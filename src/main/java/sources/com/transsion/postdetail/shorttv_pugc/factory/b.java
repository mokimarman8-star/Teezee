package com.transsion.postdetail.shorttv_pugc.factory;

import com.transsion.mb.config.manager.ConfigBean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements vs.b {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public String a() {
        ConfigBean c = cm.f.c.a().c("shorts_unlock_config", true);
        String value = c != null ? c.getValue() : null;
        a.a.f(wf.a.a, "ShortTv", "getUnlockConfig config：" + value, false, 4, (Object) null);
        return value;
    }
}
