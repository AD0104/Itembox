package com.itembox.itembox.persistance.entity;

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
@Table(name = "tbl_user_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usr_rols_id")
    private Integer id;

    @Column(name = "usr_rols_rol")
    private String rol;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usr_inf_id", nullable = false)
    private Usuario usuario;
}
