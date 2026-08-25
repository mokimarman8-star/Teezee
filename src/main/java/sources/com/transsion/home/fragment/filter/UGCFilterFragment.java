package com.transsion.home.fragment.filter;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.google.android.material.tabs.TabLayout;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.NoNetworkBigView;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.home.bean.RefreshBaseDto;
import com.transsion.home.bean.UGCFilterVideoItem;
import com.transsion.home.bean.ugc.UGCFilterGrade;
import com.transsion.home.bean.ugc.UGCFilterItem;
import com.transsion.home.bean.ugc.UGCFilterResponse;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.home.view.filter.expand.UGCFilterExpandView;
import com.transsion.home.view.layoutmanager.OffsetGridLayoutManager;
import com.transsion.home.viewmodel.UGCFilterViewModel;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.push.bean.MsgStyle;
import com.transsion.ugcvideodetail.api.UGCVideoType;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCContentList;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import qk.i0;
import wf.a;
import yg.m;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\b\u0007\u0018\u0000 ±\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004²\u0001³\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u001b\u0010\u000f\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u0004J!\u0010&\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\rH\u0002¢\u0006\u0004\b&\u0010'J\u001b\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120(H\u0002¢\u0006\u0004\b)\u0010*J+\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120+j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012`,H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u0010\u0004J\u0017\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0018H\u0002¢\u0006\u0004\b1\u0010\u001bJ\u0017\u00102\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\rH\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0007H\u0002¢\u0006\u0004\b4\u0010\u0004J\u0019\u00106\u001a\u0004\u0018\u00010\u00122\u0006\u00105\u001a\u00020\u0012H\u0002¢\u0006\u0004\b6\u00107J\u0019\u00109\u001a\u0004\u0018\u00010\u00122\u0006\u00108\u001a\u00020\u0012H\u0002¢\u0006\u0004\b9\u00107J\u000f\u0010:\u001a\u00020\u0007H\u0002¢\u0006\u0004\b:\u0010\u0004J\u000f\u0010;\u001a\u00020\u0007H\u0002¢\u0006\u0004\b;\u0010\u0004J\u0019\u0010=\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0007H\u0002¢\u0006\u0004\b?\u0010\u0004J\u000f\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020@H\u0002¢\u0006\u0004\bC\u0010BJ\u000f\u0010D\u001a\u00020\u0007H\u0002¢\u0006\u0004\bD\u0010\u0004J+\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120(2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u0012H\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001a\u00020\u00022\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bJ\u0010KJ\u0019\u0010N\u001a\u00020\u00072\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bN\u0010OJ!\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010LH\u0017¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u0007H\u0016¢\u0006\u0004\bS\u0010\u0004J\u000f\u0010T\u001a\u00020\u0007H\u0016¢\u0006\u0004\bT\u0010\u0004J\u000f\u0010U\u001a\u00020\u0007H\u0016¢\u0006\u0004\bU\u0010\u0004J\u000f\u0010V\u001a\u00020\u0007H\u0016¢\u0006\u0004\bV\u0010\u0004J\u0017\u0010X\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\rH\u0016¢\u0006\u0004\bX\u00103J\u000f\u0010Y\u001a\u00020\u0007H\u0016¢\u0006\u0004\bY\u0010\u0004J\u000f\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0007H\u0016¢\u0006\u0004\b]\u0010\u0004J\u000f\u0010^\u001a\u00020\u0012H\u0016¢\u0006\u0004\b^\u0010_J\u000f\u0010`\u001a\u00020\u0007H\u0016¢\u0006\u0004\b`\u0010\u0004J\u0011\u0010b\u001a\u0004\u0018\u00010aH\u0016¢\u0006\u0004\bb\u0010cJ\u001f\u0010g\u001a\u00020\u00072\u0006\u0010d\u001a\u00020@2\u0006\u0010f\u001a\u00020eH\u0016¢\u0006\u0004\bg\u0010hR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010}\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0081\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0083\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0083\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R+\u0010\u0091\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00180\u008e\u00010\u008d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001b\u0010\u0094\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001b\u0010\u0096\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0093\u0001R\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0093\u0001R\u001b\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0083\u0001R\u0018\u0010\u009c\u0001\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010|R\u001c\u0010 \u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R9\u0010£\u0001\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u0001`,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u001a\u0010§\u0001\u001a\u00030¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0019\u0010ª\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001a\u0010¬\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b«\u0001\u0010rR\u001a\u0010®\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010rR\u001a\u0010°\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¯\u0001\u0010r¨\u0006´\u0001"}, d2 = {"Lcom/transsion/home/fragment/filter/UGCFilterFragment;", "Lcom/transsion/home/fragment/tab/BaseHomeSubFragment;", "Lqk/m;", "<init>", "()V", "Landroid/view/View;", "header", BuildConfig.FLAVOR, "t1", "(Landroid/view/View;)V", "headerView", "s1", "Lcom/google/android/material/tabs/TabLayout$Tab;", BuildConfig.FLAVOR, "selected", "X0", "(Lcom/google/android/material/tabs/TabLayout$Tab;Z)V", "tab", BuildConfig.FLAVOR, "title", "D1", "(Lcom/google/android/material/tabs/TabLayout$Tab;Ljava/lang/String;Z)V", "n1", "l1", "Lcom/transsion/home/bean/ugc/UGCFilterItem;", "item", "C1", "(Lcom/transsion/home/bean/ugc/UGCFilterItem;)V", "o1", "i1", "Z0", "initViewModel", "loadData", "E1", "loadMore", "Lcom/transsion/ugcvideodetail/api/bean/UGCContentList;", "contentList", "isRefresh", "K1", "(Lcom/transsion/ugcvideodetail/api/bean/UGCContentList;Z)V", BuildConfig.FLAVOR, "Y0", "()Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "j1", "()Ljava/util/HashMap;", "J1", "ugcFilterItem", "B1", "A1", "(Z)V", "M1", "categoryId", "a1", "(Ljava/lang/String;)Ljava/lang/String;", "gradeCode", "b1", "showLoadingView", "g1", "string", "H1", "(Ljava/lang/String;)V", "h1", BuildConfig.FLAVOR, "e1", "()I", "d1", "k1", "key", "c1", "(Lcom/transsion/home/bean/ugc/UGCFilterItem;Ljava/lang/String;)Ljava/util/Map;", "Landroid/view/LayoutInflater;", "inflater", "f1", "(Landroid/view/LayoutInflater;)Lqk/m;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "startLoading", "hideLoading", "onResume", "hidden", "onHiddenChanged", "onPause", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "onDestroyView", "g0", "()Ljava/lang/String;", "c0", "Landroidx/recyclerview/widget/RecyclerView;", "f0", "()Landroidx/recyclerview/widget/RecyclerView;", "lastAdPosition", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "wrapperNativeManager", "l0", "(ILcom/transsion/ad/bidding/nativead/BiddingNativeManager;)V", "Lcom/transsion/home/adapter/filter/a;", "g", "Lcom/transsion/home/adapter/filter/a;", "mAdapter", "Lcom/transsion/home/viewmodel/UGCFilterViewModel;", "h", "Lcom/transsion/home/viewmodel/UGCFilterViewModel;", "mMovieModel", "i", "Landroid/view/View;", "Lqk/i0;", "j", "Lqk/i0;", "headerBinding", "Lcom/transsion/home/view/filter/expand/UGCFilterExpandView;", "k", "Lcom/transsion/home/view/filter/expand/UGCFilterExpandView;", "filterView", "l", "I", "mPage", "Lcom/transsion/home/fragment/filter/UGCFilterFragment$TabType;", "m", "Lcom/transsion/home/fragment/filter/UGCFilterFragment$TabType;", "mCurrentTab", "n", "Ljava/lang/String;", "mCategory", "o", "mFilterJson", "p", "fromOptId", "Lcom/transsion/home/bean/ugc/UGCFilterResponse;", "q", "Lcom/transsion/home/bean/ugc/UGCFilterResponse;", "mFilterResponse", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "r", "Ljava/util/Map;", "categoryChildrenByParentIdMap", "s", "Ljava/lang/Integer;", "mSelectedLevel2", "t", "mSelectedLevel3", "u", "mSelectedLevel4", "v", "mSelectedGrade", "w", "mPerPage", "Lrk/b;", "x", "Lrk/b;", "mExposureHelper", "y", "Ljava/util/HashMap;", "mLatestSelectItems", BuildConfig.FLAVOR, "z", "J", "firstLoadStartTimeMillis", "A", "Z", "hasRecordedFirstLoadDuration", "B", "mNoNetworkView", "C", "mLoadingView", "D", "mNoResultView", "E", "a", "TabType", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCFilterFragment extends BaseHomeSubFragment<qk.m> {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int F = 8;

    /* renamed from: A, reason: from kotlin metadata */
    private boolean hasRecordedFirstLoadDuration;

    /* renamed from: B, reason: from kotlin metadata */
    private View mNoNetworkView;

    /* renamed from: C, reason: from kotlin metadata */
    private View mLoadingView;

    /* renamed from: D, reason: from kotlin metadata */
    private View mNoResultView;

    /* renamed from: g, reason: from kotlin metadata */
    private com.transsion.home.adapter.filter.a mAdapter;

    /* renamed from: h, reason: from kotlin metadata */
    private UGCFilterViewModel mMovieModel;

    /* renamed from: i, reason: from kotlin metadata */
    private View header;

    /* renamed from: j, reason: from kotlin metadata */
    private i0 headerBinding;

    /* renamed from: k, reason: from kotlin metadata */
    private UGCFilterExpandView filterView;

    /* renamed from: o, reason: from kotlin metadata */
    private volatile String mFilterJson;

    /* renamed from: p, reason: from kotlin metadata */
    private String fromOptId;

    /* renamed from: q, reason: from kotlin metadata */
    private UGCFilterResponse mFilterResponse;

    /* renamed from: s, reason: from kotlin metadata */
    private Integer mSelectedLevel2;

    /* renamed from: t, reason: from kotlin metadata */
    private Integer mSelectedLevel3;

    /* renamed from: u, reason: from kotlin metadata */
    private Integer mSelectedLevel4;

    /* renamed from: v, reason: from kotlin metadata */
    private String mSelectedGrade;

    /* renamed from: x, reason: from kotlin metadata */
    private rk.b mExposureHelper;

    /* renamed from: y, reason: from kotlin metadata */
    private HashMap mLatestSelectItems;

    /* renamed from: z, reason: from kotlin metadata */
    private long firstLoadStartTimeMillis;

    /* renamed from: l, reason: from kotlin metadata */
    private int mPage = 1;

    /* renamed from: m, reason: from kotlin metadata */
    private TabType mCurrentTab = TabType.FOR_U;

    /* renamed from: n, reason: from kotlin metadata */
    private String mCategory = "Education";

    /* renamed from: r, reason: from kotlin metadata */
    private final Map categoryChildrenByParentIdMap = new LinkedHashMap();

    /* renamed from: w, reason: from kotlin metadata */
    private int mPerPage = 12;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/home/fragment/filter/UGCFilterFragment$TabType;", BuildConfig.FLAVOR, "apiValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getApiValue", "()Ljava/lang/String;", "FOR_U", "LATEST", "HOTTEST", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class TabType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TabType[] $VALUES;
        private final String apiValue;
        public static final TabType FOR_U = new TabType("FOR_U", 0, "ForYou");
        public static final TabType LATEST = new TabType("LATEST", 1, "Latest");
        public static final TabType HOTTEST = new TabType("HOTTEST", 2, "New");

        private static final /* synthetic */ TabType[] $values() {
            return new TabType[]{FOR_U, LATEST, HOTTEST};
        }

        static {
            TabType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private TabType(String str, int i, String str2) {
            this.apiValue = str2;
        }

        public static EnumEntries<TabType> getEntries() {
            return $ENTRIES;
        }

        public static TabType valueOf(String str) {
            return (TabType) Enum.valueOf(TabType.class, str);
        }

        public static TabType[] values() {
            return (TabType[]) $VALUES.clone();
        }

        public final String getApiValue() {
            return this.apiValue;
        }
    }

    /* renamed from: com.transsion.home.fragment.filter.UGCFilterFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UGCFilterFragment a(int i, String str, String str2, String str3, String str4) {
            Intrinsics.h(str2, "category");
            Intrinsics.h(str4, "fromOptId");
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", i);
            bundle.putString("tab_code", str);
            bundle.putString("category", str2);
            bundle.putString("filter_json", str3);
            bundle.putString("fromOptId", str4);
            UGCFilterFragment uGCFilterFragment = new UGCFilterFragment();
            uGCFilterFragment.setArguments(bundle);
            return uGCFilterFragment;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.FOR_U.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TabType.HOTTEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final class c implements rk.a {
        c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
        
            if (r13.s0() == true) goto L8;
         */
        @Override // rk.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i, long j, View view) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            UGCContent content;
            UGCVideo video;
            String ops;
            UGCContent content2;
            UGCVideo video2;
            UGCContent content3;
            UGCVideo video3;
            UGCContent content4;
            UGCVideo video4;
            UGCVideoBelongToCollection belongToCollection;
            List<UGCFilterItem> items;
            List data;
            com.transsion.home.adapter.filter.a aVar = UGCFilterFragment.this.mAdapter;
            int i2 = 0;
            int i3 = aVar != null ? 1 : 0;
            int i4 = i - i3;
            com.transsion.home.adapter.filter.a aVar2 = UGCFilterFragment.this.mAdapter;
            if (aVar2 != null && (data = aVar2.getData()) != null) {
                i2 = data.size();
            }
            if (i4 < 0 || i4 >= i2) {
                return;
            }
            com.transsion.home.adapter.filter.a aVar3 = UGCFilterFragment.this.mAdapter;
            UGCFilterVideoItem uGCFilterVideoItem = aVar3 != null ? (UGCFilterVideoItem) aVar3.getItem(i4) : null;
            HashMap hashMap = new HashMap();
            hashMap.put("browse_duration", String.valueOf(j));
            hashMap.put("module_name", "item");
            UGCFilterResponse uGCFilterResponse = UGCFilterFragment.this.mFilterResponse;
            String str7 = BuildConfig.FLAVOR;
            if (uGCFilterResponse == null || (items = uGCFilterResponse.getItems()) == null) {
                str = BuildConfig.FLAVOR;
                str2 = str;
                str3 = str2;
            } else {
                UGCFilterFragment uGCFilterFragment = UGCFilterFragment.this;
                str = BuildConfig.FLAVOR;
                str2 = str;
                str3 = str2;
                for (UGCFilterItem uGCFilterItem : items) {
                    String categoryId = uGCFilterItem.getCategoryId();
                    Integer num = uGCFilterFragment.mSelectedLevel2;
                    if (Intrinsics.c(categoryId, num != null ? num.toString() : null) && (str = uGCFilterItem.getName()) == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    String categoryId2 = uGCFilterItem.getCategoryId();
                    Integer num2 = uGCFilterFragment.mSelectedLevel2;
                    if (Intrinsics.c(categoryId2, num2 != null ? num2.toString() : null)) {
                        str = uGCFilterItem.getName();
                        if (str == null) {
                            str = BuildConfig.FLAVOR;
                        }
                    } else {
                        Integer num3 = uGCFilterFragment.mSelectedLevel3;
                        if (Intrinsics.c(categoryId2, num3 != null ? num3.toString() : null)) {
                            str2 = uGCFilterItem.getName();
                            if (str2 == null) {
                                str2 = BuildConfig.FLAVOR;
                            }
                        } else {
                            Integer num4 = uGCFilterFragment.mSelectedLevel4;
                            if (Intrinsics.c(categoryId2, num4 != null ? num4.toString() : null) && (str3 = uGCFilterItem.getName()) == null) {
                                str3 = BuildConfig.FLAVOR;
                            }
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            UGCFilterFragment uGCFilterFragment2 = UGCFilterFragment.this;
            jSONObject.put("categoryLve2", str);
            jSONObject.put("categoryLve3", str2);
            jSONObject.put("categoryLve4", str3);
            String str8 = uGCFilterFragment2.mSelectedGrade;
            if (str8 == null) {
                str8 = BuildConfig.FLAVOR;
            }
            jSONObject.put("grade", str8);
            jSONObject.put("sort", uGCFilterFragment2.mCurrentTab.getApiValue());
            hashMap.put("rank_category", jSONObject.toString());
            String str9 = UGCFilterFragment.this.fromOptId;
            if (str9 == null) {
                str9 = BuildConfig.FLAVOR;
            }
            hashMap.put("from_opt_id", str9);
            hashMap.put("title", UGCFilterFragment.this.getString(R.string.filter));
            if (uGCFilterVideoItem == null || (content4 = uGCFilterVideoItem.getContent()) == null || (video4 = content4.getVideo()) == null || (belongToCollection = video4.getBelongToCollection()) == null || (str4 = belongToCollection.getCollectionId()) == null) {
                str4 = BuildConfig.FLAVOR;
            }
            hashMap.put("belong_to_collection_id", str4);
            if ((uGCFilterVideoItem == null || (content3 = uGCFilterVideoItem.getContent()) == null || (video3 = content3.getVideo()) == null || (str5 = video3.getUgcVideoId()) == null) && (uGCFilterVideoItem == null || (str5 = uGCFilterVideoItem.getVideoId()) == null)) {
                str5 = BuildConfig.FLAVOR;
            }
            hashMap.put("content_id", str5);
            if (uGCFilterVideoItem == null || (content2 = uGCFilterVideoItem.getContent()) == null || (video2 = content2.getVideo()) == null || (str6 = video2.getSubjectId()) == null) {
                str6 = BuildConfig.FLAVOR;
            }
            hashMap.put("refer_subject_id", str6);
            hashMap.put("content_type", "ugc_video");
            hashMap.put("position", String.valueOf(i4));
            if ((uGCFilterVideoItem != null && (ops = uGCFilterVideoItem.getOps()) != null) || (uGCFilterVideoItem != null && (content = uGCFilterVideoItem.getContent()) != null && (video = content.getVideo()) != null && (ops = video.getOps()) != null)) {
                str7 = ops;
            }
            hashMap.put("ops", str7);
            com.transsion.baselib.helper.a.a.e("/home/ugc_filter", hashMap);
        }
    }

    public static final class d extends DiffUtil.e {
        d() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(UGCFilterVideoItem uGCFilterVideoItem, UGCFilterVideoItem uGCFilterVideoItem2) {
            Intrinsics.h(uGCFilterVideoItem, "oldItem");
            Intrinsics.h(uGCFilterVideoItem2, "newItem");
            return Intrinsics.c(uGCFilterVideoItem.getVideoId(), uGCFilterVideoItem2.getVideoId()) && Intrinsics.c(uGCFilterVideoItem.getTitle(), uGCFilterVideoItem2.getTitle());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(UGCFilterVideoItem uGCFilterVideoItem, UGCFilterVideoItem uGCFilterVideoItem2) {
            Intrinsics.h(uGCFilterVideoItem, "oldItem");
            Intrinsics.h(uGCFilterVideoItem2, "newItem");
            return Intrinsics.c(uGCFilterVideoItem.getVideoId(), uGCFilterVideoItem2.getVideoId());
        }
    }

    public static final class e implements TabLayout.OnTabSelectedListener {
        e() {
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabSelected(TabLayout.Tab tab) {
            UGCFilterFragment uGCFilterFragment = UGCFilterFragment.this;
            int position = tab != null ? tab.getPosition() : 0;
            uGCFilterFragment.mCurrentTab = position != 0 ? position != 1 ? TabType.HOTTEST : TabType.LATEST : TabType.FOR_U;
            if (tab != null) {
                UGCFilterFragment.this.X0(tab, true);
            }
            rk.b bVar = UGCFilterFragment.this.mExposureHelper;
            if (bVar != null) {
                bVar.e();
            }
            UGCFilterFragment.this.mPage = 1;
            UGCFilterFragment.this.A1(true);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            if (tab != null) {
                UGCFilterFragment.this.X0(tab, false);
            }
        }
    }

    public static final class f extends RecyclerView.r {
        private int a;
        final /* synthetic */ View c;

        f(View view) {
            this.c = view;
        }

        private final void d(RecyclerView recyclerView) {
            OffsetGridLayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type com.transsion.home.view.layoutmanager.OffsetGridLayoutManager");
            this.a = layoutManager.findLastCompletelyVisibleItemPosition();
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            com.transsion.home.adapter.filter.a aVar;
            t6.f h0;
            t6.f h02;
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
            int itemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
            if (i != 0 || childCount <= 0 || this.a < itemCount - 1) {
                return;
            }
            com.transsion.home.adapter.filter.a aVar2 = UGCFilterFragment.this.mAdapter;
            if (((aVar2 == null || (h02 = aVar2.h0()) == null) ? null : h02.i()) != LoadMoreStatus.Fail || (aVar = UGCFilterFragment.this.mAdapter) == null || (h0 = aVar.h0()) == null) {
                return;
            }
            h0.w();
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            qk.a0 a0Var;
            ConstraintLayout constraintLayout;
            qk.a0 a0Var2;
            qk.a0 a0Var3;
            ConstraintLayout constraintLayout2;
            Intrinsics.h(recyclerView, "recyclerView");
            if (recyclerView.computeVerticalScrollOffset() > this.c.getMeasuredHeight()) {
                qk.m mVar = (qk.m) UGCFilterFragment.this.getMViewBinding();
                if (mVar != null && (a0Var3 = mVar.b) != null && (constraintLayout2 = a0Var3.c) != null) {
                    uf.c.k(constraintLayout2);
                }
                qk.m mVar2 = (qk.m) UGCFilterFragment.this.getMViewBinding();
                if (mVar2 != null && (a0Var2 = mVar2.b) != null) {
                    UGCFilterFragment uGCFilterFragment = UGCFilterFragment.this;
                    ConstraintLayout constraintLayout3 = a0Var2.c;
                    Intrinsics.g(constraintLayout3, "llTabFilter");
                    uf.c.k(constraintLayout3);
                    uGCFilterFragment.M1();
                }
            } else {
                qk.m mVar3 = (qk.m) UGCFilterFragment.this.getMViewBinding();
                if (mVar3 != null && (a0Var = mVar3.b) != null && (constraintLayout = a0Var.c) != null) {
                    uf.c.g(constraintLayout);
                }
            }
            d(recyclerView);
        }
    }

    public static final class g implements yg.m {
        g() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            boolean z;
            t6.f h0;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            if (UGCFilterFragment.this.isResumed()) {
                View view = UGCFilterFragment.this.mNoNetworkView;
                if (view != null) {
                    uf.c.g(view);
                }
                com.transsion.home.adapter.filter.a aVar = UGCFilterFragment.this.mAdapter;
                List data = aVar != null ? aVar.getData() : null;
                List list = data;
                if (list == null || list.isEmpty()) {
                    UGCFilterFragment.this.loadData();
                    return;
                }
                UGCFilterVideoItem uGCFilterVideoItem = (UGCFilterVideoItem) CollectionsKt.v0(data);
                boolean c = Intrinsics.c(uGCFilterVideoItem != null ? uGCFilterVideoItem.getChannelId() : null, UGCFilterFragment.this.mCategory);
                HashMap hashMap = UGCFilterFragment.this.mLatestSelectItems;
                if (hashMap != null) {
                    z = Intrinsics.c(uGCFilterVideoItem != null ? uGCFilterVideoItem.getSelectItems() : null, hashMap);
                } else {
                    z = false;
                }
                if (!c || !z) {
                    UGCFilterFragment.this.A1(true);
                    return;
                }
                com.transsion.home.adapter.filter.a aVar2 = UGCFilterFragment.this.mAdapter;
                if (aVar2 == null || (h0 = aVar2.h0()) == null) {
                    return;
                }
                h0.w();
            }
        }

        public void onDisconnected() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(boolean isRefresh) {
        wf.a.a.c("UGCFilterFragment", "loadDataWithCurrentFilter: page=" + this.mPage + ", level2=" + this.mSelectedLevel2 + ", level3=" + this.mSelectedLevel3 + ", level4=" + this.mSelectedLevel4 + ", sort=" + this.mCurrentTab.getApiValue() + ", isRefresh=" + isRefresh, false);
        this.mLatestSelectItems = new HashMap(Y0());
        if (isRefresh && !this.hasRecordedFirstLoadDuration && this.firstLoadStartTimeMillis == 0) {
            this.firstLoadStartTimeMillis = System.currentTimeMillis();
        }
        UGCFilterViewModel uGCFilterViewModel = this.mMovieModel;
        if (uGCFilterViewModel != null) {
            uGCFilterViewModel.m(this.mCategory, this.mPage, this.mPerPage, this.mCurrentTab.getApiValue(), this.mSelectedLevel2, this.mSelectedLevel3, this.mSelectedLevel4, this.mSelectedGrade, isRefresh);
        }
        if (isRefresh) {
            this.mPage = 2;
        } else {
            this.mPage++;
        }
    }

    private final void B1(UGCFilterItem ugcFilterItem) {
        wf.a.a.c("UGCFilterFragment", "onUGCFilterItemSelected: id=" + ugcFilterItem.getCategoryId() + ", name=" + ugcFilterItem.getName() + ", parentId=" + ugcFilterItem.getParentId(), false);
        C1(ugcFilterItem);
    }

    private final void C1(UGCFilterItem item) {
        com.transsion.baselib.helper.a.a.i("/home/ugc_filter", c1(item, "click_filter"));
    }

    private final void D1(TabLayout.Tab tab, String title, boolean selected) {
        LayoutInflater from = LayoutInflater.from(requireContext());
        int i = R.layout.item_home_filter_tab;
        i0 i0Var = this.headerBinding;
        if (i0Var == null) {
            Intrinsics.y("headerBinding");
            i0Var = null;
        }
        View inflate = from.inflate(i, (ViewGroup) i0Var.c, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_tab_title);
        textView.setText(title);
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        Typeface c2 = selected ? uf.a.c(requireContext) : uf.a.d(requireContext);
        if (c2 != null) {
            textView.setTypeface(c2);
        }
        textView.setTextColor(androidx.core.content.b.getColor(requireContext(), selected ? com.tn.lib.widget.R.color.text_01 : com.tn.lib.widget.R.color.text_02));
        if (selected) {
            inflate.setBackgroundResource(R$drawable.bg_item_filter_tab);
        } else {
            inflate.setBackgroundColor(0);
        }
        inflate.setSelected(selected);
        tab.setCustomView(inflate);
    }

    private final void E1() {
        if (this.mNoNetworkView == null) {
            i0 i0Var = this.headerBinding;
            if (i0Var == null) {
                Intrinsics.y("headerBinding");
                i0Var = null;
            }
            this.mNoNetworkView = i0Var.e.inflate();
        }
        View view = this.mNoNetworkView;
        if (view != null) {
            uf.c.k(view);
            final NoNetworkBigView findViewById = view.findViewById(R.id.state_view);
            if (findViewById != null) {
                NoNetworkBigView.showTitle$default(findViewById, false, (String) null, 2, (Object) null);
                findViewById.retry(new Function0() { // from class: com.transsion.home.fragment.filter.p
                    public final Object invoke() {
                        Unit F1;
                        F1 = UGCFilterFragment.F1(findViewById, this);
                        return F1;
                    }
                });
                findViewById.goToSetting(new Function0() { // from class: com.transsion.home.fragment.filter.q
                    public final Object invoke() {
                        Unit G1;
                        G1 = UGCFilterFragment.G1();
                        return G1;
                    }
                });
            }
            com.tn.lib.view.o.a("/home/ugc_filter");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(NoNetworkBigView noNetworkBigView, UGCFilterFragment uGCFilterFragment) {
        uf.c.g(noNetworkBigView);
        uGCFilterFragment.loadData();
        com.tn.lib.view.o.b("/home/ugc_filter");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G1() {
        com.tn.lib.view.o.c("/home/ugc_filter");
        return Unit.a;
    }

    private final void H1(String string) {
        if (this.mNoResultView == null) {
            i0 i0Var = this.headerBinding;
            if (i0Var == null) {
                Intrinsics.y("headerBinding");
                i0Var = null;
            }
            this.mNoResultView = i0Var.f.inflate();
        }
        final View view = this.mNoResultView;
        if (view != null) {
            uf.c.k(view);
            TextView textView = (TextView) view.findViewById(R.id.tv_no_result);
            if (textView != null) {
                textView.setText(string);
            }
            View findViewById = view.findViewById(R.id.tv_reset);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.filter.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        UGCFilterFragment.I1(UGCFilterFragment.this, view, view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(UGCFilterFragment uGCFilterFragment, View view, View view2) {
        uGCFilterFragment.mSelectedLevel2 = null;
        uGCFilterFragment.mSelectedLevel3 = null;
        uGCFilterFragment.mSelectedLevel4 = null;
        uGCFilterFragment.mFilterJson = BuildConfig.FLAVOR;
        uf.c.g(view);
        uGCFilterFragment.loadData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v5 */
    private final void J1() {
        List<UGCFilterItem> l;
        List<UGCFilterGrade> l2;
        UGCFilterResponse uGCFilterResponse = this.mFilterResponse;
        if (uGCFilterResponse == null || (l = uGCFilterResponse.getItems()) == null) {
            l = CollectionsKt.l();
        }
        UGCFilterExpandView uGCFilterExpandView = null;
        ?? r4 = 0;
        if (l.isEmpty()) {
            UGCFilterExpandView uGCFilterExpandView2 = this.filterView;
            if (uGCFilterExpandView2 == null) {
                Intrinsics.y("filterView");
            } else {
                r4 = uGCFilterExpandView2;
            }
            uf.c.g((View) r4);
            wf.a.a.w("UGCFilterFragment", "updateFilterViewData: no filter items", false);
            return;
        }
        Map c2 = MapsKt.c();
        Integer num = this.mSelectedLevel2;
        if (num != null) {
        }
        Integer num2 = this.mSelectedLevel3;
        if (num2 != null) {
        }
        Integer num3 = this.mSelectedLevel4;
        if (num3 != null) {
        }
        String str = this.mSelectedGrade;
        if (str != null) {
            c2.put("grade", str);
        }
        Map<String, String> b2 = MapsKt.b(c2);
        wf.a.a.c("UGCFilterFragment", "updateFilterViewData: items size=" + l.size() + ", selected=" + b2, false);
        UGCFilterExpandView uGCFilterExpandView3 = this.filterView;
        ?? r2 = uGCFilterExpandView3;
        if (uGCFilterExpandView3 == null) {
            Intrinsics.y("filterView");
            r2 = null;
        }
        uf.c.k((View) r2);
        UGCFilterExpandView uGCFilterExpandView4 = this.filterView;
        if (uGCFilterExpandView4 == null) {
            Intrinsics.y("filterView");
        } else {
            uGCFilterExpandView = uGCFilterExpandView4;
        }
        UGCFilterResponse uGCFilterResponse2 = this.mFilterResponse;
        if (uGCFilterResponse2 == null || (l2 = uGCFilterResponse2.getGrades()) == null) {
            l2 = CollectionsKt.l();
        }
        uGCFilterExpandView.updateList(l, MsgStyle.CUSTOM_BUTTON, b2, l2);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void K1(UGCContentList contentList, boolean isRefresh) {
        List<UGCFilterVideoItem> list;
        qk.m mVar;
        LinearLayout root;
        t6.f h0;
        t6.f h02;
        List data;
        com.transsion.home.adapter.filter.a aVar;
        t6.f h03;
        boolean z;
        com.transsion.home.adapter.filter.a aVar2;
        com.transsion.home.adapter.filter.a aVar3;
        UGCFilterVideoItem uGCFilterVideoItem;
        UGCContent content;
        UGCVideo video;
        SwipeRefreshLayout swipeRefreshLayout;
        qk.m mVar2;
        SwipeRefreshLayout swipeRefreshLayout2;
        Integer perPage;
        List items;
        wf.a.a.c("UGCFilterFragment", "updateMovieList: isRefresh=" + isRefresh + ", size=" + ((contentList == null || (items = contentList.getItems()) == null) ? 0 : items.size()), false);
        if (contentList != null) {
            Pager pager = contentList.getPager();
            this.mPerPage = (pager == null || (perPage = pager.getPerPage()) == null) ? 12 : perPage.intValue();
            List items2 = contentList.getItems();
            if (items2 != null) {
                List list2 = items2;
                ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(UGCFilterVideoItem.INSTANCE.b((UGCContent) it.next(), this.mCategory, Y0()));
                }
                list = CollectionsKt.U0(arrayList);
            } else {
                list = null;
            }
            if (isRefresh) {
                qk.m mVar3 = (qk.m) getMViewBinding();
                if (mVar3 != null && (swipeRefreshLayout = mVar3.d) != null && swipeRefreshLayout.isRefreshing() && (mVar2 = (qk.m) getMViewBinding()) != null && (swipeRefreshLayout2 = mVar2.d) != null) {
                    swipeRefreshLayout2.setRefreshing(false);
                }
                if (!Intrinsics.c((list == null || (uGCFilterVideoItem = (UGCFilterVideoItem) CollectionsKt.k0(list)) == null || (content = uGCFilterVideoItem.getContent()) == null || (video = content.getVideo()) == null) ? null : video.getCategory(), UGCVideoType.EDUCATION.getValue())) {
                    com.transsion.home.adapter.filter.a aVar4 = this.mAdapter;
                    if (!(aVar4 != null ? aVar4.getIsEducationList() : false)) {
                        z = false;
                        aVar2 = this.mAdapter;
                        if (aVar2 != null) {
                            aVar2.U1(z);
                        }
                        aVar3 = this.mAdapter;
                        if (aVar3 != null) {
                            aVar3.n1(list);
                        }
                        if (list == null && list.isEmpty()) {
                            h1();
                        } else {
                            H1(getString(R.string.no_filter_result));
                        }
                    }
                }
                z = true;
                aVar2 = this.mAdapter;
                if (aVar2 != null) {
                }
                aVar3 = this.mAdapter;
                if (aVar3 != null) {
                }
                if (list == null && list.isEmpty()) {
                }
            } else {
                com.transsion.home.adapter.filter.a aVar5 = this.mAdapter;
                List data2 = aVar5 != null ? aVar5.getData() : null;
                ArrayList arrayList2 = new ArrayList();
                if (list == null) {
                    list = CollectionsKt.l();
                }
                if (data2 != null && (data2.isEmpty() ^ true)) {
                    for (UGCFilterVideoItem uGCFilterVideoItem2 : list) {
                        if (!data2.contains(uGCFilterVideoItem2)) {
                            arrayList2.add(uGCFilterVideoItem2);
                        }
                    }
                } else {
                    arrayList2.addAll(list);
                }
                if (arrayList2.isEmpty()) {
                    com.transsion.home.adapter.filter.a aVar6 = this.mAdapter;
                    if (aVar6 != null && (h02 = aVar6.h0()) != null) {
                        t6.f.u(h02, false, 1, (Object) null);
                    }
                    wf.a.a.c("UGCFilterFragment", "updateMovieList: all items are duplicated", false);
                    return;
                }
                com.transsion.home.adapter.filter.a aVar7 = this.mAdapter;
                if (aVar7 != null) {
                    aVar7.q(arrayList2);
                }
                com.transsion.home.adapter.filter.a aVar8 = this.mAdapter;
                if (((aVar8 == null || (h0 = aVar8.h0()) == null || !h0.r()) ? false : true) && (mVar = (qk.m) getMViewBinding()) != null && (root = mVar.getRoot()) != null) {
                    root.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.filter.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            UGCFilterFragment.L1(UGCFilterFragment.this);
                        }
                    }, 300L);
                }
            }
            Pager pager2 = contentList.getPager();
            if ((pager2 != null ? Intrinsics.c(pager2.getHasMore(), Boolean.FALSE) : false) && (aVar = this.mAdapter) != null && (h03 = aVar.h0()) != null) {
                t6.f.u(h03, false, 1, (Object) null);
            }
            a.a aVar9 = wf.a.a;
            com.transsion.home.adapter.filter.a aVar10 = this.mAdapter;
            aVar9.c("UGCFilterFragment", "updateMovieList: final adapter size=" + ((aVar10 == null || (data = aVar10.getData()) == null) ? 0 : data.size()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(UGCFilterFragment uGCFilterFragment) {
        t6.f h0;
        com.transsion.home.adapter.filter.a aVar = uGCFilterFragment.mAdapter;
        if (aVar == null || (h0 = aVar.h0()) == null) {
            return;
        }
        h0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1() {
        qk.a0 a0Var;
        AppCompatTextView appCompatTextView;
        String b1;
        String a1;
        String a12;
        String a13;
        StringBuilder sb = new StringBuilder();
        Integer num = this.mSelectedLevel2;
        if (num != null && (a13 = a1(String.valueOf(num.intValue()))) != null && !Intrinsics.c(a13, getString(com.tn.lib.widget.R.string.all))) {
            sb.append(a13);
            sb.append(" • ");
        }
        Integer num2 = this.mSelectedLevel3;
        if (num2 != null && (a12 = a1(String.valueOf(num2.intValue()))) != null && !Intrinsics.c(a12, getString(com.tn.lib.widget.R.string.all))) {
            sb.append(a12);
            sb.append(" • ");
        }
        Integer num3 = this.mSelectedLevel4;
        if (num3 != null && (a1 = a1(String.valueOf(num3.intValue()))) != null && !Intrinsics.c(a1, getString(com.tn.lib.widget.R.string.all))) {
            sb.append(a1);
            sb.append(" • ");
        }
        String str = this.mSelectedGrade;
        if (str != null && (b1 = b1(str)) != null && !Intrinsics.c(b1, getString(com.tn.lib.widget.R.string.all))) {
            sb.append(b1);
            sb.append(" • ");
        }
        boolean c0 = StringsKt.c0(sb, " • ", false, 2, (Object) null);
        String str2 = sb;
        if (c0) {
            str2 = sb.substring(0, sb.length() - 2);
        }
        int length = str2.length();
        String str3 = str2;
        if (length == 0) {
            str3 = getString(com.tn.lib.widget.R.string.all);
        }
        qk.m mVar = (qk.m) getMViewBinding();
        if (mVar == null || (a0Var = mVar.b) == null || (appCompatTextView = a0Var.b) == null) {
            return;
        }
        appCompatTextView.setText(str3);
        uf.c.k(appCompatTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(TabLayout.Tab tab, boolean z) {
        View customView = tab.getCustomView();
        if (customView == null) {
            return;
        }
        customView.setSelected(z);
        TextView textView = (TextView) customView.findViewById(R.id.tv_tab_title);
        if (textView != null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            Typeface c2 = z ? uf.a.c(requireContext) : uf.a.d(requireContext);
            if (c2 != null) {
                textView.setTypeface(c2);
            }
            textView.setTextColor(androidx.core.content.b.getColor(requireContext(), z ? com.tn.lib.widget.R.color.text_01 : com.tn.lib.widget.R.color.text_02));
            if (z) {
                customView.setBackgroundResource(R$drawable.bg_item_filter_tab);
            } else {
                customView.setBackgroundColor(0);
            }
        }
    }

    private final Map Y0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Integer num = this.mSelectedLevel2;
        if (num != null) {
        }
        Integer num2 = this.mSelectedLevel3;
        if (num2 != null) {
        }
        Integer num3 = this.mSelectedLevel4;
        if (num3 != null) {
        }
        String str = this.mSelectedGrade;
        if (str != null) {
            linkedHashMap.put("grade", str);
        }
        return linkedHashMap;
    }

    private final void Z0() {
        Object obj = this.categoryChildrenByParentIdMap.get(MsgStyle.CUSTOM_BUTTON);
        if (obj == null) {
            obj = CollectionsKt.l();
        }
        if (((List) obj).isEmpty()) {
            return;
        }
        HashMap j1 = j1();
        if (this.mCurrentTab != TabType.FOR_U) {
            i0 i0Var = this.headerBinding;
            if (i0Var == null) {
                Intrinsics.y("headerBinding");
                i0Var = null;
            }
            TabLayout tabLayout = i0Var.g;
            if (tabLayout != null) {
                i0 i0Var2 = this.headerBinding;
                if (i0Var2 == null) {
                    Intrinsics.y("headerBinding");
                    i0Var2 = null;
                }
                TabLayout tabLayout2 = i0Var2.g;
                tabLayout.selectTab(tabLayout2 != null ? tabLayout2.getTabAt(this.mCurrentTab.ordinal()) : null);
            }
        }
        if (!j1.isEmpty()) {
            this.mFilterJson = BuildConfig.FLAVOR;
        }
        wf.a.a.c("UGCFilterFragment", "buildFilterView: level2=" + this.mSelectedLevel2 + ", level3=" + this.mSelectedLevel3 + ", level4=" + this.mSelectedLevel4, false);
        J1();
    }

    private final String a1(String categoryId) {
        List<UGCFilterItem> items;
        Object obj;
        UGCFilterResponse uGCFilterResponse = this.mFilterResponse;
        if (uGCFilterResponse != null && (items = uGCFilterResponse.getItems()) != null) {
            Iterator<T> it = items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.c(((UGCFilterItem) obj).getCategoryId(), categoryId)) {
                    break;
                }
            }
            UGCFilterItem uGCFilterItem = (UGCFilterItem) obj;
            if (uGCFilterItem != null) {
                return uGCFilterItem.getName();
            }
        }
        return null;
    }

    private final String b1(String gradeCode) {
        List<UGCFilterGrade> grades;
        Object obj;
        UGCFilterResponse uGCFilterResponse = this.mFilterResponse;
        if (uGCFilterResponse != null && (grades = uGCFilterResponse.getGrades()) != null) {
            Iterator<T> it = grades.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.c(((UGCFilterGrade) obj).getGrade(), gradeCode)) {
                    break;
                }
            }
            UGCFilterGrade uGCFilterGrade = (UGCFilterGrade) obj;
            if (uGCFilterGrade != null) {
                return uGCFilterGrade.getDescName();
            }
        }
        return null;
    }

    private final Map c1(UGCFilterItem item, String key) {
        List data;
        UGCFilterVideoItem uGCFilterVideoItem;
        String ops;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", key);
        String name = item.getName();
        String str = BuildConfig.FLAVOR;
        if (name == null) {
            name = BuildConfig.FLAVOR;
        }
        hashMap.put("title", name);
        String categoryId = item.getCategoryId();
        if (categoryId == null) {
            categoryId = BuildConfig.FLAVOR;
        }
        hashMap.put("category_id", categoryId);
        hashMap.put("tab_id", String.valueOf(getMTabId()));
        hashMap.put("rank_category", "btn");
        String str2 = this.fromOptId;
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        hashMap.put("from_opt_id", str2);
        com.transsion.home.adapter.filter.a aVar = this.mAdapter;
        if (aVar != null && (data = aVar.getData()) != null && (uGCFilterVideoItem = (UGCFilterVideoItem) CollectionsKt.k0(data)) != null && (ops = uGCFilterVideoItem.getOps()) != null) {
            str = ops;
        }
        hashMap.put("ops", str);
        return hashMap;
    }

    private final int d1() {
        return R.layout.home_empty_view_loading;
    }

    private final int e1() {
        FragmentActivity activity = getActivity();
        return (activity == null || !com.transsion.baseui.util.b.a(activity)) ? 2 : 3;
    }

    private final void g1() {
        View view = this.mLoadingView;
        if (view != null) {
            uf.c.g(view);
        }
    }

    private final void h1() {
        View view = this.mNoResultView;
        if (view != null) {
            uf.c.g(view);
        }
    }

    private final void i1() {
        Object obj = this.categoryChildrenByParentIdMap.get(MsgStyle.CUSTOM_BUTTON);
        if (obj == null) {
            obj = CollectionsKt.l();
        }
        List list = (List) obj;
        wf.a.a.c("UGCFilterFragment", "initChannelView: root categories size=" + list.size(), false);
        if (!list.isEmpty()) {
            Z0();
            A1(true);
            return;
        }
        LinearLayoutCompat linearLayoutCompat = this.filterView;
        if (linearLayoutCompat == null) {
            Intrinsics.y("filterView");
            linearLayoutCompat = null;
        }
        uf.c.g(linearLayoutCompat);
    }

    private final void initViewModel() {
        UGCFilterViewModel uGCFilterViewModel = this.mMovieModel;
        if (uGCFilterViewModel != null) {
            uGCFilterViewModel.j().j(this, new c0(new Function1() { // from class: com.transsion.home.fragment.filter.o
                public final Object invoke(Object obj) {
                    Unit w1;
                    w1 = UGCFilterFragment.w1(UGCFilterFragment.this, (BaseDto) obj);
                    return w1;
                }
            }));
            uGCFilterViewModel.n().j(this, new c0(new Function1() { // from class: com.transsion.home.fragment.filter.t
                public final Object invoke(Object obj) {
                    Unit y1;
                    y1 = UGCFilterFragment.y1(UGCFilterFragment.this, (RefreshBaseDto) obj);
                    return y1;
                }
            }));
            uGCFilterViewModel.l().j(this, new c0(new Function1() { // from class: com.transsion.home.fragment.filter.u
                public final Object invoke(Object obj) {
                    Unit z1;
                    z1 = UGCFilterFragment.z1(UGCFilterFragment.this, (UGCFilterItem) obj);
                    return z1;
                }
            }));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final HashMap j1() {
        HashMap hashMap = new HashMap();
        String str = this.mFilterJson;
        if (str != null && str.length() != 0) {
            try {
                String str2 = this.mFilterJson;
                if (str2 == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    if (next != null) {
                        int hashCode = next.hashCode();
                        if (hashCode != 3536286) {
                            if (hashCode != 98615255) {
                                switch (hashCode) {
                                    case 426008981:
                                        if (!next.equals("categoryLve2")) {
                                            break;
                                        } else {
                                            Intrinsics.e(string);
                                            this.mSelectedLevel2 = StringsKt.v(string);
                                            break;
                                        }
                                    case 426008982:
                                        if (!next.equals("categoryLve3")) {
                                            break;
                                        } else {
                                            Intrinsics.e(string);
                                            this.mSelectedLevel3 = StringsKt.v(string);
                                            break;
                                        }
                                    case 426008983:
                                        if (!next.equals("categoryLve4")) {
                                            break;
                                        } else {
                                            Intrinsics.e(string);
                                            this.mSelectedLevel4 = StringsKt.v(string);
                                            break;
                                        }
                                }
                            } else if (next.equals("grade")) {
                                this.mSelectedGrade = string;
                            }
                        } else if (next.equals("sort")) {
                            this.mCurrentTab = Intrinsics.c(string, "Latest") ? TabType.LATEST : Intrinsics.c(string, "New") ? TabType.HOTTEST : TabType.FOR_U;
                        }
                    }
                    hashMap.put(next, string);
                }
                wf.a.a.c("UGCFilterFragment", "initDefaultSelect: filterMap=" + hashMap, false);
            } catch (Exception e2) {
                wf.a.a.i("UGCFilterFragment", "initDefaultSelect: parse filterJson failed: " + e2.getMessage(), true);
            }
        }
        return hashMap;
    }

    private final void k1() {
        RecyclerView recyclerView;
        if (this.mExposureHelper == null) {
            rk.b bVar = new rk.b(0.6f, new c(), false, 4, null);
            bVar.l(2);
            qk.m mVar = (qk.m) getMViewBinding();
            if (mVar != null && (recyclerView = mVar.c) != null) {
                recyclerView.addOnScrollListener(bVar);
            }
            this.mExposureHelper = bVar;
        }
    }

    private final void l1() {
        UGCFilterExpandView uGCFilterExpandView = this.filterView;
        UGCFilterExpandView uGCFilterExpandView2 = null;
        if (uGCFilterExpandView == null) {
            Intrinsics.y("filterView");
            uGCFilterExpandView = null;
        }
        uGCFilterExpandView.setFilterViewModel(this.mMovieModel);
        UGCFilterExpandView uGCFilterExpandView3 = this.filterView;
        if (uGCFilterExpandView3 == null) {
            Intrinsics.y("filterView");
        } else {
            uGCFilterExpandView2 = uGCFilterExpandView3;
        }
        uGCFilterExpandView2.setOnSelectionChanged(new Function4() { // from class: com.transsion.home.fragment.filter.v
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit m1;
                m1 = UGCFilterFragment.m1(UGCFilterFragment.this, (String) obj, (String) obj2, (String) obj3, (String) obj4);
                return m1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        startLoading();
        wf.a.a.c("UGCFilterFragment", "loadData: category=" + this.mCategory, false);
        UGCFilterViewModel uGCFilterViewModel = this.mMovieModel;
        if (uGCFilterViewModel != null) {
            uGCFilterViewModel.i(this.mCategory);
        }
    }

    private final void loadMore() {
        A1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(UGCFilterFragment uGCFilterFragment, String str, String str2, String str3, String str4) {
        RecyclerView recyclerView;
        a.a aVar = wf.a.a;
        UGCFilterViewModel uGCFilterViewModel = uGCFilterFragment.mMovieModel;
        UGCFilterExpandView uGCFilterExpandView = null;
        UGCFilterItem h = uGCFilterViewModel != null ? uGCFilterViewModel.h(str) : null;
        UGCFilterViewModel uGCFilterViewModel2 = uGCFilterFragment.mMovieModel;
        UGCFilterItem h2 = uGCFilterViewModel2 != null ? uGCFilterViewModel2.h(str2) : null;
        UGCFilterViewModel uGCFilterViewModel3 = uGCFilterFragment.mMovieModel;
        aVar.c("UGCFilterFragment", "filter selection changed: lv2=" + str + " data=" + h + ", lv3=" + str2 + "  data=" + h2 + ", lv4=" + str3 + " selectedGradeId=" + str4 + " data=" + (uGCFilterViewModel3 != null ? uGCFilterViewModel3.h(str3) : null), false);
        uGCFilterFragment.mSelectedLevel2 = str != null ? StringsKt.v(str) : null;
        uGCFilterFragment.mSelectedLevel3 = str2 != null ? StringsKt.v(str2) : null;
        uGCFilterFragment.mSelectedLevel4 = str3 != null ? StringsKt.v(str3) : null;
        uGCFilterFragment.mSelectedGrade = str4;
        UGCFilterExpandView uGCFilterExpandView2 = uGCFilterFragment.filterView;
        if (uGCFilterExpandView2 == null) {
            Intrinsics.y("filterView");
            uGCFilterExpandView2 = null;
        }
        uGCFilterFragment.mSelectedGrade = uGCFilterExpandView2.getSelectedIds().get("grade");
        UGCFilterExpandView uGCFilterExpandView3 = uGCFilterFragment.filterView;
        if (uGCFilterExpandView3 == null) {
            Intrinsics.y("filterView");
        } else {
            uGCFilterExpandView = uGCFilterExpandView3;
        }
        uGCFilterExpandView.collapseAll();
        rk.b bVar = uGCFilterFragment.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
        uGCFilterFragment.mPage = 1;
        uGCFilterFragment.A1(true);
        qk.m mVar = (qk.m) uGCFilterFragment.getMViewBinding();
        if (mVar != null && (recyclerView = mVar.c) != null) {
            recyclerView.scrollToPosition(0);
        }
        return Unit.a;
    }

    private final void n1() {
        List<UGCFilterItem> items;
        this.categoryChildrenByParentIdMap.clear();
        UGCFilterResponse uGCFilterResponse = this.mFilterResponse;
        if (uGCFilterResponse == null || (items = uGCFilterResponse.getItems()) == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : items) {
            String parentId = ((UGCFilterItem) obj).getParentId();
            if (parentId == null) {
                parentId = MsgStyle.CUSTOM_BUTTON;
            }
            Object obj2 = linkedHashMap.get(parentId);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(parentId, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.categoryChildrenByParentIdMap.putAll(linkedHashMap);
        wf.a.a.c("UGCFilterFragment", "initFilterMap: tree size=" + this.categoryChildrenByParentIdMap.size(), false);
    }

    private final void o1() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        qk.m mVar;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        int e1 = e1();
        OffsetGridLayoutManager offsetGridLayoutManager = new OffsetGridLayoutManager(getContext(), e1, 1, false);
        qk.m mVar2 = (qk.m) getMViewBinding();
        if (mVar2 != null && (recyclerView4 = mVar2.c) != null) {
            recyclerView4.setLayoutManager(offsetGridLayoutManager);
        }
        com.transsion.home.adapter.filter.a aVar = new com.transsion.home.adapter.filter.a(new ArrayList(), this.mExposureHelper, null, e1, HomeTabId.INSTANCE.h(Integer.valueOf(getMTabId()), false) || StringsKt.H(UGCVideoType.EDUCATION.getValue(), this.mCategory, true));
        aVar.h0().z(true);
        aVar.h0().y(true);
        aVar.h0().D(new r6.f() { // from class: com.transsion.home.fragment.filter.w
            public final void a() {
                UGCFilterFragment.p1(UGCFilterFragment.this);
            }
        });
        aVar.R0(new d());
        aVar.w1(new r6.d() { // from class: com.transsion.home.fragment.filter.x
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                UGCFilterFragment.r1(UGCFilterFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mAdapter = aVar;
        qk.m mVar3 = (qk.m) getMViewBinding();
        if (mVar3 != null && (recyclerView2 = mVar3.c) != null && recyclerView2.getItemDecorationCount() < 1 && (mVar = (qk.m) getMViewBinding()) != null && (recyclerView3 = mVar.c) != null) {
            recyclerView3.addItemDecoration(new tf.b(com.blankj.utilcode.util.a0.a(4.0f), com.blankj.utilcode.util.a0.a(4.0f), com.blankj.utilcode.util.a0.a(16.0f), com.blankj.utilcode.util.a0.a(16.0f)));
        }
        qk.m mVar4 = (qk.m) getMViewBinding();
        if (mVar4 == null || (recyclerView = mVar4.c) == null) {
            return;
        }
        recyclerView.setAdapter(this.mAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(final UGCFilterFragment uGCFilterFragment) {
        RecyclerView recyclerView;
        if (yg.l.a.e()) {
            uGCFilterFragment.loadMore();
            return;
        }
        fh.b.a.d(com.tn.lib.widget.R.string.no_network_toast);
        qk.m mVar = (qk.m) uGCFilterFragment.getMViewBinding();
        if (mVar == null || (recyclerView = mVar.c) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.filter.b0
            @Override // java.lang.Runnable
            public final void run() {
                UGCFilterFragment.q1(UGCFilterFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(UGCFilterFragment uGCFilterFragment) {
        t6.f h0;
        com.transsion.home.adapter.filter.a aVar = uGCFilterFragment.mAdapter;
        if (aVar == null || (h0 = aVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(UGCFilterFragment uGCFilterFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        String str2;
        UGCVideoBelongToCollection belongToCollection;
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof UGCFilterVideoItem) {
            UGCFilterVideoItem uGCFilterVideoItem = (UGCFilterVideoItem) item;
            wf.a.a.c("UGCFilterFragment", "click ugc video: id=" + uGCFilterVideoItem.getVideoId() + ", title=" + uGCFilterVideoItem.getTitle(), false);
            gu.c.f(uGCFilterVideoItem.getContent(), (Integer) null, (String) null, 3, (Object) null);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "item");
            hashMap.put("rank_category", "item");
            String str3 = uGCFilterFragment.fromOptId;
            String str4 = BuildConfig.FLAVOR;
            if (str3 == null) {
                str3 = BuildConfig.FLAVOR;
            }
            hashMap.put("from_opt_id", str3);
            UGCVideo video = uGCFilterVideoItem.getContent().getVideo();
            if (video == null || (belongToCollection = video.getBelongToCollection()) == null || (str = belongToCollection.getCollectionId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("belong_to_collection_id", str);
            String videoId = uGCFilterVideoItem.getVideoId();
            if (videoId == null) {
                videoId = BuildConfig.FLAVOR;
            }
            hashMap.put("content_id", videoId);
            UGCVideo video2 = uGCFilterVideoItem.getContent().getVideo();
            if (video2 == null || (str2 = video2.getSubjectId()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("refer_subject_id", str2);
            hashMap.put("content_type", "ugc_video");
            hashMap.put("position", String.valueOf(i));
            String ops = uGCFilterVideoItem.getOps();
            if (ops != null) {
                str4 = ops;
            }
            hashMap.put("ops", str4);
            com.transsion.baselib.helper.a.a.f("/home/ugc_filter", hashMap);
        }
    }

    private final void s1(View headerView) {
        i0 i0Var = this.headerBinding;
        i0 i0Var2 = null;
        if (i0Var == null) {
            Intrinsics.y("headerBinding");
            i0Var = null;
        }
        ConstraintLayout constraintLayout = i0Var.c;
        Intrinsics.g(constraintLayout, "llTabMovie");
        i0 i0Var3 = this.headerBinding;
        if (i0Var3 == null) {
            Intrinsics.y("headerBinding");
        } else {
            i0Var2 = i0Var3;
        }
        TabLayout tabLayout = i0Var2.g;
        Intrinsics.g(tabLayout, "tabMovie");
        uf.c.k(constraintLayout);
        tabLayout.removeAllTabs();
        int i = 0;
        for (Object obj : CollectionsKt.o(new String[]{getString(R.string.item_filter_for_u), getString(R.string.item_filter_latest), getString(R.string.item_filter_hottest)})) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            String str = (String) obj;
            int i3 = b.a[this.mCurrentTab.ordinal()];
            boolean z = true;
            if (i3 == 1) {
                if (i == 0) {
                    TabLayout.Tab newTab = tabLayout.newTab();
                    Intrinsics.g(newTab, "newTab(...)");
                    Intrinsics.e(str);
                    D1(newTab, str, z);
                    tabLayout.addTab(newTab, z);
                    i = i2;
                }
                z = false;
                TabLayout.Tab newTab2 = tabLayout.newTab();
                Intrinsics.g(newTab2, "newTab(...)");
                Intrinsics.e(str);
                D1(newTab2, str, z);
                tabLayout.addTab(newTab2, z);
                i = i2;
            } else if (i3 == 2) {
                if (i == 1) {
                    TabLayout.Tab newTab22 = tabLayout.newTab();
                    Intrinsics.g(newTab22, "newTab(...)");
                    Intrinsics.e(str);
                    D1(newTab22, str, z);
                    tabLayout.addTab(newTab22, z);
                    i = i2;
                }
                z = false;
                TabLayout.Tab newTab222 = tabLayout.newTab();
                Intrinsics.g(newTab222, "newTab(...)");
                Intrinsics.e(str);
                D1(newTab222, str, z);
                tabLayout.addTab(newTab222, z);
                i = i2;
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (i == 2) {
                    TabLayout.Tab newTab2222 = tabLayout.newTab();
                    Intrinsics.g(newTab2222, "newTab(...)");
                    Intrinsics.e(str);
                    D1(newTab2222, str, z);
                    tabLayout.addTab(newTab2222, z);
                    i = i2;
                }
                z = false;
                TabLayout.Tab newTab22222 = tabLayout.newTab();
                Intrinsics.g(newTab22222, "newTab(...)");
                Intrinsics.e(str);
                D1(newTab22222, str, z);
                tabLayout.addTab(newTab22222, z);
                i = i2;
            }
        }
        tabLayout.addOnTabSelectedListener(new e());
    }

    private final void showLoadingView() {
        i0 i0Var = this.headerBinding;
        if (i0Var == null) {
            Intrinsics.y("headerBinding");
            i0Var = null;
        }
        ViewStub viewStub = i0Var.d;
        Intrinsics.g(viewStub, "loadingStub");
        viewStub.setLayoutResource(d1());
        if (this.mLoadingView == null) {
            this.mLoadingView = viewStub.inflate();
        }
        View view = this.mLoadingView;
        if (view != null) {
            uf.c.k(view);
        }
    }

    private final void t1(View header) {
        qk.a0 a0Var;
        ConstraintLayout constraintLayout;
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        qk.m mVar = (qk.m) getMViewBinding();
        if (mVar != null && (swipeRefreshLayout2 = mVar.d) != null) {
            swipeRefreshLayout2.setEnabled(false);
        }
        qk.m mVar2 = (qk.m) getMViewBinding();
        if (mVar2 != null && (swipeRefreshLayout = mVar2.d) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.home.fragment.filter.y
                public final void a() {
                    UGCFilterFragment.u1(UGCFilterFragment.this);
                }
            });
        }
        qk.m mVar3 = (qk.m) getMViewBinding();
        if (mVar3 != null && (recyclerView = mVar3.c) != null) {
            recyclerView.addOnScrollListener(new f(header));
        }
        qk.m mVar4 = (qk.m) getMViewBinding();
        if (mVar4 == null || (a0Var = mVar4.b) == null || (constraintLayout = a0Var.c) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.filter.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCFilterFragment.v1(UGCFilterFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(UGCFilterFragment uGCFilterFragment) {
        uGCFilterFragment.c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(UGCFilterFragment uGCFilterFragment, View view) {
        RecyclerView recyclerView;
        qk.m mVar = (qk.m) uGCFilterFragment.getMViewBinding();
        if (mVar == null || (recyclerView = mVar.c) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(final UGCFilterFragment uGCFilterFragment, BaseDto baseDto) {
        SwipeRefreshLayout swipeRefreshLayout;
        List<UGCFilterItem> items;
        if (baseDto == null || !Intrinsics.c(baseDto.getCode(), "0")) {
            qk.m mVar = (qk.m) uGCFilterFragment.getMViewBinding();
            if (mVar != null && (swipeRefreshLayout = mVar.d) != null) {
                swipeRefreshLayout.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.filter.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        UGCFilterFragment.x1(UGCFilterFragment.this);
                    }
                }, 200L);
            }
            wf.a.a.i("UGCFilterFragment", "getFilterItems failed: code=" + (baseDto != null ? baseDto.getCode() : null) + ", msg=" + (baseDto != null ? baseDto.getMsg() : null), true);
            return Unit.a;
        }
        a.a aVar = wf.a.a;
        UGCFilterResponse uGCFilterResponse = (UGCFilterResponse) baseDto.getData();
        aVar.c("UGCFilterFragment", "getFilterItems success: items size=" + ((uGCFilterResponse == null || (items = uGCFilterResponse.getItems()) == null) ? 0 : items.size()), false);
        UGCFilterResponse uGCFilterResponse2 = (UGCFilterResponse) baseDto.getData();
        if (uGCFilterResponse2 != null) {
            uGCFilterFragment.hideLoading();
            uGCFilterFragment.mFilterResponse = uGCFilterResponse2;
            uGCFilterFragment.n1();
            uGCFilterFragment.i1();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(UGCFilterFragment uGCFilterFragment) {
        if (!uGCFilterFragment.isAdded() || uGCFilterFragment.isDetached() || uGCFilterFragment.isRemoving()) {
            return;
        }
        uGCFilterFragment.hideLoading();
        uGCFilterFragment.H1(uGCFilterFragment.getString(com.transsnet.downloader.R.string.str_ad_video_error_tips));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(UGCFilterFragment uGCFilterFragment, RefreshBaseDto refreshBaseDto) {
        t6.f h0;
        com.transsion.home.adapter.filter.a aVar;
        t6.f h02;
        List data;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        HashMap g2;
        List items;
        UGCContent uGCContent;
        UGCVideo video;
        List data2;
        HashMap g3;
        List items2;
        UGCContent uGCContent2;
        UGCVideo video2;
        SwipeRefreshLayout swipeRefreshLayout3;
        qk.m mVar = (qk.m) uGCFilterFragment.getMViewBinding();
        if (mVar != null && (swipeRefreshLayout3 = mVar.d) != null) {
            swipeRefreshLayout3.setEnabled(true);
        }
        if (refreshBaseDto == null || !Intrinsics.c(refreshBaseDto.getCode(), "0")) {
            if (refreshBaseDto == null || !refreshBaseDto.getIsRefresh()) {
                com.transsion.home.adapter.filter.a aVar2 = uGCFilterFragment.mAdapter;
                if (aVar2 != null && (h0 = aVar2.h0()) != null && h0.r() && (aVar = uGCFilterFragment.mAdapter) != null && (h02 = aVar.h0()) != null) {
                    h02.v();
                }
            } else {
                qk.m mVar2 = (qk.m) uGCFilterFragment.getMViewBinding();
                if (mVar2 != null && (swipeRefreshLayout = mVar2.d) != null && swipeRefreshLayout.isRefreshing()) {
                    qk.m mVar3 = (qk.m) uGCFilterFragment.getMViewBinding();
                    if (mVar3 != null && (swipeRefreshLayout2 = mVar3.d) != null) {
                        swipeRefreshLayout2.setRefreshing(false);
                    }
                    uGCFilterFragment.n0();
                }
            }
            com.transsion.home.adapter.filter.a aVar3 = uGCFilterFragment.mAdapter;
            if (aVar3 != null && (data = aVar3.getData()) != null && data.size() == 0) {
                if (yg.l.a.e()) {
                    uGCFilterFragment.H1(uGCFilterFragment.getString(com.transsnet.downloader.R.string.str_ad_video_error_tips));
                } else {
                    uGCFilterFragment.E1();
                }
                return Unit.a;
            }
            if (yg.l.a.e()) {
                fh.b.a.d(com.transsnet.downloader.R.string.str_ad_video_error_tips);
            } else {
                fh.b.a.d(com.tn.lib.widget.R.string.no_network_toast);
            }
            wf.a.a.i("UGCFilterFragment", "getUGCContentList failed: code=" + (refreshBaseDto != null ? refreshBaseDto.getCode() : null) + ", msg=" + (refreshBaseDto != null ? refreshBaseDto.getMsg() : null), true);
            return Unit.a;
        }
        qi.b logViewConfig = uGCFilterFragment.getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        com.transsion.home.adapter.filter.a aVar4 = uGCFilterFragment.mAdapter;
        if (aVar4 == null || (data2 = aVar4.getData()) == null || !data2.isEmpty() || uGCFilterFragment.hasRecordedFirstLoadDuration || uGCFilterFragment.firstLoadStartTimeMillis <= 0) {
            qi.b logViewConfig2 = uGCFilterFragment.getLogViewConfig();
            if (logViewConfig2 != null && (g2 = logViewConfig2.g()) != null) {
                UGCContentList uGCContentList = (UGCContentList) refreshBaseDto.getData();
                if (uGCContentList != null && (items = uGCContentList.getItems()) != null && (uGCContent = (UGCContent) CollectionsKt.k0(items)) != null && (video = uGCContent.getVideo()) != null) {
                    r0 = video.getOps();
                }
                g2.put("ops", r0);
            }
        } else {
            long currentTimeMillis = System.currentTimeMillis() - uGCFilterFragment.firstLoadStartTimeMillis;
            qi.b logViewConfig3 = uGCFilterFragment.getLogViewConfig();
            if (logViewConfig3 != null && (g3 = logViewConfig3.g()) != null) {
                g3.put("load_duration", String.valueOf(currentTimeMillis));
                UGCContentList uGCContentList2 = (UGCContentList) refreshBaseDto.getData();
                if (uGCContentList2 != null && (items2 = uGCContentList2.getItems()) != null && (uGCContent2 = (UGCContent) CollectionsKt.k0(items2)) != null && (video2 = uGCContent2.getVideo()) != null) {
                    r0 = video2.getOps();
                }
                g3.put("ops", r0);
            }
            uGCFilterFragment.hasRecordedFirstLoadDuration = true;
        }
        UGCContentList uGCContentList3 = (UGCContentList) refreshBaseDto.getData();
        if (uGCContentList3 != null) {
            uGCFilterFragment.K1(uGCContentList3, refreshBaseDto.getIsRefresh());
            View view = uGCFilterFragment.mNoNetworkView;
            if (view != null) {
                uf.c.g(view);
            }
        }
        uGCFilterFragment.hideLoading();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(UGCFilterFragment uGCFilterFragment, UGCFilterItem uGCFilterItem) {
        if (uGCFilterItem != null) {
            wf.a.a.c("UGCFilterFragment", "selectFilterItemLiveData changed: id=" + uGCFilterItem.getCategoryId() + ", name=" + uGCFilterItem.getName(), false);
            uGCFilterFragment.B1(uGCFilterItem);
            rk.b bVar = uGCFilterFragment.mExposureHelper;
            if (bVar != null) {
                bVar.e();
            }
        }
        return Unit.a;
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void c0() {
        super.c0();
        this.mPage = 1;
        A1(true);
        rk.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public RecyclerView f0() {
        qk.m mVar = (qk.m) getMViewBinding();
        if (mVar != null) {
            return mVar.c;
        }
        return null;
    }

    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public qk.m getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        qk.m c2 = qk.m.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public String g0() {
        int e1 = e1();
        return e1 != 2 ? e1 != 3 ? "HomeFragmentListLinearTemplateAd" : "HomeFragmentListGrid3TemplateAd" : "HomeFragmentListGrid2TemplateAd";
    }

    public void hideLoading() {
        g1();
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void initView(View view, Bundle savedInstanceState) {
        qk.a0 a0Var;
        ConstraintLayout constraintLayout;
        Intrinsics.h(view, "view");
        super.initView(view, savedInstanceState);
        this.mMovieModel = new v0(this).a(UGCFilterViewModel.class);
        i0 i0Var = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ugc_header_filter, (ViewGroup) null);
        i0 a = i0.a(inflate);
        this.headerBinding = a;
        if (a == null) {
            Intrinsics.y("headerBinding");
        } else {
            i0Var = a;
        }
        this.filterView = i0Var.b;
        l1();
        Intrinsics.e(inflate);
        s1(inflate);
        k1();
        o1();
        t1(inflate);
        com.transsion.home.adapter.filter.a aVar = this.mAdapter;
        if (aVar != null) {
            BaseQuickAdapter.y(aVar, inflate, 0, 0, 6, (Object) null);
        }
        initViewModel();
        setNetListener(new g());
        this.header = inflate;
        int color = androidx.core.content.b.getColor(requireContext(), com.tn.lib.widget.R.color.module_01);
        qk.m mVar = (qk.m) getMViewBinding();
        if (mVar == null || (a0Var = mVar.b) == null || (constraintLayout = a0Var.c) == null) {
            return;
        }
        constraintLayout.setBackgroundColor(color);
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void l0(int lastAdPosition, BiddingNativeManager wrapperNativeManager) {
        List data;
        List data2;
        Intrinsics.h(wrapperNativeManager, "wrapperNativeManager");
        if (wrapperNativeManager != null) {
            UGCFilterVideoItem a = UGCFilterVideoItem.INSTANCE.a(wrapperNativeManager, this.mCategory, Y0());
            com.transsion.home.adapter.filter.a aVar = this.mAdapter;
            int size = (aVar == null || (data2 = aVar.getData()) == null) ? 0 : data2.size();
            if (lastAdPosition < 0 || lastAdPosition > size) {
                com.transsion.home.adapter.filter.a aVar2 = this.mAdapter;
                if (aVar2 != null) {
                    aVar2.p(a);
                }
            } else {
                com.transsion.home.adapter.filter.a aVar3 = this.mAdapter;
                if (aVar3 != null) {
                    aVar3.n(lastAdPosition, a);
                }
            }
            a.a aVar4 = wf.a.a;
            com.transsion.home.adapter.filter.a aVar5 = this.mAdapter;
            aVar4.c("UGCFilterFragment", "onAdCallback: insert ad at position=" + lastAdPosition + ", total size=" + ((aVar5 == null || (data = aVar5.getData()) == null) ? null : Integer.valueOf(data.size())), false);
        }
    }

    public void lazyLoadData() {
        loadData();
    }

    public qi.b newLogViewConfig() {
        return new qi.b("/home/ugc_filter", false, 2, null);
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        HashMap g2;
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("category")) == null) {
            str = "Education";
        }
        this.mCategory = str;
        if (str.length() == 0) {
            this.mCategory = "Education";
        }
        Bundle arguments2 = getArguments();
        String str3 = BuildConfig.FLAVOR;
        if (arguments2 == null || (str2 = arguments2.getString("filter_json")) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        this.mFilterJson = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 != null && (string = arguments3.getString("fromOptId")) != null) {
            str3 = string;
        }
        this.fromOptId = str3;
        wf.a.a.c("UGCFilterFragment", "onCreate: category=" + this.mCategory + ", filterJson=" + this.mFilterJson, false);
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g2 = logViewConfig.g()) == null) {
            return;
        }
        g2.put("page_from", qi.h.a.h());
        g2.put("from_opt_id", this.fromOptId);
    }

    public void onDestroyView() {
        androidx.lifecycle.b0 o;
        androidx.lifecycle.b0 k;
        this.mPage = 1;
        UGCFilterViewModel uGCFilterViewModel = this.mMovieModel;
        if (uGCFilterViewModel != null && (k = uGCFilterViewModel.k()) != null) {
            k.q((Object) null);
        }
        UGCFilterViewModel uGCFilterViewModel2 = this.mMovieModel;
        if (uGCFilterViewModel2 != null && (o = uGCFilterViewModel2.o()) != null) {
            o.q((Object) null);
        }
        wf.a.a.c("UGCFilterFragment", "onDestroyView: clear data", false);
        super.onDestroyView();
    }

    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        com.transsion.baseui.activity.k.h(null, this, hidden, "tabId=" + getMTabId(), 1, null);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                logResume();
            }
        }
    }

    public void onPause() {
        super.onPause();
        rk.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
        com.transsion.baseui.activity.k.l(null, this, "tabId=" + getMTabId(), 1, null);
    }

    public void onResume() {
        com.transsion.home.adapter.filter.a aVar;
        List data;
        super.onResume();
        View view = this.mNoNetworkView;
        if (view != null && uf.c.i(view) && yg.l.a.e() && (aVar = this.mAdapter) != null && (data = aVar.getData()) != null && data.isEmpty()) {
            View view2 = this.mNoNetworkView;
            if (view2 != null) {
                uf.c.g(view2);
            }
            loadData();
        }
        com.transsion.baseui.activity.k.p(null, this, "tabId=" + getMTabId() + " visible=" + isVisible(), 1, null);
    }

    public void startLoading() {
        showLoadingView();
    }
}
