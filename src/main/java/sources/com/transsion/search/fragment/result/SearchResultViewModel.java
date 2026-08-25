package com.transsion.search.fragment.result;

import android.app.Application;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.google.gson.JsonObject;
import com.transsion.gslb.Worker;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.model.PostEntity;
import com.transsion.search.bean.SearchList;
import com.transsion.search.bean.VerticalRank;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchResultViewModel extends androidx.lifecycle.b {
    private final Lazy b;
    private final b0 c;
    private final b0 d;
    private final b0 e;
    private int f;

    public static final class a extends dg.a {
        a() {
        }

        public void a(String str, String str2) {
            a.a.l(wf.a.a, "search", "SearchValuesFragment --> postRequestResource --> failed to post request resources " + str2, false, 4, (Object) null);
            SearchResultViewModel.this.i().n((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(PostEntity postEntity) {
            if (postEntity != null) {
                SearchResultViewModel.this.i().n(postEntity);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchResultViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.search.fragment.result.p
            public final Object invoke() {
                cq.a q;
                q = SearchResultViewModel.q();
                return q;
            }
        });
        this.c = new b0();
        this.d = new b0();
        this.e = new b0();
        this.f = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List h(List list) {
        ArrayList arrayList = new ArrayList();
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SearchList searchList = (SearchList) it.next();
                String title = searchList.getTitle();
                if (title != null && title.length() != 0) {
                    arrayList.add(new ResultWrapData(ResultType.TITLE, null, null, null, null, searchList.getTitle(), null, 94, null));
                }
                List<Subject> subjects = searchList.getSubjects();
                if (subjects != null) {
                    Iterator<T> it2 = subjects.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new ResultWrapData(ResultType.SUBJECT, (Subject) it2.next(), null, null, null, null, null, 124, null));
                    }
                }
                List<Staff> staffs = searchList.getStaffs();
                if (staffs != null) {
                    Iterator<T> it3 = staffs.iterator();
                    while (it3.hasNext()) {
                        arrayList.add(new ResultWrapData(ResultType.STAFF, null, (Staff) it3.next(), null, null, null, null, 122, null));
                    }
                }
                List<Group> groups = searchList.getGroups();
                if (groups != null) {
                    Iterator<T> it4 = groups.iterator();
                    while (it4.hasNext()) {
                        arrayList.add(new ResultWrapData(ResultType.GROUP, null, null, (Group) it4.next(), null, null, null, 118, null));
                    }
                }
                List<VerticalRank> verticalRanks = searchList.getVerticalRanks();
                if (verticalRanks != null) {
                    Iterator<T> it5 = verticalRanks.iterator();
                    while (it5.hasNext()) {
                        arrayList.add(new ResultWrapData(ResultType.VERTICAL_RANK, null, null, null, (VerticalRank) it5.next(), null, null, Worker.WHAT_QUIT, null));
                    }
                }
                if (Intrinsics.c(searchList.getShowMore(), Boolean.TRUE)) {
                    arrayList.add(new ResultWrapData(ResultType.MORE, null, null, null, null, null, searchList.getMoreTabId(), 62, null));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final cq.a l() {
        return (cq.a) this.b.getValue();
    }

    public static /* synthetic */ void n(SearchResultViewModel searchResultViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        searchResultViewModel.m(str, z);
    }

    public static /* synthetic */ void p(SearchResultViewModel searchResultViewModel, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        searchResultViewModel.o(str, str2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cq.a q() {
        return (cq.a) kg.c.e.a().h(cq.a.class);
    }

    public final b0 i() {
        return this.e;
    }

    public final b0 j() {
        return this.d;
    }

    public final b0 k() {
        return this.c;
    }

    public final void m(String str, boolean z) {
        Intrinsics.h(str, "keyword");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("q", str);
        jsonObject.addProperty("before", Boolean.valueOf(z));
        RequestBody.Companion companion = RequestBody.Companion;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        l().f(gg.a.a.a(), companion.create(jsonElement, MediaType.Companion.parse("application/json"))).E(ey.a.c()).subscribe(new a());
    }

    public final void o(String str, String str2, boolean z) {
        Intrinsics.h(str, "keyword");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new SearchResultViewModel$requestSearchResult$1(this, str, str2, z, null), 3, (Object) null);
    }

    public final void r(int i) {
        this.f = i;
    }
}
