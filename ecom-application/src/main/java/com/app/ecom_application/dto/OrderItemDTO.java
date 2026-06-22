package com.app.ecom_application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class OrderItemDTO {
    private Long id ;
    private Long productId ;
    private BigDecimal quantity ;
    private BigDecimal price ;
    private BigDecimal subTotal;

}
