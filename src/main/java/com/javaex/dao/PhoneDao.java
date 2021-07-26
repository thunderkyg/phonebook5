package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//Insert2
	public int personInsert2(String name, String hp, String company) {

		//map을 사용해서 데이터를 묶는다
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		
		int count = sqlSession.insert("phonebook.personInsert2", personMap);
		
		return count;
	}
	
	//getPerson
	public PersonVo getPerson(int no) {
		
		PersonVo personVo = sqlSession.selectOne("phonebook.getPerson", no);
		
		return personVo;
	}
	
	//getPerson2
	public Map<String, Object> getPerson2(int personId) {

		System.out.println("[DAO, getPerson2]");
		//map을 사용해서 데이터를 묶는다
		Map<String, Object> personMap = sqlSession.selectOne("phonebook.getPerson2", personId);
		System.out.println(personMap);
		System.out.println(personMap.get("PERSON_ID"));
		
		return personMap;
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
