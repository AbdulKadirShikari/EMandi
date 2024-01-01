package com.example.emandi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Login extends AppCompatActivity {


    TextView login;
    EditText username,mobile,password,confirmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        username = findViewById(R.id.log_username);
        mobile = findViewById(R.id.log_usermobile);
        password = findViewById(R.id.log_userpass);
        confirmpass = findViewById(R.id.log_userconfirmPass);

        login = findViewById(R.id.loginbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Vname = username.getText().toString();
                String Vmobile = mobile.getText().toString();
                String Vpass = password.getText().toString();
                String Vconfirmpass = confirmpass.getText().toString();

                if(TextUtils.isEmpty(Vname)){
                    username.findFocus();
                    username.setError("Please Enter Name");
                }
                else if(TextUtils.isEmpty(Vmobile)){
                    mobile.findFocus();
                    mobile.setError("Please Enter Mobile Number");
                }
                else if(TextUtils.isEmpty(Vpass)){
                    password.findFocus();
                    password.setError("Please Enter Password");
                }
                else if(TextUtils.isEmpty(Vconfirmpass)){
                    confirmpass.findFocus();
                    confirmpass.setError("Please Enter Confirm Password");
                }
                else if(! Vpass.equals(Vconfirmpass)){
                    confirmpass.findFocus();
                    confirmpass.setError("Password & Confirm password not match");
                    password.setError("Please Enter Confirm Password");
                }

                else{
                    //insetdata();
                    Intent intent = new Intent(Login.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }





            }
        });
    }

    private void insetdata() {

       // UserModel userModel = new UserModel();
      /*  userModel.setUserPhone(mobile.getText().toString());
        userModel.setUserName(username.getText().toString());
        userModel.setUserPassword(password.getText().toString());*/
       // UserDataHelper.getInstance().insertData(userModel);

        Intent intent = new Intent(Login.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
