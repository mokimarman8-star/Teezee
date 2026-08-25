package com.transsion.moviedetail.adapter;

import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.y0;
import wf.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/transsion/moviedetail/adapter/p;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/DownloadItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/transsion/moviedetailapi/bean/Subject;", "movieDetailBean", BuildConfig.FLAVOR, "list", "<init>", "(Lcom/transsion/moviedetailapi/bean/Subject;Ljava/util/List;)V", BuildConfig.FLAVOR, "E1", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "holder", "item", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/DownloadItem;)V", BuildConfig.FLAVOR, "F", "Ljava/lang/String;", "resourceId", "G", "Lcom/transsion/moviedetailapi/bean/Subject;", "D1", "()Lcom/transsion/moviedetailapi/bean/Subject;", "G1", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "mMovieDetailBean", "Lcom/transsnet/downloader/widget/DownloadView;", "H", "Lcom/transsnet/downloader/widget/DownloadView;", "downloadView", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class p extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private String resourceId;

    /* renamed from: G, reason: from kotlin metadata */
    private Subject mMovieDetailBean;

    /* renamed from: H, reason: from kotlin metadata */
    private DownloadView downloadView;

    public p(Subject subject, List<DownloadItem> list) {
        super(R$layout.adapter_resource_detector_alone_layout, list);
        this.mMovieDetailBean = subject;
    }

    private final void E1() {
        AppCompatActivity context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.moviedetail.adapter.o
            public final Object invoke(Object obj) {
                Unit F1;
                F1 = p.F1(p.this, (AddToDownloadEvent) obj);
                return F1;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(context, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(p pVar, AddToDownloadEvent addToDownloadEvent) {
        Intrinsics.h(addToDownloadEvent, "value");
        try {
            Iterator it = pVar.getData().iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (TextUtils.equals(((DownloadItem) it.next()).getResourceId(), addToDownloadEvent.getResourceId())) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                pVar.notifyItemChanged(i);
            }
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, DownloadItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        int i = R$id.tvTitle;
        Integer resolution = item.getResolution();
        Subject subject = this.mMovieDetailBean;
        holder.setText(i, resolution + "P " + (subject != null ? subject.getTitle() : null));
        Long size = item.getSize();
        long longValue = size != null ? size.longValue() : 0L;
        Long duration = item.getDuration();
        long longValue2 = duration != null ? duration.longValue() : 0L;
        String a = zg.b.a(longValue, 1);
        if (longValue2 > 0) {
            a = a + " · " + TimeUtilKt.o(longValue2 * 1000);
        }
        holder.setText(R$id.tvSize, a);
        DownloadView view = holder.getView(R$id.innerIvDownload);
        this.downloadView = view;
        if (view != null) {
            view.setPageFrom("subjectdetail");
        }
        String resourceId = item.getResourceId();
        this.resourceId = resourceId;
        DownloadView downloadView = this.downloadView;
        if (downloadView != null) {
            Subject subject2 = this.mMovieDetailBean;
            DownloadView.setShowType$default(downloadView, (String) null, resourceId, subject2 != null ? Boolean.valueOf(subject2.isSeries()) : null, false, 0, 24, (Object) null);
        }
    }

    /* renamed from: D1, reason: from getter */
    public final Subject getMMovieDetailBean() {
        return this.mMovieDetailBean;
    }

    public final void G1(Subject subject) {
        this.mMovieDetailBean = subject;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        E1();
    }
}
