package com.transsion.sdk.oneid.data;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import bz.b;
import com.transsion.sdk.oneid.a;
import com.transsion.sdk.oneid.e;
import java.io.File;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class GroupFpInfo extends OneBaseInfo implements Serializable {
    public DeviceInfo device;
    public UniqueIdInfo dids;
    public EnvironInfo env;
    public FingerprintInfo fp;
    public PackageInfo pkg;
    public RomInfo rom;
    public UserIdInfo user;
    public String vaid;

    public GroupFpInfo(Context context, Handler.Callback callback) {
        String f;
        String packageName = context.getPackageName();
        try {
            this.vaid = b.b(context).f("vaid");
        } catch (Exception unused) {
        }
        try {
            String str = "";
            if (TextUtils.isEmpty(this.vaid)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(packageName)) {
                            this.vaid = UUID.nameUUIDFromBytes((packageName + string).replaceAll("[^a-zA-Z0-9._-]", "").getBytes(StandardCharsets.UTF_8)).toString();
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (TextUtils.isEmpty(this.vaid)) {
                    this.vaid = UUID.randomUUID().toString();
                }
                b.b(context).d("vaid", this.vaid);
            }
            try {
                File file = new File(a.a());
                if (context.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0 && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    if (file.exists() && (f = com.transsion.sdk.oneid.b.f(file)) != null && f.length() > 0) {
                        com.transsion.sdk.oneid.b.i("read vaid success");
                        str = new JSONObject(f).optString(packageName, "");
                    }
                    if (!TextUtils.equals(str, this.vaid)) {
                        e.a(context).e(new IdChangeInfo("vaid", str, this.vaid));
                    }
                }
            } catch (Exception e) {
                com.transsion.sdk.oneid.b.m(e.getMessage());
            }
        } catch (Exception unused3) {
        }
        this.dids = new UniqueIdInfo(context, callback);
        this.user = new UserIdInfo(context);
        this.pkg = new PackageInfo(context);
        this.env = new EnvironInfo(context);
        this.device = new DeviceInfo(context);
        this.fp = new FingerprintInfo(context);
        this.rom = new RomInfo(context);
    }
}
