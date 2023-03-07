package com.example.servicecreation;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import android.media.MediaPlayer;
import android.provider.Settings;
import androidx.annotation.Nullable;

public class NewService extends Service {

    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        player = MediaPlayer.create( this, Settings.System.DEFAULT_RINGTONE_URI );

        player.setLooping( true );

        player.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}