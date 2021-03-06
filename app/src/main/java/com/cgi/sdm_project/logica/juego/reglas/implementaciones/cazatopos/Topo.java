package com.cgi.sdm_project.logica.juego.reglas.implementaciones.cazatopos;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Cazatopos;
import com.cgi.sdm_project.util.singletons.AppSingleton;

/**
 * State representando un agujero con topo
 */
public class Topo extends CasillaAbstracta {
    private static final int TOPO_KILL = 10;

    public Topo(Cazatopos context, int index) {
        super(context, index);
        this.img = AppSingleton.getInstance().getDrawable(R.drawable.topo);
        this.value = TOPO_KILL;
    }

    @Override
    public void click() {
        super.click();
        context.getCasillas()[this.getIndex()] = new Agujero(context, this.getIndex());
    }

    @Override
    public String toString() {
        return "TOPO";
    }
}
