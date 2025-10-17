package com.busmate.ticketing_service.controller;

import com.busmate.ticketing_service.dto.request.ConductorLogRequestDTO;
import com.busmate.ticketing_service.entity.Conductor_log;
import com.busmate.ticketing_service.service.ConductorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tickets")
@CrossOrigin
public class TicketController {

    @Autowired
    private ConductorLogService conductorLogService;

    @PostMapping
    public String createTicket(@RequestBody ConductorLogRequestDTO request) {
        return conductorLogService.issueTicket(request);
    }
}
