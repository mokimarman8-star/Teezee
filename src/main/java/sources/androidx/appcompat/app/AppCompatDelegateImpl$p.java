package androidx.appcompat.app;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class AppCompatDelegateImpl$p extends ContentFrameLayout {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f249i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatDelegateImpl$p(AppCompatDelegateImpl appCompatDelegateImpl, Context context) {
        super(context);
        this.f249i = appCompatDelegateImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(int i5, int i6) {
        return i5 < -5 || i6 < -5 || i5 > getWidth() + 5 || i6 > getHeight() + 5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f249i.k0(keyEvent) || super/*android.widget.FrameLayout*/.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super/*android.widget.FrameLayout*/.onInterceptTouchEvent(motionEvent);
        }
        this.f249i.f0(0);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundResource(int i5) {
        setBackgroundDrawable(g.a.b(getContext(), i5));
    }
}
