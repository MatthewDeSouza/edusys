package com.github.matthewdesouza.edusys.repository.system;

import com.github.matthewdesouza.edusys.model.system.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;


public interface RoleRepository extends JpaRepository<Role, UUID> {
    /**
     * Queries the database with a supplied String to match
     * any single {@link Role} objects within the database.
     *
     * @param name Query text.
     * @return {@link Role}, empty if no matches are found.
     */
    Role getRoleByName(String name);

    /**
     * Queries the database with a supplied String to match
     * any single {@link Role} objects within the database.
     *
     * @param name Query text.
     * @return {@link Role}, empty if no matches are found.
     */
    Set<Role> getRolesByNameLikeIgnoreCase(String name);
}