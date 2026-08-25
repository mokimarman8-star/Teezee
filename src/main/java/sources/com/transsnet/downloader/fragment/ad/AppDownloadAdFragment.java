package com.transsnet.downloader.fragment.ad;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bx.t;
import com.blankj.utilcode.util.a0;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsion.ad.bidding.icon.BiddingIconAdManager;
import com.transsion.ad.bidding.icon.BiddingWrapperIconBean;
import com.transsion.baseui.fragment.LazyFragment;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\r\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u0004R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/transsnet/downloader/fragment/ad/AppDownloadAdFragment;", "Lcom/transsion/baseui/fragment/LazyFragment;", "Lbx/t;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "q0", "onDestroy", "Landroid/view/LayoutInflater;", "inflater", "p0", "(Landroid/view/LayoutInflater;)Lbx/t;", HttpUrl.FRAGMENT_ENCODE_SET, "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", HttpUrl.FRAGMENT_ENCODE_SET, "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", "lazyLoadData", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "loadDefaultData", "o0", "Lcom/transsion/ad/bidding/icon/BiddingIconAdManager;", "a", "Lcom/transsion/ad/bidding/icon/BiddingIconAdManager;", "adManager", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/transsion/ad/bidding/icon/BiddingWrapperIconBean;", "b", "Ljava/util/List;", "iconList", "Lcom/transsnet/downloader/fragment/ad/a;", "c", "Lcom/transsnet/downloader/fragment/ad/a;", "mAppDownloadAdapter", "Loh/a;", "d", "Loh/a;", "listener", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class AppDownloadAdFragment extends LazyFragment<t> {

    /* renamed from: c, reason: from kotlin metadata */
    private com.transsnet.downloader.fragment.ad.a mAppDownloadAdapter;

    /* renamed from: a, reason: from kotlin metadata */
    private BiddingIconAdManager adManager = new BiddingIconAdManager();

    /* renamed from: b, reason: from kotlin metadata */
    private final List iconList = new ArrayList();

    /* renamed from: d, reason: from kotlin metadata */
    private final oh.a listener = new b();

    public static final class a extends RecyclerView.l {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.h(outRect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (parent.getAdapter() != null) {
                boolean z = this.a;
                if (childAdapterPosition == 0) {
                    if (z) {
                        outRect.right = a0.a(12.0f);
                        outRect.left = a0.a(8.0f);
                    } else {
                        outRect.left = a0.a(12.0f);
                        outRect.right = a0.a(8.0f);
                    }
                    outRect.bottom = a0.a(12.0f);
                    return;
                }
                if (childAdapterPosition == r5.getItemCount() - 1) {
                    if (z) {
                        outRect.left = a0.a(12.0f);
                    } else {
                        outRect.right = a0.a(12.0f);
                    }
                    outRect.bottom = a0.a(12.0f);
                    return;
                }
                if (z) {
                    outRect.left = a0.a(8.0f);
                } else {
                    outRect.right = a0.a(8.0f);
                }
                outRect.bottom = a0.a(12.0f);
            }
        }
    }

    public static final class b extends oh.a {
        b() {
        }

        public void w(List list) {
            FrameLayout frameLayout;
            AppCompatTextView appCompatTextView;
            super.w(list);
            AppDownloadAdFragment.this.iconList.clear();
            if (list != null && (!list.isEmpty())) {
                AppDownloadAdFragment.this.iconList.addAll(list);
            }
            com.transsnet.downloader.fragment.ad.a aVar = AppDownloadAdFragment.this.mAppDownloadAdapter;
            if (aVar != null) {
                aVar.n1(AppDownloadAdFragment.this.iconList);
            }
            t tVar = (t) AppDownloadAdFragment.this.getMViewBinding();
            if (tVar != null && (appCompatTextView = tVar.e) != null) {
                AppDownloadAdFragment appDownloadAdFragment = AppDownloadAdFragment.this;
                if (appDownloadAdFragment.iconList.isEmpty()) {
                    appCompatTextView.setVisibility(8);
                } else {
                    appCompatTextView.setVisibility(0);
                    appCompatTextView.setText(String.valueOf(appDownloadAdFragment.iconList.size()));
                }
            }
            t tVar2 = (t) AppDownloadAdFragment.this.getMViewBinding();
            if (tVar2 == null || (frameLayout = tVar2.c) == null) {
                return;
            }
            frameLayout.setVisibility(AppDownloadAdFragment.this.iconList.isEmpty() ? 8 : 0);
        }
    }

    private final void q0() {
        RecyclerView recyclerView;
        t tVar = (t) getMViewBinding();
        if (tVar == null || (recyclerView = tVar.b) == null) {
            return;
        }
        com.transsnet.downloader.fragment.ad.a aVar = new com.transsnet.downloader.fragment.ad.a(this.adManager);
        this.mAppDownloadAdapter = aVar;
        recyclerView.setAdapter(aVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        recyclerView.addItemDecoration(new a(TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1));
    }

    public String getPageStateLayoutTitle() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public void initListener() {
    }

    public void initViewData() {
        q0();
    }

    public void initViewModel() {
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public boolean isMonitorNetworkState() {
        return false;
    }

    public void lazyLoadData() {
    }

    public void loadDefaultData() {
        super/*com.transsion.baseui.fragment.PageStatusFragment*/.loadDefaultData();
        k.d(v.a(this), null, null, new AppDownloadAdFragment$loadDefaultData$1(this, null), 3, null);
    }

    public qi.b newLogViewConfig() {
        return new qi.b("AppDownloadAdFragment", false, 2, (DefaultConstructorMarker) null);
    }

    public final void o0() {
        if (this.iconList.isEmpty()) {
            loadDefaultData();
        }
    }

    public void onDestroy() {
        List<BiddingWrapperIconBean> data;
        TAdNativeInfo nativeInfo;
        super/*com.transsion.baseui.fragment.PageStatusFragment*/.onDestroy();
        this.adManager.I();
        com.transsnet.downloader.fragment.ad.a aVar = this.mAppDownloadAdapter;
        if (aVar == null || (data = aVar.getData()) == null) {
            return;
        }
        for (BiddingWrapperIconBean biddingWrapperIconBean : data) {
            if (biddingWrapperIconBean.getType() == 2 && (nativeInfo = biddingWrapperIconBean.getNativeInfo()) != null) {
                nativeInfo.release();
            }
        }
    }

    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public t getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        t c = t.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void retryLoadData() {
    }
}
