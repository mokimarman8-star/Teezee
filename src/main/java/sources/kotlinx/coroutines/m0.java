package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class m0 extends AbstractCoroutineContextElement {
    public static final a b = new a(null);
    private final String a;

    public static final class a implements CoroutineContext$Key {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public m0(String str) {
        super(b);
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m0) && Intrinsics.c(this.a, ((m0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final String p() {
        return this.a;
    }

    public String toString() {
        return "CoroutineName(" + this.a + ')';
    }
}
