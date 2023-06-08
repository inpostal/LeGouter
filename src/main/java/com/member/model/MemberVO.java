package com.member.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
	private Integer memberStatus;
	private Date memberRegistrationTime;
}
