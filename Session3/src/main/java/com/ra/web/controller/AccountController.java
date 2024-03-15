package com.ra.web.controller;

import com.ra.web.model.RegisterAccount;
import com.ra.web.model.StorageDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Controller
@RequestMapping("/register")
public class AccountController {
    /**
     * Form đăng ký tài khoản
     * @return
     */
    @GetMapping
    public String register(Model model) {
        RegisterAccount acc = new RegisterAccount();
        model.addAttribute("acc",acc);
        return "register/register";
    }

    /**
     * Đăng ký tài khoản người dùng gồm các thông tin:
     *  username: Không bỏ trống, 6-12 kí tự
     *  password: Không bỏ trống, 8-12 kí tự
     *  phone: Không bỏ trống, đúng định dạng SĐT Việt Nam
     *  birthday: Không bỏ trống, phải trên 18 tuổi
     * @param modelMap
     * @return
     */
    @PostMapping
    public String register(@Valid @ModelAttribute("acc") RegisterAccount acc, @RequestParam("repass")String repass, BindingResult bindingResult, ModelMap modelMap) {
        if (!Objects.equals(acc.getPassword(), repass)) {
            bindingResult.addError(new FieldError("acc", "password", "Mật khẩu nhập lại không trùng nhau!"));
        }
        long isExistUser=StorageDatabase.accounts.stream().filter(account -> account.getUser().equals(acc.getUser())).count();
        if(isExistUser!=0){
            bindingResult.addError(new FieldError("acc", "user", "Đã tồn tại tài khoản này!"));
        }
        int age = Period.between(acc.getBirthday(), LocalDate.now()).getYears();
        if(age< 18){
            bindingResult.addError(new FieldError("acc", "birthday", "Bạn không đủ 18 tuổi!"));
        }
        if (bindingResult.hasErrors()) {
            return "register/register";
        }
        RegisterAccount account = new RegisterAccount();
        account.setUser(acc.getUser());
        account.setPassword(acc.getPassword());
        account.setBirthday(acc.getBirthday());
        account.setPhone(acc.getPhone());
        StorageDatabase.accounts.add(account);
        return "home/login";
    }
}
