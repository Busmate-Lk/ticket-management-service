package com.busmate.ticketing_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tickets")
public class Tickets {
    public enum IssueMethod { CONDUCTOR, ONLINE }
    public enum Status { ISSUED, CANCELLED, USED }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "bus_id", nullable = false)
    private Long busId;

    @Column(name = "trip_id", nullable = false)
    private Long tripId;

    @Column(name = "conductor_id")
    private Long conductorId;

    @Column(name = "passenger_id")
    private Long passengerId;

    @Column(name = "seat_number", length = 10)
    private String seatNumber;

    @Column(name = "number_of_passengers", nullable = false)
    private Integer numberOfPassengers;

    private String EndLocationId;
    private String StartLocationId;

    @Column(name = "fare_amount", nullable = false, precision = 10, scale = 2)
    private Double fareAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "issue_method", nullable = false)
    private IssueMethod issueMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.ISSUED;

    @Column(name = "issued_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime issuedAt;
}
