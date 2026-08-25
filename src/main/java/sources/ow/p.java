package ow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class p extends com.transsion.ad.bidding.base.u {
    private final pw.b b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        pw.b c = pw.b.c(LayoutInflater.from(context), null, false);
        Intrinsics.g(c, "inflate(...)");
        this.b = c;
    }

    public AdChoicesView a() {
        return this.b.b;
    }

    public AdCloseView b() {
        return null;
    }

    public TextView c() {
        return this.b.d;
    }

    public TextView e() {
        return null;
    }

    public ImageView f() {
        return null;
    }

    public MediaView g() {
        MediaView nativeAdMedia = this.b.e;
        Intrinsics.g(nativeAdMedia, "nativeAdMedia");
        return nativeAdMedia;
    }

    public StoreMarkView h() {
        return null;
    }

    public View i() {
        ConstraintLayout root = this.b.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        return root;
    }

    public TextView j() {
        return null;
    }
}
