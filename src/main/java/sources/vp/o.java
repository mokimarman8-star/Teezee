package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatTextView b;
    public final NativeWrapperAdView c;
    public final NativeWrapperAdView d;
    public final NativeWrapperAdView e;

    private o(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, NativeWrapperAdView nativeWrapperAdView, NativeWrapperAdView nativeWrapperAdView2, NativeWrapperAdView nativeWrapperAdView3) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = nativeWrapperAdView;
        this.d = nativeWrapperAdView2;
        this.e = nativeWrapperAdView3;
    }

    public static o a(View view) {
        int i = R$id.ad_group_title;
        AppCompatTextView a = f4.b.a(view, i);
        if (a != null) {
            i = R$id.native_ad_view_1;
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) f4.b.a(view, i);
            if (nativeWrapperAdView != null) {
                i = R$id.native_ad_view_2;
                NativeWrapperAdView nativeWrapperAdView2 = (NativeWrapperAdView) f4.b.a(view, i);
                if (nativeWrapperAdView2 != null) {
                    i = R$id.native_ad_view_3;
                    NativeWrapperAdView nativeWrapperAdView3 = (NativeWrapperAdView) f4.b.a(view, i);
                    if (nativeWrapperAdView3 != null) {
                        return new o((ConstraintLayout) view, a, nativeWrapperAdView, nativeWrapperAdView2, nativeWrapperAdView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static o c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.search_hot_hi_native_group_layout, viewGroup, false);
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
