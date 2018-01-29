package com.xyz.service;

import com.xyz.model.Group;
import com.xyz.service.ipml.GroupService;

import java.util.List;

public interface IGroupService {
    public List<Group> loadAll();
    public List<Integer> loadAllLeaderId();
}
