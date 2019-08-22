
package  ankur.projectwork;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<CPT_test_Class> implements View.OnClickListener{

    private ArrayList<CPT_test_Class> cpt;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

         TextView data1,data2,data3,data4,data5,data6,data7,data8,data9;
    }

    public Adapter(ArrayList<CPT_test_Class> data, Context context) {
        super(context, R.layout.row, data);
        this.cpt = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        /*int position=(Integer) v.getTag();
        Object object= getItem(position);
        CPT_test_Class dataModel=(CPT_test_Class)object;

        switch (v.getId())
        {
            case R.id.item_info:
                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }*/
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CPT_test_Class cpt = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row, parent, false);
            viewHolder.data1 = (TextView) convertView.findViewById(R.id.data1);
            viewHolder.data2 = (TextView) convertView.findViewById(R.id.data2);
            viewHolder.data3 = (TextView) convertView.findViewById(R.id.data3);
            viewHolder.data4 = (TextView) convertView.findViewById(R.id.data4);
            viewHolder.data5 = (TextView) convertView.findViewById(R.id.data5);
            viewHolder.data6 = (TextView) convertView.findViewById(R.id.data6);
            viewHolder.data7 = (TextView) convertView.findViewById(R.id.data7);
            viewHolder.data8 = (TextView) convertView.findViewById(R.id.data8);
           // viewHolder.data9=  (TextView)convertView.findViewById(R.id.data9);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

      /*  Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
       */ lastPosition = position;

        viewHolder.data1.setText(String.format("%.3f",cpt.getDepth()));
        viewHolder.data2.setText(String.format("%.3f",cpt.getFrictionResistance()));
        viewHolder.data3.setText(String.format("%.3f",cpt.getTipResistance()));
        viewHolder.data4.setText(String.format("%.3f",cpt.getCSR()));
        viewHolder.data5.setText(String.format("%.3f",cpt.getCRR()));
        viewHolder.data6.setText(String.format("%.3f",cpt.getFs()));
        viewHolder.data7.setText(cpt.getLiquefactionSuceptibility());
        //viewHolder.data8.setText((String.format("%.3f",cpt.getDepth()));
        //viewHolder.data1.setText((String.format("%.3f",cpt.getDepth()));

        // Return the completed view to render on screen
        return convertView;
    }
}
