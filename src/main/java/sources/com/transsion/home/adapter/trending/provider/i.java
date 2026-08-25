package com.transsion.home.adapter.trending.provider;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i extends BaseItemProvider {
    private final int e;

    public i(int i) {
        this.e = (com.blankj.utilcode.util.y.e() - com.blankj.utilcode.util.a0.a(((i - 1) * 8) + 24.0f)) / i;
    }

    public int l() {
        return PostItemType.GRID_SUBJECT.ordinal();
    }

    public int m() {
        return R.layout.item_grid_feeds_subject;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        String str;
        Cover cover;
        String thumbnail;
        Cover cover2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        ShapeableImageView view = baseViewHolder.getView(R.id.iv_cover);
        f.b m = ni.f.a.m(k());
        Subject feedsSubject = operateItem.getFeedsSubject();
        String str2 = BuildConfig.FLAVOR;
        if (feedsSubject == null || (cover2 = feedsSubject.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g = m.g(str);
        Subject feedsSubject2 = operateItem.getFeedsSubject();
        if (feedsSubject2 != null && (cover = feedsSubject2.getCover()) != null && (thumbnail = cover.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        g.l(str2).m(this.e).d(view);
        int i = R.id.tv_title;
        Subject feedsSubject3 = operateItem.getFeedsSubject();
        baseViewHolder.setText(i, feedsSubject3 != null ? feedsSubject3.getTitle() : null);
        CornerTextView view2 = baseViewHolder.getView(R.id.tv_tips);
        Subject feedsSubject4 = operateItem.getFeedsSubject();
        String corner = feedsSubject4 != null ? feedsSubject4.getCorner() : null;
        Subject feedsSubject5 = operateItem.getFeedsSubject();
        view2.setTextWithType(corner, feedsSubject5 != null ? feedsSubject5.getSubjectType() : null);
    }
}
