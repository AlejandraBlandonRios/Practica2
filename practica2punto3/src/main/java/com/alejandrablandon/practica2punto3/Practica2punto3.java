package com.alejandrablandon.practica2punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class Practica2punto3 extends AppCompatActivity {

    EditText eLadoCuadro, eBaseTriangulo, eAlturaTriangulo, eBaseRectangulo, eAlturaRectangulo, eRadio;
    EditText eSolucionCuadro, eSolucionTriangulo, eSolucionRectangulo, eSolucionCirculo;
    Button bResultado1, bResultado2, bResultado3, bResultado4;
    RadioGroup Grupo;
    LinearLayout Cuadro, Triangulo, Rectangulo, Circulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica2punto3);

        eLadoCuadro = (EditText) findViewById(R.id.eLadoCuadro);
        eBaseTriangulo = (EditText) findViewById(R.id.eBaseTriangulo);
        eAlturaTriangulo = (EditText) findViewById(R.id.eAlturaTriangulo);
        eBaseRectangulo = (EditText) findViewById(R.id.eBaseRectangulo);
        eAlturaRectangulo = (EditText) findViewById(R.id.eAlturaRectangulo);
        eRadio = (EditText) findViewById(R.id.eRadio);
        eSolucionCuadro = (EditText) findViewById(R.id.eSolucionCuadro);
        bResultado1 = (Button) findViewById(R.id.bResultado1);
        eSolucionTriangulo = (EditText) findViewById(R.id.eSolucionTriangulo);
        bResultado2 = (Button) findViewById(R.id.bResultado2);
        eSolucionRectangulo = (EditText) findViewById(R.id.eSolucionRectangulo);
        bResultado3 = (Button) findViewById(R.id.bResultado3);
        eSolucionCirculo = (EditText) findViewById(R.id.eSolucionCirculo);
        bResultado4 = (Button) findViewById(R.id.bResultado4);
        Grupo = (RadioGroup) findViewById(R.id.Grupo);
        Cuadro = (LinearLayout) findViewById(R.id.Cuadro);
        Triangulo = (LinearLayout) findViewById(R.id.Triangulo);
        Rectangulo = (LinearLayout) findViewById(R.id.Rectangulo);
        Circulo = (LinearLayout) findViewById(R.id.Circulo);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        int bandera = 0;
        switch (view.getId()) {
            case R.id.radio_cuadro:
                if (checked) {
                    Cuadro.setVisibility(View.VISIBLE);
                    Triangulo.setVisibility(View.GONE);
                    Rectangulo.setVisibility(View.GONE);
                    Circulo.setVisibility(View.GONE);
                    eAlturaTriangulo.setText("");
                    eAlturaRectangulo.setText("");
                    eBaseRectangulo.setText("");
                    eBaseTriangulo.setText("");
                    eRadio.setText("");
                    eSolucionCirculo.setText("");
                    eSolucionRectangulo.setText("");
                    eSolucionTriangulo.setText("");
                    bResultado1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (eLadoCuadro.length() == 0) {

                                CharSequence text = "Campos vacios";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                                toast.show();
                            } else {
                                final double producto;
                                double lado;
                                lado = Integer.parseInt(eLadoCuadro.getText().toString());
                                producto = lado * lado;
                                eSolucionCuadro.setText(String.valueOf(producto)); //opcion 1
                            }


                        }
                    });

                }
                break;
            case R.id.radio_triangulo:
                if (checked) {
                    Triangulo.setVisibility(View.VISIBLE);
                    Cuadro.setVisibility(View.GONE);
                    Rectangulo.setVisibility(View.GONE);
                    Circulo.setVisibility(View.GONE);
                    eLadoCuadro.setText("");
                    eAlturaRectangulo.setText("");
                    eBaseRectangulo.setText("");
                    eRadio.setText("");
                    eSolucionCirculo.setText("");
                    eSolucionRectangulo.setText("");
                    eSolucionCuadro.setText("");
                    bResultado2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (eBaseTriangulo.length() == 0 || eAlturaTriangulo.length()==0) {

                                CharSequence text = "Campos vacios";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                                toast.show();
                            } else {
                                final double producto;
                                double base, altura;
                                base = Integer.parseInt(eBaseTriangulo.getText().toString());
                                altura = Integer.parseInt(eAlturaTriangulo.getText().toString());
                                producto = (base * altura)/2;
                                eSolucionTriangulo.setText(String.valueOf(producto)); //opcion 1
                            }


                        }
                    });
                }
                break;
            case R.id.radio_rectangulo:
                if (checked) {
                    Rectangulo.setVisibility(View.VISIBLE);
                    Cuadro.setVisibility(View.GONE);
                    Triangulo.setVisibility(View.GONE);
                    Circulo.setVisibility(View.GONE);
                    eLadoCuadro.setText("");
                    eAlturaTriangulo.setText("");
                    eBaseTriangulo.setText("");
                    eRadio.setText("");
                    eSolucionCirculo.setText("");
                    eSolucionCuadro.setText("");
                    eSolucionTriangulo.setText("");
                    bResultado3.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (eBaseRectangulo.length() == 0 || eAlturaRectangulo.length()==0) {

                                CharSequence text = "Campos vacios";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                                toast.show();
                            } else {
                                final double producto;
                                double base, altura;
                                base = Integer.parseInt(eBaseRectangulo.getText().toString());
                                altura = Integer.parseInt(eAlturaRectangulo.getText().toString());
                                producto = base * altura;
                                eSolucionRectangulo.setText(String.valueOf(producto)); //opcion 1
                            }


                        }
                    });
                }
                break;
            case R.id.radio_circulo:
                if (checked) {
                    Circulo.setVisibility(View.VISIBLE);
                    Cuadro.setVisibility(View.GONE);
                    Triangulo.setVisibility(View.GONE);
                    Rectangulo.setVisibility(View.GONE);
                    eLadoCuadro.setText("");
                    eAlturaTriangulo.setText("");
                    eAlturaRectangulo.setText("");
                    eBaseRectangulo.setText("");
                    eBaseTriangulo.setText("");
                    eSolucionCuadro.setText("");
                    eSolucionRectangulo.setText("");
                    eSolucionTriangulo.setText("");
                    bResultado4.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (eRadio.length() == 0) {

                                CharSequence text = "Campos vacios";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                                toast.show();
                            } else {
                                final double producto;
                                double radio;
                                radio = Integer.parseInt(eRadio.getText().toString());
                                producto = Math.PI*(radio*radio);
                                eSolucionCirculo.setText(String.valueOf(producto)); //opcion 1
                            }


                        }
                    });
                }
                break;
        }

    }
}
