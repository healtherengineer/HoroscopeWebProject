/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.PostDAO;
import entity.Post;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author EGE
 */
@Named(value = "postBean")
@SessionScoped
public class PostBean implements Serializable {
private Post entity;
    private PostDAO dao;
    private List<Post> list;

    /**
     * Creates a new instance of PostBean
     */
    public PostBean() {
        this.entity = new Post();
    }

    public void create() {
        this.getDao().create(entity);
        this.entity = new Post();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Post();
    }

    public void delete(Post p) {
        this.getDao().delete(p);
        this.entity = new Post();
    }

    public Post getEntity() {
        if (this.entity == null) {
            this.entity = new Post();

        }
        return entity;
    }

    public void setEntity(Post entity) {
        this.entity = entity;
    }

    public PostDAO getDao() {
        if (this.dao == null) {
            this.dao = new PostDAO();
        }
        return dao;
    }

    public void setDao(PostDAO dao) {
        this.dao = dao;
    }

    public List<Post> getList() {
        this.list = this.getDao().getList(); // her seferinde databaseden listeyi çeker
        return list;
    }

    public void setList(List<Post> list) {
        this.list = list;
    }
}
