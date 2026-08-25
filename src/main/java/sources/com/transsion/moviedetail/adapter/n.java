package com.transsion.moviedetail.adapter;

import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.y0;
import wf.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/transsion/moviedetail/adapter/n;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/DownloadItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "title", "duration", BuildConfig.FLAVOR, "list", BuildConfig.FLAVOR, "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", BuildConfig.FLAVOR, "J1", "()V", "holder", "item", "I1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/DownloadItem;)Ljava/lang/String;", "H1", "(I)Ljava/lang/String;", "position", "D1", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/DownloadItem;)V", "F", "Ljava/lang/String;", "G1", "()Ljava/lang/String;", "G", "E1", "H", "Ljava/util/List;", "F1", "()Ljava/util/List;", "I", "Ljava/lang/Integer;", BuildConfig.FLAVOR, "J", "Z", "isAudio", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private final String title;

    /* renamed from: G, reason: from kotlin metadata */
    private final String duration;

    /* renamed from: H, reason: from kotlin metadata */
    private final List<DownloadItem> list;

    /* renamed from: I, reason: from kotlin metadata */
    private final Integer type;

    /* renamed from: J, reason: from kotlin metadata */
    private final boolean isAudio;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String str, String str2, List<DownloadItem> list, Integer num) {
        super(R$layout.adapter_resource_detector_collection_layout, list);
        Intrinsics.h(str, "title");
        Intrinsics.h(list, "list");
        this.title = str;
        this.duration = str2;
        this.list = list;
        this.type = num;
        this.isAudio = num != null && num.intValue() == SubjectType.AUDIO.getValue();
    }

    private final String D1(int position) {
        if (position >= 10) {
            return String.valueOf(position);
        }
        return "0" + position;
    }

    private final String H1(int holder) {
        if (this.isAudio) {
            return "Chapter " + D1(holder);
        }
        return "Episode " + D1(holder);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String I1(BaseViewHolder holder, DownloadItem item) {
        Throwable th2;
        String str;
        Object obj;
        if (item.getEp() <= 0 && item.getSe() <= 0) {
            Integer epse = item.getEpse();
            if ((epse != null ? epse.intValue() : 0) <= 0) {
                return BuildConfig.FLAVOR;
            }
            Integer epse2 = item.getEpse();
            return H1(epse2 != null ? epse2.intValue() : 0);
        }
        try {
            Result.Companion companion = Result.Companion;
            str = new DecimalFormat("00").format(Integer.valueOf(item.getEp()));
            Intrinsics.g(str, "format(...)");
        } catch (Throwable th3) {
            th2 = th3;
            str = BuildConfig.FLAVOR;
        }
        try {
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th4) {
            th2 = th4;
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
            if (Result.exceptionOrNull-impl(obj) != null) {
            }
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            return str;
        }
        Integer epse3 = item.getEpse();
        return H1(epse3 != null ? epse3.intValue() : 0);
    }

    private final void J1() {
        AppCompatActivity context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.moviedetail.adapter.m
            public final Object invoke(Object obj) {
                Unit K1;
                K1 = n.K1(n.this, (AddToDownloadEvent) obj);
                return K1;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(context, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(n nVar, AddToDownloadEvent addToDownloadEvent) {
        Intrinsics.h(addToDownloadEvent, "value");
        try {
            Iterator it = nVar.getData().iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                DownloadItem downloadItem = (DownloadItem) it.next();
                if (!TextUtils.isEmpty(addToDownloadEvent.getResourceId()) && TextUtils.equals(downloadItem.getResourceId(), addToDownloadEvent.getResourceId())) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                nVar.notifyItemChanged(i);
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
        a.a.g(wf.a.a, "ResourceDetectorCollectionAdapter " + holder.getLayoutPosition() + "  " + item.getName(), false, 2, (Object) null);
        holder.getView(R$id.group).setVisibility(0);
        holder.setGone(R$id.tvAll, true);
        holder.setText(R$id.tvTitle, I1(holder, item));
        int i = R$id.tvSize;
        Long size = item.getSize();
        holder.setText(i, zg.b.a(size != null ? size.longValue() : 0L, 1));
        DownloadView.setShowType$default(holder.getView(R$id.innerIvDownload), (String) null, item.getResourceId(), Boolean.FALSE, false, 0, 16, (Object) null);
    }

    /* renamed from: E1, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    public final List<DownloadItem> F1() {
        return this.list;
    }

    /* renamed from: G1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        J1();
    }
}
