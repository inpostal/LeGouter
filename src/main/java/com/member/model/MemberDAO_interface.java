package com.member.model;

import java.util.List;

public interface MemberDAO_interface {
	void insert(MemberVO memberVO);
	void update(MemberVO memberVO);
	void delete(Integer memberID);
	MemberVO findByPrimaryKey(Integer memberID);
	List<MemberVO> getAll();
}
