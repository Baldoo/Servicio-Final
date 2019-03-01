package com.example.proyecto;


import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class incubacion extends Fragment {

    private TextSwitcher textSwitcher;
    private int stringIndex = 0;
    private String[] opciones = {"1. Vinculación con personal calificado para asesorías en general, (fiscal, contable, mercadológica, propiedad intelectual, diseño, entre otras)",
            "\n2. Capacitación y asesoría para el desarrollo de tu plan de negocios",
            "3. Servicio de vinculación para la elaboración de tabla nutrimental, diseño y registro de marca, código de barras",
            "\n4. Espacios físicos para que inicies trabajando",
            "\n5. Vinculación para financiamiento"};
    private ArrayList<String> texto_incubacion = new ArrayList<>();
    private TextView texto;
    ImageView img, contacto;
    Dialog dialogo;
    Chronometer reloj;

    public incubacion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_incubacion3, container, false);
        reloj = v.findViewById(R.id.tiempo);

        reloj.setBase(SystemClock.elapsedRealtime());
        dialogo = new Dialog(getContext());

        CardView boton_mision = v.findViewById(R.id.boton_mision);
        boton_mision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.setContentView(R.layout.incubacion_items);
                texto = (TextView) dialogo.findViewById(R.id.texto_incubacion);
                texto.setTextColor(getResources().getColor(R.color.negro));
                texto.setText("\nMisión: \n\nSer un organismo capaz de generar y consolidar ideas, que se puedan convertir en empresas. A través de la promoción, generación y desarrollo de una cultura emprendedora e innovadora dentro de nuestro instituto, nuestra región y nuestro país. Siendo el medio por el cual sé proporcione: orientación profesional, asesoría especializada, seguimiento y consolidación empresarial.");
                dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogo.show();
            }
        });

        CardView boton_vision = v.findViewById(R.id.boton_vision);
        boton_vision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.setContentView(R.layout.incubacion_items);
                CardView card = dialogo.findViewById(R.id.carta_incubacion);
                card.setBackgroundColor(getResources().getColor(R.color.dark_blue));
                texto = dialogo.findViewById(R.id.texto_incubacion);
                texto.setText("\nVisión: \n\nSer una incubadora de tecnología intermedia capaz de promover, difundir, formalizar y consolidar la actividad empresarial entre nuestros estudiantes, nuestros egresados, nuestra región y nuestro país. Impulsando el crecimiento y desarrollo económico que a su vez mejoren la calidad de vida de  nuestra sociedad.");
                dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogo.show();
            }
        });

        CardView boton_valores = v.findViewById(R.id.boton_valores);
        boton_valores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.setContentView(R.layout.incubacion_items);
                CardView card = dialogo.findViewById(R.id.carta_incubacion);
                card.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
                texto = dialogo.findViewById(R.id.texto_incubacion);
                texto.setText("\nValores:\n\n Ética profesional. Confiere el gran compromiso de actuar dentro del marco de la Ley y de prevenir a los usuarios del servicio de los posibles riesgos que su idea puede generar. Honestidad. Aclarar en todo momento las ventajas y desventajas de los proyectos. Iniciativa. Ir de manera decidida hacia la búsqueda permanente de nuestros objetivos y metas, entendiendo que el manejo adecuado del tiempo en un valor agregado es el emprendedurismo.");
                dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogo.show();
            }
        });

        CardView boton_objetivo = v.findViewById(R.id.boton_objetivo);
        boton_objetivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.setContentView(R.layout.incubacion_items);
                CardView card = dialogo.findViewById(R.id.carta_incubacion);
                card.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                texto = dialogo.findViewById(R.id.texto_incubacion);
                texto.setText("\nObjetivo:\n\nEl objetivo de la incubadora dentro de la institución es impulsar la cultura empresarial y fomentar el desarrollo de la innovación tecnológica de productos, procesos y servicios, a través de la aplicación de tecnologías, obteniendo con ello:\n\n- La creación de empresas y empleos.\n- Las oportunidades de desarrollo para nuestros profesionistas.");
                dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogo.show();
            }
        });



        reloj.start();
        reloj.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {

                if (reloj.getText().toString().equals("00:04")||reloj.getText().toString().equals("00:08")
                        ||reloj.getText().toString().equals("00:12")||reloj.getText().toString().equals("00:16")
                        ||reloj.getText().toString().equals("00:20")||reloj.getText().toString().equals("00:24")
                        ||reloj.getText().toString().equals("00:28")||reloj.getText().toString().equals("00:32")
                        ||reloj.getText().toString().equals("00:36")||reloj.getText().toString().equals("00:40")
                        ||reloj.getText().toString().equals("00:44")||reloj.getText().toString().equals("00:48"))
                {
                    if(stringIndex == opciones.length-1) {
                        stringIndex = 0;
                        textSwitcher.setText(opciones[stringIndex]);
                    }else{
                        textSwitcher.setText(opciones[++stringIndex]);
                    }
                }

            }
        });


        CardView carta = v.findViewById(R.id.carta_switcher);
        carta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stringIndex == opciones.length-1) {
                    stringIndex = 0;
                    textSwitcher.setText(opciones[stringIndex]);
                    reloj.setBase(SystemClock.elapsedRealtime());
                }else{
                    textSwitcher.setText(opciones[++stringIndex]);
                    reloj.setBase(SystemClock.elapsedRealtime());
                }
            }
        });

        textSwitcher = v.findViewById(R.id.servicios_Tswitcher);
        textSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stringIndex == opciones.length-1) {
                    stringIndex = 0;
                    textSwitcher.setText(opciones[stringIndex]);
                    reloj.setBase(SystemClock.elapsedRealtime());
                }else{
                    textSwitcher.setText(opciones[++stringIndex]);
                    reloj.setBase(SystemClock.elapsedRealtime());
                }
            }
        });

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                texto = new TextView(getContext());
                texto.setTextColor(Color.BLACK);
                texto.setTextSize(16);
                texto.setGravity(Gravity.CENTER);
                return texto;
            }
        });
        textSwitcher.setText(opciones[stringIndex]);

        img = v.findViewById(R.id.logo_face);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/IncubadoraITM"));
                startActivity(url);
            }
        });

        contacto = v.findViewById(R.id.contacto);
        contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.setContentView(R.layout.incubacion_items);
                texto = dialogo.findViewById(R.id.texto_incubacion);
                texto.setTextColor(getResources().getColor(R.color.negro));
                texto.setText(" Horario: Lunes a Viernes de 8:00 - 14:00\n Dirección: Av. Tecnológico S/N Col.Elías Calles, Mexicali, B.C., CP 21376\n Edificio L\n Tel: 5804927\n Correo: incubadora@itmexicali.edu.mx");
                dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogo.show();
            }
        });
        return v;
    }

    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Centro de Incubación");

    }


}
