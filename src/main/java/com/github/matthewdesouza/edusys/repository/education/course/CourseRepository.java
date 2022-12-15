package com.github.matthewdesouza.edusys.repository.education.course;

import com.github.matthewdesouza.edusys.model.education.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    /**
     * Queries the database with a supplied String to match
     * any {@link Course}'s name variable's content in the database.
     *
     * @param name Query text.
     * @return {@link Set}<{@link Course}>, empty if no matches are found.
     */
    Set<Course> findCoursesByNameLikeIgnoreCase(String name);

    /**
     * Queries the database with a supplied String to match any {@link Course}'s content variable's content.
     *
     * @param content Query text.
     * @return {@link Set}<{@link Course}>, empty if no matches are found.
     */
    Set<Course> findCoursesByDescriptionLikeIgnoreCase(String content);
}
