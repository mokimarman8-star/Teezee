package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class t2 extends AbstractCoroutineContextElement {
    public static final a b = new a(null);
    public boolean a;

    public static final class a implements CoroutineContext$Key {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public t2() {
        super(b);
    }
}
