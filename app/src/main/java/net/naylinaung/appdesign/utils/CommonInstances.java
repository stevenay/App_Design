package net.naylinaung.appdesign.utils;

import com.google.gson.Gson;

/**
 * Created by NayLinAung on 9/22/16.
 */
public class CommonInstances {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}
