package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.k1;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class k1 extends i0 implements Closeable, AutoCloseable {
    public static final a a = new a(null);

    public static final class a extends AbstractCoroutineContextKey {
        private a() {
            super(i0.Key, new Function1() { // from class: kotlinx.coroutines.j1
                public final Object invoke(Object obj) {
                    k1 d;
                    d = k1.a.d((CoroutineContext.Element) obj);
                    return d;
                }
            });
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k1 d(CoroutineContext.Element element) {
            if (element instanceof k1) {
                return (k1) element;
            }
            return null;
        }
    }

    public abstract Executor p();
}
