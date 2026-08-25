package androidx.compose.ui.text.platform;

import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class h extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.ui.text.f f5319a;

    public h(androidx.compose.ui.text.f fVar) {
        this.f5319a = fVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        this.f5319a.a();
    }
}
