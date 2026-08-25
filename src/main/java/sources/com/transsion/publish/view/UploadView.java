package com.transsion.publish.view;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import androidx.lifecycle.w;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.d;
import com.blankj.utilcode.util.h;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.PublishManager;
import com.transsion.publish.R$color;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.bean.PublishResult;
import com.transsion.publish.view.UploadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.y0;
import wf.a;
import yg.l;
import yg.m;

@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001V\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001^B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\u0019\u0010\u0017\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u0010J\u000f\u0010\u001a\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001a\u0010\u0010J\u000f\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u0010J\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u001cH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020,8\u0002X\u0082D¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00104R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00104R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u00101R\u0016\u0010I\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010\u001aR\u0016\u0010K\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010.R\u0016\u0010N\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010MR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010RR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010RR\u0014\u0010U\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010RR\u0014\u0010X\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010WR\u0014\u0010\\\u001a\u00020Y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[¨\u0006_"}, d2 = {"Lcom/transsion/publish/view/UploadView;", "Lcom/transsion/publish/view/BaseFloatView;", "Landroidx/lifecycle/u;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "x", "E", "()V", "C", "t", "u", "s", "H", "progress", "K", "(Ljava/lang/Integer;)V", "G", "I", "w", BuildConfig.FLAVOR, "collapse", "v", "(Z)V", "A", "()Z", "Lcom/transsion/publish/bean/PublishResult;", "eventBean", "showFloatView", "(Lcom/transsion/publish/bean/PublishResult;)V", BuildConfig.FLAVOR, "pageName", "setPageName", "(Ljava/lang/String;)V", "e", "Lcom/transsion/publish/bean/PublishResult;", BuildConfig.FLAVOR, "f", "J", "dismissTime", "g", "Ljava/lang/String;", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "ufv_tv_progress", "i", "ufv_tv_status", "Landroid/widget/ImageView;", "j", "Landroid/widget/ImageView;", "ufv_iv_retry", "k", "right_state", "Landroid/widget/RelativeLayout;", "l", "Landroid/widget/RelativeLayout;", "ufv_view2", "Landroidx/lifecycle/w;", "m", "Landroidx/lifecycle/w;", "mLifecycleRegistry", "n", "postId", "o", "sourceType", "p", "lastSucceedTime", "q", "Z", "isLoadCover", "r", "isShowAnima", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "runnable", "netRunnable", "allAnimaRunnable", "com/transsion/publish/view/UploadView$c", "Lcom/transsion/publish/view/UploadView$c;", "netListener", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "Companion", "a", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UploadView extends BaseFloatView implements u {
    public static final int failed = 3;
    public static final int posting = 1;
    public static final int success = 2;

    /* renamed from: e, reason: from kotlin metadata */
    private PublishResult eventBean;

    /* renamed from: f, reason: from kotlin metadata */
    private final long dismissTime;

    /* renamed from: g, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: h, reason: from kotlin metadata */
    private TextView ufv_tv_progress;

    /* renamed from: i, reason: from kotlin metadata */
    private TextView ufv_tv_status;

    /* renamed from: j, reason: from kotlin metadata */
    private ImageView ufv_iv_retry;

    /* renamed from: k, reason: from kotlin metadata */
    private TextView right_state;

    /* renamed from: l, reason: from kotlin metadata */
    private RelativeLayout ufv_view2;

    /* renamed from: m, reason: from kotlin metadata */
    private w mLifecycleRegistry;

    /* renamed from: n, reason: from kotlin metadata */
    private String postId;

    /* renamed from: o, reason: from kotlin metadata */
    private int sourceType;

    /* renamed from: p, reason: from kotlin metadata */
    private long lastSucceedTime;

    /* renamed from: q, reason: from kotlin metadata */
    private boolean isLoadCover;

    /* renamed from: r, reason: from kotlin metadata */
    private boolean isShowAnima;

    /* renamed from: s, reason: from kotlin metadata */
    private final Runnable runnable;

    /* renamed from: t, reason: from kotlin metadata */
    private final Runnable netRunnable;

    /* renamed from: u, reason: from kotlin metadata */
    private final Runnable allAnimaRunnable;

    /* renamed from: v, reason: from kotlin metadata */
    private final c netListener;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String w = "UploadView";

    /* renamed from: com.transsion.publish.view.UploadView$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return UploadView.w;
        }
    }

    public static final class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            UploadView.this.lastSucceedTime = 0L;
            UploadView.this.clearAnimation();
            UploadView.this.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class c implements m {
        c() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            a.a.f(a.a, "TNPublish", "uploadview retry", false, 4, (Object) null);
        }

        public void onDisconnected() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.dismissTime = 5000L;
        this.postId = BuildConfig.FLAVOR;
        w wVar = new w(this);
        this.mLifecycleRegistry = wVar;
        wVar.n(Lifecycle.State.CREATED);
        this.runnable = new Runnable() { // from class: ro.p
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.F(UploadView.this);
            }
        };
        this.netRunnable = new Runnable() { // from class: ro.q
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.B(UploadView.this);
            }
        };
        this.allAnimaRunnable = new Runnable() { // from class: ro.r
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.r(UploadView.this);
            }
        };
        this.netListener = new c();
        x(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.dismissTime = 5000L;
        this.postId = BuildConfig.FLAVOR;
        w wVar = new w(this);
        this.mLifecycleRegistry = wVar;
        wVar.n(Lifecycle.State.CREATED);
        this.runnable = new Runnable() { // from class: ro.p
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.F(UploadView.this);
            }
        };
        this.netRunnable = new Runnable() { // from class: ro.q
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.B(UploadView.this);
            }
        };
        this.allAnimaRunnable = new Runnable() { // from class: ro.r
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.r(UploadView.this);
            }
        };
        this.netListener = new c();
        x(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.dismissTime = 5000L;
        this.postId = BuildConfig.FLAVOR;
        w wVar = new w(this);
        this.mLifecycleRegistry = wVar;
        wVar.n(Lifecycle.State.CREATED);
        this.runnable = new Runnable() { // from class: ro.p
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.F(UploadView.this);
            }
        };
        this.netRunnable = new Runnable() { // from class: ro.q
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.B(UploadView.this);
            }
        };
        this.allAnimaRunnable = new Runnable() { // from class: ro.r
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.r(UploadView.this);
            }
        };
        this.netListener = new c();
        x(context);
    }

    private final boolean A() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(UploadView uploadView) {
        l.a.m(uploadView.netListener);
    }

    private final void C() {
        Function1 function1 = new Function1() { // from class: ro.v
            public final Object invoke(Object obj) {
                Unit D;
                D = UploadView.D(UploadView.this, (PublishResult) obj);
                return D;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PublishResult.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(UploadView uploadView, PublishResult publishResult) {
        Intrinsics.h(publishResult, "it");
        uploadView.showFloatView(publishResult);
        return Unit.a;
    }

    private final void E() {
        PublishManager.Companion.a().retry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(UploadView uploadView) {
        uploadView.v(true);
    }

    private final void G() {
        u();
        this.isLoadCover = false;
        this.isShowAnima = false;
        TextView textView = this.ufv_tv_progress;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.ufv_tv_status;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        v(false);
        TextView textView3 = this.ufv_tv_status;
        if (textView3 != null) {
            textView3.setText(R$string.postint_state_fail);
        }
        TextView textView4 = this.right_state;
        if (textView4 != null) {
            textView4.setText(R$string.postint_state_retry);
        }
        TextView textView5 = this.right_state;
        if (textView5 != null) {
            textView5.setTextColor(h.a(R.color.cl01));
        }
        getH().removeCallbacks(this.runnable);
        getH().removeCallbacks(this.allAnimaRunnable);
        getH().postDelayed(this.allAnimaRunnable, this.dismissTime * 2);
    }

    private final void H() {
        s();
        TextView textView = this.ufv_tv_progress;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.ufv_tv_status;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.ufv_tv_status;
        if (textView3 != null) {
            textView3.setText(R$string.postint_state_posted);
        }
        TextView textView4 = this.right_state;
        if (textView4 != null) {
            textView4.setText(R$string.postint_state_cancel);
        }
        TextView textView5 = this.ufv_tv_progress;
        if (textView5 != null) {
            textView5.setText("0%");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void I() {
        if (this.lastSucceedTime != 0 && System.currentTimeMillis() - this.lastSucceedTime <= 3000) {
            clearAnimation();
            dismiss();
            return;
        }
        t();
        this.isLoadCover = false;
        this.isShowAnima = false;
        TextView textView = this.ufv_tv_progress;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.ufv_tv_status;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.ufv_tv_status;
        if (textView3 != null) {
            textView3.setText(R$string.postint_state_posted);
        }
        if (this.sourceType == 1) {
            TextView textView4 = this.right_state;
            if (textView4 != null) {
                textView4.setText(BuildConfig.FLAVOR);
            }
        } else {
            TextView textView5 = this.right_state;
            if (textView5 != null) {
                textView5.setText(R.string.View);
                Unit unit = Unit.a;
            }
        }
        TextView textView6 = this.right_state;
        if (textView6 != null) {
            textView6.setTextColor(h.a(R$color.color_191F2B));
        }
        TextView textView7 = this.right_state;
        if (textView7 != null) {
            textView7.setBackgroundResource(com.transsion.baseui.R.drawable.bg_btn_01_radius_4);
        }
        v(false);
        getH().removeCallbacks(this.runnable);
        getH().removeCallbacks(this.allAnimaRunnable);
        getH().postDelayed(this.allAnimaRunnable, this.dismissTime);
        getH().postDelayed(new Runnable() { // from class: ro.s
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.J(UploadView.this);
            }
        }, this.dismissTime + 1000);
        this.lastSucceedTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void J(UploadView uploadView) {
        if (uploadView.getIsShow()) {
            uploadView.lastSucceedTime = 0L;
            uploadView.clearAnimation();
            uploadView.dismiss();
        }
    }

    private final void K(Integer progress) {
        s();
        a.a.f(a.a, w, "uploading:" + progress, false, 4, (Object) null);
        TextView textView = this.ufv_tv_progress;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.ufv_tv_status;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.ufv_tv_status;
        if (textView3 != null) {
            textView3.setText(R$string.postint_state_posted);
        }
        TextView textView4 = this.right_state;
        if (textView4 != null) {
            textView4.setText(R$string.postint_state_cancel);
        }
        String str = progress + "%";
        TextView textView5 = this.ufv_tv_progress;
        if (textView5 != null) {
            textView5.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(UploadView uploadView) {
        uploadView.w();
    }

    private final void s() {
        if (this.isShowAnima) {
            return;
        }
        getH().removeCallbacks(this.runnable);
        getH().postDelayed(this.runnable, 3000L);
        this.isShowAnima = true;
    }

    private final void t() {
    }

    private final void u() {
        l lVar = l.a;
        if (lVar.e()) {
            return;
        }
        lVar.l(this.netListener);
        getH().removeCallbacks(this.netRunnable);
        getH().postDelayed(this.netRunnable, 3600000L);
    }

    private final void v(boolean collapse) {
        if (collapse) {
            RelativeLayout relativeLayout = this.ufv_view2;
            if (relativeLayout == null || relativeLayout.getVisibility() != 8) {
                A();
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, A() ? 1.0f : -1.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(500L);
                RelativeLayout relativeLayout2 = this.ufv_view2;
                if (relativeLayout2 != null) {
                    relativeLayout2.startAnimation(translateAnimation);
                }
                RelativeLayout relativeLayout3 = this.ufv_view2;
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        RelativeLayout relativeLayout4 = this.ufv_view2;
        if (relativeLayout4 == null || relativeLayout4.getVisibility() != 0) {
            float f = A() ? 1.0f : -1.0f;
            A();
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setDuration(500L);
            RelativeLayout relativeLayout5 = this.ufv_view2;
            if (relativeLayout5 != null) {
                relativeLayout5.startAnimation(translateAnimation2);
            }
            RelativeLayout relativeLayout6 = this.ufv_view2;
            if (relativeLayout6 != null) {
                relativeLayout6.setVisibility(0);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        getLocationOnScreen(new int[2]);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -(r0[1] + getHeight()));
        translateAnimation.setDuration(700L);
        translateAnimation.setAnimationListener(new b());
        startAnimation(translateAnimation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(final Context context) {
        LayoutInflater.from(context).inflate(R$layout.upload_float_view, (ViewGroup) this);
        this.ufv_tv_status = (TextView) findViewById(R$id.ufv_tv_status);
        this.ufv_tv_progress = (TextView) findViewById(R$id.ufv_tv_progress);
        this.ufv_iv_retry = (ImageView) findViewById(R$id.ufv_iv_retry);
        this.right_state = (TextView) findViewById(R$id.right_state);
        this.ufv_view2 = (RelativeLayout) findViewById(R$id.ufv_view2);
        setLayoutParams(new ConstraintLayout.b(-1, -2));
        int c2 = d.c();
        if (c2 == 0) {
            ConstraintLayout.b layoutParams = getLayoutParams();
            if (layoutParams != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = a0.a(68.0f);
            }
        } else {
            ConstraintLayout.b layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = c2 + a0.a(48.0f);
            }
        }
        ConstraintLayout.b layoutParams3 = getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.setMarginStart(a0.a(16.0f));
        }
        ConstraintLayout.b layoutParams4 = getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.setMarginEnd(a0.a(16.0f));
        }
        ImageView imageView = this.ufv_iv_retry;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ro.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UploadView.y(view);
                }
            });
        }
        TextView textView = this.right_state;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: ro.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UploadView.z(UploadView.this, context, view);
                }
            });
        }
        TextView textView2 = this.ufv_tv_progress;
        if (textView2 != null) {
            textView2.setText(BuildConfig.FLAVOR);
        }
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void z(UploadView uploadView, Context context, View view) {
        com.transsion.baseui.util.c cVar = com.transsion.baseui.util.c.a;
        TextView textView = uploadView.right_state;
        if (cVar.a(textView != null ? textView.getId() : 0, 2000L)) {
            return;
        }
        TextView textView2 = uploadView.right_state;
        CharSequence text = textView2 != null ? textView2.getText() : null;
        if (TextUtils.equals(text, context.getString(R$string.postint_state_cancel))) {
            PublishManager.Companion.a().cancel();
            uploadView.w();
            a.a.f(a.a, w, "click cancel", false, 4, (Object) null);
        } else if (TextUtils.equals(text, context.getString(R$string.postint_state_retry))) {
            uploadView.E();
            uploadView.w();
            a.a.f(a.a, w, "click retry", false, 4, (Object) null);
        } else if (TextUtils.equals(text, context.getString(R.string.View))) {
            a.a.f(a.a, w, "click view now", false, 4, (Object) null);
            uploadView.lastSucceedTime = 0L;
            uploadView.clearAnimation();
            uploadView.dismiss();
            if (TextUtils.isEmpty(uploadView.postId)) {
                return;
            }
            Navigator.x(TheRouter.c("/post/detail").K("page_from", uploadView.pageName).K("id", uploadView.postId), context, (mf.c) null, 2, (Object) null);
        }
    }

    public Lifecycle getLifecycle() {
        w wVar = this.mLifecycleRegistry;
        Intrinsics.e(wVar);
        return wVar;
    }

    public final void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public final void showFloatView(PublishResult eventBean) {
        this.eventBean = eventBean;
        Integer valueOf = eventBean != null ? Integer.valueOf(eventBean.getState()) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            G();
            return;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            this.postId = eventBean.getPostId();
            this.sourceType = eventBean.getSource();
            I();
        } else if (valueOf != null && valueOf.intValue() == 0) {
            this.postId = BuildConfig.FLAVOR;
            H();
        } else if (valueOf != null && valueOf.intValue() == 3) {
            K(Integer.valueOf(eventBean.getProgress()));
        } else if (valueOf != null && valueOf.intValue() == 4) {
            this.postId = BuildConfig.FLAVOR;
            dismiss();
        }
    }
}
