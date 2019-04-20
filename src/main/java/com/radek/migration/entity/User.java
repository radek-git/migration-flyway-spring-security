package com.radek.migration.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor // czyli takie pola które mają anotację @NonNull
public class User extends AbstractEntity {


    @NonNull
    @NotEmpty
    private String name;

    @NonNull
    @NotEmpty
    private String surname;

    @NonNull
    @NotEmpty
    @Column(unique = true)
    private String username;

    @NonNull
    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    @NonNull
    @NotEmpty
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "expired")
    private boolean isExpired;

    @Column(name = "locked")
    private boolean isLocked;

    @Column(name = "credentials_expired")
    private boolean isCredentialExpired;

    @Column(name = "enabled")
    private boolean isEnabled;

    @OneToOne(optional = false,  cascade = CascadeType.ALL)
    @JoinColumn(name = "activation_token_id", referencedColumnName = "id")
    private ActivationToken activationToken;




}
