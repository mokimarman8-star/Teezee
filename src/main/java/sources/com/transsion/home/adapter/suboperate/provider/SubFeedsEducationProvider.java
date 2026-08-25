package com.transsion.home.adapter.suboperate.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.edcation.CourseManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ExplainBean;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.push.bean.MsgStyle;
import com.transsnet.downloader.widget.DownloadView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubFeedsEducationProvider extends BaseItemProvider {
    private final int e;
    private final int f = com.blankj.utilcode.util.y.e();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/transsion/home/adapter/suboperate/provider/SubFeedsEducationProvider$MyViewHolder;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "tabId", "Landroid/view/View;", "view", "<init>", "(ILandroid/view/View;)V", BuildConfig.FLAVOR, "k", "()V", "h", "j", "Lcom/transsion/home/bean/OperateItem;", "item", "i", "(Lcom/transsion/home/bean/OperateItem;)V", "a", "I", "Lkotlinx/coroutines/t1;", "b", "Lkotlinx/coroutines/t1;", "mObserveJob", "c", "Lcom/transsion/home/bean/OperateItem;", "mCurrentItem", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class MyViewHolder extends BaseViewHolder {

        /* renamed from: a, reason: from kotlin metadata */
        private final int tabId;

        /* renamed from: b, reason: from kotlin metadata */
        private t1 mObserveJob;

        /* renamed from: c, reason: from kotlin metadata */
        private OperateItem mCurrentItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyViewHolder(int i, View view) {
            super(view);
            Intrinsics.h(view, "view");
            this.tabId = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k() {
            Subject feedsSubject;
            Integer seenStatus;
            OperateItem operateItem = this.mCurrentItem;
            if (operateItem == null || (feedsSubject = operateItem.getFeedsSubject()) == null || (seenStatus = feedsSubject.getSeenStatus()) == null || seenStatus.intValue() != 1) {
                DownloadView viewOrNull = getViewOrNull(R.id.ll_download);
                if (viewOrNull != null) {
                    viewOrNull.setAddCourse();
                    return;
                }
                return;
            }
            DownloadView viewOrNull2 = getViewOrNull(R.id.ll_download);
            if (viewOrNull2 != null) {
                viewOrNull2.setCourseAdded();
            }
        }

        public final void h() {
            if (HomeTabId.INSTANCE.h(Integer.valueOf(this.tabId), true)) {
                this.mObserveJob = kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SubFeedsEducationProvider$MyViewHolder$registerCourse$1(this, null), 3, (Object) null);
            }
        }

        public final void i(OperateItem item) {
            Intrinsics.h(item, "item");
            this.mCurrentItem = item;
        }

        public final void j() {
            t1 t1Var = this.mObserveJob;
            if (t1Var != null) {
                t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
            }
            this.mObserveJob = null;
        }
    }

    public SubFeedsEducationProvider(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Subject subject, boolean z, boolean z2, long j) {
        subject.setLoadCoverSuccess(z);
        subject.setCoverCache(z2);
        subject.setLoadCoverDuration(j);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(OperateItem operateItem, SubFeedsEducationProvider subFeedsEducationProvider, View view) {
        List data;
        Subject feedsSubject = operateItem.getFeedsSubject();
        if (feedsSubject != null) {
            zk.h.f(feedsSubject, "opt_sub_feeds");
            BaseProviderMultiAdapter g = subFeedsEducationProvider.g();
            subFeedsEducationProvider.G((g == null || (data = g.getData()) == null) ? -1 : data.indexOf(operateItem), feedsSubject, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(OperateItem operateItem, Subject subject, SubFeedsEducationProvider subFeedsEducationProvider, View view) {
        CourseManager.u(CourseManager.a, operateItem.getFeedsSubject(), null, 2, null);
        fk.a.b(subject, SubTabFragment.INSTANCE.a(subFeedsEducationProvider.e), "opt_feeds");
    }

    private final String F(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 3600), Integer.valueOf((i % 3600) / 60), Integer.valueOf(i % 60)}, 3));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    private final void G(int i, Subject subject, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", z ? "browse_feeds_item" : "click_feeds_item");
        hashMap.put("sequence", String.valueOf(i));
        hashMap.put("item_type", "rec");
        String ops = subject.getOps();
        String str = BuildConfig.FLAVOR;
        if (ops == null) {
            ops = BuildConfig.FLAVOR;
        }
        hashMap.put("ops", ops);
        String subjectId = subject.getSubjectId();
        if (subjectId != null) {
            str = subjectId;
        }
        hashMap.put("subject_id", str);
        hashMap.put("builtin", subject.getBuiltIn() ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        hashMap.put("tabId", String.valueOf(this.e));
        StringBuilder sb = new StringBuilder();
        List explains = subject.getExplains();
        if (explains != null) {
            Iterator it = explains.iterator();
            while (it.hasNext()) {
                sb.append(((ExplainBean) it.next()).getType());
                sb.append(",");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "toString(...)");
        hashMap.put("rec_explain_type", StringsKt.r1(sb2, new char[]{','}));
        sk.b.d(subject, hashMap);
        if (z) {
            com.transsion.baselib.helper.a.a.e(SubTabFragment.INSTANCE.a(this.e), hashMap);
        } else {
            com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.e), hashMap);
        }
    }

    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        String subjectId;
        List data;
        Integer seenStatus;
        String str;
        String thumbnail;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        if (baseViewHolder instanceof MyViewHolder) {
            ((MyViewHolder) baseViewHolder).i(operateItem);
        }
        final Subject feedsSubject = operateItem.getFeedsSubject();
        if (feedsSubject == null || (subjectId = feedsSubject.getSubjectId()) == null || subjectId.length() == 0) {
            return;
        }
        ShapeableImageView viewOrNull = baseViewHolder.getViewOrNull(R.id.iv_cover);
        if (viewOrNull != null) {
            f.a aVar = ni.f.a;
            Context context = viewOrNull.getContext();
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
            g.l(str2).i(com.tn.lib.widget.R.color.skeleton).m(this.f).b(new Function3() { // from class: com.transsion.home.adapter.suboperate.provider.l
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit C;
                    C = SubFeedsEducationProvider.C(feedsSubject, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Long) obj3).longValue());
                    return C;
                }
            }).d(viewOrNull);
        }
        baseViewHolder.setText(R.id.tv_subject, feedsSubject.getTitle());
        baseViewHolder.setText(R.id.tv_subject_year, a.b(k(), feedsSubject));
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_duration);
        uf.c.k(textView);
        Integer durationSeconds = feedsSubject.getDurationSeconds();
        textView.setText(F(durationSeconds != null ? durationSeconds.intValue() : 0));
        ((RecyclerView.a0) baseViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubFeedsEducationProvider.D(OperateItem.this, this, view);
            }
        });
        DownloadView viewOrNull2 = baseViewHolder.getViewOrNull(R.id.ll_download);
        if (viewOrNull2 != null) {
            if (Intrinsics.c(feedsSubject.getHasResource(), Boolean.TRUE)) {
                uf.c.k(viewOrNull2);
            } else {
                uf.c.g(viewOrNull2);
            }
            viewOrNull2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubFeedsEducationProvider.E(OperateItem.this, feedsSubject, this, view);
                }
            });
        }
        Subject feedsSubject2 = operateItem.getFeedsSubject();
        if (feedsSubject2 == null || (seenStatus = feedsSubject2.getSeenStatus()) == null || seenStatus.intValue() != 1) {
            DownloadView viewOrNull3 = baseViewHolder.getViewOrNull(R.id.ll_download);
            if (viewOrNull3 != null) {
                viewOrNull3.setAddCourse();
            }
        } else {
            DownloadView viewOrNull4 = baseViewHolder.getViewOrNull(R.id.ll_download);
            if (viewOrNull4 != null) {
                viewOrNull4.setCourseAdded();
            }
        }
        BaseProviderMultiAdapter g2 = g();
        G((g2 == null || (data = g2.getData()) == null) ? -1 : data.indexOf(operateItem), feedsSubject, true);
    }

    public int l() {
        return PostItemType.EDUCATION_SUBJECT.ordinal();
    }

    public int m() {
        return R.layout.post_list_item_subject_education;
    }

    public BaseViewHolder r(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        return new MyViewHolder(this.e, u6.a.a(viewGroup, m()));
    }

    public void t(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.t(baseViewHolder);
        if (baseViewHolder instanceof MyViewHolder) {
            ((MyViewHolder) baseViewHolder).h();
        }
    }

    public void u(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.u(baseViewHolder);
        if (baseViewHolder instanceof MyViewHolder) {
            ((MyViewHolder) baseViewHolder).j();
        }
    }
}
