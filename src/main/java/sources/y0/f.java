package y0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class f {

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        final int[] f18581a;

        /* renamed from: b, reason: collision with root package name */
        final float[] f18582b;

        a(int i5, int i6) {
            this.f18581a = new int[]{i5, i6};
            this.f18582b = new float[]{0.0f, 1.0f};
        }

        a(int i5, int i6, int i7) {
            this.f18581a = new int[]{i5, i6, i7};
            this.f18582b = new float[]{0.0f, 0.5f, 1.0f};
        }

        a(List list, List list2) {
            int size = list.size();
            this.f18581a = new int[size];
            this.f18582b = new float[size];
            for (int i5 = 0; i5 < size; i5++) {
                this.f18581a[i5] = ((Integer) list.get(i5)).intValue();
                this.f18582b[i5] = ((Float) list2.get(i5)).floatValue();
            }
        }
    }

    private static a a(a aVar, int i5, int i6, boolean z5, int i7) {
        return aVar != null ? aVar : z5 ? new a(i5, i7, i6) : new a(i5, i6);
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray k5 = k.k(resources, theme, attributeSet, R.styleable.GradientColor);
        float f5 = k.f(k5, xmlPullParser, "startX", R.styleable.GradientColor_android_startX, 0.0f);
        float f6 = k.f(k5, xmlPullParser, "startY", R.styleable.GradientColor_android_startY, 0.0f);
        float f7 = k.f(k5, xmlPullParser, "endX", R.styleable.GradientColor_android_endX, 0.0f);
        float f8 = k.f(k5, xmlPullParser, "endY", R.styleable.GradientColor_android_endY, 0.0f);
        float f9 = k.f(k5, xmlPullParser, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
        float f10 = k.f(k5, xmlPullParser, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
        int g5 = k.g(k5, xmlPullParser, "type", R.styleable.GradientColor_android_type, 0);
        int b5 = k.b(k5, xmlPullParser, "startColor", R.styleable.GradientColor_android_startColor, 0);
        boolean j5 = k.j(xmlPullParser, "centerColor");
        int b6 = k.b(k5, xmlPullParser, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
        int b7 = k.b(k5, xmlPullParser, "endColor", R.styleable.GradientColor_android_endColor, 0);
        int g6 = k.g(k5, xmlPullParser, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
        float f11 = k.f(k5, xmlPullParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
        k5.recycle();
        a a5 = a(c(resources, xmlPullParser, attributeSet, theme), b5, b7, j5, b6);
        if (g5 != 1) {
            return g5 != 2 ? new LinearGradient(f5, f6, f7, f8, a5.f18581a, a5.f18582b, d(g6)) : new SweepGradient(f9, f10, a5.f18581a, a5.f18582b);
        }
        if (f11 > 0.0f) {
            return new RadialGradient(f9, f10, f11, a5.f18581a, a5.f18582b, d(g6));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray k5 = k.k(resources, theme, attributeSet, R.styleable.GradientColorItem);
                boolean hasValue = k5.hasValue(R.styleable.GradientColorItem_android_color);
                boolean hasValue2 = k5.hasValue(R.styleable.GradientColorItem_android_offset);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = k5.getColor(R.styleable.GradientColorItem_android_color, 0);
                float f5 = k5.getFloat(R.styleable.GradientColorItem_android_offset, 0.0f);
                k5.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f5));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode d(int i5) {
        return i5 != 1 ? i5 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }
}
