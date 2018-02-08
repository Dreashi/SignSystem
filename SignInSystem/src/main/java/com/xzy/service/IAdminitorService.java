package com.xzy.service;

import com.xzy.model.Adminitor;

import java.util.List;

public interface IAdminitorService {
    public boolean loadByUserId(int userId);
    public List<Adminitor> loadAllAdminitor();
}
