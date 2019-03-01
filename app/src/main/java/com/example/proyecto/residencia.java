package com.example.proyecto;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class residencia extends Fragment {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHandler;
    private HashMap<String, List<String>> listHash;

    public residencia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_residencia, container, false);

        listView = v.findViewById(R.id.lista_objetivos);
        initData();
        listAdapter = new ExpandableListAdapter(getContext(),listDataHandler,listHash);
        listView.setAdapter(listAdapter);

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                setListViewHeight(parent,groupPosition);
                return false;
            }
        });

        CardView proyectos_Res = v.findViewById(R.id.proyectos_residencias);
        proyectos_Res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Descargando Archivo...",Toast.LENGTH_SHORT).show();
                Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.itmexicali.edu.mx/servicios1/residencias/BancoResidencias.xls"));
                startActivity(url);
            }
        }) ;

        CardView solicitud_SS = v.findViewById(R.id.soliciotud_residencias);
        solicitud_SS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Abriendo página web...",Toast.LENGTH_SHORT).show();

                Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse("http://r.practicasitm.net/"));
                startActivity(url);
            }
        });
        return v;
    }

    private void initData() {
        listDataHandler = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHandler.add("A. En el sector educativo");
        listDataHandler.add("B. En los organismos gubernamentales");
        listDataHandler.add("C. En los sectores productivos: empresariales, industriales y los servicios");

        List<String> educativo = new ArrayList<>();
        educativo.add("- Aumentar la vinculación entre la institución educativa y el entorno social y productivo.\n\n- Superar el desempeño profesional y de docencia del profesor asesor en funciones.\n\n- Tener un conocimiento más profundo del entorno social y productivo para procesos de actualización curricular y definición de especialidades.\n\n- Favorecer que la aplicación en el ámbito laboral, de los conocimientos adquiridos en la escuela, se fortalezcan y permitan descubrir nuevas posibilidades de aprendizaje ante una experiencia real.\n\n- Favorecer la obtención de experiencias por el alumno, al mismo tiempo que se está formando.\n\n- Favorecer la formación de egresados competitivos y conocedores de la problemática a la que deberán enfrentarse.");

        List<String> gubernam = new ArrayList<>();
        gubernam.add("- Integrar a los alumnos en proyectos de beneficio social o de desarrollo regional.\n\n- Participar en la asesoría, investigación y desarrollo de proyectos gubernamentales; por ejemplo, evaluaciones de impacto ambiental, diseño de redes y sistemas de bombeo, tendido de redes eléctricas, diseño de plantas de tratamiento de aguas municipales, diseño de sistemas de drenaje y alcantarillado, tendido de calles, etc.");

        List<String> produc = new ArrayList<>();
        produc.add("- Mejorar la capacitación del personal de las empresas, específicamente en los casos en los que el residente tenga oportunidad de laborar en la empresa o institución donde desarrolla su proyecto.\n\n- Promover la participación de estos sectores en: proyectos de investigación, desarrollo de nuevos productos o desarrollo tecnológico, apoyándose en la infraestructura del sector educativo y viceversa.\n\n- Reducir estos en diversas actividades de las empresas que los alumnos en residencia puedan desarrollar, previa capacitación; por ejemplo: control de inventarios, control de calidad, seguridad industrial, programas de mantenimiento, elaboración de manuales de operación, etc.\n\n- Suplir personal profesional en las empresas durante períodos vacacionales (previa capacitación y especificando claramente las condiciones bajo las cuales se regirá el alumno).\n\n- Conocer la calidad y características de la oferta de recursos humanos para seleccionar mejor a su personal.\n\n- Orientar a las instituciones educativas sobre los requerimientos de los futuros profesionales necesarios en la industria.\n\n- Desarrollar proyectos de industrialización de recursos bióticos, proyectos para el control de la contaminación ambiental, etc.");

        listHash.put(listDataHandler.get(0),educativo);
        listHash.put(listDataHandler.get(1),gubernam);
        listHash.put(listDataHandler.get(2),produc);
    }

    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Residencias");

    }

    private void setListViewHeight(ExpandableListView listView,
                                   int group) {
        ExpandableListAdapter listAdapter = (ExpandableListAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }

}
