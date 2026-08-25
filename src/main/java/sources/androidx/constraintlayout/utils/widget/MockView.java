package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class MockView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f6469a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f6470b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f6471c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6472d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6473e;

    /* renamed from: f, reason: collision with root package name */
    protected String f6474f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f6475g;

    /* renamed from: h, reason: collision with root package name */
    private int f6476h;

    /* renamed from: i, reason: collision with root package name */
    private int f6477i;

    /* renamed from: j, reason: collision with root package name */
    private int f6478j;

    /* renamed from: k, reason: collision with root package name */
    private int f6479k;

    public MockView(Context context) {
        super(context);
        this.f6469a = new Paint();
        this.f6470b = new Paint();
        this.f6471c = new Paint();
        this.f6472d = true;
        this.f6473e = true;
        this.f6474f = null;
        this.f6475g = new Rect();
        this.f6476h = Color.argb(255, 0, 0, 0);
        this.f6477i = Color.argb(255, 200, 200, 200);
        this.f6478j = Color.argb(255, 50, 50, 50);
        this.f6479k = 4;
        a(context, null);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6469a = new Paint();
        this.f6470b = new Paint();
        this.f6471c = new Paint();
        this.f6472d = true;
        this.f6473e = true;
        this.f6474f = null;
        this.f6475g = new Rect();
        this.f6476h = Color.argb(255, 0, 0, 0);
        this.f6477i = Color.argb(255, 200, 200, 200);
        this.f6478j = Color.argb(255, 50, 50, 50);
        this.f6479k = 4;
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f6469a = new Paint();
        this.f6470b = new Paint();
        this.f6471c = new Paint();
        this.f6472d = true;
        this.f6473e = true;
        this.f6474f = null;
        this.f6475g = new Rect();
        this.f6476h = Color.argb(255, 0, 0, 0);
        this.f6477i = Color.argb(255, 200, 200, 200);
        this.f6478j = Color.argb(255, 50, 50, 50);
        this.f6479k = 4;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.MockView_mock_label) {
                    this.f6474f = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.f6472d = obtainStyledAttributes.getBoolean(index, this.f6472d);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.f6476h = obtainStyledAttributes.getColor(index, this.f6476h);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.f6478j = obtainStyledAttributes.getColor(index, this.f6478j);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.f6477i = obtainStyledAttributes.getColor(index, this.f6477i);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.f6473e = obtainStyledAttributes.getBoolean(index, this.f6473e);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f6474f == null) {
            try {
                this.f6474f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f6469a.setColor(this.f6476h);
        this.f6469a.setAntiAlias(true);
        this.f6470b.setColor(this.f6477i);
        this.f6470b.setAntiAlias(true);
        this.f6471c.setColor(this.f6478j);
        this.f6479k = Math.round(this.f6479k * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f6472d) {
            width--;
            height--;
            float f5 = width;
            float f6 = height;
            canvas.drawLine(0.0f, 0.0f, f5, f6, this.f6469a);
            canvas.drawLine(0.0f, f6, f5, 0.0f, this.f6469a);
            canvas.drawLine(0.0f, 0.0f, f5, 0.0f, this.f6469a);
            canvas.drawLine(f5, 0.0f, f5, f6, this.f6469a);
            canvas.drawLine(f5, f6, 0.0f, f6, this.f6469a);
            canvas.drawLine(0.0f, f6, 0.0f, 0.0f, this.f6469a);
        }
        String str = this.f6474f;
        if (str == null || !this.f6473e) {
            return;
        }
        this.f6470b.getTextBounds(str, 0, str.length(), this.f6475g);
        float width2 = (width - this.f6475g.width()) / 2.0f;
        float height2 = ((height - this.f6475g.height()) / 2.0f) + this.f6475g.height();
        this.f6475g.offset((int) width2, (int) height2);
        Rect rect = this.f6475g;
        int i5 = rect.left;
        int i6 = this.f6479k;
        rect.set(i5 - i6, rect.top - i6, rect.right + i6, rect.bottom + i6);
        canvas.drawRect(this.f6475g, this.f6471c);
        canvas.drawText(this.f6474f, width2, height2, this.f6470b);
    }
}
