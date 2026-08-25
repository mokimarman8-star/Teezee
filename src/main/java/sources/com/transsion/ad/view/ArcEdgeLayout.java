package com.transsion.ad.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.transsion.ad.R;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001>B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0017\u0010\u0016J7\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010,R\u0016\u0010/\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00109\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00106R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/transsion/ad/view/ArcEdgeLayout;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "a", "()V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "onDraw", BuildConfig.FLAVOR, "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Lcom/transsion/ad/view/ArcEdgeLayout$ArcPosition;", "position", "setArcPosition", "(Lcom/transsion/ad/view/ArcEdgeLayout$ArcPosition;)V", BuildConfig.FLAVOR, "height", "setArcHeight", "(F)V", "Lcom/transsion/ad/view/ArcEdgeLayout$ArcPosition;", "arcPosition", "F", "arcHeight", "Landroid/graphics/Path;", "c", "Landroid/graphics/Path;", "path", "Landroid/graphics/RectF;", "d", "Landroid/graphics/RectF;", "rect", "e", "arcRect", "Landroid/graphics/Paint;", "f", "Landroid/graphics/Paint;", "paint", "ArcPosition", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ArcEdgeLayout extends ViewGroup {

    /* renamed from: a, reason: from kotlin metadata */
    private ArcPosition arcPosition;

    /* renamed from: b, reason: from kotlin metadata */
    private float arcHeight;

    /* renamed from: c, reason: from kotlin metadata */
    private final Path path;

    /* renamed from: d, reason: from kotlin metadata */
    private final RectF rect;

    /* renamed from: e, reason: from kotlin metadata */
    private final RectF arcRect;

    /* renamed from: f, reason: from kotlin metadata */
    private final Paint paint;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/transsion/ad/view/ArcEdgeLayout$ArcPosition;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "TOP", "RIGHT", "BOTTOM", "LEFT", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ArcPosition {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ArcPosition[] $VALUES;
        public static final ArcPosition TOP = new ArcPosition("TOP", 0);
        public static final ArcPosition RIGHT = new ArcPosition("RIGHT", 1);
        public static final ArcPosition BOTTOM = new ArcPosition("BOTTOM", 2);
        public static final ArcPosition LEFT = new ArcPosition("LEFT", 3);

        private static final /* synthetic */ ArcPosition[] $values() {
            return new ArcPosition[]{TOP, RIGHT, BOTTOM, LEFT};
        }

        static {
            ArcPosition[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private ArcPosition(String str, int i) {
        }

        public static EnumEntries<ArcPosition> getEntries() {
            return $ENTRIES;
        }

        public static ArcPosition valueOf(String str) {
            return (ArcPosition) Enum.valueOf(ArcPosition.class, str);
        }

        public static ArcPosition[] values() {
            return (ArcPosition[]) $VALUES.clone();
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ArcPosition.values().length];
            try {
                iArr[ArcPosition.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArcPosition.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArcPosition.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArcPosition.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ArcEdgeLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ArcEdgeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ArcEdgeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.arcPosition = ArcPosition.TOP;
        this.path = new Path();
        this.rect = new RectF();
        this.arcRect = new RectF();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.paint = paint;
        setLayerType(2, null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ArcEdgeLayout);
        try {
            this.arcPosition = ArcPosition.values()[RangesKt.l(obtainStyledAttributes.getInt(R.styleable.ArcEdgeLayout_arcPosition, 0), 0, 3)];
            this.arcHeight = obtainStyledAttributes.getDimension(R.styleable.ArcEdgeLayout_arcHeight, 40.0f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public /* synthetic */ ArcEdgeLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void a() {
        this.path.reset();
        int i = a.a[this.arcPosition.ordinal()];
        if (i == 1) {
            RectF rectF = this.arcRect;
            float f = -this.arcHeight;
            float width = getWidth();
            float f2 = this.arcHeight;
            rectF.set(f, 0.0f, width + f2, f2 * 2);
            this.path.moveTo(0.0f, this.arcHeight);
            this.path.arcTo(this.arcRect, 180.0f, 180.0f, false);
            this.path.lineTo(getWidth(), getHeight());
            this.path.lineTo(0.0f, getHeight());
        } else if (i == 2) {
            RectF rectF2 = this.arcRect;
            float width2 = getWidth();
            float f3 = this.arcHeight;
            rectF2.set(width2 - (2 * f3), -f3, getWidth(), getHeight() + this.arcHeight);
            this.path.moveTo(0.0f, 0.0f);
            this.path.lineTo(getWidth() - this.arcHeight, 0.0f);
            this.path.arcTo(this.arcRect, 270.0f, 180.0f, false);
            this.path.lineTo(0.0f, getHeight());
        } else if (i == 3) {
            this.arcRect.set(-this.arcHeight, getHeight() - (this.arcHeight * 2), getWidth() + this.arcHeight, getHeight());
            this.path.moveTo(0.0f, 0.0f);
            this.path.lineTo(getWidth(), 0.0f);
            this.path.lineTo(getWidth(), getHeight() - this.arcHeight);
            this.path.arcTo(this.arcRect, 0.0f, 180.0f, false);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            RectF rectF3 = this.arcRect;
            float f4 = this.arcHeight;
            rectF3.set(0.0f, -f4, f4 * 2, getHeight() + this.arcHeight);
            this.path.moveTo(this.arcHeight, 0.0f);
            this.path.lineTo(getWidth(), 0.0f);
            this.path.lineTo(getWidth(), getHeight());
            this.path.lineTo(this.arcHeight, getHeight());
            this.path.arcTo(this.arcRect, 90.0f, 180.0f, false);
        }
        this.path.close();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        canvas.drawPath(this.path, this.paint);
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.rect.set(0.0f, 0.0f, w, h);
        a();
    }

    public final void setArcHeight(float height) {
        if (this.arcHeight == height) {
            return;
        }
        this.arcHeight = height;
        a();
        invalidate();
    }

    public final void setArcPosition(ArcPosition position) {
        Intrinsics.h(position, "position");
        if (this.arcPosition != position) {
            this.arcPosition = position;
            a();
            invalidate();
        }
    }
}
