package com.github.matthewdesouza.edusys.model.education.course;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Year;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    UUID id;

    @Version
    long version;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "season", nullable = false)
    SemesterSeason season;

    @Column(name = "year", nullable = false)
    Year year;

    @OneToMany(targetEntity = Course.class, mappedBy = "semester")
    Set<Course> courses;
}
