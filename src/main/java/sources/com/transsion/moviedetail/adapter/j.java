package com.transsion.moviedetail.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.transsion.flow.bean.MediaType;
import com.transsion.flow.p002enum.PostListSource;
import com.transsion.flow.p002enum.ProfileSubSource;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B3\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/transsion/moviedetail/adapter/j;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "Lt6/i;", BuildConfig.FLAVOR, "postSubjectList", "Lcom/transsion/moviedetailapi/AbsSubjectListViewModel;", "viewModel", BuildConfig.FLAVOR, "pageName", "pageFrom", "<init>", "(Ljava/util/List;Lcom/transsion/moviedetailapi/AbsSubjectListViewModel;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "w0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "data", "N1", "(Ljava/util/List;I)I", "Q1", "()V", "G", "Lcom/transsion/moviedetailapi/AbsSubjectListViewModel;", "S1", "()Lcom/transsion/moviedetailapi/AbsSubjectListViewModel;", "H", "Ljava/lang/String;", "R1", "()Ljava/lang/String;", "Landroidx/recyclerview/widget/RecyclerView$s;", "I", "Landroidx/recyclerview/widget/RecyclerView$s;", "imageRecycledViewPool", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j extends BaseProviderMultiAdapter<PostSubjectItem> implements t6.i {

    /* renamed from: G, reason: from kotlin metadata */
    private final AbsSubjectListViewModel viewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private final String pageName;

    /* renamed from: I, reason: from kotlin metadata */
    private final RecyclerView.s imageRecycledViewPool;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(List<PostSubjectItem> list, AbsSubjectListViewModel absSubjectListViewModel, String str, String str2) {
        super(CollectionsKt.U0(list));
        BaseItemProvider h;
        ProfileSubSource B;
        Intrinsics.h(list, "postSubjectList");
        this.viewModel = absSubjectListViewModel;
        this.pageName = str;
        RecyclerView.s sVar = new RecyclerView.s();
        this.imageRecycledViewPool = sVar;
        String str3 = null;
        if ((absSubjectListViewModel != null ? absSubjectListViewModel.A() : null) == PostListSource.PROFILE) {
            io.b bVar = (io.b) TheRouter.d(io.b.class, new Object[0]);
            if (bVar != null) {
                h = bVar.o(str, str2, sVar);
            }
            h = null;
        } else {
            io.b bVar2 = (io.b) TheRouter.d(io.b.class, new Object[0]);
            if (bVar2 != null) {
                h = bVar2.h(str, str2, sVar);
            }
            h = null;
        }
        if (h != null) {
            F1(h);
        }
        F1(new km.b());
        if (absSubjectListViewModel != null && (B = absSubjectListViewModel.B()) != null) {
            str3 = B.getValue();
        }
        F1(new km.d(str, str3));
    }

    protected int N1(List<PostSubjectItem> data, int position) {
        Intrinsics.h(data, "data");
        return data.get(position).isRoomList() ? MediaType.ROOM_LIST.ordinal() : data.get(position).getNonAdDelegate() != null ? MediaType.SUBJECT_DETAIL_NATIVE_AD.ordinal() : MediaType.CONTENT_ALL.ordinal();
    }

    public final void Q1() {
        getData().clear();
        notifyDataSetChanged();
    }

    /* renamed from: R1, reason: from getter */
    public final String getPageName() {
        return this.pageName;
    }

    /* renamed from: S1, reason: from getter */
    public final AbsSubjectListViewModel getViewModel() {
        return this.viewModel;
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }

    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.h(holder, "holder");
        super/*com.chad.library.adapter.base.BaseQuickAdapter*/.w0(holder, position);
        if (((RecyclerView.a0) holder).itemView.findViewById(R$id.root) != null) {
            AbsSubjectListViewModel absSubjectListViewModel = this.viewModel;
            if (absSubjectListViewModel != null) {
                absSubjectListViewModel.H((PostSubjectItem) getData().get(position), position);
            }
            if (position != 0) {
                getItemCount();
            }
        }
    }
}
