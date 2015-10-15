package com.thinkmobiles.koroltrans.until;

import android.content.Context;
import android.content.Intent;

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
                switch (d.getType()) {
                    case App.GCTru:
                        invite.setNomer(d.getTruck().getNomer());
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Зелена карта");
                        break;

                    case App.GCTra:
                        invite.setNomer(d.getTruck().getTrailerNomer());
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Зелена карта");
                        break;

                    case App.WSTru:
                        invite.setNomer(d.getTruck().getNomer());
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Сертифікат");
                        break;

                    case App.WSTra:
                        invite.setNomer(d.getTruck().getTrailerNomer());
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Сертифікат");
                        break;

                    case App.EPTru:
                        invite.setNomer(d.getTruck().getNomer());
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Європротокол");
                        break;

                    case App.EPTra:
                        invite.setNomer(d.getTruck().getTrailerNomer());
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Європротокол");
                        break;

                    case App.TACHO:
                        invite.setNomer(d.getTruck().getNomer());
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Тахограф");
                        break;

                    case App.YSTra:
                        invite.setNomer(d.getTruck().getTrailerNomer());
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Жовте свідоцтво");
                        break;

                    case App.POLTru:
                        invite.setNomer(d.getTruck().getNomer());
                        invite.setDate(DateHelper.convertLongToString(d.getEndDate()));
                        invite.setType("Страховка");
                        break;

                    case App.POLTra:
                        invite.setNomer(d.getTruck().getTrailerNomer());
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
                invite.setNomer(o.getTruck().getNomer());
                invite.setType("Масло");
                invite.setDate("90 днів");
                inviteArrayList.add(invite);
            }
        }
        return inviteArrayList;
    }

    public void sendInvite(Context context){
        ArrayList<Invite> invites = convertToInvite();
        String msg = getMessage(invites);
        Sender.sendEmail(msg);
        Sender.sendSMS(context, msg, documentses, oils);

        Intent intent = new Intent();
        intent.putExtra("arrayinvites", invites);
        context.startActivity(new Intent(context, InviteActivity.class));
    }
    public String getMessage(ArrayList<Invite>  invites) {
        String s = "!!!" +  "\n" ;
        StringBuilder sb = new StringBuilder();
        for(Invite i : invites){
            sb.append(i.toString()).append("\n");
        }
        return s + sb.toString();
    }
}
