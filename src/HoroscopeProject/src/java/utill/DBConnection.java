/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utill;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author EGE
 */
public abstract class DBConnection {

    private Connection connection;
    //connection nesnesi bir defa tutulacak hep aynı connecttion la gezecez 
    // defalarca method çağrısı yapmaktansa özellik çağırcaz.

    public Connection getConnection() {
        if (this.connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/horoscope", "postgres", "12345");
                System.out.println("başarılı");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
