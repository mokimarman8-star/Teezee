package com.apm.insight.l;

import android.annotation.TargetApi;
import android.app.ActivityManager;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class i {
    private static a a = new b(0);

    static class a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }
    }

    @TargetApi(16)
    static class b extends a {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.apm.insight.l.i.a
        public final long a(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static long a(ActivityManager.MemoryInfo memoryInfo) {
        return a.a(memoryInfo);
    }
}
