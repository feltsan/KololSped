package com.thinkmobiles.koroltrans;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by john on 01.10.15.
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "MlysikbcKw2P35Bp0FdkCncIzjLRttezJowoqtj0", "cUbHLOLJqcnmtcp2ZBZ0cTBImdrfxBSvORnqnUff");

    }
}
