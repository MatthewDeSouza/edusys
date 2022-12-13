package com.github.matthewdesouza.edusys.model.education.person;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    UUID id;

    @Version
    long version;

    @OneToOne(targetEntity = Person.class)
    Person resident;

    @Column(name = "address_1", nullable = false)
    String addressLine1;

    @Column(name = "address_2")
    String addressLine2;

    @Column(name = "city", nullable = false)
    String city;

    @Column(name = "state", nullable = false)
    String state;

    @Column(name = "zip", nullable = false, length = 5)
    String zipCode;
}
