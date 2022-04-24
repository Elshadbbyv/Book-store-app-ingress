package com.example.bookstoreappingress.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String tittle;
    //ISBN- International Standard Book Number
    @Column(name = "isbn", nullable = false)
    Long isbn;
    @Column(name = "pagenum", nullable = false)
    Integer pageNum;
    @Column(name = "rating")
    Double rating;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_categories",
    joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "category_id",referencedColumnName = "id"))
    List<UserProfileEntity> userProfile = new ArrayList<>();

}
