package com.transsion.home.category.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.widget.DownloadView;
import ij.t;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k extends BaseItemProvider {
    private boolean e;

    private final void A(BaseViewHolder baseViewHolder, int i) {
        AppCompatImageView viewOrNull = baseViewHolder.getViewOrNull(R.id.iv_tag);
        if (viewOrNull != null) {
            if (!this.e) {
                AppCompatTextView viewOrNull2 = baseViewHolder.getViewOrNull(R.id.tv_rank);
                if (viewOrNull2 != null) {
                    uf.c.g(viewOrNull2);
                }
                uf.c.g(viewOrNull);
                return;
            }
            uf.c.k(viewOrNull);
            if (i == 1) {
                viewOrNull.setImageResource(R.mipmap.ic_rank_01);
                AppCompatTextView viewOrNull3 = baseViewHolder.getViewOrNull(R.id.tv_rank);
                if (viewOrNull3 != null) {
                    uf.c.g(viewOrNull3);
                    return;
                }
                return;
            }
            if (i == 2) {
                viewOrNull.setImageResource(R.mipmap.ic_rank_02);
                AppCompatTextView viewOrNull4 = baseViewHolder.getViewOrNull(R.id.tv_rank);
                if (viewOrNull4 != null) {
                    uf.c.g(viewOrNull4);
                    return;
                }
                return;
            }
            if (i == 3) {
                viewOrNull.setImageResource(R.mipmap.ic_rank_03);
                AppCompatTextView viewOrNull5 = baseViewHolder.getViewOrNull(R.id.tv_rank);
                if (viewOrNull5 != null) {
                    uf.c.g(viewOrNull5);
                    return;
                }
                return;
            }
            viewOrNull.setImageResource(R.mipmap.ic_rank_defalut);
            viewOrNull.setRotationY(TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? 180.0f : 0.0f);
            AppCompatTextView viewOrNull6 = baseViewHolder.getViewOrNull(R.id.tv_rank);
            if (viewOrNull6 != null) {
                uf.c.k(viewOrNull6);
                uf.c.k(viewOrNull6);
                StringBuilder sb = new StringBuilder();
                if (i < 10) {
                    sb.append("0");
                    sb.append(i);
                } else {
                    sb.append(i);
                }
                viewOrNull6.setText(sb);
            }
        }
    }

    public int l() {
        return 1;
    }

    public int m() {
        return R.layout.adapter_play_list;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, Subject subject) {
        List data;
        String str;
        String thumbnail;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(subject, "item");
        BaseProviderMultiAdapter g = g();
        int i = 0;
        int g0 = g != null ? g.g0(subject) : 0;
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
            zg.h hVar = zg.h.a;
            Context context2 = viewOrNull2.getContext();
            Intrinsics.g(context2, "getContext(...)");
            f.b c = g2.m(hVar.e(context2)).c(viewOrNull2.getHeight());
            Cover cover2 = subject.getCover();
            if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                str2 = thumbnail;
            }
            c.l(str2).d(viewOrNull2);
        }
        AppCompatTextView viewOrNull3 = baseViewHolder.getViewOrNull(R.id.tv_desc);
        if (viewOrNull3 != null) {
            viewOrNull3.setText(subject.getDescription());
        }
        AppCompatTextView viewOrNull4 = baseViewHolder.getViewOrNull(R.id.tv_score);
        if (viewOrNull4 != null) {
            viewOrNull4.setText(subject.getImdbRate());
        }
        DownloadView viewOrNull5 = baseViewHolder.getViewOrNull(R.id.ll_download);
        if (viewOrNull5 != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                uf.c.k(viewOrNull5);
            } else if (t.a.b()) {
                uf.c.k(viewOrNull5);
                viewOrNull5.setShowPlayType();
            } else if (Intrinsics.c(subject.getHasResource(), Boolean.TRUE)) {
                uf.c.k(viewOrNull5);
                ResourceDetectors resourceDetector = subject.getResourceDetector();
                if (resourceDetector != null) {
                    String subjectId = subject.getSubjectId();
                    String resourceId = resourceDetector.getResourceId();
                    Integer type = resourceDetector.getType();
                    DownloadView.setShowType$default(viewOrNull5, subjectId, resourceId, Boolean.valueOf(type != null && type.intValue() == 1), false, 0, 24, (Object) null);
                }
            } else {
                baseViewHolder.setGone(R.id.ll_download, true);
            }
        }
        if (g0 == 0) {
            View viewOrNull6 = baseViewHolder.getViewOrNull(R.id.divider);
            if (viewOrNull6 != null) {
                uf.c.k(viewOrNull6);
            }
            View viewOrNull7 = baseViewHolder.getViewOrNull(R.id.bg_gradient);
            if (viewOrNull7 != null) {
                uf.c.k(viewOrNull7);
            }
            View viewOrNull8 = baseViewHolder.getViewOrNull(R.id.item_root);
            if (viewOrNull8 != null) {
                viewOrNull8.setBackgroundResource(R$drawable.bg_category_first_item);
            }
        } else {
            View viewOrNull9 = baseViewHolder.getViewOrNull(R.id.divider);
            if (viewOrNull9 != null) {
                uf.c.g(viewOrNull9);
            }
            View viewOrNull10 = baseViewHolder.getViewOrNull(R.id.bg_gradient);
            if (viewOrNull10 != null) {
                uf.c.g(viewOrNull10);
            }
            View viewOrNull11 = baseViewHolder.getViewOrNull(R.id.item_root);
            if (viewOrNull11 != null) {
                viewOrNull11.setBackgroundColor(androidx.core.content.b.getColor(k(), com.tn.lib.widget.R.color.bg_01));
            }
        }
        BaseProviderMultiAdapter g3 = g();
        if (g3 != null && (data = g3.getData()) != null) {
            int i2 = 0;
            for (Object obj : data) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                Subject subject2 = (Subject) obj;
                if (i2 < g0 && subject2.getNonAdDelegate() != null) {
                    i++;
                }
                i2 = i3;
            }
        }
        A(baseViewHolder, (g0 + 1) - i);
        baseViewHolder.getView(R.id.iv_playlist_page_corner).setTextWithType(subject.getCorner(), subject.getSubjectType());
    }

    public final void z(boolean z) {
        this.e = z;
    }
}
