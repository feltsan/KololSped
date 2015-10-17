package com.thinkmobiles.koroltrans.until;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.model.Documents;
import com.thinkmobiles.koroltrans.model.Invite;
import com.thinkmobiles.koroltrans.model.Oil;
import com.thinkmobiles.koroltrans.ui.activity.InviteActivity;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 14.10.15.
 */
public class Alarm extends BroadcastReceiver{

    Context context;


    @Override
    public void onReceive(Context context, Intent intent) {
        this.context =context;
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();

        context.startService(new Intent(context, GetInvites.class));

        Toast.makeText(context, "Alarm !!!!!!!!!!", Toast.LENGTH_LONG).show();
        Log.e("ALARM", "ALARM");// For example

        wl.release();
    }

    public void SetAlarm(Context context)
    {
        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 60 * 60 * 24 * 3 , pi); // Millisec * Second * Minute
    }

    public void CancelAlarm(Context context)
    {
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }
}
