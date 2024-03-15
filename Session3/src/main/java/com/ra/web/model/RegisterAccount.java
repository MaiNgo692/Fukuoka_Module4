package com.ra.web.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

public class RegisterAccount {
    @NotEmpty(message = "Tài khoản không được bỏ trống!")
    @Size(min = 6,max = 12,message = "Độ dài từ 6 đến 12 ký tự!")
    private String user;
    @NotEmpty(message = "Mật khẩu không được bỏ trống!")
    @Size(min = 8,max = 12,message = "Độ dài từ 8 đến 12 ký tự!")
    private String password;
    @NotEmpty(message = "Số điện thoại không được bỏ trống!")
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\b")
    private String phone;
    @NotEmpty(message = "Ngày sinh không được bỏ trống!")
    private LocalDate birthday;
    public String getUser() {
        return user;
    }

    public void setUser(String userName) {
        this.user = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
