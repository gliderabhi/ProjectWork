package ankur.projectwork;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i= new Intent(getApplicationContext(),SplashScreen.class);
                startActivity(i);
            }

        }, 500);

    }
}
