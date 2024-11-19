package com.itembox.itembox.persistance.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "roles_id")
    private Integer id;

    @Column(name = "roles_rol")
    private String rol;

    /*
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usr_inf_id", nullable = false)
    private Usuario usuario;
    */

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuario;
}
