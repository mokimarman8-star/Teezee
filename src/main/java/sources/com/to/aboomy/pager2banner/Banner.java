package com.to.aboomy.pager2banner;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class Banner extends RelativeLayout {
    private ViewPager2.OnPageChangeCallback a;
    private CompositePageTransformer b;
    private c c;
    private ViewPager2 d;
    private com.to.aboomy.pager2banner.a e;
    private boolean f;
    private boolean g;
    private boolean h;
    private long i;
    private long j;
    private int k;
    private int l;
    private int m;
    private float n;
    private float o;
    private float p;
    private float q;
    private final int r;
    private final Runnable s;
    private final RecyclerView.g t;

    class a extends RecyclerView.g {
        a() {
        }

        public void onChanged() {
            Banner banner = Banner.this;
            banner.t(banner.getCurrentPager());
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }

        public final void onItemRangeInserted(int i, int i2) {
            if (i > 1) {
                onChanged();
            }
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }
    }

    class b extends ViewOutlineProvider {
        final /* synthetic */ float a;

        b(float f) {
            this.a = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
        }
    }

    private class c extends RecyclerView.Adapter {
        private RecyclerView.Adapter a;

        private c() {
        }

        public int getItemCount() {
            return h() > 1 ? h() + Banner.this.k : h();
        }

        public long getItemId(int i) {
            return this.a.getItemId(Banner.this.u(i));
        }

        public int getItemViewType(int i) {
            return this.a.getItemViewType(Banner.this.u(i));
        }

        int h() {
            RecyclerView.Adapter adapter = this.a;
            if (adapter == null) {
                return 0;
            }
            return adapter.getItemCount();
        }

        void i(RecyclerView.Adapter adapter) {
            RecyclerView.Adapter adapter2 = this.a;
            if (adapter2 != null) {
                adapter2.unregisterAdapterDataObserver(Banner.this.t);
            }
            this.a = adapter;
            if (adapter != null) {
                adapter.registerAdapterDataObserver(Banner.this.t);
            }
        }

        public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
            this.a.onBindViewHolder(a0Var, Banner.this.u(i));
        }

        public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return this.a.onCreateViewHolder(viewGroup, i);
        }
    }

    private class d extends ViewPager2.OnPageChangeCallback {
        private d() {
        }

        public void onPageScrollStateChanged(int i) {
            if (i == 1) {
                if (Banner.this.m == Banner.this.l - 1) {
                    Banner.this.g = false;
                    Banner.this.d.setCurrentItem(Banner.this.getRealCount() + Banner.this.m, false);
                } else if (Banner.this.m == Banner.this.getRealCount() + Banner.this.l) {
                    Banner.this.g = false;
                    Banner.this.d.setCurrentItem(Banner.this.l, false);
                } else {
                    Banner.this.g = true;
                }
            }
            if (Banner.this.a != null) {
                Banner.this.a.onPageScrollStateChanged(i);
            }
            if (Banner.this.e != null) {
                Banner.this.e.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            int u = Banner.this.u(i);
            if (Banner.this.a != null) {
                Banner.this.a.onPageScrolled(u, f, i2);
            }
            if (Banner.this.e != null) {
                Banner.this.e.onPageScrolled(u, f, i2);
            }
        }

        public void onPageSelected(int i) {
            if (Banner.this.getRealCount() > 1) {
                Banner.this.m = i;
            }
            if (Banner.this.g) {
                int u = Banner.this.u(i);
                if (Banner.this.a != null) {
                    Banner.this.a.onPageSelected(u);
                }
                if (Banner.this.e != null) {
                    Banner.this.e.onPageSelected(u);
                }
            }
        }
    }

    private class e extends LinearLayoutManager {
        private final RecyclerView.m a;

        class a extends h {
            a(Context context) {
                super(context);
            }

            protected int w(int i) {
                return (int) (Banner.this.j * 0.6644d);
            }
        }

        e(Context context, LinearLayoutManager linearLayoutManager) {
            super(context, linearLayoutManager.getOrientation(), false);
            this.a = linearLayoutManager;
        }

        protected void calculateExtraLayoutSpace(RecyclerView.x xVar, int[] iArr) {
            try {
                Method declaredMethod = this.a.getClass().getDeclaredMethod("calculateExtraLayoutSpace", xVar.getClass(), iArr.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.a, xVar, iArr);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }

        public void onInitializeAccessibilityNodeInfo(RecyclerView.t tVar, RecyclerView.x xVar, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            this.a.onInitializeAccessibilityNodeInfo(tVar, xVar, accessibilityNodeInfoCompat);
        }

        public boolean performAccessibilityAction(RecyclerView.t tVar, RecyclerView.x xVar, int i, Bundle bundle) {
            return this.a.performAccessibilityAction(tVar, xVar, i, bundle);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return this.a.requestChildRectangleOnScreen(recyclerView, view, rect, z, z2);
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.x xVar, int i) {
            a aVar = new a(recyclerView.getContext());
            aVar.p(i);
            startSmoothScroll(aVar);
        }
    }

    public Banner(Context context) {
        this(context, null);
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = true;
        this.g = true;
        this.i = 2500L;
        this.j = 800L;
        this.k = 2;
        this.l = 2 / 2;
        this.s = new Runnable() { // from class: com.to.aboomy.pager2banner.Banner.1
            @Override // java.lang.Runnable
            public void run() {
                if (Banner.this.isAutoPlay()) {
                    Banner.i(Banner.this);
                    if (Banner.this.m == Banner.this.getRealCount() + Banner.this.l + 1) {
                        Banner.this.g = false;
                        Banner.this.d.setCurrentItem(Banner.this.l, false);
                        Banner banner = Banner.this;
                        banner.post(banner.s);
                        return;
                    }
                    Banner.this.g = true;
                    Banner.this.d.setCurrentItem(Banner.this.m);
                    Banner banner2 = Banner.this;
                    banner2.postDelayed(banner2.s, Banner.this.i);
                }
            }
        };
        this.t = new a();
        this.r = ViewConfiguration.get(context).getScaledTouchSlop() >> 1;
        s(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealCount() {
        return this.c.h();
    }

    static /* synthetic */ int i(Banner banner) {
        int i = banner.m;
        banner.m = i + 1;
        return i;
    }

    private void r() {
        try {
            RecyclerView childAt = this.d.getChildAt(0);
            childAt.setOverScrollMode(2);
            LinearLayoutManager layoutManager = childAt.getLayoutManager();
            e eVar = new e(getContext(), layoutManager);
            childAt.setLayoutManager(eVar);
            Field declaredField = RecyclerView.m.class.getDeclaredField("mRecyclerView");
            declaredField.setAccessible(true);
            declaredField.set(layoutManager, childAt);
            Field declaredField2 = ViewPager2.class.getDeclaredField("mLayoutManager");
            declaredField2.setAccessible(true);
            declaredField2.set(this.d, eVar);
            Field declaredField3 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");
            declaredField3.setAccessible(true);
            Object obj = declaredField3.get(this.d);
            if (obj != null) {
                Field declaredField4 = obj.getClass().getDeclaredField("mLayoutManager");
                declaredField4.setAccessible(true);
                declaredField4.set(obj, eVar);
            }
            Field declaredField5 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
            declaredField5.setAccessible(true);
            Object obj2 = declaredField5.get(this.d);
            if (obj2 != null) {
                Field declaredField6 = obj2.getClass().getDeclaredField("mLayoutManager");
                declaredField6.setAccessible(true);
                declaredField6.set(obj2, eVar);
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }

    private void s(Context context) {
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.d = viewPager2;
        viewPager2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewPager2 viewPager22 = this.d;
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        this.b = compositePageTransformer;
        viewPager22.setPageTransformer(compositePageTransformer);
        this.d.registerOnPageChangeCallback(new d());
        ViewPager2 viewPager23 = this.d;
        c cVar = new c();
        this.c = cVar;
        viewPager23.setAdapter(cVar);
        setOffscreenPageLimit(1);
        r();
        addView(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i) {
        if (this.l == 2) {
            this.d.setAdapter(this.c);
        } else {
            this.c.notifyDataSetChanged();
        }
        setCurrentItem(i, false);
        com.to.aboomy.pager2banner.a aVar = this.e;
        if (aVar != null) {
            aVar.initIndicatorCount(getRealCount(), getCurrentPager());
        }
        if (isAutoPlay()) {
            startTurning();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(int i) {
        int realCount = getRealCount() > 1 ? (i - this.l) % getRealCount() : 0;
        return realCount < 0 ? realCount + getRealCount() : realCount;
    }

    public Banner addItemDecoration(@NonNull RecyclerView.l lVar) {
        this.d.addItemDecoration(lVar);
        return this;
    }

    public Banner addItemDecoration(@NonNull RecyclerView.l lVar, int i) {
        this.d.addItemDecoration(lVar, i);
        return this;
    }

    public Banner addPageTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.b.addTransformer(pageTransformer);
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isAutoPlay() && this.d.isUserInputEnabled()) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                startTurning();
            } else if (action == 0) {
                stopTurning();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public RecyclerView.Adapter getAdapter() {
        return this.c.a;
    }

    public int getCurrentPager() {
        return Math.max(u(this.m), 0);
    }

    public ViewPager2 getViewPager2() {
        return this.d;
    }

    public boolean isAutoPlay() {
        return this.f && getRealCount() > 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isAutoPlay()) {
            startTurning();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isAutoPlay()) {
            stopTurning();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            float rawX = motionEvent.getRawX();
            this.p = rawX;
            this.n = rawX;
            float rawY = motionEvent.getRawY();
            this.q = rawY;
            this.o = rawY;
        } else {
            boolean z = false;
            if (action == 2) {
                this.p = motionEvent.getRawX();
                this.q = motionEvent.getRawY();
                if (this.d.isUserInputEnabled()) {
                    float abs = Math.abs(this.p - this.n);
                    float abs2 = Math.abs(this.q - this.o);
                    if (this.d.getOrientation() != 0 ? !(abs2 <= this.r || abs2 <= abs) : !(abs <= this.r || abs <= abs2)) {
                        z = true;
                    }
                    getParent().requestDisallowInterceptTouchEvent(z);
                }
            } else if (action == 3 || action == 1) {
                return Math.abs(this.p - this.n) > ((float) this.r) || Math.abs(this.q - this.o) > ((float) this.r);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        setAdapter(adapter, 0);
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter, int i) {
        this.c.i(adapter);
        t(i);
    }

    public Banner setAutoPlay(boolean z) {
        this.f = z;
        if (z && getRealCount() > 1) {
            startTurning();
        }
        return this;
    }

    public Banner setAutoTurningTime(long j) {
        this.i = j;
        return this;
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    public void setCurrentItem(int i, boolean z) {
        int i2 = i + this.l;
        this.m = i2;
        this.d.setCurrentItem(i2, z);
    }

    public Banner setIndicator(com.to.aboomy.pager2banner.a aVar) {
        return setIndicator(aVar, true);
    }

    public Banner setIndicator(com.to.aboomy.pager2banner.a aVar, boolean z) {
        com.to.aboomy.pager2banner.a aVar2 = this.e;
        if (aVar2 != null) {
            removeView(aVar2.getView());
        }
        if (aVar != null) {
            this.e = aVar;
            if (z) {
                addView(aVar.getView(), this.e.getParams());
            }
        }
        return this;
    }

    public Banner setOffscreenPageLimit(int i) {
        this.d.setOffscreenPageLimit(i);
        return this;
    }

    public Banner setOrientation(int i) {
        this.d.setOrientation(i);
        return this;
    }

    public Banner setOuterPageChangeListener(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.a = onPageChangeCallback;
        return this;
    }

    public Banner setPageMargin(int i, int i2) {
        return setPageMargin(i, i, i2);
    }

    public Banner setPageMargin(int i, int i2, int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        addPageTransformer(new MarginPageTransformer(i3));
        RecyclerView childAt = this.d.getChildAt(0);
        if (this.d.getOrientation() == 1) {
            childAt.setPadding(this.d.getPaddingLeft(), i + Math.abs(i3), this.d.getPaddingRight(), i2 + Math.abs(i3));
        } else {
            childAt.setPadding(i + Math.abs(i3), this.d.getPaddingTop(), i2 + Math.abs(i3), this.d.getPaddingBottom());
        }
        childAt.setClipToPadding(false);
        this.k = 4;
        this.l = 2;
        return this;
    }

    public Banner setPagerScrollDuration(long j) {
        this.j = j;
        return this;
    }

    public Banner setRoundCorners(float f) {
        setOutlineProvider(new b(f));
        setClipToOutline(true);
        return this;
    }

    public void startTurning() {
        stopTurning();
        postDelayed(this.s, this.i);
        this.h = true;
    }

    public void stopTurning() {
        if (this.h) {
            removeCallbacks(this.s);
            this.h = false;
        }
    }
}
