package com.cloud.tmc.miniapp.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.fragment.app.Fragment;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.app.TmcAppContext;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.base.MiniAppBaseFragment;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import java.lang.reflect.Field;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class SwipeBackLayout extends FrameLayout {
    public Drawable OooO;
    public float OooO00o;
    public ViewDragHelper OooO0O0;
    public float OooO0OO;
    public float OooO0Oo;
    public TmcFragment OooO0o;
    public View OooO0o0;
    public Fragment OooO0oO;
    public Drawable OooO0oo;
    public final Rect OooOO0;
    public int OooOO0O;
    public boolean OooOO0o;
    public float OooOOO;
    public int OooOOO0;
    public boolean OooOOOO;
    public boolean OooOOOo;
    public int OooOOo;
    public int OooOOo0;
    public float OooOOoo;
    public int OooOo0;
    public int OooOo00;
    public int OooOo0O;
    public final Context OooOo0o;

    public enum EdgeLevel {
        MAX,
        MIN,
        MED
    }

    public class OooO00o extends ViewDragHelper.b {
        public OooO00o() {
        }

        public int clampViewPositionHorizontal(@NonNull View view, int i, int i2) {
            int i3 = SwipeBackLayout.this.OooOOO0;
            if ((i3 & 1) != 0) {
                return Math.min(view.getWidth(), Math.max(i, 0));
            }
            if ((i3 & 2) != 0) {
                return Math.min(0, Math.max(i, -view.getWidth()));
            }
            return 0;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            swipeBackLayout.OooO0o.getClass();
            TmcFragment tmcFragment = swipeBackLayout.OooO0oO;
            return (((tmcFragment instanceof TmcFragment) && tmcFragment.getPage() != null && SwipeBackLayout.this.OooO0oO.getPage().isTabPage() && SwipeBackLayout.this.OooO0o.getPage() != null && SwipeBackLayout.this.OooO0o.getPage().isTabPage()) || SwipeBackLayout.this.OooO0oO == null) ? 0 : 1;
        }

        public void onEdgeTouched(int i, int i2) {
            super.onEdgeTouched(i, i2);
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            if ((swipeBackLayout.OooOO0O & i) != 0) {
                swipeBackLayout.OooOOO0 = i;
            }
        }

        public void onViewDragStateChanged(int i) {
            super.onViewDragStateChanged(i);
            SwipeBackLayout.this.getClass();
        }

        public void onViewPositionChanged(@NonNull View view, int i, int i2, int i3, int i4) {
            View view2;
            View view3;
            super.onViewPositionChanged(view, i, i2, i3, i4);
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            int i5 = swipeBackLayout.OooOOO0;
            if ((i5 & 1) != 0) {
                swipeBackLayout.OooO0OO = Math.abs(i / (SwipeBackLayout.this.OooO0oo.getIntrinsicWidth() + swipeBackLayout.OooO0o0.getWidth()));
            } else if ((i5 & 2) != 0) {
                swipeBackLayout.OooO0OO = Math.abs(i / (SwipeBackLayout.this.OooO.getIntrinsicWidth() + swipeBackLayout.OooO0o0.getWidth()));
            }
            SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
            swipeBackLayout2.OooOOo0 = i;
            swipeBackLayout2.OooOOo = i2;
            swipeBackLayout2.invalidate();
            SwipeBackLayout.this.getClass();
            SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
            float f = swipeBackLayout3.OooO0OO;
            if (f > 1.0f) {
                TmcFragment tmcFragment = swipeBackLayout3.OooO0o;
                tmcFragment.getClass();
                if (swipeBackLayout3.OooOOOO || tmcFragment.isDetached()) {
                    return;
                }
                SwipeBackLayout.this.getClass();
                TmcFragment tmcFragment2 = SwipeBackLayout.this.OooO0o;
                if ((tmcFragment2 instanceof MiniAppBaseFragment) && (tmcFragment2.getActivity() instanceof MiniAppActivity)) {
                    TmcLogger.d("[SwipeBackLayout]：MiniAppActivity.onKeyDown()");
                    SwipeBackLayout.this.OooO0o.getActivity().swipeBack(SwipeBackLayout.this.OooO0o);
                    return;
                }
                return;
            }
            if (f > 0.0f) {
                if (f < 1.0f) {
                    swipeBackLayout3.OooO00o();
                    Fragment fragment = SwipeBackLayout.this.OooO0oO;
                    if (fragment == null || (view2 = fragment.getView()) == null || view2.getVisibility() == 0) {
                        return;
                    }
                    view2.setVisibility(0);
                    TmcLogger.d("SwipeBackLayout", "preView set visible, mScrollPercent:" + SwipeBackLayout.this.OooO0OO);
                    return;
                }
                return;
            }
            Page page = swipeBackLayout3.OooO0o.getPage();
            if (page != null && page.isHide()) {
                StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("page is hidden, mScrollPercent: ");
                OooO00o.append(SwipeBackLayout.this.OooO0OO);
                TmcLogger.d("SwipeBackLayout", OooO00o.toString());
                return;
            }
            SwipeBackLayout.this.OooO00o();
            Fragment fragment2 = SwipeBackLayout.this.OooO0oO;
            if (fragment2 == null || (view3 = fragment2.getView()) == null || view3.getVisibility() != 0) {
                return;
            }
            view3.setVisibility(8);
            TmcLogger.d("SwipeBackLayout", "preView set gone, mScrollPercent: " + SwipeBackLayout.this.OooO0OO);
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            int width = view.getWidth();
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            int i2 = swipeBackLayout.OooOOO0;
            if ((i2 & 1) != 0) {
                if (f > 0.0f || (f == 0.0f && swipeBackLayout.OooO0OO > swipeBackLayout.OooO00o)) {
                    i = swipeBackLayout.OooO0oo.getIntrinsicWidth() + width + 10;
                }
                i = 0;
            } else {
                if ((i2 & 2) != 0 && (f < 0.0f || (f == 0.0f && swipeBackLayout.OooO0OO > swipeBackLayout.OooO00o))) {
                    i = -(swipeBackLayout.OooO.getIntrinsicWidth() + width + 10);
                }
                i = 0;
            }
            SwipeBackLayout.this.OooO0O0.settleCapturedViewAt(i, 0);
            SwipeBackLayout.this.invalidate();
        }

        public boolean tryCaptureView(@NonNull View view, int i) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            boolean isEdgeTouched = swipeBackLayout.OooO0O0.isEdgeTouched(swipeBackLayout.OooOO0O, i);
            if (isEdgeTouched) {
                if (SwipeBackLayout.this.OooO0O0.isEdgeTouched(1, i)) {
                    SwipeBackLayout.this.OooOOO0 = 1;
                } else if (SwipeBackLayout.this.OooO0O0.isEdgeTouched(2, i)) {
                    SwipeBackLayout.this.OooOOO0 = 2;
                }
                SwipeBackLayout.this.getClass();
            }
            return isEdgeTouched;
        }
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OooO00o = 0.4f;
        this.OooOO0 = new Rect();
        this.OooOO0o = true;
        this.OooOOO = 0.33f;
        this.OooOOoo = 0.5f;
        this.OooOo00 = 0;
        this.OooOo0 = 0;
        this.OooOo0O = 0;
        this.OooOo0o = context;
        OooO0O0();
    }

    private void setContentView(View view) {
        this.OooO0o0 = view;
    }

    public void OooO00o() {
        TmcFragment tmcFragment;
        Page page;
        App app;
        TmcFragment findFragmentPreForPage;
        if (this.OooO0oO != null || (tmcFragment = this.OooO0o) == null || (page = tmcFragment.getPage()) == null || (app = page.getApp()) == null) {
            return;
        }
        TmcAppContext appContext = app.getAppContext();
        if (!(appContext instanceof TmcAppContext) || (findFragmentPreForPage = appContext.getFragmentManager().findFragmentPreForPage(this.OooO0o.getPage())) == null || findFragmentPreForPage.getView() == null) {
            return;
        }
        this.OooO0oO = findFragmentPreForPage;
    }

    public void OooO00o(int i, int i2) {
        Drawable drawable = androidx.core.content.b.getDrawable(this.OooOo0o, i);
        if ((i2 & 1) != 0) {
            this.OooO0oo = drawable;
        } else if ((i2 & 2) != 0) {
            this.OooO = drawable;
        }
        invalidate();
    }

    public final void OooO00o(int i, EdgeLevel edgeLevel) {
        try {
            DisplayMetrics displayMetrics = this.OooOo0o.getResources().getDisplayMetrics();
            if (i >= 0) {
                this.OooOo00 = i + this.OooOo0;
            } else if (edgeLevel == EdgeLevel.MAX) {
                this.OooOo00 = displayMetrics.widthPixels;
            } else if (edgeLevel == EdgeLevel.MED) {
                this.OooOo00 = displayMetrics.widthPixels / 2;
            } else {
                this.OooOo00 = (int) ((displayMetrics.density * 20.0f) + 0.5f);
            }
            Field declaredField = this.OooO0O0.getClass().getDeclaredField("mEdgeSize");
            declaredField.setAccessible(true);
            declaredField.setInt(this.OooO0O0, this.OooOo00);
        } catch (IllegalAccessException e) {
            e = e;
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e = e2;
            e.printStackTrace();
        }
    }

    public final void OooO0O0() {
        this.OooO0O0 = ViewDragHelper.create(this, new OooO00o());
        OooO00o(R.drawable.shape_swipe_back_shadow, 1);
        setEdgeOrientation(1);
        float f = this.OooOo0o.getResources().getDisplayMetrics().density;
        this.OooOo00 = (int) ((20.0f * f) + 0.5f);
        this.OooOo0 = (int) ((f * 25.0f) + 0.5f);
        this.OooOo0O = (int) (r0.heightPixels * 0.33f);
    }

    @Override // android.view.View
    public void computeScroll() {
        float f = 1.0f - this.OooO0OO;
        this.OooO0Oo = f;
        if (f >= 0.0f) {
            if (this.OooO0O0.continueSettling(true)) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            Fragment fragment = this.OooO0oO;
            if (fragment == null || fragment.getView() == null) {
                return;
            }
            if (this.OooOOOO) {
                this.OooO0oO.getView().setX(0.0f);
            } else if (this.OooO0O0.getCapturedView() != null) {
                int left = (int) ((this.OooO0O0.getCapturedView().getLeft() - getWidth()) * this.OooOOO * this.OooO0Oo);
                if (this.OooO0O0.getCapturedView().getLeft() == 0) {
                    left = 0;
                }
                this.OooO0oO.getView().setX(Math.min(left, 0));
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z = view == this.OooO0o0;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (z && this.OooO0Oo > 0.0f && this.OooO0O0.getViewDragState() != 0) {
            Rect rect = this.OooOO0;
            view.getHitRect(rect);
            int i = this.OooOOO0;
            if ((i & 1) != 0) {
                Drawable drawable = this.OooO0oo;
                drawable.setBounds(rect.left - drawable.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
                this.OooO0oo.draw(canvas);
            } else if ((i & 2) != 0) {
                Drawable drawable2 = this.OooO;
                int i2 = rect.right;
                drawable2.setBounds(i2, rect.top, drawable2.getIntrinsicWidth() + i2, rect.bottom);
                this.OooO.draw(canvas);
            }
            int i3 = ((int) ((this.OooO0Oo * 153.0f) * this.OooOOoo)) << 24;
            int i4 = this.OooOOO0;
            if ((i4 & 1) != 0) {
                canvas.clipRect(0, 0, view.getLeft(), getHeight());
            } else if ((i4 & 2) != 0) {
                canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
            }
            canvas.drawColor(i3);
        }
        return drawChild;
    }

    public ViewDragHelper getViewDragHelper() {
        return this.OooO0O0;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.OooOO0o) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        try {
            if (motionEvent.getActionMasked() == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (x >= this.OooOo0) {
                    if (x <= this.OooOo00) {
                        if (y > this.OooOo0O) {
                        }
                    }
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
            return this.OooO0O0.shouldInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.OooOOOo = true;
        View view = this.OooO0o0;
        if (view != null) {
            int i5 = this.OooOOo0;
            view.layout(i5, this.OooOOo, view.getMeasuredWidth() + i5, this.OooO0o0.getMeasuredHeight() + this.OooOOo);
        }
        this.OooOOOo = false;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.OooOO0o) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            if (motionEvent.getActionMasked() == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (x >= this.OooOo0) {
                    if (x <= this.OooOo00) {
                        if (y > this.OooOo0O) {
                        }
                    }
                }
                return super.onTouchEvent(motionEvent);
            }
            this.OooO0O0.processTouchEvent(motionEvent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.OooOOOo) {
            return;
        }
        super.requestLayout();
    }

    public void setEdgeLevel(int i) {
        OooO00o(i, (EdgeLevel) null);
    }

    public void setEdgeLevel(EdgeLevel edgeLevel) {
        OooO00o(-1, edgeLevel);
    }

    public void setEdgeOrientation(int i) {
        this.OooOO0O = i;
        this.OooO0O0.setEdgeTrackingEnabled(i);
        if (i == 2 || i == 3) {
            OooO00o(R.drawable.shape_swipe_back_shadow, 2);
        }
    }

    public void setEnableGesture(boolean z) {
        this.OooOO0o = z;
    }

    public void setParallaxOffset(float f) {
        this.OooOOO = f;
    }

    public void setScrollThresHold(float f) {
        if (f >= 1.0f || f <= 0.0f) {
            throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
        }
        this.OooO00o = f;
    }

    public void setSwipeAlpha(float f) {
        this.OooOOoo = f;
    }
}
