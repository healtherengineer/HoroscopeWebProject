/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.ReaderDAO;
import entity.Reader;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author EGE
 */
@Named(value = "readerBean")
@SessionScoped
public class ReaderBean implements Serializable {
// favwriter dao nesnesiyle crud yapılacak
// gelen writer id yi ise favwriter nesnesinin writer ı ile tutacağım
    private Reader entity;
    private ReaderDAO dao;
    private List<Reader> list;

    /**
     * Creates a new instance of ReaderBean
     */
    public ReaderBean() {
        this.entity = new Reader();
    }

    public void create() {
        this.getDao().create(entity);
        this.entity = new Reader();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Reader();
    }

    public void delete(Reader p) {
        this.getDao().delete(p);
        this.entity = new Reader();
    }

    public Reader getEntity() {
        if (this.entity == null) {
            this.entity = new Reader();

        }
        return entity;
    }

    public void setEntity(Reader entity) {
        this.entity = entity;
    }

    public ReaderDAO getDao() {
        if (this.dao == null) {
            this.dao = new ReaderDAO();
        }
        return dao;
    }

    public void setDao(ReaderDAO dao) {
        this.dao = dao;
    }

    public List<Reader> getList() {
        this.list = this.getDao().getList(); // her seferinde databaseden listeyi çeker
        return list;
    }

    public void setList(List<Reader> list) {
        this.list = list;
    }
}
