package com.transsion.usercenter.message.detail;

import android.text.style.URLSpan;
import android.view.View;
import com.therouter.TheRouter;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ij.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/transsion/usercenter/message/detail/CustomURLSpan;", "Landroid/text/style/URLSpan;", WebConstants.FIELD_URL, HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;)V", "onClick", HttpUrl.FRAGMENT_ENCODE_SET, "widget", "Landroid/view/View;", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class CustomURLSpan extends URLSpan {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomURLSpan(String url) {
        super(url);
        Intrinsics.h(url, "url");
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View widget) {
        Intrinsics.h(widget, "widget");
        k.p(TheRouter.c(WebPageIdentity.WEB_VIEW).K(WebConstants.FIELD_URL, getURL()));
    }
}
