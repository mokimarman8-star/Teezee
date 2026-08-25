package com.transsion.home.fragment.tab;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.d;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.tn.lib.view.DefaultView;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.view.o;
import com.tn.lib.widget.R$mipmap;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.home.R$id;
import com.transsion.home.adapter.trending.BannerADDataHelper;
import com.transsion.home.adapter.trending.provider.e;
import com.transsion.home.bean.BannerBean;
import com.transsion.home.bean.CustomData;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.LiveListItem;
import com.transsion.home.bean.MainOperateData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingData;
import com.transsion.home.bean.RankingListData;
import com.transsion.home.bean.SingleImagePage;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.home.bean.TrendingRespItemType;
import com.transsion.home.fragment.home.HomeFragment;
import com.transsion.home.fragment.tab.TrendingFragment$handleOpList$;
import com.transsion.home.viewmodel.HomePreferencesViewModel;
import com.transsion.home.viewmodel.TrendingViewModel;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$string;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.wrapperad.view.BiddingFloatingIrregularView;
import com.transsion.wrapperad.view.secondfloor.CustomSwipeRefreshLayout;
import ep.k;
import im.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kk.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import qk.h0;
import qk.x;
import rk.b;
import rk.c;
import tf.h;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0016\b\u0007\u0018\u0000 É\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002Ê\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0019\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J!\u0010\u001b\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002¢\u0006\u0004\b!\u0010\"J%\u0010&\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0#2\u0006\u0010%\u001a\u00020\u001eH\u0002¢\u0006\u0004\b&\u0010'J\u001d\u0010)\u001a\u00020\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020 0#H\u0002¢\u0006\u0004\b)\u0010*J!\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010#2\u0006\u0010+\u001a\u00020 H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u0010\u0005J\u000f\u00103\u001a\u00020/H\u0002¢\u0006\u0004\b3\u00101J\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0005J\u0017\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\u0005J#\u0010<\u001a\u00020\u00062\b\b\u0002\u0010:\u001a\u00020\n2\b\b\u0002\u0010;\u001a\u000205H\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020>H\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\nH\u0002¢\u0006\u0004\bD\u0010EJ\u001f\u0010G\u001a\u00020\n2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001dH\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010\u0005J\u000f\u0010J\u001a\u00020\nH\u0002¢\u0006\u0004\bJ\u0010EJ\u000f\u0010K\u001a\u000205H\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u0006H\u0002¢\u0006\u0004\bM\u0010\u0005J\u001d\u0010N\u001a\u0002052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020 0\u001dH\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0006H\u0002¢\u0006\u0004\bP\u0010\u0005J\u000f\u0010Q\u001a\u00020\u0006H\u0002¢\u0006\u0004\bQ\u0010\u0005J\u000f\u0010R\u001a\u00020\u0006H\u0002¢\u0006\u0004\bR\u0010\u0005J\u000f\u0010S\u001a\u00020\u0006H\u0002¢\u0006\u0004\bS\u0010\u0005J\u000f\u0010T\u001a\u00020\u0006H\u0002¢\u0006\u0004\bT\u0010\u0005J\u0019\u0010W\u001a\u00020\u00062\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bW\u0010XJ\u0017\u0010[\u001a\u00020\u00022\u0006\u0010Z\u001a\u00020YH\u0016¢\u0006\u0004\b[\u0010\\J\u0017\u0010_\u001a\u00020\u00062\u0006\u0010^\u001a\u00020]H\u0016¢\u0006\u0004\b_\u0010`J!\u0010b\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00122\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bb\u0010cJ\u0017\u0010e\u001a\u00020\u00062\u0006\u0010d\u001a\u00020UH\u0016¢\u0006\u0004\be\u0010XJ!\u0010f\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00122\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bf\u0010cJ\u0017\u0010h\u001a\u00020\u00062\u0006\u0010g\u001a\u00020\nH\u0016¢\u0006\u0004\bh\u0010\rJ\u000f\u0010i\u001a\u00020\u0006H\u0016¢\u0006\u0004\bi\u0010\u0005J\u000f\u0010j\u001a\u00020\u0006H\u0016¢\u0006\u0004\bj\u0010\u0005J\r\u0010k\u001a\u00020\u0006¢\u0006\u0004\bk\u0010\u0005J\u000f\u0010l\u001a\u00020\u0006H\u0016¢\u0006\u0004\bl\u0010\u0005J\u000f\u0010m\u001a\u00020\u0006H\u0016¢\u0006\u0004\bm\u0010\u0005J\u000f\u0010n\u001a\u00020\u0006H\u0016¢\u0006\u0004\bn\u0010\u0005J\u000f\u0010p\u001a\u00020oH\u0016¢\u0006\u0004\bp\u0010qJ\u000f\u0010r\u001a\u00020\u0006H\u0016¢\u0006\u0004\br\u0010\u0005J\u000f\u0010s\u001a\u00020\u0006H\u0016¢\u0006\u0004\bs\u0010\u0005J\u000f\u0010t\u001a\u00020/H\u0016¢\u0006\u0004\bt\u00101J\u0011\u0010v\u001a\u0004\u0018\u00010uH\u0016¢\u0006\u0004\bv\u0010wJ\u001f\u0010{\u001a\u00020\u00062\u0006\u0010x\u001a\u0002052\u0006\u0010z\u001a\u00020yH\u0016¢\u0006\u0004\b{\u0010|J\u000f\u0010}\u001a\u00020\u0006H\u0016¢\u0006\u0004\b}\u0010\u0005J\r\u0010~\u001a\u00020\u0006¢\u0006\u0004\b~\u0010\u0005R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0085\u0001\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0088\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010\u0090\u0001\u001a\u00030\u008d\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R,\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u009c\u0001\u001a\u00030\u0099\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009e\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u0087\u0001R\u001c\u0010¢\u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001b\u0010¤\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010\u0084\u0001R#\u0010ª\u0001\u001a\u0005\u0018\u00010¥\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001R!\u0010¯\u0001\u001a\u00030«\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¬\u0001\u0010§\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001R(\u0010³\u0001\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010°\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R)\u0010¸\u0001\u001a\u0012\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020/0µ\u0001\u0018\u00010´\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R1\u0010º\u0001\u001a\u001c\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060°\u0001\u0012\u0004\u0012\u00020\u00060°\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010²\u0001R\u001b\u0010½\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u0019\u0010¿\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010\u0087\u0001R\u0019\u0010Á\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010\u0087\u0001R\u0019\u0010Ä\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u0019\u0010Æ\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Ã\u0001R\u0018\u0010È\u0001\u001a\u00030\u0099\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010\u009b\u0001¨\u0006Ë\u0001"}, d2 = {"Lcom/transsion/home/fragment/tab/TrendingFragment;", "Lcom/transsion/home/fragment/tab/BaseHomeSubFragment;", "Lqk/x;", "Lim/f;", "<init>", "()V", "", "L1", "initViewModel", "i1", "", "showProgress", "W1", "(Z)V", "n2", "showEmpty", "Landroid/content/Context;", "context", "Landroid/view/View;", "getEmptyView", "(Landroid/content/Context;)Landroid/view/View;", "t1", "hideProgress", "Z1", "Lcom/transsion/home/bean/TrendingRespData;", "baseBean", "isRefresh", "p2", "(Lcom/transsion/home/bean/TrendingRespData;Z)V", "", "Lcom/transsion/home/bean/TrendingRespItem;", "feedsList", "Lcom/transsion/home/bean/OperateItem;", "i2", "(Ljava/util/List;)Ljava/util/List;", "", "newList", "item", "f1", "(Ljava/util/List;Lcom/transsion/home/bean/TrendingRespItem;)V", "opreateItems", "E1", "(Ljava/util/List;)V", "it", "Lcom/transsion/home/bean/BannerData;", "F1", "(Lcom/transsion/home/bean/OperateItem;)Ljava/util/List;", "", "B1", "()Ljava/lang/String;", "initExposureHelper", "getPageName", "n1", "", "position", "j2", "(I)V", "g1", "hasTopBanner", "retryCount", "p1", "(ZI)V", "", "alpha", "m2", "(F)V", "x1", "()F", "H1", "()Z", "items", "I1", "(Ljava/util/List;)Z", "V1", "G1", "A1", "()I", "h2", "z1", "(Ljava/util/List;)I", "initAd", "a2", "Y1", "e2", "h1", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "D1", "(Landroid/view/LayoutInflater;)Lqk/x;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onViewCreated", "hidden", "onHiddenChanged", "logResume", "p0", "f2", "lazyLoadData", "onDestroyView", "onDestroy", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "onResume", "onPause", "g0", "Landroidx/recyclerview/widget/RecyclerView;", "f0", "()Landroidx/recyclerview/widget/RecyclerView;", "lastAdPosition", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "wrapperNativeManager", "l0", "(ILcom/transsion/ad/bidding/nativead/BiddingNativeManager;)V", "c0", "k2", "Lrk/b;", "g", "Lrk/b;", "exposureHelper", "h", "Ljava/lang/String;", "nextPage", "i", "I", "mPerPage", "Lcom/transsion/home/viewmodel/TrendingViewModel;", "j", "Lcom/transsion/home/viewmodel/TrendingViewModel;", "mPostListModel", "Lcom/transsion/home/adapter/trending/b;", "k", "Lcom/transsion/home/adapter/trending/b;", "mAdapter", "Lrk/c;", "l", "Lrk/c;", "C1", "()Lrk/c;", "setPostListReport", "(Lrk/c;)V", "postListReport", "Landroid/os/Handler;", "m", "Landroid/os/Handler;", "mHandler", "n", "mHeaderBgHeight", "Lcom/transsion/home/bean/MainOperateData;", "o", "Lcom/transsion/home/bean/MainOperateData;", "operatingResp", "p", "mPageName", "Lkk/a;", "q", "Lkotlin/Lazy;", "w1", "()Lkk/a;", "fissionProvider", "Lcom/transsion/home/viewmodel/HomePreferencesViewModel;", "r", "y1", "()Lcom/transsion/home/viewmodel/HomePreferencesViewModel;", "homePreferencesViewModel", "Lkotlin/Function1;", "s", "Lkotlin/jvm/functions/Function1;", "mPermissionCallback", "Landroidx/activity/result/b;", "", "t", "Landroidx/activity/result/b;", "mLauncher", "u", "mOnAppointmentClick", "v", "Landroid/view/View;", "mNoNetworkView", "w", "mProgressViewStartOffset", "x", "mProgressViewEndOffset", "y", "Z", "hasAd", "z", "isAdLoadDisabled", "A", "adHandler", "B", "a", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class TrendingFragment extends BaseHomeSubFragment<x> implements f {
    public static final a B = new a((DefaultConstructorMarker) null);
    public static final int C = 8;

    /* renamed from: g, reason: from kotlin metadata */
    private b exposureHelper;

    /* renamed from: j, reason: from kotlin metadata */
    private TrendingViewModel mPostListModel;

    /* renamed from: k, reason: from kotlin metadata */
    private com.transsion.home.adapter.trending.b mAdapter;

    /* renamed from: l, reason: from kotlin metadata */
    private c postListReport;

    /* renamed from: n, reason: from kotlin metadata */
    private int mHeaderBgHeight;

    /* renamed from: o, reason: from kotlin metadata */
    private volatile MainOperateData operatingResp;

    /* renamed from: p, reason: from kotlin metadata */
    private String mPageName;

    /* renamed from: s, reason: from kotlin metadata */
    private Function1 mPermissionCallback;

    /* renamed from: t, reason: from kotlin metadata */
    private androidx.activity.result.b mLauncher;

    /* renamed from: v, reason: from kotlin metadata */
    private View mNoNetworkView;

    /* renamed from: w, reason: from kotlin metadata */
    private int mProgressViewStartOffset;

    /* renamed from: x, reason: from kotlin metadata */
    private int mProgressViewEndOffset;

    /* renamed from: y, reason: from kotlin metadata */
    private boolean hasAd;

    /* renamed from: z, reason: from kotlin metadata */
    private boolean isAdLoadDisabled;

    /* renamed from: h, reason: from kotlin metadata */
    private String nextPage = "1";

    /* renamed from: i, reason: from kotlin metadata */
    private int mPerPage = 12;

    /* renamed from: m, reason: from kotlin metadata */
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: q, reason: from kotlin metadata */
    private final Lazy fissionProvider = LazyKt.b(new Function0() { // from class: com.transsion.home.fragment.tab.b1
        public final Object invoke() {
            a o1;
            o1 = TrendingFragment.o1();
            return o1;
        }
    });

    /* renamed from: r, reason: from kotlin metadata */
    private final Lazy homePreferencesViewModel = LazyKt.b(new Function0() { // from class: com.transsion.home.fragment.tab.k1
        public final Object invoke() {
            HomePreferencesViewModel J1;
            J1 = TrendingFragment.J1(TrendingFragment.this);
            return J1;
        }
    });

    /* renamed from: u, reason: from kotlin metadata */
    private final Function1 mOnAppointmentClick = new Function1() { // from class: com.transsion.home.fragment.tab.l1
        public final Object invoke(Object obj) {
            Unit c2;
            c2 = TrendingFragment.c2(TrendingFragment.this, (Function1) obj);
            return c2;
        }
    };

    /* renamed from: A, reason: from kotlin metadata */
    private final Handler adHandler = new Handler(Looper.getMainLooper());

    private final int A1() {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter = null;
        }
        int i = 0;
        for (Object obj : baseQuickAdapter.getData()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            if (Intrinsics.c(((OperateItem) obj).getType(), PostItemType.NO_NETWORK.getValue())) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String B1() {
        String str;
        if (this.mPageName == null) {
            HomeFragment parentFragment = getParentFragment();
            if (parentFragment instanceof HomeFragment) {
                this.mPageName = parentFragment.J0();
            }
        }
        return (TextUtils.isEmpty(this.mPageName) || (str = this.mPageName) == null) ? "Trending" : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void E1(List opreateItems) {
        Integer groupPos;
        Integer groupPos2;
        Integer groupPos3;
        int z1;
        HashMap g;
        List items;
        List<OperateItem> I0;
        ArrayList arrayList;
        MainOperateData mainOperateData = this.operatingResp;
        if (mainOperateData != null && (items = mainOperateData.getItems()) != null && (I0 = CollectionsKt.I0(items, new TrendingFragment$handleOpList$.inlined.sortedBy.1())) != null) {
            for (OperateItem operateItem : I0) {
                String type = operateItem.getType();
                if (Intrinsics.c(type, PostItemType.BANNER.getValue())) {
                    BannerBean banner = operateItem.getBanner();
                    List banners = banner != null ? banner.getBanners() : null;
                    if (banners != null && !banners.isEmpty()) {
                        BannerBean banner2 = operateItem.getBanner();
                        if (banner2 != null) {
                            banner2.setBanners(F1(operateItem));
                        }
                    }
                }
                if (Intrinsics.c(type, PostItemType.SPORT_LIVE.getValue())) {
                    List liveList = operateItem.getLiveList();
                    if (liveList != null) {
                        arrayList = new ArrayList();
                        for (Object obj : liveList) {
                            if (!Intrinsics.c(((LiveListItem) obj).getStatus(), "MatchEnded")) {
                                arrayList.add(obj);
                            }
                        }
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                    }
                }
                com.transsion.home.adapter.trending.b bVar = this.mAdapter;
                if (bVar == null) {
                    Intrinsics.y("mAdapter");
                    bVar = null;
                }
                Set keySet = bVar.S1().keySet();
                Intrinsics.g(keySet, "<get-keys>(...)");
                if (CollectionsKt.b0(keySet, type)) {
                    List subjects = operateItem.getSubjects();
                    if (subjects != null) {
                        int size = subjects.size();
                        if (Intrinsics.c(type, PostItemType.OP_SUBJECTS_MOVIE.getValue()) && size < 3) {
                        }
                    }
                    opreateItems.add(operateItem);
                }
            }
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g = logViewConfig.g()) != null) {
            MainOperateData mainOperateData2 = this.operatingResp;
        }
        if (!l.a.e() && (z1 = z1(opreateItems)) >= 0 && z1 < opreateItems.size()) {
            opreateItems.add(z1, new OperateItem((String) null, PostItemType.NO_NETWORK.getValue(), (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (BannerBean) null, (List) null, (List) null, (CustomData) null, (Subject) null, (SingleImagePage) null, (RankingData) null, (RankingListData) null, (List) null, (List) null, (List) null, (List) null, (UGCVideo) null, (List) null, (List) null, (String) null, (BiddingNativeManager) null, (String) null, (String) null, (OperateItem) null, (HomePreferencesConfig) null, 536870909, (DefaultConstructorMarker) null));
        }
        opreateItems.add(new OperateItem(getString(R$string.short_tv_most_trending), PostItemType.FEEDS_TITLE.getValue(), (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (BannerBean) null, (List) null, (List) null, (CustomData) null, (Subject) null, (SingleImagePage) null, (RankingData) null, (RankingListData) null, (List) null, (List) null, (List) null, (List) null, (UGCVideo) null, (List) null, (List) null, (String) null, (BiddingNativeManager) null, (String) null, (String) null, (OperateItem) null, (HomePreferencesConfig) null, 536870908, (DefaultConstructorMarker) null));
        MainOperateData mainOperateData3 = this.operatingResp;
        if (((mainOperateData3 == null || (groupPos3 = mainOperateData3.getGroupPos()) == null) ? 0 : groupPos3.intValue()) > 0) {
            k.a.m(true);
            MainOperateData mainOperateData4 = this.operatingResp;
            int intValue = (mainOperateData4 == null || (groupPos2 = mainOperateData4.getGroupPos()) == null) ? 0 : groupPos2.intValue();
            if (intValue >= opreateItems.size()) {
                opreateItems.add(new OperateItem((String) null, PostItemType.ROOM.getValue(), (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (BannerBean) null, (List) null, (List) null, (CustomData) null, (Subject) null, (SingleImagePage) null, (RankingData) null, (RankingListData) null, (List) null, (List) null, (List) null, (List) null, (UGCVideo) null, (List) null, (List) null, (String) null, (BiddingNativeManager) null, (String) null, (String) null, (OperateItem) null, (HomePreferencesConfig) null, 536870909, (DefaultConstructorMarker) null));
            } else {
                opreateItems.add(intValue, new OperateItem((String) null, PostItemType.ROOM.getValue(), (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (BannerBean) null, (List) null, (List) null, (CustomData) null, (Subject) null, (SingleImagePage) null, (RankingData) null, (RankingListData) null, (List) null, (List) null, (List) null, (List) null, (UGCVideo) null, (List) null, (List) null, (String) null, (BiddingNativeManager) null, (String) null, (String) null, (OperateItem) null, (HomePreferencesConfig) null, 536870909, (DefaultConstructorMarker) null));
            }
        }
        k kVar = k.a;
        MainOperateData mainOperateData5 = this.operatingResp;
        kVar.m(((mainOperateData5 == null || (groupPos = mainOperateData5.getGroupPos()) == null) ? 0 : groupPos.intValue()) > 0);
        HomePreferencesUiHelperKt.f(d0(), y1(), opreateItems);
    }

    private final List F1(OperateItem it) {
        List banners;
        BannerBean banner = it.getBanner();
        if (banner != null) {
            banner.setRefreshAd(true);
        }
        BannerBean banner2 = it.getBanner();
        if (banner2 == null || (banners = banner2.getBanners()) == null) {
            return null;
        }
        return CollectionsKt.U0(banners);
    }

    private final boolean G1() {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter = null;
        }
        Iterator<T> it = baseQuickAdapter.getData().iterator();
        while (it.hasNext()) {
            if (Intrinsics.c(((OperateItem) it.next()).getType(), PostItemType.NO_NETWORK.getValue())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H1() {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        BaseQuickAdapter baseQuickAdapter2 = null;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter = null;
        }
        if (baseQuickAdapter.getData().size() <= 0) {
            return false;
        }
        BaseQuickAdapter baseQuickAdapter3 = this.mAdapter;
        if (baseQuickAdapter3 == null) {
            Intrinsics.y("mAdapter");
        } else {
            baseQuickAdapter2 = baseQuickAdapter3;
        }
        return Intrinsics.c(((OperateItem) baseQuickAdapter2.getData().get(0)).getType(), PostItemType.BANNER.getValue());
    }

    private final boolean I1(List items) {
        OperateItem operateItem;
        return Intrinsics.c((items == null || (operateItem = (OperateItem) CollectionsKt.k0(items)) == null) ? null : operateItem.getType(), PostItemType.BANNER.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final HomePreferencesViewModel J1(TrendingFragment trendingFragment) {
        Fragment requireParentFragment = trendingFragment.requireParentFragment();
        Intrinsics.g(requireParentFragment, "requireParentFragment(...)");
        return new v0(requireParentFragment).a(HomePreferencesViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void K1(TrendingFragment trendingFragment) {
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        CustomSwipeRefreshLayout customSwipeRefreshLayout2;
        x mViewBinding = trendingFragment.getMViewBinding();
        int i = 0;
        trendingFragment.mProgressViewStartOffset = (mViewBinding == null || (customSwipeRefreshLayout2 = mViewBinding.e) == null) ? 0 : customSwipeRefreshLayout2.getProgressViewStartOffset();
        x mViewBinding2 = trendingFragment.getMViewBinding();
        if (mViewBinding2 != null && (customSwipeRefreshLayout = mViewBinding2.e) != null) {
            i = customSwipeRefreshLayout.getProgressViewEndOffset();
        }
        trendingFragment.mProgressViewEndOffset = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L1() {
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        Context context = getContext();
        int i = (context == null || !com.transsion.baseui.util.b.a(context)) ? 3 : y.e() > y.c() ? 5 : 4;
        b bVar = this.exposureHelper;
        com.transsion.home.preload.a activity = getActivity();
        Intrinsics.f(activity, "null cannot be cast to non-null type com.transsion.home.preload.MainXMLPreload");
        com.transsion.home.preload.b d = activity.d();
        TrendingViewModel trendingViewModel = this.mPostListModel;
        Function1 function1 = this.mOnAppointmentClick;
        Context context2 = getContext();
        com.transsion.home.adapter.trending.b bVar2 = new com.transsion.home.adapter.trending.b(bVar, d, this, trendingViewModel, function1, context2 != null && com.transsion.baseui.util.b.a(context2), i);
        bVar2.h0().z(true);
        bVar2.h0().y(true);
        bVar2.h0().E(4);
        bVar2.h0().D(new r1(this));
        bVar2.R0(new f());
        bVar2.w1(new r0(this));
        bVar2.l(R$id.ll_download);
        bVar2.s1(new s0(this, bVar2));
        bVar2.U1(new t0(this));
        this.mAdapter = bVar2;
        Object obj = bVar2.S1().get(PostItemType.PREFERENCES.getValue());
        BaseQuickAdapter baseQuickAdapter = null;
        e eVar = obj instanceof e ? (e) obj : null;
        if (eVar != null) {
            HomePreferencesViewModel y1 = y1();
            BaseProviderMultiAdapter baseProviderMultiAdapter = this.mAdapter;
            if (baseProviderMultiAdapter == null) {
                Intrinsics.y("mAdapter");
                baseProviderMultiAdapter = null;
            }
            int e0 = e0();
            String d0 = d0();
            if (d0 == null) {
                d0 = "";
            }
            HomePreferencesUiHelperKt.j(eVar, y1, baseProviderMultiAdapter, e0, d0);
        }
        NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(requireContext(), i);
        g gVar = new g(this, i);
        gVar.i(true);
        npaGridLayoutManager.d0(gVar);
        initExposureHelper();
        x mViewBinding = getMViewBinding();
        RecyclerView recyclerView = mViewBinding != null ? mViewBinding.d : null;
        b bVar3 = this.exposureHelper;
        if (bVar3 != null && recyclerView != null) {
            recyclerView.addOnScrollListener(bVar3);
        }
        if (recyclerView != null) {
            recyclerView.setLayoutManager(npaGridLayoutManager);
            npaGridLayoutManager.setInitialPrefetchItemCount(6);
            h hVar = new h(a0.a(12.0f), i);
            hVar.d(a0.a(6.0f));
            recyclerView.addItemDecoration(hVar);
            recyclerView.setItemAnimator(null);
            RecyclerView.Adapter adapter = this.mAdapter;
            if (adapter == null) {
                Intrinsics.y("mAdapter");
                adapter = null;
            }
            recyclerView.setAdapter(adapter);
            BaseQuickAdapter baseQuickAdapter2 = this.mAdapter;
            if (baseQuickAdapter2 == null) {
                Intrinsics.y("mAdapter");
            } else {
                baseQuickAdapter = baseQuickAdapter2;
            }
            recyclerView.addOnScrollListener(new nj.a(baseQuickAdapter.h0()));
        }
        if (recyclerView != null) {
            HomePreferencesUiHelperKt.h(this, recyclerView, npaGridLayoutManager, y1(), new u0(this));
        }
        x mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (customSwipeRefreshLayout = mViewBinding2.e) == null) {
            return;
        }
        customSwipeRefreshLayout.setOnRefreshListener(new v0(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M1(TrendingFragment trendingFragment) {
        if (l.a.e()) {
            trendingFragment.h2();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(TrendingFragment trendingFragment) {
        trendingFragment.Z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(TrendingFragment trendingFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        OperateItem operateItem;
        Subject feedsSubject;
        String subjectId;
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        if (!(item instanceof OperateItem) || (feedsSubject = (operateItem = (OperateItem) item).getFeedsSubject()) == null || (subjectId = feedsSubject.getSubjectId()) == null || subjectId.length() <= 0) {
            return;
        }
        Subject feedsSubject2 = operateItem.getFeedsSubject();
        Intrinsics.e(feedsSubject2);
        zk.h.f(feedsSubject2, "opt_feeds");
        c cVar = trendingFragment.postListReport;
        if (cVar != null) {
            Subject feedsSubject3 = operateItem.getFeedsSubject();
            Intrinsics.e(feedsSubject3);
            cVar.b(i, feedsSubject3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(TrendingFragment trendingFragment, com.transsion.home.adapter.trending.b bVar, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Subject feedsSubject;
        TrendingViewModel trendingViewModel;
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L)) {
            return;
        }
        Object item = baseQuickAdapter.getItem(i);
        String str = null;
        OperateItem operateItem = item instanceof OperateItem ? (OperateItem) item : null;
        if (view.getId() == R$id.ll_download) {
            str = zk.h.g(operateItem != null ? operateItem.getFeedsSubject() : null, trendingFragment.getPageName(), bVar.getContext(), "opt_feeds");
        }
        if (operateItem == null || (feedsSubject = operateItem.getFeedsSubject()) == null || (trendingViewModel = trendingFragment.mPostListModel) == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        trendingViewModel.a0(feedsSubject, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Q1(TrendingFragment trendingFragment) {
        BaseQuickAdapter baseQuickAdapter = trendingFragment.mAdapter;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter = null;
        }
        return baseQuickAdapter.getData().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(TrendingFragment trendingFragment) {
        trendingFragment.c0();
        trendingFragment.a2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void S1(TrendingFragment trendingFragment, Map map) {
        RecyclerView recyclerView;
        Intrinsics.h(map, "permissions");
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = true;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                ref$BooleanRef.element = false;
            }
        }
        x mViewBinding = trendingFragment.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.d) == null) {
            return;
        }
        recyclerView.post(new o1(trendingFragment, ref$BooleanRef));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(TrendingFragment trendingFragment, Ref$BooleanRef ref$BooleanRef) {
        Function1 function1 = trendingFragment.mPermissionCallback;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(ref$BooleanRef.element));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U1(TrendingFragment trendingFragment, TrendingRespData trendingRespData) {
        List items;
        MainOperateData mainOperateData = trendingFragment.operatingResp;
        boolean z = false;
        boolean z2 = ((mainOperateData == null || (items = mainOperateData.getItems()) == null) ? 0 : items.size()) > 0;
        if (!z2) {
            BaseQuickAdapter baseQuickAdapter = trendingFragment.mAdapter;
            if (baseQuickAdapter == null) {
                Intrinsics.y("mAdapter");
                baseQuickAdapter = null;
            }
            if (baseQuickAdapter.getData().size() > 0 && Intrinsics.c(trendingFragment.nextPage, "1")) {
                z = true;
            }
        }
        a.a.f(wf.a.a, "PreloadTrending", "load feeds isFresh " + z + " hasOperating " + z2, false, 4, (Object) null);
        trendingFragment.p2(trendingRespData, z);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V1() {
        if (G1()) {
            return;
        }
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter = null;
        }
        int z1 = z1(baseQuickAdapter.getData());
        if (z1 >= 0) {
            BaseQuickAdapter baseQuickAdapter2 = this.mAdapter;
            if (baseQuickAdapter2 == null) {
                Intrinsics.y("mAdapter");
                baseQuickAdapter2 = null;
            }
            if (z1 < baseQuickAdapter2.getData().size()) {
                BaseQuickAdapter baseQuickAdapter3 = this.mAdapter;
                if (baseQuickAdapter3 == null) {
                    Intrinsics.y("mAdapter");
                    baseQuickAdapter3 = null;
                }
                baseQuickAdapter3.getData().add(z1, new OperateItem((String) null, PostItemType.NO_NETWORK.getValue(), (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (BannerBean) null, (List) null, (List) null, (CustomData) null, (Subject) null, (SingleImagePage) null, (RankingData) null, (RankingListData) null, (List) null, (List) null, (List) null, (List) null, (UGCVideo) null, (List) null, (List) null, (String) null, (BiddingNativeManager) null, (String) null, (String) null, (OperateItem) null, (HomePreferencesConfig) null, 536870909, (DefaultConstructorMarker) null));
                RecyclerView.Adapter adapter = this.mAdapter;
                if (adapter == null) {
                    Intrinsics.y("mAdapter");
                    adapter = null;
                }
                adapter.notifyItemInserted(z1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void W1(boolean showProgress) {
        if (showProgress) {
            BaseQuickAdapter baseQuickAdapter = this.mAdapter;
            if (baseQuickAdapter == null) {
                Intrinsics.y("mAdapter");
                baseQuickAdapter = null;
            }
            if (baseQuickAdapter.getData().size() <= 2) {
                showProgress();
            }
        }
        PreloadTrendingData a = PreloadTrendingData.n.a();
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        a.U(requireContext);
    }

    static /* synthetic */ void X1(TrendingFragment trendingFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        trendingFragment.W1(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Y1() {
        BiddingFloatingIrregularView biddingFloatingIrregularView;
        x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (biddingFloatingIrregularView = mViewBinding.b) == null) {
            return;
        }
        biddingFloatingIrregularView.loadAd();
    }

    private final void Z1() {
        int i = this.mPerPage;
        if (i <= 0) {
            i = 12;
        }
        TrendingViewModel trendingViewModel = this.mPostListModel;
        if (trendingViewModel != null) {
            String str = this.nextPage;
            com.transsion.home.adapter.trending.b bVar = this.mAdapter;
            if (bVar == null) {
                Intrinsics.y("mAdapter");
                bVar = null;
            }
            trendingViewModel.Y(str, i, bVar.T1());
        }
    }

    private final void a2() {
        this.adHandler.removeCallbacksAndMessages(null);
        if (this.hasAd) {
            return;
        }
        this.adHandler.postDelayed(new q1(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void b2(TrendingFragment trendingFragment) {
        d activity = trendingFragment.getActivity();
        BaseActivity baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
        if (baseActivity != null) {
            baseActivity.loadTwoLevelAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c2(TrendingFragment trendingFragment, Function1 function1) {
        Intrinsics.h(function1, "callback");
        trendingFragment.mPermissionCallback = function1;
        androidx.activity.result.b bVar = trendingFragment.mLauncher;
        if (bVar != null) {
            bVar.a(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"});
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(int i, int i2, TrendingFragment trendingFragment, OperateItem operateItem) {
        BaseQuickAdapter baseQuickAdapter = null;
        if (i < 0 || i > i2) {
            BaseQuickAdapter baseQuickAdapter2 = trendingFragment.mAdapter;
            if (baseQuickAdapter2 == null) {
                Intrinsics.y("mAdapter");
            } else {
                baseQuickAdapter = baseQuickAdapter2;
            }
            baseQuickAdapter.p(operateItem);
            return;
        }
        BaseQuickAdapter baseQuickAdapter3 = trendingFragment.mAdapter;
        if (baseQuickAdapter3 == null) {
            Intrinsics.y("mAdapter");
        } else {
            baseQuickAdapter = baseQuickAdapter3;
        }
        baseQuickAdapter.n(i, operateItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e2() {
        BaseActivity baseActivity;
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        if (this.hasAd) {
            x mViewBinding = getMViewBinding();
            String currentState = (mViewBinding == null || (customSwipeRefreshLayout = mViewBinding.e) == null) ? null : customSwipeRefreshLayout.getCurrentState();
            if (currentState != null) {
                int hashCode = currentState.hashCode();
                if (hashCode != -1435393951) {
                    if (hashCode != 2242516) {
                        if (hashCode == 1803427515 && currentState.equals("REFRESH")) {
                            String str = isVisible() ? CustomSwipeRefreshLayout.Companion.b() ? "HOVER_FULL" : "HOVER_HALF" : "IDLE";
                            d activity = getActivity();
                            baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
                            if (baseActivity != null) {
                                baseActivity.onAction(str, 0.0f, 0.0f);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (!currentState.equals("IDLE")) {
                        return;
                    }
                } else if (!currentState.equals("SECOND_FLOOR")) {
                    return;
                }
                d activity2 = getActivity();
                baseActivity = activity2 instanceof BaseActivity ? (BaseActivity) activity2 : null;
                if (baseActivity != null) {
                    baseActivity.onAction("IDLE", 0.0f, 0.0f);
                }
            }
        }
    }

    private final void f1(List newList, TrendingRespItem item) {
        Integer type = item.getType();
        int value = TrendingRespItemType.SUBJECT.getValue();
        if (type == null || type.intValue() != value || item.getSubject() == null) {
            return;
        }
        newList.add(new OperateItem((String) null, PostItemType.SUBJECT.getValue(), (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (BannerBean) null, (List) null, (List) null, (CustomData) null, item.getSubject(), (SingleImagePage) null, (RankingData) null, (RankingListData) null, (List) null, (List) null, (List) null, (List) null, (UGCVideo) null, (List) null, (List) null, (String) null, (BiddingNativeManager) null, (String) null, (String) null, (OperateItem) null, (HomePreferencesConfig) null, 536866813, (DefaultConstructorMarker) null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g1() {
        RecyclerView recyclerView;
        x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.d) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void g2(TrendingFragment trendingFragment) {
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        x mViewBinding = trendingFragment.getMViewBinding();
        if (mViewBinding != null && (customSwipeRefreshLayout = mViewBinding.e) != null) {
            customSwipeRefreshLayout.setRefreshing(true);
        }
        trendingFragment.c0();
    }

    private final View getEmptyView(Context context) {
        DefaultView defaultView = new DefaultView(context);
        defaultView.setDefaultImageViewVisibility(0);
        defaultView.setDefaultImage(R$mipmap.ic_no_content);
        String string = context.getString(com.tn.lib.widget.R$string.no_content);
        Intrinsics.g(string, "getString(...)");
        defaultView.setDescText(string);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DESC_BTN);
        defaultView.setBtnVisibility(0);
        String string2 = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.g(string2, "getString(...)");
        defaultView.setBtnText(string2);
        defaultView.setBtnClickListener(new h1(this, defaultView));
        defaultView.setVisibility(0);
        return defaultView;
    }

    private final String getPageName() {
        return B1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h1() {
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        x mViewBinding = getMViewBinding();
        if (mViewBinding != null && (customSwipeRefreshLayout = mViewBinding.e) != null) {
            customSwipeRefreshLayout.setCurrentState("IDLE");
        }
        d activity = getActivity();
        BaseActivity baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
        if (baseActivity != null) {
            baseActivity.onAction("IDLE", 0.0f, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2() {
        int A1 = A1();
        if (A1 >= 0) {
            BaseQuickAdapter baseQuickAdapter = this.mAdapter;
            RecyclerView.Adapter adapter = null;
            if (baseQuickAdapter == null) {
                Intrinsics.y("mAdapter");
                baseQuickAdapter = null;
            }
            if (A1 < baseQuickAdapter.getData().size()) {
                BaseQuickAdapter baseQuickAdapter2 = this.mAdapter;
                if (baseQuickAdapter2 == null) {
                    Intrinsics.y("mAdapter");
                    baseQuickAdapter2 = null;
                }
                baseQuickAdapter2.getData().remove(A1);
                RecyclerView.Adapter adapter2 = this.mAdapter;
                if (adapter2 == null) {
                    Intrinsics.y("mAdapter");
                } else {
                    adapter = adapter2;
                }
                adapter.notifyItemRemoved(A1);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void hideProgress() {
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        CustomSwipeRefreshLayout customSwipeRefreshLayout2;
        CustomSwipeRefreshLayout customSwipeRefreshLayout3;
        h0 h0Var;
        ConstraintLayout constraintLayout;
        x mViewBinding = getMViewBinding();
        if (mViewBinding != null && (h0Var = mViewBinding.c) != null && (constraintLayout = h0Var.h) != null) {
            uf.c.g(constraintLayout);
        }
        x mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (customSwipeRefreshLayout3 = mViewBinding2.e) != null) {
            customSwipeRefreshLayout3.setEnabled(true);
        }
        x mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (customSwipeRefreshLayout = mViewBinding3.e) == null || !customSwipeRefreshLayout.isRefreshing()) {
            return;
        }
        x mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (customSwipeRefreshLayout2 = mViewBinding4.e) != null) {
            customSwipeRefreshLayout2.setRefreshing(false);
        }
        e2();
    }

    private final void i1() {
        z0 z0Var = new z0(this);
        a.a aVar = wf.a.a;
        PreloadTrendingData.a aVar2 = PreloadTrendingData.n;
        a.a.f(aVar, "lgx", "preObserve fragment:" + this + " " + aVar2.a().J() + "  " + aVar2.a().K(), false, 4, (Object) null);
        aVar2.a().J().j(this, new j(new a1(this, z0Var)));
        aVar2.a().K().j(this, new j(new c1(this, z0Var)));
    }

    private final List i2(List feedsList) {
        ArrayList arrayList = new ArrayList();
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter = null;
        }
        List<Object> data = baseQuickAdapter.getData();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : data) {
            if (((OperateItem) obj).getFeedsSubject() != null) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.v(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Subject feedsSubject = ((OperateItem) it.next()).getFeedsSubject();
            arrayList3.add(feedsSubject != null ? feedsSubject.getSubjectId() : null);
        }
        Iterator it2 = feedsList.iterator();
        while (it2.hasNext()) {
            TrendingRespItem trendingRespItem = (TrendingRespItem) it2.next();
            if (trendingRespItem.getSubject() != null) {
                Subject subject = trendingRespItem.getSubject();
                if (arrayList3.contains(subject != null ? subject.getSubjectId() : null)) {
                    a.a aVar = wf.a.a;
                    Subject subject2 = trendingRespItem.getSubject();
                    String title = subject2 != null ? subject2.getTitle() : null;
                    Subject subject3 = trendingRespItem.getSubject();
                    a.a.f(aVar, "Trending", "find same item title..." + title + " id  " + (subject3 != null ? subject3.getSubjectId() : null), false, 4, (Object) null);
                }
            }
            f1(arrayList, trendingRespItem);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAd() {
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        CustomSwipeRefreshLayout customSwipeRefreshLayout2;
        x mViewBinding = getMViewBinding();
        if (mViewBinding != null && (customSwipeRefreshLayout2 = mViewBinding.e) != null) {
            customSwipeRefreshLayout2.post(new y0(this));
        }
        x mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (customSwipeRefreshLayout = mViewBinding2.e) == null) {
            return;
        }
        customSwipeRefreshLayout.setOnSwipeActionListener(new d(this));
    }

    private final void initExposureHelper() {
        this.postListReport = new c(getPageName());
        b bVar = new b(0.6f, new e(this), false, 4, (DefaultConstructorMarker) null);
        this.exposureHelper = bVar;
        bVar.l(2);
    }

    private final void initViewModel() {
        TrendingViewModel trendingViewModel = this.mPostListModel;
        if (trendingViewModel != null) {
            trendingViewModel.X().j(this, new j(new w0(this)));
        }
        BaseProviderMultiAdapter baseProviderMultiAdapter = null;
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new initViewModel.2(this, (Continuation) null), 3, (Object) null);
        i1();
        HomePreferencesViewModel y1 = y1();
        BaseProviderMultiAdapter baseProviderMultiAdapter2 = this.mAdapter;
        if (baseProviderMultiAdapter2 == null) {
            Intrinsics.y("mAdapter");
        } else {
            baseProviderMultiAdapter = baseProviderMultiAdapter2;
        }
        HomePreferencesUiHelperKt.o(this, y1, baseProviderMultiAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit j1(TrendingFragment trendingFragment, boolean z) {
        x mViewBinding;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        ViewTreeObserver viewTreeObserver;
        RecyclerView recyclerView4;
        TrendingViewModel trendingViewModel;
        Integer groupPos;
        qi.b logViewConfig = trendingFragment.getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        MainOperateData mainOperateData = trendingFragment.operatingResp;
        if (((mainOperateData == null || (groupPos = mainOperateData.getGroupPos()) == null) ? 0 : groupPos.intValue()) > 0 && (trendingViewModel = trendingFragment.mPostListModel) != null) {
            trendingViewModel.T(z);
        }
        ArrayList arrayList = new ArrayList();
        trendingFragment.E1(arrayList);
        String d0 = trendingFragment.d0();
        if (d0 != null) {
            trendingFragment.y1().E(d0, arrayList);
        }
        MainOperateData mainOperateData2 = trendingFragment.operatingResp;
        zk.h.c(arrayList, mainOperateData2 != null ? mainOperateData2.getOps() : null);
        boolean I1 = trendingFragment.I1(arrayList);
        x mViewBinding2 = trendingFragment.getMViewBinding();
        if (mViewBinding2 != null && (recyclerView4 = mViewBinding2.d) != null) {
            recyclerView4.post(new f1(trendingFragment, arrayList, I1));
        }
        x mViewBinding3 = trendingFragment.getMViewBinding();
        if (mViewBinding3 != null && (recyclerView3 = mViewBinding3.d) != null && (viewTreeObserver = recyclerView3.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnPreDrawListener(new c(trendingFragment));
        }
        a.a.f(wf.a.a, "lgx", "hide1 fragment:" + trendingFragment, false, 4, (Object) null);
        trendingFragment.hideProgress();
        x mViewBinding4 = trendingFragment.getMViewBinding();
        if (((mViewBinding4 == null || (recyclerView2 = mViewBinding4.d) == null) ? 0 : recyclerView2.computeVerticalScrollOffset()) > 10 && (mViewBinding = trendingFragment.getMViewBinding()) != null && (recyclerView = mViewBinding.d) != null) {
            recyclerView.scrollBy(0, 1);
        }
        if (!z) {
            com.transsion.home.preload.c.b(arrayList);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void j2(int position) {
        HashMap g;
        HashMap g2;
        String str;
        Integer v;
        qi.b logViewConfig = getLogViewConfig();
        int intValue = (logViewConfig == null || (g2 = logViewConfig.g()) == null || (str = (String) g2.get("scrollPosition")) == null || (v = StringsKt.v(str)) == null) ? 0 : v.intValue();
        qi.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 == null || (g = logViewConfig2.g()) == null) {
            return;
        }
        g.put("scrollPosition", String.valueOf(RangesKt.e(intValue, position)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(TrendingFragment trendingFragment, List list, boolean z) {
        com.transsion.home.adapter.trending.b bVar = trendingFragment.mAdapter;
        if (bVar == null) {
            Intrinsics.y("mAdapter");
            bVar = null;
        }
        bVar.n1(list);
        q1(trendingFragment, z, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit l1(TrendingFragment trendingFragment, Function1 function1, MainOperateData mainOperateData) {
        HashMap g;
        List items;
        a.a.f(wf.a.a, "lgx", "observe1 fragment:" + trendingFragment, false, 4, (Object) null);
        qi.b logViewConfig = trendingFragment.getLogViewConfig();
        if (logViewConfig != null && (g = logViewConfig.g()) != null) {
            g.put("enterCache", String.valueOf((mainOperateData == null || (items = mainOperateData.getItems()) == null) ? null : Integer.valueOf(items.size())));
        }
        BaseQuickAdapter baseQuickAdapter = trendingFragment.mAdapter;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter = null;
        }
        if (baseQuickAdapter.getData().size() == 0) {
            List items2 = mainOperateData != null ? mainOperateData.getItems() : null;
            if (items2 != null && !items2.isEmpty()) {
                trendingFragment.operatingResp = mainOperateData;
                function1.invoke(Boolean.TRUE);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit l2(TrendingFragment trendingFragment, String str) {
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        Intrinsics.h(str, "state");
        x mViewBinding = trendingFragment.getMViewBinding();
        if (mViewBinding != null && (customSwipeRefreshLayout = mViewBinding.e) != null) {
            customSwipeRefreshLayout.setCurrentState(str);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit m1(TrendingFragment trendingFragment, Function1 function1, MainOperateData mainOperateData) {
        List items;
        x mViewBinding;
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        HashMap g;
        List items2;
        List items3;
        List items4;
        List items5;
        a.a aVar = wf.a.a;
        a.a.f(aVar, "lgx", "observe2 fragment:" + trendingFragment, false, 4, (Object) null);
        MainOperateData mainOperateData2 = (MainOperateData) PreloadTrendingData.n.a().J().f();
        aVar.c("PreloadTrending", "operating preload cache " + ((mainOperateData2 == null || (items5 = mainOperateData2.getItems()) == null) ? null : Integer.valueOf(items5.size())) + "  net:" + ((mainOperateData == null || (items4 = mainOperateData.getItems()) == null) ? null : Integer.valueOf(items4.size())), true);
        qi.b logViewConfig = trendingFragment.getLogViewConfig();
        if (logViewConfig != null && (g = logViewConfig.g()) != null) {
            g.put("enterNet", "cache:" + ((mainOperateData2 == null || (items3 = mainOperateData2.getItems()) == null) ? null : Integer.valueOf(items3.size())) + " net:" + ((mainOperateData == null || (items2 = mainOperateData.getItems()) == null) ? null : Integer.valueOf(items2.size())));
        }
        List items6 = mainOperateData != null ? mainOperateData.getItems() : null;
        if (items6 != null && !items6.isEmpty()) {
            trendingFragment.operatingResp = mainOperateData;
        } else if (trendingFragment.operatingResp == null) {
            trendingFragment.operatingResp = mainOperateData2;
        }
        BaseQuickAdapter baseQuickAdapter = trendingFragment.mAdapter;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter = null;
        }
        if (baseQuickAdapter.getData().size() > 0 && ((mViewBinding = trendingFragment.getMViewBinding()) == null || (customSwipeRefreshLayout = mViewBinding.e) == null || !customSwipeRefreshLayout.isRefreshing())) {
            List items7 = mainOperateData != null ? mainOperateData.getItems() : null;
            if (items7 == null || items7.isEmpty()) {
                return Unit.a;
            }
        }
        MainOperateData mainOperateData3 = trendingFragment.operatingResp;
        if (mainOperateData3 == null || (items = mainOperateData3.getItems()) == null || !(!items.isEmpty())) {
            trendingFragment.Z1();
            q1(trendingFragment, false, 0, 3, null);
        } else {
            function1.invoke(Boolean.FALSE);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void m2(float alpha) {
        View view;
        x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (view = mViewBinding.f) == null) {
            return;
        }
        view.setAlpha(alpha);
    }

    private final void n1() {
        b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.e();
        }
    }

    private final void n2() {
        this.mHandler.postDelayed(new g1(this), 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kk.a o1() {
        return (kk.a) TheRouter.d(kk.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void o2(TrendingFragment trendingFragment) {
        if (trendingFragment.isDetached() || !trendingFragment.isAdded() || trendingFragment.getContext() == null) {
            return;
        }
        trendingFragment.hideProgress();
        Context requireContext = trendingFragment.requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        View t1 = trendingFragment.t1(requireContext);
        BaseQuickAdapter baseQuickAdapter = trendingFragment.mAdapter;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter = null;
        }
        baseQuickAdapter.Y0(t1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p1(boolean hasTopBanner, int retryCount) {
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        CustomSwipeRefreshLayout customSwipeRefreshLayout2;
        View view;
        CustomSwipeRefreshLayout customSwipeRefreshLayout3;
        x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (customSwipeRefreshLayout = mViewBinding.e) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = customSwipeRefreshLayout.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            if (retryCount < 2) {
                customSwipeRefreshLayout.post(new p1(this, hasTopBanner, retryCount));
                return;
            }
            return;
        }
        if (hasTopBanner) {
            layoutParams2.topMargin = 0;
            x mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (customSwipeRefreshLayout3 = mViewBinding2.e) != null) {
                int i = this.mHeaderBgHeight;
                customSwipeRefreshLayout3.setProgressViewOffset(false, i, a0.a(50.0f) + i);
            }
            m2(0.0f);
            b0(true);
            return;
        }
        x mViewBinding3 = getMViewBinding();
        int height = (mViewBinding3 == null || (view = mViewBinding3.f) == null) ? 0 : view.getHeight();
        if (height <= 0) {
            height = this.mHeaderBgHeight;
        }
        layoutParams2.topMargin = height;
        x mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (customSwipeRefreshLayout2 = mViewBinding4.e) != null) {
            customSwipeRefreshLayout2.setProgressViewOffset(false, 0, a0.a(50.0f));
        }
        m2(1.0f);
        b0(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p2(TrendingRespData baseBean, boolean isRefresh) {
        String str;
        List list;
        List list2;
        Integer perPage;
        a.a aVar = wf.a.a;
        a.a.f(aVar, "PreloadTrending", "updateTrendingList baseBean.data=" + baseBean, false, 4, (Object) null);
        BaseQuickAdapter baseQuickAdapter = null;
        if (baseBean == null) {
            MainOperateData mainOperateData = this.operatingResp;
            List items = mainOperateData != null ? mainOperateData.getItems() : null;
            if (items == null || items.isEmpty()) {
                n2();
            }
            BaseQuickAdapter baseQuickAdapter2 = this.mAdapter;
            if (baseQuickAdapter2 == null) {
                Intrinsics.y("mAdapter");
                baseQuickAdapter2 = null;
            }
            if (baseQuickAdapter2.h0().r()) {
                BaseQuickAdapter baseQuickAdapter3 = this.mAdapter;
                if (baseQuickAdapter3 == null) {
                    Intrinsics.y("mAdapter");
                } else {
                    baseQuickAdapter = baseQuickAdapter3;
                }
                baseQuickAdapter.h0().v();
                return;
            }
            return;
        }
        hideProgress();
        List items2 = baseBean.getItems();
        a.a.f(aVar, "TrendingFragment", "updateTrendingList subjectBean " + (items2 != null ? Integer.valueOf(items2.size()) : null), false, 4, (Object) null);
        Pager pager = baseBean.getPager();
        this.mPerPage = (pager == null || (perPage = pager.getPerPage()) == null) ? this.mPerPage : perPage.intValue();
        Pager pager2 = baseBean.getPager();
        if (pager2 == null || (str = pager2.getNextPage()) == null) {
            str = "1";
        }
        this.nextPage = str;
        List items3 = baseBean.getItems();
        if (isRefresh && (list2 = items3) != null && !list2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = items3.iterator();
            while (it.hasNext()) {
                f1(arrayList, (TrendingRespItem) it.next());
            }
            BaseQuickAdapter baseQuickAdapter4 = this.mAdapter;
            if (baseQuickAdapter4 == null) {
                Intrinsics.y("mAdapter");
            } else {
                baseQuickAdapter = baseQuickAdapter4;
            }
            baseQuickAdapter.n1(arrayList);
            return;
        }
        BaseQuickAdapter baseQuickAdapter5 = this.mAdapter;
        if (baseQuickAdapter5 == null) {
            Intrinsics.y("mAdapter");
        } else {
            baseQuickAdapter = baseQuickAdapter5;
        }
        if (baseQuickAdapter.getData().size() == 0 && ((list = items3) == null || list.isEmpty())) {
            showEmpty();
        } else {
            if (items3 == null) {
                this.mHandler.postDelayed(new d1(this), 200L);
                return;
            }
            List i2 = i2(items3);
            com.transsion.home.preload.c.a(getContext(), i2);
            this.mHandler.postDelayed(new e1(this, i2), 200L);
        }
    }

    static /* synthetic */ void q1(TrendingFragment trendingFragment, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = trendingFragment.H1();
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        trendingFragment.p1(z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(TrendingFragment trendingFragment) {
        BaseQuickAdapter baseQuickAdapter = trendingFragment.mAdapter;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter = null;
        }
        baseQuickAdapter.h0().v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void r1(TrendingFragment trendingFragment, boolean z, int i) {
        if (trendingFragment.isAdded()) {
            trendingFragment.p1(z, i + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void r2(TrendingFragment trendingFragment, List list) {
        if (trendingFragment.getContext() == null) {
            return;
        }
        BaseQuickAdapter baseQuickAdapter = null;
        if (list.isEmpty()) {
            BaseQuickAdapter baseQuickAdapter2 = trendingFragment.mAdapter;
            if (baseQuickAdapter2 == null) {
                Intrinsics.y("mAdapter");
                baseQuickAdapter2 = null;
            }
            t6.f.u(baseQuickAdapter2.h0(), false, 1, (Object) null);
            return;
        }
        BaseQuickAdapter baseQuickAdapter3 = trendingFragment.mAdapter;
        if (baseQuickAdapter3 == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter3 = null;
        }
        baseQuickAdapter3.q(list);
        BaseQuickAdapter baseQuickAdapter4 = trendingFragment.mAdapter;
        if (baseQuickAdapter4 == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter4 = null;
        }
        if (baseQuickAdapter4.h0().r()) {
            BaseQuickAdapter baseQuickAdapter5 = trendingFragment.mAdapter;
            if (baseQuickAdapter5 == null) {
                Intrinsics.y("mAdapter");
            } else {
                baseQuickAdapter = baseQuickAdapter5;
            }
            baseQuickAdapter.h0().s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(TrendingFragment trendingFragment, DefaultView defaultView, View view) {
        X1(trendingFragment, false, 1, null);
        defaultView.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showEmpty() {
        hideProgress();
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        View emptyView = getEmptyView(requireContext);
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter = null;
        }
        baseQuickAdapter.Y0(emptyView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showProgress() {
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        h0 h0Var;
        ConstraintLayout constraintLayout;
        x mViewBinding = getMViewBinding();
        if (mViewBinding != null && (h0Var = mViewBinding.c) != null && (constraintLayout = h0Var.h) != null) {
            uf.c.k(constraintLayout);
        }
        x mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (customSwipeRefreshLayout = mViewBinding2.e) == null) {
            return;
        }
        customSwipeRefreshLayout.setEnabled(false);
    }

    private final View t1(Context context) {
        NoNetworkBigView noNetworkBigView = new NoNetworkBigView(context);
        this.mNoNetworkView = noNetworkBigView;
        noNetworkBigView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        NoNetworkBigView.showTitle$default(noNetworkBigView, false, (String) null, 2, (Object) null);
        noNetworkBigView.retry(new i1(this));
        noNetworkBigView.goToSetting(new j1(this));
        o.a(getPageName());
        return noNetworkBigView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(TrendingFragment trendingFragment) {
        X1(trendingFragment, false, 1, null);
        o.b(trendingFragment.getPageName());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(TrendingFragment trendingFragment) {
        o.c(trendingFragment.getPageName());
        return Unit.a;
    }

    private final kk.a w1() {
        return (kk.a) this.fissionProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final float x1() {
        View view;
        x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (view = mViewBinding.f) == null) {
            return 0.0f;
        }
        return view.getAlpha();
    }

    private final HomePreferencesViewModel y1() {
        return (HomePreferencesViewModel) this.homePreferencesViewModel.getValue();
    }

    private final int z1(List opreateItems) {
        int i = 0;
        for (Object obj : opreateItems) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            if (Intrinsics.c(((OperateItem) obj).getType(), PostItemType.BANNER.getValue())) {
                return i2;
            }
            i = i2;
        }
        return 0;
    }

    /* renamed from: C1, reason: from getter */
    public final c getPostListReport() {
        return this.postListReport;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public x getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        com.transsion.home.preload.a activity = getActivity();
        Intrinsics.f(activity, "null cannot be cast to non-null type com.transsion.home.preload.MainXMLPreload");
        com.transsion.home.preload.b d = activity.d();
        Boolean valueOf = d != null ? Boolean.valueOf(d.e()) : null;
        View f = d != null ? d.f() : null;
        if (f == null || !Intrinsics.c(valueOf, Boolean.FALSE)) {
            x c = x.c(inflater);
            Intrinsics.g(c, "inflate(...)");
            return c;
        }
        a.a.f(wf.a.a, "MainXMLPreload", "postlist root ", false, 4, (Object) null);
        x a = x.a(f);
        Intrinsics.g(a, "bind(...)");
        return a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c0() {
        String str;
        super.c0();
        BiddingListManager i0 = i0();
        if (i0 != null) {
            i0.C(true);
        }
        this.nextPage = "1";
        Context context = getContext();
        if (context != null) {
            PreloadTrendingData a = PreloadTrendingData.n.a();
            MainOperateData mainOperateData = this.operatingResp;
            if (mainOperateData == null || (str = mainOperateData.getVersion()) == null) {
                str = "";
            }
            if (a.X(context, str)) {
                return;
            }
            hideProgress();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerView f0() {
        x mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.d;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f2() {
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        RecyclerView recyclerView;
        if (isAdded()) {
            x mViewBinding = getMViewBinding();
            if (mViewBinding != null && (recyclerView = mViewBinding.d) != null) {
                recyclerView.scrollToPosition(0);
            }
            x mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (customSwipeRefreshLayout = mViewBinding2.e) == null) {
                return;
            }
            customSwipeRefreshLayout.post(new n1(this));
        }
    }

    public String g0() {
        return "TrendingScene";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initView(View view, Bundle savedInstanceState) {
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        CustomSwipeRefreshLayout customSwipeRefreshLayout2;
        View view2;
        ViewGroup.LayoutParams layoutParams;
        RecyclerView recyclerView;
        ViewTreeObserver viewTreeObserver;
        Intrinsics.h(view, "view");
        super.initView(view, savedInstanceState);
        TrendingViewModel trendingViewModel = this.mPostListModel;
        if (trendingViewModel != null) {
            trendingViewModel.N(getPageName());
        }
        L1();
        initViewModel();
        setNetListener(new h(this));
        x mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.d) != null && (viewTreeObserver = recyclerView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnPreDrawListener(new i(this));
        }
        this.mLauncher = registerForActivityResult(new f.h(), new androidx.activity.result.a() { // from class: com.transsion.home.fragment.tab.q0
            public final void a(Object obj) {
                TrendingFragment.S1(TrendingFragment.this, (Map) obj);
            }
        });
        g1();
        this.mHeaderBgHeight = h0();
        x mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (view2 = mViewBinding2.f) != null && (layoutParams = view2.getLayoutParams()) != null) {
            layoutParams.height = this.mHeaderBgHeight;
        }
        x mViewBinding3 = getMViewBinding();
        ViewGroup.LayoutParams layoutParams2 = (mViewBinding3 == null || (customSwipeRefreshLayout2 = mViewBinding3.e) == null) ? null : customSwipeRefreshLayout2.getLayoutParams();
        FrameLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams2 : null;
        if (layoutParams3 != null) {
            layoutParams3.topMargin = this.mHeaderBgHeight;
            x mViewBinding4 = getMViewBinding();
            if (mViewBinding4 != null && (customSwipeRefreshLayout = mViewBinding4.e) != null) {
                customSwipeRefreshLayout.setLayoutParams(layoutParams3);
            }
        }
        if (savedInstanceState != null && savedInstanceState.getBoolean("operate_items", false)) {
            a.a.f(wf.a.a, "lgx", "get save instance", false, 4, (Object) null);
            List L = PreloadTrendingData.n.a().L();
            com.transsion.home.adapter.trending.b bVar = this.mAdapter;
            if (bVar == null) {
                Intrinsics.y("mAdapter");
                bVar = null;
            }
            bVar.n1(L);
            q1(this, I1(L), 0, 2, null);
        }
        initAd();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k2() {
        d activity = getActivity();
        BaseActivity baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
        if (baseActivity != null) {
            baseActivity.setStateCallback(new m1(this));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l0(int lastAdPosition, BiddingNativeManager wrapperNativeManager) {
        String value;
        RecyclerView recyclerView;
        Intrinsics.h(wrapperNativeManager, "wrapperNativeManager");
        if (wrapperNativeManager != null) {
            OperateItem operateItem = new OperateItem((String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (BannerBean) null, (List) null, (List) null, (CustomData) null, (Subject) null, (SingleImagePage) null, (RankingData) null, (RankingListData) null, (List) null, (List) null, (List) null, (List) null, (UGCVideo) null, (List) null, (List) null, (String) null, (BiddingNativeManager) null, (String) null, (String) null, (OperateItem) null, (HomePreferencesConfig) null, 536870911, (DefaultConstructorMarker) null);
            operateItem.setNonAdDelegate(wrapperNativeManager);
            BaseQuickAdapter baseQuickAdapter = this.mAdapter;
            BaseQuickAdapter baseQuickAdapter2 = null;
            if (baseQuickAdapter == null) {
                Intrinsics.y("mAdapter");
                baseQuickAdapter = null;
            }
            int size = baseQuickAdapter.getData().size();
            com.transsion.home.adapter.trending.b bVar = this.mAdapter;
            if (bVar == null) {
                Intrinsics.y("mAdapter");
                bVar = null;
            }
            if (bVar.T1()) {
                if (1 <= lastAdPosition && lastAdPosition < size) {
                    BaseQuickAdapter baseQuickAdapter3 = this.mAdapter;
                    if (baseQuickAdapter3 == null) {
                        Intrinsics.y("mAdapter");
                    } else {
                        baseQuickAdapter2 = baseQuickAdapter3;
                    }
                    if (!Intrinsics.c(((OperateItem) baseQuickAdapter2.getData().get(lastAdPosition)).getType(), PostItemType.SUBJECT.getValue())) {
                        value = PostItemType.TRENDING_NATIVE_AD.getValue();
                    }
                }
                value = PostItemType.SUBJECT.getValue();
            } else {
                value = PostItemType.TRENDING_NATIVE_AD.getValue();
            }
            operateItem.setType(value);
            if (Intrinsics.c(operateItem.getType(), PostItemType.SUBJECT.getValue())) {
                BiddingListManager i0 = i0();
                if (i0 != null) {
                    i0.C(false);
                    return;
                }
                return;
            }
            x mViewBinding = getMViewBinding();
            if (mViewBinding == null || (recyclerView = mViewBinding.d) == null) {
                return;
            }
            recyclerView.post(new x0(lastAdPosition, size, this, operateItem));
        }
    }

    public void lazyLoadData() {
        List items;
        MainOperateData mainOperateData = this.operatingResp;
        if (mainOperateData == null || (items = mainOperateData.getItems()) == null || !(!items.isEmpty())) {
            a.a aVar = wf.a.a;
            boolean z = this.operatingResp == null;
            BaseQuickAdapter baseQuickAdapter = this.mAdapter;
            if (baseQuickAdapter == null) {
                Intrinsics.y("mAdapter");
                baseQuickAdapter = null;
            }
            aVar.c("PreloadTrending", "lazyLoadData " + z + " " + baseQuickAdapter.getData().size(), true);
            StringBuilder sb = new StringBuilder();
            sb.append("load1 fragment:");
            sb.append(this);
            a.a.f(aVar, "lgx", sb.toString(), false, 4, (Object) null);
            X1(this, false, 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void logResume() {
        super/*com.transsion.baseui.fragment.BaseFragment*/.logResume();
        kk.a w1 = w1();
        if (w1 != null) {
            a.a.a(w1, false, 1, (Object) null);
        }
        kk.a w12 = w1();
        if (w12 != null) {
            w12.c(false);
        }
        bm.e.a.h();
    }

    public qi.b newLogViewConfig() {
        return new qi.b(getPageName(), false, 2, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(newConfig);
        com.transsion.home.adapter.trending.b bVar = this.mAdapter;
        RecyclerView.Adapter adapter = null;
        if (bVar == null) {
            Intrinsics.y("mAdapter");
            bVar = null;
        }
        if (bVar.T1()) {
            RecyclerView.Adapter adapter2 = this.mAdapter;
            if (adapter2 == null) {
                Intrinsics.y("mAdapter");
            } else {
                adapter = adapter2;
            }
            adapter.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle savedInstanceState) {
        HashMap g;
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g = logViewConfig.g()) != null) {
            g.put("onCreate", "true");
        }
        AppStartReport.a.e(new AppStartDotState(AppStartDotState.TRENDING_CREATE, 0L, 2, null));
        super.onCreate(savedInstanceState);
        this.mPostListModel = new v0(this).a(TrendingViewModel.class);
        k2();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        zk.c.a.a();
        BannerADDataHelper.a.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroyView() {
        super/*com.transsion.baseui.fragment.BaseFragment*/.onDestroyView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        if (hidden) {
            h1();
        }
        if (isResumed()) {
            if (hidden) {
                logPause();
                n1();
            } else {
                logResume();
                Y1();
            }
        }
        com.transsion.baseui.activity.k.h((String) null, this, hidden, (String) null, 9, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super/*com.transsion.baseui.fragment.BaseFragment*/.onPause();
        n1();
        com.transsion.baseui.activity.k.l((String) null, this, (String) null, 5, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        HashMap g;
        super/*com.transsion.baseui.fragment.BaseFragment*/.onResume();
        a.a aVar = wf.a.a;
        View view = this.mNoNetworkView;
        a.a.f(aVar, "TrendingFragment", "visible = " + (view != null ? Integer.valueOf(view.getVisibility()) : null) + "  " + this, false, 4, (Object) null);
        View view2 = this.mNoNetworkView;
        if (view2 != null && view2.getVisibility() == 0 && l.a.e()) {
            BaseQuickAdapter baseQuickAdapter = this.mAdapter;
            if (baseQuickAdapter == null) {
                Intrinsics.y("mAdapter");
                baseQuickAdapter = null;
            }
            if (baseQuickAdapter.getData().size() < 2) {
                X1(this, false, 1, null);
            }
        }
        com.transsion.baseui.activity.k.p((String) null, this, "visible=" + isVisible(), 1, (Object) null);
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g = logViewConfig.g()) != null) {
            g.put("scrollPosition", "0");
        }
        if (this.isAdLoadDisabled) {
            return;
        }
        a2();
        Y1();
        this.isAdLoadDisabled = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(outState);
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        BaseQuickAdapter baseQuickAdapter2 = null;
        if (baseQuickAdapter == null) {
            Intrinsics.y("mAdapter");
            baseQuickAdapter = null;
        }
        if (baseQuickAdapter.getData().size() > 0) {
            PreloadTrendingData a = PreloadTrendingData.n.a();
            BaseQuickAdapter baseQuickAdapter3 = this.mAdapter;
            if (baseQuickAdapter3 == null) {
                Intrinsics.y("mAdapter");
            } else {
                baseQuickAdapter2 = baseQuickAdapter3;
            }
            a.b0(baseQuickAdapter2.getData());
            outState.putBoolean("operate_items", true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*com.transsion.baseui.fragment.BaseFragment*/.onViewCreated(view, savedInstanceState);
        AppStartReport.a.e(new AppStartDotState(AppStartDotState.TRENDING_RENDER, 0L, 2, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void p0() {
        RecyclerView recyclerView;
        x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.d) == null) {
            return;
        }
        recyclerView.smoothScrollToPosition(0);
    }
}
