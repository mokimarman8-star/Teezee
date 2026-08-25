package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.b;
import java.util.Arrays;
import java.util.HashMap;
import t0.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class ConstraintHelper extends View {
    protected int[] a;
    protected int b;
    protected Context c;
    protected a d;
    protected boolean e;
    protected String f;
    protected String g;
    private View[] h;
    protected HashMap i;

    public ConstraintHelper(Context context) {
        super(context);
        this.a = new int[32];
        this.e = false;
        this.h = null;
        this.i = new HashMap();
        this.c = context;
        k(null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new int[32];
        this.e = false;
        this.h = null;
        this.i = new HashMap();
        this.c = context;
        k(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new int[32];
        this.e = false;
        this.h = null;
        this.i = new HashMap();
        this.c = context;
        k(attributeSet);
    }

    private void a(String str) {
        if (str == null || str.length() == 0 || this.c == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int i = i(trim);
        if (i != 0) {
            this.i.put(Integer.valueOf(i), trim);
            b(i);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void b(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.b + 1;
        int[] iArr = this.a;
        if (i2 > iArr.length) {
            this.a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.a;
        int i3 = this.b;
        iArr2[i3] = i;
        this.b = i3 + 1;
    }

    private void c(String str) {
        if (str == null || str.length() == 0 || this.c == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.b layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && trim.equals(layoutParams.c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    private int[] g(View view, String str) {
        String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i = 0;
        for (String str2 : split) {
            int i2 = i(str2.trim());
            if (i2 != 0) {
                iArr[i] = i2;
                i++;
            }
        }
        return i != split.length ? Arrays.copyOf(iArr, i) : iArr;
    }

    private int h(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int i(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i = ((Integer) designInformation).intValue();
            }
        }
        if (i == 0 && constraintLayout != null) {
            i = h(constraintLayout, str);
        }
        if (i == 0) {
            try {
                i = R.id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i == 0 ? this.c.getResources().getIdentifier(str, "id", this.c.getPackageName()) : i;
    }

    public void addView(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        } else {
            if (view.getParent() == null) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
                return;
            }
            this.f = null;
            b(view.getId());
            requestLayout();
        }
    }

    public boolean containsId(int i) {
        for (int i2 : this.a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    protected void d() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        e((ConstraintLayout) parent);
    }

    protected void e(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.b; i++) {
            View viewById = constraintLayout.getViewById(this.a[i]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    protected void f(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.a, this.b);
    }

    public int indexFromId(int i) {
        int i2 = -1;
        for (int i3 : this.a) {
            i2++;
            if (i3 == i) {
                return i2;
            }
        }
        return i2;
    }

    protected View[] j(ConstraintLayout constraintLayout) {
        View[] viewArr = this.h;
        if (viewArr == null || viewArr.length != this.b) {
            this.h = new View[this.b];
        }
        for (int i = 0; i < this.b; i++) {
            this.h[i] = constraintLayout.getViewById(this.a[i]);
        }
        return this.h;
    }

    protected void k(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f = string;
                    setIds(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.g = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void loadParameters(b.a aVar, t0.b bVar, ConstraintLayout.b bVar2, SparseArray<ConstraintWidget> sparseArray) {
        b.b bVar3 = aVar.e;
        int[] iArr = bVar3.k0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = bVar3.l0;
            if (str != null) {
                if (str.length() > 0) {
                    b.b bVar4 = aVar.e;
                    bVar4.k0 = g(this, bVar4.l0);
                } else {
                    aVar.e.k0 = null;
                }
            }
        }
        if (bVar == null) {
            return;
        }
        bVar.b();
        if (aVar.e.k0 == null) {
            return;
        }
        int i = 0;
        while (true) {
            int[] iArr2 = aVar.e.k0;
            if (i >= iArr2.length) {
                return;
            }
            ConstraintWidget constraintWidget = sparseArray.get(iArr2[i]);
            if (constraintWidget != null) {
                bVar.a(constraintWidget);
            }
            i++;
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public int removeView(View view) {
        int i;
        int id = view.getId();
        int i2 = -1;
        if (id == -1) {
            return -1;
        }
        this.f = null;
        int i3 = 0;
        while (true) {
            if (i3 >= this.b) {
                break;
            }
            if (this.a[i3] == id) {
                int i4 = i3;
                while (true) {
                    i = this.b;
                    if (i4 >= i - 1) {
                        break;
                    }
                    int[] iArr = this.a;
                    int i6 = i4 + 1;
                    iArr[i4] = iArr[i6];
                    i4 = i6;
                }
                this.a[i - 1] = 0;
                this.b = i - 1;
                i2 = i3;
            } else {
                i3++;
            }
        }
        requestLayout();
        return i2;
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
    }

    protected void setIds(String str) {
        this.f = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.g = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                c(str.substring(i));
                return;
            } else {
                c(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f = null;
        this.b = 0;
        for (int i : iArr) {
            b(i);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.f == null) {
            b(i);
        }
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    public void updatePreLayout(d dVar, a aVar, SparseArray<ConstraintWidget> sparseArray) {
        aVar.b();
        for (int i = 0; i < this.b; i++) {
            aVar.a(sparseArray.get(this.a[i]));
        }
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        String str;
        int h;
        if (isInEditMode()) {
            setIds(this.f);
        }
        a aVar = this.d;
        if (aVar == null) {
            return;
        }
        aVar.b();
        for (int i = 0; i < this.b; i++) {
            int i2 = this.a[i];
            View viewById = constraintLayout.getViewById(i2);
            if (viewById == null && (h = h(constraintLayout, (str = (String) this.i.get(Integer.valueOf(i2))))) != 0) {
                this.a[i] = h;
                this.i.put(Integer.valueOf(h), str);
                viewById = constraintLayout.getViewById(h);
            }
            if (viewById != null) {
                this.d.a(constraintLayout.getViewWidget(viewById));
            }
        }
        this.d.c(constraintLayout.mLayoutWidget);
    }

    public void validateParams() {
        if (this.d == null) {
            return;
        }
        ConstraintLayout.b layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            layoutParams.v0 = this.d;
        }
    }
}
