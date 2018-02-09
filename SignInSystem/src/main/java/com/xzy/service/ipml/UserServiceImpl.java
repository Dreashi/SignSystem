package com.xzy.service.ipml;

import com.shiro.realms.ShiroRealm;
import com.xzy.dao.IUserDao;
import com.xzy.model.Register;
import com.xzy.model.Users;
import com.xzy.service.IGroupService;
import com.xzy.service.IUserService;
import com.xzy.service.email.MyEailUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IGroupService groupService;
    @Resource
    private IUserDao userDao;
    @Override
    public Users selectUser(String userPhone){
        Users user = null;
        try {
            user=this.userDao.selectUser(userPhone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public void insertUser(Users user){
        try {
            this.userDao.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer selectUserId(String userPhone) {
        Integer id=0;
        try {
           id= this.userDao.selectUserId(userPhone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    @Override
    public boolean doRegister(Register register){
        boolean bool=false;
        try {
            String string =  register.getUserPassword();
            Object result = ShiroRealm.MD5Encryption(string);
            System.out.println("---------------------------->"+result);
            userDao.insertRegister(register);
            //发送邮件
            MyEailUtil.sendEmail(register.getUserEmail(),register.getUserName(),"新卓越","请点击认证");
            bool=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }

    @Override
    public void insertRegister(Register register) {

    }

    @Override
    public int selectRegisterPhone(String userPhone) {
        int i = 0 ;
        try {
            i= this.userDao.selectRegisterPhone(userPhone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int selectRegisterEmail(String useremail) {
        int i=0;
        try {
            i= this.userDao.selectRegisterEmail(useremail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }


    @Override
    public Users selectUserByUserId(int userId) {
        return  this.userDao.selectUserByUserId(userId);
    }


    @Override
    public Users loadUserPhone(String userPhone) {
        Users usersP = userDao.loadUserPhone(userPhone);
        return usersP;
    }

    @Override
    public boolean updateUsersGroupId(String userPhone, int groupLeaderId, String userName) throws Exception {
        Integer userId = userDao.selectUserId(userPhone);
        Integer groupId = userDao.selectGroupId(groupLeaderId);
        if (userId==null || groupId ==null){
            return false;
        }
        Integer res = userDao.updateGroupIdAddUsers(groupId,userId,userName);
        System.out.println(res);
        return res > 0 ? true : false;
    }

    @Override
    public List<Users> selectUsers(int groupId) {
        List<Users> userList=userDao.selectUsers(groupId);
        int gLeaderId = groupService.selectGroupLeaderId(groupId).getGroupLeaderId();
        Users gLeader=null;
        Iterator<Users> userIteratro=null;
        if (userList!=null) {
            userIteratro = userList.iterator();
        }
        if(gLeaderId!=0){
            while(userIteratro.hasNext()){
                Users user =userIteratro.next();
                if(user.getUserId() == gLeaderId) {
                    gLeader=user;
                    userIteratro.remove();
                }
            }
            userList.add(0,gLeader);
        }
        return userList;
    }
    @Override
    public boolean updateUsersGroupId(int[] userId) {
        int res=userDao.updateGroupIdDeleteUsers(userId);
        return res > 0? true : false;
    }


}
