package com.thinkmobiles.koroltrans.until;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.gsm.SmsManager;
import android.widget.Toast;

/**
 * Created by john on 09.10.15.
 */
public abstract class Sender {


        public void sendSMS(Context context, String phoneNo, String msg){
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNo, null, msg, null, null);
                Toast.makeText(context, "Message Sent",
                        Toast.LENGTH_LONG).show();
            } catch (Exception ex) {
                Toast.makeText(context,ex.getMessage().toString(),
                        Toast.LENGTH_LONG).show();
                ex.printStackTrace();

        }
    }
    public void sendEmail(Context context, String phoneNo, String msg) {
//        GMailSender sender = new GMailSender("username@gmail.com", "password");
//        sender.sendMail("This is Subject",
//                "This is Body",
//                "user@gmail.com",
//                "user@yahoo.com");

    }

//    private void sendSMS(final Context context, String text) {
//
//        String SENT = "SENT";
//        String DELIVERED = "DELIVER";
//
//        PendingIntent sentPI = PendingIntent.getBroadcast(context, 0,
//                new Intent(SENT), 0);
//
//        PendingIntent deliveredPI = PendingIntent.getBroadcast(context, 0,
//                new Intent(DELIVERED), 0);
//
//        //---when the SMS has been sent---
//        context.registerReceiver(new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context arg0, Intent arg1) {
//                switch (getResultCode()) {
//                    case Activity.RESULT_OK:
//
//
//                        break;
//                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
//                        Toast.makeText(context, "generic_failure",
//                                Toast.LENGTH_SHORT).show();
//
//                        break;
//                    case SmsManager.RESULT_ERROR_NO_SERVICE:
//                        Toast.makeText(context, "no_service",
//                                Toast.LENGTH_SHORT).show();
//                        break;
//                    case SmsManager.RESULT_ERROR_NULL_PDU:
//                        Toast.makeText(context, "null_pdu",
//                                Toast.LENGTH_SHORT).show();
//
//                        break;
//                    case SmsManager.RESULT_ERROR_RADIO_OFF:
//                        Toast.makeText(context, "radio_off",
//                                Toast.LENGTH_SHORT).show();
//
//                        break;
//                }
//            }
//        }, new IntentFilter(SENT));
//
//        //---when the SMS has been delivered---
//        context.registerReceiver(new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context arg0, Intent arg1) {
//                switch (getResultCode()) {
//                    case Activity.RESULT_OK:
//                        break;
//                    case Activity.RESULT_CANCELED:
//                        break;
//                }
//            }
//        }, new IntentFilter(DELIVERED));
//
//            SmsManager sms = SmsManager.getDefault();
//            sms.sendTextMessage("096", null, text, sentPI, deliveredPI);
//        }

}
