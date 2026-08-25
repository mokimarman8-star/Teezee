package com.transsion.moviedetail.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$mipmap;
import com.transsion.moviedetail.view.MovieDetailShareView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00168\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/transsion/moviedetail/view/MovieDetailShareView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/lifecycle/u;", "lifecycleOwner", BuildConfig.FLAVOR, "init", "(Landroidx/lifecycle/u;)V", "res", "setImageResource", "(I)V", "onDetachedFromWindow", "()V", BuildConfig.FLAVOR, "a", "J", "showTime", "b", "MAX_SHOW_TIME", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "imageView", "d", "whatsAppImageview", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "showWhatAppIconRunnable", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MovieDetailShareView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private long showTime;

    /* renamed from: b, reason: from kotlin metadata */
    private final long MAX_SHOW_TIME;

    /* renamed from: c, reason: from kotlin metadata */
    private final ImageView imageView;

    /* renamed from: d, reason: from kotlin metadata */
    private ImageView whatsAppImageview;

    /* renamed from: e, reason: from kotlin metadata */
    private final Function0 showWhatAppIconRunnable;

    public static final class a implements androidx.lifecycle.f {
        private long a;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function0 function0) {
            function0.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Function0 function0) {
            function0.invoke();
        }

        public /* synthetic */ void onCreate(androidx.lifecycle.u uVar) {
            androidx.lifecycle.e.a(this, uVar);
        }

        public /* synthetic */ void onDestroy(androidx.lifecycle.u uVar) {
            androidx.lifecycle.e.b(this, uVar);
        }

        public void onPause(androidx.lifecycle.u uVar) {
            Intrinsics.h(uVar, "owner");
            androidx.lifecycle.e.c(this, uVar);
            MovieDetailShareView.this.showTime += SystemClock.elapsedRealtime() - this.a;
            MovieDetailShareView movieDetailShareView = MovieDetailShareView.this;
            final Function0 function0 = movieDetailShareView.showWhatAppIconRunnable;
            movieDetailShareView.removeCallbacks(new Runnable() { // from class: com.transsion.moviedetail.view.s
                @Override // java.lang.Runnable
                public final void run() {
                    MovieDetailShareView.a.c(function0);
                }
            });
        }

        public void onResume(androidx.lifecycle.u uVar) {
            Intrinsics.h(uVar, "owner");
            androidx.lifecycle.e.d(this, uVar);
            this.a = SystemClock.elapsedRealtime();
            if (MovieDetailShareView.this.showTime < MovieDetailShareView.this.MAX_SHOW_TIME) {
                MovieDetailShareView movieDetailShareView = MovieDetailShareView.this;
                final Function0 function0 = movieDetailShareView.showWhatAppIconRunnable;
                movieDetailShareView.postDelayed(new Runnable() { // from class: com.transsion.moviedetail.view.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        MovieDetailShareView.a.d(function0);
                    }
                }, MovieDetailShareView.this.MAX_SHOW_TIME - MovieDetailShareView.this.showTime);
            }
        }

        public /* synthetic */ void onStart(androidx.lifecycle.u uVar) {
            androidx.lifecycle.e.e(this, uVar);
        }

        public /* synthetic */ void onStop(androidx.lifecycle.u uVar) {
            androidx.lifecycle.e.f(this, uVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MovieDetailShareView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MovieDetailShareView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieDetailShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        Intrinsics.h(context, "context");
        this.MAX_SHOW_TIME = 20000L;
        this.imageView = new ImageView(getContext());
        this.showWhatAppIconRunnable = new Function0() { // from class: com.transsion.moviedetail.view.p
            public final Object invoke() {
                Unit e;
                e = MovieDetailShareView.e(MovieDetailShareView.this);
                return e;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(final MovieDetailShareView movieDetailShareView) {
        if (movieDetailShareView.whatsAppImageview == null) {
            ImageView imageView = new ImageView(movieDetailShareView.getContext());
            imageView.setAlpha(0.0f);
            imageView.setScaleX(0.0f);
            imageView.setScaleY(0.0f);
            imageView.setImageResource(R$mipmap.movie_detail_icon_whatapp);
            movieDetailShareView.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            movieDetailShareView.whatsAppImageview = imageView;
        }
        ViewPropertyAnimator animate = movieDetailShareView.imageView.animate();
        animate.setDuration(240L);
        animate.scaleX(1.1f);
        animate.scaleY(1.1f);
        animate.withEndAction(new Runnable() { // from class: com.transsion.moviedetail.view.r
            @Override // java.lang.Runnable
            public final void run() {
                MovieDetailShareView.f(MovieDetailShareView.this);
            }
        }).start();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MovieDetailShareView movieDetailShareView) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator animate2 = movieDetailShareView.imageView.animate();
        animate2.setDuration(240L);
        animate2.scaleX(0.0f);
        animate2.scaleY(0.0f);
        animate2.alpha(0.0f);
        animate2.start();
        ImageView imageView = movieDetailShareView.whatsAppImageview;
        if (imageView == null || (animate = imageView.animate()) == null) {
            return;
        }
        animate.setDuration(240L);
        animate.scaleX(1.0f);
        animate.scaleY(1.0f);
        animate.alpha(1.0f);
        animate.start();
    }

    public final void init(androidx.lifecycle.u lifecycleOwner) {
        Intrinsics.h(lifecycleOwner, "lifecycleOwner");
        if (ij.y.a.a()) {
            this.imageView.setImageResource(R$mipmap.movie_share_night);
        } else {
            this.imageView.setImageResource(R$mipmap.movie_share_light);
        }
        addView(this.imageView, new FrameLayout.LayoutParams(-1, -1));
        lifecycleOwner.getLifecycle().a(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewPropertyAnimator animate;
        super.onDetachedFromWindow();
        this.imageView.animate().cancel();
        ImageView imageView = this.whatsAppImageview;
        if (imageView != null && (animate = imageView.animate()) != null) {
            animate.cancel();
        }
        final Function0 function0 = this.showWhatAppIconRunnable;
        removeCallbacks(new Runnable() { // from class: com.transsion.moviedetail.view.q
            @Override // java.lang.Runnable
            public final void run() {
                MovieDetailShareView.d(function0);
            }
        });
    }

    public final void setImageResource(int res) {
        this.imageView.setImageResource(res);
    }
}
