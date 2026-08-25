package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.tn.lib.widget.R;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.bean.GameInfoType;
import com.transsion.flow.bean.DubsInfo;
import com.transsion.flow.bean.PreVideoAddress;
import com.transsion.flow.bean.SubjectGameInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.player.longvideo.constants.LongVodPageType;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.player.longvideo.ui.LongVodUiType;
import com.transsion.player.p003enum.PlayMimeType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.push.PushConstants;
import com.transsion.usercenter.setting.labelsfeedback.model.FbTvData;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import cw.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kn.a;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import net.lucode.hackware.magicindicator.MagicIndicator;
import wf.a;

@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 À\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0005J\u0019\u0010'\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0019H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\u0005J\u0017\u0010/\u001a\u00020\u00192\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u0011\u00102\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0005J\u0017\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\u0005J\u0017\u0010:\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b:\u0010\u000bJ\u0019\u0010=\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010;H\u0002¢\u0006\u0004\b=\u0010>J\u0019\u0010A\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0006H\u0016¢\u0006\u0004\bC\u0010\u0005J\u0017\u0010F\u001a\u00020\u00022\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0019H\u0016¢\u0006\u0004\bK\u0010\u001bJ\u000f\u0010L\u001a\u00020\u0006H\u0016¢\u0006\u0004\bL\u0010\u0005J\u000f\u0010M\u001a\u00020\u0006H\u0016¢\u0006\u0004\bM\u0010\u0005J\u000f\u0010N\u001a\u00020\u0006H\u0016¢\u0006\u0004\bN\u0010\u0005J\u000f\u0010O\u001a\u00020\u0006H\u0016¢\u0006\u0004\bO\u0010\u0005J\u000f\u0010Q\u001a\u00020PH\u0016¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u0006H\u0016¢\u0006\u0004\bS\u0010\u0005J\u0011\u0010U\u001a\u0004\u0018\u00010TH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u0006H\u0016¢\u0006\u0004\bW\u0010\u0005J\u000f\u0010X\u001a\u00020\u0006H\u0016¢\u0006\u0004\bX\u0010\u0005J\u000f\u0010Y\u001a\u00020\u0006H\u0016¢\u0006\u0004\bY\u0010\u0005J\u000f\u0010Z\u001a\u00020\u0006H\u0016¢\u0006\u0004\bZ\u0010\u0005J\r\u0010[\u001a\u00020\u0006¢\u0006\u0004\b[\u0010\u0005J\u000f\u0010\\\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\\\u0010\u0005J\u0017\u0010^\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u0019H\u0016¢\u0006\u0004\b^\u0010+J\u000f\u0010_\u001a\u00020\u0006H\u0016¢\u0006\u0004\b_\u0010\u0005J\u000f\u0010`\u001a\u00020\u0006H\u0016¢\u0006\u0004\b`\u0010\u0005J\u001f\u0010c\u001a\u00020\u00062\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010aH\u0016¢\u0006\u0004\bc\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010o\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u001b\u0010u\u001a\u00020p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u001b\u0010z\u001a\u00020v8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010r\u001a\u0004\bx\u0010yR\u001d\u0010\u007f\u001a\u0004\u0018\u00010{8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b|\u0010r\u001a\u0004\b}\u0010~R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0085\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001b\u0010\u0087\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0081\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0081\u0001R\u0019\u0010\u008e\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u0089\u0001R\u0019\u0010\u0090\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0089\u0001R\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0081\u0001R(\u0010\u0097\u0001\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0093\u0001\u0010\u0084\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0005\b\u0096\u0001\u0010(R\u0019\u0010\u0099\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0089\u0001R\u0019\u0010\u009b\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u0084\u0001R\u001b\u0010\u009d\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u0081\u0001R\u001c\u0010¡\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u0019\u0010£\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010\u0089\u0001R\u001b\u0010¦\u0001\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u0019\u0010¨\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010\u0089\u0001R\u001c\u0010¬\u0001\u001a\u0005\u0018\u00010©\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\"\u0010±\u0001\u001a\u0005\u0018\u00010\u00ad\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b®\u0001\u0010r\u001a\u0006\b¯\u0001\u0010°\u0001R\u001a\u0010µ\u0001\u001a\u00030²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u0019\u0010¸\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R!\u0010»\u0001\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010¼\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001¨\u0006Á\u0001"}, d2 = {"Lcom/transsion/moviedetail/fragment/MovieDetailFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Llm/h;", "Len/a;", "<init>", "()V", BuildConfig.FLAVOR, "H1", "Lcom/transsion/moviedetailapi/bean/Subject;", "movieDetailBean", "L1", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "y1", "subject", "B1", "Lcom/transsion/moviedetailapi/bean/Trailer;", "trailer", "v1", "(Lcom/transsion/moviedetailapi/bean/Trailer;)V", BuildConfig.FLAVOR, "Lln/c;", "X0", "(Lcom/transsion/moviedetailapi/bean/Trailer;)Ljava/util/List;", "G1", "a1", BuildConfig.FLAVOR, "o1", "()Z", "f1", "M0", "P0", "L0", "Y0", "O0", "I1", "Q0", "q1", BuildConfig.FLAVOR, "visible", "J1", "(I)V", PushConstants.PUSH_SERVICE_TYPE_SHOW, "s1", "(Z)V", "i1", "Lcom/transsion/videofloat/bean/FloatActionType;", "actionType", "C1", "(Lcom/transsion/videofloat/bean/FloatActionType;)Z", "Ldw/a;", "R0", "()Ldw/a;", "c1", "Lcom/transsion/player/longvideo/ui/LongVodUiType;", "uiType", "t1", "(Lcom/transsion/player/longvideo/ui/LongVodUiType;)V", "F1", "g1", "Lln/a;", "bean", "u1", "(Lln/a;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "receiveArguments", "Landroid/view/LayoutInflater;", "inflater", "W0", "(Landroid/view/LayoutInflater;)Llm/h;", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "isRegisteDeviceKeyMonitor", "initViewData", "initViewModel", "initListener", "retryLoadData", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "loadDefaultData", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "onDestroyView", "onResume", "onPause", "onStop", "x1", "onDestroy", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "onHomeClick", "onRecentClick", "Lkotlin/Function0;", "callback", "S", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/transsnet/downloader/widget/DownloadView;", "a", "Lcom/transsnet/downloader/widget/DownloadView;", "downloadViewFloat", "Lzm/e;", "b", "Lzm/e;", "bottomRecHelper", "c", "Lcom/transsion/moviedetailapi/bean/Subject;", "mMovieDetailBean", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "d", "Lkotlin/Lazy;", "U0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "Lcom/transsnet/downloader/viewmodel/k0;", "e", "getDownloadViewModel", "()Lcom/transsnet/downloader/viewmodel/k0;", "downloadViewModel", "Ljo/a;", "f", "V0", "()Ljo/a;", "publishedApi", "g", "Ljava/lang/String;", "mSubjectId", "h", "I", "mSubjectType", "i", "ops", "j", "Z", "netResultSuccess", "k", "moduleName", "l", "autoDownload", "m", "autoPlay", "n", "autoPlayResourceId", "o", "getPreloadId", "()I", "setPreloadId", "preloadId", "p", "fetchDownloadFinish", "q", "curSeason", "r", "lastPageFrom", "Lkn/a;", "s", "Lkn/a;", "playerControl", "t", "hasClickedActivityTip", "u", "Landroid/view/View;", "gameResView", "v", "isGameResInit", "Lkk/a;", "w", "Lkk/a;", "palmPayApi", "Lim/b;", "x", "T0", "()Lim/b;", "memberProvider", BuildConfig.FLAVOR, "y", "J", "curAudioTrackPlayProgress", "z", "Lcom/transsion/player/longvideo/ui/LongVodUiType;", "curPlayerUiType", "A", "Lkotlin/jvm/functions/Function0;", "backPressedCallback", "Landroidx/fragment/app/Fragment;", "B", "Landroidx/fragment/app/Fragment;", "coverFragment", "C", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MovieDetailFragment extends PageStatusFragment<lm.h> implements en.a {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    private Function0 backPressedCallback;

    /* renamed from: B, reason: from kotlin metadata */
    private Fragment coverFragment;

    /* renamed from: a, reason: from kotlin metadata */
    private DownloadView downloadViewFloat;

    /* renamed from: b, reason: from kotlin metadata */
    private zm.e bottomRecHelper;

    /* renamed from: c, reason: from kotlin metadata */
    private Subject mMovieDetailBean;

    /* renamed from: g, reason: from kotlin metadata */
    private String mSubjectId;

    /* renamed from: i, reason: from kotlin metadata */
    private String ops;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean netResultSuccess;

    /* renamed from: k, reason: from kotlin metadata */
    private String moduleName;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean autoDownload;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean autoPlay;

    /* renamed from: n, reason: from kotlin metadata */
    private String autoPlayResourceId;

    /* renamed from: o, reason: from kotlin metadata */
    private int preloadId;

    /* renamed from: p, reason: from kotlin metadata */
    private boolean fetchDownloadFinish;

    /* renamed from: r, reason: from kotlin metadata */
    private String lastPageFrom;

    /* renamed from: s, reason: from kotlin metadata */
    private kn.a playerControl;

    /* renamed from: t, reason: from kotlin metadata */
    private boolean hasClickedActivityTip;

    /* renamed from: u, reason: from kotlin metadata */
    private View gameResView;

    /* renamed from: v, reason: from kotlin metadata */
    private boolean isGameResInit;

    /* renamed from: y, reason: from kotlin metadata */
    private long curAudioTrackPlayProgress;

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final androidx.lifecycle.x0 m39invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m40invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: e, reason: from kotlin metadata */
    private final Lazy downloadViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsnet.downloader.viewmodel.k0.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$special$$inlined$activityViewModels$default$3
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final androidx.lifecycle.x0 m41invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$special$$inlined$activityViewModels$default$4
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m42invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: f, reason: from kotlin metadata */
    private final Lazy publishedApi = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.fragment.u
        public final Object invoke() {
            jo.a w1;
            w1 = MovieDetailFragment.w1();
            return w1;
        }
    });

    /* renamed from: h, reason: from kotlin metadata */
    private int mSubjectType = SubjectType.MOVIE.getValue();

    /* renamed from: q, reason: from kotlin metadata */
    private int curSeason = 1;

    /* renamed from: w, reason: from kotlin metadata */
    private kk.a palmPayApi = (kk.a) TheRouter.d(kk.a.class, new Object[0]);

    /* renamed from: x, reason: from kotlin metadata */
    private final Lazy memberProvider = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.fragment.v
        public final Object invoke() {
            im.b p1;
            p1 = MovieDetailFragment.p1();
            return p1;
        }
    });

    /* renamed from: z, reason: from kotlin metadata */
    private LongVodUiType curPlayerUiType = LongVodUiType.MIDDLE;

    /* renamed from: com.transsion.moviedetail.fragment.MovieDetailFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MovieDetailFragment a() {
            return new MovieDetailFragment();
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            BubbleTextView bubbleTextView;
            ViewTreeObserver viewTreeObserver;
            lm.h hVar = (lm.h) MovieDetailFragment.this.getMViewBinding();
            if (hVar != null && (bubbleTextView = hVar.b) != null && (viewTreeObserver = bubbleTextView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            lm.h hVar2 = (lm.h) MovieDetailFragment.this.getMViewBinding();
            BubbleTextView bubbleTextView2 = hVar2 != null ? hVar2.b : null;
            if (bubbleTextView2 == null || bubbleTextView2.getMeasuredWidth() == 0) {
                return;
            }
            float measuredWidth = (bubbleTextView2.getMeasuredWidth() / 2) - (com.blankj.utilcode.util.a0.a(16.0f) / 2);
            bubbleTextView2.setArrowPosition(measuredWidth);
            a.a.f(wf.a.a, "movie_detail", "activity tip width: " + bubbleTextView2.getMeasuredWidth() + ", arrowPosition: " + measuredWidth, false, 4, (Object) null);
        }
    }

    public static final class c extends androidx.activity.u {
        c() {
            super(true);
        }

        public void handleOnBackPressed() {
            Function0 function0 = MovieDetailFragment.this.backPressedCallback;
            if (function0 == null || !((Boolean) function0.invoke()).booleanValue()) {
                if (MovieDetailFragment.this.playerControl != null) {
                    kn.a aVar = MovieDetailFragment.this.playerControl;
                    if (aVar != null) {
                        aVar.onBackPressed();
                        return;
                    }
                    return;
                }
                FragmentActivity activity = MovieDetailFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    static final class d implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        d(Function1 function1) {
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

    public static final class e implements gw.a {
        e() {
        }

        public boolean a(dw.a aVar) {
            return false;
        }

        public void b(dw.a aVar) {
        }

        public void c(dw.a aVar) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("oneroom://com.community.oneroom?type=/movie/detail&id=" + (aVar != null ? aVar.r() : null)));
            intent.setFlags(268435456);
            Utils.a().startActivity(intent);
        }
    }

    public static final class f implements a.b {
        f() {
        }

        @Override // kn.a.b
        public void a() {
        }

        @Override // kn.a.b
        public boolean b() {
            return false;
        }

        @Override // kn.a.b
        public boolean c(FloatActionType floatActionType) {
            Intrinsics.h(floatActionType, "actionType");
            return MovieDetailFragment.this.C1(floatActionType);
        }

        @Override // kn.a.b
        public void d(LongVodUiType longVodUiType) {
            Intrinsics.h(longVodUiType, "uiType");
            MovieDetailFragment.this.curPlayerUiType = longVodUiType;
            MovieDetailFragment.this.t1(longVodUiType);
            zm.e eVar = MovieDetailFragment.this.bottomRecHelper;
            if (eVar != null) {
                eVar.x(longVodUiType != LongVodUiType.MIDDLE);
            }
        }

        @Override // kn.a.b
        public View e() {
            return MovieDetailFragment.this.gameResView;
        }

        @Override // kn.a.b
        public void f(boolean z) {
            AppCompatImageView appCompatImageView;
            lm.h hVar = (lm.h) MovieDetailFragment.this.getMViewBinding();
            if (hVar == null || (appCompatImageView = hVar.j) == null) {
                return;
            }
            appCompatImageView.setVisibility(z ? 0 : 8);
        }

        @Override // kn.a.b
        public void g(ln.a aVar) {
            MovieDetailFragment.this.u1(aVar);
        }

        @Override // kn.a.b
        public void onCompletion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(MovieDetailFragment movieDetailFragment, Subject subject, View view) {
        String str;
        jo.a V0 = movieDetailFragment.V0();
        if (V0 != null) {
            Context context = view.getContext();
            Intrinsics.g(context, "getContext(...)");
            String str2 = movieDetailFragment.mSubjectId;
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            Cover cover = subject.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            String title = subject.getTitle();
            if (title == null) {
                title = BuildConfig.FLAVOR;
            }
            String description = subject.getDescription();
            if (description == null) {
                description = BuildConfig.FLAVOR;
            }
            V0.e(context, str2, str, title, description, 3);
        }
        com.transsion.baselib.helper.a.a.h("subjectdetail", "post", (r16 & 4) != 0 ? BuildConfig.FLAVOR : null, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void B1(Subject subject) {
        Fragment a;
        List items;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        if (this.coverFragment != null || subject == null) {
            return;
        }
        ResourceDetectors resourceDetector = subject.getResourceDetector();
        String downloadUrl = resourceDetector != null ? resourceDetector.getDownloadUrl() : null;
        Integer subjectType = subject.getSubjectType();
        SubjectType subjectType2 = SubjectType.MUSIC;
        int value = subjectType2.getValue();
        if (subjectType == null || subjectType.intValue() != value || downloadUrl == null || downloadUrl.length() == 0) {
            Integer subjectType3 = subject.getSubjectType();
            SubjectType subjectType4 = SubjectType.EDUCATION;
            int value2 = subjectType4.getValue();
            if (subjectType3 == null || subjectType3.intValue() != value2) {
                Trailer trailer = subject.getTrailer();
                if (trailer != null) {
                    v1(trailer);
                    return;
                }
                Cover stills = subject.getStills();
                if (stills == null) {
                    stills = subject.getCover();
                }
                if (stills != null) {
                    a = StillsFragment.INSTANCE.a(stills);
                    if (a != null) {
                    }
                }
            } else if (this.fetchDownloadFinish) {
                DownloadListBean downloadListBean = (DownloadListBean) U0().y().f();
                DownloadItem downloadItem = (downloadListBean == null || (items = downloadListBean.getItems()) == null) ? null : (DownloadItem) CollectionsKt.k0(items);
                if (downloadItem != null) {
                    Trailer trailer2 = new Trailer(0, (PreVideoAddress) null, (Cover) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
                    Cover stills2 = subject.getStills();
                    if (stills2 == null) {
                        stills2 = subject.getCover();
                    }
                    trailer2.setCover(stills2);
                    trailer2.setSubjectType(subjectType4.getValue());
                    trailer2.setSubjectId(subject.getSubjectId());
                    Long duration = downloadItem.getDuration();
                    trailer2.setVideoAddress(new PreVideoAddress(0, null, duration != null ? Integer.valueOf((int) duration.longValue()) : null, 0, 0, downloadItem.getSize(), 0, downloadItem.getUrl(), null, 0));
                    v1(trailer2);
                    return;
                }
                Trailer trailer3 = subject.getTrailer();
                if (trailer3 != null) {
                    v1(trailer3);
                    return;
                }
                Cover stills3 = subject.getStills();
                if (stills3 == null) {
                    stills3 = subject.getCover();
                }
                if (stills3 != null) {
                    a = StillsFragment.INSTANCE.a(stills3);
                    if (a != null) {
                        this.coverFragment = a;
                        if (((lm.h) getMViewBinding()) != null) {
                            int f2 = com.transsion.core.utils.e.f();
                            lm.h hVar = (lm.h) getMViewBinding();
                            if (hVar != null && (frameLayout2 = hVar.h) != null) {
                                r2 = frameLayout2.getLayoutParams();
                            }
                            if (r2 == null) {
                                r2 = new ConstraintLayout.b(f2, (f2 * 9) / 16);
                            } else {
                                ((ViewGroup.LayoutParams) r2).height = (f2 * 9) / 16;
                            }
                            lm.h hVar2 = (lm.h) getMViewBinding();
                            if (hVar2 != null && (frameLayout = hVar2.h) != null) {
                                frameLayout.setLayoutParams(r2);
                            }
                            FragmentManager childFragmentManager = getChildFragmentManager();
                            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
                            androidx.fragment.app.w p = childFragmentManager.p();
                            Intrinsics.g(p, "beginTransaction()");
                            int i = R$id.fl_player;
                            Fragment fragment = this.coverFragment;
                            Intrinsics.e(fragment);
                            p.s(i, fragment);
                            p.j();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        } else {
            Integer durationSeconds = subject.getDurationSeconds();
            PreVideoAddress preVideoAddress = new PreVideoAddress(0, null, Integer.valueOf(durationSeconds != null ? durationSeconds.intValue() : 0), 0, 0, 0L, 0, downloadUrl, BuildConfig.FLAVOR, 0);
            Cover stills4 = subject.getStills();
            if (stills4 == null) {
                stills4 = subject.getCover();
            }
            Trailer trailer4 = new Trailer(subjectType2.getValue(), preVideoAddress, stills4, (String) null, (String) null, 24, (DefaultConstructorMarker) null);
            trailer4.setSubjectId(subject.getSubjectId());
            trailer4.setMusicName(subject.getTitle());
            v1(trailer4);
        }
        a = null;
        if (a != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean C1(final FloatActionType actionType) {
        final FragmentActivity activity;
        ConstraintLayout root;
        Integer subjectType;
        Subject subject = this.mMovieDetailBean;
        if (((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()) != SubjectType.MUSIC.getValue() && (activity = getActivity()) != null && !activity.isDestroyed() && !activity.isFinishing()) {
            FloatActionType floatActionType = FloatActionType.ICON;
            if (actionType != floatActionType && !com.transsion.baselib.report.launch.b.a.b().getBoolean("k_pip_enable", true)) {
                wf.a.a.c("VideoFloat", "设置页pip开关被关闭了", true);
                return false;
            }
            final dw.a R0 = R0();
            if (R0 != null) {
                if (actionType != floatActionType && !R0.f().isPlaying()) {
                    wf.a.a.c("VideoFloat-pip", "movie 视频暂停，无需触发画中画", true);
                    return false;
                }
                e.a aVar = cw.e.a;
                if (aVar.b().c()) {
                    wf.a.a.c("VideoFloat-pip", "movie 当前可用画中画，使用画中画播放", true);
                    if (Build.VERSION.SDK_INT < 31 || actionType != FloatActionType.HOME) {
                        aVar.b().d(activity, R0, actionType, this.curPlayerUiType == LongVodUiType.LAND);
                    } else {
                        lm.h hVar = (lm.h) getMViewBinding();
                        if (hVar != null && (root = hVar.getRoot()) != null) {
                            root.postDelayed(new Runnable() { // from class: com.transsion.moviedetail.fragment.i
                                @Override // java.lang.Runnable
                                public final void run() {
                                    MovieDetailFragment.D1(activity, R0, actionType, this);
                                }
                            }, 1000L);
                        }
                    }
                    return true;
                }
                cw.b.a.c().e(activity, R0, actionType == floatActionType, this.curPlayerUiType == LongVodUiType.LAND, new Function1() { // from class: com.transsion.moviedetail.fragment.t
                    public final Object invoke(Object obj) {
                        Unit E1;
                        E1 = MovieDetailFragment.E1(activity, ((Boolean) obj).booleanValue());
                        return E1;
                    }
                }, new e());
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(FragmentActivity fragmentActivity, dw.a aVar, FloatActionType floatActionType, MovieDetailFragment movieDetailFragment) {
        cw.e.a.b().d(fragmentActivity, aVar, floatActionType, movieDetailFragment.curPlayerUiType == LongVodUiType.LAND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E1(FragmentActivity fragmentActivity, boolean z) {
        if (z && fragmentActivity != null) {
            fragmentActivity.finish();
        }
        return Unit.a;
    }

    private final void F1() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        View view = this.gameResView;
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.gameResView);
        }
        KeyEvent.Callback callback = this.gameResView;
        wj.c cVar = callback instanceof wj.c ? (wj.c) callback : null;
        if (cVar != null) {
            cVar.setPageStyle("detail");
        }
        lm.h hVar = (lm.h) getMViewBinding();
        if (hVar != null && (frameLayout3 = hVar.i) != null) {
            uf.c.k(frameLayout3);
        }
        lm.h hVar2 = (lm.h) getMViewBinding();
        if (hVar2 != null && (frameLayout2 = hVar2.i) != null) {
            frameLayout2.removeAllViews();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        lm.h hVar3 = (lm.h) getMViewBinding();
        if (hVar3 == null || (frameLayout = hVar3.i) == null) {
            return;
        }
        frameLayout.addView(this.gameResView, layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.view.View, com.transsion.player.longvideo.ui.LongVodPlayerView, kn.a] */
    private final void G1() {
        Context context;
        Integer subjectType;
        if (this.playerControl == null && (context = getContext()) != null) {
            Subject subject = this.mMovieDetailBean;
            LongVodPageType longVodPageType = ((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()) == SubjectType.MUSIC.getValue() ? LongVodPageType.MUSIC : LongVodPageType.TRAILER;
            lm.h hVar = (lm.h) getMViewBinding();
            if (hVar != null) {
                ?? longVodPlayerView = new LongVodPlayerView(context);
                String name = longVodPageType.name();
                Subject subject2 = this.mMovieDetailBean;
                a.C0081a.a(longVodPlayerView, "subjectdetail", longVodPageType, name + (subject2 != null ? subject2.getSubjectId() : null), hVar.g, hVar.l.f, null, null, 96, null);
                Subject subject3 = this.mMovieDetailBean;
                longVodPlayerView.initAdHelper(subject3 != null ? subject3.getGenre() : null);
                longVodPlayerView.setFeedBackVisible(true);
                this.playerControl = longVodPlayerView;
                hVar.h.addView(longVodPlayerView);
            }
            Subject subject4 = this.mMovieDetailBean;
            if (subject4 != null) {
                g1(subject4);
            }
            kn.a aVar = this.playerControl;
            if (aVar != null) {
                aVar.setCallback(new f());
            }
        }
    }

    private final void H1() {
        new zm.g(this, R$id.subjectDetailLayout, this.mMovieDetailBean, "subjectdetail", this.moduleName, false, false, 96, null);
    }

    private final void I1() {
        BubbleTextView bubbleTextView;
        DownloadView downloadView;
        DownloadView downloadView2;
        BubbleTextView bubbleTextView2;
        if (L0() && (downloadView = this.downloadViewFloat) != null && downloadView.getVisibility() == 0 && (downloadView2 = this.downloadViewFloat) != null && downloadView2.getShowType() == 0) {
            lm.h hVar = (lm.h) getMViewBinding();
            if (hVar != null && (bubbleTextView2 = hVar.b) != null) {
                uf.c.k(bubbleTextView2);
            }
            O0();
            return;
        }
        lm.h hVar2 = (lm.h) getMViewBinding();
        if (hVar2 == null || (bubbleTextView = hVar2.b) == null) {
            return;
        }
        uf.c.g(bubbleTextView);
    }

    private final void J1(int visible) {
        HashMap g;
        ResourceDetectors resourceDetector;
        List resourceDetectors;
        DownloadView downloadView = this.downloadViewFloat;
        if (downloadView != null) {
            downloadView.setVisibility(visible);
        }
        Subject subject = this.mMovieDetailBean;
        if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && !resourceDetectors.isEmpty()) {
            ((ResourceDetectors) resourceDetectors.get(0)).getResourceId();
            ((ResourceDetectors) resourceDetectors.get(0)).isMultiResolution();
        }
        Subject subject2 = this.mMovieDetailBean;
        if (subject2 != null && (resourceDetector = subject2.getResourceDetector()) != null) {
            resourceDetector.getResourceId();
            resourceDetector.isMultiResolution();
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g = logViewConfig.g()) != null) {
        }
        I1();
    }

    static /* synthetic */ void K1(MovieDetailFragment movieDetailFragment, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        movieDetailFragment.J1(i);
    }

    private final boolean L0() {
        kk.a aVar;
        if (this.hasClickedActivityTip || (aVar = this.palmPayApi) == null) {
            return false;
        }
        return aVar.g();
    }

    private final void L1(Subject movieDetailBean) {
        Subject subject;
        View view;
        View view2;
        FrameLayout frameLayout;
        this.mMovieDetailBean = movieDetailBean;
        if (!this.isGameResInit) {
            c1();
            s1(true);
        }
        Subject subject2 = this.mMovieDetailBean;
        String ops = subject2 != null ? subject2.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject = this.mMovieDetailBean) != null) {
            subject.setOps(this.ops);
        }
        Subject subject3 = this.mMovieDetailBean;
        if (subject3 == null || !subject3.isFamilyModeIntercept()) {
            B1(this.mMovieDetailBean);
        } else {
            lm.h hVar = (lm.h) getMViewBinding();
            if (hVar != null && (frameLayout = hVar.h) != null) {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                ((ViewGroup.MarginLayoutParams) bVar).height = lj.a.b(48);
                frameLayout.setLayoutParams(bVar);
            }
            lm.h hVar2 = (lm.h) getMViewBinding();
            if (hVar2 != null && (view2 = hVar2.s) != null) {
                uf.c.g(view2);
            }
            lm.h hVar3 = (lm.h) getMViewBinding();
            if (hVar3 != null && (view = hVar3.t) != null) {
                view.setBackgroundResource(R.color.bg_01);
            }
        }
        if (this.downloadViewFloat == null) {
            M0();
            K1(this, 0, 1, null);
        }
        a1();
        f1();
        if (this.autoDownload) {
            this.autoDownload = false;
            DownloadView downloadView = this.downloadViewFloat;
            if (downloadView != null) {
                downloadView.post(new Runnable() { // from class: com.transsion.moviedetail.fragment.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        MovieDetailFragment.M1(MovieDetailFragment.this);
                    }
                });
            }
        }
        y1();
    }

    private final void M0() {
        if (o1()) {
            Subject subject = this.mMovieDetailBean;
            if (subject == null || !subject.isFamilyModeIntercept()) {
                lm.h hVar = (lm.h) getMViewBinding();
                DownloadView downloadView = hVar != null ? hVar.d : null;
                this.downloadViewFloat = downloadView;
                if (downloadView != null) {
                    downloadView.setPageFrom("subjectdetail");
                }
                DownloadView downloadView2 = this.downloadViewFloat;
                if (downloadView2 != null) {
                    DownloadView.setAttrs$default(downloadView2, (Integer) null, Float.valueOf(com.transsion.core.utils.e.g(16.0f)), (Integer) null, 5, (Object) null);
                }
                DownloadView downloadView3 = this.downloadViewFloat;
                if (downloadView3 != null) {
                    downloadView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MovieDetailFragment.N0(MovieDetailFragment.this, view);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(MovieDetailFragment movieDetailFragment) {
        movieDetailFragment.P0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(MovieDetailFragment movieDetailFragment, View view) {
        ResourceDetectors resourceDetector;
        List resolutionList;
        Subject subject;
        ResourceDetectors resourceDetector2;
        ResourceDetectors resourceDetector3;
        List resolutionList2;
        Subject subject2 = movieDetailFragment.mMovieDetailBean;
        if (subject2 != null && (resourceDetector = subject2.getResourceDetector()) != null && (resolutionList = resourceDetector.getResolutionList()) != null && (!resolutionList.isEmpty())) {
            Subject subject3 = movieDetailFragment.mMovieDetailBean;
            Integer valueOf = (subject3 == null || (resourceDetector3 = subject3.getResourceDetector()) == null || (resolutionList2 = resourceDetector3.getResolutionList()) == null) ? null : Integer.valueOf(resolutionList2.size());
            Intrinsics.e(valueOf);
            if (valueOf.intValue() > 1 && (subject = movieDetailFragment.mMovieDetailBean) != null && (resourceDetector2 = subject.getResourceDetector()) != null) {
                resourceDetector2.setType(1);
            }
        }
        movieDetailFragment.P0();
    }

    private final void O0() {
        BubbleTextView bubbleTextView;
        ViewTreeObserver viewTreeObserver;
        lm.h hVar = (lm.h) getMViewBinding();
        if (hVar == null || (bubbleTextView = hVar.b) == null || (viewTreeObserver = bubbleTextView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    private final void P0() {
        List resourceDetectors;
        if (getContext() == null) {
            return;
        }
        Q0();
        Subject subject = this.mMovieDetailBean;
        String str = BuildConfig.FLAVOR;
        if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && !resourceDetectors.isEmpty()) {
            String resourceLink = ((ResourceDetectors) resourceDetectors.get(0)).getResourceLink();
            if (resourceLink != null) {
                str = resourceLink;
            }
            ((ResourceDetectors) resourceDetectors.get(0)).getResourceId();
            ((ResourceDetectors) resourceDetectors.get(0)).isMultiResolution();
        }
        String str2 = str;
        Subject subject2 = this.mMovieDetailBean;
        String str3 = null;
        if (subject2 != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi a = DownloadManagerApi.j.a();
                FragmentActivity context = getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = context;
                String str4 = this.ops;
                if (str4 == null || str4.length() == 0) {
                    Subject subject3 = this.mMovieDetailBean;
                    if (subject3 != null) {
                        str3 = subject3.getOps();
                    }
                } else {
                    str3 = this.ops;
                }
                DownloadManagerApi.e0(a, fragmentActivity, "subjectdetail", BuildConfig.FLAVOR, str3, "download_subject", true, this.mMovieDetailBean, (String) null, (Boolean) null, 384, (Object) null);
                return;
            }
        }
        DownloadManagerApi a2 = DownloadManagerApi.j.a();
        FragmentActivity context2 = getContext();
        Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity2 = context2;
        Subject subject4 = this.mMovieDetailBean;
        String str5 = this.ops;
        if (str5 == null || str5.length() == 0) {
            Subject subject5 = this.mMovieDetailBean;
            if (subject5 != null) {
                str3 = subject5.getOps();
            }
        } else {
            str3 = this.ops;
        }
        DownloadManagerApi.N(a2, fragmentActivity2, subject4, "subjectdetail", BuildConfig.FLAVOR, str3, str2, (String) null, this.moduleName, (String) null, false, this.curSeason, false, 832, (Object) null);
    }

    private final void Q0() {
        BubbleTextView bubbleTextView;
        this.hasClickedActivityTip = true;
        lm.h hVar = (lm.h) getMViewBinding();
        if (hVar == null || (bubbleTextView = hVar.b) == null) {
            return;
        }
        uf.c.g(bubbleTextView);
    }

    private final dw.a R0() {
        String str;
        kn.a aVar = this.playerControl;
        com.transsion.player.orplayer.f player = aVar != null ? aVar.getPlayer() : null;
        kn.a aVar2 = this.playerControl;
        ORPlayerView orPlayerView = aVar2 != null ? aVar2.getOrPlayerView() : null;
        if (orPlayerView == null || player == null) {
            return null;
        }
        a.a aVar3 = wf.a.a;
        Subject subject = this.mMovieDetailBean;
        aVar3.c("VideoFloat", "trailer--showFloat, title:" + (subject != null ? subject.getTitle() : null), true);
        FloatPlayType floatPlayType = FloatPlayType.TRAILER;
        Subject subject2 = this.mMovieDetailBean;
        if (subject2 == null || (str = subject2.getSubjectId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        return new dw.a(orPlayerView, player, (ViewGroup) null, floatPlayType, str, 0, 0, BuildConfig.FLAVOR, "subjectdetail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(MovieDetailFragment movieDetailFragment, View view) {
        movieDetailFragment.requireActivity().finish();
    }

    private final im.b T0() {
        return (im.b) this.memberProvider.getValue();
    }

    private final MovieDetailViewModel U0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    private final jo.a V0() {
        return (jo.a) this.publishedApi.getValue();
    }

    private final List X0(Trailer trailer) {
        Integer duration;
        String num;
        Long size;
        String l;
        String url;
        String videoId;
        ArrayList arrayList = new ArrayList();
        PlayMimeType playMimeType = PlayMimeType.DEFAULT;
        PreVideoAddress videoAddress = trailer.getVideoAddress();
        String str = (videoAddress == null || (videoId = videoAddress.getVideoId()) == null) ? BuildConfig.FLAVOR : videoId;
        PreVideoAddress videoAddress2 = trailer.getVideoAddress();
        String str2 = (videoAddress2 == null || (url = videoAddress2.getUrl()) == null) ? BuildConfig.FLAVOR : url;
        PreVideoAddress videoAddress3 = trailer.getVideoAddress();
        String str3 = (videoAddress3 == null || (size = videoAddress3.getSize()) == null || (l = size.toString()) == null) ? BuildConfig.FLAVOR : l;
        PreVideoAddress videoAddress4 = trailer.getVideoAddress();
        arrayList.add(new ln.c(playMimeType, str, str2, BuildConfig.FLAVOR, str3, (videoAddress4 == null || (duration = videoAddress4.getDuration()) == null || (num = duration.toString()) == null) ? BuildConfig.FLAVOR : num, BuildConfig.FLAVOR, null, 128, null));
        return arrayList;
    }

    private final void Y0() {
        BubbleTextView bubbleTextView;
        lm.h hVar = (lm.h) getMViewBinding();
        if (hVar == null || (bubbleTextView = hVar.b) == null) {
            return;
        }
        bubbleTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieDetailFragment.Z0(MovieDetailFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(MovieDetailFragment movieDetailFragment, View view) {
        a.a.f(wf.a.a, "movie_detail", "Click activity tip", false, 4, (Object) null);
        movieDetailFragment.hasClickedActivityTip = true;
        Intrinsics.e(view);
        uf.c.g(view);
    }

    private final void a1() {
        Subject subject = this.mMovieDetailBean;
        lm.h hVar = (lm.h) getMViewBinding();
        MagicIndicator magicIndicator = hVar != null ? hVar.m : null;
        lm.h hVar2 = (lm.h) getMViewBinding();
        this.bottomRecHelper = new zm.e(this, subject, magicIndicator, hVar2 != null ? hVar2.n : null, "subjectdetail", false, false, new Function1() { // from class: com.transsion.moviedetail.fragment.p
            public final Object invoke(Object obj) {
                Unit b1;
                b1 = MovieDetailFragment.b1(MovieDetailFragment.this, ((Integer) obj).intValue());
                return b1;
            }
        }, 96, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(MovieDetailFragment movieDetailFragment, int i) {
        TnTextView tnTextView;
        DownloadView downloadView = movieDetailFragment.downloadViewFloat;
        if (downloadView != null && downloadView != null) {
            downloadView.setVisibility(i != 1 ? 0 : 8);
        }
        lm.h hVar = (lm.h) movieDetailFragment.getMViewBinding();
        if (hVar != null && (tnTextView = hVar.r) != null) {
            tnTextView.setVisibility(i == 1 ? 0 : 8);
        }
        return Unit.a;
    }

    private final void c1() {
        String genre;
        wj.b bVar;
        SubjectGameInfo gameInfo;
        SubjectGameInfo gameInfo2;
        SubjectGameInfo gameInfo3;
        SubjectGameInfo gameInfo4;
        this.isGameResInit = true;
        Subject subject = this.mMovieDetailBean;
        String str = null;
        String type = (subject == null || (gameInfo4 = subject.getGameInfo()) == null) ? null : gameInfo4.getType();
        if (type != null && type.length() != 0) {
            Subject subject2 = this.mMovieDetailBean;
            String itemId = (subject2 == null || (gameInfo3 = subject2.getGameInfo()) == null) ? null : gameInfo3.getItemId();
            if (itemId != null && itemId.length() != 0) {
                a.a.f(wf.a.a, "GameResLoader", "sub detail game initGameRes", false, 4, (Object) null);
                Context context = getContext();
                if (context == null || (bVar = (wj.b) TheRouter.d(wj.b.class, new Object[0])) == null) {
                    return;
                }
                Subject subject3 = this.mMovieDetailBean;
                GameInfoType gameInfoType = (subject3 == null || (gameInfo2 = subject3.getGameInfo()) == null) ? null : gameInfo2.getGameInfoType();
                Intrinsics.e(gameInfoType);
                Subject subject4 = this.mMovieDetailBean;
                if (subject4 != null && (gameInfo = subject4.getGameInfo()) != null) {
                    str = gameInfo.getItemId();
                }
                String str2 = str;
                Intrinsics.e(str2);
                bVar.a(context, "subjectdetail", gameInfoType, str2, new Function1() { // from class: com.transsion.moviedetail.fragment.q
                    public final Object invoke(Object obj) {
                        Unit d1;
                        d1 = MovieDetailFragment.d1(MovieDetailFragment.this, (View) obj);
                        return d1;
                    }
                });
                return;
            }
        }
        Subject subject5 = this.mMovieDetailBean;
        if (subject5 == null || (genre = subject5.getGenre()) == null) {
            return;
        }
        String lowerCase = genre.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        if (lowerCase == null || !StringsKt.c0(lowerCase, "game", false, 2, (Object) null)) {
            return;
        }
        a.a.l(wf.a.a, "GameResLoader", "sub detail,  game is null", false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(MovieDetailFragment movieDetailFragment, View view) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        movieDetailFragment.gameResView = view;
        if (view == null) {
            lm.h hVar = (lm.h) movieDetailFragment.getMViewBinding();
            if (hVar != null && (frameLayout2 = hVar.i) != null) {
                uf.c.g(frameLayout2);
            }
            lm.h hVar2 = (lm.h) movieDetailFragment.getMViewBinding();
            if (hVar2 != null && (frameLayout = hVar2.i) != null) {
                frameLayout.removeAllViews();
            }
        } else {
            movieDetailFragment.F1();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(MovieDetailFragment movieDetailFragment, View view) {
        FragmentActivity activity;
        if (movieDetailFragment.playerControl != null) {
            if (movieDetailFragment.C1(FloatActionType.BACK) || (activity = movieDetailFragment.getActivity()) == null) {
                return;
            }
            activity.finish();
            return;
        }
        FragmentActivity activity2 = movieDetailFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    private final void f1() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        androidx.fragment.app.w p = childFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        Subject subject = this.mMovieDetailBean;
        if (subject != null && subject.isFamilyModeIntercept()) {
            ResourceDetectorFamilyModeFragment resourceDetectorFamilyModeFragment = new ResourceDetectorFamilyModeFragment();
            resourceDetectorFamilyModeFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("data_key_resource_detectors", this.mMovieDetailBean)}));
            p.s(R$id.resourceDetectorGroup, resourceDetectorFamilyModeFragment);
        } else if (o1()) {
            ResourceDetectorFragment resourceDetectorFragment = new ResourceDetectorFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_key_resource_detectors", this.mMovieDetailBean);
            bundle.putString("ops", this.ops);
            bundle.putBoolean("auto_play", this.autoPlay);
            bundle.putString("auto_play_resource_id", this.autoPlayResourceId);
            bundle.putString("module_name", this.moduleName);
            bundle.putInt("season", this.curSeason);
            resourceDetectorFragment.setArguments(bundle);
            p.s(R$id.resourceDetectorGroup, resourceDetectorFragment);
        } else {
            ResourceDetectorEmptyFragment resourceDetectorEmptyFragment = new ResourceDetectorEmptyFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("data_key_resource_detectors", this.mMovieDetailBean);
            resourceDetectorEmptyFragment.setArguments(bundle2);
            p.s(R$id.resourceDetectorGroup, resourceDetectorEmptyFragment);
        }
        p.j();
    }

    private final void g1(Subject movieDetailBean) {
        String restrictLevel = movieDetailBean.getRestrictLevel();
        if (restrictLevel == null || restrictLevel.length() == 0 || !com.transsion.baselib.report.launch.b.a.b().getBoolean("restrict_tips_dialog_again", true)) {
            return;
        }
        kn.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.onHandlePause();
        }
        ConfigBean d2 = cm.f.d(cm.f.c.a(), "sa_restrict_tips", false, 2, (Object) null);
        String value = d2 != null ? d2.getValue() : null;
        if (value == null || value.length() == 0) {
            value = Utils.a().getString(R$string.movie_detail_restrict_tips);
        }
        final RestrictTipsDialog a = RestrictTipsDialog.INSTANCE.a(value, "subjectdetail", movieDetailBean.getSubjectId());
        a.l0(this, "RestrictTipsDialog");
        a.y0(new Function1() { // from class: com.transsion.moviedetail.fragment.o
            public final Object invoke(Object obj) {
                Unit h1;
                h1 = MovieDetailFragment.h1(RestrictTipsDialog.this, this, ((Boolean) obj).booleanValue());
                return h1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(RestrictTipsDialog restrictTipsDialog, MovieDetailFragment movieDetailFragment, boolean z) {
        if (z) {
            kn.a aVar = movieDetailFragment.playerControl;
            if (aVar != null) {
                aVar.onHandlePlay();
            }
        } else {
            FragmentActivity activity = restrictTipsDialog.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        return Unit.a;
    }

    private final void i1() {
        ConstraintLayout root;
        lm.h hVar = (lm.h) getMViewBinding();
        if (hVar == null || (root = hVar.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsion.moviedetail.fragment.a0
            @Override // java.lang.Runnable
            public final void run() {
                MovieDetailFragment.j1(MovieDetailFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(MovieDetailFragment movieDetailFragment) {
        Subject subject;
        String subjectId;
        String ops;
        FragmentActivity activity = movieDetailFragment.getActivity();
        if (activity == null || (subject = movieDetailFragment.mMovieDetailBean) == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        cw.b c2 = cw.b.a.c();
        Subject subject2 = movieDetailFragment.mMovieDetailBean;
        c2.f(activity, subjectId, (String) null, "subjectdetail", (subject2 == null || (ops = subject2.getOps()) == null) ? movieDetailFragment.ops : ops);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(MovieDetailFragment movieDetailFragment, Pair pair) {
        HashMap g;
        HashMap g2;
        HashMap g3;
        Subject subject = (Subject) pair.getSecond();
        MovieDetailActivity.INSTANCE.a("movie_detail get movie detail data --> it = " + subject);
        if (subject == null) {
            if (Intrinsics.c(pair.getFirst(), "404")) {
                com.tn.lib.widget.toast.core.h.a.k(R$string.movie_lost_content);
                kotlinx.coroutines.i.d(androidx.lifecycle.v.a(movieDetailFragment), (CoroutineContext) null, (CoroutineStart) null, new MovieDetailFragment$initViewModel$1$1$1(movieDetailFragment, null), 3, (Object) null);
            }
            if (yg.l.a.e()) {
                PageStatusFragment.showEmptyView$default(movieDetailFragment, false, 1, (Object) null);
            } else {
                PageStatusFragment.showNoNetworkView$default(movieDetailFragment, false, 1, (Object) null);
            }
        } else {
            if (subject.isRefreshViewOnly()) {
                movieDetailFragment.L1(subject);
                return Unit.a;
            }
            MovieDetailViewModel U0 = movieDetailFragment.U0();
            String subjectId = subject.getSubjectId();
            Integer subjectType = subject.getSubjectType();
            Context context = movieDetailFragment.getContext();
            MovieDetailViewModel.u(U0, subjectId, subjectType, 0, context != null && com.transsion.baseui.util.b.a(context), 4, null);
            Integer subjectType2 = subject.getSubjectType();
            movieDetailFragment.mSubjectType = subjectType2 != null ? subjectType2.intValue() : movieDetailFragment.mSubjectType;
            movieDetailFragment.showContentView();
            movieDetailFragment.netResultSuccess = true;
            movieDetailFragment.L1(subject);
            movieDetailFragment.H1();
            qi.b logViewConfig = movieDetailFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            qi.b logViewConfig2 = movieDetailFragment.getLogViewConfig();
            if (logViewConfig2 != null) {
                logViewConfig2.n(movieDetailFragment.ops);
            }
            qi.b logViewConfig3 = movieDetailFragment.getLogViewConfig();
            if (logViewConfig3 != null && (g3 = logViewConfig3.g()) != null) {
                String subjectId2 = subject.getSubjectId();
                if (subjectId2 == null) {
                    subjectId2 = BuildConfig.FLAVOR;
                }
                g3.put("subject_id", subjectId2);
            }
            qi.b logViewConfig4 = movieDetailFragment.getLogViewConfig();
            if (logViewConfig4 != null && (g2 = logViewConfig4.g()) != null) {
                g2.put("has_resource", String.valueOf(subject.getHasResource()));
            }
            qi.b logViewConfig5 = movieDetailFragment.getLogViewConfig();
            if (logViewConfig5 != null && (g = logViewConfig5.g()) != null) {
                g.put("module_name", movieDetailFragment.moduleName);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(MovieDetailFragment movieDetailFragment, DownloadListBean downloadListBean) {
        movieDetailFragment.fetchDownloadFinish = true;
        Subject subject = movieDetailFragment.mMovieDetailBean;
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.EDUCATION.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                movieDetailFragment.B1(movieDetailFragment.mMovieDetailBean);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(MovieDetailFragment movieDetailFragment, Integer num) {
        int i = movieDetailFragment.curSeason;
        if (num != null && i == num.intValue()) {
            return Unit.a;
        }
        Intrinsics.e(num);
        movieDetailFragment.curSeason = num.intValue();
        String str = movieDetailFragment.mSubjectId;
        if (str != null) {
            movieDetailFragment.U0().D(str, Integer.valueOf(movieDetailFragment.curSeason), true);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(MovieDetailFragment movieDetailFragment, DubsInfo dubsInfo) {
        kn.a aVar = movieDetailFragment.playerControl;
        movieDetailFragment.curAudioTrackPlayProgress = aVar != null ? aVar.currentPosition() : 0L;
        movieDetailFragment.mSubjectId = dubsInfo.getSubjectId();
        movieDetailFragment.mMovieDetailBean = null;
        MovieDetailViewModel U0 = movieDetailFragment.U0();
        int i = movieDetailFragment.preloadId;
        String str = movieDetailFragment.mSubjectId;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        U0.S(i, str, Integer.valueOf(movieDetailFragment.curSeason));
        movieDetailFragment.loadDefaultData();
        return Unit.a;
    }

    private final boolean o1() {
        Boolean hasResource;
        Subject subject = this.mMovieDetailBean;
        if (subject == null || (hasResource = subject.getHasResource()) == null) {
            return false;
        }
        return hasResource.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final im.b p1() {
        return (im.b) TheRouter.d(im.b.class, new Object[0]);
    }

    private final void q1() {
        AppCompatActivity context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.moviedetail.fragment.w
            public final Object invoke(Object obj) {
                Unit r1;
                r1 = MovieDetailFragment.r1(MovieDetailFragment.this, (AddToDownloadEvent) obj);
                return r1;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(context, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(MovieDetailFragment movieDetailFragment, AddToDownloadEvent addToDownloadEvent) {
        Intrinsics.h(addToDownloadEvent, "value");
        try {
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        if (!TextUtils.equals(addToDownloadEvent.getSubjectId(), movieDetailFragment.mSubjectId)) {
            return Unit.a;
        }
        if (movieDetailFragment.downloadViewFloat != null) {
            K1(movieDetailFragment, 0, 1, null);
        }
        return Unit.a;
    }

    private final void s1(boolean show) {
        String genre;
        Subject subject = this.mMovieDetailBean;
        if (subject == null || (genre = subject.getGenre()) == null) {
            return;
        }
        String lowerCase = genre.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        if (lowerCase == null || !StringsKt.c0(lowerCase, "game", false, 2, (Object) null)) {
            return;
        }
        if (show) {
            im.b T0 = T0();
            if (T0 != null) {
                T0.h();
                return;
            }
            return;
        }
        im.b T02 = T0();
        if (T02 != null) {
            T02.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(LongVodUiType uiType) {
        if (this.gameResView == null || uiType != LongVodUiType.MIDDLE) {
            return;
        }
        F1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(ln.a bean) {
        Navigator K = TheRouter.c("/profile/user_center_labels_feedback").K("feedback_from_page", "SUBJECT_PLAY").K("subject_id", this.mSubjectId);
        Subject subject = this.mMovieDetailBean;
        if (subject != null && subject.getType() == 3 && bean != null) {
            K.I("TV_DATA", new FbTvData(bean.o(), bean.l(), bean.e()));
        }
        Navigator.x(K, requireContext(), (mf.c) null, 2, (Object) null);
    }

    private final void v1(Trailer trailer) {
        Subject subject;
        String averageHueLight;
        String thumbnail;
        String url;
        Subject subject2 = this.mMovieDetailBean;
        if (subject2 == null || !subject2.isFamilyModeIntercept()) {
            G1();
            String str = this.mSubjectId;
            if (str == null || (subject = this.mMovieDetailBean) == null) {
                return;
            }
            PlayMimeType playMimeType = PlayMimeType.DEFAULT;
            long j = this.curAudioTrackPlayProgress;
            String title = subject.getTitle();
            String str2 = title == null ? BuildConfig.FLAVOR : title;
            String str3 = this.lastPageFrom;
            String str4 = str3 == null ? BuildConfig.FLAVOR : str3;
            List X0 = X0(trailer);
            Cover cover = trailer.getCover();
            String str5 = (cover == null || (url = cover.getUrl()) == null) ? BuildConfig.FLAVOR : url;
            Cover cover2 = trailer.getCover();
            String str6 = (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? BuildConfig.FLAVOR : thumbnail;
            Cover cover3 = subject.getCover();
            String str7 = (cover3 == null || (averageHueLight = cover3.getAverageHueLight()) == null) ? BuildConfig.FLAVOR : averageHueLight;
            Integer durationSeconds = subject.getDurationSeconds();
            int intValue = durationSeconds != null ? durationSeconds.intValue() : 0;
            Integer subjectType = subject.getSubjectType();
            ln.a aVar = new ln.a(str, playMimeType, j, 0, 0, str2, null, str4, "subjectdetail", X0, str5, str6, str7, intValue, Integer.valueOf(subjectType != null ? subjectType.intValue() : 1), false, subject.getTitle(), subject.getOps(), 32832, null);
            aVar.z(this.mMovieDetailBean);
            wf.a.a.c("movie_detail", "playTrailer  addDataSource:" + aVar + "  playerControl:" + this.playerControl, true);
            kn.a aVar2 = this.playerControl;
            if (aVar2 != null) {
                aVar2.setDataSource(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jo.a w1() {
        return (jo.a) TheRouter.d(jo.a.class, new Object[0]);
    }

    private final void y1() {
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView;
        final Subject subject = this.mMovieDetailBean;
        if (subject != null) {
            lm.h hVar = (lm.h) getMViewBinding();
            if (hVar != null && (appCompatImageView = hVar.k) != null) {
                appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MovieDetailFragment.z1(MovieDetailFragment.this, subject, view);
                    }
                });
            }
            lm.h hVar2 = (lm.h) getMViewBinding();
            if (hVar2 == null || (tnTextView = hVar2.r) == null) {
                return;
            }
            tnTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MovieDetailFragment.A1(MovieDetailFragment.this, subject, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(MovieDetailFragment movieDetailFragment, Subject subject, View view) {
        String str;
        jo.a V0 = movieDetailFragment.V0();
        if (V0 != null) {
            Context context = view.getContext();
            Intrinsics.g(context, "getContext(...)");
            String str2 = movieDetailFragment.mSubjectId;
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            Cover cover = subject.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            String title = subject.getTitle();
            if (title == null) {
                title = BuildConfig.FLAVOR;
            }
            String description = subject.getDescription();
            if (description == null) {
                description = BuildConfig.FLAVOR;
            }
            V0.e(context, str2, str, title, description, 3);
        }
        com.transsion.baselib.helper.a.a.h("subjectdetail", "post", (r16 & 4) != 0 ? BuildConfig.FLAVOR : null, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
    }

    @Override // en.a
    public void S(Function0 callback) {
        this.backPressedCallback = callback;
    }

    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public lm.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        lm.h c2 = lm.h.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public View getLoadingView() {
        View inflate = LayoutInflater.from(requireContext()).inflate(R$layout.default_movie_detail_skeleton_drawing_layout_2, (ViewGroup) getFlStateView(), false);
        inflate.findViewById(R$id.ivBack).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieDetailFragment.S0(MovieDetailFragment.this, view);
            }
        });
        return inflate;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
        lm.h hVar = (lm.h) getMViewBinding();
        if (hVar != null) {
            hVar.j.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MovieDetailFragment.e1(MovieDetailFragment.this, view);
                }
            });
        }
    }

    public void initViewData() {
        View view;
        lm.h hVar = (lm.h) getMViewBinding();
        if (hVar != null && (view = hVar.t) != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).height = com.blankj.utilcode.util.d.c();
            view.setLayoutParams(bVar);
        }
        requireActivity().getOnBackPressedDispatcher().i(this, new c());
        q1();
        Y0();
        i1();
    }

    public void initViewModel() {
        MovieDetailViewModel U0 = U0();
        U0.F().j(this, new d(new Function1() { // from class: com.transsion.moviedetail.fragment.b0
            public final Object invoke(Object obj) {
                Unit k1;
                k1 = MovieDetailFragment.k1(MovieDetailFragment.this, (Pair) obj);
                return k1;
            }
        }));
        U0.y().j(this, new d(new Function1() { // from class: com.transsion.moviedetail.fragment.j
            public final Object invoke(Object obj) {
                Unit l1;
                l1 = MovieDetailFragment.l1(MovieDetailFragment.this, (DownloadListBean) obj);
                return l1;
            }
        }));
        U0.K().j(this, new d(new Function1() { // from class: com.transsion.moviedetail.fragment.k
            public final Object invoke(Object obj) {
                Unit m1;
                m1 = MovieDetailFragment.m1(MovieDetailFragment.this, (Integer) obj);
                return m1;
            }
        }));
        U0.P().j(this, new d(new Function1() { // from class: com.transsion.moviedetail.fragment.l
            public final Object invoke(Object obj) {
                Unit n1;
                n1 = MovieDetailFragment.n1(MovieDetailFragment.this, (DubsInfo) obj);
                return n1;
            }
        }));
    }

    public boolean isRegisteDeviceKeyMonitor() {
        return true;
    }

    public void loadDefaultData() {
        HashMap g;
        MovieDetailActivity.INSTANCE.a("movie_detail start load data ....");
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g = logViewConfig.g()) != null) {
            String str = this.mSubjectId;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            g.put("subject_id", str);
        }
        Bundle arguments = getArguments();
        this.ops = arguments != null ? arguments.getString("ops") : null;
        if (yg.l.a.e()) {
            showLoadingView();
            String str2 = this.mSubjectId;
            if (str2 != null) {
                MovieDetailViewModel.E(U0(), str2, Integer.valueOf(this.curSeason), false, 4, null);
            }
        }
    }

    public qi.b newLogViewConfig() {
        return new qi.b("subjectdetail", false, 2, null);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieDetailActivity.INSTANCE.a("movie_detail------- onCreate ------");
    }

    public void onDestroy() {
        super.onDestroy();
        kn.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.onPageDestroy();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onHomeClick() {
        super.onHomeClick();
        a.a.f(wf.a.a, "VideoFloat", "MovieDetailFragment onHomeClick", false, 4, (Object) null);
        C1(FloatActionType.HOME);
    }

    public void onPause() {
        super.onPause();
        cw.c cVar = cw.c.a;
        kn.a aVar = this.playerControl;
        cVar.c(aVar != null ? aVar.getPlayer() : null);
        s1(false);
    }

    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super/*androidx.fragment.app.Fragment*/.onPictureInPictureModeChanged(isInPictureInPictureMode);
        if (isInPictureInPictureMode) {
            FragmentActivity activity = getActivity();
            if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            dw.a R0 = R0();
            if (R0 != null && Build.VERSION.SDK_INT >= 31) {
                cw.e.a.b().h(activity, R0);
            }
        }
        cw.e.a.b().onPipModeChanged(isInPictureInPictureMode);
    }

    public void onRecentClick() {
        super.onRecentClick();
        a.a.f(wf.a.a, "VideoFloat", "MovieDetailFragment onRecentClick", false, 4, (Object) null);
        C1(FloatActionType.HOME);
    }

    public void onResume() {
        super.onResume();
        kn.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.onViewResume();
        }
        s1(true);
    }

    public void onStop() {
        kn.a aVar;
        super/*androidx.fragment.app.Fragment*/.onStop();
        cw.c cVar = cw.c.a;
        kn.a aVar2 = this.playerControl;
        if (cVar.c(aVar2 != null ? aVar2.getPlayer() : null) || (aVar = this.playerControl) == null) {
            return;
        }
        aVar.onViewPause();
    }

    public void receiveArguments() {
        this.lastPageFrom = qi.h.a.h();
        Bundle arguments = getArguments();
        this.ops = arguments != null ? arguments.getString("ops") : null;
        Bundle arguments2 = getArguments();
        this.mSubjectId = arguments2 != null ? arguments2.getString("id") : null;
        Bundle arguments3 = getArguments();
        this.mSubjectType = arguments3 != null ? arguments3.getInt("subject_type", this.mSubjectType) : this.mSubjectType;
        Bundle arguments4 = getArguments();
        this.autoDownload = arguments4 != null ? arguments4.getBoolean("auto_download") : false;
        Bundle arguments5 = getArguments();
        this.autoPlay = arguments5 != null ? arguments5.getBoolean("auto_play") : false;
        Bundle arguments6 = getArguments();
        this.autoPlayResourceId = arguments6 != null ? arguments6.getString("auto_play_resource_id") : null;
        Bundle arguments7 = getArguments();
        this.preloadId = arguments7 != null ? arguments7.getInt("yy_preload_id") : 0;
        Bundle arguments8 = getArguments();
        this.moduleName = arguments8 != null ? arguments8.getString("module_name") : null;
        Bundle arguments9 = getArguments();
        this.curSeason = arguments9 != null ? arguments9.getInt("season") : 1;
        MovieDetailViewModel U0 = U0();
        int i = this.preloadId;
        String str = this.mSubjectId;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        U0.S(i, str, Integer.valueOf(this.curSeason));
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(this.lastPageFrom);
        }
    }

    public void retryLoadData() {
        if (this.mMovieDetailBean == null) {
            loadDefaultData();
        }
    }

    public final void x1() {
        kn.a aVar;
        cw.c cVar = cw.c.a;
        kn.a aVar2 = this.playerControl;
        if (!cVar.c(aVar2 != null ? aVar2.getPlayer() : null) && (aVar = this.playerControl) != null) {
            aVar.release();
        }
        kn.a aVar3 = this.playerControl;
        if (aVar3 != null) {
            aVar3.onPageDestroy();
        }
    }
}
