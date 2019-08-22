package ankur.projectwork;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class SelectionPanel extends AppCompatActivity {

     public ImageView SPTBtn,CPTBtn;
    public TextView CPT,SPT;
    public Spinner LocationSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_panel);

    }
    public void SPTTEstResult(View v){
        Intent i=new Intent(getApplicationContext(),DataRequirement.class) ;
        startActivity(i);
        //Toast.makeText(getApplicationContext(),"SPt CLicked ", Toast.LENGTH_SHORT).show();
    }

    public void CPTTEstResult(View v){
        Intent i=new Intent(getApplicationContext(),DataRequirementCPT.class) ;
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.actionSettings : signOut();break;
            case R.id.aboutUs:

                Intent i= new Intent(getApplicationContext(),AboutUS.class);
                startActivity(i);break;

                case R.id.ExitApp:
                closeApplication();
        }
        return  super.onOptionsItemSelected(item);
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

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), TagLocation.class);
        startActivity(i);
    }

    public void closeApplication() {
        finish();
        moveTaskToBack(true);
    }
}
