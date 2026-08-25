package androidx.compose.foundation.lazy.layout;

import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface b {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f2028a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2029b;

        /* renamed from: c, reason: collision with root package name */
        private final Object f2030c;

        public a(int i5, int i6, Object obj) {
            this.f2028a = i5;
            this.f2029b = i6;
            this.f2030c = obj;
            if (i5 < 0) {
                throw new IllegalArgumentException(("startIndex should be >= 0, but was " + i5).toString());
            }
            if (i6 > 0) {
                return;
            }
            throw new IllegalArgumentException(("size should be >0, but was " + i6).toString());
        }

        public final int a() {
            return this.f2029b;
        }

        public final int b() {
            return this.f2028a;
        }

        public final Object c() {
            return this.f2030c;
        }
    }

    void a(int i5, int i6, Function1 function1);

    a get(int i5);

    int getSize();
}
