package ms;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.blankj.utilcode.util.a0;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class a extends ReplacementSpan {
    private Uri a;
    private int b;
    private Context c;
    private WeakReference d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private final float k;
    private boolean l;

    public a(Context context, int i, int i2, int i3, float f, int i4, boolean z) {
        this.c = context;
        this.b = i;
        this.e = i3;
        this.f = i2;
        this.g = a(context, i4);
        this.i = a(context, 1.0f);
        this.j = a(context, 1.0f);
        this.h = a(context, 4.0f);
        this.k = f;
        this.l = z;
    }

    private static int a(Context context, float f) {
        return a0.a(f);
    }

    private Drawable b() {
        WeakReference weakReference = this.d;
        Drawable drawable = weakReference != null ? (Drawable) weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable c = c();
        this.d = new WeakReference(c);
        return c;
    }

    private int d() {
        Drawable b = b();
        if (b == null) {
            return 0;
        }
        return b.getIntrinsicWidth();
    }

    public Drawable c() {
        Drawable drawable = null;
        try {
            if (this.a != null) {
                InputStream openInputStream = this.c.getContentResolver().openInputStream(this.a);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.c.getResources(), BitmapFactory.decodeStream(openInputStream));
                try {
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    openInputStream.close();
                    return bitmapDrawable;
                } catch (Exception unused) {
                    drawable = bitmapDrawable;
                }
            } else if (this.b != -111) {
                drawable = this.c.getResources().getDrawable(this.b);
                drawable.setColorFilter(this.f, PorterDuff.Mode.SRC_IN);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
        } catch (Exception unused2) {
        }
        return drawable;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int color = paint.getColor();
        float textSize = paint.getTextSize();
        paint.setColor(this.e);
        boolean z = this.l;
        int i6 = z ? 0 : 6;
        int i7 = z ? 6 : 0;
        float f2 = i6;
        float size = f + getSize(paint, charSequence, i, i2, paint.getFontMetricsInt());
        RectF rectF = new RectF(f + f2, i3 + this.i, size - i7, i5 - this.j);
        int i8 = this.h;
        canvas.drawRoundRect(rectF, i8, i8, paint);
        paint.setColor(this.f);
        paint.setTextSize(this.k);
        canvas.drawText(charSequence, i, i2, f + this.g, i4 - ((this.i + this.j) / 2), paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
        Drawable b = b();
        if (b == null || i2 - i <= 2) {
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i9 = (i4 + ((fontMetricsInt.descent + fontMetricsInt.ascent) / 2)) - (b.getBounds().bottom / 2);
        canvas.save();
        canvas.translate(((size - this.g) - d()) + f2, i9);
        b.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        float textSize = paint.getTextSize();
        paint.setTextSize(this.k);
        int measureText = ((int) paint.measureText(charSequence, i, i2)) + (this.g * 2) + d();
        paint.setTextSize(textSize);
        return measureText;
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextSize(this.k * textPaint.density);
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextSize(this.k * textPaint.density);
    }
}
