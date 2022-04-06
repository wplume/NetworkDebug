package com.windplume.networkdebug;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;

public class MainViewModel extends ObservableViewModel {
    private static final String TAG = "MainViewModel";
    private final Repository repository;

    private String port;
    private boolean enableBootDebug;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    @Bindable
    public String getPort() {
        Log.d(TAG, "getPort: ");
        port = repository.getPort();
        return port;
    }

    public void setPort(String port) {
        Log.d(TAG, "setPort() called with: port = [" + port + "]");
        repository.setPort(port);
        this.port = port;
//        notifyPropertyChanged(BR.port);
    }

    @Bindable
    public boolean isEnableBootDebug() {
        Log.d(TAG, "isEnableBootDebug: ");
        return enableBootDebug;
    }

    public void setEnableBootDebug(boolean enableBootDebug) {
        Log.d(TAG, "setEnableBootDebug() called with: enableBootDebug = [" + enableBootDebug + "]");
        this.enableBootDebug = enableBootDebug;
    }
}
