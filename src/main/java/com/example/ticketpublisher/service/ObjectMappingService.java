package com.example.ticketpublisher.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ObjectMappingService {

  private static final Logger logger = LoggerFactory.getLogger(ObjectMappingService.class);

  private final ObjectMapper mapper;

  @Autowired
  public ObjectMappingService(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  public Optional<String> toJson(final Object object) {
    try {
      return Optional.of(mapper.writeValueAsString(object));
    } catch (JsonProcessingException e) {
      logger.error("Failed to write object to String: {}", e.getMessage(), e);
      return Optional.empty();
    }
  }
}
