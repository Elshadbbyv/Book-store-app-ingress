package com.example.bookstoreappingress.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "username", length = 15, unique = true, nullable = false)
    String username;
    @Column(name = "mail", unique = true, nullable = false)
    String mail;
    @Column(name = "password", nullable = false)
    String password;
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "timestamp default now()")
    LocalDateTime created_at;
    @CreationTimestamp
    @Column(name = "updated_at", columnDefinition = "timestamp default now()")
    LocalDateTime updated_at;

    @ManyToMany
    @JoinTable(name = "add_roles",
        joinColumns = @JoinColumn(name = "add_roles", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    List<RoleEntity> roles = new ArrayList<>();





}
