package com.github.matthewdesouza.edusys.repository.education.course;

import com.github.matthewdesouza.edusys.model.education.course.Assignment;
import com.github.matthewdesouza.edusys.model.education.course.Grade;
import com.github.matthewdesouza.edusys.model.education.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface GradeRepository extends JpaRepository<Grade, UUID> {
    /**
     * Queries the database with two floats to match any {@link Grade}'s value variables in range in the database.
     *
     * @param min The minimum value of the desired range.
     * @param max The maximum value of the desired range.
     * @return {@link Set}<{@link Grade}>, empty if no matches are found.
     */
    Set<Grade> findGradesByValueBetween(Float min, Float max);

    /**
     * Queries the database with a float value to match any {@link Assignment} objects in the database.
     *
     * @param value Query float.
     * @return {@link Set}<{@link Grade}>, empty if no matches are found.
     */
    Set<Grade> findGradesByValueEquals(float value);

    /**
     * Queries the database with a {@link Person} and an {@link Assignment} object
     * to match any {@link Grade} objects in the database.
     *
     * @param person     Query {@link Person} object.
     * @param assignment Query {@link Assignment} object.
     * @return {@link Grade}, null if no matches are found.
     */
    Grade findGradeByPersonAndAssignment(Person person, Assignment assignment);
}