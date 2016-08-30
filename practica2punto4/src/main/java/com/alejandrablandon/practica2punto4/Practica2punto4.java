package com.alejandrablandon.practica2punto4;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;
import java.util.StringTokenizer;

public class Practica2punto4 extends AppCompatActivity {

    Calendar calendar;
    Button bFechas, bAceptar1;
    Spinner spCiudades;
    EditText eNombre, eContraseña, eContraseña1, eCorreo;
    TextView Mostrar;
    int year, month, day;
    String Ciudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica2punto4);

        //Objetos de loggin, para capturar informacion y luego mostrar
        bFechas = (Button) findViewById(R.id.bFechas);
        eNombre = (EditText) findViewById(R.id.eNombre);
        eContraseña = (EditText) findViewById(R.id.eContraseña);
        eContraseña1 = (EditText) findViewById(R.id.eContraseña1);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        Mostrar = (TextView) findViewById(R.id.Mostrar);

        //Objetos de Calendario, para el DatePicker
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        //Funcion para mostrar la fecha en el boton
        showDate(year, month+1, day);

        //Objeto de Ciudades para Spinner
        spCiudades = (Spinner) findViewById(R.id.spCiudad);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Arreglo_ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCiudades.setAdapter(adapter);
        spCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemIdAtPosition(position)+" seleccionada", Toast.LENGTH_LONG).show();
                switch(position) {
                    case 0:
                        Ciudad="Medellin";
                        break;
                    case 1:
                        Ciudad="Bogotá";
                        break;
                    case 2:
                        Ciudad="Bucaramanga";
                        break;
                    case 3:
                        Ciudad="Cartagena";
                        break;
                    case 4:
                        Ciudad="Barranquilla";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Objeto del boton Aceptar para ver los datos ingresados
        bAceptar1 = (Button) findViewById(R.id.bAceptar);
        bAceptar1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (bFechas.length() == 0 || eNombre.length() == 0 || eContraseña.length() == 0 || eContraseña1.length() == 0
                        || eCorreo.length() == 0) {
                    CharSequence text = "Campos vacios";
                    //int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Mostrar.setText(String.valueOf(eNombre.getText())+"\n"+ String.valueOf(eContraseña.getText())+
                            "\n"+String.valueOf(eCorreo.getText())+"\n"+String.valueOf(bFechas.getText())+"\n"+String.valueOf(Ciudad)+"\n");
                }
            }
        });
    }

    //Las siguientes son funciones para la fecha (DataPicker)
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "calendario", Toast.LENGTH_SHORT)
                .show();
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            showDate(arg1, arg2+1, arg3);
        }
    };

    //Funcion para ver la fecha en el boton Fecha
    private void showDate(int year, int month, int day) {
        bFechas.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    //Funcion para los Hobbies con Checkbox
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_leer:
                if (checked)
                    Toast.makeText(Practica2punto4.this, "Leer", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkbox_vertv:
                if (checked)
                    Toast.makeText(Practica2punto4.this, "Ver tv", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkbox_correr:
                if (checked)
                    Toast.makeText(Practica2punto4.this, "Correr", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkbox_bailar:
                if (checked)
                    Toast.makeText(Practica2punto4.this, "Bailar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
