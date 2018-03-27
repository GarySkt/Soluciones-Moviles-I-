/*
 * Copyright (c) 2016 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.raywenderlich.alltherecipes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

  private ListView mListView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Get data to display
    final ArrayList<Tour> tourList = Tour.getToursFromFile("tours.json", this);
    // Create adapter
    TourAdapter adapter = new TourAdapter(this, tourList);
    // Create list view
    mListView = (ListView) findViewById(R.id.tour_list_view);
    mListView.setAdapter(adapter);

    final Context context = this;
    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // 1
        Tour selectedRecipe = tourList.get(position);
        // 2
        Intent tourFragment = new Intent(context, TourDetailActivity.class);
        // 3
        tourFragment.putExtra("title", selectedRecipe.titulo);
        tourFragment.putExtra("imagen", selectedRecipe.imagen);
        tourFragment.putExtra("descripcion", selectedRecipe.descripcion);
        tourFragment.putExtra("persona", selectedRecipe.persona);
        tourFragment.putExtra("dias", selectedRecipe.dias);
        tourFragment.putExtra("precio", selectedRecipe.precio);
        tourFragment.putExtra("url", selectedRecipe.Url);
        // 4
        startActivity(tourFragment);
      }

    });
  }

}
