package com.radek.migration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
@Table(name = "activation_tokens")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActivationToken extends AbstractEntity{

    @PrePersist
    public void prePersist() {
        value = UUID.randomUUID().toString().replaceAll("-", "");
        creationDate = LocalDateTime.now();
        expirationDate = creationDate.plus(7, ChronoUnit.DAYS);
    }

    private String value;

    private LocalDateTime creationDate;

    private LocalDateTime expirationDate;
}
