package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 5, message = "Street name must contain at least 5 characters")
    private String street;

    @NotBlank
    @Size(min = 5, message = "Building name must contain at least 5 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 4, message = "City name must contain at least 4 characters")
    private String cityName;

    @NotBlank
    @Size(min = 2, message = "State name must contain at least 2 characters")
    private String state;

    @NotBlank
    @Size(min = 2, message = "Country name must contain at least 2 characters")
    private String country;

    @NotBlank
    @Size(min = 4, message = "Postal code  must contain at least 4 characters")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address(String street, String buildingName, String cityName, String state, String country, String postalCode) {
        this.street = street;
        this.buildingName = buildingName;
        this.cityName = cityName;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }
}
