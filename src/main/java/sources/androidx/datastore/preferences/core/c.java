package androidx.datastore.preferences.core;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f7510a;

        public a(String str) {
            Intrinsics.h(str, "name");
            this.f7510a = str;
        }

        public final String a() {
            return this.f7510a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Intrinsics.c(this.f7510a, ((a) obj).f7510a);
            }
            return false;
        }

        public int hashCode() {
            return this.f7510a.hashCode();
        }

        public String toString() {
            return this.f7510a;
        }
    }

    public static final class b {
    }

    public abstract Map a();

    public abstract Object b(a aVar);

    public final MutablePreferences c() {
        return new MutablePreferences(MapsKt.w(a()), false);
    }

    public final c d() {
        return new MutablePreferences(MapsKt.w(a()), true);
    }
}
