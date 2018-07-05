package com.first.sab.ebook.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.first.sab.ebook.R;
import com.first.sab.ebook.modeles.ModelView;

import java.util.ArrayList;

/**
 * Created by Sab on 23/03/2018.
 */

public class CustomArrayAdapter extends ArrayAdapter<ModelView>{
    Context context;
    public CustomArrayAdapter(@NonNull Context context, @NonNull ArrayList<ModelView> objects) {
        super(context, 0, objects);
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ModelView modelView = getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.layout_row1, parent,false);
        TextView txt = convertView.findViewById(R.id.txtgrid1);
        ImageView img = convertView.findViewById(R.id.imggrid1);

        txt.setText(modelView.getTxtModel());
        img.setImageResource(modelView.getImgModel());
        return convertView;
    }


}
