package com.itembox.itembox.persistance.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SucursalesDto {
    private String idExterno;
    private String descripcion;
    private List<ArticulosDto> articulos;
    private EmpresaDto empresa;
}
