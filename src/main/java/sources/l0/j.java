package l0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class j extends ReplacementSpan {

    /* renamed from: k, reason: collision with root package name */
    public static final a f16355k = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public static final int f16356l = 8;

    /* renamed from: a, reason: collision with root package name */
    private final float f16357a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16358b;

    /* renamed from: c, reason: collision with root package name */
    private final float f16359c;

    /* renamed from: d, reason: collision with root package name */
    private final int f16360d;

    /* renamed from: e, reason: collision with root package name */
    private final float f16361e;

    /* renamed from: f, reason: collision with root package name */
    private final int f16362f;

    /* renamed from: g, reason: collision with root package name */
    private Paint.FontMetricsInt f16363g;

    /* renamed from: h, reason: collision with root package name */
    private int f16364h;

    /* renamed from: i, reason: collision with root package name */
    private int f16365i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f16366j;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Paint.FontMetricsInt a() {
        Paint.FontMetricsInt fontMetricsInt = this.f16363g;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        Intrinsics.y("fontMetrics");
        return null;
    }

    public final int b() {
        if (this.f16366j) {
            return this.f16365i;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.");
    }

    public final int c() {
        return this.f16362f;
    }

    public final int d() {
        if (this.f16366j) {
            return this.f16364h;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.");
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i5, int i6, float f5, int i7, int i8, int i9, Paint paint) {
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i5, int i6, Paint.FontMetricsInt fontMetricsInt) {
        float f5;
        int a5;
        this.f16366j = true;
        float textSize = paint.getTextSize();
        this.f16363g = paint.getFontMetricsInt();
        if (a().descent <= a().ascent) {
            throw new IllegalArgumentException("Invalid fontMetrics: line height can not be negative.");
        }
        int i7 = this.f16358b;
        if (i7 == 0) {
            f5 = this.f16357a * this.f16361e;
        } else {
            if (i7 != 1) {
                throw new IllegalArgumentException("Unsupported unit.");
            }
            f5 = this.f16357a * textSize;
        }
        this.f16364h = k.a(f5);
        int i8 = this.f16360d;
        if (i8 == 0) {
            a5 = k.a(this.f16359c * this.f16361e);
        } else {
            if (i8 != 1) {
                throw new IllegalArgumentException("Unsupported unit.");
            }
            a5 = k.a(this.f16359c * textSize);
        }
        this.f16365i = a5;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = a().ascent;
            fontMetricsInt.descent = a().descent;
            fontMetricsInt.leading = a().leading;
            switch (this.f16362f) {
                case 0:
                    if (fontMetricsInt.ascent > (-b())) {
                        fontMetricsInt.ascent = -b();
                        break;
                    }
                    break;
                case 1:
                case 4:
                    if (fontMetricsInt.ascent + b() > fontMetricsInt.descent) {
                        fontMetricsInt.descent = fontMetricsInt.ascent + b();
                        break;
                    }
                    break;
                case 2:
                case 5:
                    if (fontMetricsInt.ascent > fontMetricsInt.descent - b()) {
                        fontMetricsInt.ascent = fontMetricsInt.descent - b();
                        break;
                    }
                    break;
                case 3:
                case 6:
                    if (fontMetricsInt.descent - fontMetricsInt.ascent < b()) {
                        int b5 = fontMetricsInt.ascent - ((b() - (fontMetricsInt.descent - fontMetricsInt.ascent)) / 2);
                        fontMetricsInt.ascent = b5;
                        fontMetricsInt.descent = b5 + b();
                        break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unknown verticalAlign.");
            }
            fontMetricsInt.top = Math.min(a().top, fontMetricsInt.ascent);
            fontMetricsInt.bottom = Math.max(a().bottom, fontMetricsInt.descent);
        }
        return d();
    }
}
