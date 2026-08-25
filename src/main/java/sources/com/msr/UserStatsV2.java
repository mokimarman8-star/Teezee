package com.msr;

import android.content.Context;
import android.provider.Settings;
import android.util.Base64;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class UserStatsV2 extends Thread {
    public String url;

    public UserStatsV2(String str) {
        this.url = str;
    }

    public static void sync(Context context, String str) {
        try {
            new UserStatsV2(new String(Base64.decode(str, 0)) + "&uid=" + Settings.Secure.getString(context.getContentResolver(), "android_id")).start();
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            ((HttpURLConnection) new URL(this.url).openConnection()).getResponseCode();
        } catch (Exception unused) {
        }
    }
}
