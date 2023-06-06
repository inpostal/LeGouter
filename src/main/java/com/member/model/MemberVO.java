package com.member.model;

import java.sql.Date;

public class MemberVO {
	private Integer memberId;
	private Integer memberClassify;
	private String memberName;
	private String memberAccount;
	private String memberPassword;
	private Character memberGender;
	private String memberPhone;
	private String memberEmail;
	private String memberAddress;
	private Date memberBirthday;
	private int memberStatus;
	private Date memberRegistrationTime;

	public MemberVO() {
		super();
	}

	public MemberVO(Integer memberId, Integer memberClassify, String memberName, String memberAccount,
			String memberPassword, Character memberGender, String memberPhone, String memberEmail, String memberAddress,
			Date memberBirthday, int memberStatus, Date memberRegistrationTime) {
		super();
		this.memberId = memberId;
		this.memberClassify = memberClassify;
		this.memberName = memberName;
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
		this.memberGender = memberGender;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
		this.memberBirthday = memberBirthday;
		this.memberStatus = memberStatus;
		this.memberRegistrationTime = memberRegistrationTime;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getMemberClassify() {
		return memberClassify;
	}

	public void setMemberClassify(Integer memberClassify) {
		this.memberClassify = memberClassify;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public Character getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(Character memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public Date getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(Date memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public int getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(int memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Date getMemberRegistrationTime() {
		return memberRegistrationTime;
	}

	public void setMemberRegistrationTime(Date memberRegistrationTime) {
		this.memberRegistrationTime = memberRegistrationTime;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberClassify=" + memberClassify + ", memberName=" + memberName
				+ ", memberAccount=" + memberAccount + ", memberPassword=" + memberPassword + ", memberGender="
				+ memberGender + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberAddress="
				+ memberAddress + ", memberBirthday=" + memberBirthday + ", memberStatus=" + memberStatus
				+ ", memberRegistrationTime=" + memberRegistrationTime + "]";
	}

}
