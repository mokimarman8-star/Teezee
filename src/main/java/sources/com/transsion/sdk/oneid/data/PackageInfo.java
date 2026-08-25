package com.transsion.sdk.oneid.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import com.transsion.sdk.oneid.b;
import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class PackageInfo extends OneBaseInfo implements Serializable {
    public String pkg;
    public String signatures;
    public String ssaid;

    @SuppressLint({"PackageManagerGetSignatures"})
    public PackageInfo(Context context) {
        this.pkg = "";
        this.signatures = "";
        this.ssaid = "";
        this.pkg = context.getPackageName();
        this.signatures = b.l(context, "SHA-256");
        try {
            this.ssaid = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
        if (this.ssaid == null) {
            this.ssaid = "";
        }
    }
}
