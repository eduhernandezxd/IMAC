package com.ucab.tesis.imac.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.ucab.tesis.imac.modelo.Items;
import com.ucab.tesis.imac.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentB.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentB extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TextView texto_s;
    ImageView imagen_s;

    private List<String> list_padre;
    private HashMap<String,List<String>> listHashMap;

    public FragmentB() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentB.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentB newInstance(String param1, String param2) {
        FragmentB fragment = new FragmentB();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_b, container, false);

        texto_s = vista.findViewById(R.id.textoDetalle);
        imagen_s = vista.findViewById(R.id.fotodetalle);

        Bundle bundle = getArguments();
        Items datos = null;

        if(bundle != null){

            datos = (Items) bundle.getSerializable("objeto");
            imagen_s.setImageResource(datos.getObjeto3());
            texto_s.setText(datos.getObjeto4());
        }


        ExpandableListView expandableListView = vista.findViewById(R.id.expand_list);
        initData();
        ExpandableListAdapter expandableListAdapter = new com.ucab.tesis.imac.Adaptadores.ExpandableListAdapter(getContext(),list_padre,listHashMap);
        expandableListView.setAdapter(expandableListAdapter);

        return vista;
    }

    private void initData() {
        list_padre = new ArrayList<>();
        listHashMap = new HashMap<>();

        list_padre.add("Normas y Reglamentos");
        list_padre.add("Reseña Historica");
        list_padre.add("Vegetaciòn Arborea");
        list_padre.add("Actvidades Recreacionales");

        List<String> normas= new ArrayList<>();
        normas.add("Opcion 1");
        normas.add("Opcion 2");
        normas.add("Opcion 3");
        normas.add("Opcion 4");

        List<String> historia = new ArrayList<>();
        historia.add("Opcion 1");
        historia.add("Opcion 1");
        historia.add("Opcion 1");historia.add("Opcion 1");

        List<String> vegetal= new ArrayList<>();
        vegetal.add("Opcion 1");
        vegetal.add("Opcion 2");
        vegetal.add("Opcion 3");
        vegetal.add("Opcion 4");

        List<String> activi= new ArrayList<>();
        activi.add("Opcion 1");
        activi.add("Opcion 2");
        activi.add("Opcion 3");
        activi.add("Opcion 4");

        listHashMap.put(list_padre.get(0),normas);
        listHashMap.put(list_padre.get(1),historia);
        listHashMap.put(list_padre.get(2),vegetal);
        listHashMap.put(list_padre.get(3),activi);



    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
