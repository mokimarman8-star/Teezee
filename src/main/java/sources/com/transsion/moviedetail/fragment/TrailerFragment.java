package com.transsion.moviedetail.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.therouter.TheRouter;
import com.tn.lib.util.networkinfo.NetworkType;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.flow.bean.PreVideoAddress;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$drawable;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ni.f;
import wf.a;
import yg.m;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u0083\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001IB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u0006J\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010\u0006J\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u0006J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J!\u0010)\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0007H\u0016¢\u0006\u0004\b+\u0010\u0006J\u0019\u0010.\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00100\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b0\u0010/J\u0019\u00101\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b1\u0010/J\u0019\u00102\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b2\u0010/J!\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b4\u00105J\u0019\u00106\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b6\u0010/J\u000f\u00107\u001a\u00020\u0007H\u0016¢\u0006\u0004\b7\u0010\u0006J!\u00108\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b8\u00105J\u000f\u00109\u001a\u00020\u0007H\u0016¢\u0006\u0004\b9\u0010\u0006J\u000f\u0010:\u001a\u00020\u0007H\u0016¢\u0006\u0004\b:\u0010\u0006J\u000f\u0010;\u001a\u00020\u0007H\u0016¢\u0006\u0004\b;\u0010\u0006J!\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0007H\u0016¢\u0006\u0004\b@\u0010\u0006J\u001f\u0010E\u001a\u00020\u00072\u0006\u0010B\u001a\u00020A2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0007H\u0016¢\u0006\u0004\bG\u0010\u0006R\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010QR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082D¢\u0006\u0006\n\u0004\b[\u0010\\R\u001d\u0010c\u001a\u0004\u0018\u00010^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u001b\u0010h\u001a\u00020d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010`\u001a\u0004\bf\u0010gR\u001b\u0010m\u001a\u00020i8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010`\u001a\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010MR\u0016\u0010q\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010MR\u001c\u0010u\u001a\b\u0012\u0004\u0012\u00020Z0r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010TR\u0014\u0010{\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0016\u0010\u0082\u0001\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010z¨\u0006\u0084\u0001"}, d2 = {"Lcom/transsion/moviedetail/fragment/TrailerFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Llm/u;", "Lcom/transsion/player/orplayer/e;", "Lyg/m;", "<init>", "()V", BuildConfig.FLAVOR, "z0", "x0", "y0", "r0", "Lcom/transsion/moviedetailapi/bean/Trailer;", "trailer", "B0", "(Lcom/transsion/moviedetailapi/bean/Trailer;)V", "Lcom/transsion/moviedetailapi/bean/Cover;", "cover", "D0", "(Lcom/transsion/moviedetailapi/bean/Cover;)V", "t0", BuildConfig.FLAVOR, "type", "F0", "(I)V", "A0", BuildConfig.FLAVOR, "delay", "G0", "(J)V", "I0", "n0", "C0", "Landroid/view/LayoutInflater;", "inflater", "q0", "(Landroid/view/LayoutInflater;)Llm/u;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "Lgn/e;", "mediaSource", "onCompletion", "(Lgn/e;)V", "onVideoStart", "onVideoPause", "onLoadingBegin", "progress", "onBufferedPosition", "(JLgn/e;)V", "onLoadingEnd", "onRenderFirstFrame", "onProgress", "onPause", "onResume", "onDestroy", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lgn/e;)V", "onDisconnected", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "onStart", "Lcom/transsion/moviedetailapi/bean/PreVideoAddress;", "a", "Lcom/transsion/moviedetailapi/bean/PreVideoAddress;", "videoAddress", "b", "J", "duration", BuildConfig.FLAVOR, "c", "Z", "formUserSeek", "d", "I", "playState", "e", "isShowFirstFrame", "f", "Lcom/transsion/moviedetailapi/bean/Trailer;", BuildConfig.FLAVOR, "g", "Ljava/lang/String;", "TAG", "Lep/a;", "h", "Lkotlin/Lazy;", "getMAudioApi", "()Lep/a;", "mAudioApi", "Landroid/os/Handler;", "i", "o0", "()Landroid/os/Handler;", "loadingHandler", "Lcom/transsion/player/orplayer/f;", "j", "p0", "()Lcom/transsion/player/orplayer/f;", "mOrPlayer", "k", "bufferPosition", "l", "currentPosition", BuildConfig.FLAVOR, "m", "[Ljava/lang/String;", "loadingDot", "n", "loadingDotIndex", "Ljava/lang/Runnable;", "o", "Ljava/lang/Runnable;", "loadingRunnable", "p", "Lcom/transsion/player/orplayer/PlayError;", "q", "Landroid/view/View;", "errorLayout", "r", "showErrorRunnable", "s", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TrailerFragment extends BaseFragment<lm.u> implements com.transsion.player.orplayer.e, yg.m {

    /* renamed from: a, reason: from kotlin metadata */
    private PreVideoAddress videoAddress;

    /* renamed from: b, reason: from kotlin metadata */
    private long duration;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean formUserSeek;

    /* renamed from: d, reason: from kotlin metadata */
    private int playState;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isShowFirstFrame;

    /* renamed from: f, reason: from kotlin metadata */
    private Trailer trailer;

    /* renamed from: k, reason: from kotlin metadata */
    private long bufferPosition;

    /* renamed from: l, reason: from kotlin metadata */
    private long currentPosition;

    /* renamed from: n, reason: from kotlin metadata */
    private int loadingDotIndex;

    /* renamed from: p, reason: from kotlin metadata */
    private PlayError errorInfo;

    /* renamed from: q, reason: from kotlin metadata */
    private View errorLayout;

    /* renamed from: g, reason: from kotlin metadata */
    private final String TAG = "TrailerFragment";

    /* renamed from: h, reason: from kotlin metadata */
    private final Lazy mAudioApi = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.fragment.u2
        public final Object invoke() {
            ep.a mAudioApi_delegate$lambda$0;
            mAudioApi_delegate$lambda$0 = TrailerFragment.mAudioApi_delegate$lambda$0();
            return mAudioApi_delegate$lambda$0;
        }
    });

    /* renamed from: i, reason: from kotlin metadata */
    private final Lazy loadingHandler = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.fragment.v2
        public final Object invoke() {
            Handler u0;
            u0 = TrailerFragment.u0();
            return u0;
        }
    });

    /* renamed from: j, reason: from kotlin metadata */
    private final Lazy mOrPlayer = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.fragment.w2
        public final Object invoke() {
            com.transsion.player.orplayer.f w0;
            w0 = TrailerFragment.w0(TrailerFragment.this);
            return w0;
        }
    });

    /* renamed from: m, reason: from kotlin metadata */
    private String[] loadingDot = {".", "..", "..."};

    /* renamed from: o, reason: from kotlin metadata */
    private final Runnable loadingRunnable = new Runnable() { // from class: com.transsion.moviedetail.fragment.x2
        @Override // java.lang.Runnable
        public final void run() {
            TrailerFragment.v0(TrailerFragment.this);
        }
    };

    /* renamed from: r, reason: from kotlin metadata */
    private final Runnable showErrorRunnable = new Runnable() { // from class: com.transsion.moviedetail.fragment.y2
        @Override // java.lang.Runnable
        public final void run() {
            TrailerFragment.H0(TrailerFragment.this);
        }
    };

    public static final class b implements com.tn.lib.view.s {
        private long a;

        b() {
        }

        public void a(SecondariesSeekBar secondariesSeekBar) {
            Intrinsics.h(secondariesSeekBar, "seekBar");
            TrailerFragment.this.formUserSeek = false;
            TrailerFragment.this.p0().seekTo((this.a * TrailerFragment.this.duration) / 100);
            if (TrailerFragment.this.p0().isPlaying()) {
                return;
            }
            TrailerFragment.this.p0().play();
        }

        public void b(SecondariesSeekBar secondariesSeekBar, long j, boolean z) {
            Intrinsics.h(secondariesSeekBar, "seekBar");
            if (z) {
                this.a = j;
            }
        }

        public void c(SecondariesSeekBar secondariesSeekBar) {
            Intrinsics.h(secondariesSeekBar, "seekBar");
            TrailerFragment.this.formUserSeek = true;
        }
    }

    public static final class c implements View.OnClickListener {
        private long a;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TrailerFragment.this.playState != 10) {
                TrailerFragment.this.z0();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.a;
            if (j == 0 || currentTimeMillis - j > 500) {
                this.a = currentTimeMillis;
            } else {
                this.a = 0L;
                TrailerFragment.this.x0();
            }
        }
    }

    private final void A0() {
        a.a.f(wf.a.a, this.TAG, "video error，reload~~", false, 4, (Object) null);
        this.bufferPosition = 0L;
        p0().stop();
        p0().reset();
        p0().prepare();
        p0().seekTo(this.currentPosition);
        I0();
    }

    private final void B0(Trailer trailer) {
        String url;
        TextView textView;
        Integer duration;
        SecondariesSeekBar secondariesSeekBar;
        D0(trailer.getCover());
        this.videoAddress = trailer.getVideoAddress();
        lm.u uVar = (lm.u) getMViewBinding();
        if (uVar != null && (secondariesSeekBar = uVar.l) != null) {
            secondariesSeekBar.setMax(100L);
        }
        PreVideoAddress preVideoAddress = this.videoAddress;
        long intValue = (preVideoAddress == null || (duration = preVideoAddress.getDuration()) == null) ? 0L : duration.intValue() * 1000;
        this.duration = intValue;
        if (intValue > 0) {
            String str = "00:00/" + com.transsion.postdetail.util.m.d(intValue);
            lm.u uVar2 = (lm.u) getMViewBinding();
            if (uVar2 != null && (textView = uVar2.m) != null) {
                textView.setText(str);
            }
        }
        PreVideoAddress preVideoAddress2 = this.videoAddress;
        if (preVideoAddress2 == null || (url = preVideoAddress2.getUrl()) == null) {
            return;
        }
        p0().setDataSource(new gn.e(url, url, 0, null, null, 28, null));
    }

    private final void C0() {
        ShapeableImageView shapeableImageView;
        ShapeableImageView shapeableImageView2;
        lm.u uVar = (lm.u) getMViewBinding();
        if (uVar != null && (shapeableImageView2 = uVar.e) != null) {
            uf.c.k(shapeableImageView2);
        }
        lm.u uVar2 = (lm.u) getMViewBinding();
        if (uVar2 == null || (shapeableImageView = uVar2.d) == null) {
            return;
        }
        uf.c.k(shapeableImageView);
    }

    private final void D0(Cover cover) {
        final lm.u uVar;
        if (cover == null || (uVar = (lm.u) getMViewBinding()) == null) {
            return;
        }
        int f = com.transsion.core.utils.e.f();
        f.a aVar = ni.f.a;
        String url = cover.getUrl();
        if (url == null) {
            url = BuildConfig.FLAVOR;
        }
        String e = f.a.e(aVar, url, f, false, false, 12, null);
        String thumbnail = cover.getThumbnail();
        com.transsion.base.image.blurhash.e.d(com.transsion.base.image.blurhash.e.a, thumbnail == null ? BuildConfig.FLAVOR : thumbnail, 0, 0, new Function1() { // from class: com.transsion.moviedetail.fragment.a3
            public final Object invoke(Object obj) {
                Unit E0;
                E0 = TrailerFragment.E0(lm.u.this, (BitmapDrawable) obj);
                return E0;
            }
        }, 6, null);
        Glide.with(requireContext()).load(e).into(uVar.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(lm.u uVar, BitmapDrawable bitmapDrawable) {
        Intrinsics.h(bitmapDrawable, "it");
        uVar.d.setImageDrawable(bitmapDrawable);
        return Unit.a;
    }

    private final void F0(int type) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        Group group;
        ShapeableImageView shapeableImageView;
        ShapeableImageView shapeableImageView2;
        ViewStub viewStub;
        if (this.errorLayout == null) {
            lm.u uVar = (lm.u) getMViewBinding();
            this.errorLayout = (uVar == null || (viewStub = uVar.n) == null) ? null : viewStub.inflate();
        }
        if (type == 1) {
            Intrinsics.g(Utils.a().getString(R.string.downloading_play_timeout), "getString(...)");
            Intrinsics.g(Utils.a().getString(R.string.downloading_play_timeout_reload), "getString(...)");
            this.playState = -1;
        } else {
            Intrinsics.g(Utils.a().getString(R.string.downloading_play_load_failed), "getString(...)");
            Intrinsics.g(Utils.a().getString(R.string.turn_on_network), "getString(...)");
            this.playState = 22;
        }
        p0().pause();
        lm.u uVar2 = (lm.u) getMViewBinding();
        if (uVar2 != null && (shapeableImageView2 = uVar2.d) != null) {
            uf.c.k(shapeableImageView2);
        }
        lm.u uVar3 = (lm.u) getMViewBinding();
        if (uVar3 != null && (shapeableImageView = uVar3.e) != null) {
            uf.c.g(shapeableImageView);
        }
        lm.u uVar4 = (lm.u) getMViewBinding();
        if (uVar4 != null && (group = uVar4.b) != null) {
            uf.c.g(group);
        }
        View view = this.errorLayout;
        if (view != null) {
            uf.c.k(view);
        }
        View view2 = this.errorLayout;
        if (view2 != null) {
            view2.setTag(Integer.valueOf(type));
        }
        lm.u uVar5 = (lm.u) getMViewBinding();
        if (uVar5 != null && (appCompatImageView2 = uVar5.k) != null) {
            appCompatImageView2.setImageResource(R$drawable.post_icon_play);
        }
        lm.u uVar6 = (lm.u) getMViewBinding();
        if (uVar6 == null || (appCompatImageView = uVar6.k) == null) {
            return;
        }
        appCompatImageView.setKeepScreenOn(false);
    }

    private final void G0(long delay) {
        o0().removeCallbacks(this.showErrorRunnable);
        o0().postDelayed(this.showErrorRunnable, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(TrailerFragment trailerFragment) {
        trailerFragment.F0(0);
    }

    private final void I0() {
        AppCompatImageView appCompatImageView;
        Group group;
        AppCompatImageView appCompatImageView2;
        ep.a mAudioApi = getMAudioApi();
        if (mAudioApi != null) {
            mAudioApi.pause();
        }
        this.playState = 10;
        this.errorInfo = null;
        p0().play();
        View view = this.errorLayout;
        if (view != null) {
            uf.c.g(view);
        }
        lm.u uVar = (lm.u) getMViewBinding();
        if (uVar != null && (appCompatImageView2 = uVar.f) != null) {
            uf.c.g(appCompatImageView2);
        }
        lm.u uVar2 = (lm.u) getMViewBinding();
        if (uVar2 != null && (group = uVar2.c) != null) {
            uf.c.k(group);
        }
        lm.u uVar3 = (lm.u) getMViewBinding();
        if (uVar3 != null && (appCompatImageView = uVar3.k) != null) {
            appCompatImageView.setImageResource(R$drawable.post_icon_pause);
        }
        o0().removeCallbacks(this.showErrorRunnable);
        Trailer trailer = this.trailer;
        if (trailer == null || trailer.getSubjectType() != SubjectType.MUSIC.getValue()) {
            n0();
        } else {
            C0();
        }
    }

    private final ep.a getMAudioApi() {
        return (ep.a) this.mAudioApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.a mAudioApi_delegate$lambda$0() {
        return (ep.a) TheRouter.d(ep.a.class, new Object[0]);
    }

    private final void n0() {
        ShapeableImageView shapeableImageView;
        ShapeableImageView shapeableImageView2;
        if (this.isShowFirstFrame) {
            Trailer trailer = this.trailer;
            if (trailer == null || trailer.getSubjectType() != SubjectType.MUSIC.getValue()) {
                lm.u uVar = (lm.u) getMViewBinding();
                if (uVar != null && (shapeableImageView2 = uVar.e) != null) {
                    uf.c.g(shapeableImageView2);
                }
                lm.u uVar2 = (lm.u) getMViewBinding();
                if (uVar2 == null || (shapeableImageView = uVar2.d) == null) {
                    return;
                }
                uf.c.g(shapeableImageView);
            }
        }
    }

    private final Handler o0() {
        return (Handler) this.loadingHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.player.orplayer.f p0() {
        return (com.transsion.player.orplayer.f) this.mOrPlayer.getValue();
    }

    private final void r0() {
        SecondariesSeekBar secondariesSeekBar;
        lm.u uVar = (lm.u) getMViewBinding();
        if (uVar == null || (secondariesSeekBar = uVar.l) == null) {
            return;
        }
        secondariesSeekBar.setOnSeekBarChangeListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(TrailerFragment trailerFragment, View view) {
        trailerFragment.z0();
    }

    private final void t0() {
        o0().postDelayed(this.loadingRunnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler u0() {
        Looper myLooper = Looper.myLooper();
        Intrinsics.e(myLooper);
        return new Handler(myLooper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(TrailerFragment trailerFragment) {
        TextView textView;
        int i = trailerFragment.loadingDotIndex;
        if (i >= 2) {
            trailerFragment.loadingDotIndex = 0;
        } else {
            trailerFragment.loadingDotIndex = i + 1;
        }
        lm.u uVar = (lm.u) trailerFragment.getMViewBinding();
        if (uVar != null && (textView = uVar.i) != null) {
            textView.setText(Utils.a().getString(R.string.play_loading) + trailerFragment.loadingDot[trailerFragment.loadingDotIndex]);
        }
        trailerFragment.t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.player.orplayer.f w0(TrailerFragment trailerFragment) {
        com.transsion.player.orplayer.f m = on.e0.a.m();
        m.setPlayerConfig(new hn.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 126975, null));
        lm.u uVar = (lm.u) trailerFragment.getMViewBinding();
        m.setTextureView(uVar != null ? uVar.h : null);
        m.setLooping(false);
        m.setPlayerListener(trailerFragment);
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0() {
        this.playState = 20;
        p0().pause();
    }

    private final void y0() {
        this.playState = 10;
        I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0() {
        lm.u uVar;
        Group group;
        lm.u uVar2;
        Group group2;
        int i = this.playState;
        if (i == -1) {
            A0();
            return;
        }
        if (i == 0) {
            p0().prepare();
            p0().seekTo(0L);
            y0();
            if (this.playState != 10 || (uVar = (lm.u) getMViewBinding()) == null || (group = uVar.b) == null) {
                return;
            }
            uf.c.k(group);
            return;
        }
        if (i == 10) {
            x0();
            return;
        }
        if (i == 20 || i == 22) {
            y0();
            return;
        }
        if (i != 30) {
            return;
        }
        p0().seekTo(0L);
        y0();
        if (this.playState != 10 || (uVar2 = (lm.u) getMViewBinding()) == null || (group2 = uVar2.b) == null) {
            return;
        }
        uf.c.k(group2);
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i, int i2, qn.d dVar) {
        e.a.a(this, z, i, i2, dVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.b(this);
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        lm.u uVar = (lm.u) getMViewBinding();
        if (uVar != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.z2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TrailerFragment.s0(TrailerFragment.this, view2);
                }
            };
            uVar.f.setOnClickListener(onClickListener);
            uVar.k.setOnClickListener(onClickListener);
            uVar.j.setOnClickListener(new c());
        }
        r0();
        yg.l.a.l(this);
    }

    public void lazyLoadData() {
        Bundle arguments = getArguments();
        Trailer trailer = null;
        Trailer trailer2 = (Trailer) (arguments != null ? arguments.getSerializable("trailer") : null);
        if (trailer2 != null) {
            B0(trailer2);
            if (NetworkType.NETWORK_WIFI == yg.l.a.d() && trailer2.getSubjectType() < SubjectType.AUDIO.getValue()) {
                z0();
            }
            trailer = trailer2;
        }
        this.trailer = trailer;
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        e.a.c(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long progress, gn.e mediaSource) {
        SecondariesSeekBar secondariesSeekBar;
        e.a.d(this, progress, mediaSource);
        if (this.bufferPosition < progress) {
            this.bufferPosition = progress;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(0, Integer.valueOf((int) ((progress * 100) / this.duration)));
            lm.u uVar = (lm.u) getMViewBinding();
            if (uVar == null || (secondariesSeekBar = uVar.l) == null) {
                return;
            }
            secondariesSeekBar.setSecondariesProgress(linkedHashMap);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e mediaSource) {
        e.a.e(this, mediaSource);
        lm.u uVar = (lm.u) getMViewBinding();
        if (uVar != null) {
            this.currentPosition = 0L;
            this.playState = 30;
            AppCompatImageView appCompatImageView = uVar.f;
            Intrinsics.g(appCompatImageView, "ivPlay");
            uf.c.k(appCompatImageView);
            uVar.k.setImageResource(R$drawable.post_icon_play);
            Group group = uVar.c;
            Intrinsics.g(group, "groupProgress");
            uf.c.g(group);
            ShapeableImageView shapeableImageView = uVar.e;
            Intrinsics.g(shapeableImageView, "ivMovieCover");
            uf.c.k(shapeableImageView);
            ShapeableImageView shapeableImageView2 = uVar.d;
            Intrinsics.g(shapeableImageView2, "ivMovieBlurCover");
            uf.c.k(shapeableImageView2);
            a.a.f(wf.a.a, this.TAG, "onCompletion", false, 4, (Object) null);
        }
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        int i;
        Integer errorCode;
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        a.a.f(wf.a.a, this.TAG, "onConnected~~", false, 4, (Object) null);
        View view = this.errorLayout;
        if (view == null || view.getVisibility() != 0 || (i = this.playState) == 20 || i == 21) {
            return;
        }
        View view2 = this.errorLayout;
        if (!(view2 != null ? Intrinsics.c(view2.getTag(), 1) : false)) {
            PlayError playError = this.errorInfo;
            if (!((playError == null || (errorCode = playError.getErrorCode()) == null || errorCode.intValue() != 537067524) ? false : true)) {
                I0();
                return;
            }
        }
        A0();
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        o0().removeCallbacks(this.loadingRunnable);
        yg.l.a.m(this);
    }

    public void onDisconnected() {
        a.a.f(wf.a.a, this.TAG, "onDisconnected~~", false, 4, (Object) null);
        if (this.playState != 10 || p0().isPlaying()) {
            return;
        }
        G0(500L);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z) {
        e.a.g(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z) {
        e.a.h(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(gn.e mediaSource) {
        Group group;
        e.a.i(this, mediaSource);
        a.a.f(wf.a.a, this.TAG, "onLoadingBegin", false, 4, (Object) null);
        if (!yg.l.a.e()) {
            G0(1000L);
            return;
        }
        lm.u uVar = (lm.u) getMViewBinding();
        if (uVar != null && (group = uVar.b) != null) {
            uf.c.k(group);
        }
        o0().post(this.loadingRunnable);
        View view = this.errorLayout;
        if (view != null) {
            uf.c.g(view);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(gn.e mediaSource) {
        Group group;
        e.a.k(this, mediaSource);
        lm.u uVar = (lm.u) getMViewBinding();
        if (uVar != null && (group = uVar.b) != null) {
            uf.c.g(group);
        }
        a.a.f(wf.a.a, this.TAG, "onLoadingEnd", false, 4, (Object) null);
        View view = this.errorLayout;
        if (view != null) {
            uf.c.g(view);
        }
        o0().removeCallbacks(this.loadingRunnable);
        o0().removeCallbacks(this.showErrorRunnable);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i, float f, gn.e eVar) {
        e.a.m(this, i, f, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        e.a.o(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
    }

    public void onPause() {
        super.onPause();
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            p0().release();
        } else if (this.playState == 10) {
            this.playState = 21;
            p0().pause();
        }
        ep.a mAudioApi = getMAudioApi();
        if (mAudioApi != null) {
            mAudioApi.start();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, gn.e mediaSource) {
        Intrinsics.h(errorInfo, "errorInfo");
        e.a.q(this, errorInfo, mediaSource);
        Integer errorCode = errorInfo.getErrorCode();
        if (errorCode != null && errorCode.intValue() == 537067524) {
            if (yg.l.a.e()) {
                F0(1);
            } else {
                G0(500L);
            }
        }
        this.errorInfo = errorInfo;
        wf.a.a.i("i_media", this.TAG + " --> IPlayerListener --> onPlayError()  errorCode:" + errorInfo.getErrorCode() + " errorMessage:" + errorInfo.getErrorMessage() + " url:" + (mediaSource != null ? mediaSource.j() : null) + " --> 预告片播放失败了", true);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(gn.e eVar) {
        e.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.v(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(gn.e eVar) {
        e.a.w(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long progress, gn.e mediaSource) {
        SecondariesSeekBar secondariesSeekBar;
        TextView textView;
        e.a.y(this, progress, mediaSource);
        if (this.formUserSeek) {
            return;
        }
        this.currentPosition = progress;
        if (this.duration <= 0) {
            this.duration = p0().getDuration();
        }
        String str = com.transsion.postdetail.util.m.d(progress) + "/" + com.transsion.postdetail.util.m.d(this.duration);
        lm.u uVar = (lm.u) getMViewBinding();
        if (uVar != null && (textView = uVar.m) != null) {
            textView.setText(str);
        }
        lm.u uVar2 = (lm.u) getMViewBinding();
        if (uVar2 == null || (secondariesSeekBar = uVar2.l) == null) {
            return;
        }
        secondariesSeekBar.setProgress((progress * 100) / this.duration);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        e.a.A(this);
        this.isShowFirstFrame = true;
        a.a.f(wf.a.a, this.TAG, "onRenderFirstFrame", false, 4, (Object) null);
        n0();
    }

    public void onResume() {
        super.onResume();
        PreVideoAddress preVideoAddress = this.videoAddress;
        if ((preVideoAddress != null ? preVideoAddress.getUrl() : null) != null) {
            if (p0().requestForce()) {
                p0().prepare();
                p0().seekTo(this.currentPosition);
            }
            if (this.playState == 21) {
                this.playState = 10;
                p0().play();
                ep.a mAudioApi = getMAudioApi();
                if (mAudioApi != null) {
                    mAudioApi.pause();
                }
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.B(this);
    }

    public void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
        a.a.f(wf.a.a, this.TAG, "onStart~~", false, 4, (Object) null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i) {
        e.a.C(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(qn.c cVar) {
        e.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i) {
        e.a.E(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(gn.e mediaSource) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        e.a.F(this, mediaSource);
        lm.u uVar = (lm.u) getMViewBinding();
        if (uVar != null && (appCompatImageView2 = uVar.k) != null) {
            appCompatImageView2.setImageResource(R$drawable.post_icon_play);
        }
        lm.u uVar2 = (lm.u) getMViewBinding();
        if (uVar2 != null && (appCompatImageView = uVar2.k) != null) {
            appCompatImageView.setKeepScreenOn(false);
        }
        a.a.f(wf.a.a, this.TAG, "onVideoPause", false, 4, (Object) null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i, int i2) {
        e.a.H(this, i, i2);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e mediaSource) {
        e.a.I(this, mediaSource);
        lm.u uVar = (lm.u) getMViewBinding();
        if (uVar != null) {
            Group group = uVar.b;
            Intrinsics.g(group, "groupLoading");
            uf.c.g(group);
            uVar.k.setImageResource(R$drawable.post_icon_pause);
            uVar.k.setKeepScreenOn(true);
            n0();
            a.a.f(wf.a.a, this.TAG, "onVideoStart", false, 4, (Object) null);
        }
    }

    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public lm.u getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        lm.u c2 = lm.u.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.K(this);
    }
}
