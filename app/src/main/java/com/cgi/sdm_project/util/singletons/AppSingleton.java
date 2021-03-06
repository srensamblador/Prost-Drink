package com.cgi.sdm_project.util.singletons;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.cgi.sdm_project.util.Conf;
import com.cgi.sdm_project.util.Enumerates;

import java.util.Locale;

/**
 * La idea de esta clase es proporcionar un nexo común a toda la aplicación para acceder al contexto,
 * además todas las actividades compartirán su contexto de cara a la internacionalización
 */
public class AppSingleton extends Application {
    private static  AppSingleton app;

    private Locale locale = null;

    public static void notifyLangChange() {
        getInstance().setLocale();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        setLocale();

    }

    public static AppSingleton getInstance() {
        return app;
    }

    public Context getContext() {
        return app.getApplicationContext();
    }

    private void setLocale() {
        Configuration config = getBaseContext().getResources().getConfiguration();

        Enumerates.Idioma idioma = Enumerates.Idioma.values()[Conf.getInstancia().getIdioma()];
        String lang = "es";
        switch (idioma) {
            case ENGLISH:
                lang = "en";
                break;
            case SPANISH:
                lang = "es";
                break;
        }
        if (!config.locale.getLanguage().equals(lang)) {

            locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (locale != null) {
            newConfig.locale = locale;
            Locale.setDefault(locale);
            getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        }
    }
}
