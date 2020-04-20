package com.example.food_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.food_app.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.jar.Attributes;

public class SignUp extends AppCompatActivity {

    EditText username,password,Community,Phone_no,Email;
    Button bnSignup,bnuser,bndelivery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        Community = (EditText)findViewById(R.id.community);
        Phone_no = (EditText)findViewById(R.id.phone_no);
        Email = (EditText)findViewById(R.id.email);

        bnSignup = (Button)findViewById(R.id.bnSignup);

        //Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        bnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //check if user name already exists
                        if(dataSnapshot.child(username.getText().toString()).exists()){
                            mDialog.dismiss();
                            User user = dataSnapshot.child(username.getText().toString()).getValue(User.class);
                            Toast.makeText(SignUp.this,"username already registered",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            mDialog.dismiss();
                            User user = new User(password.getText().toString(),Community.getText().toString(),Phone_no.getText().toString(),Email.getText().toString());
                            table_user.child(username.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this,"SignUp successfull!",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
