package com.github.matthewdesouza.edusys.repository.education.course;

import com.github.matthewdesouza.edusys.model.education.course.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    /**
     * Queries the database with a supplied String to match
     * any {@link Department}'s name variable's content in the database.
     *
     * @param name Query text.
     * @return {@link Set}<{@link Department}>, empty if no matches are found.
     */
    Set<Department> findDepartmentsByNameLikeIgnoreCase(String name);
}
