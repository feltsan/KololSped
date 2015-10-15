package com.thinkmobiles.koroltrans.until;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.thinkmobiles.koroltrans.App;

/**
 * Created by john on 11.10.15.
 */
public class BootReceiver extends BroadcastReceiver {
    Alarm alarm = new Alarm();
    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())&& ShPrManager.getRunService(context)) {
            alarm.SetAlarm(context);
        }
    }
}
