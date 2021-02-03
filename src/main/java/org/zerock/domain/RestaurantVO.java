package org.zerock.domain;

import lombok.Data;

@Data
public class RestaurantVO {
	private Long no;
	private Long mountain_no;
	private String rName;
	private String rLoc;
	private String contact;
	private String menu;
	private String description;
}
