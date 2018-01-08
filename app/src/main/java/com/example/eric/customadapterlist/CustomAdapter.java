package com.example.eric.customadapterlist;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] countries;
    private final Integer[] images;

    public CustomAdapter(Activity context, String [] countries, Integer [] images){
        super(context, R.layout.row,countries);
        this.context = context;
        this.countries = countries;
        this.images = images;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater(); // standard way to get the inflater
        View row = inflater.inflate(R.layout.row, null, true); // selecting the xml to inflate (Row.xml)

        TextView txt = (TextView) row.findViewById(R.id.text);
        ImageView image = (ImageView) row.findViewById(R.id.image);

        if(countries[position].equalsIgnoreCase("Ireland")){
        txt.setText(countries[position]);
        image.setImageResource(images[1]);
    }else{
        txt.setText(countries[position]);
        image.setImageResource(images[0]);
    }

        return row;

}

}