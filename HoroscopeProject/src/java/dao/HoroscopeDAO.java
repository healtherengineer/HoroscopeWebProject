/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Horoscope;
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
public class HoroscopeDAO extends DBConnection {
    //create update delete read

    public void create(Horoscope c) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "insert into horoscopes(name) values('" + c.getName() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Horoscope c) {
        try {

            Statement st = this.getConnection().createStatement();

            String query = "Delete from horoscopes where id = " + c.getId();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Horoscope> getList() {
        List<Horoscope> list = new ArrayList<>();
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "Select * from horoscopes order by id asc";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                list.add(new Horoscope(rs.getInt("id"), rs.getString("name")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(Horoscope c) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "update horoscopes set  name =('" + c.getName() + "') where id =" + c.getId();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Horoscope findById(int id) {
        Horoscope horo =null ;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "Select * from horoscopes where id = " + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                horo = new Horoscope(rs.getInt("id"), rs.getString("name"));
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoroscopeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horo;
    }

}
