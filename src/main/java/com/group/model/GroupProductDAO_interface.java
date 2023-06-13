package com.group.model;

import java.util.List;

public interface GroupProductDAO_interface {
	public void insert(GroupProductVO GroupProductVO);
    public void update(GroupProductVO GroupProductVO);
    public void delete(Integer GroupProductVO);
    public GroupProductVO findByPrimaryKey(Integer GroupProductVO);
    public List<GroupProductVO> getAll();
}
