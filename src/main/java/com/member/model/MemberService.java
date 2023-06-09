package com.member.model;

import java.util.List;

public class MemberService {
	IMemberDAO memberDAO;

	public MemberService() {
		memberDAO = new MemberDAO();
	}

	public MemberVO findByPk(Integer id) {
		return memberDAO.findByPrimaryKey(id);
	}
	
	public void register(MemberVO newMemberVO) {
		memberDAO.insert(newMemberVO);
	}

	public boolean isAcciuntAllow(MemberVO newMemberVO) {
		List<MemberVO> list = memberDAO.getAll();
		for (MemberVO memberVO : list) {
			if (memberVO.getMemberAccount().equals(newMemberVO.getMemberAccount())) {
				return false;
			}
		}
		return true;
	}

	public boolean isMailAllow(MemberVO newMemberVO) {
		List<MemberVO> list = memberDAO.getAll();
		for (MemberVO memberVO : list) {
			if (memberVO.getMemberEmail().equals(newMemberVO.getMemberEmail())) {
				return false;
			}
		}
		return true;
	}

	public Integer login(String username, String password) {
		List<MemberVO> list = memberDAO.getAll();
		for (MemberVO memberVO : list) {
			if (username.equals(memberVO.getMemberAccount()) && password.equals(memberVO.getMemberPassword())) {
				return memberVO.getMemberId();
			}
		}
		return null;
	}

	public void editMemberData(MemberVO inputMemberData) {
		MemberVO oldMemberVO = memberDAO.findByPrimaryKey(inputMemberData.getMemberId());
		
		oldMemberVO.setMemberName(inputMemberData.getMemberName());
		oldMemberVO.setMemberPassword(inputMemberData.getMemberPassword());
		oldMemberVO.setMemberGender(inputMemberData.getMemberGender());
		oldMemberVO.setMemberPhone(inputMemberData.getMemberPhone());
		oldMemberVO.setMemberAddress(inputMemberData.getMemberAddress());
		
		memberDAO.update(oldMemberVO);
	}
}
