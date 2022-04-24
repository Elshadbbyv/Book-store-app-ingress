package com.example.bookstoreappingress.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "rolename")
    RoleEnumEntity roleName;
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "timestamp default now()")
    LocalDateTime created_at;
    @CreationTimestamp
    @Column(name = "updated_at", columnDefinition = "timestamp default now()")
    LocalDateTime updated_at;



}
