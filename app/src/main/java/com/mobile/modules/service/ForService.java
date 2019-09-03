package com.mobile.modules.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.mobile.modules.R;

/**
 * Created by Alex Michenko
 */
@RequiresApi(Build.VERSION_CODES.O)
public class ForService extends Service {

    @Override
    public void onCreate() {
        Log.e("ForService", "Create");
        super.onCreate();
//        new Handler().postDelayed(this::sendNotification, 6000);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendNotification();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("ForService", "Start");
//        sendNotification();
        return START_STICKY;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void sendNotification() {
        startForeground(1, getNotification(this));
    }

    private Notification getNotification(Context context) {
        String name = "BackgroundService";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Channel_id")
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentTitle("Drive Yello")
                .setContentText("The app is performing tasks in the background.");

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (notificationManager.getNotificationChannel("Channel_id") == null) {
            NotificationChannel channel = new NotificationChannel(
                    "Channel_id",
                    name,
                    NotificationManager.IMPORTANCE_LOW
            );

            notificationManager.createNotificationChannel(channel);
        }

        return builder.build();
    }
}
