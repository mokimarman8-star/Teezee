package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class u extends EdgeEffect {

    /* renamed from: a, reason: collision with root package name */
    private final float f2342a;

    /* renamed from: b, reason: collision with root package name */
    private float f2343b;

    public u(Context context) {
        super(context);
        this.f2342a = o0.a.a(context).D0(o0.i.g(1));
    }

    public final void a(float f5) {
        float f6 = this.f2343b + f5;
        this.f2343b = f6;
        if (Math.abs(f6) > this.f2342a) {
            onRelease();
        }
    }

    @Override // android.widget.EdgeEffect
    public void onAbsorb(int i5) {
        this.f2343b = 0.0f;
        super.onAbsorb(i5);
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float f5) {
        this.f2343b = 0.0f;
        super.onPull(f5);
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float f5, float f6) {
        this.f2343b = 0.0f;
        super.onPull(f5, f6);
    }

    @Override // android.widget.EdgeEffect
    public void onRelease() {
        this.f2343b = 0.0f;
        super.onRelease();
    }
}
