package com.tpe.onetomany_bi;

import com.tpe.onetomany_uni.Company2;

import javax.persistence.*;

@Entity
@Table(name = "t_developer6")
public class Developer06 {

    @Id
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(unique = true)
    private String email;

    private String branch;

    @ManyToOne
    @JoinColumn
    private Company3 company;

    public Developer06() {
    }

    public Developer06(Long id, String name, String email, String branch, Company3 company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Company3 getCompany() {
        return company;
    }

    public void setCompany(Company3 company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Developer07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", company=" + company +
                '}';
    }
}
