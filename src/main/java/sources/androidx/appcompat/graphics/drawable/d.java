package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class d extends DrawableContainerCompat {

    /* renamed from: m, reason: collision with root package name */
    private a f408m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f409n;

    static class a extends DrawableContainerCompat.c {
        int[][] J;

        a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[f()][];
            }
        }

        int A(int[] iArr, Drawable drawable) {
            int a5 = a(drawable);
            this.J[a5] = iArr;
            return a5;
        }

        int B(int[] iArr) {
            int[][] iArr2 = this.J;
            int h5 = h();
            for (int i5 = 0; i5 < h5; i5++) {
                if (StateSet.stateSetMatches(iArr2[i5], iArr)) {
                    return i5;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new d(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.c
        public void o(int i5, int i6) {
            super.o(i5, i6);
            int[][] iArr = new int[i6][];
            System.arraycopy(this.J, 0, iArr, 0, i5);
            this.J = iArr;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.c
        void s() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[] iArr3 = this.J[length];
                iArr2[length] = iArr3 != null ? (int[]) iArr3.clone() : null;
            }
            this.J = iArr2;
        }
    }

    public d() {
        this(null, null);
    }

    d(a aVar) {
        if (aVar != null) {
            h(aVar);
        }
    }

    d(a aVar, Resources resources) {
        h(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void h(DrawableContainerCompat.c cVar) {
        super.h(cVar);
        if (cVar instanceof a) {
            this.f408m = (a) cVar;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a b() {
        return new a(this.f408m, this, null);
    }

    int[] k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i5 = 0;
        for (int i6 = 0; i6 < attributeCount; i6++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i6);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i7 = i5 + 1;
                if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i5] = attributeNameResource;
                i5 = i7;
            }
        }
        return StateSet.trimStateSet(iArr, i5);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f409n && super.mutate() == this) {
            this.f408m.s();
            this.f409n = true;
        }
        return this;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int B = this.f408m.B(iArr);
        if (B < 0) {
            B = this.f408m.B(StateSet.WILD_CARD);
        }
        return g(B) || onStateChange;
    }
}
