package com.transsion.wrapperad.view.cardpage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.transsion.wrapperad.view.cardpage.NativeCardPageView;
import com.transsion.wrapperad.view.cardpage.e;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u0000 b2\u00020\u0001:\u00026cB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0012J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\fJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010!\u001a\u00020\u00002\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0000¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0000¢\u0006\u0004\b%\u0010$J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0015\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0015\u00100\u001a\u00020\u00002\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\r\u00103\u001a\u000202¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u0000¢\u0006\u0004\b5\u0010$R\"\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010\u0012R\"\u0010?\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u00107\u001a\u0004\b=\u00109\"\u0004\b>\u0010\u0012R\u0016\u0010A\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010@R\u0016\u0010C\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010BR\u0016\u0010F\u001a\u00020D8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010HR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010KR\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010OR\u0016\u0010Q\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010OR\u0016\u0010T\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u00107R\u0016\u0010[\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u00107R\u0016\u0010]\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010SR\u0016\u0010_\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010VR\u0016\u0010a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010V¨\u0006d"}, d2 = {"Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", HttpUrl.FRAGMENT_ENCODE_SET, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", HttpUrl.FRAGMENT_ENCODE_SET, "d", "()V", "Landroidx/viewpager2/widget/CompositePageTransformer;", "j", "()Landroidx/viewpager2/widget/CompositePageTransformer;", "position", "g", "(I)V", HttpUrl.FRAGMENT_ENCODE_SET, "positionOffset", "positionOffsetPixels", "f", "(IFI)V", "state", "e", "i", "h", "c", "(I)I", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/transsion/wrapperad/view/cardpage/f;", "data", "setPageData", "(Ljava/util/List;)Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView;", "startAutoScroll", "()Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView;", "pauseAutoScroll", HttpUrl.FRAGMENT_ENCODE_SET, "interval", "setScrollInterval", "(J)Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView;", HttpUrl.FRAGMENT_ENCODE_SET, "disable", "setDisableRightSwipe", "(Z)Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "listener", "setOnPageChangeListener", "(Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;)Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView;", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "destroy", "a", "I", "getContentWidth", "()I", "setContentWidth", "contentWidth", "b", "getStackOffset", "setStackOffset", "stackOffset", "J", "scrollInterval", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Lcom/transsion/wrapperad/view/cardpage/e;", "Lcom/transsion/wrapperad/view/cardpage/e;", "pageAdapter", "Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView$AutoScrollRunnable;", "Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView$AutoScrollRunnable;", "autoScrollRunnable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isAutoScrolling", "Ljava/util/List;", "pageDataList", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageChangeListener", "pageChangeCallback", "k", "Z", "isScrolling", "l", "F", "stackPageScale", "m", "lastOffsetX", "n", "lastPosition", "o", "disableRightSwipe", "p", "disableRightSwipeThreshold", "q", "switchPagePercent", "Companion", "AutoScrollRunnable", "wrapperad_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SuppressLint({"ClickableViewAccessibility"})
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class NativeCardPageView extends FrameLayout {
    public static final float STACK_OFFSET = 12.0f;

    /* renamed from: a, reason: from kotlin metadata */
    private int contentWidth;

    /* renamed from: b, reason: from kotlin metadata */
    private int stackOffset;

    /* renamed from: c, reason: from kotlin metadata */
    private long scrollInterval;

    /* renamed from: d, reason: from kotlin metadata */
    private ViewPager2 viewPager2;

    /* renamed from: e, reason: from kotlin metadata */
    private e pageAdapter;

    /* renamed from: f, reason: from kotlin metadata */
    private AutoScrollRunnable autoScrollRunnable;

    /* renamed from: g, reason: from kotlin metadata */
    private AtomicBoolean isAutoScrolling;

    /* renamed from: h, reason: from kotlin metadata */
    private List pageDataList;

    /* renamed from: i, reason: from kotlin metadata */
    private ViewPager2.OnPageChangeCallback onPageChangeListener;

    /* renamed from: j, reason: from kotlin metadata */
    private ViewPager2.OnPageChangeCallback pageChangeCallback;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean isScrolling;

    /* renamed from: l, reason: from kotlin metadata */
    private float stackPageScale;

    /* renamed from: m, reason: from kotlin metadata */
    private int lastOffsetX;

    /* renamed from: n, reason: from kotlin metadata */
    private int lastPosition;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean disableRightSwipe;

    /* renamed from: p, reason: from kotlin metadata */
    private float disableRightSwipeThreshold;

    /* renamed from: q, reason: from kotlin metadata */
    private float switchPagePercent;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView$AutoScrollRunnable;", "Ljava/lang/Runnable;", "nativeCardPageView", "Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView;", "<init>", "(Lcom/transsion/wrapperad/view/cardpage/NativeCardPageView;)V", "nativeCardPageViewRef", "Ljava/lang/ref/WeakReference;", "run", HttpUrl.FRAGMENT_ENCODE_SET, "wrapperad_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    private static final class AutoScrollRunnable implements Runnable {
        private final WeakReference<NativeCardPageView> nativeCardPageViewRef;

        public AutoScrollRunnable(NativeCardPageView nativeCardPageView) {
            Intrinsics.h(nativeCardPageView, "nativeCardPageView");
            this.nativeCardPageViewRef = new WeakReference<>(nativeCardPageView);
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeCardPageView nativeCardPageView = this.nativeCardPageViewRef.get();
            if (nativeCardPageView == null || !nativeCardPageView.isAutoScrolling.get()) {
                return;
            }
            ViewPager2 viewPager2 = nativeCardPageView.viewPager2;
            View view = null;
            if (viewPager2 == null) {
                Intrinsics.y("viewPager2");
                viewPager2 = null;
            }
            int currentItem = viewPager2.getCurrentItem() + 1;
            ViewPager2 viewPager22 = nativeCardPageView.viewPager2;
            if (viewPager22 == null) {
                Intrinsics.y("viewPager2");
                viewPager22 = null;
            }
            viewPager22.setCurrentItem(currentItem, true);
            View view2 = nativeCardPageView.viewPager2;
            if (view2 == null) {
                Intrinsics.y("viewPager2");
            } else {
                view = view2;
            }
            view.postDelayed(this, nativeCardPageView.scrollInterval);
        }
    }

    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
            NativeCardPageView.this.e(i);
        }

        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
            NativeCardPageView.this.f(i, f, i2);
        }

        public void onPageSelected(int i) {
            super.onPageSelected(i);
            NativeCardPageView.this.g(i);
        }
    }

    public static final class c implements RecyclerView.q {
        private float a;
        private boolean b;

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(NativeCardPageView nativeCardPageView) {
            ViewPager2 viewPager2 = nativeCardPageView.viewPager2;
            if (viewPager2 == null) {
                Intrinsics.y("viewPager2");
                viewPager2 = null;
            }
            viewPager2.setCurrentItem(nativeCardPageView.lastPosition, false);
        }

        public void a(RecyclerView rv2, MotionEvent e) {
            Intrinsics.h(rv2, "rv");
            Intrinsics.h(e, "e");
            if (this.b) {
                int action = e.getAction();
                if (action == 1 || action == 3) {
                    final NativeCardPageView nativeCardPageView = NativeCardPageView.this;
                    rv2.post(new Runnable() { // from class: com.transsion.wrapperad.view.cardpage.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            NativeCardPageView.c.e(NativeCardPageView.this);
                        }
                    });
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        
            if (r4 != 3) goto L25;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean b(RecyclerView rv2, MotionEvent e) {
            Intrinsics.h(rv2, "rv");
            Intrinsics.h(e, "e");
            ViewPager2 viewPager2 = NativeCardPageView.this.viewPager2;
            if (viewPager2 == null) {
                Intrinsics.y("viewPager2");
                viewPager2 = null;
            }
            if (!viewPager2.isUserInputEnabled()) {
                return false;
            }
            int action = e.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x = e.getX() - this.a;
                        if (NativeCardPageView.this.disableRightSwipe && x > NativeCardPageView.this.disableRightSwipeThreshold) {
                            this.b = true;
                            return true;
                        }
                    }
                }
                NativeCardPageView.this.startAutoScroll();
            } else {
                NativeCardPageView.this.pauseAutoScroll();
                this.a = e.getX();
                this.b = false;
            }
            return false;
        }

        public void c(boolean z) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NativeCardPageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NativeCardPageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NativeCardPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.stackOffset = a0.a(12.0f);
        this.scrollInterval = 30000L;
        this.isAutoScrolling = new AtomicBoolean(false);
        this.pageDataList = CollectionsKt.l();
        this.stackPageScale = 0.1f;
        this.disableRightSwipe = true;
        this.disableRightSwipeThreshold = 10.0f;
        this.switchPagePercent = 0.05f;
        d();
        i();
    }

    public /* synthetic */ NativeCardPageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final int c(int position) {
        if (this.pageDataList.isEmpty()) {
            return 0;
        }
        return position % this.pageDataList.size();
    }

    private final void d() {
        ViewPager2 viewPager2 = new ViewPager2(getContext());
        this.viewPager2 = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(y.e() - a0.a(24.0f), -2));
        ViewGroup viewGroup = this.viewPager2;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = null;
        if (viewGroup == null) {
            Intrinsics.y("viewPager2");
            viewGroup = null;
        }
        viewGroup.setClipChildren(false);
        ViewGroup viewGroup2 = this.viewPager2;
        if (viewGroup2 == null) {
            Intrinsics.y("viewPager2");
            viewGroup2 = null;
        }
        viewGroup2.setClipToPadding(false);
        View view = this.viewPager2;
        if (view == null) {
            Intrinsics.y("viewPager2");
            view = null;
        }
        view.setOverScrollMode(2);
        ViewPager2 viewPager22 = this.viewPager2;
        if (viewPager22 == null) {
            Intrinsics.y("viewPager2");
            viewPager22 = null;
        }
        viewPager22.setOrientation(0);
        ViewPager2 viewPager23 = this.viewPager2;
        if (viewPager23 == null) {
            Intrinsics.y("viewPager2");
            viewPager23 = null;
        }
        viewPager23.setUserInputEnabled(false);
        View view2 = this.viewPager2;
        if (view2 == null) {
            Intrinsics.y("viewPager2");
            view2 = null;
        }
        addView(view2);
        this.pageChangeCallback = new b();
        ViewPager2 viewPager24 = this.viewPager2;
        if (viewPager24 == null) {
            Intrinsics.y("viewPager2");
            viewPager24 = null;
        }
        ViewPager2.OnPageChangeCallback onPageChangeCallback2 = this.pageChangeCallback;
        if (onPageChangeCallback2 == null) {
            Intrinsics.y("pageChangeCallback");
        } else {
            onPageChangeCallback = onPageChangeCallback2;
        }
        viewPager24.registerOnPageChangeCallback(onPageChangeCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(int state) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.onPageChangeListener;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(state);
        }
        if (state != 0) {
            if (state != 1) {
                return;
            }
            this.isScrolling = true;
            return;
        }
        this.lastOffsetX = 0;
        ViewPager2 viewPager2 = null;
        if (this.isScrolling) {
            ViewPager2 viewPager22 = this.viewPager2;
            if (viewPager22 == null) {
                Intrinsics.y("viewPager2");
                viewPager22 = null;
            }
            if (viewPager22.getCurrentItem() == this.lastPosition) {
                h();
            } else if (this.disableRightSwipe) {
                ViewPager2 viewPager23 = this.viewPager2;
                if (viewPager23 == null) {
                    Intrinsics.y("viewPager2");
                    viewPager23 = null;
                }
                if (viewPager23.getCurrentItem() < this.lastPosition) {
                    ViewPager2 viewPager24 = this.viewPager2;
                    if (viewPager24 == null) {
                        Intrinsics.y("viewPager2");
                        viewPager24 = null;
                    }
                    viewPager24.setCurrentItem(this.lastPosition, false);
                    h();
                }
            }
        }
        ViewPager2 viewPager25 = this.viewPager2;
        if (viewPager25 == null) {
            Intrinsics.y("viewPager2");
        } else {
            viewPager2 = viewPager25;
        }
        this.lastPosition = viewPager2.getCurrentItem();
        this.isScrolling = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int position, float positionOffset, int positionOffsetPixels) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.onPageChangeListener;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
        ViewGroup viewGroup = this.viewPager2;
        if (viewGroup == null) {
            Intrinsics.y("viewPager2");
            viewGroup = null;
        }
        RecyclerView childAt = viewGroup.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? childAt : null;
        if (recyclerView == null || positionOffset <= this.switchPagePercent || this.lastOffsetX != 0) {
            return;
        }
        int i = position + 1;
        RecyclerView.a0 findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i);
        e.a aVar = findViewHolderForAdapterPosition instanceof e.a ? (e.a) findViewHolderForAdapterPosition : null;
        if (aVar != null) {
            Result.box-impl(aVar.f((f) this.pageDataList.get(c(i))));
        }
        this.lastOffsetX = positionOffsetPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(int position) {
        int c2 = c(position);
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.onPageChangeListener;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(c2);
        }
        ViewGroup viewGroup = this.viewPager2;
        if (viewGroup == null) {
            Intrinsics.y("viewPager2");
            viewGroup = null;
        }
        RecyclerView childAt = viewGroup.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? childAt : null;
        if (recyclerView != null) {
            RecyclerView.a0 findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(position);
            e.a aVar = findViewHolderForAdapterPosition instanceof e.a ? (e.a) findViewHolderForAdapterPosition : null;
            if (aVar == null || aVar.g().getChildCount() > 0) {
                return;
            }
            aVar.f((f) this.pageDataList.get(c2));
        }
    }

    private final void h() {
        FrameLayout g;
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.y("viewPager2");
            viewPager2 = null;
        }
        int currentItem = viewPager2.getCurrentItem() + 1;
        ViewGroup viewGroup = this.viewPager2;
        if (viewGroup == null) {
            Intrinsics.y("viewPager2");
            viewGroup = null;
        }
        RecyclerView childAt = viewGroup.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? childAt : null;
        if (recyclerView != null) {
            RecyclerView.a0 findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(currentItem);
            e.a aVar = findViewHolderForAdapterPosition instanceof e.a ? (e.a) findViewHolderForAdapterPosition : null;
            if (aVar == null || (g = aVar.g()) == null) {
                return;
            }
            g.removeAllViews();
        }
    }

    private final void i() {
        View view = this.viewPager2;
        if (view == null) {
            Intrinsics.y("viewPager2");
            view = null;
        }
        view.post(new Runnable() { // from class: com.transsion.wrapperad.view.cardpage.h
            @Override // java.lang.Runnable
            public final void run() {
                NativeCardPageView.setupTouchEventListener$lambda$5(NativeCardPageView.this);
            }
        });
    }

    private final CompositePageTransformer j() {
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() { // from class: com.transsion.wrapperad.view.cardpage.g
            public final void transformPage(View view, float f) {
                NativeCardPageView.k(NativeCardPageView.this, view, f);
            }
        });
        return compositePageTransformer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(NativeCardPageView nativeCardPageView, View page, float f) {
        Intrinsics.h(page, "page");
        if (f <= 0.0f) {
            page.setScaleX(1.0f);
            page.setScaleY(1.0f);
            page.setTranslationX(0.0f);
            page.setTranslationZ(0.0f);
            return;
        }
        float f2 = 1;
        float f3 = f2 - (nativeCardPageView.stackPageScale * f);
        page.setScaleX(f3);
        page.setScaleY(f3);
        page.setTranslationX(((-page.getWidth()) * f) + ((nativeCardPageView.contentWidth * (f2 - f3)) / 2) + (nativeCardPageView.stackOffset * f));
        page.setTranslationZ(-f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTouchEventListener$lambda$5(NativeCardPageView nativeCardPageView) {
        c cVar = nativeCardPageView.new c();
        ViewGroup viewGroup = nativeCardPageView.viewPager2;
        if (viewGroup == null) {
            Intrinsics.y("viewPager2");
            viewGroup = null;
        }
        View childAt = viewGroup.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            recyclerView.removeOnItemTouchListener(cVar);
        }
        if (recyclerView != null) {
            recyclerView.addOnItemTouchListener(cVar);
        }
    }

    public final NativeCardPageView destroy() {
        pauseAutoScroll();
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.y("viewPager2");
            viewPager2 = null;
        }
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.pageChangeCallback;
        if (onPageChangeCallback == null) {
            Intrinsics.y("pageChangeCallback");
            onPageChangeCallback = null;
        }
        viewPager2.unregisterOnPageChangeCallback(onPageChangeCallback);
        ViewPager2 viewPager22 = this.viewPager2;
        if (viewPager22 == null) {
            Intrinsics.y("viewPager2");
            viewPager22 = null;
        }
        viewPager22.setAdapter((RecyclerView.Adapter) null);
        this.onPageChangeListener = null;
        for (f fVar : this.pageDataList) {
            ViewParent parent = fVar.d().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(fVar.d());
            }
            fVar.g(null);
        }
        this.pageDataList = CollectionsKt.l();
        removeAllViews();
        return this;
    }

    public final int getContentWidth() {
        return this.contentWidth;
    }

    public final int getStackOffset() {
        return this.stackOffset;
    }

    public final ViewPager2 getViewPager() {
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 != null) {
            return viewPager2;
        }
        Intrinsics.y("viewPager2");
        return null;
    }

    public final NativeCardPageView pauseAutoScroll() {
        if (!this.isAutoScrolling.get()) {
            return this;
        }
        this.isAutoScrolling.set(false);
        AutoScrollRunnable autoScrollRunnable = this.autoScrollRunnable;
        if (autoScrollRunnable != null) {
            View view = this.viewPager2;
            if (view == null) {
                Intrinsics.y("viewPager2");
                view = null;
            }
            view.removeCallbacks(autoScrollRunnable);
        }
        return this;
    }

    public final void setContentWidth(int i) {
        this.contentWidth = i;
    }

    public final NativeCardPageView setDisableRightSwipe(boolean disable) {
        this.disableRightSwipe = disable;
        return this;
    }

    public final NativeCardPageView setOnPageChangeListener(ViewPager2.OnPageChangeCallback listener) {
        Intrinsics.h(listener, "listener");
        this.onPageChangeListener = listener;
        return this;
    }

    public final NativeCardPageView setPageData(List<f> data) {
        Intrinsics.h(data, "data");
        this.pageDataList = data;
        View view = this.viewPager2;
        ViewPager2 viewPager2 = null;
        if (view == null) {
            Intrinsics.y("viewPager2");
            view = null;
        }
        this.contentWidth = view.getMeasuredWidth() - ((this.stackOffset + 5) * (this.pageDataList.size() - 1));
        ViewPager2 viewPager22 = this.viewPager2;
        if (viewPager22 == null) {
            Intrinsics.y("viewPager2");
            viewPager22 = null;
        }
        viewPager22.setPageTransformer(j());
        this.pageAdapter = new e(this.pageDataList, this.contentWidth);
        ViewPager2 viewPager23 = this.viewPager2;
        if (viewPager23 == null) {
            Intrinsics.y("viewPager2");
            viewPager23 = null;
        }
        e eVar = this.pageAdapter;
        if (eVar == null) {
            Intrinsics.y("pageAdapter");
            eVar = null;
        }
        viewPager23.setAdapter(eVar);
        ViewPager2 viewPager24 = this.viewPager2;
        if (viewPager24 == null) {
            Intrinsics.y("viewPager2");
            viewPager24 = null;
        }
        viewPager24.setUserInputEnabled(data.size() > 1);
        ViewPager2 viewPager25 = this.viewPager2;
        if (viewPager25 == null) {
            Intrinsics.y("viewPager2");
            viewPager25 = null;
        }
        ViewPager2 viewPager26 = this.viewPager2;
        if (viewPager26 == null) {
            Intrinsics.y("viewPager2");
        } else {
            viewPager2 = viewPager26;
        }
        viewPager25.setOffscreenPageLimit(viewPager2.isUserInputEnabled() ? RangesKt.h(data.size() - 1, 2) : -1);
        startAutoScroll();
        return this;
    }

    public final NativeCardPageView setScrollInterval(long interval) {
        this.scrollInterval = interval;
        if (this.isAutoScrolling.get()) {
            pauseAutoScroll();
            startAutoScroll();
        }
        return this;
    }

    public final void setStackOffset(int i) {
        this.stackOffset = i;
    }

    public final NativeCardPageView startAutoScroll() {
        ViewPager2 viewPager2 = this.viewPager2;
        View view = null;
        if (viewPager2 == null) {
            Intrinsics.y("viewPager2");
            viewPager2 = null;
        }
        if (viewPager2.isUserInputEnabled() && !this.isAutoScrolling.get()) {
            this.isAutoScrolling.set(true);
            this.autoScrollRunnable = new AutoScrollRunnable(this);
            View view2 = this.viewPager2;
            if (view2 == null) {
                Intrinsics.y("viewPager2");
            } else {
                view = view2;
            }
            AutoScrollRunnable autoScrollRunnable = this.autoScrollRunnable;
            Intrinsics.e(autoScrollRunnable);
            view.postDelayed(autoScrollRunnable, this.scrollInterval);
        }
        return this;
    }
}
