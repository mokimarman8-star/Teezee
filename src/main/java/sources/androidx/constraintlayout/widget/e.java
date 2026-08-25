package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    int f6728a = -1;

    /* renamed from: b, reason: collision with root package name */
    int f6729b = -1;

    /* renamed from: c, reason: collision with root package name */
    int f6730c = -1;

    /* renamed from: d, reason: collision with root package name */
    private SparseArray f6731d = new SparseArray();

    /* renamed from: e, reason: collision with root package name */
    private SparseArray f6732e = new SparseArray();

    /* renamed from: f, reason: collision with root package name */
    private c f6733f = null;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f6734a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList f6735b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        int f6736c;

        /* renamed from: d, reason: collision with root package name */
        boolean f6737d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f6736c = -1;
            this.f6737d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.State_android_id) {
                    this.f6734a = obtainStyledAttributes.getResourceId(index, this.f6734a);
                } else if (index == R.styleable.State_constraints) {
                    this.f6736c = obtainStyledAttributes.getResourceId(index, this.f6736c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f6736c);
                    context.getResources().getResourceName(this.f6736c);
                    if ("layout".equals(resourceTypeName)) {
                        this.f6737d = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f6735b.add(bVar);
        }

        public int b(float f5, float f6) {
            for (int i5 = 0; i5 < this.f6735b.size(); i5++) {
                if (((b) this.f6735b.get(i5)).a(f5, f6)) {
                    return i5;
                }
            }
            return -1;
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        float f6738a;

        /* renamed from: b, reason: collision with root package name */
        float f6739b;

        /* renamed from: c, reason: collision with root package name */
        float f6740c;

        /* renamed from: d, reason: collision with root package name */
        float f6741d;

        /* renamed from: e, reason: collision with root package name */
        int f6742e;

        /* renamed from: f, reason: collision with root package name */
        boolean f6743f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f6738a = Float.NaN;
            this.f6739b = Float.NaN;
            this.f6740c = Float.NaN;
            this.f6741d = Float.NaN;
            this.f6742e = -1;
            this.f6743f = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.Variant_constraints) {
                    this.f6742e = obtainStyledAttributes.getResourceId(index, this.f6742e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f6742e);
                    context.getResources().getResourceName(this.f6742e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f6743f = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f6741d = obtainStyledAttributes.getDimension(index, this.f6741d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f6739b = obtainStyledAttributes.getDimension(index, this.f6739b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f6740c = obtainStyledAttributes.getDimension(index, this.f6740c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f6738a = obtainStyledAttributes.getDimension(index, this.f6738a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        boolean a(float f5, float f6) {
            if (!Float.isNaN(this.f6738a) && f5 < this.f6738a) {
                return false;
            }
            if (!Float.isNaN(this.f6739b) && f6 < this.f6739b) {
                return false;
            }
            if (Float.isNaN(this.f6740c) || f5 <= this.f6740c) {
                return Float.isNaN(this.f6741d) || f6 <= this.f6741d;
            }
            return false;
        }
    }

    public e(Context context, XmlPullParser xmlPullParser) {
        b(context, xmlPullParser);
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            if (index == R.styleable.StateSet_defaultState) {
                this.f6728a = obtainStyledAttributes.getResourceId(index, this.f6728a);
            }
        }
        obtainStyledAttributes.recycle();
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar = null;
            while (true) {
                char c5 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                c5 = 2;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                c5 = 0;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c5 = 3;
                                break;
                            }
                            c5 = 65535;
                            break;
                        default:
                            c5 = 65535;
                            break;
                    }
                    if (c5 == 2) {
                        aVar = new a(context, xmlPullParser);
                        this.f6731d.put(aVar.f6734a, aVar);
                    } else if (c5 == 3) {
                        b bVar = new b(context, xmlPullParser);
                        if (aVar != null) {
                            aVar.a(bVar);
                        }
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (XmlPullParserException e6) {
            e6.printStackTrace();
        }
    }

    public int a(int i5, int i6, float f5, float f6) {
        a aVar = (a) this.f6731d.get(i6);
        if (aVar == null) {
            return i6;
        }
        if (f5 == -1.0f || f6 == -1.0f) {
            if (aVar.f6736c == i5) {
                return i5;
            }
            Iterator it = aVar.f6735b.iterator();
            while (it.hasNext()) {
                if (i5 == ((b) it.next()).f6742e) {
                    return i5;
                }
            }
            return aVar.f6736c;
        }
        Iterator it2 = aVar.f6735b.iterator();
        b bVar = null;
        while (it2.hasNext()) {
            b bVar2 = (b) it2.next();
            if (bVar2.a(f5, f6)) {
                if (i5 == bVar2.f6742e) {
                    return i5;
                }
                bVar = bVar2;
            }
        }
        return bVar != null ? bVar.f6742e : aVar.f6736c;
    }

    public int c(int i5, int i6, int i7) {
        return d(-1, i5, i6, i7);
    }

    public int d(int i5, int i6, float f5, float f6) {
        int b5;
        if (i5 == i6) {
            a aVar = i6 == -1 ? (a) this.f6731d.valueAt(0) : (a) this.f6731d.get(this.f6729b);
            if (aVar == null) {
                return -1;
            }
            return ((this.f6730c == -1 || !((b) aVar.f6735b.get(i5)).a(f5, f6)) && i5 != (b5 = aVar.b(f5, f6))) ? b5 == -1 ? aVar.f6736c : ((b) aVar.f6735b.get(b5)).f6742e : i5;
        }
        a aVar2 = (a) this.f6731d.get(i6);
        if (aVar2 == null) {
            return -1;
        }
        int b6 = aVar2.b(f5, f6);
        return b6 == -1 ? aVar2.f6736c : ((b) aVar2.f6735b.get(b6)).f6742e;
    }
}
