package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class Placeholder extends View {
    private int a;
    private View b;
    private int c;

    public Placeholder(Context context) {
        super(context);
        this.a = -1;
        this.b = null;
        this.c = 4;
        a(null);
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = null;
        this.c = 4;
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -1;
        this.b = null;
        this.c = 4;
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.a = -1;
        this.b = null;
        this.c = 4;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        super.setVisibility(this.c);
        this.a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ConstraintLayout_placeholder_content) {
                    this.a = obtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == R$styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.c = obtainStyledAttributes.getInt(index, this.c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public View getContent() {
        return this.b;
    }

    public int getEmptyVisibility() {
        return this.c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.a == i) {
            return;
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
            this.b.getLayoutParams().j0 = false;
            this.b = null;
        }
        this.a = i;
        if (i == -1 || (findViewById = ((View) getParent()).findViewById(i)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i) {
        this.c = i;
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
        if (this.b == null) {
            return;
        }
        ConstraintLayout.b layoutParams = getLayoutParams();
        ConstraintLayout.b layoutParams2 = this.b.getLayoutParams();
        layoutParams2.v0.n1(0);
        ConstraintWidget.DimensionBehaviour C = layoutParams.v0.C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        if (C != dimensionBehaviour) {
            layoutParams.v0.o1(layoutParams2.v0.Y());
        }
        if (layoutParams.v0.V() != dimensionBehaviour) {
            layoutParams.v0.P0(layoutParams2.v0.z());
        }
        layoutParams2.v0.n1(8);
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        if (this.a == -1 && !isInEditMode()) {
            setVisibility(this.c);
        }
        View findViewById = constraintLayout.findViewById(this.a);
        this.b = findViewById;
        if (findViewById != null) {
            findViewById.getLayoutParams().j0 = true;
            this.b.setVisibility(0);
            setVisibility(0);
        }
    }
}
