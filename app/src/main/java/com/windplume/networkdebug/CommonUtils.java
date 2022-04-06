package com.windplume.networkdebug;

import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;

public class CommonUtils {
    private static final String TAG = "CommonUtils";

    public static void startADB(int port) throws IOException {
        Process su;
        OutputStream os = null;
        try {
            String cmd = ("stop adbd\n");
            String cmd1 = ("setprop service.adb.tcp.port " + port + "\n"
                    + "start adbd\n"
                    + "exit\n");

            su = Runtime.getRuntime().exec("/system/xbin/su");

            os = su.getOutputStream();
            os.write(cmd.getBytes());
            os.flush();

            Thread.sleep(1000);

            os.write(cmd1.getBytes());
            os.flush();

            if (su.waitFor() == 0) {
                Log.d(TAG, "adb服务启动成功");
            } else {
                Log.d(TAG, "adb服务启动失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void stopADB() throws IOException {
        Process su;
        OutputStream os = null;
        try {
            String cmd = ("stop adbd\n");
            su = Runtime.getRuntime().exec("/system/xbin/su");
            os = su.getOutputStream();
            os.write(cmd.getBytes());
            os.flush();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
