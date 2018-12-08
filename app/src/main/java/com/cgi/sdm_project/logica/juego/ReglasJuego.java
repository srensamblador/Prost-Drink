package com.cgi.sdm_project.logica.juego;

import com.cgi.sdm_project.logica.juego.Reglas.HastaQue;
import com.cgi.sdm_project.logica.juego.Reglas.Juego;
import com.cgi.sdm_project.logica.juego.Reglas.Pregunta;
import com.cgi.sdm_project.logica.juego.Reglas.Reto;
import com.cgi.sdm_project.logica.juego.Reglas.Votacion;
import com.cgi.sdm_project.util.Loader;

import java.util.List;

public class ReglasJuego {
    private static ReglasJuego instance;

    private List<Pregunta> preguntas;
    private List<Reto> retos;
    private List<Votacion> votaciones;
    private List<Juego> juegos;
    private List<HastaQue> hastaques;

    private ReglasJuego() {
        cargarReglas();
    }

    public static ReglasJuego getInstance() {
        if (instance == null)
            instance = new ReglasJuego();
        return instance;
    }

    public void cargarReglas() {
        preguntas = Loader.loadPreguntas();
        retos = Loader.loadRetos();
        votaciones = Loader.loadVotaciones();
        juegos = Loader.loadJuegos();
        hastaques = Loader.loadHastaQues();
    }

    public Pregunta getPregunta() {
        return preguntas.get((int) (Math.random() * (preguntas.size())));
    }

    public Reto getReto() {
        return retos.get((int) (Math.random() * (retos.size())));
    }

    public Votacion getVotacion() {
        return votaciones.get((int) (Math.random() * (votaciones.size())));
    }

    public Juego getJuego() {
        return juegos.get((int) (Math.random() * (juegos.size())));
    }

    public HastaQue getHastaque() {
        return hastaques.get((int) (Math.random() * (hastaques.size())));
    }
}
