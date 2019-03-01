package com.example.proyecto;


import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmento_servicio_social extends Fragment {


    public fragmento_servicio_social() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_servicio_social2, container, false);

        Typeface custom_font = Typeface.createFromAsset(getContext().getApplicationContext().getAssets(),  "poppins_regular.otf");
        final TextView texto = v.findViewById(R.id.intro);
        texto.setTypeface(custom_font);

        texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation blink = AnimationUtils.loadAnimation(getContext(), R.anim.blink_anim);
                texto.setAnimation(blink);
                texto.startAnimation(blink);

                Intent intent = new Intent(getActivity(), activity_servicio_introduccion.class);
                startActivity(intent);
            }
        });

        final TextView texto2 = v.findViewById(R.id.docu);
        texto2.setTypeface(custom_font);
        texto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation blink = AnimationUtils.loadAnimation(getContext(), R.anim.blink_anim);
                texto2.setAnimation(blink);
                texto2.startAnimation(blink);
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right,R.anim.enter_from_right, R.anim.exit_to_right).replace(R.id.content_main, new servicio_documentos()).commit();
            }
        });

        final TextView texto3 = v.findViewById(R.id.proce);
        texto3.setTypeface(custom_font);
        texto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation blink = AnimationUtils.loadAnimation(getContext(), R.anim.blink_anim);
                texto3.setAnimation(blink);
                texto3.startAnimation(blink);
                Intent intent = new Intent(getActivity(), activity_servicio_procedimientos.class);
                startActivity(intent);
            }
        });

        final TextView texto4 = v.findViewById(R.id.contacto_ser);
        texto4.setTypeface(custom_font);
        texto4.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Animation blink = AnimationUtils.loadAnimation(getContext(), R.anim.blink_anim);
                texto4.setAnimation(blink);
                texto4.startAnimation(blink);

                /*int x = (v.getLeft() + v.getRootView().getRight()) / 2;
                int y = (v.getRootView().getTop() + v.getRootView().getBottom()) / 2;

                int startRadius = 0;
                int endRadius = Math.max(v.getRootView().getWidth(), v.getRootView().getHeight());

                    Animator anim = ViewAnimationUtils.createCircularReveal(v.getRootView(),x,y,startRadius,endRadius);
                    v.getRootView().setVisibility(View.VISIBLE);

                    anim.start();*/
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
