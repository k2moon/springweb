package com.myweb.service;

import java.util.List;

import com.myweb.dto.MemberDTO;

public interface IMemberService {

	List<MemberDTO> getMemberList();
	MemberDTO getMember(MemberDTO dto);
	int insert(MemberDTO dto);
	int update(MemberDTO dto);
	int delete(MemberDTO dto);
	List<MemberDTO> getMemberSearchNameList(MemberDTO dto);

}
