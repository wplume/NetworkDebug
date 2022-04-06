package com.windplume.networkdebug;

import androidx.annotation.NonNull;

public class Config {
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isBootDebugEnable() {
        return bootDebugEnable;
    }

    public void setBootDebugEnable(boolean bootDebugEnable) {
        this.bootDebugEnable = bootDebugEnable;
    }

    int port;
    boolean bootDebugEnable;

    @Override
    @NonNull
    public String toString() {
        return "Config{" +
                "port=" + port +
                ", bootDebugEnable=" + bootDebugEnable +
                '}';
    }
}
