package com.lambdaschool.javacountries.models;

//import javax.persistence.*
//
//@Entity
//@Table(name = "countries")
public class Countries {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Long population;
    private Long landMassKm2;
    private int medianAge;

    public Countries(String name, Long population, Long landMassKm2, int medianAge) {
        this.name = name;
        this.population = population;
        this.landMassKm2 = landMassKm2;
        this.medianAge = medianAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getLandMassKm2() {
        return landMassKm2;
    }

    public void setLandMassKm2(Long landMassKm2) {
        this.landMassKm2 = landMassKm2;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }
}
