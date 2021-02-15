package org.zerock.domain.restaurant;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class RestaurantVO {
	private Long no;
	private Long mountain_no;
	@NotEmpty(message="상호를 입력해주세요.")
	private String rname;
	private String rloc;
	@NotEmpty(message="연락처를 입력해주세요.")
	private String contact;
	@NotEmpty(message="메뉴를 입력해주세요.")
	private String menu;
	@NotEmpty(message="설명을 입력해주세요.")
	private String description;
	private String img;
	private String mname;
	private Long likecnt;
	private Long dislikecnt;

}
