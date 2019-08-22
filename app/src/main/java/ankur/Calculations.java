package ankur.projectwork;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

import static java.lang.Math.exp;
import static java.lang.Math.pow;
import static java.lang.Math.random;
import static java.lang.Math.sqrt;

class Calculations {

    private double depth, SPT, gravel, sand, silt, clay, unitwt, waterDepth,dR,Mw;

    double fines, AmaxG, effectiveStress, Rd, CSR, verticalStress, Cn,alpha,Beta, CRR,N160, N160CS, km, kstress, kslope, CRR75, Fs;
    String liquefactionSuceptibility,testType,soilType;
    double frictionResistance,tipResistance;
    CPT_test_Class cpt=new CPT_test_Class();
    SPT_test_Class spt=new SPT_test_Class();
Context context;
String amaxG, m;

    SharedPreferences sharedPreferences;


    Calculations (Context context,CPT_test_Class cpt, SPT_test_Class spt){
        this.context=context;
        sharedPreferences=context.getSharedPreferences(Constants.PACKAGE_NAME,Context.MODE_PRIVATE);

        if(cpt.testType.matches("CPT") ){
           this.testType=cpt.getTestType();
           this.tipResistance=cpt.getTipResistance();
           this.frictionResistance=cpt.getFrictionResistance();
           this.depth=cpt.getDepth();
           this.unitwt=cpt.unitWt;
           this.AmaxG=cpt.getAmaxG();
           this.kslope=Constants.KSlope;
           this.waterDepth=cpt.getWaterDepth();
           this.soilType=cpt.getSoilType();

            stresses();
            CSR();
            correctedCPT();
            Kstress();
            CRRandFs();
            saveCPTResults();
        }
        if(spt.testType.matches("SPT")){
            this.testType=spt.getTestType();
            this.soilType=spt.getSoilType();
            this.waterDepth=spt.getWaterDepth();
            this.sand=spt.getSand();
            this.kslope=Constants.KSlope;
            this.gravel=spt.getGravel();
            this.clay=spt.getClay();
            this.silt=spt.getSilt();
            this.Mw=spt.getMw();
            this.unitwt=spt.getUnitWt();
            this.depth=spt.getDepthex();
            this.dR=spt.densityRatio;
            this.SPT=spt.getSpt();

            //PUT CORRECTION FOR SNO STANDARD APPARATUS

            calculateFines();
            stresses();
            CSR();
            correctedSPT();
            CRR75();
            Kstress();
            CRRandFs();
            saveSPTResults();
        }

    }

   

    private double calculateFines() {
        fines = clay / (sand + silt + clay + gravel);

        Log.d("solved",String.valueOf(fines));
        return fines;
    }


    private void stresses() {
        verticalStress = unitwt * depth;
        effectiveStress = unitwt * depth - 9.81 * waterDepth;

        if (depth >= 0 || depth <= 9.15) {
            Rd = 1 - 0.00765 * depth;
        }
        if (depth > 9.15 || depth <= 23) {
            Rd = 1.174 - 0.0267 * depth;
        }

        Log.d("solved",String.valueOf(Rd));
        Log.d("solved",String.valueOf(verticalStress));
        Log.d("effective",String.valueOf(effectiveStress));
    }

    private void CSR() {
        //get the value of amax from dropdown
         amaxG=sharedPreferences.getString(Constants.ZOneValue, "0.26");
        AmaxG= Double.parseDouble(amaxG);

        Log.d("display", String.valueOf(AmaxG));

        CSR = 0.65 * (AmaxG ) * (verticalStress / effectiveStress) * Rd;

        Log.d("CSR",String.valueOf(CSR));
    }

    private void correctedSPT(){

        Cn=sqrt(Constants.Pa/effectiveStress);

        Log.d("Cn",String.valueOf(Cn));
        if(Cn<=1.7){
            N160=Cn*SPT;
        }else{
            Cn=1.7;
           N160= Cn*SPT;
        }
        if(fines<=5){
            alpha=0;
            Beta=1;
        }
        if(fines>5 && fines <35){
            alpha=exp(1.76-(190/pow(fines,2)));
            Beta=0.99 + pow(fines,1.5)/1000;

        }
        if(fines>=35){
            alpha=0.5;
            Beta=1.2;

        }
        N160CS=alpha+ Beta*N160;


        Log.d("alpha",String.valueOf(alpha));
        Log.d("N160CS",String.valueOf(N160CS));

    }
    private void CRR75(){
        CRR75=1/(34-N160CS)+N160CS/135+50/pow((10*N160CS+45),2)-1/200;

        Log.d("CRR75",String.valueOf(CRR75));
    }

    private void Kstress(){
        if(effectiveStress<100){
            kstress= pow(effectiveStress,dR-1);
        }else{
            kstress=1;
        }
        m=sharedPreferences.getString(Constants.KEY_MW,"5.9");
        Mw=Double.parseDouble(m);
        Log.d("Display",m);

     km=pow(10,2.24)/pow(Mw,2.56);
    }


   double n,F,Q,Ic,Cq,qCIN,kc,qCINcs;

