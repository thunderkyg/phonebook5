package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//List 가져오기
	public List<PersonVo> getPersonList(){
		
		//db 요청
		//리스트 가져오기
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");
		
		return personList;
	}
	
	//Insert
	public int personInsert(PersonVo personVo) {
		
		int count = sqlSession.insert("phonebook.personInsert", personVo);
		
		return count;
	}
	
	//getPerson
	public PersonVo getPerson(int no) {
		
		PersonVo personVo = sqlSession.selectOne("phonebook.getPerson", no);
		
		return personVo;
	}
	
	//Delete
	public int personDelete(int no) {
		
		int count = sqlSession.delete("phonebook.personDelete", no);
		
		return count;
	}
	
	//Update
	public int personUpdate(PersonVo personVo) {
		
		int count = sqlSession.update("phonebook.personUpdate", personVo);
		
		return count;
	}

	

}
