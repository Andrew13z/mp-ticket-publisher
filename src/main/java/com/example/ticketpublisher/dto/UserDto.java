package com.example.ticketpublisher.dto;

import java.io.Serializable;

/**
 * User DTO
 * @author Andrii Krokhta
 */
public class UserDto implements Serializable {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserDto{" +
				"id=" + id +
				'}';
	}
}
