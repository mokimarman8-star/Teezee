package com.bytedance.adsdk.ugeno.Dq;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC extends ViewGroup {
    private int Bml;
    private HiB Chv;
    private final sP Dq;
    private EjP EZ;
    private int Ei;
    int EjP;
    private float FPG;
    private VelocityTracker Fm;
    private Scroller Fmk;
    private int HpB;
    private List<EjP> IOh;
    private int JcM;
    private final ArrayList<sP> Jcg;
    private int LD;
    private boolean LqL;
    private float Mts;
    private int MuB;
    private int RiZ;
    private int Sj;
    private int TEQ;
    com.bytedance.adsdk.ugeno.Dq.sP TKC;
    private int TzV;
    private boolean UHs;
    private final Runnable Uc;
    private float WMZ;
    private float Wjd;
    private boolean Yf;
    private Parcelable Ym;
    private vS Zq;
    private int aNB;
    private ClassLoader aa;
    private ArrayList<View> cX;
    private Drawable dNu;
    private boolean db;
    private boolean dwU;
    private float dx;
    private int fF;
    private List<Object> gY;
    private int ib;
    private int jb;
    private boolean kF;
    private int ley;
    private EdgeEffect ndK;
    private EjP pfr;
    private EdgeEffect qRN;
    private float sU;
    private boolean sdp;
    private boolean sef;
    private final Rect uA;
    private boolean uP;
    private int uvD;
    private boolean wE;
    private int xD;
    private int xhi;
    private int xu;
    private int zR;
    static final int[] sP = {R.attr.layout_gravity};
    private static final Comparator<sP> HiB = new Comparator<sP>() { // from class: com.bytedance.adsdk.ugeno.Dq.TKC.1
        @Override // java.util.Comparator
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public int compare(sP sPVar, sP sPVar2) {
            return sPVar.sP - sPVar2.sP;
        }
    };
    private static final Interpolator vS = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.Dq.TKC.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private static final Dq kb = new Dq();

    static class Dq implements Comparator<View> {
        Dq() {
        }

        @Override // java.util.Comparator
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            C0022TKC c0022tkc = (C0022TKC) view.getLayoutParams();
            C0022TKC c0022tkc2 = (C0022TKC) view2.getLayoutParams();
            boolean z = c0022tkc.Sj;
            return z != c0022tkc2.Sj ? z ? 1 : -1 : c0022tkc.HiB - c0022tkc2.HiB;
        }
    }

    public interface EjP {
        void Sj(int i, float f, int i2);

        void TEQ(int i);

        void Ym(int i);
    }

    public interface HiB {
        void Sj(View view, float f);
    }

    public static class Jcg extends com.bytedance.adsdk.ugeno.Dq.Sj {
        public static final Parcelable.Creator<Jcg> CREATOR = new Parcelable.ClassLoaderCreator<Jcg>() { // from class: com.bytedance.adsdk.ugeno.Dq.TKC.Jcg.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public Jcg createFromParcel(Parcel parcel) {
                return new Jcg(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public Jcg createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new Jcg(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public Jcg[] newArray(int i) {
                return new Jcg[i];
            }
        };
        ClassLoader EjP;
        Parcelable TKC;
        int sP;

        Jcg(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.sP = parcel.readInt();
            this.TKC = parcel.readParcelable(classLoader);
            this.EjP = classLoader;
        }

        public Jcg(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.sP + "}";
        }

        @Override // com.bytedance.adsdk.ugeno.Dq.Sj, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.sP);
            parcel.writeParcelable(this.TKC, i);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Sj {
    }

    /* renamed from: com.bytedance.adsdk.ugeno.Dq.TKC$TKC, reason: collision with other inner class name */
    public static class C0022TKC extends ViewGroup.LayoutParams {
        boolean EjP;
        int HiB;
        public boolean Sj;
        float TKC;
        public int sP;
        int vS;

        public C0022TKC() {
            super(-1, -1);
            this.TKC = 0.0f;
        }

        public C0022TKC(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.TKC = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, TKC.sP);
            this.sP = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    static class sP {
        float EjP;
        float HiB;
        Object Sj;
        boolean TKC;
        int sP;

        sP() {
        }
    }

    private class vS extends DataSetObserver {
        vS() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TKC.this.sP();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TKC.this.sP();
        }
    }

    public TKC(Context context) {
        super(context);
        this.Jcg = new ArrayList<>();
        this.Dq = new sP();
        this.uA = new Rect();
        this.TEQ = -1;
        this.Ym = null;
        this.aa = null;
        this.sU = -3.4028235E38f;
        this.dx = Float.MAX_VALUE;
        this.ley = 1;
        this.xD = -1;
        this.UHs = true;
        this.dwU = false;
        this.Uc = new Runnable() { // from class: com.bytedance.adsdk.ugeno.Dq.TKC.3
            @Override // java.lang.Runnable
            public void run() {
                TKC.this.setScrollState(0);
                TKC.this.TKC();
            }
        };
        this.xu = 0;
        Sj();
    }

    private boolean Dq() {
        this.xD = -1;
        TEQ();
        this.ndK.onRelease();
        this.qRN.onRelease();
        return this.ndK.isFinished() || this.qRN.isFinished();
    }

    private boolean EjP(int i) {
        if (this.Jcg.size() == 0) {
            if (this.UHs) {
                return false;
            }
            this.sdp = false;
            Sj(0, 0.0f, 0);
            if (this.sdp) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        sP uA = uA();
        int clientWidth = getClientWidth();
        int i2 = this.uvD;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = uA.sP;
        float f2 = ((i / f) - uA.HiB) / (uA.EjP + (i2 / f));
        this.sdp = false;
        Sj(i4, f2, (int) (i3 * f2));
        if (this.sdp) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void HiB(int i) {
        EjP ejP = this.pfr;
        if (ejP != null) {
            ejP.TEQ(i);
        }
        List<EjP> list = this.IOh;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                EjP ejP2 = this.IOh.get(i2);
                if (ejP2 != null) {
                    ejP2.TEQ(i);
                }
            }
        }
        EjP ejP3 = this.EZ;
        if (ejP3 != null) {
            ejP3.TEQ(i);
        }
    }

    private void Jcg() {
        if (this.aNB != 0) {
            ArrayList<View> arrayList = this.cX;
            if (arrayList == null) {
                this.cX = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.cX.add(getChildAt(i));
            }
            Collections.sort(this.cX, kb);
        }
    }

    private int Sj(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.HpB || Math.abs(i2) <= this.jb) {
            i += (int) (f + (i >= this.EjP ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.Jcg.size() <= 0) {
            return i;
        }
        return Math.max(this.Jcg.get(0).sP, Math.min(i, this.Jcg.get(r4.size() - 1).sP));
    }

    private Rect Sj(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private void Sj(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.Jcg.isEmpty()) {
            if (!this.Fmk.isFinished()) {
                this.Fmk.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        sP sP2 = sP(this.EjP);
        int min = (int) ((sP2 != null ? Math.min(sP2.HiB, this.dx) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            Sj(false);
            scrollTo(min, getScrollY());
        }
    }

    private void Sj(int i, boolean z, int i2, boolean z2) {
        sP sP2 = sP(i);
        int clientWidth = sP2 != null ? (int) (getClientWidth() * Math.max(this.sU, Math.min(sP2.HiB, this.dx))) : 0;
        if (z) {
            Sj(clientWidth, 0, i2);
            if (z2) {
                HiB(i);
                return;
            }
            return;
        }
        if (z2) {
            HiB(i);
        }
        Sj(false);
        scrollTo(clientWidth, 0);
        EjP(clientWidth);
    }

    private void Sj(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.xD) {
            int i = actionIndex == 0 ? 1 : 0;
            this.WMZ = motionEvent.getX(i);
            this.xD = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.Fm;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void Sj(sP sPVar, int i, sP sPVar2) {
        int i2;
        int i3;
        sP sPVar3;
        sP sPVar4;
        int Sj2 = this.TKC.Sj();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.uvD / clientWidth : 0.0f;
        if (sPVar2 != null) {
            int i4 = sPVar2.sP;
            int i8 = sPVar.sP;
            if (i4 < i8) {
                float f2 = sPVar2.HiB + sPVar2.EjP + f;
                int i9 = i4 + 1;
                int i10 = 0;
                while (i9 <= sPVar.sP && i10 < this.Jcg.size()) {
                    sP sPVar5 = this.Jcg.get(i10);
                    while (true) {
                        sPVar4 = sPVar5;
                        if (i9 <= sPVar4.sP || i10 >= this.Jcg.size() - 1) {
                            break;
                        }
                        i10++;
                        sPVar5 = this.Jcg.get(i10);
                    }
                    while (i9 < sPVar4.sP) {
                        f2 += this.TKC.Sj(i9) + f;
                        i9++;
                    }
                    sPVar4.HiB = f2;
                    f2 += sPVar4.EjP + f;
                    i9++;
                }
            } else if (i4 > i8) {
                int size = this.Jcg.size() - 1;
                float f3 = sPVar2.HiB;
                while (true) {
                    i4--;
                    if (i4 < sPVar.sP || size < 0) {
                        break;
                    }
                    sP sPVar6 = this.Jcg.get(size);
                    while (true) {
                        sPVar3 = sPVar6;
                        if (i4 >= sPVar3.sP || size <= 0) {
                            break;
                        }
                        size--;
                        sPVar6 = this.Jcg.get(size);
                    }
                    while (i4 > sPVar3.sP) {
                        f3 -= this.TKC.Sj(i4) + f;
                        i4--;
                    }
                    f3 -= sPVar3.EjP + f;
                    sPVar3.HiB = f3;
                }
            }
        }
        int size2 = this.Jcg.size();
        float f4 = sPVar.HiB;
        int i11 = sPVar.sP;
        int i12 = i11 - 1;
        this.sU = i11 == 0 ? f4 : -3.4028235E38f;
        int i13 = Sj2 - 1;
        this.dx = i11 == i13 ? (sPVar.EjP + f4) - 1.0f : Float.MAX_VALUE;
        int i14 = i - 1;
        while (i14 >= 0) {
            sP sPVar7 = this.Jcg.get(i14);
            while (true) {
                i3 = sPVar7.sP;
                if (i12 <= i3) {
                    break;
                }
                f4 -= this.TKC.Sj(i12) + f;
                i12--;
            }
            f4 -= sPVar7.EjP + f;
            sPVar7.HiB = f4;
            if (i3 == 0) {
                this.sU = f4;
            }
            i14--;
            i12--;
        }
        float f8 = sPVar.HiB + sPVar.EjP + f;
        int i15 = sPVar.sP + 1;
        int i16 = i + 1;
        while (i16 < size2) {
            sP sPVar8 = this.Jcg.get(i16);
            while (true) {
                i2 = sPVar8.sP;
                if (i15 >= i2) {
                    break;
                }
                f8 += this.TKC.Sj(i15) + f;
                i15++;
            }
            if (i2 == i13) {
                this.dx = (sPVar8.EjP + f8) - 1.0f;
            }
            sPVar8.HiB = f8;
            f8 += sPVar8.EjP + f;
            i16++;
            i15++;
        }
        this.dwU = false;
    }

    private void Sj(boolean z) {
        boolean z2 = this.xu == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.Fmk.isFinished()) {
                this.Fmk.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.Fmk.getCurrX();
                int currY = this.Fmk.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        EjP(currX);
                    }
                }
            }
        }
        this.wE = false;
        for (int i = 0; i < this.Jcg.size(); i++) {
            sP sPVar = this.Jcg.get(i);
            if (sPVar.TKC) {
                sPVar.TKC = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                postOnAnimation(this.Uc);
            } else {
                this.Uc.run();
            }
        }
    }

    private boolean Sj(float f, float f2) {
        if (f >= this.fF || f2 <= 0.0f) {
            return f > ((float) (getWidth() - this.fF)) && f2 < 0.0f;
        }
        return true;
    }

    private void TEQ() {
        this.LqL = false;
        this.Yf = false;
        VelocityTracker velocityTracker = this.Fm;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.Fm = null;
        }
    }

    private void TKC(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private static boolean TKC(View view) {
        return view.getClass().getAnnotation(Sj.class) != null;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void sP(int i, float f, int i2) {
        EjP ejP = this.pfr;
        if (ejP != null) {
            ejP.Sj(i, f, i2);
        }
        List<EjP> list = this.IOh;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                EjP ejP2 = this.IOh.get(i3);
                if (ejP2 != null) {
                    ejP2.Sj(i, f, i2);
                }
            }
        }
        EjP ejP3 = this.EZ;
        if (ejP3 != null) {
            ejP3.Sj(i, f, i2);
        }
    }

    private void sP(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.Bml : 0, null);
        }
    }

    private boolean sP(float f) {
        boolean z;
        boolean z2;
        float f2 = this.WMZ - f;
        this.WMZ = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.sU * clientWidth;
        float f4 = this.dx * clientWidth;
        boolean z3 = false;
        sP sPVar = this.Jcg.get(0);
        ArrayList<sP> arrayList = this.Jcg;
        sP sPVar2 = arrayList.get(arrayList.size() - 1);
        if (sPVar.sP != 0) {
            f3 = sPVar.HiB * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (sPVar2.sP != this.TKC.Sj() - 1) {
            f4 = sPVar2.HiB * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.ndK.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.qRN.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.WMZ += scrollX - i;
        scrollTo(i, getScrollY());
        EjP(i);
        return z3;
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.uP != z) {
            this.uP = z;
        }
    }

    private sP uA() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.uvD / clientWidth : 0.0f;
        int i2 = 0;
        boolean z = true;
        sP sPVar = null;
        int i3 = -1;
        float f3 = 0.0f;
        while (i2 < this.Jcg.size()) {
            sP sPVar2 = this.Jcg.get(i2);
            if (!z && sPVar2.sP != (i = i3 + 1)) {
                sPVar2 = this.Dq;
                sPVar2.HiB = f + f3 + f2;
                sPVar2.sP = i;
                sPVar2.EjP = this.TKC.Sj(i);
                i2--;
            }
            sP sPVar3 = sPVar2;
            f = sPVar3.HiB;
            float f4 = sPVar3.EjP + f + f2;
            if (!z && scrollX < f) {
                return sPVar;
            }
            if (scrollX < f4 || i2 == this.Jcg.size() - 1) {
                return sPVar3;
            }
            int i4 = sPVar3.sP;
            float f8 = sPVar3.EjP;
            i2++;
            z = false;
            i3 = i4;
            f3 = f8;
            sPVar = sPVar3;
        }
        return sPVar;
    }

    private void vS() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0022TKC) getChildAt(i).getLayoutParams()).Sj) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private void vS(int i) {
        EjP ejP = this.pfr;
        if (ejP != null) {
            ejP.Ym(i);
        }
        List<EjP> list = this.IOh;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                EjP ejP2 = this.IOh.get(i2);
                if (ejP2 != null) {
                    ejP2.Ym(i);
                }
            }
        }
        EjP ejP3 = this.EZ;
        if (ejP3 != null) {
            ejP3.Ym(i);
        }
    }

    boolean EjP() {
        int i = this.EjP;
        if (i <= 0) {
            return false;
        }
        Sj(i - 1, true);
        return true;
    }

    boolean HiB() {
        com.bytedance.adsdk.ugeno.Dq.sP sPVar = this.TKC;
        if (sPVar == null || this.EjP >= sPVar.Sj() - 1) {
            return false;
        }
        Sj(this.EjP + 1, true);
        return true;
    }

    float Sj(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    sP Sj(int i, int i2) {
        sP sPVar = new sP();
        sPVar.sP = i;
        sPVar.Sj = this.TKC.Sj((ViewGroup) this, i);
        sPVar.EjP = this.TKC.Sj(i);
        if (i2 < 0 || i2 >= this.Jcg.size()) {
            this.Jcg.add(sPVar);
        } else {
            this.Jcg.add(i2, sPVar);
        }
        return sPVar;
    }

    sP Sj(View view) {
        for (int i = 0; i < this.Jcg.size(); i++) {
            sP sPVar = this.Jcg.get(i);
            if (this.TKC.Sj(view, sPVar.Sj)) {
                return sPVar;
            }
        }
        return null;
    }

    void Sj() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.Fmk = new Scroller(context, vS);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.JcM = viewConfiguration.getScaledPagingTouchSlop();
        this.jb = (int) (400.0f * f);
        this.Ei = viewConfiguration.getScaledMaximumFlingVelocity();
        this.ndK = new EdgeEffect(context);
        this.qRN = new EdgeEffect(context);
        this.HpB = (int) (25.0f * f);
        this.xhi = (int) (2.0f * f);
        this.LD = (int) (f * 16.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        if (r9 == r10) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void Sj(int i) {
        sP sPVar;
        String hexString;
        sP sPVar2;
        sP Sj2;
        sP sPVar3;
        int i2 = this.EjP;
        if (i2 != i) {
            sPVar = sP(i2);
            this.EjP = i;
        } else {
            sPVar = null;
        }
        if (this.TKC == null) {
            Jcg();
            return;
        }
        if (this.wE) {
            Jcg();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        int i3 = this.ley;
        int max = Math.max(0, this.EjP - i3);
        int Sj3 = this.TKC.Sj();
        int min = Math.min(Sj3 - 1, this.EjP + i3);
        if (Sj3 != this.Sj) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.Sj + ", found: " + Sj3 + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.TKC.getClass());
        }
        int i4 = 0;
        while (true) {
            if (i4 >= this.Jcg.size()) {
                break;
            }
            sPVar2 = this.Jcg.get(i4);
            int i8 = sPVar2.sP;
            int i9 = this.EjP;
            if (i8 < i9) {
                i4++;
            }
        }
        sPVar2 = null;
        if (sPVar2 == null && Sj3 > 0) {
            sPVar2 = Sj(this.EjP, i4);
        }
        if (sPVar2 != null) {
            int i10 = i4 - 1;
            sP sPVar4 = i10 >= 0 ? this.Jcg.get(i10) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - sPVar2.EjP) + (getPaddingLeft() / clientWidth);
            float f = 0.0f;
            for (int i11 = this.EjP - 1; i11 >= 0; i11--) {
                if (f >= paddingLeft && i11 < max) {
                    if (sPVar4 == null) {
                        break;
                    }
                    if (i11 == sPVar4.sP && !sPVar4.TKC) {
                        this.Jcg.remove(i10);
                        this.TKC.Sj((ViewGroup) this, i11, sPVar4.Sj);
                        i10--;
                        i4--;
                        if (i10 >= 0) {
                            sPVar3 = this.Jcg.get(i10);
                            sPVar4 = sPVar3;
                        }
                        sPVar3 = null;
                        sPVar4 = sPVar3;
                    }
                } else if (sPVar4 == null || i11 != sPVar4.sP) {
                    f += Sj(i11, i10 + 1).EjP;
                    i4++;
                    if (i10 >= 0) {
                        sPVar3 = this.Jcg.get(i10);
                        sPVar4 = sPVar3;
                    }
                    sPVar3 = null;
                    sPVar4 = sPVar3;
                } else {
                    f += sPVar4.EjP;
                    i10--;
                    if (i10 >= 0) {
                        sPVar3 = this.Jcg.get(i10);
                        sPVar4 = sPVar3;
                    }
                    sPVar3 = null;
                    sPVar4 = sPVar3;
                }
            }
            float f2 = sPVar2.EjP;
            int i12 = i4 + 1;
            if (f2 < 2.0f) {
                sP sPVar5 = i12 < this.Jcg.size() ? this.Jcg.get(i12) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i13 = this.EjP;
                while (true) {
                    i13++;
                    if (i13 >= Sj3) {
                        break;
                    }
                    if (f2 >= paddingRight && i13 > min) {
                        if (sPVar5 == null) {
                            break;
                        }
                        if (i13 == sPVar5.sP && !sPVar5.TKC) {
                            this.Jcg.remove(i12);
                            this.TKC.Sj((ViewGroup) this, i13, sPVar5.Sj);
                            if (i12 < this.Jcg.size()) {
                                sPVar5 = this.Jcg.get(i12);
                            }
                        }
                    } else if (sPVar5 == null || i13 != sPVar5.sP) {
                        sP Sj4 = Sj(i13, i12);
                        i12++;
                        f2 += Sj4.EjP;
                        sPVar5 = i12 < this.Jcg.size() ? this.Jcg.get(i12) : null;
                    } else {
                        f2 += sPVar5.EjP;
                        i12++;
                        if (i12 < this.Jcg.size()) {
                            sPVar5 = this.Jcg.get(i12);
                        }
                    }
                }
            }
            Sj(sPVar2, i4, sPVar);
        }
        int childCount = getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            C0022TKC c0022tkc = (C0022TKC) childAt.getLayoutParams();
            c0022tkc.vS = i14;
            if (!c0022tkc.Sj && c0022tkc.TKC == 0.0f && (Sj2 = Sj(childAt)) != null) {
                c0022tkc.TKC = Sj2.EjP;
                c0022tkc.HiB = Sj2.sP;
            }
        }
        Jcg();
        if (hasFocus()) {
            View findFocus = findFocus();
            sP sP2 = findFocus != null ? sP(findFocus) : null;
            if (sP2 == null || sP2.sP != this.EjP) {
                for (int i15 = 0; i15 < getChildCount(); i15++) {
                    View childAt2 = getChildAt(i15);
                    sP Sj5 = Sj(childAt2);
                    if (Sj5 != null && Sj5.sP == this.EjP && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void Sj(int i, float f, int i2) {
        int max;
        int i3;
        int left;
        if (this.MuB > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                C0022TKC c0022tkc = (C0022TKC) childAt.getLayoutParams();
                if (c0022tkc.Sj) {
                    int i8 = c0022tkc.sP & 7;
                    if (i8 != 1) {
                        if (i8 == 3) {
                            i3 = childAt.getWidth() + paddingLeft;
                        } else if (i8 != 5) {
                            i3 = paddingLeft;
                        } else {
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i3;
                    } else {
                        max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i9 = max;
                    i3 = paddingLeft;
                    paddingLeft = i9;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = i3;
                }
            }
        }
        sP(i, f, i2);
        if (this.Chv != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i10 = 0; i10 < childCount2; i10++) {
                View childAt2 = getChildAt(i10);
                if (!((C0022TKC) childAt2.getLayoutParams()).Sj) {
                    this.Chv.Sj(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.sdp = true;
    }

    void Sj(int i, int i2, int i3) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.Fmk;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.sef ? this.Fmk.getCurrX() : this.Fmk.getStartX();
            this.Fmk.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i8 = i - i4;
        int i9 = i2 - scrollY;
        if (i8 == 0 && i9 == 0) {
            Sj(false);
            TKC();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i10 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i10;
        float Sj2 = f2 + (Sj(Math.min(1.0f, (Math.abs(i8) * 1.0f) / f)) * f2);
        int abs = Math.abs(i3);
        int min = Math.min(abs > 0 ? Math.round(Math.abs(Sj2 / abs) * 1000.0f) * 4 : (int) (((Math.abs(i8) / ((f * this.TKC.Sj(this.EjP)) + this.uvD)) + 1.0f) * 100.0f), 600);
        this.sef = false;
        this.Fmk.startScroll(i4, scrollY, i8, i9, min);
        postInvalidateOnAnimation();
    }

    public void Sj(int i, boolean z) {
        this.wE = false;
        Sj(i, z, false);
    }

    void Sj(int i, boolean z, boolean z2) {
        Sj(i, z, z2, 0);
    }

    void Sj(int i, boolean z, boolean z2, int i2) {
        com.bytedance.adsdk.ugeno.Dq.sP sPVar = this.TKC;
        if (sPVar == null || sPVar.Sj() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.EjP == i && this.Jcg.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.TKC.Sj()) {
            i = this.TKC.Sj() - 1;
        }
        int i3 = this.ley;
        int i4 = this.EjP;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i8 = 0; i8 < this.Jcg.size(); i8++) {
                this.Jcg.get(i8).TKC = true;
            }
        }
        boolean z3 = this.EjP != i;
        if (!this.UHs) {
            Sj(i);
            Sj(i, z, i2, z3);
        } else {
            this.EjP = i;
            if (z3) {
                HiB(i);
            }
            requestLayout();
        }
    }

    public void Sj(EjP ejP) {
        if (this.IOh == null) {
            this.IOh = new ArrayList();
        }
        this.IOh.add(ejP);
    }

    public void Sj(boolean z, HiB hiB) {
        Sj(z, hiB, 2);
    }

    public void Sj(boolean z, HiB hiB, int i) {
        boolean z2 = hiB != null;
        boolean z3 = z2 != (this.Chv != null);
        this.Chv = hiB;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.aNB = z ? 2 : 1;
            this.Bml = i;
        } else {
            this.aNB = 0;
        }
        if (z3) {
            TKC();
        }
    }

    public boolean Sj(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? EjP() : TKC(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? HiB() : TKC(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return TKC(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return TKC(1);
                }
            }
        }
        return false;
    }

    protected boolean Sj(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i8 = i2 + scrollX;
                if (i8 >= childAt.getLeft() && i8 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && Sj(childAt, true, i, i8 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    void TKC() {
        Sj(this.EjP);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b4, code lost:
    
        if (r5 != 2) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean TKC(int i) {
        View findNextFocus;
        boolean EjP2;
        View findFocus = findFocus();
        if (findFocus != this) {
            if (findFocus != null) {
                for (ViewParent parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        break;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(findFocus.getClass().getSimpleName());
                for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ");
                    sb.append(parent2.getClass().getSimpleName());
                }
                Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
            if (findNextFocus != null || findNextFocus == findFocus) {
                if (i != 17 || i == 1) {
                    EjP2 = EjP();
                } else {
                    if (i != 66) {
                    }
                    EjP2 = HiB();
                }
            } else if (i == 17) {
                EjP2 = (findFocus == null || Sj(this.uA, findNextFocus).left < Sj(this.uA, findFocus).left) ? findNextFocus.requestFocus() : EjP();
            } else {
                if (i == 66) {
                    int i2 = Sj(this.uA, findNextFocus).left;
                    int i3 = Sj(this.uA, findFocus).left;
                    if (findFocus == null || i2 > i3) {
                        EjP2 = findNextFocus.requestFocus();
                    }
                    EjP2 = HiB();
                }
                EjP2 = false;
            }
            if (EjP2) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return EjP2;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus != null) {
        }
        if (i != 17) {
        }
        EjP2 = EjP();
        if (EjP2) {
        }
        return EjP2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        sP Sj2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (Sj2 = Sj(childAt)) != null && Sj2.sP == this.EjP) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        sP Sj2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (Sj2 = Sj(childAt)) != null && Sj2.sP == this.EjP) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C0022TKC c0022tkc = (C0022TKC) layoutParams;
        boolean TKC = c0022tkc.Sj | TKC(view);
        c0022tkc.Sj = TKC;
        if (!this.kF) {
            super.addView(view, i, layoutParams);
        } else {
            if (TKC) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            c0022tkc.EjP = true;
            addViewInLayout(view, i, layoutParams);
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.TKC == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.sU)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.dx));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0022TKC) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.sef = true;
        if (this.Fmk.isFinished() || !this.Fmk.computeScrollOffset()) {
            Sj(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.Fmk.getCurrX();
        int currY = this.Fmk.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!EjP(currX)) {
                this.Fmk.abortAnimation();
                scrollTo(0, currY);
            }
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || Sj(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        sP Sj2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (Sj2 = Sj(childAt)) != null && Sj2.sP == this.EjP && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.bytedance.adsdk.ugeno.Dq.sP sPVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (sPVar = this.TKC) != null && sPVar.Sj() > 1)) {
            if (!this.ndK.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.sU * width);
                this.ndK.setSize(height, width);
                z = this.ndK.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.qRN.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.dx + 1.0f)) * width2);
                this.qRN.setSize(height2, width2);
                z |= this.qRN.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.ndK.finish();
            this.qRN.finish();
        }
        if (z) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.dNu;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0022TKC();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0022TKC(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public com.bytedance.adsdk.ugeno.Dq.sP getAdapter() {
        return this.TKC;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.aNB == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0022TKC) this.cX.get(i2).getLayoutParams()).vS;
    }

    public int getCurrentItem() {
        return this.EjP;
    }

    public int getOffscreenPageLimit() {
        return this.ley;
    }

    public int getPageMargin() {
        return this.uvD;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.UHs = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.Uc);
        Scroller scroller = this.Fmk;
        if (scroller != null && !scroller.isFinished()) {
            this.Fmk.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.uvD <= 0 || this.dNu == null || this.Jcg.size() <= 0 || this.TKC == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f3 = this.uvD / width;
        int i2 = 0;
        sP sPVar = this.Jcg.get(0);
        float f4 = sPVar.HiB;
        int size = this.Jcg.size();
        int i3 = sPVar.sP;
        int i4 = this.Jcg.get(size - 1).sP;
        while (i3 < i4) {
            while (true) {
                i = sPVar.sP;
                if (i3 <= i || i2 >= size) {
                    break;
                }
                i2++;
                sPVar = this.Jcg.get(i2);
            }
            if (i3 == i) {
                float f8 = sPVar.HiB;
                float f9 = sPVar.EjP;
                f = (f8 + f9) * width;
                f4 = f8 + f9 + f3;
            } else {
                float Sj2 = this.TKC.Sj(i3);
                f = (f4 + Sj2) * width;
                f4 += Sj2 + f3;
            }
            if (this.uvD + f > scrollX) {
                f2 = f3;
                this.dNu.setBounds(Math.round(f), this.TzV, Math.round(this.uvD + f), this.RiZ);
                this.dNu.draw(canvas);
            } else {
                f2 = f3;
            }
            if (f > scrollX + r2) {
                return;
            }
            i3++;
            f3 = f2;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            Dq();
            return false;
        }
        if (action != 0) {
            if (this.LqL) {
                return true;
            }
            if (this.Yf) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.FPG = x;
            this.WMZ = x;
            float y = motionEvent.getY();
            this.Wjd = y;
            this.Mts = y;
            this.xD = motionEvent.getPointerId(0);
            this.Yf = false;
            this.sef = true;
            this.Fmk.computeScrollOffset();
            if (this.xu != 2 || Math.abs(this.Fmk.getFinalX() - this.Fmk.getCurrX()) <= this.xhi) {
                Sj(false);
                this.LqL = false;
            } else {
                this.Fmk.abortAnimation();
                this.wE = false;
                TKC();
                this.LqL = true;
                TKC(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.xD;
            if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                float x2 = motionEvent.getX(findPointerIndex);
                float f = x2 - this.WMZ;
                float abs = Math.abs(f);
                float y2 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.Wjd);
                if (f != 0.0f && !Sj(this.WMZ, f) && Sj(this, false, (int) f, (int) x2, (int) y2)) {
                    this.WMZ = x2;
                    this.Mts = y2;
                    this.Yf = true;
                    return false;
                }
                int i2 = this.JcM;
                if (abs > i2 && abs * 0.5f > abs2) {
                    this.LqL = true;
                    TKC(true);
                    setScrollState(1);
                    float f2 = this.FPG;
                    float f3 = this.JcM;
                    this.WMZ = f > 0.0f ? f2 + f3 : f2 - f3;
                    this.Mts = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > i2) {
                    this.Yf = true;
                }
                if (this.LqL && sP(x2)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            Sj(motionEvent);
        }
        if (this.Fm == null) {
            this.Fm = VelocityTracker.obtain();
        }
        this.Fm.addMovement(motionEvent);
        return this.LqL;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        sP Sj2;
        int max;
        int i8;
        int max2;
        int i9;
        int childCount = getChildCount();
        int i10 = i3 - i;
        int i11 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                C0022TKC c0022tkc = (C0022TKC) childAt.getLayoutParams();
                if (c0022tkc.Sj) {
                    int i14 = c0022tkc.sP;
                    int i15 = i14 & 7;
                    int i16 = i14 & 112;
                    if (i15 != 1) {
                        if (i15 == 3) {
                            i8 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i15 != 5) {
                            i8 = paddingLeft;
                        } else {
                            max = (i10 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i16 == 16) {
                            if (i16 == 48) {
                                i9 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i16 != 80) {
                                i9 = paddingTop;
                            } else {
                                max2 = (i11 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i17 = paddingLeft + scrollX;
                            childAt.layout(i17, paddingTop, childAt.getMeasuredWidth() + i17, paddingTop + childAt.getMeasuredHeight());
                            i12++;
                            paddingTop = i9;
                            paddingLeft = i8;
                        } else {
                            max2 = Math.max((i11 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i18 = max2;
                        i9 = paddingTop;
                        paddingTop = i18;
                        int i172 = paddingLeft + scrollX;
                        childAt.layout(i172, paddingTop, childAt.getMeasuredWidth() + i172, paddingTop + childAt.getMeasuredHeight());
                        i12++;
                        paddingTop = i9;
                        paddingLeft = i8;
                    } else {
                        max = Math.max((i10 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i19 = max;
                    i8 = paddingLeft;
                    paddingLeft = i19;
                    if (i16 == 16) {
                    }
                    int i182 = max2;
                    i9 = paddingTop;
                    paddingTop = i182;
                    int i1722 = paddingLeft + scrollX;
                    childAt.layout(i1722, paddingTop, childAt.getMeasuredWidth() + i1722, paddingTop + childAt.getMeasuredHeight());
                    i12++;
                    paddingTop = i9;
                    paddingLeft = i8;
                }
            }
        }
        int i20 = (i10 - paddingLeft) - paddingRight;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8) {
                C0022TKC c0022tkc2 = (C0022TKC) childAt2.getLayoutParams();
                if (!c0022tkc2.Sj && (Sj2 = Sj(childAt2)) != null) {
                    float f = i20;
                    int i22 = ((int) (Sj2.HiB * f)) + paddingLeft;
                    if (c0022tkc2.EjP) {
                        c0022tkc2.EjP = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * c0022tkc2.TKC), 1073741824), View.MeasureSpec.makeMeasureSpec((i11 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i22, paddingTop, childAt2.getMeasuredWidth() + i22, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.TzV = paddingTop;
        this.RiZ = i11 - paddingBottom;
        this.MuB = i12;
        if (this.UHs) {
            z2 = false;
            Sj(this.EjP, false, 0, false);
        } else {
            z2 = false;
        }
        this.UHs = z2;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        C0022TKC c0022tkc;
        C0022TKC c0022tkc2;
        int i3;
        setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.fF = Math.min(measuredWidth / 10, this.LD);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i4 = 0;
        while (true) {
            boolean z = true;
            int i8 = 1073741824;
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 && (c0022tkc2 = (C0022TKC) childAt.getLayoutParams()) != null && c0022tkc2.Sj) {
                int i9 = c0022tkc2.sP;
                int i10 = i9 & 7;
                int i11 = i9 & 112;
                boolean z2 = i11 == 48 || i11 == 80;
                if (i10 != 3 && i10 != 5) {
                    z = false;
                }
                int i12 = Integer.MIN_VALUE;
                if (z2) {
                    i3 = Integer.MIN_VALUE;
                    i12 = 1073741824;
                } else {
                    i3 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i13 = ((ViewGroup.LayoutParams) c0022tkc2).width;
                if (i13 != -2) {
                    if (i13 == -1) {
                        i13 = paddingLeft;
                    }
                    i12 = 1073741824;
                } else {
                    i13 = paddingLeft;
                }
                int i14 = ((ViewGroup.LayoutParams) c0022tkc2).height;
                if (i14 == -2) {
                    i14 = measuredHeight;
                    i8 = i3;
                } else if (i14 == -1) {
                    i14 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i13, i12), View.MeasureSpec.makeMeasureSpec(i14, i8));
                if (z2) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i4++;
        }
        this.zR = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.ib = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.kF = true;
        TKC();
        this.kF = false;
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8 && ((c0022tkc = (C0022TKC) childAt2.getLayoutParams()) == null || !c0022tkc.Sj)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * c0022tkc.TKC), 1073741824), this.ib);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        sP Sj2;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (Sj2 = Sj(childAt)) != null && Sj2.sP == this.EjP && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Jcg)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Jcg jcg = (Jcg) parcelable;
        super.onRestoreInstanceState(jcg.Sj());
        if (this.TKC != null) {
            Sj(jcg.sP, false, true);
            return;
        }
        this.TEQ = jcg.sP;
        this.Ym = jcg.TKC;
        this.aa = jcg.EjP;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Jcg jcg = new Jcg(super.onSaveInstanceState());
        jcg.sP = this.EjP;
        com.bytedance.adsdk.ugeno.Dq.sP sPVar = this.TKC;
        if (sPVar != null) {
            jcg.TKC = sPVar.sP();
        }
        return jcg;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i8 = this.uvD;
            Sj(i, i3, i8, i8);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.Dq.sP sPVar;
        int findPointerIndex;
        if (this.db) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (sPVar = this.TKC) == null || sPVar.Sj() == 0) {
            return false;
        }
        if (this.Fm == null) {
            this.Fm = VelocityTracker.obtain();
        }
        this.Fm.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.Fmk.abortAnimation();
            this.wE = false;
            TKC();
            float x = motionEvent.getX();
            this.FPG = x;
            this.WMZ = x;
            float y = motionEvent.getY();
            this.Wjd = y;
            this.Mts = y;
            this.xD = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.LqL) {
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.xD);
                    if (findPointerIndex2 == -1) {
                        z = Dq();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex2);
                        float abs = Math.abs(x2 - this.WMZ);
                        float y2 = motionEvent.getY(findPointerIndex2);
                        float abs2 = Math.abs(y2 - this.Mts);
                        if (abs > this.JcM && abs > abs2) {
                            this.LqL = true;
                            TKC(true);
                            float f = this.FPG;
                            this.WMZ = x2 - f > 0.0f ? f + this.JcM : f - this.JcM;
                            this.Mts = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.LqL && (findPointerIndex = motionEvent.findPointerIndex(this.xD)) != -1) {
                    z = sP(motionEvent.getX(findPointerIndex));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex != -1) {
                        this.WMZ = motionEvent.getX(actionIndex);
                        this.xD = motionEvent.getPointerId(actionIndex);
                    }
                } else if (action == 6) {
                    Sj(motionEvent);
                    int findPointerIndex3 = motionEvent.findPointerIndex(this.xD);
                    if (findPointerIndex3 != -1) {
                        this.WMZ = motionEvent.getX(findPointerIndex3);
                    }
                }
            } else if (this.LqL) {
                Sj(this.EjP, true, 0, false);
                z = Dq();
            }
        } else if (this.LqL) {
            VelocityTracker velocityTracker = this.Fm;
            velocityTracker.computeCurrentVelocity(1000, this.Ei);
            int xVelocity = (int) velocityTracker.getXVelocity(this.xD);
            this.wE = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            sP uA = uA();
            float f2 = clientWidth;
            int i = uA.sP;
            float f3 = ((scrollX / f2) - uA.HiB) / (uA.EjP + (this.uvD / f2));
            int findPointerIndex4 = motionEvent.findPointerIndex(this.xD);
            if (findPointerIndex4 != -1) {
                Sj(Sj(i, f3, xVelocity, (int) (motionEvent.getX(findPointerIndex4) - this.FPG)), true, true, xVelocity);
                z = Dq();
            }
        }
        if (z) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.kF) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    sP sP(int i) {
        for (int i2 = 0; i2 < this.Jcg.size(); i2++) {
            sP sPVar = this.Jcg.get(i2);
            if (sPVar.sP == i) {
                return sPVar;
            }
        }
        return null;
    }

    sP sP(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return Sj(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    void sP() {
        int Sj2 = this.TKC.Sj();
        this.Sj = Sj2;
        boolean z = this.Jcg.size() < (this.ley * 2) + 1 && this.Jcg.size() < Sj2;
        int i = this.EjP;
        int i2 = 0;
        while (i2 < this.Jcg.size()) {
            sP sPVar = this.Jcg.get(i2);
            int Sj3 = this.TKC.Sj(sPVar.Sj);
            if (Sj3 != -1) {
                if (Sj3 == -2) {
                    this.Jcg.remove(i2);
                    i2--;
                    this.TKC.Sj((ViewGroup) this, sPVar.sP, sPVar.Sj);
                    int i3 = this.EjP;
                    if (i3 == sPVar.sP) {
                        i = Math.max(0, Math.min(i3, Sj2 - 1));
                    }
                } else {
                    int i4 = sPVar.sP;
                    if (i4 != Sj3) {
                        if (i4 == this.EjP) {
                            i = Sj3;
                        }
                        sPVar.sP = Sj3;
                    }
                }
                z = true;
            }
            i2++;
        }
        Collections.sort(this.Jcg, HiB);
        if (z) {
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                C0022TKC c0022tkc = (C0022TKC) getChildAt(i8).getLayoutParams();
                if (!c0022tkc.Sj) {
                    c0022tkc.TKC = 0.0f;
                }
            }
            Sj(i, false, true);
            requestLayout();
        }
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.Dq.sP sPVar) {
        com.bytedance.adsdk.ugeno.Dq.sP sPVar2 = this.TKC;
        if (sPVar2 != null) {
            sPVar2.Sj((DataSetObserver) null);
            for (int i = 0; i < this.Jcg.size(); i++) {
                sP sPVar3 = this.Jcg.get(i);
                this.TKC.Sj((ViewGroup) this, sPVar3.sP, sPVar3.Sj);
            }
            this.Jcg.clear();
            vS();
            this.EjP = 0;
            scrollTo(0, 0);
        }
        this.TKC = sPVar;
        this.Sj = 0;
        if (sPVar != null) {
            if (this.Zq == null) {
                this.Zq = new vS();
            }
            this.TKC.Sj((DataSetObserver) this.Zq);
            this.wE = false;
            boolean z = this.UHs;
            this.UHs = true;
            this.Sj = this.TKC.Sj();
            int i2 = this.TEQ;
            if (i2 >= 0) {
                Sj(i2, false, true);
                this.TEQ = -1;
                this.Ym = null;
                this.aa = null;
            } else if (z) {
                requestLayout();
            } else {
                TKC();
            }
        }
        List<Object> list = this.gY;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.gY.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.gY.get(i3);
        }
    }

    public void setCurrentItem(int i) {
        this.wE = false;
        Sj(i, !this.UHs, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.ley) {
            this.ley = i;
            TKC();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(EjP ejP) {
        this.pfr = ejP;
    }

    public void setPageMargin(int i) {
        int i2 = this.uvD;
        this.uvD = i;
        int width = getWidth();
        Sj(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.dNu = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void setScrollState(int i) {
        if (this.xu == i) {
            return;
        }
        this.xu = i;
        if (this.Chv != null) {
            sP(i != 0);
        }
        vS(i);
    }

    public void setScroller(Scroller scroller) {
        this.Fmk = scroller;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.dNu;
    }
}
