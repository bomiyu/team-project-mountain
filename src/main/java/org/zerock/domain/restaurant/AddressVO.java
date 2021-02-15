package org.zerock.domain.restaurant;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.Getter;

@Data
public class AddressVO {
	@NotEmpty(message="주소를 입력해주세요.")
	private String address1;
	private String address2;

}
