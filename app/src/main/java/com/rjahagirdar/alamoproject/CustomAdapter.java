package com.rjahagirdar.alamoproject;

/**
 * Created by rjahagirdar on 12/5/2017.
 */


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class CustomAdapter extends BaseAdapter{
    String [] result;
    Context context;
    String [] imageId;
    String [] rates;
    String [] owners;

    private static LayoutInflater inflater=null;
    String category;

    SharedPreferences prefs;

    public CustomAdapter(Context context, String category) {

        this.category = category;
        this.context= context;
        imageId=getListImages(category);
        result=getListNames(category);

        owners=getListOwners(category);
        rates=getListRates(category);



        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }
    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView tv, owner, rate;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_car_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.nameCar);
        holder.img=(ImageView) rowView.findViewById(R.id.imageCar);
        holder.rate=(TextView) rowView.findViewById(R.id.rateCar);
        holder.owner =(TextView) rowView.findViewById(R.id.ownerCar);

        holder.tv.setText(result[position]);


        holder.owner.setText(owners[position]);
        holder.rate.setText("$" + rates[position] + "/day");

        holder.img.setBackground(context.getResources().
                getDrawable(context.getResources().getIdentifier(imageId[position],
                        "drawable",context.getPackageName())));


        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            prefs.edit().putString("category", category).putInt("position", position).apply();

            Intent i = new Intent(context, CarSelectedActivity.class);
            context.startActivity(i);
            }
        });
        return rowView;
    }


    public String getJsonFromAssets() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("document.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    public String[] getListNames(String category) {
        String [] names = new String[4];
        getJsonFromAssets();
        try {
            JSONObject obj = new JSONObject(getJsonFromAssets());
            JSONArray car_array = obj.getJSONArray(category.toLowerCase());
            for(int i = 0 ; i < car_array.length() ; i++){
                names[i] = car_array.getJSONObject(i).getString("name");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return names;
    }

    public String[] getListImages(String category) {
        String[] images = new String[4];

        try {
            JSONObject obj = new JSONObject(getJsonFromAssets());
            JSONArray car_array = obj.getJSONArray(category.toLowerCase());
            for(int i = 0 ; i < car_array.length() ; i++){
                images[i] = car_array.getJSONObject(i).getString("image");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return images;
    }



    public String[] getListOwners(String category) {
        String[] images = new String[4];

        try {
            JSONObject obj = new JSONObject(getJsonFromAssets());
            JSONArray car_array = obj.getJSONArray(category.toLowerCase());
            for(int i = 0 ; i < car_array.length() ; i++){
                images[i] = car_array.getJSONObject(i).getString("owner");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return images;
    }


    public String[] getListRates(String category) {
        String[] images = new String[4];

        try {
            JSONObject obj = new JSONObject(getJsonFromAssets());
            JSONArray car_array = obj.getJSONArray(category.toLowerCase());
            for(int i = 0 ; i < car_array.length() ; i++){
                images[i] = car_array.getJSONObject(i).getString("rate");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return images;
    }
}