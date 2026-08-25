package com.transsion.postdetail.comment.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c0;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.flow.bean.CommentBean;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import t6.f;
import yg.l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/transsion/postdetail/comment/ui/CommentListFragment;", "Lcom/transsion/baseui/fragment/BaseListFragment;", "Lcom/transsion/moviedetailapi/bean/CommentBean;", "<init>", "()V", BuildConfig.FLAVOR, "R0", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "Lcom/transsion/postdetail/comment/ui/a;", "P0", "()Lcom/transsion/postdetail/comment/ui/a;", "G0", "s0", "loadMore", "retryLoadData", "lazyLoadData", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Lcom/transsion/postdetail/comment/ui/CommentListViewModel;", "b", "Lkotlin/Lazy;", "Q0", "()Lcom/transsion/postdetail/comment/ui/CommentListViewModel;", "mViewModel", "c", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CommentListFragment extends BaseListFragment<CommentBean> {

    /* renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy mViewModel;

    /* renamed from: com.transsion.postdetail.comment.ui.CommentListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CommentListFragment a() {
            CommentListFragment commentListFragment = new CommentListFragment();
            commentListFragment.setArguments(new Bundle());
            return commentListFragment;
        }
    }

    static final class b implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
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

    public CommentListFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.comment.ui.CommentListFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m74invoke() {
                return this;
            }
        };
        this.mViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(CommentListViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.comment.ui.CommentListFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m75invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.comment.ui.CommentListFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m76invoke() {
                Object invoke = function0.invoke();
                m mVar = invoke instanceof m ? (m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    private final CommentListViewModel Q0() {
        return (CommentListViewModel) this.mViewModel.getValue();
    }

    private final void R0() {
        Q0().m().j(this, new b(new Function1() { // from class: com.transsion.postdetail.comment.ui.b
            public final Object invoke(Object obj) {
                Unit S0;
                S0 = CommentListFragment.S0(CommentListFragment.this, (List) obj);
                return S0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(CommentListFragment commentListFragment, List list) {
        List data;
        BaseQuickAdapter mBaseAdapter;
        f h0;
        commentListFragment.showContentView();
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            BaseQuickAdapter mBaseAdapter2 = commentListFragment.getMBaseAdapter();
            if (mBaseAdapter2 != null && (data = mBaseAdapter2.getData()) != null && data.isEmpty() && (mBaseAdapter = commentListFragment.getMBaseAdapter()) != null) {
                mBaseAdapter.Y0(commentListFragment.getEmptyView(false));
            }
        } else {
            qi.b logViewConfig = commentListFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            BaseQuickAdapter mBaseAdapter3 = commentListFragment.getMBaseAdapter();
            if (mBaseAdapter3 != null) {
                mBaseAdapter3.n1(list2);
            }
        }
        commentListFragment.I0(false);
        BaseQuickAdapter mBaseAdapter4 = commentListFragment.getMBaseAdapter();
        if (mBaseAdapter4 != null && (h0 = mBaseAdapter4.h0()) != null && h0.r()) {
            commentListFragment.B0();
        }
        if (!commentListFragment.Q0().n()) {
            commentListFragment.C0(false);
        }
        return Unit.a;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void G0() {
        Q0().k(true);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public a m0() {
        return new a();
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void initViewData() {
        super.initViewData();
        I0(true);
    }

    public void initViewModel() {
        R0();
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        if (!l.a.e()) {
            BaseQuickAdapter mBaseAdapter = getMBaseAdapter();
            if (mBaseAdapter != null) {
                mBaseAdapter.Y0(getLocalNoNetworkView(false));
                return;
            }
            return;
        }
        I0(false);
        BaseQuickAdapter mBaseAdapter2 = getMBaseAdapter();
        if (mBaseAdapter2 != null && mBaseAdapter2.getItemCount() == 0) {
            showLoadingView();
        }
        Q0().k(false);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void loadMore() {
        Q0().k(false);
    }

    public qi.b newLogViewConfig() {
        return new qi.b("comments", false, 2, null);
    }

    public void retryLoadData() {
        F0();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String s0() {
        return "My Comments";
    }
}
