package yosman.dhar.stonybrook.edu.famfityosmanv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //creating variables for the buttons/textviews/etc
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigns variables for specific button
        Name= (EditText)findViewById(R.id.etname);
        Password= (EditText)findViewById(R.id.etpassword);
        Info = (TextView)findViewById(R.id.tvinfo);
        Login= (Button)findViewById(R.id.btlogin);

        //make buttons clickable
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }
    //function to ensure the login/logout is correct
    private void validate(String username, String userpassword){
        if ((username.equals("Yosman")) && (userpassword.equals("1234"))) {
            Intent intent = new Intent(MainActivity.this, Main3Activity.class);
            startActivity(intent);
        } else {
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter ==0){
                Login.setEnabled(false);
            }
        }
    }
}
