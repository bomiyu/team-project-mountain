package org.zerock.domain.restaurant;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.Getter;

@Data
public class AddressVO {
	private String address1;
	private String address2;

}
