package com.jhcompany.shop;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhcompany.shop.dao.IDao;

@Controller
public class TestController {
	
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="test")
	public String test() {
		
		MemberDto dto = new MemberDto("홍길동",10,"ada@aca.com");
		System.out.println(dto.getName());
		
		return "test";
	}
	@RequestMapping("insert")
	public String insert() {
		
		String id="cat";
		String pw="12345";
		String name="고양이";
		String email="cat@asa.com";
			
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.joinMemberDao(id, pw, name, email);
		return "insert";
	}
}
