package com.transsion.rewardscenter.task.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class w extends com.transsion.ad.bidding.base.u {
    private final yo.k b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        yo.k c = yo.k.c(LayoutInflater.from(context), null, false);
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
        return null;
    }

    public TextView e() {
        return null;
    }

    public ImageView f() {
        ImageView imageView = this.b.b;
        Intrinsics.g(imageView, "adIcon");
        return imageView;
    }

    public MediaView g() {
        return null;
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
        AppCompatTextView appCompatTextView = this.b.c;
        Intrinsics.g(appCompatTextView, "adTitle");
        return appCompatTextView;
    }
}
