package ya;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class i extends ya.a {
    private final float g;
    private final float h;
    private final float i;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ int b;

        a(boolean z, int i) {
            this.a = z;
            this.b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.b.setTranslationX(0.0f);
            i.this.k(0.0f, this.a, this.b);
        }
    }

    public i(View view) {
        super(view);
        Resources resources = view.getResources();
        this.g = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.h = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.i = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    private boolean g(int i, int i2) {
        return (GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this.b)) & i2) == i2;
    }

    private int i(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return z ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.SCALE_Y, 1.0f));
        View view = this.b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.e);
        animatorSet.start();
    }

    public void h(androidx.activity.b bVar, int i, Animator.AnimatorListener animatorListener, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        boolean z = bVar.b() == 0;
        boolean g = g(i, 3);
        float width = (this.b.getWidth() * this.b.getScaleX()) + i(g);
        View view = this.b;
        Property property = View.TRANSLATION_X;
        if (g) {
            width = -width;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, width);
        if (animatorUpdateListener != null) {
            ofFloat.addUpdateListener(animatorUpdateListener);
        }
        ofFloat.setInterpolator(new o1.b());
        ofFloat.setDuration(qa.a.c(this.c, this.d, bVar.a()));
        ofFloat.addListener(new a(z, i));
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void j(androidx.activity.b bVar) {
        super.d(bVar);
    }

    public void k(float f, boolean z, int i) {
        float a2 = a(f);
        boolean g = g(i, 3);
        boolean z2 = z == g;
        int width = this.b.getWidth();
        int height = this.b.getHeight();
        float f2 = width;
        if (f2 > 0.0f) {
            float f3 = height;
            if (f3 <= 0.0f) {
                return;
            }
            float f4 = this.g / f2;
            float f5 = this.h / f2;
            float f6 = this.i / f3;
            View view = this.b;
            if (g) {
                f2 = 0.0f;
            }
            view.setPivotX(f2);
            if (!z2) {
                f5 = -f4;
            }
            float a3 = qa.a.a(0.0f, f5, a2);
            float f7 = a3 + 1.0f;
            this.b.setScaleX(f7);
            float a4 = 1.0f - qa.a.a(0.0f, f6, a2);
            this.b.setScaleY(a4);
            View view2 = this.b;
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    childAt.setPivotX(g ? (width - childAt.getRight()) + childAt.getWidth() : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f8 = z2 ? 1.0f - a3 : 1.0f;
                    float f9 = a4 != 0.0f ? (f7 / a4) * f8 : 1.0f;
                    childAt.setScaleX(f8);
                    childAt.setScaleY(f9);
                }
            }
        }
    }

    public void l(androidx.activity.b bVar, int i) {
        if (super.e(bVar) == null) {
            return;
        }
        k(bVar.a(), bVar.b() == 0, i);
    }
}
