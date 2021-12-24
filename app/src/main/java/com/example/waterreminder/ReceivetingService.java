package com.example.waterreminder;

import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.legacy.content.WakefulBroadcastReceiver;

public class ReceivetingService extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Uri path = Uri.parse(RingtoneManager.EXTRA_RINGTONE_TYPE);
        Ringtone tone = RingtoneManager.getRingtone(context, path);
        tone.play();

    }
}
