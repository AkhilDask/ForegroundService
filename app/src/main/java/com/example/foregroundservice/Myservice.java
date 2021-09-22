package com.example.foregroundservice;

import static com.example.foregroundservice.App.channel_id;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;



import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;


public class Myservice extends Service {
    private NotificationManagerCompat notificationmanager;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        calling(intent,flags,startId);
        return START_NOT_STICKY;

    }

    private void calling(Intent intent,int flags,int startId) {
        String input = intent.getStringExtra("inputExtra");
        Intent notificationIntent = new Intent(this,MainActivity.class);
        notificationmanager = NotificationManagerCompat.from(this);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0,notificationIntent,0);

        Notification notification= new NotificationCompat.Builder(this,channel_id)
                .setContentTitle("foreground service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_run)
                .setContentIntent(pendingIntent)
                .build();

        notificationmanager.notify(1,notification);

        startForeground(1,notification);





    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
