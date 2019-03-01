package com.example.proyecto;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Noticias extends Fragment{


    int[] img ={R.drawable.ic_fiber_new_black_24dp, R.drawable.ic_fiber_new_black_24dp,
            R.drawable.ic_fiber_new_black_24dp, R.drawable.ic_fiber_new_black_24dp};

    String[] titulo = {"Titulo 1", "Titulo 2", "Titulo 3", "Titulo 4"};

    String[] desc = {"Descripcion Noticia 1", "Descripcion Noticia 2", "Descripcion Noticia 3", "Descripcion Noticia 4"};

    private OnFragmentInteractionListener mListener;

    public Noticias() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_noticias, container, false);

        ListView lista_noticias = (ListView) view.findViewById(R.id.lista_noticias);

        CustomAdapter customAdapter = new CustomAdapter();
        lista_noticias.setAdapter(customAdapter);

        // Inflate the layout for this fragment
        return view;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return img.length;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.item_list_layout, null);

            ImageView imageView = (ImageView)view.findViewById(R.id.imagen_noticia);
            TextView titulo_lista = (TextView)view.findViewById(R.id.titulo);
            TextView descripcion_lista = (TextView)view.findViewById(R.id.desc);

            imageView.setImageResource(img[i]);
            titulo_lista.setText(titulo[i]);
            descripcion_lista.setText(desc[i]);

            return view;
        }
    }

    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Noticias");

    }
}
