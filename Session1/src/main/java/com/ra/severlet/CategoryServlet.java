package com.ra.severlet;

import com.ra.entity.Category;
import com.ra.service.impl.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("lstCategory",categories);
        String key = request.getParameter("key");
        if(key!= null){
            Category category = categoryService.findByName(key);
            if(category!= null){
                request.setAttribute("findCategory",category);
            }
        }
        request.getRequestDispatcher("/views/category/category.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        CategoryService categoryService = new CategoryService();
        String categoryName = request.getParameter("categoryName");
        String description = request.getParameter("description");
        Category category = new Category(categoryName,description,true);
        categoryService.add(category);

        List<Category> categories = categoryService.findAll();
        request.setAttribute("lstCategory",categories);
        request.getRequestDispatcher("/views/category//category.jsp").forward(request,response);
    }
}
