package com.itembox.itembox.persistance.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_item_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Articulos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "itm_inf_id")
    private Integer id;

    @Column(name = "itm_inf_name")
    private String nombre;

    @Column(name = "itm_inf_description")
    private String descripcion;

    @Column(name = "itm_inf_stock")
    private Integer activos;

    @Column(name = "itm_inf_unitary_price")
    private BigDecimal precioUnitario;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "suc_id", nullable = false)
    private Sucursales sucursal;
}
