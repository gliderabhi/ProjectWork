package ankur.projectwork;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

import static ankur.projectwork.Constants.InputData;

public class DataRequirement extends Activity {

   RelativeLayout data,data1,data2,data3,data4,data5,data6,data7,data8,data9;
    EditText Spt,DepthExc,Gravel,Sand,Silt,Clay,UnitWt,Phi,C,WAterDepth;
    double spt,depthex,gravel,sand,clay,silt,unitWt,c,phi,waterDepth,densityRatio;
     Calculations calculations;
    Spinner soilDr;
   Button yes,no;
//   SessionManager s=new SessionManager(getApplicationContext());

    SPT_test_Class SPTData;
    CPT_test_Class cpt;
    ArrayList<SPT_test_Class> SpT;
    ArrayList<CPT_test_Class> cPT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_requirement);
        SPTData=new SPT_test_Class();
        cpt=new CPT_test_Class();
        CreateArrayData();
        FieldInitiation();

     }

    private void CreateArrayData() {
       SpT=new ArrayList<>();
       cPT=new ArrayList<>();
    }

    private void FieldInitiation(){
         Spt=(EditText)findViewById(R.id.SptValue);Spt.setText("");
         DepthExc=(EditText)findViewById(R.id.depthCPT);DepthExc.setText("");
         Gravel=(EditText)findViewById(R.id.GravelDistribution);Gravel.setText("");
         Sand=(EditText)findViewById(R.id.SandDistribution);Sand.setText("");
         Silt=(EditText)findViewById(R.id.SiltDistribution);Silt.setText("");
         Clay=(EditText)findViewById(R.id.ClayDistribution);Clay.setText("");
         UnitWt=(EditText)findViewById(R.id.unitWtvalue);UnitWt.setText("");
         WAterDepth=(EditText)findViewById(R.id.WaterTableValue);WAterDepth.setText("");
         soilDr=(Spinner)findViewById(R.id.SoilDr);

         yes=(Button)findViewById(R.id.ConfirmMoreData);
         no=(Button)findViewById(R.id.NoData);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Constants.DATA_Soil_Density);
        soilDr.setAdapter(adapter);
        soilDr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    densityRatio = 0.8;
                } else {
                    if (position == 1) {
                        densityRatio = 0.7;
                    } else{
                        if(position==2){
                            densityRatio=0.6;
                        }
                    }

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"NOne selected", Toast.LENGTH_SHORT).show();
            }

        });

         yes.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 getData();
                 FieldInitiation();
             }
         });

         no.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 getData();
                 Intent i= new Intent(getApplicationContext(),Output.class);
                 i.putExtra("CPT",cPT);
                 i.putExtra("SPT",SpT);
                 startActivity(i);


             }
         });

     }

     private void getData() {

         spt = depthex = gravel = sand = clay = silt = unitWt = c = phi = waterDepth = 0;
         int i = 0;
         if (Spt.getText().toString().matches("")) {
             i++;
         }

         if (DepthExc.getText().toString().matches("")) {
             i++;
         }

         if (Gravel.getText().toString().matches("")) {
             i++;
         }

         if (Sand.getText().toString().matches("")) {
             i++;
         }
         if (Silt.getText().toString().matches("")) {
             i++;
         }
         if (UnitWt.getText().toString().matches("")) {
             i++;
         }

         if (WAterDepth.getText().toString().matches("")) {
             i++;
         }
         if (Clay.getText().toString().matches("")) {
             i++;
         }
         if (i > 0) {
             Toast.makeText(getApplicationContext(), "Please fill all the information to proceed", Toast.LENGTH_SHORT).show();
         } else if (i == 0) {

             spt = Double.parseDouble(Spt.getText().toString());
             depthex = Double.parseDouble(DepthExc.getText().toString());

             gravel = Double.parseDouble(Gravel.getText().toString());
             sand = Double.parseDouble(Sand.getText().toString());
             clay = Double.parseDouble(Clay.getText().toString());
             silt = Double.parseDouble(Silt.getText().toString());
             unitWt = Double.parseDouble(UnitWt.getText().toString());
             waterDepth = Double.parseDouble(WAterDepth.getText().toString());

             String testType="SPT";

            SPTData.setSpt(spt);
            SPTData.setGravel(gravel);
            SPTData.setClay(clay);
            SPTData.setSilt(silt);
            SPTData.setUnitWt(unitWt);
            SPTData.setWaterDepth(waterDepth);
            SPTData.setDepthex(depthex);
            SPTData.setTestType(testType);
           /* SPTData.setMw(Double.parseDouble(s.getDetails().get("KEY_MW")));
            SPTData.setAmaxG(Double.parseDouble(s.getDetails().get("KEY_AMAXG")));
*/
             calculations= new Calculations(getApplicationContext(),cpt,SPTData);

             SpT.add(calculations.returnSPT());


             //calculations=new Calculations( depthex, spt, gravel,  sand, silt, clay, unitWt, waterDepth, densityRatio,testType,tip,friction,soilTypeCPT);

             FieldInitiation();
        i=0;
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