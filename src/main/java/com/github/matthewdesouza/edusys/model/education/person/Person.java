package com.github.matthewdesouza.edusys.model.education.person;

import com.github.matthewdesouza.edusys.model.education.course.Assignment;
import com.github.matthewdesouza.edusys.model.education.course.Course;
import com.github.matthewdesouza.edusys.model.education.course.Grade;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Calendar;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    UUID id;

    @Version
    long version;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "middle_initial")
    Character middleInitial;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "dob", nullable = false)
    Calendar dob;

    @OneToOne(targetEntity = Address.class, fetch = FetchType.EAGER)
    Address address;

    @OneToMany(targetEntity = Grade.class, mappedBy = "person")
    Set<Grade> grades;

    @ManyToOne(targetEntity = Gender.class)
    Gender gender;

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(
            name = "person_courses",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    Set<Course> courses;

    @ManyToMany(targetEntity = Status.class)
    @JoinTable(
            name = "person_status",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "status_id")
    )
    Set<Status> positions;

    @ManyToMany(targetEntity = Assignment.class)
    @JoinTable(
            name = "person_assingments",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "assingment_id")
    )
    Set<Assignment> assignments;


    public float calculateGpa() {
        return (float) grades.stream()
                .mapToDouble(Grade::getValue)
                .average()
                .orElse(0.0f);
    }
}
