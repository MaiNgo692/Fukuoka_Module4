package com.ra.repository.impl;

import com.ra.entity.Category;
import com.ra.util.*;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.Arrays;

public class CategoryRepository extends Repository<Category,Integer>{
    public Category findByName(String key){
        Connection conn = null;
        PreparedStatement pst;
        ResultSet rs;
        try{
            conn = MysqlConnect.open();
            Field[]fields =Category.class.getDeclaredFields();
            String sql = MessageFormat.format("SELECT * FROM {0} WHERE {1} = ?", Category.class.getAnnotation(Table.class).name(), "categoryNam");
            pst =conn.prepareStatement(sql);
            pst.setObject(1,key);
            rs = pst.executeQuery();
            while (rs.next()){
                return setField(Category.class,rs,fields);
            }
        }catch (Exception ex){
            System.out.println(FontColor.err("Tìm không thành công!"));
            System.out.println(FontColor.err(ex.getMessage()));
        }finally {
            MysqlConnect.close(conn);
        }
        return null;
    }
}
