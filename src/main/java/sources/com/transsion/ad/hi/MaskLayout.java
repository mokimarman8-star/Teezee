package com.transsion.ad.hi;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.ad.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class MaskLayout extends FrameLayout {
    Drawable a;
    Paint b;

    public MaskLayout(@NonNull Context context) {
        this(context, null);
    }

    public MaskLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaskLayout);
        this.a = obtainStyledAttributes.getDrawable(R.styleable.MaskLayout_xhg_mask_drawable);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setFilterBitmap(true);
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.a == null) {
            super.draw(canvas);
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null);
        } else {
            canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, null, 31);
        }
        this.a.setBounds(getPaddingLeft(), getPaddingTop(), measuredWidth - getPaddingRight(), measuredHeight - getPaddingBottom());
        this.a.draw(canvas);
        if (i >= 26) {
            canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, this.b);
        } else {
            canvas.saveLayer(0.0f, 0.0f, measuredWidth, measuredHeight, this.b, 31);
        }
        super.draw(canvas);
        canvas.restore();
        canvas.restore();
    }
}
