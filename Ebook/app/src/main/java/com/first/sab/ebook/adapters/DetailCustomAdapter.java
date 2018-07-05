package com.first.sab.ebook.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.first.sab.ebook.R;
import com.first.sab.ebook.modeles.ModelDetails;

import java.util.ArrayList;

/**
 * Created by Sab on 25/03/2018.
 */

public class DetailCustomAdapter extends ArrayAdapter<ModelDetails>{


    Context context;
    public DetailCustomAdapter(@NonNull Context context,  @NonNull ArrayList<ModelDetails> objects) {
        super(context, 0, objects);
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ModelDetails modelDetails = getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.row_details ,parent ,false);

       ImageView img = (convertView.findViewById(R.id.img_line_details));
       TextView txt1 = (convertView.findViewById(R.id.txt1_line_details));
       TextView txt2 = (convertView.findViewById(R.id.txt2_line_details));
       img.setImageResource(modelDetails.getImg());
       txt1.setText(modelDetails.getTxt1());
       txt2.setText(modelDetails.getTxt2());


        return convertView;
    }
}
