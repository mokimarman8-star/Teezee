package androidx.compose.ui.scrollcapture;

import androidx.compose.ui.j;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class e implements androidx.compose.ui.j {

    /* renamed from: a, reason: collision with root package name */
    public static final e f4899a = new e();

    private e() {
    }

    public Object fold(Object obj, Function2 function2) {
        return j.a.a(this, obj, function2);
    }

    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return j.a.b(this, key);
    }

    public /* synthetic */ CoroutineContext.Key getKey() {
        return androidx.compose.ui.i.a(this);
    }

    @Override // androidx.compose.ui.j
    public float h() {
        return 0.0f;
    }

    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return j.a.c(this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return j.a.d(this, coroutineContext);
    }
}
