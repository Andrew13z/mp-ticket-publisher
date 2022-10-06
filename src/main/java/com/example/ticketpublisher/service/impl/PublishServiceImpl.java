package com.example.ticketpublisher.service.impl;

import com.example.ticketpublisher.controller.PublishController;
import com.example.ticketpublisher.dto.TicketDto;
import com.example.ticketpublisher.service.ObjectMappingService;
import com.example.ticketpublisher.service.PublishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublishServiceImpl implements PublishService {

  private static final Logger logger = LoggerFactory.getLogger(PublishController.class);

  private final JmsTemplate jmsTemplate;

  private final ObjectMappingService mappingService;

  @Autowired
  public PublishServiceImpl(JmsTemplate jmsTemplate, ObjectMappingService mappingService) {
    this.jmsTemplate = jmsTemplate;
    this.mappingService = mappingService;
  }

  @Override
  public void publishBookTicketMessage(TicketDto ticketDto) {
    mappingService.toJson(ticketDto).stream()
      .peek(message -> logger.info("Pushing message to mp-ticket-queue. Payload: {}", message))
      .forEach(message -> jmsTemplate.convertAndSend("mp-ticket-queue", message));
  }
}
