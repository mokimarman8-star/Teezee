package com.transsion.search.fragment.result.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.fragment.result.ResultWrapData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t6.h;
import t6.i;
import zp.c;
import zp.d;
import zp.f;
import zp.g;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B/\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0010\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\"¨\u0006%"}, d2 = {"Lcom/transsion/search/fragment/result/adapter/a;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/search/fragment/result/ResultWrapData;", "Lt6/i;", "Lbj/b;", "exposureHelper", BuildConfig.FLAVOR, "keyword", "searchFrom", "tabId", "<init>", "(Lbj/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", BuildConfig.FLAVOR, "S1", "(Ljava/lang/String;)V", "Q1", "()Ljava/lang/String;", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "R1", "(Lcom/transsion/moviedetailapi/bean/Subject;I)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "G", "Lbj/b;", "H", "Ljava/lang/String;", "I", "J", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseProviderMultiAdapter<ResultWrapData> implements i {

    /* renamed from: G, reason: from kotlin metadata */
    private final bj.b exposureHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private final String keyword;

    /* renamed from: I, reason: from kotlin metadata */
    private final String searchFrom;

    /* renamed from: J, reason: from kotlin metadata */
    private String tabId;

    public a(bj.b bVar, String str, String str2, String str3) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        this.exposureHelper = bVar;
        this.keyword = str;
        this.searchFrom = str2;
        this.tabId = str3;
        F1(new zp.a());
        F1(new zp.b());
        F1(new c());
        F1(new d());
        F1(new f());
        F1(new g());
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.B0(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        bj.b bVar = this.exposureHelper;
        if (bVar != null) {
            LinearLayoutManager layoutManager = getRecyclerView().getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            bj.b.j(bVar, layoutManager, bindingAdapterPosition, true, false, 8, null);
        }
    }

    protected int N1(List<ResultWrapData> data, int position) {
        Intrinsics.h(data, "data");
        return data.get(position).getType().ordinal();
    }

    /* renamed from: Q1, reason: from getter */
    public final String getTabId() {
        return this.tabId;
    }

    public final void R1(Subject subject, int position) {
        com.transsion.search.widget.d.a.u(subject, position, this.keyword, this.searchFrom, this.tabId);
    }

    public final void S1(String tabId) {
        Intrinsics.h(tabId, "tabId");
        this.tabId = tabId;
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
