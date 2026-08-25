package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.therouter.TheRouter;
import com.tn.lib.view.DefaultView;
import com.tn.lib.widget.TnTextView;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.flow.bean.CommentBean;
import com.transsion.flow.bean.PostSubjectBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.ninegridview.R$string;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R;
import com.transsion.postdetail.control.VideoPagerChangeControl;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.ui.fragment.preload.VideoDataLoader;
import com.transsion.postdetail.ui.fragment.preload.VideoImmersiveDataLoaderV2;
import com.transsion.postdetail.ui.view.ImmVideoLoadMoreView;
import com.transsion.postdetail.ui.view.ImmVideoNoNetworkView;
import com.transsion.postdetail.util.PostSaveHelper;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.push.bean.MsgStyle;
import com.transsion.shorttv.base.pager.PagerLayoutManager;
import fh.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import wf.a;
import yg.m;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u009f\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002 \u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0006J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u0006J\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u0006J\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u0006J\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0007H\u0002¢\u0006\u0004\b(\u0010\u0006J\u000f\u0010)\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010\u0006J\u0017\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0007H\u0002¢\u0006\u0004\b.\u0010\u0006J\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u0010\u0006J\u0017\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0019\u00106\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00109\u001a\u000208H\u0016¢\u0006\u0004\b9\u0010:J!\u0010<\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00162\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b<\u0010=J!\u0010>\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00162\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b>\u0010=J\u000f\u0010?\u001a\u00020\u0007H\u0016¢\u0006\u0004\b?\u0010\u0006J\u000f\u0010@\u001a\u00020\u0007H\u0016¢\u0006\u0004\b@\u0010\u0006J\u000f\u0010A\u001a\u00020\u0007H\u0016¢\u0006\u0004\bA\u0010\u0006J\u0017\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020%H\u0016¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0007H\u0016¢\u0006\u0004\bE\u0010\u0006J\u000f\u0010F\u001a\u00020\u0007H\u0016¢\u0006\u0004\bF\u0010\u0006J\u000f\u0010G\u001a\u00020\u0007H\u0016¢\u0006\u0004\bG\u0010\u0006J\u0017\u0010I\u001a\u00020\u00072\u0006\u0010H\u001a\u000204H\u0016¢\u0006\u0004\bI\u00107J\u000f\u0010J\u001a\u00020\u0007H\u0016¢\u0006\u0004\bJ\u0010\u0006J\u0017\u0010M\u001a\u00020\u00072\u0006\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020\u00072\u0006\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bO\u0010NJ1\u0010U\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u001f2\u0010\u0010R\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010#0Q2\u0006\u0010T\u001a\u00020SH\u0016¢\u0006\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010XR\u0016\u0010Z\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R$\u0010^\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010X\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010XR\u0016\u0010d\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010[R\u0016\u0010e\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010]R\u0016\u0010f\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010XR\u0018\u0010g\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010XR\u001b\u0010m\u001a\u00020h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u001d\u0010r\u001a\u0004\u0018\u00010n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010j\u001a\u0004\bp\u0010qR\u0018\u0010t\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010w\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010z\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010}\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u001b\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0082\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010]R\u0018\u0010\u0083\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010]R\u0018\u0010\u0084\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010]R\u0018\u0010\u0085\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010]R/\u0010\u0088\u0001\u001a\u0018\u0012\u0004\u0012\u00020*\u0018\u00010\u0086\u0001j\u000b\u0012\u0004\u0012\u00020*\u0018\u0001`\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008a\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010]R\u0018\u0010\u008b\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010]R\u0018\u0010\u008c\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010[R\u0018\u0010\u008d\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010[R\u0018\u0010\u008e\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010]R\u0018\u0010\u008f\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010[R#\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020#0\u0090\u00018\u0006¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R*\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001¨\u0006¡\u0001"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/VideoFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lwn/o;", "Lim/f;", "Lcom/tn/lib/widget/dialog/TRDialogListener;", "<init>", "()V", BuildConfig.FLAVOR, "initPlayer", "initAdapter", "initViewModel", "initBack", "initAudioListener", "observeRemoveVideo", "Lcom/transsion/moviedetailapi/bean/PostSubjectBean;", "subjectBean", "updateData", "(Lcom/transsion/moviedetailapi/bean/PostSubjectBean;)V", "showNotNetError", "showEmpty", "Landroid/content/Context;", "context", "Landroid/view/View;", "getEmptyView", "(Landroid/content/Context;)Landroid/view/View;", "getNotNetErrorView", "hideProgress", "showProgress", "loadMore", "loadData", "doLoadData", BuildConfig.FLAVOR, "it", "scrollToPosition", "(I)V", BuildConfig.FLAVOR, "itemType", BuildConfig.FLAVOR, "checkItemType", "(Ljava/lang/String;)Z", "localLogPause", "initAd", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "item", "setPTParams", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "initNonAd", "showSettingDialog", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)Lwn/o;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "onResume", "onPause", "hidden", "onHiddenChanged", "(Z)V", "logPause", "logResume", "onDestroy", "outState", "onSaveInstanceState", "onMemberStateChange", "Lcom/tn/lib/widget/dialog/TRDialog;", "dialog", "onLeftButtonClick", "(Lcom/tn/lib/widget/dialog/TRDialog;)V", "onRightButtonClick", "requestCode", BuildConfig.FLAVOR, "permissions", BuildConfig.FLAVOR, "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "mPostId", "Ljava/lang/String;", "mItemType", "mTabId", "I", "fromComment", "Z", "tran_ops", "getTran_ops", "()Ljava/lang/String;", "setTran_ops", "(Ljava/lang/String;)V", "mNextPage", "mPerPage", "videoLoadMore", "commentId", "pageFrom", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "mVideoViewModel$delegate", "Lkotlin/Lazy;", "getMVideoViewModel", "()Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "mVideoViewModel", "Lep/a;", "mAudioApi$delegate", "getMAudioApi", "()Lep/a;", "mAudioApi", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "mPagerLayoutManager", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "Lcom/transsion/postdetail/control/VideoPagerChangeControl;", "mPagerChangeControl", "Lcom/transsion/postdetail/control/VideoPagerChangeControl;", "Lcom/transsion/postdetail/ui/adapter/d;", "mAdapter", "Lcom/transsion/postdetail/ui/adapter/d;", "Lcom/transsion/player/orplayer/f;", "mOrPlayer", "Lcom/transsion/player/orplayer/f;", "Lcom/transsion/player/ui/ORPlayerView;", "mOrPlayerView", "Lcom/transsion/player/ui/ORPlayerView;", "isLoadingData", "isFirstLoadMore", "attachToMain", "needBackToRoom", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "downloadedShortsList", "Ljava/util/ArrayList;", "prioritizeDownloaded", "isFromDownloaded", "currentDownloadedIndex", "startDownloadedIndex", "hasShownOnlineToast", "savedCurrentIndex", BuildConfig.FLAVOR, "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", BuildConfig.FLAVOR, "resumeTimeStamp", "J", "getResumeTimeStamp", "()J", "setResumeTimeStamp", "(J)V", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "v3ListManager", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "Companion", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class VideoFragment extends BaseFragment<wn.o> implements im.f, TRDialogListener {
    private static final String CURRENT_INDEX = "CURRENT_INDEX";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String PAGE_NAME = "postdetail_video";
    private boolean attachToMain;
    private int currentDownloadedIndex;
    private ArrayList<PostSubjectItem> downloadedShortsList;
    private boolean fromComment;
    private boolean hasShownOnlineToast;
    private boolean isFirstLoadMore;
    private boolean isFromDownloaded;
    private boolean isLoadingData;
    private final List<String> list;
    private com.transsion.postdetail.ui.adapter.d mAdapter;

    /* renamed from: mAudioApi$delegate, reason: from kotlin metadata */
    private final Lazy mAudioApi;
    private com.transsion.player.orplayer.f mOrPlayer;
    private ORPlayerView mOrPlayerView;
    private VideoPagerChangeControl mPagerChangeControl;
    private PagerLayoutManager mPagerLayoutManager;
    private int mTabId;

    /* renamed from: mVideoViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mVideoViewModel;
    private boolean needBackToRoom;
    private String pageFrom;
    private boolean prioritizeDownloaded;
    private long resumeTimeStamp;
    private int savedCurrentIndex;
    private int startDownloadedIndex;
    private String tran_ops;
    private BiddingListManager v3ListManager;
    private boolean videoLoadMore;
    private String mPostId = BuildConfig.FLAVOR;
    private String mItemType = BuildConfig.FLAVOR;
    private String mNextPage = MsgStyle.CUSTOM_LEFT_PIC;
    private int mPerPage = 5;
    private String commentId = BuildConfig.FLAVOR;

    /* renamed from: com.transsion.postdetail.ui.fragment.VideoFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoFragment a(String str, String str2, Integer num, boolean z, boolean z2, String str3, boolean z3, String str4, String str5, boolean z4, ArrayList arrayList, boolean z5, boolean z6) {
            int c;
            VideoFragment videoFragment = new VideoFragment();
            if (str == null || str.length() == 0) {
                c = am.e.a.c(new VideoImmersiveDataLoaderV2(str5, "0", MsgStyle.CUSTOM_LEFT_PIC, 5));
            } else {
                c = am.e.a.c(new VideoDataLoader(str));
            }
            videoFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("id", str), TuplesKt.a("item_type", str2), TuplesKt.a("tab_id", num), TuplesKt.a("video_load_more", Boolean.valueOf(z)), TuplesKt.a("from_comment", Boolean.valueOf(z2)), TuplesKt.a("rec_ops", str3), TuplesKt.a("attach_to_main", Boolean.valueOf(z3)), TuplesKt.a("yy_preload_id", Integer.valueOf(c)), TuplesKt.a("comment_id", str4), TuplesKt.a("page_from", str5), TuplesKt.a("need_back_to_room", Boolean.valueOf(z4)), TuplesKt.a("downloaded_shorts_list", arrayList), TuplesKt.a("prioritize_downloaded", Boolean.valueOf(z5)), TuplesKt.a("is_from_downloaded", Boolean.valueOf(z6))}));
            return videoFragment;
        }
    }

    public static final class b extends androidx.activity.u {
        b() {
            super(true);
        }

        public void handleOnBackPressed() {
            if (VideoFragment.this.needBackToRoom) {
                ep.k.i(ep.k.a, null, null, null, false, 15, null);
            }
            FragmentActivity activity = VideoFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static final class c implements yg.m {
        c() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            t6.f h0;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            if (((PostSubjectBean) VideoFragment.this.getMVideoViewModel().v().f()) == null) {
                VideoFragment.this.loadData();
                return;
            }
            com.transsion.postdetail.ui.adapter.d dVar = VideoFragment.this.mAdapter;
            if (((dVar == null || (h0 = dVar.h0()) == null) ? null : h0.i()) == LoadMoreStatus.Fail) {
                VideoFragment.this.loadMore();
            }
        }

        public void onDisconnected() {
        }
    }

    public static final class d extends VideoPagerChangeControl {
        d(boolean z, com.transsion.postdetail.ui.adapter.d dVar, com.transsion.player.orplayer.f fVar, ORPlayerView oRPlayerView, PagerLayoutManager pagerLayoutManager, String str) {
            super(VideoFragment.this, z, dVar, fVar, oRPlayerView, pagerLayoutManager, str);
        }

        @Override // com.transsion.postdetail.control.VideoPagerChangeControl, gr.a
        public void f(int i, boolean z, View view) {
            super.f(i, z, view);
            if (VideoFragment.this.isFromDownloaded) {
                ArrayList arrayList = VideoFragment.this.downloadedShortsList;
                int size = VideoFragment.this.startDownloadedIndex >= 0 ? (arrayList != null ? arrayList.size() : 0) - VideoFragment.this.startDownloadedIndex : 0;
                if (size <= 0 || i < size) {
                    VideoFragment.this.hasShownOnlineToast = false;
                } else {
                    if (VideoFragment.this.hasShownOnlineToast) {
                        return;
                    }
                    VideoFragment.this.hasShownOnlineToast = true;
                    com.transsion.baseui.util.m.a(R.string.shorts_view_online_content);
                    com.transsion.baselib.helper.a.a.c(VideoFragment.PAGE_NAME, "online");
                }
            }
        }
    }

    public static final class e extends RecyclerView.r {
        private long a;

        e() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            List data;
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            if (!VideoFragment.this.isFromDownloaded || yg.l.a.e() || i == 0) {
                return;
            }
            VideoPagerChangeControl videoPagerChangeControl = VideoFragment.this.mPagerChangeControl;
            int i2 = 0;
            int h = videoPagerChangeControl != null ? videoPagerChangeControl.h() : 0;
            com.transsion.postdetail.ui.adapter.d dVar = VideoFragment.this.mAdapter;
            if (dVar != null && (data = dVar.getData()) != null) {
                i2 = data.size();
            }
            boolean canScrollVertically = recyclerView.canScrollVertically(1);
            if (h < i2 - 1 || canScrollVertically) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.a > 2000) {
                this.a = currentTimeMillis;
                com.transsion.baseui.util.m.d(R.string.shorts_no_more_downloaded);
                com.transsion.baselib.helper.a.a.c(VideoFragment.PAGE_NAME, "offline");
            }
        }
    }

    static final class f implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        f(Function1 function1) {
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

    public VideoFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m125invoke() {
                return this;
            }
        };
        this.mVideoViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(PostDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.x0 m126invoke() {
                androidx.lifecycle.x0 viewModelStore = ((androidx.lifecycle.y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m127invoke() {
                Object invoke = function0.invoke();
                androidx.lifecycle.m mVar = invoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mAudioApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.c6
            public final Object invoke() {
                ep.a mAudioApi_delegate$lambda$0;
                mAudioApi_delegate$lambda$0 = VideoFragment.mAudioApi_delegate$lambda$0();
                return mAudioApi_delegate$lambda$0;
            }
        });
        this.isFirstLoadMore = true;
        this.currentDownloadedIndex = -1;
        this.savedCurrentIndex = -1;
        this.list = CollectionsKt.e(PostItemType.SUBJECT.getValue());
    }

    private final boolean checkItemType(String itemType) {
        return this.list.contains(itemType);
    }

    private final void doLoadData() {
        ArrayList<PostSubjectItem> arrayList;
        if (this.isLoadingData) {
            return;
        }
        if (this.prioritizeDownloaded && (arrayList = this.downloadedShortsList) != null && !arrayList.isEmpty()) {
            int i = this.currentDownloadedIndex + 1;
            this.currentDownloadedIndex = i;
            ArrayList<PostSubjectItem> arrayList2 = this.downloadedShortsList;
            Intrinsics.e(arrayList2);
            if (i < arrayList2.size()) {
                ArrayList<PostSubjectItem> arrayList3 = this.downloadedShortsList;
                Intrinsics.e(arrayList3);
                PostSubjectItem postSubjectItem = arrayList3.get(this.currentDownloadedIndex);
                Intrinsics.g(postSubjectItem, "get(...)");
                updateData(new PostSubjectBean(CollectionsKt.q(new PostSubjectItem[]{postSubjectItem}), null, null, null));
                return;
            }
            this.prioritizeDownloaded = false;
        }
        this.isLoadingData = true;
        PostDetailViewModel mVideoViewModel = getMVideoViewModel();
        String str = this.mPostId;
        mVideoViewModel.u(str, this.mTabId, this.mNextPage, this.mPerPage, this.videoLoadMore, (this.attachToMain && (str == null || str.length() == 0)) ? 1 : 0);
    }

    private final View getEmptyView(Context context) {
        final DefaultView defaultView = new DefaultView(context, DefaultView.ModelStyle.MODEL_STYLE_NIGHT);
        defaultView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        defaultView.setGravity(17);
        defaultView.setDefaultImageViewVisibility(0);
        defaultView.setDefaultImage(com.tn.lib.widget.R.mipmap.ic_no_content);
        String string = context.getString(com.tn.lib.widget.R.string.no_content);
        Intrinsics.g(string, "getString(...)");
        defaultView.setDescText(string);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DESC_BTN);
        defaultView.setBtnVisibility(0);
        String string2 = context.getString(com.transsion.baseui.R.string.retry_text);
        Intrinsics.g(string2, "getString(...)");
        defaultView.setBtnText(string2);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.d6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFragment.getEmptyView$lambda$20$lambda$19(VideoFragment.this, defaultView, view);
            }
        });
        defaultView.setVisibility(0);
        return defaultView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getEmptyView$lambda$20$lambda$19(VideoFragment videoFragment, DefaultView defaultView, View view) {
        videoFragment.loadData();
        defaultView.setVisibility(8);
    }

    private final ep.a getMAudioApi() {
        return (ep.a) this.mAudioApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostDetailViewModel getMVideoViewModel() {
        return (PostDetailViewModel) this.mVideoViewModel.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.transsion.postdetail.ui.view.ImmVideoNoNetworkView] */
    private final View getNotNetErrorView(Context context) {
        final ?? immVideoNoNetworkView = new ImmVideoNoNetworkView(context);
        uf.c.e((View) immVideoNoNetworkView);
        immVideoNoNetworkView.retry(new Function0() { // from class: com.transsion.postdetail.ui.fragment.r5
            public final Object invoke() {
                Unit notNetErrorView$lambda$23$lambda$21;
                notNetErrorView$lambda$23$lambda$21 = VideoFragment.getNotNetErrorView$lambda$23$lambda$21(ImmVideoNoNetworkView.this, this);
                return notNetErrorView$lambda$23$lambda$21;
            }
        });
        immVideoNoNetworkView.goToSetting(new Function0() { // from class: com.transsion.postdetail.ui.fragment.s5
            public final Object invoke() {
                Unit notNetErrorView$lambda$23$lambda$22;
                notNetErrorView$lambda$23$lambda$22 = VideoFragment.getNotNetErrorView$lambda$23$lambda$22();
                return notNetErrorView$lambda$23$lambda$22;
            }
        });
        com.tn.lib.view.o.a(PAGE_NAME);
        return immVideoNoNetworkView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit getNotNetErrorView$lambda$23$lambda$21(ImmVideoNoNetworkView immVideoNoNetworkView, VideoFragment videoFragment) {
        uf.c.g(immVideoNoNetworkView);
        videoFragment.showProgress();
        videoFragment.loadData();
        com.tn.lib.view.o.b(PAGE_NAME);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNotNetErrorView$lambda$23$lambda$22() {
        com.tn.lib.view.o.c(PAGE_NAME);
        return Unit.a;
    }

    private final void hideProgress() {
        ProgressBar progressBar;
        wn.o oVar = (wn.o) getMViewBinding();
        if (oVar == null || (progressBar = oVar.c) == null) {
            return;
        }
        uf.c.g(progressBar);
    }

    private final void initAd() {
        BiddingListManager biddingListManager = new BiddingListManager();
        this.v3ListManager = biddingListManager;
        wn.o oVar = (wn.o) getMViewBinding();
        biddingListManager.F(oVar != null ? oVar.d : null);
        BiddingListManager biddingListManager2 = this.v3ListManager;
        if (biddingListManager2 != null) {
            biddingListManager2.A(androidx.lifecycle.v.a(this));
        }
        BiddingListManager biddingListManager3 = this.v3ListManager;
        if (biddingListManager3 != null) {
            biddingListManager3.G("VideoForYouListScene");
        }
        BiddingListManager biddingListManager4 = this.v3ListManager;
        if (biddingListManager4 != null) {
            biddingListManager4.z(new Function2() { // from class: com.transsion.postdetail.ui.fragment.u5
                public final Object invoke(Object obj, Object obj2) {
                    Unit initAd$lambda$28;
                    initAd$lambda$28 = VideoFragment.initAd$lambda$28(VideoFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                    return initAd$lambda$28;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAd$lambda$28(VideoFragment videoFragment, int i, BiddingNativeManager biddingNativeManager) {
        List data;
        Intrinsics.h(biddingNativeManager, "current");
        if (biddingNativeManager != null) {
            PostSubjectItem postSubjectItem = new PostSubjectItem((String) null, (String) null, (Group) null, (Boolean) null, (Boolean) null, (Link) null, (Media) null, (String) null, (Stat) null, (Integer) null, (Subject) null, (Integer) null, (String) null, (String) null, (User) null, (String) null, (String) null, (Integer) null, (String) null, false, (Float) null, (Float) null, (String) null, (String) null, false, (List) null, false, (BiddingNativeManager) null, false, false, false, false, (CommentBean) null, -1, 1, (DefaultConstructorMarker) null);
            postSubjectItem.setNonAdDelegate(biddingNativeManager);
            com.transsion.postdetail.ui.adapter.d dVar = videoFragment.mAdapter;
            int size = (dVar == null || (data = dVar.getData()) == null) ? 0 : data.size();
            if (i <= size) {
                com.transsion.postdetail.ui.adapter.d dVar2 = videoFragment.mAdapter;
                if (dVar2 != null) {
                    dVar2.n(i, postSubjectItem);
                }
            } else {
                com.transsion.postdetail.ui.adapter.d dVar3 = videoFragment.mAdapter;
                if (dVar3 != null) {
                    dVar3.n(size, postSubjectItem);
                }
            }
        }
        return Unit.a;
    }

    private final void initAdapter() {
        ArrayList arrayList = new ArrayList();
        boolean z = this.videoLoadMore;
        String str = this.mPostId;
        String str2 = this.mItemType;
        boolean z2 = this.attachToMain;
        String str3 = this.commentId;
        String str4 = this.pageFrom;
        if (str4 == null) {
            str4 = BuildConfig.FLAVOR;
        }
        com.transsion.postdetail.ui.adapter.d dVar = new com.transsion.postdetail.ui.adapter.d(arrayList, this, z, str, str2, z2, str3, str4, this.isFromDownloaded);
        dVar.h0().z(this.videoLoadMore);
        if (this.videoLoadMore) {
            dVar.h0().C(new ImmVideoLoadMoreView());
            dVar.h0().z(true);
            dVar.h0().y(true);
            dVar.h0().E(2);
            dVar.h0().D(new r6.f() { // from class: com.transsion.postdetail.ui.fragment.t5
                public final void a() {
                    VideoFragment.initAdapter$lambda$7$lambda$6(VideoFragment.this);
                }
            });
        }
        this.mAdapter = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$7$lambda$6(final VideoFragment videoFragment) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ArrayList<PostSubjectItem> arrayList;
        boolean e2 = yg.l.a.e();
        boolean z = (!videoFragment.prioritizeDownloaded || (arrayList = videoFragment.downloadedShortsList) == null || arrayList.isEmpty()) ? false : true;
        if (!e2 && !z) {
            wn.o oVar = (wn.o) videoFragment.getMViewBinding();
            if (oVar == null || (recyclerView2 = oVar.d) == null) {
                return;
            }
            recyclerView2.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.y5
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFragment.initAdapter$lambda$7$lambda$6$lambda$5(VideoFragment.this);
                }
            }, 500L);
            return;
        }
        if (videoFragment.isFirstLoadMore) {
            videoFragment.isFirstLoadMore = false;
            videoFragment.loadMore();
            return;
        }
        wn.o oVar2 = (wn.o) videoFragment.getMViewBinding();
        if (oVar2 == null || (recyclerView = oVar2.d) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.x5
            @Override // java.lang.Runnable
            public final void run() {
                VideoFragment.this.loadMore();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$7$lambda$6$lambda$5(VideoFragment videoFragment) {
        t6.f h0;
        videoFragment.isLoadingData = false;
        com.transsion.postdetail.ui.adapter.d dVar = videoFragment.mAdapter;
        if (dVar == null || (h0 = dVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    private final void initAudioListener() {
        ep.a mAudioApi = getMAudioApi();
        if (mAudioApi != null) {
            mAudioApi.pause();
        }
    }

    private final void initBack() {
        AppCompatImageView appCompatImageView;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView2;
        ConstraintLayout constraintLayout;
        wn.o oVar = (wn.o) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (oVar == null || (constraintLayout = oVar.e) == null) ? null : constraintLayout.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = com.blankj.utilcode.util.d.c();
        if (this.mPostId.length() == 0) {
            wn.o oVar2 = (wn.o) getMViewBinding();
            if (oVar2 == null || (appCompatImageView2 = oVar2.b) == null) {
                return;
            }
            uf.c.g(appCompatImageView2);
            return;
        }
        wn.o oVar3 = (wn.o) getMViewBinding();
        if (oVar3 != null && (tnTextView = oVar3.f) != null) {
            uf.c.g(tnTextView);
        }
        wn.o oVar4 = (wn.o) getMViewBinding();
        if (oVar4 != null && (appCompatImageView = oVar4.b) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.q5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoFragment.initBack$lambda$11(VideoFragment.this, view);
                }
            });
        }
        requireActivity().getOnBackPressedDispatcher().i(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBack$lambda$11(VideoFragment videoFragment, View view) {
        if (videoFragment.needBackToRoom) {
            ep.k.i(ep.k.a, null, null, null, false, 15, null);
        }
        videoFragment.requireActivity().finish();
    }

    private final void initNonAd() {
    }

    private final void initPlayer() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        this.mOrPlayer = new f.a(requireContext).b(new hn.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, true, false, false, false, null, 126975, null)).a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        ORPlayerView oRPlayerView = new ORPlayerView(requireActivity, RenderType.TEXTURE_VIEW);
        this.mOrPlayerView = oRPlayerView;
        com.transsion.player.orplayer.f fVar = this.mOrPlayer;
        if (fVar != null) {
            fVar.setTextureView(oRPlayerView.getTextureView());
        }
        com.transsion.player.orplayer.f fVar2 = this.mOrPlayer;
        if (fVar2 != null) {
            fVar2.setLooping(true);
        }
    }

    private final void initViewModel() {
        getMVideoViewModel().v().j(this, new f(new Function1() { // from class: com.transsion.postdetail.ui.fragment.z5
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$8;
                initViewModel$lambda$8 = VideoFragment.initViewModel$lambda$8(VideoFragment.this, (PostSubjectBean) obj);
                return initViewModel$lambda$8;
            }
        }));
        getMVideoViewModel().t().j(this, new f(new Function1() { // from class: com.transsion.postdetail.ui.fragment.a6
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$9;
                initViewModel$lambda$9 = VideoFragment.initViewModel$lambda$9(VideoFragment.this, (String) obj);
                return initViewModel$lambda$9;
            }
        }));
        if (this.attachToMain) {
            ImmVideoHelper.h.a().i().j(this, new f(new Function1() { // from class: com.transsion.postdetail.ui.fragment.b6
                public final Object invoke(Object obj) {
                    Unit initViewModel$lambda$10;
                    initViewModel$lambda$10 = VideoFragment.initViewModel$lambda$10(VideoFragment.this, (List) obj);
                    return initViewModel$lambda$10;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$10(VideoFragment videoFragment, List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            videoFragment.showProgress();
            videoFragment.loadData();
        } else {
            a.a.f(wf.a.a, PAGE_NAME, "get cache " + ((PostSubjectItem) list.get(0)).getTitle(), false, 4, (Object) null);
            videoFragment.updateData(new PostSubjectBean(CollectionsKt.U0(list), null, null, null));
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$8(VideoFragment videoFragment, PostSubjectBean postSubjectBean) {
        t6.f h0;
        com.transsion.postdetail.ui.adapter.d dVar;
        t6.f h02;
        List data;
        videoFragment.isLoadingData = false;
        if (postSubjectBean == null) {
            com.transsion.postdetail.ui.adapter.d dVar2 = videoFragment.mAdapter;
            if (dVar2 == null || (data = dVar2.getData()) == null || data.size() != 0) {
                com.transsion.postdetail.ui.adapter.d dVar3 = videoFragment.mAdapter;
                if (dVar3 != null && (h0 = dVar3.h0()) != null && h0.r() && (dVar = videoFragment.mAdapter) != null && (h02 = dVar.h0()) != null) {
                    h02.v();
                }
            } else if (yg.l.a.e()) {
                videoFragment.showEmpty();
            } else {
                videoFragment.showNotNetError();
            }
        } else {
            qi.b logViewConfig = videoFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            videoFragment.updateData(postSubjectBean);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$9(VideoFragment videoFragment, String str) {
        if (TextUtils.equals("0", str)) {
            gx.b.a.a().e(videoFragment.mPostId);
            FragmentActivity activity = videoFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else {
            b.a aVar = fh.b.a;
            FragmentActivity activity2 = videoFragment.getActivity();
            aVar.e(activity2 != null ? activity2.getString(R.string.delete_post_failed) : null);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        doLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMore() {
        loadData();
    }

    private final void localLogPause() {
        HashMap g;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        qi.b logViewConfig = getLogViewConfig();
        long h = elapsedRealtime - (logViewConfig != null ? logViewConfig.h() : 0L);
        qi.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 == null || (g = logViewConfig2.g()) == null) {
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.a mAudioApi_delegate$lambda$0() {
        return (ep.a) TheRouter.d(ep.a.class, new Object[0]);
    }

    private final void observeRemoveVideo() {
        getMVideoViewModel().C().j(this, new f(new Function1() { // from class: com.transsion.postdetail.ui.fragment.v5
            public final Object invoke(Object obj) {
                Unit observeRemoveVideo$lambda$13;
                observeRemoveVideo$lambda$13 = VideoFragment.observeRemoveVideo$lambda$13(VideoFragment.this, (Integer) obj);
                return observeRemoveVideo$lambda$13;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeRemoveVideo$lambda$13(final VideoFragment videoFragment, final Integer num) {
        RecyclerView recyclerView;
        try {
            if (num.intValue() >= 0) {
                VideoPagerChangeControl videoPagerChangeControl = videoFragment.mPagerChangeControl;
                if (videoPagerChangeControl != null) {
                    videoPagerChangeControl.n();
                }
                com.transsion.postdetail.ui.adapter.d dVar = videoFragment.mAdapter;
                if (dVar != null) {
                    Intrinsics.e(num);
                    dVar.G0(num.intValue());
                }
                wn.o oVar = (wn.o) videoFragment.getMViewBinding();
                if (oVar != null && (recyclerView = oVar.d) != null) {
                    recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.w5
                        @Override // java.lang.Runnable
                        public final void run() {
                            VideoFragment.observeRemoveVideo$lambda$13$lambda$12(VideoFragment.this, num);
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeRemoveVideo$lambda$13$lambda$12(VideoFragment videoFragment, Integer num) {
        RecyclerView.a0 a0Var;
        RecyclerView recyclerView;
        Integer num2;
        wn.o oVar = (wn.o) videoFragment.getMViewBinding();
        if (oVar == null || (recyclerView = oVar.d) == null) {
            a0Var = null;
        } else {
            com.transsion.postdetail.ui.adapter.d dVar = videoFragment.mAdapter;
            if (dVar != null) {
                int a0 = dVar.a0();
                Intrinsics.e(num);
                num2 = Integer.valueOf(a0 + num.intValue());
            } else {
                num2 = num;
            }
            Intrinsics.e(num2);
            a0Var = recyclerView.findViewHolderForAdapterPosition(num2.intValue());
        }
        VideoPagerChangeControl videoPagerChangeControl = videoFragment.mPagerChangeControl;
        if (videoPagerChangeControl != null) {
            Intrinsics.e(num);
            videoPagerChangeControl.f(num.intValue(), true, a0Var != null ? a0Var.itemView : null);
        }
    }

    private final void scrollToPosition(final int it) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        List data;
        com.transsion.postdetail.ui.adapter.d dVar = this.mAdapter;
        if (((dVar == null || (data = dVar.getData()) == null) ? 0 : data.size()) <= it) {
            return;
        }
        wn.o oVar = (wn.o) getMViewBinding();
        if (oVar != null && (recyclerView2 = oVar.d) != null) {
            recyclerView2.scrollToPosition(it);
        }
        wn.o oVar2 = (wn.o) getMViewBinding();
        if (oVar2 == null || (recyclerView = oVar2.d) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.p5
            @Override // java.lang.Runnable
            public final void run() {
                VideoFragment.scrollToPosition$lambda$26(VideoFragment.this, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollToPosition$lambda$26(VideoFragment videoFragment, int i) {
        PagerLayoutManager pagerLayoutManager = videoFragment.mPagerLayoutManager;
        if (pagerLayoutManager != null) {
            View T = pagerLayoutManager.T();
            if (T != null) {
                a.a.r(wf.a.a, "ImmVideoPlayer", new String[]{"initView2， scrollToPosition ：" + i}, false, 4, (Object) null);
                VideoPagerChangeControl videoPagerChangeControl = videoFragment.mPagerChangeControl;
                if (videoPagerChangeControl != null) {
                    videoPagerChangeControl.f(i, true, T);
                    return;
                }
                return;
            }
            int childCount = pagerLayoutManager.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = pagerLayoutManager.getChildAt(i2);
                if (childAt != null && pagerLayoutManager.getPosition(childAt) == i) {
                    a.a.r(wf.a.a, "ImmVideoPlayer", new String[]{"initView， scrollToPosition ：" + i}, false, 4, (Object) null);
                    VideoPagerChangeControl videoPagerChangeControl2 = videoFragment.mPagerChangeControl;
                    if (videoPagerChangeControl2 != null) {
                        videoPagerChangeControl2.f(i, true, childAt);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private final void setPTParams(PostSubjectItem item) {
        HashMap g;
        HashMap g2;
        HashMap g3;
        String str;
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        qi.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null) {
            logViewConfig2.n(item.getRec_ops());
        }
        qi.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (g3 = logViewConfig3.g()) != null) {
            Media media = item.getMedia();
            if (media == null || (str = media.getMediaType()) == null) {
                str = BuildConfig.FLAVOR;
            }
            g3.put("post_media_type", str);
        }
        qi.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (g2 = logViewConfig4.g()) != null) {
            Subject subject = item.getSubject();
            g2.put("subject_id", subject != null ? subject.getSubjectId() : null);
        }
        qi.b logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 == null || (g = logViewConfig5.g()) == null) {
            return;
        }
        Subject subject2 = item.getSubject();
        g.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
    }

    private final void showEmpty() {
        com.transsion.postdetail.ui.adapter.d dVar;
        List data;
        hideProgress();
        com.transsion.postdetail.ui.adapter.d dVar2 = this.mAdapter;
        if (dVar2 == null || (data = dVar2.getData()) == null || !(!data.isEmpty())) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            View emptyView = getEmptyView(requireContext);
            if (emptyView == null || (dVar = this.mAdapter) == null) {
                return;
            }
            dVar.Y0(emptyView);
        }
    }

    private final void showNotNetError() {
        com.transsion.postdetail.ui.adapter.d dVar;
        TnTextView tnTextView;
        List data;
        hideProgress();
        com.transsion.postdetail.ui.adapter.d dVar2 = this.mAdapter;
        if (dVar2 == null || (data = dVar2.getData()) == null || !(!data.isEmpty())) {
            wn.o oVar = (wn.o) getMViewBinding();
            if (oVar != null && (tnTextView = oVar.f) != null) {
                uf.c.g(tnTextView);
            }
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            View notNetErrorView = getNotNetErrorView(requireContext);
            if (notNetErrorView == null || (dVar = this.mAdapter) == null) {
                return;
            }
            dVar.Y0(notNetErrorView);
        }
    }

    private final void showProgress() {
        ProgressBar progressBar;
        wn.o oVar = (wn.o) getMViewBinding();
        if (oVar == null || (progressBar = oVar.c) == null) {
            return;
        }
        uf.c.k(progressBar);
    }

    private final void showSettingDialog() {
        String string = Utils.a().getString(R$string.permission_deny_down_tip, "\"" + Utils.a().getString(com.transsion.baseui.R.string.base_app_name) + "\"", "\"" + Utils.a().getString(R$string.system_settings) + "\"");
        Intrinsics.g(string, "getString(...)");
        TRDialog.a g = new TRDialog.a().g(string);
        String string2 = Utils.a().getString(R$string.cancel);
        Intrinsics.g(string2, "getString(...)");
        TRDialog.a e2 = g.e(string2);
        String string3 = Utils.a().getString(R$string.system_settings);
        Intrinsics.g(string3, "getString(...)");
        e2.j(string3).f(this).a().show(getChildFragmentManager(), "settings");
    }

    private final void updateData(PostSubjectBean subjectBean) {
        String str;
        com.transsion.postdetail.ui.adapter.d dVar;
        t6.f h0;
        t6.f h02;
        com.transsion.postdetail.ui.adapter.d dVar2;
        t6.f h03;
        hideProgress();
        Pager pager = subjectBean.getPager();
        if (pager == null || (str = pager.getNextPage()) == null) {
            str = MsgStyle.CUSTOM_LEFT_PIC;
        }
        this.mNextPage = str;
        List<PostSubjectItem> items = subjectBean.getItems();
        if (items != null) {
            Iterator<PostSubjectItem> it = items.iterator();
            while (it.hasNext()) {
                PostSubjectItem next = it.next();
                Media media = next.getMedia();
                if ((media != null ? media.getVideo() : null) != null) {
                    Media media2 = next.getMedia();
                    List video = media2 != null ? media2.getVideo() : null;
                    Intrinsics.e(video);
                    if (video.isEmpty()) {
                    }
                }
                it.remove();
            }
            com.transsion.postdetail.ui.adapter.d dVar3 = this.mAdapter;
            List data = dVar3 != null ? dVar3.getData() : null;
            ArrayList arrayList = new ArrayList();
            if (data == null || !(!data.isEmpty())) {
                arrayList.addAll(items);
            } else {
                PostSubjectItem postSubjectItem = (PostSubjectItem) CollectionsKt.k0(data);
                if (postSubjectItem != null) {
                    setPTParams(postSubjectItem);
                }
                for (PostSubjectItem postSubjectItem2 : items) {
                    if (data.contains(postSubjectItem2)) {
                        Subject subject = postSubjectItem2.getSubject();
                        if (subject != null) {
                            Integer subjectType = subject.getSubjectType();
                            int value = SubjectType.SHORT_TV.getValue();
                            if (subjectType != null && subjectType.intValue() == value) {
                            }
                        }
                        a.a.f(wf.a.a, "ImmVideoList", "find same item title..." + postSubjectItem2.getTitle() + " id  " + postSubjectItem2.getPostId(), false, 4, (Object) null);
                    }
                    arrayList.add(postSubjectItem2);
                }
            }
            com.transsion.postdetail.ui.adapter.d dVar4 = this.mAdapter;
            if (dVar4 != null) {
                dVar4.q(arrayList);
            }
            VideoPagerChangeControl videoPagerChangeControl = this.mPagerChangeControl;
            if (videoPagerChangeControl != null) {
                videoPagerChangeControl.k();
            }
            if (this.attachToMain) {
                ImmVideoHelper a = ImmVideoHelper.h.a();
                com.transsion.postdetail.ui.adapter.d dVar5 = this.mAdapter;
                a.r(dVar5 != null ? dVar5.getData() : null);
            }
        }
        com.transsion.postdetail.ui.adapter.d dVar6 = this.mAdapter;
        if (dVar6 != null && (h02 = dVar6.h0()) != null && h02.r() && (dVar2 = this.mAdapter) != null && (h03 = dVar2.h0()) != null) {
            h03.s();
        }
        Pager pager2 = subjectBean.getPager();
        if ((pager2 != null ? Intrinsics.c(pager2.getHasMore(), Boolean.FALSE) : false) && (dVar = this.mAdapter) != null && (h0 = dVar.h0()) != null) {
            t6.f.u(h0, false, 1, (Object) null);
        }
        int i = this.savedCurrentIndex;
        if (i >= 0) {
            scrollToPosition(i);
            this.savedCurrentIndex = -1;
        }
    }

    public final List<String> getList() {
        return this.list;
    }

    public final long getResumeTimeStamp() {
        return this.resumeTimeStamp;
    }

    public final String getTran_ops() {
        return this.tran_ops;
    }

    public wn.o getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        wn.o c2 = wn.o.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        if (r4 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initData(View view, Bundle savedInstanceState) {
        List g;
        ArrayList<PostSubjectItem> arrayList;
        String str;
        Intrinsics.h(view, "view");
        setNetListener(new c());
        initViewModel();
        PostSubjectBean B = getMVideoViewModel().B();
        if (B != null) {
            Pager pager = B.getPager();
            if (pager == null || (str = pager.getNextPage()) == null) {
                str = MsgStyle.CUSTOM_LEFT_PIC;
            }
            this.mNextPage = str;
            g = B.getItems();
        }
        g = ImmVideoHelper.h.a().g();
        if (g.isEmpty()) {
            if (this.attachToMain) {
                ImmVideoHelper.h.a().p();
                return;
            } else {
                showProgress();
                loadData();
                return;
            }
        }
        if (!this.isFromDownloaded || (arrayList = this.downloadedShortsList) == null || arrayList.isEmpty()) {
            PostSubjectItem postSubjectItem = (PostSubjectItem) CollectionsKt.k0(g);
            if (postSubjectItem != null) {
                setPTParams(postSubjectItem);
            }
            com.transsion.postdetail.ui.adapter.d dVar = this.mAdapter;
            if (dVar != null) {
                dVar.q(g);
                return;
            }
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<PostSubjectItem> arrayList3 = this.downloadedShortsList;
        Intrinsics.e(arrayList3);
        int size = arrayList3.size();
        for (int i = this.startDownloadedIndex; i < size; i++) {
            ArrayList<PostSubjectItem> arrayList4 = this.downloadedShortsList;
            Intrinsics.e(arrayList4);
            PostSubjectItem postSubjectItem2 = arrayList4.get(i);
            Intrinsics.g(postSubjectItem2, "get(...)");
            arrayList2.add(postSubjectItem2);
        }
        com.transsion.postdetail.ui.adapter.d dVar2 = this.mAdapter;
        if (dVar2 != null) {
            dVar2.n1(arrayList2);
        }
        this.prioritizeDownloaded = false;
    }

    public void initView(View view, Bundle savedInstanceState) {
        HashMap g;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Intrinsics.h(view, "view");
        int i = savedInstanceState != null ? savedInstanceState.getInt(CURRENT_INDEX) : -1;
        this.savedCurrentIndex = i;
        a.a.r(wf.a.a, "ImmVideoPlayer", new String[]{"initView， savedCurrentIndex ：" + i}, false, 4, (Object) null);
        initAd();
        initNonAd();
        initAdapter();
        initPlayer();
        initBack();
        initAudioListener();
        observeRemoveVideo();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        PagerLayoutManager pagerLayoutManager = new PagerLayoutManager(requireActivity);
        this.mPagerLayoutManager = pagerLayoutManager;
        d dVar = new d(this.fromComment, this.mAdapter, this.mOrPlayer, this.mOrPlayerView, pagerLayoutManager, this.pageFrom);
        this.mPagerChangeControl = dVar;
        PagerLayoutManager pagerLayoutManager2 = this.mPagerLayoutManager;
        if (pagerLayoutManager2 != null) {
            pagerLayoutManager2.X(dVar);
        }
        wn.o oVar = (wn.o) getMViewBinding();
        if (oVar != null && (recyclerView3 = oVar.d) != null) {
            recyclerView3.setLayoutManager(this.mPagerLayoutManager);
        }
        wn.o oVar2 = (wn.o) getMViewBinding();
        if (oVar2 != null && (recyclerView2 = oVar2.d) != null) {
            recyclerView2.setAdapter(this.mAdapter);
        }
        wn.o oVar3 = (wn.o) getMViewBinding();
        if (oVar3 != null && (recyclerView = oVar3.d) != null) {
            recyclerView.addOnScrollListener(new e());
        }
        ImmVideoHelper a = ImmVideoHelper.h.a();
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.g(requireActivity2, "requireActivity(...)");
        a.k(requireActivity2);
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g = logViewConfig.g()) == null) {
            return;
        }
    }

    public void lazyLoadData() {
    }

    public void logPause() {
        super.logPause();
        if (this.resumeTimeStamp != 0) {
            com.transsion.baselib.report.e.a.n(PAGE_NAME, Long.valueOf(SystemClock.elapsedRealtime() - this.resumeTimeStamp), getContext());
        }
    }

    public void logResume() {
        super.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    public qi.b newLogViewConfig() {
        return new qi.b(PAGE_NAME, false, 2, null);
    }

    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        HashMap g;
        HashMap g2;
        HashMap g3;
        ArrayList<PostSubjectItem> arrayList;
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str3 = BuildConfig.FLAVOR;
        if (arguments == null || (str = arguments.getString("id")) == null) {
            str = BuildConfig.FLAVOR;
        }
        this.mPostId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("comment_id")) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        this.commentId = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 != null && (string = arguments3.getString("item_type")) != null) {
            str3 = string;
        }
        this.mItemType = str3;
        Bundle arguments4 = getArguments();
        this.mTabId = arguments4 != null ? arguments4.getInt("tab_id") : 0;
        Bundle arguments5 = getArguments();
        this.videoLoadMore = arguments5 != null ? arguments5.getBoolean("video_load_more", true) : true;
        Bundle arguments6 = getArguments();
        this.fromComment = arguments6 != null ? arguments6.getBoolean("from_comment") : false;
        Bundle arguments7 = getArguments();
        this.tran_ops = arguments7 != null ? arguments7.getString("rec_ops") : null;
        Bundle arguments8 = getArguments();
        this.attachToMain = arguments8 != null ? arguments8.getBoolean("attach_to_main") : false;
        Bundle arguments9 = getArguments();
        this.pageFrom = arguments9 != null ? arguments9.getString("page_from") : null;
        Bundle arguments10 = getArguments();
        this.needBackToRoom = arguments10 != null ? arguments10.getBoolean("need_back_to_room") : false;
        Bundle arguments11 = getArguments();
        Serializable serializable = arguments11 != null ? arguments11.getSerializable("downloaded_shorts_list") : null;
        this.downloadedShortsList = serializable instanceof ArrayList ? (ArrayList) serializable : null;
        Bundle arguments12 = getArguments();
        this.prioritizeDownloaded = arguments12 != null ? arguments12.getBoolean("prioritize_downloaded") : false;
        Bundle arguments13 = getArguments();
        this.isFromDownloaded = arguments13 != null ? arguments13.getBoolean("is_from_downloaded") : false;
        if (this.prioritizeDownloaded && (arrayList = this.downloadedShortsList) != null && !arrayList.isEmpty()) {
            ArrayList<PostSubjectItem> arrayList2 = this.downloadedShortsList;
            int i = -1;
            if (arrayList2 != null) {
                Iterator<PostSubjectItem> it = arrayList2.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.c(it.next().getPostId(), this.mPostId)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            this.currentDownloadedIndex = i;
            if (i < 0) {
                i = 0;
            }
            this.startDownloadedIndex = i;
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g3 = logViewConfig.g()) != null) {
        }
        qi.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g2 = logViewConfig2.g()) != null) {
        }
        qi.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (g = logViewConfig3.g()) != null) {
        }
        PostDetailViewModel mVideoViewModel = getMVideoViewModel();
        if (mVideoViewModel != null) {
            Bundle arguments14 = getArguments();
            mVideoViewModel.F(arguments14 != null ? Integer.valueOf(arguments14.getInt("yy_preload_id")) : null, this.pageFrom);
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.D(this);
        }
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), (CoroutineContext) null, (CoroutineStart) null, new VideoFragment$onDestroy$1(this, null), 3, (Object) null);
        ImmVideoHelper.h.a().f();
        BiddingListManager biddingListManager = this.v3ListManager;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.v(this);
        }
    }

    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                com.transsion.player.orplayer.f fVar = this.mOrPlayer;
                if (fVar != null) {
                    fVar.pause();
                }
                logPause();
            } else {
                com.transsion.player.orplayer.f fVar2 = this.mOrPlayer;
                if (fVar2 != null) {
                    fVar2.play();
                }
                logResume();
            }
            VideoPagerChangeControl videoPagerChangeControl = this.mPagerChangeControl;
            if (videoPagerChangeControl != null) {
                videoPagerChangeControl.l(hidden);
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
    }

    @Override // im.f
    public void onMemberStateChange() {
        a.a.f(wf.a.a, "co_mem", "VideoFragment --> onMemberStateChange() --> refresh list", false, 4, (Object) null);
        com.transsion.postdetail.ui.adapter.d dVar = this.mAdapter;
        if (dVar != null) {
            dVar.n1((Collection) null);
        }
        loadData();
    }

    public void onPause() {
        localLogPause();
        super.onPause();
        com.transsion.baseui.activity.k.l(null, this, null, 5, null);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        PostSubjectItem postSubjectItem;
        List data;
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(grantResults, "grantResults");
        super/*androidx.fragment.app.Fragment*/.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == FileHelper.a.l()) {
            if (grantResults.length > 1) {
                if (grantResults[0] == 0 && grantResults[1] == 0) {
                    PostSaveHelper postSaveHelper = PostSaveHelper.a;
                    com.transsion.postdetail.ui.adapter.d dVar = this.mAdapter;
                    if (dVar == null || (data = dVar.getData()) == null) {
                        postSubjectItem = null;
                    } else {
                        VideoPagerChangeControl videoPagerChangeControl = this.mPagerChangeControl;
                        postSubjectItem = (PostSubjectItem) data.get(videoPagerChangeControl != null ? videoPagerChangeControl.h() : 0);
                    }
                    postSaveHelper.c(postSubjectItem);
                    return;
                }
            }
            FragmentActivity activity = getActivity();
            Intrinsics.f(activity, "null cannot be cast to non-null type android.app.Activity");
            if (ActivityCompat.j(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return;
            }
            showSettingDialog();
        }
    }

    public void onResume() {
        super.onResume();
        com.transsion.baseui.activity.k.p(null, this, "visible=" + isVisible(), 1, null);
    }

    public void onRightButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
        com.transsion.ninegridview.helper.b bVar = com.transsion.ninegridview.helper.b.a;
        FragmentActivity activity = getActivity();
        Intrinsics.f(activity, "null cannot be cast to non-null type android.app.Activity");
        bVar.a(activity, 101);
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(outState);
        VideoPagerChangeControl videoPagerChangeControl = this.mPagerChangeControl;
        outState.putInt(CURRENT_INDEX, videoPagerChangeControl != null ? videoPagerChangeControl.h() : 0);
    }

    public final void setResumeTimeStamp(long j) {
        this.resumeTimeStamp = j;
    }

    public final void setTran_ops(String str) {
        this.tran_ops = str;
    }
}
