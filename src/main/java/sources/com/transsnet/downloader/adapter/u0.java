package com.transsnet.downloader.adapter;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface u0 {

    public static final class a {
        public static void a(u0 u0Var, int i, p6.a aVar) {
        }

        public static void b(u0 u0Var, b listener) {
            Intrinsics.h(listener, "listener");
        }
    }

    public interface b {

        public static final class a {
            public static void a(b bVar, int i, int i2, int i3, boolean z) {
            }
        }

        void a(int i, int i2);

        void b(int i, int i2, int i3, boolean z);
    }

    void a(int i, p6.a aVar);

    void b(int i, p6.a aVar);

    void c(b bVar);
}
