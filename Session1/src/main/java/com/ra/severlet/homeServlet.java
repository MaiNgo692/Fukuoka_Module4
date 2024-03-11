package com.ra.severlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet(name = "homeServlet", value = "/trang-chu")
public class homeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){
            request.getRequestDispatcher("views/login.jsp").forward(request,response);
        }
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String email = "ngomai@gmail.com";
        boolean gender = false;
        Date birthday = new Date();
        double balance =465232166L;
        List<String > fav = Arrays.asList("Game","Đá bóng","Chạy","Du lịch");

        request.setAttribute("txtEmail",email);
        request.setAttribute("txtName", name);
        request.setAttribute("txtGender",gender);
        request.setAttribute("lstFav",fav);
        request.setAttribute("txtBirthday",birthday);
        request.setAttribute("balance",balance);

        request.getRequestDispatcher("views/home.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
