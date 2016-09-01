package net.naylinaung.appdesign;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Dell on 8/30/2016.
 */
public class AppDesignApp extends Application {

    public static final String TAG = "AppDesignApp";
    private static Context context;

    public static AppDesignApp INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        INSTANCE = this;
    }

    public static Context getContext() {
        return context;
    }

}
