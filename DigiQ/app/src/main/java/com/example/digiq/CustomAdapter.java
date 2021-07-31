package com.example.digiq;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] localDataSet;
    private Context context;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final  TextView desc;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            title = (TextView) view.findViewById(R.id.textView8);
            desc = (TextView) view.findViewById(R.id.textView9);
        }

        public TextView getTitle() {
            return title;
        }
        public TextView getDesc() {return  desc; }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter(String[] dataSet, Context context) {
        localDataSet = dataSet;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.my_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position ) {
        viewHolder.getTitle().setText(localDataSet[position]);
        String num = Integer.toString(position+1);
        viewHolder.getDesc().setText(num);
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }

}

