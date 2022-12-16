package com.github.matthewdesouza.edusys.repository.education.person;

import com.github.matthewdesouza.edusys.model.education.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;
import java.util.Set;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    /**
     * Queries the database with two {@link Calendar} objects to
     * match any {@link Person} objects in the database that are in range.
     *
     * @param start Query {@link Calendar} object.
     * @param end Query {@link Calendar} object.
     * @return {@link Set}<{@link Person}>, empty if no matches are found.
     */
    Set<Person> getPeopleByDobBetween(Calendar start, Calendar end);

    /**
     * Queries the database with a supplied String to
     * match any {@link Person} objects in the database.
     *
     * @param firstName Query text.
     * @return {@link Set}<{@link Person}>, empty if no matches are found.
     */
    Set<Person> getPeopleByFirstNameLikeIgnoreCase(String firstName);

    /**
     * Queries the database with a supplied String to
     * match any {@link Person} objects in the database.
     *
     * @param lastName Query text.
     * @return {@link Set}<{@link Person}>, empty if no matches are found.
     */
    Set<Person> getPeopleByLastNameLikeIgnoreCase(String lastName);

    /**
     * Queries the database with two supplied Strings to
     * match any {@link Person} objects by first name and last name in the database.
     *
     * @param firstName Query text.
     * @param lastName Query text.
     * @return {@link Set}<{@link Person}>, empty if no matches are found.
     */
    Set<Person> getPeopleByFirstNameLikeIgnoreCaseAndLastNameLikeIgnoreCase(String firstName, String lastName);

    /**
     * Queries the database with a supplied String to
     * match any {@link Person} objects by email in the database.
     *
     * @param email Query text.
     * @return {@link Set}<{@link Person}>, empty if no matches are found.
     */
    Set<Person> getPeopleByEmailLikeIgnoreCase(String email);
}