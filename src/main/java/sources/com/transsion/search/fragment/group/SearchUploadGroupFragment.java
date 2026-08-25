package com.transsion.search.fragment.group;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baseui.R$color;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.publish.api.GroupBean;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.SearchManager;
import com.transsion.search.bean.Pager;
import com.transsion.search.bean.PagerEntity;
import com.transsion.search.bean.SearchGroupEntity;
import com.transsion.search.bean.SearchSubject;
import com.transsion.search.bean.SearchWorkEntity;
import com.transsion.search.dialog.CheckTipsDialog;
import com.transsion.search.fragment.group.SearchUploadGroupFragment;
import com.transsion.search.viewmodel.SearchViewModel;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import yg.m;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001SB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0005J5\u0010\u001d\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010\u0005J\u0017\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b/\u0010.J\u0011\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00170>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010ER\u0016\u0010G\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010H\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P¨\u0006T"}, d2 = {"Lcom/transsion/search/fragment/group/SearchUploadGroupFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lvp/d;", "Lcom/tn/lib/widget/dialog/TRDialogListener;", "<init>", "()V", BuildConfig.FLAVOR, "clear", BuildConfig.FLAVOR, "resetContent", "(Z)V", "postFinsh", "Lcom/transsion/publish/api/GroupBean;", "groupBean", "postGroup", "(Lcom/transsion/publish/api/GroupBean;)V", "searchJob", "initViewModel", "Landroid/view/View;", "emptyView", "()Landroid/view/View;", "clearTipsDialog", "showCheckDialog", BuildConfig.FLAVOR, "group_id", "subject_id", "opt", BuildConfig.FLAVOR, "position", "reportClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)Lvp/d;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initView", "lazyLoadData", "onDestroyView", "Lcom/tn/lib/widget/dialog/TRDialog;", "dialog", "onLeftButtonClick", "(Lcom/tn/lib/widget/dialog/TRDialog;)V", "onRightButtonClick", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "isRefreshing", "Z", "Lcom/transsion/search/fragment/group/adapter/a;", "mSearchGroupAdapter", "Lcom/transsion/search/fragment/group/adapter/a;", "Lcom/transsion/search/fragment/group/adapter/b;", "mSearchKeywordAdapter", "Lcom/transsion/search/fragment/group/adapter/b;", "Lcom/transsion/search/adapter/b;", "mSearchWorkAdapter", "Lcom/transsion/search/adapter/b;", BuildConfig.FLAVOR, "mHistoryList", "Ljava/util/List;", "Lcom/transsion/search/viewmodel/SearchViewModel;", "mSearchViewModel", "Lcom/transsion/search/viewmodel/SearchViewModel;", "mType", "I", "page", "perPage", "mKeyword", "Ljava/lang/String;", "selectGroup", "Lcom/transsion/publish/api/GroupBean;", "Lcom/transsion/search/dialog/CheckTipsDialog;", "mCheckTipsDialog$delegate", "Lkotlin/Lazy;", "getMCheckTipsDialog", "()Lcom/transsion/search/dialog/CheckTipsDialog;", "mCheckTipsDialog", "Companion", "a", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchUploadGroupFragment extends BaseFragment<vp.d> implements TRDialogListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean isRefreshing;
    private com.transsion.search.fragment.group.adapter.a mSearchGroupAdapter;
    private com.transsion.search.fragment.group.adapter.b mSearchKeywordAdapter;
    private SearchViewModel mSearchViewModel;
    private com.transsion.search.adapter.b mSearchWorkAdapter;
    private int mType;
    private GroupBean selectGroup;
    private List<String> mHistoryList = new ArrayList();
    private int page = 1;
    private int perPage = 10;
    private String mKeyword = BuildConfig.FLAVOR;

    /* renamed from: mCheckTipsDialog$delegate, reason: from kotlin metadata */
    private final Lazy mCheckTipsDialog = LazyKt.b(new Function0() { // from class: com.transsion.search.fragment.group.e
        public final Object invoke() {
            CheckTipsDialog mCheckTipsDialog_delegate$lambda$0;
            mCheckTipsDialog_delegate$lambda$0 = SearchUploadGroupFragment.mCheckTipsDialog_delegate$lambda$0();
            return mCheckTipsDialog_delegate$lambda$0;
        }
    });

    /* renamed from: com.transsion.search.fragment.group.SearchUploadGroupFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchUploadGroupFragment a(int i) {
            SearchUploadGroupFragment searchUploadGroupFragment = new SearchUploadGroupFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            searchUploadGroupFragment.setArguments(bundle);
            return searchUploadGroupFragment;
        }
    }

    public static final class b implements yg.m {
        b() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            t6.f h0;
            t6.f h02;
            List data;
            List data2;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            com.transsion.search.adapter.b bVar = SearchUploadGroupFragment.this.mSearchWorkAdapter;
            if (bVar == null || (data2 = bVar.getData()) == null || !data2.isEmpty()) {
                com.transsion.search.adapter.b bVar2 = SearchUploadGroupFragment.this.mSearchWorkAdapter;
                if (bVar2 != null && (h0 = bVar2.h0()) != null) {
                    h0.w();
                }
            } else {
                SearchUploadGroupFragment.this.searchJob();
            }
            com.transsion.search.fragment.group.adapter.a aVar = SearchUploadGroupFragment.this.mSearchGroupAdapter;
            if (aVar != null && (data = aVar.getData()) != null && data.isEmpty()) {
                SearchUploadGroupFragment.this.searchJob();
                return;
            }
            com.transsion.search.fragment.group.adapter.a aVar2 = SearchUploadGroupFragment.this.mSearchGroupAdapter;
            if (aVar2 == null || (h02 = aVar2.h0()) == null) {
                return;
            }
            h02.w();
        }

        public void onDisconnected() {
        }
    }

    public static final class c implements TextView.OnEditorActionListener {
        c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 0 && i != 3) {
                return false;
            }
            SearchUploadGroupFragment.this.mKeyword = String.valueOf(textView != null ? textView.getText() : null);
            SearchUploadGroupFragment.this.searchJob();
            return true;
        }
    }

    public static final class d implements wp.a {
        d() {
        }

        @Override // wp.a
        public void a() {
            String groupId;
            SearchViewModel searchViewModel;
            GroupBean groupBean = SearchUploadGroupFragment.this.selectGroup;
            if (groupBean == null || (groupId = groupBean.getGroupId()) == null || (searchViewModel = SearchUploadGroupFragment.this.mSearchViewModel) == null) {
                return;
            }
            searchViewModel.t(groupId);
        }

        @Override // wp.a
        public void b() {
        }
    }

    public static final class e extends RecyclerView.r {
        e() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            FragmentActivity activity;
            vp.d dVar;
            EditText editText;
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            if (i != 1 || (activity = SearchUploadGroupFragment.this.getActivity()) == null) {
                return;
            }
            SearchUploadGroupFragment searchUploadGroupFragment = SearchUploadGroupFragment.this;
            if (!KeyboardUtils.g(activity) || (dVar = (vp.d) searchUploadGroupFragment.getMViewBinding()) == null || (editText = dVar.b) == null) {
                return;
            }
            KeyboardUtils.e(editText);
        }
    }

    public static final class f implements com.transsion.search.a {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(List list, SearchUploadGroupFragment searchUploadGroupFragment) {
            RelativeLayout relativeLayout;
            List list2 = list;
            if (list2.isEmpty()) {
                vp.d dVar = (vp.d) searchUploadGroupFragment.getMViewBinding();
                if (dVar == null || (relativeLayout = dVar.g) == null) {
                    return;
                }
                relativeLayout.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list2);
            CollectionsKt.Y(arrayList);
            searchUploadGroupFragment.mHistoryList = arrayList;
            com.transsion.search.fragment.group.adapter.b bVar = searchUploadGroupFragment.mSearchKeywordAdapter;
            if (bVar != null) {
                bVar.q1(arrayList);
            }
        }

        @Override // com.transsion.search.a
        public void a(final List list) {
            Intrinsics.h(list, "list");
            FragmentActivity activity = SearchUploadGroupFragment.this.getActivity();
            if (activity != null) {
                final SearchUploadGroupFragment searchUploadGroupFragment = SearchUploadGroupFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.transsion.search.fragment.group.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchUploadGroupFragment.f.c(list, searchUploadGroupFragment);
                    }
                });
            }
        }
    }

    public static final class g implements TextWatcher {
        g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AppCompatImageView appCompatImageView;
            AppCompatImageView appCompatImageView2;
            if ((editable != null ? editable.length() : 0) > 0) {
                vp.d dVar = (vp.d) SearchUploadGroupFragment.this.getMViewBinding();
                if (dVar != null && (appCompatImageView2 = dVar.d) != null) {
                    appCompatImageView2.setVisibility(0);
                }
            } else {
                vp.d dVar2 = (vp.d) SearchUploadGroupFragment.this.getMViewBinding();
                if (dVar2 != null && (appCompatImageView = dVar2.d) != null) {
                    appCompatImageView.setVisibility(8);
                }
                SearchUploadGroupFragment.this.resetContent(true);
            }
            SearchUploadGroupFragment.this.mKeyword = String.valueOf(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TextView textView;
            vp.d dVar = (vp.d) SearchUploadGroupFragment.this.getMViewBinding();
            if (dVar == null || (textView = dVar.j) == null) {
                return;
            }
            uf.c.k(textView);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    static final class h implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        h(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.c0) && (obj instanceof FunctionAdapter)) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearTipsDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.search_clear_title);
            Intrinsics.g(string, "getString(...)");
            TRDialog.a k = aVar.k(string);
            String string2 = getString(R$string.search_clear_des);
            Intrinsics.g(string2, "getString(...)");
            TRDialog.a g2 = k.g(string2);
            String string3 = getString(R$string.search_clear_cancel);
            Intrinsics.g(string3, "getString(...)");
            TRDialog.a e2 = g2.e(string3);
            String string4 = getString(R$string.search_clear_clear);
            Intrinsics.g(string4, "getString(...)");
            e2.j(string4).h(R$drawable.btn_bg_dialog_edit_selector).c(R$drawable.btn_bg_dialog_edit_selector).i(com.blankj.utilcode.util.h.a(R$color.base_color_black)).f(this).a().d0(this, "clear_tips");
        } catch (Exception unused) {
        }
    }

    private final View emptyView() {
        EditText editText;
        Editable editable = null;
        View inflate = getLayoutInflater().inflate(R$layout.view_search_manager_empty, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_empty_tips);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_tips);
        AppCompatTextView findViewById = inflate.findViewById(R$id.tv_retry);
        if (yg.l.a.e()) {
            vp.d dVar = (vp.d) getMViewBinding();
            if (dVar != null && (editText = dVar.b) != null) {
                editable = editText.getText();
            }
            String valueOf = String.valueOf(editable);
            textView.setText(getString(R$string.user_works_empty) + " \"" + valueOf + "\"");
            findViewById.setVisibility(8);
            imageView.setImageResource(R.mipmap.ic_no_content);
        } else {
            textView.setText(com.transsion.baseui.R.string.base_net_err);
            imageView.setImageResource(R.mipmap.ic_no_network);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchUploadGroupFragment.this.searchJob();
                }
            });
        }
        Intrinsics.e(inflate);
        return inflate;
    }

    private final CheckTipsDialog getMCheckTipsDialog() {
        return (CheckTipsDialog) this.mCheckTipsDialog.getValue();
    }

    @SuppressLint({"InflateParams"})
    private final void initViewModel() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        SearchViewModel a = new v0(requireActivity).a(SearchViewModel.class);
        a.m().j(getViewLifecycleOwner(), new h(new Function1() { // from class: com.transsion.search.fragment.group.f
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$28$lambda$24;
                initViewModel$lambda$28$lambda$24 = SearchUploadGroupFragment.initViewModel$lambda$28$lambda$24(SearchUploadGroupFragment.this, (SearchGroupEntity) obj);
                return initViewModel$lambda$28$lambda$24;
            }
        }));
        a.o().j(getViewLifecycleOwner(), new h(new Function1() { // from class: com.transsion.search.fragment.group.g
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$28$lambda$26;
                initViewModel$lambda$28$lambda$26 = SearchUploadGroupFragment.initViewModel$lambda$28$lambda$26(SearchUploadGroupFragment.this, (SearchWorkEntity) obj);
                return initViewModel$lambda$28$lambda$26;
            }
        }));
        a.k().j(getViewLifecycleOwner(), new h(new Function1() { // from class: com.transsion.search.fragment.group.h
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$28$lambda$27;
                initViewModel$lambda$28$lambda$27 = SearchUploadGroupFragment.initViewModel$lambda$28$lambda$27(SearchUploadGroupFragment.this, (String) obj);
                return initViewModel$lambda$28$lambda$27;
            }
        }));
        this.mSearchViewModel = a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$28$lambda$24(SearchUploadGroupFragment searchUploadGroupFragment, SearchGroupEntity searchGroupEntity) {
        List data;
        RecyclerView recyclerView;
        RelativeLayout relativeLayout;
        RecyclerView recyclerView2;
        ProgressBar progressBar;
        PagerEntity pager;
        PagerEntity pager2;
        String nextPage;
        Integer v;
        PagerEntity pager3;
        RecyclerView.Adapter adapter = null;
        List<GroupBean> items = searchGroupEntity != null ? searchGroupEntity.getItems() : null;
        boolean hasMore = (searchGroupEntity == null || (pager3 = searchGroupEntity.getPager()) == null) ? false : pager3.getHasMore();
        searchUploadGroupFragment.page = (searchGroupEntity == null || (pager2 = searchGroupEntity.getPager()) == null || (nextPage = pager2.getNextPage()) == null || (v = StringsKt.v(nextPage)) == null) ? 1 : v.intValue();
        searchUploadGroupFragment.perPage = (searchGroupEntity == null || (pager = searchGroupEntity.getPager()) == null) ? 10 : pager.getPerPage();
        vp.d dVar = (vp.d) searchUploadGroupFragment.getMViewBinding();
        if (dVar != null && (progressBar = dVar.f) != null) {
            uf.c.g(progressBar);
        }
        com.transsion.search.fragment.group.adapter.a aVar = searchUploadGroupFragment.mSearchGroupAdapter;
        if (aVar != null) {
            aVar.h0().s();
            List<GroupBean> list = items;
            if (list == null || list.isEmpty()) {
                com.transsion.search.fragment.group.adapter.a aVar2 = searchUploadGroupFragment.mSearchGroupAdapter;
                if (aVar2 != null) {
                    aVar2.q1(new ArrayList());
                }
                aVar.Y0(searchUploadGroupFragment.emptyView());
                aVar.z1(true);
            }
            vp.d dVar2 = (vp.d) searchUploadGroupFragment.getMViewBinding();
            if (dVar2 != null && (recyclerView2 = dVar2.h) != null) {
                adapter = recyclerView2.getAdapter();
            }
            if (adapter instanceof com.transsion.search.fragment.group.adapter.b) {
                vp.d dVar3 = (vp.d) searchUploadGroupFragment.getMViewBinding();
                if (dVar3 != null && (relativeLayout = dVar3.g) != null) {
                    relativeLayout.setVisibility(8);
                }
                vp.d dVar4 = (vp.d) searchUploadGroupFragment.getMViewBinding();
                if (dVar4 != null && (recyclerView = dVar4.h) != null) {
                    recyclerView.setAdapter(searchUploadGroupFragment.mSearchGroupAdapter);
                }
            }
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : items) {
                    GroupBean groupBean = (GroupBean) obj;
                    com.transsion.search.fragment.group.adapter.a aVar3 = searchUploadGroupFragment.mSearchGroupAdapter;
                    if (aVar3 != null && (data = aVar3.getData()) != null && !data.contains(groupBean)) {
                        arrayList.add(obj);
                    }
                }
                if (arrayList.isEmpty()) {
                    aVar.h0().t(false);
                } else if (searchUploadGroupFragment.isRefreshing) {
                    searchUploadGroupFragment.isRefreshing = false;
                    com.transsion.search.fragment.group.adapter.a aVar4 = searchUploadGroupFragment.mSearchGroupAdapter;
                    if (aVar4 != null) {
                        aVar4.n1(arrayList);
                    }
                } else {
                    com.transsion.search.fragment.group.adapter.a aVar5 = searchUploadGroupFragment.mSearchGroupAdapter;
                    if (aVar5 != null) {
                        aVar5.q(arrayList);
                    }
                }
            }
            if (!hasMore) {
                aVar.h0().t(false);
            }
            if (searchGroupEntity == null) {
                aVar.h0().v();
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$28$lambda$26(SearchUploadGroupFragment searchUploadGroupFragment, SearchWorkEntity searchWorkEntity) {
        Pager pager;
        HashMap g2;
        RecyclerView recyclerView;
        RelativeLayout relativeLayout;
        RecyclerView recyclerView2;
        List data;
        ProgressBar progressBar;
        Pager pager2;
        Pager pager3;
        Pager pager4;
        RecyclerView.Adapter adapter = null;
        List<SearchSubject> items = searchWorkEntity != null ? searchWorkEntity.getItems() : null;
        boolean hasMore = (searchWorkEntity == null || (pager4 = searchWorkEntity.getPager()) == null) ? false : pager4.getHasMore();
        searchUploadGroupFragment.page = (searchWorkEntity == null || (pager3 = searchWorkEntity.getPager()) == null) ? 1 : pager3.getNextPage();
        searchUploadGroupFragment.perPage = (searchWorkEntity == null || (pager2 = searchWorkEntity.getPager()) == null) ? 10 : pager2.getPerPage();
        vp.d dVar = (vp.d) searchUploadGroupFragment.getMViewBinding();
        if (dVar != null && (progressBar = dVar.f) != null) {
            uf.c.g(progressBar);
        }
        com.transsion.search.adapter.b bVar = searchUploadGroupFragment.mSearchWorkAdapter;
        if (bVar != null) {
            bVar.h0().s();
            com.transsion.search.adapter.b bVar2 = searchUploadGroupFragment.mSearchWorkAdapter;
            Boolean valueOf = (bVar2 == null || (data = bVar2.getData()) == null) ? null : Boolean.valueOf(data.isEmpty());
            List<SearchSubject> list = items;
            if ((list == null || list.isEmpty()) && Intrinsics.c(valueOf, Boolean.TRUE) && (searchUploadGroupFragment.page == 1 || (searchWorkEntity != null && (pager = searchWorkEntity.getPager()) != null && pager.getPage() == 1))) {
                com.transsion.search.adapter.b bVar3 = searchUploadGroupFragment.mSearchWorkAdapter;
                if (bVar3 != null) {
                    bVar3.q1(new ArrayList());
                }
                bVar.Y0(searchUploadGroupFragment.emptyView());
                bVar.z1(true);
            }
            vp.d dVar2 = (vp.d) searchUploadGroupFragment.getMViewBinding();
            if (dVar2 != null && (recyclerView2 = dVar2.h) != null) {
                adapter = recyclerView2.getAdapter();
            }
            if (adapter instanceof com.transsion.search.fragment.group.adapter.b) {
                vp.d dVar3 = (vp.d) searchUploadGroupFragment.getMViewBinding();
                if (dVar3 != null && (relativeLayout = dVar3.g) != null) {
                    relativeLayout.setVisibility(8);
                }
                vp.d dVar4 = (vp.d) searchUploadGroupFragment.getMViewBinding();
                if (dVar4 != null && (recyclerView = dVar4.h) != null) {
                    recyclerView.setAdapter(searchUploadGroupFragment.mSearchWorkAdapter);
                }
            }
            if (list == null || list.isEmpty()) {
                bVar.h0().t(false);
            } else {
                if (searchUploadGroupFragment.isRefreshing) {
                    searchUploadGroupFragment.isRefreshing = false;
                    com.transsion.search.adapter.b bVar4 = searchUploadGroupFragment.mSearchWorkAdapter;
                    if (bVar4 != null) {
                        bVar4.n1(list);
                    }
                } else {
                    com.transsion.search.adapter.b bVar5 = searchUploadGroupFragment.mSearchWorkAdapter;
                    if (bVar5 != null) {
                        bVar5.q(list);
                    }
                }
                qi.b logViewConfig = searchUploadGroupFragment.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.k(true);
                }
                qi.b logViewConfig2 = searchUploadGroupFragment.getLogViewConfig();
                if (logViewConfig2 != null && (g2 = logViewConfig2.g()) != null) {
                    g2.put("type", String.valueOf(searchUploadGroupFragment.mType));
                }
            }
            if (!hasMore) {
                bVar.h0().t(false);
            }
            if (searchWorkEntity == null) {
                bVar.h0().v();
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$28$lambda$27(SearchUploadGroupFragment searchUploadGroupFragment, String str) {
        if (!TextUtils.isEmpty(str) && searchUploadGroupFragment.selectGroup != null) {
            searchUploadGroupFragment.postFinsh();
            searchUploadGroupFragment.postGroup(searchUploadGroupFragment.selectGroup);
            FragmentActivity activity = searchUploadGroupFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
            return Unit.a;
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CheckTipsDialog mCheckTipsDialog_delegate$lambda$0() {
        return CheckTipsDialog.INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$7(final SearchUploadGroupFragment searchUploadGroupFragment) {
        RecyclerView recyclerView;
        if (yg.l.a.e()) {
            SearchViewModel searchViewModel = searchUploadGroupFragment.mSearchViewModel;
            if (searchViewModel != null) {
                searchViewModel.v(searchUploadGroupFragment.page, searchUploadGroupFragment.perPage, searchUploadGroupFragment.mKeyword);
                return;
            }
            return;
        }
        fh.b.a.d(R.string.no_network_toast);
        vp.d dVar = (vp.d) searchUploadGroupFragment.getMViewBinding();
        if (dVar == null || (recyclerView = dVar.h) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.search.fragment.group.a
            @Override // java.lang.Runnable
            public final void run() {
                SearchUploadGroupFragment.onViewCreated$lambda$10$lambda$7$lambda$6(SearchUploadGroupFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$7$lambda$6(SearchUploadGroupFragment searchUploadGroupFragment) {
        t6.f h0;
        com.transsion.search.adapter.b bVar = searchUploadGroupFragment.mSearchWorkAdapter;
        if (bVar == null || (h0 = bVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$9(SearchUploadGroupFragment searchUploadGroupFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List data;
        GroupBean groupBean;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "view");
        com.transsion.search.fragment.group.adapter.a aVar = searchUploadGroupFragment.mSearchGroupAdapter;
        if (aVar == null || (data = aVar.getData()) == null || (groupBean = (GroupBean) data.get(i)) == null) {
            return;
        }
        searchUploadGroupFragment.selectGroup = groupBean;
        searchUploadGroupFragment.reportClick(groupBean.getGroupId(), BuildConfig.FLAVOR, groupBean.getOps(), i);
        searchUploadGroupFragment.postFinsh();
        searchUploadGroupFragment.postGroup(searchUploadGroupFragment.selectGroup);
        FragmentActivity activity = searchUploadGroupFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
    
        if (r2 != 3) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void onViewCreated$lambda$14(SearchUploadGroupFragment searchUploadGroupFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ProgressBar progressBar;
        EditText editText;
        EditText editText2;
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (view.getId() == R$id.tv_keyword) {
            FragmentActivity activity = searchUploadGroupFragment.getActivity();
            if (activity != null) {
                KeyboardUtils.d(activity);
            }
            com.transsion.search.fragment.group.adapter.b bVar = searchUploadGroupFragment.mSearchKeywordAdapter;
            searchUploadGroupFragment.mKeyword = String.valueOf(bVar != null ? (String) bVar.getItem(i) : null);
            vp.d dVar = (vp.d) searchUploadGroupFragment.getMViewBinding();
            if (dVar != null && (editText2 = dVar.b) != null) {
                editText2.setText(searchUploadGroupFragment.mKeyword);
            }
            int length = searchUploadGroupFragment.mKeyword.length();
            vp.d dVar2 = (vp.d) searchUploadGroupFragment.getMViewBinding();
            if (dVar2 != null && (editText = dVar2.b) != null) {
                editText.setSelection(length);
            }
            vp.d dVar3 = (vp.d) searchUploadGroupFragment.getMViewBinding();
            if (dVar3 != null && (progressBar = dVar3.f) != null) {
                progressBar.setVisibility(0);
            }
            int i2 = searchUploadGroupFragment.mType;
            if (i2 != 1) {
                if (i2 == 2) {
                    searchUploadGroupFragment.page = 1;
                    searchUploadGroupFragment.searchJob();
                }
                SearchManager.f.a().g(searchUploadGroupFragment.mKeyword);
            }
            searchUploadGroupFragment.page = 1;
            searchUploadGroupFragment.searchJob();
            SearchManager.f.a().g(searchUploadGroupFragment.mKeyword);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$15(SearchUploadGroupFragment searchUploadGroupFragment, View view) {
        TextView textView;
        vp.d dVar = (vp.d) searchUploadGroupFragment.getMViewBinding();
        if (dVar == null || (textView = dVar.j) == null) {
            return;
        }
        uf.c.k(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r3 != 3) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void onViewCreated$lambda$16(SearchUploadGroupFragment searchUploadGroupFragment, View view, boolean z) {
        HashMap g2;
        List data;
        RelativeLayout relativeLayout;
        List data2;
        RelativeLayout relativeLayout2;
        view.dispatchWindowFocusChanged(z);
        if (z) {
            int i = searchUploadGroupFragment.mType;
            if (i != 1) {
                if (i == 2) {
                    com.transsion.search.fragment.group.adapter.a aVar = searchUploadGroupFragment.mSearchGroupAdapter;
                    if (aVar != null && (data2 = aVar.getData()) != null && data2.isEmpty()) {
                        vp.d dVar = (vp.d) searchUploadGroupFragment.getMViewBinding();
                        if (dVar != null && (relativeLayout2 = dVar.g) != null) {
                            relativeLayout2.setVisibility(0);
                        }
                        com.transsion.search.fragment.group.adapter.b bVar = searchUploadGroupFragment.mSearchKeywordAdapter;
                        if (bVar != null) {
                            bVar.q1(searchUploadGroupFragment.mHistoryList);
                        }
                    }
                }
            }
            com.transsion.search.adapter.b bVar2 = searchUploadGroupFragment.mSearchWorkAdapter;
            if (bVar2 != null && (data = bVar2.getData()) != null && data.isEmpty()) {
                vp.d dVar2 = (vp.d) searchUploadGroupFragment.getMViewBinding();
                if (dVar2 != null && (relativeLayout = dVar2.g) != null) {
                    relativeLayout.setVisibility(0);
                }
                com.transsion.search.fragment.group.adapter.b bVar3 = searchUploadGroupFragment.mSearchKeywordAdapter;
                if (bVar3 != null) {
                    bVar3.q1(searchUploadGroupFragment.mHistoryList);
                }
            }
        }
        String j = com.blankj.utilcode.util.o.j(searchUploadGroupFragment.mHistoryList);
        qi.b logViewConfig = searchUploadGroupFragment.getLogViewConfig();
        if (logViewConfig == null || (g2 = logViewConfig.g()) == null) {
            return;
        }
        g2.put("keyword", j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$19(SearchUploadGroupFragment searchUploadGroupFragment, View view) {
        searchUploadGroupFragment.postFinsh();
        FragmentActivity activity = searchUploadGroupFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$2(final SearchUploadGroupFragment searchUploadGroupFragment) {
        RecyclerView recyclerView;
        if (yg.l.a.e()) {
            SearchViewModel searchViewModel = searchUploadGroupFragment.mSearchViewModel;
            if (searchViewModel != null) {
                searchViewModel.w(searchUploadGroupFragment.page, searchUploadGroupFragment.perPage, searchUploadGroupFragment.mKeyword);
                return;
            }
            return;
        }
        fh.b.a.d(R.string.no_network_toast);
        vp.d dVar = (vp.d) searchUploadGroupFragment.getMViewBinding();
        if (dVar == null || (recyclerView = dVar.h) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.search.fragment.group.i
            @Override // java.lang.Runnable
            public final void run() {
                SearchUploadGroupFragment.onViewCreated$lambda$5$lambda$2$lambda$1(SearchUploadGroupFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$2$lambda$1(SearchUploadGroupFragment searchUploadGroupFragment) {
        t6.f h0;
        com.transsion.search.adapter.b bVar = searchUploadGroupFragment.mSearchWorkAdapter;
        if (bVar == null || (h0 = bVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$4(SearchUploadGroupFragment searchUploadGroupFragment, com.transsion.search.adapter.b bVar, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List data;
        SearchSubject searchSubject;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "view");
        com.transsion.search.adapter.b bVar2 = searchUploadGroupFragment.mSearchWorkAdapter;
        if (bVar2 == null || (data = bVar2.getData()) == null || (searchSubject = (SearchSubject) data.get(i)) == null) {
            return;
        }
        searchUploadGroupFragment.reportClick(BuildConfig.FLAVOR, searchSubject.getSubjectId(), searchSubject.getOps(), i);
        if (searchUploadGroupFragment.mType == 3) {
            Integer subjectType = searchSubject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value) {
                Navigator c2 = TheRouter.c("/movie/detail");
                Integer subjectType2 = searchSubject.getSubjectType();
                Navigator.x(c2.F("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).K("id", searchSubject.getSubjectId()).K("ops", searchSubject.getOps()), searchUploadGroupFragment.requireContext(), (mf.c) null, 2, (Object) null);
                return;
            } else {
                DownloadManagerApi a = DownloadManagerApi.j.a();
                FragmentActivity context = bVar.getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                DownloadManagerApi.e0(a, context, "searchpage", BuildConfig.FLAVOR, searchSubject.getOps(), "download_subject", false, searchSubject, (String) null, (Boolean) null, 384, (Object) null);
                return;
            }
        }
        jo.b bVar3 = new jo.b();
        bVar3.o(3);
        bVar3.n(1);
        bVar3.s(searchSubject);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar3, 0L);
        FragmentActivity activity = searchUploadGroupFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void postFinsh() {
        tp.a aVar = new tp.a();
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = tp.a.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, aVar, 0L);
    }

    private final void postGroup(GroupBean groupBean) {
        jo.b bVar = new jo.b();
        bVar.o(6);
        bVar.n(1);
        bVar.m(groupBean);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
    }

    private final void reportClick(String group_id, String subject_id, String opt, int position) {
        HashMap hashMap = new HashMap();
        if (group_id == null) {
            group_id = BuildConfig.FLAVOR;
        }
        hashMap.put("group_id", group_id);
        if (subject_id == null) {
            subject_id = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", subject_id);
        hashMap.put("sequence", String.valueOf(position));
        if (opt == null) {
            opt = BuildConfig.FLAVOR;
        }
        hashMap.put("ops", opt);
        com.transsion.baselib.helper.a.a.f("searchresult", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if (r3 != 3) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void resetContent(boolean clear) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RecyclerView recyclerView;
        vp.d dVar;
        EditText editText;
        EditText editText2;
        if (!clear) {
            vp.d dVar2 = (vp.d) getMViewBinding();
            if (dVar2 != null && (editText2 = dVar2.b) != null) {
                editText2.setText(BuildConfig.FLAVOR);
            }
            this.mKeyword = BuildConfig.FLAVOR;
        }
        int i = this.mType;
        if (i != 1) {
            if (i == 2) {
                com.transsion.search.fragment.group.adapter.a aVar = this.mSearchGroupAdapter;
                if (aVar != null) {
                    aVar.q1(new ArrayList());
                }
                com.transsion.search.adapter.b bVar = this.mSearchWorkAdapter;
                if (bVar != null) {
                    bVar.H0();
                }
            }
            dVar = (vp.d) getMViewBinding();
            if (dVar != null || (editText = dVar.b) == null) {
            }
            KeyboardUtils.i(editText);
            return;
        }
        com.transsion.search.adapter.b bVar2 = this.mSearchWorkAdapter;
        if (bVar2 != null) {
            bVar2.q1(new ArrayList());
        }
        com.transsion.search.adapter.b bVar3 = this.mSearchWorkAdapter;
        if (bVar3 != null) {
            bVar3.H0();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(SearchManager.f.a().l());
        CollectionsKt.Y(arrayList);
        this.mHistoryList = arrayList;
        com.transsion.search.fragment.group.adapter.b bVar4 = this.mSearchKeywordAdapter;
        if (bVar4 != null) {
            bVar4.q1(arrayList);
        }
        vp.d dVar3 = (vp.d) getMViewBinding();
        if (dVar3 != null && (recyclerView = dVar3.h) != null) {
            recyclerView.setAdapter(this.mSearchKeywordAdapter);
        }
        if (arrayList.isEmpty()) {
            vp.d dVar4 = (vp.d) getMViewBinding();
            if (dVar4 != null && (relativeLayout = dVar4.g) != null) {
                relativeLayout.setVisibility(8);
            }
        } else {
            vp.d dVar5 = (vp.d) getMViewBinding();
            if (dVar5 != null && (relativeLayout2 = dVar5.g) != null) {
                relativeLayout2.setVisibility(0);
            }
        }
        dVar = (vp.d) getMViewBinding();
        if (dVar != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b3, code lost:
    
        if (r2 != 3) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void searchJob() {
        TextView textView;
        ProgressBar progressBar;
        if (TextUtils.isEmpty(this.mKeyword)) {
            if (this.mType == 2) {
                com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.a;
                hVar.e(16);
                hVar.l(getString(R$string.tips_room));
                return;
            } else {
                com.tn.lib.widget.toast.core.h hVar2 = com.tn.lib.widget.toast.core.h.a;
                hVar2.e(16);
                hVar2.l(getString(R$string.tips_movie));
                return;
            }
        }
        this.isRefreshing = true;
        SearchManager.f.a().g(this.mKeyword);
        vp.d dVar = (vp.d) getMViewBinding();
        EditText editText = dVar != null ? dVar.b : null;
        Intrinsics.e(editText);
        KeyboardUtils.e(editText);
        if (!yg.l.a.e()) {
            int i = this.mType;
            if (i != 1) {
                if (i == 2) {
                    com.transsion.search.fragment.group.adapter.a aVar = this.mSearchGroupAdapter;
                    if (aVar != null) {
                        aVar.Y0(emptyView());
                    }
                    com.transsion.search.fragment.group.adapter.a aVar2 = this.mSearchGroupAdapter;
                    if (aVar2 != null) {
                        aVar2.q1(new ArrayList());
                        return;
                    }
                    return;
                }
                if (i != 3) {
                    return;
                }
            }
            com.transsion.search.adapter.b bVar = this.mSearchWorkAdapter;
            if (bVar != null) {
                bVar.Y0(emptyView());
            }
            com.transsion.search.adapter.b bVar2 = this.mSearchWorkAdapter;
            if (bVar2 != null) {
                bVar2.q1(new ArrayList());
                return;
            }
            return;
        }
        vp.d dVar2 = (vp.d) getMViewBinding();
        if (dVar2 != null && (progressBar = dVar2.f) != null) {
            uf.c.k(progressBar);
        }
        vp.d dVar3 = (vp.d) getMViewBinding();
        if (dVar3 != null && (textView = dVar3.j) != null) {
            uf.c.g(textView);
        }
        int i2 = this.mType;
        if (i2 != 1) {
            if (i2 == 2) {
                this.page = 1;
                SearchViewModel searchViewModel = this.mSearchViewModel;
                if (searchViewModel != null) {
                    searchViewModel.v(1, this.perPage, this.mKeyword);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "search");
            hashMap.put("key_word", this.mKeyword);
            hashMap.put("type", String.valueOf(this.mType));
            com.transsion.baselib.helper.a.a.f("searchpage", hashMap);
        }
        this.page = 1;
        SearchViewModel searchViewModel2 = this.mSearchViewModel;
        if (searchViewModel2 != null) {
            searchViewModel2.w(1, this.perPage, this.mKeyword);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("module_name", "search");
        hashMap2.put("key_word", this.mKeyword);
        hashMap2.put("type", String.valueOf(this.mType));
        com.transsion.baselib.helper.a.a.f("searchpage", hashMap2);
    }

    private final void showCheckDialog() {
        getMCheckTipsDialog().l0(this, "mCheckTipsDialog");
    }

    public vp.d getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        vp.d c2 = vp.d.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        setNetListener(new b());
    }

    public void lazyLoadData() {
    }

    public qi.b newLogViewConfig() {
        return new qi.b("searchpage", false, 2, null);
    }

    public void onDestroyView() {
        ProgressBar progressBar;
        vp.d dVar = (vp.d) getMViewBinding();
        if (dVar != null && (progressBar = dVar.f) != null) {
            uf.c.g(progressBar);
        }
        super.onDestroyView();
    }

    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
    }

    public void onRightButtonClick(TRDialog dialog) {
        RelativeLayout relativeLayout;
        Intrinsics.h(dialog, "dialog");
        if (TextUtils.equals(dialog.getTag(), "clear_tips")) {
            SearchManager.f.a().j();
            vp.d dVar = (vp.d) getMViewBinding();
            if (dVar != null && (relativeLayout = dVar.g) != null) {
                relativeLayout.setVisibility(8);
            }
            com.transsion.search.fragment.group.adapter.b bVar = this.mSearchKeywordAdapter;
            if (bVar != null) {
                bVar.q1(new ArrayList());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r5 != 3) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0217  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        vp.d dVar;
        com.transsion.search.fragment.group.adapter.b bVar;
        vp.d dVar2;
        vp.d dVar3;
        vp.d dVar4;
        vp.d dVar5;
        vp.d dVar6;
        vp.d dVar7;
        vp.d dVar8;
        vp.d dVar9;
        vp.d dVar10;
        vp.d dVar11;
        vp.d dVar12;
        vp.d dVar13;
        qi.b logViewConfig;
        vp.d dVar14;
        RecyclerView recyclerView4;
        EditText editText;
        EditText editText2;
        ImageView imageView;
        ProgressBar progressBar;
        AppCompatImageView appCompatImageView;
        EditText editText3;
        EditText editText4;
        TextView textView;
        EditText editText5;
        EditText editText6;
        RecyclerView recyclerView5;
        RecyclerView recyclerView6;
        TextView textView2;
        RecyclerView recyclerView7;
        EditText editText7;
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        int i = 1;
        int i2 = arguments != null ? arguments.getInt("type") : 1;
        this.mType = i2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i3 = 0;
        if (i2 != 1) {
            if (i2 == 2) {
                vp.d dVar15 = (vp.d) getMViewBinding();
                if (dVar15 != null && (editText7 = dVar15.b) != null) {
                    editText7.setHint(R$string.search_hint_input_group);
                }
                com.transsion.search.fragment.group.adapter.a aVar = new com.transsion.search.fragment.group.adapter.a(i3, i, defaultConstructorMarker);
                aVar.h0().D(new r6.f() { // from class: com.transsion.search.fragment.group.m
                    public final void a() {
                        SearchUploadGroupFragment.onViewCreated$lambda$10$lambda$7(SearchUploadGroupFragment.this);
                    }
                });
                aVar.w1(new r6.d() { // from class: com.transsion.search.fragment.group.n
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i4) {
                        SearchUploadGroupFragment.onViewCreated$lambda$10$lambda$9(SearchUploadGroupFragment.this, baseQuickAdapter, view2, i4);
                    }
                });
                this.mSearchGroupAdapter = aVar;
                vp.d dVar16 = (vp.d) getMViewBinding();
                if (dVar16 != null && (recyclerView7 = dVar16.h) != null) {
                    com.transsion.search.fragment.group.adapter.a aVar2 = this.mSearchGroupAdapter;
                    recyclerView7.addOnScrollListener(new nj.a(aVar2 != null ? aVar2.h0() : null));
                }
            }
            dVar = (vp.d) getMViewBinding();
            if (dVar != null && (textView2 = dVar.i) != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SearchUploadGroupFragment.this.clearTipsDialog();
                    }
                });
            }
            com.transsion.search.fragment.group.adapter.b bVar2 = new com.transsion.search.fragment.group.adapter.b(0, 1, null);
            this.mSearchKeywordAdapter = bVar2;
            bVar2.l(new int[]{R$id.tv_keyword});
            bVar = this.mSearchKeywordAdapter;
            if (bVar != null) {
                bVar.s1(new r6.b() { // from class: com.transsion.search.fragment.group.p
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i4) {
                        SearchUploadGroupFragment.onViewCreated$lambda$14(SearchUploadGroupFragment.this, baseQuickAdapter, view2, i4);
                    }
                });
            }
            dVar2 = (vp.d) getMViewBinding();
            if (dVar2 != null && (recyclerView6 = dVar2.h) != null) {
                recyclerView6.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
            }
            dVar3 = (vp.d) getMViewBinding();
            if (dVar3 != null && (recyclerView5 = dVar3.h) != null) {
                recyclerView5.setAdapter(this.mSearchKeywordAdapter);
            }
            SearchManager.f.a().m(this.mType, new f());
            initViewModel();
            dVar4 = (vp.d) getMViewBinding();
            if (dVar4 != null && (editText6 = dVar4.b) != null) {
                editText6.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SearchUploadGroupFragment.onViewCreated$lambda$15(SearchUploadGroupFragment.this, view2);
                    }
                });
            }
            dVar5 = (vp.d) getMViewBinding();
            if (dVar5 != null && (editText5 = dVar5.b) != null) {
                editText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.search.fragment.group.r
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view2, boolean z) {
                        SearchUploadGroupFragment.onViewCreated$lambda$16(SearchUploadGroupFragment.this, view2, z);
                    }
                });
            }
            dVar6 = (vp.d) getMViewBinding();
            if (dVar6 != null && (textView = dVar6.j) != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SearchUploadGroupFragment.this.searchJob();
                    }
                });
            }
            dVar7 = (vp.d) getMViewBinding();
            if (dVar7 != null && (editText4 = dVar7.b) != null) {
                editText4.addTextChangedListener(new g());
            }
            dVar8 = (vp.d) getMViewBinding();
            if (dVar8 != null && (editText3 = dVar8.b) != null) {
                editText3.setOnEditorActionListener(new c());
            }
            dVar9 = (vp.d) getMViewBinding();
            if (dVar9 != null && (appCompatImageView = dVar9.d) != null) {
                appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SearchUploadGroupFragment.this.resetContent(false);
                    }
                });
            }
            dVar10 = (vp.d) getMViewBinding();
            if (dVar10 != null && (progressBar = dVar10.f) != null) {
                uf.c.g(progressBar);
            }
            getMCheckTipsDialog().s0(new d());
            dVar11 = (vp.d) getMViewBinding();
            if (dVar11 != null && (imageView = dVar11.c) != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SearchUploadGroupFragment.onViewCreated$lambda$19(SearchUploadGroupFragment.this, view2);
                    }
                });
            }
            dVar12 = (vp.d) getMViewBinding();
            if (dVar12 != null && (editText2 = dVar12.b) != null) {
                editText2.requestFocus();
            }
            dVar13 = (vp.d) getMViewBinding();
            if (dVar13 != null && (editText = dVar13.b) != null) {
                KeyboardUtils.i(editText);
            }
            logViewConfig = getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            dVar14 = (vp.d) getMViewBinding();
            if (dVar14 != null || (recyclerView4 = dVar14.h) == null) {
            }
            recyclerView4.addOnScrollListener(new e());
            return;
        }
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        final com.transsion.search.adapter.b bVar3 = new com.transsion.search.adapter.b(requireContext, new ArrayList());
        bVar3.h0().D(new r6.f() { // from class: com.transsion.search.fragment.group.j
            public final void a() {
                SearchUploadGroupFragment.onViewCreated$lambda$5$lambda$2(SearchUploadGroupFragment.this);
            }
        });
        bVar3.w1(new r6.d() { // from class: com.transsion.search.fragment.group.l
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i4) {
                SearchUploadGroupFragment.onViewCreated$lambda$5$lambda$4(SearchUploadGroupFragment.this, bVar3, baseQuickAdapter, view2, i4);
            }
        });
        this.mSearchWorkAdapter = bVar3;
        vp.d dVar17 = (vp.d) getMViewBinding();
        if (dVar17 != null && (recyclerView3 = dVar17.h) != null) {
            recyclerView3.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        }
        vp.d dVar18 = (vp.d) getMViewBinding();
        if (dVar18 != null && (recyclerView2 = dVar18.h) != null) {
            recyclerView2.setAdapter(this.mSearchWorkAdapter);
        }
        vp.d dVar19 = (vp.d) getMViewBinding();
        if (dVar19 != null && (recyclerView = dVar19.h) != null) {
            com.transsion.search.adapter.b bVar4 = this.mSearchWorkAdapter;
            recyclerView.addOnScrollListener(new nj.a(bVar4 != null ? bVar4.h0() : null));
        }
        dVar = (vp.d) getMViewBinding();
        if (dVar != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadGroupFragment.this.clearTipsDialog();
                }
            });
        }
        com.transsion.search.fragment.group.adapter.b bVar22 = new com.transsion.search.fragment.group.adapter.b(0, 1, null);
        this.mSearchKeywordAdapter = bVar22;
        bVar22.l(new int[]{R$id.tv_keyword});
        bVar = this.mSearchKeywordAdapter;
        if (bVar != null) {
        }
        dVar2 = (vp.d) getMViewBinding();
        if (dVar2 != null) {
            recyclerView6.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        }
        dVar3 = (vp.d) getMViewBinding();
        if (dVar3 != null) {
            recyclerView5.setAdapter(this.mSearchKeywordAdapter);
        }
        SearchManager.f.a().m(this.mType, new f());
        initViewModel();
        dVar4 = (vp.d) getMViewBinding();
        if (dVar4 != null) {
            editText6.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadGroupFragment.onViewCreated$lambda$15(SearchUploadGroupFragment.this, view2);
                }
            });
        }
        dVar5 = (vp.d) getMViewBinding();
        if (dVar5 != null) {
            editText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.search.fragment.group.r
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z) {
                    SearchUploadGroupFragment.onViewCreated$lambda$16(SearchUploadGroupFragment.this, view2, z);
                }
            });
        }
        dVar6 = (vp.d) getMViewBinding();
        if (dVar6 != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadGroupFragment.this.searchJob();
                }
            });
        }
        dVar7 = (vp.d) getMViewBinding();
        if (dVar7 != null) {
            editText4.addTextChangedListener(new g());
        }
        dVar8 = (vp.d) getMViewBinding();
        if (dVar8 != null) {
            editText3.setOnEditorActionListener(new c());
        }
        dVar9 = (vp.d) getMViewBinding();
        if (dVar9 != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadGroupFragment.this.resetContent(false);
                }
            });
        }
        dVar10 = (vp.d) getMViewBinding();
        if (dVar10 != null) {
            uf.c.g(progressBar);
        }
        getMCheckTipsDialog().s0(new d());
        dVar11 = (vp.d) getMViewBinding();
        if (dVar11 != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadGroupFragment.onViewCreated$lambda$19(SearchUploadGroupFragment.this, view2);
                }
            });
        }
        dVar12 = (vp.d) getMViewBinding();
        if (dVar12 != null) {
            editText2.requestFocus();
        }
        dVar13 = (vp.d) getMViewBinding();
        if (dVar13 != null) {
            KeyboardUtils.i(editText);
        }
        logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
        }
        dVar14 = (vp.d) getMViewBinding();
        if (dVar14 != null) {
        }
    }
}
