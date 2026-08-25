package ow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class s extends com.transsion.ad.bidding.base.u {
    private final pw.d b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        pw.d c = pw.d.c(LayoutInflater.from(context), null, false);
        Intrinsics.g(c, "inflate(...)");
        this.b = c;
    }

    public AdChoicesView a() {
        return null;
    }

    public AdCloseView b() {
        return null;
    }

    public TextView c() {
        return this.b.c;
    }

    public TextView e() {
        return this.b.e;
    }

    public ImageView f() {
        AppCompatImageView nativeAdIcon = this.b.f;
        Intrinsics.g(nativeAdIcon, "nativeAdIcon");
        return nativeAdIcon;
    }

    public MediaView g() {
        MediaView nativeAdMedia = this.b.g;
        Intrinsics.g(nativeAdMedia, "nativeAdMedia");
        return nativeAdMedia;
    }

    public StoreMarkView h() {
        return null;
    }

    public View i() {
        CardView root = this.b.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        return root;
    }

    public TextView j() {
        return this.b.i;
    }
}
