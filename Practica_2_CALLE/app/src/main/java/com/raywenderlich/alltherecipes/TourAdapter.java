package com.raywenderlich.alltherecipes;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class TourAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Tour> mDataSource;

    public TourAdapter(Context context, ArrayList<Tour> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { return mDataSource.size();  }

    //2
    @Override
    public Object getItem(int position) {   return mDataSource.get(position);   }

    //3
    @Override
    public long getItemId(int position) {   return position;    }

    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_tour, parent, false);
        // Get title element
        TextView titleTextView =
                (TextView) rowView.findViewById(com.raywenderlich.alltherecipes.R.id.tour_list_title);
        // Get subtitle element
        TextView subtitleTextView =
                (TextView) rowView.findViewById(com.raywenderlich.alltherecipes.R.id.tour_list_subtitle);
        // Get detail element
        TextView detailTextView =
                (TextView) rowView.findViewById(com.raywenderlich.alltherecipes.R.id.tour_list_detail);
        // Get thumbnail element
        ImageView thumbnailImageView =
                (ImageView) rowView.findViewById(R.id.tour_list_thumbnail);
        // 1
        Tour tour = (Tour) getItem(position);
        // 2
        titleTextView.setText(tour.titulo);
        subtitleTextView.setText(tour.descripcion);
        detailTextView.setText(tour.dias + "\ndías");
        // 3
        Picasso.with(mContext).load(tour.imagen).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        return rowView;
    }
}
