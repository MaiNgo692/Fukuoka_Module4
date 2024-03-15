package com.ra.web.controller;

import com.ra.web.model.Product;
import com.ra.web.model.StorageDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Path;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ServletContext context;

    public ProductController(ServletContext context) {
        this.context = context;
    }

    @GetMapping("/index")
    public String index(){
        return "/products/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        Product product = new Product();
        product.setId("PS001");
        product.setCreated(new Date());
        model.addAttribute("product",product);
        return "/products/create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product")Product product, BindingResult bindingResult, Model model){
        boolean check = true;
        if (check) {
            bindingResult.addError(new FieldError("product", "id", "Mã sp đã tồn tại!"));
        }
        if (bindingResult.hasErrors()) {
            return "products/create";
        }
        Product pro = new Product();
        pro.setId(product.getId());
        pro.setName(product.getName());
        pro.setPrice(product.getPrice());
        pro.setCreated(product.getCreated());
        pro.setStatus(product.isStatus());
        String pathFolder = "/uploads/";
        String path = context.getRealPath("/WEB-INF/") + pathFolder;
        File folder = new File(path);
        // Tạo thư mục nếu chưa có
        if (!folder.exists())
            folder.mkdir();
        // Lưu file
        //        if (!product.getImage().isEmpty()) {
//
//            Path fileUpload = Paths.get(path + product.getImage().getOriginalFilename()); // => /WEB-INF/uploads/abc.jpg
//            try {
//                Files.write(fileUpload, product.getImage().getBytes());
//                pro.setImage(pathFolder + product.getImage().getOriginalFilename());
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
        StorageDatabase.products.add(pro);
        return "redirect:/products/index";
    }
    @GetMapping("/edit")
    public String edit(ModelMap model) {
        return "products/edit";
    }
    @PostMapping(value = "/edit")
    public String edit(@RequestParam("image") MultipartFile file, ModelMap model) {
        // Thư mục lưu file
        String pathFolder = "/uploads/";
        String path = context.getRealPath("/WEB-INF/") + pathFolder;
        File folder = new File(path);
        // Tạo thư mục nếu chưa có
        if (!folder.exists())
            folder.mkdir();
        // Lưu file
        if (!file.isEmpty()) {

//            Path fileUpload = (Path) Paths.get(path + file.getOriginalFilename()); // => /WEB-INF/uploads/abc.jpg
//            try {
//                Files.write((java.nio.file.Path) fileUpload, file.getBytes());
//                model.addAttribute("uploaded", pathFolder + file.getOriginalFilename());
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
        }
        return "products/edit";
    }
}
