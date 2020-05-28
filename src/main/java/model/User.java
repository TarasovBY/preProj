package model;

public class User {
    private int id;
    private String name;
    private String telephone;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }


    public User(int id, String name, String telephone) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
    }

    public User(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }
}
