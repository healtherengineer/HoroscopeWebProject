/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.HoroscopeDAO;
import entity.Horoscope;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author EGE
 */
@Named(value = "horoscopeBean")
@SessionScoped
public class HoroscopeBean implements Serializable {

    private Horoscope entity;
    private HoroscopeDAO dao;
    private List<Horoscope> list;

    /**
     * Creates a new instance of HoroscopeBean
     */
    public HoroscopeBean() {
    }

    public void create() {
        this.getDao().create(entity);
        this.entity = new Horoscope();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Horoscope();
    }

    public void delete(Horoscope p) {
        this.getDao().delete(p);
        this.entity = new Horoscope();
    }

    public Horoscope getEntity() {
        if (this.entity == null) {
            this.entity = new Horoscope();
        }
        return entity;
    }

    public void setEntity(Horoscope entity) {
        this.entity = entity;
    }

    public HoroscopeDAO getDao() {
        if (this.dao == null) {
            this.dao = new HoroscopeDAO();
        }
        return dao;
    }

    public void setDao(HoroscopeDAO dao) {
        this.dao = dao;
    }

    public List<Horoscope> getList() {
        this.list = this.getDao().getList(); // her seferinde databaseden listeyi çeker
        return list;
    }

    public void setList(List<Horoscope> list) {
        this.list = list;
    }

}
