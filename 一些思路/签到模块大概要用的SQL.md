
 
 - ### 签到表

```
CREATE TABLE sign_In(
	user_id INT,
	sign_date DATE,
	sign_time TIME,
	sign_status ENUM('已签到','迟签到','未签到'),
	user_name VARCHAR(20),
	PRIMARY KEY(user_id,sign_date)
);
```

- ### 题库
```
CREATE TABLE Questions(
  questions_id INT AUTO_INCREMENT,
  questions_content VARCHAR(50),
  questions_answer VARCHAR(20),
  PRIMARY KEY(questions_id)
);
```
- ### 创建索引

```
CREATE INDEX date_index ON Sign_In(sign_date);
```

##### 由于实际业务中有显示自己所有签到记录和当天所有人记录两种需求，所以必然要根据user_id和sign_date去查询两次表，又因为id和date为复合主键并且索引有最左前缀原则，所以id可以从（id，date）中脱离出来单独作为索引，但data不行所以要给date加上索引.


- ### 创建一个只能改变status列的用户


```
GRANT SELECT,UPDATE(sign_status) ON xzy.Sign_In TO 'SignInAdmin'@'localhost' IDENTIFIED BY 'newpassword'
```

##### 创建user并赋权限，将来也可以根据业务修改 ``` 'SignInAdmin'@'localhost' ``` 参数将该权限给全局管理员

- ### 查询签到状态

#### 根据id查本人所有签到


```
SELECT sign_date,sign_time,sign_status,user_name 
    FROM Sign_In
        WHERE user_id = #{userId}
```

#### 查当天所有签到信息


```
SELECT sign_time,sign_status,user_name 
    FROM Sign_In
        WHERE sign_date = #{signDate}
```
##### 这里已经知道signDate就没必要再查日期了，而且索引的使用是根据where里的条件优化，所以不select sign_date这一列不影响索引的使用

- ### * Mysql event 
参考博客： [http://blog.csdn.net/lixia755324/article/details/53923856](http://blog.csdn.net/lixia755324/article/details/53923856)

##### 由于可能存在未签到这种情况，也就意味我们需要每天定时给没有签到的人插入一条未签到元组，这就要用到Mysql event来创建一个事件

先查看Mysql是否开启定时器。

```
SHOW VARIABLES LIKE '%sche%';
```
如果参数event_scheduler为OFF或0则修改为1
```
SET GLOBAL event_scheduler = 1;
```

接下来创建一个event事件。

```
CREATE EVENT
insert_into_sign_in_everyDay
ON SCHEDULE EVERY 1 DAY STARTS CONCAT(DATE_ADD(CURDATE(),INTERVAL 1 DAY),' 09:00:00')
DISABLE
COMMENT'每天自动为未签到用户添加一条未签到元组'
DO CALL insert_day();
```
EVABLE开启事件时，``` CONCAT(DATE_ADD(CURDATE(),INTERVAL 1 DAY),'09:00:00')```获取第二天早上九点的时间作为起点，之后每一天```  EVERY 1 DAY，``` 调用 insert_day()这个存储过程给未签到用户添加一条未签到元组

### insert_day()存储过程:


```
DELIMITER $$
CREATE PROCEDURE insert_day()
BEGIN
	DECLARE user_id INT ;
	DECLARE user_name VARCHAR(15);
	DECLARE cur_date DATE DEFAULT CURDATE();
	DECLARE index_users CURSOR FOR SELECT user_id,user_name FROM Users;
	DECLARE EXIT HANDLER FOR NOT FOUND CLOSE index_users;
	
	OPEN index_users;
	
	REPEAT
	  FETCH index_users INTO user_id,user_name;
	  IF user_id NOT IN (SELECT user_id FROM Sign_In WHERE sign_date=cur_date) THEN
	     INSERT INTO Sign_In VALUES (user_id,cur_date,'未签到',user_name);
	  END IF;
	UNTIL 0 END REPEAT;
	
	CLOSE index_users;
END ;
$$
DELIMITER ;
```
#### 大致思路是通过光标遍历User表中的所有id，然后根据CURDATE()即当天时间去Sign_In表中查今天出现了的id(即签到过),如果当天该id还没有在该结果集中出现则说明该id未签到需要为其插入一条元组

- ### 可能会用到的sql

只显示当天 本组内所有组员的签到状态 需要两个参数 userId 和 signDate


```
SELECT sign_time,sign_status,user_name  FROM Sign_In
    WHERE sign_date = '2018-01-26'
    AND user_id IN ( SELECT user_id FROM Users 
        WHERE group_id = (SELECT group_id FROM Users 
            WHERE user_id = #{userId} ))
```

获取题库中随机一道题


```
SELECT * FROM Questions WHERE question_id >= ((SELECT MAX(question_id) FROM Questions)-(SELECT MIN(question_id) FROM Questions)) * RAND() + (SELECT MIN(question_id) FROM Questions) LIMIT 1
```

