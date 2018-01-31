package com.signInSystem.shiro.realms;

import java.util.HashSet;
import java.util.Set;

import com.signInSystem.xyz.model.Users;
import com.signInSystem.xyz.service.IPasswordService;
import com.signInSystem.xyz.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class ShiroRealm extends AuthorizingRealm{
    @Resource
    private IUserService userService;

    @Resource
    private IPasswordService passwordService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("[ShiroRealm]   doGetAuthenticationInfo");
        // TODO Auto-generated method stub
        //System.out.println("doGetAuthenticationInfo"+token.hashCode());
        //1.把AuthenticationToken转化成UsernamePasswordToken
        UsernamePasswordToken upt=(UsernamePasswordToken) token;
        //2.从UsernamePasswordToken 中获取userName
        String userPhone=upt.getUsername();
        Users user=this.userService.selectUser(userPhone);
        // System.out.println("----------------->"+user);

        int userId=this.userService.selectUserId(userPhone);
        //取到的是数据库中储存的密码
        String userPwd=this.passwordService.selectUserPassword(userId);
        // System.out.println("------------------>"+userId);

        System.out.println(userPhone+"---------"+userPwd);


        String userPassword=upt.getPassword().toString();
        //3.调用数据库的方法，从数据库中 查询userName 对应的用户记录
        System.out.println("从数据库中获取"+userPhone+"---------------"+ userPassword +"所对应 的用户信息。");
        //6.根据用户的情况来构建 AuthenticationInfo的对象并返回，通常使用的实现类是

        //以下信息是从数据库中获取的
        //principal ：认证的实体信息	  可以是userName也可以是数据表对应的用户的实体类对象
        Object principal=userPhone;
        //credentials:密码        //经md5加密1024 后的密码值
        Object credentials=null;

        if("admin".equals(userPhone)){
            credentials="038bdaf98f2037b31f1e75b5b4c9b26e";
        }else if("user".equals(userPhone)){
            credentials="098d2c478e9c11555ce2823231e02ec1";
        }

        //realmName:当前对象的name调用父类的getName方法
        String realmName=getName();
        //盐值：
        ByteSource credentialsSalt=ByteSource.Util.bytes(userPhone);




        //SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal, credentials, realmName);
        SimpleAuthenticationInfo info=null;
        info=new SimpleAuthenticationInfo(principal, credentials,credentialsSalt,realmName );



        return info;
    }

    public static void main(String[] args) {
        String algorithmName="MD5";
        Object source="123456";
        Object salt=ByteSource.Util.bytes("user");
        int hashIterations=1024;

        Object result=new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(result);
    }
    //授权会被shiro回调的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //System.out.println("AuthorizingRealm!");
        //1.从PrincipalCollection获取登录信息
        //获取Realm信息时按配置顺序读取

        //记住顺序！！！！！！！！！！！
        Object principal=principals.getPrimaryPrincipal();

        //2.利用登录用户的信息来获取当前用户的角色和权限(可能需要查询数据库)

        Set<String> roles=new HashSet<String>();
        roles.add("user");
        if("admin".equals(principal)){
            //admin可以访问两个页面！！！！！！！！！！
            roles.add("admin");
        }
        //3.创建SimpleAuthorizationInfo接口，并设置roles属性

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo(roles);
        //4.返回对象
        return info;
    }
}
