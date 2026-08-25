package com.hisavana.mintegral.bidding;

import android.content.Context;
import android.os.Looper;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.common.base.BaseQueryPrice;
import com.hisavana.common.bean.Network;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.IBidWithNotify;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mintegral.bidding.MintegralBidding;
import com.hisavana.mintegral.check.ExistsCheck;
import com.hisavana.mintegral.check.MBridgeSDKManager;
import com.mbridge.msdk.mbbid.out.BannerBidRequestParams;
import com.mbridge.msdk.mbbid.out.BidListennning;
import com.mbridge.msdk.mbbid.out.BidLossCode;
import com.mbridge.msdk.mbbid.out.BidManager;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.mbbid.out.SplashBidRequestParams;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class MintegralBidding extends BaseQueryPrice {
    private int a;
    int b;
    int c;

    /* renamed from: com.hisavana.mintegral.bidding.MintegralBidding$2, reason: invalid class name */
    class AnonymousClass2 implements BidListennning {
        final /* synthetic */ long a;
        final /* synthetic */ Network b;

        AnonymousClass2(long j, Network network) {
            this.a = j;
            this.b = network;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            if (((BaseQueryPrice) MintegralBidding.this).mQueryPriceListener != null) {
                ((BaseQueryPrice) MintegralBidding.this).mQueryPriceListener.onQueryPriceFailed();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Network network) {
            if (((BaseQueryPrice) MintegralBidding.this).mQueryPriceListener != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(network);
                ((BaseQueryPrice) MintegralBidding.this).mQueryPriceListener.onQueryPriceSuccess(arrayList);
            }
        }

        public void onFailed(String str) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            AdLogUtil.Log().d("mintegral_log", "*---->mintegral bidding request fail --- : " + this.b.getCodeSeatId() + " | " + str + ",time use:" + currentTimeMillis);
            if (this.b == null) {
                return;
            }
            MintegralBidding.this.trackingBiddingFailed(30006, str);
            Preconditions.d(new Preconditions.a() { // from class: com.hisavana.mintegral.bidding.b
                public final void onRun() {
                    MintegralBidding.AnonymousClass2.this.c();
                }
            });
        }

        public void onSuccessed(BidResponsed bidResponsed) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            if (bidResponsed == null || this.b == null) {
                return;
            }
            Double valueOf = Double.valueOf(0.0d);
            try {
                valueOf = Double.valueOf(Double.parseDouble(bidResponsed.getPrice()) * 100.0d);
            } catch (Exception unused) {
                AdLogUtil.Log().e("mintegral_log", "*----> mintegral bidding success ---,price is:" + valueOf + ",id:" + this.b.getCodeSeatId() + ",time use:" + currentTimeMillis);
            }
            MintegralBidding.this.trackingBiddingSuccess(valueOf.doubleValue());
            this.b.setPrice(valueOf);
            this.b.setBidInfo(new BidWithNotify(bidResponsed));
            AdLogUtil.Log().d("mintegral_log", "*----> mintegral bidding success ---,price is:" + valueOf + ",id:" + this.b.getCodeSeatId());
            final Network network = this.b;
            Preconditions.d(new Preconditions.a() { // from class: com.hisavana.mintegral.bidding.a
                public final void onRun() {
                    MintegralBidding.AnonymousClass2.this.d(network);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class BidWithNotify implements IBidWithNotify {
        private final BidResponsed a;
        private boolean b = false;
        private long c = System.currentTimeMillis();

        BidWithNotify(BidResponsed bidResponsed) {
            this.a = bidResponsed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.a.sendLossNotice(e.a(), BidLossCode.bidPriceNotHighest());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            this.a.sendWinNotice(e.a());
            this.b = true;
        }

        public String getPayload() {
            if (this.a == null) {
                return TtmlNode.ANONYMOUS_REGION_ID;
            }
            AdLogUtil.Log().d("mintegral_log", "mintegral getPayload" + this.a.getBidToken());
            return this.a.getBidToken();
        }

        public boolean isExpired() {
            return Math.abs(System.currentTimeMillis() - this.c) > ((long) ComConstants.BID_PRICE_CACHE_TIME);
        }

        public void notifyLoss() {
            if (this.b || this.a == null) {
                return;
            }
            AdLogUtil.Log().d("mintegral_log", "notify mintegral bidding failed");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                HSScopeHelper.a.g(new Runnable() { // from class: com.hisavana.mintegral.bidding.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        MintegralBidding.BidWithNotify.this.c();
                    }
                });
            } else {
                this.a.sendLossNotice(e.a(), BidLossCode.bidPriceNotHighest());
            }
        }

        public void notifyWin() {
            if (this.a == null) {
                return;
            }
            AdLogUtil.Log().d("mintegral_log", "notify mintegral bidding win");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                HSScopeHelper.a.g(new Runnable() { // from class: com.hisavana.mintegral.bidding.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        MintegralBidding.BidWithNotify.this.d();
                    }
                });
            } else {
                this.a.sendWinNotice(e.a());
                this.b = true;
            }
        }
    }

    private void b() {
        int i = this.a;
        if (i == 1) {
            this.b = 100;
            this.c = 320;
        } else if (i == 2) {
            this.b = 250;
            this.c = 320;
        } else if (i != 3) {
            this.b = 50;
            this.c = 320;
        } else {
            this.b = 90;
            this.c = 320;
        }
    }

    @Override // com.hisavana.common.base.BaseQueryPrice
    public void destroy() {
        this.mQueryPriceListener = null;
    }

    @Override // com.hisavana.common.base.BaseQueryPrice
    public void queryPrice(Context context, final Network network) {
        if (network == null || context == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        ExistsCheck.initAdSource(network.getApplicationId(), network.getApplicationKey(), new MBridgeSDKManager.MBridgeSDKInitializeListener() { // from class: com.hisavana.mintegral.bidding.MintegralBidding.1
            @Override // com.hisavana.mintegral.check.MBridgeSDKManager.MBridgeSDKInitializeListener
            public void onInitializeFailure(String str) {
                AdLogUtil.Log().d("mintegral_log", "init onError message：" + str);
            }

            @Override // com.hisavana.mintegral.check.MBridgeSDKManager.MBridgeSDKInitializeListener
            public void onInitializeSuccess(String str, String str2) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                AdLogUtil.Log().d("mintegral_log", "onInitializeSuccess，init time " + currentTimeMillis2);
                MintegralBidding.this.startQueryPrice(network);
            }
        });
    }

    @Override // com.hisavana.common.base.BaseQueryPrice
    public void setBannerSize(int i) {
        this.a = i;
    }

    public void startQueryPrice(Network network) {
        BidManager bidManager;
        if (network == null) {
            return;
        }
        int adt = network.getAdt();
        if (adt == 2) {
            b();
            bidManager = new BidManager(new BannerBidRequestParams(TtmlNode.ANONYMOUS_REGION_ID, network.getCodeSeatId(), this.c, this.b));
        } else if (adt != 4) {
            bidManager = new BidManager(TtmlNode.ANONYMOUS_REGION_ID, network.getCodeSeatId());
        } else {
            AdLogUtil.Log().d("mintegral_log", "*---->mintegral bidding getOrientation() --- :" + getOrientation());
            bidManager = new BidManager(new SplashBidRequestParams(TtmlNode.ANONYMOUS_REGION_ID, network.getCodeSeatId(), true, getOrientation(), 30, 30));
        }
        long currentTimeMillis = System.currentTimeMillis();
        trackingBiddingStart();
        bidManager.setBidListener(new AnonymousClass2(currentTimeMillis, network));
        bidManager.bid();
    }
}
