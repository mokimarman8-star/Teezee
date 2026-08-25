package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f795a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f796b;

    /* renamed from: c, reason: collision with root package name */
    private int f797c;

    public ButtonBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f797c = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ButtonBarLayout);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.ButtonBarLayout, attributeSet, obtainStyledAttributes, 0, 0);
        this.f795a = obtainStyledAttributes.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f795a);
        }
    }

    private int a(int i5) {
        int childCount = getChildCount();
        while (i5 < childCount) {
            if (getChildAt(i5).getVisibility() == 0) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    private boolean b() {
        return this.f796b;
    }

    private void setStacked(boolean z5) {
        if (this.f796b != z5) {
            if (!z5 || this.f795a) {
                this.f796b = z5;
                setOrientation(z5 ? 1 : 0);
                setGravity(z5 ? 8388613 : 80);
                View findViewById = findViewById(R.id.spacer);
                if (findViewById != null) {
                    findViewById.setVisibility(z5 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        int i7;
        boolean z5;
        int size = View.MeasureSpec.getSize(i5);
        int i8 = 0;
        if (this.f795a) {
            if (size > this.f797c && b()) {
                setStacked(false);
            }
            this.f797c = size;
        }
        if (b() || View.MeasureSpec.getMode(i5) != 1073741824) {
            i7 = i5;
            z5 = false;
        } else {
            i7 = View.MeasureSpec.makeMeasureSpec(size, EditorInfoCompat.IME_FLAG_FORCE_ASCII);
            z5 = true;
        }
        super.onMeasure(i7, i6);
        if (this.f795a && !b() && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z5 = true;
        }
        if (z5) {
            super.onMeasure(i5, i6);
        }
        int a5 = a(0);
        if (a5 >= 0) {
            View childAt = getChildAt(a5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (b()) {
                int a6 = a(a5 + 1);
                if (a6 >= 0) {
                    paddingTop += getChildAt(a6).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i8 = paddingTop;
            } else {
                i8 = paddingTop + getPaddingBottom();
            }
        }
        if (ViewCompat.getMinimumHeight(this) != i8) {
            setMinimumHeight(i8);
            if (i6 == 0) {
                super.onMeasure(i5, i6);
            }
        }
    }

    public void setAllowStacking(boolean z5) {
        if (this.f795a != z5) {
            this.f795a = z5;
            if (!z5 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
