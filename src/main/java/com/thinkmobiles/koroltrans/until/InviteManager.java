package com.thinkmobiles.koroltrans.until;

import android.content.Context;
import android.content.Intent;
import android.text.Html;

import com.parse.ParseException;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.model.Documents;
import com.thinkmobiles.koroltrans.model.Invite;
import com.thinkmobiles.koroltrans.model.Oil;
import com.thinkmobiles.koroltrans.ui.activity.InviteActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 15.10.15.
 */
public class InviteManager {
    private List<Documents> documentses;
    private List<Oil> oils;


    public InviteManager(List<Documents> documentses, List<Oil> oils) {
        this.documentses = documentses;
        this.oils = oils;
    }

    public ArrayList<Invite> convertToInvite(){
        ArrayList<Invite> inviteArrayList = new ArrayList<>();

        if(!documentses.isEmpty()) {
            for (Documents d : documentses) {
                Invite invite = new Invite();
                String nomer = "";
                switch (d.getType()) {
                    case App.GCTru:
                        try {
                            nomer =d.getTruck().fetchIfNeeded().getString("nomer");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        invite.setNomer(nomer);
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Зелена карта");
                        break;

                    case App.GCTra:
                        try {
                            nomer =d.getTruck().fetchIfNeeded().getString("trailer_nomer");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        invite.setNomer(nomer);
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Зелена карта");
                        break;

                    case App.WSTru:
                        try {
                            nomer =d.getTruck().fetchIfNeeded().getString("nomer");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        invite.setNomer(nomer);
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Сертифікат");
                        break;

                    case App.WSTra:
                        try {
                            nomer =d.getTruck().fetchIfNeeded().getString("trailer_nomer");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        invite.setNomer(nomer);
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Сертифікат");
                        break;

                    case App.EPTru:
                        try {
                            nomer =d.getTruck().fetchIfNeeded().getString("nomer");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        invite.setNomer(nomer);
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Європротокол");
                        break;

                    case App.EPTra:
                        try {
                            nomer =d.getTruck().fetchIfNeeded().getString("trailer_nomer");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        invite.setNomer(nomer);
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Європротокол");
                        break;

                    case App.TACHO:
                        try {
                            nomer =d.getTruck().fetchIfNeeded().getString("nomer");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        invite.setNomer(nomer);
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Тахограф");
                        break;

                    case App.YSTra:
                        try {
                            nomer =d.getTruck().fetchIfNeeded().getString("trailer_nomer");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        invite.setNomer(nomer);
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Жовте свідоцтво");
                        break;

                    case App.POLTru:
                        try {
                            nomer =d.getTruck().fetchIfNeeded().getString("nomer");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        invite.setNomer(nomer);
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Страховка");
                        break;

                    case App.POLTra:
                        try {
                            nomer =d.getTruck().fetchIfNeeded().getString("trailer_nomer");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        invite.setNomer(nomer);
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Страховка");
                        break;
                }
                inviteArrayList.add(invite);


            }
        }
        if (!oils.isEmpty()) {
            for (Oil o : oils) {
                Invite invite = new Invite();
                String nomer = "";
                try {
                    nomer =o.getTruck().fetchIfNeeded().getString("nomer");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                invite.setNomer(nomer);
                invite.setType("Масло");
                invite.setDate(DateHelper.convertLongToString(o.getDate()));
                inviteArrayList.add(invite);
            }
        }
        return inviteArrayList;
    }

    public void sendInvite(Context context){
        ArrayList<Invite> invites = convertToInvite();
        String msg = getMessage(invites);
        Sender.sendSMS(context, msg,documentses,oils);
        Sender.sendEmail(getEmailMessage(invites), documentses, oils);

        Intent intent = new Intent(context, InviteActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putParcelableArrayListExtra("arrayinvites", invites);
        context.startActivity(intent);
    }
    public String getMessage(ArrayList<Invite>  invites) {
        String s = "!!!" +  "\n" ;
        StringBuilder sb = new StringBuilder();
        for(Invite i : invites){
            sb.append(i.toString()).append("\n");
        }
        return s + sb.toString();
    }
    public String getEmailMessage(ArrayList<Invite>  invites) {
        String s = "!!!!!!!!!!!!!!!!!!!!!!!!!!" +  "<br />" ;
        StringBuilder sb = new StringBuilder();
        for(Invite i : invites){
            sb.append(i.toString()).append("<br />");
        }
        return s + sb.toString();
    }


}
