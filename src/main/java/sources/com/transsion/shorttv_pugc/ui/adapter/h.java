package com.transsion.shorttv_pugc.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.shorttv_pugc.base.adapter.BaseBindingQuickAdapter;
import com.transsion.shorttv_pugc.bean.DubsInfo;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/transsion/shorttv_pugc/ui/adapter/h;", "Lcom/transsion/shorttv_pugc/base/adapter/BaseBindingQuickAdapter;", "Lcom/transsion/shorttv_pugc/bean/DubsInfo;", "Lqr/e;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "H1", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lqr/e;", "binding", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "I1", "(Lqr/e;Lcom/transsion/shorttv_pugc/bean/DubsInfo;)V", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h extends BaseBindingQuickAdapter<DubsInfo, qr.e> {
    public h() {
        super(null, 1, null);
    }

    @Override // com.transsion.shorttv_pugc.base.adapter.BaseBindingQuickAdapter
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public qr.e E1(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.h(inflater, "inflater");
        Intrinsics.h(parent, "parent");
        qr.e c = qr.e.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    @Override // com.transsion.shorttv_pugc.base.adapter.BaseBindingQuickAdapter
    /* renamed from: I1, reason: merged with bridge method [inline-methods] */
    public void F1(qr.e binding, DubsInfo item) {
        Intrinsics.h(binding, "binding");
        Intrinsics.h(item, "item");
        binding.b.setSelected(item.getIsSelected());
        AppCompatTextView appCompatTextView = binding.c;
        String lanName = item.getLanName();
        CharSequence charSequence = HttpUrl.FRAGMENT_ENCODE_SET;
        if (lanName == null) {
            lanName = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        appCompatTextView.setText(lanName);
        AppCompatTextView appCompatTextView2 = binding.d;
        CharSequence lanName2 = item.getLanName();
        if (lanName2 != null) {
            charSequence = lanName2;
        }
        appCompatTextView2.setText(charSequence);
        AppCompatTextView tvName = binding.c;
        Intrinsics.g(tvName, "tvName");
        tvName.setVisibility(!item.getIsSelected() ? 0 : 8);
        AppCompatTextView tvNameSelected = binding.d;
        Intrinsics.g(tvNameSelected, "tvNameSelected");
        tvNameSelected.setVisibility(item.getIsSelected() ? 0 : 8);
    }
}
