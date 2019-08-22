package ankur.projectwork;

import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.io.Serializable;

public class SPT_test_Class implements Serializable {

    double spt;
    double depthex;
    double gravel;
    double sand;
    double clay;
    double silt;
    double unitWt;
    double c;
    double phi;
    double waterDepth;
    double densityRatio;

    public double getMw() {
        return Mw;
    }

    public void setMw(double mw) {
        Mw = mw;
    }

    double Mw;

    double fines, AmaxG, effectiveStress, Rd, CSR, verticalStress, Cn,alpha,Beta, CRR,N160, N160CS, km, kstress, kslope, CRR75, Fs;
    String liquefactionSuceptibility,testType,soilType;


    SPT_test_Class (){

     fines=AmaxG=effectiveStress=Rd=CSR=verticalStress=Cn=alpha=Beta=CRR=N160=N160CS=km=kslope=CRR75=Fs=0;
      liquefactionSuceptibility="";
      testType="";
      soilType="";
    }



    public double getSpt() {
        return spt;
    }

    public void setSpt(double spt) {
        this.spt = spt;
    }

    public double getDepthex() {
        return depthex;
    }

    public void setDepthex(double depthex) {
        this.depthex = depthex;
    }

    public double getGravel() {
        return gravel;
    }

    public void setGravel(double gravel) {
        this.gravel = gravel;
    }

    public double getSand() {
        return sand;
    }

    public void setSand(double sand) {
        this.sand = sand;
    }

    public double getClay() {
        return clay;
    }

    public void setClay(double clay) {
        this.clay = clay;
    }

    public double getSilt() {
        return silt;
    }

    public void setSilt(double silt) {
        this.silt = silt;
    }

    public double getUnitWt() {
        return unitWt;
    }

    public void setUnitWt(double unitWt) {
        this.unitWt = unitWt;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public double getWaterDepth() {
        return waterDepth;
    }

    public void setWaterDepth(double waterDepth) {
        this.waterDepth = waterDepth;
    }

    public double getDensityRatio() {
        return densityRatio;
    }

    public void setDensityRatio(double densityRatio) {
        this.densityRatio = densityRatio;
    }

    public double getFines() {
        return fines;
    }

    public void setFines(double fines) {
        this.fines = fines;
    }

    public double getAmaxG() {
        return AmaxG;
    }

    public void setAmaxG(double amaxG) {
        AmaxG = amaxG;
    }

    public double getEffectiveStress() {
        return effectiveStress;
    }

    public void setEffectiveStress(double effectiveStress) {
        this.effectiveStress = effectiveStress;
    }

    public double getRd() {
        return Rd;
    }

    public void setRd(double rd) {
        Rd = rd;
    }

    public double getCSR() {
        return CSR;
    }

    public void setCSR(double CSR) {
        this.CSR = CSR;
    }

    public double getVerticalStress() {
        return verticalStress;
    }

    public void setVerticalStress(double verticalStress) {
        this.verticalStress = verticalStress;
    }

    public double getCn() {
        return Cn;
    }

    public void setCn(double cn) {
        Cn = cn;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getBeta() {
        return Beta;
    }

    public void setBeta(double beta) {
        Beta = beta;
    }

    public double getCRR() {
        return CRR;
    }

    public void setCRR(double CRR) {
        this.CRR = CRR;
    }

    public double getN160() {
        return N160;
    }

    public void setN160(double n160) {
        N160 = n160;
    }

    public double getN160CS() {
        return N160CS;
    }

    public void setN160CS(double n160CS) {
        N160CS = n160CS;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getKstress() {
        return kstress;
    }

    public void setKstress(double kstress) {
        this.kstress = kstress;
    }

    public double getKslope() {
        return kslope;
    }

    public void setKslope(double kslope) {
        this.kslope = kslope;
    }

    public double getCRR75() {
        return CRR75;
    }

    public void setCRR75(double CRR75) {
        this.CRR75 = CRR75;
    }

    public double getFs() {
        return Fs;
    }

    public void setFs(double fs) {
        Fs = fs;
    }

    public String getLiquefactionSuceptibility() {
        return liquefactionSuceptibility;
    }

    public void setLiquefactionSuceptibility(String liquefactionSuceptibility) {
        this.liquefactionSuceptibility = liquefactionSuceptibility;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }
}
