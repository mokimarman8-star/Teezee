package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.v;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class e implements v {

    /* renamed from: b, reason: collision with root package name */
    private final v f2200b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2201c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2202d;

    public e(v vVar, int i5, int i6) {
        this.f2200b = vVar;
        this.f2201c = i5;
        this.f2202d = i6;
    }

    @Override // androidx.compose.ui.text.input.v
    public int a(int i5) {
        int a5 = this.f2200b.a(i5);
        if (i5 >= 0 && i5 <= this.f2201c) {
            f.c(a5, this.f2202d, i5);
        }
        return a5;
    }
}
