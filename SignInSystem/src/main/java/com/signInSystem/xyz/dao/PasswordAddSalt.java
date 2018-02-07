package com.signInSystem.xyz.dao;
import java.util.Random;


public class PasswordAddSalt {

    public String getSalt(String user_password) {
        Random random=new Random();
        Object [] obj=new Object[10];
        int [] arr=new int[200];
        for (int i = 32,j=0; i < 123; i++,j++) {
            arr[j]=i;
        }
//    for (int j = 0; j < 91; j++) {
//      System.out.println((char)arr[j]+" ");
//    }
        //加盐
        String str="";
        for (int i = 0; i < 10; i++) {
            obj[i]=(char)(32+random.nextInt(90));
            str+=obj[i];
        }
        //加盐一共十一位，最后一个是分隔符
        return  user_password+str+"~";
    }
}




