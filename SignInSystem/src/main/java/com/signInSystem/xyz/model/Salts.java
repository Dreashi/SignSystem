package com.signInSystem.xyz.model;

import java.util.Random;

public class Salts {

        int salt_id ;
        String salt;
        int pwd_id;


        public int getSalt_id() {
            return salt_id;
        }

        public String getSalt() {
            return salt;
        }

        public int getPwd_id() {
            return pwd_id;
        }

        public void setSalt_id(int salt_id) {
            this.salt_id = salt_id;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public void setPwd_id(int pwd_id) {
            this.pwd_id = pwd_id;
        }


}
