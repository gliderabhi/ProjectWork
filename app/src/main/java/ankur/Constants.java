package ankur.projectwork;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankur on 8/27/2018.
 */

public class Constants {
    public static final int SUCCESS_RESULT = 0;
    public static final int FAILURE_RESULT = 1;
    public static final String PACKAGE_NAME = "ankur.projectwork";
    public static final String RECEIVER = PACKAGE_NAME + ".RECEIVER";
    public static final String RESULT_DATA_KEY = PACKAGE_NAME + ".RESULT_DATA_KEY";
    public static final String LOCATION_DATA_EXTRA = PACKAGE_NAME + ".LOCATION_DATA_EXTRA";

    public static final String[] DATA_CITIES= new String[]{"Select City", "Agra " , "Ahmedabad " , "Ajmer " , "Allahabad " , "Almora " , "Ambala " , "Amritsar " , "Asansol " , "Aurangabad " , "Bahraich " , "Bangalore (Bengaluru) " , "Barauni " , "Bareilly " , "Belgaum " , "Bhatinda " , "Bhilai " , "Bhopal " , "Bhubaneswar " , "Bhuj " , "Bijapur " , "Bikaner " , "Bokaro " , "Bulandshahr " , "Burdwan " , "Calicut " , "Chandigarh " , "Chennai " , "Chitradurga " , "Coimbatore " , "Cuddalore " , "Cuttack " , "Darbhanga " , "Darjeeling " , "Dharwad " , "Dehra Dun " , "Dharampuri " , "Delhi " , "Durgapur " , "Gangtok " , "Guwahati " , "Gulbarga " , "Gaya " , "Gorakhpur " , "Hyderabad " , "Imphal " , "Jabalpur " , "Jaipur " , "Jamshedpur " , "Jhansi " , "Jodhpur " , "Jorhat " , "Kakrapara " , "Kalpakkam " , "Kanchipuram " , "Kanpur " , "Karwar " , "Kochi " , "Kohima " , "Kolkata " , "Kota " , "Kurnool " , "Lucknow " , "Ludhiana " , "Madurai " , "Mandi " , "Mangalore " , "Monghyr (Munger) " , "Moradabad " , "Mumbai " , "Mysore " , "Nagpur " , "Nagarjunasagar " , "Nainital " , "Nasik " , "Nellore " , "Osmanabad " , "Panjim " , "Patiala " , "Patna " , "Pilibhit " , "Pondicherry " , "Pune " , "Raipur " , "Rajkot " , "Ranchi " , "Roorkee " , "Rourkela " , "Sadiya " , "Salem " , "Shillong " , "Shimla " , "Sironj " , "Solapur " , "Srinagar " , "Surat " , "Tarapur " , "Tezpur " , "Thane " , "Thanjavur " , "Thiruvananthapuram " , "Tiruchirappalli " , "Thiruvannamalai " , "Udaipur " , "Vadodara " , "Varanasi " , "Vellore " , "Vijayawada " , "Vishakhapatnam "};
    public static final String[] DATA_CITIES_ZONES= new String[]{"0","0.16" , "0.16" , "0.1" , "0.1" , "0.24" , "0.24" , "0.24" , "0.16" , "0.1" , "0.24" , "0.1" , "0.24" , "0.16" , "0.16" , "0.16" , "0.1" , "0.1" , "0.16" , "0.36" , "0.16" , "0.16" , "0.16" , "0.24" , "0.16" , "0.16" , "0.24" , "0.16" , "0.1" , "0.16" , "0.1" , "0.16" , "0.36" , "0.24" , "0.16" , "0.24" , "0.16" , "0.24" , "0.16" , "0.24" , "0.36" , "0.1" , "0.16" , "0.24" , "0.1" , "0.36" , "0.16" , "0.1" , "0.1" , "0.1" , "0.1" , "0.36" , "0.16" , "0.16" , "0.16" , "0.16" , "0.16" , "0.16" , "0.36" , "0.16" , "0.1" , "0.1" , "0.16" , "0.24" , "0.1" , "0.36" , "0.16" , "0.24" , "0.24" , "0.16" , "0.1" , "0.1" , "0.1" , "0.24" , "0.16" , "0.16" , "0.16" , "0.16" , "0.16" , "0.24" , "0.24" , "0.1" , "0.16" , "0.1" , "0.16" , "0.1" , "0.24" , "0.1" , "0.36" , "0.16" , "0.36" , "0.24" , "0.1" , "0.16" , "0.36" , "0.16" , "0.16" , "0.36" , "0.16" , "0.1" , "0.16" , "0.1" , "0.16" , "0.1" , "0.16" , "0.16" , "0.16" , "0.16" , "0.1"};
     public static final List<Double> InputData=new ArrayList<>();
    public static final String VIEW = "View";
    public static final String v="Visible";
    public static final String in="INVisible";
    public static final String ZOneValue = "AMax";
    public static double AmaxG=0;
    public static double Pa=100;
    public static final String[] DATA_Soil_Density=new String[]{"Select Soil type ","Dense soil","Medium soil","Loose soil "};
    public static final String[] Soil_Type=new String[]{"Select ","Sandy","Clay"};
    public static final double KSlope=1;
    public static final String sand="Sand";
    public static final String clay="Clay";

