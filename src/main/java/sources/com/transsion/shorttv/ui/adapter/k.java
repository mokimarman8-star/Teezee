package com.transsion.shorttv.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.shorttv.base.adapter.BaseBindingQuickAdapter;
import com.transsion.shorttv.base.widget.ShortTvGradientTextView;
import com.transsion.shorttv.bean.DubsInfo;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import qr.f0;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/transsion/shorttv/ui/adapter/k;", "Lcom/transsion/shorttv/base/adapter/BaseBindingQuickAdapter;", "Lcom/transsion/shorttv/bean/DubsInfo;", "Lqr/f0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "H1", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lqr/f0;", "binding", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "I1", "(Lqr/f0;Lcom/transsion/shorttv/bean/DubsInfo;)V", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class k extends BaseBindingQuickAdapter<DubsInfo, f0> {
    public k() {
        super((List) null, 1, (DefaultConstructorMarker) null);
    }

    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public f0 E1(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.h(inflater, "inflater");
        Intrinsics.h(parent, "parent");
        f0 c = f0.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: I1, reason: merged with bridge method [inline-methods] */
    public void F1(f0 binding, DubsInfo item) {
        Intrinsics.h(binding, "binding");
        Intrinsics.h(item, "item");
        binding.b.setSelected(item.isSelected());
        AppCompatTextView appCompatTextView = binding.c;
        String lanName = item.getLanName();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (lanName == null) {
            lanName = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        appCompatTextView.setText(lanName);
        ShortTvGradientTextView shortTvGradientTextView = binding.d;
        String lanName2 = item.getLanName();
        if (lanName2 != null) {
            str = lanName2;
        }
        shortTvGradientTextView.setText(str);
        AppCompatTextView tvName = binding.c;
        Intrinsics.g(tvName, "tvName");
        tvName.setVisibility(!item.isSelected() ? 0 : 8);
        ShortTvGradientTextView tvNameSelected = binding.d;
        Intrinsics.g(tvNameSelected, "tvNameSelected");
        tvNameSelected.setVisibility(item.isSelected() ? 0 : 8);
        String lanName3 = item.getLanName();
        binding.b.setLayoutDirection(lanName3 != null ? androidx.core.text.a.c().f(lanName3) : 0);
    }
}
