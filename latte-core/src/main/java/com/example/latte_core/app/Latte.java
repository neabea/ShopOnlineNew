package com.example.latte_core.app;

import android.content.Context;

import java.util.HashMap;

public final class Latte {

    public static Configurator init(Context context) {
        getConfigurations().put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<Object, Object> getConfigurations() {
        return  getConfigurator().getLatteConfigs();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplication(){
        return (Context) getConfigurations().get(ConfigKeys.APPLICATION_CONTEXT);
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }
}
