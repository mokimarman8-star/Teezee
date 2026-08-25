package y0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class e {

    static class a {
        static int a(TypedArray typedArray, int i5) {
            return typedArray.getType(i5);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final d[] f18569a;

        public c(d[] dVarArr) {
            this.f18569a = dVarArr;
        }

        public d[] a() {
            return this.f18569a;
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f18570a;

        /* renamed from: b, reason: collision with root package name */
        private final int f18571b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f18572c;

        /* renamed from: d, reason: collision with root package name */
        private final String f18573d;

        /* renamed from: e, reason: collision with root package name */
        private final int f18574e;

        /* renamed from: f, reason: collision with root package name */
        private final int f18575f;

        public d(String str, int i5, boolean z5, String str2, int i6, int i7) {
            this.f18570a = str;
            this.f18571b = i5;
            this.f18572c = z5;
            this.f18573d = str2;
            this.f18574e = i6;
            this.f18575f = i7;
        }

        public String a() {
            return this.f18570a;
        }

        public int b() {
            return this.f18575f;
        }

        public int c() {
            return this.f18574e;
        }

        public String d() {
            return this.f18573d;
        }

        public int e() {
            return this.f18571b;
        }

        public boolean f() {
            return this.f18572c;
        }
    }

    /* renamed from: y0.e$e, reason: collision with other inner class name */
    public static final class C0184e implements b {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.core.provider.e f18576a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.provider.e f18577b;

        /* renamed from: c, reason: collision with root package name */
        private final int f18578c;

        /* renamed from: d, reason: collision with root package name */
        private final int f18579d;

        /* renamed from: e, reason: collision with root package name */
        private final String f18580e;

        public C0184e(androidx.core.provider.e eVar, androidx.core.provider.e eVar2, int i5, int i6, String str) {
            this.f18576a = eVar;
            this.f18577b = eVar2;
            this.f18579d = i5;
            this.f18578c = i6;
            this.f18580e = str;
        }

        public androidx.core.provider.e a() {
            return this.f18577b;
        }

        public int b() {
            return this.f18579d;
        }

        public androidx.core.provider.e c() {
            return this.f18576a;
        }

        public String d() {
            return this.f18580e;
        }

        public int e() {
            return this.f18578c;
        }
    }

    private static int a(TypedArray typedArray, int i5) {
        return a.a(typedArray, i5);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i5) {
        if (i5 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i5);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i6 = 0; i6 < obtainTypedArray.length(); i6++) {
                    int resourceId = obtainTypedArray.getResourceId(i6, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i5)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        String string4 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderFallbackQuery);
        int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string5 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            List c5 = c(resources, resourceId);
            return new C0184e(new androidx.core.provider.e(string, string2, string3, c5), string4 != null ? new androidx.core.provider.e(string, string2, string4, c5) : null, integer, integer2, string5);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int i5 = obtainAttributes.getInt(obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontWeight) ? R.styleable.FontFamilyFont_fontWeight : R.styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z5 = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontStyle) ? R.styleable.FontFamilyFont_fontStyle : R.styleable.FontFamilyFont_android_fontStyle, 0);
        int i6 = obtainAttributes.hasValue(R.styleable.FontFamilyFont_ttcIndex) ? R.styleable.FontFamilyFont_ttcIndex : R.styleable.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontVariationSettings) ? R.styleable.FontFamilyFont_fontVariationSettings : R.styleable.FontFamilyFont_android_fontVariationSettings);
        int i7 = obtainAttributes.getInt(i6, 0);
        int i8 = obtainAttributes.hasValue(R.styleable.FontFamilyFont_font) ? R.styleable.FontFamilyFont_font : R.styleable.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i8, 0);
        String string2 = obtainAttributes.getString(i8);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i5, z5, string, i7, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i5 = 1;
        while (i5 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i5++;
            } else if (next == 3) {
                i5--;
            }
        }
    }

    private static List h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
