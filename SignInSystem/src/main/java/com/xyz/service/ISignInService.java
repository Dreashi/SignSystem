package com.xyz.service;

import com.xyz.model.SignIn;

import java.util.Date;
import java.util.List;

public interface ISignInService {
    public List<SignIn> select(int userId);
    public List<SignIn> select(String signInDate);
    public List<SignIn> select(String signInDate,int userId);
    boolean insert(int userId,String signInTime);
}
