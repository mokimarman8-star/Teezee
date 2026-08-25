package com.transsnet.downloader.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsnet.downloader.widget.DownloadShortTvEpItemView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadShortTvEpListAdapter extends RecyclerView.Adapter {
    private final List a = new ArrayList();
    private Function1 b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsnet/downloader/adapter/DownloadShortTvEpListAdapter$EpisodeViewHolder;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/transsnet/downloader/widget/DownloadShortTvEpItemView;", "view", "<init>", "(Lcom/transsnet/downloader/widget/DownloadShortTvEpItemView;)V", "a", "Lcom/transsnet/downloader/widget/DownloadShortTvEpItemView;", "f", "()Lcom/transsnet/downloader/widget/DownloadShortTvEpItemView;", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    public static final class EpisodeViewHolder extends BaseViewHolder {

        /* renamed from: a, reason: from kotlin metadata */
        private final DownloadShortTvEpItemView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public EpisodeViewHolder(DownloadShortTvEpItemView view) {
            super(view);
            Intrinsics.h(view, "view");
            this.view = view;
        }

        /* renamed from: f, reason: from getter */
        public final DownloadShortTvEpItemView getView() {
            return this.view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DownloadShortTvEpListAdapter downloadShortTvEpListAdapter, yw.c cVar, View view) {
        Function1 function1 = downloadShortTvEpListAdapter.b;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(cVar.a()));
        }
    }

    public final List getData() {
        return this.a;
    }

    public int getItemCount() {
        return this.a.size();
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(EpisodeViewHolder holder, int i) {
        Intrinsics.h(holder, "holder");
        final yw.c cVar = (yw.c) this.a.get(i);
        holder.getView().showIndex(cVar.a() + 1);
        holder.getView().showLockImg(!cVar.c());
        if (cVar.c()) {
            holder.getView().setSelect(cVar.d());
            holder.getView().showDownloadImg(cVar.b());
        }
        holder.getView().setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadShortTvEpListAdapter.j(DownloadShortTvEpListAdapter.this, cVar, view);
            }
        });
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(EpisodeViewHolder holder, int i, List payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(payloads, "payloads");
        super.onBindViewHolder(holder, i, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object obj = payloads.get(0);
        if (obj instanceof yw.c) {
            yw.c cVar = (yw.c) obj;
            holder.getView().showLockImg(!cVar.c());
            if (cVar.c()) {
                holder.getView().setSelect(cVar.d());
                holder.getView().showDownloadImg(cVar.b());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [android.view.View, com.transsnet.downloader.widget.DownloadShortTvEpItemView] */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.h(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.g(context, "getContext(...)");
        ?? downloadShortTvEpItemView = new DownloadShortTvEpItemView(context);
        downloadShortTvEpItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new EpisodeViewHolder(downloadShortTvEpItemView);
    }

    public final void l(Function1 function1) {
        this.b = function1;
    }
}
