package com.example.proyecto;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class servicio_social extends Fragment {


    public servicio_social() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_servicio_social2, container, false);

        final Typeface custom_font = Typeface.createFromAsset(getContext().getApplicationContext().getAssets(),  "poppins_regular.otf");
        final TextView texto = v.findViewById(R.id.intro);
        texto.setTypeface(custom_font);

        texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_servicio_introduccion.class);
                startActivity(intent);
            }
        });

        final TextView texto2 = v.findViewById(R.id.docu);
        texto2.setTypeface(custom_font);
        texto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right,R.anim.enter_from_right, R.anim.exit_to_right).replace(R.id.content_main, new servicio_documentos()).commit();
            }
        });

        final TextView texto3 = v.findViewById(R.id.proce);
        texto3.setTypeface(custom_font);
        texto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_servicio_procedimientos.class);
                startActivity(intent);
            }
        });

        final TextView texto4 = v.findViewById(R.id.contacto_ser);
        texto4.setTypeface(custom_font);
        texto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.gla_there_come, R.anim.gla_there_gone, R.anim.gla_back_gone, R.anim.gla_back_come).replace(R.id.content_main, new Contacto(0)).addToBackStack("Servicio Social").commit();

            }
        });


        return v;
    }

    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Servicio Social");

    }

}
