package com.transsion.room.adapter;

import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.flow.bean.RoomItem;
import com.transsion.gslb.BuildConfig;
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

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/transsion/room/adapter/e;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", BuildConfig.FLAVOR, "dataList", "<init>", "(Ljava/util/List;)V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/RoomItem;)V", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends BaseQuickAdapter implements i {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(List<RoomItem> list) {
        super(R$layout.adapter_personal_room, list);
        Intrinsics.h(list, "dataList");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, RoomItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ShapeableImageView view = holder.getView(R$id.iv_cover);
        String avatar = item.getAvatar();
        if (avatar != null) {
            f.a.m(getContext()).g(avatar).m(a0.a(46.0f)).c(a0.a(46.0f)).d(view);
        }
        holder.setText(R$id.tv_name, item.getName());
        int i = R$id.tv_focus_num;
        Long userCount = item.getUserCount();
        String l = userCount != null ? userCount.toString() : null;
        holder.setText(i, l + getContext().getString(R$string.check_in));
        Long newPostCount = item.getNewPostCount();
        long longValue = newPostCount != null ? newPostCount.longValue() : 0L;
        holder.setVisible(R$id.tv_post_num, true);
        if (longValue <= 0) {
            holder.setVisible(R$id.tv_post_num, false);
        } else if (longValue > 99) {
            holder.setText(R$id.tv_post_num, "99+");
        } else {
            holder.setText(R$id.tv_post_num, String.valueOf(longValue));
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

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
