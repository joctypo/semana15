package com.example.myapplication;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tareas {

    private String id;
    private String tittle;
    private String description;
    private String date;
    private boolean completed;
   // private String pendiente;

    public Tareas(String  date, String id, String tittle, String description){
        this.id = id;
        this.tittle = tittle;
        this.description = description;
       // this.date = new Date().getTime();
        this.date = date;
       // this.pendiente = pend;
    }

    /*public String getDateStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date();
        date.setTime(this.date);
        return sdf.format(date);

    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}