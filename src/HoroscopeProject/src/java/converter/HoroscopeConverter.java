/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.HoroscopeDAO;
import entity.Horoscope;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author EGE
 */
@FacesConverter("horoscopeConverter")
public class HoroscopeConverter implements Converter {

    private HoroscopeDAO horoscopeDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string); // Gelen python categorysinin id si . // int e çevirdik ki findById ile alabilelim
        Horoscope c = this.getHoroscopeDao().findById(id); // Python categorysinde bir category nesnesi oluşturduk 
         System.out.println("başarısadsdadslı");
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Horoscope c = (Horoscope) t;
        System.out.println("başarsadsaddsılı");
        return String.valueOf(c.getId());
    }

    public HoroscopeDAO getHoroscopeDao() {
        if (this.horoscopeDao == null) {
            this.horoscopeDao = new HoroscopeDAO();
        }
        return horoscopeDao;
    }

    public void setHoroscopeDao(HoroscopeDAO horoscopeDao) {
        this.horoscopeDao = horoscopeDao;
    }

}
