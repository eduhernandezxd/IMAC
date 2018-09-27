package com.ucab.tesis.imac.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ucab.tesis.imac.modelo.InformacionParques;
import com.ucab.tesis.imac.modelo.InformacionParques_opciones;
import com.ucab.tesis.imac.modelo.Items;
import com.ucab.tesis.imac.R;

import java.util.ArrayList;

import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;

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

    ArrayList<InformacionParques> list_items;
    ArrayList<InformacionParques_opciones> list;

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

        //Lista de Opciones: Normas,Actividades,Historia,Vegetacion

        ExpandableLayout expandableLayout = vista.findViewById(R.id.expand_list);
        expandableLayout.setRenderer(new ExpandableLayout.Renderer<InformacionParques,
                InformacionParques_opciones>() {
            @Override
            public void renderParent(View view, InformacionParques informacionParques,
                                     boolean accion, int parentPosition) {

                ((TextView)view.findViewById(R.id.textView_padre))
                        .setText(informacionParques.getOpciones());
                view.findViewById(R.id.flecha_lista)
                        .setBackgroundResource(accion?R.drawable.ic_arrow_up:R.drawable.ic_arrow_down);
            }

            @Override
            public void renderChild(View view, InformacionParques_opciones info_p_o,
                                    int parentPosition, int childPosition) {

                ((TextView)view.findViewById(R.id.textView_hijo)).setText(info_p_o.getOpciones_adicionales());

            }
        });

        expandableLayout.addSection(getSection());
        expandableLayout.addSection(getSection());
        expandableLayout.addSection(getSection());
        expandableLayout.addSection(getSection());
        expandableLayout.addSection(getSection());
        expandableLayout.addSection(getSection());
        expandableLayout.addSection(getSection());
        expandableLayout.addSection(getSection());
        expandableLayout.addSection(getSection());
        expandableLayout.addSection(getSection());




        return vista;
    }

    private Section<InformacionParques,InformacionParques_opciones> getSection() {

        Section<InformacionParques,InformacionParques_opciones> section = new Section<>();



//        list_items = new ArrayList<>();
        list = new ArrayList<>();
        llenar_lista_opciones();
  //      llenar_lista_infoparques();

        InformacionParques info = new InformacionParques("PARQUE");
        section.parent = info;
        section.children.addAll(list);

        return section;
    }
 /*
    private void llenar_lista_infoparques() {
        list_items.add(new InformacionParques(R.string.normas));
        list_items.add(new InformacionParques(R.string.historia));
        list_items.add(new InformacionParques(R.string.vegetacion));
        list_items.add(new InformacionParques(R.string.actividades));
    }
*/
    private void llenar_lista_opciones() {
        list.add(new InformacionParques_opciones("Opcion 1"));
        list.add(new InformacionParques_opciones("Opcion 2"));
        list.add(new InformacionParques_opciones("Opcion 3"));
        list.add(new InformacionParques_opciones("Opcion 4"));
        list.add(new InformacionParques_opciones("Opcion 5"));

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
