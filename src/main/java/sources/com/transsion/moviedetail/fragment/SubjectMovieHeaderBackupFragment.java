package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.activity.MoviePosterActivity;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import ni.f;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J!\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001bR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010%R\u0018\u0010-\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010%¨\u0006."}, d2 = {"Lcom/transsion/moviedetail/fragment/SubjectMovieHeaderBackupFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Llm/t;", "<init>", "()V", "Lcom/transsion/moviedetailapi/bean/Subject;", "movieDetailBean", BuildConfig.FLAVOR, "k0", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", BuildConfig.FLAVOR, "seconds", BuildConfig.FLAVOR, "d0", "(I)Ljava/lang/String;", "subtitles", "i0", "(Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "f0", "(Landroid/view/LayoutInflater;)Llm/t;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "initData", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "a", "Lkotlin/Lazy;", "e0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "b", "Ljava/lang/String;", "TAG", "c", "Lcom/transsion/moviedetailapi/bean/Subject;", "mMovieDetailBean", "d", "ops", "e", "mSubjectId", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubjectMovieHeaderBackupFragment extends BaseFragment<lm.t> {

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.SubjectMovieHeaderBackupFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final androidx.lifecycle.x0 m54invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.fragment.SubjectMovieHeaderBackupFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m55invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: b, reason: from kotlin metadata */
    private final String TAG = "SubjectMovieHeaderFragment";

    /* renamed from: c, reason: from kotlin metadata */
    private Subject mMovieDetailBean;

    /* renamed from: d, reason: from kotlin metadata */
    private String ops;

    /* renamed from: e, reason: from kotlin metadata */
    private String mSubjectId;

    static final class a implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        a(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    private final String d0(int seconds) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("%02dh%02dm", Arrays.copyOf(new Object[]{Integer.valueOf(seconds / 3600), Integer.valueOf((seconds % 3600) / 60)}, 2));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    private final MovieDetailViewModel e0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(SubjectMovieHeaderBackupFragment subjectMovieHeaderBackupFragment, Pair pair) {
        HashMap g;
        HashMap g2;
        Subject subject = (Subject) pair.getSecond();
        wf.a.a.c(subjectMovieHeaderBackupFragment.TAG, "get movie detail data==" + pair, true);
        if (subject != null) {
            subjectMovieHeaderBackupFragment.k0(subject);
            qi.b logViewConfig = subjectMovieHeaderBackupFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            qi.b logViewConfig2 = subjectMovieHeaderBackupFragment.getLogViewConfig();
            if (logViewConfig2 != null) {
                logViewConfig2.n(subjectMovieHeaderBackupFragment.ops);
            }
            qi.b logViewConfig3 = subjectMovieHeaderBackupFragment.getLogViewConfig();
            if (logViewConfig3 != null && (g2 = logViewConfig3.g()) != null) {
                String subjectId = subject.getSubjectId();
                if (subjectId == null) {
                    subjectId = BuildConfig.FLAVOR;
                }
                g2.put("subject_id", subjectId);
            }
            qi.b logViewConfig4 = subjectMovieHeaderBackupFragment.getLogViewConfig();
            if (logViewConfig4 != null && (g = logViewConfig4.g()) != null) {
                g.put("has_resource", String.valueOf(subject.getHasResource()));
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(SubjectMovieHeaderBackupFragment subjectMovieHeaderBackupFragment, View view) {
        jm.j jVar = new jm.j(subjectMovieHeaderBackupFragment.mMovieDetailBean);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jm.j.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, jVar, 0L);
        com.transsion.baselib.helper.a.a.h("subjectdetail", "movie_poster", (r16 & 4) != 0 ? BuildConfig.FLAVOR : BuildConfig.FLAVOR, (r16 & 8) != 0 ? BuildConfig.FLAVOR : subjectMovieHeaderBackupFragment.mSubjectId, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
        subjectMovieHeaderBackupFragment.startActivity(new Intent(subjectMovieHeaderBackupFragment.requireContext(), (Class<?>) MoviePosterActivity.class));
    }

    private final void i0(String subtitles) {
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        AppCompatTextView appCompatTextView6;
        AppCompatTextView appCompatTextView7;
        AppCompatImageView appCompatImageView2;
        CharSequence v = e0().v(subtitles);
        if (v == null || v.length() == 0) {
            lm.t tVar = (lm.t) getMViewBinding();
            if (tVar != null && (appCompatTextView2 = tVar.n) != null) {
                uf.c.g(appCompatTextView2);
            }
            lm.t tVar2 = (lm.t) getMViewBinding();
            if (tVar2 != null && (appCompatImageView = tVar2.h) != null) {
                uf.c.g(appCompatImageView);
            }
            lm.t tVar3 = (lm.t) getMViewBinding();
            if (tVar3 == null || (appCompatTextView = tVar3.m) == null) {
                return;
            }
            uf.c.g(appCompatTextView);
            return;
        }
        lm.t tVar4 = (lm.t) getMViewBinding();
        if (tVar4 != null && (appCompatImageView2 = tVar4.h) != null) {
            uf.c.k(appCompatImageView2);
        }
        lm.t tVar5 = (lm.t) getMViewBinding();
        if (tVar5 != null && (appCompatTextView7 = tVar5.n) != null) {
            uf.c.k(appCompatTextView7);
        }
        lm.t tVar6 = (lm.t) getMViewBinding();
        if (tVar6 == null || (appCompatTextView3 = tVar6.n) == null) {
            return;
        }
        appCompatTextView3.setText(v);
        TextPaint paint = appCompatTextView3.getPaint();
        Intrinsics.g(paint, "getPaint(...)");
        int f = com.transsion.core.utils.e.f() - com.blankj.utilcode.util.i.e(130.0f);
        StaticLayout build = Build.VERSION.SDK_INT > 23 ? StaticLayout.Builder.obtain(v, 0, v.length(), paint, f).build() : new StaticLayout(v, paint, f, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        Intrinsics.e(build);
        if (build.getLineCount() <= 1) {
            lm.t tVar7 = (lm.t) getMViewBinding();
            if (tVar7 == null || (appCompatTextView4 = tVar7.m) == null) {
                return;
            }
            uf.c.g(appCompatTextView4);
            return;
        }
        lm.t tVar8 = (lm.t) getMViewBinding();
        if (tVar8 != null && (appCompatTextView6 = tVar8.m) != null) {
            uf.c.k(appCompatTextView6);
        }
        lm.t tVar9 = (lm.t) getMViewBinding();
        if (tVar9 == null || (appCompatTextView5 = tVar9.m) == null) {
            return;
        }
        appCompatTextView5.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.n2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectMovieHeaderBackupFragment.j0(SubjectMovieHeaderBackupFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(SubjectMovieHeaderBackupFragment subjectMovieHeaderBackupFragment, View view) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        lm.t tVar = (lm.t) subjectMovieHeaderBackupFragment.getMViewBinding();
        if (tVar != null && (appCompatTextView2 = tVar.m) != null) {
            uf.c.g(appCompatTextView2);
        }
        lm.t tVar2 = (lm.t) subjectMovieHeaderBackupFragment.getMViewBinding();
        if (tVar2 == null || (appCompatTextView = tVar2.n) == null) {
            return;
        }
        appCompatTextView.setMaxLines(5);
    }

    private final void k0(Subject movieDetailBean) {
        Subject subject;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        ImageView imageView;
        String str;
        String thumbnail;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView6;
        AppCompatImageView appCompatImageView2;
        ShapeableImageView shapeableImageView;
        AppCompatTextView appCompatTextView7;
        AppCompatImageView appCompatImageView3;
        this.mMovieDetailBean = movieDetailBean;
        String ops = movieDetailBean != null ? movieDetailBean.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject = this.mMovieDetailBean) != null) {
            subject.setOps(this.ops);
        }
        int a2 = com.transsion.flow.h.a(movieDetailBean.getSubjectType());
        lm.t tVar = (lm.t) getMViewBinding();
        if (tVar != null && (appCompatImageView3 = tVar.d) != null) {
            appCompatImageView3.setImageResource(a2);
        }
        lm.t tVar2 = (lm.t) getMViewBinding();
        if (tVar2 != null && (appCompatTextView7 = tVar2.k) != null) {
            appCompatTextView7.setText(movieDetailBean.getTitle());
        }
        Subject subject2 = this.mMovieDetailBean;
        i0(subject2 != null ? subject2.getSubtitles() : null);
        if (movieDetailBean.isMusicType()) {
            lm.t tVar3 = (lm.t) getMViewBinding();
            if (tVar3 != null && (shapeableImageView = tVar3.e) != null) {
                uf.c.g(shapeableImageView);
            }
            lm.t tVar4 = (lm.t) getMViewBinding();
            if (tVar4 != null && (appCompatImageView2 = tVar4.g) != null) {
                uf.c.g(appCompatImageView2);
            }
            lm.t tVar5 = (lm.t) getMViewBinding();
            if (tVar5 != null && (appCompatTextView6 = tVar5.l) != null) {
                uf.c.g(appCompatTextView6);
            }
            lm.t tVar6 = (lm.t) getMViewBinding();
            if (tVar6 != null && (appCompatImageView = tVar6.h) != null) {
                uf.c.g(appCompatImageView);
            }
            lm.t tVar7 = (lm.t) getMViewBinding();
            if (tVar7 != null && (appCompatTextView5 = tVar7.n) != null) {
                uf.c.g(appCompatTextView5);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.isEmpty(movieDetailBean.getCountryName())) {
                spannableStringBuilder.append((CharSequence) movieDetailBean.getLanguage());
            } else {
                spannableStringBuilder.append((CharSequence) movieDetailBean.getCountryName());
            }
            if (!TextUtils.isEmpty(movieDetailBean.getGenre())) {
                if (spannableStringBuilder.length() > 2) {
                    spannableStringBuilder.append((CharSequence) " / ");
                }
                spannableStringBuilder.append((CharSequence) movieDetailBean.getGenre());
            }
            String releaseDate = movieDetailBean.getReleaseDate();
            if (releaseDate != null && releaseDate.length() > 0) {
                spannableStringBuilder.append((CharSequence) " / ");
                spannableStringBuilder.append((CharSequence) releaseDate);
            }
            String duration = movieDetailBean.getDuration();
            if (duration != null) {
                if (duration.length() > 0) {
                    if (spannableStringBuilder.length() > 0) {
                        spannableStringBuilder.append((CharSequence) " / ");
                    }
                    spannableStringBuilder.append((CharSequence) duration);
                } else {
                    Integer durationSeconds = movieDetailBean.getDurationSeconds();
                    if ((durationSeconds != null ? durationSeconds.intValue() : 0) > 0) {
                        spannableStringBuilder.append((CharSequence) " / ");
                        Integer durationSeconds2 = movieDetailBean.getDurationSeconds();
                        spannableStringBuilder.append((CharSequence) d0(durationSeconds2 != null ? durationSeconds2.intValue() : 0));
                    }
                }
            }
            lm.t tVar8 = (lm.t) getMViewBinding();
            if (tVar8 == null || (appCompatTextView4 = tVar8.j) == null) {
                return;
            }
            appCompatTextView4.setText(spannableStringBuilder);
            return;
        }
        lm.t tVar9 = (lm.t) getMViewBinding();
        if (tVar9 != null && (imageView = tVar9.e) != null) {
            f.a aVar = ni.f.a;
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            f.b m = aVar.m(requireContext);
            Cover cover = movieDetailBean.getCover();
            String str2 = BuildConfig.FLAVOR;
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b g = m.g(str);
            Cover cover2 = movieDetailBean.getCover();
            if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                str2 = thumbnail;
            }
            g.l(str2).d(imageView);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        String restrictLevel = movieDetailBean.getRestrictLevel();
        if (restrictLevel != null) {
            if (restrictLevel.length() > 0) {
                spannableStringBuilder2.append((CharSequence) " / ");
                spannableStringBuilder2.append((CharSequence) restrictLevel);
            }
        }
        String releaseDate2 = movieDetailBean.getReleaseDate();
        if (releaseDate2 != null) {
            if (releaseDate2.length() > 0) {
                spannableStringBuilder2.append((CharSequence) " / ");
                spannableStringBuilder2.append((CharSequence) releaseDate2);
            }
        }
        String duration2 = movieDetailBean.getDuration();
        if (duration2 != null) {
            if (duration2.length() > 0) {
                if ((spannableStringBuilder2.length() > 0 ? 1 : 0) != 0) {
                    spannableStringBuilder2.append((CharSequence) " / ");
                }
                spannableStringBuilder2.append((CharSequence) duration2);
            } else {
                Integer durationSeconds3 = movieDetailBean.getDurationSeconds();
                if ((durationSeconds3 != null ? durationSeconds3.intValue() : 0) > 0) {
                    spannableStringBuilder2.append((CharSequence) " / ");
                    Integer durationSeconds4 = movieDetailBean.getDurationSeconds();
                    spannableStringBuilder2.append((CharSequence) d0(durationSeconds4 != null ? durationSeconds4.intValue() : 0));
                }
            }
        }
        lm.t tVar10 = (lm.t) getMViewBinding();
        if (tVar10 != null && (appCompatTextView3 = tVar10.o) != null) {
            appCompatTextView3.setText(spannableStringBuilder2);
        }
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(movieDetailBean.getCountryName())) {
            spannableStringBuilder3.append((CharSequence) movieDetailBean.getCountryName());
        }
        if (!TextUtils.isEmpty(movieDetailBean.getGenre())) {
            if (spannableStringBuilder3.length() > 2) {
                spannableStringBuilder3.append((CharSequence) " / ");
            }
            spannableStringBuilder3.append((CharSequence) movieDetailBean.getGenre());
        }
        lm.t tVar11 = (lm.t) getMViewBinding();
        if (tVar11 != null && (appCompatTextView2 = tVar11.j) != null) {
            appCompatTextView2.setText(spannableStringBuilder3);
        }
        lm.t tVar12 = (lm.t) getMViewBinding();
        if (tVar12 == null || (appCompatTextView = tVar12.l) == null) {
            return;
        }
        appCompatTextView.setText(movieDetailBean.getImdbRate());
    }

    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public lm.t getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        lm.t c = lm.t.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.ops = arguments != null ? arguments.getString("ops") : null;
        Bundle arguments2 = getArguments();
        this.mSubjectId = arguments2 != null ? arguments2.getString("id") : null;
        e0().F().j(this, new a(new Function1() { // from class: com.transsion.moviedetail.fragment.l2
            public final Object invoke(Object obj) {
                Unit g0;
                g0 = SubjectMovieHeaderBackupFragment.g0(SubjectMovieHeaderBackupFragment.this, (Pair) obj);
                return g0;
            }
        }));
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        lm.t tVar = (lm.t) getMViewBinding();
        if (tVar != null) {
            tVar.e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.m2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubjectMovieHeaderBackupFragment.h0(SubjectMovieHeaderBackupFragment.this, view2);
                }
            });
        }
    }

    public void lazyLoadData() {
    }
}
