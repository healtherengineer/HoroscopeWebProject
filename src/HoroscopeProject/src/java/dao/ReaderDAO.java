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
public class ReaderDAO extends DBConnection {

    private HoroscopeDAO horoscopeDAO;

    public void create(Reader c) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "insert into readers(horoscope_id,name,surname , email , password ,gender) values('" + c.getHoroscope().getId()
                    + "','" + c.getName() + "','"
                    + c.getSurname() + "','"
                    + c.getEmail() + "','"
                    + c.getPassword() + "','"
                    + c.getGender() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Reader c) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();

            String query = "Delete from readers where id = " + c.getId();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Reader> getList() {
        List<Reader> list = new ArrayList<>();
        try {

            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "Select * from readers";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Horoscope horo = this.getHoroscopeDAO().findById(rs.getInt("horoscope_id"));
                list.add(new Reader(rs.getInt("id"), rs.getString("name"),
                        rs.getString("surname"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), horo));
                //findbyID
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(Reader c) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "update readers set horoscope_id = " + c.getHoroscope().getId()
                    + ",name ='" + c.getName() + "',surname ='" + c.getSurname() + "',email ='" + c.getEmail()
                    + "',password = '" + c.getPassword() + "',gender ='" + c.getGender() + "' where id = " + c.getId();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public HoroscopeDAO getHoroscopeDAO() {
        if (this.horoscopeDAO == null) {
            this.horoscopeDAO = new HoroscopeDAO();
        }
        return horoscopeDAO;
    }

    public void setHoroscopeDAO(HoroscopeDAO horoscopeDAO) {
        this.horoscopeDAO = horoscopeDAO;
    }

    public Reader findById(int id) {
        Reader horo = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "Select * from readers where id = " + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Horoscope horos = this.getHoroscopeDAO().findById(rs.getInt("horoscope_id"));
                horo = new Reader(rs.getInt("id"), rs.getString("name"),
                        rs.getString("surname"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), horos);

            }
        } catch (SQLException ex) {
            Logger.getLogger(HoroscopeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horo;
    }
}
