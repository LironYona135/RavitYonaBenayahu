package com.example.belove.ui.loginRegister.login;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {


    //for email validation
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public int performLogin(String inputEmail, String inputPassword) {

        if (!inputEmail.matches(emailPattern)) {
            //1 is email error
            return 1;
        } else if (inputPassword.isEmpty() || inputPassword.length() < 6) {
            //2 is password error
            return 2;
        }
        //0 is all is ok
        return 0;
    }
}
