package com.example.depis01.directoriomedico.datos;


import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.depis01.directoriomedico.R;

public class MedicosCursorAdapter extends CursorAdapter{

    public MedicosCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_item_medico,viewGroup,false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        TextView name = (TextView)view.findViewById(R.id.tv_name);
        final ImageView image = (ImageView)view.findViewById(R.id.iv_avatar);
        String nombre = cursor.getString(cursor
        .getColumnIndex(MedicosContract.MedicosEntry.NAME));
        String imagen = cursor.getString(cursor
        .getColumnIndex(MedicosContract.MedicosEntry.AVATAR_URI));

        //mostrar
        name.setText(nombre);
        Glide.with(context)
                .load(Uri.parse("file:///android_asset/" + imagen))
                .asBitmap()
                .error(R.drawable.ic_account_circle)
                .centerCrop()
                .into(new BitmapImageViewTarget(image){
                    @Override
                    protected void setResource(Bitmap resource){
                        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory
                                .create(context.getResources()
                                ,resource);
                        drawable.setCircular(true);
                        image.setImageDrawable(drawable);
                    }
                });
    }
}
