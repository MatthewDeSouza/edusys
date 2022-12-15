package com.github.matthewdesouza.edusys.repository.education.course;

import com.github.matthewdesouza.edusys.model.education.course.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public interface AssignmentRepository extends JpaRepository<Assignment, UUID> {
    /**
     * Queries the database with a supplied String to match any
     * {@link Assignment}'s content variable's content in the database.
     *
     * @param content Query text.
     * @return {@link Set}<{@link Assignment}>, empty if no matches are found.
     */
    Set<Assignment> findAssignmentsByContentLikeIgnoreCase(String content);

    /**
     * Queries the database with a supplied String to match any
     * {@link Assignment}'s title variable's content in the database.
     *
     * @param name Query text.
     * @return {@link Set}<{@link Assignment}>, empty if no matches are found.
     */
    Set<Assignment> findAssignmentsByNameLikeIgnoreCase(String name);

    /**
     * Queries the database with two {@link LocalDateTime} objects to match
     * any {@link Assignment} objects in range in the database.
     *
     * @param start Query {@link LocalDateTime} object, minimum value.
     * @param end   Query {@link LocalDateTime} object, maximum value.
     * @return {@link Set}<{@link Assignment}>, empty if no matches are found.
     */
    Set<Assignment> findAssignmentsByDueDateTimeIsBetween(LocalDateTime start, LocalDateTime end);
}
