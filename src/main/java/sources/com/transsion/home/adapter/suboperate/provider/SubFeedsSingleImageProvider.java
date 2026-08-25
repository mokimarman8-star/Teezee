package com.transsion.home.adapter.suboperate.provider;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.adapter.trending.provider.SubjectSingleImgItemProvider;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.ExplainBean;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.push.bean.MsgStyle;
import com.transsion.videodetail.music.data.MusicLikedFragmentViewModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class SubFeedsSingleImageProvider extends BaseItemProvider {
    private final int e;
    private final boolean f;
    private final SubjectSingleImgItemProvider g;
    private final Lazy h = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.suboperate.provider.r
        public final Object invoke() {
            MusicLikedFragmentViewModel G;
            G = SubFeedsSingleImageProvider.G();
            return G;
        }
    });

    public SubFeedsSingleImageProvider(int i, boolean z) {
        this.e = i;
        this.f = z;
        this.g = new SubjectSingleImgItemProvider(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(OperateItem operateItem, SubFeedsSingleImageProvider subFeedsSingleImageProvider, View view) {
        List data;
        Subject feedsSubject = operateItem.getFeedsSubject();
        if (feedsSubject != null) {
            if (yg.l.a.e()) {
                zk.h.f(feedsSubject, "opt_sub_feeds");
                BaseProviderMultiAdapter g = subFeedsSingleImageProvider.g();
                subFeedsSingleImageProvider.H((g == null || (data = g.getData()) == null) ? -1 : data.indexOf(operateItem), feedsSubject, false);
            } else {
                AppCompatActivity k = subFeedsSingleImageProvider.k();
                AppCompatActivity appCompatActivity = k instanceof AppCompatActivity ? k : null;
                if (appCompatActivity != null) {
                    kotlinx.coroutines.i.d(androidx.lifecycle.v.a(appCompatActivity), (CoroutineContext) null, (CoroutineStart) null, new SubFeedsSingleImageProvider$convert$2$1$1$1(subFeedsSingleImageProvider, operateItem, feedsSubject, null), 3, (Object) null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(OperateItem operateItem, SubFeedsSingleImageProvider subFeedsSingleImageProvider, View view) {
        Subject feedsSubject;
        List data;
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L) || (feedsSubject = operateItem.getFeedsSubject()) == null) {
            return;
        }
        zk.h.g(feedsSubject, SubTabFragment.INSTANCE.a(subFeedsSingleImageProvider.e), subFeedsSingleImageProvider.k(), "opt_sub_feeds");
        BaseProviderMultiAdapter g = subFeedsSingleImageProvider.g();
        subFeedsSingleImageProvider.H((g == null || (data = g.getData()) == null) ? -1 : data.indexOf(operateItem), feedsSubject, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MusicLikedFragmentViewModel G() {
        return new MusicLikedFragmentViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(int i, Subject subject, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", z ? "browse_feeds_single_item" : "click_feeds_single_item");
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

    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        List data;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        Subject feedsSubject = operateItem.getFeedsSubject();
        if (feedsSubject != null) {
            this.g.b(baseViewHolder, operateItem);
            BaseProviderMultiAdapter g = g();
            H((g == null || (data = g.getData()) == null) ? -1 : data.indexOf(operateItem), feedsSubject, true);
        }
        ((RecyclerView.a0) baseViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubFeedsSingleImageProvider.D(OperateItem.this, this, view);
            }
        });
        View H = this.g.H();
        if (H != null) {
            H.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubFeedsSingleImageProvider.E(OperateItem.this, this, view);
                }
            });
        }
    }

    protected final MusicLikedFragmentViewModel F() {
        return (MusicLikedFragmentViewModel) this.h.getValue();
    }

    public int l() {
        return PostItemType.SINGLE_SUBJECT.ordinal();
    }

    public int m() {
        return this.g.m();
    }
}
