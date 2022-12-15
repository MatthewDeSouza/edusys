package com.github.matthewdesouza.edusys.repository.education.course;

import com.github.matthewdesouza.edusys.model.education.course.Semester;
import com.github.matthewdesouza.edusys.model.education.course.SemesterSeason;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Year;
import java.util.Set;
import java.util.UUID;

public interface SemesterRepository extends JpaRepository<Semester, UUID> {
    /**
     * Queries the database with a {@link SemesterSeason} enum to match any {@link Semester} objects in the database.
     *
     * @param season Query {@link SemesterSeason} enum.
     * @return {@link Set}<{@link Semester}>, empty if no matches are found.
     */
    Set<Semester> findSemestersBySeason(SemesterSeason season);

    /**
     * Queries the database with a {@link Year} object to match any {@link Semester} objects in the database.
     *
     * @param year Query {@link Year} object.
     * @return {@link Set}<{@link Semester}>, empty if no matches are found.
     */
    Set<Semester> findSemestersByYear(Year year);

    /**
     * Queries the database with two {@link Year} objects to match
     * any {@link Semester} objects in range in the database.
     *
     * @param start Query {@link Year} object, minimum value.
     * @param end   Query {@link Year} object, maximum value.
     * @return {@link Set}<{@link Semester}>, empty if no matches are found.
     */
    Set<Semester> findSemestersByYearBetween(Year start, Year end);

    /**
     * Queries the database with a {@link SemesterSeason} enum and a {@link Year}
     * object to match any {@link Semester} objects in the database.
     *
     * @param season Query {@link SemesterSeason} enum.
     * @param year   Query {@link Year} object.
     * @return {@link Semester}, null if no matches are found.
     */
    Semester findSemesterBySeasonAndYear(SemesterSeason season, Year year);
}