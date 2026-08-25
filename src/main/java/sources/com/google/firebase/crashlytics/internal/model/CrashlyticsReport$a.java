package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.c;
import com.google.firebase.crashlytics.internal.model.d;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class CrashlyticsReport$a {

    public static abstract class a {

        /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a$a$a, reason: collision with other inner class name */
        public static abstract class AbstractC0020a {
            public abstract a a();

            public abstract AbstractC0020a b(String str);

            public abstract AbstractC0020a c(String str);

            public abstract AbstractC0020a d(String str);
        }

        public static AbstractC0020a a() {
            return new d.b();
        }

        public abstract String b();

        public abstract String c();

        public abstract String d();
    }

    public static abstract class b {
        public abstract CrashlyticsReport$a a();

        public abstract b b(List list);

        public abstract b c(int i);

        public abstract b d(int i);

        public abstract b e(String str);

        public abstract b f(long j);

        public abstract b g(int i);

        public abstract b h(long j);

        public abstract b i(long j);

        public abstract b j(String str);
    }

    public static b a() {
        return new c.b();
    }

    public abstract List b();

    public abstract int c();

    public abstract int d();

    public abstract String e();

    public abstract long f();

    public abstract int g();

    public abstract long h();

    public abstract long i();

    public abstract String j();
}
