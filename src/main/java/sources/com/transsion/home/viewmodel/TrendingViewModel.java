package com.transsion.home.viewmodel;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.o;
import com.transsion.baselib.report.h;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.bean.TrendingRequestEntity;
import com.transsion.home.enum.HomeTabId;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.enum.PostListSource;
import java.util.HashMap;
import java.util.Map;
import jg.b;
import kg.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;
import wf.a;
import yk.e;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class TrendingViewModel extends AbsSubjectListViewModel {
    public static final a p = new a((DefaultConstructorMarker) null);
    public static final int q = 8;
    private final Lazy k;
    private final Lazy l;
    private final Lazy m;
    private int n;
    private final e o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.k = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.v
            public final Object invoke() {
                b0 c0;
                c0 = TrendingViewModel.c0();
                return c0;
            }
        });
        this.l = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.w
            public final Object invoke() {
                b0 Z;
                Z = TrendingViewModel.Z();
                return Z;
            }
        });
        this.m = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.x
            public final Object invoke() {
                b0 b0;
                b0 = TrendingViewModel.b0();
                return b0;
            }
        });
        this.n = 12;
        this.o = (e) c.e.a().h(e.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(TrendingViewModel trendingViewModel) {
        String string = zk.e.a.b().getString("trending_room_entrance_cache_v2", "");
        if (string == null || string.length() == 0) {
            a.a.c("TrendingViewModel", "fetchGroupInfo failed without cache", true);
        } else {
            trendingViewModel.W().n((RoomEntranceResponse) o.d(string, RoomEntranceResponse.class));
            a.a.c("TrendingViewModel", "fetchGroupInfo use cache", true);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 Z() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 b0() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 c0() {
        return new b0();
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public PostListSource A() {
        return PostListSource.POSTLIST;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void E(boolean z) {
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void F(Bundle bundle) {
    }

    public final void T(boolean z) {
        y yVar = new y(this);
        if (z) {
            yVar.invoke();
        } else {
            i.d(u0.a(this), y0.b(), (CoroutineStart) null, new fetchGroupInfo.1(this, yVar, (Continuation) null), 2, (Object) null);
        }
    }

    public final b0 V() {
        return (b0) this.l.getValue();
    }

    public final b0 W() {
        return (b0) this.m.getValue();
    }

    public final b0 X() {
        return (b0) this.k.getValue();
    }

    public final void Y(String str, int i, boolean z) {
        String str2;
        Intrinsics.h(str, "nextPage");
        TrendingRequestEntity trendingRequestEntity = new TrendingRequestEntity();
        trendingRequestEntity.setPage(str);
        trendingRequestEntity.setPerPage(i);
        trendingRequestEntity.setSessionId(b.a.h());
        Uri b = h.a.b();
        if (b == null || (str2 = b.toString()) == null) {
            str2 = "";
        }
        trendingRequestEntity.setDeepLink(str2);
        trendingRequestEntity.setLatest_events(new ej.a(ej.b.a.e()));
        trendingRequestEntity.setTabId(String.valueOf(HomeTabId.Trending.getValue()));
        trendingRequestEntity.setDisablePlaylist(Boolean.valueOf(z));
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new getTrendingList.1(trendingRequestEntity, this, str, (Continuation) null), 2, (Object) null);
    }

    public final void a0(Subject subject, int i, String str) {
        Intrinsics.h(subject, "subject");
        Intrinsics.h(str, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", str);
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        hashMap.put("subject_id", subjectId);
        hashMap.put("has_resource", String.valueOf(subject.getHasResource()));
        hashMap.put("item_type", "rec");
        String title = subject.getTitle();
        if (title == null) {
            title = "";
        }
        hashMap.put("title", title);
        String ops = subject.getOps();
        if (ops == null) {
            ops = "";
        }
        hashMap.put("ops", ops);
        hashMap.put("page_from", v());
        hashMap.put("sequence", String.valueOf(i));
        Map u = u(t().ordinal());
        if (u != null) {
            for (Map.Entry entry : u.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                if (str3 == null) {
                    str3 = "";
                }
                hashMap.put(str2, str3);
            }
        }
        com.transsion.baselib.helper.a.a.g(w(t().ordinal()), hashMap);
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public String w(int i) {
        return "Trending";
    }
}
