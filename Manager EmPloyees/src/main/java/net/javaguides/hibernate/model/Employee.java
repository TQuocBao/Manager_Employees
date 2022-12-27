package net.javaguides.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    protected int id;
 
    @Column(name="name")
    protected String name;
    
    @Column(name="SEX")
    protected String sex;
 
    @Column(name="email")
    protected String email;
 
    @Column(name="country")
    protected String country;
    
    @Column(name="phone")
    protected String phone;
 
    public Employee() {
    }
 
    public Employee(String name, String sex, String email, String country, String phone) {
        super();
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.country = country;
        this.phone = phone;
    }

    public Employee(int id, String name, String sex, String email, String country, String phone) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.country = country;
        this.phone = phone;
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
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    } 
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}