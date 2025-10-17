package com.busmate.ticketing_service.controller;

import com.busmate.ticketing_service.dto.request.PaymentRequestDTO;
import com.busmate.ticketing_service.dto.response.ConductorLogTicketDTO;
import com.busmate.ticketing_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin
public class TicketController {

    @Autowired
    private PaymentService conductorLogService;

    @PostMapping("/conductor/issue")
    public String createTicket(@RequestBody PaymentRequestDTO request) {
        return conductorLogService.issueTicket(request);
    }

    @GetMapping("/conductor/{conductorId}/logs")
    public List<ConductorLogTicketDTO> getConductorLogs(@PathVariable Long conductorId) {
        return conductorLogService.getConductorLogDetails(conductorId);
    }



}
