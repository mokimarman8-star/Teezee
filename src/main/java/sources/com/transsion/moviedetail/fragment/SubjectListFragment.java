package com.transsion.moviedetail.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResult;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.StateView;
import com.tn.lib.widget.R;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.flow.bean.CommentBean;
import com.transsion.flow.bean.LikeBean;
import com.transsion.flow.bean.PostSubjectBean;
import com.transsion.flow.bean.RoomBean;
import com.transsion.flow.bean.RoomItem;
import com.transsion.flow.p002enum.PostListSource;
import com.transsion.flow.p002enum.ProfileSubSource;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.SubjectCommentsLoadMoreView;
import com.transsion.moviedetail.viewmodel.HotViewModel;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Audio;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.ninegridview.R$string;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.util.PostSaveHelper;
import com.transsion.room.api.RoomsViewType;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.user.action.sync.event.CommentEvent;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.loginapi.bean.UserInfo;
import ep.a$a;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import wf.a;

@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 ¼\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002½\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0006J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0006J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0006J#\u0010\u001d\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u0006J\u000f\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010\u0006J\u0019\u0010%\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b%\u0010\"J!\u0010'\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010&\u001a\u00020\u001bH\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020\u00072\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010)H\u0002¢\u0006\u0004\b+\u0010,J\u0019\u0010.\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b.\u0010/J\u0019\u00101\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b1\u0010/J\u0019\u00103\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b3\u0010\"J\u000f\u00104\u001a\u00020\u0007H\u0002¢\u0006\u0004\b4\u0010\u0006J\u000f\u00105\u001a\u00020\u0007H\u0002¢\u0006\u0004\b5\u0010\u0006J\u000f\u00106\u001a\u00020\u0007H\u0002¢\u0006\u0004\b6\u0010\u0006J\u000f\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0004\b7\u0010\u0006J\u000f\u00108\u001a\u00020\u0007H\u0002¢\u0006\u0004\b8\u0010\u0006J\u000f\u00109\u001a\u00020\u0007H\u0002¢\u0006\u0004\b9\u0010\u0006J\u000f\u0010:\u001a\u00020\u0007H\u0002¢\u0006\u0004\b:\u0010\u0006J\u000f\u0010;\u001a\u00020\u0019H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0019H\u0002¢\u0006\u0004\b=\u0010<J\u001b\u0010@\u001a\u0004\u0018\u00010\u001f2\b\u0010?\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010C\u001a\u00020BH\u0002¢\u0006\u0004\bC\u0010DJ\u0019\u0010G\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010K\u001a\u00020\u00022\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u0019H\u0016¢\u0006\u0004\bM\u0010<J\u000f\u0010N\u001a\u00020\u001bH\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0007H\u0016¢\u0006\u0004\bP\u0010\u0006J\u001f\u0010U\u001a\u00020\u00072\u0006\u0010R\u001a\u00020Q2\u0006\u0010T\u001a\u00020SH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u0007H\u0016¢\u0006\u0004\bW\u0010\u0006J\u000f\u0010X\u001a\u00020\u0007H\u0016¢\u0006\u0004\bX\u0010\u0006J\u000f\u0010Y\u001a\u00020\u0007H\u0016¢\u0006\u0004\bY\u0010\u0006J\r\u0010Z\u001a\u00020\u0007¢\u0006\u0004\bZ\u0010\u0006J\u0017\u0010]\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b_\u0010^J1\u0010f\u001a\u00020\u00072\u0006\u0010a\u001a\u00020`2\u0010\u0010c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190b2\u0006\u0010e\u001a\u00020dH\u0016¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\u0007H\u0016¢\u0006\u0004\bh\u0010\u0006J\u000f\u0010i\u001a\u00020\u0007H\u0016¢\u0006\u0004\bi\u0010\u0006J\u000f\u0010j\u001a\u00020\u0007H\u0016¢\u0006\u0004\bj\u0010\u0006J\u0011\u0010l\u001a\u0004\u0018\u00010kH\u0016¢\u0006\u0004\bl\u0010mJ\u0017\u0010o\u001a\u00020k2\u0006\u0010n\u001a\u00020\u001bH\u0016¢\u0006\u0004\bo\u0010pJ\u0017\u0010q\u001a\u00020k2\u0006\u0010n\u001a\u00020\u001bH\u0016¢\u0006\u0004\bq\u0010pJ\u0017\u0010s\u001a\u00020\u00072\u0006\u0010r\u001a\u00020\u001bH\u0016¢\u0006\u0004\bs\u0010tJ\u000f\u0010v\u001a\u00020uH\u0016¢\u0006\u0004\bv\u0010wJ\u0017\u0010y\u001a\u00020\u00072\u0006\u0010x\u001a\u00020\u001bH\u0016¢\u0006\u0004\by\u0010tR\u0018\u0010{\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010~\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R#\u0010\u008f\u0001\u001a\f\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R#\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0091\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R#\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0097\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u0093\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R#\u0010 \u0001\u001a\u0005\u0018\u00010\u009c\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009d\u0001\u0010\u0093\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001c\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001b\u0010¤\u0001\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R#\u0010ª\u0001\u001a\u0005\u0018\u00010¦\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b§\u0001\u0010\u0093\u0001\u001a\u0006\b¨\u0001\u0010©\u0001R\u001c\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u0019\u0010±\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u001b\u0010³\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R2\u0010º\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00190µ\u0001j\t\u0012\u0004\u0012\u00020\u0019`¶\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b·\u0001\u0010\u0093\u0001\u001a\u0006\b¸\u0001\u0010¹\u0001R\u0019\u0010»\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010²\u0001¨\u0006¾\u0001"}, d2 = {"Lcom/transsion/moviedetail/fragment/SubjectListFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Llm/g;", "Lwv/b;", "Lcom/tn/lib/widget/dialog/TRDialogListener;", "<init>", "()V", BuildConfig.FLAVOR, "initExposureHelper", "initLaunch", "initLiveData", "Lcom/transsion/moviedetailapi/bean/PostSubjectBean;", "postSubjectBean", "updateSubjectList", "(Lcom/transsion/moviedetailapi/bean/PostSubjectBean;)V", "initScrollListener", "initPlayer", "checkToShowEmptyView", "Lcom/transsion/moviedetailapi/bean/LikeBean;", "likeBean", "updateLikeStatus", "(Lcom/transsion/moviedetailapi/bean/LikeBean;)V", "lazyLoadData", "loadMore", "initClickListener", BuildConfig.FLAVOR, "postId", BuildConfig.FLAVOR, "hasLike", "like", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "postItem", "onDownLoadClick", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "requestPermission", "showSettingDialog", "share", "fromComment", "openDetail", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;Z)V", "Lcom/tn/lib/net/bean/BaseDto;", "data", "updateDeletePost", "(Lcom/tn/lib/net/bean/BaseDto;)V", "id", "removePost", "(Ljava/lang/String;)V", "url", "toWeb", "item", "showAudioFloating", "observeDelete", "observeLike", "observeComment", "initAd", "insertLast", "initListVideoPreload", "localLogPause", "pageName", "()Ljava/lang/String;", "subpageName", "Lcom/transsion/moviedetailapi/bean/RoomBean;", "bean", "getRecommendRoomsBean", "(Lcom/transsion/moviedetailapi/bean/RoomBean;)Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", BuildConfig.FLAVOR, "getPostExposurePercent", "()F", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)Llm/g;", "getPageStateLayoutTitle", "isAudioShowNoNetworkLayout", "()Z", "initViewData", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "initViewModel", "initListener", "retryLoadData", "refresh", "Lcom/tn/lib/widget/dialog/TRDialog;", "dialog", "onLeftButtonClick", "(Lcom/tn/lib/widget/dialog/TRDialog;)V", "onRightButtonClick", BuildConfig.FLAVOR, "requestCode", BuildConfig.FLAVOR, "permissions", BuildConfig.FLAVOR, "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "onPause", "onDestroy", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "isShowTitleLayout", "getLocalNoNetworkView", "(Z)Landroid/view/View;", "getEmptyView", "hidden", "onHiddenChanged", "(Z)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "fullscreen", "onScreenChange", "Lbj/b;", "mExposureHelper", "Lbj/b;", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "middleListManager", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "nativeManager", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "Lcom/transsion/moviedetailapi/AbsSubjectListViewModel;", "mHotViewModel", "Lcom/transsion/moviedetailapi/AbsSubjectListViewModel;", "Lcom/transsion/moviedetail/adapter/j;", "mAdapter", "Lcom/transsion/moviedetail/adapter/j;", "mPostSubjectBean", "Lcom/transsion/moviedetailapi/bean/PostSubjectBean;", "mPostSubjectItem", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "postDetailLauncher", "Landroidx/activity/result/b;", "Lqx/a;", "mLoginApi$delegate", "Lkotlin/Lazy;", "getMLoginApi", "()Lqx/a;", "mLoginApi", "Lep/a;", "mAudioApi$delegate", "getMAudioApi", "()Lep/a;", "mAudioApi", "Lep/b;", "mFloatApi$delegate", "getMFloatApi", "()Lep/b;", "mFloatApi", "Lep/e;", "mRoomView", "Lep/e;", "mEmptyLayout", "Landroid/view/View;", "Lep/f;", "mRoomApi$delegate", "getMRoomApi", "()Lep/f;", "mRoomApi", "Lcom/transsion/ninegridview/a;", "mGifPlayerManager", "Lcom/transsion/ninegridview/a;", "Lcom/transsion/moviedetailapi/bean/Subject;", "mSubject", "Lcom/transsion/moviedetailapi/bean/Subject;", "firstLoad", "Z", "curPageName", "Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mExposureList$delegate", "getMExposureList", "()Ljava/util/HashSet;", "mExposureList", "isFirst", "Companion", "a", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class SubjectListFragment extends PageStatusFragment<lm.g> implements wv.b, TRDialogListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_POST_EXPOSURE_PERCENT = "sa_post_exposure_percent";
    public static final String TAG = "MoveListFragment";
    private String curPageName;
    private boolean firstLoad;
    private com.transsion.moviedetail.adapter.j mAdapter;
    private View mEmptyLayout;
    private bj.b mExposureHelper;
    private com.transsion.ninegridview.a mGifPlayerManager;
    private AbsSubjectListViewModel mHotViewModel;
    private PostSubjectBean mPostSubjectBean;
    private PostSubjectItem mPostSubjectItem;
    private ep.e mRoomView;
    private Subject mSubject;
    private BiddingListManager middleListManager;
    private BiddingNativeManager nativeManager;
    private androidx.activity.result.b postDetailLauncher;

    /* renamed from: mLoginApi$delegate, reason: from kotlin metadata */
    private final Lazy mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.fragment.d2
        public final Object invoke() {
            qx.a mLoginApi_delegate$lambda$0;
            mLoginApi_delegate$lambda$0 = SubjectListFragment.mLoginApi_delegate$lambda$0();
            return mLoginApi_delegate$lambda$0;
        }
    });

    /* renamed from: mAudioApi$delegate, reason: from kotlin metadata */
    private final Lazy mAudioApi = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.fragment.e2
        public final Object invoke() {
            ep.a mAudioApi_delegate$lambda$1;
            mAudioApi_delegate$lambda$1 = SubjectListFragment.mAudioApi_delegate$lambda$1();
            return mAudioApi_delegate$lambda$1;
        }
    });

    /* renamed from: mFloatApi$delegate, reason: from kotlin metadata */
    private final Lazy mFloatApi = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.fragment.f2
        public final Object invoke() {
            ep.b mFloatApi_delegate$lambda$2;
            mFloatApi_delegate$lambda$2 = SubjectListFragment.mFloatApi_delegate$lambda$2();
            return mFloatApi_delegate$lambda$2;
        }
    });

    /* renamed from: mRoomApi$delegate, reason: from kotlin metadata */
    private final Lazy mRoomApi = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.fragment.g2
        public final Object invoke() {
            ep.f mRoomApi_delegate$lambda$3;
            mRoomApi_delegate$lambda$3 = SubjectListFragment.mRoomApi_delegate$lambda$3();
            return mRoomApi_delegate$lambda$3;
        }
    });

    /* renamed from: mExposureList$delegate, reason: from kotlin metadata */
    private final Lazy mExposureList = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.fragment.h2
        public final Object invoke() {
            HashSet mExposureList_delegate$lambda$4;
            mExposureList_delegate$lambda$4 = SubjectListFragment.mExposureList_delegate$lambda$4();
            return mExposureList_delegate$lambda$4;
        }
    });
    private boolean isFirst = true;

    /* renamed from: com.transsion.moviedetail.fragment.SubjectListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubjectListFragment a(Bundle bundle, Class cls) {
            Intrinsics.h(bundle, "params");
            Intrinsics.h(cls, "type");
            SubjectListFragment subjectListFragment = new SubjectListFragment();
            bundle.putSerializable("view_model_type", cls);
            subjectListFragment.setArguments(bundle);
            return subjectListFragment;
        }
    }

    public static final class b implements bj.a {
        b() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            PostSubjectItem postSubjectItem;
            AbsSubjectListViewModel viewModel;
            PostListSource A;
            SubjectListFragment subjectListFragment = SubjectListFragment.this;
            try {
                Result.Companion companion = Result.Companion;
                com.transsion.moviedetail.adapter.j jVar = subjectListFragment.mAdapter;
                if (jVar != null && (postSubjectItem = (PostSubjectItem) jVar.getItem(i)) != null) {
                    String str = BuildConfig.FLAVOR;
                    if (subjectListFragment.mAdapter != null) {
                        com.transsion.moviedetail.adapter.j jVar2 = subjectListFragment.mAdapter;
                        str = (jVar2 == null || (viewModel = jVar2.getViewModel()) == null || (A = viewModel.A()) == null) ? null : A.name();
                    }
                    String str2 = str;
                    if (!CollectionsKt.b0(subjectListFragment.getMExposureList(), postSubjectItem.getPostId())) {
                        String postId = postSubjectItem.getPostId();
                        if (postId != null) {
                            subjectListFragment.getMExposureList().add(postId);
                        }
                        com.transsion.postdetail.helper.a.a.v(str2, subjectListFragment.pageName(), subjectListFragment.subpageName(), i, j, postSubjectItem, (r19 & 64) != 0 ? null : null);
                    }
                }
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
    }

    public static final class c extends RecyclerView.r {
        private int a;
        private int b;

        c() {
        }

        private final void d(RecyclerView recyclerView) {
            LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                throw new RuntimeException("Unsupported layoutManager.");
            }
            LinearLayoutManager linearLayoutManager = layoutManager;
            this.a = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            this.b = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            com.transsion.moviedetail.adapter.j jVar;
            t6.f h0;
            t6.f h02;
            Intrinsics.h(recyclerView, "recyclerView");
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
            int itemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
            if (i != 0 || childCount <= 0 || this.a < itemCount - 1) {
                return;
            }
            com.transsion.moviedetail.adapter.j jVar2 = SubjectListFragment.this.mAdapter;
            if (((jVar2 == null || (h02 = jVar2.h0()) == null) ? null : h02.i()) != LoadMoreStatus.Fail || (jVar = SubjectListFragment.this.mAdapter) == null || (h0 = jVar.h0()) == null) {
                return;
            }
            h0.w();
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.h(recyclerView, "recyclerView");
            d(recyclerView);
        }
    }

    public static final class d extends DiffUtil.e {
        d() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(PostSubjectItem postSubjectItem, PostSubjectItem postSubjectItem2) {
            Intrinsics.h(postSubjectItem, "oldItem");
            Intrinsics.h(postSubjectItem2, "newItem");
            return Intrinsics.c(String.valueOf(postSubjectItem.getPostId()), String.valueOf(postSubjectItem2.getPostId()));
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(PostSubjectItem postSubjectItem, PostSubjectItem postSubjectItem2) {
            Intrinsics.h(postSubjectItem, "oldItem");
            Intrinsics.h(postSubjectItem2, "newItem");
            Subject subject = postSubjectItem.getSubject();
            String subjectId = subject != null ? subject.getSubjectId() : null;
            Subject subject2 = postSubjectItem2.getSubject();
            return Intrinsics.c(subjectId, subject2 != null ? subject2.getSubjectId() : null);
        }
    }

    public static final class e implements com.transsion.share.share.a {
        e() {
        }

        @Override // com.transsion.share.share.a
        public void a(String str, PostType postType) {
            Intrinsics.h(str, "id");
            AbsSubjectListViewModel absSubjectListViewModel = SubjectListFragment.this.mHotViewModel;
            if (absSubjectListViewModel != null) {
                absSubjectListViewModel.m(str);
            }
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            a.a.f(wf.a.a, SubjectListFragment.TAG, "id" + str, false, 4, (Object) null);
            SubjectListFragment.this.removePost(str);
        }

        @Override // com.transsion.share.share.a
        public void c(String str, String str2, String str3, String str4) {
            Intrinsics.h(str, "url");
            Intrinsics.h(str2, "fileName");
            Intrinsics.h(str3, "fileSize");
            Intrinsics.h(str4, "fileImage");
        }

        @Override // com.transsion.share.share.a
        public void d(String str) {
            Intrinsics.h(str, "id");
        }

        @Override // com.transsion.share.share.a
        public void e(String str) {
            a.C0056a.c(this, str);
        }
    }

    private final void checkToShowEmptyView() {
        PostSubjectItem recommendRoomsBean;
        ep.e eVar;
        View view;
        Unit unit;
        ep.e eVar2;
        View view2;
        String value;
        ProfileSubSource B;
        RecyclerView recyclerView;
        lm.g gVar;
        RecyclerView recyclerView2;
        com.transsion.moviedetail.adapter.j jVar = this.mAdapter;
        if (jVar == null || jVar.getItemCount() != 0) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            lm.g gVar2 = (lm.g) getMViewBinding();
            if (gVar2 != null && (recyclerView = gVar2.b) != null && recyclerView.getItemDecorationCount() == 0 && (gVar = (lm.g) getMViewBinding()) != null && (recyclerView2 = gVar.b) != null) {
                recyclerView2.addItemDecoration(new tf.i(com.blankj.utilcode.util.a0.a(16.0f), 0));
            }
            Context context = getContext();
            Unit unit2 = null;
            if (context != null) {
                if (this.mRoomView == null) {
                    ep.f mRoomApi = getMRoomApi();
                    this.mRoomView = mRoomApi != null ? mRoomApi.c(context, RoomsViewType.TYPE_SUBJECT_DETAIL) : null;
                }
                AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
                if (absSubjectListViewModel instanceof HotViewModel) {
                    Intrinsics.f(absSubjectListViewModel, "null cannot be cast to non-null type com.transsion.moviedetail.viewmodel.HotViewModel");
                    RoomBean roomBean = (RoomBean) ((HotViewModel) absSubjectListViewModel).d0().f();
                    if (roomBean != null && (recommendRoomsBean = getRecommendRoomsBean(roomBean)) != null) {
                        List roomList = recommendRoomsBean.getRoomList();
                        if (roomList != null) {
                            ep.e eVar3 = this.mRoomView;
                            if (eVar3 != null) {
                                String pageName = pageName();
                                AbsSubjectListViewModel absSubjectListViewModel2 = this.mHotViewModel;
                                if (absSubjectListViewModel2 == null || (B = absSubjectListViewModel2.B()) == null || (value = B.getValue()) == null) {
                                    value = ProfileSubSource.COMMENTS.getValue();
                                }
                                eVar3.setReportName(pageName, value);
                            }
                            ep.e eVar4 = this.mRoomView;
                            if (eVar4 != null) {
                                eVar4.setList(roomList);
                                unit = Unit.a;
                            } else {
                                unit = null;
                            }
                            if (unit != null && (eVar2 = this.mRoomView) != null && (view2 = eVar2.getView()) != null) {
                                uf.c.g(view2);
                                unit2 = Unit.a;
                            }
                        }
                        if (unit2 != null && (eVar = this.mRoomView) != null && (view = eVar.getView()) != null) {
                            uf.c.g(view);
                        }
                    }
                }
                com.transsion.moviedetail.adapter.j jVar2 = this.mAdapter;
                if (jVar2 != null) {
                    jVar2.Y0(getEmptyView(false));
                }
                com.transsion.moviedetail.adapter.j jVar3 = this.mAdapter;
                if (jVar3 != null) {
                    jVar3.z1(true);
                }
                unit2 = Unit.a;
            }
            Result.constructor-impl(unit2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    private final ep.a getMAudioApi() {
        return (ep.a) this.mAudioApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashSet<String> getMExposureList() {
        return (HashSet) this.mExposureList.getValue();
    }

    private final ep.b getMFloatApi() {
        return (ep.b) this.mFloatApi.getValue();
    }

    private final qx.a getMLoginApi() {
        return (qx.a) this.mLoginApi.getValue();
    }

    private final ep.f getMRoomApi() {
        return (ep.f) this.mRoomApi.getValue();
    }

    private final float getPostExposurePercent() {
        Float t;
        ConfigBean d2 = cm.f.d(cm.f.c.a(), KEY_POST_EXPOSURE_PERCENT, false, 2, (Object) null);
        String value = d2 != null ? d2.getValue() : null;
        if (value == null || value.length() == 0 || (t = StringsKt.t(value)) == null) {
            return 0.6f;
        }
        return t.floatValue();
    }

    private final PostSubjectItem getRecommendRoomsBean(RoomBean bean) {
        List data;
        PostSubjectItem postSubjectItem;
        List<RoomItem> items = bean != null ? bean.getItems() : null;
        List<RoomItem> list = items;
        if (list == null || list.isEmpty()) {
            return null;
        }
        com.transsion.moviedetail.adapter.j jVar = this.mAdapter;
        if (jVar != null && (data = jVar.getData()) != null && (postSubjectItem = (PostSubjectItem) CollectionsKt.k0(data)) != null && postSubjectItem.isRoomList()) {
            return null;
        }
        if (items.size() > 3) {
            items = items.subList(0, 3);
        }
        PostSubjectItem postSubjectItem2 = new PostSubjectItem((String) null, (String) null, (Group) null, (Boolean) null, (Boolean) null, (Link) null, (Media) null, (String) null, (Stat) null, (Integer) null, (Subject) null, (Integer) null, (String) null, (String) null, (User) null, (String) null, (String) null, (Integer) null, (String) null, false, (Float) null, (Float) null, (String) null, (String) null, false, (List) null, false, (BiddingNativeManager) null, false, false, false, false, (CommentBean) null, -1, 1, (DefaultConstructorMarker) null);
        postSubjectItem2.setRoomList(true);
        postSubjectItem2.setRoomList(items);
        return postSubjectItem2;
    }

    private final void initAd() {
        AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
        if ((absSubjectListViewModel != null ? absSubjectListViewModel.A() : null) != PostListSource.SUBJECT) {
            return;
        }
        BiddingListManager biddingListManager = new BiddingListManager();
        this.middleListManager = biddingListManager;
        lm.g gVar = (lm.g) getMViewBinding();
        biddingListManager.F(gVar != null ? gVar.b : null);
        BiddingListManager biddingListManager2 = this.middleListManager;
        if (biddingListManager2 != null) {
            biddingListManager2.A(androidx.lifecycle.v.a(this));
        }
        BiddingListManager biddingListManager3 = this.middleListManager;
        if (biddingListManager3 != null) {
            biddingListManager3.G("SubjectDetailRecommendScene");
        }
        BiddingListManager biddingListManager4 = this.middleListManager;
        if (biddingListManager4 != null) {
            biddingListManager4.z(new Function2() { // from class: com.transsion.moviedetail.fragment.q1
                public final Object invoke(Object obj, Object obj2) {
                    Unit initAd$lambda$60;
                    initAd$lambda$60 = SubjectListFragment.initAd$lambda$60(SubjectListFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                    return initAd$lambda$60;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAd$lambda$60(SubjectListFragment subjectListFragment, int i, BiddingNativeManager biddingNativeManager) {
        List data;
        Intrinsics.h(biddingNativeManager, "current");
        if (biddingNativeManager != null) {
            PostSubjectItem postSubjectItem = new PostSubjectItem((String) null, (String) null, (Group) null, (Boolean) null, (Boolean) null, (Link) null, (Media) null, (String) null, (Stat) null, (Integer) null, (Subject) null, (Integer) null, (String) null, (String) null, (User) null, (String) null, (String) null, (Integer) null, (String) null, false, (Float) null, (Float) null, (String) null, (String) null, false, (List) null, false, (BiddingNativeManager) null, false, false, false, false, (CommentBean) null, -1, 1, (DefaultConstructorMarker) null);
            postSubjectItem.setNonAdDelegate(biddingNativeManager);
            com.transsion.moviedetail.adapter.j jVar = subjectListFragment.mAdapter;
            int size = (jVar == null || (data = jVar.getData()) == null) ? 0 : data.size();
            if (i <= size) {
                com.transsion.moviedetail.adapter.j jVar2 = subjectListFragment.mAdapter;
                if (jVar2 != null) {
                    jVar2.n(i, postSubjectItem);
                }
            } else {
                com.transsion.moviedetail.adapter.j jVar3 = subjectListFragment.mAdapter;
                if (jVar3 != null) {
                    jVar3.n(size, postSubjectItem);
                }
            }
        }
        return Unit.a;
    }

    private final void initClickListener() {
    }

    private final void initExposureHelper() {
        RecyclerView recyclerView;
        float postExposurePercent = getPostExposurePercent();
        a.a.f(wf.a.a, "PostList", "initExposureHelper, postExposurePercent:" + postExposurePercent, false, 4, (Object) null);
        bj.b bVar = new bj.b(postExposurePercent, new b(), false, 4, null);
        bVar.n(2);
        lm.g gVar = (lm.g) getMViewBinding();
        if (gVar != null && (recyclerView = gVar.b) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.mExposureHelper = bVar;
    }

    private final void initLaunch() {
        this.postDetailLauncher = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.moviedetail.fragment.u1
            public final void a(Object obj) {
                SubjectListFragment.initLaunch$lambda$13(SubjectListFragment.this, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLaunch$lambda$13(SubjectListFragment subjectListFragment, ActivityResult activityResult) {
        Intrinsics.h(activityResult, "it");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            Serializable serializableExtra = data != null ? data.getSerializableExtra("audio") : null;
            if (serializableExtra instanceof AudioBean) {
                a.a.f(wf.a.a, TAG, "showFloating", false, 4, (Object) null);
                ep.b bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0]);
                if (bVar != null) {
                    bVar.a(new WeakReference(subjectListFragment.requireActivity()), (AudioBean) serializableExtra);
                }
            }
            Intent data2 = activityResult.getData();
            subjectListFragment.removePost(data2 != null ? data2.getStringExtra("id") : null);
        }
    }

    private final void initListVideoPreload() {
        RecyclerView recyclerView;
        AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
        if (absSubjectListViewModel != null) {
            if ((absSubjectListViewModel != null ? absSubjectListViewModel.A() : null) != PostListSource.SUBJECT) {
                return;
            }
            sm.b bVar = new sm.b(0.75f, new Function1() { // from class: com.transsion.moviedetail.fragment.v1
                public final Object invoke(Object obj) {
                    PostSubjectItem initListVideoPreload$lambda$61;
                    initListVideoPreload$lambda$61 = SubjectListFragment.initListVideoPreload$lambda$61(SubjectListFragment.this, ((Integer) obj).intValue());
                    return initListVideoPreload$lambda$61;
                }
            });
            lm.g gVar = (lm.g) getMViewBinding();
            if (gVar == null || (recyclerView = gVar.b) == null) {
                return;
            }
            recyclerView.addOnScrollListener(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PostSubjectItem initListVideoPreload$lambda$61(SubjectListFragment subjectListFragment, int i) {
        List data;
        try {
            com.transsion.moviedetail.adapter.j jVar = subjectListFragment.mAdapter;
            if (jVar == null || (data = jVar.getData()) == null) {
                return null;
            }
            return (PostSubjectItem) data.get(i);
        } catch (Throwable unused) {
            return null;
        }
    }

    private final void initLiveData() {
        AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
        if (absSubjectListViewModel != null) {
            if (absSubjectListViewModel instanceof HotViewModel) {
                ((HotViewModel) absSubjectListViewModel).d0().j(this, new k2(new Function1() { // from class: com.transsion.moviedetail.fragment.w1
                    public final Object invoke(Object obj) {
                        Unit initLiveData$lambda$22$lambda$14;
                        initLiveData$lambda$22$lambda$14 = SubjectListFragment.initLiveData$lambda$22$lambda$14(SubjectListFragment.this, (RoomBean) obj);
                        return initLiveData$lambda$22$lambda$14;
                    }
                }));
            }
            absSubjectListViewModel.x().j(this, new k2(new Function1() { // from class: com.transsion.moviedetail.fragment.x1
                public final Object invoke(Object obj) {
                    Unit initLiveData$lambda$22$lambda$16;
                    initLiveData$lambda$22$lambda$16 = SubjectListFragment.initLiveData$lambda$22$lambda$16(SubjectListFragment.this, (PostSubjectBean) obj);
                    return initLiveData$lambda$22$lambda$16;
                }
            }));
            absSubjectListViewModel.r().j(this, new k2(new Function1() { // from class: com.transsion.moviedetail.fragment.y1
                public final Object invoke(Object obj) {
                    Unit initLiveData$lambda$22$lambda$17;
                    initLiveData$lambda$22$lambda$17 = SubjectListFragment.initLiveData$lambda$22$lambda$17(SubjectListFragment.this, (LikeBean) obj);
                    return initLiveData$lambda$22$lambda$17;
                }
            }));
            absSubjectListViewModel.n().j(getViewLifecycleOwner(), new k2(new Function1() { // from class: com.transsion.moviedetail.fragment.a2
                public final Object invoke(Object obj) {
                    Unit initLiveData$lambda$22$lambda$20;
                    initLiveData$lambda$22$lambda$20 = SubjectListFragment.initLiveData$lambda$22$lambda$20(SubjectListFragment.this, (List) obj);
                    return initLiveData$lambda$22$lambda$20;
                }
            }));
            absSubjectListViewModel.p().j(getViewLifecycleOwner(), new k2(new Function1() { // from class: com.transsion.moviedetail.fragment.b2
                public final Object invoke(Object obj) {
                    Unit initLiveData$lambda$22$lambda$21;
                    initLiveData$lambda$22$lambda$21 = SubjectListFragment.initLiveData$lambda$22$lambda$21(SubjectListFragment.this, (BaseDto) obj);
                    return initLiveData$lambda$22$lambda$21;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initLiveData$lambda$22$lambda$14(SubjectListFragment subjectListFragment, RoomBean roomBean) {
        AbsSubjectListViewModel absSubjectListViewModel;
        com.transsion.moviedetail.adapter.j jVar = subjectListFragment.mAdapter;
        List data = jVar != null ? jVar.getData() : null;
        if ((data == null || data.isEmpty()) && (absSubjectListViewModel = subjectListFragment.mHotViewModel) != null) {
            absSubjectListViewModel.E(true);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initLiveData$lambda$22$lambda$16(final SubjectListFragment subjectListFragment, final PostSubjectBean postSubjectBean) {
        RecyclerView recyclerView;
        qi.b logViewConfig = subjectListFragment.getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        subjectListFragment.showContentView();
        subjectListFragment.mPostSubjectBean = postSubjectBean;
        sm.d.d(subjectListFragment.getContext(), postSubjectBean != null ? postSubjectBean.getItems() : null);
        if (subjectListFragment.firstLoad) {
            lm.g gVar = (lm.g) subjectListFragment.getMViewBinding();
            if (gVar != null && (recyclerView = gVar.b) != null) {
                recyclerView.postDelayed(new Runnable() { // from class: com.transsion.moviedetail.fragment.o1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SubjectListFragment.this.updateSubjectList(postSubjectBean);
                    }
                }, 300L);
            }
        } else {
            subjectListFragment.firstLoad = true;
            subjectListFragment.updateSubjectList(postSubjectBean);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initLiveData$lambda$22$lambda$17(SubjectListFragment subjectListFragment, LikeBean likeBean) {
        if (likeBean != null) {
            subjectListFragment.updateLikeStatus(likeBean);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initLiveData$lambda$22$lambda$20(SubjectListFragment subjectListFragment, List list) {
        List arrayList;
        com.transsion.moviedetail.adapter.j jVar;
        t6.f h0;
        RecyclerView recyclerView;
        LinearLayoutManager layoutManager;
        List data;
        PostSubjectItem postSubjectItem;
        if (list != null) {
            com.transsion.moviedetail.adapter.j jVar2 = subjectListFragment.mAdapter;
            if (jVar2 == null || (arrayList = jVar2.getData()) == null) {
                arrayList = new ArrayList();
            }
            ArrayList arrayList2 = new ArrayList();
            if (arrayList.isEmpty()) {
                arrayList2.addAll(list);
            } else {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    PostSubjectItem postSubjectItem2 = (PostSubjectItem) it.next();
                    if (!arrayList.contains(postSubjectItem2)) {
                        arrayList2.add(postSubjectItem2);
                    }
                }
            }
            com.transsion.moviedetail.adapter.j jVar3 = subjectListFragment.mAdapter;
            int i = (jVar3 == null || (data = jVar3.getData()) == null || (postSubjectItem = (PostSubjectItem) CollectionsKt.k0(data)) == null || !postSubjectItem.isRoomList()) ? 0 : 1;
            com.transsion.moviedetail.adapter.j jVar4 = subjectListFragment.mAdapter;
            if (jVar4 != null) {
                jVar4.o(i, arrayList2);
            }
            lm.g gVar = (lm.g) subjectListFragment.getMViewBinding();
            if (gVar != null && (recyclerView = gVar.b) != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
                try {
                    if ((layoutManager instanceof LinearLayoutManager) && layoutManager.findFirstVisibleItemPosition() <= 1) {
                        layoutManager.scrollToPosition(0);
                    }
                } catch (Exception unused) {
                }
            }
            com.transsion.moviedetail.adapter.j jVar5 = subjectListFragment.mAdapter;
            if ((jVar5 != null ? jVar5.getItemCount() : 0) == list.size() && (jVar = subjectListFragment.mAdapter) != null && (h0 = jVar.h0()) != null) {
                h0.t(false);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initLiveData$lambda$22$lambda$21(SubjectListFragment subjectListFragment, BaseDto baseDto) {
        subjectListFragment.updateDeletePost(baseDto);
        return Unit.a;
    }

    private final void initPlayer() {
        RecyclerView recyclerView;
        com.transsion.ninegridview.a aVar = new com.transsion.ninegridview.a();
        lm.g gVar = (lm.g) getMViewBinding();
        if (gVar != null && (recyclerView = gVar.b) != null) {
            aVar.n(recyclerView, this.mAdapter);
        }
        this.mGifPlayerManager = aVar;
    }

    private final void initScrollListener() {
        RecyclerView recyclerView;
        lm.g gVar = (lm.g) getMViewBinding();
        if (gVar == null || (recyclerView = gVar.b) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewData$lambda$11$lambda$10(SubjectListFragment subjectListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        User user;
        User user2;
        User user3;
        User user4;
        Media media;
        Subject subject;
        Subject subject2;
        Subject subject3;
        Integer subjectType;
        AbsSubjectListViewModel viewModel;
        PostListSource A;
        Group group;
        AbsSubjectListViewModel absSubjectListViewModel;
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        Object item = baseQuickAdapter.getItem(i);
        String str = null;
        str = null;
        PostSubjectItem postSubjectItem = item instanceof PostSubjectItem ? (PostSubjectItem) item : null;
        int id = view.getId();
        if (id == R$id.v_post_share) {
            subjectListFragment.share(postSubjectItem);
            str = "share";
        } else if (id == R$id.v_post_download) {
            subjectListFragment.onDownLoadClick(postSubjectItem);
            subjectListFragment.mPostSubjectItem = postSubjectItem;
            str = "download";
        } else if (id == R$id.v_post_like) {
            String str2 = postSubjectItem != null ? Intrinsics.c(postSubjectItem.getHasLike(), Boolean.TRUE) : false ? "dislike" : "like";
            subjectListFragment.like(postSubjectItem != null ? postSubjectItem.getPostId() : null, postSubjectItem != null ? postSubjectItem.getHasLike() : null);
            str = str2;
        } else if (id == R$id.v_post_comment) {
            subjectListFragment.openDetail(postSubjectItem, true);
            str = "comment";
        } else if (id == R$id.tv_room_tag) {
            Navigator.x(TheRouter.c("/room/detail").K("id", (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null) ? null : group.getGroupId()), subjectListFragment.requireContext(), (mf.c) null, 2, (Object) null);
            str = "group";
        } else if (id == R$id.fl_cover || id == R$id.tv_room_name || id == R$id.tv_post_date) {
            AbsSubjectListViewModel absSubjectListViewModel2 = subjectListFragment.mHotViewModel;
            if ((absSubjectListViewModel2 != null ? absSubjectListViewModel2.B() : null) == ProfileSubSource.POSTS) {
                Navigator.x(TheRouter.c("/post/detail").K("page_from", subjectListFragment.pageName()).J("item_object", postSubjectItem).K("rec_ops", postSubjectItem != null ? postSubjectItem.getOps() : null).K("id", postSubjectItem != null ? postSubjectItem.getPostId() : null).K("item_type", postSubjectItem != null ? postSubjectItem.getItemType() : null).K("media_type", (postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getMediaType()), subjectListFragment.requireContext(), (mf.c) null, 2, (Object) null);
            } else {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId((postSubjectItem == null || (user4 = postSubjectItem.getUser()) == null) ? null : user4.getUserId());
                userInfo.setAvatar((postSubjectItem == null || (user3 = postSubjectItem.getUser()) == null) ? null : user3.getAvatar());
                userInfo.setUsername((postSubjectItem == null || (user2 = postSubjectItem.getUser()) == null) ? null : user2.getUsername());
                userInfo.setNickname((postSubjectItem == null || (user = postSubjectItem.getUser()) == null) ? null : user.getNickname());
                Navigator.x(TheRouter.c("/profile/user_profile").K("userId", userInfo.getUserId()), subjectListFragment.requireContext(), (mf.c) null, 2, (Object) null);
                str = "user_center";
            }
        } else if (id == com.transsion.moviedetail.R$id.cl_audio) {
            subjectListFragment.showAudioFloating(postSubjectItem);
            str = "audio_play";
        } else if (id == R$id.cl_subject_content) {
            com.transsion.moviedetail.adapter.j jVar = subjectListFragment.mAdapter;
            if (jVar != null && (viewModel = jVar.getViewModel()) != null && (A = viewModel.A()) != null) {
                A.name();
            }
            Navigator.x(TheRouter.c("/movie/detail").F("subject_type", (postSubjectItem == null || (subject3 = postSubjectItem.getSubject()) == null || (subjectType = subject3.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()).K("id", (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null) ? null : subject2.getSubjectId()).K("ops", (postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null) ? null : subject.getOps()), subjectListFragment.requireContext(), (mf.c) null, 2, (Object) null);
            str = "subject";
        }
        if (postSubjectItem == null || (absSubjectListViewModel = subjectListFragment.mHotViewModel) == null) {
            return;
        }
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        absSubjectListViewModel.J(postSubjectItem, i, str, subjectListFragment.subpageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewData$lambda$11$lambda$8(SubjectListFragment subjectListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof PostSubjectItem) {
            PostSubjectItem postSubjectItem = (PostSubjectItem) item;
            subjectListFragment.openDetail(postSubjectItem, false);
            AbsSubjectListViewModel absSubjectListViewModel = subjectListFragment.mHotViewModel;
            if (absSubjectListViewModel != null) {
                absSubjectListViewModel.I(postSubjectItem, i, subjectListFragment.subpageName());
            }
        }
    }

    private final void insertLast() {
        List arrayList;
        AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
        if ((absSubjectListViewModel != null ? absSubjectListViewModel.A() : null) == PostListSource.SUBJECT) {
            com.transsion.moviedetail.adapter.j jVar = this.mAdapter;
            if (jVar == null || (arrayList = jVar.getData()) == null) {
                arrayList = new ArrayList();
            }
            if (arrayList.size() <= com.transsion.ad.scene.a.o(com.transsion.ad.scene.a.a, "SubjectDetailRecommendScene", 0, 2, null)) {
                kotlinx.coroutines.i.d(androidx.lifecycle.v.a(this), (CoroutineContext) null, (CoroutineStart) null, new SubjectListFragment$insertLast$1(this, arrayList, null), 3, (Object) null);
            }
        }
    }

    private final void lazyLoadData() {
        if (!yg.l.a.e()) {
            com.transsion.moviedetail.adapter.j jVar = this.mAdapter;
            if (jVar != null) {
                jVar.Y0(getLocalNoNetworkView(false));
                return;
            }
            return;
        }
        showLoadingView();
        if ((this.mHotViewModel instanceof HotViewModel) && ep.k.a.a()) {
            AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
            Intrinsics.f(absSubjectListViewModel, "null cannot be cast to non-null type com.transsion.moviedetail.viewmodel.HotViewModel");
            HotViewModel.c0((HotViewModel) absSubjectListViewModel, null, 0, 3, null);
        } else {
            AbsSubjectListViewModel absSubjectListViewModel2 = this.mHotViewModel;
            if (absSubjectListViewModel2 != null) {
                absSubjectListViewModel2.E(true);
            }
        }
    }

    private final void like(String postId, Boolean hasLike) {
        boolean c2 = Intrinsics.c(hasLike, Boolean.TRUE);
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.no_network_tips);
            return;
        }
        AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
        if (absSubjectListViewModel != null) {
            absSubjectListViewModel.C(postId, c2 ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMore() {
        RecyclerView recyclerView;
        if (yg.l.a.e()) {
            AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
            if (absSubjectListViewModel != null) {
                absSubjectListViewModel.E(false);
                return;
            }
            return;
        }
        fh.b.a.d(R.string.no_network_tips);
        lm.g gVar = (lm.g) getMViewBinding();
        if (gVar == null || (recyclerView = gVar.b) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.moviedetail.fragment.s1
            @Override // java.lang.Runnable
            public final void run() {
                SubjectListFragment.loadMore$lambda$42(SubjectListFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadMore$lambda$42(SubjectListFragment subjectListFragment) {
        t6.f h0;
        com.transsion.moviedetail.adapter.j jVar = subjectListFragment.mAdapter;
        if (jVar == null || (h0 = jVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    private final void localLogPause() {
        bj.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.a mAudioApi_delegate$lambda$1() {
        return (ep.a) TheRouter.d(ep.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashSet mExposureList_delegate$lambda$4() {
        return new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.b mFloatApi_delegate$lambda$2() {
        return (ep.b) TheRouter.d(ep.b.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a mLoginApi_delegate$lambda$0() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.f mRoomApi_delegate$lambda$3() {
        return (ep.f) TheRouter.d(ep.f.class, new Object[0]);
    }

    @JvmStatic
    public static final SubjectListFragment newInstance(Bundle bundle, Class<? extends AbsSubjectListViewModel> cls) {
        return INSTANCE.a(bundle, cls);
    }

    private final void observeComment() {
        Function1 function1 = new Function1() { // from class: com.transsion.moviedetail.fragment.c2
            public final Object invoke(Object obj) {
                Unit observeComment$lambda$58;
                observeComment$lambda$58 = SubjectListFragment.observeComment$lambda$58(SubjectListFragment.this, (CommentEvent) obj);
                return observeComment$lambda$58;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = CommentEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeComment$lambda$58(SubjectListFragment subjectListFragment, CommentEvent commentEvent) {
        Stat stat;
        List data;
        List data2;
        Intrinsics.h(commentEvent, "value");
        try {
            com.transsion.moviedetail.adapter.j jVar = subjectListFragment.mAdapter;
            int i = -1;
            if (jVar != null && (data2 = jVar.getData()) != null) {
                Iterator it = data2.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), commentEvent.getSubjectId())) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i >= 0) {
                com.transsion.moviedetail.adapter.j jVar2 = subjectListFragment.mAdapter;
                PostSubjectItem postSubjectItem = (jVar2 == null || (data = jVar2.getData()) == null) ? null : (PostSubjectItem) data.get(i);
                if (postSubjectItem != null && (stat = postSubjectItem.getStat()) != null) {
                    try {
                        if (commentEvent.getStatus()) {
                            Long commentCount = stat.getCommentCount();
                            stat.setCommentCount(Long.valueOf((commentCount != null ? commentCount.longValue() : 0L) + 1));
                        } else {
                            Long commentCount2 = stat.getCommentCount();
                            stat.setCommentCount(Long.valueOf((commentCount2 != null ? commentCount2.longValue() : 1L) - 1));
                        }
                    } catch (Exception e2) {
                        a.a.g(wf.a.a, " callback change data fail " + e2.getMessage(), false, 2, (Object) null);
                    }
                }
                com.transsion.moviedetail.adapter.j jVar3 = subjectListFragment.mAdapter;
                if (jVar3 != null) {
                    jVar3.notifyItemChanged(i + (jVar3 != null ? jVar3.a0() : 0));
                }
            }
        } catch (Exception e3) {
            a.a.g(wf.a.a, " callback change data fail " + e3.getMessage(), false, 2, (Object) null);
        }
        return Unit.a;
    }

    private final void observeDelete() {
        Function1 function1 = new Function1() { // from class: com.transsion.moviedetail.fragment.r1
            public final Object invoke(Object obj) {
                Unit observeDelete$lambda$51;
                observeDelete$lambda$51 = SubjectListFragment.observeDelete$lambda$51(SubjectListFragment.this, (hx.b) obj);
                return observeDelete$lambda$51;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = hx.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeDelete$lambda$51(SubjectListFragment subjectListFragment, hx.b bVar) {
        com.transsion.moviedetail.adapter.j jVar;
        List data;
        Intrinsics.h(bVar, "value");
        try {
            com.transsion.moviedetail.adapter.j jVar2 = subjectListFragment.mAdapter;
            int i = -1;
            if (jVar2 != null && (data = jVar2.getData()) != null) {
                Iterator it = data.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), bVar.a())) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i >= 0 && (jVar = subjectListFragment.mAdapter) != null) {
                jVar.G0(i);
            }
            subjectListFragment.checkToShowEmptyView();
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        return Unit.a;
    }

    private final void observeLike() {
        Function1 function1 = new Function1() { // from class: com.transsion.moviedetail.fragment.t1
            public final Object invoke(Object obj) {
                Unit observeLike$lambda$55;
                observeLike$lambda$55 = SubjectListFragment.observeLike$lambda$55(SubjectListFragment.this, (LikeEvent) obj);
                return observeLike$lambda$55;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LikeEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeLike$lambda$55(SubjectListFragment subjectListFragment, LikeEvent likeEvent) {
        int i;
        Stat stat;
        Object obj;
        List data;
        List data2;
        int i2 = 1;
        Intrinsics.h(likeEvent, "value");
        try {
            com.transsion.moviedetail.adapter.j jVar = subjectListFragment.mAdapter;
            if (jVar != null && (data2 = jVar.getData()) != null) {
                Iterator it = data2.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), likeEvent.getSubjectId())) {
                        break;
                    }
                    i++;
                }
            }
            i = -1;
            if (i >= 0) {
                com.transsion.moviedetail.adapter.j jVar2 = subjectListFragment.mAdapter;
                PostSubjectItem postSubjectItem = (jVar2 == null || (data = jVar2.getData()) == null) ? null : (PostSubjectItem) data.get(i);
                if (postSubjectItem != null) {
                    postSubjectItem.setHasLike(Boolean.valueOf(likeEvent.getLike()));
                }
                if (postSubjectItem != null && (stat = postSubjectItem.getStat()) != null) {
                    try {
                        Result.Companion companion = Result.Companion;
                        Long likeCount = stat.getLikeCount();
                        long longValue = likeCount != null ? likeCount.longValue() : 0L;
                        if (!likeEvent.getLike()) {
                            i2 = -1;
                        }
                        stat.setLikeCount(Long.valueOf(longValue + i2));
                        obj = Result.constructor-impl(Unit.a);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.a(th2));
                    }
                    Result.box-impl(obj);
                }
                com.transsion.moviedetail.adapter.j jVar3 = subjectListFragment.mAdapter;
                if (jVar3 != null) {
                    jVar3.notifyItemChanged(i + (jVar3 != null ? jVar3.a0() : 0), Boolean.valueOf(likeEvent.getLike()));
                }
            }
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        return Unit.a;
    }

    private final void onDownLoadClick(PostSubjectItem postItem) {
        if (Build.VERSION.SDK_INT >= 29) {
            PostSaveHelper.a.e(postItem);
            return;
        }
        Context context = getContext();
        if (context == null) {
            context = Utils.a();
        }
        if (androidx.core.content.b.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            Context context2 = getContext();
            if (context2 == null) {
                context2 = Utils.a();
            }
            if (androidx.core.content.b.checkSelfPermission(context2, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
                PostSaveHelper.a.e(postItem);
                return;
            }
        }
        requestPermission();
    }

    private final void openDetail(PostSubjectItem postItem, boolean fromComment) {
        Media media;
        io.b bVar = (io.b) TheRouter.d(io.b.class, new Object[0]);
        AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
        PostListSource A = absSubjectListViewModel != null ? absSubjectListViewModel.A() : null;
        PostListSource postListSource = PostListSource.PROFILE;
        if (A != postListSource && postItem != null && bVar != null) {
            bVar.i(postItem);
        }
        Navigator z = TheRouter.c("/post/detail").K("page_from", pageName()).J("item_object", postItem).K("rec_ops", postItem != null ? postItem.getOps() : null).K("id", postItem != null ? postItem.getPostId() : null).K("item_type", postItem != null ? postItem.getItemType() : null).K("media_type", (postItem == null || (media = postItem.getMedia()) == null) ? null : media.getMediaType()).z("from_comment", fromComment);
        AbsSubjectListViewModel absSubjectListViewModel2 = this.mHotViewModel;
        Navigator.x(z.z("video_load_more", (absSubjectListViewModel2 != null ? absSubjectListViewModel2.A() : null) != postListSource), getContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String pageName() {
        String str = this.curPageName;
        return str == null ? BuildConfig.FLAVOR : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removePost(String id) {
        com.transsion.moviedetail.adapter.j jVar = this.mAdapter;
        if (jVar != null) {
            int i = 0;
            for (Object obj : jVar.getData()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                if (Intrinsics.c(((PostSubjectItem) obj).getPostId(), id)) {
                    if (jVar.getItemCount() > 2) {
                        jVar.getData().remove(i);
                        jVar.notifyDataSetChanged();
                        return;
                    } else {
                        jVar.getData().clear();
                        jVar.notifyDataSetChanged();
                        checkToShowEmptyView();
                        return;
                    }
                }
                i = i2;
            }
        }
    }

    private final void requestPermission() {
        requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, FileHelper.a.l());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void share(PostSubjectItem postItem) {
        boolean z;
        ShareDialogFragment a;
        User user;
        User user2;
        qx.a mLoginApi = getMLoginApi();
        UserInfo i = mLoginApi != null ? mLoginApi.i() : null;
        if ((i != null ? i.getUserId() : null) != null) {
            if (Intrinsics.c(i.getUserId(), (postItem == null || (user2 = postItem.getUser()) == null) ? null : user2.getUserId())) {
                z = true;
                a = ShareDialogFragment.INSTANCE.a(PostType.POST_TYPE, postItem == null ? postItem.getPostId() : null, (postItem != null || (user = postItem.getUser()) == null) ? null : user.getUserId(), ReportType.POST.getValue(), (r29 & 16) != 0 ? BuildConfig.FLAVOR : postItem != null ? postItem.getTitle() : null, (r29 & 32) != 0 ? BuildConfig.FLAVOR : BuildConfig.FLAVOR, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : z, (r29 & 256) != 0 ? false : false, "postdetail", (r29 & 1024) != 0 ? BuildConfig.FLAVOR : null, (r29 & 2048) != 0 ? BuildConfig.FLAVOR : null);
                a.G0(new e());
                a.show(getChildFragmentManager(), "share");
            }
        }
        z = false;
        a = ShareDialogFragment.INSTANCE.a(PostType.POST_TYPE, postItem == null ? postItem.getPostId() : null, (postItem != null || (user = postItem.getUser()) == null) ? null : user.getUserId(), ReportType.POST.getValue(), (r29 & 16) != 0 ? BuildConfig.FLAVOR : postItem != null ? postItem.getTitle() : null, (r29 & 32) != 0 ? BuildConfig.FLAVOR : BuildConfig.FLAVOR, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : z, (r29 & 256) != 0 ? false : false, "postdetail", (r29 & 1024) != 0 ? BuildConfig.FLAVOR : null, (r29 & 2048) != 0 ? BuildConfig.FLAVOR : null);
        a.G0(new e());
        a.show(getChildFragmentManager(), "share");
    }

    private final void showAudioFloating(PostSubjectItem item) {
        String str;
        Integer size;
        List audio;
        if (item != null) {
            String coverUrl$default = PostSubjectItem.getCoverUrl$default(item, false, 1, (Object) null);
            Media media = item.getMedia();
            Audio audio2 = (Audio) ((media == null || (audio = media.getAudio()) == null || audio.isEmpty()) ? null : audio.get(0));
            if (audio2 == null || (str = audio2.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            Long duration = audio2 != null ? audio2.getDuration() : null;
            Long valueOf = (audio2 == null || (size = audio2.getSize()) == null) ? null : Long.valueOf(size.intValue());
            String url = audio2 != null ? audio2.getUrl() : null;
            String title = item.getTitle();
            String content = item.getContent();
            if (content == null) {
                content = BuildConfig.FLAVOR;
            }
            Integer bitrate = audio2 != null ? audio2.getBitrate() : null;
            String postId = item.getPostId();
            Subject subject = item.getSubject();
            String subjectId = subject != null ? subject.getSubjectId() : null;
            Subject subject2 = item.getSubject();
            String title2 = subject2 != null ? subject2.getTitle() : null;
            Group group = item.getGroup();
            AudioBean audioBean = new AudioBean(str, coverUrl$default, duration, valueOf, url, title, content, bitrate, (Long) null, (Long) null, (String) null, (String) null, (String) null, postId, subjectId, group != null ? group.getGroupId() : null, 0, title2, 0, 0, 859904, (DefaultConstructorMarker) null);
            ep.b mFloatApi = getMFloatApi();
            if (mFloatApi != null) {
                mFloatApi.a(new WeakReference((Activity) getContext()), audioBean);
            }
            audioBean.setOps(item.getRec_ops());
            ep.a mAudioApi = getMAudioApi();
            if (mAudioApi != null) {
                a$a.a(mAudioApi, audioBean, false, 2, null);
            }
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public final String subpageName() {
        AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
        if (absSubjectListViewModel != null) {
            ProfileSubSource B = absSubjectListViewModel.B();
            String value = B != null ? B.getValue() : null;
            if (value != null) {
                return value;
            }
        }
        return BuildConfig.FLAVOR;
    }

    private final void toWeb(String url) {
        Navigator.x(TheRouter.c("/web/web").K("url", url), requireContext(), (mf.c) null, 2, (Object) null);
    }

    private final void updateDeletePost(BaseDto<String> data) {
        List data2;
        List data3;
        List data4;
        if (!Intrinsics.c(data != null ? data.getCode() : null, "0")) {
            fh.b.a.e(getString(com.transsion.moviedetail.R$string.delete_post_failed));
            return;
        }
        com.transsion.moviedetail.adapter.j jVar = this.mAdapter;
        List data5 = jVar != null ? jVar.getData() : null;
        if (data5 != null) {
            int i = 0;
            for (Object obj : data5) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                PostSubjectItem postSubjectItem = (PostSubjectItem) obj;
                if (Intrinsics.c(postSubjectItem.getPostId(), data.getData())) {
                    com.transsion.moviedetail.adapter.j jVar2 = this.mAdapter;
                    if (jVar2 == null || (data3 = jVar2.getData()) == null || data3.size() != 1) {
                        com.transsion.moviedetail.adapter.j jVar3 = this.mAdapter;
                        if (jVar3 != null) {
                            jVar3.notifyItemRemoved(i);
                        }
                        com.transsion.moviedetail.adapter.j jVar4 = this.mAdapter;
                        if (jVar4 == null || (data2 = jVar4.getData()) == null) {
                            return;
                        }
                        data2.remove(postSubjectItem);
                        return;
                    }
                    com.transsion.moviedetail.adapter.j jVar5 = this.mAdapter;
                    if (jVar5 != null && (data4 = jVar5.getData()) != null) {
                        data4.remove(postSubjectItem);
                    }
                    com.transsion.moviedetail.adapter.j jVar6 = this.mAdapter;
                    if (jVar6 != null) {
                        jVar6.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                i = i2;
            }
        }
    }

    private final void updateLikeStatus(LikeBean likeBean) {
        List data;
        com.transsion.moviedetail.adapter.j jVar = this.mAdapter;
        if (jVar == null || (data = jVar.getData()) == null) {
            return;
        }
        int i = 0;
        for (Object obj : data) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            PostSubjectItem postSubjectItem = (PostSubjectItem) obj;
            if (Intrinsics.c(likeBean.isAffected(), Boolean.TRUE) && Intrinsics.c(postSubjectItem.getPostId(), likeBean.getPostId())) {
                postSubjectItem.setHasLike(postSubjectItem.getHasLike() != null ? Boolean.valueOf(!r0.booleanValue()) : null);
                Stat stat = postSubjectItem.getStat();
                if (stat != null) {
                    stat.setLikeCount(likeBean.getLikes() != null ? Long.valueOf(r7.intValue()) : null);
                }
                com.transsion.moviedetail.adapter.j jVar2 = this.mAdapter;
                if (jVar2 != null) {
                    jVar2.notifyItemChanged(i);
                    return;
                }
                return;
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubjectList(PostSubjectBean postSubjectBean) {
        List arrayList;
        PostSubjectItem recommendRoomsBean;
        t6.f h0;
        Object obj;
        t6.f h02;
        Pager pager;
        t6.f h03;
        com.transsion.moviedetail.adapter.j jVar;
        t6.f h04;
        t6.f h05;
        com.transsion.moviedetail.adapter.j jVar2;
        t6.f h06;
        if (postSubjectBean == null) {
            com.transsion.moviedetail.adapter.j jVar3 = this.mAdapter;
            if (jVar3 != null && (h05 = jVar3.h0()) != null && h05.r() && (jVar2 = this.mAdapter) != null && (h06 = jVar2.h0()) != null) {
                h06.v();
            }
        } else {
            if (postSubjectBean.getSubject() != null) {
                this.mSubject = postSubjectBean.getSubject();
            }
            List<PostSubjectItem> items = postSubjectBean.getItems();
            if (items != null) {
                com.transsion.moviedetail.adapter.j jVar4 = this.mAdapter;
                if (jVar4 == null || (arrayList = jVar4.getData()) == null) {
                    arrayList = new ArrayList();
                }
                ArrayList arrayList2 = new ArrayList();
                if (arrayList.isEmpty()) {
                    for (PostSubjectItem postSubjectItem : items) {
                        Subject subject = this.mSubject;
                        if (subject != null) {
                            postSubjectItem.setSubject(subject);
                        }
                    }
                    arrayList2.addAll(items);
                } else {
                    for (PostSubjectItem postSubjectItem2 : items) {
                        if (!arrayList.contains(postSubjectItem2)) {
                            Subject subject2 = this.mSubject;
                            if (subject2 != null) {
                                postSubjectItem2.setSubject(subject2);
                            }
                            arrayList2.add(postSubjectItem2);
                        }
                    }
                }
                if (arrayList2.isEmpty()) {
                    com.transsion.moviedetail.adapter.j jVar5 = this.mAdapter;
                    if (jVar5 != null && (h0 = jVar5.h0()) != null) {
                        t6.f.u(h0, false, 1, (Object) null);
                    }
                    checkToShowEmptyView();
                    return;
                }
                if (this.mHotViewModel instanceof HotViewModel) {
                    com.transsion.moviedetail.adapter.j jVar6 = this.mAdapter;
                    List data = jVar6 != null ? jVar6.getData() : null;
                    if (data == null || data.isEmpty()) {
                        AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
                        Intrinsics.f(absSubjectListViewModel, "null cannot be cast to non-null type com.transsion.moviedetail.viewmodel.HotViewModel");
                        RoomBean roomBean = (RoomBean) ((HotViewModel) absSubjectListViewModel).d0().f();
                        if (roomBean != null && (recommendRoomsBean = getRecommendRoomsBean(roomBean)) != null) {
                            arrayList2.add(0, recommendRoomsBean);
                        }
                    }
                }
                com.transsion.moviedetail.adapter.j jVar7 = this.mAdapter;
                if (jVar7 != null) {
                    jVar7.q(arrayList2);
                }
            }
        }
        com.transsion.moviedetail.adapter.j jVar8 = this.mAdapter;
        if (jVar8 != null && (h03 = jVar8.h0()) != null && h03.r() && (jVar = this.mAdapter) != null && (h04 = jVar.h0()) != null) {
            h04.s();
        }
        if ((postSubjectBean == null || (pager = postSubjectBean.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.FALSE)) {
            com.transsion.moviedetail.adapter.j jVar9 = this.mAdapter;
            if (jVar9 != null && (h02 = jVar9.h0()) != null) {
                h02.t(false);
            }
            try {
                Result.Companion companion = Result.Companion;
                insertLast();
                obj = Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            Result.exceptionOrNull-impl(obj);
        }
        checkToShowEmptyView();
    }

    public View getEmptyView(boolean isShowTitleLayout) {
        if (this.mEmptyLayout == null) {
            ep.e eVar = null;
            View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_hot_empty_view, (ViewGroup) null);
            lm.x a = lm.x.a(inflate);
            Intrinsics.g(a, "bind(...)");
            if (this.mHotViewModel instanceof HotViewModel) {
                if (this.mRoomView == null) {
                    ep.f mRoomApi = getMRoomApi();
                    if (mRoomApi != null) {
                        Context context = inflate.getContext();
                        Intrinsics.g(context, "getContext(...)");
                        eVar = mRoomApi.c(context, RoomsViewType.TYPE_SUBJECT_DETAIL);
                    }
                    this.mRoomView = eVar;
                }
                FrameLayout frameLayout = a.c;
                ep.e eVar2 = this.mRoomView;
                Intrinsics.e(eVar2);
                frameLayout.addView(eVar2.getView());
            }
            FrameLayout frameLayout2 = a.b;
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            StateView stateView = new StateView(requireContext);
            stateView.showData(2, 2, isShowTitleLayout, getPageStateLayoutTitle(), getEmptyDescText());
            frameLayout2.addView(stateView);
            this.mEmptyLayout = inflate;
        }
        View view = this.mEmptyLayout;
        Intrinsics.e(view);
        return view;
    }

    public View getLoadingView() {
        return LayoutInflater.from(requireContext()).inflate(R$layout.layout_commnets_loading_view, (ViewGroup) getFlStateView(), false);
    }

    public View getLocalNoNetworkView(boolean isShowTitleLayout) {
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_state_view, (ViewGroup) null);
        lm.y a = lm.y.a(inflate);
        Intrinsics.g(a, "bind(...)");
        a.d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectListFragment.this.retryLoadData();
            }
        });
        Intrinsics.g(inflate, "apply(...)");
        return inflate;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public lm.g getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        lm.g c2 = lm.g.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void initListener() {
        initExposureHelper();
    }

    public void initViewData() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        initAd();
        lm.g gVar = (lm.g) getMViewBinding();
        if (gVar != null && (recyclerView2 = gVar.b) != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        }
        com.transsion.moviedetail.adapter.j jVar = new com.transsion.moviedetail.adapter.j(new ArrayList(), this.mHotViewModel, pageName(), qi.h.a.h());
        t6.f h0 = jVar.h0();
        h0.C(new SubjectCommentsLoadMoreView());
        h0.z(true);
        h0.D(new r6.f() { // from class: com.transsion.moviedetail.fragment.i2
            public final void a() {
                SubjectListFragment.this.loadMore();
            }
        });
        jVar.R0(new d());
        jVar.w1(new r6.d() { // from class: com.transsion.moviedetail.fragment.j2
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SubjectListFragment.initViewData$lambda$11$lambda$8(SubjectListFragment.this, baseQuickAdapter, view, i);
            }
        });
        initScrollListener();
        jVar.l(new int[]{R$id.fl_cover, R$id.tv_room_name, R$id.tv_post_date, R$id.v_post_like, R$id.v_post_download, R$id.v_post_comment, R$id.v_post_share, R$id.cl_subject_content, R$id.tv_room_tag});
        jVar.s1(new r6.b() { // from class: com.transsion.moviedetail.fragment.p1
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SubjectListFragment.initViewData$lambda$11$lambda$10(SubjectListFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mAdapter = jVar;
        lm.g gVar2 = (lm.g) getMViewBinding();
        if (gVar2 != null && (recyclerView = gVar2.b) != null) {
            recyclerView.setAdapter(this.mAdapter);
        }
        initLiveData();
        initClickListener();
        observeDelete();
        observeLike();
        observeComment();
        initLaunch();
        initPlayer();
        initListVideoPreload();
    }

    public void initViewModel() {
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public qi.b newLogViewConfig() {
        return new qi.b(pageName(), false, 2, null);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        List data;
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        super.onConnected(network, networkCapabilities);
        com.transsion.moviedetail.adapter.j jVar = this.mAdapter;
        if (jVar == null || (data = jVar.getData()) == null || !data.isEmpty()) {
            loadMore();
        } else {
            lazyLoadData();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        HashMap g;
        HashMap g2;
        String Z;
        HashMap g3;
        String str;
        super.onCreate(savedInstanceState);
        try {
            Bundle arguments = getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("view_model_type") : null;
            Intrinsics.f(serializable, "null cannot be cast to non-null type java.lang.Class<com.transsion.moviedetailapi.AbsSubjectListViewModel>");
            AbsSubjectListViewModel a = new androidx.lifecycle.v0(this).a((Class) serializable);
            this.mHotViewModel = a;
            if (a != null) {
                a.F(getArguments());
            }
            Bundle arguments2 = getArguments();
            this.curPageName = arguments2 != null ? arguments2.getString("page_name") : null;
            AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
            if (absSubjectListViewModel != null) {
                absSubjectListViewModel.N(qi.h.a.h());
            }
            if (this.mHotViewModel instanceof HotViewModel) {
                qi.b logViewConfig = getLogViewConfig();
                String str2 = BuildConfig.FLAVOR;
                if (logViewConfig != null && (g3 = logViewConfig.g()) != null) {
                    AbsSubjectListViewModel absSubjectListViewModel2 = this.mHotViewModel;
                    HotViewModel hotViewModel = absSubjectListViewModel2 instanceof HotViewModel ? (HotViewModel) absSubjectListViewModel2 : null;
                    if (hotViewModel == null || (str = hotViewModel.f0()) == null) {
                        str = BuildConfig.FLAVOR;
                    }
                }
                qi.b logViewConfig2 = getLogViewConfig();
                if (logViewConfig2 != null && (g2 = logViewConfig2.g()) != null) {
                    AbsSubjectListViewModel absSubjectListViewModel3 = this.mHotViewModel;
                    HotViewModel hotViewModel2 = absSubjectListViewModel3 instanceof HotViewModel ? (HotViewModel) absSubjectListViewModel3 : null;
                    if (hotViewModel2 != null && (Z = hotViewModel2.Z()) != null) {
                        str2 = Z;
                    }
                }
            }
        } catch (Exception unused) {
        }
        qi.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 == null || (g = logViewConfig3.g()) == null) {
            return;
        }
    }

    public void onDestroy() {
        com.transsion.ninegridview.a aVar = this.mGifPlayerManager;
        if (aVar != null) {
            aVar.f();
        }
        super.onDestroy();
        androidx.activity.result.b bVar = this.postDetailLauncher;
        if (bVar != null) {
            bVar.c();
        }
        BiddingListManager biddingListManager = this.middleListManager;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
        BiddingNativeManager biddingNativeManager = this.nativeManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.U();
        }
    }

    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
                localLogPause();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
    }

    public void onPause() {
        super.onPause();
        localLogPause();
        com.transsion.ninegridview.a aVar = this.mGifPlayerManager;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(grantResults, "grantResults");
        super/*androidx.fragment.app.Fragment*/.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == FileHelper.a.l()) {
            if (grantResults.length > 1 && grantResults[0] == 0 && grantResults[1] == 0) {
                PostSaveHelper.a.e(this.mPostSubjectItem);
                return;
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
        com.transsion.ninegridview.a aVar = this.mGifPlayerManager;
        if (aVar != null) {
            aVar.l();
        }
        if (this.isFirst) {
            this.isFirst = false;
            lazyLoadData();
        }
    }

    public void onRightButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
        com.transsion.ninegridview.helper.b bVar = com.transsion.ninegridview.helper.b.a;
        FragmentActivity activity = getActivity();
        Intrinsics.f(activity, "null cannot be cast to non-null type android.app.Activity");
        bVar.a(activity, 101);
    }

    public void onScreenChange(boolean fullscreen) {
        if (isAdded() && !isHidden() && isResumed()) {
            if (!fullscreen) {
                logResume();
            } else {
                logPause();
                localLogPause();
            }
        }
    }

    public final void refresh() {
        AbsSubjectListViewModel absSubjectListViewModel = this.mHotViewModel;
        if (absSubjectListViewModel != null) {
            absSubjectListViewModel.F(getArguments());
        }
        com.transsion.moviedetail.adapter.j jVar = this.mAdapter;
        if (jVar != null) {
            jVar.Q1();
        }
        com.transsion.ninegridview.a aVar = this.mGifPlayerManager;
        if (aVar != null) {
            aVar.m();
        }
        lazyLoadData();
    }

    public void retryLoadData() {
        lazyLoadData();
    }
}
