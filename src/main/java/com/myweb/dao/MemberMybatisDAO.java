package com.myweb.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweb.dto.MemberDTO;

@Repository
public class MemberMybatisDAO {

	// Mybtis
	@Autowired
	SqlSession sqlSession;

	public List<MemberDTO> getMemberList() {
		
		return sqlSession.selectList("memberxml.getMemberList");
	} // End	

	public MemberDTO getMember(MemberDTO dto) {
		
		return sqlSession.selectOne("memberxml.getMember",dto);
	} // End

	public int insert(MemberDTO dto) {
		
		return sqlSession.insert("memberxml.insert",dto);
	} // End

	public int update(MemberDTO dto) {
		
		return sqlSession.update("memberxml.update",dto);
	}

	public int delete(MemberDTO dto) {
		
		return sqlSession.update("membermapper.delete",dto);
	}

	public List<MemberDTO> getMemberSearchNameList(MemberDTO dto) {
		
		return sqlSession.selectList("memberxml.getMemberSearchNameList");
	} // End
	
	public List<MemberDTO> getMemberCount() {
		
		return sqlSession.selectList("memberxml.getMemberList");
	} // End
	
	public List<MemberDTO> getMemberListPasing() {
		
		return sqlSession.selectList("memberxml.getMemberList");
	} // End
	
	
}
