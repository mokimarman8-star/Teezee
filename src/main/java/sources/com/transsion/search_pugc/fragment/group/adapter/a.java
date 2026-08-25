package com.transsion.search_pugc.fragment.group.adapter;

import android.content.Context;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R;
import com.transsion.baseui.util.h;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.api.GroupBean;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import t6.i;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/transsion/search_pugc/fragment/group/adapter/a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/publish/api/GroupBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", BuildConfig.FLAVOR, "layoutResId", "<init>", "(I)V", "item", "sequence", BuildConfig.FLAVOR, "E1", "(Lcom/transsion/publish/api/GroupBean;I)V", "holder", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/publish/api/GroupBean;)V", "F", "I", "D1", "()I", "width", "G", "C1", "height", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseQuickAdapter implements i {

    /* renamed from: F, reason: from kotlin metadata */
    private final int width;

    /* renamed from: G, reason: from kotlin metadata */
    private final int height;

    public a() {
        this(0, 1, null);
    }

    public a(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        this.width = a0.a(48.0f);
        this.height = a0.a(48.0f);
    }

    public /* synthetic */ a(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R$layout.item_search_group : i);
    }

    private final void E1(GroupBean item, int sequence) {
        HashMap hashMap = new HashMap();
        String groupId = item.getGroupId();
        String str = BuildConfig.FLAVOR;
        if (groupId == null) {
            groupId = BuildConfig.FLAVOR;
        }
        hashMap.put("group_id", groupId);
        hashMap.put("sequence", String.valueOf(sequence));
        String ops = item.getOps();
        if (ops != null) {
            str = ops;
        }
        hashMap.put("ops", str);
        com.transsion.baselib.helper.a.a.a("searchresult", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, GroupBean item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        holder.setText(R$id.tv_name, item.getName());
        holder.setText(R$id.tv_des, h.a.a(item.getUserCount()) + " checkin");
        holder.setVisible(R$id.iv_select, item.getSelect());
        Context context = ((RecyclerView.a0) holder).itemView.getContext();
        ImageView imageView = (ImageView) ((RecyclerView.a0) holder).itemView.findViewById(R$id.iv_avatar);
        String avatar = item.getAvatar();
        if (avatar != null) {
            f.a aVar = f.a;
            Intrinsics.e(context);
            f.b c = aVar.m(context).g(avatar).i(R.color.cl34_ff).m(this.width).c(this.height);
            Intrinsics.e(imageView);
            c.d(imageView);
        }
        E1(item, g0(item));
    }

    /* renamed from: C1, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: D1, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
