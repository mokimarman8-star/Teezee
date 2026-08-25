package i5;

import android.os.Bundle;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class d {
    private final Bundle a;

    public d(Bundle bundle) {
        this.a = bundle;
    }

    public boolean a() {
        return this.a.getBoolean("google_play_instant");
    }

    public long b() {
        return this.a.getLong("install_begin_timestamp_seconds");
    }

    public long c() {
        return this.a.getLong("install_begin_timestamp_server_seconds");
    }

    public String d() {
        return this.a.getString("install_referrer");
    }

    public String e() {
        return this.a.getString("install_version");
    }

    public long f() {
        return this.a.getLong("referrer_click_timestamp_seconds");
    }

    public long g() {
        return this.a.getLong("referrer_click_timestamp_server_seconds");
    }
}
