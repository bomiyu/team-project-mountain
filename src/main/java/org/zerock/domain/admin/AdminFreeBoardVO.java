package org.zerock.domain.admin;

import java.util.Date;

import lombok.Data;

@Data
public class AdminFreeBoardVO {
	private Long no;
	private String title;
	private String content;
	private Date regdate;
	private int member_no;
	private String user_nickname; 
}
