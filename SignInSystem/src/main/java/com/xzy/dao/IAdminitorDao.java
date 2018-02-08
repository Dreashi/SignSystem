package com.xzy.dao;

import com.xzy.model.Adminitor;

import java.util.List;

public interface IAdminitorDao {
    public Adminitor loadByUserId(int userId);
    public List<Adminitor> loadAllAdminitor();
}
