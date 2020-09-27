package com.example.labpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*public class RegistrationActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText editusername;
    EditText editpassword;
    EditText editFirst_Name;
    EditText editSurname;
    EditText editemail;
    EditText editpasswordconfirm;
    Button btnAddData;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mydb = new DatabaseHelper(this);

        setContentView(R.layout.activity_registration);
        editusername = (EditText) findViewById(R.id.editusername);
        editpassword = (EditText) findViewById(R.id.editPassword);
        editFirst_Name = (EditText) findViewById(R.id.editFirst_Name);
        editSurname = (EditText) findViewById(R.id.editSurname);
        editemail = (EditText) findViewById(R.id.editemail);
        btnAddData = (Button) findViewById(R.id.btnAddData);
        editpasswordconfirm = (EditText) findViewById(R.id.editpasswordconfirm);
        AddData();
        String edtusername = editusername.getText().toString();
        String edtpassword = editpassword.getText().toString();
        String edtfirstname = editFirst_Name.getText().toString();
        String edtsurname = editSurname.getText().toString();
        // confirm password filed to be added and be ...herr
        String edtpassconfirm = editpasswordconfirm.getText().toString();
        String edtemail = editemail.getText().toString();
        // checking if a username entered already exists



    }

    public void AddData() {
       btnAddData.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       boolean isInserted= mydb.insertData(editusername.getText().toString(),editpassword.getText().toString(),editFirst_Name.getText().toString(),editSurname.getText().toString());
                       if (isInserted == true)
                           Toast.makeText(RegistrationActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                       else if (isInserted == false)
                           Toast.makeText(RegistrationActivity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();

                   }
               }
       );

    }
}

/*
   btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edtusername = editusername.getText().toString();
                String edtpassword = editpassword.getText().toString();
                String edtfirstname = editFirst_Name.getText().toString();
                String edtsurname = editSurname.getText().toString();
                String edtpassconfirm = editpasswordconfirm.getText().toString();
                String edtemail = editemail.getText().toString();
               // boolean checkusernameexixtence = mydb.checkusernameexixtence(edtusername);
                /*if (edtpassword.equals(edtpassconfirm) || edtusername.length() >= 4 || edtsurname.length() >= 2 || edtpassword.length() >= 4 || checkusernameexixtence == false) {
                    btnAddData.setEnabled(true);

                } else if (edtpassword.equals(edtpassconfirm) || edtusername.length() >= 4 || edtsurname.length() >= 2 || edtpassword.length() >= 4 || checkusernameexixtence == true) {
                    Toast.makeText(getApplicationContext(), "Username exists already", Toast.LENGTH_LONG);
                    btnAddData.setEnabled(false);
                }*/


   /* boolean isInserted = mydb.insertData(editusername.getText().toString(),
            editpassword.getText().toString(),
            editFirst_Name.getText().toString(),
            editSurname.getText().toString());

                if (isInserted == true)
                        Toast.makeText(RegistrationActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        else if (isInserted == false)
                        Toast.makeText(RegistrationActivity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();


                        }
                        });*/

