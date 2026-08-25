package com.transsion.commercialization.aha;

import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.c0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.bean.AhaGameData;
import com.transsion.bean.AhaGameResponse;
import com.transsion.bean.GameLayoutType;
import com.transsion.commercialization.R$string;
import com.transsion.gslb.BuildConfig;
import ij.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import sj.i;
import yg.l;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001b\u0010:\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010*\u001a\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/transsion/commercialization/aha/AhaGameAllFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lsj/i;", "<init>", "()V", BuildConfig.FLAVOR, "w0", BuildConfig.FLAVOR, "url", "toWeb", "(Ljava/lang/String;)V", "loadMore", "Lcom/transsion/bean/AhaGameResponse;", "ahaGameResponse", "D0", "(Lcom/transsion/bean/AhaGameResponse;)V", BuildConfig.FLAVOR, "gameId", BuildConfig.FLAVOR, "r0", "(Ljava/lang/Integer;)Z", "A0", "Landroid/view/LayoutInflater;", "inflater", "v0", "(Landroid/view/LayoutInflater;)Lsj/i;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "loadDefaultData", "initListener", "retryLoadData", "onPause", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Lcom/transsion/commercialization/aha/GameRecommendViewModel;", "a", "Lkotlin/Lazy;", "u0", "()Lcom/transsion/commercialization/aha/GameRecommendViewModel;", "mViewModel", "Lcom/transsion/commercialization/aha/adapter/a;", "b", "Lcom/transsion/commercialization/aha/adapter/a;", "mAdapter", "Lbj/b;", "c", "Lbj/b;", "mExposureHelper", "Lrj/a;", "d", "t0", "()Lrj/a;", "mGameDotHelper", "e", "Commercialization_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AhaGameAllFragment extends PageStatusFragment<i> {

    /* renamed from: b, reason: from kotlin metadata */
    private com.transsion.commercialization.aha.adapter.a mAdapter;

    /* renamed from: c, reason: from kotlin metadata */
    private bj.b mExposureHelper;

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy mViewModel = LazyKt.b(new Function0() { // from class: com.transsion.commercialization.aha.c
        public final Object invoke() {
            GameRecommendViewModel C0;
            C0 = AhaGameAllFragment.C0();
            return C0;
        }
    });

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy mGameDotHelper = LazyKt.b(new Function0() { // from class: com.transsion.commercialization.aha.d
        public final Object invoke() {
            rj.a B0;
            B0 = AhaGameAllFragment.B0();
            return B0;
        }
    });

    public static final class b implements bj.a {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[GameLayoutType.values().length];
                try {
                    iArr[GameLayoutType.ITEM_INFO.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[GameLayoutType.PEOPLE_PLAYING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        b() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            List data;
            com.transsion.commercialization.aha.adapter.a aVar = AhaGameAllFragment.this.mAdapter;
            if (i < ((aVar == null || (data = aVar.getData()) == null) ? 0 : data.size())) {
                com.transsion.commercialization.aha.adapter.a aVar2 = AhaGameAllFragment.this.mAdapter;
                AhaGameAllGames ahaGameAllGames = aVar2 != null ? (AhaGameAllGames) aVar2.getItem(i) : null;
                GameLayoutType gameLayoutType = ahaGameAllGames != null ? ahaGameAllGames.getGameLayoutType() : null;
                int i2 = gameLayoutType == null ? -1 : a.a[gameLayoutType.ordinal()];
                if (i2 == 1) {
                    AhaGameAllFragment.this.t0().a(ahaGameAllGames, i, j, ahaGameAllGames.getGameLayoutType());
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    AhaGameAllFragment.this.t0().c(ahaGameAllGames, j);
                }
            }
        }
    }

    static final class c implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
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

    private final void A0() {
        t6.f h0;
        com.transsion.commercialization.aha.adapter.a aVar;
        t6.f h02;
        com.transsion.commercialization.aha.adapter.a aVar2 = this.mAdapter;
        if (aVar2 == null || (h0 = aVar2.h0()) == null || !h0.r() || (aVar = this.mAdapter) == null || (h02 = aVar.h0()) == null) {
            return;
        }
        h02.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rj.a B0() {
        return new rj.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameRecommendViewModel C0() {
        return new GameRecommendViewModel();
    }

    private final void D0(AhaGameResponse ahaGameResponse) {
        t6.f h0;
        List data;
        List<AhaGameAllGames> allGames;
        com.transsion.commercialization.aha.adapter.a aVar;
        t6.f h02;
        List data2;
        t6.f h03;
        List data3;
        AhaGameData data4;
        List<AhaGameAllGames> allGames2;
        wf.a.a.c(getClassTag(), "ahaGameResponse = " + ((ahaGameResponse == null || (data4 = ahaGameResponse.getData()) == null || (allGames2 = data4.getAllGames()) == null) ? null : Integer.valueOf(allGames2.size())), true);
        if (ahaGameResponse == null) {
            com.transsion.commercialization.aha.adapter.a aVar2 = this.mAdapter;
            if (aVar2 == null || (data3 = aVar2.getData()) == null || data3.size() != 0) {
                com.transsion.commercialization.aha.adapter.a aVar3 = this.mAdapter;
                if (aVar3 == null || (h03 = aVar3.h0()) == null) {
                    return;
                }
                h03.v();
                return;
            }
            A0();
            if (l.a.e()) {
                PageStatusFragment.showErrorView$default(this, false, 1, (Object) null);
                return;
            } else {
                PageStatusFragment.showNoNetworkView$default(this, false, 1, (Object) null);
                return;
            }
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        A0();
        AhaGameData data5 = ahaGameResponse.getData();
        List<AhaGameAllGames> allGames3 = data5 != null ? data5.getAllGames() : null;
        if (allGames3 == null || allGames3.isEmpty()) {
            com.transsion.commercialization.aha.adapter.a aVar4 = this.mAdapter;
            if (aVar4 != null && (data = aVar4.getData()) != null && data.size() == 0) {
                showEmptyView(true);
                return;
            }
            com.transsion.commercialization.aha.adapter.a aVar5 = this.mAdapter;
            if (aVar5 == null || (h0 = aVar5.h0()) == null) {
                return;
            }
            t6.f.u(h0, false, 1, (Object) null);
            return;
        }
        AhaGameData data6 = ahaGameResponse.getData();
        if (data6 == null || (allGames = data6.getAllGames()) == null) {
            return;
        }
        com.transsion.commercialization.aha.adapter.a aVar6 = this.mAdapter;
        if (aVar6 != null && (data2 = aVar6.getData()) != null && data2.size() == 0) {
            com.transsion.commercialization.aha.adapter.a aVar7 = this.mAdapter;
            if (aVar7 != null) {
                aVar7.p(new AhaGameAllGames((Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, getString(R$string.game_recommend_tip), GameLayoutType.ITEM_TITLE, (List) null, 2559, (DefaultConstructorMarker) null));
            }
            com.transsion.commercialization.aha.adapter.a aVar8 = this.mAdapter;
            if (aVar8 != null) {
                GameLayoutType gameLayoutType = GameLayoutType.PEOPLE_PLAYING;
                AhaGameData data7 = ahaGameResponse.getData();
                aVar8.p(new AhaGameAllGames((Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, gameLayoutType, data7 != null ? data7.getPeoplePlaying() : null, 1023, (DefaultConstructorMarker) null));
            }
            com.transsion.commercialization.aha.adapter.a aVar9 = this.mAdapter;
            if (aVar9 != null) {
                aVar9.p(new AhaGameAllGames((Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, getString(R$string.all_game), GameLayoutType.ITEM_TITLE, (List) null, 2559, (DefaultConstructorMarker) null));
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : allGames) {
            if (!r0(((AhaGameAllGames) obj).getId())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty() && (aVar = this.mAdapter) != null && (h02 = aVar.h0()) != null) {
            t6.f.u(h02, false, 1, (Object) null);
        }
        com.transsion.commercialization.aha.adapter.a aVar10 = this.mAdapter;
        if (aVar10 != null) {
            aVar10.q(arrayList);
        }
    }

    private final void loadMore() {
        u0().i();
    }

    private final boolean r0(Integer gameId) {
        List data;
        if (gameId == null) {
            return true;
        }
        com.transsion.commercialization.aha.adapter.a aVar = this.mAdapter;
        if (aVar == null || (data = aVar.getData()) == null) {
            return false;
        }
        Iterator it = data.iterator();
        while (it.hasNext()) {
            if (Intrinsics.c(gameId, ((AhaGameAllGames) it.next()).getId())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(AhaGameAllFragment ahaGameAllFragment, View view) {
        ahaGameAllFragment.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rj.a t0() {
        return (rj.a) this.mGameDotHelper.getValue();
    }

    private final void toWeb(String url) {
        AhaGameAllActivity activity = getActivity();
        AhaGameAllActivity ahaGameAllActivity = activity instanceof AhaGameAllActivity ? activity : null;
        k.p(TheRouter.c("/web/web").K("url", url).K("page_from", "game_center").z("fromTask", ahaGameAllActivity != null ? ahaGameAllActivity.fromTask : false));
    }

    private final GameRecommendViewModel u0() {
        return (GameRecommendViewModel) this.mViewModel.getValue();
    }

    private final void w0() {
        RecyclerView recyclerView;
        bj.b bVar = new bj.b(0.6f, new b(), false, 4, null);
        bVar.n(2);
        i iVar = (i) getMViewBinding();
        if (iVar != null && (recyclerView = iVar.b) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.mExposureHelper = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(com.transsion.commercialization.aha.adapter.a aVar, AhaGameAllFragment ahaGameAllFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (!l.a.e()) {
            fh.b.a.d(R.string.no_network_toast);
            return;
        }
        String link = ((AhaGameAllGames) aVar.getItem(i)).getLink();
        if (link != null) {
            ahaGameAllFragment.toWeb(link);
        }
        AhaGameAllGames ahaGameAllGames = (AhaGameAllGames) aVar.getItem(i);
        if (ahaGameAllGames.getGameLayoutType() == GameLayoutType.ITEM_INFO) {
            rj.a t0 = ahaGameAllFragment.t0();
            if (i > 2) {
                i -= 2;
            }
            t0.b(ahaGameAllGames, i, ahaGameAllGames.getGameLayoutType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(AhaGameAllFragment ahaGameAllFragment) {
        ahaGameAllFragment.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(AhaGameAllFragment ahaGameAllFragment, AhaGameResponse ahaGameResponse) {
        ahaGameAllFragment.showContentView();
        ahaGameAllFragment.D0(ahaGameResponse);
        return Unit.a;
    }

    public View getLoadingView() {
        jj.c c2 = jj.c.c(LayoutInflater.from(getContext()));
        c2.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.aha.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AhaGameAllFragment.s0(AhaGameAllFragment.this, view);
            }
        });
        ConstraintLayout root = c2.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        return root;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
    }

    public void initViewData() {
        i iVar = (i) getMViewBinding();
        if (iVar != null) {
            TitleLayout titleLayout = iVar.c;
            String string = getString(R.string.game_center);
            Intrinsics.g(string, "getString(...)");
            titleLayout.setTitleText(string);
            RecyclerView recyclerView = iVar.b;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.addItemDecoration(new tf.h(a0.a(12.0f), 1));
            w0();
            final com.transsion.commercialization.aha.adapter.a aVar = new com.transsion.commercialization.aha.adapter.a(this.mExposureHelper, t0());
            aVar.w1(new r6.d() { // from class: com.transsion.commercialization.aha.e
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    AhaGameAllFragment.x0(com.transsion.commercialization.aha.adapter.a.this, this, baseQuickAdapter, view, i);
                }
            });
            t6.f h0 = aVar.h0();
            h0.z(true);
            h0.y(true);
            h0.E(1);
            h0.D(new r6.f() { // from class: com.transsion.commercialization.aha.f
                public final void a() {
                    AhaGameAllFragment.y0(AhaGameAllFragment.this);
                }
            });
            this.mAdapter = aVar;
            recyclerView.setAdapter(aVar);
            com.transsion.commercialization.aha.adapter.a aVar2 = this.mAdapter;
            recyclerView.addOnScrollListener(new nj.a(aVar2 != null ? aVar2.h0() : null));
        }
    }

    public void initViewModel() {
        u0().h().j(this, new c(new Function1() { // from class: com.transsion.commercialization.aha.a
            public final Object invoke(Object obj) {
                Unit z0;
                z0 = AhaGameAllFragment.z0(AhaGameAllFragment.this, (AhaGameResponse) obj);
                return z0;
            }
        }));
    }

    public void loadDefaultData() {
        u0().i();
        showLoadingView();
    }

    public qi.b newLogViewConfig() {
        return new qi.b("game_center", false, 2, null);
    }

    public void onPause() {
        super.onPause();
        bj.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    public void retryLoadData() {
        t6.f h0;
        List data;
        com.transsion.commercialization.aha.adapter.a aVar = this.mAdapter;
        if (aVar != null && (data = aVar.getData()) != null && data.size() == 0) {
            loadDefaultData();
            return;
        }
        com.transsion.commercialization.aha.adapter.a aVar2 = this.mAdapter;
        if (aVar2 == null || (h0 = aVar2.h0()) == null) {
            return;
        }
        h0.w();
    }

    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public i getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        i c2 = i.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
