/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author EGE
 */
public class Reader {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String gender;
    private Horoscope horoscope;

    public Reader() {
    }

    public Reader(int id, String name, String surname, String email, String password, String gender, Horoscope horoscope) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.horoscope = horoscope;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Horoscope getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(Horoscope horoscope) {
        this.horoscope = horoscope;
    }

}
