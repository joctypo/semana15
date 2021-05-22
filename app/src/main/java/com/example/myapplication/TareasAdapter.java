package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

public class TareasAdapter extends BaseAdapter {

    ArrayList<Tareas> tareas;

    public TareasAdapter(){
        tareas = new ArrayList<>();
    }

    public void addTareas(Tareas tarea){
        tareas.add(tarea);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return tareas.size();
    }

    @Override
    public Object getItem(int position) {
        return tareas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      /*  LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.tareitas,null);
        TextView titulo = item.findViewById(R.id.titulo);
        TextView fecha = item.findViewById(R.id.fecha);
        TextView descripcion = item.findViewById(R.id.descripcion);

        titulo.setText(tareas.get(position).getTittle());
        fecha.setText(tareas.get(position).getDate());
        descripcion.setText(tareas.get(position).getDescription());
*/

        return null;
    }

    public void clear() {

        tareas.clear();
        notifyDataSetChanged();
    }
}
