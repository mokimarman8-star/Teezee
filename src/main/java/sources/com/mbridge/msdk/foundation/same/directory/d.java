package com.mbridge.msdk.foundation.same.directory;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d extends b {
    public d(String str) {
        super(str);
    }

    @Override // com.mbridge.msdk.foundation.same.directory.b
    protected List<a> b() {
        ArrayList<a> arrayList = new ArrayList<>();
        a(arrayList, c.MBRIDGE_RES_MANAGER_DIR, "mb/res");
        a(arrayList, c.AD_MOVIES, "mb/res/Movies").a(c.MBRIDGE_VC, "mb/res/.MBridge_VC");
        a a = a(arrayList, c.AD_MBRIDGE_700, "mb/res/.mbridge700");
        a.a(c.MBRIDGE_700_IMG, "mb/res/img");
        a.a(c.MBRIDGE_700_IMG_PICASSO, "mb/res/picasso");
        a.a(c.MBRIDGE_700_RES, "mb/res/res");
        a.a(c.MBRIDGE_700_HTML, "mb/res/html");
        a.a(c.MBRIDGE_700_XML, "mb/res/xml");
        a.a(c.MBRIDGE_700_CONFIG, "mb/config");
        c cVar = c.MBRIDGE_OTHER;
        a(arrayList, cVar, "mb/other");
        a(arrayList, c.MBRIDGE_CRASH_INFO, "mb/crashinfo");
        a(arrayList, cVar, "mb/other");
        return arrayList;
    }
}
