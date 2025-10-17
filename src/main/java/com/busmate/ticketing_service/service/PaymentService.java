package com.busmate.ticketing_service.service;

import com.busmate.ticketing_service.dto.request.PaymentRequestDTO;
import com.busmate.ticketing_service.dto.response.ConductorLogTicketDTO;

import java.util.List;

public interface PaymentService {
    String issueTicket(PaymentRequestDTO requestDTO);

    List<ConductorLogTicketDTO> getConductorLogDetails(Long conductorId);

    List<ConductorLogTicketDTO> getTicketDetailsByBusId(Long busId);
}
