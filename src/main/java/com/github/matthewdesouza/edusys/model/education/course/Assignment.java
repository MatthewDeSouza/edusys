package com.github.matthewdesouza.edusys.model.education.course;

import com.github.matthewdesouza.edusys.model.education.person.Person;
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
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    UUID id;

    @Version
    long version;

    @Column(name = "name", nullable = false)
    String name;

    @Lob
    @Column(name = "content")
    String content;

    @ManyToOne(targetEntity = Course.class)
    Course course;

    @ManyToMany(targetEntity = Person.class)
    @JoinTable(
            name = "person_assignments",
            joinColumns = @JoinColumn(name = "assignment_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    Set<Person> people;
}
