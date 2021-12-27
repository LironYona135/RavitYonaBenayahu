package com.example.belove.ui.loginRegister.register;

import androidx.lifecycle.ViewModel;


public class RegisterViewModel extends ViewModel {

    //for email validation
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    //validates all of the inputs, returns int to fragment to show error if there is one
    public int performAuth(String inputEmail, String inputPassword, String inputConfirmPassword) {

        if (!inputEmail.matches(emailPattern)) {
            //1 is email error
            return 1;
        } else if (inputPassword.isEmpty() || inputPassword.length() < 6) {
            //2 is password error
            return 2;
        } else if (!inputPassword.equals(inputConfirmPassword)) {
            //3 is confirm password doesn't match the password
            return 3;
        }
        //0 is all is ok
        return 0;
    }
}