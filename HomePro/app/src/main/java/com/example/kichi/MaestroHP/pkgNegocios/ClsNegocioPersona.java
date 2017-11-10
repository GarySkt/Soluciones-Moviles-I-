package com.example.kichi.MaestroHP.pkgNegocios;



import android.content.Context;
import android.widget.Toast;

import com.example.kichi.MaestroHP.pkgEntidad.ClsEntidadPersona;
import com.example.kichi.MaestroHP.pkgNegociosParticulares.ClsConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Kichi on 29/08/2017.
 */

public class ClsNegocioPersona {
    public ClsConexion con;

    private Context context;
    public ClsNegocioPersona(Context context){
        this.context = context;
    }

    public void AgregarPersona(ClsEntidadPersona persona){
        con = new ClsConexion();
        String cadenaSql = "insert into tbl_persona values (?,?,?,?,?,?,?)";
        try {
            Connection connection = con.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(cadenaSql);
            preparedStatement.setString(1,persona.getEmail_persona());
            preparedStatement.setString(2,persona.getNombre_persona());
            preparedStatement.setString(3,persona.getApellido_persona());
            preparedStatement.setString(4,persona.getTelefono_persona());
            preparedStatement.setString(5,persona.getDireccion_persona());
            preparedStatement.setString(6,persona.getPassword_persona());
            preparedStatement.setString(7,persona.getFoto_persona());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            mensaje("Usuario registrado correctamente.");

        }catch (Exception e){
            mensaje("Error al registrar usuario.");
        }
    }

    private void mensaje(String msg){
        Toast.makeText(this.context, msg, Toast.LENGTH_LONG).show();
    }

}
