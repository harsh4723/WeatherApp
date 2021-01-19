package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomItemAdapter extends RecyclerView.Adapter<CustomItemAdapter.ViewHolder> {


    private ArrayList<ListItems> listItems;

    public CustomItemAdapter(ArrayList<ListItems> listItem) {
        this.listItems = listItem;
    }


    public void updateListItems(List<ListItems> newListItems) {
        listItems.clear();
        listItems.addAll(newListItems);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItems listItem = listItems.get(position);
        String st = listItem.temp+" °C";
        holder.temp.setText(st);
        String st1 = listItem.rain +"%";
        holder.rain.setText(st1);
        String st2 = listItem.wind +" km/hr";
        holder.wind.setText(st2);
        String date = listItem.time;
        Date expiry = new Date(Long.parseLong(date));
        String str = new SimpleDateFormat("dd/MM/yyyy").format(expiry);
        holder.time.setText(str);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView temp;
        TextView rain;
        TextView wind;
        TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            temp = itemView.findViewById(R.id.temperatureText);
            rain = itemView.findViewById(R.id.rain);
            wind = itemView.findViewById(R.id.wind);
            time = itemView.findViewById(R.id.DateText);

        }
    }
}

