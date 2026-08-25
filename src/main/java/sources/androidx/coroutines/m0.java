package androidx.coroutines;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class m0 implements CoroutineContext.Element {

    /* renamed from: c, reason: collision with root package name */
    public static final a f13228c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final ContinuationInterceptor f13229a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f13230b;

    public static final class a implements CoroutineContext.Key {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public m0(ContinuationInterceptor continuationInterceptor) {
        Intrinsics.h(continuationInterceptor, "transactionDispatcher");
        this.f13229a = continuationInterceptor;
        this.f13230b = new AtomicInteger(0);
    }

    public final void a() {
        this.f13230b.incrementAndGet();
    }

    public final ContinuationInterceptor c() {
        return this.f13229a;
    }

    public final void e() {
        if (this.f13230b.decrementAndGet() < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
    }

    public Object fold(Object obj, Function2 function2) {
        return CoroutineContext.Element.DefaultImpls.a(this, obj, function2);
    }

    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.b(this, key);
    }

    public CoroutineContext.Key getKey() {
        return f13228c;
    }

    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.c(this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.d(this, coroutineContext);
    }
}
