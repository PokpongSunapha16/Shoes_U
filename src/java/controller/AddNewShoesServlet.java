package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Shoes;

@WebServlet(name = "AddNewShoesServlet", urlPatterns = {"/AddNewShoesServlet"})

public class AddNewShoesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8"); //  ป้องกันค่าวรรณยุกต์ผิด
        response.setContentType("text/html;charset=UTF-8");

        //  รับค่าจาก form
        String shoesName = request.getParameter("shoesName");
        String shoesType = request.getParameter("shoesType");
        String brand = request.getParameter("brand");
        int shoesPrice = Integer.parseInt(request.getParameter("shoesPrice"));

        // สร้าง instance of shoes
        Shoes shoes = new Shoes();
        shoes.setId("1");
        shoes.setName(shoesName);
        shoes.setType(shoesType);
        shoes.setBrand(brand);
        shoes.setPrice(shoesPrice);
        
                // insert into MySQL: table food
        DBConnection dbConnection = new DBConnection();
        if(!dbConnection.insertNewShoes(shoes)){
            System.out.println(">>> AddNewShoesMySQL ERROR");
        }

        //  เก็บใน session
        HttpSession session = request.getSession();
        session.setAttribute("shoes", shoes);
        
                // forward ไป addNewFoodSuccess.jsp
        request.getRequestDispatcher("/AddNewShoesSuccess.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "AddNewFoodServlet - receives food form and forwards to success page";
    }
}
