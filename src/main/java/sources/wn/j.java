package wn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ad.AdInterceptTimerView;
import com.transsion.postdetail.ui.view.AdCountDownView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final NativeWrapperAdView c;
    public final AdCountDownView d;
    public final AdInterceptTimerView e;
    public final NativeWrapperAdView f;
    public final FrameLayout g;
    public final ConstraintLayout h;
    public final View i;
    public final ImageView j;
    public final u k;
    public final w l;
    public final y m;
    public final AppCompatImageView n;
    public final ImageView o;

    private j(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, NativeWrapperAdView nativeWrapperAdView, AdCountDownView adCountDownView, AdInterceptTimerView adInterceptTimerView, NativeWrapperAdView nativeWrapperAdView2, FrameLayout frameLayout, ConstraintLayout constraintLayout2, View view, ImageView imageView, u uVar, w wVar, y yVar, AppCompatImageView appCompatImageView2, ImageView imageView2) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = nativeWrapperAdView;
        this.d = adCountDownView;
        this.e = adInterceptTimerView;
        this.f = nativeWrapperAdView2;
        this.g = frameLayout;
        this.h = constraintLayout2;
        this.i = view;
        this.j = imageView;
        this.k = uVar;
        this.l = wVar;
        this.m = yVar;
        this.n = appCompatImageView2;
        this.o = imageView2;
    }

    public static j a(View view) {
        ConstraintLayout a;
        View a2;
        View a3;
        int i = R$id.adCloseView;
        AppCompatImageView a4 = f4.b.a(view, i);
        if (a4 != null) {
            i = R$id.adContainer;
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) f4.b.a(view, i);
            if (nativeWrapperAdView != null) {
                i = R$id.adCountDownView;
                AdCountDownView adCountDownView = (AdCountDownView) f4.b.a(view, i);
                if (adCountDownView != null) {
                    i = R$id.enter_ad_tip;
                    AdInterceptTimerView adInterceptTimerView = (AdInterceptTimerView) f4.b.a(view, i);
                    if (adInterceptTimerView != null) {
                        i = R$id.flLandAd;
                        NativeWrapperAdView nativeWrapperAdView2 = (NativeWrapperAdView) f4.b.a(view, i);
                        if (nativeWrapperAdView2 != null) {
                            i = R$id.flLandAdGroup;
                            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                            if (frameLayout != null && (a = f4.b.a(view, (i = R$id.flPauseAdGroup))) != null && (a2 = f4.b.a(view, (i = R$id.guideline))) != null) {
                                i = R$id.ivAdPauseClose;
                                ImageView imageView = (ImageView) f4.b.a(view, i);
                                if (imageView != null && (a3 = f4.b.a(view, (i = R$id.local_video_land))) != null) {
                                    u a5 = u.a(a3);
                                    i = R$id.local_video_middle;
                                    View a6 = f4.b.a(view, i);
                                    if (a6 != null) {
                                        w a7 = w.a(a6);
                                        i = R$id.local_video_portrait;
                                        View a8 = f4.b.a(view, i);
                                        if (a8 != null) {
                                            y a9 = y.a(a8);
                                            i = R$id.rotate;
                                            AppCompatImageView a10 = f4.b.a(view, i);
                                            if (a10 != null) {
                                                i = R$id.v_top_space;
                                                ImageView imageView2 = (ImageView) f4.b.a(view, i);
                                                if (imageView2 != null) {
                                                    return new j((ConstraintLayout) view, a4, nativeWrapperAdView, adCountDownView, adInterceptTimerView, nativeWrapperAdView2, frameLayout, a, a2, imageView, a5, a7, a9, a10, imageView2);
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

    public static j c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_local_video, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
