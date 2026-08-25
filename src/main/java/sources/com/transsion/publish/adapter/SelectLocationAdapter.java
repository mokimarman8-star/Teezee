package com.transsion.publish.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$layout;
import com.transsion.room.api.bean.LocationPlace;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/transsion/publish/adapter/SelectLocationAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/room/api/bean/LocationPlace;", "Lcom/transsion/publish/adapter/SelectLocationAdapter$SelectLocationItemVH;", "<init>", "()V", BuildConfig.FLAVOR, "lat", "lon", BuildConfig.FLAVOR, "D1", "(Ljava/lang/Double;Ljava/lang/Double;)V", "Landroid/view/ViewGroup;", "parent", BuildConfig.FLAVOR, "viewType", "C1", "(Landroid/view/ViewGroup;I)Lcom/transsion/publish/adapter/SelectLocationAdapter$SelectLocationItemVH;", "holder", "item", "B1", "(Lcom/transsion/publish/adapter/SelectLocationAdapter$SelectLocationItemVH;Lcom/transsion/room/api/bean/LocationPlace;)V", "F", "Ljava/lang/Double;", "curLat", "G", "curLon", "SelectLocationItemVH", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SelectLocationAdapter extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private Double curLat;

    /* renamed from: G, reason: from kotlin metadata */
    private Double curLon;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/publish/adapter/SelectLocationAdapter$SelectLocationItemVH;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Llo/j;", "viewBinding", "<init>", "(Llo/j;)V", "a", "Llo/j;", "f", "()Llo/j;", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SelectLocationItemVH extends BaseViewHolder {

        /* renamed from: a, reason: from kotlin metadata */
        private final lo.j viewBinding;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public SelectLocationItemVH(lo.j jVar) {
            super(r0);
            Intrinsics.h(jVar, "viewBinding");
            ConstraintLayout root = jVar.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            this.viewBinding = jVar;
        }

        /* renamed from: f, reason: from getter */
        public final lo.j getViewBinding() {
            return this.viewBinding;
        }
    }

    public SelectLocationAdapter() {
        super(R$layout.item_select_location, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(SelectLocationItemVH holder, LocationPlace item) {
        String str;
        StringBuilder sb;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        holder.getViewBinding().c.setText(item.getName());
        String distance = item.getDistance();
        if (distance == null || distance.length() == 0) {
            Double d = this.curLat;
            if ((d != null ? d.doubleValue() : 0.0d) > 0.0d) {
                Double d2 = this.curLon;
                if ((d2 != null ? d2.doubleValue() : 0.0d) > 0.0d) {
                    if (this.curLat == null || this.curLon == null || item.getLat() == null || item.getLon() == null) {
                        str = null;
                    } else {
                        ij.s sVar = ij.s.a;
                        Double d3 = this.curLat;
                        Intrinsics.e(d3);
                        double doubleValue = d3.doubleValue();
                        Double d4 = this.curLon;
                        Intrinsics.e(d4);
                        double doubleValue2 = d4.doubleValue();
                        Double lat = item.getLat();
                        Intrinsics.e(lat);
                        double doubleValue3 = lat.doubleValue();
                        Double lon = item.getLon();
                        Intrinsics.e(lon);
                        str = sVar.a(doubleValue, doubleValue2, doubleValue3, lon.doubleValue());
                    }
                    sb = new StringBuilder();
                    if (str != null && str.length() != 0) {
                        sb.append(item.getDistance());
                        sb.append("·");
                    }
                    sb.append(item.getAddress());
                    holder.getViewBinding().b.setText(sb);
                }
            }
        }
        str = item.getDistance();
        sb = new StringBuilder();
        if (str != null) {
            sb.append(item.getDistance());
            sb.append("·");
        }
        sb.append(item.getAddress());
        holder.getViewBinding().b.setText(sb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public SelectLocationItemVH y0(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        lo.j c = lo.j.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.g(c, "inflate(...)");
        return new SelectLocationItemVH(c);
    }

    public final void D1(Double lat, Double lon) {
        this.curLat = lat;
        this.curLon = lon;
    }
}
