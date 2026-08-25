package com.transsion.moviedetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$layout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lm.z;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/transsion/moviedetail/view/WatchModeTipsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "n", "()V", "checkShow", "onDetachedFromWindow", "Llm/z;", "a", "Llm/z;", "mViewBinding", BuildConfig.FLAVOR, "b", "Z", "hasShow", "Ljava/lang/Runnable;", "c", "Lkotlin/Lazy;", "getDelayShow", "()Ljava/lang/Runnable;", "delayShow", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class WatchModeTipsView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private z mViewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean hasShow;

    /* renamed from: c, reason: from kotlin metadata */
    private final Lazy delayShow;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WatchModeTipsView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WatchModeTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchModeTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.hasShow = com.transsion.baselib.report.launch.b.a.b().getBoolean("watch_mode_tips", false);
        n();
        this.delayShow = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.view.v
            public final Object invoke() {
                Runnable l;
                l = WatchModeTipsView.l(WatchModeTipsView.this);
                return l;
            }
        });
    }

    private final Runnable getDelayShow() {
        return (Runnable) this.delayShow.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Runnable l(final WatchModeTipsView watchModeTipsView) {
        return new Runnable() { // from class: com.transsion.moviedetail.view.y
            @Override // java.lang.Runnable
            public final void run() {
                WatchModeTipsView.m(WatchModeTipsView.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(WatchModeTipsView watchModeTipsView) {
        uf.c.k(watchModeTipsView);
        com.transsion.baselib.report.launch.b.a.b().putBoolean("watch_mode_tips", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        z a = z.a(View.inflate(getContext(), R$layout.layout_watch_mode_tips, this));
        this.mViewBinding = a;
        if (a != null) {
            AppCompatTextView appCompatTextView = a.c;
            Intrinsics.g(appCompatTextView, "goWatchTv");
            uf.c.c(appCompatTextView, 0L, new Function1() { // from class: com.transsion.moviedetail.view.w
                public final Object invoke(Object obj) {
                    Unit o;
                    o = WatchModeTipsView.o(WatchModeTipsView.this, (View) obj);
                    return o;
                }
            }, 1, (Object) null);
            ImageView imageView = a.b;
            Intrinsics.g(imageView, "closeWatchTv");
            uf.c.c(imageView, 0L, new Function1() { // from class: com.transsion.moviedetail.view.x
                public final Object invoke(Object obj) {
                    Unit p;
                    p = WatchModeTipsView.p(WatchModeTipsView.this, (View) obj);
                    return p;
                }
            }, 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit o(WatchModeTipsView watchModeTipsView, View view) {
        Intrinsics.h(view, "it");
        Navigator.x(TheRouter.c("/profile/watch_option"), watchModeTipsView.getContext(), (mf.c) null, 2, (Object) null);
        uf.c.g(watchModeTipsView);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit p(WatchModeTipsView watchModeTipsView, View view) {
        Intrinsics.h(view, "it");
        uf.c.g(watchModeTipsView);
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void checkShow() {
        if (this.hasShow || ij.t.a.b()) {
            uf.c.g(this);
        } else {
            removeCallbacks(getDelayShow());
            post(getDelayShow());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        removeCallbacks(getDelayShow());
    }
}
