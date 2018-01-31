package com.signInSystem.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class SecondRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("[SecondRealm]   doGetAuthenticationInfo");
        // TODO Auto-generated method stub
        //System.out.println("doGetAuthenticationInfo"+token.hashCode());
        //1.把AuthenticationToken转化成UsernamePasswordToken
        UsernamePasswordToken upt=(UsernamePasswordToken) token;
        //2.从UsernamePasswordToken 中获取userName,userPhone
        String userName=upt.getUsername();
        //3.调用数据库的方法，从数据库中 查询userName 对应的用户记录
        System.out.println("从数据库中获取"+userName+"所对应 的用户信息。");
        //4.若用户不存在，则可以抛出异常AuthenticationException的子类UnknownAccountException异常
        if("unknown".equals(userName))
        {
            throw new UnknownAccountException("用户不存在");
        }
        //5.根据用户信息的情况决定是否需要抛出其他的异常---用户锁定
        if("monster".equals(userName)){
            throw new LockedAccountException("用户被锁定");
        }
        //6.根据用户的情况来构建 AuthenticationInfo的对象并返回，通常使用的实现类是

        //以下信息是从数据库中获取的
        //principal ：认证的实体信息	  可以是userName也可以是数据表对应的用户的实体类对象
        Object principal=userName;
        //credentials:密码        //经md5加密1024 后的密码值
        Object credentials=null;

        if("admin".equals(userName)){
            credentials="ce2f6417c7e1d32c1d81a797ee0b499f87c5de06";
        }else if("user".equals(userName)){
            credentials="073d4c3ae812935f23cb3f2a71943f49e082a718";
        }

        //realmName:当前对象的name调用父类的getName方法
        String realmName=getName();
        //盐值：
        ByteSource credentialsSalt=ByteSource.Util.bytes(userName);




        //SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal, credentials, realmName);
        SimpleAuthenticationInfo info=null;
        info=new SimpleAuthenticationInfo(principal, credentials,credentialsSalt,realmName );



        return info;
    }

    public static void main(String[] args) {
        String algorithmName="SHA1";
        Object source="123456";
        Object salt=ByteSource.Util.bytes("admin");
        int hashIterations=1024;

        Object result=new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(result);
    }
}
