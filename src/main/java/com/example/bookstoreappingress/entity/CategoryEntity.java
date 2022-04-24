package com.example.bookstoreappingress.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryEntity {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "book_category")
    private CategoryEnumEntity categoryEnumEntity;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "timestamp default now()", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition = "timestamp default now()", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();


}
