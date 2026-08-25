package com.transsion.shorttv.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.shorttv.R;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.ui.widget.ShortTvDownloadEpItemView;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/transsion/shorttv/ui/adapter/r;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lnr/e;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", WebConstants.FIELD_ITEM, "holder", HttpUrl.FRAGMENT_ENCODE_SET, "E1", "(Lnr/e;Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "Lcom/transsion/shorttv/bean/Subject;", "subject", "F1", "(Lcom/transsion/shorttv/bean/Subject;)V", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lnr/e;)V", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "payloads", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lnr/e;Ljava/util/List;)V", HttpUrl.FRAGMENT_ENCODE_SET, "ep", "D1", "(I)V", "F", "I", "selectEp", "G", "Lcom/transsion/shorttv/bean/Subject;", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class r extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private int selectEp;

    /* renamed from: G, reason: from kotlin metadata */
    private Subject subject;

    public r() {
        super(R.layout.short_tv_item_episode, (List) null, 2, (DefaultConstructorMarker) null);
        this.selectEp = -1;
    }

    private final void E1(nr.e item, BaseViewHolder holder) {
        ShortTvDownloadEpItemView shortTvDownloadEpItemView = (ShortTvDownloadEpItemView) holder.getView(R.id.v_ep);
        shortTvDownloadEpItemView.showLockedImg(dr.b.a.c(this.subject, item.d()));
        shortTvDownloadEpItemView.showPlayingImg(item.c() == this.selectEp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, nr.e item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ShortTvDownloadEpItemView shortTvDownloadEpItemView = (ShortTvDownloadEpItemView) holder.getView(R.id.v_ep);
        shortTvDownloadEpItemView.useForEpList();
        shortTvDownloadEpItemView.showIndex(item.c());
        E1(item, holder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void G(BaseViewHolder holder, nr.e item, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.G(holder, item, payloads);
        if (payloads.isEmpty() || !(payloads.get(0) instanceof nr.e)) {
            return;
        }
        E1(item, holder);
    }

    public final void D1(int ep) {
        int i;
        if (ep == this.selectEp) {
            return;
        }
        Iterator it = getData().iterator();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = -1;
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (((nr.e) it.next()).c() == this.selectEp) {
                break;
            } else {
                i3++;
            }
        }
        this.selectEp = ep;
        if (i3 >= 0) {
            notifyItemChanged(i3, (nr.e) getData().get(i3));
        }
        Iterator it2 = getData().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            if (((nr.e) it2.next()).c() == ep) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            notifyItemChanged(i, (nr.e) getData().get(i));
        }
    }

    public final void F1(Subject subject) {
        this.subject = subject;
        notifyDataSetChanged();
    }
}
