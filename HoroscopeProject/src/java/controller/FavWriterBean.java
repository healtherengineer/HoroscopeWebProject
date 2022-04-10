/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.FavWriterDAO;
import entity.FavWriter;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author EGE
 */
@Named(value = "favWriterBean")
@SessionScoped
public class FavWriterBean implements Serializable {

   private FavWriter entity;
    private FavWriterDAO dao;
    private List<FavWriter> list;

    /**
     * Creates a new instance of FavWriterBean
     */
    public FavWriterBean() {
    }

    public void create() {
        this.getDao().create(entity);
        this.entity = new FavWriter();
    }



    public void delete(FavWriter p) {
        this.getDao().delete(p);
        this.entity = new FavWriter();
    }

    public FavWriter getEntity() {
        if (this.entity == null) {
            this.entity = new FavWriter();
        }
        return entity;
    }

    public void setEntity(FavWriter entity) {
        this.entity = entity;
    }

    public FavWriterDAO getDao() {
        if (this.dao == null) {
            this.dao = new FavWriterDAO();
        }
        return dao;
    }

    public void setDao(FavWriterDAO dao) {
        this.dao = dao;
    }

    public List<FavWriter> getList() {
        this.list = this.getDao().getList(); // her seferinde databaseden listeyi çeker
        return list;
    }

    public void setList(List<FavWriter> list) {
        this.list = list;
    }
    
}
