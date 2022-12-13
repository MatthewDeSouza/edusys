package com.github.matthewdesouza.edusys.model.education.course;

import com.github.matthewdesouza.edusys.model.education.person.Person;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    UUID id;

    @Version
    long version;

    @Column(name = "value", nullable = false)
    Float value;

    @ManyToOne(targetEntity = Assignment.class)
    Assignment assignment;

    @ManyToOne(targetEntity = Person.class)
    Person person;

}
