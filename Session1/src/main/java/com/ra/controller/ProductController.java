package com.ra.controller;

import com.ra.entity.Product;
import com.ra.repository.impl.ProductRepository;
import com.ra.repository.impl.Repository;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "products",value = "/products")
public class ProductController extends Controller{
    private ProductRepository productRepository;
    @Override
    public void init() throws ServletException{
        this.productRepository = new ProductRepository();
    }
    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int pageSize = 5;
        int page = Integer.parseInt(req.getParameter("page") == null ? "1": req.getParameter("page"));
        final String key = req.getParameter("key");
        List<Product> data = productRepository.findAll(Product.class);
        if(key != null&& key!=""){
            data = productRepository.findByKey(key);
        }
        int total = (int) Math.ceil((data.size())/(double) pageSize);
        if(key != null&& key!=""){
            data = productRepository.findByKeyPageable(key,page,pageSize);
        }else {
            data = productRepository.findAllPageable(page,pageSize);
        }
        req.setAttribute("data" ,data);
        req.setAttribute("total",total);
        req.setAttribute("page",page);
        req.setAttribute("key",key);
        req.getRequestDispatcher("views/products/index.jsp").forward(req,resp);
    }
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("action","create");
        req.getRequestDispatcher("views/products/create.jsp").forward(req, resp);
    }
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = productRepository.findId(id,Product.class);
        req.setAttribute("product",product);
        req.setAttribute("action","edit");
        req.getRequestDispatcher("views/products/create.jsp").forward(req, resp);
    }
    public void postCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String manufacturer = req.getParameter("manufacturer");
        Date created = new Date();
        int batch = Integer.parseInt(req.getParameter("batch"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        Product product = new Product(id,name,manufacturer,created,batch,quantity,status);
        productRepository.add(product);
        req.setAttribute("product",product);
        req.getRequestDispatcher("views/products/create.jsp").forward(req, resp);
    }
    public void postEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
        Product product = new Product();
        product.setProductId(req.getParameter("id"));
        product.setProductName(req.getParameter("name"));
        product.setManufacturer(req.getParameter("manufacturer"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String createDateStr = req.getParameter("created");
        product.setCreated(sdf.parse(createDateStr));
        product.setBatch(Integer.parseInt(req.getParameter("batch")));
        product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        product.setProductStatus(Boolean.parseBoolean(req.getParameter("status")));
        productRepository.edit(product);
        req.getRequestDispatcher("views/products/create.jsp").forward(req, resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        productRepository.remove(id,Product.class);
        index(req,resp);
        req.getRequestDispatcher("views/products/index.jsp").forward(req, resp);
    }
}
