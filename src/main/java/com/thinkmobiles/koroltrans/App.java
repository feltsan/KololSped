package com.thinkmobiles.koroltrans;

import android.app.Application;


import com.parse.Parse;
import com.parse.ParseObject;
import com.thinkmobiles.koroltrans.model.Documents;
import com.thinkmobiles.koroltrans.model.Oil;
import com.thinkmobiles.koroltrans.model.Reys;
import com.thinkmobiles.koroltrans.model.Service;
import com.thinkmobiles.koroltrans.model.Truck;

/**
 * Created by john on 01.10.15.
 */
public class App extends Application{

    public static final int DOCUMENTS_CODE = 100;
    public static final int REYS_CODE = 200;
    public static final int OIL_CODE = 300;
    public static final int SERVICE_CODE = 400;
    public static final int NEW_TRUCK_CODE = 500;
    public static final int DETAIL_TRUCK_CODE = 600;
    public static final String DATE_VIEW = "VIEW";
    public static final int GCTru = 1;
    public static final int GCTra = 2;
    public static final int WSTru = 3;
    public static final int WSTra = 4;
    public static final int EPTru = 5;
    public static final int EPTra = 6;
    public static final int TACHO = 7;
    public static final int YSTra = 8;
    public static final int POLTru =9;
    public static final int POLTra =10;

    public static final String TRUCK_GROUP_NAME = "ALL_TRUCK";

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Truck.class);
        ParseObject.registerSubclass(Documents.class);
        ParseObject.registerSubclass(Reys.class);
        ParseObject.registerSubclass(Oil.class);
        ParseObject.registerSubclass(Service.class);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "MlysikbcKw2P35Bp0FdkCncIzjLRttezJowoqtj0", "cUbHLOLJqcnmtcp2ZBZ0cTBImdrfxBSvORnqnUff");

    }
}
