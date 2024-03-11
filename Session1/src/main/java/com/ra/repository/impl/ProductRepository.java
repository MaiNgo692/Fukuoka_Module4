package com.ra.repository.impl;

import com.ra.entity.Account;
import com.ra.entity.Product;
import com.ra.util.FontColor;
import com.ra.util.MysqlConnect;
import com.ra.util.Table;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends Repository<Product,String>{
    public List<Product> findByKey(String name){
        List<Product> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst;
        ResultSet rs;
        try{
            conn = MysqlConnect.open();
            pst = conn.prepareStatement("SELECT * FROM products WHERE Product_Name LIKE ? OR Product_Id LIKE ? OR Manufacturer LIKE ?");
            pst.setObject(1,"%"+name+"%");
            pst.setObject(2,"%"+name+"%");
            pst.setObject(3,"%"+name+"%");
            rs = pst.executeQuery();
            Field[] fields = Product.class.getDeclaredFields();
            while (rs.next()){
                result.add(setField(Product.class,rs,fields));
            }
        }catch (Exception ex){
            System.out.println(FontColor.err("Tìm không thành công!"));
            System.out.println(FontColor.err(ex.getMessage()));
        }finally {
            MysqlConnect.close(conn);
        }
        return result;
    }
    public List<Product> findByKeyPageable(String name,int page,int pageSize){
        List<Product> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst;
        ResultSet rs;
        try{
            conn = MysqlConnect.open();
            pst = conn.prepareStatement("SELECT * FROM products WHERE Product_Name LIKE ? OR Product_Id LIKE ? OR Manufacturer LIKE ? ORDER BY Product_Id LIMIT ? OFFSET ?");
            pst.setObject(1,"%"+name+"%");
            pst.setObject(2,"%"+name+"%");
            pst.setObject(3,"%"+name+"%");
            pst.setObject(4,pageSize);
            pst.setObject(5,(page-1)*pageSize);

            rs = pst.executeQuery();
            Field[] fields = Product.class.getDeclaredFields();
            while (rs.next()){
                result.add(setField(Product.class,rs,fields));
            }
        }catch (Exception ex){
            System.out.println(FontColor.err("Tìm không thành công!"));
            System.out.println(FontColor.err(ex.getMessage()));
        }finally {
            MysqlConnect.close(conn);
        }
        return result;
    }
    public List<Product> findAllPageable(int page,int pageSize){
        List<Product> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst;
        ResultSet rs;
        try{
            conn = MysqlConnect.open();
            pst = conn.prepareStatement("SELECT * FROM products ORDER BY Product_Id LIMIT ? OFFSET ?");
            pst.setObject(1,pageSize);
            pst.setObject(2,(page-1)*pageSize);
            rs = pst.executeQuery();
            Field[] fields = Product.class.getDeclaredFields();
            while (rs.next()){
                result.add(setField(Product.class,rs,fields));
            }
        }catch (Exception ex){
            System.out.println(FontColor.err("Tìm không thành công!"));
            System.out.println(FontColor.err(ex.getMessage()));
        }finally {
            MysqlConnect.close(conn);
        }
        return result;
    }
}
