package com.busmate.ticketing_service.service.impl;

import com.busmate.ticketing_service.dto.request.ConductorLogRequestDTO;
import com.busmate.ticketing_service.entity.Conductor_log;
import com.busmate.ticketing_service.entity.Tickets;
import com.busmate.ticketing_service.repository.ConductorLogRepo;
import com.busmate.ticketing_service.repository.TicketRepo;
import com.busmate.ticketing_service.service.ConductorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.busmate.ticketing_service.entity.Conductor_log.Action.ISSUED;
import static com.busmate.ticketing_service.entity.Tickets.IssueMethod.CONDUCTOR;

@Service
public class ConductorLogServiceIMPL implements ConductorLogService {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private ConductorLogRepo conductorLogRepo;

    @Override
    @Transactional
    public String issueTicket(ConductorLogRequestDTO requestDTO) {
        Tickets ticket = new Tickets();
        ticket.setConductorId(requestDTO.getConductorId());
        ticket.setBusId(requestDTO.getBusId());
        ticket.setTripId(requestDTO.getTripId());
        ticket.setNumberOfPassengers(requestDTO.getNumberOfPassengers());
        ticket.setStartLocationId(requestDTO.getStartLocationId());
        ticket.setEndLocationId(requestDTO.getEndLocationId());
        ticket.setFareAmount(requestDTO.getFareAmount());
        ticket.setIssueMethod(CONDUCTOR);

        ticketRepo.save(ticket);

        Conductor_log conductorLog = new Conductor_log();
        conductorLog.setConductorId(requestDTO.getConductorId());
        conductorLog.setAction(ISSUED);

        conductorLogRepo.save(conductorLog);

        return "Ticket issued successfully";
    }
}
