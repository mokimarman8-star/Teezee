package com.apm.insight.l;

import android.annotation.TargetApi;
import android.os.Debug;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c {
    private static a a = new b(0);

    /* renamed from: com.apm.insight.l.c$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static int a(Object obj, int i) {
            if (obj == null) {
                return i;
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof String) {
                try {
                    return Integer.parseInt(String.valueOf(obj));
                } catch (Throwable unused) {
                }
            }
            return i;
        }

        public static Float a(Map<? super String, Float> map) {
            float f = 0.0f;
            for (Float f2 : map.values()) {
                if (f2 != null) {
                    f += f2.floatValue();
                }
            }
            return Float.valueOf(f);
        }

        public static Long a(Map<? super String, Long> map, String str, Long l) {
            if (str == null || map == null) {
                return -1L;
            }
            Long l2 = map.get(str);
            if (l2 != null) {
                l = Long.valueOf(l2.longValue() + l.longValue());
            }
            map.put(str, l);
            return l;
        }
    }

    static class a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public int a(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }
    }

    @TargetApi(TTAdConstant.CONVERSION_LINK_LANDING_DIRECT_AND_ENDCARD)
    static class b extends a {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.apm.insight.l.c.a
        public final int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.apm.insight.l.c.a
        public final int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.apm.insight.l.c.a
        public final int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return a.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return a.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return a.c(memoryInfo);
    }
}
