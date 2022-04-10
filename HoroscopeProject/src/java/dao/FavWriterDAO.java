/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.FavWriter;
import entity.Horoscope;
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
public class FavWriterDAO extends DBConnection {

    private ReaderDAO readerDao;
    private WriterDAO writerDao;

    public void create(FavWriter fw) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "insert into readers(reader_id , writer_id) values(" + fw.getReader().getId() + "," + fw.getWriter().getId() + ")";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(FavWriter c) {
        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();

            String query = "Delete from fav_writers where id = " + c.getId();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<FavWriter> getList() {
        List<FavWriter> list = new ArrayList<>();
        try {

            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "Select * from fav_writers";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                  Reader reader = this.getReaderDao().findById(rs.getInt("reader_id"));
                  Writer writer = this.getWriterDao().findById(rs.getInt("writer_id"));
                  list.add(new FavWriter(rs.getInt("id"),reader, writer));
                //findbyID
            }
            return list;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ReaderDAO getReaderDao() {
        if (this.readerDao == null) {
            this.readerDao = new ReaderDAO();
        }
        return readerDao;
    }

    public void setReaderDao(ReaderDAO readerDao) {
        this.readerDao = readerDao;
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
