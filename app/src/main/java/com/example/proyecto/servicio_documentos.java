package com.example.proyecto;


import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class servicio_documentos extends Fragment {


    Animation fade1;
    public servicio_documentos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_servicio_documentos, container, false);

        Typeface custom_font = Typeface.createFromAsset(getContext().getApplicationContext().getAssets(),  "poppins_regular.otf");
        TextView texto1 = v.findViewById(R.id.t1);
        texto1.setTypeface(custom_font);

        TextView texto2 = v.findViewById(R.id.t2);
        texto2.setTypeface(custom_font);

        TextView texto3 = v.findViewById(R.id.t3);
        texto3.setTypeface(custom_font);

        fade1= AnimationUtils.loadAnimation(getContext(), R.anim.fadein);
        texto1.setAnimation(fade1);
        fade1= AnimationUtils.loadAnimation(getContext(), R.anim.fadein);
        texto2.setAnimation(fade1);
        fade1= AnimationUtils.loadAnimation(getContext(), R.anim.fadein);
        texto3.setAnimation(fade1);

        View view = v.findViewById(R.id.view_docu);
        view.setOnTouchListener(new OnSwipeTouchListener(getContext()) {

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right,R.anim.enter_from_right, R.anim.exit_to_right).replace(R.id.content_main, new fragmento_servicio_social()).commit();
            }

        });

        ImageView img = v.findViewById(R.id.regresa_docu);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right,R.anim.enter_from_right, R.anim.exit_to_right).replace(R.id.content_main, new fragmento_servicio_social()).commit();
            }
        });
        return v;
    }





}
