package com.myweb.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.dto.MemberDTO;

@Mapper
public interface MemberMapper {	

	public List<MemberDTO> getMemberList();	

	public MemberDTO getMember(MemberDTO dto);

	public int insert(MemberDTO dto);

	public int update(MemberDTO dto);

	public int delete(MemberDTO dto);

	public List<MemberDTO> getMemberSearchNameList(MemberDTO dto);
	
	public List<MemberDTO> getMemberCount(); 
	
	public List<MemberDTO> getMemberListPasing(); 
	
	
}
