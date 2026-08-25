package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.transsnet.downloader.widget.DownloadView;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubjectSingleImgItemProvider extends b {
    private final boolean e;
    private final int f;
    private final double g;
    private BaseViewHolder h;

    public SubjectSingleImgItemProvider(boolean z) {
        this.e = z;
        int min = Math.min(com.blankj.utilcode.util.y.e(), com.blankj.utilcode.util.y.c());
        this.f = min;
        this.g = min * 0.5d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Subject subject, boolean z, boolean z2, long j) {
        subject.setLoadCoverSuccess(z);
        subject.setCoverCache(z2);
        subject.setLoadCoverDuration(j);
        return Unit.a;
    }

    private final String G(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 3600), Integer.valueOf((i % 3600) / 60), Integer.valueOf(i % 60)}, 3));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0111, code lost:
    
        if (r0.intValue() != r2) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0245  */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        String subjectId;
        AppCompatTextView viewOrNull;
        String str;
        String thumbnail;
        ConstraintLayout viewOrNull2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        final Subject feedsSubject = operateItem.getFeedsSubject();
        if (feedsSubject == null || (subjectId = feedsSubject.getSubjectId()) == null || subjectId.length() == 0) {
            return;
        }
        if (this.e && (viewOrNull2 = baseViewHolder.getViewOrNull(R.id.cl_cover)) != null) {
            ViewGroup.LayoutParams layoutParams = viewOrNull2.getLayoutParams();
            layoutParams.height = lj.a.b(122);
            layoutParams.width = ((int) this.g) - lj.a.b(36);
            viewOrNull2.setLayoutParams(layoutParams);
        }
        ShapeableImageView viewOrNull3 = baseViewHolder.getViewOrNull(R.id.iv_cover);
        if (viewOrNull3 != null) {
            if (feedsSubject.getBuiltIn()) {
                kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new SubjectSingleImgItemProvider$convert$2$1(feedsSubject, viewOrNull3, null), 3, (Object) null);
            } else {
                f.a aVar = ni.f.a;
                Context context = viewOrNull3.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Cover cover = feedsSubject.getCover();
                String str2 = BuildConfig.FLAVOR;
                if (cover == null || (str = cover.getUrl()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b g = m.g(str);
                Cover cover2 = feedsSubject.getCover();
                if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                    str2 = thumbnail;
                }
                g.l(str2).i(com.tn.lib.widget.R.color.skeleton).m(this.f).b(new Function3() { // from class: com.transsion.home.adapter.trending.provider.k0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit F;
                        F = SubjectSingleImgItemProvider.F(feedsSubject, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Long) obj3).longValue());
                        return F;
                    }
                }).d(viewOrNull3);
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
        Integer subjectType = feedsSubject.getSubjectType();
        int value = SubjectType.MUSIC.getValue();
        boolean z = false;
        if (subjectType == null || subjectType.intValue() != value) {
            Integer subjectType2 = feedsSubject.getSubjectType();
            int value2 = SubjectType.AUDIO.getValue();
            if (subjectType2 == null || subjectType2.intValue() != value2) {
                Integer subjectType3 = feedsSubject.getSubjectType();
                int value3 = SubjectType.EDUCATION.getValue();
                if (subjectType3 != null) {
                }
                baseViewHolder.getView(R.id.tv_tips).setTextWithType(feedsSubject.getCorner(), feedsSubject.getSubjectType());
                Date l = com.blankj.utilcode.util.c0.l(feedsSubject.getReleaseDate(), "yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(l);
                viewOrNull = baseViewHolder.getViewOrNull(R.id.tv_subject_year);
                if (viewOrNull != null) {
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
                    viewOrNull.setText(spannableStringBuilder.toString());
                    Drawable drawable = androidx.core.content.b.getDrawable(viewOrNull.getContext(), com.transsion.flow.h.a(feedsSubject.getSubjectType()));
                    if (drawable != null) {
                        drawable.setTint(androidx.core.content.b.getColor(viewOrNull.getContext(), com.tn.lib.widget.R.color.gray_40));
                    }
                    viewOrNull.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (Intrinsics.c(feedsSubject.getHasResource(), Boolean.TRUE)) {
                    baseViewHolder.setGone(R.id.ll_download, true);
                } else {
                    DownloadView viewOrNull5 = baseViewHolder.getViewOrNull(R.id.ll_download);
                    if (viewOrNull5 != null) {
                        uf.c.k(viewOrNull5);
                        if (ij.t.a.b()) {
                            Integer subjectType4 = feedsSubject.getSubjectType();
                            int value4 = SubjectType.SHORT_TV.getValue();
                            if (subjectType4 == null || subjectType4.intValue() != value4) {
                                viewOrNull5.setShowPlayType();
                            }
                        }
                        ResourceDetectors resourceDetector = feedsSubject.getResourceDetector();
                        if (resourceDetector != null) {
                            String subjectId2 = feedsSubject.getSubjectId();
                            String resourceId = resourceDetector.getResourceId();
                            Integer type = resourceDetector.getType();
                            if (type != null && type.intValue() == 1) {
                                z = true;
                            }
                            DownloadView.setShowType$default(viewOrNull5, subjectId2, resourceId, Boolean.valueOf(z), false, 0, 24, (Object) null);
                        }
                    }
                }
                this.h = baseViewHolder;
                A(baseViewHolder, feedsSubject);
            }
        }
        uf.c.h(baseViewHolder.getView(R.id.tv_score));
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_duration);
        uf.c.k(textView);
        Integer durationSeconds = feedsSubject.getDurationSeconds();
        textView.setText(G(durationSeconds != null ? durationSeconds.intValue() : 0));
        baseViewHolder.getView(R.id.tv_tips).setTextWithType(feedsSubject.getCorner(), feedsSubject.getSubjectType());
        Date l2 = com.blankj.utilcode.util.c0.l(feedsSubject.getReleaseDate(), "yyyy-MM-dd");
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(l2);
        viewOrNull = baseViewHolder.getViewOrNull(R.id.tv_subject_year);
        if (viewOrNull != null) {
        }
        if (Intrinsics.c(feedsSubject.getHasResource(), Boolean.TRUE)) {
        }
        this.h = baseViewHolder;
        A(baseViewHolder, feedsSubject);
    }

    public final View H() {
        BaseViewHolder baseViewHolder = this.h;
        if (baseViewHolder != null) {
            return baseViewHolder.getViewOrNull(R.id.ll_download);
        }
        return null;
    }

    public int l() {
        return PostItemType.SINGLE_SUBJECT.ordinal();
    }

    public int m() {
        return R.layout.post_list_item_subject_single_img;
    }
}
