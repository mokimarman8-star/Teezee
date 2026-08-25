package mn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.transsion.ad.view.CustomRoundCornerLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView;
import com.transsion.player.longvideo.view.LongVodRewardInterceptView;
import com.transsion.player.ui.longvideo.ORLongVodPlayerView;
import com.transsion.postdetail.ad.AdInterceptTimerView;
import com.transsion.postdetail.ui.view.AdCountDownView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements f4.a {
    public final SimpleSubtitleView A;
    public final ImageView B;
    public final ViewStub C;
    public final ViewStub D;
    public final ViewStub E;
    public final ViewStub F;
    private final View a;
    public final AppCompatImageView b;
    public final NativeWrapperAdView c;
    public final AdCountDownView d;
    public final ConstraintLayout e;
    public final AdInterceptTimerView f;
    public final NativeWrapperAdView g;
    public final FrameLayout h;
    public final FrameLayout i;
    public final CustomRoundCornerLayout j;
    public final FrameLayout k;
    public final LinearLayoutCompat l;
    public final View m;
    public final ImageView n;
    public final k o;
    public final l p;
    public final i q;
    public final LongVodMemberNoFreeResolutionView r;
    public final AppCompatImageView s;
    public final View t;
    public final ORLongVodPlayerView u;
    public final LongVodRewardInterceptView v;
    public final AppCompatImageView w;
    public final AppCompatTextView x;
    public final AppCompatTextView y;
    public final SimpleSubtitleView z;

    private j(View view, AppCompatImageView appCompatImageView, NativeWrapperAdView nativeWrapperAdView, AdCountDownView adCountDownView, ConstraintLayout constraintLayout, AdInterceptTimerView adInterceptTimerView, NativeWrapperAdView nativeWrapperAdView2, FrameLayout frameLayout, FrameLayout frameLayout2, CustomRoundCornerLayout customRoundCornerLayout, FrameLayout frameLayout3, LinearLayoutCompat linearLayoutCompat, View view2, ImageView imageView, k kVar, l lVar, i iVar, LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView, AppCompatImageView appCompatImageView2, View view3, ORLongVodPlayerView oRLongVodPlayerView, LongVodRewardInterceptView longVodRewardInterceptView, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, ImageView imageView2, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, ViewStub viewStub4) {
        this.a = view;
        this.b = appCompatImageView;
        this.c = nativeWrapperAdView;
        this.d = adCountDownView;
        this.e = constraintLayout;
        this.f = adInterceptTimerView;
        this.g = nativeWrapperAdView2;
        this.h = frameLayout;
        this.i = frameLayout2;
        this.j = customRoundCornerLayout;
        this.k = frameLayout3;
        this.l = linearLayoutCompat;
        this.m = view2;
        this.n = imageView;
        this.o = kVar;
        this.p = lVar;
        this.q = iVar;
        this.r = longVodMemberNoFreeResolutionView;
        this.s = appCompatImageView2;
        this.t = view3;
        this.u = oRLongVodPlayerView;
        this.v = longVodRewardInterceptView;
        this.w = appCompatImageView3;
        this.x = appCompatTextView;
        this.y = appCompatTextView2;
        this.z = simpleSubtitleView;
        this.A = simpleSubtitleView2;
        this.B = imageView2;
        this.C = viewStub;
        this.D = viewStub2;
        this.E = viewStub3;
        this.F = viewStub4;
    }

    public static j a(View view) {
        ConstraintLayout a;
        LinearLayoutCompat a2;
        View a3;
        View a4;
        AppCompatImageView a5;
        View a6;
        AppCompatImageView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        SimpleSubtitleView a10;
        SimpleSubtitleView a11;
        int i = R$id.adCloseView;
        AppCompatImageView a12 = f4.b.a(view, i);
        if (a12 != null) {
            i = R$id.adContainer;
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) f4.b.a(view, i);
            if (nativeWrapperAdView != null) {
                i = R$id.adCountDownView;
                AdCountDownView adCountDownView = (AdCountDownView) f4.b.a(view, i);
                if (adCountDownView != null && (a = f4.b.a(view, (i = R$id.clPlayer))) != null) {
                    i = R$id.enter_ad_tip;
                    AdInterceptTimerView adInterceptTimerView = (AdInterceptTimerView) f4.b.a(view, i);
                    if (adInterceptTimerView != null) {
                        i = R$id.flLandAd;
                        NativeWrapperAdView nativeWrapperAdView2 = (NativeWrapperAdView) f4.b.a(view, i);
                        if (nativeWrapperAdView2 != null) {
                            i = R$id.flLandAdGroup;
                            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                            if (frameLayout != null) {
                                i = R$id.flPauseAdGroup;
                                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                                if (frameLayout2 != null) {
                                    i = R$id.flResolution;
                                    CustomRoundCornerLayout customRoundCornerLayout = (CustomRoundCornerLayout) f4.b.a(view, i);
                                    if (customRoundCornerLayout != null) {
                                        i = R$id.flRootSubtitle;
                                        FrameLayout frameLayout3 = (FrameLayout) f4.b.a(view, i);
                                        if (frameLayout3 != null && (a2 = f4.b.a(view, (i = R$id.flSubtitle))) != null && (a3 = f4.b.a(view, (i = R$id.guideline))) != null) {
                                            i = R$id.ivAdPauseClose;
                                            ImageView imageView = (ImageView) f4.b.a(view, i);
                                            if (imageView != null && (a4 = f4.b.a(view, (i = R$id.layout_land))) != null) {
                                                k a13 = k.a(a4);
                                                i = R$id.layout_middle;
                                                View a14 = f4.b.a(view, i);
                                                if (a14 != null) {
                                                    l a15 = l.a(a14);
                                                    i = R$id.layout_top_tool_bar;
                                                    View a16 = f4.b.a(view, i);
                                                    if (a16 != null) {
                                                        i a17 = i.a(a16);
                                                        i = R$id.memberNoFreeResolutionView;
                                                        LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView = (LongVodMemberNoFreeResolutionView) f4.b.a(view, i);
                                                        if (longVodMemberNoFreeResolutionView != null && (a5 = f4.b.a(view, (i = R$id.or_long_vod_iv_bg))) != null && (a6 = f4.b.a(view, (i = R$id.or_long_vod_player_bg))) != null) {
                                                            i = R$id.or_long_vod_view;
                                                            ORLongVodPlayerView oRLongVodPlayerView = (ORLongVodPlayerView) f4.b.a(view, i);
                                                            if (oRLongVodPlayerView != null) {
                                                                i = R$id.rewardIntercept;
                                                                LongVodRewardInterceptView longVodRewardInterceptView = (LongVodRewardInterceptView) f4.b.a(view, i);
                                                                if (longVodRewardInterceptView != null && (a7 = f4.b.a(view, (i = R$id.rotate))) != null && (a8 = f4.b.a(view, (i = R$id.tv_center_progress))) != null && (a9 = f4.b.a(view, (i = R$id.tvPressSpeed))) != null && (a10 = f4.b.a(view, (i = R$id.vSubtitleBottom))) != null && (a11 = f4.b.a(view, (i = R$id.vSubtitleTop))) != null) {
                                                                    i = R$id.v_top_space;
                                                                    ImageView imageView2 = (ImageView) f4.b.a(view, i);
                                                                    if (imageView2 != null) {
                                                                        i = R$id.vs_load_fail;
                                                                        ViewStub viewStub = (ViewStub) f4.b.a(view, i);
                                                                        if (viewStub != null) {
                                                                            i = R$id.vs_mobile_data;
                                                                            ViewStub viewStub2 = (ViewStub) f4.b.a(view, i);
                                                                            if (viewStub2 != null) {
                                                                                i = R$id.vs_replay;
                                                                                ViewStub viewStub3 = (ViewStub) f4.b.a(view, i);
                                                                                if (viewStub3 != null) {
                                                                                    i = R$id.vs_toast;
                                                                                    ViewStub viewStub4 = (ViewStub) f4.b.a(view, i);
                                                                                    if (viewStub4 != null) {
                                                                                        return new j(view, a12, nativeWrapperAdView, adCountDownView, a, adInterceptTimerView, nativeWrapperAdView2, frameLayout, frameLayout2, customRoundCornerLayout, frameLayout3, a2, a3, imageView, a13, a15, a17, longVodMemberNoFreeResolutionView, a5, a6, oRLongVodPlayerView, longVodRewardInterceptView, a7, a8, a9, a10, a11, imageView2, viewStub, viewStub2, viewStub3, viewStub4);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static j b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.long_vod_view_player, viewGroup);
        return a(viewGroup);
    }

    public View getRoot() {
        return this.a;
    }
}
