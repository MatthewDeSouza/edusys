package com.github.matthewdesouza.edusys.repository.education.person;

import com.github.matthewdesouza.edusys.model.education.person.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    /**
     * Queries the database with a city string to match any {@link Address} objects in the database.
     *
     * @param city Query text.
     * @return {@link Set}<{@link Address}>, null if no matches are found.
     */
    Set<Address> findAddressesByCity(String city);

    /**
     * Queries the database with a state string to match any {@link Address} objects in the database.
     *
     * @param state Query text.
     * @return {@link Set}<{@link Address}>, null if no matches are found.
     */
    Set<Address> findAddressesByState(String state);

    /**
     * Queries the database with a zip code string to match any {@link Address} objects in the database.
     *
     * @param zipCode Query text.
     * @return {@link Set}<{@link Address}>, null if no matches are found.
     */
    Set<Address> findAddressesByZipCode(String zipCode);

    /**
     * Queries the database with a city string and a state
     * string to match any {@link Address} objects in the database.
     *
     * @param city Query city text.
     * @param state Query state text.
     * @return {@link Set}<{@link Address}>, null if no matches are found.
     */
    Set<Address> findAddressesByCityAndState(String city, String state);

    /**
     * Queries the database with a primary address line string to match any {@link Address} objects in the database.
     *
     * @param addressLine1 Query text.
     * @return {@link Set}<{@link Address}>, null if no matches are found.
     */
    Set<Address> findAddressesByAddressLine1(String addressLine1);

    /**
     * Queries the database with a secondary address line string to match any {@link Address} objects in the database.
     *
     * @param addressLine2 Query text.
     * @return {@link Set}<{@link Address}>, null if no matches are found.
     */
    Set<Address> findAddressesByAddressLine2(String addressLine2);
}