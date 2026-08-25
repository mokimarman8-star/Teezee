package com.mbridge.msdk.dycreator.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f {
    private static volatile f b;
    private com.mbridge.msdk.dycreator.engine.b a;

    private f(Context context) {
        this.a = null;
        com.mbridge.msdk.dycreator.engine.b a = com.mbridge.msdk.dycreator.engine.b.a();
        this.a = a;
        a.a(context, TtmlNode.ANONYMOUS_REGION_ID);
    }

    public static f a(Context context) {
        if (b == null) {
            synchronized (f.class) {
                try {
                    if (b == null) {
                        b = new f(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public View a(ViewGroup viewGroup, String str) {
        if (viewGroup != null && !TextUtils.isEmpty(str)) {
            if (viewGroup.getId() == str.hashCode()) {
                return viewGroup;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getId() == str.hashCode()) {
                    return childAt;
                }
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, str);
                }
            }
        }
        return null;
    }

    public View a(String str) {
        if (new File(str).exists()) {
            return this.a.e(str);
        }
        return null;
    }
}
