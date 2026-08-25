package com.transsion.push.notification;

import com.transsion.push.bean.MsgType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final a d = new a(null);
    private static Void e;
    private static final Void f = null;
    private static final d g = new d((String) e, -1, (String) f);
    private static final d h = new d("oneroom.group.tag.tpush", 1201, "oneroom.group.key.tpush");
    private static final d i = new d("oneroom.group.tag.cms", 1202, "oneroom.group.key.cms");
    private static final d j = new d("oneroom.group.tag.permanent", 1204, "oneroom.group.key.permanent");
    private String a;
    private int b;
    private String c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            return d.i;
        }

        public final d b() {
            return d.j;
        }

        public final d c(String str) {
            return Intrinsics.c(str, MsgType.PERMANENT.getType()) ? b() : a();
        }
    }

    public d(String str, int i2, String str2) {
        this.a = str;
        this.b = i2;
        this.c = str2;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.a;
    }
}
