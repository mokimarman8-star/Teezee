package bw;

import androidx.core.os.d;
import androidx.fragment.app.Fragment;
import com.transsion.moviedetail.fragment.ForYouFragment;
import com.transsion.moviedetail.fragment.HotFragment;
import com.transsion.moviedetail.fragment.SubjectEduHeaderFragment;
import com.transsion.moviedetailapi.PostRankType;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.SubjectDetailHeaderFragment;
import com.transsion.videodetail.VideoDetailAudioTrackSelectDialog;
import com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment;
import com.transsion.web.api.WebConstants;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements wv.a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function1 function1, DubsInfo it) {
        Intrinsics.h(it, "it");
        function1.invoke(it);
        return Unit.a;
    }

    @Override // wv.a
    public Fragment a(String str, String str2, String str3) {
        return HotFragment.Companion.a(str, str2, str3, PostRankType.POST_RANK_TYPE_HOT);
    }

    @Override // wv.a
    public Fragment b(Subject subject, String pageName, String str, boolean z, boolean z2) {
        SubjectEduHeaderFragment subjectMusicHeaderFragment;
        Intrinsics.h(pageName, "pageName");
        Integer subjectType = subject != null ? subject.getSubjectType() : null;
        int value = SubjectType.EDUCATION.getValue();
        if (subjectType != null && subjectType.intValue() == value) {
            subjectMusicHeaderFragment = new SubjectEduHeaderFragment();
        } else {
            subjectMusicHeaderFragment = (subjectType != null && subjectType.intValue() == SubjectType.MUSIC.getValue()) ? new SubjectMusicHeaderFragment() : new SubjectDetailHeaderFragment();
        }
        subjectMusicHeaderFragment.setArguments(d.b(new Pair[]{TuplesKt.a("data_key_resource_detectors", subject), TuplesKt.a("ops", subject != null ? subject.getOps() : null), TuplesKt.a("module_name", str), TuplesKt.a("id", subject != null ? subject.getSubjectId() : null), TuplesKt.a("season", Integer.valueOf(subject != null ? subject.getSeason() : 0)), TuplesKt.a(WebConstants.PAGE_FROM, pageName), TuplesKt.a("is_Intercept_detail", Boolean.valueOf(z)), TuplesKt.a("isOutsideVideo", Boolean.valueOf(z2))}));
        return subjectMusicHeaderFragment;
    }

    @Override // wv.a
    public void c(Fragment targetFragment, int i, String subjectId, final Function1 callback) {
        Intrinsics.h(targetFragment, "targetFragment");
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(callback, "callback");
        VideoDetailAudioTrackSelectDialog videoDetailAudioTrackSelectDialog = new VideoDetailAudioTrackSelectDialog();
        videoDetailAudioTrackSelectDialog.A0(subjectId);
        videoDetailAudioTrackSelectDialog.n0(targetFragment, i);
        videoDetailAudioTrackSelectDialog.z0(new Function1() { // from class: bw.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f;
                f = b.f(Function1.this, (DubsInfo) obj);
                return f;
            }
        });
    }

    @Override // wv.a
    public Fragment d(Subject subject, String str, String str2, boolean z, boolean z2) {
        return ForYouFragment.r.a(subject, str, str2, z, z2);
    }
}
