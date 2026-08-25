package androidx.compose.ui.platform;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.SessionMutex;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.CoroutineContext;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i0 implements kotlinx.coroutines.n0 {

    /* renamed from: a, reason: collision with root package name */
    private final View f4800a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.compose.ui.text.input.e0 f4801b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlinx.coroutines.n0 f4802c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicReference f4803d = SessionMutex.a();

    public i0(View view, androidx.compose.ui.text.input.e0 e0Var, kotlinx.coroutines.n0 n0Var) {
        this.f4800a = view;
        this.f4801b = e0Var;
        this.f4802c = n0Var;
    }

    public final InputConnection a(EditorInfo editorInfo) {
        android.support.v4.media.session.c.a(SessionMutex.c(this.f4803d));
        return null;
    }

    public final boolean b() {
        android.support.v4.media.session.c.a(SessionMutex.c(this.f4803d));
        return false;
    }

    public CoroutineContext getCoroutineContext() {
        return this.f4802c.getCoroutineContext();
    }
}
