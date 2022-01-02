package com.example.pafitness.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.example.pafitness.Activity.NotificationActivity;
import com.example.pafitness.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class NotificationService extends FirebaseMessagingService {
    //id channel notification
    private static final String CHANNEL_ID = "com.pafitnes.herokuapp.CH01";


//    my fcm token
//    fBElW_ghTvyjShkwd7F_ao:APA91bH1qgpIpus2O-6WNfL10EXQesd3zhlddw6x0jc58IhDqeJULwPMG9BUWE-ChtI_MeByyxTccMyt-7KbeglQvzHhak4tRk9E6p2h_bzIylgSdk7otzyziblhdsEVz8jmkNMtYXEL
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String title = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();
        showNotification(title,message);
    }

    private void showNotification(String title ,String message) {
        //Ambil objeck notification
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);


        //buat channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ){
            NotificationChannel notificationChannel =
                    new NotificationChannel(CHANNEL_ID,
                            "Channel Fitnes",
                            NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        //buat pending intent
        Intent notificationIntent = new Intent(getApplicationContext(), NotificationActivity.class);

        PendingIntent pendingNotificationIntent = PendingIntent.getActivity(
                getApplicationContext(),
                123,
                notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT

        );

        //buat notifikasi
        NotificationCompat.Builder builder =  new
                NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_meeting_room_24)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(pendingNotificationIntent)
                .addAction(R.drawable.ic_baseline_remove_red_eye_24,"Check",pendingNotificationIntent);


        Notification notification = builder.build();

        //tampilkan notifikasi
        notificationManager.notify(123,notification);


    }


}