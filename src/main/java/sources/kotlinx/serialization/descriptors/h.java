package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class h {

    public static final class a extends h {
        public static final a a = new a();

        private a() {
            super(null);
        }
    }

    public static final class b extends h {
        public static final b a = new b();

        private b() {
            super(null);
        }
    }

    private h() {
    }

    public /* synthetic */ h(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String g = Reflection.b(getClass()).g();
        Intrinsics.e(g);
        return g;
    }
}
