package com.example.ticketpublisher.controller;

import com.example.ticketpublisher.dto.TicketDto;
import com.example.ticketpublisher.service.PublishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

	private static final Logger logger = LoggerFactory.getLogger(PublishController.class);

	private final PublishService publishService;

	public PublishController(PublishService publishService) {
		this.publishService = publishService;
	}

	@PostMapping("/publishMessage")
	public ResponseEntity<Void> publishMessage(@RequestBody TicketDto ticketDto) {
		publishService.publishBookTicketMessage(ticketDto);
		return ResponseEntity.accepted().build();
	}
}
