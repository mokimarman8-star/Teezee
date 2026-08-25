package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsnet.downloader.widget.DownloadView;
import java.util.Calendar;
import java.util.Date;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubjectItemProvider extends b {
    private final boolean e;
    private final int f = Math.min(com.blankj.utilcode.util.y.e(), com.blankj.utilcode.util.y.c());
    private final int g;
    private BaseViewHolder h;

    public SubjectItemProvider(boolean z) {
        this.e = z;
        this.g = com.blankj.utilcode.util.a0.a(z ? 146.40001f : 122.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Subject subject, boolean z, boolean z2, long j) {
        subject.setLoadCoverSuccess(z);
        subject.setCoverCache(z2);
        subject.setLoadCoverDuration(j);
        return Unit.a;
    }

    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        String subjectId;
        Cover cover;
        Cover cover2;
        Cover cover3;
        Cover cover4;
        String str;
        String str2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        final Subject feedsSubject = operateItem.getFeedsSubject();
        if (feedsSubject == null || (subjectId = feedsSubject.getSubjectId()) == null || subjectId.length() == 0) {
            return;
        }
        ConstraintLayout viewOrNull = baseViewHolder.getViewOrNull(R.id.cl_cover);
        if (viewOrNull != null) {
            ViewGroup.LayoutParams layoutParams = viewOrNull.getLayoutParams();
            int i = this.g;
            layoutParams.height = i;
            layoutParams.width = (i / 4) * 3;
            viewOrNull.setLayoutParams(layoutParams);
        }
        ShapeableImageView viewOrNull2 = baseViewHolder.getViewOrNull(R.id.iv_cover);
        String str3 = BuildConfig.FLAVOR;
        if (viewOrNull2 != null) {
            if (feedsSubject.getBuiltIn()) {
                kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new SubjectItemProvider$convert$2$1(feedsSubject, viewOrNull2, null), 3, (Object) null);
            } else {
                f.a aVar = ni.f.a;
                Context context = viewOrNull2.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Cover cover5 = feedsSubject.getCover();
                if (cover5 == null || (str = cover5.getUrl()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b i2 = m.g(str).m(this.f).i(com.tn.lib.widget.R.color.skeleton);
                Cover cover6 = feedsSubject.getCover();
                if (cover6 == null || (str2 = cover6.getThumbnail()) == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                i2.l(str2).b(new Function3() { // from class: com.transsion.home.adapter.trending.provider.j0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit F;
                        F = SubjectItemProvider.F(feedsSubject, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Long) obj3).longValue());
                        return F;
                    }
                }).d(viewOrNull2);
            }
        }
        ShapeableImageView viewOrNull3 = baseViewHolder.getViewOrNull(R.id.iv_stills);
        if (viewOrNull3 != null) {
            ViewGroup.LayoutParams layoutParams2 = viewOrNull3.getLayoutParams();
            layoutParams2.height = this.g;
            viewOrNull3.setLayoutParams(layoutParams2);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Trailer trailer = feedsSubject.getTrailer();
            String url = (trailer == null || (cover4 = trailer.getCover()) == null) ? null : cover4.getUrl();
            objectRef.element = url;
            String str4 = url;
            if (str4 == null || str4.length() == 0) {
                Cover stills = feedsSubject.getStills();
                String url2 = stills != null ? stills.getUrl() : null;
                objectRef.element = (url2 == null || url2.length() == 0 ? (cover = feedsSubject.getCover()) == null : (cover = feedsSubject.getStills()) == null) ? null : cover.getUrl();
            }
            Trailer trailer2 = feedsSubject.getTrailer();
            String thumbnail = (trailer2 == null || (cover3 = trailer2.getCover()) == null) ? null : cover3.getThumbnail();
            if (thumbnail == null || thumbnail.length() == 0) {
                Cover stills2 = feedsSubject.getStills();
                String thumbnail2 = stills2 != null ? stills2.getThumbnail() : null;
                thumbnail = (thumbnail2 == null || thumbnail2.length() == 0 ? (cover2 = feedsSubject.getCover()) == null : (cover2 = feedsSubject.getStills()) == null) ? null : cover2.getThumbnail();
            }
            if (feedsSubject.getBuiltIn()) {
                kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new SubjectItemProvider$convert$3$1(objectRef, viewOrNull3, null), 3, (Object) null);
            } else {
                f.a aVar2 = ni.f.a;
                Context context2 = viewOrNull3.getContext();
                Intrinsics.g(context2, "getContext(...)");
                f.b m2 = aVar2.m(context2);
                String str5 = (String) objectRef.element;
                if (str5 == null) {
                    str5 = BuildConfig.FLAVOR;
                }
                f.b i3 = m2.g(str5).i(com.tn.lib.widget.R.color.skeleton);
                if (thumbnail != null) {
                    str3 = thumbnail;
                }
                i3.l(str3).d(viewOrNull3);
            }
        }
        AppCompatImageView viewOrNull4 = baseViewHolder.getViewOrNull(R.id.ic_player);
        if (viewOrNull4 != null) {
            if (feedsSubject.getTrailer() == null) {
                uf.c.g(viewOrNull4);
            } else {
                uf.c.k(viewOrNull4);
            }
        }
        baseViewHolder.setText(R.id.tv_subject, feedsSubject.getTitle());
        Date l = com.blankj.utilcode.util.c0.l(feedsSubject.getReleaseDate(), "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(l);
        AppCompatTextView viewOrNull5 = baseViewHolder.getViewOrNull(R.id.tv_subject_year);
        if (viewOrNull5 != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
            String countryName = feedsSubject.getCountryName();
            if (countryName != null && countryName.length() != 0) {
                spannableStringBuilder.append((CharSequence) " • ").append((CharSequence) feedsSubject.getCountryName());
            }
            String genre = feedsSubject.getGenre();
            if (genre != null && genre.length() != 0) {
                SpannableStringBuilder append = spannableStringBuilder.append((CharSequence) " • ");
                String genre2 = feedsSubject.getGenre();
                append.append((CharSequence) (genre2 != null ? StringsKt.Q(genre2, "，", " • ", false, 4, (Object) null) : null));
            }
            viewOrNull5.setText(spannableStringBuilder.toString());
            Drawable drawable = androidx.core.content.b.getDrawable(viewOrNull5.getContext(), com.transsion.flow.h.a(feedsSubject.getSubjectType()));
            if (drawable != null) {
                drawable.setTint(androidx.core.content.b.getColor(viewOrNull5.getContext(), com.tn.lib.widget.R.color.gray_40));
            }
            viewOrNull5.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        baseViewHolder.setText(com.transsion.baseui.R.id.tv_subject, feedsSubject.getTitle());
        if (Intrinsics.c(feedsSubject.getHasResource(), Boolean.TRUE)) {
            DownloadView viewOrNull6 = baseViewHolder.getViewOrNull(R.id.ll_download);
            if (viewOrNull6 != null) {
                uf.c.k(viewOrNull6);
                if (ij.t.a.b()) {
                    Integer subjectType = feedsSubject.getSubjectType();
                    int value = SubjectType.SHORT_TV.getValue();
                    if (subjectType == null || subjectType.intValue() != value) {
                        viewOrNull6.setShowPlayType();
                    }
                }
                ResourceDetectors resourceDetector = feedsSubject.getResourceDetector();
                if (resourceDetector != null) {
                    String subjectId2 = feedsSubject.getSubjectId();
                    String resourceId = resourceDetector.getResourceId();
                    Integer type = resourceDetector.getType();
                    DownloadView.setShowType$default(viewOrNull6, subjectId2, resourceId, Boolean.valueOf(type != null && type.intValue() == 1), false, 0, 24, (Object) null);
                }
            }
        } else {
            baseViewHolder.setGone(R.id.ll_download, true);
        }
        this.h = baseViewHolder;
        A(baseViewHolder, feedsSubject);
    }

    public final View G() {
        BaseViewHolder baseViewHolder = this.h;
        if (baseViewHolder != null) {
            return baseViewHolder.getViewOrNull(R.id.ll_download);
        }
        return null;
    }

    public int l() {
        return PostItemType.SUBJECT.ordinal();
    }

    public int m() {
        return R.layout.post_list_item_subject;
    }
}
