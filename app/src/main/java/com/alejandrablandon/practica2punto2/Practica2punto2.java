package com.alejandrablandon.practica2punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View;
import android.widget.Toast;


public class Practica2punto2 extends AppCompatActivity {

    EditText eNumero_1,eNumero_2,eSolucion;
    Button bResultado;
    RadioGroup rdgGrupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica2punto2);

        eNumero_1=(EditText)findViewById(R.id.eNumero1);
        eNumero_2=(EditText)findViewById(R.id.eNumero2);
        eSolucion=(EditText)findViewById(R.id.eSolucionar);
        bResultado=(Button)findViewById(R.id.bresultado);
        rdgGrupo=(RadioGroup)findViewById(R.id.Grupo);


    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        final double producto;
        double numero1=0;
        double numero2=0;
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_sumar:
                if (checked) {
                    if(eNumero_1.length()==0 || eNumero_2.length()==0)
                    {
                        Toast texto= Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT);
                        texto.show();
                    }else {
                        numero1 = Double.parseDouble(eNumero_1.getText().toString());
                        numero2 = Double.parseDouble(eNumero_2.getText().toString());
                        producto = numero1 + numero2;
                        bResultado.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                eSolucion.setText(String.valueOf(producto)); //opcion 1
                            }
                        });
                    }
                }
                break;
            case R.id.radio_restar:
                if (checked){
                    if(eNumero_1.length()==0 || eNumero_2.length()==0)
                    {
                        Toast texto= Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT);
                        texto.show();
                    }else {
                        numero1 = Double.parseDouble(eNumero_1.getText().toString());
                        numero2 = Double.parseDouble(eNumero_2.getText().toString());
                        producto = numero1 - numero2;
                        bResultado.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                eSolucion.setText(String.valueOf(producto)); //opcion 1
                            }
                        });

                    }
                }
                break;
            case R.id.radio_multiplicar:
                if (checked){
                    if(eNumero_1.length()==0 || eNumero_2.length()==0)
                    {
                        Toast texto= Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT);
                        texto.show();
                    }else {
                        numero1 = Double.parseDouble(eNumero_1.getText().toString());
                        numero2 = Double.parseDouble(eNumero_2.getText().toString());
                        producto = numero1 * numero2;
                        bResultado.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                eSolucion.setText(String.valueOf(producto)); //opcion 1
                            }
                        });
                    }
                }
                break;
            case R.id.radio_dividir:
                if (checked){
                    if(eNumero_1.length()==0 || eNumero_2.length()==0)
                    {
                        Toast texto= Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT);
                        texto.show();
                    }else {
                        numero1 = Double.parseDouble(eNumero_1.getText().toString());
                        numero2 = Double.parseDouble(eNumero_2.getText().toString());
                        if (numero2 == 0) eSolucion.setText("Infinity");
                        producto = numero1 / numero2;
                        bResultado.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                eSolucion.setText(String.valueOf(producto)); //opcion 1
                            }
                        });

                    }
                }
                break;
        }

    }

}

