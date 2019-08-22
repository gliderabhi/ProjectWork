package ankur.projectwork;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PRofileRegistration extends AppCompatActivity {

     FirebaseUser user;
     FirebaseAuth mAuth;
     EditText email,pass,confPass;
     String mail,password,conf_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_registration);
       mAuth= FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        user=mAuth.getCurrentUser();
        if(user==null){
            initialise();
        }
    }

    public void initialise(){
        email=(EditText)findViewById(R.id.USernameReg);
        pass=(EditText)findViewById(R.id.passwordText);
        confPass=(EditText)findViewById(R.id.passwordREg2);

        mail=email.getText().toString();
        password=pass.getText().toString();
        conf_pass=confPass.getText().toString();

        mAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("msg","Created user ");
                    FirebaseUser user= mAuth.getCurrentUser();

                }else{
                    Toast.makeText(getApplicationContext(),"Fialed to sign up ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
