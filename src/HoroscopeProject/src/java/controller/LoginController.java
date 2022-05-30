/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.ReaderDAO;
import entity.Reader;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

/**
 *
 * @author EGE
 */
@Named(value = "lc")
@SessionScoped
public class LoginController implements Serializable {

    private Reader reader;
    private ReaderDAO readerDAO ;
    
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    public void login() {

        // bu if kontrolünü bir method ile sağla ve bu method boolean dönsün ama senin bir dao methoduna ihtiyacın var reader için
        // dao nun içinde isAvailable methodu koy result set boş sa false 1 kayıt varsa true dönsün zaten burdaki
        //if in içinde sessionmap e yerleştiriyoruz.
        if (this.getReaderDAO().isAvailable(this.reader.getName() , this.reader.getPassword())) {
            //burda session map de validReader diye bir alan açtık ve oraya reader koyacağımızı söyledik
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validReader", reader);
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username or Password is Wrong !"));

        }

    }
  
    public Reader getReader() {
        if (this.reader == null) {
            reader = new Reader();
        }
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public ReaderDAO getReaderDAO() {
        if(this.readerDAO == null){
            readerDAO = new ReaderDAO();
        }
        return readerDAO;
    }

    public void setReaderDAO(ReaderDAO readerDAO) {
        this.readerDAO = readerDAO;
    }
    
}
