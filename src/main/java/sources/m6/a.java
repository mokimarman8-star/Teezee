package m6;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a implements b {
    public static final C0148a b = new C0148a(null);
    private final float a;

    /* renamed from: m6.a$a, reason: collision with other inner class name */
    public static final class C0148a {
        private C0148a() {
        }

        public /* synthetic */ C0148a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmOverloads
    public a() {
        this(0.0f, 1, null);
    }

    public a(float f) {
        this.a = f;
    }

    public /* synthetic */ a(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f);
    }

    @Override // m6.b
    public Animator[] a(View view) {
        Intrinsics.h(view, "view");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", this.a, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new LinearInterpolator());
        Intrinsics.g(ofFloat, "animator");
        return new Animator[]{ofFloat};
    }
}
