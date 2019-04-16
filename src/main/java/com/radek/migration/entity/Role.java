package com.radek.migration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "roles")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbstractEntity{

    private String name;
}
