package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v0;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.therouter.TheRouter;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baseui.widget.f;
import com.transsion.flow.bean.CommentBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.helper.ShortTvImmVideoHelper;
import com.transsion.postdetail.shorttv.ShortTvPlayListViewModel;
import com.transsion.push.PushConstants;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.shorttv.base.pager.PagerLayoutManager;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import ni.f;
import wf.a;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0007*\u0002Ä\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B!\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0011JE\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010#\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J)\u0010.\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\t¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u001b2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u001f\u00107\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u0006\u00101\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u000fH\u0016¢\u0006\u0004\b9\u0010\u0011J\u0019\u0010<\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\u000f¢\u0006\u0004\b>\u0010\u0011J\u0015\u0010@\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u0018¢\u0006\u0004\b@\u0010AJ\u0015\u0010C\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u0018¢\u0006\u0004\bC\u0010AJ\u000f\u0010D\u001a\u00020\u000fH\u0016¢\u0006\u0004\bD\u0010\u0011J\u001f\u0010G\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u000fH\u0016¢\u0006\u0004\bI\u0010\u0011J\u0019\u0010J\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bJ\u0010=J\u0019\u0010K\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bK\u0010=J\u0019\u0010L\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bL\u0010=J!\u0010O\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020M2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bO\u0010PJ\u0019\u0010Q\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bQ\u0010=J\u0019\u0010R\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bR\u0010=J!\u0010U\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020S2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u000fH\u0016¢\u0006\u0004\bW\u0010\u0011J\u0019\u0010X\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bX\u0010=J\u0019\u0010Z\u001a\u00020\u000f2\b\u0010Y\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\bZ\u0010AJ\u000f\u0010[\u001a\u00020\u000fH\u0016¢\u0006\u0004\b[\u0010\u0011J\u0019\u0010]\u001a\u00020\u000f2\b\u0010\\\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b]\u0010^J\u0019\u0010`\u001a\u00020\u000f2\b\u0010_\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b`\u0010AJ\u0017\u0010a\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\ba\u0010\rJ\u0017\u0010b\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\u000fH\u0002¢\u0006\u0004\bd\u0010\u0011J\u000f\u0010e\u001a\u00020\u000fH\u0002¢\u0006\u0004\be\u0010\u0011J/\u0010h\u001a\u00020\u000f2\b\u0010e\u001a\u0004\u0018\u00010\t2\b\u0010f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bh\u0010iJ\u0017\u0010k\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u001bH\u0002¢\u0006\u0004\bk\u0010lJ\u0017\u0010m\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\bm\u0010nJ\u0017\u0010\\\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b\\\u0010^J\u0019\u0010p\u001a\u00020\u000f2\b\u0010o\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\bp\u0010AJ\u000f\u0010q\u001a\u00020\u000fH\u0002¢\u0006\u0004\bq\u0010\u0011J\u0017\u0010s\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020\u001bH\u0002¢\u0006\u0004\bs\u0010lR\u0014\u0010v\u001a\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010z\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010~\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bf\u0010\u008c\u0001R*\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010uR\u001a\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001b\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b`\u0010\u009c\u0001R\u001b\u0010 \u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bp\u0010\u009f\u0001R\"\u0010¥\u0001\u001a\u0005\u0018\u00010¡\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\ba\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001R\u001b\u0010¨\u0001\u001a\u0005\u0018\u00010¦\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bq\u0010§\u0001R\u0019\u0010«\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u0019\u0010\u00ad\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010ª\u0001R\u0018\u0010®\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bm\u0010ª\u0001R\u0019\u0010±\u0001\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u0016\u0010³\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\\\u0010²\u0001R\u0016\u0010´\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\be\u0010²\u0001R\u0017\u0010¶\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010²\u0001R\u0017\u0010¸\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010²\u0001R\u0017\u0010º\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010²\u0001R\u0016\u0010»\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bd\u0010²\u0001R\u0017\u0010?\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¼\u0001\u0010uR\u0018\u0010À\u0001\u001a\u00030½\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0018\u0010Á\u0001\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bh\u0010°\u0001R\u0018\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010ª\u0001R\u0018\u0010Ã\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bb\u0010ª\u0001R\u0018\u0010Ç\u0001\u001a\u00030Ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u0019\u0010É\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010ª\u0001¨\u0006Ê\u0001²\u0006\f\u0010~\u001a\u00020{8\nX\u008a\u0084\u0002²\u0006\r\u0010\u0082\u0001\u001a\u00020\u007f8\nX\u008a\u0084\u0002"}, d2 = {"Lcom/transsion/postdetail/ui/view/ShortTvImmVideoItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/transsion/player/orplayer/e;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/r;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "onAttachedToWindow", "()V", "onDetachedFromWindow", "Lcom/transsion/moviedetailapi/bean/Subject;", "item", "Landroidx/fragment/app/Fragment;", "fragment", "position", BuildConfig.FLAVOR, "basePostId", "baseItemType", BuildConfig.FLAVOR, "attachToMain", "setData", "(Lcom/transsion/moviedetailapi/bean/Subject;Landroidx/fragment/app/Fragment;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Z)V", "Lcom/transsion/player/orplayer/f;", "orPlayer", "Lcom/transsion/player/ui/ORPlayerView;", "orPlayerView", "setPlayer", "(Lcom/transsion/player/orplayer/f;Lcom/transsion/player/ui/ORPlayerView;)V", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "pagerLayoutManager", "setPagerLayoutManager", "(Lcom/transsion/shorttv/base/pager/PagerLayoutManager;)V", "Landroid/view/View;", "view", "Lcom/transsion/moviedetailapi/bean/Video;", "video", "maxHeight", "addVideoView", "(Landroid/view/View;Lcom/transsion/moviedetailapi/bean/Video;I)V", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroidx/lifecycle/u;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged", "(Landroidx/lifecycle/u;Landroidx/lifecycle/Lifecycle$Event;)V", "onPlayerReset", "Lgn/e;", "mediaSource", "onPlayerRelease", "(Lgn/e;)V", "app2Background", "pageFrom", "videoStartPrepare", "(Ljava/lang/String;)V", "url", "setVideoUrl", "onSetDataSource", "width", "height", "onVideoSizeChanged", "(II)V", "onRenderFirstFrame", "onVideoStart", "onPrepare", "onVideoPause", BuildConfig.FLAVOR, "progress", "onProgress", "(JLgn/e;)V", "onLoadingBegin", "onLoadingEnd", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lgn/e;)V", "onLoopingStart", "onCompletion", "uuid", "onMediaItemTransition", "setOnSeekCompleteListener", "v", "onClick", "(Landroid/view/View;)V", "type", "n", "p", "F", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "A", "w", "h", "rootHeight", "D", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", PushConstants.PUSH_SERVICE_TYPE_SHOW, "setLoading", "(Z)V", "t", "(J)V", "id", "o", "q", "visible", "setContentVisibility", "a", "Ljava/lang/String;", "TAG", "Lwn/g0;", "b", "Lwn/g0;", "viewBinding", "Lcom/transsion/postdetail/viewmodel/w;", "c", "Lcom/transsion/postdetail/viewmodel/w;", "videoDetailModel", "Lcom/transsion/postdetail/shorttv/ShortTvPlayListViewModel;", "d", "Lcom/transsion/postdetail/shorttv/ShortTvPlayListViewModel;", "shortTvPlayListViewModel", "Lcom/transsion/share/share/ShareDialogFragment;", "e", "Lcom/transsion/share/share/ShareDialogFragment;", "mShareDialog", "f", "Lcom/transsion/moviedetailapi/bean/Subject;", "data", "g", "Landroidx/fragment/app/Fragment;", "Ljava/lang/Boolean;", "videoLoadMore", "i", "Ljava/lang/Integer;", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", "j", "k", "Lcom/transsion/player/orplayer/f;", "l", "Lcom/transsion/player/ui/ORPlayerView;", "m", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "Lcom/transsion/postdetail/ui/view/ImmVideoGuideView;", "Lcom/transsion/postdetail/ui/view/ImmVideoGuideView;", "guideView", "Landroid/view/GestureDetector;", "Landroid/view/GestureDetector;", "gestureDetector", "Lqx/a;", "Lkotlin/Lazy;", "getLoginApi", "()Lqx/a;", "loginApi", "Lcom/transsion/postdetail/layer/b;", "Lcom/transsion/postdetail/layer/b;", "dotLayer", "r", "Z", "isClickPause", "s", "isHorizontalDragging", "isPageHide", "u", "J", "currentSaveProgress", "I", "resImgLargeWidth", "resImgLargeHeight", "x", "resImgSmallWidth", "y", "resImgSmallHeight", "z", "screenHeight", "dp170", "B", "Ljava/util/concurrent/atomic/AtomicBoolean;", "C", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isSeekToFinish", "nextSeekTo", "E", "isPageRelease", "com/transsion/postdetail/ui/view/ShortTvImmVideoItemView$b", "G", "Lcom/transsion/postdetail/ui/view/ShortTvImmVideoItemView$b;", "favoriteResultObserver", "H", "isPrepare", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvImmVideoItemView extends ConstraintLayout implements com.transsion.player.orplayer.e, View.OnClickListener, androidx.lifecycle.r {

    /* renamed from: A, reason: from kotlin metadata */
    private final int dp170;

    /* renamed from: B, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: C, reason: from kotlin metadata */
    private final AtomicBoolean isSeekToFinish;

    /* renamed from: D, reason: from kotlin metadata */
    private long nextSeekTo;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean attachToMain;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isPageRelease;

    /* renamed from: G, reason: from kotlin metadata */
    private final b favoriteResultObserver;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isPrepare;

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: from kotlin metadata */
    private final wn.g0 viewBinding;

    /* renamed from: c, reason: from kotlin metadata */
    private com.transsion.postdetail.viewmodel.w videoDetailModel;

    /* renamed from: d, reason: from kotlin metadata */
    private ShortTvPlayListViewModel shortTvPlayListViewModel;

    /* renamed from: e, reason: from kotlin metadata */
    private ShareDialogFragment mShareDialog;

    /* renamed from: f, reason: from kotlin metadata */
    private Subject data;

    /* renamed from: g, reason: from kotlin metadata */
    private Fragment fragment;

    /* renamed from: h, reason: from kotlin metadata */
    private Boolean videoLoadMore;

    /* renamed from: i, reason: from kotlin metadata */
    private Integer position;

    /* renamed from: j, reason: from kotlin metadata */
    private String basePostId;

    /* renamed from: k, reason: from kotlin metadata */
    private com.transsion.player.orplayer.f orPlayer;

    /* renamed from: l, reason: from kotlin metadata */
    private ORPlayerView orPlayerView;

    /* renamed from: m, reason: from kotlin metadata */
    private PagerLayoutManager pagerLayoutManager;

    /* renamed from: n, reason: from kotlin metadata */
    private ImmVideoGuideView guideView;

    /* renamed from: o, reason: from kotlin metadata */
    private GestureDetector gestureDetector;

    /* renamed from: p, reason: from kotlin metadata */
    private final Lazy loginApi;

    /* renamed from: q, reason: from kotlin metadata */
    private com.transsion.postdetail.layer.b dotLayer;

    /* renamed from: r, reason: from kotlin metadata */
    private boolean isClickPause;

    /* renamed from: s, reason: from kotlin metadata */
    private boolean isHorizontalDragging;

    /* renamed from: t, reason: from kotlin metadata */
    private boolean isPageHide;

    /* renamed from: u, reason: from kotlin metadata */
    private long currentSaveProgress;

    /* renamed from: v, reason: from kotlin metadata */
    private final int resImgLargeWidth;

    /* renamed from: w, reason: from kotlin metadata */
    private final int resImgLargeHeight;

    /* renamed from: x, reason: from kotlin metadata */
    private final int resImgSmallWidth;

    /* renamed from: y, reason: from kotlin metadata */
    private final int resImgSmallHeight;

    /* renamed from: z, reason: from kotlin metadata */
    private final int screenHeight;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    public static final class b implements androidx.lifecycle.c0 {
        private String a;

        b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            if (Intrinsics.c(this.a, str)) {
                return;
            }
            ShortTvImmVideoItemView.this.n(str);
        }

        public final void b(String str) {
            this.a = str;
        }
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
            ShortTvImmVideoItemView.this.w();
            return super.onSingleTapUp(motionEvent);
        }
    }

    public static final class d implements f.a {
        private int a;
        private int b;
        private int c;
        private String d = BuildConfig.FLAVOR;
        private int e = com.blankj.utilcode.util.a0.a(1.5f);

        d() {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void a() {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void b(float f, float f2) {
            if (!ShortTvImmVideoItemView.this.isHorizontalDragging) {
                PagerLayoutManager pagerLayoutManager = ShortTvImmVideoItemView.this.pagerLayoutManager;
                if (pagerLayoutManager != null) {
                    pagerLayoutManager.W(false);
                }
                this.a = ShortTvImmVideoItemView.this.viewBinding.m.getProgress();
                ShortTvImmVideoItemView.this.setContentVisibility(false);
                AppCompatTextView appCompatTextView = ShortTvImmVideoItemView.this.viewBinding.t;
                Intrinsics.g(appCompatTextView, "tvProgressDes");
                uf.c.k(appCompatTextView);
                AppCompatSeekBar appCompatSeekBar = ShortTvImmVideoItemView.this.viewBinding.o;
                Intrinsics.g(appCompatSeekBar, "seekBar");
                uf.c.k(appCompatSeekBar);
                ProgressBar progressBar = ShortTvImmVideoItemView.this.viewBinding.m;
                Intrinsics.g(progressBar, "progressBar");
                uf.c.g(progressBar);
                this.c = ShortTvImmVideoItemView.this.viewBinding.m.getWidth();
                int max = ShortTvImmVideoItemView.this.viewBinding.m.getMax();
                this.b = max;
                this.d = com.transsion.postdetail.util.m.c(max);
            }
            ShortTvImmVideoItemView.this.isHorizontalDragging = true;
            float f3 = f2 - f;
            int i = this.b;
            int i2 = (int) (this.a + ((f3 * i) / this.c));
            int i3 = i2 >= 0 ? i2 > i ? i : i2 : 0;
            ShortTvImmVideoItemView.this.viewBinding.t.setText(com.transsion.postdetail.util.m.c(i3) + " / " + this.d);
            ShortTvImmVideoItemView.this.viewBinding.m.setProgress(i3);
            ShortTvImmVideoItemView.this.viewBinding.o.setProgress(i3);
        }

        @Override // com.transsion.baseui.widget.f.a
        public void c(float f, float f2) {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void d(float f, float f2) {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void e() {
            com.transsion.player.orplayer.f fVar;
            PagerLayoutManager pagerLayoutManager = ShortTvImmVideoItemView.this.pagerLayoutManager;
            if (pagerLayoutManager != null) {
                pagerLayoutManager.W(true);
            }
            if (ShortTvImmVideoItemView.this.isHorizontalDragging) {
                ShortTvImmVideoItemView.this.isHorizontalDragging = false;
                ShortTvImmVideoItemView.this.setContentVisibility(true);
                AppCompatTextView appCompatTextView = ShortTvImmVideoItemView.this.viewBinding.t;
                Intrinsics.g(appCompatTextView, "tvProgressDes");
                uf.c.g(appCompatTextView);
                AppCompatSeekBar appCompatSeekBar = ShortTvImmVideoItemView.this.viewBinding.o;
                Intrinsics.g(appCompatSeekBar, "seekBar");
                uf.c.g(appCompatSeekBar);
                ProgressBar progressBar = ShortTvImmVideoItemView.this.viewBinding.m;
                Intrinsics.g(progressBar, "progressBar");
                uf.c.k(progressBar);
                long progress = ShortTvImmVideoItemView.this.viewBinding.m.getProgress();
                ShortTvImmVideoItemView shortTvImmVideoItemView = ShortTvImmVideoItemView.this;
                if (shortTvImmVideoItemView.isSeekToFinish.compareAndSet(true, false)) {
                    com.transsion.player.orplayer.f fVar2 = ShortTvImmVideoItemView.this.orPlayer;
                    if (fVar2 != null) {
                        fVar2.seekTo(progress);
                    }
                    progress = 0;
                }
                shortTvImmVideoItemView.nextSeekTo = progress;
                com.transsion.player.orplayer.f fVar3 = ShortTvImmVideoItemView.this.orPlayer;
                if (fVar3 == null || fVar3.isPlaying() || (fVar = ShortTvImmVideoItemView.this.orPlayer) == null) {
                    return;
                }
                fVar.play();
            }
        }

        @Override // com.transsion.baseui.widget.f.a
        public void onDoubleTap(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
        }

        @Override // com.transsion.baseui.widget.f.a
        public void onLongPress(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
        }
    }

    public static final class e implements com.transsion.share.share.a {
        e() {
        }

        @Override // com.transsion.share.share.a
        public void a(String str, PostType postType) {
            Intrinsics.h(str, "id");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            ShortTvImmVideoItemView.this.o(str);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvImmVideoItemView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvImmVideoItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShortTvImmVideoItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.TAG = "ImmVideoPlayer";
        this.loginApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.view.y1
            public final Object invoke() {
                qx.a s;
                s = ShortTvImmVideoItemView.s();
                return s;
            }
        });
        this.screenHeight = com.blankj.utilcode.util.y.c();
        this.dp170 = com.blankj.utilcode.util.a0.a(170.0f);
        this.pageFrom = BuildConfig.FLAVOR;
        this.isSeekToFinish = new AtomicBoolean(true);
        this.attachToMain = true;
        this.favoriteResultObserver = new b();
        View.inflate(getContext(), R$layout.layout_short_tv_immersion_video_item_view, this);
        wn.g0 a2 = wn.g0.a(this);
        Intrinsics.g(a2, "bind(...)");
        this.viewBinding = a2;
        a2.s.setOnClickListener(this);
        a2.i.setOnClickListener(this);
        a2.k.setOnClickListener(this);
        a2.u.setOnClickListener(this);
        a2.g.setOnClickListener(this);
        a2.j.setOnClickListener(this);
        a2.v.setOnClickListener(this);
        a2.q.setOnClickListener(this);
        this.resImgLargeWidth = com.blankj.utilcode.util.a0.a(48.0f);
        this.resImgLargeHeight = com.blankj.utilcode.util.a0.a(64.0f);
        this.resImgSmallWidth = com.blankj.utilcode.util.a0.a(24.0f);
        this.resImgSmallHeight = com.blankj.utilcode.util.a0.a(32.0f);
        p(context);
        if (ShortTvImmVideoHelper.k.a().m() > 0) {
            ConstraintLayout.b layoutParams = a2.n.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = layoutParams;
            if (((ViewGroup.MarginLayoutParams) bVar).bottomMargin < com.blankj.utilcode.util.a0.a(35.0f)) {
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin += com.blankj.utilcode.util.a0.a(10.0f);
                a2.n.setLayoutParams(bVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A() {
        Cover cover;
        String url;
        Fragment fragment;
        FragmentActivity activity;
        String str;
        Cover cover2;
        ShortTVItem shortTVFirstEp;
        Media video;
        Video videoAddress;
        ShapeableImageView shapeableImageView = this.viewBinding.k;
        Intrinsics.g(shapeableImageView, "ivVideoAvatar");
        uf.c.g(shapeableImageView);
        AppCompatImageView appCompatImageView = this.viewBinding.g;
        Intrinsics.g(appCompatImageView, "ivDownload");
        uf.c.k(appCompatImageView);
        AppCompatTextView appCompatTextView = this.viewBinding.v;
        Intrinsics.g(appCompatTextView, "tvTitle");
        uf.c.k(appCompatTextView);
        BLTextView bLTextView = this.viewBinding.u;
        Intrinsics.g(bLTextView, "tvShortTvEp");
        uf.c.k(bLTextView);
        ShapeableImageView shapeableImageView2 = this.viewBinding.j;
        Intrinsics.g(shapeableImageView2, "ivShortCover");
        uf.c.k(shapeableImageView2);
        AppCompatTextView appCompatTextView2 = this.viewBinding.v;
        Subject subject = this.data;
        appCompatTextView2.setText(subject != null ? subject.getTitle() : null);
        com.transsion.postdetail.util.s sVar = com.transsion.postdetail.util.s.a;
        Subject subject2 = this.data;
        String a2 = sVar.a(Integer.valueOf(subject2 != null ? subject2.getTotalEpisode() : 0));
        AppCompatTextView appCompatTextView3 = this.viewBinding.q;
        Subject subject3 = this.data;
        appCompatTextView3.setText(subject3 != null ? subject3.getDescription() : null);
        this.viewBinding.u.setText(getContext().getString(R.string.short_tv_play_all, a2));
        com.transsion.baseui.widget.jumpingbeans.a.a(this.viewBinding.u).e(0, this.viewBinding.u.getText().toString().length()).g(true).i(100).f(0.05f).h(10000).a();
        ShapeableImageView shapeableImageView3 = this.viewBinding.j;
        Subject subject4 = this.data;
        if (subject4 == null || !subject4.getBuiltIn()) {
            Subject subject5 = this.data;
            if (subject5 != null && (cover = subject5.getCover()) != null && (url = cover.getUrl()) != null && (fragment = this.fragment) != null && (activity = fragment.getActivity()) != null && !activity.isFinishing()) {
                f.b c2 = ni.f.a.m(activity).g(url).m(com.blankj.utilcode.util.i.e(21.0f)).c(com.blankj.utilcode.util.i.e(30.0f));
                Subject subject6 = this.data;
                if (subject6 == null || (cover2 = subject6.getCover()) == null || (str = cover2.getThumbnail()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b h = c2.l(str).h(true);
                ShapeableImageView shapeableImageView4 = this.viewBinding.j;
                Intrinsics.g(shapeableImageView4, "ivShortCover");
                h.d(shapeableImageView4);
            }
        } else {
            kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), (CoroutineContext) null, (CoroutineStart) null, new ShortTvImmVideoItemView$updateShortTVInfo$1(this, null), 3, (Object) null);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Subject subject7 = this.data;
        ShortTVFavInfo shortTVFavInfo = subject7 != null ? subject7.getShortTVFavInfo() : null;
        objectRef.element = shortTVFavInfo;
        if (shortTVFavInfo == null) {
            ShortTVFavInfo shortTVFavInfo2 = new ShortTVFavInfo((String) null, false, (String) null, 7, (DefaultConstructorMarker) null);
            shortTVFavInfo2.setFavoriteNum("0");
            objectRef.element = shortTVFavInfo2;
            Subject subject8 = this.data;
            if (subject8 != null) {
                subject8.setShortTVFavInfo(shortTVFavInfo2);
            }
        }
        AppCompatTextView appCompatTextView4 = this.viewBinding.r;
        Intrinsics.g(appCompatTextView4, "tvFavorite");
        uf.c.k(appCompatTextView4);
        this.viewBinding.r.setSelected(((ShortTVFavInfo) objectRef.element).getHasFavorite());
        AppCompatTextView appCompatTextView5 = this.viewBinding.r;
        String favoriteNum = ((ShortTVFavInfo) objectRef.element).getFavoriteNum();
        appCompatTextView5.setText(com.transsion.baseui.util.j.a(Long.parseLong(favoriteNum != null ? favoriteNum : "0")));
        this.viewBinding.r.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvImmVideoItemView.B(ShortTvImmVideoItemView.this, objectRef, view);
            }
        });
        AppCompatActivity context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.view.w1
            public final Object invoke(Object obj) {
                Unit C;
                C = ShortTvImmVideoItemView.C(ShortTvImmVideoItemView.this, (hx.c) obj);
                return C;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = hx.c.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(context, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
        Subject subject9 = this.data;
        if (subject9 == null || (shortTVFirstEp = subject9.getShortTVFirstEp()) == null || (video = shortTVFirstEp.getVideo()) == null || (videoAddress = video.getVideoAddress()) == null) {
            return;
        }
        E(this, videoAddress.getWidth(), videoAddress.getHeight(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ShortTvImmVideoItemView shortTvImmVideoItemView, Ref.ObjectRef objectRef, View view) {
        ShortTvPlayListViewModel shortTvPlayListViewModel;
        com.transsion.postdetail.shorttv.k kVar = com.transsion.postdetail.shorttv.k.a;
        Subject subject = shortTvImmVideoItemView.data;
        String subjectId = subject != null ? subject.getSubjectId() : null;
        Subject subject2 = shortTvImmVideoItemView.data;
        com.transsion.postdetail.shorttv.k.d(kVar, subjectId, subject2 != null ? subject2.getOps() : null, BuildConfig.FLAVOR, ((ShortTVFavInfo) objectRef.element).getHasFavorite(), "shorttv_detail_video", null, 32, null);
        Subject subject3 = shortTvImmVideoItemView.data;
        if (subject3 == null || (shortTvPlayListViewModel = shortTvImmVideoItemView.shortTvPlayListViewModel) == null) {
            return;
        }
        shortTvPlayListViewModel.d(subject3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(ShortTvImmVideoItemView shortTvImmVideoItemView, hx.c cVar) {
        String c2;
        Subject subject;
        String str;
        ShortTVFavInfo shortTVFavInfo;
        ShortTVFavInfo shortTVFavInfo2;
        Intrinsics.h(cVar, "value");
        try {
            c2 = cVar.c();
            subject = shortTvImmVideoItemView.data;
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        if (!Intrinsics.c(c2, subject != null ? subject.getSubjectId() : null)) {
            return Unit.a;
        }
        Subject subject2 = shortTvImmVideoItemView.data;
        if (subject2 != null && (shortTVFavInfo2 = subject2.getShortTVFavInfo()) != null) {
            shortTVFavInfo2.update(cVar);
        }
        AppCompatTextView appCompatTextView = shortTvImmVideoItemView.viewBinding.r;
        Subject subject3 = shortTvImmVideoItemView.data;
        if (subject3 == null || (shortTVFavInfo = subject3.getShortTVFavInfo()) == null || (str = shortTVFavInfo.getFavoriteNum()) == null) {
            str = "0";
        }
        appCompatTextView.setText(com.transsion.baseui.util.j.a(Long.parseLong(str)));
        shortTvImmVideoItemView.viewBinding.r.setSelected(cVar.a());
        return Unit.a;
    }

    private final void D(Integer w, Integer h, Integer rootHeight) {
        int e2;
        if (w == null || rootHeight == null || h == null || w.intValue() == 0) {
            return;
        }
        FrameLayout frameLayout = this.viewBinding.d;
        Intrinsics.g(frameLayout, "flContainer");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        int intValue = (h.intValue() * com.blankj.utilcode.util.y.e()) / w.intValue();
        if (RangesKt.s(1, intValue).o(rootHeight.intValue())) {
            e2 = (rootHeight.intValue() * w.intValue()) / h.intValue();
            intValue = rootHeight.intValue();
        } else {
            e2 = com.blankj.utilcode.util.y.e();
        }
        if (e2 != ((ViewGroup.MarginLayoutParams) bVar).width || intValue != ((ViewGroup.MarginLayoutParams) bVar).height) {
            ((ViewGroup.MarginLayoutParams) bVar).width = e2;
            ((ViewGroup.MarginLayoutParams) bVar).height = intValue;
        }
        frameLayout.setLayoutParams(bVar);
    }

    static /* synthetic */ void E(ShortTvImmVideoItemView shortTvImmVideoItemView, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 4) != 0) {
            ViewGroup viewGroup = (ViewGroup) shortTvImmVideoItemView.viewBinding.getRoot().getParent();
            num3 = viewGroup != null ? Integer.valueOf(viewGroup.getHeight()) : null;
        }
        shortTvImmVideoItemView.D(num, num2, num3);
    }

    private final void F(Subject item) {
        Media video;
        Cover cover;
        String url;
        Fragment fragment;
        FragmentActivity activity;
        Media video2;
        Cover cover2;
        if (!item.getBuiltIn()) {
            ShortTVItem shortTVFirstEp = item.getShortTVFirstEp();
            if (shortTVFirstEp == null || (video = shortTVFirstEp.getVideo()) == null || (cover = video.getCover()) == null || (url = cover.getUrl()) == null || (fragment = this.fragment) == null || (activity = fragment.getActivity()) == null || activity.isFinishing()) {
                return;
            }
            Glide.with(activity).load(f.a.e(ni.f.a, url, sm.b.e.a(), false, false, 12, null)).into(this.viewBinding.f);
            return;
        }
        String str = null;
        kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), (CoroutineContext) null, (CoroutineStart) null, new ShortTvImmVideoItemView$updateVideoInfo$1(item, this, null), 3, (Object) null);
        a.a aVar = wf.a.a;
        String str2 = this.TAG;
        ShortTVItem shortTVFirstEp2 = item.getShortTVFirstEp();
        if (shortTVFirstEp2 != null && (video2 = shortTVFirstEp2.getVideo()) != null && (cover2 = video2.getCover()) != null) {
            str = cover2.getUrl();
        }
        a.a.f(aVar, str2, "set info - cover = " + str, false, 4, (Object) null);
    }

    private final qx.a getLoginApi() {
        return (qx.a) this.loginApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(String type) {
        Integer num;
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != -1550083459) {
                if (hashCode != -877500447) {
                    if (hashCode == 525878142 && type.equals("favorite_add")) {
                        num = Integer.valueOf(com.transsnet.downloader.R.string.short_tv_favorite_toast);
                    }
                } else if (type.equals("favorite_fail")) {
                    num = Integer.valueOf(com.tn.lib.widget.R.string.failed_toast);
                }
            } else if (type.equals("favorite_cancel")) {
                num = Integer.valueOf(com.transsnet.downloader.R.string.short_tv_favorite_remove_toast);
            }
            if (num == null) {
                fh.b.a.d(num.intValue());
                return;
            }
            return;
        }
        num = null;
        if (num == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String id) {
        androidx.lifecycle.b0 o;
        a.a.r(wf.a.a, this.TAG, new String[]{"finishAfterReport, position = " + this.position}, false, 4, (Object) null);
        com.transsion.postdetail.viewmodel.w wVar = this.videoDetailModel;
        if (wVar == null || (o = wVar.o()) == null) {
            return;
        }
        o.q(this.position);
    }

    private final void p(Context context) {
        this.gestureDetector = new GestureDetector(context, new c());
        q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        new com.transsion.baseui.widget.f(getContext(), this.viewBinding.x).s(new d());
        this.viewBinding.o.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.postdetail.ui.view.a2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean r;
                r = ShortTvImmVideoItemView.r(view, motionEvent);
                return r;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a s() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setContentVisibility(boolean visible) {
        Group group = this.viewBinding.e;
        Intrinsics.g(group, "groupContent");
        group.setVisibility(visible ? 0 : 8);
    }

    public static /* synthetic */ void setData$default(ShortTvImmVideoItemView shortTvImmVideoItemView, Subject subject, Fragment fragment, Integer num, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            z = false;
        }
        shortTvImmVideoItemView.setData(subject, fragment, num, str, str2, z);
    }

    private final void setLoading(boolean show) {
        a.a.l(wf.a.a, "yy", "setLoading:" + show + "  " + this, false, 4, (Object) null);
        if (show) {
            AppCompatImageView appCompatImageView = this.viewBinding.c;
            Intrinsics.g(appCompatImageView, "clLoading");
            uf.c.k(appCompatImageView);
            ProgressBar progressBar = this.viewBinding.m;
            Intrinsics.g(progressBar, "progressBar");
            uf.c.g(progressBar);
            this.viewBinding.c.start();
            return;
        }
        ProgressBar progressBar2 = this.viewBinding.m;
        Intrinsics.g(progressBar2, "progressBar");
        uf.c.k(progressBar2);
        AppCompatImageView appCompatImageView2 = this.viewBinding.c;
        Intrinsics.g(appCompatImageView2, "clLoading");
        uf.c.g(appCompatImageView2);
        this.viewBinding.c.stop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t(long progress) {
        if (Intrinsics.c(this.videoLoadMore, Boolean.TRUE)) {
            ShortTvImmVideoHelper.a aVar = ShortTvImmVideoHelper.k;
            if (!aVar.a().s() || progress < 1000) {
                return;
            }
            aVar.a().A();
            ImmVideoGuideView a2 = ImmVideoGuideView.INSTANCE.a(this);
            a2.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.view.z1
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTvImmVideoItemView.u(ShortTvImmVideoItemView.this);
                }
            }, 5000L);
            this.guideView = a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ShortTvImmVideoItemView shortTvImmVideoItemView) {
        ImmVideoGuideView immVideoGuideView = shortTvImmVideoItemView.guideView;
        if (immVideoGuideView != null) {
            immVideoGuideView.removeGuide();
        }
    }

    private final void v(View view) {
        Fragment fragment;
        FragmentManager childFragmentManager;
        ShareDialogFragment shareDialogFragment;
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        if (this.mShareDialog == null) {
            qx.a loginApi = getLoginApi();
            if (loginApi != null) {
                loginApi.i();
            }
            ShareDialogFragment.Companion companion = ShareDialogFragment.INSTANCE;
            PostType postType = PostType.SHORT_TV_TYPE;
            Subject subject = this.data;
            String subjectId = subject != null ? subject.getSubjectId() : null;
            String value = ReportType.SUBJECT.getValue();
            Subject subject2 = this.data;
            String title = subject2 != null ? subject2.getTitle() : null;
            Subject subject3 = this.data;
            ShareDialogFragment a2 = companion.a(postType, subjectId, BuildConfig.FLAVOR, value, title, BuildConfig.FLAVOR, false, false, false, "postdetail", subject3 != null ? subject3.getOps() : null, view.getContext().getString(R.string.save_video));
            this.mShareDialog = a2;
            if (a2 != null) {
                a2.G0(new e());
            }
        }
        try {
            Fragment fragment2 = this.fragment;
            if (fragment2 == null || !fragment2.isAdded() || (fragment = this.fragment) == null || (childFragmentManager = fragment.getChildFragmentManager()) == null) {
                return;
            }
            childFragmentManager.g0();
            ShareDialogFragment shareDialogFragment2 = this.mShareDialog;
            if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.k0("share") == null && (shareDialogFragment = this.mShareDialog) != null) {
                shareDialogFragment.show(childFragmentManager, "share");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        AppCompatImageView appCompatImageView = this.viewBinding.c;
        Intrinsics.g(appCompatImageView, "clLoading");
        if (appCompatImageView.getVisibility() == 0) {
            return;
        }
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        if (fVar == null || !fVar.isPlaying()) {
            com.transsion.postdetail.layer.b bVar = this.dotLayer;
            if (bVar != null) {
                bVar.c();
            }
            com.transsion.player.orplayer.f fVar2 = this.orPlayer;
            if (fVar2 != null) {
                fVar2.play();
            }
            this.isClickPause = false;
            return;
        }
        com.transsion.postdetail.layer.b bVar2 = this.dotLayer;
        if (bVar2 != null) {
            bVar2.b();
        }
        com.transsion.player.orplayer.f fVar3 = this.orPlayer;
        if (fVar3 != null) {
            fVar3.pause();
        }
        this.isClickPause = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ShortTvImmVideoItemView shortTvImmVideoItemView) {
        com.transsion.player.orplayer.f fVar;
        Fragment fragment = shortTvImmVideoItemView.fragment;
        if (fragment == null || !fragment.isVisible() || (fVar = shortTvImmVideoItemView.orPlayer) == null) {
            return;
        }
        fVar.play();
    }

    private static final com.transsion.postdetail.viewmodel.w y(Lazy lazy) {
        return (com.transsion.postdetail.viewmodel.w) lazy.getValue();
    }

    private static final ShortTvPlayListViewModel z(Lazy lazy) {
        return (ShortTvPlayListViewModel) lazy.getValue();
    }

    public final void addVideoView(View view, Video video, int maxHeight) {
        if (view == null) {
            return;
        }
        this.viewBinding.d.addView(view, new FrameLayout.LayoutParams(-1, -1));
        if (video != null) {
            D(video.getWidth(), video.getHeight(), Integer.valueOf(maxHeight));
        }
    }

    public final void app2Background() {
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.d(true);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i, int i2, qn.d dVar) {
        e.a.a(this, z, i, i2, dVar);
    }

    public final Integer getPosition() {
        return this.position;
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.b(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        e.a.c(this, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        androidx.lifecycle.u viewLifecycleOwner;
        androidx.lifecycle.b0 f;
        androidx.lifecycle.b0 f2;
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        Fragment fragment = this.fragment;
        if (fragment == null || (viewLifecycleOwner = fragment.getViewLifecycleOwner()) == null) {
            return;
        }
        b bVar = this.favoriteResultObserver;
        ShortTvPlayListViewModel shortTvPlayListViewModel = this.shortTvPlayListViewModel;
        bVar.b((shortTvPlayListViewModel == null || (f2 = shortTvPlayListViewModel.f()) == null) ? null : (String) f2.f());
        ShortTvPlayListViewModel shortTvPlayListViewModel2 = this.shortTvPlayListViewModel;
        if (shortTvPlayListViewModel2 == null || (f = shortTvPlayListViewModel2.f()) == null) {
            return;
        }
        f.j(viewLifecycleOwner, this.favoriteResultObserver);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j, gn.e eVar) {
        e.a.d(this, j, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer valueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R$id.iv_share;
        if (valueOf != null && valueOf.intValue() == i) {
            v(v);
            return;
        }
        int i2 = R$id.tv_short_tv_ep;
        if (valueOf != null && valueOf.intValue() == i2) {
            Fragment fragment = this.fragment;
            if (fragment != null) {
                fragment.getContext();
                return;
            }
            return;
        }
        int i3 = R$id.iv_download;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i4 = R$id.iv_short_cover;
            if (valueOf == null || valueOf.intValue() != i4) {
                int i5 = R$id.tv_title;
                if (valueOf == null || valueOf.intValue() != i5) {
                    int i6 = R$id.tv_desc;
                    if (valueOf == null || valueOf.intValue() != i6) {
                        return;
                    }
                }
            }
        }
        DownloadManagerApi a2 = DownloadManagerApi.j.a();
        FragmentActivity context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = context;
        Subject subject = this.data;
        DownloadManagerApi.e0(a2, fragmentActivity, "shorttv_detail_video", BuildConfig.FLAVOR, subject != null ? subject.getOps() : null, "download_subject", v.getId() == R$id.iv_download, this.data, (String) null, Boolean.valueOf(v.getId() != R$id.iv_download), 128, (Object) null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e mediaSource) {
        Fragment fragment;
        Subject subject;
        ShortTVItem shortTVFirstEp;
        a.a.r(wf.a.a, this.TAG, new String[]{"player- onCompletion"}, false, 4, (Object) null);
        Subject subject2 = this.data;
        if (subject2 != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value || (fragment = this.fragment) == null || fragment.getContext() == null || (subject = this.data) == null || subject.getDeleted()) {
                return;
            }
            com.transsion.postdetail.layer.b bVar = this.dotLayer;
            if (bVar != null) {
                bVar.d(false);
            }
            Trailer trailer = subject.getTrailer();
            if ((trailer != null ? trailer.getVideoAddress() : null) == null && (shortTVFirstEp = subject.getShortTVFirstEp()) != null) {
                shortTVFirstEp.getEp();
            }
            com.transsion.player.orplayer.f fVar = this.orPlayer;
            if (fVar != null) {
                fVar.seekTo(0L);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        androidx.lifecycle.b0 f;
        androidx.lifecycle.b0 f2;
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        ShortTvPlayListViewModel shortTvPlayListViewModel = this.shortTvPlayListViewModel;
        if (shortTvPlayListViewModel != null && (f2 = shortTvPlayListViewModel.f()) != null) {
            f2.q((Object) null);
        }
        ShortTvPlayListViewModel shortTvPlayListViewModel2 = this.shortTvPlayListViewModel;
        if (shortTvPlayListViewModel2 == null || (f = shortTvPlayListViewModel2.f()) == null) {
            return;
        }
        f.o(this.favoriteResultObserver);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z) {
        e.a.g(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z) {
        e.a.h(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(gn.e mediaSource) {
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.h();
        }
        setLoading(true);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(gn.e mediaSource) {
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.i();
        }
        setLoading(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i, float f, gn.e eVar) {
        e.a.m(this, i, f, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.j();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String uuid) {
        Fragment fragment;
        Subject subject;
        ShortTVItem shortTVFirstEp;
        e.a.p(this, uuid);
        Subject subject2 = this.data;
        if (subject2 != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value || (fragment = this.fragment) == null || fragment.getContext() == null || (subject = this.data) == null) {
                return;
            }
            com.transsion.postdetail.layer.b bVar = this.dotLayer;
            if (bVar != null) {
                bVar.d(false);
            }
            Trailer trailer = subject.getTrailer();
            if ((trailer != null ? trailer.getVideoAddress() : null) == null && (shortTVFirstEp = subject.getShortTVFirstEp()) != null) {
                shortTVFirstEp.getEp();
            }
            com.transsion.player.orplayer.f fVar = this.orPlayer;
            if (fVar != null) {
                fVar.pause();
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, gn.e mediaSource) {
        Intrinsics.h(errorInfo, "errorInfo");
        this.isSeekToFinish.set(true);
        this.nextSeekTo = 0L;
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.k(errorInfo);
        }
        wf.a.a.i("i_media", this.TAG + " --> IPlayerListener --> onPlayError()  errorCode:" + errorInfo.getErrorCode() + " errorMessage:" + errorInfo.getErrorMessage() + " url:" + (mediaSource != null ? mediaSource.j() : null) + " --> 短播放失败了", true);
    }

    public void onPlayErrorChangePayer(TnPlayerType tnPlayerType, gn.e eVar) {
        e.a.s(this, tnPlayerType, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(gn.e mediaSource) {
        this.isSeekToFinish.set(true);
        this.nextSeekTo = 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        String a2;
        com.transsion.player.orplayer.f fVar;
        ShortTVItem shortTVFirstEp;
        Media video;
        Video videoAddress;
        String url;
        a.a.f(wf.a.a, this.TAG, "player- onPlayerReset", false, 4, (Object) null);
        this.isPrepare = false;
        this.isPageRelease = true;
        this.isSeekToFinish.set(true);
        this.nextSeekTo = 0L;
        setKeepScreenOn(false);
        this.isClickPause = false;
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            com.transsion.postdetail.layer.b.e(bVar, false, 1, null);
        }
        Subject subject = this.data;
        if (subject != null && (shortTVFirstEp = subject.getShortTVFirstEp()) != null && (video = shortTVFirstEp.getVideo()) != null && (videoAddress = video.getVideoAddress()) != null && (url = videoAddress.getUrl()) != null) {
        }
        com.transsion.player.orplayer.f fVar2 = this.orPlayer;
        if (fVar2 != null) {
            fVar2.removePlayerListener(this);
        }
        Subject subject2 = this.data;
        if (subject2 != null && subject2.getDeleted() && (a2 = com.transsion.postdetail.control.a.o.a(subject2)) != null && (fVar = this.orPlayer) != null) {
            ShortTVItem shortTVFirstEp2 = subject2.getShortTVFirstEp();
            fVar.removeDataSource(new gn.e(shortTVFirstEp2 != null ? shortTVFirstEp2.getId() : null, a2, 0, null, null, 24, null));
        }
        AppCompatImageView appCompatImageView = this.viewBinding.f;
        Intrinsics.g(appCompatImageView, "ivCover");
        uf.c.k(appCompatImageView);
        AppCompatImageView appCompatImageView2 = this.viewBinding.h;
        Intrinsics.g(appCompatImageView2, "ivPause");
        uf.c.g(appCompatImageView2);
        AppCompatSeekBar appCompatSeekBar = this.viewBinding.o;
        Intrinsics.g(appCompatSeekBar, "seekBar");
        uf.c.g(appCompatSeekBar);
        ImmVideoGuideView immVideoGuideView = this.guideView;
        if (immVideoGuideView != null) {
            immVideoGuideView.removeGuide();
        }
        this.orPlayer = null;
        this.orPlayerView = null;
        this.pagerLayoutManager = null;
        this.currentSaveProgress = 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.player.orplayer.e
    public void onPrepare(gn.e mediaSource) {
        Fragment fragment;
        ShortTVItem shortTVFirstEp;
        Media video;
        Video videoAddress;
        String url;
        if (this.isPrepare) {
            return;
        }
        this.isPrepare = true;
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        int duration = fVar != null ? (int) fVar.getDuration() : 0;
        a.a aVar = wf.a.a;
        a.a.g(aVar, "shorttv.here.duration: " + duration, false, 2, (Object) null);
        this.viewBinding.m.setMax(duration);
        this.viewBinding.o.setMax(duration);
        Subject subject = this.data;
        if (subject != null && (shortTVFirstEp = subject.getShortTVFirstEp()) != null && (video = shortTVFirstEp.getVideo()) != null && (videoAddress = video.getVideoAddress()) != null && (url = videoAddress.getUrl()) != null) {
            Long l = (Long) ShortTvImmVideoHelper.k.a().o().get(url);
            long longValue = l != null ? l.longValue() : 0L;
            a.a.f(aVar, this.TAG, "player- onPrepare, duration = " + this.viewBinding.m.getMax() + ", progress = " + longValue, false, 4, (Object) null);
            if (longValue >= 0) {
                this.currentSaveProgress = longValue;
                int i = (int) longValue;
                this.viewBinding.m.setProgress(i);
                this.viewBinding.o.setProgress(i);
                com.transsion.player.orplayer.f fVar2 = this.orPlayer;
                if (fVar2 != null) {
                    fVar2.seekTo(longValue);
                }
            }
        }
        if (!this.isClickPause && !this.isPageHide && (fragment = this.fragment) != null && fragment.isVisible()) {
            a.a.f(aVar, this.TAG, "player- onPrepare， play~", false, 4, (Object) null);
            com.transsion.player.orplayer.f fVar3 = this.orPlayer;
            if (fVar3 != null) {
                fVar3.play();
            }
        }
        setKeepScreenOn(true);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long progress, gn.e mediaSource) {
        ShortTVItem shortTVFirstEp;
        if (this.isSeekToFinish.get() && !this.isHorizontalDragging) {
            if (eo.b.a.b() && mediaSource != null) {
                String e2 = mediaSource.e();
                Subject subject = this.data;
                if (!Intrinsics.c(e2, (subject == null || (shortTVFirstEp = subject.getShortTVFirstEp()) == null) ? null : shortTVFirstEp.getId())) {
                    a.a.f(wf.a.a, this.TAG, "onProgress- vid 不同, return", false, 4, (Object) null);
                    return;
                }
            }
            com.transsion.postdetail.layer.b bVar = this.dotLayer;
            if (bVar != null) {
                bVar.l(progress);
            }
            int i = (int) progress;
            this.viewBinding.m.setProgress(i);
            this.viewBinding.o.setProgress(i);
            t(progress);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        a.a.f(wf.a.a, this.TAG, "player- onRenderFirstFrame", false, 4, (Object) null);
        AppCompatImageView appCompatImageView = this.viewBinding.f;
        Intrinsics.g(appCompatImageView, "ivCover");
        uf.c.g(appCompatImageView);
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.m();
        }
        setLoading(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        this.isPageRelease = false;
        this.isSeekToFinish.set(true);
        this.nextSeekTo = 0L;
        setLoading(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStateChanged(androidx.lifecycle.u source, Lifecycle.Event event) {
        ShortTVItem shortTVFirstEp;
        Media video;
        Video videoAddress;
        String url;
        Lifecycle lifecycle;
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        int i = a.a[event.ordinal()];
        if (i == 1) {
            this.isPageHide = true;
            a.a.f(wf.a.a, this.TAG, "player- onPause", false, 4, (Object) null);
            com.transsion.player.orplayer.f fVar = this.orPlayer;
            if (fVar != null) {
                fVar.pause();
                return;
            }
            return;
        }
        if (i == 2) {
            this.isPageHide = false;
            if (this.isClickPause) {
                return;
            }
            Fragment fragment = this.fragment;
            if (fragment != null && !fragment.isVisible()) {
                post(new Runnable() { // from class: com.transsion.postdetail.ui.view.x1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ShortTvImmVideoItemView.x(ShortTvImmVideoItemView.this);
                    }
                });
                return;
            }
            com.transsion.player.orplayer.f fVar2 = this.orPlayer;
            if (fVar2 != null) {
                fVar2.play();
                return;
            }
            return;
        }
        if (i == 3) {
            Subject subject = this.data;
            if (subject == null || (shortTVFirstEp = subject.getShortTVFirstEp()) == null || (video = shortTVFirstEp.getVideo()) == null || (videoAddress = video.getVideoAddress()) == null || (url = videoAddress.getUrl()) == null) {
                return;
            }
            return;
        }
        if (i != 5) {
            return;
        }
        Fragment fragment2 = this.fragment;
        if (fragment2 != null && (lifecycle = fragment2.getLifecycle()) != null) {
            lifecycle.d(this);
        }
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.p();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.h(event, "event");
        GestureDetector gestureDetector = this.gestureDetector;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(event)) {
            return super/*android.view.ViewGroup*/.onTouchEvent(event);
        }
        return true;
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i) {
        e.a.C(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(qn.c cVar) {
        e.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i) {
        e.a.E(this, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(gn.e mediaSource) {
        a.a.f(wf.a.a, this.TAG, "player- onVideoPause", false, 4, (Object) null);
        AppCompatImageView appCompatImageView = this.viewBinding.h;
        Intrinsics.g(appCompatImageView, "ivPause");
        uf.c.k(appCompatImageView);
        AppCompatSeekBar appCompatSeekBar = this.viewBinding.o;
        Intrinsics.g(appCompatSeekBar, "seekBar");
        uf.c.k(appCompatSeekBar);
        ProgressBar progressBar = this.viewBinding.m;
        Intrinsics.g(progressBar, "progressBar");
        uf.c.g(progressBar);
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.n();
        }
        setKeepScreenOn(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int width, int height) {
        e.a.H(this, width, height);
        E(this, Integer.valueOf(width), Integer.valueOf(height), null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e mediaSource) {
        a.a.f(wf.a.a, this.TAG, "player- onVideoStart", false, 4, (Object) null);
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.o();
        }
        AppCompatImageView appCompatImageView = this.viewBinding.h;
        Intrinsics.g(appCompatImageView, "ivPause");
        uf.c.g(appCompatImageView);
        AppCompatSeekBar appCompatSeekBar = this.viewBinding.o;
        Intrinsics.g(appCompatSeekBar, "seekBar");
        uf.c.g(appCompatSeekBar);
        setLoading(false);
        setKeepScreenOn(true);
    }

    public final void setData(Subject item, final Fragment fragment, Integer position, String basePostId, String baseItemType, boolean attachToMain) {
        Intrinsics.h(item, "item");
        Intrinsics.h(fragment, "fragment");
        com.transsion.postdetail.layer.b bVar = new com.transsion.postdetail.layer.b();
        this.dotLayer = bVar;
        bVar.s(basePostId);
        com.transsion.postdetail.layer.b bVar2 = this.dotLayer;
        if (bVar2 != null) {
            bVar2.r(baseItemType);
        }
        com.transsion.postdetail.layer.b bVar3 = this.dotLayer;
        if (bVar3 != null) {
            bVar3.y(SubjectType.SHORT_TV.getValue());
        }
        PostSubjectItem postSubjectItem = new PostSubjectItem((String) null, (String) null, (com.transsion.moviedetailapi.bean.Group) null, (Boolean) null, (Boolean) null, (Link) null, (Media) null, (String) null, (Stat) null, (Integer) null, (Subject) null, (Integer) null, (String) null, (String) null, (User) null, (String) null, (String) null, (Integer) null, (String) null, false, (Float) null, (Float) null, (String) null, (String) null, false, (List) null, false, (BiddingNativeManager) null, false, false, false, false, (CommentBean) null, -1, 1, (DefaultConstructorMarker) null);
        postSubjectItem.setSubject(item);
        postSubjectItem.setOps(item.getOps());
        postSubjectItem.setItemType("7");
        com.transsion.postdetail.layer.b bVar4 = this.dotLayer;
        if (bVar4 != null) {
            bVar4.x(BuildConfig.FLAVOR, postSubjectItem);
        }
        this.fragment = fragment;
        this.videoLoadMore = this.videoLoadMore;
        this.basePostId = basePostId;
        this.position = position;
        this.attachToMain = attachToMain;
        fragment.getLifecycle().a(this);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m137invoke() {
                return fragment;
            }
        };
        this.videoDetailModel = y(FragmentViewModelLazyKt.a(fragment, Reflection.b(com.transsion.postdetail.viewmodel.w.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.x0 m138invoke() {
                androidx.lifecycle.x0 viewModelStore = ((androidx.lifecycle.y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m139invoke() {
                Object invoke = function0.invoke();
                androidx.lifecycle.m mVar = invoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }));
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m140invoke() {
                return fragment;
            }
        };
        this.shortTvPlayListViewModel = z(FragmentViewModelLazyKt.a(fragment, Reflection.b(ShortTvPlayListViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.x0 m141invoke() {
                androidx.lifecycle.x0 viewModelStore = ((androidx.lifecycle.y0) function02.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m142invoke() {
                Object invoke = function02.invoke();
                androidx.lifecycle.m mVar = invoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }));
        this.data = item;
        F(item);
        if (attachToMain) {
            ConstraintLayout.b layoutParams = this.viewBinding.n.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.b) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.blankj.utilcode.util.a0.a(16.0f);
            }
        }
        A();
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.K(this);
        this.isSeekToFinish.set(true);
        long j = this.nextSeekTo;
        if (j > 0) {
            a.a.r(wf.a.a, this.TAG, new String[]{"seek OnSeekComplete，nextSeekTo:" + j}, false, 4, (Object) null);
            com.transsion.player.orplayer.f fVar = this.orPlayer;
            if (fVar != null) {
                fVar.seekTo(this.nextSeekTo);
            }
            this.nextSeekTo = 0L;
        }
    }

    public final void setPagerLayoutManager(PagerLayoutManager pagerLayoutManager) {
        Intrinsics.h(pagerLayoutManager, "pagerLayoutManager");
        this.pagerLayoutManager = pagerLayoutManager;
    }

    public final void setPlayer(com.transsion.player.orplayer.f orPlayer, ORPlayerView orPlayerView) {
        Intrinsics.h(orPlayer, "orPlayer");
        Intrinsics.h(orPlayerView, "orPlayerView");
        this.orPlayer = orPlayer;
        this.orPlayerView = orPlayerView;
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.v(orPlayer);
        }
    }

    public final void setPosition(Integer num) {
        this.position = num;
    }

    public final void setVideoUrl(String url) {
        Intrinsics.h(url, "url");
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.A(url);
        }
    }

    public final void videoStartPrepare(String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        this.pageFrom = pageFrom;
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.t(pageFrom);
        }
        com.transsion.postdetail.layer.b bVar2 = this.dotLayer;
        if (bVar2 != null) {
            bVar2.g();
        }
        com.transsion.postdetail.layer.b bVar3 = this.dotLayer;
        if (bVar3 != null) {
            bVar3.a(0, 0);
        }
        com.transsion.postdetail.layer.b bVar4 = this.dotLayer;
        if (bVar4 != null) {
            bVar4.w(this.position);
        }
    }
}
