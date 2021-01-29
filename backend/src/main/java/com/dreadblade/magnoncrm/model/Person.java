package com.dreadblade.magnoncrm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
@EqualsAndHashCode(of = { "id" })
@ToString(of = { "id", "name" })
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
}
