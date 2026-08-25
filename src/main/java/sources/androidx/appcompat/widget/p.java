package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class p {

    /* renamed from: l, reason: collision with root package name */
    private static final RectF f1091l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap f1092m = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private int f1093a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1094b = false;

    /* renamed from: c, reason: collision with root package name */
    private float f1095c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f1096d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f1097e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private int[] f1098f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    private boolean f1099g = false;

    /* renamed from: h, reason: collision with root package name */
    private TextPaint f1100h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f1101i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f1102j;

    /* renamed from: k, reason: collision with root package name */
    private final d f1103k;

    private static final class a {
        @NonNull
        static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i5, int i6, @NonNull TextView textView, @NonNull TextPaint textPaint, @NonNull d dVar) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i5);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i6 == -1) {
                i6 = DescriptorProtos$Edition.EDITION_MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i6);
            try {
                dVar.a(obtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
    }

    private static class b extends d {
        b() {
        }

        @Override // androidx.appcompat.widget.p.d
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) p.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    private static class c extends b {
        c() {
        }

        @Override // androidx.appcompat.widget.p.b, androidx.appcompat.widget.p.d
        void a(StaticLayout.Builder builder, TextView textView) {
            TextDirectionHeuristic textDirectionHeuristic;
            textDirectionHeuristic = textView.getTextDirectionHeuristic();
            builder.setTextDirection(textDirectionHeuristic);
        }

        @Override // androidx.appcompat.widget.p.d
        boolean b(TextView textView) {
            boolean isHorizontallyScrollable;
            isHorizontallyScrollable = textView.isHorizontallyScrollable();
            return isHorizontallyScrollable;
        }
    }

    private static class d {
        d() {
        }

        abstract void a(StaticLayout.Builder builder, TextView textView);

        boolean b(TextView textView) {
            return ((Boolean) p.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    p(TextView textView) {
        this.f1101i = textView;
        this.f1102j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1103k = new c();
        } else {
            this.f1103k = new b();
        }
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i5 : iArr) {
            if (i5 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i5)) < 0) {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr2[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f1093a = 0;
        this.f1096d = -1.0f;
        this.f1097e = -1.0f;
        this.f1095c = -1.0f;
        this.f1098f = new int[0];
        this.f1094b = false;
    }

    private int e(RectF rectF) {
        int length = this.f1098f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i5 = 1;
        int i6 = length - 1;
        int i7 = 0;
        while (i5 <= i6) {
            int i8 = (i5 + i6) / 2;
            if (x(this.f1098f[i8], rectF)) {
                int i9 = i8 + 1;
                i7 = i5;
                i5 = i9;
            } else {
                i7 = i8 - 1;
                i6 = i7;
            }
        }
        return this.f1098f[i7];
    }

    private static Method k(String str) {
        try {
            Method method = (Method) f1092m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, null)) != null) {
                method.setAccessible(true);
                f1092m.put(str, method);
            }
            return method;
        } catch (Exception e5) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e5);
            return null;
        }
    }

    static Object m(Object obj, String str, Object obj2) {
        try {
            return k(str).invoke(obj, null);
        } catch (Exception e5) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e5);
            return obj2;
        }
    }

    private void s(float f5) {
        if (f5 != this.f1101i.getPaint().getTextSize()) {
            this.f1101i.getPaint().setTextSize(f5);
            boolean isInLayout = this.f1101i.isInLayout();
            if (this.f1101i.getLayout() != null) {
                this.f1094b = false;
                try {
                    Method k5 = k("nullLayouts");
                    if (k5 != null) {
                        k5.invoke(this.f1101i, null);
                    }
                } catch (Exception e5) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e5);
                }
                if (isInLayout) {
                    this.f1101i.forceLayout();
                } else {
                    this.f1101i.requestLayout();
                }
                this.f1101i.invalidate();
            }
        }
    }

    private boolean u() {
        if (y() && this.f1093a == 1) {
            if (!this.f1099g || this.f1098f.length == 0) {
                int floor = ((int) Math.floor((this.f1097e - this.f1096d) / this.f1095c)) + 1;
                int[] iArr = new int[floor];
                for (int i5 = 0; i5 < floor; i5++) {
                    iArr[i5] = Math.round(this.f1096d + (i5 * this.f1095c));
                }
                this.f1098f = b(iArr);
            }
            this.f1094b = true;
        } else {
            this.f1094b = false;
        }
        return this.f1094b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i5 = 0; i5 < length; i5++) {
                iArr[i5] = typedArray.getDimensionPixelSize(i5, -1);
            }
            this.f1098f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z5 = this.f1098f.length > 0;
        this.f1099g = z5;
        if (z5) {
            this.f1093a = 1;
            this.f1096d = r0[0];
            this.f1097e = r0[r1 - 1];
            this.f1095c = -1.0f;
        }
        return z5;
    }

    private boolean x(int i5, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1101i.getText();
        TransformationMethod transformationMethod = this.f1101i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1101i)) != null) {
            text = transformation;
        }
        int maxLines = this.f1101i.getMaxLines();
        l(i5);
        StaticLayout d5 = d(text, (Layout.Alignment) m(this.f1101i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (d5.getLineCount() <= maxLines && d5.getLineEnd(d5.getLineCount() - 1) == text.length())) && ((float) d5.getHeight()) <= rectF.bottom;
    }

    private boolean y() {
        return !(this.f1101i instanceof AppCompatEditText);
    }

    private void z(float f5, float f6, float f7) {
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f5 + "px) is less or equal to (0px)");
        }
        if (f6 <= f5) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f6 + "px) is less or equal to minimum auto-size text size (" + f5 + "px)");
        }
        if (f7 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f7 + "px) is less or equal to (0px)");
        }
        this.f1093a = 1;
        this.f1096d = f5;
        this.f1097e = f6;
        this.f1095c = f7;
        this.f1099g = false;
    }

    void a() {
        if (n()) {
            if (this.f1094b) {
                if (this.f1101i.getMeasuredHeight() <= 0 || this.f1101i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f1103k.b(this.f1101i) ? 1048576 : (this.f1101i.getMeasuredWidth() - this.f1101i.getTotalPaddingLeft()) - this.f1101i.getTotalPaddingRight();
                int height = (this.f1101i.getHeight() - this.f1101i.getCompoundPaddingBottom()) - this.f1101i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f1091l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float e5 = e(rectF);
                        if (e5 != this.f1101i.getTextSize()) {
                            t(0, e5);
                        }
                    } finally {
                    }
                }
            }
            this.f1094b = true;
        }
    }

    StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i5, int i6) {
        return a.a(charSequence, alignment, i5, i6, this.f1101i, this.f1100h, this.f1103k);
    }

    int f() {
        return Math.round(this.f1097e);
    }

    int g() {
        return Math.round(this.f1096d);
    }

    int h() {
        return Math.round(this.f1095c);
    }

    int[] i() {
        return this.f1098f;
    }

    int j() {
        return this.f1093a;
    }

    void l(int i5) {
        TextPaint textPaint = this.f1100h;
        if (textPaint == null) {
            this.f1100h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1100h.set(this.f1101i.getPaint());
        this.f1100h.setTextSize(i5);
    }

    boolean n() {
        return y() && this.f1093a != 0;
    }

    void o(AttributeSet attributeSet, int i5) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f1102j.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i5, 0);
        TextView textView = this.f1101i;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), R.styleable.AppCompatTextView, attributeSet, obtainStyledAttributes, i5, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
            this.f1093a = obtainStyledAttributes.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!y()) {
            this.f1093a = 0;
            return;
        }
        if (this.f1093a == 1) {
            if (!this.f1099g) {
                DisplayMetrics displayMetrics = this.f1102j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    void p(int i5, int i6, int i7, int i8) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f1102j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i8, i5, displayMetrics), TypedValue.applyDimension(i8, i6, displayMetrics), TypedValue.applyDimension(i8, i7, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    void q(int[] iArr, int i5) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i5 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1102j.getResources().getDisplayMetrics();
                    for (int i6 = 0; i6 < length; i6++) {
                        iArr2[i6] = Math.round(TypedValue.applyDimension(i5, iArr[i6], displayMetrics));
                    }
                }
                this.f1098f = b(iArr2);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1099g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    void r(int i5) {
        if (y()) {
            if (i5 == 0) {
                c();
                return;
            }
            if (i5 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i5);
            }
            DisplayMetrics displayMetrics = this.f1102j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    void t(int i5, float f5) {
        Context context = this.f1102j;
        s(TypedValue.applyDimension(i5, f5, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
