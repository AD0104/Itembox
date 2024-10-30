package com.itembox.itembox.persistance.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticulosDto {
    private String nombre;
    private String descripcion;
    private Integer activos;
    private BigDecimal precioUnitario;
}
