package ankur.projectwork;

import android.content.Intent;
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
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class DataRequirementCPT extends AppCompatActivity {

    EditText tip,friction,Depth,waterDepth,unitWt,kSlope;
    Button yes,no;
    Spinner soilType, soilDr;
    String soil_type;
    ArrayList<Double> depth,UniWt,WaterDpth,CSR,CRR,qc1n,qc1ncs,Fs,Tip,Friction;
    ArrayList<String> liquidifiaction;
    Calculations calculations;
   double densityRatio;
    CPT_test_Class cpt;
    SPT_test_Class spt;
    ArrayList<CPT_test_Class> CPT;
    ArrayList<SPT_test_Class> SPT;
   // SessionManager s=new SessionManager(getApplicationContext());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_requirement_cpt);

        layoutInittiation();
        CreateArrayData();

    }

    private void CreateArrayData() {
        depth=new ArrayList<>();
        UniWt=new ArrayList<>();
        WaterDpth=new ArrayList<>();
        CSR=new ArrayList<>();
        CRR=new ArrayList<>();
        Fs=new ArrayList<>();
        liquidifiaction=new ArrayList<>();
        Friction=new ArrayList<>();
        Tip=new ArrayList<>();

        CPT=new ArrayList<>();
        SPT=new ArrayList<>();

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    getData();
                   Intent i= new Intent(getApplicationContext(),Output.class);
                   i.putExtra("CPT",CPT);
                   i.putExtra("SPT",SPT);
                   startActivity(i);


            }
        });
    }

    private void layoutInittiation() {
        tip=(EditText)findViewById(R.id.tipResistance);tip.setText("");
        Depth=(EditText)findViewById(R.id.depthCPT);Depth.setText("");
        waterDepth=(EditText)findViewById(R.id.WaterTableValue);waterDepth.setText("");
        friction=(EditText)findViewById(R.id.frictionResistance);friction.setText("");
        unitWt=(EditText)findViewById(R.id.unitWtvalue);unitWt.setText("");
        kSlope=(EditText) findViewById(R.id.KSLope);kSlope.setText("");
        yes=(Button)findViewById(R.id.ConfirmMoreData);


        no=(Button)findViewById(R.id.NoData);
        soilType=(Spinner)findViewById(R.id.StateSpinner);
        soilDr=(Spinner)findViewById(R.id.SoilDr);
        cpt=new CPT_test_Class();
        spt=new SPT_test_Class();

        ArrayAdapter<String> adaptr = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Constants.DATA_Soil_Density);
        soilDr.setAdapter(adaptr);

        soilDr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    densityRatio = 0.8;
                } else {
                    if (position == 1) {
                        densityRatio = 0.7;
                    } else {
                        if (position == 2) {
                            densityRatio = 0.6;
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Constants.Soil_Type);
        soilType.setAdapter(adapter);
        soilType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    soil_type=Constants.sand;

                }
                if(position==1){
                    soil_type=Constants.clay;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    double depthex,unitWeightt,water_depth,tip_resistance,friction_resistance;

    private void getData() {

        depthex  = unitWeightt = water_depth = 0;
        int i = 0;


        if (Depth.getText().toString().matches("")) {
            i++;
        }

        if (unitWt.getText().toString().matches("")) {
            i++;
        }

        if (waterDepth.getText().toString().matches("")) {
            i++;
        }
        if(tip.getText().toString().matches("")){
            i++;
        }
        if(friction.getText().toString().matches("")){
            i++;
        }
        if (i > 0) {
            Toast.makeText(getApplicationContext(), "Please fill all the information to proceed", Toast.LENGTH_SHORT).show();
        } else if (i == 0) {
            depthex = Double.parseDouble(Depth.getText().toString());
            unitWeightt = Double.parseDouble(unitWt.getText().toString());
            water_depth = Double.parseDouble(waterDepth.getText().toString());
            tip_resistance=Double.parseDouble(tip.getText().toString());
            friction_resistance=Double.parseDouble(friction.getText().toString());

            cpt.setDepth(depthex);
            cpt.setUnitWt(unitWeightt);
            cpt.setTipResistance(tip_resistance);
            cpt.setFrictionResistance(friction_resistance);
            cpt.setWaterDepth(water_depth);
            String testType="CPT";
            cpt.setTestType(testType);
            cpt.setSoilType(soil_type);
            cpt.setDensityRatio(densityRatio);
/*
            cpt.setMw(Double.parseDouble(s.getDetails().get("KEY_MW")));
            cpt.setAmaxG(Double.parseDouble(s.getDetails().get("KEY_AMAXG")));
*/

            //calculations=new Calculations( depthex, spt, gravel,  sand, silt, clay, unitWeightt, water_depth, densityRatio,testType,tip_resistance,friction_resistance,soil_type);

            calculations =new Calculations(getApplicationContext(), cpt,spt);
            CPT.add(calculations.returnCPT());
            layoutInittiation();
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