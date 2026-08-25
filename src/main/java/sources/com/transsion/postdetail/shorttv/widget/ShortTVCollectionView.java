package com.transsion.postdetail.shorttv.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.HorizontalRecyclerview2;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.TnTextView;
import com.transsion.flow.bean.ShortTVRespData;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.shorttv.adapter.ShortTVHeaderViewAdapter;
import com.transsion.postdetail.shorttv.viewmodel.ShortTVContentViewModel;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;
import wn.d0;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 D2\u00020\u0001:\u0001!B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u0010B3\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00122\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0012¢\u0006\u0004\b \u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010$R\u001d\u0010C\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u00103\u001a\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/transsion/postdetail/shorttv/widget/ShortTVCollectionView;", "Landroid/widget/LinearLayout;", "Landroidx/fragment/app/Fragment;", "fragment", BuildConfig.FLAVOR, "type", "Lcom/transsion/postdetail/shorttv/j;", "recReport", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lcom/transsion/postdetail/shorttv/j;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lcom/transsion/postdetail/shorttv/j;Landroid/content/Context;)V", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lcom/transsion/postdetail/shorttv/j;Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "e", "()V", "h", BuildConfig.FLAVOR, "Lcom/transsion/moviedetailapi/bean/Subject;", "list", "l", "(Ljava/util/List;)V", "subject", "k", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "getItemOptType", "()Ljava/lang/String;", "clearExposureCache", "a", "Landroidx/fragment/app/Fragment;", "b", "Ljava/lang/String;", "c", "Lcom/transsion/postdetail/shorttv/j;", BuildConfig.FLAVOR, "d", "Z", "isRTL", "I", "dp8", "Lwn/d0;", "f", "Lwn/d0;", "viewBinding", "Lcom/transsion/postdetail/shorttv/viewmodel/ShortTVContentViewModel;", "g", "Lkotlin/Lazy;", "getViewModel", "()Lcom/transsion/postdetail/shorttv/viewmodel/ShortTVContentViewModel;", "viewModel", "Lcom/transsion/postdetail/shorttv/adapter/ShortTVHeaderViewAdapter;", "Lcom/transsion/postdetail/shorttv/adapter/ShortTVHeaderViewAdapter;", "headerAdapter", "Lbj/b;", "i", "Lbj/b;", "exposureHelper", "j", "nextPage", "Lqx/a;", "getLoginApi", "()Lqx/a;", "loginApi", "Companion", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTVCollectionView extends LinearLayout {
    public static final String TYPE_COLLECTION = "collection";

    /* renamed from: a, reason: from kotlin metadata */
    private final Fragment fragment;

    /* renamed from: b, reason: from kotlin metadata */
    private final String type;

    /* renamed from: c, reason: from kotlin metadata */
    private final com.transsion.postdetail.shorttv.j recReport;

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean isRTL;

    /* renamed from: e, reason: from kotlin metadata */
    private final int dp8;

    /* renamed from: f, reason: from kotlin metadata */
    private final d0 viewBinding;

    /* renamed from: g, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: h, reason: from kotlin metadata */
    private ShortTVHeaderViewAdapter headerAdapter;

    /* renamed from: i, reason: from kotlin metadata */
    private bj.b exposureHelper;

    /* renamed from: j, reason: from kotlin metadata */
    private String nextPage;

    /* renamed from: k, reason: from kotlin metadata */
    private final Lazy loginApi;

    public static final class b implements bj.a {
        b() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            List data;
            List data2;
            ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = ShortTVCollectionView.this.headerAdapter;
            if (((shortTVHeaderViewAdapter == null || (data2 = shortTVHeaderViewAdapter.getData()) == null) ? 0 : data2.size()) <= i) {
                return;
            }
            ShortTVHeaderViewAdapter shortTVHeaderViewAdapter2 = ShortTVCollectionView.this.headerAdapter;
            Subject subject = (shortTVHeaderViewAdapter2 == null || (data = shortTVHeaderViewAdapter2.getData()) == null) ? null : (Subject) data.get(i);
            if (subject != null) {
                ShortTVCollectionView.this.recReport.a("minitv_explore", subject, i, j, ShortTVCollectionView.this.getItemOptType());
            }
        }
    }

    public static final class c extends RecyclerView.l {
        c() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(rect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            super.getItemOffsets(rect, view, recyclerView, xVar);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (recyclerView.getAdapter() != null) {
                if (childAdapterPosition == 0) {
                    if (ShortTVCollectionView.this.isRTL) {
                        rect.right = ShortTVCollectionView.this.dp8 * 2;
                        return;
                    } else {
                        rect.left = ShortTVCollectionView.this.dp8 * 2;
                        return;
                    }
                }
                if (childAdapterPosition == r4.getItemCount() - 1) {
                    rect.right = ShortTVCollectionView.this.dp8;
                    rect.left = ShortTVCollectionView.this.dp8;
                } else if (ShortTVCollectionView.this.isRTL) {
                    rect.right = ShortTVCollectionView.this.dp8;
                } else {
                    rect.left = ShortTVCollectionView.this.dp8;
                }
            }
        }
    }

    static final class d implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        d(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVCollectionView(Fragment fragment, String str, com.transsion.postdetail.shorttv.j jVar, Context context) {
        this(fragment, str, jVar, context, null);
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(str, "type");
        Intrinsics.h(jVar, "recReport");
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVCollectionView(Fragment fragment, String str, com.transsion.postdetail.shorttv.j jVar, Context context, AttributeSet attributeSet) {
        this(fragment, str, jVar, context, attributeSet, 0);
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(str, "type");
        Intrinsics.h(jVar, "recReport");
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVCollectionView(final Fragment fragment, String str, com.transsion.postdetail.shorttv.j jVar, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(str, "type");
        Intrinsics.h(jVar, "recReport");
        Intrinsics.h(context, "context");
        this.fragment = fragment;
        this.type = str;
        this.recReport = jVar;
        this.isRTL = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.dp8 = a0.a(8.0f);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.shorttv.widget.ShortTVCollectionView$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m87invoke() {
                return fragment;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(fragment, Reflection.b(ShortTVContentViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.shorttv.widget.ShortTVCollectionView$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m88invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.shorttv.widget.ShortTVCollectionView$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m89invoke() {
                Object invoke = function0.invoke();
                androidx.lifecycle.m mVar = invoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.nextPage = "0";
        this.loginApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.widget.a
            public final Object invoke() {
                qx.a j;
                j = ShortTVCollectionView.j();
                return j;
            }
        });
        View.inflate(context, R$layout.layout_short_tv_collection, this);
        d0 a = d0.a(this);
        Intrinsics.g(a, "bind(...)");
        this.viewBinding = a;
        setOrientation(1);
        e();
        h();
    }

    private final void e() {
        this.exposureHelper = new bj.b(0.6f, new b(), false, 4, null);
        ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = new ShortTVHeaderViewAdapter(null, 1, null);
        shortTVHeaderViewAdapter.w1(new r6.d() { // from class: com.transsion.postdetail.shorttv.widget.c
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShortTVCollectionView.f(ShortTVCollectionView.this, baseQuickAdapter, view, i);
            }
        });
        this.headerAdapter = shortTVHeaderViewAdapter;
        HorizontalRecyclerview2 horizontalRecyclerview2 = this.viewBinding.b;
        horizontalRecyclerview2.setLayoutManager(new NpaLinearLayoutManager(horizontalRecyclerview2.getContext(), 0, false));
        horizontalRecyclerview2.addItemDecoration(new c());
        horizontalRecyclerview2.setAdapter(this.headerAdapter);
        bj.b bVar = this.exposureHelper;
        Intrinsics.e(bVar);
        horizontalRecyclerview2.addOnScrollListener(bVar);
        this.viewBinding.e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTVCollectionView.g(ShortTVCollectionView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ShortTVCollectionView shortTVCollectionView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            shortTVCollectionView.recReport.b("minitv_explore", subject, i, shortTVCollectionView.getItemOptType());
            shortTVCollectionView.k(subject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ShortTVCollectionView shortTVCollectionView, View view) {
        a.a.g(wf.a.a, "Click view all", false, 2, (Object) null);
        Navigator.x(TheRouter.c("/shorts/favorite"), shortTVCollectionView.getContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getItemOptType() {
        return Intrinsics.c(this.type, TYPE_COLLECTION) ? TYPE_COLLECTION : "continue_watching";
    }

    private final qx.a getLoginApi() {
        return (qx.a) this.loginApi.getValue();
    }

    private final ShortTVContentViewModel getViewModel() {
        return (ShortTVContentViewModel) this.viewModel.getValue();
    }

    private final void h() {
        if (Intrinsics.c(this.type, TYPE_COLLECTION)) {
            TnTextView tnTextView = this.viewBinding.d;
            Intrinsics.g(tnTextView, "tvTitleTrending");
            tnTextView.setVisibility(8);
            AppCompatTextView appCompatTextView = this.viewBinding.c;
            Context context = getContext();
            appCompatTextView.setText(context != null ? context.getString(R.string.short_tv_my_list) : null);
            getViewModel().h().j(this.fragment, new d(new Function1() { // from class: com.transsion.postdetail.shorttv.widget.b
                public final Object invoke(Object obj) {
                    Unit i;
                    i = ShortTVCollectionView.i(ShortTVCollectionView.this, (ShortTVRespData) obj);
                    return i;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(ShortTVCollectionView shortTVCollectionView, ShortTVRespData shortTVRespData) {
        String str;
        if (shortTVRespData == null) {
            return Unit.a;
        }
        Pager pager = shortTVRespData.getPager();
        if (pager == null || (str = pager.getNextPage()) == null) {
            str = "0";
        }
        shortTVCollectionView.nextPage = str;
        shortTVCollectionView.l(shortTVRespData.getItems());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a j() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    private final void k(Subject subject) {
        FragmentActivity context = getContext();
        if (context == null || !Intrinsics.c(getItemOptType(), TYPE_COLLECTION)) {
            return;
        }
        DownloadManagerApi.e0(DownloadManagerApi.j.a(), context, "minitv_explore", BuildConfig.FLAVOR, subject.getOps(), "download_subject", false, subject, (String) null, (Boolean) null, 384, (Object) null);
    }

    private final void l(List list) {
        ShortTVHeaderViewAdapter shortTVHeaderViewAdapter;
        a.a.f(wf.a.a, "ShortTVCollectionView", "updateList, type:" + this.type + "，size:" + (list != null ? Integer.valueOf(list.size()) : null), false, 4, (Object) null);
        List list2 = list;
        if (list2 == null || list2.isEmpty() || (shortTVHeaderViewAdapter = this.headerAdapter) == null) {
            return;
        }
        shortTVHeaderViewAdapter.n1(list2);
    }

    public final void clearExposureCache() {
        bj.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }
}
