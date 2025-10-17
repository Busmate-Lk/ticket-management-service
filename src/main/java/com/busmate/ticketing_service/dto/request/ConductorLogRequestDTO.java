package com.busmate.ticketing_service.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConductorLogRequestDTO {
    private Long conductorId;
    private Long busId;
    private Long tripId;
    private Integer numberOfPassengers;
    private String startLocationId;
    private String endLocationId;
    private Double fareAmount;
}
