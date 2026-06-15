package com.app.ecom_application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private long id ;
    private String name ;
    private String description ;
    private BigDecimal price ;
    private String category ;
    private Integer StockQuantity ;
    private String imageUrl;
    private Boolean active ;
}
