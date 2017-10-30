package com.example.adri9ps.botones_y_colores;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rl;
    private boolean colorFondo=false;
    private boolean colorLetras=false;
    private Button btnFondo;
    private Button btnLetras;
    private TextView longClick;
    private CheckBox checkBox;
    private TextView mensajeOculto;
    private RatingBar estrellas;
    private TextView cuentaEstrellas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFondo = (Button) findViewById(R.id.btn_fondoRojo);
        btnLetras = (Button) findViewById(R.id.btn_letrasNegras);
        rl = (RelativeLayout) findViewById(R.id.relative);
        longClick = (TextView) findViewById(R.id.id_clickLargo);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        mensajeOculto = (TextView) findViewById(R.id.id_mensajeOculto);
        estrellas = (RatingBar) findViewById(R.id.ratingBar);
        cuentaEstrellas = (TextView) findViewById(R.id.cuentaEstrellas);

        //Asignamos funcion al cambiar valor de las estrellas
        estrellas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                cuentaEstrellas.setText("[" + estrellas.getRating()+ "/5]");
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onClick (View v){
        switch (v.getId()){
            case R.id.btn_fondoRojo:

                if(!colorFondo){
                    rl.setBackground(getDrawable(R.color.Rojo));
                    btnFondo.setText("FONDO BLANCO");
                    colorFondo=true;

                }else{
                    rl.setBackground(getDrawable(R.color.Blanco));
                    btnFondo.setText("FONDO ROJO");
                    colorFondo=false;
                }
                break;

            case R.id.btn_letrasNegras:
                if(!colorLetras){
                    btnLetras.setTextColor(getColor(R.color.Negro));
                    btnLetras.setText("LETRAS ROJAS");
                    colorLetras=true;

                }else{
                    btnLetras.setTextColor(getColor(R.color.Rojo));
                    btnLetras.setText("LETRAS NEGRAS");
                    colorLetras=false;
                }
                break;

            case R.id.checkBox:
                if(checkBox.isChecked()){
                    mensajeOculto.setVisibility(View.VISIBLE);

                }else{
                    mensajeOculto.setVisibility(View.INVISIBLE);
                }
                break;
        }


        longClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast t1;
                t1 = Toast.makeText(getApplicationContext(),"Muchas gracias",Toast.LENGTH_SHORT);
                t1.show();
                return false;




            }

            

        });







    }





}
