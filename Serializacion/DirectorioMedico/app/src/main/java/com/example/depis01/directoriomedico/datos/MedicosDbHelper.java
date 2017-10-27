package com.example.depis01.directoriomedico.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DEPIS01 on 06/10/2017.
 */

public class MedicosDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="medicos.db";

    public MedicosDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    public long mockMedicos(SQLiteDatabase db, Medicos medicos){
        return db.insert(MedicosContract.MedicosEntry.TABLE_NAME,null,medicos.toContentValues());
    }

    public void mockData(SQLiteDatabase db){
        mockMedicos(db,new Medicos("Carlos Sanchez", "Medicos Emergencista","300 200 1111","Gran profesional con experiencia de 5 años","carlos_sanchez.jpg"));
        mockMedicos(db,new Medicos("Juan Perez", "Medicos Emergencista","300 200 1111","Gran profesional con experiencia de 10 años","juan_perez.jpg"));
        mockMedicos(db,new Medicos("Andrea Faucheux", "Medicos Cirujano","300 200 1111","Gran profesional con experiencia de 4 años","andrea_faucheux.jpg"));
        mockMedicos(db,new Medicos("Maria Ramos", "Medicos Obstetra","300 200 1111","Gran profesional con experiencia de 5 años","maria_ramos.jpg"));
        mockMedicos(db,new Medicos("Nicole Faucheux", "Medicos Emergencista","300 200 1111","Gran profesional con experiencia de 3 años","nicole_faucheux.jpg"));
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "
                + MedicosContract.MedicosEntry.TABLE_NAME
                + "("
                + MedicosContract.MedicosEntry._ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MedicosContract.MedicosEntry.ID
                + " TEXT NOT NULL,"
                + MedicosContract.MedicosEntry.NAME
                + " TEXT NOT NULL,"
                + MedicosContract.MedicosEntry.SPECIALTY
                + " TEXT NOT NULL,"
                + MedicosContract.MedicosEntry.PHONE_NUMBER
                + " TEXT NOT NULL,"
                + MedicosContract.MedicosEntry.BIO
                + " TEXT NOT NULL,"
                + MedicosContract.MedicosEntry.AVATAR_URI
                + " TEXT, "
                + "UNIQUE (" + MedicosContract.MedicosEntry.ID +"))"
        );
        //insercion de datos
        mockData(sqLiteDatabase);
    }

    public Cursor getAllMedicos(){
        return getReadableDatabase()
                .query(MedicosContract.MedicosEntry.TABLE_NAME
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }
    //para obtener un solo valor
    public Cursor getMedicoById(String medicoId){
        return getReadableDatabase()
                .query(MedicosContract.MedicosEntry.TABLE_NAME
                        ,null
                        ,MedicosContract.MedicosEntry.ID + " LIKE ?"
                        , new String[]{medicoId}
                        ,null
                        ,null
                        ,null);
    }

    //metodo para grabar datos
    public long saveMedico(Medicos medicos){
         SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(MedicosContract.MedicosEntry.TABLE_NAME,null,medicos.toContentValues());
    }

    //metodo actualizar datos
    public int updateMedico(Medicos medicos,String medicoId){
        return getWritableDatabase()
                .update(MedicosContract.MedicosEntry.TABLE_NAME
                ,medicos.toContentValues()
                ,MedicosContract.MedicosEntry.ID + " LIKE ?"
                        ,new String[]{medicoId});
    }
    //
    public int deleteMedico(String medicoId){
        return getWritableDatabase()
                .delete(MedicosContract.MedicosEntry.TABLE_NAME
                        ,MedicosContract.MedicosEntry.ID + " LIKE ?"
                        ,new String[]{medicoId}
                        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
