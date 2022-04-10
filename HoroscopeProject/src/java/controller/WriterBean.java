/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.WriterDAO;

import entity.Writer;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author EGE
 */
@Named(value = "writerBean")
@SessionScoped
public class WriterBean implements Serializable {

    private Writer entity;
    private WriterDAO dao;
    private List<Writer> list;

    /**
     * Creates a new instance of WriterBean
     */
    public WriterBean() {

    }

    public void create() {
        this.getDao().create(entity);
        this.entity = new Writer();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Writer();
    }

    public void delete(Writer p) {
        this.getDao().delete(p);
        this.entity = new Writer();
    }

    public Writer getEntity() {
        if (this.entity == null) {
            this.entity = new Writer();

        }
        return entity;
    }

    public void setEntity(Writer entity) {
        this.entity = entity;
    }

    public WriterDAO getDao() {
        if (this.dao == null) {
            this.dao = new WriterDAO();
        }
        return dao;
    }

    public void setDao(WriterDAO dao) {
        this.dao = dao;
    }

    public List<Writer> getList() {
        this.list = this.getDao().getList(); // her seferinde databaseden listeyi çeker
        return list;
    }

    public void setList(List<Writer> list) {
        this.list = list;
    }


}
