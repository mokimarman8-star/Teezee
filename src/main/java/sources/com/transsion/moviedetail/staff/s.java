package com.transsion.moviedetail.staff;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.R$mipmap;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.staff.bean.MovieStaffList;
import com.transsion.moviedetail.staff.s;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0018\u0019\u001a\u001bBS\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00126\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/transsion/moviedetail/staff/s;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "staffId", BuildConfig.FLAVOR, "staffType", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "firstPosition", "lastPosition", BuildConfig.FLAVOR, "staffScrollCallback", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;)V", BuildConfig.FLAVOR, "data", "position", "N1", "(Ljava/util/List;I)I", "G", "Ljava/lang/Integer;", "H", "a", "d", "b", "c", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s extends BaseProviderMultiAdapter<Object> {
    public static final int I = 1;
    public static final int J = 2;
    public static final int K = 3;

    /* renamed from: G, reason: from kotlin metadata */
    private final Integer staffType;

    private static final class b extends BaseItemProvider {
        public void b(BaseViewHolder baseViewHolder, Object obj) {
            Intrinsics.h(baseViewHolder, "helper");
            Intrinsics.h(obj, "item");
            if (obj instanceof qm.a) {
                qm.a aVar = (qm.a) obj;
                if (aVar.a() >= aVar.c()) {
                    baseViewHolder.setText(R$id.tv_load, R$string.movie_staff_show_less);
                    baseViewHolder.setImageResource(R$id.iv_arrow, R$mipmap.movie_arrow_up);
                } else {
                    baseViewHolder.setText(R$id.tv_load, R$string.movie_staff_show_more);
                    baseViewHolder.setImageResource(R$id.iv_arrow, R$mipmap.movie_arrow_down);
                }
            }
        }

        public int l() {
            return 2;
        }

        public int m() {
            return R$layout.movie_staff_item_more;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c extends BaseItemProvider {
        private final String e;
        private final Function2 f;

        public static final class a extends RecyclerView.r {
            a() {
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.h(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i, i2);
                LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                LinearLayoutManager linearLayoutManager = layoutManager;
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                if (findViewByPosition != null) {
                    Rect rect = new Rect();
                    findViewByPosition.getLocalVisibleRect(rect);
                    if ((rect.width() * 100) / findViewByPosition.getWidth() < 70) {
                        findFirstVisibleItemPosition++;
                    }
                }
                View findViewByPosition2 = linearLayoutManager.findViewByPosition(findLastVisibleItemPosition);
                if (findViewByPosition2 != null) {
                    Rect rect2 = new Rect();
                    findViewByPosition2.getLocalVisibleRect(rect2);
                    if ((rect2.width() * 100) / findViewByPosition2.getWidth() < 70) {
                        findLastVisibleItemPosition--;
                    }
                }
                c.this.A().invoke(Integer.valueOf(findFirstVisibleItemPosition), Integer.valueOf(findLastVisibleItemPosition));
            }
        }

        public c(String str, Function2 function2) {
            Intrinsics.h(function2, "callback");
            this.e = str;
            this.f = function2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(c cVar, BaseQuickAdapter baseQuickAdapter, View view, int i) {
            Intrinsics.h(baseQuickAdapter, "adapter");
            Intrinsics.h(view, "v");
            Object item = baseQuickAdapter.getItem(i);
            Intrinsics.f(item, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Staff");
            Staff staff = (Staff) item;
            Navigator.x(TheRouter.c("/movie/staff").J("staff", staff), view.getContext(), (mf.c) null, 2, (Object) null);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "staff");
            String str = cVar.e;
            String str2 = BuildConfig.FLAVOR;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("staff_id", str);
            String staffId = staff.getStaffId();
            if (staffId != null) {
                str2 = staffId;
            }
            hashMap.put("related_staff_id", str2);
            com.transsion.baselib.helper.a.a.i("staff_info", hashMap);
        }

        public final Function2 A() {
            return this.f;
        }

        public void b(BaseViewHolder baseViewHolder, Object obj) {
            Intrinsics.h(baseViewHolder, "helper");
            Intrinsics.h(obj, "item");
            RecyclerView view = baseViewHolder.getView(R$id.rv);
            if (obj instanceof MovieStaffList) {
                if (view.getLayoutManager() == null) {
                    view.setLayoutManager(new LinearLayoutManager(k(), 0, false));
                }
                if (view.getItemDecorationCount() <= 0) {
                    view.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
                }
                if (view.getAdapter() == null) {
                    List<Staff> items = ((MovieStaffList) obj).getItems();
                    if (items == null) {
                        items = Collections.emptyList();
                        Intrinsics.g(items, "emptyList(...)");
                    }
                    com.transsion.moviedetail.adapter.b bVar = new com.transsion.moviedetail.adapter.b(items);
                    bVar.w1(new r6.d() { // from class: com.transsion.moviedetail.staff.t
                        public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                            s.c.z(s.c.this, baseQuickAdapter, view2, i);
                        }
                    });
                    view.setAdapter(bVar);
                    view.addOnScrollListener(new a());
                }
            }
        }

        public int l() {
            return 3;
        }

        public int m() {
            return R$layout.movie_staff_item_related;
        }
    }

    private static final class d extends BaseItemProvider {
        private final Integer e;

        public d(Integer num) {
            this.e = num;
        }

        public void b(BaseViewHolder baseViewHolder, Object obj) {
            String str;
            String thumbnail;
            Intrinsics.h(baseViewHolder, "helper");
            Intrinsics.h(obj, "item");
            if (obj instanceof Subject) {
                ShapeableImageView viewOrNull = baseViewHolder.getViewOrNull(R$id.iv_cover);
                if (viewOrNull != null) {
                    Integer num = this.e;
                    if (num != null && num.intValue() == 6) {
                        ConstraintLayout.b layoutParams = viewOrNull.getLayoutParams();
                        ConstraintLayout.b bVar = null;
                        ConstraintLayout.b bVar2 = layoutParams instanceof ConstraintLayout.b ? layoutParams : null;
                        if (bVar2 != null) {
                            bVar2.I = "h,160:90";
                            bVar = bVar2;
                        }
                        viewOrNull.setLayoutParams(bVar);
                    }
                    f.a aVar = ni.f.a;
                    Context context = viewOrNull.getContext();
                    Intrinsics.g(context, "getContext(...)");
                    f.b m = aVar.m(context);
                    Subject subject = (Subject) obj;
                    Cover cover = subject.getCover();
                    String str2 = BuildConfig.FLAVOR;
                    if (cover == null || (str = cover.getUrl()) == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    f.b g = m.g(str);
                    Cover cover2 = subject.getCover();
                    if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                        str2 = thumbnail;
                    }
                    g.l(str2).d(viewOrNull);
                }
                AppCompatTextView viewOrNull2 = baseViewHolder.getViewOrNull(R$id.tv_title);
                if (viewOrNull2 != null) {
                    viewOrNull2.setText(((Subject) obj).getTitle());
                }
            }
        }

        public int l() {
            return 1;
        }

        public int m() {
            return R$layout.movie_staff_item_subject;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(String str, Integer num, Function2<? super Integer, ? super Integer, Unit> function2) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.h(function2, "staffScrollCallback");
        this.staffType = num;
        F1(new b());
        F1(new c(str, function2));
        F1(new d(num));
    }

    protected int N1(List<? extends Object> data, int position) {
        Intrinsics.h(data, "data");
        if (data.get(position) instanceof Subject) {
            return 1;
        }
        return data.get(position) instanceof qm.a ? 2 : 3;
    }
}
