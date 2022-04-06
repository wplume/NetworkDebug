package com.windplume.networkdebug;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

class Repository {
    private static final String PORT = "port";
    private static final String ENABLE_BOOT_DEBUG = "enable_boot_debug";
    private final SharedPreferences sp;

    public Repository(Context context) {
        sp = context.getSharedPreferences("config", MODE_PRIVATE);
    }

    public String getPort() {
        return sp.getString(PORT, "5555");
    }

    public boolean getEnableBootDebug() {
        return sp.getBoolean(ENABLE_BOOT_DEBUG, false);
    }

    public void setPort(String port) {
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(PORT, port);
        edit.apply();
    }

    public void setEnableBootDebug(boolean enableBootDebug) {
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(ENABLE_BOOT_DEBUG, enableBootDebug);
        edit.apply();
    }
}
