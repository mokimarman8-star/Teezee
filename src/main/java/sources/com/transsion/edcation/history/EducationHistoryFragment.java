package com.transsion.edcation.history;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.StateView;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.edcation.R$string;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.p000enum.BottomTabType;
import com.transsion.moviedetailapi.SubjectType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import r6.f;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0082@¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0004R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&¨\u0006*"}, d2 = {"Lcom/transsion/edcation/history/EducationHistoryFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lek/b;", "<init>", "()V", "Landroid/view/View;", "j0", "()Landroid/view/View;", BuildConfig.FLAVOR, "isRefresh", BuildConfig.FLAVOR, "Lcom/transsion/baselib/db/video/VideoDetailPlayBean;", "i0", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/LayoutInflater;", "inflater", "m0", "(Landroid/view/LayoutInflater;)Lek/b;", "view", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "onResume", "Lcom/transsion/edcation/history/EducationHistoryAdapter;", "a", "Lcom/transsion/edcation/history/EducationHistoryAdapter;", "mAdapter", "Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "b", "Lkotlin/Lazy;", "l0", "()Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "mVideoDetailPlayDao", BuildConfig.FLAVOR, "c", "I", "mOffset", "d", "mLimit", "Education_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class EducationHistoryFragment extends BaseFragment<ek.b> {

    /* renamed from: a, reason: from kotlin metadata */
    private EducationHistoryAdapter mAdapter;

    /* renamed from: c, reason: from kotlin metadata */
    private int mOffset;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy mVideoDetailPlayDao = LazyKt.b(new Function0() { // from class: com.transsion.edcation.history.c
        public final Object invoke() {
            VideoDetailPlayDao o0;
            o0 = EducationHistoryFragment.o0();
            return o0;
        }
    });

    /* renamed from: d, reason: from kotlin metadata */
    private int mLimit = 10;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i0(boolean z, Continuation continuation) {
        EducationHistoryFragment$fetchHistory$1 educationHistoryFragment$fetchHistory$1;
        int i;
        if (continuation instanceof EducationHistoryFragment$fetchHistory$1) {
            educationHistoryFragment$fetchHistory$1 = (EducationHistoryFragment$fetchHistory$1) continuation;
            int i2 = educationHistoryFragment$fetchHistory$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                educationHistoryFragment$fetchHistory$1.label = i2 - Integer.MIN_VALUE;
                Object obj = educationHistoryFragment$fetchHistory$1.result;
                Object f = IntrinsicsKt.f();
                i = educationHistoryFragment$fetchHistory$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (z) {
                        this.mOffset = 0;
                    }
                    VideoDetailPlayDao l0 = l0();
                    int i3 = this.mOffset;
                    int i4 = this.mLimit;
                    int value = SubjectType.EDUCATION.getValue();
                    educationHistoryFragment$fetchHistory$1.label = 1;
                    obj = l0.i(i3, i4, value, educationHistoryFragment$fetchHistory$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                List list = (List) obj;
                this.mOffset += list != null ? list.size() : 0;
                return list != null ? new ArrayList() : list;
            }
        }
        educationHistoryFragment$fetchHistory$1 = new EducationHistoryFragment$fetchHistory$1(this, continuation);
        Object obj2 = educationHistoryFragment$fetchHistory$1.result;
        Object f2 = IntrinsicsKt.f();
        i = educationHistoryFragment$fetchHistory$1.label;
        if (i != 0) {
        }
        List list2 = (List) obj2;
        this.mOffset += list2 != null ? list2.size() : 0;
        if (list2 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View j0() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        String string = getString(R$string.course_list_empy);
        Intrinsics.g(string, "getString(...)");
        stateView.showData(4, 1, false, BuildConfig.FLAVOR, string);
        String string2 = getString(R$string.course_explore_now);
        Intrinsics.g(string2, "getString(...)");
        stateView.setReTryTxt(string2);
        stateView.retry(new Function0() { // from class: com.transsion.edcation.history.d
            public final Object invoke() {
                Unit k0;
                k0 = EducationHistoryFragment.k0(EducationHistoryFragment.this);
                return k0;
            }
        });
        return stateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(EducationHistoryFragment educationHistoryFragment) {
        Navigator.x(TheRouter.c("/main/tab").K("bottomTab", BottomTabType.TAB_CODE_HOME).K("topTab", "Education"), educationHistoryFragment.requireContext(), (mf.c) null, 2, (Object) null);
        return Unit.a;
    }

    private final VideoDetailPlayDao l0() {
        return (VideoDetailPlayDao) this.mVideoDetailPlayDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(EducationHistoryFragment educationHistoryFragment) {
        i.d(v.a(educationHistoryFragment), (CoroutineContext) null, (CoroutineStart) null, new EducationHistoryFragment$initView$1$1$1(educationHistoryFragment, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao o0() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return appDatabase$f1.b(a).C1();
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        ek.b bVar = (ek.b) getMViewBinding();
        RecyclerView recyclerView = bVar != null ? bVar.b : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        EducationHistoryAdapter educationHistoryAdapter = new EducationHistoryAdapter(new ArrayList());
        this.mAdapter = educationHistoryAdapter;
        if (recyclerView != null) {
            recyclerView.setAdapter(educationHistoryAdapter);
        }
        EducationHistoryAdapter educationHistoryAdapter2 = this.mAdapter;
        if (educationHistoryAdapter2 != null) {
            educationHistoryAdapter2.h0().z(true);
            educationHistoryAdapter2.h0().z(true);
            educationHistoryAdapter2.h0().y(true);
            educationHistoryAdapter2.h0().D(new f() { // from class: com.transsion.edcation.history.e
                public final void a() {
                    EducationHistoryFragment.n0(EducationHistoryFragment.this);
                }
            });
        }
    }

    public void lazyLoadData() {
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new EducationHistoryFragment$lazyLoadData$1(this, null), 3, (Object) null);
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public ek.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        ek.b c = ek.b.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void onResume() {
        super.onResume();
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new EducationHistoryFragment$onResume$1(this, null), 3, (Object) null);
    }
}
