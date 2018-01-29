package com.xyz.dao;



import com.xyz.model.Group;

import java.util.List;

public interface IGroupDao {
 public List<Group> loadAll();
 public List<Integer> loadAllLeaderId();
}
