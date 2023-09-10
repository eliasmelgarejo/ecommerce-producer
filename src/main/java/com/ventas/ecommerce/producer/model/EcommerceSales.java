package com.ventas.ecommerce.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EcommerceSales implements Serializable {
    private static final long serialVersionUID = 4212129403091423953L;
    private int mes;
    private int anio;
    private String productCode;
    private String productCategory;
    private int quantity;
}
