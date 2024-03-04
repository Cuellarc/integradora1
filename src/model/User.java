package model;

public class User {
    private String Nameuser;
    private String password;
    private String name;
    private String lastname;
    private String fechaNacimiento;
    private String direccionResidencia;
    private String city;
    private String telephone;
    private String email;
    

    public User(String Nameuser, String password, String name, String lastname, String fechaNacimiento,
                   String direccionResidencia, String city, String telephone, String email) {
        this.Nameuser = Nameuser;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.fechaNacimiento = fechaNacimiento;
        this.direccionResidencia = direccionResidencia;
        this.city = city;
        this.telephone = telephone;
        this.email = email;
    }

    

    public String getNameuser() {
        return Nameuser;
    }

    public void setNameuser(String Nameuser) {
        this.Nameuser = Nameuser;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getLastname() {
        return lastname;
    }



    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public String getFechaNacimiento() {
        return fechaNacimiento;
    }



    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }



    public String getDireccionResidencia() {
        return direccionResidencia;
    }



    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }



    public String getCity() {
        return city;
    }



    public void setCity(String city) {
        this.city = city;
    }



    public String getTelephone() {
        return telephone;
    }



    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    
}

