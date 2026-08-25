package xk;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final C0102a c = new C0102a(null);
    public static final int d = 8;
    private final ImageView a;
    private final View b;

    /* renamed from: xk.a$a, reason: collision with other inner class name */
    public static final class C0102a {
        private C0102a() {
        }

        public /* synthetic */ C0102a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(ImageView imageView, View view) {
        this.a = imageView;
        this.b = view;
    }

    private final int b(int i, float f) {
        return (i & 16777215) | (((int) (RangesKt.k(f, 0.0f, 1.0f) * 255)) << 24);
    }

    public final void a(Integer num) {
        View view = this.b;
        if (view == null || num == null) {
            return;
        }
        view.setBackground(sk.a.b(new int[]{num.intValue(), num.intValue(), b(num.intValue(), 0.3f)}, GradientDrawable.Orientation.LEFT_RIGHT));
    }
}
