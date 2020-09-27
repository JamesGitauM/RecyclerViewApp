package com.example.labpro;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    EditText mTextusername;
    EditText mTextpassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    TextView terms2;
    DatabaseHelper mydb;
    //swipe fucntionalities
   float x1, x2, y1, y2;
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1<x2){
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }else if(x1 > x2){
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
            break;
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //calling create db method from database helper class constructor
        mydb=new DatabaseHelper(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       getSupportActionBar().hide();
        final String loginmsg="Welcome Daktari wa Udongo";

       // mTextusername=(EditText)findViewById(R.id.txt_username);
       // mTextpassword=(EditText)findViewById(R.id.txt_password);
       /// mButtonLogin=(Button)findViewById(R.id.btn_login);
       // mTextViewRegister=(TextView)findViewById(R.id.lbl_register);
       /* mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vm) {
                Toast.makeText(getApplicationContext(),loginmsg,Toast.LENGTH_LONG).show();
               //Intent gotomainmenu=new Intent(getApplicationContext(),homemenu.class);
               //startActivity(gotomainmenu);
               Intent gototestactivity=new Intent(getApplicationContext(),LoginActivity.class);
               startActivity(gototestactivity);
            }
        });
        //Intent movetoregintent=new Intent(getApplicationContext(),RegistrationActivity.class);
        //startActivity(movetoregintent);

        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movetoregintent=new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(movetoregintent);

            }
        });*/


    }

    public static class InputValidation {
        private Context context;
        /**
         * constructor
         *
         * @param context
         */
        public InputValidation(Context context) {
            this.context = context;
        }

        /**
         * method to check InputEditText filled .
         *
         * @param textInputEditText
         * @param textInputLayout
         * @param message
         * @return
         */
        public boolean isInputEditTextFilled(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message) {
            String value = textInputEditText.getText().toString().trim();
            if (value.isEmpty()) {
                textInputLayout.setError(message);
                hideKeyboardFrom(textInputEditText);
                return false;
            } else {
                textInputLayout.setErrorEnabled(false);
            }

            return true;
        }


        /**
         * method to check InputEditText has valid email .
         *
         * @param textInputEditText
         * @param textInputLayout
         * @param message
         * @return
         */
        public boolean isInputEditTextEmail(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message) {
            String value = textInputEditText.getText().toString().trim();
            if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
                textInputLayout.setError(message);
                hideKeyboardFrom(textInputEditText);
                return false;
            } else {
                textInputLayout.setErrorEnabled(false);
            }
            return true;
        }

        public boolean isInputEditTextMatches(TextInputEditText textInputEditText1, TextInputEditText textInputEditText2, TextInputLayout textInputLayout, String message) {
            String value1 = textInputEditText1.getText().toString().trim();
            String value2 = textInputEditText2.getText().toString().trim();
            if (!value1.contentEquals(value2)) {
                textInputLayout.setError(message);
                hideKeyboardFrom(textInputEditText2);
                return false;
            } else {
                textInputLayout.setErrorEnabled(false);
            }
            return true;
        }

        /**
         * method to Hide keyboard
         *
         * @param view
         */
        private void hideKeyboardFrom(View view) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }
    }
}
