package com.signInSystem.xyz.dao;

import com.signInSystem.xyz.SaltMethod.GetTruePassword;
import com.signInSystem.xyz.SaltMethod.PasswordAddSalt;
import org.junit.Test;

public class SaltTest {
    @Test
    public void func(){
        PasswordAddSalt passwordAddSalt=new PasswordAddSalt();
       String passwords= passwordAddSalt.getSalt("dssas",3);
        System.out.println("------------------------->"+passwords);
        GetTruePassword getTruePassword=new GetTruePassword();
       String password= getTruePassword.getTruePassword(passwords,3);
        System.out.println("------------------------->"+password);
    }
}
