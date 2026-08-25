package com.google.common.base;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class h {

    public static final class b {
        private final String a;
        private final C0004b b;
        private C0004b c;
        private boolean d;
        private boolean e;

        private static final class a extends C0004b {
            private a() {
            }
        }

        /* renamed from: com.google.common.base.h$b$b, reason: collision with other inner class name */
        static class C0004b {
            String a;
            Object b;
            C0004b c;

            C0004b() {
            }
        }

        private b(String str) {
            C0004b c0004b = new C0004b();
            this.b = c0004b;
            this.c = c0004b;
            this.d = false;
            this.e = false;
            this.a = (String) m.o(str);
        }

        private C0004b e() {
            C0004b c0004b = new C0004b();
            this.c.c = c0004b;
            this.c = c0004b;
            return c0004b;
        }

        private b f(Object obj) {
            e().b = obj;
            return this;
        }

        private b g(String str, Object obj) {
            C0004b e = e();
            e.b = obj;
            e.a = (String) m.o(str);
            return this;
        }

        private a h() {
            a aVar = new a();
            this.c.c = aVar;
            this.c = aVar;
            return aVar;
        }

        private b i(String str, Object obj) {
            a h = h();
            h.b = obj;
            h.a = (String) m.o(str);
            return this;
        }

        private static boolean k(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof Optional ? !((Optional) obj).isPresent() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public b a(String str, double d) {
            return i(str, String.valueOf(d));
        }

        public b b(String str, int i) {
            return i(str, String.valueOf(i));
        }

        public b c(String str, long j) {
            return i(str, String.valueOf(j));
        }

        public b d(String str, Object obj) {
            return g(str, obj);
        }

        public b j(Object obj) {
            return f(obj);
        }

        public String toString() {
            boolean z = this.d;
            boolean z2 = this.e;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.a);
            sb2.append('{');
            String str = TtmlNode.ANONYMOUS_REGION_ID;
            for (C0004b c0004b = this.b.c; c0004b != null; c0004b = c0004b.c) {
                Object obj = c0004b.b;
                if (!(c0004b instanceof a)) {
                    if (obj == null) {
                        if (z) {
                        }
                    } else if (z2 && k(obj)) {
                    }
                }
                sb2.append(str);
                String str2 = c0004b.a;
                if (str2 != null) {
                    sb2.append(str2);
                    sb2.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb2.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb2.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static Object a(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        if (obj2 != null) {
            return obj2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
