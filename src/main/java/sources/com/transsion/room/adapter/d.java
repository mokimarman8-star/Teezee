package com.transsion.room.adapter;

import android.R;
import android.widget.ImageView;
import cb.n;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.widget.PileLayout;
import com.transsion.flow.bean.RoomItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.R$drawable;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.R$string;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/transsion/room/adapter/d;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", BuildConfig.FLAVOR, "dataList", "<init>", "(Ljava/util/List;)V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/RoomItem;)V", BuildConfig.FLAVOR, "F", "I", "C1", "()I", "sz", "Lcb/n;", "G", "Lcb/n;", "shapeModel", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseQuickAdapter implements i {

    /* renamed from: F, reason: from kotlin metadata */
    private final int sz;

    /* renamed from: G, reason: from kotlin metadata */
    private n shapeModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(List<RoomItem> list) {
        super(R$layout.adapter_hot_room, list);
        Intrinsics.h(list, "dataList");
        this.sz = a0.a(20.0f);
        n m = n.a().q(0, 20.0f).p(n.m).m();
        Intrinsics.g(m, "build(...)");
        this.shapeModel = m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, RoomItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ShapeableImageView view = holder.getView(R$id.iv_cover);
        String avatar = item.getAvatar();
        if (avatar != null) {
            f.a.m(getContext()).g(avatar).m(a0.a(48.0f)).c(a0.a(48.0f)).d(view);
        }
        holder.setText(R$id.tv_name, item.getName());
        holder.setText(R$id.tv_desc, item.getDescription());
        int i = R$id.tv_focus_num;
        Long postCount = item.getPostCount();
        String l = postCount != null ? postCount.toString() : null;
        holder.setText(i, l + getContext().getResources().getString(R$string.str_checkin));
        PileLayout pileLayout = (PileLayout) holder.getView(R$id.pl_member_ic);
        pileLayout.removeAllViews();
        List<String> memberAvatars = item.getMemberAvatars();
        int size = memberAvatars != null ? memberAvatars.size() : 0;
        for (int i2 = 0; i2 < size; i2++) {
            List<String> memberAvatars2 = item.getMemberAvatars();
            String str = memberAvatars2 != null ? memberAvatars2.get(i2) : null;
            ImageView shapeableImageView = new ShapeableImageView(getContext());
            shapeableImageView.setStrokeWidth(com.transsion.baseui.util.a.a.a(getContext(), 1.0f));
            shapeableImageView.setStrokeColor(androidx.core.content.b.getColorStateList(getContext(), R.color.white));
            shapeableImageView.setShapeAppearanceModel(this.shapeModel);
            if (str != null) {
                f.a.m(getContext()).g(str).m(this.sz).c(this.sz).i(R$drawable.ic_avatar_default).d(shapeableImageView);
            }
            int i3 = this.sz;
            pileLayout.addView(shapeableImageView, i3, i3);
        }
        HashMap hashMap = new HashMap();
        String groupId = item.getGroupId();
        if (groupId == null) {
            groupId = BuildConfig.FLAVOR;
        }
        hashMap.put("group_id", groupId);
        hashMap.put("sequence", String.valueOf(g0(item)));
        com.transsion.baselib.helper.a.a.a("rooms", hashMap);
    }

    /* renamed from: C1, reason: from getter */
    public final int getSz() {
        return this.sz;
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
