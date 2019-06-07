package com.example.thirdproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    EditText email;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText)findViewById(R.id.emailEditText);
        final EditText password = (EditText)findViewById(R.id.password1EditText);
        Button login = (Button) findViewById(R.id.loginButton);
        final TextView error =(TextView) findViewById(R.id.errorTextView);
        TextView register =(TextView) findViewById(R.id.registerTextView);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(email.getText()!=null && password.getText()!=null){
                    if(email.getText().toString().equals("root") && password.getText().toString().equals("toor")){
                        Intent intent = new Intent(getBaseContext(),ArticleActivity.class);
                        startActivity(intent);
                        error.setText("");
                    }else{
                        error.setText("Incorrect email or password");
                    }
//                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
