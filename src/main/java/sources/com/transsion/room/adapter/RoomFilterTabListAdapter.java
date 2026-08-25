package com.transsion.room.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLTextView;
import com.transsion.flow.bean.RoomFilter;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.R$layout;
import fp.z;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/transsion/room/adapter/RoomFilterTabListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/RoomFilter;", "Lcom/transsion/room/adapter/RoomFilterTabListAdapter$FilterTabListItemVH;", "<init>", "()V", "holder", BuildConfig.FLAVOR, "isSelected", BuildConfig.FLAVOR, "E1", "(Lcom/transsion/room/adapter/RoomFilterTabListAdapter$FilterTabListItemVH;Z)V", "Landroid/view/ViewGroup;", "parent", BuildConfig.FLAVOR, "viewType", "D1", "(Landroid/view/ViewGroup;I)Lcom/transsion/room/adapter/RoomFilterTabListAdapter$FilterTabListItemVH;", "item", "B1", "(Lcom/transsion/room/adapter/RoomFilterTabListAdapter$FilterTabListItemVH;Lcom/transsion/moviedetailapi/bean/RoomFilter;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "payloads", "C1", "(Lcom/transsion/room/adapter/RoomFilterTabListAdapter$FilterTabListItemVH;Lcom/transsion/moviedetailapi/bean/RoomFilter;Ljava/util/List;)V", "FilterTabListItemVH", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomFilterTabListAdapter extends BaseQuickAdapter {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/room/adapter/RoomFilterTabListAdapter$FilterTabListItemVH;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lfp/z;", "viewBinding", "<init>", "(Lfp/z;)V", "a", "Lfp/z;", "f", "()Lfp/z;", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FilterTabListItemVH extends BaseViewHolder {

        /* renamed from: a, reason: from kotlin metadata */
        private final z viewBinding;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public FilterTabListItemVH(z zVar) {
            super(r0);
            Intrinsics.h(zVar, "viewBinding");
            BLFrameLayout root = zVar.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            this.viewBinding = zVar;
        }

        /* renamed from: f, reason: from getter */
        public final z getViewBinding() {
            return this.viewBinding;
        }
    }

    public RoomFilterTabListAdapter() {
        super(R$layout.item_room_list_tab, (List) null, 2, (DefaultConstructorMarker) null);
    }

    private final void E1(FilterTabListItemVH holder, boolean isSelected) {
        Typeface d;
        holder.getViewBinding().b.setSelected(isSelected);
        holder.getViewBinding().c.setSelected(isSelected);
        View view = holder.getViewBinding().d;
        Intrinsics.g(view, "vSelected");
        view.setVisibility(isSelected ? 0 : 8);
        BLTextView bLTextView = holder.getViewBinding().c;
        if (isSelected) {
            Context context = ((RecyclerView.a0) holder).itemView.getContext();
            Intrinsics.g(context, "getContext(...)");
            d = uf.a.c(context);
        } else {
            Context context2 = ((RecyclerView.a0) holder).itemView.getContext();
            Intrinsics.g(context2, "getContext(...)");
            d = uf.a.d(context2);
        }
        bLTextView.setTypeface(d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(FilterTabListItemVH holder, RoomFilter item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        holder.getViewBinding().c.setText(item.getTitle());
        E1(holder, item.getIsSelected());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void G(FilterTabListItemVH holder, RoomFilter item, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.G(holder, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object v0 = CollectionsKt.v0(payloads);
        if (v0 instanceof Boolean) {
            E1(holder, ((Boolean) v0).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public FilterTabListItemVH y0(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        z c = z.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.g(c, "inflate(...)");
        return new FilterTabListItemVH(c);
    }
}
