package com.hisavana.adxlibrary.excuter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import b7.e;
import com.cloud.hisavana.sdk.api.adx.TSplashView;
import com.cloud.hisavana.sdk.api.listener.d;
import com.cloud.hisavana.sdk.common.bean.AdActiveInfo;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.hisavana.common.base.WrapTadView;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.interfacz.OnSkipListener;
import com.hisavana.common.interfacz.TAdditionalListener;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bridge.holder.JsAdHolderHandlerKt;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import ee.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0006*\u0002RV\u0018\u0000 Z2\u00020\u0001:\u00012B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u001a\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001c¢\u0006\u0004\b%\u0010\u001fJ\r\u0010&\u001a\u00020\u000b¢\u0006\u0004\b&\u0010'J!\u0010,\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\r\u0010/\u001a\u00020.¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u000b¢\u0006\u0004\b1\u0010'J\u000f\u00102\u001a\u00020\u000bH\u0002¢\u0006\u0004\b2\u0010'J\u000f\u00103\u001a\u00020\u000bH\u0002¢\u0006\u0004\b3\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00104R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00105R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006["}, d2 = {"Lcom/hisavana/adxlibrary/excuter/AdxWrapperSplash;", TtmlNode.ANONYMOUS_REGION_ID, "Landroid/content/Context;", "context", TtmlNode.ANONYMOUS_REGION_ID, "appId", "adUnit", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", TtmlNode.ANONYMOUS_REGION_ID, "logoLayoutHeightRatio", TtmlNode.ANONYMOUS_REGION_ID, "setLogoLayoutHeightRatio", "(Ljava/lang/Float;)V", "Lcom/hisavana/common/interfacz/TAdditionalListener;", "listener", "setAdditionalListener", "(Lcom/hisavana/common/interfacz/TAdditionalListener;)Lcom/hisavana/adxlibrary/excuter/AdxWrapperSplash;", "Lcom/hisavana/common/interfacz/OnSkipListener;", "setSkipListener", "(Lcom/hisavana/common/interfacz/OnSkipListener;)Lcom/hisavana/adxlibrary/excuter/AdxWrapperSplash;", JsAdHolderHandlerKt.GAME_NAME, JsAdHolderHandlerKt.GAME_SCENE, TtmlNode.ANONYMOUS_REGION_ID, "Ljava/lang/Object;", "extInfo", "setAdLoadScenes", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/hisavana/adxlibrary/excuter/AdxWrapperSplash;", TtmlNode.ANONYMOUS_REGION_ID, "isContainVulgarContent", "setContainVulgarContent", "(Z)Lcom/hisavana/adxlibrary/excuter/AdxWrapperSplash;", TtmlNode.ANONYMOUS_REGION_ID, "mode", "setSplashMode", "(I)Lcom/hisavana/adxlibrary/excuter/AdxWrapperSplash;", "debug", "setDebug", "loadAd", "()V", "Lcom/hisavana/common/base/WrapTadView;", "adContainer", "Landroid/view/View;", "logoLayout", "showAd", "(Lcom/hisavana/common/base/WrapTadView;Landroid/view/View;)V", TtmlNode.ANONYMOUS_REGION_ID, "getEcpmPrice", "()D", "destroy", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/content/Context;", "Ljava/lang/String;", "c", "Lb7/e;", "d", "Lb7/e;", "tSplash", "Lcom/cloud/hisavana/sdk/api/adx/TSplashView;", "e", "Lcom/cloud/hisavana/sdk/api/adx/TSplashView;", "tSplashView", "f", "I", "splashMode", g.b, "Z", "isDebug", "h", "Lcom/hisavana/common/interfacz/TAdditionalListener;", "additionalListener", "i", "Lcom/hisavana/common/interfacz/OnSkipListener;", "adSkipListener", j.b, "Ljava/lang/Float;", "mLogoLayoutHeightRatio", "Lcom/hisavana/common/bean/AdditionalInfo;", CampaignEx.JSON_KEY_AD_K, "Lcom/hisavana/common/bean/AdditionalInfo;", "additionalInfo", "com/hisavana/adxlibrary/excuter/AdxWrapperSplash$b", "l", "Lcom/hisavana/adxlibrary/excuter/AdxWrapperSplash$b;", "adListener", "com/hisavana/adxlibrary/excuter/AdxWrapperSplash$c", "m", "Lcom/hisavana/adxlibrary/excuter/AdxWrapperSplash$c;", "skipListener", "Companion", "ssp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class AdxWrapperSplash {
    public static final String TAG = "AdxWrapperSplash";

    /* renamed from: a, reason: from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: from kotlin metadata */
    public final String appId;

    /* renamed from: c, reason: from kotlin metadata */
    public final String adUnit;

    /* renamed from: d, reason: from kotlin metadata */
    public e tSplash;

    /* renamed from: e, reason: from kotlin metadata */
    public TSplashView tSplashView;

    /* renamed from: f, reason: from kotlin metadata */
    public int splashMode;

    /* renamed from: g, reason: from kotlin metadata */
    public boolean isDebug;

    /* renamed from: h, reason: from kotlin metadata */
    public TAdditionalListener additionalListener;

    /* renamed from: i, reason: from kotlin metadata */
    public OnSkipListener adSkipListener;

    /* renamed from: j, reason: from kotlin metadata */
    public Float mLogoLayoutHeightRatio;

    /* renamed from: k, reason: from kotlin metadata */
    public final AdditionalInfo additionalInfo;

    /* renamed from: l, reason: from kotlin metadata */
    public final b adListener;

    /* renamed from: m, reason: from kotlin metadata */
    public final c skipListener;

    public static final class b extends d {
        public b() {
        }

        public void onAdActivate(AdActiveInfo adActiveInfo) {
            super.onAdActivate(adActiveInfo);
            AdLogUtil.Log().i(AdxWrapperSplash.TAG, "AdxWrapperSplash --> onAdActivate");
            AdxWrapperSplash.this.additionalInfo.setEcpm(adActiveInfo != null ? adActiveInfo.getEcpm() : null);
            AdxWrapperSplash.this.additionalInfo.setPackageName(adActiveInfo != null ? adActiveInfo.getPackageName() : null);
            AdxWrapperSplash.this.additionalInfo.setImageUrl(adActiveInfo != null ? adActiveInfo.getImageUrl() : null);
            TAdditionalListener tAdditionalListener = AdxWrapperSplash.this.additionalListener;
            if (tAdditionalListener != null) {
                tAdditionalListener.onAdActivate(AdxWrapperSplash.this.additionalInfo);
            }
        }

        public void onAdClicked() {
            super.onAdClicked();
            AdLogUtil.Log().i(AdxWrapperSplash.TAG, "AdxWrapperSplash --> onAdClicked");
            TAdditionalListener tAdditionalListener = AdxWrapperSplash.this.additionalListener;
            if (tAdditionalListener != null) {
                tAdditionalListener.onClick(null, AdxWrapperSplash.this.additionalInfo);
            }
        }

        public void onAdClosed() {
            super.onAdClosed();
            AdLogUtil.Log().i(AdxWrapperSplash.TAG, "AdxWrapperSplash --> onAdClosed");
            TAdditionalListener tAdditionalListener = AdxWrapperSplash.this.additionalListener;
            if (tAdditionalListener != null) {
                tAdditionalListener.onClosed(0);
            }
        }

        public void onAdLoaded() {
            Double valueOf;
            TSplashView tSplashView;
            super.onAdLoaded();
            int i = AdxWrapperSplash.this.splashMode;
            if (i != 1) {
                if (i == 2 && (tSplashView = AdxWrapperSplash.this.tSplashView) != null) {
                    valueOf = Double.valueOf(tSplashView.getBidPrice());
                }
                valueOf = null;
            } else {
                e eVar = AdxWrapperSplash.this.tSplash;
                if (eVar != null) {
                    valueOf = Double.valueOf(eVar.e());
                }
                valueOf = null;
            }
            AdxWrapperSplash.this.additionalInfo.setEcpm(valueOf);
            AdLogUtil.Log().i(AdxWrapperSplash.TAG, "AdxWrapperSplash --> onAdLoaded, ecpm: " + valueOf);
            TAdditionalListener tAdditionalListener = AdxWrapperSplash.this.additionalListener;
            if (tAdditionalListener != null) {
                tAdditionalListener.onLoadSuccess(AdxWrapperSplash.this.additionalInfo);
            }
        }

        public void onAdShow() {
            super.onAdShow();
            AdLogUtil.Log().i(AdxWrapperSplash.TAG, "AdxWrapperSplash --> onAdShow");
            TAdditionalListener tAdditionalListener = AdxWrapperSplash.this.additionalListener;
            if (tAdditionalListener != null) {
                tAdditionalListener.onShow(null, AdxWrapperSplash.this.additionalInfo);
            }
        }

        public void onAdShowError(TaErrorCode taErrorCode) {
            super.onAdShowError(taErrorCode);
            TAdditionalListener tAdditionalListener = AdxWrapperSplash.this.additionalListener;
            if (tAdditionalListener != null) {
                tAdditionalListener.onShowError(new TAdErrorCode(taErrorCode != null ? taErrorCode.getErrorCode() : -1, taErrorCode != null ? taErrorCode.getErrorMessage() : null), AdxWrapperSplash.this.additionalInfo);
            }
        }

        public void onError(TaErrorCode taErrorCode) {
            super.onError(taErrorCode);
            TAdditionalListener tAdditionalListener = AdxWrapperSplash.this.additionalListener;
            if (tAdditionalListener != null) {
                tAdditionalListener.onLoadFailure(new TAdErrorCode(taErrorCode != null ? taErrorCode.getErrorCode() : -1, taErrorCode != null ? taErrorCode.getErrorMessage() : null), AdxWrapperSplash.this.additionalInfo);
            }
        }
    }

    public static final class c implements com.cloud.hisavana.sdk.api.listener.g {
        public c() {
        }

        public void a() {
            AdLogUtil.Log().i(AdxWrapperSplash.TAG, "AdxWrapperSplash --> onTimeEnd");
            OnSkipListener onSkipListener = AdxWrapperSplash.this.adSkipListener;
            if (onSkipListener != null) {
                onSkipListener.onTimeReach();
            }
        }

        public void onClick() {
            AdLogUtil.Log().i(AdxWrapperSplash.TAG, "AdxWrapperSplash --> onClick");
            OnSkipListener onSkipListener = AdxWrapperSplash.this.adSkipListener;
            if (onSkipListener != null) {
                onSkipListener.onClick();
            }
        }
    }

    public AdxWrapperSplash(Context context, String str, String str2) {
        Intrinsics.h(context, "context");
        this.context = context;
        this.appId = str;
        this.adUnit = str2;
        this.splashMode = 1;
        AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setPlacementId(str2);
        additionalInfo.setCodeSeatId(str2);
        additionalInfo.setSource(0);
        this.additionalInfo = additionalInfo;
        this.adListener = new b();
        this.skipListener = new c();
    }

    public final void a() {
        e eVar = new e(this.context, this.adUnit);
        this.tSplash = eVar;
        eVar.p(this.adListener);
        e eVar2 = this.tSplash;
        if (eVar2 != null) {
            eVar2.x(this.skipListener);
        }
        e eVar3 = this.tSplash;
        if (eVar3 != null) {
            eVar3.o(0);
        }
    }

    public final void b() {
        TSplashView tSplashView = new TSplashView(this.context, this.adUnit);
        this.tSplashView = tSplashView;
        tSplashView.setListener(this.adListener);
        TSplashView tSplashView2 = this.tSplashView;
        if (tSplashView2 != null) {
            tSplashView2.setSkipListener(this.skipListener);
        }
        TSplashView tSplashView3 = this.tSplashView;
        if (tSplashView3 != null) {
            tSplashView3.setDefaultFillTimeoutDuration(0);
        }
    }

    public final void destroy() {
        e eVar = this.tSplash;
        if (eVar != null) {
            eVar.c();
        }
        TSplashView tSplashView = this.tSplashView;
        if (tSplashView != null) {
            tSplashView.destroy();
        }
    }

    public final double getEcpmPrice() {
        if (this.splashMode == 1) {
            e eVar = this.tSplash;
            if (eVar != null) {
                return eVar.e();
            }
        } else {
            TSplashView tSplashView = this.tSplashView;
            if (tSplashView != null) {
                return tSplashView.getBidPrice();
            }
        }
        return 0.0d;
    }

    public final void loadAd() {
        e u;
        TSplashView tSplashView;
        TSplashView liteInit;
        AdLogUtil.Log().i(TAG, "AdxWrapperSplash --> loadAd, splashMode: " + this.splashMode);
        int i = this.splashMode;
        if (i != 1) {
            if (i != 2 || (tSplashView = this.tSplashView) == null || (liteInit = tSplashView.setLiteInit(this.appId, this.isDebug)) == null) {
                return;
            }
            liteInit.loadAd();
            return;
        }
        e eVar = this.tSplash;
        if (eVar == null || (u = eVar.u(this.appId, this.isDebug)) == null) {
            return;
        }
        u.t();
    }

    public final AdxWrapperSplash setAdLoadScenes(String gameName, String gameScene, Map<String, ? extends Object> extInfo) {
        e eVar = this.tSplash;
        if (eVar != null) {
            eVar.l(gameName, gameScene, extInfo);
        }
        TSplashView tSplashView = this.tSplashView;
        if (tSplashView != null) {
            tSplashView.setAdLoadScenes(gameName, gameScene, extInfo);
        }
        return this;
    }

    public final AdxWrapperSplash setAdditionalListener(TAdditionalListener listener) {
        this.additionalListener = listener;
        return this;
    }

    public final AdxWrapperSplash setContainVulgarContent(boolean isContainVulgarContent) {
        e eVar = this.tSplash;
        if (eVar != null) {
            eVar.m(isContainVulgarContent);
        }
        TSplashView tSplashView = this.tSplashView;
        if (tSplashView != null) {
            tSplashView.setContainVulgarContent(isContainVulgarContent);
        }
        return this;
    }

    public final AdxWrapperSplash setDebug(boolean debug) {
        this.isDebug = debug;
        return this;
    }

    public final void setLogoLayoutHeightRatio(Float logoLayoutHeightRatio) {
        this.mLogoLayoutHeightRatio = logoLayoutHeightRatio;
    }

    public final AdxWrapperSplash setSkipListener(OnSkipListener listener) {
        this.adSkipListener = listener;
        return this;
    }

    public final AdxWrapperSplash setSplashMode(int mode) {
        this.splashMode = mode;
        if (mode == 1) {
            a();
        } else if (mode == 2) {
            b();
        }
        return this;
    }

    public final void showAd(WrapTadView adContainer, View logoLayout) {
        View view;
        int i = this.splashMode;
        if (i == 1) {
            e eVar = this.tSplash;
            if (eVar != null) {
                eVar.w(this.mLogoLayoutHeightRatio);
            }
            e eVar2 = this.tSplash;
            if (eVar2 != null) {
                eVar2.v(logoLayout);
            }
            e eVar3 = this.tSplash;
            if (eVar3 != null) {
                eVar3.y();
                return;
            }
            return;
        }
        if (i == 2 && (view = this.tSplashView) != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            if (adContainer != null) {
                adContainer.removeAllViews();
            }
            Float f = this.mLogoLayoutHeightRatio;
            float floatValue = f != null ? f.floatValue() : 0.2f;
            AdLogUtil.Log().i(TAG, "mediation sdk adxWrapperSplash view addLogoLayout heightRatio = " + floatValue);
            int i2 = logoLayout != null ? (int) (Resources.getSystem().getDisplayMetrics().heightPixels * floatValue) : 0;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(0, 0, 0, i2);
            if (adContainer != null) {
                adContainer.addView(view, layoutParams);
            }
            if (adContainer != null) {
                adContainer.setVisibility(0);
            }
            if (logoLayout != null) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, i2);
                layoutParams2.addRule(12);
                if (adContainer != null) {
                    adContainer.addView(logoLayout, layoutParams2);
                }
            }
            view.show();
        }
    }
}
