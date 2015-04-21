package org.test.hellobeer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 2, message = "\"${validatedValue}\" is too short.")
    private String name;

    @ManyToOne
    @NotNull
    private Brewery brewery;

    @NotNull
    @Size(min = 2, message = "\"${validatedValue}\" is too short.")
    private String type;

    @Min(0)
    @NotNull
    private float alcoholContent;

    protected Beer() {
    }

    /**
     * @param name
     * @param brewery
     * @param type
     * @param alcohol
     */
    public Beer(String name, Brewery brewery, String type, float alcohol) {
        this.name = name;
        this.brewery = brewery;
        this.type = type;
        this.alcoholContent = alcohol;
    }

    /**
     * @return
     */
    public final long getId() {
        return id;
    }

    /**
     * @return
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public final Brewery getBrewery() {
        return brewery;
    }

    /**
     * @param brewery
     */
    public final void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    /**
     * @return
     */
    public final String getType() {
        return type;
    }

    /**
     * @param type
     */
    public final void setType(String type) {
        this.type = type;
    }

    /**
     * @return
     */
    public final float getAlcoholContent() {
        return alcoholContent;
    }

    /**
     * @param alcohol
     */
    public final void setAlcoholContent(float alcohol) {
        this.alcoholContent = alcohol;
    }

    @Override
    public final String toString() {
        return String
                .format("Beer[id=%d, name='%s', brewery='%s', type='%s', alcoholContent=%f)",
                        id, name, brewery, type, alcoholContent);
    }
}
