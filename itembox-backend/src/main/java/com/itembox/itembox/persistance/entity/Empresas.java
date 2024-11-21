package com.itembox.itembox.persistance.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_empresas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empresas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "entrp_id")
    private Integer id;

    @Column(name = "entrp_name")
    private String name;

    @OneToMany(
        mappedBy = "empresa",
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Sucursales> sucursales;
}
