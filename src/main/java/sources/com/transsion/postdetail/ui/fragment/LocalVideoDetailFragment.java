package com.transsion.postdetail.ui.fragment;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.helper.ScreenRotationHelper;
import com.transsion.baselib.report.k$a;
import com.transsion.baselib.utils.PlayMode;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.music.MusicFloatManager;
import com.transsion.flow.bean.DubsInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.player.config.RenderType;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$array;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.layer.local.LocalUiType;
import com.transsion.postdetail.layer.local.LocalVideoMiddleLayer;
import com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment;
import com.transsion.postdetail.util.LocalFloatManager;
import com.transsion.postdetail.util.LocalVideoAdHelper;
import com.transsion.push.bean.MsgStyle;
import com.transsion.subtitle.VideoSubtitleControl;
import com.transsion.subtitle.h;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DownloadUtil;
import cw.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import wf.a;

@Metadata(d1 = {"\u0000Ì\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u0004¸\u0002À\u0002\u0018\u0000 È\u00022\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002\u009a\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020\u001aH\u0002¢\u0006\u0004\b&\u0010'J\u0011\u0010)\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0007H\u0002¢\u0006\u0004\b.\u0010\u0006J\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u0010\u0006J\u0017\u00100\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b0\u0010\u001dJ'\u00103\u001a\u00020\u00072\u0006\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0007H\u0002¢\u0006\u0004\b5\u0010\u0006J\u000f\u00106\u001a\u00020\u0007H\u0002¢\u0006\u0004\b6\u0010\u0006J\u000f\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0004\b7\u0010\u0006J\u001f\u00109\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u0016H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b;\u0010\u0015J\u0017\u0010=\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0016H\u0002¢\u0006\u0004\b=\u0010\u0019J\u0015\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0007H\u0002¢\u0006\u0004\bB\u0010\u0006J\u000f\u0010C\u001a\u00020\u0007H\u0002¢\u0006\u0004\bC\u0010\u0006J\u0019\u0010E\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\bE\u0010\u0015J\u000f\u0010F\u001a\u00020\u0007H\u0002¢\u0006\u0004\bF\u0010\u0006J\u000f\u0010G\u001a\u00020\u0007H\u0002¢\u0006\u0004\bG\u0010\u0006J\u000f\u0010H\u001a\u00020\u0007H\u0002¢\u0006\u0004\bH\u0010\u0006J\u0017\u0010K\u001a\u00020\u00072\u0006\u0010J\u001a\u00020IH\u0002¢\u0006\u0004\bK\u0010LJ+\u0010P\u001a\u00020\u00072\b\u0010M\u001a\u0004\u0018\u00010\u00122\u0006\u0010N\u001a\u00020I2\b\b\u0002\u0010O\u001a\u00020\u0016H\u0002¢\u0006\u0004\bP\u0010QJ\u0018\u0010R\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u0007H\u0002¢\u0006\u0004\bT\u0010\u0006J\u000f\u0010U\u001a\u00020\u0007H\u0002¢\u0006\u0004\bU\u0010\u0006J\u000f\u0010V\u001a\u00020\u0007H\u0002¢\u0006\u0004\bV\u0010\u0006J\u000f\u0010W\u001a\u00020\u0007H\u0002¢\u0006\u0004\bW\u0010\u0006J\u000f\u0010X\u001a\u00020\u0016H\u0002¢\u0006\u0004\bX\u0010YJ\u0017\u0010[\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u0016H\u0002¢\u0006\u0004\b[\u0010\u0019J\u000f\u0010\\\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\\\u0010\u0006J\u0017\u0010_\u001a\u00020\u00072\u0006\u0010^\u001a\u00020]H\u0016¢\u0006\u0004\b_\u0010`J\u0017\u0010c\u001a\u00020\u00022\u0006\u0010b\u001a\u00020aH\u0016¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\u0016H\u0016¢\u0006\u0004\be\u0010YJ\u000f\u0010f\u001a\u00020\u001aH\u0016¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\u0007H\u0016¢\u0006\u0004\bh\u0010\u0006J\u000f\u0010i\u001a\u00020\u0007H\u0016¢\u0006\u0004\bi\u0010\u0006J\u000f\u0010j\u001a\u00020\u0007H\u0016¢\u0006\u0004\bj\u0010\u0006J\u000f\u0010k\u001a\u00020\u0007H\u0016¢\u0006\u0004\bk\u0010\u0006J\u000f\u0010l\u001a\u00020\u0016H\u0016¢\u0006\u0004\bl\u0010YJ\u000f\u0010m\u001a\u00020\u0007H\u0016¢\u0006\u0004\bm\u0010\u0006J\u001f\u0010r\u001a\u00020\u00072\u0006\u0010o\u001a\u00020n2\u0006\u0010q\u001a\u00020pH\u0016¢\u0006\u0004\br\u0010sJ\u0017\u0010v\u001a\u00020\u00072\u0006\u0010u\u001a\u00020tH\u0016¢\u0006\u0004\bv\u0010wJ\u000f\u0010x\u001a\u00020\u0007H\u0016¢\u0006\u0004\bx\u0010\u0006J\u000f\u0010y\u001a\u00020\u0007H\u0016¢\u0006\u0004\by\u0010\u0006J\u000f\u0010z\u001a\u00020\u0007H\u0016¢\u0006\u0004\bz\u0010\u0006J\u000f\u0010{\u001a\u00020\u0007H\u0016¢\u0006\u0004\b{\u0010\u0006J\r\u0010|\u001a\u00020\u0007¢\u0006\u0004\b|\u0010\u0006J\"\u0010\u007f\u001a\u00020\u00072\b\u0010}\u001a\u0004\u0018\u00010\u001a2\b\u0010~\u001a\u0004\u0018\u00010\u001a¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u000f\u0010\u0081\u0001\u001a\u00020\u0007¢\u0006\u0005\b\u0081\u0001\u0010\u0006J\"\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010J\u001a\u00020I2\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u000f\u0010\u0086\u0001\u001a\u00020\u0007¢\u0006\u0005\b\u0086\u0001\u0010\u0006J\u001a\u0010\u0088\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0087\u0001\u001a\u00020\u0016¢\u0006\u0005\b\u0088\u0001\u0010\u0019J\u001e\u0010\u008b\u0001\u001a\u00020\u00072\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0016¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0013\u0010\u008e\u0001\u001a\u00030\u008d\u0001H\u0016¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001a\u0010\u0091\u0001\u001a\u00020\u00072\u0007\u0010\u0090\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0005\b\u0091\u0001\u0010\u0019J\u0011\u0010\u0092\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b\u0092\u0001\u0010\u0006J\u0011\u0010\u0093\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b\u0093\u0001\u0010\u0006J\u001a\u0010\u0095\u0001\u001a\u00020\u00072\u0007\u0010\u0094\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0005\b\u0095\u0001\u0010\u0019J\u0018\u0010\u0097\u0001\u001a\u00020\u00072\u0007\u0010\u0096\u0001\u001a\u00020\u0016¢\u0006\u0005\b\u0097\u0001\u0010\u0019J\u000f\u0010\u0098\u0001\u001a\u00020\u0007¢\u0006\u0005\b\u0098\u0001\u0010\u0006J\u000f\u0010\u0099\u0001\u001a\u00020\u0016¢\u0006\u0005\b\u0099\u0001\u0010YR\u0017\u0010\u009c\u0001\u001a\u00020\u001a8\u0002X\u0082D¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001c\u0010 \u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001c\u0010¤\u0001\u001a\u0005\u0018\u00010¡\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u0019\u0010ª\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010\u009b\u0001R\u0019\u0010¬\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010\u009b\u0001R\u0019\u0010®\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010\u009b\u0001R\u0018\u0010~\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010\u009b\u0001R\u0019\u0010±\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010\u009b\u0001R\u0019\u0010³\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010\u009b\u0001R\u0018\u0010}\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010\u009b\u0001R\u0019\u0010¶\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010\u009b\u0001R\u0019\u0010¹\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u0019\u0010»\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010¸\u0001R\u0019\u0010½\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010¸\u0001R\u0018\u0010O\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¸\u0001R\u0019\u0010À\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010¸\u0001R\u001a\u0010D\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R!\u0010È\u0001\u001a\u00030Ã\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0018\u0010Ë\u0001\u001a\u00030Ã\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R!\u0010Ð\u0001\u001a\u00030Ì\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÍ\u0001\u0010Å\u0001\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u0018\u0010N\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001a\u0010Õ\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u0019\u0010×\u0001\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010Ò\u0001R\u0018\u00101\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R\u0018\u00102\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Ù\u0001R\u0019\u0010Ü\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ù\u0001R\u0019\u0010Þ\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010Ù\u0001R!\u0010ã\u0001\u001a\n\u0012\u0005\u0012\u00030à\u00010ß\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010â\u0001R!\u0010è\u0001\u001a\u00030ä\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bå\u0001\u0010Å\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001R!\u0010í\u0001\u001a\u00030é\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bê\u0001\u0010Å\u0001\u001a\u0006\bë\u0001\u0010ì\u0001R!\u0010ñ\u0001\u001a\u00030î\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÔ\u0001\u0010Å\u0001\u001a\u0006\bï\u0001\u0010ð\u0001R\u0019\u0010ó\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010¸\u0001R\u0019\u0010õ\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bô\u0001\u0010¸\u0001R\u0019\u0010ö\u0001\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ò\u0001R\u0019\u0010÷\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010¸\u0001R\u0019\u0010ù\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010¸\u0001R\u0019\u0010û\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010¸\u0001R\u001a\u0010ÿ\u0001\u001a\u00030ü\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0001\u0010þ\u0001R\u001c\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0080\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002R\u0017\u0010\u0085\u0002\u001a\u00020+8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0084\u0002\u0010Ù\u0001R#\u0010\u008a\u0002\u001a\u0005\u0018\u00010\u0086\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0087\u0002\u0010Å\u0001\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002R*\u0010\u0090\u0002\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u008b\u0002\u0010\u008c\u0002\u001a\u0006\b\u008d\u0002\u0010\u008e\u0002\"\u0005\b\u008f\u0002\u0010\rR'\u0010\u0092\u0002\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u0091\u0002\u0010¸\u0001\u001a\u0005\b\u0092\u0002\u0010Y\"\u0005\b\u0093\u0002\u0010\u0019R\u001a\u0010\u0097\u0002\u001a\u00030\u0094\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0002\u0010\u0096\u0002R\u001c\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u0098\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0002\u0010\u009a\u0002R\u0019\u0010\u009d\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0002\u0010¸\u0001R\u0019\u0010\u009f\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0002\u0010¸\u0001R!\u0010¤\u0002\u001a\u00030 \u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¡\u0002\u0010Å\u0001\u001a\u0006\b¢\u0002\u0010£\u0002R\u0018\u0010¦\u0002\u001a\u00030Ã\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0002\u0010Ê\u0001R\u001b\u0010¨\u0002\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0002\u0010\u009b\u0001R \u0010«\u0002\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¸\u0001\u0010Å\u0001\u001a\u0006\b©\u0002\u0010ª\u0002R \u0010®\u0002\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¬\u0002\u0010Å\u0001\u001a\u0006\b\u00ad\u0002\u0010ª\u0002R\u0019\u0010°\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0002\u0010¸\u0001R\u0017\u0010²\u0002\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0002\u0010Ù\u0001R#\u0010·\u0002\u001a\u0005\u0018\u00010³\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b´\u0002\u0010Å\u0001\u001a\u0006\bµ\u0002\u0010¶\u0002R\u0018\u0010»\u0002\u001a\u00030¸\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0002\u0010º\u0002R\u0018\u0010¿\u0002\u001a\u00030¼\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0002\u0010¾\u0002R\u0018\u0010Ã\u0002\u001a\u00030À\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0002\u0010Â\u0002R\u0018\u0010Å\u0002\u001a\u00030¼\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÄ\u0002\u0010¾\u0002R\u0019\u0010Ç\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0002\u0010\u008c\u0002¨\u0006É\u0002"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/LocalVideoDetailFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lwn/j;", "Lcom/transsion/player/orplayer/e;", "Lcom/transsion/baselib/report/k$a;", "<init>", "()V", BuildConfig.FLAVOR, "initAd", "initView", "Lcom/transsion/postdetail/layer/local/LocalUiType;", "uiType", "C3", "(Lcom/transsion/postdetail/layer/local/LocalUiType;)V", "y2", "initAudioListener", "Q2", "x2", "Lcom/transsion/baselib/db/download/DownloadBean;", "bean", "N2", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", BuildConfig.FLAVOR, "isSameResource", "D2", "(Z)V", BuildConfig.FLAVOR, "path", "j3", "(Ljava/lang/String;)V", "q3", "Lcom/transsion/player/mediasession/MediaItem;", "i2", "()Lcom/transsion/player/mediasession/MediaItem;", "Landroid/content/Intent;", "d2", "()Landroid/content/Intent;", "pageName", "g2", "(Ljava/lang/String;)Landroid/content/Intent;", "Landroid/app/PendingIntent;", "j2", "()Landroid/app/PendingIntent;", BuildConfig.FLAVOR, "l2", "()I", "E2", "z2", "V2", "videoWidth", "videoHeight", "b3", "(IILjava/lang/String;)V", "B2", "a2", "G2", "isStart", "w3", "(Lcom/transsion/baselib/db/download/DownloadBean;Z)V", "Y2", "isFirst", "A2", BuildConfig.FLAVOR, "Lcom/transsion/moviedetailapi/bean/DubsInfo;", "f2", "()Ljava/util/List;", "F2", "B3", "downloadBean", "k3", "A3", "t2", "E3", BuildConfig.FLAVOR, "progress", "i3", "(J)V", "cvideoBean", "playProgress", "completed", "r3", "(Lcom/transsion/baselib/db/download/DownloadBean;JZ)V", "t3", "(Lcom/transsion/baselib/db/download/DownloadBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a3", "Y1", "O2", "w2", "T2", "()Z", "isPortrait", "V1", "p3", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "r2", "(Landroid/view/LayoutInflater;)Lwn/j;", "isAudioShowNoNetworkLayout", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewModel", "initListener", "retryLoadData", "initViewData", "isRegisteDeviceKeyMonitor", "onDisconnected", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onResume", "onPause", "onStop", "onDestroy", "m3", "subjectId", "resourceId", "W1", "(Ljava/lang/String;Ljava/lang/String;)V", "e3", BuildConfig.FLAVOR, "targetPercent", "v3", "(JF)V", "b2", "fromClicked", "n3", "Lgn/e;", "mediaSource", "onVideoStart", "(Lgn/e;)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "onHomeClick", "onRecentClick", "isBackground", "onBackgroundStatusChange", "isLock", "W2", "Z2", "S2", "a", "Ljava/lang/String;", "TAG", "Lcom/transsion/player/orplayer/f;", "b", "Lcom/transsion/player/orplayer/f;", "orPlayer", "Lcom/transsion/player/ui/ORPlayerView;", "c", "Lcom/transsion/player/ui/ORPlayerView;", "orPlayerView", "Lcom/transsion/postdetail/layer/local/c0;", "d", "Lcom/transsion/postdetail/layer/local/c0;", "localVideoDot", "e", "localPath", "f", "url", "g", "proxyUrl", "h", "i", "name", "j", "postId", "k", "l", "pageFrom", "m", "Z", "isDownloadingPlay", "n", "isDownloadingPlayStart", "o", "isPrepare", "p", "q", "isSeries", "r", "Lcom/transsion/baselib/db/download/DownloadBean;", "Landroid/os/Handler;", "s", "Lkotlin/Lazy;", "getHandler", "()Landroid/os/Handler;", "handler", "t", "Landroid/os/Handler;", "playingDownloadHandler", "Lcom/transsion/postdetail/layer/a;", "u", "h2", "()Lcom/transsion/postdetail/layer/a;", "layerManager", "v", "J", "w", "F", "unplaySeekTargetPercent", "x", "duration", "y", "I", "z", "A", "parentPosition", "B", "position", BuildConfig.FLAVOR, "Lht/a;", "C", "Ljava/util/List;", "subtitleList", "Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "D", "q2", "()Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "videoDetailPlayDao", "Lcom/transsnet/downloader/manager/g;", "E", "e2", "()Lcom/transsnet/downloader/manager/g;", "downloadManager", "Lcom/transsion/baselib/helper/ScreenRotationHelper;", "o2", "()Lcom/transsion/baselib/helper/ScreenRotationHelper;", "screenHelper", "G", "isNextPlayTipsShow", "H", "isPlayerNetTimeout", "lastReloadTime", "isReload", "K", "isMusic", "L", "isBgPlaying", "Ljava/util/concurrent/atomic/AtomicInteger;", "M", "Ljava/util/concurrent/atomic/AtomicInteger;", "playErrorCount", "Lcom/transsion/subtitle/VideoSubtitleControl;", "N", "Lcom/transsion/subtitle/VideoSubtitleControl;", "subtitleControl", "O", "sDownloadIngAndPlayTimeout", "Lep/a;", "P", "c2", "()Lep/a;", "audioApi", "Q", "Lcom/transsion/postdetail/layer/local/LocalUiType;", "getMUiType", "()Lcom/transsion/postdetail/layer/local/LocalUiType;", "y3", "mUiType", "R", "isPauseState", "z3", "Lcom/transsion/postdetail/util/LocalVideoAdHelper;", "S", "Lcom/transsion/postdetail/util/LocalVideoAdHelper;", "localVideoAdHelper", "Lcom/transsion/player/orplayer/PlayError;", "T", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "U", "isNewPlayer", "V", "isFloatShow", "Lcom/transsion/postdetail/ui/dialog/k;", "W", "p2", "()Lcom/transsion/postdetail/ui/dialog/k;", "speedViewModel", "X", "playTimeoutHandler", "Y", "curTimeoutPlayPath", "m2", "()J", "playTimeout", "a0", "n2", "playTimeoutDp", "b0", "isAdShowing", "c0", "statusBarHeight", "Lcom/transsion/postdetail/util/n;", "d0", "k2", "()Lcom/transsion/postdetail/util/n;", "orientationEventListener", "com/transsion/postdetail/ui/fragment/LocalVideoDetailFragment$playerListener$1", "e0", "Lcom/transsion/postdetail/ui/fragment/LocalVideoDetailFragment$playerListener$1;", "playerListener", "Ljava/lang/Runnable;", "f0", "Ljava/lang/Runnable;", "playTimeoutRunnable", "com/transsion/postdetail/ui/fragment/LocalVideoDetailFragment$b", "g0", "Lcom/transsion/postdetail/ui/fragment/LocalVideoDetailFragment$b;", "downloadListener", "h0", "notNetRunnable", "i0", "curUiRotation", "j0", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LocalVideoDetailFragment extends PageStatusFragment<wn.j> implements com.transsion.player.orplayer.e, k$a {

    /* renamed from: j0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    private int parentPosition;

    /* renamed from: B, reason: from kotlin metadata */
    private int position;

    /* renamed from: C, reason: from kotlin metadata */
    private List subtitleList;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy videoDetailPlayDao;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy downloadManager;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy screenHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isNextPlayTipsShow;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isPlayerNetTimeout;

    /* renamed from: I, reason: from kotlin metadata */
    private long lastReloadTime;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isReload;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isMusic;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isBgPlaying;

    /* renamed from: M, reason: from kotlin metadata */
    private AtomicInteger playErrorCount;

    /* renamed from: N, reason: from kotlin metadata */
    private VideoSubtitleControl subtitleControl;

    /* renamed from: O, reason: from kotlin metadata */
    private final int sDownloadIngAndPlayTimeout;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy audioApi;

    /* renamed from: Q, reason: from kotlin metadata */
    private LocalUiType mUiType;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isPauseState;

    /* renamed from: S, reason: from kotlin metadata */
    private LocalVideoAdHelper localVideoAdHelper;

    /* renamed from: T, reason: from kotlin metadata */
    private PlayError errorInfo;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isNewPlayer;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isFloatShow;

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy speedViewModel;

    /* renamed from: X, reason: from kotlin metadata */
    private final Handler playTimeoutHandler;

    /* renamed from: Y, reason: from kotlin metadata */
    private String curTimeoutPlayPath;

    /* renamed from: Z, reason: from kotlin metadata */
    private final Lazy playTimeout;

    /* renamed from: a0, reason: from kotlin metadata */
    private final Lazy playTimeoutDp;

    /* renamed from: b, reason: from kotlin metadata */
    private com.transsion.player.orplayer.f orPlayer;

    /* renamed from: b0, reason: from kotlin metadata */
    private boolean isAdShowing;

    /* renamed from: c, reason: from kotlin metadata */
    private ORPlayerView orPlayerView;

    /* renamed from: c0, reason: from kotlin metadata */
    private final int statusBarHeight;

    /* renamed from: d, reason: from kotlin metadata */
    private com.transsion.postdetail.layer.local.c0 localVideoDot;

    /* renamed from: d0, reason: from kotlin metadata */
    private final Lazy orientationEventListener;

    /* renamed from: e0, reason: from kotlin metadata */
    private final LocalVideoDetailFragment$playerListener$1 playerListener;

    /* renamed from: f0, reason: from kotlin metadata */
    private final Runnable playTimeoutRunnable;

    /* renamed from: g0, reason: from kotlin metadata */
    private final b downloadListener;

    /* renamed from: h0, reason: from kotlin metadata */
    private final Runnable notNetRunnable;

    /* renamed from: i0, reason: from kotlin metadata */
    private LocalUiType curUiRotation;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean isDownloadingPlay;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean isDownloadingPlayStart;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean isPrepare;

    /* renamed from: r, reason: from kotlin metadata */
    private DownloadBean downloadBean;

    /* renamed from: u, reason: from kotlin metadata */
    private final Lazy layerManager;

    /* renamed from: v, reason: from kotlin metadata */
    private long playProgress;

    /* renamed from: w, reason: from kotlin metadata */
    private float unplaySeekTargetPercent;

    /* renamed from: x, reason: from kotlin metadata */
    private long duration;

    /* renamed from: y, reason: from kotlin metadata */
    private int videoWidth;

    /* renamed from: z, reason: from kotlin metadata */
    private int videoHeight;

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG = "LocalVideoDetail";

    /* renamed from: e, reason: from kotlin metadata */
    private String localPath = BuildConfig.FLAVOR;

    /* renamed from: f, reason: from kotlin metadata */
    private String url = BuildConfig.FLAVOR;

    /* renamed from: g, reason: from kotlin metadata */
    private String proxyUrl = BuildConfig.FLAVOR;

    /* renamed from: h, reason: from kotlin metadata */
    private String resourceId = BuildConfig.FLAVOR;

    /* renamed from: i, reason: from kotlin metadata */
    private String name = BuildConfig.FLAVOR;

    /* renamed from: j, reason: from kotlin metadata */
    private String postId = BuildConfig.FLAVOR;

    /* renamed from: k, reason: from kotlin metadata */
    private String subjectId = BuildConfig.FLAVOR;

    /* renamed from: l, reason: from kotlin metadata */
    private String pageFrom = BuildConfig.FLAVOR;

    /* renamed from: p, reason: from kotlin metadata */
    private boolean completed = true;

    /* renamed from: q, reason: from kotlin metadata */
    private boolean isSeries = true;

    /* renamed from: s, reason: from kotlin metadata */
    private final Lazy handler = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.p
        public final Object invoke() {
            Handler s2;
            s2 = LocalVideoDetailFragment.s2();
            return s2;
        }
    });

    /* renamed from: t, reason: from kotlin metadata */
    private final Handler playingDownloadHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalVideoDetailFragment a(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, String str8, Integer num, Integer num2, Integer num3, Integer num4) {
            LocalVideoDetailFragment localVideoDetailFragment = new LocalVideoDetailFragment();
            localVideoDetailFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("extra_local_path", str), TuplesKt.a("extra_url", str2), TuplesKt.a("extra_proxy_url", str7), TuplesKt.a("extra_name", str3), TuplesKt.a("extra_resource_id", str4), TuplesKt.a("extra_subject_id", str6), TuplesKt.a("extra_post_id", str5), TuplesKt.a("extra_completed", bool), TuplesKt.a("extra_is_series", bool2), TuplesKt.a("extra_page_from", str8), TuplesKt.a("extra_height", num), TuplesKt.a("extra_width", num2), TuplesKt.a("extra_parent_position", num3), TuplesKt.a("extra_position", num4)}));
            return localVideoDetailFragment;
        }
    }

    public static final class b extends zw.d {
        b() {
        }

        public void h(DownloadBean downloadBean, int i) {
            com.transsion.postdetail.layer.local.c0 c0Var;
            Intrinsics.h(downloadBean, "bean");
            LocalVideoDetailFragment.this.h2().h(LayerFlag.DOWNLOAD_CALLBACK, downloadBean);
            if (Intrinsics.c(LocalVideoDetailFragment.this.resourceId, downloadBean.getResourceId())) {
                if (downloadBean.getStatus() == 6 && (c0Var = LocalVideoDetailFragment.this.localVideoDot) != null) {
                    DownloadException exception = downloadBean.getException();
                    c0Var.G(1, exception != null ? exception.getMessage() : null);
                }
                if (downloadBean.getSize() != null) {
                    Long size = downloadBean.getSize();
                    if ((size != null ? size.longValue() : 0L) <= 0) {
                        return;
                    }
                    LocalVideoDetailFragment.this.downloadBean = downloadBean;
                    if (downloadBean.getStatus() == 2 || downloadBean.getStatus() == 5) {
                        LocalVideoDetailFragment.this.Y2(downloadBean);
                        LocalVideoDetailFragment.this.h2().h(LayerFlag.DOWNLOAD_SPEED, downloadBean.getStatus() == 5 ? BuildConfig.FLAVOR : com.transsion.baseui.util.i.a.a(downloadBean.getProgress()));
                        LocalVideoDetailFragment.this.w3(downloadBean, false);
                    }
                }
            }
        }
    }

    public static final class c implements zn.b {
        c() {
        }

        @Override // zn.b
        public void a(LocalUiType localUiType) {
            Intrinsics.h(localUiType, "uiType");
            LocalVideoDetailFragment.this.y3(localUiType);
            VideoSubtitleControl videoSubtitleControl = LocalVideoDetailFragment.this.subtitleControl;
            if (videoSubtitleControl != null) {
                videoSubtitleControl.O(com.transsion.postdetail.util.t.c(localUiType));
            }
            LocalVideoDetailFragment.this.C3(localUiType);
            LocalVideoDetailFragment.this.localVideoAdHelper.x2(localUiType, LocalVideoDetailFragment.this.orPlayer);
            com.transsion.postdetail.layer.local.c0 c0Var = LocalVideoDetailFragment.this.localVideoDot;
            if (c0Var != null) {
                c0Var.k(localUiType);
            }
        }

        @Override // zn.b
        public void b(DownloadBean downloadBean) {
            com.transsion.postdetail.layer.local.c0 c0Var = LocalVideoDetailFragment.this.localVideoDot;
            if (c0Var != null) {
                c0Var.o();
            }
            com.transsion.postdetail.layer.local.c0 c0Var2 = LocalVideoDetailFragment.this.localVideoDot;
            if (c0Var2 != null) {
                c0Var2.g();
            }
            com.transsion.postdetail.layer.local.c0 c0Var3 = LocalVideoDetailFragment.this.localVideoDot;
            if (c0Var3 != null) {
                c0Var3.a();
            }
            com.transsion.postdetail.layer.local.c0 c0Var4 = LocalVideoDetailFragment.this.localVideoDot;
            if (c0Var4 != null) {
                c0Var4.n();
            }
        }

        @Override // zn.b
        public void c(DownloadBean downloadBean) {
            LocalVideoDetailFragment.this.isFloatShow = true;
        }

        @Override // zn.b
        public void d(DownloadBean downloadBean) {
            LocalVideoDetailFragment.this.B3();
            com.transsion.postdetail.layer.local.c0 c0Var = LocalVideoDetailFragment.this.localVideoDot;
            if (c0Var != null) {
                com.transsion.postdetail.layer.local.c0.c(c0Var, false, 1, null);
            }
        }
    }

    public static final class d implements zn.c {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(LocalVideoDetailFragment localVideoDetailFragment) {
            if (localVideoDetailFragment.isDownloadingPlayStart) {
                return;
            }
            a.a.f(wf.a.a, localVideoDetailFragment.TAG, "2------ playNextVideo, postDelayed start video", false, 4, (Object) null);
            localVideoDetailFragment.a2();
        }

        @Override // zn.c
        public void a(DownloadBean downloadBean, boolean z) {
            Intrinsics.h(downloadBean, "bean");
            a.a aVar = wf.a.a;
            a.a.v(aVar, "LocalVideoMiddle", "onNext", false, 4, (Object) null);
            LocalVideoDetailFragment localVideoDetailFragment = LocalVideoDetailFragment.this;
            localVideoDetailFragment.r3(localVideoDetailFragment.downloadBean, LocalVideoDetailFragment.this.playProgress, z);
            LocalVideoDetailFragment.this.e2().H();
            LocalVideoDetailFragment.this.e2().o();
            LocalVideoDetailFragment.this.B3();
            com.transsion.postdetail.layer.local.c0 c0Var = LocalVideoDetailFragment.this.localVideoDot;
            if (c0Var != null) {
                com.transsion.postdetail.layer.local.c0.c(c0Var, false, 1, null);
            }
            com.transsion.postdetail.layer.local.c0 c0Var2 = LocalVideoDetailFragment.this.localVideoDot;
            if (c0Var2 != null) {
                c0Var2.g();
            }
            com.transsion.postdetail.layer.local.c0 c0Var3 = LocalVideoDetailFragment.this.localVideoDot;
            if (c0Var3 != null) {
                c0Var3.a();
            }
            LocalVideoDetailFragment.this.isReload = false;
            LocalVideoDetailFragment.this.isNextPlayTipsShow = false;
            LocalVideoDetailFragment localVideoDetailFragment2 = LocalVideoDetailFragment.this;
            String name = downloadBean.getName();
            String str = BuildConfig.FLAVOR;
            if (name == null) {
                name = BuildConfig.FLAVOR;
            }
            localVideoDetailFragment2.name = name;
            LocalVideoDetailFragment localVideoDetailFragment3 = LocalVideoDetailFragment.this;
            String postId = downloadBean.getPostId();
            if (postId == null) {
                postId = BuildConfig.FLAVOR;
            }
            localVideoDetailFragment3.postId = postId;
            LocalVideoDetailFragment localVideoDetailFragment4 = LocalVideoDetailFragment.this;
            String subjectId = downloadBean.getSubjectId();
            if (subjectId == null) {
                subjectId = BuildConfig.FLAVOR;
            }
            localVideoDetailFragment4.subjectId = subjectId;
            LocalVideoDetailFragment.this.completed = downloadBean.getStatus() == 5;
            LocalVideoDetailFragment localVideoDetailFragment5 = LocalVideoDetailFragment.this;
            localVideoDetailFragment5.isDownloadingPlay = true ^ localVideoDetailFragment5.completed;
            LocalVideoDetailFragment localVideoDetailFragment6 = LocalVideoDetailFragment.this;
            String resourceId = downloadBean.getResourceId();
            if (resourceId == null) {
                resourceId = BuildConfig.FLAVOR;
            }
            localVideoDetailFragment6.resourceId = resourceId;
            LocalVideoDetailFragment.this.url = downloadBean.getUrl();
            LocalVideoDetailFragment localVideoDetailFragment7 = LocalVideoDetailFragment.this;
            String path = downloadBean.getPath();
            if (path != null) {
                str = path;
            }
            localVideoDetailFragment7.localPath = str;
            if (LocalVideoDetailFragment.this.isDownloadingPlay) {
                LocalVideoDetailFragment.this.e2().l(downloadBean);
                LocalVideoDetailFragment localVideoDetailFragment8 = LocalVideoDetailFragment.this;
                localVideoDetailFragment8.proxyUrl = localVideoDetailFragment8.e2().h(downloadBean);
            }
            LocalVideoDetailFragment.this.downloadBean = downloadBean;
            LocalVideoDetailFragment.this.E2();
            LocalVideoDetailFragment.this.subtitleList.clear();
            VideoSubtitleControl videoSubtitleControl = LocalVideoDetailFragment.this.subtitleControl;
            if (videoSubtitleControl != null) {
                videoSubtitleControl.X();
            }
            LocalVideoDetailFragment.this.A2(false);
            a.a.f(aVar, LocalVideoDetailFragment.this.TAG, "playNextVideo, episode = :" + downloadBean.getEpse() + "， isDownloadingPlay = " + LocalVideoDetailFragment.this.isDownloadingPlay, false, 4, (Object) null);
            LocalVideoDetailFragment.this.playProgress = 0L;
            LocalVideoDetailFragment.this.isPrepare = false;
            LocalVideoDetailFragment.this.unplaySeekTargetPercent = 0.0f;
        }

        @Override // zn.c
        public void b(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
            LocalVideoDetailFragment.this.isDownloadingPlayStart = false;
            Handler handler = LocalVideoDetailFragment.this.playingDownloadHandler;
            final LocalVideoDetailFragment localVideoDetailFragment = LocalVideoDetailFragment.this;
            handler.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.p0
                @Override // java.lang.Runnable
                public final void run() {
                    LocalVideoDetailFragment.d.d(LocalVideoDetailFragment.this);
                }
            }, 5000L);
        }
    }

    public static final class e implements lt.a {
        e() {
        }
    }

    public static final class f extends androidx.activity.u {
        f() {
            super(true);
        }

        public void handleOnBackPressed() {
            a.a.f(wf.a.a, LocalVideoDetailFragment.this.TAG, "----------handleOnBackPressed", false, 4, (Object) null);
            LocalVideoDetailFragment.this.h2().h(LayerFlag.BACK_PRESSED, new Object[0]);
        }
    }

    static final class g implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        g(Function1 function1) {
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

    public LocalVideoDetailFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.layerManager = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: com.transsion.postdetail.ui.fragment.h0
            public final Object invoke() {
                com.transsion.postdetail.layer.a U2;
                U2 = LocalVideoDetailFragment.U2();
                return U2;
            }
        });
        this.parentPosition = -1;
        this.position = -1;
        this.subtitleList = new ArrayList();
        this.videoDetailPlayDao = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.i0
            public final Object invoke() {
                VideoDetailPlayDao D3;
                D3 = LocalVideoDetailFragment.D3();
                return D3;
            }
        });
        this.downloadManager = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.j0
            public final Object invoke() {
                com.transsnet.downloader.manager.g X1;
                X1 = LocalVideoDetailFragment.X1();
                return X1;
            }
        });
        this.screenHelper = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.k0
            public final Object invoke() {
                ScreenRotationHelper u3;
                u3 = LocalVideoDetailFragment.u3(LocalVideoDetailFragment.this);
                return u3;
            }
        });
        this.playErrorCount = new AtomicInteger(0);
        this.sDownloadIngAndPlayTimeout = 15000;
        this.audioApi = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: com.transsion.postdetail.ui.fragment.l0
            public final Object invoke() {
                ep.a U1;
                U1 = LocalVideoDetailFragment.U1();
                return U1;
            }
        });
        this.localVideoAdHelper = new LocalVideoAdHelper();
        this.isNewPlayer = true;
        this.speedViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.postdetail.ui.dialog.k.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.x0 m101invoke() {
                androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
                Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m102invoke() {
                v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.playTimeoutHandler = new Handler(Looper.getMainLooper());
        this.playTimeout = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.m0
            public final Object invoke() {
                long h3;
                h3 = LocalVideoDetailFragment.h3();
                return Long.valueOf(h3);
            }
        });
        this.playTimeoutDp = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.n0
            public final Object invoke() {
                long f3;
                f3 = LocalVideoDetailFragment.f3();
                return Long.valueOf(f3);
            }
        });
        this.statusBarHeight = com.blankj.utilcode.util.d.c();
        this.orientationEventListener = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.o0
            public final Object invoke() {
                com.transsion.postdetail.util.n c3;
                c3 = LocalVideoDetailFragment.c3(LocalVideoDetailFragment.this);
                return c3;
            }
        });
        this.playerListener = new LocalVideoDetailFragment$playerListener$1(this);
        this.playTimeoutRunnable = new Runnable() { // from class: com.transsion.postdetail.ui.fragment.q
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoDetailFragment.g3(LocalVideoDetailFragment.this);
            }
        };
        this.downloadListener = new b();
        this.notNetRunnable = new Runnable() { // from class: com.transsion.postdetail.ui.fragment.a0
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoDetailFragment.X2(LocalVideoDetailFragment.this);
            }
        };
        this.curUiRotation = LocalUiType.MIDDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A2(boolean isFirst) {
        String name;
        DownloadBean downloadBean;
        DownloadBean downloadBean2;
        DownloadBean downloadBean3;
        DownloadBean downloadBean4;
        e2().g(this.downloadListener);
        DownloadBean q = DownloadEsHelper.m.a().q(this.resourceId);
        this.downloadBean = q;
        this.isSeries = q != null ? q.isSeries() : this.isSeries;
        String str = this.subjectId;
        int length = str.length();
        String str2 = BuildConfig.FLAVOR;
        if (length == 0 && ((downloadBean4 = this.downloadBean) == null || (str = downloadBean4.getSubjectId()) == null)) {
            str = BuildConfig.FLAVOR;
        }
        this.subjectId = str;
        String str3 = this.postId;
        if (str3.length() == 0 && ((downloadBean3 = this.downloadBean) == null || (str3 = downloadBean3.getPostId()) == null)) {
            str3 = BuildConfig.FLAVOR;
        }
        this.postId = str3;
        if (Intrinsics.c(this.pageFrom, MsgStyle.SOURCE_PUSH) && ((downloadBean = this.downloadBean) == null || ((downloadBean != null && downloadBean.getStatus() == 7) || ((downloadBean2 = this.downloadBean) != null && downloadBean2.getStatus() == 0)))) {
            fh.b.a.d(R.string.video_has_delete_tip);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        h2().h(LayerFlag.UPDATE_DOWNLOAD_DATA, this.downloadBean, this.pageFrom, Boolean.valueOf(isFirst));
        VideoSubtitleControl videoSubtitleControl = this.subtitleControl;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.h0(this.downloadBean);
        }
        com.transsion.postdetail.layer.local.c0 c0Var = this.localVideoDot;
        if (c0Var != null) {
            c0Var.z(this.downloadBean, this.pageFrom);
        }
        if (this.isDownloadingPlay) {
            DownloadBean downloadBean5 = this.downloadBean;
            if ((downloadBean5 != null ? downloadBean5.getProgress() : 0L) > 1048576 && !this.isDownloadingPlayStart) {
                a.a.f(wf.a.a, this.TAG, "3--------initDownloadBean, start video", false, 4, (Object) null);
                a2();
            }
        }
        A3();
        if (isFirst) {
            com.transsion.postdetail.layer.a h2 = h2();
            LayerFlag layerFlag = LayerFlag.REQUEST_FORYOU;
            DownloadBean downloadBean6 = this.downloadBean;
            Boolean valueOf = Boolean.valueOf(downloadBean6 == null || !downloadBean6.isInnerRes() || this.subjectId.length() == 0);
            DownloadBean downloadBean7 = this.downloadBean;
            if (downloadBean7 == null || !downloadBean7.isInnerRes() || this.subjectId.length() <= 0) {
                DownloadBean downloadBean8 = this.downloadBean;
                if (downloadBean8 != null && (name = downloadBean8.getName()) != null) {
                    str2 = name;
                }
            } else {
                str2 = this.subjectId;
            }
            h2.h(layerFlag, valueOf, str2);
            if (this.isSeries) {
                h2().h(LayerFlag.SERIES_INIT, this.subjectId, this.resourceId);
                F2();
            }
        }
        if (this.isDownloadingPlay && !yg.l.a.e()) {
            this.playingDownloadHandler.postDelayed(this.notNetRunnable, 6000L);
        }
        VideoSubtitleControl videoSubtitleControl2 = this.subtitleControl;
        if (videoSubtitleControl2 != null) {
            videoSubtitleControl2.p0(f2());
        }
        this.localVideoAdHelper.B2(this.downloadBean);
    }

    private final void A3() {
        DownloadBean downloadBean = this.downloadBean;
        if (downloadBean == null || !downloadBean.isVideo()) {
            return;
        }
        DownloadBean downloadBean2 = this.downloadBean;
        if (downloadBean2 == null || !downloadBean2.isMusic()) {
            kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.a()), (CoroutineContext) null, (CoroutineStart) null, new LocalVideoDetailFragment$setSubtitle$1(this, null), 3, (Object) null);
        }
    }

    private final void B2() {
        if (this.isDownloadingPlay) {
            this.isReload = false;
            this.isDownloadingPlayStart = false;
            e2().A();
            this.playingDownloadHandler.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.v
                @Override // java.lang.Runnable
                public final void run() {
                    LocalVideoDetailFragment.C2(LocalVideoDetailFragment.this);
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B3() {
        Map e2;
        Map e3;
        VideoSubtitleControl videoSubtitleControl = this.subtitleControl;
        if (videoSubtitleControl != null) {
            com.transsion.postdetail.layer.local.c0 c0Var = this.localVideoDot;
            if (c0Var != null && (e3 = c0Var.e()) != null) {
                e3.clear();
            }
            com.transsion.postdetail.layer.local.c0 c0Var2 = this.localVideoDot;
            if (c0Var2 == null || (e2 = c0Var2.e()) == null) {
                return;
            }
            e2.putAll(videoSubtitleControl.F());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(LocalVideoDetailFragment localVideoDetailFragment) {
        if (localVideoDetailFragment.isDownloadingPlayStart) {
            return;
        }
        localVideoDetailFragment.a2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C3(LocalUiType uiType) {
        ImageView imageView;
        wn.j jVar = (wn.j) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (jVar == null || (imageView = jVar.o) == null) ? null : imageView.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).topMargin = uiType == LocalUiType.LAND ? 0 : this.statusBarHeight;
    }

    private final void D2(boolean isSameResource) {
        com.transsion.player.orplayer.f fVar;
        gn.e currentMediaSource;
        com.transsion.postdetail.layer.local.c0 c0Var;
        DownloadBean downloadBean = this.downloadBean;
        boolean isMusic = downloadBean != null ? downloadBean.isMusic() : false;
        this.isMusic = isMusic;
        if (isMusic && (c0Var = this.localVideoDot) != null) {
            c0Var.D("music_play");
        }
        if (!this.isMusic || !isSameResource) {
            this.isBgPlaying = false;
            hn.d dVar = new hn.d(RenderType.SURFACE_VIEW, false, 1000, 0, 0, 0, 3, 0, 0L, 0, this.sDownloadIngAndPlayTimeout, false, false, false, false, false, null, 129976, null);
            com.transsion.player.orplayer.f fVar2 = this.orPlayer;
            if (fVar2 != null) {
                fVar2.setPlayerConfig(dVar);
                return;
            }
            return;
        }
        com.transsion.player.orplayer.f fVar3 = this.orPlayer;
        if (fVar3 != null && (currentMediaSource = fVar3.currentMediaSource()) != null) {
            MusicFloatManager.a aVar = MusicFloatManager.h;
            aVar.b().C(currentMediaSource.e());
            aVar.b().B(currentMediaSource.h());
        }
        this.isBgPlaying = true;
        com.transsion.player.orplayer.f fVar4 = this.orPlayer;
        if (fVar4 == null || fVar4.isPlaying() || (fVar = this.orPlayer) == null) {
            return;
        }
        fVar.play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao D3() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return appDatabase$f1.b(a).C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E2() {
        HashMap g2;
        HashMap hashMap = new HashMap();
        hashMap.put("resource_id", this.resourceId);
        hashMap.put("subject_id", this.subjectId);
        hashMap.put("post_id", this.postId);
        hashMap.put("url", this.url);
        DownloadBean downloadBean = this.downloadBean;
        hashMap.put("ops", downloadBean != null ? downloadBean.getOps() : null);
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g2 = logViewConfig.g()) == null) {
            return;
        }
        g2.putAll(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E3() {
        DownloadBean downloadBean;
        com.transsnet.downloader.util.h.a.c(MsgStyle.CUSTOM_LEFT_PIC_EMOJI);
        if (!this.isDownloadingPlay || (downloadBean = this.downloadBean) == null) {
            return;
        }
        DownloadUtil downloadUtil = DownloadUtil.a;
        Intrinsics.e(downloadBean);
        downloadUtil.B(downloadBean);
        DownloadBean downloadBean2 = this.downloadBean;
        Intrinsics.e(downloadBean2);
        w3(downloadBean2, true);
    }

    private final void F2() {
        a.a.f(wf.a.a, this.TAG, "---------initSeries", false, 4, (Object) null);
        h2().h(LayerFlag.SERIES_EVENT, new d());
    }

    private final void G2() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        VideoSubtitleControl videoSubtitleControl = new VideoSubtitleControl(requireActivity, "local_video_detail", com.transsion.baselib.helper.d.a.d(), f2(), new Function1() { // from class: com.transsion.postdetail.ui.fragment.w
            public final Object invoke(Object obj) {
                Unit H2;
                H2 = LocalVideoDetailFragment.H2(LocalVideoDetailFragment.this, ((Boolean) obj).booleanValue());
                return H2;
            }
        }, new Function2() { // from class: com.transsion.postdetail.ui.fragment.x
            public final Object invoke(Object obj, Object obj2) {
                Unit I2;
                I2 = LocalVideoDetailFragment.I2(LocalVideoDetailFragment.this, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                return I2;
            }
        }, new Function3() { // from class: com.transsion.postdetail.ui.fragment.y
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit J2;
                J2 = LocalVideoDetailFragment.J2(LocalVideoDetailFragment.this, (String) obj, (String) obj2, ((Integer) obj3).intValue());
                return J2;
            }
        }, new Function1() { // from class: com.transsion.postdetail.ui.fragment.z
            public final Object invoke(Object obj) {
                Unit K2;
                K2 = LocalVideoDetailFragment.K2((DubsInfo) obj);
                return K2;
            }
        }, new Function1() { // from class: com.transsion.postdetail.ui.fragment.b0
            public final Object invoke(Object obj) {
                Unit L2;
                L2 = LocalVideoDetailFragment.L2((List) obj);
                return L2;
            }
        }, (Function1) null, new Function2() { // from class: com.transsion.postdetail.ui.fragment.c0
            public final Object invoke(Object obj, Object obj2) {
                Unit M2;
                M2 = LocalVideoDetailFragment.M2(LocalVideoDetailFragment.this, (String) obj, (String) obj2);
                return M2;
            }
        }, DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED, (DefaultConstructorMarker) null);
        h2().h(LayerFlag.SUBTITLE_CONTROL, videoSubtitleControl);
        this.subtitleControl = videoSubtitleControl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H2(LocalVideoDetailFragment localVideoDetailFragment, boolean z) {
        localVideoDetailFragment.h2().g(z ? LayerFlag.LOADING_BEGIN : LayerFlag.LOADING_END, new Object[0]);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I2(LocalVideoDetailFragment localVideoDetailFragment, boolean z, boolean z2) {
        if (z) {
            localVideoDetailFragment.h2().h(LayerFlag.BOTTOM_CONTROL, Boolean.TRUE, Boolean.valueOf(z2));
        } else {
            localVideoDetailFragment.h2().h(LayerFlag.BOTTOM_CONTROL, Boolean.FALSE, Boolean.TRUE);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J2(LocalVideoDetailFragment localVideoDetailFragment, String str, String str2, int i) {
        Intrinsics.h(str, "lanName");
        Intrinsics.h(str2, "lan");
        com.transsion.postdetail.layer.local.c0 c0Var = localVideoDetailFragment.localVideoDot;
        if (c0Var != null) {
            c0Var.r(str, str2, i);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K2(DubsInfo dubsInfo) {
        Intrinsics.h(dubsInfo, "it");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L2(List list) {
        Intrinsics.h(list, "it");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M2(LocalVideoDetailFragment localVideoDetailFragment, String str, String str2) {
        com.transsion.postdetail.layer.local.c0 c0Var = localVideoDetailFragment.localVideoDot;
        if (c0Var == null) {
            return null;
        }
        c0Var.s(str, str2);
        return Unit.a;
    }

    private final void N2(DownloadBean bean) {
        if (bean != null) {
            String str = this.localPath;
            int length = str.length();
            String str2 = BuildConfig.FLAVOR;
            if (length == 0 && (str = bean.getPath()) == null) {
                str = BuildConfig.FLAVOR;
            }
            this.localPath = str;
            String str3 = this.url;
            if (str3.length() == 0) {
                str3 = bean.getUrl();
            }
            this.url = str3;
            String str4 = this.subjectId;
            if (str4.length() == 0 && (str4 = bean.getSubjectId()) == null) {
                str4 = BuildConfig.FLAVOR;
            }
            this.subjectId = str4;
            String str5 = this.name;
            if (str5.length() == 0 && (str5 = bean.getName()) == null) {
                str5 = BuildConfig.FLAVOR;
            }
            this.name = str5;
            String str6 = this.postId;
            if (str6.length() == 0) {
                String postId = bean.getPostId();
                if (postId != null) {
                    str2 = postId;
                }
                str6 = str2;
            }
            this.postId = str6;
            this.completed = bean.getStatus() == 5 || !bean.isInnerRes();
            this.isSeries = bean.isSeries();
            this.videoHeight = bean.getVideoHeight();
            this.videoWidth = bean.getVideoWidth();
            boolean z = this.completed;
            this.isDownloadingPlay = !z;
            if (!z && this.proxyUrl.length() == 0 && !this.isBgPlaying) {
                this.proxyUrl = e2().h(bean);
            }
        }
        V2(this.localPath);
        h2().h(LayerFlag.INIT_DATA, this.resourceId, this.subjectId, this.postId, Boolean.valueOf(this.isDownloadingPlay), Boolean.valueOf(this.isSeries));
        h2().h(LayerFlag.LOCAL_UI_CHANGED, LocalUiType.MIDDLE);
        E2();
        this.isNextPlayTipsShow = false;
        VideoSubtitleControl videoSubtitleControl = this.subtitleControl;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.g0(new e());
        }
    }

    private final void O2() {
        ConstraintLayout root;
        wn.j jVar = (wn.j) getMViewBinding();
        if (jVar == null || (root = jVar.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.r
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoDetailFragment.P2(LocalVideoDetailFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(LocalVideoDetailFragment localVideoDetailFragment) {
        FragmentActivity activity = localVideoDetailFragment.getActivity();
        if (activity != null) {
            cw.b c2 = cw.b.a.c();
            String str = localVideoDetailFragment.subjectId;
            DownloadBean downloadBean = localVideoDetailFragment.downloadBean;
            c2.f(activity, str, (String) null, "local_video_detail", downloadBean != null ? downloadBean.getOps() : null);
        }
    }

    private final void Q2() {
        String url;
        boolean z;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        this.orPlayerView = new ORPlayerView(requireActivity, RenderType.SURFACE_VIEW);
        com.transsnet.downloader.util.h.a.d(MsgStyle.CUSTOM_LEFT_PIC);
        String str = this.isDownloadingPlay ? this.proxyUrl : this.localPath;
        com.transsion.videofloat.manager.a0 a0Var = com.transsion.videofloat.manager.a0.a;
        LocalFloatManager localFloatManager = LocalFloatManager.b;
        DownloadBean downloadBean = this.downloadBean;
        if (downloadBean == null || (url = downloadBean.getResourceId()) == null) {
            DownloadBean downloadBean2 = this.downloadBean;
            url = downloadBean2 != null ? downloadBean2.getUrl() : "local";
        }
        com.transsion.player.orplayer.f b2 = a0Var.b(localFloatManager.h(url));
        String valueOf = String.valueOf(str.hashCode());
        on.e0 e0Var = on.e0.a;
        com.transsion.player.orplayer.f d2 = e0Var.d(valueOf);
        boolean z2 = d2 == null && b2 == null;
        this.isNewPlayer = z2;
        a.a aVar = wf.a.a;
        aVar.c(this.TAG, "initVideoPlayer, subjectId:" + this.subjectId + ", isNewPlayer:" + z2 + ", id:" + valueOf, true);
        if (b2 != null) {
            h2().h(LayerFlag.PLAYER_FOREGROUND, Boolean.FALSE);
            a.a.f(aVar, this.TAG, "initVideoPlayer, float player复用", false, 4, (Object) null);
            z = true;
        } else if (d2 != null) {
            h2().h(LayerFlag.PLAYER_FOREGROUND, Boolean.FALSE);
            a.a.f(aVar, this.TAG, "initVideoPlayer, music player复用", false, 4, (Object) null);
            z = true;
            b2 = d2;
        } else {
            b2 = e0Var.m();
            z = false;
        }
        this.orPlayer = b2;
        b.b.a(cw.b.a.c(), false, 1, (Object) null);
        D2(z);
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        if (fVar != null) {
            ORPlayerView oRPlayerView = this.orPlayerView;
            fVar.setSurfaceView(oRPlayerView != null ? oRPlayerView.getSurface() : null);
            fVar.setLooping(false);
            fVar.addPlayerListener(this.playerListener);
            com.transsion.baselib.helper.d dVar = com.transsion.baselib.helper.d.a;
            fVar.setSpeed(dVar.d());
            fVar.setScaleMode(dVar.c());
            com.transsion.postdetail.layer.local.c0 c0Var = this.localVideoDot;
            if (c0Var != null) {
                c0Var.H(fVar);
            }
        }
        h2().e(LayerFlag.SET_PLAYER, this.orPlayer, this.orPlayerView);
        p2().b().j(this, new g(new Function1() { // from class: com.transsion.postdetail.ui.fragment.u
            public final Object invoke(Object obj) {
                Unit R2;
                R2 = LocalVideoDetailFragment.R2(LocalVideoDetailFragment.this, (Float) obj);
                return R2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R2(LocalVideoDetailFragment localVideoDetailFragment, Float f2) {
        com.transsion.player.orplayer.f fVar = localVideoDetailFragment.orPlayer;
        if (fVar != null) {
            Intrinsics.e(f2);
            fVar.setSpeed(f2.floatValue());
        }
        localVideoDetailFragment.h2().h(LayerFlag.UPDATE_SPEED, f2);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean T2() {
        return cw.e.a.b().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.a U1() {
        return (ep.a) TheRouter.d(ep.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.postdetail.layer.a U2() {
        return new com.transsion.postdetail.layer.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V1(boolean isPortrait) {
        LocalUiType localUiType = this.curUiRotation;
        boolean isResumed = isResumed();
        LocalUiType localUiType2 = this.mUiType;
        StringBuilder sb = new StringBuilder();
        sb.append("竖屏: ");
        sb.append(isPortrait);
        sb.append("，curUiRation: ");
        sb.append(localUiType);
        sb.append(", isResumed");
        sb.append(isResumed);
        sb.append(", ui:");
        sb.append(localUiType2);
        com.transsion.postdetail.layer.local.c0 c0Var = this.localVideoDot;
        if (c0Var == null || !c0Var.d()) {
            if (isPortrait) {
                p3();
            }
            LocalUiType localUiType3 = isPortrait ? LocalUiType.MIDDLE : LocalUiType.LAND;
            if (!isResumed() || this.curUiRotation == localUiType3 || localUiType3 == this.mUiType) {
                this.curUiRotation = localUiType3;
                return;
            }
            this.curUiRotation = localUiType3;
            qi.h.a.r("auto_screen", MapsKt.f(new Pair("orientation", localUiType3 == LocalUiType.LAND ? "land" : "port")));
            h2().h(LayerFlag.SCREEN_ORIENTATION_CHANGED, localUiType3);
        }
    }

    private final void V2(String path) {
        int i;
        int i2 = this.videoHeight;
        if (i2 <= 0 || (i = this.videoWidth) <= 0) {
            kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), (CoroutineContext) null, (CoroutineStart) null, new LocalVideoDetailFragment$localVideoPrepare$1(path, this, null), 3, (Object) null);
            a.a.f(wf.a.a, this.TAG, "play path = " + path, false, 4, (Object) null);
            return;
        }
        a.a.v(wf.a.a, this.TAG, "localVideoPrepare, videoWidth  = " + i + ",videoHeight = " + i2, false, 4, (Object) null);
        b3(this.videoWidth, this.videoHeight, path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g X1() {
        return com.transsnet.downloader.manager.p.a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X2(LocalVideoDetailFragment localVideoDetailFragment) {
        a.a.f(wf.a.a, localVideoDetailFragment.TAG, "---------no net， show error", false, 4, (Object) null);
        localVideoDetailFragment.h2().h(LayerFlag.NETWORK_CHANGE, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y1() {
        if (yg.l.a.e()) {
            a.a.f(wf.a.a, this.TAG, "---------has net， delay show toast", false, 4, (Object) null);
            getHandler().postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.f0
                @Override // java.lang.Runnable
                public final void run() {
                    LocalVideoDetailFragment.Z1(LocalVideoDetailFragment.this);
                }
            }, 10000L);
        } else {
            a.a.f(wf.a.a, this.TAG, "---------no net， show error", false, 4, (Object) null);
            h2().h(LayerFlag.NETWORK_CHANGE, Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y2(DownloadBean bean) {
        this.lastReloadTime = SystemClock.elapsedRealtime();
        if (!this.isDownloadingPlayStart && bean.getProgress() >= ui.b.a.d()) {
            a.a.f(wf.a.a, this.TAG, "1------ onDownloading, start video", false, 4, (Object) null);
            a2();
            return;
        }
        if (bean.getProgress() < 10485760 || this.isPrepare || SystemClock.elapsedRealtime() - this.lastReloadTime <= this.sDownloadIngAndPlayTimeout) {
            return;
        }
        wf.a.a.w("long_video_play", "video error，reload~~ from onDownloading progress=" + bean.getProgress() + ",isPrepare=" + this.isPrepare + ",waitTime=" + (System.currentTimeMillis() - this.lastReloadTime), true);
        this.lastReloadTime = SystemClock.elapsedRealtime();
        o3(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(LocalVideoDetailFragment localVideoDetailFragment) {
        localVideoDetailFragment.h2().h(LayerFlag.SHOW_TOAST, Utils.a().getString(R.string.downloading_play_wait_msg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2() {
        this.isPrepare = false;
        this.isDownloadingPlayStart = true;
        com.transsion.postdetail.layer.local.c0 c0Var = this.localVideoDot;
        if (c0Var != null) {
            c0Var.a();
        }
        com.transsnet.downloader.util.h.a.b("2");
        j3(this.proxyUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a3() {
        h2().g(LayerFlag.COMPLETION, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b3(int videoWidth, int videoHeight, String path) {
        h2().h(LayerFlag.ADD_SURFACE, Integer.valueOf(videoWidth), Integer.valueOf(videoHeight));
        if (!this.isDownloadingPlay) {
            this.isPrepare = false;
            com.transsnet.downloader.util.h.a.b("2");
            com.transsion.postdetail.layer.local.c0 c0Var = this.localVideoDot;
            if (c0Var != null) {
                c0Var.a();
            }
            j3(path);
            return;
        }
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        if (fVar != null && !fVar.isPlaying()) {
            h2().g(LayerFlag.LOADING_BEGIN, new Object[0]);
        }
        DownloadBean downloadBean = this.downloadBean;
        if ((downloadBean != null ? downloadBean.getProgress() : 0L) >= 1048576 || yg.l.a.e()) {
            return;
        }
        h2().h(LayerFlag.NETWORK_CHANGE, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ep.a c2() {
        return (ep.a) this.audioApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.postdetail.util.n c3(final LocalVideoDetailFragment localVideoDetailFragment) {
        FragmentActivity activity = localVideoDetailFragment.getActivity();
        if (activity != null) {
            return new com.transsion.postdetail.util.n(activity, new Function1() { // from class: com.transsion.postdetail.ui.fragment.e0
                public final Object invoke(Object obj) {
                    Unit d3;
                    d3 = LocalVideoDetailFragment.d3(LocalVideoDetailFragment.this, ((Integer) obj).intValue());
                    return d3;
                }
            });
        }
        return null;
    }

    private final Intent d2() {
        Intent intent = new Intent();
        intent.putExtra("path", "/video/detail");
        intent.putExtra("id", this.subjectId);
        DownloadBean downloadBean = this.downloadBean;
        intent.putExtra("extra_resource_id", downloadBean != null ? downloadBean.getResourceId() : null);
        DownloadBean downloadBean2 = this.downloadBean;
        intent.putExtra("extra_local_path", downloadBean2 != null ? downloadBean2.getPath() : null);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d3(LocalVideoDetailFragment localVideoDetailFragment, int i) {
        if (i == 1 || i == 3) {
            localVideoDetailFragment.h2().h(LayerFlag.UPDATE_ROTATION, Integer.valueOf(i));
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.g e2() {
        return (com.transsnet.downloader.manager.g) this.downloadManager.getValue();
    }

    private final List f2() {
        DownloadBean downloadBean = this.downloadBean;
        String currentDubLanName = downloadBean != null ? downloadBean.getCurrentDubLanName() : null;
        if (currentDubLanName == null || currentDubLanName.length() == 0) {
            return CollectionsKt.l();
        }
        String str = this.subjectId;
        DownloadBean downloadBean2 = this.downloadBean;
        String currentDubLanName2 = downloadBean2 != null ? downloadBean2.getCurrentDubLanName() : null;
        DownloadBean downloadBean3 = this.downloadBean;
        DubsInfo dubsInfo = new DubsInfo(str, currentDubLanName2, downloadBean3 != null ? downloadBean3.getCurrentDubLanCode() : null, false, 8, null);
        dubsInfo.setSelected(true);
        return CollectionsKt.e(dubsInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long f3() {
        Long x;
        ConfigBean c2 = cm.f.c.a().c("sb_lv_play_timeout_dp", true);
        String value = c2 != null ? c2.getValue() : null;
        if (value == null || value.length() == 0 || (x = StringsKt.x(value)) == null) {
            return 12000L;
        }
        return x.longValue();
    }

    private final Intent g2(String pageName) {
        to.a aVar = (to.a) TheRouter.d(to.a.class, new Object[0]);
        DownloadBean downloadBean = this.downloadBean;
        boolean isCompleted = downloadBean != null ? downloadBean.isCompleted() : false;
        StringBuilder sb = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb.append("/video/detail");
        sb.append("&");
        sb.append("extra_resource_id");
        sb.append("=");
        DownloadBean downloadBean2 = this.downloadBean;
        sb.append(downloadBean2 != null ? downloadBean2.getResourceId() : null);
        sb.append("&");
        sb.append("extra_local_path");
        sb.append("=");
        DownloadBean downloadBean3 = this.downloadBean;
        sb.append(downloadBean3 != null ? downloadBean3.getPath() : null);
        sb.append("&");
        sb.append("extra_url");
        sb.append("=");
        DownloadBean downloadBean4 = this.downloadBean;
        sb.append(downloadBean4 != null ? downloadBean4.getUrl() : null);
        sb.append("&");
        sb.append("extra_page_from");
        sb.append("=");
        sb.append(pageName);
        sb.append("&");
        sb.append("extra_completed");
        sb.append("=");
        sb.append(isCompleted);
        if (aVar == null) {
            return null;
        }
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        Intent a2 = aVar.a(a);
        if (a2 == null) {
            return null;
        }
        a2.addFlags(603979776);
        a2.setData(Uri.parse(sb.toString()));
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g3(LocalVideoDetailFragment localVideoDetailFragment) {
        String str = localVideoDetailFragment.curTimeoutPlayPath;
        if (str != null) {
            com.transsion.player.orplayer.f fVar = localVideoDetailFragment.orPlayer;
            if (fVar != null) {
                fVar.reset();
            }
            com.transsion.player.orplayer.f fVar2 = localVideoDetailFragment.orPlayer;
            if (fVar2 != null) {
                fVar2.stop();
            }
            com.transsion.postdetail.layer.local.c0 c0Var = localVideoDetailFragment.localVideoDot;
            if (c0Var != null) {
                c0Var.L(true);
            }
            String valueOf = String.valueOf(str.hashCode());
            wf.a.a.c("long_video_play", "playerTimeout,change 2 software decoder, id:" + valueOf + ", path = " + str, true);
            com.transsion.player.orplayer.f fVar3 = localVideoDetailFragment.orPlayer;
            if (fVar3 != null) {
                fVar3.enableHardwareDecoder(false);
            }
            com.transsion.player.orplayer.f fVar4 = localVideoDetailFragment.orPlayer;
            if (fVar4 != null) {
                gn.e eVar = new gn.e(valueOf, str, 0, null, localVideoDetailFragment.i2(), 12, null);
                MusicFloatManager.a aVar = MusicFloatManager.h;
                aVar.b().C(eVar.e());
                aVar.b().B(eVar.h());
                fVar4.setDataSource(eVar);
            }
            com.transsion.player.orplayer.f fVar5 = localVideoDetailFragment.orPlayer;
            if (fVar5 != null) {
                fVar5.prepare();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getHandler() {
        return (Handler) this.handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.postdetail.layer.a h2() {
        return (com.transsion.postdetail.layer.a) this.layerManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h3() {
        Long x;
        ConfigBean c2 = cm.f.c.a().c("sb_lv_play_timeout", true);
        String value = c2 != null ? c2.getValue() : null;
        if (value == null || value.length() == 0 || (x = StringsKt.x(value)) == null) {
            return 8000L;
        }
        return x.longValue();
    }

    private final MediaItem i2() {
        DownloadBean downloadBean = this.downloadBean;
        String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
        String str = this.subjectId;
        DownloadBean downloadBean2 = this.downloadBean;
        String cover = downloadBean2 != null ? downloadBean2.getCover() : null;
        String t = MusicFloatManager.h.b().t(this.subjectId);
        PendingIntent j2 = j2();
        Intent d2 = d2();
        DownloadBean downloadBean3 = this.downloadBean;
        boolean z = false;
        if (downloadBean3 != null && downloadBean3.getType() == 6) {
            z = true;
        }
        boolean z2 = z;
        DownloadBean downloadBean4 = this.downloadBean;
        return new MediaItem(totalTitleName, BuildConfig.FLAVOR, cover, null, null, null, j2, d2, str, t, Boolean.valueOf(z2), "local_detail", null, downloadBean4 != null ? downloadBean4.getOps() : null, 4152, null);
    }

    private final void i3(long progress) {
        if (this.isBgPlaying || !this.isNewPlayer) {
            return;
        }
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        if (fVar != null) {
            fVar.seekTo(progress);
        }
        com.transsion.player.orplayer.f fVar2 = this.orPlayer;
        if (fVar2 != null) {
            fVar2.play();
        }
        if (this.unplaySeekTargetPercent <= 0.0f && progress >= 1000 && !this.isReload) {
            h2().h(LayerFlag.SHOW_TOAST, Utils.a().getString(R.string.last_played_time) + " " + com.transsion.postdetail.util.m.d(progress));
        }
        if (!this.isDownloadingPlay || this.isReload) {
            return;
        }
        com.transsion.postdetail.layer.a h2 = h2();
        LayerFlag layerFlag = LayerFlag.SHOW_TOAST;
        String string = Utils.a().getString(R.string.analysing_from);
        String[] stringArray = Utils.a().getResources().getStringArray(R$array.analysing_array);
        Intrinsics.g(stringArray, "getStringArray(...)");
        h2.h(layerFlag, string + " [" + ArraysKt.v0(stringArray, Random.Default) + "]");
    }

    private final void initAd() {
        AppCompatImageView appCompatImageView;
        LocalVideoAdHelper localVideoAdHelper = this.localVideoAdHelper;
        wn.j jVar = (wn.j) getMViewBinding();
        DownloadBean downloadBean = this.downloadBean;
        localVideoAdHelper.t2(jVar, downloadBean != null ? downloadBean.getGenre() : null, new Function1() { // from class: com.transsion.postdetail.ui.fragment.s
            public final Object invoke(Object obj) {
                Unit u2;
                u2 = LocalVideoDetailFragment.u2(LocalVideoDetailFragment.this, ((Boolean) obj).booleanValue());
                return u2;
            }
        });
        wn.j jVar2 = (wn.j) getMViewBinding();
        if (jVar2 == null || (appCompatImageView = jVar2.n) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoDetailFragment.v2(LocalVideoDetailFragment.this, view);
            }
        });
    }

    private final void initAudioListener() {
        ep.a c2 = c2();
        if (c2 != null) {
            c2.addPlayerListener(this);
        }
        ep.a c22 = c2();
        if (c22 != null) {
            c22.pause();
        }
    }

    private final void initView() {
        wn.w wVar;
        wn.u uVar;
        wn.y yVar;
        ConstraintLayout root;
        wn.j jVar = (wn.j) getMViewBinding();
        if (jVar != null && (root = jVar.getRoot()) != null) {
            root.setKeepScreenOn(true);
        }
        wn.j jVar2 = (wn.j) getMViewBinding();
        ConstraintLayout constraintLayout = null;
        ConstraintLayout constraintLayout2 = (jVar2 == null || (yVar = jVar2.m) == null) ? null : yVar.i;
        if (constraintLayout2 != null) {
            h2().h(LayerFlag.INIT_VIEW_TYPE, constraintLayout2, LocalUiType.PORTRAIT);
        }
        wn.j jVar3 = (wn.j) getMViewBinding();
        ConstraintLayout constraintLayout3 = (jVar3 == null || (uVar = jVar3.k) == null) ? null : uVar.l;
        if (constraintLayout3 != null) {
            h2().h(LayerFlag.INIT_VIEW_TYPE, constraintLayout3, LocalUiType.LAND);
        }
        wn.j jVar4 = (wn.j) getMViewBinding();
        if (jVar4 != null && (wVar = jVar4.l) != null) {
            constraintLayout = wVar.r;
        }
        if (constraintLayout != null) {
            h2().h(LayerFlag.INIT_VIEW_TYPE, constraintLayout, LocalUiType.MIDDLE);
        }
        C3(LocalUiType.PORTRAIT);
        w2();
        Context context = getContext();
        if (context == null || com.transsion.baseui.util.b.a(context)) {
            return;
        }
        o2().h();
    }

    private final PendingIntent j2() {
        return PendingIntent.getActivity(Utils.a(), 0, g2("media_notification"), l2());
    }

    private final void j3(String path) {
        VideoSubtitleControl videoSubtitleControl;
        a.a aVar = wf.a.a;
        boolean z = this.isBgPlaying;
        DownloadBean downloadBean = this.downloadBean;
        String subjectId = downloadBean != null ? downloadBean.getSubjectId() : null;
        DownloadBean downloadBean2 = this.downloadBean;
        String totalTitleName = downloadBean2 != null ? downloadBean2.getTotalTitleName() : null;
        DownloadBean downloadBean3 = this.downloadBean;
        String resourceId = downloadBean3 != null ? downloadBean3.getResourceId() : null;
        DownloadBean downloadBean4 = this.downloadBean;
        String createAtFormat = downloadBean4 != null ? downloadBean4.getCreateAtFormat() : null;
        aVar.c("long_video_play", "playerSetDataSource, isBgPlaying = " + z + ", subjectId = " + subjectId + ", name:" + totalTitleName + "resourceId = " + resourceId + ", downloadTime:" + createAtFormat + "， orPlayer:" + this.orPlayer + ", path = " + path, true);
        if (!this.isNewPlayer && (videoSubtitleControl = this.subtitleControl) != null) {
            videoSubtitleControl.b0(true);
        }
        if (this.isBgPlaying || !this.isNewPlayer) {
            this.isNewPlayer = true;
            return;
        }
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        if (fVar != null) {
            fVar.clearScreen();
        }
        DownloadBean downloadBean5 = this.downloadBean;
        if (downloadBean5 != null) {
            downloadBean5.setPlayingUrl(path);
        }
        com.transsion.player.orplayer.f fVar2 = this.orPlayer;
        if (fVar2 != null) {
            gn.e eVar = new gn.e(String.valueOf(path.hashCode()), path, 0, null, i2(), 12, null);
            MusicFloatManager.a aVar2 = MusicFloatManager.h;
            aVar2.b().C(eVar.e());
            aVar2.b().B(eVar.h());
            fVar2.setDataSource(eVar);
        }
        com.transsion.player.orplayer.f fVar3 = this.orPlayer;
        if (fVar3 != null) {
            fVar3.prepare();
        }
        q3();
        this.curTimeoutPlayPath = path;
        this.playTimeoutHandler.postDelayed(this.playTimeoutRunnable, this.isDownloadingPlay ? n2() : m2());
    }

    private final com.transsion.postdetail.util.n k2() {
        return (com.transsion.postdetail.util.n) this.orientationEventListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k3(DownloadBean downloadBean) {
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        this.duration = fVar != null ? fVar.getDuration() : 0L;
        wf.a.a.c("long_video_play", "onPrepare history progress " + (downloadBean != null ? Long.valueOf(downloadBean.getReadProgress()) : null) + "， duration = " + this.duration + ", unplaySeekProgress = " + this.unplaySeekTargetPercent + ", id =" + (downloadBean != null ? downloadBean.getResourceId() : null) + ", epse = " + (downloadBean != null ? Integer.valueOf(downloadBean.getEpse()) : null), true);
        final Ref.LongRef longRef = new Ref.LongRef();
        long readProgress = downloadBean != null ? downloadBean.getReadProgress() : 0L;
        longRef.element = readProgress;
        if (Math.abs(readProgress - this.duration) < 100) {
            longRef.element = 0L;
        }
        float f2 = this.unplaySeekTargetPercent;
        if (f2 > 0.0f) {
            longRef.element = (long) (f2 * this.duration);
        }
        if (this.subtitleList.isEmpty()) {
            i3(longRef.element);
            return;
        }
        ORPlayerView oRPlayerView = this.orPlayerView;
        if (oRPlayerView != null) {
            oRPlayerView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.g0
                @Override // java.lang.Runnable
                public final void run() {
                    LocalVideoDetailFragment.l3(LocalVideoDetailFragment.this, longRef);
                }
            }, 200L);
        }
    }

    private final int l2() {
        return Build.VERSION.SDK_INT >= 31 ? 67108864 : 134217728;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l3(LocalVideoDetailFragment localVideoDetailFragment, Ref.LongRef longRef) {
        localVideoDetailFragment.i3(longRef.element);
    }

    private final long m2() {
        return ((Number) this.playTimeout.getValue()).longValue();
    }

    private final long n2() {
        return ((Number) this.playTimeoutDp.getValue()).longValue();
    }

    private final ScreenRotationHelper o2() {
        return (ScreenRotationHelper) this.screenHelper.getValue();
    }

    public static /* synthetic */ void o3(LocalVideoDetailFragment localVideoDetailFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        localVideoDetailFragment.n3(z);
    }

    private final com.transsion.postdetail.ui.dialog.k p2() {
        return (com.transsion.postdetail.ui.dialog.k) this.speedViewModel.getValue();
    }

    private final void p3() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        List<BaseDialog> y0 = getParentFragmentManager().y0();
        Intrinsics.g(y0, "getFragments(...)");
        for (BaseDialog baseDialog : y0) {
            if (baseDialog instanceof BaseDialog) {
                try {
                    Result.Companion companion = Result.Companion;
                    baseDialog.dismissAllowingStateLoss();
                    Result.constructor-impl(Unit.a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.a(th2));
                }
            }
        }
    }

    private final VideoDetailPlayDao q2() {
        return (VideoDetailPlayDao) this.videoDetailPlayDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q3() {
        this.curTimeoutPlayPath = null;
        com.transsion.postdetail.layer.local.c0 c0Var = this.localVideoDot;
        if (c0Var != null) {
            c0Var.L(false);
        }
        this.playTimeoutHandler.removeCallbacks(this.playTimeoutRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r3(DownloadBean cvideoBean, long playProgress, boolean completed) {
        kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), (CoroutineContext) null, (CoroutineStart) null, new LocalVideoDetailFragment$save$1(completed, this, playProgress, cvideoBean, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler s2() {
        Looper myLooper = Looper.myLooper();
        Intrinsics.e(myLooper);
        return new Handler(myLooper);
    }

    static /* synthetic */ void s3(LocalVideoDetailFragment localVideoDetailFragment, DownloadBean downloadBean, long j, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        localVideoDetailFragment.r3(downloadBean, j, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t2() {
        VideoSubtitleControl videoSubtitleControl;
        if (!isAdded() || isDetached() || isRemoving() || this.isMusic) {
            return;
        }
        a.a.r(wf.a.a, "ORSubtitle", new String[]{"没字幕准备提示用户"}, false, 4, (Object) null);
        if (!com.transsion.baselib.report.launch.b.a.b().getBoolean("no_subtitle_tip_again", true) || (videoSubtitleControl = this.subtitleControl) == null) {
            return;
        }
        VideoSubtitleControl.k0(videoSubtitleControl, true, false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t3(DownloadBean downloadBean, Continuation continuation) {
        String str;
        Long l;
        String subjectId = downloadBean.getSubjectId();
        String str2 = subjectId == null ? BuildConfig.FLAVOR : subjectId;
        String resourceId = downloadBean.getResourceId();
        String str3 = resourceId == null ? BuildConfig.FLAVOR : resourceId;
        int ep2 = downloadBean.getEp();
        int se = downloadBean.getSe();
        long readProgress = downloadBean.getReadProgress();
        Long duration = downloadBean.getDuration();
        String subjectName = downloadBean.getSubjectName();
        if (subjectName == null) {
            subjectName = downloadBean.getFileName();
        }
        String str4 = subjectName;
        String url = downloadBean.getUrl();
        long lastPlayTimeStamp = downloadBean.getLastPlayTimeStamp();
        String cover = downloadBean.getCover();
        String thumbnail = downloadBean.getThumbnail();
        String averageHueLight = downloadBean.getAverageHueLight();
        Integer subjectDurationSeconds = downloadBean.getSubjectDurationSeconds();
        if (subjectDurationSeconds != null) {
            int intValue = subjectDurationSeconds.intValue();
            str = BuildConfig.FLAVOR;
            l = Boxing.e(intValue);
        } else {
            str = BuildConfig.FLAVOR;
            l = null;
        }
        Long l2 = l;
        int subjectType = downloadBean.getSubjectType();
        String value = PlayMode.DOWNLOAD.getValue();
        String url2 = downloadBean.getUrl();
        String path = downloadBean.getPath();
        Long size = downloadBean.getSize();
        long longValue = size != null ? size.longValue() : 0L;
        String ops = downloadBean.getOps();
        Object p = q2().p(new VideoDetailPlayBean(str2, str3, ep2, se, readProgress, str4, cover, thumbnail, url, lastPlayTimeStamp, null, duration, l2, averageHueLight, Boxing.d(subjectType), false, value, url2, path, longValue, null, null, null, false, false, false, ops == null ? str : ops, 66061312, null), continuation);
        return p == IntrinsicsKt.f() ? p : Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u2(LocalVideoDetailFragment localVideoDetailFragment, boolean z) {
        com.transsion.player.orplayer.f fVar;
        com.transsion.player.orplayer.f fVar2;
        localVideoDetailFragment.isAdShowing = z;
        if (z && (fVar = localVideoDetailFragment.orPlayer) != null && fVar.isPlaying() && (fVar2 = localVideoDetailFragment.orPlayer) != null) {
            fVar2.pause();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScreenRotationHelper u3(LocalVideoDetailFragment localVideoDetailFragment) {
        Context requireContext = localVideoDetailFragment.requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        return new ScreenRotationHelper(requireContext, new LocalVideoDetailFragment$screenHelper$2$1(localVideoDetailFragment), new LocalVideoDetailFragment$screenHelper$2$2(localVideoDetailFragment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(LocalVideoDetailFragment localVideoDetailFragment, View view) {
        LocalUiType localUiType = localVideoDetailFragment.mUiType;
        LocalUiType localUiType2 = LocalUiType.LAND;
        if (localUiType == localUiType2) {
            localUiType2 = LocalUiType.MIDDLE;
        }
        localVideoDetailFragment.h2().h(LayerFlag.SCREEN_ORIENTATION_CHANGED, localUiType2);
    }

    private final void w2() {
        com.transsion.baselib.report.k.a.g(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w3(DownloadBean bean, boolean isStart) {
        int longValue;
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = this.duration;
        long j2 = 0;
        long j3 = 10000;
        int i = j > 0 ? (int) ((this.playProgress / j) * 10000) : 0;
        boolean z = false;
        boolean z2 = false;
        for (DownloadRange downloadRange : bean.getDownloadRanges()) {
            float start = downloadRange.getStart();
            Intrinsics.e(bean.getSize());
            float longValue2 = start / r14.longValue();
            float f2 = j3;
            int i2 = (int) (longValue2 * f2);
            if (downloadRange.getProgress() == j2) {
                longValue = 0;
            } else {
                float f3 = downloadRange.totalProgress();
                Intrinsics.e(bean.getSize());
                longValue = (int) ((f3 / r6.longValue()) * f2);
            }
            if (z) {
                z2 = true;
                if (i < i2) {
                    if (longValue < i) {
                        longValue = i;
                        i2 = longValue;
                    } else {
                        i2 = i;
                    }
                }
                z = false;
            }
            if (i > 0 && !z2 && i > longValue) {
                z = true;
            }
            linkedHashMap.put(Integer.valueOf(i2), Integer.valueOf(longValue));
            j2 = 0;
            j3 = 10000;
        }
        if (!isStart) {
            this.playingDownloadHandler.removeCallbacksAndMessages(null);
            h2().h(LayerFlag.DOWNLOAD_PROGRESS, linkedHashMap);
            return;
        }
        a.a.f(wf.a.a, this.TAG, "start setDownloadedProgress, progressList = " + linkedHashMap, false, 4, (Object) null);
        this.playingDownloadHandler.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.d0
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoDetailFragment.x3(LocalVideoDetailFragment.this, linkedHashMap);
            }
        }, 1000L);
    }

    private final void x2() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("extra_local_path");
            String str = BuildConfig.FLAVOR;
            if (string == null) {
                string = BuildConfig.FLAVOR;
            }
            this.localPath = string;
            String string2 = arguments.getString("extra_url");
            if (string2 == null) {
                string2 = BuildConfig.FLAVOR;
            }
            this.url = string2;
            String string3 = arguments.getString("extra_proxy_url");
            if (string3 == null) {
                string3 = BuildConfig.FLAVOR;
            }
            this.proxyUrl = string3;
            String string4 = arguments.getString("extra_resource_id");
            if (string4 == null) {
                string4 = BuildConfig.FLAVOR;
            }
            this.resourceId = string4;
            String string5 = arguments.getString("extra_subject_id");
            if (string5 == null) {
                string5 = BuildConfig.FLAVOR;
            }
            this.subjectId = string5;
            String string6 = arguments.getString("extra_name");
            if (string6 == null) {
                string6 = BuildConfig.FLAVOR;
            }
            this.name = string6;
            String string7 = arguments.getString("extra_post_id");
            if (string7 == null) {
                string7 = BuildConfig.FLAVOR;
            }
            this.postId = string7;
            this.completed = arguments.getBoolean("extra_completed");
            this.isSeries = arguments.getBoolean("extra_is_series");
            String string8 = arguments.getString("extra_page_from");
            if (string8 != null) {
                str = string8;
            }
            this.pageFrom = str;
            this.videoHeight = arguments.getInt("extra_height");
            this.videoWidth = arguments.getInt("extra_width");
            this.parentPosition = arguments.getInt("extra_parent_position", -1);
            this.position = arguments.getInt("extra_position", -1);
            this.isDownloadingPlay = !this.completed;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x3(LocalVideoDetailFragment localVideoDetailFragment, Map map) {
        localVideoDetailFragment.h2().h(LayerFlag.DOWNLOAD_PROGRESS, map);
    }

    private final void y2() {
        x2();
        z2();
        G2();
        A2(true);
        Q2();
        initAudioListener();
        N2(this.downloadBean);
        B2();
        initAd();
        O2();
        MediaItem q = MusicFloatManager.h.b().q();
        if (q != null) {
            q.setPageName("local_detail");
        }
    }

    private final void z2() {
        com.transsion.postdetail.layer.local.c0 c0Var = new com.transsion.postdetail.layer.local.c0();
        this.localVideoDot = c0Var;
        c0Var.g();
        com.transsion.postdetail.layer.local.c0 c0Var2 = this.localVideoDot;
        if (c0Var2 != null) {
            c0Var2.B(this.position);
        }
        com.transsion.postdetail.layer.local.c0 c0Var3 = this.localVideoDot;
        if (c0Var3 != null) {
            c0Var3.A(this.parentPosition);
        }
        h2().h(LayerFlag.LAYER_EVENT, new c());
    }

    /* renamed from: S2, reason: from getter */
    public final boolean getIsAdShowing() {
        return this.isAdShowing;
    }

    public final void W1(String subjectId, String resourceId) {
        h2().h(LayerFlag.SERIES_PLAY, subjectId, resourceId);
    }

    public final void W2(boolean isLock) {
        com.transsion.postdetail.layer.local.c0 c0Var = this.localVideoDot;
        if (c0Var != null) {
            c0Var.E(isLock);
        }
    }

    public final void Z2() {
        this.localVideoAdHelper.s2();
    }

    public final void b2() {
        com.transsion.postdetail.layer.local.c0 c0Var = this.localVideoDot;
        if (c0Var != null) {
            c0Var.p();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i, int i2, qn.d dVar) {
        e.a.a(this, z, i, i2, dVar);
    }

    public final void e3() {
        com.transsion.player.orplayer.f fVar;
        com.transsion.player.orplayer.f fVar2 = this.orPlayer;
        if (fVar2 == null || fVar2.isPlaying() || this.isAdShowing || (fVar = this.orPlayer) == null) {
            return;
        }
        fVar.play();
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.b(this);
    }

    public void initViewData() {
        HashMap g2;
        MusicFloatManager.h.b().u();
        initView();
        y2();
        if (this.pageFrom.length() == 0) {
            this.pageFrom = qi.h.a.h();
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g2 = logViewConfig.g()) == null) {
            return;
        }
    }

    public void initViewModel() {
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public boolean isRegisteDeviceKeyMonitor() {
        return true;
    }

    public final void m3() {
        if (!this.isMusic) {
            h2().h(LayerFlag.RELEASE_PLAYER, new Object[0]);
        }
        q3();
    }

    public final void n3(boolean fromClicked) {
        if (this.isBgPlaying || !this.isNewPlayer) {
            return;
        }
        if (fromClicked) {
            this.playErrorCount.set(0);
        }
        if (this.playErrorCount.get() > 2) {
            return;
        }
        this.errorInfo = null;
        this.playErrorCount.getAndAdd(1);
        wf.a.a.w("long_video_play", "video error，reload~~", true);
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        if (fVar != null) {
            fVar.stop();
        }
        com.transsion.player.orplayer.f fVar2 = this.orPlayer;
        if (fVar2 != null) {
            fVar2.reset();
        }
        this.isPrepare = false;
        this.isReload = true;
        h2().g(LayerFlag.LOADING_BEGIN, new Object[0]);
        j3(!this.isDownloadingPlay ? this.localPath : this.proxyUrl);
    }

    public qi.b newLogViewConfig() {
        return new qi.b("local_video_detail", false, 2, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        e.a.c(this, eVar);
    }

    public void onAttach(Context context) {
        Intrinsics.h(context, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(context);
        h2().d(new com.transsion.postdetail.layer.local.e1(this));
        h2().d(new com.transsion.postdetail.layer.local.u0(this));
        h2().d(new LocalVideoMiddleLayer(this));
        h2().e(LayerFlag.SET_MANAGER, h2());
        requireActivity().getOnBackPressedDispatcher().i(this, new f());
    }

    @Override // com.transsion.baselib.report.k$a
    public void onBackgroundStatusChange(boolean isBackground) {
        com.transsion.postdetail.layer.local.c0 c0Var;
        if (!isBackground || (c0Var = this.localVideoDot) == null) {
            return;
        }
        c0Var.b(true);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j, gn.e eVar) {
        e.a.d(this, j, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e eVar) {
        e.a.e(this, eVar);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        ep.b bVar;
        Intrinsics.h(newConfig, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(newConfig);
        a.a.f(wf.a.a, this.TAG, "onConfigurationChanged " + newConfig.orientation, false, 4, (Object) null);
        int i = newConfig.orientation;
        if (i == 2) {
            ep.a c2 = c2();
            if (c2 != null) {
                c2.pause();
                return;
            }
            return;
        }
        if (i != 1 || (bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0])) == null) {
            return;
        }
        bVar.show();
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        com.transsion.player.orplayer.f fVar;
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        DownloadBean downloadBean = this.downloadBean;
        if (downloadBean != null) {
            wf.a.a.c(com.transsion.baselib.report.a.a.a(), "网络连接成功开始检测字幕,name:" + downloadBean.getTotalTitleName() + ", subtitleResId:" + downloadBean.getSubtitleResId(), true);
            h.b.a(com.transsion.subtitle.h.a.b(), downloadBean, (Function1) null, 2, (Object) null);
        }
        if (this.isDownloadingPlay && isResumed()) {
            DownloadBean downloadBean2 = this.downloadBean;
            if (downloadBean2 != null) {
                e2().l(downloadBean2);
            }
            a.a.v(wf.a.a, this.TAG, "onNetworkConnected", false, 4, (Object) null);
            com.transsion.player.orplayer.f fVar2 = this.orPlayer;
            if ((fVar2 != null && !fVar2.isPlaying()) || ((fVar = this.orPlayer) != null && fVar.isLoading())) {
                h2().g(LayerFlag.LOADING_BEGIN, new Object[0]);
                Y1();
                if (this.errorInfo != null || this.isAdShowing) {
                    n3(false);
                } else {
                    com.transsion.player.orplayer.f fVar3 = this.orPlayer;
                    if (fVar3 != null) {
                        fVar3.play();
                    }
                }
            }
            h2().h(LayerFlag.NETWORK_CHANGE, Boolean.TRUE);
            if (this.isPlayerNetTimeout) {
                h2().h(LayerFlag.PLAYER_TIMEOUT_TIPS, new Object[0]);
            }
        }
    }

    public void onDestroy() {
        ConstraintLayout root;
        super.onDestroy();
        a.a.f(wf.a.a, this.TAG, "onDestroy", false, 4, (Object) null);
        DownloadBean downloadBean = this.downloadBean;
        if (downloadBean != null) {
            downloadBean.setQuitDPRestart(true);
            downloadBean.setDownloadingPlay(false);
        }
        com.transsion.baselib.report.k.a.t(this);
        if (this.isDownloadingPlay) {
            e2().d();
        }
        B3();
        com.transsion.postdetail.layer.local.c0 c0Var = this.localVideoDot;
        if (c0Var != null) {
            com.transsion.postdetail.layer.local.c0.c(c0Var, false, 1, null);
        }
        wn.j jVar = (wn.j) getMViewBinding();
        if (jVar != null && (root = jVar.getRoot()) != null) {
            root.setKeepScreenOn(false);
        }
        VideoSubtitleControl videoSubtitleControl = this.subtitleControl;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.M();
        }
        h2().h(LayerFlag.FRAGMENT_DESTROY, new Object[0]);
        ep.a c2 = c2();
        if (c2 != null) {
            c2.removePlayerListener(this);
        }
        e2().o();
        e2().k(this.downloadListener);
        this.localVideoAdHelper.r2();
        com.transsion.player.orplayer.f fVar = this.orPlayer;
        if (fVar != null) {
            fVar.removePlayerListener(this.playerListener);
        }
        this.playTimeoutHandler.removeCallbacks(this.playTimeoutRunnable);
        Context context = getContext();
        if (context != null && !com.transsion.baseui.util.b.a(context)) {
            o2().l();
        }
        setMViewBinding((f4.a) null);
    }

    public void onDisconnected() {
        if (this.isDownloadingPlay) {
            a.a aVar = wf.a.a;
            com.transsion.player.orplayer.f fVar = this.orPlayer;
            Boolean valueOf = fVar != null ? Boolean.valueOf(fVar.isLoading()) : null;
            aVar.c("long_video_play", "onNetworkDisconnected  isLoading= " + valueOf + ", isPrepare = " + this.isPrepare + ", isDownloadingPlayStart =" + this.isDownloadingPlayStart, true);
            com.transsion.player.orplayer.f fVar2 = this.orPlayer;
            if ((fVar2 == null || !fVar2.isLoading()) && this.isDownloadingPlayStart && this.isPrepare) {
                return;
            }
            h2().h(LayerFlag.NETWORK_CHANGE, Boolean.FALSE);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z) {
        e.a.g(this, z);
    }

    public void onHomeClick() {
        super.onHomeClick();
        wf.a.a.c("VideoFloat", "local onHomeClick", true);
        h2().h(LayerFlag.SHOW_FLOAT_2_WINDOW, FloatActionType.HOME);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z) {
        e.a.h(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(gn.e eVar) {
        e.a.i(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(gn.e eVar) {
        e.a.k(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i, float f2, gn.e eVar) {
        e.a.m(this, i, f2, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        e.a.o(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
    }

    public void onPause() {
        super.onPause();
        if (this.isMusic) {
            return;
        }
        h2().h(LayerFlag.FRAGMENT_PAUSE, new Object[0]);
        com.transsion.postdetail.util.n k2 = k2();
        if (k2 != null) {
            k2.disable();
        }
        this.localVideoAdHelper.z2();
    }

    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super/*androidx.fragment.app.Fragment*/.onPictureInPictureModeChanged(isInPictureInPictureMode);
        h2().h(LayerFlag.INTO_PIP, Boolean.valueOf(isInPictureInPictureMode));
        cw.e.a.b().onPipModeChanged(isInPictureInPictureMode);
        com.transsion.postdetail.layer.local.c0 c0Var = this.localVideoDot;
        if (c0Var != null) {
            c0Var.C(isInPictureInPictureMode);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError playError, gn.e eVar) {
        e.a.q(this, playError, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(gn.e eVar) {
        e.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.v(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(gn.e eVar) {
        e.a.w(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j, gn.e eVar) {
        e.a.y(this, j, eVar);
    }

    public void onRecentClick() {
        super.onRecentClick();
        wf.a.a.c("VideoFloat", "local onRecentClick", true);
        h2().h(LayerFlag.SHOW_FLOAT_2_WINDOW, FloatActionType.HOME);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        e.a.A(this);
    }

    public void onResume() {
        super.onResume();
        if (this.isMusic) {
            return;
        }
        h2().h(LayerFlag.FRAGMENT_RESUME, new Object[0]);
        com.transsion.postdetail.util.n k2 = k2();
        if (k2 != null) {
            k2.enable();
        }
        this.localVideoAdHelper.A2();
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.B(this);
    }

    public void onStop() {
        s3(this, this.downloadBean, this.playProgress, false, 4, null);
        if (!this.isMusic) {
            h2().h(LayerFlag.FRAGMENT_STOP, new Object[0]);
        }
        super/*androidx.fragment.app.Fragment*/.onStop();
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

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(gn.e eVar) {
        e.a.F(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i, int i2) {
        e.a.H(this, i, i2);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e mediaSource) {
        e.a.I(this, mediaSource);
    }

    /* renamed from: r2, reason: merged with bridge method [inline-methods] */
    public wn.j getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        wn.j c2 = wn.j.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void retryLoadData() {
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.K(this);
    }

    public final void v3(long progress, float targetPercent) {
        com.transsion.postdetail.layer.local.c0 c0Var = this.localVideoDot;
        if (c0Var != null) {
            c0Var.p();
        }
        if (!this.isPrepare) {
            this.unplaySeekTargetPercent = targetPercent;
        }
        this.playProgress = progress;
    }

    public final void y3(LocalUiType localUiType) {
        this.mUiType = localUiType;
    }

    public final void z3(boolean z) {
        this.isPauseState = z;
    }
}
