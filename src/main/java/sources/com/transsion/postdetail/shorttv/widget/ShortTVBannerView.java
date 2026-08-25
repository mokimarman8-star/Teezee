package com.transsion.postdetail.shorttv.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.to.aboomy.pager2banner.Banner;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001d¨\u0006 "}, d2 = {"Lcom/transsion/postdetail/shorttv/widget/ShortTVBannerView;", "Lcom/to/aboomy/pager2banner/Banner;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "orientation", BuildConfig.FLAVOR, "delta", BuildConfig.FLAVOR, "v", "(IF)Z", "Landroid/view/MotionEvent;", "e", BuildConfig.FLAVOR, "w", "(Landroid/view/MotionEvent;)V", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "u", "I", "touchSlop", "F", "initialX", "initialY", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTVBannerView extends Banner {

    /* renamed from: u, reason: from kotlin metadata */
    private int touchSlop;

    /* renamed from: v, reason: from kotlin metadata */
    private float initialX;

    /* renamed from: w, reason: from kotlin metadata */
    private float initialY;

    /* JADX WARN: Multi-variable type inference failed */
    public ShortTVBannerView(Context context) {
        super(context);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShortTVBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShortTVBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean v(int orientation, float delta) {
        int i = -((int) Math.signum(delta));
        if (orientation == 0) {
            return canScrollHorizontally(i);
        }
        if (orientation == 1) {
            return canScrollVertically(i);
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w(MotionEvent e) {
        int orientation = getViewPager2().getOrientation();
        if (e.getAction() == 0) {
            this.initialX = e.getX();
            this.initialY = e.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            return;
        }
        if (e.getAction() == 2) {
            float x = e.getX() - this.initialX;
            float y = e.getY() - this.initialY;
            boolean z = orientation == 0;
            float abs = Math.abs(x) * (z ? 0.5f : 1.0f);
            float abs2 = Math.abs(y) * (z ? 1.0f : 0.5f);
            int i = this.touchSlop;
            if (abs > i || abs2 > i) {
                if (z == (abs2 > abs)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return;
                }
                if (!z) {
                    x = y;
                }
                if (v(orientation, x)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (getCurrentPager() == 0 && getChildCount() == 0) {
            return false;
        }
        if (ev != null) {
            w(ev);
        }
        return super.onInterceptTouchEvent(ev);
    }
}
