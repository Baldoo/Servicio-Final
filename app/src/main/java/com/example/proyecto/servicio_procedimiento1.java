package com.example.proyecto;


import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class servicio_procedimiento1 extends Fragment {

int i = 1, inicio=0, actual=1, anterior=0, siguiente=2;

    public servicio_procedimiento1() {
        // Required empty public constructor
    }

    Animation fromRight, toRight, fromLeft, toLeft, fromBot, fadeIn, fadeOut;
    Chronometer reloj;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_servicio_procedimiento1, container, false);

        reloj = v.findViewById(R.id.reloj);
        reloj.setBase(SystemClock.elapsedRealtime());

        final LottieAnimationView animationView = v.findViewById(R.id.animacion);
        final LottieAnimationView animationView2 = v.findViewById(R.id.animacion_swipe);
        final LottieAnimationView tiempo = v.findViewById(R.id.tiempo);

        Typeface custom_font = Typeface.createFromAsset(getContext().getAssets(),  "poppins_regular.otf");
        final TextView texto = v.findViewById(R.id.text1);
        texto.setTypeface(custom_font);
        final TextView texto2 = v.findViewById(R.id.text2);
        texto2.setTypeface(custom_font);
        final TextView num = v.findViewById(R.id.num);
        num.setTypeface(custom_font);

        final ImageView avanzar = v.findViewById(R.id.avanzar_proc);
        final ImageView atras = v.findViewById(R.id.atras_proc);

        final ImageView edificio = v.findViewById(R.id.edificio);
        final ImageView solicitud = v.findViewById(R.id.solicitud1);

        fromRight = AnimationUtils.loadAnimation(getContext(), R.anim.from_right);
        fromLeft = AnimationUtils.loadAnimation(getContext(), R.anim.from_left);
        toRight = AnimationUtils.loadAnimation(getContext(), R.anim.to_right);
        toLeft = AnimationUtils.loadAnimation(getContext(), R.anim.to_left);
        fromBot = AnimationUtils.loadAnimation(getContext(), R.anim.from_bot);
        fadeIn = AnimationUtils.loadAnimation(getContext(), R.anim.fadein);

        if(inicio == 0)
        {
            atras.setVisibility(View.INVISIBLE);
            texto2.setVisibility(View.INVISIBLE);
            solicitud.setVisibility(View.INVISIBLE);
            texto.setText("Los alumnos interesados que cumplan con los requisitos anteriores, deberán dirigirse a la oficina de Servicio Social.");
            edificio.setAnimation(fromRight);
            texto.setAnimation(fromBot);
            tiempo.setSpeed(3);
            tiempo.playAnimation();
        }

        reloj.start();
        reloj.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(reloj.getText().toString().equals("00:05")||reloj.getText().toString().equals("00:10")
                        ||reloj.getText().toString().equals("00:15")||reloj.getText().toString().equals("00:20")
                        ||reloj.getText().toString().equals("00:25")||reloj.getText().toString().equals("00:30")
                        ||reloj.getText().toString().equals("00:35")||reloj.getText().toString().equals("00:40")
                        ||reloj.getText().toString().equals("00:45")) {
                    if(i==8)
                        getActivity().finish();
                    else {
                        anterior = i;
                        i++;
                        actual++;
                        siguiente++;
                        Cambio(i, num, atras, solicitud, texto, texto2, edificio, animationView, tiempo);
                    }
                }

                if(reloj.getText().toString().equals("00:00") && inicio==0)
                {
                    inicio = 1;
                    animationView2.setVisibility(View.VISIBLE);
                    animationView2.playAnimation();
                }

                if(reloj.getText().toString().equals("00:04"))
                {
                    animationView2.setAnimation(fadeOut);
                }
            }
        });


        avanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==8)
                    getActivity().finish();
                else {
                    anterior = i;
                    i++;
                    actual++;
                    siguiente++;
                    Cambio(i, num, atras, solicitud, texto, texto2, edificio, animationView, tiempo);
                    reloj.setBase(SystemClock.elapsedRealtime());
                }
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==1)
                    getActivity().finish();
                else {
                    anterior = i;
                    i--;
                    actual--;
                    siguiente--;
                    Cambio(i,num, atras, solicitud, texto, texto2, edificio, animationView, tiempo);
                    reloj.setBase(SystemClock.elapsedRealtime());
                }
            }
        });


        View view = v.findViewById(R.id.procedimientos);
        view.setOnTouchListener(new OnSwipeTouchListener(getContext()) {

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if(i==8) {
                    solicitud.setVisibility(View.INVISIBLE);
                    edificio.setVisibility(View.INVISIBLE);
                    texto.setVisibility(View.INVISIBLE);
                    texto2.setVisibility(View.INVISIBLE);
                    getActivity().finish();
                }
                else {
                    anterior = i;
                    i++;
                    actual++;
                    siguiente++;
                    Cambio(i, num, atras, solicitud, texto, texto2, edificio, animationView, tiempo);
                    reloj.setBase(SystemClock.elapsedRealtime());
                }
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if(i==1) {
                    solicitud.setVisibility(View.INVISIBLE);
                    edificio.setVisibility(View.INVISIBLE);
                    texto.setVisibility(View.INVISIBLE);
                    texto2.setVisibility(View.INVISIBLE);
                    getActivity().finish();
                }
                else {
                    anterior = i;
                    i--;
                    actual--;
                    siguiente--;
                    Cambio(i, num, atras, solicitud, texto, texto2, edificio, animationView, tiempo);
                    reloj.setBase(SystemClock.elapsedRealtime());
                }
            }
        });


        return v;
    }

    public void Cambio(int i, TextView num, ImageView atras, ImageView solicitud, TextView texto, TextView texto2, ImageView edificio, LottieAnimationView animationView, LottieAnimationView tiempo)
    {
        double n = 2.8;
        fromRight = AnimationUtils.loadAnimation(getContext(), R.anim.from_right);
        fromLeft = AnimationUtils.loadAnimation(getContext(), R.anim.from_left);
        toRight = AnimationUtils.loadAnimation(getContext(), R.anim.to_right);
        toLeft = AnimationUtils.loadAnimation(getContext(), R.anim.to_left);
        fromBot = AnimationUtils.loadAnimation(getContext(), R.anim.from_bot);
        fadeIn = AnimationUtils.loadAnimation(getContext(), R.anim.fadein);
        fadeOut = AnimationUtils.loadAnimation(getContext(), R.anim.fadeout);

        switch(i)
        {
            case 1:
                edificio.setImageResource(R.drawable.edificio);
                animationView.setAnimation(fadeOut);
                animationView.setVisibility(View.INVISIBLE);
                num.setText("1");
                num.setAnimation(fadeIn);
                atras.setVisibility(View.INVISIBLE);
                solicitud.setVisibility(View.INVISIBLE);
                texto.setText("Los alumnos interesados que cumplan con los requisitos anteriores, deberán dirigirse a la oficina de Servicio Social.");
                texto.setVisibility(View.VISIBLE);
                texto.setAnimation(fromBot);
                edificio.setVisibility(View.VISIBLE);
                edificio.setAnimation(fromRight);
                texto2.setVisibility(View.INVISIBLE);
                texto2.setAnimation(toRight);
                break;

            case 2:
                tiempo.setSpeed((float) n);
                tiempo.setProgress(0);
                tiempo.playAnimation();
                animationView.setAnimation(fadeIn);
                animationView.setAnimation("pencil_anim.json");
                animationView.setVisibility(View.VISIBLE);
                animationView.playAnimation();
                animationView.loop(true);
                num.setText("2");
                num.setAnimation(fadeIn);
                atras.setVisibility(View.VISIBLE);
                texto2.setText("Se deberá llenar una solicitud, para asignar plaza en función de las necesidades de las organizaciones y perfil de los alumnos. También se llenará una carta compromiso para integrar su expediente.");
                texto2.setVisibility(View.VISIBLE);
                texto2.setAnimation(fromBot);
                texto.setAnimation(toRight);
                texto.setVisibility(View.INVISIBLE);
                if(anterior==0) {
                    edificio.setAnimation(toRight);
                }
                edificio.setVisibility(View.INVISIBLE);
                solicitud.setVisibility(View.INVISIBLE);
                break;

            case 3:
                tiempo.setSpeed((float) n);
                tiempo.setProgress(0);
                tiempo.playAnimation();
                animationView.setVisibility(View.VISIBLE);
                animationView.setAnimation(fadeIn);
                animationView.setAnimation("paper.json");
                animationView.loop(true);
                animationView.playAnimation();
                num.setText("3");
                num.setAnimation(fadeIn);
                texto.setText("El Departamento elaborará una carta de Presentación, la cuál el alumno entregará posteriormente en la Dependencia o Institución.");
                edificio.setVisibility(View.INVISIBLE);
                texto.setVisibility(View.VISIBLE);
                texto.setAnimation(fromBot);
                texto2.setAnimation(toRight);
                texto2.setVisibility(View.INVISIBLE);
                break;

            case 4:
                tiempo.setSpeed((float) n);
                tiempo.setProgress(0);
                tiempo.playAnimation();
                animationView.setVisibility(View.VISIBLE);
                animationView.setAnimation("success.json");
                animationView.playAnimation();
                num.setText("4");
                num.setAnimation(fadeIn);
                edificio.setImageResource(R.drawable.plan_trabajo);
                edificio.setVisibility(View.INVISIBLE);
                texto2.setText("El alumno solicita carta de Aceptación a la Dependencia o Institución y elabora un plan de Trabajo.");
                texto2.setVisibility(View.VISIBLE);
                texto2.setAnimation(fromBot);
                texto.setAnimation(toRight);
                texto.setVisibility(View.INVISIBLE);
                break;

            case 5:
                tiempo.setSpeed((float) n);
                tiempo.setProgress(0);
                tiempo.playAnimation();
                animationView.setVisibility(View.VISIBLE);
                animationView.setAnimation(fadeIn);
                animationView.setAnimation("checkmark.json");
                animationView.loop(true);
                animationView.playAnimation();
                num.setText("5");
                num.setAnimation(fadeIn);
                texto.setText("El alumno entrega la carta de Aceptación y el Plan de Trabajo en la oficina de servicio social (original y copia). Hasta entonces oficialmente el alumno inicia su servicio social.");
                texto.setVisibility(View.VISIBLE);
                texto.setAnimation(fromBot);
                texto2.setAnimation(toRight);
                texto2.setVisibility(View.INVISIBLE);
                break;

            case 6:
                tiempo.setSpeed((float) n);
                tiempo.setProgress(0);
                tiempo.playAnimation();
                animationView.setVisibility(View.VISIBLE);
                animationView.setAnimation("keyboard.json");
                animationView.playAnimation();
                animationView.setAnimation(fadeIn);
                num.setText("6");
                num.setAnimation(fadeIn);
                texto2.setText("Durante el desarrollo de servicio social el alumno elaborará Reportes Bimestrales de las actividades que realiza, los cuales deberán ser entregados en la oficina de servicio social en el tiempo estipulado (original y copia).");
                texto2.setVisibility(View.VISIBLE);
                texto2.setAnimation(fromBot);
                texto.setAnimation(toRight);
                texto.setVisibility(View.INVISIBLE);
                break;

            case 7:
                tiempo.setSpeed((float) n);
                tiempo.setProgress(0);
                tiempo.playAnimation();
                animationView.setVisibility(View.VISIBLE);
                animationView.setAnimation(fadeIn);
                animationView.setAnimation("recibido.json");
                animationView.playAnimation();
                num.setText("7");
                num.setAnimation(fadeIn);
                texto.setText("La oficina de servicio social recibe los reportes y firma la copia de recibido como evidencia de entregado por el alumno.");
                texto.setVisibility(View.VISIBLE);
                texto.setAnimation(fromBot);
                texto2.setAnimation(toRight);
                texto2.setVisibility(View.INVISIBLE);
                break;

            case 8:
                tiempo.setSpeed((float) n);
                tiempo.setProgress(0);
                tiempo.playAnimation();
                animationView.setVisibility(View.VISIBLE);
                animationView.setAnimation("trophy.json");
                animationView.setAnimation(fadeIn);
                animationView.playAnimation();
                num.setText("8");
                num.setAnimation(fadeIn);
                texto2.setText("Al concluir el periodo, el alumno deberá presentar Constancia de Terminación de Servicio Social y Memoria Final.");
                texto2.setVisibility(View.VISIBLE);
                texto2.setAnimation(fromBot);
                texto.setAnimation(toRight);
                texto.setVisibility(View.INVISIBLE);
                break;

        }
    }
}
