package com.careerit.cbook.domain;



import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Contact {
	@Id
	private String cid;
	private String name;
	private String email;
	private String mobile;
	private String city;
}
