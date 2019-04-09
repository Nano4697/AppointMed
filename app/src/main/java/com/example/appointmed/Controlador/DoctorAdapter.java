package com.example.appointmed.Controlador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.appointmed.Modelo.Doctor;
import com.example.appointmed.R;

import java.util.ArrayList;



public class DoctorAdapter extends ArrayAdapter {

    ArrayList<Object> list;
    private LayoutInflater inflater;

    Context ctx;

    public DoctorAdapter(Context context, ArrayList objects) {
        super(context, 0, objects);
        this.list =  objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ctx = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null)
            view = inflater.inflate(R.layout.layout_doctor_list, null);

        TextView doc = view.findViewById(R.id.doctorCita);
        TextView dept = view.findViewById(R.id.deptCita);

        Doctor doctor = (Doctor) getItem(i);

        if (doc!=null)
            doc.setText(doctor.getNomnbre());
        if (dept!=null)
            dept.setText(doctor.getEspecialidad());

        return view;
    }
}

