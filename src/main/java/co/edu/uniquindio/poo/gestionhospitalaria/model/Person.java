package co.edu.uniquindio.poo.gestionhospitalaria.model;

public class Person {
    private String name;
    private String id;
    private String email;
    private String password;

    /**
     * Constructor method of person class
     * @param name
     * @param id
     * @param email
     * @param password
     */
    public Person(String name, String id, String email, String password) {
        this.name=name;
        this.id=id;
        this.email=email;
        this.password=password;
    }


    /**
     * Method to read the name of the person
     * @return The name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Method to change the name of the person
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
