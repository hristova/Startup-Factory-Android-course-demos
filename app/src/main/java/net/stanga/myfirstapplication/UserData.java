package net.stanga.myfirstapplication;

import java.io.Serializable;

public class UserData implements Serializable {

    private String name;
    private String email;
    private String password;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String userEmail) {
        this.email = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String userPassword) {
        this.password = userPassword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int userAge) {
        this.age = userAge;
    }
}
