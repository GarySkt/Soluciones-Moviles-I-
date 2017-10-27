package com.example.depis01.directoriomedico.datos;

import android.provider.BaseColumns;

public class MedicosContract {
    public static abstract class MedicosEntry implements BaseColumns{
        public static final String TABLE_NAME="medicos";
        public static final String ID="id";
        public static final String NAME="name";
        public static final String SPECIALTY="speciality";
        public static final String PHONE_NUMBER="phoneNumber";
        public static final String BIO="bio";
        public static final String AVATAR_URI="avatarUri";
    }
}
