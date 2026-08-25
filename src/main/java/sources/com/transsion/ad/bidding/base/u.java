package com.transsion.ad.bidding.base;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.api.view.TNativeView;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class u {
    private final Context a;

    public u(Context context) {
        Intrinsics.h(context, "context");
        this.a = context;
    }

    public abstract AdChoicesView a();

    public abstract AdCloseView b();

    public abstract TextView c();

    public final List d(TNativeView tNativeView, TaNativeInfo taNativeInfo) {
        Intrinsics.h(tNativeView, "nativeView");
        Intrinsics.h(taNativeInfo, "nativeInfo");
        ArrayList arrayList = new ArrayList();
        MediaView g = g();
        if (g != null) {
            tNativeView.setMediaView(g, ImageView.ScaleType.FIT_XY);
            arrayList.add(g);
        }
        ImageView f = f();
        if (f != null) {
            tNativeView.setIconView(f);
            arrayList.add(f);
        }
        AdChoicesView a = a();
        if (a != null) {
            tNativeView.setAdChoiceView(a);
            arrayList.add(a);
        }
        AdCloseView b = b();
        if (b != null) {
            tNativeView.setAdCloseView(b);
            arrayList.add(b);
        }
        StoreMarkView h = h();
        if (h != null) {
            tNativeView.setPsMarkView(h);
            arrayList.add(h);
        }
        TextView j = j();
        if (j != null) {
            j.setText(taNativeInfo.getTitle());
            arrayList.add(j);
        }
        TextView e = e();
        if (e != null) {
            e.setText(taNativeInfo.getDescription());
            arrayList.add(e);
        }
        TextView c = c();
        if (c != null) {
            c.setText(taNativeInfo.getCtatext());
            arrayList.add(c);
        }
        tNativeView.addView(i());
        return arrayList;
    }

    public abstract TextView e();

    public abstract ImageView f();

    public abstract MediaView g();

    public abstract StoreMarkView h();

    public abstract View i();

    public abstract TextView j();
}
