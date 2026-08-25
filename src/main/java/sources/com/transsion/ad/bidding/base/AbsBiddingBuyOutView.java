package com.transsion.ad.bidding.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blankj.utilcode.util.a0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.ad.strategy.t;
import com.transsion.player.config.RenderType;
import com.transsion.player.enum.PlayMimeType;
import com.transsion.player.enum.ScaleMode;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xh.b;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b\"\u0010#J\u0011\u0010$\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u001dH&¢\u0006\u0004\b&\u0010'J\u0015\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b.\u0010/J\u0011\u00100\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u0004\u0018\u000102¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u000108¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u0004\u0018\u000108¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\bA\u0010BJ\u0017\u0010E\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u0004\u0018\u00010C¢\u0006\u0004\bG\u0010HJ\r\u0010I\u001a\u00020\n¢\u0006\u0004\bI\u0010\fJ\r\u0010J\u001a\u00020\n¢\u0006\u0004\bJ\u0010\fJ\u0015\u0010K\u001a\u00020\n2\u0006\u0010K\u001a\u00020\u001d¢\u0006\u0004\bK\u0010 J\u0015\u0010M\u001a\u00020\n2\u0006\u0010L\u001a\u00020\u001d¢\u0006\u0004\bM\u0010 J\r\u0010N\u001a\u00020\n¢\u0006\u0004\bN\u0010\fJ\u0019\u0010P\u001a\u00020\n2\b\u0010O\u001a\u0004\u0018\u00010,H\u0004¢\u0006\u0004\bP\u0010/J\r\u0010Q\u001a\u00020\n¢\u0006\u0004\bQ\u0010\fJ\r\u0010R\u001a\u00020\n¢\u0006\u0004\bR\u0010\fR\u0018\u0010U\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\\R\u0018\u0010^\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010]R\u0018\u0010`\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010aR\u0016\u0010e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010fR\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010L\u001a\u00020k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010q\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010dR\u0016\u0010K\u001a\u00020k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010mR\u0016\u0010u\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010t¨\u0006v"}, d2 = {"Lcom/transsion/ad/bidding/base/AbsBiddingBuyOutView;", "Landroid/widget/FrameLayout;", "Lcom/transsion/ad/strategy/t$a;", "Lxh/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", TtmlNode.ANONYMOUS_REGION_ID, "d", "()V", TtmlNode.ANONYMOUS_REGION_ID, "displayTimestamp", "e", "(J)V", "Lcom/transsion/ad/monopoly/model/AdMaterialList;", "adMaterialList", "i", "(Lcom/transsion/ad/monopoly/model/AdMaterialList;)V", ee.g.b, "Landroid/widget/ImageView;", "imageView", "setVolumeImage", "(Landroid/widget/ImageView;)V", "Lcom/transsion/player/orplayer/f;", "getOrPlayer", "()Lcom/transsion/player/orplayer/f;", TtmlNode.ANONYMOUS_REGION_ID, "isVisible", "onVisibilityChanged", "(Z)V", "Landroid/view/View;", "getVisibilityView", "()Landroid/view/View;", "getMediaContainer", "()Landroid/widget/FrameLayout;", "isShowVolumeIcon", "()Z", "Landroid/widget/ImageView$ScaleType;", "scaleType", "setScaleType", "(Landroid/widget/ImageView$ScaleType;)V", TtmlNode.ANONYMOUS_REGION_ID, "sceneId", "setSceneId", "(Ljava/lang/String;)V", "getSceneId", "()Ljava/lang/String;", "Loh/a;", "listener", "setListener", "(Loh/a;)V", "getListener", "()Loh/a;", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "maxEcpmObject", "setEcpmObject", "(Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;)V", "Lcom/transsion/ad/monopoly/model/AdPlans;", "getAdPlans", "()Lcom/transsion/ad/monopoly/model/AdPlans;", "getMaxEcpmObject", "()Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "getAdMaterialList", "()Lcom/transsion/ad/monopoly/model/AdMaterialList;", "Lcom/transsion/ad/ps/model/RecommendInfo;", "recommendInfo", "setRecommendInfo", "(Lcom/transsion/ad/ps/model/RecommendInfo;)V", "getRecommendInfo", "()Lcom/transsion/ad/ps/model/RecommendInfo;", "destroy", "reset", "isReportAdDisplay", "isAdMaterialShow", "setAdMaterialShow", "onAdClick", "errorMsg", "f", "addSession", "showMedia", "a", "Ljava/lang/String;", "mSceneId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Loh/a;", "mListener", "c", "Lcom/transsion/ad/monopoly/model/AdPlans;", "mAdPlans", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "Lcom/transsion/ad/monopoly/model/AdMaterialList;", "mAdMaterialList", "Lcom/transsion/ad/ps/model/RecommendInfo;", "mRecommendInfo", "Lcom/transsion/player/orplayer/f;", "mOrPlayer", "h", "Z", "mIsMute", "Landroid/widget/ImageView;", "Landroid/view/TextureView;", com.mbridge.msdk.foundation.same.report.j.b, "Landroid/view/TextureView;", "textureView", "Ljava/util/concurrent/atomic/AtomicBoolean;", CampaignEx.JSON_KEY_AD_K, "Ljava/util/concurrent/atomic/AtomicBoolean;", "l", "Landroid/widget/ImageView$ScaleType;", "m", "isInScreen", "n", "o", "J", "showTimestamp", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class AbsBiddingBuyOutView extends FrameLayout implements t.a, xh.b {

    /* renamed from: a, reason: from kotlin metadata */
    private String mSceneId;

    /* renamed from: b, reason: from kotlin metadata */
    private oh.a mListener;

    /* renamed from: c, reason: from kotlin metadata */
    private AdPlans mAdPlans;

    /* renamed from: d, reason: from kotlin metadata */
    private BiddingIntermediateMaterialBean maxEcpmObject;

    /* renamed from: e, reason: from kotlin metadata */
    private AdMaterialList mAdMaterialList;

    /* renamed from: f, reason: from kotlin metadata */
    private RecommendInfo mRecommendInfo;

    /* renamed from: g, reason: from kotlin metadata */
    private com.transsion.player.orplayer.f mOrPlayer;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean mIsMute;

    /* renamed from: i, reason: from kotlin metadata */
    private final ImageView imageView;

    /* renamed from: j, reason: from kotlin metadata */
    private final TextureView textureView;

    /* renamed from: k, reason: from kotlin metadata */
    private AtomicBoolean isAdMaterialShow;

    /* renamed from: l, reason: from kotlin metadata */
    private ImageView.ScaleType scaleType;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean isInScreen;

    /* renamed from: n, reason: from kotlin metadata */
    private AtomicBoolean isReportAdDisplay;

    /* renamed from: o, reason: from kotlin metadata */
    private long showTimestamp;

    public static final class a implements com.transsion.player.orplayer.e {
        final /* synthetic */ com.transsion.player.orplayer.f b;

        a(com.transsion.player.orplayer.f fVar) {
            this.b = fVar;
        }

        public void initPlayer() {
            e.a.b(this);
        }

        public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
            e.a.c(this, eVar);
        }

        public void onBufferedPosition(long j, gn.e eVar) {
            e.a.d(this, j, eVar);
        }

        public void onCompletion(gn.e eVar) {
            e.a.e(this, eVar);
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

        public void onLoopingStart() {
            e.a.o(this);
        }

        public void onMediaItemTransition(String str) {
            e.a.p(this, str);
        }

        public void onPlayError(PlayError playError, gn.e eVar) {
            Intrinsics.h(playError, "errorInfo");
            e.a.q(this, playError, eVar);
            AbsBiddingBuyOutView.this.f(playError.getErrorMessage());
        }

        public void onPlayerRelease(gn.e eVar) {
            e.a.t(this, eVar);
        }

        public void onPlayerReset() {
            e.a.v(this);
        }

        public void onPrepare(gn.e eVar) {
            e.a.w(this, eVar);
            this.b.play();
        }

        public void onProgress(long j, gn.e eVar) {
            e.a.y(this, j, eVar);
        }

        public void onRenderFirstFrame() {
            e.a.A(this);
            AbsBiddingBuyOutView.this.isAdMaterialShow.set(true);
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

        public void onVideoPause(gn.e eVar) {
            e.a.F(this, eVar);
        }

        public void onVideoSizeChanged(int i, int i2) {
            e.a.H(this, i, i2);
        }

        public void onVideoStart(gn.e eVar) {
            e.a.I(this, eVar);
        }

        public void setOnSeekCompleteListener() {
            e.a.K(this);
        }
    }

    public static final class b implements RequestListener {
        b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z) {
            Intrinsics.h(drawable, "resource");
            Intrinsics.h(obj, "model");
            Intrinsics.h(target, "target");
            Intrinsics.h(dataSource, "dataSource");
            if (drawable instanceof GifDrawable) {
                ((GifDrawable) drawable).start();
            }
            AbsBiddingBuyOutView.this.isAdMaterialShow.set(true);
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
            Intrinsics.h(target, "target");
            AbsBiddingBuyOutView.this.f("图片加载失败 -->" + (glideException != null ? glideException.getMessage() : null));
            return false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbsBiddingBuyOutView(Context context) {
        this(context, r0, 2, r0);
        Intrinsics.h(context, "context");
        AttributeSet attributeSet = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbsBiddingBuyOutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.mIsMute = true;
        this.imageView = new ImageView(getContext());
        this.textureView = new TextureView(getContext());
        this.isAdMaterialShow = new AtomicBoolean(false);
        this.scaleType = ImageView.ScaleType.FIT_CENTER;
        setOnClickListener(new ci.g(0L, new Function1() { // from class: com.transsion.ad.bidding.base.s
            public final Object invoke(Object obj) {
                Unit c;
                c = AbsBiddingBuyOutView.c(AbsBiddingBuyOutView.this, (View) obj);
                return c;
            }
        }, 1, (DefaultConstructorMarker) null));
        this.isReportAdDisplay = new AtomicBoolean(false);
    }

    public /* synthetic */ AbsBiddingBuyOutView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(AbsBiddingBuyOutView absBiddingBuyOutView, View view) {
        Intrinsics.h(view, "it");
        absBiddingBuyOutView.onAdClick();
        return Unit.a;
    }

    private final void d() {
        oh.a mListener;
        oh.a mListener2;
        if (getMAdPlans() != null && (mListener2 = getMListener()) != null) {
            mListener2.c(this.maxEcpmObject);
        }
        RecommendInfo mRecommendInfo = getMRecommendInfo();
        if (mRecommendInfo == null || (mListener = getMListener()) == null) {
            return;
        }
        mListener.t(mRecommendInfo);
    }

    private final void e(long displayTimestamp) {
        oh.a mListener;
        oh.a mListener2;
        if (getMAdPlans() != null && (mListener2 = getMListener()) != null) {
            mListener2.d(this.maxEcpmObject, displayTimestamp);
        }
        RecommendInfo mRecommendInfo = getMRecommendInfo();
        if (mRecommendInfo == null || (mListener = getMListener()) == null) {
            return;
        }
        mListener.s(mRecommendInfo, displayTimestamp);
    }

    private final void g(AdMaterialList adMaterialList) {
        MbAdVideo video;
        String path;
        MbAdVideo video2;
        String path2;
        MbAdVideo video3;
        String url;
        MbAdVideo video4;
        String url2;
        MbAdVideo video5;
        FrameLayout mediaContainer = getMediaContainer();
        if (mediaContainer == null) {
            b.a.c(this, 6, "playVideo() --> getMediaContainer() == null", (String) null, false, 12, (Object) null);
            return;
        }
        com.transsion.player.orplayer.f mOrPlayer = getMOrPlayer();
        if (mOrPlayer != null) {
            mOrPlayer.release();
        }
        mediaContainer.removeAllViews();
        this.mIsMute = true;
        ci.q qVar = ci.q.a;
        qVar.a(this.textureView);
        mediaContainer.addView(this.textureView);
        if (isShowVolumeIcon()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a0.a(24.0f), a0.a(24.0f));
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = a0.a(8.0f);
            layoutParams.setMarginEnd(a0.a(8.0f));
            this.imageView.setTag("adVolumeImage");
            this.imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.bidding.base.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AbsBiddingBuyOutView.h(AbsBiddingBuyOutView.this, view);
                }
            });
            setVolumeImage(this.imageView);
            qVar.a(this.imageView);
            mediaContainer.addView(this.imageView, layoutParams);
        }
        Context context = mediaContainer.getContext();
        Intrinsics.g(context, "getContext(...)");
        com.transsion.player.orplayer.f a2 = new f.a(context).b(new hn.d((RenderType) null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, (String) null, 94207, (DefaultConstructorMarker) null)).a();
        a2.setMute(true);
        a2.setTextureView(this.textureView);
        a2.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
        a2.setLooping(true);
        a2.setPlayerListener(new a(a2));
        this.mOrPlayer = a2;
        if (TextUtils.isEmpty((adMaterialList == null || (video5 = adMaterialList.getVideo()) == null) ? null : video5.getPath())) {
            com.transsion.player.orplayer.f fVar = this.mOrPlayer;
            if (fVar != null) {
                fVar.setDataSource(new gn.e((adMaterialList == null || (video4 = adMaterialList.getVideo()) == null || (url2 = video4.getUrl()) == null) ? TtmlNode.ANONYMOUS_REGION_ID : url2, (adMaterialList == null || (video3 = adMaterialList.getVideo()) == null || (url = video3.getUrl()) == null) ? TtmlNode.ANONYMOUS_REGION_ID : url, 0, (PlayMimeType) null, (MediaItem) null, 28, (DefaultConstructorMarker) null));
            }
        } else {
            com.transsion.player.orplayer.f fVar2 = this.mOrPlayer;
            if (fVar2 != null) {
                fVar2.setDataSource(new gn.e((adMaterialList == null || (video2 = adMaterialList.getVideo()) == null || (path2 = video2.getPath()) == null) ? TtmlNode.ANONYMOUS_REGION_ID : path2, (adMaterialList == null || (video = adMaterialList.getVideo()) == null || (path = video.getPath()) == null) ? TtmlNode.ANONYMOUS_REGION_ID : path, 0, (PlayMimeType) null, (MediaItem) null, 28, (DefaultConstructorMarker) null));
            }
        }
        com.transsion.player.orplayer.f fVar3 = this.mOrPlayer;
        if (fVar3 != null) {
            fVar3.prepare();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AbsBiddingBuyOutView absBiddingBuyOutView, View view) {
        b.a.c(absBiddingBuyOutView, 3, "playVideo() --> 点击了音频按钮", (String) null, false, 4, (Object) null);
        boolean z = !absBiddingBuyOutView.mIsMute;
        absBiddingBuyOutView.mIsMute = z;
        com.transsion.player.orplayer.f fVar = absBiddingBuyOutView.mOrPlayer;
        if (fVar != null) {
            fVar.setMute(z);
        }
        absBiddingBuyOutView.setVolumeImage(absBiddingBuyOutView.imageView);
    }

    private final void i(AdMaterialList adMaterialList) {
        MbAdImage image;
        MbAdImage image2;
        FrameLayout mediaContainer = getMediaContainer();
        if (mediaContainer == null) {
            return;
        }
        Context context = mediaContainer.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !(activity.isFinishing() || activity.isDestroyed())) {
            mediaContainer.removeAllViews();
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(this.scaleType);
            String path = (adMaterialList == null || (image2 = adMaterialList.getImage()) == null) ? null : image2.getPath();
            Object url = (adMaterialList == null || (image = adMaterialList.getImage()) == null) ? null : image.getUrl();
            if (path != null) {
                String str = new File(path).exists() ? path : null;
                if (str != null) {
                    url = new File(str);
                }
            }
            try {
                Intrinsics.e(Glide.with(mediaContainer).load(url).listener(new b()).into(imageView));
            } catch (IllegalArgumentException e) {
                f("加载图片失败 --> " + e.getMessage());
            }
            mediaContainer.addView(imageView);
        }
    }

    private final void setVolumeImage(ImageView imageView) {
        if (this.mIsMute) {
            imageView.setImageResource(R$mipmap.ad_volumeoff);
        } else {
            imageView.setImageResource(R$mipmap.ad_volumeon);
        }
    }

    public final void addSession() {
        com.transsion.ad.strategy.t.a.j(this);
    }

    public final void destroy() {
        this.isReportAdDisplay.set(false);
        reset();
        com.transsion.ad.strategy.t.a.v(this);
    }

    protected final void f(String errorMsg) {
        oh.a mListener;
        if (getMAdPlans() != null) {
            BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = this.maxEcpmObject;
            if (biddingIntermediateMaterialBean != null) {
                biddingIntermediateMaterialBean.setErrorMsg(errorMsg);
            }
            oh.a mListener2 = getMListener();
            if (mListener2 != null) {
                mListener2.p(this.maxEcpmObject);
            }
        }
        RecommendInfo mRecommendInfo = getMRecommendInfo();
        if (mRecommendInfo == null || (mListener = getMListener()) == null) {
            return;
        }
        mListener.u(mRecommendInfo);
    }

    /* renamed from: getAdMaterialList, reason: from getter */
    public final AdMaterialList getMAdMaterialList() {
        return this.mAdMaterialList;
    }

    /* renamed from: getAdPlans, reason: from getter */
    public final AdPlans getMAdPlans() {
        return this.mAdPlans;
    }

    public String getClassTag() {
        return b.a.a(this);
    }

    /* renamed from: getListener, reason: from getter */
    public final oh.a getMListener() {
        return this.mListener;
    }

    public abstract /* synthetic */ String getLogTag();

    public final BiddingIntermediateMaterialBean getMaxEcpmObject() {
        return this.maxEcpmObject;
    }

    public abstract FrameLayout getMediaContainer();

    /* renamed from: getOrPlayer, reason: from getter */
    protected final com.transsion.player.orplayer.f getMOrPlayer() {
        return this.mOrPlayer;
    }

    /* renamed from: getRecommendInfo, reason: from getter */
    public final RecommendInfo getMRecommendInfo() {
        return this.mRecommendInfo;
    }

    /* renamed from: getSceneId, reason: from getter */
    public String getMSceneId() {
        return this.mSceneId;
    }

    public double getVisibilityThreshold() {
        return t.a.a.a(this);
    }

    public View getVisibilityView() {
        return getMediaContainer();
    }

    public final void isReportAdDisplay(boolean isReportAdDisplay) {
        this.isReportAdDisplay.set(isReportAdDisplay);
    }

    public abstract boolean isShowVolumeIcon();

    public final void onAdClick() {
        oh.a mListener;
        oh.a mListener2;
        if (getMAdPlans() != null && (mListener2 = getMListener()) != null) {
            mListener2.a(this.maxEcpmObject);
        }
        RecommendInfo mRecommendInfo = getMRecommendInfo();
        if (mRecommendInfo == null || (mListener = getMListener()) == null) {
            return;
        }
        mListener.r(mRecommendInfo);
    }

    public void onLog(int i, String str, String str2, boolean z) {
        b.a.b(this, i, str, str2, z);
    }

    public void onVisibilityChanged(boolean isVisible) {
        com.transsion.player.orplayer.f mOrPlayer;
        oh.a mListener;
        if (!this.isInScreen && isVisible && (mListener = getMListener()) != null) {
            mListener.f(this.maxEcpmObject);
        }
        this.isInScreen = isVisible;
        if (!isVisible) {
            if (this.showTimestamp > 0) {
                e(SystemClock.elapsedRealtime() - this.showTimestamp);
            }
            this.showTimestamp = 0L;
            com.transsion.player.orplayer.f mOrPlayer2 = getMOrPlayer();
            if (mOrPlayer2 != null) {
                mOrPlayer2.pause();
                return;
            }
            return;
        }
        if (this.showTimestamp == 0) {
            this.showTimestamp = SystemClock.elapsedRealtime();
        }
        if (!this.isReportAdDisplay.get() && this.isAdMaterialShow.get()) {
            this.isReportAdDisplay.set(true);
            d();
        }
        com.transsion.player.orplayer.f mOrPlayer3 = getMOrPlayer();
        if (mOrPlayer3 == null || mOrPlayer3.isPlaying() || (mOrPlayer = getMOrPlayer()) == null) {
            return;
        }
        mOrPlayer.play();
    }

    public final void reset() {
        if (this.showTimestamp > 0) {
            e(SystemClock.elapsedRealtime() - this.showTimestamp);
        }
        setListener(null);
        removeAllViews();
        com.transsion.player.orplayer.f fVar = this.mOrPlayer;
        if (fVar != null) {
            fVar.release();
        }
    }

    public final void setAdMaterialShow(boolean isAdMaterialShow) {
        this.isAdMaterialShow.set(isAdMaterialShow);
    }

    public final void setEcpmObject(BiddingIntermediateMaterialBean maxEcpmObject) {
        List adMaterialList;
        List adMaterialList2;
        this.maxEcpmObject = maxEcpmObject;
        AdMaterialList adMaterialList3 = null;
        AdPlans plans = maxEcpmObject != null ? maxEcpmObject.getPlans() : null;
        this.mAdPlans = plans;
        if (plans == null || (adMaterialList = plans.getAdMaterialList()) == null || !(!adMaterialList.isEmpty())) {
            return;
        }
        AdPlans adPlans = this.mAdPlans;
        if (adPlans != null && (adMaterialList2 = adPlans.getAdMaterialList()) != null) {
            adMaterialList3 = (AdMaterialList) adMaterialList2.get(0);
        }
        this.mAdMaterialList = adMaterialList3;
    }

    public final void setListener(oh.a listener) {
        this.mListener = listener;
    }

    public final void setRecommendInfo(RecommendInfo recommendInfo) {
        this.mRecommendInfo = recommendInfo;
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        Intrinsics.h(scaleType, "scaleType");
        this.scaleType = scaleType;
    }

    public final void setSceneId(String sceneId) {
        this.mSceneId = sceneId;
    }

    public final void showMedia() {
        if (getMAdMaterialList() == null) {
            return;
        }
        AdMaterialList mAdMaterialList = getMAdMaterialList();
        if (Intrinsics.c(mAdMaterialList != null ? mAdMaterialList.getType() : null, "TextAdMaterial")) {
            i(getMAdMaterialList());
        } else {
            g(getMAdMaterialList());
        }
        addSession();
    }
}
