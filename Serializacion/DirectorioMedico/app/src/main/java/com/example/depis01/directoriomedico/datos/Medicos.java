package com.example.depis01.directoriomedico.datos;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.UUID;

public class Medicos {
    private String id,name,speciality,phoneNumber,bio,avatarUri;

    //constructo recibe un cursor
    public Medicos(Cursor cursor){
        id = cursor.getString(cursor.getColumnIndex(MedicosContract.MedicosEntry.ID));
        name = cursor.getString(cursor.getColumnIndex(MedicosContract.MedicosEntry.NAME));
        speciality = cursor.getString(cursor.getColumnIndex(MedicosContract.MedicosEntry.SPECIALTY));
        phoneNumber = cursor.getString(cursor.getColumnIndex(MedicosContract.MedicosEntry.PHONE_NUMBER));
        bio = cursor.getString(cursor.getColumnIndex(MedicosContract.MedicosEntry.BIO));
        avatarUri = cursor.getString(cursor.getColumnIndex(MedicosContract.MedicosEntry.AVATAR_URI));
    }

    public Medicos(String name, String speciality, String phoneNumber, String bio, String avatarUri) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.avatarUri = avatarUri;
    }

    public ContentValues toContentValues(){

        ContentValues values = new ContentValues();

        values.put(MedicosContract.MedicosEntry.ID,id);
        values.put(MedicosContract.MedicosEntry.NAME,name);
        values.put(MedicosContract.MedicosEntry.SPECIALTY,speciality);
        values.put(MedicosContract.MedicosEntry.PHONE_NUMBER,phoneNumber);
        values.put(MedicosContract.MedicosEntry.BIO,bio);
        values.put(MedicosContract.MedicosEntry.AVATAR_URI,avatarUri);
        return values;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }
}
