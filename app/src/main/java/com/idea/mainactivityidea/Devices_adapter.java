package com.idea.mainactivityidea;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class Devices_adapter extends ArrayAdapter<String> {

    Context context;
    int[] image_ids;
    String[] device_list;

    public Devices_adapter(Context context, int[] resource,String[] device_name) {
        super(context,R.layout.custom_list,device_name);
        this.device_list=device_name;
        this.context=context;
        this.image_ids=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View single_row = inflater.inflate(R.layout.custom_list, null, true);

        TextView textView =(TextView)single_row.findViewById(R.id.device_list);
        // ImageView imageView=(ImageView)single_row.findViewById(R.id.device_icon);
        textView.setText(device_list[position]); // .toString().toUpperCase()
        textView.setTypeface(BaseApplication.getTypeFaceRegular());
        // imageView.setImageResource(image_ids[position]);
        return single_row;
    }
}
