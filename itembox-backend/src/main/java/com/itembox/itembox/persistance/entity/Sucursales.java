package com.itembox.itembox.persistance.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_sucursales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sucursales {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "suc_id")
    private Integer id;

    @Column(name = "suc_id_external")
    private String idExterno;

    @Column(name = "suc_description")
    private String descripcion;

    @OneToMany(
        mappedBy = "sucursal",
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL
    )
    private List<Articulos> articulos;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "entrp_id", nullable = false)
    private Empresas empresa; 
}
