/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Document;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utill.DBConnection;

/**
 *
 * @author EGE
 */
public class DocumentDao extends DBConnection {

    public List<Document> findAll(int page, int pageSize) {

        List<Document> dList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from documents order by id asc limit " + pageSize + " offset " +  start;

            System.out.println(start);
            // String query1 = "select * from documents order by id";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                
                Document doc = new Document();
                doc.setId(rs.getInt("id"));
                doc.setFileName(rs.getString("fileName"));
                doc.setFilePath(rs.getString("filePath"));
                doc.setFileType(rs.getString("fileType"));
                System.out.println(doc.getId() + doc.getFileName());
                dList.add(doc);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dList;
    }

    public void insert(Document document) {

        try {
            // Connection conn = this.connect();
            Statement st = this.getConnection().createStatement();
            String query = "insert into documents(filePath,fileName ,fileType) values('" + document.getFilePath() + "',"
                    + "'" + document.getFileName() + "',"
                    + "'" + document.getFileType() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public int count() {

        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "Select count(id) as document_count from documents";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("document_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
