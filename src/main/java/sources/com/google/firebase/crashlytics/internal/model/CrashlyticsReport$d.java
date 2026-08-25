package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.f;
import com.google.firebase.crashlytics.internal.model.g;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class CrashlyticsReport$d {

    public static abstract class a {
        public abstract CrashlyticsReport$d a();

        public abstract a b(List list);

        public abstract a c(String str);
    }

    public static abstract class b {

        public static abstract class a {
            public abstract b a();

            public abstract a b(byte[] bArr);

            public abstract a c(String str);
        }

        public static a a() {
            return new g.b();
        }

        public abstract byte[] b();

        public abstract String c();
    }

    public static a a() {
        return new f.b();
    }

    public abstract List b();

    public abstract String c();
}
