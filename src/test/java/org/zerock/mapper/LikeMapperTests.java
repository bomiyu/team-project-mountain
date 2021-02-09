package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	@Setter(onMethod_ = @Autowired)
	private RestaurantMapper resMapper;
	//성공
	@Test
	public void testExist() {
		assertNotNull(mapper);
	}
	//성공
	@Test
	public void testInsert() {
		LikeVO like = new LikeVO();
		like.setResno(new Long(109));
		like.setUserno(new Long(2));
		
		int before = mapper.getCount(new Long(109));
		log.info("************************ before : " + before);
		mapper.insertLike(like);
		int after = mapper.getCount(new Long(109));
		log.info("************************ after : " + after);
		

		assertEquals(before+1, after);
	}
	
	@Test
	public void testGetLike() {
		LikeVO like = new LikeVO();
		like.setResno(new Long(109));
		like.setUserno(new Long(3));
		int val = mapper.getLike(like.getResno(), like.getUserno());
		log.info("************************ val : " + val);

	}
	
	@Test
	public void testDelete() {
		LikeVO like = new LikeVO();
		like.setResno(new Long(109));
		like.setUserno(new Long(3));
		mapper.insertLike(like);
		int before = mapper.getCount(like.getResno());
		log.info("************************ before : " + before);
		log.info("************************ like.getResno() : " + like.getResno());
		log.info("************************ like.getUserno() : " + like.getUserno());
		int cnt = mapper.likeDelete(like.getResno(), like.getUserno());
		int after = mapper.getCount(like.getResno());
		log.info("************************ after : " + after);
		
		assertEquals(cnt, 1);
		assertEquals(before+1, after);
	}
	
	@Test
	public void testUpdate() {
		LikeVO like = new LikeVO();
		like.setResno(new Long(109));
		like.setUserno(new Long(3));
		mapper.insertLike(like);
		
		mapper.likeUpdate(like.getResno());
		resMapper.read(like.getResno());
	}
}
