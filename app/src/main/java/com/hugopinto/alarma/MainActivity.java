package com.hugopinto.alarma;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private String mensaje;
    private int hora;
    private int minutos;
    private Button alarma;
    private TimePicker reloj;
    private EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarma = findViewById(R.id.btnalarm);
        reloj = findViewById(R.id.timePicker);
        texto = findViewById(R.id.text1);

        alarma.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View v){
            if(texto.length()==0){
                Toast.makeText(getApplicationContext(),"Por favor, ingrese un asunto",Toast.LENGTH_SHORT).show();
            }else {
                hora = reloj.getHour();
                minutos = reloj.getMinute();
                mensaje = texto.getText().toString();

                createAlarm(mensaje, hora, minutos);
            }
            }




        });


    }
    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
