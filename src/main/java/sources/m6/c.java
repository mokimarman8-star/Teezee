package m6;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c implements b {
    public static final a b = new a(null);
    private final float a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmOverloads
    public c() {
        this(0.0f, 1, null);
    }

    public c(float f) {
        this.a = f;
    }

    public /* synthetic */ c(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.5f : f);
    }

    @Override // m6.b
    public Animator[] a(View view) {
        Intrinsics.h(view, "view");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", this.a, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", this.a, 1.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        Intrinsics.g(ofFloat, "scaleX");
        Intrinsics.g(ofFloat2, "scaleY");
        return new Animator[]{ofFloat, ofFloat2};
    }
}
