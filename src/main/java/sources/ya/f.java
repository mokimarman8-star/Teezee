package ya;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f extends ya.a {
    private final float g;
    private final float h;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.b.setTranslationY(0.0f);
            f.this.k(0.0f);
        }
    }

    public f(View view) {
        super(view);
        Resources resources = view.getResources();
        this.g = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.h = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    private Animator g() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.SCALE_Y, 1.0f));
        View view = this.b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new o1.b());
        return animatorSet;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        Animator g = g();
        g.setDuration(this.e);
        g.start();
    }

    public void h(androidx.activity.b bVar, Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.TRANSLATION_Y, this.b.getHeight() * this.b.getScaleY());
        ofFloat.setInterpolator(new o1.b());
        ofFloat.setDuration(qa.a.c(this.c, this.d, bVar.a()));
        ofFloat.addListener(new a());
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void i(androidx.activity.b bVar, Animator.AnimatorListener animatorListener) {
        Animator g = g();
        g.setDuration(qa.a.c(this.c, this.d, bVar.a()));
        if (animatorListener != null) {
            g.addListener(animatorListener);
        }
        g.start();
    }

    public void j(androidx.activity.b bVar) {
        super.d(bVar);
    }

    public void k(float f) {
        float a2 = a(f);
        float width = this.b.getWidth();
        float height = this.b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f2 = this.g / width;
        float f3 = this.h / height;
        float a3 = 1.0f - qa.a.a(0.0f, f2, a2);
        float a4 = 1.0f - qa.a.a(0.0f, f3, a2);
        this.b.setScaleX(a3);
        this.b.setPivotY(height);
        this.b.setScaleY(a4);
        View view = this.b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(a4 != 0.0f ? a3 / a4 : 1.0f);
            }
        }
    }

    public void l(androidx.activity.b bVar) {
        if (super.e(bVar) == null) {
            return;
        }
        k(bVar.a());
    }
}
