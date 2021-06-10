package com.example.final_project;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

    // Adapter class for spinner control
    public class MyAdapter extends ArrayAdapter<TakoItem> {
        private Context context;
        private int spos=0;
        public MyAdapter(Context context, ArrayList<TakoItem> TakoList) {
            super(context, 0, TakoList);
            this.context=context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            spos = position;
            return initView(position, convertView, parent);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return initView(position, convertView, parent);
        }

        private View initView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.myspinner, parent, false);
            ImageView imageViewFlag = convertView.findViewById(R.id.image);
            TakoItem currentItem = getItem(position);
            if (currentItem != null) {
                imageViewFlag.setImageResource(currentItem.getTakoImage());
            }
            return convertView;
        }
    }

