package ankur.projectwork;

import java.io.Serializable;

public class CPT_test_Class implements Serializable {
    private  double  AmaxG,effectiveStress,Rd,CSR,verticalStress, CRR, km,kstress, kslope,CRR75;

    public double getMw() {
        return Mw;
    }

    public void setMw(double mw) {
        Mw = mw;
    }

    private double Fs,depth,waterDepth, Mw;


    private double unitWt;
    private String liquefactionSuceptibility,testType,soilType;
    private double frictionResistance,tipResistance;


    private double F,n,Q,Ic,Cq, qCIN,kc, qCINcs;

    public double getDensityRatio() {
        return densityRatio;
    }

    public void setDensityRatio(double densityRatio) {
        this.densityRatio = densityRatio;
    }

    private double densityRatio;

    CPT_test_Class(){

        AmaxG=effectiveStress=verticalStress=CSR=CRR=km=kslope=CRR75=depth=waterDepth=Fs=Rd=0;

       testType="";
       liquefactionSuceptibility="";
       soilType="";
    }



    public double getUnitWt() {
        return unitWt;
    }

    public void setUnitWt(double unitWt) {
        this.unitWt = unitWt;
    }


    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getWaterDepth() {
        return waterDepth;
    }

    public void setWaterDepth(double waterDepth) {
        this.waterDepth = waterDepth;
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

    public double getCRR() {
        return CRR;
    }

    public void setCRR(double CRR) {
        this.CRR = CRR;
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

    public double getFrictionResistance() {
        return frictionResistance;
    }

    public void setFrictionResistance(double frictionResistance) {
        this.frictionResistance = frictionResistance;
    }

    public double getTipResistance() {
        return tipResistance;
    }

    public void setTipResistance(double tipResistance) {
        this.tipResistance = tipResistance;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getF() {
        return F;
    }

    public void setF(double f) {
        F = f;
    }

    public double getQ() {
        return Q;
    }

    public void setQ(double q) {
        Q = q;
    }

    public double getIc() {
        return Ic;
    }

    public void setIc(double ic) {
        Ic = ic;
    }

    public double getCq() {
        return Cq;
    }

    public void setCq(double cq) {
        Cq = cq;
    }

    public double getqCIN() {
        return qCIN;
    }

    public void setqCIN(double qCIN) {
        this.qCIN = qCIN;
    }

    public double getKc() {
        return kc;
    }

    public void setKc(double kc) {
        this.kc = kc;
    }

    public double getqCINcs() {
        return qCINcs;
    }

    public void setqCINcs(double qCINcs) {
        this.qCINcs = qCINcs;
    }
}
