package com.transsion.search_pugc.fragment.hot.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.Utils;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.bean.HotWord;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/transsion/search_pugc/fragment/hot/adapter/e;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/search_pugc/bean/HotWord;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", BuildConfig.FLAVOR, "layoutResId", "<init>", "(I)V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/search_pugc/bean/HotWord;)V", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends BaseQuickAdapter implements i {
    public e() {
        this(0, 1, null);
    }

    public e(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ e(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R$layout.item_search_keyword_group : i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, HotWord item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        if (!Intrinsics.c(item.getTopicType(), "HASH_TAG")) {
            holder.setText(R$id.tv_keyword, item.getWord());
            return;
        }
        int i = R$id.tv_keyword;
        UGCVideoHashTag hashTag = item.getHashTag();
        holder.setText(i, Utils.SEPARATOR + (hashTag != null ? hashTag.getTitle() : null));
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
