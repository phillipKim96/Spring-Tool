package com.board;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest // 스프링 부트에서 지원하는 단위 선언
class BoardApplicationTests {

	@Autowired
	private ApplicationContext context; // DB에서 받는 객체를 잘 받았는지
	
	@Autowired
	private SqlSessionFactory sessionFactory; // session이 잘 돌아가는지
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testByApplicationContext() {
		try {
			System.out.println("==============================");
			System.out.println(context.getBean("sqlSessionFactory"));
			System.out.println("==============================");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBySqlSessionFactory() {
		try {
			System.out.println("==============================");
			System.out.println(sessionFactory.toString());
			System.out.println("==============================");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}