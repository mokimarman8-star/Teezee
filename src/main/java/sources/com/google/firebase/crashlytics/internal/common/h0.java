package com.google.firebase.crashlytics.internal.common;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface h0 {

    public static abstract class a {
        static a a(String str, f0 f0Var) {
            return new c(str, f0Var.b(), f0Var.a());
        }

        public static a b(String str) {
            return new c(str, null, null);
        }

        public abstract String c();

        public abstract String d();

        public abstract String e();
    }

    a a();
}
