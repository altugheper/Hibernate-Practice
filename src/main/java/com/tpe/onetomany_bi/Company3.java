package com.tpe.onetomany_bi;

import com.tpe.onetomany_uni.Developer05;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company3 {

    @Id
    private Long id;

    @Column(unique = true)
    private String companyName;

    // If we want to see devs working in the company
    // Why Set? Because it does not allow repetitive data
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Developer06> devs = new HashSet<>();

    public Set<Developer06> getDevs() {
        return devs;
    }

    public void setDevs(Set<Developer06> devs) {
        this.devs = devs;
    }

    public Company3() {
    }

    public Company3(Long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company3{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
