package com.example.ticketpublisher.service.impl;

import com.example.ticketpublisher.controller.PublishController;
import com.example.ticketpublisher.dto.TicketDto;
import com.example.ticketpublisher.service.PublishService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublishServiceImpl implements PublishService {

	private static final Logger logger = LoggerFactory.getLogger(PublishController.class);

	private final JmsTemplate jmsTemplate;

	private final ObjectMapper mapper;

	@Autowired
	public PublishServiceImpl(JmsTemplate jmsTemplate, ObjectMapper mapper) {
		this.jmsTemplate = jmsTemplate;
		this.mapper = mapper;
	}

	@Override
	public void publishBookTicketMessage(TicketDto ticketDto) {
		String message = null;
		try {
			message = mapper.writeValueAsString(ticketDto);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Failed to write object to String", e);
		}
		logger.info("Pushing message to mp-ticket-queue. Payload: {}", message);
		jmsTemplate.convertAndSend("mp-ticket-queue", message);
	}
}
