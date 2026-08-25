package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class o {

    /* renamed from: b, reason: collision with root package name */
    private static volatile o f7727b;

    /* renamed from: c, reason: collision with root package name */
    static final o f7728c = new o(true);

    /* renamed from: a, reason: collision with root package name */
    private final Map f7729a = Collections.emptyMap();

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f7730a;

        /* renamed from: b, reason: collision with root package name */
        private final int f7731b;

        a(Object obj, int i5) {
            this.f7730a = obj;
            this.f7731b = i5;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7730a == aVar.f7730a && this.f7731b == aVar.f7731b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f7730a) * 65535) + this.f7731b;
        }
    }

    o(boolean z5) {
    }

    public static o b() {
        if (x0.f7784d) {
            return f7728c;
        }
        o oVar = f7727b;
        if (oVar == null) {
            synchronized (o.class) {
                try {
                    oVar = f7727b;
                    if (oVar == null) {
                        oVar = n.a();
                        f7727b = oVar;
                    }
                } finally {
                }
            }
        }
        return oVar;
    }

    public GeneratedMessageLite.d a(n0 n0Var, int i5) {
        android.support.v4.media.session.c.a(this.f7729a.get(new a(n0Var, i5)));
        return null;
    }
}
