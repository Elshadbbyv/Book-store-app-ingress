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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    @Column(name = "firstname", length = 20, nullable = false)
    String firstname;
    @Column(name = "lastname", length = 20, nullable = false)
    String lastname;
    @CreationTimestamp
    @Column(name = "createdAt", columnDefinition = "timestamp deafult now()")
    LocalDateTime createdAt;
    @CreationTimestamp
    @Column(name = "updatedAt", columnDefinition = "timestamp deafult now()")
    LocalDateTime updatedAt;
    @OneToOne
    @JoinColumn(name = "acc_id",referencedColumnName = "id")
    AccountEntity accountEntity = new AccountEntity();
    @ManyToMany
    @JoinTable(name = "author",
    joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    List<BookEntity> bookEntities = new ArrayList<>();

}
