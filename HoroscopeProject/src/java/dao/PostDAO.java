/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Horoscope;
import entity.Post;
import entity.Reader;
import entity.Writer;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utill.DBConnection;

/**
 *
 * @author EGE
 */
public class PostDAO extends DBConnection {

    private WriterDAO writerDao;

    public void create(Post c) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "insert into posts(title , context , writer_id) values('" + c.getTitle() + "','" + c.getContext() + "',"
                    + c.getWriter().getId() + ")";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Post c) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();

            String query = "Delete from posts where id = " + c.getId();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Post> getList() {
        List<Post> list = new ArrayList<>();
        try {

            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "Select * from posts";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Writer horo = this.getWriterDao().findById(rs.getInt("writer_id"));
                list.add(new Post(rs.getInt("id"), rs.getString("title"), rs.getString("context"), horo));
                //findbyID
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(Post c) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "update posts set title = '" + c.getTitle()
                    + "',context ='" + c.getContext() + "',writer_id ='" + c.getWriter().getId() + "' where id = " +c.getId();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public WriterDAO getWriterDao() {
        if (this.writerDao == null) {
            this.writerDao = new WriterDAO();
        }
        return writerDao;
    }

    public void setWriterDao(WriterDAO writerDao) {
        this.writerDao = writerDao;
    }

}
