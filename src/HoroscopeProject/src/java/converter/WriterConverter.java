/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.WriterDAO;
import entity.Writer;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author EGE
 */
@FacesConverter("writerConverter")
public class WriterConverter implements Converter {

    private WriterDAO writerDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string); // Gelen python categorysinin id si . // int e çevirdik ki findById ile alabilelim
        Writer c = this.getWriterDao().findById(id); // Python categorysinde bir category nesnesi oluşturduk 
        System.out.println("başarısadsdadslı");
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Writer c = (Writer) t;
        System.out.println("başarsadsaddsılı");
        return String.valueOf(c.getId());
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
