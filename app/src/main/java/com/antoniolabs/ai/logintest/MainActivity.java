package com.antoniolabs.ai.logintest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText fullname, email, phone, username, password, cpassword;
    String fName, eMail, pHone, userName, pWord, cPassword;
    Button validateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        validateBtnClick();
    }

    private void init() {
        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);
        validateBtn = findViewById(R.id.validateBtn);
    }

    public void validateBtnClick(){
        validateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });
    }

    public void getEditTextInfo(){
        fName = fullname.getText().toString();
        eMail = email.getText().toString();
        pHone = phone.getText().toString();
        userName = username.getText().toString();
        pWord = password.getText().toString();
        cPassword = cpassword.getText().toString();
    }


    public void validateInput(){
        String regexName = "(([A-Z][a-z]+) ([A-Z][a-z]+))";
        String regexEmail = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        String regexPhoneNumber = "[0][0-9]+$";
        String regexUserName= "[a-z]+[0-9]+";
        String regexPassword= "^([A-Za-z0-9]+)$";
        String regexPassword1 = "\\d";
        String regexPassword2 = "[A-Z]";

        Pattern fullnamePattern, emailPattern, phonePattern, usernamePattern, passwordPattern, passwordPattern1, passwordPattern2, cpasswordPattern;
        Matcher fullnameMatcher, emailMatcher, phoneMatcher, usernameMatcher, passwordMatcher, passwordMatcher1, passwordMatcher2, cpasswordMatcher;

        getEditTextInfo();

        fullnamePattern = Pattern.compile(regexName);
        emailPattern = Pattern.compile(regexEmail);
        phonePattern = Pattern.compile(regexPhoneNumber);
        usernamePattern = Pattern.compile(regexUserName);
        passwordPattern = Pattern.compile(regexPassword);
        passwordPattern1 = Pattern.compile(regexPassword1);
        passwordPattern2 = Pattern.compile(regexPassword2);
        cpasswordPattern = Pattern.compile(pWord);

        fullnameMatcher = fullnamePattern.matcher(fName);
        emailMatcher = emailPattern.matcher(eMail);
        phoneMatcher = phonePattern.matcher(pHone);
        usernameMatcher = usernamePattern.matcher(userName);
        passwordMatcher = passwordPattern.matcher(pWord);
        passwordMatcher1 = passwordPattern1.matcher(pWord);
        passwordMatcher2 = passwordPattern2.matcher(pWord);
        cpasswordMatcher = cpasswordPattern.matcher(cPassword);

        if (fullnameMatcher.find()){
            fullname.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
        }
        else fullname.setBackgroundColor(getResources().getColor(R.color.colorError));

        if (emailMatcher.matches()){
            email.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
        }
        else email.setBackgroundColor(getResources().getColor(R.color.colorError));

        if (pHone.length() == 10 && phoneMatcher.matches()){
            phone.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
        }
        else phone.setBackgroundColor(getResources().getColor(R.color.colorError));

        if (usernameMatcher.find()){
            username.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
        }
        else username.setBackgroundColor(getResources().getColor(R.color.colorError));

        if (pWord.length() > 5 && passwordMatcher.find() && passwordMatcher1.find() && passwordMatcher2.find()){
            password.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
        }
        else password.setBackgroundColor(getResources().getColor(R.color.colorError));

        if (cpasswordMatcher.matches()){
            cpassword.setBackgroundColor(getResources().getColor(R.color.colorCorrect));
        }
        else cpassword.setBackgroundColor(getResources().getColor(R.color.colorError));
    }




}
