package com.github.matthewdesouza.edusys.model.education.course;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    UUID id;

    @Version
    long version;

    @Column(name = "name", nullable = false, unique = true)
    String name;

    @OneToMany(targetEntity = Course.class, mappedBy = "department")
    Set<Course> courses;
}