    private void correctedCPT() {
        if(soilType.matches(Constants.sand)){
            n=0.5;
        }
        else{
            if(soilType.matches(Constants.clay)){
                n=1;
            }
        }
        //assuming qc=frictionResistance;
        F=100*(frictionResistance/(tipResistance-verticalStress));

        Q= ((tipResistance-verticalStress)/Constants.Pa)*(pow(Constants.Pa/verticalStress,n));

        Ic=sqrt((3.47-Math.log10(Q))*(3.47-Math.log10(Q)) + (1.22-Math.log10(F))*(1.22-Math.log10(F)));

        Cq = pow(Constants.Pa/effectiveStress,n);

        qCIN = Cq*(tipResistance/Constants.Pa);


        Log.d("F",String.valueOf(F));
        Log.d("Q",String.valueOf(Q));

        Log.d("Ic",String.valueOf(Ic));

        Log.d("qCin",String.valueOf(qCIN));
        Log.d("Cq",String.valueOf(Cq));
        if(Ic<=1.64){
            kc = 1;
        }else {
            if(Ic>1.64){
                kc= -0.403*pow(Ic,4) + 5.581*pow(Ic,3) - 21.63 *pow(Ic,2) + 33.75*Ic - 17.88;
            }
        }
      qCINcs=kc*qCIN;


        Log.d("qCinCS",String.valueOf(qCINcs));

    }
    private void CRRandFs(){

        if(testType.matches("CPT")){
            if(qCIN<50){
                CRR75=0.833*pow((qCINcs/1000),3)+0.05;
            }else if(qCIN>50){
                CRR75=93*pow((qCINcs/1000),3)+0.08;
            }

            Fs=CRR75* km * kslope * kstress/CSR;


            if (Fs < 1) {
                liquefactionSuceptibility = "yes";
            } else {
                liquefactionSuceptibility = "no";
            }
        }

        else if(testType.matches("SPT")) {
            CRR = CRR75 * km * kslope * kstress;

            Fs = CRR / CSR;
            if (Fs < 1) {
                liquefactionSuceptibility = "yes";
            } else {
                liquefactionSuceptibility = "no";
            }
        }
        Log.d("CRR",String.valueOf(CRR));
        Log.d("Liq",String.valueOf(liquefactionSuceptibility));


        Log.d("Fs",String.valueOf(Fs));


    }

    public CPT_test_Class returnCPT(){
        return cpt;
    }
    public SPT_test_Class returnSPT(){
        return spt;
    }
    public void saveCPTResults(){
         cpt.setCq(Cq);
         cpt.setAmaxG(AmaxG);
         cpt.setCRR(CRR);
         cpt.setCRR75(CRR75);
         cpt.setCSR(CSR);
         cpt.setDensityRatio(dR);
         cpt.setEffectiveStress(effectiveStress);
         cpt.setDepth(depth);
         cpt.setFrictionResistance(frictionResistance);
         cpt.setVerticalStress(verticalStress);
         cpt.setTipResistance(tipResistance);
         cpt.setSoilType(soilType);
         cpt.setTestType(testType);
         cpt.setUnitWt(unitwt);
         cpt.setWaterDepth(waterDepth);
         cpt.setqCINcs(qCINcs);
         cpt.setRd(Rd);
         cpt.setQ(Q);
         cpt.setKstress(kstress);
         cpt.setKc(kc);
         cpt.setN(n);
         cpt.setIc(Ic);
         cpt.setIc(Ic);
         cpt.setFs(Fs);
         cpt.setKm(km);
         cpt.setLiquefactionSuceptibility(liquefactionSuceptibility);

        String fileName="logDataCPT"+String.valueOf(random()+".csv");
        File f=new File(fileName);
        if(f.exists()){
            fileName= "logDataCPT"+String.valueOf(random()+".csv");
        }
        String entry= String.valueOf(depth) + "," + String .valueOf(tipResistance) +", "+
                String.valueOf(frictionResistance) + "," + String .valueOf(unitwt) +", "+
                String.valueOf(waterDepth) + "," + String .valueOf(dR) +", "+
                String.valueOf(soilType) + "," + String .valueOf(CSR) +", "+
                String.valueOf(CRR) + "," + String .valueOf(Fs) + "," + liquefactionSuceptibility+ "\n";
        try {
            FileOutputStream out = context.openFileOutput(fileName, Context.MODE_APPEND);
            out.write(entry.getBytes());
            out.close();
            Log.v("msg","Done");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void saveSPTResults(){
        spt.setGravel(gravel);
        spt.setAlpha(alpha);
        spt.setBeta(Beta);
        spt.setAmaxG(AmaxG);
        spt.setSand(sand);
        spt.setVerticalStress(verticalStress);
        spt.setEffectiveStress(effectiveStress);
        spt.setSand(silt);
        spt.setUnitWt(unitwt);
        spt.setWaterDepth(waterDepth);
        spt.setTestType(testType);
        spt.setSpt(SPT);
        spt.setSoilType(soilType);
        spt.setSilt(silt);
        spt.setRd(Rd);
        spt.setN160(N160);
        spt.setN160CS(N160CS);
        spt.setLiquefactionSuceptibility(liquefactionSuceptibility);
        spt.setKstress(kstress);
        spt.setKslope(kslope);
        spt.setKm(km);
        spt.setFs(Fs);
        spt.setFines(fines);
        spt.setDepthex(depth);
        spt.setDensityRatio(dR);
        spt.setCSR(CSR);
        spt.setCRR75(CRR75);
        spt.setCRR(CRR);

        String fileName="logDataSPT.csv";
        String entry= String.valueOf(depth) + "," + String .valueOf(N160CS) +", "+
                String .valueOf(gravel) +", "+
                String.valueOf(sand) + "," + String .valueOf(silt) +", "+
                String.valueOf(clay) + "," + String .valueOf(soilType) +", "+
                String.valueOf(unitwt) + "," + String .valueOf(waterDepth) +", "+
                String.valueOf(CSR) + "," + String .valueOf(CRR) +", "+
                String.valueOf(Fs) + "," + (liquefactionSuceptibility) + "\n";
        try {
            FileOutputStream out = context.openFileOutput(fileName, Context.MODE_APPEND);
            out.write(entry.getBytes());
            out.close();

            Log.v("msg","Done");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

