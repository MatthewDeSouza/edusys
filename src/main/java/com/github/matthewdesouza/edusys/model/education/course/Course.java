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
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    UUID id;

    @Version
    long version;

    @Column(name = "name")
    String name;

    @Lob
    @Column(name = "description")
    String description;

    @Column(name = "credits", nullable = false)
    Float credits;

    @OneToMany(targetEntity = Assignment.class, mappedBy = "course")
    Set<Assignment> assignments;

    @ManyToOne(targetEntity = Department.class)
    Department department;

    @ManyToOne(targetEntity = Semester.class)
    Semester semester;

    @ManyToMany(targetEntity = Person.class)
            @JoinTable(
                    name = "person_courses",
                    joinColumns = @JoinColumn(name = "course_id"),
                    inverseJoinColumns = @JoinColumn(name = "person_id")
            )
    Set<Person> attendees;
}
