package com.transsion.baseui.music;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import com.blankj.utilcode.util.a0;
import com.therouter.TheRouter;
import com.transsion.baseui.R;
import com.transsion.baseui.R$anim;
import com.transsion.baseui.activity.BaseMusicFloatActivity;
import com.transsion.baseui.music.MusicFloatManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.mediasession.MediaItem;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u000f¢\u0006\u0004\b!\u0010\u0011R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u0006:"}, d2 = {"Lcom/transsion/baseui/music/MusicFloatView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "getClassTag", "()Ljava/lang/String;", BuildConfig.FLAVOR, "l", "()V", "k", "Lcom/transsion/player/mediasession/MediaItem;", "mediaItem", "t", "(Lcom/transsion/player/mediasession/MediaItem;)V", "w", "Landroid/view/View;", "view", "z", "(Landroid/view/View;)V", "y", BuildConfig.FLAVOR, "isExpand", "setExpand", "(Z)V", "refresh", "Ljj/f;", "a", "Ljj/f;", "binding", "b", "Ljava/lang/String;", "lastCoverUrl", "Ljava/lang/Runnable;", "c", "Ljava/lang/Runnable;", "refreshTimedTask", "Landroid/os/Handler;", "d", "Lkotlin/Lazy;", "getMHandler", "()Landroid/os/Handler;", "mHandler", BuildConfig.FLAVOR, "e", "J", "progress", "f", "I", "count", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MusicFloatView extends FrameLayout {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private final jj.f binding;

    /* renamed from: b, reason: from kotlin metadata */
    private String lastCoverUrl;

    /* renamed from: c, reason: from kotlin metadata */
    private final Runnable refreshTimedTask;

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy mHandler;

    /* renamed from: e, reason: from kotlin metadata */
    private long progress;

    /* renamed from: f, reason: from kotlin metadata */
    private int count;

    public static final class a implements androidx.lifecycle.f {
        a() {
        }

        public /* synthetic */ void onCreate(u uVar) {
            androidx.lifecycle.e.a(this, uVar);
        }

        public void onDestroy(u uVar) {
            Intrinsics.h(uVar, "owner");
            androidx.lifecycle.e.b(this, uVar);
            uVar.getLifecycle().d(this);
            MusicFloatView.this.getMHandler().removeCallbacksAndMessages(null);
        }

        public void onPause(u uVar) {
            Intrinsics.h(uVar, "owner");
            androidx.lifecycle.e.c(this, uVar);
            MusicFloatView.this.getMHandler().removeCallbacks(MusicFloatView.this.refreshTimedTask);
        }

        public void onResume(u uVar) {
            Intrinsics.h(uVar, "owner");
            androidx.lifecycle.e.d(this, uVar);
            MusicFloatView.this.refresh();
        }

        public /* synthetic */ void onStart(u uVar) {
            androidx.lifecycle.e.e(this, uVar);
        }

        public /* synthetic */ void onStop(u uVar) {
            androidx.lifecycle.e.f(this, uVar);
        }
    }

    public static final class b implements Animation.AnimationListener {
        final /* synthetic */ View a;
        final /* synthetic */ MusicFloatView b;

        b(View view, MusicFloatView musicFloatView) {
            this.a = view;
            this.b = musicFloatView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.setVisibility(8);
            ConstraintLayout constraintLayout = this.b.binding.h;
            Intrinsics.g(constraintLayout, "roundFold");
            uf.c.k(constraintLayout);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MusicFloatView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MusicFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.lastCoverUrl = BuildConfig.FLAVOR;
        this.refreshTimedTask = new Runnable() { // from class: com.transsion.baseui.music.d
            @Override // java.lang.Runnable
            public final void run() {
                MusicFloatView.v(MusicFloatView.this);
            }
        };
        this.mHandler = LazyKt.b(new Function0() { // from class: com.transsion.baseui.music.e
            public final Object invoke() {
                Handler u;
                u = MusicFloatView.u();
                return u;
            }
        });
        jj.f a2 = jj.f.a(LayoutInflater.from(getContext()).inflate(R.layout.music_float_layout, (ViewGroup) this, true));
        Intrinsics.g(a2, "bind(...)");
        this.binding = a2;
        setExpand(MusicFloatManager.h.b().v());
        l();
        k();
        w();
    }

    private final String getClassTag() {
        String simpleName = MusicFloatView.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    private final void k() {
        Lifecycle lifecycle;
        AppCompatActivity context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? context : null;
        if (appCompatActivity == null || (lifecycle = appCompatActivity.getLifecycle()) == null) {
            return;
        }
        lifecycle.a(new a());
    }

    private final void l() {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        ConstraintLayout constraintLayout;
        this.binding.h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.baseui.music.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MusicFloatView.m(MusicFloatView.this, view);
            }
        });
        jj.f fVar = this.binding;
        if (fVar != null && (constraintLayout = fVar.g) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.baseui.music.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MusicFloatView.n(view);
                }
            });
        }
        jj.f fVar2 = this.binding;
        if (fVar2 != null && (appCompatImageView2 = fVar2.b) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.baseui.music.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MusicFloatView.o(MusicFloatView.this, view);
                }
            });
        }
        jj.f fVar3 = this.binding;
        if (fVar3 == null || (appCompatImageView = fVar3.e) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.baseui.music.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MusicFloatView.q(MusicFloatView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MusicFloatView musicFloatView, View view) {
        musicFloatView.setExpand(true);
        musicFloatView.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(View view) {
        Intent clickIntent;
        MediaItem q = MusicFloatManager.h.b().q();
        if (q == null || (clickIntent = q.getClickIntent()) == null) {
            return;
        }
        clickIntent.addFlags(268435456);
        String stringExtra = clickIntent.getStringExtra("path");
        String stringExtra2 = clickIntent.getStringExtra("id");
        String stringExtra3 = clickIntent.getStringExtra("resource_id");
        String stringExtra4 = clickIntent.getStringExtra("collection_id");
        String stringExtra5 = clickIntent.getStringExtra("extra_local_path");
        boolean booleanExtra = clickIntent.getBooleanExtra("isMusicLikedFragment", false);
        Log.e("m_d_log", "initListener -->  path = " + stringExtra + " -- id = " + stringExtra2 + " -- isMusicLikedFragment = " + booleanExtra);
        ij.k.p(TheRouter.c(stringExtra).K("id", stringExtra2).z("is_music_liked_fragment", booleanExtra).K("resource_id", stringExtra3).K("extra_local_path", stringExtra5).K("collection_id", stringExtra4).z("isMusicFloatViewClick", true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final MusicFloatView musicFloatView, View view) {
        MusicFloatManager.a aVar = MusicFloatManager.h;
        com.transsion.player.orplayer.f s = aVar.b().s();
        if (s != null) {
            s.pause();
        }
        aVar.b().B(null);
        musicFloatView.setVisibility(8);
        musicFloatView.lastCoverUrl = BuildConfig.FLAVOR;
        musicFloatView.post(new Runnable() { // from class: com.transsion.baseui.music.l
            @Override // java.lang.Runnable
            public final void run() {
                MusicFloatView.p(MusicFloatView.this);
            }
        });
        com.transsion.player.mediasession.h.a.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(MusicFloatView musicFloatView) {
        Object context = musicFloatView.getContext();
        BaseMusicFloatActivity baseMusicFloatActivity = context instanceof BaseMusicFloatActivity ? (BaseMusicFloatActivity) context : null;
        if (baseMusicFloatActivity != null) {
            baseMusicFloatActivity.onCloseMusicFloating();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final MusicFloatView musicFloatView, View view) {
        com.transsion.baseui.util.d.b(0L, new Function0() { // from class: com.transsion.baseui.music.k
            public final Object invoke() {
                Unit r;
                r = MusicFloatView.r(MusicFloatView.this);
                return r;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(final MusicFloatView musicFloatView) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        musicFloatView.w();
        com.transsion.player.orplayer.f s = MusicFloatManager.h.b().s();
        if (s == null || !s.isPlaying()) {
            jj.f fVar = musicFloatView.binding;
            if (fVar != null && (appCompatImageView = fVar.e) != null) {
                appCompatImageView.setImageResource(R.drawable.music_float_play);
            }
            if (s != null && s.isComplete()) {
                s.seekTo(0L);
            }
            if (s != null) {
                s.play();
            }
        } else {
            jj.f fVar2 = musicFloatView.binding;
            if (fVar2 != null && (appCompatImageView2 = fVar2.e) != null) {
                appCompatImageView2.setImageResource(R.drawable.music_float_pause);
            }
            s.pause();
        }
        musicFloatView.postDelayed(new Runnable() { // from class: com.transsion.baseui.music.m
            @Override // java.lang.Runnable
            public final void run() {
                MusicFloatView.s(MusicFloatView.this);
            }
        }, 200L);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MusicFloatView musicFloatView) {
        musicFloatView.refresh();
    }

    private final void t(MediaItem mediaItem) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        jj.f fVar;
        AppCompatTextView appCompatTextView;
        Long position = mediaItem.getPosition();
        long longValue = position != null ? position.longValue() : 0L;
        if (longValue != this.progress) {
            this.progress = longValue;
            this.count = 0;
        } else {
            this.count++;
        }
        if (!TextUtils.isEmpty(mediaItem.getTitle()) && (fVar = this.binding) != null && (appCompatTextView = fVar.j) != null) {
            appCompatTextView.setText(mediaItem.getTitle());
        }
        Long duration = mediaItem.getDuration();
        long longValue2 = duration != null ? duration.longValue() : 0L;
        Long position2 = mediaItem.getPosition();
        long longValue3 = position2 != null ? position2.longValue() : 0L;
        if (longValue2 > 0) {
            this.binding.f.setProgress((int) ((longValue3 * 10000.0f) / longValue2));
        }
        if (!TextUtils.equals(this.lastCoverUrl, mediaItem.getCoverUrl())) {
            this.lastCoverUrl = mediaItem.getCoverUrl();
            ImageView imageView = this.binding.c;
            f.a aVar = ni.f.a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            String coverUrl = mediaItem.getCoverUrl();
            if (coverUrl == null) {
                coverUrl = BuildConfig.FLAVOR;
            }
            f.b m2 = m.g(coverUrl).m(a0.a(44.0f));
            Intrinsics.e(imageView);
            m2.d(imageView);
        }
        com.transsion.player.orplayer.f s = MusicFloatManager.h.b().s();
        if (s == null || !s.isPlaying()) {
            jj.f fVar2 = this.binding;
            if (fVar2 != null && (appCompatImageView = fVar2.e) != null) {
                appCompatImageView.setImageResource(R.drawable.music_float_pause);
            }
        } else {
            jj.f fVar3 = this.binding;
            if (fVar3 != null && (appCompatImageView2 = fVar3.e) != null) {
                appCompatImageView2.setImageResource(R.drawable.music_float_play);
            }
        }
        getMHandler().removeCallbacks(this.refreshTimedTask);
        getMHandler().postDelayed(this.refreshTimedTask, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler u() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(MusicFloatView musicFloatView) {
        musicFloatView.refresh();
    }

    private final void w() {
        getMHandler().removeCallbacksAndMessages(null);
        getMHandler().postDelayed(new Runnable() { // from class: com.transsion.baseui.music.j
            @Override // java.lang.Runnable
            public final void run() {
                MusicFloatView.x(MusicFloatView.this);
            }
        }, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(MusicFloatView musicFloatView) {
        musicFloatView.setExpand(false);
    }

    private final void y(View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.music_slide_left);
        loadAnimation.setAnimationListener(new b(view, this));
        view.startAnimation(loadAnimation);
    }

    private final void z(View view) {
        view.setVisibility(0);
        ConstraintLayout constraintLayout = this.binding.h;
        Intrinsics.g(constraintLayout, "roundFold");
        uf.c.g(constraintLayout);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.music_slide_right);
        loadAnimation.setAnimationListener(new c());
        view.startAnimation(loadAnimation);
    }

    public final void refresh() {
        MediaItem q = MusicFloatManager.h.b().q();
        if (q == null) {
            com.transsion.player.mediasession.i.a.a(getClassTag() + " --> refresh() --> musicFloatBean == null --> 没有数据不展示UI");
            setVisibility(8);
            return;
        }
        if (!Intrinsics.c(q.isMusic(), Boolean.FALSE)) {
            q.setPageName("music_float");
            setVisibility(0);
            t(q);
            return;
        }
        com.transsion.player.mediasession.i.a.a(getClassTag() + " --> refresh() --> musicFloatBean.isMusic == false --> 当前不是Music类型，不展示悬浮窗");
        setVisibility(8);
    }

    public final void setExpand(boolean isExpand) {
        MusicFloatManager.h.b().A(isExpand);
        if (isExpand) {
            ConstraintLayout constraintLayout = this.binding.g;
            Intrinsics.g(constraintLayout, "roundExpand");
            z(constraintLayout);
        } else {
            ConstraintLayout constraintLayout2 = this.binding.g;
            Intrinsics.g(constraintLayout2, "roundExpand");
            y(constraintLayout2);
        }
    }
}
