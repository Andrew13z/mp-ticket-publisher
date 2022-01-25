package com.example.ticketpublisher.controller;

import com.example.ticketpublisher.dto.TicketDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

	private static final Logger logger = LoggerFactory.getLogger(PublishController.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private ObjectMapper mapper;

	@PostMapping("/publishMessage")
	public ResponseEntity<String> publishMessage(@RequestBody TicketDto ticketDto) throws JsonProcessingException {
		var message = mapper.writeValueAsString(ticketDto);
		logger.info("Pushing message to mp-ticket-queue. Payload: {}", message);
		jmsTemplate.convertAndSend("mp-ticket-queue", message);
		return new ResponseEntity<>("Sent", HttpStatus.OK);
	}
}
