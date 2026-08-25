package com.transsion.edcation.history;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.edcation.R$id;
import com.transsion.edcation.R$layout;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsnet.downloader.DownloadManagerApi;
import ij.t;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/transsion/edcation/history/EducationHistoryAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/baselib/db/video/VideoDetailPlayBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", BuildConfig.FLAVOR, "data", "<init>", "(Ljava/util/List;)V", "item", "Landroid/widget/TextView;", "textView", BuildConfig.FLAVOR, "E1", "(Lcom/transsion/baselib/db/video/VideoDetailPlayBean;Landroid/widget/TextView;)V", "videoDetailPlayBean", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "I1", "(Lcom/transsion/baselib/db/video/VideoDetailPlayBean;Landroid/content/Context;)Ljava/lang/String;", "holder", "F1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/baselib/db/video/VideoDetailPlayBean;)V", "Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "F", "Lkotlin/Lazy;", "H1", "()Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "mVideoDetailPlayDao", "Education_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class EducationHistoryAdapter extends BaseQuickAdapter implements i {

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy mVideoDetailPlayDao;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EducationHistoryAdapter(List<VideoDetailPlayBean> list) {
        super(R$layout.item_education_history, list);
        Intrinsics.h(list, "data");
        this.mVideoDetailPlayDao = LazyKt.b(new Function0() { // from class: com.transsion.edcation.history.a
            public final Object invoke() {
                VideoDetailPlayDao J1;
                J1 = EducationHistoryAdapter.J1();
                return J1;
            }
        });
    }

    private final void E1(VideoDetailPlayBean item, TextView textView) {
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new EducationHistoryAdapter$calculateProgress$1(this, item, textView, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(EducationHistoryAdapter educationHistoryAdapter, VideoDetailPlayBean videoDetailPlayBean, View view) {
        educationHistoryAdapter.I1(videoDetailPlayBean, educationHistoryAdapter.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao H1() {
        return (VideoDetailPlayDao) this.mVideoDetailPlayDao.getValue();
    }

    private final String I1(VideoDetailPlayBean videoDetailPlayBean, Context context) {
        if (!t.a.b()) {
            DownloadManagerApi.a aVar = DownloadManagerApi.j;
            if (DownloadManagerApi.x0(aVar.a(), videoDetailPlayBean != null ? videoDetailPlayBean.getSubjectId() : null, videoDetailPlayBean != null ? videoDetailPlayBean.getId() : null, false, false, 8, (Object) null) && (context instanceof FragmentActivity)) {
                if (videoDetailPlayBean != null && videoDetailPlayBean.getId() != null) {
                    aVar.a().t0((FragmentActivity) context, videoDetailPlayBean.getId(), "Education History");
                }
                return "play_subject";
            }
        }
        Navigator.x(TheRouter.c("/movie/detail").F("subject_type", SubjectType.EDUCATION.getValue()).K("id", videoDetailPlayBean != null ? videoDetailPlayBean.getSubjectId() : null).K("module_name", "Education History"), context, (mf.c) null, 2, (Object) null);
        return "play_subject";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao J1() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return appDatabase$f1.b(a).C1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, final VideoDetailPlayBean item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ShapeableImageView view = holder.getView(R$id.education_history_cover);
        f.b m = f.a.m(getContext());
        String coverUrl = item.getCoverUrl();
        if (coverUrl == null) {
            coverUrl = BuildConfig.FLAVOR;
        }
        m.g(coverUrl).d(view);
        holder.setText(R$id.education_history_title, item.getTitle());
        ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.edcation.history.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EducationHistoryAdapter.G1(EducationHistoryAdapter.this, item, view2);
            }
        });
        E1(item, (TextView) holder.getView(R$id.education_history_tag));
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
