package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class Group extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }

    protected void f(ConstraintLayout constraintLayout) {
        e(constraintLayout);
    }

    protected void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        ((ConstraintHelper) this).e = false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setElevation(float f5) {
        super/*android.view.View*/.setElevation(f5);
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int i5) {
        super/*android.view.View*/.setVisibility(i5);
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updatePostLayout(ConstraintLayout constraintLayout) {
        ConstraintLayout$b constraintLayout$b = (ConstraintLayout$b) getLayoutParams();
        constraintLayout$b.f6578v0.o1(0);
        constraintLayout$b.f6578v0.P0(0);
    }
}
