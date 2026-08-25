package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import xy.b;
import xy.d;
import zy.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class BadgePagerTitleView extends FrameLayout implements b {
    private d a;
    private View b;
    private boolean c;

    public BadgePagerTitleView(Context context) {
        super(context);
        this.c = true;
    }

    public View getBadgeView() {
        return this.b;
    }

    @Override // xy.b
    public int getContentBottom() {
        d dVar = this.a;
        return dVar instanceof b ? ((b) dVar).getContentBottom() : getBottom();
    }

    @Override // xy.b
    public int getContentLeft() {
        return this.a instanceof b ? getLeft() + ((b) this.a).getContentLeft() : getLeft();
    }

    @Override // xy.b
    public int getContentRight() {
        return this.a instanceof b ? getLeft() + ((b) this.a).getContentRight() : getRight();
    }

    @Override // xy.b
    public int getContentTop() {
        d dVar = this.a;
        return dVar instanceof b ? ((b) dVar).getContentTop() : getTop();
    }

    public d getInnerPagerTitleView() {
        return this.a;
    }

    public a getXBadgeRule() {
        return null;
    }

    public a getYBadgeRule() {
        return null;
    }

    public boolean isAutoCancelBadge() {
        return this.c;
    }

    @Override // xy.d
    public void onDeselected(int i, int i2) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.onDeselected(i, i2);
        }
    }

    @Override // xy.d
    public void onEnter(int i, int i2, float f, boolean z) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.onEnter(i, i2, f, z);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Object obj = this.a;
        if (!(obj instanceof View) || this.b == null) {
            return;
        }
        int[] iArr = new int[14];
        View view = (View) obj;
        iArr[0] = view.getLeft();
        iArr[1] = view.getTop();
        iArr[2] = view.getRight();
        iArr[3] = view.getBottom();
        d dVar = this.a;
        if (dVar instanceof b) {
            b bVar = (b) dVar;
            iArr[4] = bVar.getContentLeft();
            iArr[5] = bVar.getContentTop();
            iArr[6] = bVar.getContentRight();
            iArr[7] = bVar.getContentBottom();
        } else {
            for (int i5 = 4; i5 < 8; i5++) {
                iArr[i5] = iArr[i5 - 4];
            }
        }
        iArr[8] = view.getWidth() / 2;
        iArr[9] = view.getHeight() / 2;
        iArr[10] = iArr[4] / 2;
        iArr[11] = iArr[5] / 2;
        int i6 = iArr[6];
        iArr[12] = i6 + ((iArr[2] - i6) / 2);
        int i7 = iArr[7];
        iArr[13] = i7 + ((iArr[3] - i7) / 2);
    }

    @Override // xy.d
    public void onLeave(int i, int i2, float f, boolean z) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.onLeave(i, i2, f, z);
        }
    }

    @Override // xy.d
    public void onSelected(int i, int i2) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.onSelected(i, i2);
        }
        if (this.c) {
            setBadgeView(null);
        }
    }

    public void setAutoCancelBadge(boolean z) {
        this.c = z;
    }

    public void setBadgeView(View view) {
        if (this.b == view) {
            return;
        }
        this.b = view;
        removeAllViews();
        if (this.a instanceof View) {
            addView((View) this.a, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.b != null) {
            addView(this.b, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public void setInnerPagerTitleView(d dVar) {
        if (this.a == dVar) {
            return;
        }
        this.a = dVar;
        removeAllViews();
        if (this.a instanceof View) {
            addView((View) this.a, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.b != null) {
            addView(this.b, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public void setXBadgeRule(a aVar) {
    }

    public void setYBadgeRule(a aVar) {
    }
}
