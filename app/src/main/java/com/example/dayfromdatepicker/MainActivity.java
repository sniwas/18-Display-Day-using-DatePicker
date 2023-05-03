package com.example.dayfromdatepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    TextView tvDate,tvshow;
    EditText etDate;
    DatePickerDialog.OnDateSetListener setListener;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker=findViewById(R.id.datepicker);
        tvDate=findViewById(R.id.text_date);
        tvshow=findViewById(R.id.text_date_show);
        tvshow.setOnClickListener(V ->{
            int yr=datePicker.getYear();
            int mon=datePicker.getMonth();
            int d=datePicker.getDayOfMonth();
            Calendar calendar1=Calendar.getInstance();
            calendar1.set(yr,mon,d);
            String dayofweek=new SimpleDateFormat("EEEE", Locale.getDefault()).format(calendar1.getTime());
            int mont=mon+1;
            String date=d+"/"+mont+"/"+yr;
            tvshow.append(date+"\n");
            tvshow.append(dayofweek);
        });


        /*Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                tvDate.setText(date);
            }
        };
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        etDate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });*/
    }
}