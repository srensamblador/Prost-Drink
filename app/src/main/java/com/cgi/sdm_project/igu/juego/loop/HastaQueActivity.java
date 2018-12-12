package com.cgi.sdm_project.igu.juego.loop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.FinJuego;
import com.cgi.sdm_project.logica.juego.IFinJuego;
import com.cgi.sdm_project.logica.juego.InicioJuego;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.reglas.HastaQue;

public class HastaQueActivity extends AppCompatActivity implements InicioJuego, IFinJuego {
    private HastaQue hastaQue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_que);
        hastaQue = (HastaQue) Juego.getInstance().getJuegoActual();

        ((TextView) findViewById(R.id.lblHastaQue)).setText(hastaQue.getTexto());
    }

    public void siguiente(View v) {
        cargarSiguienteJuego(v);
    }

    @Override
    public void cargarSiguienteJuego(View view) {
        new FinJuego().cargarSiguienteJuego(view);
    }
}
