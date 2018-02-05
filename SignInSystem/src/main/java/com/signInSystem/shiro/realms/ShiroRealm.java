package com.signInSystem.shiro.realms;

import java.util.Arrays;
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
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class ShiroRealm extends AuthenticatingRealm {

    @Resource
    private IUserService userService;

    @Resource
    private IPasswordService passwordService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("ShiroRealm    进入认证系统");
        UsernamePasswordToken upt= (UsernamePasswordToken) token;
        String curUserPhone=upt.getUsername();
        char [] curUserPassword1=upt.getPassword();
        //拿到原始密码
        String curUserPassword=String.valueOf(upt.getPassword());
        //加密，和原密码表中的数据进行比对
        String algorithmName="MD5";
        Object source=curUserPassword;
        Object salt=ByteSource.Util.bytes("user");
        int hashIterations=1024;
        Object afterEncryptionPwd=new SimpleHash(algorithmName, source, salt, hashIterations);
        int userId=this.userService.selectUserId(curUserPhone);
        // System.out.println("------------------>"+userId);
        //通过userid找密码
        //System.out.println(this.passwordService.selectUserPassword(userId));
        //此时passwords表中的密码
        String userPassword=this.passwordService.selectUserPassword(userId);
        System.out.println(userPassword+"---------"+curUserPhone);
        SimpleAuthenticationInfo info=null;
        if(userPassword==afterEncryptionPwd)
        {
            Object principal=curUserPhone;
            Object credentials=userPassword;
            ByteSource credentialsSalt=ByteSource.Util.bytes("user");
            info=new SimpleAuthenticationInfo(principal, credentials,credentialsSalt,"user" );
            //     info=new SimpleAuthenticationInfo(principal, credentials,credentialsSalt,realmName);
        }
        return info;
    }
    public static Object MD5Encryption(String string){
        String hashAlgorithmName="MD5";
        Object credentials=string;
        Object salt  = ByteSource.Util.bytes("user");
        int hashIterations=1024;
        Object result = new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
        return result;
    }
}
