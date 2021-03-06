package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.admin.Acriteria;
import org.zerock.domain.admin.AdminMemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminMemberMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private AdminMemberMapper mapper;
	
	@Test
	public void test() {
		assertNotNull(mapper);
	}
	
	@Test
	public void getMemgerList() {
		Acriteria cri = new Acriteria(1, 5);
		List<AdminMemberVO> list = mapper.getMemberListPaging(cri);
		
		assertEquals(5, list.size());
	}
	
	@Test
	public void getMemger() {
		AdminMemberVO vo = mapper.getMember(307L);
		
		assertNotNull(vo);
	}
}
