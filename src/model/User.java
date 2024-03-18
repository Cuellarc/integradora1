package model;

import java.time.LocalDate;

public class User {
    private String name;
    private String secName;
    private String password;
    private LocalDate birthdate;
    private String city;
    private int telefNumber;
    private String mailPers;

    public User(String name, String secName, String password, LocalDate birthdate, String city, int telefNumber, String mailPers) {
        this.name = name;
        this.secName = secName;
        this.password = password;
        this.birthdate = birthdate;
        this.city = city;
        this.telefNumber = telefNumber;
        this.mailPers = mailPers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city= city;
    }

    public int getTelefNumber() {
        return telefNumber;
    }

    public void setTelefNumber(int telefNumber) {
        this.telefNumber = telefNumber;
    }

    public String getMailPers() {
        return mailPers;
    }

    public void setMailPers(String mailPers) {
        this.mailPers = mailPers;
    }
    
    
}

