package com.cloud.tmc.miniapp.widget.pulldownrefresh.impl;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.viewpager.widget.ViewPager;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO0;
import com.google.android.material.appbar.AppBarLayout;
import java.util.LinkedList;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooO00o implements com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0o, com.cloud.tmc.miniapp.widget.pulldownrefresh.listener.OooO00o, ValueAnimator.AnimatorUpdateListener {
    public View OooO00o;
    public View OooO0O0;
    public View OooO0OO;
    public View OooO0Oo;
    public View OooO0o0;
    public int OooO0o = 0;
    public boolean OooO0oO = true;
    public boolean OooO0oo = true;
    public OooO0o OooO = new OooO0o();

    public OooO00o(@NonNull View view) {
        this.OooO0OO = view;
        this.OooO0O0 = view;
        this.OooO00o = view;
    }

    public ValueAnimator.AnimatorUpdateListener OooO00o(int i) {
        View view = this.OooO0OO;
        if (view == null || i == 0) {
            return null;
        }
        if ((i >= 0 || !com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(view, 1)) && (i <= 0 || !com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(this.OooO0OO, -1))) {
            return null;
        }
        this.OooO0o = i;
        return this;
    }

    public View OooO00o(View view, PointF pointF, View view2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View OooO00o = OooO00o(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return OooO00o;
                }
            }
        }
        return view2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void OooO00o(int i, int i2, int i3) {
        boolean z;
        View view;
        View view2;
        View findViewById;
        View findViewById2;
        boolean z2 = true;
        if (i2 != -1 && (findViewById2 = this.OooO0O0.findViewById(i2)) != null) {
            if (i > 0) {
                findViewById2.setTranslationY(i);
                z = true;
                if (i3 != -1 && (findViewById = this.OooO0O0.findViewById(i3)) != null) {
                    if (i >= 0) {
                        findViewById.setTranslationY(i);
                        if (z2) {
                            this.OooO0O0.setTranslationY(0.0f);
                        } else {
                            this.OooO0O0.setTranslationY(i);
                        }
                        view = this.OooO0Oo;
                        if (view != null) {
                            view.setTranslationY(Math.max(0, i));
                        }
                        view2 = this.OooO0o0;
                        if (view2 != null) {
                            view2.setTranslationY(Math.min(0, i));
                            return;
                        }
                        return;
                    }
                    if (findViewById.getTranslationY() < 0.0f) {
                        findViewById.setTranslationY(0.0f);
                    }
                }
                z2 = z;
                if (z2) {
                }
                view = this.OooO0Oo;
                if (view != null) {
                }
                view2 = this.OooO0o0;
                if (view2 != null) {
                }
            } else if (findViewById2.getTranslationY() > 0.0f) {
                findViewById2.setTranslationY(0.0f);
            }
        }
        z = false;
        if (i3 != -1) {
            if (i >= 0) {
            }
        }
        z2 = z;
        if (z2) {
        }
        view = this.OooO0Oo;
        if (view != null) {
        }
        view2 = this.OooO0o0;
        if (view2 != null) {
        }
    }

    public void OooO00o(OooOOO0 oooOOO0, View view, View view2) {
        View view3 = this.OooO00o;
        boolean isInEditMode = view3.isInEditMode();
        View view4 = null;
        while (true) {
            if (view4 != null && (!(view4 instanceof NestedScrollingParent) || (view4 instanceof NestedScrollingChild))) {
                break;
            }
            boolean z = view4 == null;
            LinkedList linkedList = new LinkedList();
            linkedList.add(view3);
            View view5 = null;
            while (linkedList.size() > 0 && view5 == null) {
                View view6 = (View) linkedList.poll();
                if (view6 != null) {
                    if ((z || view6 != view3) && com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(view6)) {
                        view5 = view6;
                    } else if (view6 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view6;
                        for (int i = 0; i < viewGroup.getChildCount(); i++) {
                            linkedList.add(viewGroup.getChildAt(i));
                        }
                    }
                }
            }
            if (view5 != null) {
                view3 = view5;
            }
            if (view3 == view4) {
                break;
            }
            if (!isInEditMode) {
                try {
                    if (view3 instanceof CoordinatorLayout) {
                        com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.this.setNestedScrollingEnabled(false);
                        ViewGroup viewGroup2 = (ViewGroup) view3;
                        for (int childCount = viewGroup2.getChildCount() - 1; childCount >= 0; childCount--) {
                            AppBarLayout childAt = viewGroup2.getChildAt(childCount);
                            if (childAt instanceof AppBarLayout) {
                                childAt.addOnOffsetChangedListener(new com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO00o(this));
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            view4 = view3;
        }
        if (view4 != null) {
            this.OooO0OO = view4;
        }
        if (view == null && view2 == null) {
            return;
        }
        this.OooO0Oo = view;
        this.OooO0o0 = view2;
        FrameLayout frameLayout = new FrameLayout(this.OooO00o.getContext());
        OooO00o.OooOo oooOo = (OooO00o.OooOo) oooOOO0;
        int indexOfChild = com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.this.getLayout().indexOfChild(this.OooO00o);
        com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.this.getLayout().removeView(this.OooO00o);
        ViewExtKt.removeSelf(this.OooO00o);
        frameLayout.addView(this.OooO00o, 0, new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = this.OooO00o.getLayoutParams();
        ViewExtKt.removeSelf(frameLayout);
        com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.this.getLayout().addView(frameLayout, indexOfChild, layoutParams);
        this.OooO00o = frameLayout;
        if (view != null) {
            view.setTag("fixed-top");
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            ViewGroup viewGroup3 = (ViewGroup) view.getParent();
            int indexOfChild2 = viewGroup3.indexOfChild(view);
            viewGroup3.removeView(view);
            layoutParams2.height = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO0OO(view);
            viewGroup3.addView(new Space(this.OooO00o.getContext()), indexOfChild2, layoutParams2);
            frameLayout.addView(view, 1, layoutParams2);
        }
        if (view2 != null) {
            view2.setTag("fixed-bottom");
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            ViewGroup viewGroup4 = (ViewGroup) view2.getParent();
            int indexOfChild3 = viewGroup4.indexOfChild(view2);
            viewGroup4.removeView(view2);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
            layoutParams3.height = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO0OO(view2);
            viewGroup4.addView(new Space(this.OooO00o.getContext()), indexOfChild3, layoutParams3);
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, 1, layoutParams4);
        }
    }

    public boolean OooO00o() {
        return this.OooO0oo && this.OooO.OooO00o(this.OooO00o);
    }

    public boolean OooO0O0() {
        return this.OooO0oO && this.OooO.OooO0O0(this.OooO00o);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (intValue - this.OooO0o) * this.OooO0OO.getScaleY();
            View view = this.OooO0OO;
            if (view instanceof AbsListView) {
                float f = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO0O0;
                ((AbsListView) view).scrollListBy((int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.OooO0o = intValue;
    }
}
