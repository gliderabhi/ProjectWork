package ankur.projectwork;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Output extends AppCompatActivity {

    TextView c1,c2,c3,c4,c5,c6,c7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        c1=(TextView)findViewById(R.id.data1);
        c2=(TextView)findViewById(R.id.data2);
        c3=(TextView)findViewById(R.id.data3);
        c4=(TextView)findViewById(R.id.data4);
        c5=(TextView)findViewById(R.id.data5);
        c6=(TextView)findViewById(R.id.data6);
        c7=(TextView)findViewById(R.id.data7);

        ArrayList<CPT_test_Class> cpt = (ArrayList<CPT_test_Class>) getIntent().getSerializableExtra("CPT");
        ArrayList<SPT_test_Class> spt = (ArrayList<SPT_test_Class>) getIntent().getSerializableExtra("SPT");
       ListView lst=(ListView)findViewById(R.id.list) ;
       if (cpt.size() == 0) {
            c1.setText(R.string.depth);
            c2.setText(R.string.waterDepth);
           c3.setText(R.string.N160CS);
           c4.setText(R.string.CSR);
           c5.setText(R.string.CRR);
           c6.setText(R.string.FS);
           c7.setText(R.string.Liq);

           AdapterSPT adapter=new AdapterSPT(spt,getApplicationContext());
            lst.setAdapter(adapter);
        } else if (spt.size() == 0) {
           c1.setText(R.string.depth);
           c2.setText(R.string.Fric);
           c3.setText(R.string.Tip);
           c4.setText(R.string.CSR);
           c5.setText(R.string.CRR);
           c6.setText(R.string.FS);
           c7.setText(R.string.Liq);
          Adapter adapter= new Adapter(cpt,getApplicationContext());
          lst.setAdapter(adapter);
        }
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
                Toast.makeText(getApplicationContext(),"Developer Abhishekh : Project : Ankur  : Mentor  : Supriya Mohanty ",Toast.LENGTH_LONG).show();break;
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
    public void closeApplication() {
        finish();
        moveTaskToBack(true);
    }


    @Override
    public void onBackPressed() {
        Intent i=new Intent(getApplicationContext(),SplashScreen.class);
        startActivity(i);
    }
}