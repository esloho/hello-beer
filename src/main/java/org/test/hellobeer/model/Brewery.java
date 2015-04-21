package org.test.hellobeer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Brewery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 2, message = "\"${validatedValue}\" is too short.")
    private String name;

    @NotNull
    @Size(min = 2, message = "\"${validatedValue}\" is too short.")
    private String city;

    @NotNull
    @Size(min = 2, message = "\"${validatedValue}\" is too short.")
    private String country;

    @Pattern(regexp = "\\d{4}",
            message = "\"${validatedValue}\" needs to have 4 digits.")
    @Max(
            value = 2015,
            message = "\"${validatedValue}\" needs to be year no further than 2015")
    @NotNull
    private String foundedYear;

    protected Brewery() {
    }

    /**
     * @param name
     * @param city
     * @param country
     * @param year
     */
    public Brewery(String name, String city, String country, String year) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.foundedYear = year;
    }

    /**
     * @return the id
     */
    public final long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * @return the city
     */
    public final String getCity() {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public final void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public final String getCountry() {
        return country;
    }

    /**
     * @param country
     *            the country to set
     */
    public final void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the foundationYear
     */
    public final String getFoundedYear() {
        return foundedYear;
    }

    /**
     * @param foundationYear
     *            the foundationYear to set
     */
    public final void setFoundedYear(String foundationYear) {
        this.foundedYear = foundationYear;
    }

    @Override
    public final String toString() {
        return String
                .format("Brewery[id=%d, name='%s', city='%s', country='%s', foundedYear=%s)",
                        id, name, city, country, foundedYear);
    }
}
