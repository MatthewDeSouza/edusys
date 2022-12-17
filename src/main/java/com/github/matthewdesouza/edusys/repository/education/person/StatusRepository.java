package com.github.matthewdesouza.edusys.repository.education.person;

import com.github.matthewdesouza.edusys.model.education.person.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface StatusRepository extends JpaRepository<Status, UUID> {
    /**
     * Queries the database with a supplied String to match
     * any single {@link Status} objects within the database.
     *
     * @param name Query text.
     * @return {@link Status}, empty if no matches are found.
     */
    Status findStatusByName(String name);
    /**
     * Queries the database with a supplied String to
     * match any {@link Status} objects within the database.
     *
     * @param name Query text.
     * @return {@link Set}<{@link Status}>, empty if no matches are found.
     */
    Set<Status> findStatusByNameLikeIgnoreCase(String name);
}