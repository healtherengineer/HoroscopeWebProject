/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import entity.Reader;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author EGE
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {

        HttpServletRequest client = (HttpServletRequest) sr;
        HttpServletResponse server = (HttpServletResponse) sr1;

        //url leri aldık clientin
        HttpSession session = client.getSession();

        String url = client.getRequestURI();

        Reader reader = null;

        //bir session varsa gir ve login controller da oluşturulan validReader anahtarının içindeki reader ı 
        //reader nesnesine define et .
        if (session != null) {

            reader = (Reader) session.getAttribute("validReader");

        }
        //validReader ın değeri reader == null sa başarılı bir login olamamıştır 
        // index ve logout isteklerinde bulunduğunda login.xhtml e yönlendirecez 
        if (reader == null) {
            if (url.contains("index") || url.contains("logout")) {
                server.sendRedirect(client.getContextPath() + "/login.xhtml");

            } else {

                //başka birşey isterse istediği yere yönlendirecez
                fc.doFilter(sr, sr1);

            }

        } else {
            //reader null değilse başarılı bir login olduysa 
            //istediği her yere yönlendirecez
            //logout olunca session ı invalidate edeceğiz ve login.xhtml e yollayacağız .

            if (url.contains("logout")) {
                session.invalidate();
                server.sendRedirect(client.getContextPath() + "/login.xhtml");
            } else {
                fc.doFilter(sr, sr1);

            }

        }

    }
}
