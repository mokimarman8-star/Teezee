package net.lucode.hackware.magicindicator.buildins.commonnavigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.R$layout;
import uy.b;
import vy.a;
import xy.c;
import xy.d;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class CommonNavigator extends FrameLayout implements a, b.a {
    private HorizontalScrollView a;
    private LinearLayout b;
    private LinearLayout c;
    private c d;
    private xy.a e;
    private b f;
    private boolean g;
    private boolean h;
    private float i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private List q;
    private DataSetObserver r;

    public CommonNavigator(Context context) {
        super(context);
        this.i = 0.5f;
        this.j = true;
        this.k = true;
        this.p = true;
        this.q = new ArrayList();
        this.r = new a(this);
        b bVar = new b();
        this.f = bVar;
        bVar.k(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        removeAllViews();
        View inflate = this.g ? LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout_no_scroll, this) : LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout, this);
        this.a = (HorizontalScrollView) inflate.findViewById(R$id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.title_container);
        this.b = linearLayout;
        linearLayout.setPadding(this.m, 0, this.l, 0);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R$id.indicator_container);
        this.c = linearLayout2;
        if (this.n) {
            linearLayout2.getParent().bringChildToFront(this.c);
        }
        e();
    }

    private void e() {
        LinearLayout.LayoutParams layoutParams;
        int g = this.f.g();
        for (int i = 0; i < g; i++) {
            View c = this.e.c(getContext(), i);
            if (c instanceof View) {
                View view = c;
                if (this.g) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.e.d(getContext(), i);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.b.addView(view, layoutParams);
            }
        }
        xy.a aVar = this.e;
        if (aVar != null) {
            c b = aVar.b(getContext());
            this.d = b;
            if (b instanceof View) {
                this.c.addView((View) this.d, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void f() {
        this.q.clear();
        int g = this.f.g();
        for (int i = 0; i < g; i++) {
            yy.a aVar = new yy.a();
            xy.b childAt = this.b.getChildAt(i);
            if (childAt != null) {
                aVar.a = childAt.getLeft();
                aVar.b = childAt.getTop();
                aVar.c = childAt.getRight();
                int bottom = childAt.getBottom();
                aVar.d = bottom;
                if (childAt instanceof xy.b) {
                    xy.b bVar = childAt;
                    aVar.e = bVar.getContentLeft();
                    aVar.f = bVar.getContentTop();
                    aVar.g = bVar.getContentRight();
                    aVar.h = bVar.getContentBottom();
                } else {
                    aVar.e = aVar.a;
                    aVar.f = aVar.b;
                    aVar.g = aVar.c;
                    aVar.h = bottom;
                }
            }
            this.q.add(aVar);
        }
    }

    public xy.a getAdapter() {
        return this.e;
    }

    public int getLeftPadding() {
        return this.m;
    }

    public c getPagerIndicator() {
        return this.d;
    }

    public d getPagerTitleView(int i) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return null;
        }
        return linearLayout.getChildAt(i);
    }

    public int getRightPadding() {
        return this.l;
    }

    public float getScrollPivotX() {
        return this.i;
    }

    public LinearLayout getTitleContainer() {
        return this.b;
    }

    public boolean isAdjustMode() {
        return this.g;
    }

    public boolean isEnablePivotScroll() {
        return this.h;
    }

    public boolean isFollowTouch() {
        return this.k;
    }

    public boolean isIndicatorOnTop() {
        return this.n;
    }

    public boolean isReselectWhenLayout() {
        return this.p;
    }

    public boolean isSkimOver() {
        return this.o;
    }

    public boolean isSmoothScroll() {
        return this.j;
    }

    public void notifyDataSetChanged() {
        xy.a aVar = this.e;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void onAttachToMagicIndicator() {
        d();
    }

    public void onDeselected(int i, int i2) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return;
        }
        d childAt = linearLayout.getChildAt(i);
        if (childAt instanceof d) {
            childAt.onDeselected(i, i2);
        }
    }

    public void onDetachFromMagicIndicator() {
    }

    public void onEnter(int i, int i2, float f, boolean z) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return;
        }
        d childAt = linearLayout.getChildAt(i);
        if (childAt instanceof d) {
            childAt.onEnter(i, i2, f, z);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.e != null) {
            f();
            c cVar = this.d;
            if (cVar != null) {
                cVar.onPositionDataProvide(this.q);
            }
            if (this.p && this.f.f() == 0) {
                onPageSelected(this.f.e());
                onPageScrolled(this.f.e(), 0.0f, 0);
            }
        }
    }

    public void onLeave(int i, int i2, float f, boolean z) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return;
        }
        d childAt = linearLayout.getChildAt(i);
        if (childAt instanceof d) {
            childAt.onLeave(i, i2, f, z);
        }
    }

    public void onPageScrollStateChanged(int i) {
        if (this.e != null) {
            this.f.h(i);
            c cVar = this.d;
            if (cVar != null) {
                cVar.onPageScrollStateChanged(i);
            }
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.e != null) {
            this.f.i(i, f, i2);
            c cVar = this.d;
            if (cVar != null) {
                cVar.onPageScrolled(i, f, i2);
            }
            if (this.a == null || this.q.size() <= 0 || i < 0 || i >= this.q.size() || !this.k) {
                return;
            }
            int min = Math.min(this.q.size() - 1, i);
            int min2 = Math.min(this.q.size() - 1, i + 1);
            yy.a aVar = (yy.a) this.q.get(min);
            yy.a aVar2 = (yy.a) this.q.get(min2);
            float a = aVar.a() - (this.a.getWidth() * this.i);
            this.a.scrollTo((int) (a + (((aVar2.a() - (this.a.getWidth() * this.i)) - a) * f)), 0);
        }
    }

    public void onPageSelected(int i) {
        if (this.e != null) {
            this.f.j(i);
            c cVar = this.d;
            if (cVar != null) {
                cVar.onPageSelected(i);
            }
        }
    }

    public void onSelected(int i, int i2) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return;
        }
        d childAt = linearLayout.getChildAt(i);
        if (childAt instanceof d) {
            childAt.onSelected(i, i2);
        }
        if (this.g || this.k || this.a == null || this.q.size() <= 0) {
            return;
        }
        yy.a aVar = (yy.a) this.q.get(Math.min(this.q.size() - 1, i));
        if (this.h) {
            float a = aVar.a() - (this.a.getWidth() * this.i);
            if (this.j) {
                this.a.smoothScrollTo((int) a, 0);
                return;
            } else {
                this.a.scrollTo((int) a, 0);
                return;
            }
        }
        int scrollX = this.a.getScrollX();
        int i3 = aVar.a;
        if (scrollX > i3) {
            if (this.j) {
                this.a.smoothScrollTo(i3, 0);
                return;
            } else {
                this.a.scrollTo(i3, 0);
                return;
            }
        }
        int scrollX2 = this.a.getScrollX() + getWidth();
        int i4 = aVar.c;
        if (scrollX2 < i4) {
            if (this.j) {
                this.a.smoothScrollTo(i4 - getWidth(), 0);
            } else {
                this.a.scrollTo(i4 - getWidth(), 0);
            }
        }
    }

    public void setAdapter(xy.a aVar) {
        xy.a aVar2 = this.e;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.g(this.r);
        }
        this.e = aVar;
        if (aVar == null) {
            this.f.m(0);
            d();
            return;
        }
        aVar.f(this.r);
        this.f.m(this.e.a());
        if (this.b != null) {
            this.e.e();
        }
    }

    public void setAdjustMode(boolean z) {
        this.g = z;
    }

    public void setEnablePivotScroll(boolean z) {
        this.h = z;
    }

    public void setFollowTouch(boolean z) {
        this.k = z;
    }

    public void setIndicatorOnTop(boolean z) {
        this.n = z;
    }

    public void setLeftPadding(int i) {
        this.m = i;
    }

    public void setReselectWhenLayout(boolean z) {
        this.p = z;
    }

    public void setRightPadding(int i) {
        this.l = i;
    }

    public void setScrollPivotX(float f) {
        this.i = f;
    }

    public void setSkimOver(boolean z) {
        this.o = z;
        this.f.l(z);
    }

    public void setSmoothScroll(boolean z) {
        this.j = z;
    }
}
