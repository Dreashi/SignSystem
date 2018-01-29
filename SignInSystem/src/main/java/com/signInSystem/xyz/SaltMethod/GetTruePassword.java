package com.signInSystem.xyz.SaltMethod;

public class GetTruePassword {
    public String getTruePassword(String user_pwd,int user_id){
        char [] arr=user_pwd.toCharArray();
        String password="";
        int k=0;
        //数组的长度
        int length=user_pwd.length();
        while( length!=0  ){
            if(k<user_id) {
                password += arr[k];
                k++;
            }
            length--;
        }
        //k+10是之后的密码位置
        int t=user_pwd.length()-10-k;
        while(t--!=0){
            password+=arr[k+10];
            k++;
        }

        return password;
    }
}
