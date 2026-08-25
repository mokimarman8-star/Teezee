package com.transsion.moviedetail.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.flow.h;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.dialog.SubjectEduInfoMoreDetailDialog;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.InfoExtendView;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.play.detail.fragment.BaseBottomDialogFragment;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lm.e;
import qi.b;
import uf.c;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/transsion/moviedetail/dialog/SubjectEduInfoMoreDetailDialog;", "Lcom/transsion/play/detail/fragment/BaseBottomDialogFragment;", "Llm/e;", "<init>", "()V", "Lcom/transsion/moviedetailapi/bean/Subject;", "movieDetailBean", BuildConfig.FLAVOR, "s0", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "subject", "r0", "Landroid/view/LayoutInflater;", "inflater", "p0", "(Landroid/view/LayoutInflater;)Llm/e;", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", BuildConfig.FLAVOR, "hidden", "onHiddenChanged", "(Z)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "b", "Lcom/transsion/moviedetailapi/bean/Subject;", "mMovieDetailBean", "c", "Ljava/lang/String;", "mSubjectId", "d", "a", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubjectEduInfoMoreDetailDialog extends BaseBottomDialogFragment<e> {

    /* renamed from: b, reason: from kotlin metadata */
    private Subject mMovieDetailBean;

    /* renamed from: c, reason: from kotlin metadata */
    private String mSubjectId;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(SubjectEduInfoMoreDetailDialog subjectEduInfoMoreDetailDialog, View view) {
        BaseBottomDialogFragment.m0(subjectEduInfoMoreDetailDialog, false, 1, null);
    }

    private final void r0(Subject subject) {
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        InfoExtendView infoExtendView;
        String description = subject != null ? subject.getDescription() : null;
        if (description == null || description.length() == 0) {
            e eVar = (e) getMViewBinding();
            if (eVar == null || (constraintLayout = eVar.c) == null) {
                return;
            }
            c.g(constraintLayout);
            return;
        }
        e eVar2 = (e) getMViewBinding();
        if (eVar2 != null && (infoExtendView = eVar2.c) != null) {
            infoExtendView.showData(subject);
        }
        e eVar3 = (e) getMViewBinding();
        if (eVar3 == null || (constraintLayout2 = eVar3.c) == null) {
            return;
        }
        c.k(constraintLayout2);
    }

    private final void s0(Subject movieDetailBean) {
        e eVar;
        CustomTextViewGroup customTextViewGroup;
        e eVar2;
        CustomTextViewGroup customTextViewGroup2;
        e eVar3;
        CustomTextViewGroup customTextViewGroup3;
        e eVar4;
        CustomTextViewGroup customTextViewGroup4;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        this.mMovieDetailBean = movieDetailBean;
        e eVar5 = (e) getMViewBinding();
        if (eVar5 != null && (appCompatTextView = eVar5.k) != null) {
            appCompatTextView.setText(movieDetailBean.getTitle());
        }
        r0(movieDetailBean);
        int a = h.a(movieDetailBean.getSubjectType());
        e eVar6 = (e) getMViewBinding();
        if (eVar6 != null && (appCompatImageView = eVar6.d) != null) {
            appCompatImageView.setImageResource(a);
        }
        String category = movieDetailBean.getCategory();
        if (category != null && (eVar4 = (e) getMViewBinding()) != null && (customTextViewGroup4 = eVar4.f) != null) {
            customTextViewGroup4.setText(category);
        }
        String genre = movieDetailBean.getGenre();
        if (genre != null && (eVar3 = (e) getMViewBinding()) != null && (customTextViewGroup3 = eVar3.i) != null) {
            customTextViewGroup3.setText(genre);
        }
        String a2 = a.a(this.mMovieDetailBean);
        if (a2 != null && (eVar2 = (e) getMViewBinding()) != null && (customTextViewGroup2 = eVar2.h) != null) {
            customTextViewGroup2.setText(a2);
        }
        Context context = getContext();
        if (context != null) {
            int i = R$string.movie_detail_students;
            Long viewers = movieDetailBean.getViewers();
            String string = context.getString(i, Long.valueOf(viewers != null ? viewers.longValue() : 0L));
            if (string == null || (eVar = (e) getMViewBinding()) == null || (customTextViewGroup = eVar.l) == null) {
                return;
            }
            customTextViewGroup.setText(string);
        }
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
        AppCompatImageView appCompatImageView;
        e eVar = (e) getMViewBinding();
        if (eVar == null || (appCompatImageView = eVar.g) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: mm.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectEduInfoMoreDetailDialog.q0(SubjectEduInfoMoreDetailDialog.this, view);
            }
        });
    }

    public void initViewData() {
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        HashMap g;
        HashMap g2;
        HashMap g3;
        String str;
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        Subject subject = serializable instanceof Subject ? (Subject) serializable : null;
        this.mMovieDetailBean = subject;
        this.mSubjectId = subject != null ? subject.getSubjectId() : null;
        b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g3 = logViewConfig2.g()) != null) {
            Subject subject2 = this.mMovieDetailBean;
            if (subject2 == null || (str = subject2.getSubjectId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            g3.put("subject_id", str);
        }
        b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (g2 = logViewConfig3.g()) != null) {
            Subject subject3 = this.mMovieDetailBean;
            g2.put("subject_type", String.valueOf(subject3 != null ? subject3.getSubjectType() : null));
        }
        b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (g = logViewConfig4.g()) != null) {
            Subject subject4 = this.mMovieDetailBean;
            g.put("has_resource", String.valueOf(subject4 != null ? subject4.getHasResource() : null));
        }
        Subject subject5 = this.mMovieDetailBean;
        if (subject5 != null) {
            int a = h.a(subject5.getSubjectType());
            e eVar = (e) getMViewBinding();
            if (eVar != null && (appCompatImageView = eVar.d) != null) {
                appCompatImageView.setImageResource(a);
            }
            e eVar2 = (e) getMViewBinding();
            if (eVar2 != null && (appCompatTextView = eVar2.k) != null) {
                appCompatTextView.setText(subject5.getTitle());
            }
            s0(subject5);
        }
    }

    public void initViewModel() {
    }

    public b newLogViewConfig() {
        return new b("detail_info", false, 2, null);
    }

    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                logResume();
            }
        }
    }

    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public e getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        e c = e.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void retryLoadData() {
    }
}
