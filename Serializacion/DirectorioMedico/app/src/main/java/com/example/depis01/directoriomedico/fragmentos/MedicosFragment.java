package com.example.depis01.directoriomedico.fragmentos;


import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.depis01.directoriomedico.R;
import com.example.depis01.directoriomedico.datos.MedicosCursorAdapter;
import com.example.depis01.directoriomedico.datos.MedicosDbHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicosFragment extends Fragment {

    MedicosCursorAdapter mMedicosAdapter;
    MedicosDbHelper mMedicosDbHelper;

    public MedicosFragment() {
        // Required empty public constructor
    }

    public static MedicosFragment newInstance(){
        return new MedicosFragment();
    }

    public static MedicosFragment newInstance(String p1,String p2){
        return new MedicosFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_medicos
                , container, false);

        ListView listView = (ListView)root.findViewById(R.id.medicos_list);

        mMedicosAdapter = new MedicosCursorAdapter(getActivity(),null,0);

        listView.setAdapter(mMedicosAdapter);

        mMedicosDbHelper = new MedicosDbHelper(getActivity());
        loadMedicos();

        return root;
    }
    private void loadMedicos(){
        //carga la lista
        new MedicosLoadTask().execute();

    }

    private class MedicosLoadTask extends AsyncTask<Void,Void,Cursor>{

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mMedicosDbHelper.getAllMedicos();
        }
        @Override
        protected void onPostExecute(Cursor c){
            if (c != null && c.getCount() > 0){

                mMedicosAdapter.swapCursor(c);//asigna el cursor al adaptador que actualiza la vista
            }else {
                //mostrar empty state
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
