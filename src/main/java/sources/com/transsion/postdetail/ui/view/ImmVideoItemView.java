package com.transsion.postdetail.ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baseui.util.UrlContent;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsion.baseui.widget.f;
import com.transsion.flow.bean.CommentBean;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$mipmap;
import com.transsion.postdetail.bean.CommentLikeBody;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.shorttv.ShortTvPlayListViewModel;
import com.transsion.postdetail.ui.dialog.ImmVideoCommentDialog;
import com.transsion.postdetail.ui.dialog.PostConfirmDialog;
import com.transsion.postdetail.ui.fragment.CommentFragment;
import com.transsion.postdetail.ui.fragment.VideoFragment;
import com.transsion.postdetail.ui.view.ImmVideoItemView;
import com.transsion.postdetail.viewmodel.CommentViewModel;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.push.PushConstants;
import com.transsion.push.bean.MsgStyle;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.shorttv.base.pager.PagerLayoutManager;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import ni.f;
import wf.a;

@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002õ\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B!\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0011Jk\u0010!\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u0018¢\u0006\u0004\b!\u0010\"J\u001d\u0010'\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\r\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00182\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u001f\u00107\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u0006\u00101\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u000fH\u0016¢\u0006\u0004\b9\u0010\u0011J\u0019\u0010<\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\u000f¢\u0006\u0004\b>\u0010\u0011J\u0017\u0010?\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b?\u0010@J\u0015\u0010B\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u001a¢\u0006\u0004\bB\u0010@J\u000f\u0010C\u001a\u00020\u000fH\u0016¢\u0006\u0004\bC\u0010\u0011J\u000f\u0010D\u001a\u00020\u000fH\u0016¢\u0006\u0004\bD\u0010\u0011J\u0019\u0010E\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bE\u0010=J\u0019\u0010F\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bF\u0010=J\u0019\u0010G\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bG\u0010=J!\u0010J\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020H2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bJ\u0010KJ\u0019\u0010L\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bL\u0010=J\u0019\u0010M\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bM\u0010=J!\u0010P\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020N2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\u000fH\u0016¢\u0006\u0004\bR\u0010\u0011J\u0019\u0010S\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bS\u0010=J\u000f\u0010T\u001a\u00020\u000fH\u0016¢\u0006\u0004\bT\u0010\u0011J\u0019\u0010W\u001a\u00020\u000f2\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bW\u0010XJ\r\u0010Y\u001a\u00020\u000f¢\u0006\u0004\bY\u0010\u0011J\u0019\u0010[\u001a\u00020\u000f2\b\u0010Z\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b[\u0010@J\u0017\u0010\\\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\\\u0010\rJ\u0017\u0010]\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b_\u0010^J\u0017\u0010a\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020HH\u0002¢\u0006\u0004\ba\u0010bJ\u0017\u0010d\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020HH\u0002¢\u0006\u0004\bd\u0010bJ\u0017\u0010e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\be\u0010^J\u0017\u0010f\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bf\u0010^J\u0017\u0010g\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bg\u0010^J\u001f\u0010j\u001a\u00020\u000f2\u0006\u0010h\u001a\u00020\u00182\u0006\u0010i\u001a\u00020\u0018H\u0002¢\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bl\u0010^J\u001f\u0010o\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020m2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bo\u0010pJ\u0017\u0010q\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bq\u0010^J\u001f\u0010s\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bs\u0010tJ\u000f\u0010u\u001a\u00020\u000fH\u0002¢\u0006\u0004\bu\u0010\u0011J\u000f\u0010v\u001a\u00020\u000fH\u0002¢\u0006\u0004\bv\u0010\u0011J\u000f\u0010w\u001a\u00020\u000fH\u0002¢\u0006\u0004\bw\u0010\u0011J\u000f\u0010x\u001a\u00020\u000fH\u0002¢\u0006\u0004\bx\u0010\u0011J\u0017\u0010z\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020\u0018H\u0002¢\u0006\u0004\bz\u0010{J\u0017\u0010|\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020HH\u0002¢\u0006\u0004\b|\u0010bJ\u0017\u0010~\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0004\b~\u0010XJ\u000f\u0010\u007f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u007f\u0010\u0011J\u0019\u0010\u0080\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u0080\u0001\u0010XJ\u0019\u0010\u0081\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u0081\u0001\u0010XJ\u0019\u0010\u0082\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u0082\u0001\u0010XJ\u001c\u0010\u0085\u0001\u001a\u00020\u000f2\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001H\u0002¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u001c\u0010\u0088\u0001\u001a\u00020\u000f2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0005\b\u0088\u0001\u0010@J\u0019\u0010\u0089\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u0089\u0001\u0010XJ\u0019\u0010\u008a\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u008a\u0001\u0010XJ\u0019\u0010\u008b\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u008b\u0001\u0010XJ\u0011\u0010\u008c\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u008c\u0001\u0010\u0011J\u001a\u0010\u008e\u0001\u001a\u00020\u000f2\u0007\u0010\u008d\u0001\u001a\u00020\u0018H\u0002¢\u0006\u0005\b\u008e\u0001\u0010{J\u0019\u0010\u008f\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u008f\u0001\u0010XJ\u0019\u0010\u0090\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u0090\u0001\u0010XR\u0017\u0010\u0093\u0001\u001a\u00020\u001a8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001c\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001c\u0010£\u0001\u001a\u0005\u0018\u00010 \u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u001c\u0010§\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R*\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010\u0092\u0001R\u0018\u0010\u001e\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010\u0092\u0001R\u001a\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u001a\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001a\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001c\u0010À\u0001\u001a\u0005\u0018\u00010½\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u001c\u0010Ä\u0001\u001a\u0005\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001c\u0010È\u0001\u001a\u0005\u0018\u00010Å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R#\u0010Î\u0001\u001a\u0005\u0018\u00010É\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001R\u001c\u0010Ò\u0001\u001a\u0005\u0018\u00010Ï\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u001c\u0010Ö\u0001\u001a\u0005\u0018\u00010Ó\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u0018\u0010Ø\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bV\u0010×\u0001R\u0019\u0010Ú\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010×\u0001R\u0019\u0010Ü\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010×\u0001R\u0018\u0010Ý\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b[\u0010×\u0001R\u0019\u0010Þ\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010×\u0001R\u0018\u0010à\u0001\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bo\u0010ß\u0001R\u0015\u0010á\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010vR\u0016\u0010â\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010vR\u0016\u0010ä\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bã\u0001\u0010vR\u0016\u0010æ\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bå\u0001\u0010vR\u0016\u0010ç\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010vR\u0016\u0010è\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010vR\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0092\u0001R\u0017\u0010ë\u0001\u001a\u00030é\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bv\u0010ê\u0001R\u0019\u0010ì\u0001\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010ß\u0001R\u0018\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0001\u0010×\u0001R\u0018\u0010î\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bw\u0010×\u0001R\u0019\u0010ð\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010×\u0001R\u0016\u0010ñ\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010vR\u0018\u0010 \u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010×\u0001R\u001b\u0010ô\u0001\u001a\u0005\u0018\u00010ò\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b|\u0010ó\u0001R\u0018\u0010ø\u0001\u001a\u00030õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R!\u0010ý\u0001\u001a\u00030ù\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bú\u0001\u0010Ë\u0001\u001a\u0006\bû\u0001\u0010ü\u0001R\u001f\u0010\u0080\u0002\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0þ\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b~\u0010ÿ\u0001¨\u0006\u0082\u0002²\u0006\u000e\u0010\u009b\u0001\u001a\u00030\u0098\u00018\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u009f\u0001\u001a\u00030\u009c\u00018\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0081\u0002\u001a\u00030 \u00018\nX\u008a\u0084\u0002"}, d2 = {"Lcom/transsion/postdetail/ui/view/ImmVideoItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/transsion/player/orplayer/e;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/r;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "onAttachedToWindow", "()V", "onDetachedFromWindow", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "item", "Landroidx/fragment/app/Fragment;", "fragment", "position", BuildConfig.FLAVOR, "videoLoadMore", BuildConfig.FLAVOR, "basePostId", "baseItemType", "attachToMain", "commentId", "pageFrom", "isFromDownloaded", "setData", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;Landroidx/fragment/app/Fragment;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)V", "Lcom/transsion/player/orplayer/f;", "orPlayer", "Lcom/transsion/player/ui/ORPlayerView;", "orPlayerView", "setPlayer", "(Lcom/transsion/player/orplayer/f;Lcom/transsion/player/ui/ORPlayerView;)V", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "pagerLayoutManager", "setPagerLayoutManager", "(Lcom/transsion/shorttv/base/pager/PagerLayoutManager;)V", "Landroid/widget/FrameLayout;", "getPlayerContainer", "()Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroidx/lifecycle/u;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged", "(Landroidx/lifecycle/u;Landroidx/lifecycle/Lifecycle$Event;)V", "onPlayerReset", "Lgn/e;", "mediaSource", "onPlayerRelease", "(Lgn/e;)V", "app2Background", "videoStartPrepare", "(Ljava/lang/String;)V", "url", "setVideoUrl", "onSetDataSource", "onRenderFirstFrame", "onVideoStart", "onPrepare", "onVideoPause", BuildConfig.FLAVOR, "progress", "onProgress", "(JLgn/e;)V", "onLoadingBegin", "onLoadingEnd", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lgn/e;)V", "onLoopingStart", "onCompletion", "setOnSeekCompleteListener", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "showCommentDialog", "type", "y", "B", "p0", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "i0", "comment", "e0", "(J)V", "share", "l0", "o0", "setBottomSubjectModuleData", "setBottomRoomModuleData", "isShowSubject", "isShowRoom", "setBottomSubjectAndRoomVisibility", "(ZZ)V", "f0", "Lcom/transsion/moviedetailapi/bean/CommentBean;", "hotComment", "A", "(Lcom/transsion/moviedetailapi/bean/CommentBean;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "W", "moduleName", "X", "(Ljava/lang/String;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "m0", "I", "L", "U", PushConstants.PUSH_SERVICE_TYPE_SHOW, "setLoading", "(Z)V", "P", "view", "S", "j0", "O", "N", "T", "Lcom/transsion/baselib/db/download/DownloadBean;", "download", "Y", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "id", "z", "F", "H", "G", "C", "visible", "setContentVisibility", "c0", "d0", "a", "Ljava/lang/String;", "TAG", "Lwn/t;", "b", "Lwn/t;", "viewBinding", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "c", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "videoDetailModel", "Lcom/transsion/postdetail/shorttv/ShortTvPlayListViewModel;", "d", "Lcom/transsion/postdetail/shorttv/ShortTvPlayListViewModel;", "shortTvPlayListViewModel", "Lcom/transsion/postdetail/viewmodel/CommentViewModel;", "e", "Lcom/transsion/postdetail/viewmodel/CommentViewModel;", "mCommentViewModel", "Lcom/transsion/share/share/ShareDialogFragment;", "f", "Lcom/transsion/share/share/ShareDialogFragment;", "mShareDialog", "g", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "data", "h", "Landroidx/fragment/app/Fragment;", "i", "Ljava/lang/Boolean;", "j", "Ljava/lang/Integer;", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", "k", "l", "m", "Lcom/transsion/player/orplayer/f;", "n", "Lcom/transsion/player/ui/ORPlayerView;", "o", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "Lep/a;", "p", "Lep/a;", "audioApi", "Lcom/transsion/postdetail/ui/view/ImmVideoGuideView;", "q", "Lcom/transsion/postdetail/ui/view/ImmVideoGuideView;", "guideView", "Landroid/view/GestureDetector;", "r", "Landroid/view/GestureDetector;", "gestureDetector", "Lqx/a;", "s", "Lkotlin/Lazy;", "getLoginApi", "()Lqx/a;", "loginApi", "Lcom/transsion/postdetail/layer/b;", "t", "Lcom/transsion/postdetail/layer/b;", "dotLayer", "Lcom/transsion/postdetail/ui/dialog/ImmVideoCommentDialog;", "u", "Lcom/transsion/postdetail/ui/dialog/ImmVideoCommentDialog;", "commentDialog", "Z", "isClickPause", "w", "isHorizontalDragging", "x", "isPageHide", "isShowHotComment", "isFavoriteShow", "J", "currentSaveProgress", "resImgLargeWidth", "resImgLargeHeight", "D", "resImgSmallWidth", "E", "resImgSmallHeight", "screenHeight", "dp170", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isSeekToFinish", "nextSeekTo", "K", "isPageRelease", "M", "isLongPressTriggered", "screenWidth", "Landroid/animation/ObjectAnimator;", "Landroid/animation/ObjectAnimator;", "rotateAnimator", "com/transsion/postdetail/ui/view/ImmVideoItemView$b", "Q", "Lcom/transsion/postdetail/ui/view/ImmVideoItemView$b;", "downloadListener", "Lcom/transsnet/downloader/manager/g;", "R", "getDownloadManager", "()Lcom/transsnet/downloader/manager/g;", "downloadManager", "Landroidx/lifecycle/c0;", "Landroidx/lifecycle/c0;", "favoriteResultObserver", "commentViewModel", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ImmVideoItemView extends ConstraintLayout implements com.transsion.player.orplayer.e, View.OnClickListener, androidx.lifecycle.r {

    /* renamed from: A, reason: from kotlin metadata */
    private long currentSaveProgress;

    /* renamed from: B, reason: from kotlin metadata */
    private final int resImgLargeWidth;

    /* renamed from: C, reason: from kotlin metadata */
    private final int resImgLargeHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private final int resImgSmallWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private final int resImgSmallHeight;

    /* renamed from: F, reason: from kotlin metadata */
    private final int screenHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private final int dp170;

    /* renamed from: H, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: I, reason: from kotlin metadata */
    private final AtomicBoolean isSeekToFinish;

    /* renamed from: J, reason: from kotlin metadata */
    private long nextSeekTo;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean attachToMain;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isPageRelease;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isLongPressTriggered;

    /* renamed from: N, reason: from kotlin metadata */
    private final int screenWidth;

    /* renamed from: O, reason: from kotlin metadata */
    private boolean isFromDownloaded;

    /* renamed from: P, reason: from kotlin metadata */
    private ObjectAnimator rotateAnimator;

    /* renamed from: Q, reason: from kotlin metadata */
    private final b downloadListener;

    /* renamed from: R, reason: from kotlin metadata */
    private final Lazy downloadManager;

    /* renamed from: S, reason: from kotlin metadata */
    private final androidx.lifecycle.c0 favoriteResultObserver;

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: from kotlin metadata */
    private final wn.t viewBinding;

    /* renamed from: c, reason: from kotlin metadata */
    private PostDetailViewModel videoDetailModel;

    /* renamed from: d, reason: from kotlin metadata */
    private ShortTvPlayListViewModel shortTvPlayListViewModel;

    /* renamed from: e, reason: from kotlin metadata */
    private CommentViewModel mCommentViewModel;

    /* renamed from: f, reason: from kotlin metadata */
    private ShareDialogFragment mShareDialog;

    /* renamed from: g, reason: from kotlin metadata */
    private PostSubjectItem data;

    /* renamed from: h, reason: from kotlin metadata */
    private Fragment fragment;

    /* renamed from: i, reason: from kotlin metadata */
    private Boolean videoLoadMore;

    /* renamed from: j, reason: from kotlin metadata */
    private Integer position;

    /* renamed from: k, reason: from kotlin metadata */
    private String basePostId;

    /* renamed from: l, reason: from kotlin metadata */
    private String commentId;

    /* renamed from: m, reason: from kotlin metadata */
    private com.transsion.player.orplayer.f orPlayer;

    /* renamed from: n, reason: from kotlin metadata */
    private ORPlayerView orPlayerView;

    /* renamed from: o, reason: from kotlin metadata */
    private PagerLayoutManager pagerLayoutManager;

    /* renamed from: p, reason: from kotlin metadata */
    private ep.a audioApi;

    /* renamed from: q, reason: from kotlin metadata */
    private ImmVideoGuideView guideView;

    /* renamed from: r, reason: from kotlin metadata */
    private GestureDetector gestureDetector;

    /* renamed from: s, reason: from kotlin metadata */
    private final Lazy loginApi;

    /* renamed from: t, reason: from kotlin metadata */
    private com.transsion.postdetail.layer.b dotLayer;

    /* renamed from: u, reason: from kotlin metadata */
    private ImmVideoCommentDialog commentDialog;

    /* renamed from: v, reason: from kotlin metadata */
    private boolean isClickPause;

    /* renamed from: w, reason: from kotlin metadata */
    private boolean isHorizontalDragging;

    /* renamed from: x, reason: from kotlin metadata */
    private boolean isPageHide;

    /* renamed from: y, reason: from kotlin metadata */
    private boolean isShowHotComment;

    /* renamed from: z, reason: from kotlin metadata */
    private boolean isFavoriteShow;

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

    public static final class b implements ui.m0 {
        b() {
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, com.transsion.postdetail.ui.view.ImmVideoItemView] */
        private final void i(DownloadBean downloadBean) {
            String postId = downloadBean.getPostId();
            PostSubjectItem postSubjectItem = ImmVideoItemView.this.data;
            if (!Intrinsics.c(postId, postSubjectItem != null ? postSubjectItem.getPostId() : null)) {
                String resourceId = downloadBean.getResourceId();
                PostSubjectItem postSubjectItem2 = ImmVideoItemView.this.data;
                if (!Intrinsics.c(resourceId, postSubjectItem2 != null ? postSubjectItem2.getPostId() : null)) {
                    return;
                }
            }
            final ?? r4 = ImmVideoItemView.this;
            r4.post(new Runnable() { // from class: com.transsion.postdetail.ui.view.r
                @Override // java.lang.Runnable
                public final void run() {
                    ImmVideoItemView.b.j(ImmVideoItemView.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(ImmVideoItemView immVideoItemView) {
            immVideoItemView.j0();
        }

        @Override // ui.m0
        public void a(DownloadBean downloadBean, DownloadException downloadException) {
            Intrinsics.h(downloadBean, "bean");
            i(downloadBean);
        }

        @Override // ui.m0
        public void b(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
            i(downloadBean);
        }

        @Override // ui.m0
        public void c(DownloadBean downloadBean, long j, long j2) {
            Intrinsics.h(downloadBean, "bean");
            i(downloadBean);
        }

        @Override // ui.m0
        public void d(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
            i(downloadBean);
        }

        @Override // ui.m0
        public void e(DownloadBean downloadBean, String str) {
            Intrinsics.h(downloadBean, "bean");
            i(downloadBean);
        }

        @Override // ui.m0
        public void f(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
            i(downloadBean);
        }

        @Override // ui.m0
        public void g(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
            i(downloadBean);
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
        public void onLongPress(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
            super.onLongPress(motionEvent);
            int i = ImmVideoItemView.this.screenWidth / 3;
            int x = (int) motionEvent.getX();
            ImmVideoItemView.this.isLongPressTriggered = true;
            if (x >= 0 && x <= i) {
                a.a.f(wf.a.a, ImmVideoItemView.this.TAG, "左边长按，clickX=" + x + ", cut=" + i, false, 4, (Object) null);
                return;
            }
            if (x > i * 2) {
                a.a.f(wf.a.a, ImmVideoItemView.this.TAG, "右边长按，clickX=" + x + ", cut=" + i, false, 4, (Object) null);
                return;
            }
            a.a.f(wf.a.a, ImmVideoItemView.this.TAG, "中间长按，clickX=" + x + ", cut=" + i, false, 4, (Object) null);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
            ImmVideoItemView.this.U();
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
            if (!ImmVideoItemView.this.isHorizontalDragging) {
                PagerLayoutManager pagerLayoutManager = ImmVideoItemView.this.pagerLayoutManager;
                if (pagerLayoutManager != null) {
                    pagerLayoutManager.W(false);
                }
                this.a = ImmVideoItemView.this.viewBinding.u.getProgress();
                ImmVideoItemView.this.setContentVisibility(false);
                AppCompatTextView appCompatTextView = ImmVideoItemView.this.viewBinding.D;
                Intrinsics.g(appCompatTextView, "tvProgressDes");
                uf.c.k(appCompatTextView);
                AppCompatSeekBar appCompatSeekBar = ImmVideoItemView.this.viewBinding.w;
                Intrinsics.g(appCompatSeekBar, "seekBar");
                uf.c.k(appCompatSeekBar);
                ProgressBar progressBar = ImmVideoItemView.this.viewBinding.u;
                Intrinsics.g(progressBar, "progressBar");
                uf.c.g(progressBar);
                this.c = ImmVideoItemView.this.viewBinding.u.getWidth();
                int max = ImmVideoItemView.this.viewBinding.u.getMax();
                this.b = max;
                this.d = com.transsion.postdetail.util.m.c(max);
            }
            ImmVideoItemView.this.isHorizontalDragging = true;
            float f3 = f2 - f;
            int i = this.b;
            int i2 = (int) (this.a + ((f3 * i) / this.c));
            int i3 = i2 >= 0 ? i2 > i ? i : i2 : 0;
            ImmVideoItemView.this.viewBinding.D.setText(com.transsion.postdetail.util.m.c(i3) + " / " + this.d);
            ImmVideoItemView.this.viewBinding.u.setProgress(i3);
            ImmVideoItemView.this.viewBinding.w.setProgress(i3);
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
            PagerLayoutManager pagerLayoutManager = ImmVideoItemView.this.pagerLayoutManager;
            if (pagerLayoutManager != null) {
                pagerLayoutManager.W(true);
            }
            if (ImmVideoItemView.this.isHorizontalDragging) {
                ImmVideoItemView.this.isHorizontalDragging = false;
                ImmVideoItemView.this.setContentVisibility(true);
                AppCompatTextView appCompatTextView = ImmVideoItemView.this.viewBinding.D;
                Intrinsics.g(appCompatTextView, "tvProgressDes");
                uf.c.g(appCompatTextView);
                AppCompatSeekBar appCompatSeekBar = ImmVideoItemView.this.viewBinding.w;
                Intrinsics.g(appCompatSeekBar, "seekBar");
                uf.c.g(appCompatSeekBar);
                ProgressBar progressBar = ImmVideoItemView.this.viewBinding.u;
                Intrinsics.g(progressBar, "progressBar");
                uf.c.k(progressBar);
                long progress = ImmVideoItemView.this.viewBinding.u.getProgress();
                ImmVideoItemView immVideoItemView = ImmVideoItemView.this;
                if (immVideoItemView.isSeekToFinish.compareAndSet(true, false)) {
                    com.transsion.player.orplayer.f fVar2 = ImmVideoItemView.this.orPlayer;
                    if (fVar2 != null) {
                        fVar2.seekTo(progress);
                    }
                    progress = 0;
                }
                immVideoItemView.nextSeekTo = progress;
                com.transsion.player.orplayer.f fVar3 = ImmVideoItemView.this.orPlayer;
                if (fVar3 == null || fVar3.isPlaying() || (fVar = ImmVideoItemView.this.orPlayer) == null) {
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
        final /* synthetic */ View a;
        final /* synthetic */ ImmVideoItemView b;

        public static final class a implements PostConfirmDialog.a {
            final /* synthetic */ ImmVideoItemView a;

            a(ImmVideoItemView immVideoItemView) {
                this.a = immVideoItemView;
            }

            @Override // com.transsion.postdetail.ui.dialog.PostConfirmDialog.a
            public void a() {
                String postId;
                PostDetailViewModel postDetailViewModel;
                PostSubjectItem postSubjectItem = this.a.data;
                if (postSubjectItem == null || (postId = postSubjectItem.getPostId()) == null || (postDetailViewModel = this.a.videoDetailModel) == null) {
                    return;
                }
                postDetailViewModel.r(postId);
            }
        }

        e(View view, ImmVideoItemView immVideoItemView) {
            this.a = view;
            this.b = immVideoItemView;
        }

        @Override // com.transsion.share.share.a
        public void a(String str, PostType postType) {
            Fragment fragment;
            FragmentManager childFragmentManager;
            Intrinsics.h(str, "id");
            PostConfirmDialog postConfirmDialog = new PostConfirmDialog();
            postConfirmDialog.r0(new a(this.b));
            Fragment fragment2 = this.b.fragment;
            if (fragment2 == null || !fragment2.isAdded() || (fragment = this.b.fragment) == null || (childFragmentManager = fragment.getChildFragmentManager()) == null) {
                return;
            }
            childFragmentManager.g0();
            if (postConfirmDialog.isAdded() || childFragmentManager.k0("PostConfirmDialog") != null) {
                return;
            }
            postConfirmDialog.show(childFragmentManager, "PostConfirmDialog");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            this.b.z(str);
        }

        @Override // com.transsion.share.share.a
        public void c(String str, String str2, String str3, String str4) {
            Subject subject;
            ResourceDetectors resourceDetector;
            String resourceLink;
            Media media;
            Cover cover;
            Integer size;
            Media media2;
            Cover cover2;
            String url;
            String url2;
            String url3;
            Media media3;
            Intrinsics.h(str, "url");
            Intrinsics.h(str2, "fileName");
            Intrinsics.h(str3, "fileSize");
            Intrinsics.h(str4, "fileImage");
            if (com.transsion.baseui.util.c.a.a(this.a.getId(), 500L)) {
                return;
            }
            PostSubjectItem postSubjectItem = this.b.data;
            Video a2 = com.transsion.postdetail.util.t.a((postSubjectItem == null || (media3 = postSubjectItem.getMedia()) == null) ? null : media3.getVideo());
            PostSubjectItem postSubjectItem2 = this.b.data;
            String title = postSubjectItem2 != null ? postSubjectItem2.getTitle() : null;
            if (TextUtils.isEmpty(title)) {
                PostSubjectItem postSubjectItem3 = this.b.data;
                title = postSubjectItem3 != null ? postSubjectItem3.getContent() : null;
            }
            String str5 = title;
            String str6 = (a2 == null || (url3 = a2.getUrl()) == null) ? BuildConfig.FLAVOR : url3;
            String str7 = (a2 == null || (url2 = a2.getUrl()) == null) ? BuildConfig.FLAVOR : url2;
            PostSubjectItem postSubjectItem4 = this.b.data;
            String str8 = (postSubjectItem4 == null || (media2 = postSubjectItem4.getMedia()) == null || (cover2 = media2.getCover()) == null || (url = cover2.getUrl()) == null) ? BuildConfig.FLAVOR : url;
            Long valueOf = (a2 == null || (size = a2.getSize()) == null) ? null : Long.valueOf(size.intValue());
            PostSubjectItem postSubjectItem5 = this.b.data;
            String postId = postSubjectItem5 != null ? postSubjectItem5.getPostId() : null;
            PostSubjectItem postSubjectItem6 = this.b.data;
            DownloadBean downloadBean = new DownloadBean(str6, str7, str5, str8, valueOf, postSubjectItem6 != null ? postSubjectItem6.getPostId() : null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, postId, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -134217792, -1, 65535, null);
            PostSubjectItem postSubjectItem7 = this.b.data;
            downloadBean.setThumbnail((postSubjectItem7 == null || (media = postSubjectItem7.getMedia()) == null || (cover = media.getCover()) == null) ? null : cover.getThumbnail());
            PostSubjectItem postSubjectItem8 = this.b.data;
            if (postSubjectItem8 == null || !postSubjectItem8.getBuiltIn()) {
                DownloadManagerApi a3 = DownloadManagerApi.j.a();
                Context context = this.b.getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                PostSubjectItem postSubjectItem9 = this.b.data;
                String ops = postSubjectItem9 != null ? postSubjectItem9.getOps() : null;
                PostSubjectItem postSubjectItem10 = this.b.data;
                DownloadManagerApi.P(a3, fragmentActivity, downloadBean, VideoFragment.PAGE_NAME, ops, (postSubjectItem10 == null || (subject = postSubjectItem10.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) ? BuildConfig.FLAVOR : resourceLink, (Subject) null, (String) null, 96, (Object) null);
            } else {
                this.b.Y(downloadBean);
            }
            com.transsion.postdetail.helper.a.a.i(this.b.data, VideoFragment.PAGE_NAME, this.b.pageFrom);
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

    public static final class f implements CommentFragment.b {
        f() {
        }

        @Override // com.transsion.postdetail.ui.fragment.CommentFragment.b
        public void a(long j) {
            Stat stat;
            PostSubjectItem postSubjectItem = ImmVideoItemView.this.data;
            if (postSubjectItem != null && (stat = postSubjectItem.getStat()) != null) {
                stat.setCommentCount(Long.valueOf(j));
            }
            ImmVideoItemView.this.e0(j);
        }
    }

    public static final class g implements ExpandView.c {
        final /* synthetic */ Ref.BooleanRef a;

        g(Ref.BooleanRef booleanRef) {
            this.a = booleanRef;
        }

        public void a(ExpandView expandView) {
            this.a.element = true;
        }

        public void b(ExpandView expandView) {
            this.a.element = false;
        }
    }

    public static final class h implements com.transsion.baseui.util.g {
        final /* synthetic */ Ref.ObjectRef a;

        h(Ref.ObjectRef objectRef) {
            this.a = objectRef;
        }

        @Override // com.transsion.baseui.util.g
        public void a(List list) {
            Intrinsics.h(list, "list");
            this.a.element = list;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmVideoItemView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmVideoItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImmVideoItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.TAG = "ImmVideoPlayer";
        this.commentId = BuildConfig.FLAVOR;
        this.loginApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.view.c
            public final Object invoke() {
                qx.a E;
                E = ImmVideoItemView.E();
                return E;
            }
        });
        this.screenHeight = com.blankj.utilcode.util.y.c();
        this.dp170 = com.blankj.utilcode.util.a0.a(170.0f);
        this.isSeekToFinish = new AtomicBoolean(true);
        this.attachToMain = true;
        this.screenWidth = com.blankj.utilcode.util.y.e();
        this.downloadListener = new b();
        this.downloadManager = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.view.i
            public final Object invoke() {
                com.transsnet.downloader.manager.g w;
                w = ImmVideoItemView.w();
                return w;
            }
        });
        this.favoriteResultObserver = new androidx.lifecycle.c0() { // from class: com.transsion.postdetail.ui.view.j
            public final void onChanged(Object obj) {
                ImmVideoItemView.x(ImmVideoItemView.this, (String) obj);
            }
        };
        View.inflate(getContext(), R$layout.layout_immersion_video_item_view, this);
        wn.t a2 = wn.t.a(this);
        Intrinsics.g(a2, "bind(...)");
        this.viewBinding = a2;
        a2.C.setOnClickListener(this);
        a2.x.setOnClickListener(this);
        a2.E.setOnClickListener(this);
        a2.o.setOnClickListener(this);
        a2.q.setOnClickListener(this);
        a2.r.b.setOnClickListener(this);
        a2.r.f.setOnClickListener(this);
        a2.F.setOnClickListener(this);
        a2.j.setOnClickListener(this);
        a2.p.setOnClickListener(this);
        a2.G.setOnClickListener(this);
        a2.d.setOnClickListener(this);
        this.resImgLargeWidth = com.blankj.utilcode.util.a0.a(48.0f);
        this.resImgLargeHeight = com.blankj.utilcode.util.a0.a(64.0f);
        this.resImgSmallWidth = com.blankj.utilcode.util.a0.a(24.0f);
        this.resImgSmallHeight = com.blankj.utilcode.util.a0.a(32.0f);
        B(context);
        if (ImmVideoHelper.h.a().h() > 0) {
            ConstraintLayout.b layoutParams = a2.v.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = layoutParams;
            if (((ViewGroup.MarginLayoutParams) bVar).bottomMargin < com.blankj.utilcode.util.a0.a(35.0f)) {
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin += com.blankj.utilcode.util.a0.a(10.0f);
                a2.v.setLayoutParams(bVar);
            }
        }
    }

    private final void A(CommentBean hotComment, PostSubjectItem item) {
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.base_net_err);
            return;
        }
        Boolean likeStatu = hotComment.getLikeStatu();
        Boolean bool = Boolean.TRUE;
        boolean c2 = Intrinsics.c(likeStatu, bool);
        AppCompatImageView appCompatImageView = this.viewBinding.m;
        if (appCompatImageView != null) {
            if (appCompatImageView.isEnabled()) {
                appCompatImageView.setEnabled(false);
                hotComment.setLikeStatu(Boolean.FALSE);
                if (hotComment.getLikeCnt() > 0) {
                    hotComment.setLikeCnt(hotComment.getLikeCnt() - 1);
                }
            } else {
                appCompatImageView.setEnabled(true);
                hotComment.setLikeStatu(bool);
                hotComment.setLikeCnt(hotComment.getLikeCnt() + 1);
            }
        }
        this.viewBinding.B.setText(hotComment.getLikeCnt() == 0 ? BuildConfig.FLAVOR : com.transsion.baseui.util.j.a(hotComment.getLikeCnt()));
        String commentId = hotComment.getCommentId();
        if (commentId != null) {
            X(c2 ? "dislike_hot_comment" : "like_hot_comment", item);
            CommentLikeBody commentLikeBody = new CommentLikeBody(commentId, Integer.valueOf(c2 ? 1 : 0));
            CommentViewModel commentViewModel = this.mCommentViewModel;
            if (commentViewModel != null) {
                commentViewModel.q(commentLikeBody);
            }
            rm.b bVar = new rm.b(!c2, commentId, hotComment.getLikeCnt());
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = rm.b.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, bVar, 0L);
        }
    }

    private final void B(Context context) {
        this.gestureDetector = new GestureDetector(context, new c());
        L();
        I();
        C();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C() {
        new com.transsion.baseui.widget.f(getContext(), this.viewBinding.J).s(new d());
        this.viewBinding.w.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.postdetail.ui.view.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean D;
                D = ImmVideoItemView.D(view, motionEvent);
                return D;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a E() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(View view) {
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        UserInfo userInfo = new UserInfo();
        PostSubjectItem postSubjectItem = this.data;
        User user = postSubjectItem != null ? postSubjectItem.getUser() : null;
        userInfo.setUserId(user != null ? user.getUserId() : null);
        userInfo.setNickname(user != null ? user.getNickname() : null);
        userInfo.setUsername(user != null ? user.getUsername() : null);
        userInfo.setAvatar(user != null ? user.getAvatar() : null);
        Navigator.x(TheRouter.c("/profile/user_profile").K("userId", userInfo.getUserId()), getContext(), (mf.c) null, 2, (Object) null);
        com.transsion.postdetail.helper.a.a.c(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G(View view) {
        Group group;
        Integer num;
        FragmentActivity requireActivity;
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        String c2 = sg.b.b.a().c();
        ep.f fVar = (ep.f) TheRouter.d(ep.f.class, new Object[0]);
        if (!TextUtils.equals(c2, fVar != null ? fVar.d() : null) || (num = this.position) == null || num.intValue() != 0) {
            Navigator c3 = TheRouter.c("/room/detail");
            PostSubjectItem postSubjectItem = this.data;
            Navigator.x(c3.K("id", (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null) ? null : group.getGroupId()), getContext(), (mf.c) null, 2, (Object) null);
            com.transsion.postdetail.helper.a.a.l(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
            return;
        }
        Fragment fragment = this.fragment;
        if (fragment == null || (requireActivity = fragment.requireActivity()) == null) {
            return;
        }
        requireActivity.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H(View view) {
        Subject subject;
        Subject subject2;
        Integer subjectType;
        Subject subject3;
        Subject subject4;
        Integer num;
        FragmentActivity requireActivity;
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        String c2 = sg.b.b.a().c();
        com.transsion.moviedetailapi.g gVar = (com.transsion.moviedetailapi.g) TheRouter.d(com.transsion.moviedetailapi.g.class, new Object[0]);
        if (TextUtils.equals(c2, gVar != null ? gVar.d() : null) && (num = this.position) != null && num.intValue() == 0) {
            Fragment fragment = this.fragment;
            if (fragment == null || (requireActivity = fragment.requireActivity()) == null) {
                return;
            }
            requireActivity.finish();
            return;
        }
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem != null && (subject3 = postSubjectItem.getSubject()) != null) {
            Integer subjectType2 = subject3.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType2 != null && subjectType2.intValue() == value) {
                DownloadManagerApi a2 = DownloadManagerApi.j.a();
                FragmentActivity context = getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = context;
                PostSubjectItem postSubjectItem2 = this.data;
                String ops = (postSubjectItem2 == null || (subject4 = postSubjectItem2.getSubject()) == null) ? null : subject4.getOps();
                PostSubjectItem postSubjectItem3 = this.data;
                DownloadManagerApi.e0(a2, fragmentActivity, VideoFragment.PAGE_NAME, BuildConfig.FLAVOR, ops, "download_subject", false, postSubjectItem3 != null ? postSubjectItem3.getSubject() : null, (String) null, (Boolean) null, 384, (Object) null);
                com.transsion.postdetail.helper.a.a.B(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
            }
        }
        Navigator c3 = TheRouter.c("/movie/detail");
        PostSubjectItem postSubjectItem4 = this.data;
        Navigator F = c3.F("subject_type", (postSubjectItem4 == null || (subject2 = postSubjectItem4.getSubject()) == null || (subjectType = subject2.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
        PostSubjectItem postSubjectItem5 = this.data;
        Navigator K = F.K("id", (postSubjectItem5 == null || (subject = postSubjectItem5.getSubject()) == null) ? null : subject.getSubjectId());
        PostSubjectItem postSubjectItem6 = this.data;
        Navigator.x(K.K("ops", postSubjectItem6 != null ? postSubjectItem6.getOps() : null), getContext(), (mf.c) null, 2, (Object) null);
        com.transsion.postdetail.helper.a.a.B(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void I() {
        AppCompatActivity context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity appCompatActivity = context;
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.view.e
            public final Object invoke(Object obj) {
                Unit J;
                J = ImmVideoItemView.J(ImmVideoItemView.this, (AddToDownloadEvent) obj);
                return J;
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus applicationScopeViewModel = appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        applicationScopeViewModel.observeEvent(appCompatActivity, name, state, kotlinx.coroutines.y0.c().p(), false, function1);
        AppCompatActivity context2 = getContext();
        Intrinsics.f(context2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function12 = new Function1() { // from class: com.transsion.postdetail.ui.view.f
            public final Object invoke(Object obj) {
                Unit K;
                K = ImmVideoItemView.K(ImmVideoItemView.this, (hx.c) obj);
                return K;
            }
        };
        FlowEventBus applicationScopeViewModel2 = appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = hx.c.class.getName();
        Intrinsics.g(name2, "getName(...)");
        applicationScopeViewModel2.observeEvent(context2, name2, state, kotlinx.coroutines.y0.c().p(), false, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(ImmVideoItemView immVideoItemView, AddToDownloadEvent addToDownloadEvent) {
        Subject subject;
        Intrinsics.h(addToDownloadEvent, "value");
        try {
            String subjectId = addToDownloadEvent.getSubjectId();
            PostSubjectItem postSubjectItem = immVideoItemView.data;
            if (!TextUtils.equals(subjectId, (postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null) ? null : subject.getSubjectId())) {
                return Unit.a;
            }
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(ImmVideoItemView immVideoItemView, hx.c cVar) {
        String c2;
        PostSubjectItem postSubjectItem;
        Subject subject;
        ShortTVFavInfo shortTVFavInfo;
        Subject subject2;
        Intrinsics.h(cVar, "value");
        try {
            c2 = cVar.c();
            postSubjectItem = immVideoItemView.data;
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        if (!TextUtils.equals(c2, (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null) ? null : subject2.getSubjectId())) {
            return Unit.a;
        }
        PostSubjectItem postSubjectItem2 = immVideoItemView.data;
        if (postSubjectItem2 != null && (subject = postSubjectItem2.getSubject()) != null && (shortTVFavInfo = subject.getShortTVFavInfo()) != null) {
            shortTVFavInfo.setFavoriteNum(cVar.b());
            shortTVFavInfo.setHasFavorite(cVar.a());
        }
        immVideoItemView.viewBinding.y.setSelected(cVar.a());
        AppCompatTextView appCompatTextView = immVideoItemView.viewBinding.y;
        String b2 = cVar.b();
        appCompatTextView.setText(com.transsion.baseui.util.j.a(b2 != null ? Long.parseLong(b2) : 0L));
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L() {
        AppCompatActivity context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.view.h
            public final Object invoke(Object obj) {
                Unit M;
                M = ImmVideoItemView.M(ImmVideoItemView.this, (LikeEvent) obj);
                return M;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LikeEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(context, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(ImmVideoItemView immVideoItemView, LikeEvent likeEvent) {
        String subjectId;
        PostSubjectItem postSubjectItem;
        Stat stat;
        Stat stat2;
        Long likeCount;
        Stat stat3;
        Stat stat4;
        Long likeCount2;
        Intrinsics.h(likeEvent, "value");
        try {
            subjectId = likeEvent.getSubjectId();
            postSubjectItem = immVideoItemView.data;
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        if (!TextUtils.equals(subjectId, postSubjectItem != null ? postSubjectItem.getPostId() : null)) {
            return Unit.a;
        }
        PostSubjectItem postSubjectItem2 = immVideoItemView.data;
        if (postSubjectItem2 != null) {
            postSubjectItem2.setHasLike(Boolean.valueOf(likeEvent.getLike()));
        }
        if (likeEvent.getLike()) {
            PostSubjectItem postSubjectItem3 = immVideoItemView.data;
            if (postSubjectItem3 != null && (stat3 = postSubjectItem3.getStat()) != null) {
                PostSubjectItem postSubjectItem4 = immVideoItemView.data;
                stat3.setLikeCount((postSubjectItem4 == null || (stat4 = postSubjectItem4.getStat()) == null || (likeCount2 = stat4.getLikeCount()) == null) ? null : Long.valueOf(likeCount2.longValue() + 1));
            }
        } else {
            PostSubjectItem postSubjectItem5 = immVideoItemView.data;
            if (postSubjectItem5 != null && (stat = postSubjectItem5.getStat()) != null) {
                PostSubjectItem postSubjectItem6 = immVideoItemView.data;
                stat.setLikeCount((postSubjectItem6 == null || (stat2 = postSubjectItem6.getStat()) == null || (likeCount = stat2.getLikeCount()) == null) ? null : Long.valueOf(likeCount.longValue() - 1));
            }
        }
        PostSubjectItem postSubjectItem7 = immVideoItemView.data;
        if (postSubjectItem7 != null) {
            immVideoItemView.i0(postSubjectItem7);
        }
        return Unit.a;
    }

    private final void N(View view) {
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        showCommentDialog();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O(View view) {
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        if (!yg.l.a.e()) {
            fh.b.a.d(com.tn.lib.widget.R.string.no_network_tips);
            return;
        }
        PostSubjectItem postSubjectItem = this.data;
        int c2 = postSubjectItem != null ? Intrinsics.c(postSubjectItem.getHasLike(), Boolean.TRUE) : 0;
        PostDetailViewModel postDetailViewModel = this.videoDetailModel;
        if (postDetailViewModel != null) {
            PostSubjectItem postSubjectItem2 = this.data;
            postDetailViewModel.G(postSubjectItem2 != null ? postSubjectItem2.getPostId() : null, c2);
        }
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.a;
        PostSubjectItem postSubjectItem3 = this.data;
        aVar.o(postSubjectItem3, postSubjectItem3 != null ? Intrinsics.c(postSubjectItem3.getHasLike(), Boolean.TRUE) : false, VideoFragment.PAGE_NAME, this.pageFrom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P(long progress) {
        Boolean bool = this.videoLoadMore;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.c(bool, bool2)) {
            ImmVideoHelper.a aVar = ImmVideoHelper.h;
            if (aVar.a().n() && progress >= 1000) {
                aVar.a().t();
                ImmVideoGuideView a2 = ImmVideoGuideView.INSTANCE.a(this);
                a2.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.view.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImmVideoItemView.Q(ImmVideoItemView.this);
                    }
                }, 5000L);
                this.guideView = a2;
                return;
            }
        }
        if (Intrinsics.c(this.videoLoadMore, bool2) && Intrinsics.c(this.pageFrom, "Trending")) {
            ImmVideoHelper.a aVar2 = ImmVideoHelper.h;
            if (!aVar2.a().o() || progress < 1000) {
                return;
            }
            aVar2.a().u();
            ImmVideoGuideView a3 = ImmVideoGuideView.INSTANCE.a(this);
            a3.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.view.q
                @Override // java.lang.Runnable
                public final void run() {
                    ImmVideoItemView.R(ImmVideoItemView.this);
                }
            }, 5000L);
            this.guideView = a3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(ImmVideoItemView immVideoItemView) {
        ImmVideoGuideView immVideoGuideView = immVideoItemView.guideView;
        if (immVideoGuideView != null) {
            immVideoGuideView.removeGuide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(ImmVideoItemView immVideoItemView) {
        ImmVideoGuideView immVideoGuideView = immVideoItemView.guideView;
        if (immVideoGuideView != null) {
            immVideoGuideView.removeGuide();
        }
    }

    private final void S(View view) {
        PostSubjectItem postSubjectItem;
        DownloadBean G;
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L) || (postSubjectItem = this.data) == null || (G = DownloadUtil.a.G(postSubjectItem)) == null) {
            return;
        }
        DownloadEsHelper a2 = DownloadEsHelper.m.a();
        String resourceId = G.getResourceId();
        if (resourceId == null) {
            resourceId = BuildConfig.FLAVOR;
        }
        DownloadBean q = a2.q(resourceId);
        if (q == null || q.getStatus() != 5) {
            com.transsion.baseui.util.m.c(R.string.shorts_click_download);
            com.transsion.postdetail.helper.a.a.i(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
            getDownloadManager().p(G);
            j0();
        }
    }

    private final void T(View view) {
        Fragment fragment;
        FragmentManager childFragmentManager;
        ShareDialogFragment shareDialogFragment;
        Integer subjectRate;
        User user;
        User user2;
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        com.transsion.postdetail.helper.a.a.z(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
        if (this.mShareDialog == null) {
            qx.a loginApi = getLoginApi();
            UserInfo i = loginApi != null ? loginApi.i() : null;
            PostSubjectItem postSubjectItem = this.data;
            boolean equals = TextUtils.equals((postSubjectItem == null || (user2 = postSubjectItem.getUser()) == null) ? null : user2.getUserId(), i != null ? i.getUserId() : null);
            ShareDialogFragment.Companion companion = ShareDialogFragment.INSTANCE;
            PostType postType = PostType.POST_TYPE;
            PostSubjectItem postSubjectItem2 = this.data;
            String postId = postSubjectItem2 != null ? postSubjectItem2.getPostId() : null;
            PostSubjectItem postSubjectItem3 = this.data;
            String userId = (postSubjectItem3 == null || (user = postSubjectItem3.getUser()) == null) ? null : user.getUserId();
            String value = ReportType.POST.getValue();
            PostSubjectItem postSubjectItem4 = this.data;
            String title = postSubjectItem4 != null ? postSubjectItem4.getTitle() : null;
            PostSubjectItem postSubjectItem5 = this.data;
            String num = (postSubjectItem5 == null || (subjectRate = postSubjectItem5.getSubjectRate()) == null) ? null : subjectRate.toString();
            PostSubjectItem postSubjectItem6 = this.data;
            ShareDialogFragment a2 = companion.a(postType, postId, userId, value, title, num, false, equals, false, "postdetail", postSubjectItem6 != null ? postSubjectItem6.getOps() : null, view.getContext().getString(R.string.save_video));
            this.mShareDialog = a2;
            if (a2 != null) {
                a2.G0(new e(view, this));
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
    public final void U() {
        AppCompatImageView appCompatImageView = this.viewBinding.e;
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
    public static final void V(ImmVideoItemView immVideoItemView) {
        com.transsion.player.orplayer.f fVar;
        Fragment fragment = immVideoItemView.fragment;
        if (fragment == null || !fragment.isVisible() || (fVar = immVideoItemView.orPlayer) == null) {
            return;
        }
        fVar.play();
    }

    private final void W(PostSubjectItem item) {
        String str;
        String str2;
        String str3;
        String str4;
        String value;
        Integer subjectType;
        String postId = item.getPostId();
        String str5 = BuildConfig.FLAVOR;
        if (postId == null) {
            postId = BuildConfig.FLAVOR;
        }
        Pair a2 = TuplesKt.a("post_id", postId);
        Pair a3 = TuplesKt.a("page_from", this.pageFrom);
        Pair a4 = TuplesKt.a("module_name", "hot_comment");
        Pair a5 = TuplesKt.a("is_cache_post", String.valueOf(item.isRoomCache()));
        User user = item.getUser();
        if (user == null || (str = user.getUserId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        Pair a6 = TuplesKt.a("user_id", str);
        Group group = item.getGroup();
        if (group == null || (str2 = group.getGroupId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        Pair a7 = TuplesKt.a("group_id", str2);
        Subject subject = item.getSubject();
        if (subject == null || (str3 = subject.getSubjectId()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        Pair a8 = TuplesKt.a("subject_id", str3);
        Subject subject2 = item.getSubject();
        if (subject2 == null || (subjectType = subject2.getSubjectType()) == null || (str4 = subjectType.toString()) == null) {
            str4 = BuildConfig.FLAVOR;
        }
        Pair a9 = TuplesKt.a("subject_type", str4);
        Pair a10 = TuplesKt.a("builtin", item.getBuiltIn() ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        Media media = item.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        Pair a11 = TuplesKt.a("post_media_type", value);
        String ops = item.getOps();
        if (ops != null) {
            str5 = ops;
        }
        qi.h.a.z(VideoFragment.PAGE_NAME, MapsKt.m(new Pair[]{a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, TuplesKt.a("ops", str5)}));
    }

    private final void X(String moduleName, PostSubjectItem item) {
        String str;
        String value;
        String groupId;
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        CommentBean hotComment = item.getHotComment();
        String str2 = BuildConfig.FLAVOR;
        if (hotComment == null || (str = hotComment.getCommentId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("comment_id", str);
        String postId = item.getPostId();
        if (postId == null) {
            postId = BuildConfig.FLAVOR;
        }
        hashMap.put("post_id", postId);
        String ops = item.getOps();
        if (ops == null) {
            ops = BuildConfig.FLAVOR;
        }
        hashMap.put("ops", ops);
        Group group = item.getGroup();
        if (group != null && (groupId = group.getGroupId()) != null) {
            str2 = groupId;
        }
        hashMap.put("group_id", str2);
        Media media = item.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value);
        String str3 = this.pageFrom;
        if (str3 != null && str3.length() != 0) {
            String str4 = this.pageFrom;
            Intrinsics.e(str4);
            hashMap.put("page_from", str4);
        }
        com.transsion.baselib.helper.a.a.i(VideoFragment.PAGE_NAME, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(DownloadBean download) {
        kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), (CoroutineContext) null, (CoroutineStart) null, new ImmVideoItemView$saveBuiltInVideo$1(download, null), 3, (Object) null);
    }

    private static final PostDetailViewModel Z(Lazy lazy) {
        return (PostDetailViewModel) lazy.getValue();
    }

    private static final ShortTvPlayListViewModel a0(Lazy lazy) {
        return (ShortTvPlayListViewModel) lazy.getValue();
    }

    private static final CommentViewModel b0(Lazy lazy) {
        return (CommentViewModel) lazy.getValue();
    }

    private final void c0(View view) {
        ObjectAnimator objectAnimator = this.rotateAnimator;
        if (objectAnimator != null) {
            Intrinsics.e(objectAnimator);
            if (objectAnimator.isRunning()) {
                return;
            }
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
        ofFloat.setDuration(800L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
        this.rotateAnimator = ofFloat;
    }

    private final void d0(View view) {
        ObjectAnimator objectAnimator = this.rotateAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.rotateAnimator = null;
        view.setRotation(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(long comment) {
        this.viewBinding.x.setText(com.transsion.baseui.util.j.a(comment));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f0(final PostSubjectItem item) {
        String url;
        Subject subject;
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                BLConstraintLayout bLConstraintLayout = this.viewBinding.d;
                Intrinsics.g(bLConstraintLayout, "clHotComment");
                uf.c.g(bLConstraintLayout);
                return;
            }
        }
        final CommentBean hotComment = item.getHotComment();
        String content = hotComment != null ? hotComment.getContent() : null;
        if (content == null || content.length() == 0) {
            BLConstraintLayout bLConstraintLayout2 = this.viewBinding.d;
            Intrinsics.g(bLConstraintLayout2, "clHotComment");
            uf.c.g(bLConstraintLayout2);
            NestedScrollableHost nestedScrollableHost = this.viewBinding.t;
            Intrinsics.g(nestedScrollableHost, "nsPostDes");
            uf.c.k(nestedScrollableHost);
            return;
        }
        W(item);
        BLConstraintLayout bLConstraintLayout3 = this.viewBinding.d;
        Intrinsics.g(bLConstraintLayout3, "clHotComment");
        uf.c.k(bLConstraintLayout3);
        NestedScrollableHost nestedScrollableHost2 = this.viewBinding.t;
        Intrinsics.g(nestedScrollableHost2, "nsPostDes");
        uf.c.g(nestedScrollableHost2);
        this.viewBinding.z.setText(content);
        String avatarUrl = hotComment.getAvatarUrl();
        String str = BuildConfig.FLAVOR;
        if (avatarUrl == null) {
            avatarUrl = BuildConfig.FLAVOR;
        }
        if (avatarUrl.length() > 0) {
            f.a aVar = ni.f.a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b c2 = aVar.m(context).g(avatarUrl).m(lj.a.b(20)).c(lj.a.b(20));
            ShapeableImageView shapeableImageView = this.viewBinding.k;
            Intrinsics.g(shapeableImageView, "ivHotCommentAvatar");
            c2.d(shapeableImageView);
        }
        this.viewBinding.B.setText(hotComment.getLikeCnt() == 0 ? BuildConfig.FLAVOR : com.transsion.baseui.util.j.a(hotComment.getLikeCnt()));
        this.viewBinding.m.setEnabled(Intrinsics.c(hotComment.getLikeStatu(), Boolean.TRUE));
        List<Cover> imageList = hotComment.getImageList();
        if (imageList == null || imageList.isEmpty()) {
            ShapeableImageView shapeableImageView2 = this.viewBinding.f;
            Intrinsics.g(shapeableImageView2, "commentCover");
            uf.c.g(shapeableImageView2);
        } else {
            ImageView imageView = this.viewBinding.f;
            imageView.setVisibility(0);
            f.a aVar2 = ni.f.a;
            Context context2 = imageView.getContext();
            Intrinsics.g(context2, "getContext(...)");
            f.b m = aVar2.m(context2);
            List<Cover> imageList2 = hotComment.getImageList();
            Intrinsics.e(imageList2);
            Cover cover = imageList2.get(0);
            if (cover != null && (url = cover.getUrl()) != null) {
                str = url;
            }
            f.b g2 = m.g(str);
            Intrinsics.e(imageView);
            g2.d(imageView);
            Intrinsics.e(imageView);
        }
        this.viewBinding.I.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImmVideoItemView.g0(ImmVideoItemView.this, hotComment, item, view);
            }
        });
        AppCompatActivity context3 = getContext();
        Intrinsics.f(context3, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.view.m
            public final Object invoke(Object obj) {
                Unit h0;
                h0 = ImmVideoItemView.h0(CommentBean.this, this, (rm.b) obj);
                return h0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = rm.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(context3, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(ImmVideoItemView immVideoItemView, CommentBean commentBean, PostSubjectItem postSubjectItem, View view) {
        immVideoItemView.A(commentBean, postSubjectItem);
    }

    private final com.transsnet.downloader.manager.g getDownloadManager() {
        return (com.transsnet.downloader.manager.g) this.downloadManager.getValue();
    }

    private final qx.a getLoginApi() {
        return (qx.a) this.loginApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(CommentBean commentBean, ImmVideoItemView immVideoItemView, rm.b bVar) {
        Intrinsics.h(bVar, "value");
        if (Intrinsics.c(bVar.a(), commentBean.getCommentId())) {
            commentBean.setLikeStatu(Boolean.valueOf(bVar.c()));
            commentBean.setLikeCnt(bVar.b());
            immVideoItemView.viewBinding.B.setText(bVar.b() == 0 ? BuildConfig.FLAVOR : com.transsion.baseui.util.j.a(bVar.b()));
            immVideoItemView.viewBinding.m.setEnabled(bVar.c());
        }
        return Unit.a;
    }

    private final void i0(PostSubjectItem item) {
        Long likeCount;
        AppCompatTextView appCompatTextView = this.viewBinding.C;
        Boolean hasLike = item.getHasLike();
        appCompatTextView.setSelected(hasLike != null ? hasLike.booleanValue() : false);
        Stat stat = item.getStat();
        String a2 = com.transsion.baseui.util.j.a((stat == null || (likeCount = stat.getLikeCount()) == null) ? 0L : likeCount.longValue());
        if (Intrinsics.c(a2, "0")) {
            a2 = BuildConfig.FLAVOR;
        }
        appCompatTextView.setText(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        final String postId;
        AppCompatImageView appCompatImageView;
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem == null || (postId = postSubjectItem.getPostId()) == null || (appCompatImageView = this.viewBinding.o) == null) {
            return;
        }
        DownloadBean q = DownloadEsHelper.m.a().q(postId);
        if (q == null) {
            d0(appCompatImageView);
            appCompatImageView.setImageResource(R$mipmap.post_detail_ic_video_download_new);
            appCompatImageView.setEnabled(true);
            appCompatImageView.setOnClickListener(this);
            return;
        }
        int status = q.getStatus();
        if (status == 1 || status == 2 || status == 3) {
            appCompatImageView.setImageResource(R$drawable.post_detail_ic_video_downloading);
            appCompatImageView.setEnabled(false);
            c0(appCompatImageView);
        } else {
            if (status != 5) {
                d0(appCompatImageView);
                appCompatImageView.setImageResource(R$mipmap.post_detail_ic_video_download_new);
                appCompatImageView.setEnabled(true);
                appCompatImageView.setOnClickListener(this);
                return;
            }
            d0(appCompatImageView);
            appCompatImageView.setImageResource(R$drawable.post_detail_ic_video_downloaded);
            appCompatImageView.setEnabled(true);
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImmVideoItemView.k0(ImmVideoItemView.this, postId, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void k0(ImmVideoItemView immVideoItemView, String str, View view) {
        com.transsion.postdetail.helper.a.a.k(immVideoItemView.data, VideoFragment.PAGE_NAME, immVideoItemView.pageFrom);
        Navigator.x(TheRouter.c("/download/panel_activity").F("extra_page_index", 0).K("extra_target_resource_id", str), immVideoItemView.getContext(), (mf.c) null, 2, (Object) null);
    }

    private final void l0(long share) {
        this.viewBinding.E.setText(com.transsion.baseui.util.j.a(share));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m0() {
        Subject subject;
        Subject subject2;
        Cover cover;
        String url;
        String str;
        Subject subject3;
        Cover cover2;
        Subject subject4;
        Subject subject5;
        Subject subject6;
        Subject subject7;
        ShortTVItem shortTVFirstEp;
        Subject subject8;
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                BLLinearLayout root = this.viewBinding.r.getRoot();
                Intrinsics.g(root, "getRoot(...)");
                uf.c.g(root);
                ShapeableImageView shapeableImageView = this.viewBinding.q;
                Intrinsics.g(shapeableImageView, "ivVideoAvatar");
                uf.c.g(shapeableImageView);
                AppCompatImageView appCompatImageView = this.viewBinding.j;
                Intrinsics.g(appCompatImageView, "ivDownload");
                uf.c.k(appCompatImageView);
                AppCompatTextView appCompatTextView = this.viewBinding.G;
                Intrinsics.g(appCompatTextView, "tvTitle");
                uf.c.k(appCompatTextView);
                BLTextView bLTextView = this.viewBinding.F;
                Intrinsics.g(bLTextView, "tvShortTvEp");
                uf.c.k(bLTextView);
                ShapeableImageView shapeableImageView2 = this.viewBinding.p;
                Intrinsics.g(shapeableImageView2, "ivShortCover");
                uf.c.k(shapeableImageView2);
                AppCompatTextView appCompatTextView2 = this.viewBinding.G;
                PostSubjectItem postSubjectItem2 = this.data;
                ShortTVFavInfo shortTVFavInfo = null;
                appCompatTextView2.setText((postSubjectItem2 == null || (subject8 = postSubjectItem2.getSubject()) == null) ? null : subject8.getTitle());
                com.transsion.postdetail.util.s sVar = com.transsion.postdetail.util.s.a;
                PostSubjectItem postSubjectItem3 = this.data;
                sVar.a(Integer.valueOf((postSubjectItem3 == null || (subject7 = postSubjectItem3.getSubject()) == null || (shortTVFirstEp = subject7.getShortTVFirstEp()) == null) ? 1 : shortTVFirstEp.getEp()));
                PostSubjectItem postSubjectItem4 = this.data;
                this.viewBinding.F.setText(getContext().getString(R.string.short_tv_play_all, sVar.a(Integer.valueOf((postSubjectItem4 == null || (subject6 = postSubjectItem4.getSubject()) == null) ? 0 : subject6.getTotalEpisode()))));
                com.transsion.baseui.widget.jumpingbeans.a.a(this.viewBinding.F).e(0, this.viewBinding.F.getText().toString().length()).g(true).i(100).f(0.05f).h(10000).a();
                ShapeableImageView shapeableImageView3 = this.viewBinding.p;
                PostSubjectItem postSubjectItem5 = this.data;
                if (postSubjectItem5 == null || !postSubjectItem5.getBuiltIn()) {
                    PostSubjectItem postSubjectItem6 = this.data;
                    if (postSubjectItem6 != null && (subject2 = postSubjectItem6.getSubject()) != null && (cover = subject2.getCover()) != null && (url = cover.getUrl()) != null) {
                        f.a aVar = ni.f.a;
                        Context context = getContext();
                        Intrinsics.g(context, "getContext(...)");
                        f.b c2 = aVar.m(context).g(url).m(com.blankj.utilcode.util.i.e(21.0f)).c(com.blankj.utilcode.util.i.e(30.0f));
                        PostSubjectItem postSubjectItem7 = this.data;
                        if (postSubjectItem7 == null || (subject3 = postSubjectItem7.getSubject()) == null || (cover2 = subject3.getCover()) == null || (str = cover2.getThumbnail()) == null) {
                            str = BuildConfig.FLAVOR;
                        }
                        f.b h2 = c2.l(str).h(true);
                        ShapeableImageView shapeableImageView4 = this.viewBinding.p;
                        Intrinsics.g(shapeableImageView4, "ivShortCover");
                        h2.d(shapeableImageView4);
                    }
                } else {
                    kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), (CoroutineContext) null, (CoroutineStart) null, new ImmVideoItemView$updateShortTVInfo$1(this, null), 3, (Object) null);
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                PostSubjectItem postSubjectItem8 = this.data;
                if (postSubjectItem8 != null && (subject5 = postSubjectItem8.getSubject()) != null) {
                    shortTVFavInfo = subject5.getShortTVFavInfo();
                }
                objectRef.element = shortTVFavInfo;
                if (shortTVFavInfo == null) {
                    ShortTVFavInfo shortTVFavInfo2 = new ShortTVFavInfo((String) null, false, (String) null, 7, (DefaultConstructorMarker) null);
                    shortTVFavInfo2.setFavoriteNum("0");
                    objectRef.element = shortTVFavInfo2;
                    PostSubjectItem postSubjectItem9 = this.data;
                    if (postSubjectItem9 != null && (subject4 = postSubjectItem9.getSubject()) != null) {
                        subject4.setShortTVFavInfo((ShortTVFavInfo) objectRef.element);
                    }
                }
                AppCompatTextView appCompatTextView3 = this.viewBinding.y;
                Intrinsics.g(appCompatTextView3, "tvFavorite");
                uf.c.k(appCompatTextView3);
                this.viewBinding.y.setSelected(((ShortTVFavInfo) objectRef.element).getHasFavorite());
                AppCompatTextView appCompatTextView4 = this.viewBinding.y;
                String favoriteNum = ((ShortTVFavInfo) objectRef.element).getFavoriteNum();
                appCompatTextView4.setText(com.transsion.baseui.util.j.a(Long.parseLong(favoriteNum != null ? favoriteNum : "0")));
                this.viewBinding.y.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ImmVideoItemView.n0(ImmVideoItemView.this, objectRef, view);
                    }
                });
                return;
            }
        }
        AppCompatTextView appCompatTextView5 = this.viewBinding.G;
        Intrinsics.g(appCompatTextView5, "tvTitle");
        uf.c.g(appCompatTextView5);
        BLTextView bLTextView2 = this.viewBinding.F;
        Intrinsics.g(bLTextView2, "tvShortTvEp");
        uf.c.g(bLTextView2);
        ShapeableImageView shapeableImageView5 = this.viewBinding.p;
        Intrinsics.g(shapeableImageView5, "ivShortCover");
        uf.c.g(shapeableImageView5);
        AppCompatImageView appCompatImageView2 = this.viewBinding.j;
        Intrinsics.g(appCompatImageView2, "ivDownload");
        uf.c.g(appCompatImageView2);
        ShapeableImageView shapeableImageView6 = this.viewBinding.q;
        Intrinsics.g(shapeableImageView6, "ivVideoAvatar");
        uf.c.k(shapeableImageView6);
        AppCompatTextView appCompatTextView6 = this.viewBinding.y;
        Intrinsics.g(appCompatTextView6, "tvFavorite");
        uf.c.g(appCompatTextView6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(ImmVideoItemView immVideoItemView, Ref.ObjectRef objectRef, View view) {
        Subject subject;
        Subject subject2;
        com.transsion.postdetail.shorttv.k kVar = com.transsion.postdetail.shorttv.k.a;
        PostSubjectItem postSubjectItem = immVideoItemView.data;
        String subjectId = (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null) ? null : subject2.getSubjectId();
        PostSubjectItem postSubjectItem2 = immVideoItemView.data;
        kVar.c(subjectId, (postSubjectItem2 == null || (subject = postSubjectItem2.getSubject()) == null) ? null : subject.getOps(), BuildConfig.FLAVOR, ((ShortTVFavInfo) objectRef.element).getHasFavorite(), VideoFragment.PAGE_NAME, immVideoItemView.pageFrom);
        ShortTvPlayListViewModel shortTvPlayListViewModel = immVideoItemView.shortTvPlayListViewModel;
        if (shortTvPlayListViewModel != null) {
            PostSubjectItem postSubjectItem3 = immVideoItemView.data;
            shortTvPlayListViewModel.d(postSubjectItem3 != null ? postSubjectItem3.getSubject() : null);
        }
    }

    private final void o0(PostSubjectItem item) {
        setBottomSubjectAndRoomVisibility(item.getSubject() != null, item.getGroup() != null);
        if (item.getSubject() != null) {
            setBottomSubjectModuleData(item);
        }
        if (item.getGroup() != null) {
            Group group = item.getGroup();
            String name = group != null ? group.getName() : null;
            if (name == null || name.length() == 0) {
                return;
            }
            setBottomRoomModuleData(item);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void p0(final PostSubjectItem item) {
        String str;
        FirstFrame firstFrame;
        String url;
        String str2;
        Subject subject;
        Subject subject2;
        FirstFrame firstFrame2;
        String str3 = null;
        if (item.getBuiltIn()) {
            kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), (CoroutineContext) null, (CoroutineStart) null, new ImmVideoItemView$updateVideoInfo$1(item, this, null), 3, (Object) null);
            kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), (CoroutineContext) null, (CoroutineStart) null, new ImmVideoItemView$updateVideoInfo$2(item, this, null), 3, (Object) null);
            a.a aVar = wf.a.a;
            String str4 = this.TAG;
            Media media = item.getMedia();
            String url2 = (media == null || (firstFrame2 = media.getFirstFrame()) == null) ? null : firstFrame2.getUrl();
            User user = item.getUser();
            a.a.f(aVar, str4, "set info - firstFrame = " + url2 + ", avatar = " + (user != null ? user.getAvatar() : null), false, 4, (Object) null);
        } else {
            Media media2 = item.getMedia();
            if (media2 != null && (firstFrame = media2.getFirstFrame()) != null && (url = firstFrame.getUrl()) != null) {
                Glide.with(getContext()).load(f.a.e(ni.f.a, url, sm.b.e.a(), false, false, 12, null)).into(this.viewBinding.i);
            }
            f.a aVar2 = ni.f.a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar2.m(context);
            User user2 = item.getUser();
            if (user2 == null || (str = user2.getAvatar()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b c2 = m.g(str).m(this.viewBinding.q.getWidth()).c(this.viewBinding.q.getHeight());
            ShapeableImageView shapeableImageView = this.viewBinding.q;
            Intrinsics.g(shapeableImageView, "ivVideoAvatar");
            c2.d(shapeableImageView);
        }
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem != null && (subject2 = postSubjectItem.getSubject()) != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                this.viewBinding.G.setTextSize(18.0f);
                NestedScrollableHost nestedScrollableHost = this.viewBinding.t;
                Intrinsics.g(nestedScrollableHost, "nsPostDes");
                uf.c.g(nestedScrollableHost);
                AppCompatImageView appCompatImageView = this.viewBinding.o;
                Intrinsics.g(appCompatImageView, "ivSave");
                uf.c.g(appCompatImageView);
                return;
            }
        }
        NestedScrollableHost nestedScrollableHost2 = this.viewBinding.t;
        Intrinsics.g(nestedScrollableHost2, "nsPostDes");
        uf.c.k(nestedScrollableHost2);
        AppCompatImageView appCompatImageView2 = this.viewBinding.o;
        Intrinsics.g(appCompatImageView2, "ivSave");
        uf.c.k(appCompatImageView2);
        j0();
        this.viewBinding.G.setTextSize(16.0f);
        final ExpandView expandView = this.viewBinding.g;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        expandView.setExpandListener(new g(booleanRef));
        if (TextUtils.isEmpty(item.getTitle())) {
            String content = item.getContent();
            if (content != null) {
                str2 = StringsKt.n1(content).toString();
            }
            str2 = null;
        } else if (TextUtils.isEmpty(item.getContent())) {
            String title = item.getTitle();
            if (title != null) {
                str2 = StringsKt.n1(title).toString();
            }
            str2 = null;
        } else {
            String title2 = item.getTitle();
            String obj = title2 != null ? StringsKt.n1(title2).toString() : null;
            String content2 = item.getContent();
            str2 = obj + "\n" + (content2 != null ? StringsKt.n1(content2).toString() : null);
        }
        PostSubjectItem postSubjectItem2 = this.data;
        if (postSubjectItem2 != null && (subject = postSubjectItem2.getSubject()) != null) {
            Integer subjectType2 = subject.getSubjectType();
            int value2 = SubjectType.SHORT_TV.getValue();
            if (subjectType2 != null && subjectType2.intValue() == value2) {
                Subject subject3 = item.getSubject();
                if (subject3 != null) {
                    str3 = subject3.getDescription();
                }
                if (TextUtils.isEmpty(str3)) {
                    Intrinsics.e(expandView);
                    uf.c.k(expandView);
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    expandView.setTitle(com.transsion.baseui.util.l.b(expandView, str3, false, new h(objectRef), new Function2() { // from class: com.transsion.postdetail.ui.view.k
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit q0;
                            q0 = ImmVideoItemView.q0(expandView, booleanRef, objectRef, item, this, (View) obj2, (String) obj3);
                            return q0;
                        }
                    }));
                } else {
                    Intrinsics.e(expandView);
                    uf.c.g(expandView);
                }
                Intrinsics.e(expandView);
            }
        }
        str3 = str2;
        if (TextUtils.isEmpty(str3)) {
        }
        Intrinsics.e(expandView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0062, code lost:
    
        if ((r9.length() > 0) == true) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit q0(ExpandView expandView, Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef, PostSubjectItem postSubjectItem, ImmVideoItemView immVideoItemView, View view, String str) {
        boolean z;
        String str2;
        ResourceDetectors resourceDetector;
        List<UrlContent> list;
        int length = expandView.getText().length();
        boolean z2 = true;
        if (!booleanRef.element || (list = (List) objectRef.element) == null) {
            z = false;
        } else {
            z = false;
            for (UrlContent urlContent : list) {
                int indexOfUrl = urlContent.getIndexOfUrl();
                int indexOfUrl2 = urlContent.getIndexOfUrl() + urlContent.getUrl().length();
                if (indexOfUrl <= length && indexOfUrl2 >= length && indexOfUrl <= length && length < indexOfUrl2 + 1) {
                    z = true;
                }
            }
        }
        if (z) {
            expandView.performClick();
        } else {
            Subject subject = postSubjectItem.getSubject();
            if (subject != null && (r9 = subject.getSubjectId()) != null) {
            }
            z2 = false;
            if (z2) {
                DownloadManagerApi a2 = DownloadManagerApi.j.a();
                FragmentActivity context = expandView.getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = context;
                Subject subject2 = postSubjectItem.getSubject();
                Intrinsics.e(str);
                PostSubjectItem postSubjectItem2 = immVideoItemView.data;
                String ops = postSubjectItem2 != null ? postSubjectItem2.getOps() : null;
                Subject subject3 = postSubjectItem.getSubject();
                if (subject3 == null || (resourceDetector = subject3.getResourceDetector()) == null || (str2 = resourceDetector.getResourceLink()) == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                String str3 = str2;
                User user = postSubjectItem.getUser();
                a2.U(fragmentActivity, subject2, str, "post_video_detail", ops, str3, user != null ? user.getNickname() : null);
            } else {
                Navigator.x(TheRouter.c("/web/web").K("url", str), expandView.getContext(), (mf.c) null, 2, (Object) null);
            }
        }
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setBottomRoomModuleData(PostSubjectItem item) {
        String str;
        Cover cover;
        AppCompatTextView appCompatTextView = this.viewBinding.r.g;
        Group group = item.getGroup();
        String str2 = null;
        appCompatTextView.setText(group != null ? group.getName() : null);
        f.a aVar = ni.f.a;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m = aVar.m(context);
        Group group2 = item.getGroup();
        if (group2 == null || (str = group2.getAvatar()) == null) {
            Group group3 = item.getGroup();
            if (group3 != null && (cover = group3.getCover()) != null) {
                str2 = cover.getUrl();
            }
            str = str2 == null ? BuildConfig.FLAVOR : str2;
        }
        f.b c2 = m.g(str).m(lj.a.b(32)).c(lj.a.b(32));
        ShapeableImageView shapeableImageView = this.viewBinding.r.c;
        Intrinsics.g(shapeableImageView, "ivRoomCover");
        c2.d(shapeableImageView);
    }

    private final void setBottomSubjectAndRoomVisibility(boolean isShowSubject, boolean isShowRoom) {
        if (ij.g.a.b()) {
            BLLinearLayout root = this.viewBinding.r.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            root.setVisibility(isShowRoom ? 0 : 8);
            ConstraintLayout constraintLayout = this.viewBinding.r.b;
            Intrinsics.g(constraintLayout, "clSubjectContent");
            uf.c.g(constraintLayout);
            View view = this.viewBinding.r.m;
            Intrinsics.g(view, "vSubjectRoomLine");
            uf.c.g(view);
            LinearLayout linearLayout = this.viewBinding.r.f;
            Intrinsics.g(linearLayout, "llRoomTag");
            linearLayout.setVisibility(isShowRoom ? 0 : 8);
            return;
        }
        if (isShowSubject) {
            BLLinearLayout root2 = this.viewBinding.r.getRoot();
            Intrinsics.g(root2, "getRoot(...)");
            uf.c.k(root2);
            ConstraintLayout constraintLayout2 = this.viewBinding.r.b;
            Intrinsics.g(constraintLayout2, "clSubjectContent");
            uf.c.k(constraintLayout2);
            View view2 = this.viewBinding.r.m;
            Intrinsics.g(view2, "vSubjectRoomLine");
            view2.setVisibility(isShowRoom ? 0 : 8);
            LinearLayout linearLayout2 = this.viewBinding.r.f;
            Intrinsics.g(linearLayout2, "llRoomTag");
            linearLayout2.setVisibility(isShowRoom ? 0 : 8);
            return;
        }
        BLLinearLayout root3 = this.viewBinding.r.getRoot();
        Intrinsics.g(root3, "getRoot(...)");
        root3.setVisibility(isShowRoom ? 0 : 8);
        ConstraintLayout constraintLayout3 = this.viewBinding.r.b;
        Intrinsics.g(constraintLayout3, "clSubjectContent");
        uf.c.g(constraintLayout3);
        View view3 = this.viewBinding.r.m;
        Intrinsics.g(view3, "vSubjectRoomLine");
        uf.c.g(view3);
        LinearLayout linearLayout3 = this.viewBinding.r.f;
        Intrinsics.g(linearLayout3, "llRoomTag");
        linearLayout3.setVisibility(isShowRoom ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setBottomSubjectModuleData(PostSubjectItem item) {
        String str;
        String str2;
        String str3;
        Subject subject;
        String genre;
        List S0;
        String str4;
        Cover cover;
        Cover cover2;
        f.a aVar = ni.f.a;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m = aVar.m(context);
        Subject subject2 = item.getSubject();
        String str5 = BuildConfig.FLAVOR;
        if (subject2 == null || (cover2 = subject2.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b c2 = m.g(str).m(lj.a.b(32)).c(lj.a.b(32));
        Subject subject3 = item.getSubject();
        if (subject3 == null || (cover = subject3.getCover()) == null || (str2 = cover.getThumbnail()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        f.b l = c2.l(str2);
        ShapeableImageView shapeableImageView = this.viewBinding.r.d;
        Intrinsics.g(shapeableImageView, "ivSubjectCover");
        l.d(shapeableImageView);
        AppCompatTextView appCompatTextView = this.viewBinding.r.j;
        Subject subject4 = item.getSubject();
        if (subject4 == null || (str3 = subject4.getTitle()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        appCompatTextView.setText(str3);
        Subject subject5 = item.getSubject();
        this.viewBinding.r.e.setImageResource(com.transsion.flow.h.a(subject5 != null ? subject5.getSubjectType() : null));
        Subject subject6 = item.getSubject();
        Date l2 = com.blankj.utilcode.util.c0.l(subject6 != null ? subject6.getReleaseDate() : null, "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(l2);
        this.viewBinding.r.h.setText(String.valueOf(calendar.get(1)));
        Subject subject7 = item.getSubject();
        String genre2 = subject7 != null ? subject7.getGenre() : null;
        if (genre2 != null && genre2.length() != 0 && (subject = item.getSubject()) != null && (genre = subject.getGenre()) != null && (S0 = StringsKt.S0(genre, new String[]{", "}, false, 0, 6, (Object) null)) != null && (str4 = (String) CollectionsKt.k0(S0)) != null) {
            str5 = str4;
        }
        AppCompatTextView appCompatTextView2 = this.viewBinding.r.i;
        Intrinsics.g(appCompatTextView2, "tvSubjectGenre");
        appCompatTextView2.setVisibility(str5.length() > 0 ? 0 : 8);
        AppCompatTextView appCompatTextView3 = this.viewBinding.r.i;
        Intrinsics.g(appCompatTextView3, "tvSubjectGenre");
        appCompatTextView3.setVisibility(str5.length() > 0 ? 0 : 8);
        this.viewBinding.r.i.setText(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setContentVisibility(boolean visible) {
        Subject subject;
        String str;
        String str2;
        Subject subject2;
        if (visible) {
            PostSubjectItem postSubjectItem = this.data;
            if (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null) {
                str = "tvFavorite";
            } else {
                Integer subjectType = subject2.getSubjectType();
                str = "tvFavorite";
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    BLTextView bLTextView = this.viewBinding.F;
                    Intrinsics.g(bLTextView, "tvShortTvEp");
                    uf.c.k(bLTextView);
                    AppCompatTextView appCompatTextView = this.viewBinding.G;
                    Intrinsics.g(appCompatTextView, "tvTitle");
                    uf.c.k(appCompatTextView);
                    AppCompatImageView appCompatImageView = this.viewBinding.j;
                    Intrinsics.g(appCompatImageView, "ivDownload");
                    uf.c.k(appCompatImageView);
                    ShapeableImageView shapeableImageView = this.viewBinding.p;
                    Intrinsics.g(shapeableImageView, "ivShortCover");
                    uf.c.k(shapeableImageView);
                    ProgressBar progressBar = this.viewBinding.u;
                    Intrinsics.g(progressBar, "progressBar");
                    uf.c.k(progressBar);
                    AppCompatTextView appCompatTextView2 = this.viewBinding.C;
                    Intrinsics.g(appCompatTextView2, "tvLike");
                    uf.c.k(appCompatTextView2);
                    AppCompatTextView appCompatTextView3 = this.viewBinding.E;
                    Intrinsics.g(appCompatTextView3, "tvShare");
                    uf.c.k(appCompatTextView3);
                    AppCompatTextView appCompatTextView4 = this.viewBinding.x;
                    Intrinsics.g(appCompatTextView4, "tvComment");
                    uf.c.k(appCompatTextView4);
                    if (this.isShowHotComment) {
                        BLConstraintLayout bLConstraintLayout = this.viewBinding.d;
                        Intrinsics.g(bLConstraintLayout, "clHotComment");
                        uf.c.k(bLConstraintLayout);
                    }
                    if (this.isFavoriteShow) {
                        str2 = str;
                    } else {
                        AppCompatTextView appCompatTextView5 = this.viewBinding.y;
                        str2 = str;
                        Intrinsics.g(appCompatTextView5, str2);
                        uf.c.k(appCompatTextView5);
                    }
                    AppCompatTextView appCompatTextView6 = this.viewBinding.y;
                    Intrinsics.g(appCompatTextView6, str2);
                    uf.c.k(appCompatTextView6);
                    return;
                }
            }
            ShapeableImageView shapeableImageView2 = this.viewBinding.q;
            Intrinsics.g(shapeableImageView2, "ivVideoAvatar");
            uf.c.k(shapeableImageView2);
            BLLinearLayout root = this.viewBinding.r.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            uf.c.k(root);
            NestedScrollableHost nestedScrollableHost = this.viewBinding.t;
            Intrinsics.g(nestedScrollableHost, "nsPostDes");
            uf.c.k(nestedScrollableHost);
            AppCompatImageView appCompatImageView2 = this.viewBinding.o;
            Intrinsics.g(appCompatImageView2, "ivSave");
            uf.c.k(appCompatImageView2);
            ProgressBar progressBar2 = this.viewBinding.u;
            Intrinsics.g(progressBar2, "progressBar");
            uf.c.k(progressBar2);
            AppCompatTextView appCompatTextView22 = this.viewBinding.C;
            Intrinsics.g(appCompatTextView22, "tvLike");
            uf.c.k(appCompatTextView22);
            AppCompatTextView appCompatTextView32 = this.viewBinding.E;
            Intrinsics.g(appCompatTextView32, "tvShare");
            uf.c.k(appCompatTextView32);
            AppCompatTextView appCompatTextView42 = this.viewBinding.x;
            Intrinsics.g(appCompatTextView42, "tvComment");
            uf.c.k(appCompatTextView42);
            if (this.isShowHotComment) {
            }
            if (this.isFavoriteShow) {
            }
            AppCompatTextView appCompatTextView62 = this.viewBinding.y;
            Intrinsics.g(appCompatTextView62, str2);
            uf.c.k(appCompatTextView62);
            return;
        }
        BLConstraintLayout bLConstraintLayout2 = this.viewBinding.d;
        Intrinsics.g(bLConstraintLayout2, "clHotComment");
        if (bLConstraintLayout2.getVisibility() == 0) {
            this.isShowHotComment = true;
            BLConstraintLayout bLConstraintLayout3 = this.viewBinding.d;
            Intrinsics.g(bLConstraintLayout3, "clHotComment");
            uf.c.h(bLConstraintLayout3);
        }
        AppCompatTextView appCompatTextView7 = this.viewBinding.y;
        Intrinsics.g(appCompatTextView7, "tvFavorite");
        if (appCompatTextView7.getVisibility() == 0) {
            this.isFavoriteShow = true;
            AppCompatTextView appCompatTextView8 = this.viewBinding.y;
            Intrinsics.g(appCompatTextView8, "tvFavorite");
            uf.c.h(appCompatTextView8);
        }
        PostSubjectItem postSubjectItem2 = this.data;
        if (postSubjectItem2 != null && (subject = postSubjectItem2.getSubject()) != null) {
            Integer subjectType2 = subject.getSubjectType();
            int value2 = SubjectType.SHORT_TV.getValue();
            if (subjectType2 != null && subjectType2.intValue() == value2) {
                BLTextView bLTextView2 = this.viewBinding.F;
                Intrinsics.g(bLTextView2, "tvShortTvEp");
                uf.c.h(bLTextView2);
                AppCompatTextView appCompatTextView9 = this.viewBinding.G;
                Intrinsics.g(appCompatTextView9, "tvTitle");
                uf.c.h(appCompatTextView9);
                AppCompatImageView appCompatImageView3 = this.viewBinding.j;
                Intrinsics.g(appCompatImageView3, "ivDownload");
                uf.c.h(appCompatImageView3);
                ShapeableImageView shapeableImageView3 = this.viewBinding.p;
                Intrinsics.g(shapeableImageView3, "ivShortCover");
                uf.c.h(shapeableImageView3);
                ProgressBar progressBar3 = this.viewBinding.u;
                Intrinsics.g(progressBar3, "progressBar");
                uf.c.h(progressBar3);
                AppCompatTextView appCompatTextView10 = this.viewBinding.C;
                Intrinsics.g(appCompatTextView10, "tvLike");
                uf.c.h(appCompatTextView10);
                AppCompatTextView appCompatTextView11 = this.viewBinding.E;
                Intrinsics.g(appCompatTextView11, "tvShare");
                uf.c.h(appCompatTextView11);
                AppCompatImageView appCompatImageView4 = this.viewBinding.o;
                Intrinsics.g(appCompatImageView4, "ivSave");
                uf.c.h(appCompatImageView4);
                AppCompatTextView appCompatTextView12 = this.viewBinding.x;
                Intrinsics.g(appCompatTextView12, "tvComment");
                uf.c.h(appCompatTextView12);
            }
        }
        ShapeableImageView shapeableImageView4 = this.viewBinding.q;
        Intrinsics.g(shapeableImageView4, "ivVideoAvatar");
        uf.c.h(shapeableImageView4);
        BLLinearLayout root2 = this.viewBinding.r.getRoot();
        Intrinsics.g(root2, "getRoot(...)");
        uf.c.h(root2);
        NestedScrollableHost nestedScrollableHost2 = this.viewBinding.t;
        Intrinsics.g(nestedScrollableHost2, "nsPostDes");
        uf.c.h(nestedScrollableHost2);
        AppCompatImageView appCompatImageView5 = this.viewBinding.o;
        Intrinsics.g(appCompatImageView5, "ivSave");
        uf.c.h(appCompatImageView5);
        ProgressBar progressBar32 = this.viewBinding.u;
        Intrinsics.g(progressBar32, "progressBar");
        uf.c.h(progressBar32);
        AppCompatTextView appCompatTextView102 = this.viewBinding.C;
        Intrinsics.g(appCompatTextView102, "tvLike");
        uf.c.h(appCompatTextView102);
        AppCompatTextView appCompatTextView112 = this.viewBinding.E;
        Intrinsics.g(appCompatTextView112, "tvShare");
        uf.c.h(appCompatTextView112);
        AppCompatImageView appCompatImageView42 = this.viewBinding.o;
        Intrinsics.g(appCompatImageView42, "ivSave");
        uf.c.h(appCompatImageView42);
        AppCompatTextView appCompatTextView122 = this.viewBinding.x;
        Intrinsics.g(appCompatTextView122, "tvComment");
        uf.c.h(appCompatTextView122);
    }

    private final void setLoading(boolean show) {
        if (show) {
            AppCompatImageView appCompatImageView = this.viewBinding.e;
            Intrinsics.g(appCompatImageView, "clLoading");
            uf.c.k(appCompatImageView);
            ProgressBar progressBar = this.viewBinding.u;
            Intrinsics.g(progressBar, "progressBar");
            uf.c.g(progressBar);
            this.viewBinding.e.start();
            return;
        }
        ProgressBar progressBar2 = this.viewBinding.u;
        Intrinsics.g(progressBar2, "progressBar");
        uf.c.k(progressBar2);
        AppCompatImageView appCompatImageView2 = this.viewBinding.e;
        Intrinsics.g(appCompatImageView2, "clLoading");
        uf.c.g(appCompatImageView2);
        this.viewBinding.e.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g w() {
        return com.transsnet.downloader.manager.p.a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ImmVideoItemView immVideoItemView, String str) {
        immVideoItemView.y(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void y(String type) {
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
    public final void z(String id) {
        androidx.lifecycle.b0 C;
        a.a.r(wf.a.a, this.TAG, new String[]{"finishAfterReport, position = " + this.position}, false, 4, (Object) null);
        PostDetailViewModel postDetailViewModel = this.videoDetailModel;
        if (postDetailViewModel == null || (C = postDetailViewModel.C()) == null) {
            return;
        }
        C.q(this.position);
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

    public final FrameLayout getPlayerContainer() {
        FrameLayout frameLayout = this.viewBinding.h;
        Intrinsics.g(frameLayout, "flContainer");
        return frameLayout;
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
        ShortTvPlayListViewModel shortTvPlayListViewModel;
        androidx.lifecycle.b0 f2;
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        Fragment fragment = this.fragment;
        if (fragment != null && (viewLifecycleOwner = fragment.getViewLifecycleOwner()) != null && (shortTvPlayListViewModel = this.shortTvPlayListViewModel) != null && (f2 = shortTvPlayListViewModel.f()) != null) {
            f2.j(viewLifecycleOwner, this.favoriteResultObserver);
        }
        getDownloadManager().g(this.downloadListener);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j, gn.e eVar) {
        e.a.d(this, j, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Subject subject;
        Context context;
        PostSubjectItem postSubjectItem;
        Subject subject2;
        Integer valueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R$id.tv_like;
        if (valueOf != null && valueOf.intValue() == i) {
            O(v);
            return;
        }
        int i2 = R$id.tv_comment;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R$id.clHotComment;
            if (valueOf == null || valueOf.intValue() != i3) {
                int i4 = R$id.tv_share;
                if (valueOf != null && valueOf.intValue() == i4) {
                    T(v);
                    return;
                }
                int i5 = R$id.iv_save;
                if (valueOf != null && valueOf.intValue() == i5) {
                    S(v);
                    return;
                }
                int i6 = R$id.iv_video_avatar;
                if (valueOf != null && valueOf.intValue() == i6) {
                    F(v);
                    return;
                }
                int i7 = R$id.ev_post_des;
                if (valueOf != null && valueOf.intValue() == i7) {
                    return;
                }
                int i8 = R$id.cl_subject_content;
                if (valueOf != null && valueOf.intValue() == i8) {
                    H(v);
                    return;
                }
                int i9 = R$id.ll_room_tag;
                if (valueOf != null && valueOf.intValue() == i9) {
                    G(v);
                    return;
                }
                int i10 = R$id.tvShortTvEp;
                if (valueOf != null && valueOf.intValue() == i10) {
                    Fragment fragment = this.fragment;
                    if (fragment == null || (context = fragment.getContext()) == null || (postSubjectItem = this.data) == null || (subject2 = postSubjectItem.getSubject()) == null) {
                        return;
                    }
                    PostSubjectItem postSubjectItem2 = this.data;
                    subject2.setOps(postSubjectItem2 != null ? postSubjectItem2.getOps() : null);
                    Navigator F = TheRouter.c(pr.a.a.b()).K("id", subject2.getSubjectId()).F("ep", 1);
                    PostSubjectItem postSubjectItem3 = this.data;
                    Navigator.x(F.K("ops", postSubjectItem3 != null ? postSubjectItem3.getOps() : null), context, (mf.c) null, 2, (Object) null);
                    return;
                }
                int i11 = R$id.iv_download;
                if (valueOf == null || valueOf.intValue() != i11) {
                    int i12 = R$id.iv_short_cover;
                    if (valueOf == null || valueOf.intValue() != i12) {
                        int i13 = R$id.tv_title;
                        if (valueOf == null || valueOf.intValue() != i13) {
                            return;
                        }
                    }
                }
                DownloadManagerApi a2 = DownloadManagerApi.j.a();
                FragmentActivity context2 = getContext();
                Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = context2;
                PostSubjectItem postSubjectItem4 = this.data;
                String ops = (postSubjectItem4 == null || (subject = postSubjectItem4.getSubject()) == null) ? null : subject.getOps();
                boolean z = v.getId() == R$id.iv_download;
                PostSubjectItem postSubjectItem5 = this.data;
                DownloadManagerApi.e0(a2, fragmentActivity, VideoFragment.PAGE_NAME, BuildConfig.FLAVOR, ops, "download_subject", z, postSubjectItem5 != null ? postSubjectItem5.getSubject() : null, (String) null, (Boolean) null, 384, (Object) null);
                return;
            }
        }
        N(v);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e mediaSource) {
        Subject subject;
        Fragment fragment;
        Context context;
        PostSubjectItem postSubjectItem;
        Subject subject2;
        a.a.r(wf.a.a, this.TAG, new String[]{"player- onCompletion"}, false, 4, (Object) null);
        PostSubjectItem postSubjectItem2 = this.data;
        if (postSubjectItem2 == null || (subject = postSubjectItem2.getSubject()) == null) {
            return;
        }
        Integer subjectType = subject.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType == null || subjectType.intValue() != value || (fragment = this.fragment) == null || (context = fragment.getContext()) == null || (postSubjectItem = this.data) == null || (subject2 = postSubjectItem.getSubject()) == null) {
            return;
        }
        PostSubjectItem postSubjectItem3 = this.data;
        subject2.setOps(postSubjectItem3 != null ? postSubjectItem3.getOps() : null);
        Navigator F = TheRouter.c(pr.a.a.b()).K("id", subject2.getSubjectId()).F("ep", 1);
        PostSubjectItem postSubjectItem4 = this.data;
        Navigator.x(F.K("ops", postSubjectItem4 != null ? postSubjectItem4.getOps() : null), context, (mf.c) null, 2, (Object) null);
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        if (fVar != null) {
            fVar.seekTo(0L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        androidx.lifecycle.b0 f2;
        androidx.lifecycle.b0 f3;
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        ShortTvPlayListViewModel shortTvPlayListViewModel = this.shortTvPlayListViewModel;
        if (shortTvPlayListViewModel != null && (f3 = shortTvPlayListViewModel.f()) != null) {
            f3.q((Object) null);
        }
        ShortTvPlayListViewModel shortTvPlayListViewModel2 = this.shortTvPlayListViewModel;
        if (shortTvPlayListViewModel2 != null && (f2 = shortTvPlayListViewModel2.f()) != null) {
            f2.o(this.favoriteResultObserver);
        }
        getDownloadManager().k(this.downloadListener);
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
    public void onLoadingProgress(int i, float f2, gn.e eVar) {
        e.a.m(this, i, f2, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.j();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
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
        String postId;
        a.a.f(wf.a.a, this.TAG, "player- onPlayerReset", false, 4, (Object) null);
        this.isPageRelease = true;
        this.isSeekToFinish.set(true);
        this.nextSeekTo = 0L;
        setKeepScreenOn(false);
        this.isClickPause = false;
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            com.transsion.postdetail.layer.b.e(bVar, false, 1, null);
        }
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem != null && (postId = postSubjectItem.getPostId()) != null) {
        }
        AppCompatImageView appCompatImageView = this.viewBinding.i;
        Intrinsics.g(appCompatImageView, "ivCover");
        uf.c.k(appCompatImageView);
        AppCompatImageView appCompatImageView2 = this.viewBinding.n;
        Intrinsics.g(appCompatImageView2, "ivPause");
        uf.c.g(appCompatImageView2);
        AppCompatSeekBar appCompatSeekBar = this.viewBinding.w;
        Intrinsics.g(appCompatSeekBar, "seekBar");
        uf.c.g(appCompatSeekBar);
        this.viewBinding.g.reset();
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
        String postId;
        long longValue;
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        boolean z = false;
        int duration = fVar != null ? (int) fVar.getDuration() : 0;
        this.viewBinding.u.setMax(duration);
        this.viewBinding.w.setMax(duration);
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem != null && (postId = postSubjectItem.getPostId()) != null) {
            if (this.isFromDownloaded) {
                longValue = io.f.a.c(postId);
            } else {
                Long b2 = io.d.a.b(postId);
                longValue = b2 != null ? b2.longValue() : 0L;
            }
            Long valueOf = Long.valueOf(longValue);
            if (valueOf.longValue() <= 0) {
                valueOf = null;
            }
            if (valueOf != null) {
                long longValue2 = valueOf.longValue();
                a.a.v(wf.a.a, "PostFeedVideo", "immvideo seek:" + longValue2, false, 4, (Object) null);
                com.transsion.player.orplayer.f fVar2 = this.orPlayer;
                if (fVar2 != null) {
                    fVar2.seekTo(longValue2);
                }
                z = true;
            }
            Long l = (Long) ImmVideoHelper.h.a().j().get(postId);
            long longValue3 = l != null ? l.longValue() : 0L;
            a.a.f(wf.a.a, this.TAG, "player- onPrepare, duration = " + this.viewBinding.u.getMax() + ", progress = " + longValue3, false, 4, (Object) null);
            if (longValue3 > 0 && !z) {
                this.currentSaveProgress = longValue3;
                int i = (int) longValue3;
                this.viewBinding.u.setProgress(i);
                this.viewBinding.w.setProgress(i);
                com.transsion.player.orplayer.f fVar3 = this.orPlayer;
                if (fVar3 != null) {
                    fVar3.seekTo(longValue3);
                }
            }
        }
        if (!this.isClickPause && !this.isPageHide && (fragment = this.fragment) != null && fragment.isVisible()) {
            a.a.f(wf.a.a, this.TAG, "player- onPrepare， play~", false, 4, (Object) null);
            com.transsion.player.orplayer.f fVar4 = this.orPlayer;
            if (fVar4 != null) {
                fVar4.play();
            }
        }
        setKeepScreenOn(true);
        j0();
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long progress, gn.e mediaSource) {
        if (this.isSeekToFinish.get() && !this.isHorizontalDragging) {
            com.transsion.postdetail.layer.b bVar = this.dotLayer;
            if (bVar != null) {
                bVar.l(progress);
            }
            int i = (int) progress;
            this.viewBinding.u.setProgress(i);
            this.viewBinding.w.setProgress(i);
            P(progress);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        a.a.f(wf.a.a, this.TAG, "player- onRenderFirstFrame", false, 4, (Object) null);
        AppCompatImageView appCompatImageView = this.viewBinding.i;
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
        String postId;
        String postId2;
        Lifecycle lifecycle;
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        int i = a.a[event.ordinal()];
        if (i == 1) {
            this.isPageHide = true;
            a.a aVar = wf.a.a;
            a.a.f(aVar, this.TAG, "player- onPause", false, 4, (Object) null);
            com.transsion.player.orplayer.f fVar = this.orPlayer;
            if (fVar != null) {
                fVar.pause();
            }
            PostSubjectItem postSubjectItem = this.data;
            if (postSubjectItem == null || (postId = postSubjectItem.getPostId()) == null) {
                return;
            }
            a.a.v(aVar, "PostFeedVideo", "immvideo savePlayProgress:" + this.viewBinding.u.getProgress(), false, 4, (Object) null);
            if (this.isFromDownloaded) {
                io.f.a.e(postId, this.viewBinding.u.getProgress());
                return;
            } else {
                io.d.a.c(postId, this.viewBinding.u.getProgress());
                return;
            }
        }
        if (i == 2) {
            this.isPageHide = false;
            if (this.isClickPause) {
                return;
            }
            Fragment fragment = this.fragment;
            if (fragment != null && !fragment.isVisible()) {
                post(new Runnable() { // from class: com.transsion.postdetail.ui.view.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImmVideoItemView.V(ImmVideoItemView.this);
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
            PostSubjectItem postSubjectItem2 = this.data;
            if (postSubjectItem2 == null || (postId2 = postSubjectItem2.getPostId()) == null) {
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
        AppCompatImageView appCompatImageView = this.viewBinding.n;
        Intrinsics.g(appCompatImageView, "ivPause");
        uf.c.k(appCompatImageView);
        AppCompatSeekBar appCompatSeekBar = this.viewBinding.w;
        Intrinsics.g(appCompatSeekBar, "seekBar");
        uf.c.k(appCompatSeekBar);
        ProgressBar progressBar = this.viewBinding.u;
        Intrinsics.g(progressBar, "progressBar");
        uf.c.g(progressBar);
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.n();
        }
        setKeepScreenOn(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i, int i2) {
        e.a.H(this, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e mediaSource) {
        a.a.f(wf.a.a, this.TAG, "player- onVideoStart", false, 4, (Object) null);
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.o();
        }
        AppCompatImageView appCompatImageView = this.viewBinding.n;
        Intrinsics.g(appCompatImageView, "ivPause");
        uf.c.g(appCompatImageView);
        AppCompatSeekBar appCompatSeekBar = this.viewBinding.w;
        Intrinsics.g(appCompatSeekBar, "seekBar");
        uf.c.g(appCompatSeekBar);
        setLoading(false);
        setKeepScreenOn(true);
        ep.a aVar = this.audioApi;
        if (aVar != null) {
            aVar.pause();
        }
    }

    public final void setData(PostSubjectItem item, final Fragment fragment, Integer position, boolean videoLoadMore, String basePostId, String baseItemType, boolean attachToMain, String commentId, String pageFrom, boolean isFromDownloaded) {
        Long shareCount;
        Long commentCount;
        Integer subjectType;
        Intrinsics.h(item, "item");
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(commentId, "commentId");
        Intrinsics.h(pageFrom, "pageFrom");
        com.transsion.postdetail.layer.b bVar = new com.transsion.postdetail.layer.b();
        this.dotLayer = bVar;
        bVar.s(basePostId);
        com.transsion.postdetail.layer.b bVar2 = this.dotLayer;
        if (bVar2 != null) {
            bVar2.r(baseItemType);
        }
        com.transsion.postdetail.layer.b bVar3 = this.dotLayer;
        if (bVar3 != null) {
            String postId = item.getPostId();
            if (postId == null) {
                postId = BuildConfig.FLAVOR;
            }
            bVar3.x(postId, item);
        }
        com.transsion.postdetail.layer.b bVar4 = this.dotLayer;
        if (bVar4 != null) {
            Subject subject = item.getSubject();
            bVar4.y((subject == null || (subjectType = subject.getSubjectType()) == null) ? 0 : subjectType.intValue());
        }
        this.fragment = fragment;
        this.videoLoadMore = Boolean.valueOf(videoLoadMore);
        this.basePostId = basePostId;
        this.position = position;
        this.attachToMain = attachToMain;
        this.commentId = commentId;
        this.pageFrom = pageFrom;
        this.isFromDownloaded = isFromDownloaded;
        fragment.getLifecycle().a(this);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m128invoke() {
                return fragment;
            }
        };
        this.videoDetailModel = Z(FragmentViewModelLazyKt.a(fragment, Reflection.b(PostDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.x0 m129invoke() {
                androidx.lifecycle.x0 viewModelStore = ((androidx.lifecycle.y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m130invoke() {
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
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m131invoke() {
                return fragment;
            }
        };
        this.shortTvPlayListViewModel = a0(FragmentViewModelLazyKt.a(fragment, Reflection.b(ShortTvPlayListViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.x0 m132invoke() {
                androidx.lifecycle.x0 viewModelStore = ((androidx.lifecycle.y0) function02.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m133invoke() {
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
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m134invoke() {
                return fragment;
            }
        };
        this.mCommentViewModel = b0(FragmentViewModelLazyKt.a(fragment, Reflection.b(CommentViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.x0 m135invoke() {
                androidx.lifecycle.x0 viewModelStore = ((androidx.lifecycle.y0) function03.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m136invoke() {
                Object invoke = function03.invoke();
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
        p0(item);
        i0(item);
        Stat stat = item.getStat();
        long j = 0;
        e0((stat == null || (commentCount = stat.getCommentCount()) == null) ? 0L : commentCount.longValue());
        Stat stat2 = item.getStat();
        if (stat2 != null && (shareCount = stat2.getShareCount()) != null) {
            j = shareCount.longValue();
        }
        l0(j);
        o0(item);
        f0(item);
        if (attachToMain) {
            ConstraintLayout.b layoutParams = this.viewBinding.v.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.b) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.blankj.utilcode.util.a0.a(16.0f);
            }
        }
        m0();
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

    public final void showCommentDialog() {
        FragmentManager childFragmentManager;
        Fragment fragment = this.fragment;
        if (fragment != null && (childFragmentManager = fragment.getChildFragmentManager()) != null) {
            ImmVideoCommentDialog b2 = ImmVideoCommentDialog.Companion.b(ImmVideoCommentDialog.INSTANCE, this.data, this.commentId, VideoFragment.PAGE_NAME, null, 8, null);
            this.commentDialog = b2;
            if (b2 != null) {
                b2.show(childFragmentManager, "immComment");
            }
        }
        ImmVideoCommentDialog immVideoCommentDialog = this.commentDialog;
        if (immVideoCommentDialog != null) {
            immVideoCommentDialog.A0(new f());
        }
        com.transsion.postdetail.helper.a.a.e(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
    }

    public final void videoStartPrepare(String pageFrom) {
        com.transsion.postdetail.layer.b bVar;
        this.pageFrom = pageFrom;
        if (pageFrom != null && (bVar = this.dotLayer) != null) {
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
