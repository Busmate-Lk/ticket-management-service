package com.busmate.ticketing_service.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {
    private Long conductorId;
    private Long busId;
    private Long tripId;
    private String startLocationId;
    private String endLocationId;
    private BigDecimal fareAmount;
    private String paymentMethod;
    private String transactionRef;

}
