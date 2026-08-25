package com.bytedance.sdk.openadsdk.api.banner;

import android.content.Context;
import com.bytedance.sdk.openadsdk.utils.TKC;
import com.cloud.hisavana.abtestkit.db.ABContentProvider;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class PAGBannerSize {
    private int EjP;
    private int Sj;
    private int TKC = 1;
    private int sP;
    public static final PAGBannerSize BANNER_W_320_H_50 = new PAGBannerSize(320, 50);
    public static final PAGBannerSize BANNER_W_300_H_250 = new PAGBannerSize(ABContentProvider.AB_SUCCESS, 250);
    public static final PAGBannerSize BANNER_W_728_H_90 = new PAGBannerSize(728, 90);

    public PAGBannerSize(int i, int i2) {
        this.Sj = i;
        this.sP = i2;
    }

    public static PAGBannerSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(Context context, int i) {
        int Sj = TKC.Sj(context, i, 0);
        if (Sj == TKC.Sj) {
            return new PAGBannerSize(-1, -1);
        }
        PAGBannerSize pAGBannerSize = new PAGBannerSize(i, Sj);
        pAGBannerSize.TKC = 2;
        return pAGBannerSize;
    }

    public static PAGBannerSize getCurrentOrientationInlineAdaptiveBannerAdSize(Context context, int i) {
        int Sj = TKC.Sj(context, 0);
        if (Sj == TKC.Sj) {
            return new PAGBannerSize(-1, -1);
        }
        PAGBannerSize pAGBannerSize = new PAGBannerSize(i, 0);
        pAGBannerSize.EjP = Sj;
        pAGBannerSize.TKC = 3;
        return pAGBannerSize;
    }

    public static PAGBannerSize getInlineAdaptiveBannerAdSize(int i, int i2) {
        PAGBannerSize pAGBannerSize = new PAGBannerSize(i, 0);
        pAGBannerSize.EjP = i2;
        pAGBannerSize.TKC = 3;
        return pAGBannerSize;
    }

    public int getHeight() {
        return this.sP;
    }

    public int getMaxHeight() {
        return this.EjP;
    }

    public int getType() {
        return this.TKC;
    }

    public int getWidth() {
        return this.Sj;
    }
}
