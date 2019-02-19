package yosman.dhar.stonybrook.edu.famfityosmanv1;

import android.content.Intent;
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

public class Main2Activity extends AppCompatActivity {

    //defines variables
    //alt enter to import in
    private EditText retusername, retpassword, retuseremail;
    private Button rbtnregister;
    private TextView rtvgoback;
    private FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupUIViews();

        firebaseAuth= FirebaseAuth.getInstance();

        rbtnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()){
                    //if all entries are in then access data base
                    String user_email = retuseremail.getText().toString().trim();
                    String user_password= retpassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Main2Activity.this,"Registration Successful", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(Main2Activity.this,"Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
            }
        });
        rbtnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });


    }

    private void setupUIViews(){
        retusername=(EditText)findViewById(R.id.retusername);
        retpassword= (EditText)findViewById(R.id.retpassword);
        retuseremail= (EditText)findViewById(R.id.retuseremail);
        rbtnregister= (Button)findViewById(R.id.rbtnregister);
        rtvgoback= (TextView)findViewById(R.id.rtvgoback);

    }

    // basically if something is empty it'll tell you to fill all fields in
    private Boolean validate(){
        Boolean result = false;

        String name= retusername.getText().toString();
        String password = retpassword.getText().toString();
        String email = retuseremail.getText().toString();

        if (name.isEmpty()&& password.isEmpty()&&email.isEmpty()) {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        } else{
            result = true;
                    }

                    return result;

    }
}
