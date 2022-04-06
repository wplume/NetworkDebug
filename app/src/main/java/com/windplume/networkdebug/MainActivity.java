package com.windplume.networkdebug;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.windplume.networkdebug.databinding.ActivityMainBinding;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setVm(viewModel);
        binding.setLifecycleOwner(this);

        binding.btnStartDebug.setOnClickListener(v -> {
            try {
                String port = viewModel.getPort();
                if (port == null) {
                    Toast.makeText(MainActivity.this, "端口不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                CommonUtils.startADB(Integer.parseInt(port));
            } catch (IOException e) {
                Toast.makeText(MainActivity.this, "启动调试异常： " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnStopDebug.setOnClickListener(v -> {
            try {
                CommonUtils.stopADB();
            } catch (IOException e) {
                Toast.makeText(MainActivity.this, "关闭调试异常： " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
}