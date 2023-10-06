package com.myweb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.dao.MemberDAO;
import com.myweb.dto.MemberDTO;
import com.myweb.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService{
	
	@Autowired
	MemberDAO dao;

	@Override
	public List<MemberDTO> getMemberList() {
		
		return dao.getMemberList();
	}

	@Override
	public MemberDTO getMember(MemberDTO dto) {
		
		return dao.getMember(dto);
	}

	@Override
	public int insert(MemberDTO dto) {
		
		return dao.insert(dto);
	}

	@Override
	public int update(MemberDTO dto) {
		
		return dao.update(dto);
	}

	@Override
	public int delete(MemberDTO dto) {
		
		return dao.delete(dto);
	}

	@Override
	public List<MemberDTO> getMemberSearchNameList(MemberDTO dto) {
		
		return dao.getMemberSearchNameList(dto);
	}

}
