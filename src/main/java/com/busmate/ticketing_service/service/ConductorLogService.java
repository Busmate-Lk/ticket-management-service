package com.busmate.ticketing_service.service;

import com.busmate.ticketing_service.dto.request.ConductorLogRequestDTO;

public interface ConductorLogService {
    String issueTicket(ConductorLogRequestDTO requestDTO);
}
