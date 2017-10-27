package com.example.depis01.directoriomedico.MedicoDetail;


import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.depis01.directoriomedico.R;
import com.example.depis01.directoriomedico.datos.MedicosDbHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MedicoDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicoDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String ARG_MEDICO_ID = "medicoId";
    private  String mMedicoId;

    private CollapsingToolbarLayout mCollapsingView;
    private ImageView mAvatar;
    private TextView mPhoneNumber;
    private TextView mSpeciality;
    private TextView mBio;

    private MedicosDbHelper medicosDbHelper;

    public MedicoDetailFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MedicoDetailFragment newInstance(String mMedicoId) {
        MedicoDetailFragment fragment = new MedicoDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mMedicoId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            mMedicoId = getArguments().getString(ARG_MEDICO_ID); //asigna el argumento a mMedicoId
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_medico_detail,container,false);
        mCollapsingView = (CollapsingToolbarLayout)getActivity().findViewById(R.id.toolbar_layout);
        mAvatar = (ImageView)getActivity().findViewById(R.id.iv_avatar);
        mPhoneNumber = (TextView)root.findViewById(R.id.tv_phone_number);
        mSpeciality = (TextView)root.findViewById(R.id.tv_specialidad);
        mBio = (TextView)root.findViewById(R.id.tv_bio);

        medicosDbHelper = new MedicosDbHelper(getActivity());

        loadMedico();

        return root;


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

    }

}
