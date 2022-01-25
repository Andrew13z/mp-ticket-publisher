package com.example.ticketpublisher.dto;

import com.example.ticketpublisher.enums.Category;

import java.io.Serializable;

/**
 * Ticket DTO
 * @author Andrii Krokhta
 */
public class TicketDto implements Serializable {

	private Long id;

	private UserDto user;

	private EventDto event;

	private Category category;

	private int place;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EventDto getEvent() {
		return event;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public void setEvent(EventDto event) {
		this.event = event;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "TicketDto{" +
				"id=" + id +
				", user=" + user.toString() +
				", event=" + event.toString() +
				", category=" + category +
				", place=" + place +
				'}';
	}
}
