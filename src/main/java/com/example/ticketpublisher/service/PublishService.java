package com.example.ticketpublisher.service;

import com.example.ticketpublisher.dto.TicketDto;

public interface PublishService {

	void publishBookTicketMessage(TicketDto ticketDto);
}
