package com.transsion.postdetail.shorttv.adapter;

import android.content.Context;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;
import uf.c;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\n*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\n*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/transsion/postdetail/shorttv/adapter/ShortTVHeaderViewAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lbj/b;", "exposureHelper", "<init>", "(Lbj/b;)V", "Landroidx/appcompat/widget/AppCompatImageView;", "item", BuildConfig.FLAVOR, "C1", "(Landroidx/appcompat/widget/AppCompatImageView;Lcom/transsion/moviedetailapi/bean/Subject;)V", "D1", "holder", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "F", "Lbj/b;", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTVHeaderViewAdapter extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private final bj.b exposureHelper;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShortTVHeaderViewAdapter() {
        this(r0, 1, r0);
        bj.b bVar = null;
    }

    public ShortTVHeaderViewAdapter(bj.b bVar) {
        super(R$layout.item_short_tv_history, (List) null, 2, (DefaultConstructorMarker) null);
        this.exposureHelper = bVar;
    }

    public /* synthetic */ ShortTVHeaderViewAdapter(bj.b bVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bVar);
    }

    private final void C1(AppCompatImageView appCompatImageView, Subject subject) {
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new ShortTVHeaderViewAdapter$loadBuiltInCover$1(subject, appCompatImageView, null), 3, (Object) null);
    }

    private final void D1(AppCompatImageView appCompatImageView, Subject subject) {
        String str;
        String thumbnail;
        f.a aVar = f.a;
        Context context = appCompatImageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m = aVar.m(context);
        Cover cover = subject.getCover();
        String str2 = BuildConfig.FLAVOR;
        if (cover == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b i = m.g(str).i(R.color.module_04);
        Cover cover2 = subject.getCover();
        if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        i.l(str2).d(appCompatImageView);
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
            bVar.i(layoutManager, bindingAdapterPosition, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007d, code lost:
    
        if (r5.getEp() <= 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0052, code lost:
    
        if (r2 == null) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void F(BaseViewHolder holder, Subject item) {
        List l;
        int totalEpisode;
        ResourceDetectors resourceDetectors;
        Integer totalEpisode2;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getView(R$id.iv_cover);
        if (item.getBuiltIn()) {
            C1(appCompatImageView, item);
        } else {
            D1(appCompatImageView, item);
        }
        ((TextView) holder.getView(R$id.tv_title)).setText(item.getTitle());
        List tags = item.getTags();
        if (tags != null) {
            l = !tags.isEmpty() ? CollectionsKt.e(CollectionsKt.i0(CollectionsKt.f(tags))) : CollectionsKt.l();
        }
        l = CollectionsKt.l();
        a aVar = new a(CollectionsKt.U0(l));
        RecyclerView view = holder.getView(R$id.rv_list);
        if (item.getShortTVFirstEp() != null) {
            ShortTVItem shortTVFirstEp = item.getShortTVFirstEp();
            Intrinsics.e(shortTVFirstEp);
        }
        if (!l.isEmpty()) {
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(view.getContext());
            flexboxLayoutManager.c0(0);
            flexboxLayoutManager.d0(1);
            flexboxLayoutManager.e0(0);
            view.setLayoutManager(flexboxLayoutManager);
            view.setAdapter(aVar);
            c.k(view);
            TextView textView = (TextView) holder.getView(R$id.tv_ep);
            if (item.getTotalEpisode() != 0) {
                List resourceDetectors2 = item.getResourceDetectors();
                totalEpisode = (resourceDetectors2 == null || (resourceDetectors = (ResourceDetectors) CollectionsKt.i0(resourceDetectors2)) == null || (totalEpisode2 = resourceDetectors.getTotalEpisode()) == null) ? 0 : totalEpisode2.intValue();
            } else {
                totalEpisode = item.getTotalEpisode();
            }
            textView.setText(Utils.a().getString(com.transsion.postdetail.R.string.short_tv_watch_ad_tips, String.valueOf(totalEpisode)));
        }
        c.g(view);
        TextView textView2 = (TextView) holder.getView(R$id.tv_ep);
        if (item.getTotalEpisode() != 0) {
        }
        textView2.setText(Utils.a().getString(com.transsion.postdetail.R.string.short_tv_watch_ad_tips, String.valueOf(totalEpisode)));
    }
}
