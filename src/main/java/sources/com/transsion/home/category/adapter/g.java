package com.transsion.home.category.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.flow.bean.CategoryItemBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.widget.DownloadView;
import ij.t;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g extends BaseItemProvider {
    private final String e;
    private final boolean f;

    public g(String str, boolean z) {
        Intrinsics.h(str, "pageName");
        this.e = str;
        this.f = z;
    }

    public int l() {
        return 2;
    }

    public int m() {
        return R.layout.adapter_play_list_music;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, CategoryItemBean categoryItemBean) {
        List data;
        ResourceDetectors resourceDetector;
        String str;
        String thumbnail;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(categoryItemBean, "item");
        Subject subject = categoryItemBean.getSubject();
        if (subject != null) {
            BaseProviderMultiAdapter g = g();
            int i = 0;
            int g0 = g != null ? g.g0(categoryItemBean) : 0;
            AppCompatTextView viewOrNull = baseViewHolder.getViewOrNull(R.id.tv_title);
            if (viewOrNull != null) {
                viewOrNull.setText(subject.getTitle());
            }
            ShapeableImageView viewOrNull2 = baseViewHolder.getViewOrNull(R.id.iv_cover);
            if (viewOrNull2 != null) {
                f.a aVar = ni.f.a;
                Context context = viewOrNull2.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Cover cover = subject.getCover();
                String str2 = BuildConfig.FLAVOR;
                if (cover == null || (str = cover.getUrl()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b g2 = m.g(str);
                Cover cover2 = subject.getCover();
                if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                    str2 = thumbnail;
                }
                g2.l(str2).d(viewOrNull2);
            }
            TextView textView = (TextView) baseViewHolder.getViewOrNull(R.id.tvRankNum);
            if (textView != null) {
                textView.setVisibility(this.f ? 0 : 8);
                if (this.f) {
                    int i2 = g0 + 1;
                    textView.setText(String.valueOf(i2));
                    textView.setTextSize(i2 > 99 ? 14.0f : i2 > 9 ? 18.0f : 20.0f);
                }
            }
            DownloadView viewOrNull3 = baseViewHolder.getViewOrNull(R.id.ll_download);
            if (viewOrNull3 != null) {
                viewOrNull3.setPageFrom(this.e);
                if (t.a.b()) {
                    uf.c.k(viewOrNull3);
                    viewOrNull3.setShowPlayType();
                } else {
                    Subject subject2 = categoryItemBean.getSubject();
                    if (subject2 != null ? Intrinsics.c(subject2.getHasResource(), Boolean.TRUE) : false) {
                        DownloadView viewOrNull4 = baseViewHolder.getViewOrNull(R.id.ll_download);
                        if (viewOrNull4 != null) {
                            uf.c.k(viewOrNull4);
                            Subject subject3 = categoryItemBean.getSubject();
                            if (subject3 != null && (resourceDetector = subject3.getResourceDetector()) != null) {
                                Subject subject4 = categoryItemBean.getSubject();
                                String subjectId = subject4 != null ? subject4.getSubjectId() : null;
                                String resourceId = resourceDetector.getResourceId();
                                Integer type = resourceDetector.getType();
                                DownloadView.setShowType$default(viewOrNull4, subjectId, resourceId, Boolean.valueOf(type != null && type.intValue() == 1), false, 0, 24, (Object) null);
                            }
                        }
                    } else {
                        baseViewHolder.setGone(R.id.ll_download, true);
                    }
                }
            }
            if (g0 == 0) {
                View viewOrNull5 = baseViewHolder.getViewOrNull(R.id.divider);
                if (viewOrNull5 != null) {
                    uf.c.k(viewOrNull5);
                }
                View viewOrNull6 = baseViewHolder.getViewOrNull(R.id.bg_gradient);
                if (viewOrNull6 != null) {
                    uf.c.k(viewOrNull6);
                }
                View viewOrNull7 = baseViewHolder.getViewOrNull(R.id.item_root);
                if (viewOrNull7 != null) {
                    viewOrNull7.setBackgroundResource(R$drawable.bg_category_first_item);
                }
            } else {
                View viewOrNull8 = baseViewHolder.getViewOrNull(R.id.divider);
                if (viewOrNull8 != null) {
                    uf.c.g(viewOrNull8);
                }
                View viewOrNull9 = baseViewHolder.getViewOrNull(R.id.bg_gradient);
                if (viewOrNull9 != null) {
                    uf.c.g(viewOrNull9);
                }
                View viewOrNull10 = baseViewHolder.getViewOrNull(R.id.item_root);
                if (viewOrNull10 != null) {
                    viewOrNull10.setBackgroundColor(androidx.core.content.b.getColor(k(), com.tn.lib.widget.R.color.bg_01));
                }
            }
            BaseProviderMultiAdapter g3 = g();
            if (g3 != null && (data = g3.getData()) != null) {
                for (Object obj : data) {
                    int i3 = i + 1;
                    if (i < 0) {
                        CollectionsKt.u();
                    }
                    if (i < g0) {
                        subject.getNonAdDelegate();
                    }
                    i = i3;
                }
            }
            baseViewHolder.getView(R.id.iv_playlist_page_corner).setTextWithType(subject.getCorner(), subject.getSubjectType());
        }
    }
}
