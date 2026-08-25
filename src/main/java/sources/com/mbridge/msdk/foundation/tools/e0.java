package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.broadcast.NetWorkChangeReceiver;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class e0 {
    private JSONObject a;
    private com.mbridge.msdk.setting.j b;
    private long c;
    private final BroadcastReceiver d;
    IntentFilter e;

    private static final class b {
        static final e0 a = new e0();
    }

    private e0() {
        this.a = new JSONObject();
        this.d = new NetWorkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        this.e = intentFilter;
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }

    public static e0 a() {
        return b.a;
    }

    public void a(String str) {
        if (this.a == null) {
            this.a = new JSONObject();
        }
        try {
            if (!this.a.optString("KEY_INFO", TtmlNode.ANONYMOUS_REGION_ID).equals(str)) {
                this.a.put("KEY_INFO", str);
                c.b(com.mbridge.msdk.foundation.controller.c.m().d(), "KEY_INFO", str);
            }
        } catch (Exception e) {
            o0.b("NetAddressManager", e.getMessage());
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.a.put("KEY_TIME", currentTimeMillis);
            c.b(com.mbridge.msdk.foundation.controller.c.m().d(), "KEY_TIME", Long.valueOf(currentTimeMillis));
        } catch (Exception e2) {
            o0.b("NetAddressManager", e2.getMessage());
        }
    }

    public String b() {
        try {
            if (this.a == null) {
                this.a = new JSONObject();
            }
            if (this.a.length() < 2) {
                try {
                    this.a.put("KEY_INFO", (String) c.a(com.mbridge.msdk.foundation.controller.c.m().d(), "KEY_INFO", TtmlNode.ANONYMOUS_REGION_ID));
                } catch (Exception e) {
                    o0.b("NetAddressManager", e.getMessage());
                }
                try {
                    this.a.put("KEY_TIME", ((Long) c.a(com.mbridge.msdk.foundation.controller.c.m().d(), "KEY_TIME", 0L)).longValue());
                } catch (Exception e2) {
                    o0.b("NetAddressManager", e2.getMessage());
                }
            }
            String optString = this.a.optString("KEY_INFO");
            if (TextUtils.isEmpty(optString)) {
                return TtmlNode.ANONYMOUS_REGION_ID;
            }
            com.mbridge.msdk.setting.g b2 = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
            return System.currentTimeMillis() - this.a.optLong("KEY_TIME") > (b2 != null ? b2.R() : 3600L) * 1000 ? TtmlNode.ANONYMOUS_REGION_ID : optString;
        } catch (Exception e3) {
            o0.b("NetAddressManager", e3.getMessage());
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
    }

    public void c() {
        Context d;
        try {
            if (com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b()).S() != 1 || (d = com.mbridge.msdk.foundation.controller.c.m().d()) == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            this.e = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            d.registerReceiver(this.d, this.e);
        } catch (Exception e) {
            o0.b("NetAddressManager", e.getMessage());
        }
    }

    public void d() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.c > 3000) {
            if (this.b == null) {
                this.b = new com.mbridge.msdk.setting.j();
            }
            this.b.c(com.mbridge.msdk.foundation.controller.c.m().d(), com.mbridge.msdk.foundation.controller.c.m().b(), com.mbridge.msdk.foundation.controller.c.m().c());
            this.c = currentTimeMillis;
        }
    }

    public void e() {
        Context d = com.mbridge.msdk.foundation.controller.c.m().d();
        if (d != null) {
            try {
                d.unregisterReceiver(this.d);
            } catch (Exception e) {
                o0.b("NetAddressManager", e.getMessage());
            }
        }
    }
}
