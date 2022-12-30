package controller;

import data.LicorDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Licor;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rs) 
            throws ServletException, IOException{
        List<Licor> licores;
        licores = new LicorDAO().seleccionar();
        licores.forEach(System.out::println);
        
        req.setAttribute("licores", licores);
        req.getRequestDispatcher("licores.jsp").forward(req, rs);
    }
}
