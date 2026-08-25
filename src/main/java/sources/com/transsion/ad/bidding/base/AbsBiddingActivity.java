package com.transsion.ad.bidding.base;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.y;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.gyf.immersionbar.ImmersionBar;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.MBAd;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.bidding.base.AbsBiddingActivity;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.strategy.t;
import com.transsion.player.config.RenderType;
import com.transsion.player.enum.PlayMimeType;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xh.b;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\u0006J\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0006J\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u0006J\u0019\u0010\u001e\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\nH\u0014¢\u0006\u0004\b \u0010\u0006J\u000f\u0010!\u001a\u00020\nH\u0014¢\u0006\u0004\b!\u0010\u0006J\u0011\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0014H\u0016¢\u0006\u0004\b&\u0010'J!\u0010,\u001a\u00020\n2\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\nH\u0016¢\u0006\u0004\b0\u0010\u0006J\u0019\u00101\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b1\u0010/J\u0019\u00102\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b2\u0010/J\u0019\u00103\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b3\u0010/J\u000f\u00104\u001a\u00020\rH\u0016¢\u0006\u0004\b4\u00105J\u0011\u00106\u001a\u0004\u0018\u00010\"H&¢\u0006\u0004\b6\u0010$J\u000f\u00107\u001a\u00020\nH&¢\u0006\u0004\b7\u0010\u0006J\u0011\u00109\u001a\u0004\u0018\u000108H&¢\u0006\u0004\b9\u0010:J\u0011\u0010;\u001a\u0004\u0018\u000108H&¢\u0006\u0004\b;\u0010:J\u000f\u0010=\u001a\u00020<H&¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020<H&¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\nH&¢\u0006\u0004\bB\u0010\u0006J\u0011\u0010C\u001a\u0004\u0018\u00010\"H&¢\u0006\u0004\bC\u0010$J\u0011\u0010D\u001a\u0004\u0018\u00010\"H&¢\u0006\u0004\bD\u0010$J\u0011\u0010E\u001a\u0004\u0018\u00010\"H&¢\u0006\u0004\bE\u0010$J-\u0010J\u001a\u00020\n2\b\u0010G\u001a\u0004\u0018\u00010F2\b\u0010H\u001a\u0004\u0018\u00010<2\b\u0010I\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0014H\u0016¢\u0006\u0004\bL\u0010\u0016J\u000f\u0010M\u001a\u00020\u0014H\u0016¢\u0006\u0004\bM\u0010\u0016J\u0017\u0010P\u001a\u00020\n2\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bP\u0010QJ\r\u0010R\u001a\u00020\n¢\u0006\u0004\bR\u0010\u0006J\r\u0010S\u001a\u00020\n¢\u0006\u0004\bS\u0010\u0006J\u000f\u0010T\u001a\u00020\nH\u0017¢\u0006\u0004\bT\u0010\u0006J\u0015\u0010V\u001a\u00020\n2\u0006\u0010U\u001a\u00020\u0014¢\u0006\u0004\bV\u0010'J\r\u0010W\u001a\u00020<¢\u0006\u0004\bW\u0010>J\r\u0010X\u001a\u00020<¢\u0006\u0004\bX\u0010>J\u000f\u0010Z\u001a\u0004\u0018\u00010Y¢\u0006\u0004\bZ\u0010[J\u000f\u0010]\u001a\u0004\u0018\u00010\\¢\u0006\u0004\b]\u0010^J\r\u0010_\u001a\u00020\n¢\u0006\u0004\b_\u0010\u0006J\r\u0010`\u001a\u00020\n¢\u0006\u0004\b`\u0010\u0006J\r\u0010a\u001a\u00020\n¢\u0006\u0004\ba\u0010\u0006J\r\u0010b\u001a\u00020\n¢\u0006\u0004\bb\u0010\u0006R\u0018\u0010e\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010l\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010r\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010yR\u0016\u0010~\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010}R\u0017\u0010\u0082\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0084\u0001\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010nR\u001b\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0089\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010}R\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001¨\u0006\u008e\u0001"}, d2 = {"Lcom/transsion/ad/bidding/base/AbsBiddingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/transsion/ad/strategy/t$a;", "Lxh/b;", "Lcom/transsion/player/orplayer/e;", "<init>", "()V", "Lcom/transsion/player/orplayer/f;", "n0", "()Lcom/transsion/player/orplayer/f;", TtmlNode.ANONYMOUS_REGION_ID, "z0", "W", TtmlNode.ANONYMOUS_REGION_ID, "errorMsg", "u0", "(Ljava/lang/String;)V", "q0", "s0", "F0", TtmlNode.ANONYMOUS_REGION_ID, "A0", "()Z", "H0", "E0", "x0", "J0", "w0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onDestroy", "Landroid/view/View;", "getVisibilityView", "()Landroid/view/View;", "isVisible", "onVisibilityChanged", "(Z)V", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "Lgn/e;", "mediaSource", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lgn/e;)V", "onPrepare", "(Lgn/e;)V", "onRenderFirstFrame", "onVideoPause", "onVideoStart", "onCompletion", "getSceneId", "()Ljava/lang/String;", "o0", "D0", "Landroid/widget/FrameLayout;", "j0", "()Landroid/widget/FrameLayout;", "p0", TtmlNode.ANONYMOUS_REGION_ID, "g0", "()I", "i", "y0", "(I)V", "r0", "c0", "k0", "l0", "Landroidx/appcompat/widget/AppCompatImageView;", "imageView", "width", "height", "t0", "(Landroidx/appcompat/widget/AppCompatImageView;Ljava/lang/Integer;Ljava/lang/Integer;)V", "i0", "m0", "Lcom/gyf/immersionbar/ImmersionBar;", "with", "L0", "(Lcom/gyf/immersionbar/ImmersionBar;)V", "b0", "K0", "B0", "isShow", "C0", "h0", "f0", "Lcom/transsion/ad/monopoly/model/AdPlans;", "e0", "()Lcom/transsion/ad/monopoly/model/AdPlans;", "Lcom/transsion/ad/monopoly/model/AdMaterialList;", "d0", "()Lcom/transsion/ad/monopoly/model/AdMaterialList;", "X", "a0", "V", "Y", "a", "Lcom/transsion/ad/monopoly/model/AdPlans;", "mAdPlan", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "maxEcpmObject", "c", "Lcom/transsion/ad/monopoly/model/AdMaterialList;", "mAdMaterialList", "d", "I", "mAppLayoutId", "e", "Ljava/lang/String;", "mSceneId", TtmlNode.ANONYMOUS_REGION_ID, "f", "J", "displayTimestamp", "Ljava/util/concurrent/atomic/AtomicBoolean;", ee.g.b, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReportAdDisplay", "h", "isAdMaterialShow", "Z", "mIsMute", "Landroid/os/Handler;", com.mbridge.msdk.foundation.same.report.j.b, "Landroid/os/Handler;", "mHandler", CampaignEx.JSON_KEY_AD_K, "countDownTimes", "l", "Lcom/transsion/player/orplayer/f;", "mOrPlayer", "m", "isInScreen", "Ljava/lang/Runnable;", "n", "Ljava/lang/Runnable;", "countdownRunnable", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class AbsBiddingActivity extends AppCompatActivity implements t.a, xh.b, com.transsion.player.orplayer.e {

    /* renamed from: a, reason: from kotlin metadata */
    private AdPlans mAdPlan;

    /* renamed from: b, reason: from kotlin metadata */
    private BiddingIntermediateMaterialBean maxEcpmObject;

    /* renamed from: c, reason: from kotlin metadata */
    private AdMaterialList mAdMaterialList;

    /* renamed from: d, reason: from kotlin metadata */
    private int mAppLayoutId;

    /* renamed from: e, reason: from kotlin metadata */
    private String mSceneId;

    /* renamed from: f, reason: from kotlin metadata */
    private long displayTimestamp;

    /* renamed from: k, reason: from kotlin metadata */
    private int countDownTimes;

    /* renamed from: l, reason: from kotlin metadata */
    private com.transsion.player.orplayer.f mOrPlayer;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean isInScreen;

    /* renamed from: g, reason: from kotlin metadata */
    private AtomicBoolean isReportAdDisplay = new AtomicBoolean(false);

    /* renamed from: h, reason: from kotlin metadata */
    private AtomicBoolean isAdMaterialShow = new AtomicBoolean(false);

    /* renamed from: i, reason: from kotlin metadata */
    private boolean mIsMute = true;

    /* renamed from: j, reason: from kotlin metadata */
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: n, reason: from kotlin metadata */
    private final Runnable countdownRunnable = new Runnable() { // from class: com.transsion.ad.bidding.base.l
        @Override // java.lang.Runnable
        public final void run() {
            AbsBiddingActivity.Z(AbsBiddingActivity.this);
        }
    };

    public static final class a extends androidx.activity.u {
        a() {
            super(true);
        }

        public void handleOnBackPressed() {
        }
    }

    public static final class b implements RequestListener {
        final /* synthetic */ AppCompatImageView b;

        b(AppCompatImageView appCompatImageView) {
            this.b = appCompatImageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(AbsBiddingActivity absBiddingActivity, AppCompatImageView appCompatImageView, int i, int i2) {
            absBiddingActivity.t0(appCompatImageView, Integer.valueOf(i), Integer.valueOf(i2));
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z) {
            Intrinsics.h(drawable, "resource");
            Intrinsics.h(obj, "model");
            Intrinsics.h(dataSource, "dataSource");
            if (drawable instanceof GifDrawable) {
                ((GifDrawable) drawable).start();
            }
            AbsBiddingActivity.this.isAdMaterialShow.set(true);
            final int intrinsicWidth = drawable.getIntrinsicWidth();
            final int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                return false;
            }
            final AppCompatImageView appCompatImageView = this.b;
            final AbsBiddingActivity absBiddingActivity = AbsBiddingActivity.this;
            appCompatImageView.post(new Runnable() { // from class: com.transsion.ad.bidding.base.p
                @Override // java.lang.Runnable
                public final void run() {
                    AbsBiddingActivity.b.c(AbsBiddingActivity.this, appCompatImageView, intrinsicWidth, intrinsicHeight);
                }
            });
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
            Intrinsics.h(target, "target");
            AbsBiddingActivity.this.u0("图片加载失败 --> " + (glideException != null ? glideException.getMessage() : null));
            return false;
        }
    }

    private final boolean A0() {
        this.mIsMute = !this.mIsMute;
        com.transsion.player.orplayer.f mOrPlayer = getMOrPlayer();
        if (mOrPlayer != null) {
            mOrPlayer.setMute(this.mIsMute);
        }
        return this.mIsMute;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void E0() {
        MbAdImage image;
        FrameLayout j0 = j0();
        if (j0 == null) {
            u0("图片广告容器为空");
            return;
        }
        AppCompatImageView appCompatImageView = new AppCompatImageView(this);
        appCompatImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        AdMaterialList mAdMaterialList = getMAdMaterialList();
        if (mAdMaterialList == null || (image = mAdMaterialList.getImage()) == null) {
            u0("图片广告素材为空");
        } else {
            String path = image.getPath();
            Object url = image.getUrl();
            if (path != null) {
                if (!new File(path).exists()) {
                    path = null;
                }
                if (path != null) {
                    url = new File(path);
                }
            }
            Glide.with(this).load(url).listener(new b(appCompatImageView)).into(appCompatImageView);
            if (image.getWidth() == null || image.getHeight() == null) {
                t0(appCompatImageView, Integer.valueOf(y.e()), Integer.valueOf(y.c()));
            } else {
                t0(appCompatImageView, image.getWidth(), image.getHeight());
            }
        }
        j0.removeAllViews();
        j0.addView(appCompatImageView);
    }

    private final void F0() {
        AdMaterialList mAdMaterialList = getMAdMaterialList();
        if (Intrinsics.c(mAdMaterialList != null ? mAdMaterialList.getType() : null, "TextAdMaterial")) {
            E0();
        } else {
            x0();
        }
        FrameLayout j0 = j0();
        if (j0 != null) {
            j0.setOnClickListener(new ci.g(0L, new Function1() { // from class: com.transsion.ad.bidding.base.m
                public final Object invoke(Object obj) {
                    Unit G0;
                    G0 = AbsBiddingActivity.G0(AbsBiddingActivity.this, (View) obj);
                    return G0;
                }
            }, 1, (DefaultConstructorMarker) null));
        }
        H0();
        View c0 = c0();
        if (c0 != null) {
            com.transsion.ad.strategy.h.a.a(c0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(AbsBiddingActivity absBiddingActivity, View view) {
        Intrinsics.h(view, "it");
        absBiddingActivity.V();
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H0() {
        int i;
        FrameLayout p0 = p0();
        if (p0 != null) {
            AdMaterialList mAdMaterialList = getMAdMaterialList();
            if (Intrinsics.c(mAdMaterialList != null ? mAdMaterialList.getType() : null, "TextAdMaterial")) {
                i = 8;
            } else {
                final AppCompatImageView appCompatImageView = new AppCompatImageView(this);
                appCompatImageView.setImageResource(R$mipmap.ad_volumeoff);
                p0.removeAllViews();
                p0.addView((View) appCompatImageView, -1, -1);
                p0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.bidding.base.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AbsBiddingActivity.I0(AbsBiddingActivity.this, appCompatImageView, view);
                    }
                });
                i = 0;
            }
            p0.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(AbsBiddingActivity absBiddingActivity, AppCompatImageView appCompatImageView, View view) {
        if (absBiddingActivity.A0()) {
            appCompatImageView.setImageResource(R$mipmap.ad_volumeoff);
        } else {
            appCompatImageView.setImageResource(R$mipmap.ad_volumeon);
        }
    }

    private final void J0() {
        w0();
        if (this.countDownTimes >= 0) {
            this.mHandler.postDelayed(this.countdownRunnable, 1000L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void W() {
        Intent intent = new Intent(getIntent().getStringExtra("action_close"));
        intent.putExtra("ad_max_ecpm_object", this.maxEcpmObject);
        r1.a.b(this).d(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(AbsBiddingActivity absBiddingActivity) {
        absBiddingActivity.y0(absBiddingActivity.countDownTimes);
        b.a.c(absBiddingActivity, 3, "countdownRunnable() --> times = " + absBiddingActivity.g0() + " --> i = " + absBiddingActivity.countDownTimes, (String) null, false, 4, (Object) null);
        if (absBiddingActivity.countDownTimes == 0) {
            absBiddingActivity.r0();
        }
        absBiddingActivity.countDownTimes--;
        absBiddingActivity.J0();
    }

    /* renamed from: n0, reason: from getter */
    private final com.transsion.player.orplayer.f getMOrPlayer() {
        return this.mOrPlayer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b9 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:2:0x0000, B:4:0x0009, B:5:0x0014, B:7:0x001d, B:8:0x0025, B:29:0x0090, B:32:0x0098, B:34:0x009e, B:35:0x00b5, B:37:0x00b9, B:38:0x00bf, B:40:0x00c3, B:42:0x00c9, B:44:0x00d3, B:46:0x00d7, B:48:0x00dd, B:49:0x00e4, B:50:0x00e6, B:60:0x00a9, B:62:0x00af, B:68:0x0087, B:10:0x0027, B:12:0x002d, B:14:0x0037, B:16:0x003d, B:17:0x0043, B:19:0x0049, B:21:0x0055, B:23:0x005f, B:27:0x007f, B:28:0x0083), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:2:0x0000, B:4:0x0009, B:5:0x0014, B:7:0x001d, B:8:0x0025, B:29:0x0090, B:32:0x0098, B:34:0x009e, B:35:0x00b5, B:37:0x00b9, B:38:0x00bf, B:40:0x00c3, B:42:0x00c9, B:44:0x00d3, B:46:0x00d7, B:48:0x00dd, B:49:0x00e4, B:50:0x00e6, B:60:0x00a9, B:62:0x00af, B:68:0x0087, B:10:0x0027, B:12:0x002d, B:14:0x0037, B:16:0x003d, B:17:0x0043, B:19:0x0049, B:21:0x0055, B:23:0x005f, B:27:0x007f, B:28:0x0083), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void q0() {
        Object obj;
        Throwable th;
        AdMaterialList adMaterialList;
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBean;
        AdPlans plans;
        List adMaterialList2;
        AdPlans adPlans;
        List adMaterialList3;
        Unit unit;
        Set<String> keySet;
        try {
            Result.Companion companion = Result.Companion;
            Intent intent = getIntent();
            adMaterialList = null;
            this.mSceneId = intent != null ? intent.getStringExtra(TrackingKey.SCENE_ID) : null;
            Intent intent2 = getIntent();
            this.mAppLayoutId = intent2 != null ? intent2.getIntExtra("app_layout_id", 0) : 0;
            try {
                Intent intent3 = getIntent();
                Bundle extras = intent3 != null ? intent3.getExtras() : null;
                if (extras == null || (keySet = extras.keySet()) == null) {
                    unit = null;
                } else {
                    for (String str : keySet) {
                        Object obj2 = extras.get(str);
                        onLog(6, "处理 FM Parcelable 异常 --> Bundle key = " + str + ", valueClass = " + (obj2 != null ? obj2.getClass().getName() : null), "parcelable", false);
                    }
                    unit = Unit.a;
                }
                Result.constructor-impl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        } catch (Throwable th3) {
            Result.Companion companion3 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th3));
        }
        if (Build.VERSION.SDK_INT >= 33) {
            Intent intent4 = getIntent();
            if (intent4 != null) {
                biddingIntermediateMaterialBean = (BiddingIntermediateMaterialBean) com.cloud.hisavana.sdk.common.activity.c.a(intent4, "ad_max_ecpm_object", BiddingIntermediateMaterialBean.class);
                this.maxEcpmObject = biddingIntermediateMaterialBean;
                plans = biddingIntermediateMaterialBean == null ? biddingIntermediateMaterialBean.getPlans() : null;
                this.mAdPlan = plans;
                if (plans != null && (adMaterialList2 = plans.getAdMaterialList()) != null && (!adMaterialList2.isEmpty())) {
                    adPlans = this.mAdPlan;
                    if (adPlans != null && (adMaterialList3 = adPlans.getAdMaterialList()) != null) {
                        adMaterialList = (AdMaterialList) adMaterialList3.get(0);
                    }
                    this.mAdMaterialList = adMaterialList;
                }
                obj = Result.constructor-impl(Unit.a);
                th = Result.exceptionOrNull-impl(obj);
                if (th != null) {
                    return;
                }
                b.a.c(this, 6, "initExtData() --> it = " + th.getMessage(), (String) null, false, 12, (Object) null);
                return;
            }
            biddingIntermediateMaterialBean = null;
            this.maxEcpmObject = biddingIntermediateMaterialBean;
            if (biddingIntermediateMaterialBean == null) {
            }
            this.mAdPlan = plans;
            if (plans != null) {
                adPlans = this.mAdPlan;
                if (adPlans != null) {
                    adMaterialList = (AdMaterialList) adMaterialList3.get(0);
                }
                this.mAdMaterialList = adMaterialList;
            }
            obj = Result.constructor-impl(Unit.a);
            th = Result.exceptionOrNull-impl(obj);
            if (th != null) {
            }
        } else {
            Intent intent5 = getIntent();
            if (intent5 != null) {
                biddingIntermediateMaterialBean = (BiddingIntermediateMaterialBean) intent5.getParcelableExtra("ad_max_ecpm_object");
                this.maxEcpmObject = biddingIntermediateMaterialBean;
                if (biddingIntermediateMaterialBean == null) {
                }
                this.mAdPlan = plans;
                if (plans != null) {
                }
                obj = Result.constructor-impl(Unit.a);
                th = Result.exceptionOrNull-impl(obj);
                if (th != null) {
                }
            }
            biddingIntermediateMaterialBean = null;
            this.maxEcpmObject = biddingIntermediateMaterialBean;
            if (biddingIntermediateMaterialBean == null) {
            }
            this.mAdPlan = plans;
            if (plans != null) {
            }
            obj = Result.constructor-impl(Unit.a);
            th = Result.exceptionOrNull-impl(obj);
            if (th != null) {
            }
        }
    }

    private final void s0() {
        getOnBackPressedDispatcher().i(this, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(final String errorMsg) {
        FrameLayout j0 = j0();
        if (j0 != null) {
            j0.post(new Runnable() { // from class: com.transsion.ad.bidding.base.n
                @Override // java.lang.Runnable
                public final void run() {
                    AbsBiddingActivity.v0(AbsBiddingActivity.this, errorMsg);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void v0(AbsBiddingActivity absBiddingActivity, String str) {
        Intent intent = new Intent(absBiddingActivity.getIntent().getStringExtra("show_error"));
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = absBiddingActivity.maxEcpmObject;
        if (biddingIntermediateMaterialBean != null) {
            biddingIntermediateMaterialBean.setErrorMsg(str);
        }
        intent.putExtra("ad_max_ecpm_object", absBiddingActivity.maxEcpmObject);
        r1.a.b(absBiddingActivity).d(intent);
        absBiddingActivity.b0();
    }

    private final void w0() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x0() {
        AdMaterialList mAdMaterialList;
        MbAdVideo video;
        String path;
        AdMaterialList mAdMaterialList2;
        MbAdVideo video2;
        MbAdVideo video3;
        FrameLayout j0 = j0();
        if (j0 == null) {
            u0("视频广告容器为空");
            return;
        }
        TextureView textureView = new TextureView(this);
        com.transsion.player.orplayer.f a2 = new f.a(this).b(new hn.d((RenderType) null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, true, false, false, false, (String) null, 94207, (DefaultConstructorMarker) null)).a();
        a2.setMute(m0());
        a2.setTextureView(textureView);
        a2.setLooping(i0());
        a2.setPlayerListener(this);
        this.mOrPlayer = a2;
        AdMaterialList mAdMaterialList3 = getMAdMaterialList();
        String str = (!TextUtils.isEmpty((mAdMaterialList3 == null || (video3 = mAdMaterialList3.getVideo()) == null) ? null : video3.getPath()) ? !((mAdMaterialList = getMAdMaterialList()) == null || (video = mAdMaterialList.getVideo()) == null || (path = video.getPath()) == null) : !((mAdMaterialList2 = getMAdMaterialList()) == null || (video2 = mAdMaterialList2.getVideo()) == null || (path = video2.getUrl()) == null)) ? TtmlNode.ANONYMOUS_REGION_ID : path;
        com.transsion.player.orplayer.f fVar = this.mOrPlayer;
        if (fVar != null) {
            fVar.setDataSource(new gn.e(str, str, 0, (PlayMimeType) null, (MediaItem) null, 28, (DefaultConstructorMarker) null));
        }
        com.transsion.player.orplayer.f fVar2 = this.mOrPlayer;
        if (fVar2 != null) {
            fVar2.prepare();
        }
        j0.addView(textureView, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z0() {
        if (this.displayTimestamp > 0) {
            Intent intent = new Intent(getIntent().getStringExtra("action_display_timestamp"));
            intent.putExtra("ad_max_ecpm_object", this.maxEcpmObject);
            intent.putExtra("display_timestamp", SystemClock.elapsedRealtime() - this.displayTimestamp);
            r1.a.b(this).d(intent);
            this.displayTimestamp = 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void B0() {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
    }

    public final void C0(boolean isShow) {
        if (isShow) {
            com.transsion.player.orplayer.f mOrPlayer = getMOrPlayer();
            if (mOrPlayer != null) {
                mOrPlayer.pause();
            }
            w0();
            return;
        }
        com.transsion.player.orplayer.f mOrPlayer2 = getMOrPlayer();
        if (mOrPlayer2 != null) {
            mOrPlayer2.play();
        }
        J0();
    }

    public abstract void D0();

    public final void K0() {
        rh.a d;
        MBAd.a b2 = MBAd.a.b();
        if (b2 == null || (d = b2.d()) == null) {
            return;
        }
        d.c(getSceneId());
    }

    public void L0(ImmersionBar with) {
        Intrinsics.h(with, "with");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V() {
        Intent intent = new Intent(getIntent().getStringExtra("action_click"));
        intent.putExtra("ad_max_ecpm_object", this.maxEcpmObject);
        r1.a.b(this).d(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X() {
        Intent intent = new Intent(getIntent().getStringExtra("action_resume"));
        intent.putExtra("ad_max_ecpm_object", this.maxEcpmObject);
        r1.a.b(this).d(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y() {
        Intent intent = new Intent(getIntent().getStringExtra("action_rewarded"));
        intent.putExtra("ad_max_ecpm_object", this.maxEcpmObject);
        r1.a.b(this).d(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a0() {
        Intent intent = new Intent(getIntent().getStringExtra("action_display"));
        intent.putExtra("ad_max_ecpm_object", this.maxEcpmObject);
        r1.a.b(this).d(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b0() {
        finish();
    }

    public abstract View c0();

    /* renamed from: d0, reason: from getter */
    public final AdMaterialList getMAdMaterialList() {
        return this.mAdMaterialList;
    }

    /* renamed from: e0, reason: from getter */
    public final AdPlans getMAdPlan() {
        return this.mAdPlan;
    }

    /* renamed from: f0, reason: from getter */
    public final int getMAppLayoutId() {
        return this.mAppLayoutId;
    }

    public abstract int g0();

    public String getClassTag() {
        return b.a.a(this);
    }

    public String getSceneId() {
        String str = this.mSceneId;
        return str == null ? TtmlNode.ANONYMOUS_REGION_ID : str;
    }

    public double getVisibilityThreshold() {
        return t.a.a.a(this);
    }

    public View getVisibilityView() {
        return j0();
    }

    public final int h0() {
        return com.transsion.ad.scene.a.a.e(getSceneId());
    }

    public boolean i0() {
        return true;
    }

    public void initPlayer() {
        e.a.b(this);
    }

    public abstract FrameLayout j0();

    public abstract View k0();

    public abstract View l0();

    public boolean m0() {
        return true;
    }

    public abstract View o0();

    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        e.a.c(this, eVar);
    }

    public void onBufferedPosition(long j, gn.e eVar) {
        e.a.d(this, j, eVar);
    }

    public void onCompletion(gn.e mediaSource) {
        e.a.e(this, mediaSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        B0();
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        ImmersionBar with = ImmersionBar.with(this);
        with.statusBarAlpha(0.0f);
        Intrinsics.e(with);
        L0(with);
        with.init();
        setContentView(o0());
        getWindow().setLayout(-1, -1);
        setFinishOnTouchOutside(false);
        q0();
        if (getMAdPlan() == null || TextUtils.isEmpty(getSceneId())) {
            u0("onCreate() --> 开始展示广告 --> getAdPlan() == null || getSceneId() is empty");
            return;
        }
        b.a.c(this, 3, "onCreate() --> 开始展示广告", (String) null, false, 4, (Object) null);
        this.countDownTimes = g0();
        com.transsion.ad.strategy.t.a.j(this);
        D0();
        F0();
        s0();
        Intent intent = getIntent();
        if ((intent != null ? Boolean.valueOf(intent.getBooleanExtra("is_show_member_btn", true)) : null) == null || !(!r8.booleanValue())) {
            return;
        }
        View k0 = k0();
        if (k0 != null) {
            k0.setVisibility(8);
        }
        View l0 = l0();
        if (l0 != null) {
            l0.setVisibility(8);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        com.transsion.ad.strategy.t.a.v(this);
        com.transsion.player.orplayer.f mOrPlayer = getMOrPlayer();
        if (mOrPlayer != null) {
            mOrPlayer.release();
        }
        z0();
        W();
    }

    public void onFocusChange(boolean z) {
        e.a.g(this, z);
    }

    public void onIsPlayingChanged(boolean z) {
        e.a.h(this, z);
    }

    public void onLoadingBegin(gn.e eVar) {
        e.a.i(this, eVar);
    }

    public void onLoadingEnd(gn.e eVar) {
        e.a.k(this, eVar);
    }

    public void onLoadingProgress(int i, float f, gn.e eVar) {
        e.a.m(this, i, f, eVar);
    }

    public void onLog(int i, String str, String str2, boolean z) {
        b.a.b(this, i, str, str2, z);
    }

    public void onLoopingStart() {
        e.a.o(this);
    }

    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
    }

    public void onPlayError(PlayError errorInfo, gn.e mediaSource) {
        Intrinsics.h(errorInfo, "errorInfo");
        e.a.q(this, errorInfo, mediaSource);
        u0(errorInfo.getErrorMessage());
    }

    public void onPlayerRelease(gn.e eVar) {
        e.a.t(this, eVar);
    }

    public void onPlayerReset() {
        e.a.v(this);
    }

    public void onPrepare(gn.e mediaSource) {
        e.a.w(this, mediaSource);
        com.transsion.player.orplayer.f mOrPlayer = getMOrPlayer();
        if (mOrPlayer != null) {
            mOrPlayer.play();
        }
    }

    public void onProgress(long j, gn.e eVar) {
        e.a.y(this, j, eVar);
    }

    public void onRenderFirstFrame() {
        e.a.A(this);
        this.isAdMaterialShow.set(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        if (com.transsion.ad.scene.c.a.d(this.mSceneId)) {
            b.a.c(this, 0, "onResume() --> 重新进入页面的时候需要校验一下，isVipSkipAd == true", (String) null, false, 13, (Object) null);
            finish();
        }
    }

    public void onSetDataSource() {
        e.a.B(this);
    }

    public void onTracksAudioBitrateChange(int i) {
        e.a.C(this, i);
    }

    public void onTracksChange(qn.c cVar) {
        e.a.D(this, cVar);
    }

    public void onTracksVideoBitrateChange(int i) {
        e.a.E(this, i);
    }

    public void onVideoPause(gn.e mediaSource) {
        e.a.F(this, mediaSource);
    }

    public void onVideoSizeChanged(int i, int i2) {
        e.a.H(this, i, i2);
    }

    public void onVideoStart(gn.e mediaSource) {
        e.a.I(this, mediaSource);
    }

    public void onVisibilityChanged(boolean isVisible) {
        com.transsion.player.orplayer.f mOrPlayer;
        if (!this.isInScreen && isVisible) {
            X();
        }
        this.isInScreen = isVisible;
        if (!isVisible) {
            com.transsion.player.orplayer.f mOrPlayer2 = getMOrPlayer();
            if (mOrPlayer2 != null) {
                mOrPlayer2.pause();
            }
            z0();
            w0();
            return;
        }
        if (this.displayTimestamp == 0) {
            this.displayTimestamp = SystemClock.elapsedRealtime();
            J0();
        }
        com.transsion.player.orplayer.f mOrPlayer3 = getMOrPlayer();
        if (mOrPlayer3 != null && !mOrPlayer3.isPlaying() && (mOrPlayer = getMOrPlayer()) != null) {
            mOrPlayer.play();
        }
        if (this.isReportAdDisplay.get() || !this.isAdMaterialShow.get()) {
            return;
        }
        this.isReportAdDisplay.set(true);
        a0();
    }

    public abstract FrameLayout p0();

    public abstract void r0();

    public void setOnSeekCompleteListener() {
        e.a.K(this);
    }

    public void t0(AppCompatImageView imageView, Integer width, Integer height) {
    }

    public abstract void y0(int i);
}
