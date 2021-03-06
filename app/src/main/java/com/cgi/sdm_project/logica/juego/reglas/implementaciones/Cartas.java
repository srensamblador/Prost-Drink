package com.cgi.sdm_project.logica.juego.reglas.implementaciones;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.ReglaTragable;
import com.cgi.sdm_project.util.baraja.Baraja;
import com.cgi.sdm_project.util.baraja.Carta;

import java.util.LinkedList;
import java.util.List;

public class Cartas extends ReglaTragable {
    public static final boolean RESPUESTA_DERECHA = true;
    public static final boolean RESPUESTA_IZQUIERDA = false;

    private List<Boolean> aciertos;
    private Baraja baraja;
    private Carta actual;

    public Cartas(int tragos) {
        super(tragos);
    }

    public void initCartas() {
        aciertos = new LinkedList<>();
        baraja = new Baraja();
    }

    public Carta getActual() {
        return actual;
    }

    /**
     * Método que registra una acción en el juego. Cada vez que el usuario interactua registra una acción con la que puede acertar o no.
     *
     * @param respuesta Respuesta que ha introducido el usuario
     * @return true si ha acertado y false en caso contrario
     */
    public boolean jugar(boolean respuesta) {
        siguienteCarta();
        boolean correcta;
        if (aciertos.size() % 2 == 0)
            aciertos.add(correcta = respuesta && actual.isEven() || !respuesta && !actual.isEven());
        else
            aciertos.add(correcta = respuesta && actual.isRed() || !respuesta && !actual.isRed());
        return correcta;
    }

    private void siguienteCarta() {
        actual = baraja.sacarCarta();
    }

    public boolean isFinished() {
        return aciertos.size() == 3;
    }

    public int getNumCarta() {
        return aciertos.size() + 1;
    }

    public int getOpcionDerecha() {
        return aciertos.size() % 2 == 0 ? R.string.par : R.string.rojo;
    }

    public int getOpcionIzquierda() {
        return aciertos.size() % 2 == 0 ? R.string.impar : R.string.negro;
    }

    @Override
    protected String nombreRespuesta() {
        return (aciertos() * 100 / aciertos.size() < 50) ? "resultado_cartas_mal" : "resultado_cartas_bien";
    }

    private int aciertos() {
        int contador = 0;
        for (boolean respuesta : aciertos)
            if (respuesta)
                contador++;
        return contador;
    }
}
