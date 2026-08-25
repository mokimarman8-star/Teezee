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
import com.transsion.shorttv.R;
import com.transsion.shorttv._channel.model.ShortTvCategoryItemBean;
import com.transsion.shorttv._channel.ui.widget.ShortTvDownloadView;
import com.transsion.shorttv.base.widget.CornerTextView;
import com.transsion.shorttv.bean.Cover;
import com.transsion.shorttv.bean.ResourceDetectors;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.bean.SubjectType;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m extends BaseItemProvider {
    private final String e;

    public m(String str) {
        Intrinsics.h(str, "pageName");
        this.e = str;
    }

    private final void z(BaseViewHolder baseViewHolder, int i) {
        AppCompatImageView viewOrNull = baseViewHolder.getViewOrNull(R.id.iv_tag);
        if (viewOrNull != null) {
            if (i == 1) {
                viewOrNull.setImageResource(R.mipmap.short_tv_ic_rank_01);
                AppCompatTextView viewOrNull2 = baseViewHolder.getViewOrNull(R.id.tv_rank);
                if (viewOrNull2 != null) {
                    cr.b.b(viewOrNull2);
                    return;
                }
                return;
            }
            if (i == 2) {
                viewOrNull.setImageResource(R.mipmap.short_tv_ic_rank_02);
                AppCompatTextView viewOrNull3 = baseViewHolder.getViewOrNull(R.id.tv_rank);
                if (viewOrNull3 != null) {
                    cr.b.b(viewOrNull3);
                    return;
                }
                return;
            }
            if (i == 3) {
                viewOrNull.setImageResource(R.mipmap.short_tv_ic_rank_03);
                AppCompatTextView viewOrNull4 = baseViewHolder.getViewOrNull(R.id.tv_rank);
                if (viewOrNull4 != null) {
                    cr.b.b(viewOrNull4);
                    return;
                }
                return;
            }
            viewOrNull.setImageResource(R.mipmap.short_tv_ic_rank_defalut);
            viewOrNull.setRotationY(TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? 180.0f : 0.0f);
            AppCompatTextView viewOrNull5 = baseViewHolder.getViewOrNull(R.id.tv_rank);
            if (viewOrNull5 != null) {
                cr.b.e(viewOrNull5);
                StringBuilder sb = new StringBuilder();
                if (i < 10) {
                    sb.append("0");
                    sb.append(i);
                } else {
                    sb.append(i);
                }
                viewOrNull5.setText(sb);
            }
        }
    }

    public int l() {
        return 1;
    }

    public int m() {
        return R.layout.short_tv_adapter_play_list;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, ShortTvCategoryItemBean shortTvCategoryItemBean) {
        List data;
        ResourceDetectors resourceDetector;
        String str;
        String thumbnail;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(shortTvCategoryItemBean, "item");
        Subject subject = shortTvCategoryItemBean.getSubject();
        if (subject != null) {
            BaseProviderMultiAdapter g = g();
            int i = 0;
            int g0 = g != null ? g.g0(shortTvCategoryItemBean) : 0;
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
            AppCompatTextView viewOrNull3 = baseViewHolder.getViewOrNull(R.id.tv_desc);
            if (viewOrNull3 != null) {
                Subject subject2 = shortTvCategoryItemBean.getSubject();
                viewOrNull3.setText(subject2 != null ? subject2.getDescription() : null);
            }
            AppCompatTextView viewOrNull4 = baseViewHolder.getViewOrNull(R.id.tv_score);
            if (viewOrNull4 != null) {
                viewOrNull4.setText(subject.getImdbRate());
            }
            ShortTvDownloadView shortTvDownloadView = (ShortTvDownloadView) baseViewHolder.getViewOrNull(R.id.ll_download);
            if (shortTvDownloadView != null) {
                shortTvDownloadView.setPageFrom(this.e);
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    cr.b.e(shortTvDownloadView);
                } else if (xq.e.a.b()) {
                    cr.b.e(shortTvDownloadView);
                    shortTvDownloadView.setShowPlayType();
                } else {
                    Subject subject3 = shortTvCategoryItemBean.getSubject();
                    if (subject3 != null ? Intrinsics.c(subject3.getHasResource(), Boolean.TRUE) : false) {
                        ShortTvDownloadView shortTvDownloadView2 = (ShortTvDownloadView) baseViewHolder.getViewOrNull(R.id.ll_download);
                        if (shortTvDownloadView2 != null) {
                            cr.b.e(shortTvDownloadView2);
                            Subject subject4 = shortTvCategoryItemBean.getSubject();
                            if (subject4 != null && (resourceDetector = subject4.getResourceDetector()) != null) {
                                Subject subject5 = shortTvCategoryItemBean.getSubject();
                                String subjectId = subject5 != null ? subject5.getSubjectId() : null;
                                String resourceId = resourceDetector.getResourceId();
                                Integer type = resourceDetector.getType();
                                ShortTvDownloadView.setShowType$default(shortTvDownloadView2, subjectId, resourceId, Boolean.valueOf(type != null && type.intValue() == 1), false, 0, 24, null);
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
                    cr.b.e(viewOrNull5);
                }
                View viewOrNull6 = baseViewHolder.getViewOrNull(R.id.bg_gradient);
                if (viewOrNull6 != null) {
                    cr.b.e(viewOrNull6);
                }
                View viewOrNull7 = baseViewHolder.getViewOrNull(R.id.item_root);
                if (viewOrNull7 != null) {
                    viewOrNull7.setBackgroundResource(R.drawable.short_tv_bg_category_first_item);
                }
            } else {
                View viewOrNull8 = baseViewHolder.getViewOrNull(R.id.divider);
                if (viewOrNull8 != null) {
                    cr.b.b(viewOrNull8);
                }
                View viewOrNull9 = baseViewHolder.getViewOrNull(R.id.bg_gradient);
                if (viewOrNull9 != null) {
                    cr.b.b(viewOrNull9);
                }
                View viewOrNull10 = baseViewHolder.getViewOrNull(R.id.item_root);
                if (viewOrNull10 != null) {
                    viewOrNull10.setBackgroundColor(androidx.core.content.b.getColor(k(), R.color.short_tv_gray_light_00));
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
                    if (i2 < g0 && subject.getNonAdDelegate() != null) {
                        i++;
                    }
                    i2 = i3;
                }
            }
            z(baseViewHolder, (g0 + 1) - i);
            ((CornerTextView) baseViewHolder.getView(R.id.iv_playlist_page_corner)).setTextWithType(subject.getCorner(), subject.getSubjectType());
        }
    }
}
