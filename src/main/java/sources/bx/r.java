package bx;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class r implements f4.a {
    private final ConstraintLayout a;
    public final NativeWrapperAdView b;
    public final CardView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final BLTextView f;
    public final BLTextView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;

    private r(ConstraintLayout constraintLayout, NativeWrapperAdView nativeWrapperAdView, CardView cardView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, BLTextView bLTextView, BLTextView bLTextView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.a = constraintLayout;
        this.b = nativeWrapperAdView;
        this.c = cardView;
        this.d = appCompatImageView;
        this.e = appCompatImageView2;
        this.f = bLTextView;
        this.g = bLTextView2;
        this.h = appCompatTextView;
        this.i = appCompatTextView2;
        this.j = appCompatTextView3;
        this.k = appCompatTextView4;
    }

    public static r a(View view) {
        CardView a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        BLTextView a4;
        BLTextView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        int i = R.id.adContainer;
        NativeWrapperAdView a10 = f4.b.a(view, i);
        if (a10 == null || (a = f4.b.a(view, (i = R.id.card_native_ad))) == null || (a2 = f4.b.a(view, (i = R.id.ivClose))) == null || (a3 = f4.b.a(view, (i = R.id.ivDownload))) == null || (a4 = f4.b.a(view, (i = R.id.tvBtnDetails))) == null || (a5 = f4.b.a(view, (i = R.id.tvBtnPlayNow))) == null || (a6 = f4.b.a(view, (i = R.id.tvDes))) == null || (a7 = f4.b.a(view, (i = R.id.tvFileSize))) == null || (a8 = f4.b.a(view, (i = R.id.tvTitle))) == null || (a9 = f4.b.a(view, (i = R.id.tvTitleCopy))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new r((ConstraintLayout) view, a10, a, a2, a3, a4, a5, a6, a7, a8, a9);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
