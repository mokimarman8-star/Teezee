package androidx.core.view.insets;

import android.graphics.drawable.ColorDrawable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ColorProtection extends Protection {
    private int mColor;
    private final ColorDrawable mDrawable;
    private boolean mHasColor;

    public ColorProtection(int i5) {
        super(i5);
        this.mDrawable = new ColorDrawable();
        this.mColor = 0;
    }

    public ColorProtection(int i5, int i6) {
        this(i5);
        setColor(i6);
    }

    private void setColorInner(int i5) {
        if (this.mColor != i5) {
            this.mColor = i5;
            this.mDrawable.setColor(i5);
            setDrawable(this.mDrawable);
        }
    }

    @Override // androidx.core.view.insets.Protection
    void dispatchColorHint(int i5) {
        if (this.mHasColor) {
            return;
        }
        setColorInner(i5);
    }

    public int getColor() {
        return this.mColor;
    }

    @Override // androidx.core.view.insets.Protection
    boolean occupiesCorners() {
        return true;
    }

    public void setColor(int i5) {
        this.mHasColor = true;
        setColorInner(i5);
    }
}
