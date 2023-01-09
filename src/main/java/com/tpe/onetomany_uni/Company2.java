package com.tpe.onetomany_uni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company2 {

    @Id
    private Long id;

    @Column(unique = true)
    private String companyName;

    // If we want to see devs working in the company
    // Why Set? Because it does not allow repetitive data
    @OneToMany
    @JoinColumn(name = "company_id")
    private Set<Developer05> devs = new HashSet<>();

    public Set<Developer05> getDevs() {
        return devs;
    }

    public void setDevs(Set<Developer05> devs) {
        this.devs = devs;
    }

    public Company2() {
    }

    public Company2(Long id, String companyName) {
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
        return "Company2{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
