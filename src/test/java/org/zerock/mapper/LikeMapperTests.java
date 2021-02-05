package org.zerock.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.LikeVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LikeMapperTests {
	@Setter(onMethod_ = @Autowired)
	private LikeMapper mapper;
	
	@Test
	public void testInsert() {
		LikeVO like = new LikeVO();
		like.setBno(1L);
		like.setLikeCheck(1L);
		like.setUno(20L);
		
		int before = mapper.getList().size();
		mapper.insertSelectKey(like);
		int after = mapper.getList().size();
		
		assertEquals(before+1, after);
	}

}
