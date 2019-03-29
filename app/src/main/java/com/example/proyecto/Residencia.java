package com.example.proyecto;


import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Residencia extends Fragment {

    public Residencia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_residencia, container, false);

        Typeface custom_font = Typeface.createFromAsset(getContext().getApplicationContext().getAssets(),  "poppins_regular.otf");

        TextView textTit = v.findViewById(R.id.res_titulo);
        textTit.setTypeface(custom_font);
        TextView text1 = v.findViewById(R.id.res_t1);
        text1.setTypeface(custom_font);
        TextView text2 = v.findViewById(R.id.res_t2);
        text2.setTypeface(custom_font);
        TextView text3 = v.findViewById(R.id.res_t3);
        text3.setTypeface(custom_font);
        TextView text4 = v.findViewById(R.id.res_t4);
        text4.setTypeface(custom_font);
        TextView text5 = v.findViewById(R.id.res_down);
        text5.setTypeface(custom_font);
        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckInt c = new CheckInt();
                if(c.internetIsConnected())
                {
                    Toast.makeText(getContext(), "Descargando Archivo...",Toast.LENGTH_SHORT).show();
                    Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.itmexicali.edu.mx/servicios1/programa.xls"));
                }
                else
                    Toast.makeText(getContext(), "No esta conectado a Internet...",Toast.LENGTH_SHORT).show();

            }
        });

        LinearLayout op1 = v.findViewById(R.id.res_op1);
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_up, R.anim.slide_down, R.anim.slide_up, R.anim.slide_down).replace(R.id.content_main, new Residencia1()).commit();

            }
        });
        LinearLayout op2 = v.findViewById(R.id.res_op2);
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_up, R.anim.slide_down, R.anim.slide_up, R.anim.slide_down).replace(R.id.content_main, new Residencia2()).commit();
            }
        });
        LinearLayout op3 = v.findViewById(R.id.res_op3);
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_up, R.anim.slide_down, R.anim.slide_up, R.anim.slide_down).replace(R.id.content_main, new Residencia3()).commit();
            }
        });
        LinearLayout op4 = v.findViewById(R.id.res_op4);
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.gla_there_come, R.anim.gla_there_gone, R.anim.gla_back_gone, R.anim.gla_back_come).replace(R.id.content_main, new Contacto(1)).addToBackStack("Residencia").commit();
            }
        });

        return v;
    }



    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Residencias");

    }



}
