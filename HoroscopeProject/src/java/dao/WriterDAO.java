/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Horoscope;
import entity.Reader;
import entity.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utill.DBConnection;

/**
 *
 * @author EGE
 */
public class WriterDAO extends DBConnection {

    public void create(Writer c) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "insert into writers(name,surname , email , password ,gender) values("
                    + "'" + c.getName() + "','"
                    + c.getSurname() + "','"
                    + c.getEmail() + "','"
                    + c.getPassword() + "','"
                    + c.getGender() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Writer c) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();

            String query = "Delete from writers where id = " + c.getId();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Writer> getList() {
        List<Writer> list = new ArrayList<>();
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "Select * from writers ";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                list.add(new Writer(rs.getInt("id"), rs.getString("name"),
                        rs.getString("surname"), rs.getString("email"), rs.getString("password"), rs.getString("gender")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(Writer c) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "update writers set "
                    + "name ='" + c.getName() + "',surname ='" + c.getSurname() + "',email ='" + c.getEmail()
                    + "',password = '" + c.getPassword() + "',gender ='" + c.getGender() + "' where id = " + c.getId();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Writer findById(int id) {
        Writer horo = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "Select * from writers where id = " + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                horo = new Writer(rs.getInt("id"), rs.getString("name"),
                        rs.getString("surname"), rs.getString("email"), rs.getString("password"), rs.getString("gender"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(HoroscopeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horo;
    }

}
