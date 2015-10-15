package com.thinkmobiles.koroltrans.until;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.model.Documents;
import com.thinkmobiles.koroltrans.model.Oil;
import com.thinkmobiles.koroltrans.model.Truck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 15.10.15.
 */
public class InviteGetter{
    List<Documents> documentses;
    FindeCallback findeCallback;
    public  void getAllDocuments(){

        ParseQuery<Documents> query_doc = ParseQuery.getQuery(Documents.class);
        query_doc.whereEqualTo("inform", false);
        query_doc.fromLocalDatastore();
        query_doc.findInBackground(new FindCallback<Documents>() {
            @Override
            public void done(List<Documents> objects, ParseException e) {
                documentses =objects;
                getAllOils();
            }
        });
    }

    public void getAllOils(){

        ParseQuery<Oil> query_doc = ParseQuery.getQuery(Oil.class);
        query_doc.whereEqualTo("inform", false);
        query_doc.fromLocalDatastore();
        query_doc.findInBackground(new FindCallback<Oil>() {
            @Override
            public void done(List<Oil> objects, ParseException e) {
               findeCallback.onTaskCompleted(documentses,objects);
            }
        });
    }
}
