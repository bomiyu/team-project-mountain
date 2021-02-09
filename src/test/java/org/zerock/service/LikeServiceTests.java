package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.LikeVO;
import org.zerock.mapper.LikeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LikeServiceTests {
	@Setter(onMethod_ = @Autowired)
	private LikeMapper mapper;
	@Setter(onMethod_ = @Autowired)
	private LikeService service;

	@Test
	public void test() {
		assertNotNull(service);
	}
	
	@Test
	public void testInsertLike() {
		LikeVO like = new LikeVO();
		like.setResno(new Long(109));
		like.setUserno(new Long(2));
		
		int before = mapper.getCount(like.getResno());
		log.info("************************ before : " + before);
		service.likeInsert(like);
		int after = mapper.getCount(like.getResno());
		log.info("************************ after : " + after);
		

		assertEquals(before+1, after);
	}
}
