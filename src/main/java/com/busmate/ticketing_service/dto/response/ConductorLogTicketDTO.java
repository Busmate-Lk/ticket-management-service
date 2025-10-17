package com.busmate.ticketing_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConductorLogTicketDTO {
    private Long ticketId;
    private Long passengerId;
    private Long startLocationId;
    private Long endLocationId;
    private String seatNumber;
    private int passengerCount;
    private double fareAmount;
    private String paymentStatus;
    private LocalDateTime issuedAt;
}
