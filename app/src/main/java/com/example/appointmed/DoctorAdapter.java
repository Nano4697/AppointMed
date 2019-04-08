package com.example.appointmed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class DoctorAdapter extends ArrayAdapter {

    ArrayList<Object> list;
    private static final int HEADER = 0;
    private static final int ITEM = 1;
    private LayoutInflater inflater;

    Context ctx;

    public DoctorAdapter(Context context, ArrayList objects) {
        super(context, 0, objects);
        this.list =  objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ctx = context;
    }

//    @Override
//    public int getItemViewType(int position) {
//        if (list.get(position) instanceof Group_letter)
//            return HEADER;
//        else
//            return ITEM;
//    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null)
            view = inflater.inflate(R.layout.layout_doctor_list, null);

        TextView doc = (TextView) view.findViewById(R.id.doctorCita);
        TextView dept = (TextView) view.findViewById(R.id.deptCita);
        ImageView img = (ImageView) view.findViewById(R.id.thumbnail_image);

        if (doc!=null)
            doc.setText(getItem(i).toString());
        if (dept!=null)
            dept.setText(getItem(i).toString());
        if (img!=null)
            Glide.with(getContext()).load(getItem(i).toString()).into(img);


        return view;
    }
}

