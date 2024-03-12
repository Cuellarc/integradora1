package model;

import java.time.LocalDate;

public class User {
    private String name;
    private String secName;
    private String password;
    private LocalDate birthdate;
    private String country;
    private String telefNumber;
    private String mainPers;

    public User(String name, String secName, String password, LocalDate birthdate, String country, String telefNumber, String mainPers) {
        this.name = name;
        this.secName = secName;
        this.password = password;
        this.birthdate = birthdate;
        this.country = country;
        this.telefNumber = telefNumber;
        this.mainPers = mainPers;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelefNumber() {
        return telefNumber;
    }

    public void setTelefNumber(String telefNumber) {
        this.telefNumber = telefNumber;
    }

    public String getMainPers() {
        return mainPers;
    }

    public void setMainPers(String mainPers) {
        this.mainPers = mainPers;
    }
    
    
}

