package com.transsion.postdetail.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.video.PostFeedVideoView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wn.o0;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ0\u0010#\u001a\u00020\r2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\r0\u001e¢\u0006\u0004\b#\u0010$J\u001b\u0010&\u001a\u00020\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0%¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\r¢\u0006\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R3\u00104\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u00107\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/transsion/postdetail/video/PostFeedVideoView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "progress", BuildConfig.FLAVOR, "setCountdown", "(I)V", "max", "setProgressMax", "setProgress", "Landroid/view/SurfaceView;", "getSurfaceView", "()Landroid/view/SurfaceView;", BuildConfig.FLAVOR, "duration", "setDurationTime", "(J)V", BuildConfig.FLAVOR, "mute", "updateMute", "(Z)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isMute", "callback", "setMuteClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setRemovePlayerCallback", "(Lkotlin/jvm/functions/Function0;)V", "removePlayer", "()V", "Lwn/o0;", "a", "Lwn/o0;", "viewBinding", "Lcom/transsion/player/ui/ORPlayerView;", "b", "Lcom/transsion/player/ui/ORPlayerView;", "orPlayerView", "c", "Lkotlin/jvm/functions/Function1;", "muteClickCallback", "d", "Lkotlin/jvm/functions/Function0;", "removePlayerCallback", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostFeedVideoView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final o0 viewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private final ORPlayerView orPlayerView;

    /* renamed from: c, reason: from kotlin metadata */
    private Function1 muteClickCallback;

    /* renamed from: d, reason: from kotlin metadata */
    private Function0 removePlayerCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFeedVideoView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        View.inflate(getContext(), R$layout.view_post_feed_video, this);
        o0 a = o0.a(this);
        Intrinsics.g(a, "bind(...)");
        this.viewBinding = a;
        Context context2 = getContext();
        Intrinsics.g(context2, "getContext(...)");
        ORPlayerView oRPlayerView = new ORPlayerView(context2);
        this.orPlayerView = oRPlayerView;
        addView(oRPlayerView, 0, new FrameLayout.LayoutParams(-1, -1));
        a.e.setOnClickListener(new View.OnClickListener() { // from class: ho.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostFeedVideoView.b(PostFeedVideoView.this, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFeedVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        View.inflate(getContext(), R$layout.view_post_feed_video, this);
        o0 a = o0.a(this);
        Intrinsics.g(a, "bind(...)");
        this.viewBinding = a;
        Context context2 = getContext();
        Intrinsics.g(context2, "getContext(...)");
        ORPlayerView oRPlayerView = new ORPlayerView(context2);
        this.orPlayerView = oRPlayerView;
        addView(oRPlayerView, 0, new FrameLayout.LayoutParams(-1, -1));
        a.e.setOnClickListener(new View.OnClickListener() { // from class: ho.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostFeedVideoView.b(PostFeedVideoView.this, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFeedVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        View.inflate(getContext(), R$layout.view_post_feed_video, this);
        o0 a = o0.a(this);
        Intrinsics.g(a, "bind(...)");
        this.viewBinding = a;
        Context context2 = getContext();
        Intrinsics.g(context2, "getContext(...)");
        ORPlayerView oRPlayerView = new ORPlayerView(context2);
        this.orPlayerView = oRPlayerView;
        addView(oRPlayerView, 0, new FrameLayout.LayoutParams(-1, -1));
        a.e.setOnClickListener(new View.OnClickListener() { // from class: ho.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostFeedVideoView.b(PostFeedVideoView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PostFeedVideoView postFeedVideoView, View view) {
        boolean isSelected = postFeedVideoView.viewBinding.b.isSelected();
        postFeedVideoView.viewBinding.b.setSelected(!isSelected);
        Function1 function1 = postFeedVideoView.muteClickCallback;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(isSelected));
        }
    }

    private final void setCountdown(int progress) {
        int max = this.viewBinding.c.getMax() - progress;
        if (max > 0) {
            this.viewBinding.d.setText(TimeUtilKt.h(max));
        }
    }

    public final SurfaceView getSurfaceView() {
        return this.orPlayerView.getSurface();
    }

    public final void removePlayer() {
        Function0 function0 = this.removePlayerCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setDurationTime(long duration) {
        this.viewBinding.d.setText(TimeUtilKt.h(duration));
    }

    public final void setMuteClickCallback(Function1<? super Boolean, Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.muteClickCallback = callback;
    }

    public final void setProgress(int progress) {
        this.viewBinding.c.setProgress(progress);
        setCountdown(progress);
    }

    public final void setProgressMax(int max) {
        this.viewBinding.c.setMax(max);
    }

    public final void setRemovePlayerCallback(Function0<Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.removePlayerCallback = callback;
    }

    public final void updateMute(boolean mute) {
        this.viewBinding.b.setSelected(!mute);
    }
}
