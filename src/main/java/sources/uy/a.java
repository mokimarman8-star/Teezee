package uy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class a {
    private ValueAnimator b;
    private List a = new ArrayList();
    private int c = 150;
    private Interpolator d = new AccelerateDecelerateInterpolator();
    private Animator.AnimatorListener e = new C0110a();
    private ValueAnimator.AnimatorUpdateListener f = new b();

    /* renamed from: uy.a$a, reason: collision with other inner class name */
    class C0110a extends AnimatorListenerAdapter {
        C0110a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.d(0);
            a.this.b = null;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i = (int) floatValue;
            float f = floatValue - i;
            if (floatValue < 0.0f) {
                i--;
                f += 1.0f;
            }
            a.this.e(i, f, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((MagicIndicator) it.next()).onPageScrollStateChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, float f, int i2) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((MagicIndicator) it.next()).onPageScrolled(i, f, i2);
        }
    }

    public static yy.a f(List list, int i) {
        yy.a aVar;
        if (i >= 0 && i <= list.size() - 1) {
            return (yy.a) list.get(i);
        }
        yy.a aVar2 = new yy.a();
        if (i < 0) {
            aVar = (yy.a) list.get(0);
        } else {
            i = (i - list.size()) + 1;
            aVar = (yy.a) list.get(list.size() - 1);
        }
        aVar2.a = aVar.a + (aVar.b() * i);
        aVar2.b = aVar.b;
        aVar2.c = aVar.c + (aVar.b() * i);
        aVar2.d = aVar.d;
        aVar2.e = aVar.e + (aVar.b() * i);
        aVar2.f = aVar.f;
        aVar2.g = aVar.g + (i * aVar.b());
        aVar2.h = aVar.h;
        return aVar2;
    }
}
