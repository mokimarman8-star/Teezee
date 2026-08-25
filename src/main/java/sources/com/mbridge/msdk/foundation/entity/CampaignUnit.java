package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class CampaignUnit extends b implements Serializable, NoProGuard {
    private static final String TAG = "CampaignUnit";

    @Override // com.mbridge.msdk.foundation.entity.b
    public String assembCParams() {
        String str;
        String str2;
        StringBuffer stringBuffer = this.cParams;
        if (stringBuffer != null && stringBuffer.length() > 0) {
            return this.cParams.toString();
        }
        try {
            String d = com.mbridge.msdk.foundation.tools.f.d();
            Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
            String r = k0.r(d2);
            String q = k0.q(d2);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                str2 = String.valueOf(k0.s(d2));
                str = k0.n(d2) + "x" + k0.m(d2);
            } else {
                str = TtmlNode.ANONYMOUS_REGION_ID;
                str2 = str;
            }
            StringBuffer stringBuffer2 = this.cParams;
            stringBuffer2.append(getAdType());
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty("1"));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(Build.VERSION.RELEASE));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty("MAL_16.9.71"));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(k0.n()));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(str));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(Integer.valueOf(k0.F(com.mbridge.msdk.foundation.controller.c.m().d()))));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(k0.p(com.mbridge.msdk.foundation.controller.c.m().d())));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(str2));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(q));
            stringBuffer2.append(nullToEmpty(r));
            stringBuffer2.append("|");
            stringBuffer2.append("|");
            stringBuffer2.append("|");
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(d));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(TtmlNode.ANONYMOUS_REGION_ID));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(k0.s()));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(TtmlNode.ANONYMOUS_REGION_ID));
            stringBuffer2.append("|");
            stringBuffer2.append(TtmlNode.ANONYMOUS_REGION_ID);
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(TtmlNode.ANONYMOUS_REGION_ID));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(com.mbridge.msdk.foundation.same.a.V + "," + com.mbridge.msdk.foundation.same.a.g));
            stringBuffer2.append("|");
            stringBuffer2.append(k0.j());
            stringBuffer2.append("|");
            this.cParams = stringBuffer2;
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                o0.b(TAG, th.getMessage(), th);
            }
        }
        return this.cParams.toString();
    }
}
