## 建表语句
CREATE TABLE Adminitor(

  admin_id  INT AUTO_INCREMENT,
  
  admin_name VARCHAR(20),
  
  user_id INT,
  
  admin_phone INT,
  
  PRIMARY KEY(admin_id)
  
  )CHARSET=utf8;
  
CREATE TABLE Groups(

  groups_id INT AUTO_INCREMENT,
  
  groups_name VARCHAR(20),
  
  groups_direct VARCHAR(50),
  
  gl_id INT,
  
  PRIMARY KEY(groups_id )
  
)CHARSET=utf8;


## groups:

select user_id from users where user_phone=?;

update users s set s.group_id = (select groups_id from groups where gl_id=?) where user_id=?;

update users s join groups g set s.group_id=0 where where s.group_id=g.groups_id

update groups g set gl_id=? where groups_id =?

## adminitor:

update groups_id  set gl_id=?  




 