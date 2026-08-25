package com.transsion.ad.test.ad_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import kotlin.jvm.internal.Intrinsics;
import sh.z;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class w extends com.transsion.ad.bidding.base.u {
    private final z b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        z c = z.c(LayoutInflater.from(context), (ViewGroup) null, false);
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
        AppCompatImageView appCompatImageView = this.b.f;
        Intrinsics.g(appCompatImageView, "nativeAdIcon");
        return appCompatImageView;
    }

    public MediaView g() {
        MediaView mediaView = this.b.g;
        Intrinsics.g(mediaView, "nativeAdMedia");
        return mediaView;
    }

    public StoreMarkView h() {
        return null;
    }

    public View i() {
        CardView b = this.b.b();
        Intrinsics.g(b, "getRoot(...)");
        return b;
    }

    public TextView j() {
        return this.b.i;
    }
}
