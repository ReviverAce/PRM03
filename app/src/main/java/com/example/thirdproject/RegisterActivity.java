package com.example.thirdproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    User user;
    EditText nick;
    EditText email;
    EditText password1;
    EditText password2;
    TextView enick;
    TextView eemail;
    TextView epassword1;
    TextView epassword2;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nick =(EditText) findViewById(R.id.nickEditText);
        email =(EditText) findViewById(R.id.emailEditText);
        password1 =(EditText) findViewById(R.id.password1EditText);
        password2 =(EditText) findViewById(R.id.password2EditText);
        enick =(TextView) findViewById(R.id.enickTextView);
        eemail =(TextView)findViewById(R.id.eemailTextView);
        epassword1 =(TextView)findViewById(R.id.epassword1TextView);
        epassword2 =(TextView)findViewById(R.id.epassword2TextView);
        Button register =(Button)findViewById(R.id.registerButton);

//        mAuth=FirebaseAuth.getInstance();



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag=true;

                if(nick.getText().toString().length()<4){
                    flag=false;
                    enick.setText("Nick is too short");
                }else{
                    enick.setText("");
                }

                if(!email.getText().toString().contains("@") && !email.getText().toString().contains(".com")){
                    flag=false;
                    eemail.setText("Email is not valid");
                }else{
                    eemail.setText("");
                }

                if(password1.getText().toString().length()<8){
                    flag=false;
                    epassword1.setText("Password is too short");
                }else{
                    epassword1.setText("");
                }

                if(!password2.getText().toString().equals(password1.getText().toString())){
                    flag=false;
                    epassword2.setText("Passwords are not the same");
                }else{
                    epassword2.setText("");
                }

                if(flag){
                    Toast.makeText(RegisterActivity.this,"Registration succesfull",Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
}
