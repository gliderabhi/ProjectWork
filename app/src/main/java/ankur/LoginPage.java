package ankur.projectwork;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page2);
       // EditText email=(EditText)findViewById(R.id.USernameText);
        TextView text=(TextView)findViewById(R.id.EmailID);
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null) {
            if (user.getDisplayName()!=null) {
                   text.setText(user.getDisplayName());
            }else{
                Toast.makeText(getApplicationContext(),"Error ",Toast.LENGTH_LONG).show();

                Intent i =new Intent(getApplicationContext(),SplashScreen.class);
                startActivity(i);
            }
        }else{
            Intent i =new Intent(getApplicationContext(),SplashScreen.class);
            startActivity(i);
        }
        EditText pass=(EditText)findViewById(R.id.passwordText);
        Button btn= (Button) findViewById(R.id.LOginBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    Intent i=new Intent(getApplicationContext(),TagLocation.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please enter the valid email ", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button  Singup_btn= (Button)findViewById(R.id.LoginBtn);
        Singup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
                Intent i =new Intent(getApplicationContext(),SplashScreen.class);
                startActivity(i);
            }
        });

    }
    public void signOut(){
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent i=new Intent(getApplicationContext(),SplashScreen.class);
                        startActivity(i);
                    }
                });
    }

}
