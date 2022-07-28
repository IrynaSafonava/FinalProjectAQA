package by.it_academy.onliner.rest_api.model;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Headphones {
    private String name;
    private String description;

    public Headphones(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Headphones{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
