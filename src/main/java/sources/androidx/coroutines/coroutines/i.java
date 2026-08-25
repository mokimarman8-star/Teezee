package androidx.coroutines.coroutines;

import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.g;
import y3.b;
import y3.e;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class i implements b, a {

    /* renamed from: a, reason: collision with root package name */
    private final b f13172a;

    /* renamed from: b, reason: collision with root package name */
    private final a f13173b;

    /* renamed from: c, reason: collision with root package name */
    private CoroutineContext f13174c;

    /* renamed from: d, reason: collision with root package name */
    private Throwable f13175d;

    public i(b bVar, a aVar) {
        Intrinsics.h(bVar, "delegate");
        Intrinsics.h(aVar, "lock");
        this.f13172a = bVar;
        this.f13173b = aVar;
    }

    public /* synthetic */ i(b bVar, a aVar, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i5 & 2) != 0 ? g.b(false, 1, (Object) null) : aVar);
    }

    @Override // y3.b
    public e F0(String str) {
        Intrinsics.h(str, "sql");
        return this.f13172a.F0(str);
    }

    public boolean b(Object obj) {
        return this.f13173b.b(obj);
    }

    @Override // y3.b, java.lang.AutoCloseable
    public void close() {
        this.f13172a.close();
    }

    public boolean d() {
        return this.f13173b.d();
    }

    public Object f(Object obj, Continuation continuation) {
        return this.f13173b.f(obj, continuation);
    }

    public final void h(StringBuilder sb) {
        Intrinsics.h(sb, "builder");
        if (this.f13174c == null && this.f13175d == null) {
            sb.append("\t\tStatus: Free connection");
            sb.append('\n');
            return;
        }
        sb.append("\t\tStatus: Acquired connection");
        sb.append('\n');
        CoroutineContext coroutineContext = this.f13174c;
        if (coroutineContext != null) {
            sb.append("\t\tCoroutine: " + coroutineContext);
            sb.append('\n');
        }
        Throwable th = this.f13175d;
        if (th != null) {
            sb.append("\t\tAcquired:");
            sb.append('\n');
            Iterator it = CollectionsKt.d0(StringsKt.y0(ExceptionsKt.b(th)), 1).iterator();
            while (it.hasNext()) {
                sb.append("\t\t" + ((String) it.next()));
                sb.append('\n');
            }
        }
    }

    public final i j(CoroutineContext coroutineContext) {
        Intrinsics.h(coroutineContext, "context");
        this.f13174c = coroutineContext;
        this.f13175d = new Throwable();
        return this;
    }

    public final i k() {
        this.f13174c = null;
        this.f13175d = null;
        return this;
    }

    public String toString() {
        return this.f13172a.toString();
    }

    public void unlock(Object obj) {
        this.f13173b.unlock(obj);
    }
}