    public  static final String KEY_LONGITUDE="longitude";
    public  static final String KEY_LATITUDE="latitude";
    public static final String KEY_MW="";
    public static final String KEY_AMAXG="";

    public static final String[] DATA_CITY_LAT=new String[]{"27.17667" , "23.022505" ,  "26.449896" , "25.435801" , "29.589241" ,  "30.37818" , "31.63398" , "23.693029" , "19.876165" ,
                       "27.58374" ,  "12.82767" ,  "25.4166" ,  "28.35184" , "15.85276" ,  "26.08181" ,  "21.193848" ,  "23.259933" , "20.27261" ,  "23.26567" , "16.8288" ,"28.01079" , "23.79372" , "28.40988" , "23.2491" , "11.25909" , "30.733315" ,
            "13.08268" , "14.22425" , "11.01601" , "11.75664" , "20.4657" , "26.15635" , "27.03949" , "15.45849" , "30.3163" , "22.153" , "28.70406" , "23.55575" , "27.33049" , "26.14029" , "17.34199" , "24.79248" , "26.76076" ,
            "17.385044" , "24.902579" , "23.16667" , "26.91667" , "22.8" , "25.4484257" , "26.173068" , "26.75" , "25.507816" , "12.5238119" , "12.8341735" , "26.4725" , "14.8" , "9.9312328" , "25.6585963" , "22.572646" ,
            "25.2138156" , "15.8281257" , "26.8466937" , "30.900965" , "9.9252007" , "31.5892006" , "12.9141417" , "25.3747561" , "28.8386481" , "19.0759837" , "12.2958104" , "21.1458004" , "16.5167641" , "29.3803039" ,
            "19.9974533" , "14.4425987" , "18.2069636" , "15.4909301" , "30.3397809" , "25.5940947" , "28.6207939" , "11.9415915" , "18.5204303" , "21.2513844" , "22.3038945" , "23.3440997" , "29.8542626" , "22.260423" ,
            "27.860175" ,
            "11.664325" ,
            "25.5787726" ,
            "31.1048145" ,
            "24.0993031" ,
            "17.6599188" ,
            "34.08409328" ,
            "21.1702401" ,
            "19.8649145" ,
            "26.6528495" ,
            "19.2183307" ,
            "10.7869994" ,
            "8.5241391" ,
            "10.7904833" ,
            "12.2252841" ,
            "24.585445" ,
            "22.3071588" ,
            "25.3176452" ,
            "12.9165167" ,
            "16.5061743" ,
            "17.6868159"};
    public static final String[] DATA_CITY_LNG=new String[] {"78.008072" ,
            "72.571365" ,
            "74.639915" ,
            "81.846313" ,
            "79.646667" ,
            "76.776695" ,
            "74.872261" ,
            "86.95311" ,
            "75.343315" ,
            "81.60445" ,
            "77.678978" ,
            "86.0937" ,
            "79.40956" ,
            "74.511124" ,
            "73.28547" ,
            "81.350945" ,
            "77.412613" ,
            "85.833122" ,
            "69.6769" ,
            "75.71778" ,
            "73.32101" ,
            "85.88231" ,
            "77.8707" ,
            "87.8694" ,
            "75.782" ,
            "76.779419" ,
            "80.270721" ,
            "76.39545" ,
            "76.97031" ,
            "79.7629" ,
            "85.90019" ,
            "85.89432" ,
            "88.263908" ,
            "75.00747" ,
            "78.03298" ,
            "75.3444" ,
            "77.102493" ,
            "87.27427" ,
            "88.61355" ,
            "91.79186" ,
            "76.83746" ,
            "85.00771" ,
            "83.3737" ,
            "78.486671" ,
            "93.884047" ,
            "79.93333" ,
            "75.86667" ,
            "86.18333" ,
            "78.5684594" ,
            "73.26135" ,
            "94.21667" ,
            "89.865688" ,
            "80.1568134" ,
            "79.7036402" ,
            "80.33111" ,
            "74.13333" ,
            "76.2673041" ,
            "94.1053307" ,
            "88.363895" ,
            "75.8647527" ,
            "78.0372792" ,
            "80.946166" ,
            "75.8572758" ,
            "78.1197754" ,
            "76.9182097" ,
            "74.8559568" ,
            "86.4735251" ,
            "78.7733286" ,
            "72.8776559" ,
            "76.6393805" ,
            "79.0881546" ,
            "80.6749986" ,
            "79.4635658" ,
            "73.7898023" ,
            "79.986456" ,
            "76.1783739" ,
            "73.8278496" ,
            "76.3868797" ,
            "85.1375645" ,
            "79.8128649" ,
            "79.8083133" ,
            "73.8567437" ,
            "81.6296413" ,
            "70.8021599" ,
            "85.309562" ,
            "77.8880002" ,
            "84.8535844" ,
            "95.6273951" ,
            "78.1460142" ,
            "91.8932535" ,
            "77.1734033" ,
            "77.6707924" ,
            "75.9063906" ,
            "74.80833024" ,
            "72.8310607" ,
            "72.6849984" ,
            "92.7925592" ,
            "72.9780897" ,
            "79.1378274" ,
            "76.9366376" ,
            "78.7046725" ,
            "79.0746957" ,
            "73.712479" ,
            "73.1812187" ,
            "82.9739144" ,
            "79.1324986" ,
            "80.6480153" ,
            "83.2184815"};



}




