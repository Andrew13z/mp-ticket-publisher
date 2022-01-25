package com.example.ticketpublisher.dto;

import java.io.Serializable;

/**
 * Event DTO
 * @author Andrii Krokhta
 */
public class EventDto implements Serializable {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EventDto{" +
				"id=" + id +
				'}';
	}
}
