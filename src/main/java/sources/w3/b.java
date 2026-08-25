package w3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f18145c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Map f18146d = new LinkedHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final ReentrantLock f18147a;

    /* renamed from: b, reason: collision with root package name */
    private final c f18148b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final c c(String str) {
            return new c(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ReentrantLock d(String str) {
            ReentrantLock reentrantLock;
            synchronized (this) {
                try {
                    Map map = b.f18146d;
                    Object obj = map.get(str);
                    if (obj == null) {
                        obj = new ReentrantLock();
                        map.put(str, obj);
                    }
                    reentrantLock = (ReentrantLock) obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return reentrantLock;
        }
    }

    public b(String str, boolean z5) {
        Intrinsics.h(str, "filename");
        a aVar = f18145c;
        this.f18147a = aVar.d(str);
        this.f18148b = z5 ? aVar.c(str) : null;
    }

    public final Object b(Function0 function0, Function1 function1) {
        Intrinsics.h(function0, "onLocked");
        Intrinsics.h(function1, "onLockError");
        this.f18147a.lock();
        boolean z5 = false;
        try {
            c cVar = this.f18148b;
            if (cVar != null) {
                cVar.a();
            }
            z5 = true;
            try {
                Object invoke = function0.invoke();
                this.f18147a.unlock();
                return invoke;
            } finally {
                c cVar2 = this.f18148b;
                if (cVar2 != null) {
                    cVar2.b();
                }
            }
        } catch (Throwable th) {
            try {
                if (z5) {
                    throw th;
                }
                function1.invoke(th);
                throw new KotlinNothingValueException();
            } catch (Throwable th2) {
                this.f18147a.unlock();
                throw th2;
            }
        }
    }
}
