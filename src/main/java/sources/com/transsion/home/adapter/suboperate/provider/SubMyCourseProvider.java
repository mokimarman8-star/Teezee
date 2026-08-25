package com.transsion.home.adapter.suboperate.provider;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.flow.bean.LayoutStyle;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.flow.bean.SubjectGameInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectDl;
import com.transsion.moviedetailapi.bean.Trailer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubMyCourseProvider extends BaseItemProvider implements androidx.lifecycle.f {
    private final int e;
    private t1 f;
    private BaseViewHolder g;
    private CourseBean h;
    private final Lazy i = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.suboperate.provider.e0
        public final Object invoke() {
            VideoDetailPlayDao P;
            P = SubMyCourseProvider.P();
            return P;
        }
    });

    public SubMyCourseProvider(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(BaseViewHolder baseViewHolder, View view) {
        Navigator.x(TheRouter.c("/edu/courseList"), ((RecyclerView.a0) baseViewHolder).itemView.getContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(SubMyCourseProvider subMyCourseProvider, BaseViewHolder baseViewHolder, OperateItem operateItem, View view) {
        Navigator.x(TheRouter.c("/home/filter").F("tabId", subMyCourseProvider.e), ((RecyclerView.a0) baseViewHolder).itemView.getContext(), (mf.c) null, 2, (Object) null);
        subMyCourseProvider.T("click_my_course_explore", operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(SubMyCourseProvider subMyCourseProvider, OperateItem operateItem, View view) {
        CourseBean courseBean = subMyCourseProvider.h;
        if ((courseBean != null ? courseBean.getSubjectId() : null) != null) {
            CourseBean courseBean2 = subMyCourseProvider.h;
            String subjectId = courseBean2 != null ? courseBean2.getSubjectId() : null;
            CourseBean courseBean3 = subMyCourseProvider.h;
            zk.h.f(new Subject(subjectId, courseBean3 != null ? courseBean3.getSubjectType() : null, (String) null, (String) null, (Cover) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -4, 67108863, (DefaultConstructorMarker) null), "operation_course");
        }
        subMyCourseProvider.T("click_my_course_learn", operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao O() {
        return (VideoDetailPlayDao) this.i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao P() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return appDatabase$f1.b(a).C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(SubMyCourseProvider subMyCourseProvider) {
        subMyCourseProvider.W();
    }

    private final void R() {
        this.f = kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SubMyCourseProvider$registerCourse$1(this, null), 3, (Object) null);
    }

    private final void S(OperateItem operateItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_my_course");
        hashMap.put("title", String.valueOf(operateItem.getTitle()));
        hashMap.put("tabId", String.valueOf(this.e));
        com.transsion.baselib.helper.a.a.a(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    private final void T(String str, OperateItem operateItem) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", str);
        hashMap.put("title", String.valueOf(operateItem.getTitle()));
        hashMap.put("tabId", String.valueOf(this.e));
        CourseBean courseBean = this.h;
        if (courseBean == null || (str2 = courseBean.getSubjectId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        hashMap.put("subjectId", str2);
        com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(final BaseViewHolder baseViewHolder, final float f) {
        TextView textView;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("%.0f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
        Intrinsics.g(format, "format(...)");
        String str = format + "%";
        if (baseViewHolder != null && (textView = (TextView) baseViewHolder.getView(R.id.sub_operation_course_item_percent_text)) != null) {
            textView.setText(str);
        }
        final View view = baseViewHolder != null ? baseViewHolder.getView(R.id.sub_operation_course_item_percent_bg) : null;
        if (view != null) {
            view.post(new Runnable() { // from class: com.transsion.home.adapter.suboperate.provider.i0
                @Override // java.lang.Runnable
                public final void run() {
                    SubMyCourseProvider.V(baseViewHolder, view, f);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(BaseViewHolder baseViewHolder, View view, float f) {
        View view2 = baseViewHolder.getView(R.id.sub_operation_course_item_percent_view);
        view2.getLayoutParams().width = (int) ((view.getWidth() * f) / 100);
        view2.setLayoutParams(view2.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W() {
        TextView textView;
        String title;
        ImageView imageView;
        String str;
        String str2;
        Cover cover;
        Cover cover2;
        View view;
        View view2;
        View view3;
        View view4;
        if (this.h == null) {
            BaseViewHolder baseViewHolder = this.g;
            if (baseViewHolder != null && (view4 = baseViewHolder.getView(R.id.sub_operation_course_start_liner)) != null) {
                uf.c.k(view4);
            }
            BaseViewHolder baseViewHolder2 = this.g;
            if (baseViewHolder2 == null || (view3 = baseViewHolder2.getView(R.id.sub_operation_course_item_liner)) == null) {
                return;
            }
            uf.c.h(view3);
            return;
        }
        BaseViewHolder baseViewHolder3 = this.g;
        if (baseViewHolder3 != null && (view2 = baseViewHolder3.getView(R.id.sub_operation_course_start_liner)) != null) {
            uf.c.h(view2);
        }
        BaseViewHolder baseViewHolder4 = this.g;
        if (baseViewHolder4 != null && (view = baseViewHolder4.getView(R.id.sub_operation_course_item_liner)) != null) {
            uf.c.k(view);
        }
        BaseViewHolder baseViewHolder5 = this.g;
        String str3 = BuildConfig.FLAVOR;
        if (baseViewHolder5 != null && (imageView = (ImageView) baseViewHolder5.getView(R.id.sub_operation_course_item_image)) != null) {
            f.a aVar = ni.f.a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            CourseBean courseBean = this.h;
            if (courseBean == null || (cover2 = courseBean.getCover()) == null || (str = cover2.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b g = m.g(str);
            CourseBean courseBean2 = this.h;
            if (courseBean2 == null || (cover = courseBean2.getCover()) == null || (str2 = cover.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            g.l(str2).m(imageView.getWidth()).d(imageView);
        }
        CourseBean courseBean3 = this.h;
        if (courseBean3 != null && (title = courseBean3.getTitle()) != null) {
            str3 = title;
        }
        BaseViewHolder baseViewHolder6 = this.g;
        if (baseViewHolder6 != null && (textView = (TextView) baseViewHolder6.getView(R.id.sub_operation_course_item_title_text)) != null) {
            textView.setText(str3);
        }
        kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SubMyCourseProvider$updateCurrentCourse$2(this, null), 3, (Object) null);
    }

    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        baseViewHolder.getView(R.id.sub_operation_course_title).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubMyCourseProvider.L(baseViewHolder, view);
            }
        });
        baseViewHolder.getView(R.id.sub_operation_course_explore).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubMyCourseProvider.M(SubMyCourseProvider.this, baseViewHolder, operateItem, view);
            }
        });
        baseViewHolder.getView(R.id.sub_operation_course_learn).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubMyCourseProvider.N(SubMyCourseProvider.this, operateItem, view);
            }
        });
        S(operateItem);
    }

    public int l() {
        return PostItemType.MY_COURSE.ordinal();
    }

    public int m() {
        return R.layout.item_sub_operation_my_course;
    }

    public /* synthetic */ void onCreate(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    public /* synthetic */ void onDestroy(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    public /* synthetic */ void onPause(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.c(this, uVar);
    }

    public void onResume(androidx.lifecycle.u uVar) {
        Intrinsics.h(uVar, "owner");
        androidx.lifecycle.e.d(this, uVar);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsion.home.adapter.suboperate.provider.d0
            @Override // java.lang.Runnable
            public final void run() {
                SubMyCourseProvider.Q(SubMyCourseProvider.this);
            }
        }, 1000L);
    }

    public /* synthetic */ void onStart(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.e(this, uVar);
    }

    public /* synthetic */ void onStop(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.f(this, uVar);
    }

    public void t(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.t(baseViewHolder);
        this.g = baseViewHolder;
        if (this.f == null) {
            R();
        }
    }

    public void u(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.u(baseViewHolder);
        this.g = null;
        t1 t1Var = this.f;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f = null;
    }
}
