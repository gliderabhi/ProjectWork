package ankur.projectwork;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.pow;


public class TagLocation extends AppCompatActivity {


    Button btn,proceed,tagLocation;
    Spinner Cities;
    WebView webView;
    EditText mag;
    double lat,lng;
    TextView spinText,earthText;
    double ZoneValue,Mw;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_location);
        btn = (Button) findViewById(R.id.fab);
        Cities = (Spinner) findViewById(R.id.LocationSelector);
        proceed=(Button)findViewById(R.id.ProceedBtn);
        tagLocation=(Button)findViewById(R.id.fab);
        spinText=(TextView)findViewById(R.id.SpinnerText) ;
        earthText=(TextView)findViewById(R.id.MagnitudeEarthquake) ;
        mag=(EditText)findViewById(R.id.Magnitude);

        //hide the other option ot enter manually

         sharedPreferences=getSharedPreferences(Constants.PACKAGE_NAME,Context.MODE_PRIVATE);
/*
         String x=sharedPreferences.getString(Constants.VIEW,Constants.v);

        Toast.makeText(getApplicationContext(),x,Toast.LENGTH_LONG).show();
         if(x.matches(Constants.in)){
             spinText.setVisibility(View.INVISIBLE);
             Cities.setVisibility(View.INVISIBLE);
             earthText.setVisibility(View.INVISIBLE);
             mag.setVisibility(View.INVISIBLE);
         }
         else{
             spinText.setVisibility(View.VISIBLE);
             Cities.setVisibility(View.VISIBLE);
             earthText.setVisibility(View.VISIBLE);
             mag.setVisibility(View.VISIBLE);

         }
         */
        tagLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);

            }
        });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mag.getText().toString().matches("")){
                      Mw=5.9;
                }else {
                     Mw = Double.parseDouble(mag.getText().toString());
                }
                 lng= Double.parseDouble(sharedPreferences.getString(Constants.KEY_LONGITUDE,""));
                 lat= Double.parseDouble(sharedPreferences.getString(Constants.KEY_LATITUDE,""));
                 editor=sharedPreferences.edit();

               // Toast.makeText(getApplicationContext(),String.valueOf(lat),Toast.LENGTH_LONG).show();
                 getAmax();
                 editor.putString(Constants.ZOneValue,String.valueOf(ZoneValue));
                editor.putString(Constants.KEY_MW,String.valueOf(Mw));
                 editor.commit();

                Intent i=new Intent(getApplicationContext(),SelectionPanel.class);
                startActivity(i);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Constants.DATA_CITIES);
//set the spinners adapter to the previously created one.
        Cities.setAdapter(adapter);

        Cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String zoneValue = Constants.DATA_CITIES_ZONES[position];
                ZoneValue = Double.parseDouble(zoneValue);
                editor=sharedPreferences.edit();
                editor.putString(Constants.ZOneValue,String.valueOf(ZoneValue));
                editor.putString(Constants.KEY_MW,String.valueOf(Mw));
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    Toast.makeText(getApplicationContext(),"None selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    ArrayList<Double> dist=new ArrayList<>();
    private void getAmax() {
        ProgressDialog dialog = ProgressDialog.show(TagLocation.this, "",
                "Loading. Please wait...", true);
         dialog.create();
        for(int i=0 ; i<108 ;i++){
            double theta1, delta, lambda1, a ,c ,d, R;
            R=6371;
            theta1=convertRad(Double.parseDouble(Constants.DATA_CITY_LAT[i]));
            lambda1=convertRad(Double.parseDouble(Constants.DATA_CITY_LNG[i]));

            a= pow(Math.sin((theta1-(convertRad(lat)))/2),2) + cos(theta1)*cos(convertRad(lat))*
                    pow(Math.sin((lambda1-(convertRad(lng)))/2),2);
            c= 2 * atan2(pow(a,0.5), pow((1-a),0.5));
            d=R*c;
            dist.add(d);

        }
        double p=1000000;
        int k=0;
        for (int i =0; i<108 ; i++){
            Log.d("msg",String.valueOf(dist.get(i)));
            if(p>dist.get(i)){
               p=dist.get(i);
               k=i;
            }
        }

        Log.d("msg",String.valueOf(p));
        Log.d("msg",String.valueOf(k));
        ZoneValue=Double.parseDouble(Constants.DATA_CITIES_ZONES[k]);
        Log.d("msg", Constants.DATA_CITIES_ZONES[k+1]);
        dialog.dismiss();
    }
    public double convertRad( double angle){
        return (3.147/180)*angle;
    }

    public boolean isServices(){
        int av= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(TagLocation.this);
        if(av == ConnectionResult.SUCCESS){
            return  true;
        }else if(GoogleApiAvailability.getInstance().isUserResolvableError(av)){
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(TagLocation.this,av,9001);
            dialog.show();
        } else {
            Toast.makeText(this,"Cnat do anything  SORRY ", Toast.LENGTH_LONG).show();
        }
      return  false;
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

    boolean doubleBackToExitPressedOnce =false;

    @Override
    public void onBackPressed() {
        /*if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        if(doubleBackToExitPressedOnce){
            closeApplication();
        }
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
        */

    }

    public void getLocation(View v){

        Intent i=new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(i);
    }
    public void closeApplication() {
        finish();
        moveTaskToBack(true);
    }
}







