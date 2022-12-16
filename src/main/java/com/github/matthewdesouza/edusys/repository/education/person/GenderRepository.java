package com.github.matthewdesouza.edusys.repository.education.person;

import com.github.matthewdesouza.edusys.model.education.person.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface GenderRepository extends JpaRepository<Gender, UUID> {
    /**
     * Queries the database with a name string to match any {@link Gender} objects in the database.
     *
     * @param name Query text.
     * @return {@link Set}<{@link Gender}>, null if no matches are found.
     */
    Set<Gender> findGendersByNameLikeIgnoreCase(String name);
}