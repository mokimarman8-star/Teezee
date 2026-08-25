package com.transsion.publish;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.util.networkinfo.NetworkType;
import com.transsion.publish.api.bean.MediaAudioEntity;
import com.transsion.publish.api.bean.MediaCoverEntity;
import com.transsion.publish.api.bean.MediaImageEntity;
import com.transsion.publish.api.bean.MediaVideoEntity;
import com.transsion.publish.api.bean.RequestPostEntity;
import com.transsion.publish.api.bean.RequestPostMediaEntity;
import com.transsion.publish.bean.PublishResult;
import com.transsion.publish.bean.PublishValue;
import com.transsion.publish.net.PostResuleEntity;
import com.transsion.upload.bean.TstTokenEntity;
import com.transsion.upload.bean.UploadFileType;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import dg.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import oo.b;
import qo.h;
import uu.c;
import wf.a;

@Keep
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u009d\u00012\u00020\u0001:\u0002\u009e\u0001B\t\b\u0012¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0003J'\u0010\u0018\u001a\u00020\u000b2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00192\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u001bJ!\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\"\u001a\u00020\u000b2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00192\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010\u001bJ'\u0010%\u001a\u00020\u000b2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00192\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b%\u0010\u001bJ\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\tH\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\tH\u0002¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\tH\u0002¢\u0006\u0004\b/\u0010-J\u000f\u00100\u001a\u00020\u000bH\u0002¢\u0006\u0004\b0\u0010\u0003J\u000f\u00101\u001a\u00020\tH\u0002¢\u0006\u0004\b1\u0010-J\u000f\u00102\u001a\u00020\u000bH\u0002¢\u0006\u0004\b2\u0010\u0003J\u000f\u00103\u001a\u00020\u000bH\u0002¢\u0006\u0004\b3\u0010\u0003J\u0017\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0014H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u000bH\u0002¢\u0006\u0004\b7\u0010\u0003J\u000f\u00108\u001a\u00020\u000bH\u0002¢\u0006\u0004\b8\u0010\u0003J'\u0010=\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:H\u0002¢\u0006\u0004\b=\u0010>J'\u0010?\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:H\u0002¢\u0006\u0004\b?\u0010>J/\u0010A\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010@\u001a\u00020\u0014H\u0002¢\u0006\u0004\bA\u0010BJ\u001f\u00104\u001a\u00020\u00142\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:H\u0002¢\u0006\u0004\b4\u0010CJ\u0017\u0010E\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u0014H\u0002¢\u0006\u0004\bE\u0010FJ'\u0010G\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:H\u0003¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u000bH\u0002¢\u0006\u0004\bI\u0010\u0003J\u000f\u0010J\u001a\u00020\u000bH\u0002¢\u0006\u0004\bJ\u0010\u0003J\u000f\u0010K\u001a\u00020\u000bH\u0002¢\u0006\u0004\bK\u0010\u0003J\u000f\u0010L\u001a\u00020\u000bH\u0002¢\u0006\u0004\bL\u0010\u0003J\u0017\u0010N\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u000eH\u0002¢\u0006\u0004\bN\u0010OJ\u001f\u0010N\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\bN\u0010PJ\u0017\u0010Q\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u000eH\u0002¢\u0006\u0004\bQ\u0010OJ\u0019\u0010S\u001a\u00020\t2\b\u0010R\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bS\u0010+J+\u0010V\u001a\u00020\u000b2\b\u0010T\u001a\u0004\u0018\u00010\u00042\b\u0010U\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\bV\u0010WJ\u0019\u0010Y\u001a\u00020\u000b2\b\u0010X\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\bY\u0010ZJ\u0019\u0010[\u001a\u00020\u000b2\b\u0010X\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b[\u0010ZJ+\u0010^\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\u00142\b\b\u0002\u00104\u001a\u00020\u00142\b\b\u0002\u0010]\u001a\u00020\u0004H\u0002¢\u0006\u0004\b^\u0010_J\u0017\u0010b\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020`H\u0002¢\u0006\u0004\bb\u0010cJ\u0017\u0010d\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u0004H\u0002¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020\u000bH\u0002¢\u0006\u0004\bf\u0010\u0003J\u001d\u0010i\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u000e2\u0006\u0010h\u001a\u00020\u0014¢\u0006\u0004\bi\u0010jJ\r\u0010k\u001a\u00020\t¢\u0006\u0004\bk\u0010-J\r\u0010l\u001a\u00020\t¢\u0006\u0004\bl\u0010-J\r\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\n\u0010\u0003J\r\u0010m\u001a\u00020\u000b¢\u0006\u0004\bm\u0010\u0003J\r\u0010n\u001a\u00020\u000b¢\u0006\u0004\bn\u0010\u0003J\r\u0010o\u001a\u00020\u000b¢\u0006\u0004\bo\u0010\u0003J\u0017\u0010r\u001a\u00020\u000b2\b\u0010q\u001a\u0004\u0018\u00010p¢\u0006\u0004\br\u0010sJ\r\u0010t\u001a\u00020\u0004¢\u0006\u0004\bt\u0010\u0006R\"\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020v0u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010yR\u0016\u0010h\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010zR\u0016\u0010{\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010zR\u0016\u0010|\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0014\u0010~\u001a\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b~\u0010zR\u0014\u0010\u007f\u001a\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u007f\u0010zR\u0016\u0010\u0080\u0001\u001a\u00020\u00148\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010zR\u0016\u0010\u0081\u0001\u001a\u00020\u00148\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010zR\u0019\u0010\u0082\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0084\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0083\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0017\u0010k\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bk\u0010\u0088\u0001R\u0019\u0010\u0089\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0088\u0001R\u0017\u00103\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b3\u0010\u0088\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0088\u0001R\u0019\u0010\u008b\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0088\u0001R\u001a\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u008f\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010zR!\u0010\u0095\u0001\u001a\u00030\u0090\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001d\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00198\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009b\u0001\u001a\u00020`8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001¨\u0006\u009f\u0001"}, d2 = {"Lcom/transsion/publish/PublishManager;", "", "<init>", "()V", "", "getClassTag", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "", "retry", "", "startPost", "(Landroid/content/Context;Z)V", "Lcom/transsion/publish/api/bean/RequestPostEntity;", "postEntity", "disposePost", "(Landroid/content/Context;Lcom/transsion/publish/api/bean/RequestPostEntity;Z)V", "Lcom/transsion/publish/api/bean/MediaImageEntity;", "it", "", "size", "check", "(Lcom/transsion/publish/api/bean/MediaImageEntity;I)V", "disposeImage", "", "images", "(Ljava/util/List;Z)V", "Lcom/transsion/publish/api/bean/MediaCoverEntity;", "cover", "disposeCover", "(Lcom/transsion/publish/api/bean/MediaCoverEntity;Z)V", "Lcom/transsion/publish/api/bean/MediaVideoEntity;", "videos", "disposeVideo", "Lcom/transsion/publish/api/bean/MediaAudioEntity;", "audios", "disposeAudio", "Luu/a;", "uploadCallback", "()Luu/a;", "key", "isUploadSucceed", "(Ljava/lang/String;)Z", "checkImageNext", "()Z", "checkImageUploadState", "isInterceptProgress", "setLastRefreshTime", "isCompleteAll", "uploadSuccess", "uploadFail", "progress", "uploadIng", "(I)V", "uploadSucceed", "netWorkMonitor", "uploadKey", "", "currentSize", "totalSize", "uploadProgress", "(Ljava/lang/String;JJ)V", "disposeImageProgress", "mediaType", "disposeAudioVideoProgress", "(Ljava/lang/String;JJI)V", "(JJ)I", "value", "isComplete", "(I)Z", "checkUploadState", "(Ljava/lang/String;JJ)Z", "imageSourceReplace", "videoSourceReplace", "audioSourceReplace", "coverSourceReplace", "requestPost", "create", "(Lcom/transsion/publish/api/bean/RequestPostEntity;)V", "(Lcom/transsion/publish/api/bean/RequestPostEntity;Z)V", "filterExceptionData", "url", "isExceptionData", "code", "message", "failureCallback", "(Ljava/lang/String;Ljava/lang/String;Z)V", "data", "successCallback", "(Ljava/lang/Object;)V", "postSucceed", "state", "postId", "postUploadState", "(IILjava/lang/String;)V", "Ljava/lang/Runnable;", "runnable", "asyn", "(Ljava/lang/Runnable;)V", "syncPost", "(Ljava/lang/String;)V", "setNetMonitor", "requestPostEntity", "publishType", "publish", "(Lcom/transsion/publish/api/bean/RequestPostEntity;I)V", "uploading", "isFail", "cancel", "reset", "onDisconnected", "Lcom/tn/lib/util/networkinfo/NetworkType;", "networkType", "onConnected", "(Lcom/tn/lib/util/networkinfo/NetworkType;)V", "getPageName", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/transsion/publish/bean/PublishValue;", "publishQueue", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/transsion/publish/api/bean/RequestPostEntity;", "I", "uploadType", "tempBucket", "Ljava/lang/String;", "postProgress", "coverProgress", "imageProgress", "INTERVALTIME", "lastRefreshTime", "J", "NETWORK_MONITOR", "Lcom/transsion/publish/NetworkReceiver;", "netWorkReceiver", "Lcom/transsion/publish/NetworkReceiver;", "Z", "cancelIng", "uploadRetry", "createIng", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "currentProgress", "Loo/b;", "publishModel$delegate", "Lkotlin/Lazy;", "getPublishModel", "()Loo/b;", "publishModel", "Lcom/transsion/upload/bean/TstTokenEntity;", "tstToken", "Lcom/transsion/upload/bean/TstTokenEntity;", "compressorList", "Ljava/util/List;", "netRunnable", "Ljava/lang/Runnable;", "Companion", "a", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class PublishManager {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final Lazy<PublishManager> INSTANCE$delegate = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.publish.g
        public final Object invoke() {
            PublishManager INSTANCE_delegate$lambda$27;
            INSTANCE_delegate$lambda$27 = PublishManager.INSTANCE_delegate$lambda$27();
            return INSTANCE_delegate$lambda$27;
        }
    });
    public static final String TAG = "TNPublish";
    private volatile boolean cancelIng;
    private volatile boolean createIng;
    private int currentProgress;
    private long lastRefreshTime;
    private NetworkReceiver netWorkReceiver;
    private RequestPostEntity postEntity;
    private int publishType;
    private TstTokenEntity tstToken;
    private volatile boolean uploadFail;
    private volatile boolean uploadRetry;
    private int uploadType;
    private volatile boolean uploading;
    private ConcurrentHashMap<String, PublishValue> publishQueue = new ConcurrentHashMap<>();
    private String tempBucket = "";
    private final int postProgress = 10;
    private final int coverProgress = 10;
    private final int imageProgress = 90;
    private final int INTERVALTIME = 2000;
    private long NETWORK_MONITOR = 3600000;
    private Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: publishModel$delegate, reason: from kotlin metadata */
    private final Lazy publishModel = LazyKt.b(new d());
    private final List<MediaImageEntity> compressorList = new ArrayList();
    private Runnable netRunnable = new e(this);

    private PublishManager() {
        setNetMonitor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PublishManager INSTANCE_delegate$lambda$27() {
        return new PublishManager();
    }

    private final void asyn(Runnable runnable) {
        p.b.a().d(runnable);
    }

    private final void audioSourceReplace() {
        RequestPostMediaEntity media;
        RequestPostEntity requestPostEntity = this.postEntity;
        List<MediaAudioEntity> audio = (requestPostEntity == null || (media = requestPostEntity.getMedia()) == null) ? null : media.getAudio();
        if (audio != null) {
            for (MediaAudioEntity mediaAudioEntity : audio) {
                PublishValue publishValue = this.publishQueue.get(mediaAudioEntity.getUrl());
                mediaAudioEntity.setUrl(String.valueOf(publishValue != null ? publishValue.getUploadUrl() : null));
            }
        }
        coverSourceReplace();
        RequestPostEntity requestPostEntity2 = this.postEntity;
        if (requestPostEntity2 != null) {
            create(requestPostEntity2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void check(MediaImageEntity it, int size) {
        this.compressorList.add(it);
        if (this.compressorList.size() == size) {
            disposeImage();
        }
    }

    private final boolean checkImageNext() {
        RequestPostMediaEntity media;
        RequestPostEntity requestPostEntity = this.postEntity;
        return 1 == this.uploadType && ((requestPostEntity == null || (media = requestPostEntity.getMedia()) == null) ? null : media.getImage()) != null;
    }

    private final boolean checkImageUploadState() {
        RequestPostMediaEntity media;
        RequestPostEntity requestPostEntity = this.postEntity;
        List image = (requestPostEntity == null || (media = requestPostEntity.getMedia()) == null) ? null : media.getImage();
        if (1 != this.uploadType || image == null) {
            return true;
        }
        return isCompleteAll();
    }

    @Deprecated
    private final boolean checkUploadState(String uploadKey, long currentSize, long totalSize) {
        return false;
    }

    private static final void checkUploadState$lambda$17(PublishManager publishManager, String str) {
        PublishValue publishValue = publishManager.publishQueue.get(str);
        if (publishValue != null) {
            publishValue.getState();
        }
    }

    private final void coverSourceReplace() {
        RequestPostMediaEntity media;
        MediaCoverEntity cover;
        RequestPostMediaEntity media2;
        MediaCoverEntity cover2;
        RequestPostEntity requestPostEntity = this.postEntity;
        String url = (requestPostEntity == null || (media2 = requestPostEntity.getMedia()) == null || (cover2 = media2.getCover()) == null) ? null : cover2.getUrl();
        RequestPostEntity requestPostEntity2 = this.postEntity;
        if (requestPostEntity2 == null || (media = requestPostEntity2.getMedia()) == null || (cover = media.getCover()) == null) {
            return;
        }
        PublishValue publishValue = this.publishQueue.get(url);
        cover.setUrl(publishValue != null ? publishValue.getUploadUrl() : null);
    }

    private final void create(RequestPostEntity requestPost) {
        create(requestPost, false);
    }

    private final void create(RequestPostEntity requestPost, boolean retry) {
        if (TextUtils.isEmpty(this.tempBucket)) {
            RequestPostMediaEntity media = requestPost.getMedia();
            if (media != null) {
                media.setTempBucket("tempBucket");
            }
        } else {
            RequestPostMediaEntity media2 = requestPost.getMedia();
            if (media2 != null) {
                media2.setTempBucket(this.tempBucket);
            }
        }
        filterExceptionData(requestPost);
        a.a aVar = a.a;
        a.a.f(aVar, TAG, "Upload create...", false, 4, (Object) null);
        if (this.createIng) {
            a.a.f(aVar, TAG, "Repeated requests", false, 4, (Object) null);
            return;
        }
        this.createIng = true;
        int i = this.publishType;
        if (i == 2) {
            a.a.f(aVar, TAG, "Upload create... type_post_publish", false, 4, (Object) null);
            getPublishModel().e(requestPost).f(d.a.c()).subscribe(new b(this, retry));
        } else if (i == 1) {
            a.a.f(aVar, TAG, "Upload create... type_star_publish", false, 4, (Object) null);
            getPublishModel().f(requestPost).f(d.a.c()).subscribe(new c(this, retry, requestPost));
        }
    }

    private final void disposeAudio(List<MediaAudioEntity> audios, boolean retry) {
        if (audios != null) {
            for (MediaAudioEntity mediaAudioEntity : audios) {
                if (!isUploadSucceed(mediaAudioEntity.getUrl())) {
                    this.publishQueue.put(mediaAudioEntity.getUrl(), new PublishValue(2));
                    c.a.f(mediaAudioEntity.getUrl(), UploadFileType.OBJECT_NAME_AUDIO, true, uploadCallback());
                }
            }
        }
    }

    private final void disposeAudioVideoProgress(String uploadKey, long currentSize, long totalSize, int mediaType) {
        int progress = progress(currentSize, totalSize);
        PublishValue publishValue = this.publishQueue.get(uploadKey);
        Integer valueOf = publishValue != null ? Integer.valueOf(publishValue.getFileType()) : null;
        if (valueOf != null && valueOf.intValue() == mediaType) {
            int i = progress - this.postProgress;
            a.a.f(a.a, TAG, "uploadProgress progress: " + progress + " " + uploadKey, false, 4, (Object) null);
            for (Map.Entry<String, PublishValue> entry : this.publishQueue.entrySet()) {
                if (!Intrinsics.c(entry.getKey(), uploadKey) && entry.getValue().getFileType() != mediaType && entry.getValue().getState() == 1) {
                    i += this.coverProgress;
                }
            }
            if (i <= 0) {
                i = 0;
            }
            uploadIng(i);
        }
    }

    private final void disposeCover(MediaCoverEntity cover, boolean retry) {
        String url;
        if (isUploadSucceed(cover != null ? cover.getUrl() : null) || cover == null || (url = cover.getUrl()) == null) {
            return;
        }
        this.publishQueue.put(url, new PublishValue(1));
        c.a.f(url, UploadFileType.OBJECT_NAME_IMAGE, true, uploadCallback());
    }

    private final void disposeImage() {
        this.publishQueue.clear();
        int i = 0;
        for (Object obj : this.compressorList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            MediaImageEntity mediaImageEntity = (MediaImageEntity) obj;
            this.publishQueue.put(mediaImageEntity.getUrl(), new PublishValue(1));
            c.a.f(mediaImageEntity.getUrl(), UploadFileType.OBJECT_NAME_IMAGE, true, uploadCallback());
            i = i2;
        }
    }

    private final void disposeImage(List<MediaImageEntity> images, boolean retry) {
        this.compressorList.clear();
        if (images != null) {
            int i = 0;
            for (Object obj : images) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                MediaImageEntity mediaImageEntity = (MediaImageEntity) obj;
                xj.a.a.a(Utils.a()).l(mediaImageEntity.getUrl()).j(new f()).m(new d(mediaImageEntity, this, images)).k();
                i = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean disposeImage$lambda$9$lambda$8(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intrinsics.e(str);
        Locale locale = Locale.getDefault();
        Intrinsics.g(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        return !StringsKt.G(lowerCase, ".gif", false, 2, (Object) null);
    }

    private final void disposeImageProgress(String uploadKey, long currentSize, long totalSize) {
        int i;
        ConcurrentHashMap<String, PublishValue> concurrentHashMap = this.publishQueue;
        if (concurrentHashMap != null && concurrentHashMap.isEmpty()) {
            a.a.f(a.a, TAG, "disposeImageProgress isNullOrEmpty", false, 4, (Object) null);
            return;
        }
        ConcurrentHashMap<String, PublishValue> concurrentHashMap2 = this.publishQueue;
        Integer valueOf = concurrentHashMap2 != null ? Integer.valueOf(concurrentHashMap2.size()) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            if (isInterceptProgress()) {
                checkUploadState(uploadKey, currentSize, totalSize);
                return;
            }
            int progress = progress(currentSize, totalSize);
            int i2 = progress - this.postProgress;
            i = i2 >= 0 ? i2 : 0;
            uploadIng(i);
            a.a.f(a.a, TAG, "single uploadProgress progress " + progress + " imageProgress:" + i + " " + uploadKey, false, 4, (Object) null);
            return;
        }
        if (isInterceptProgress()) {
            checkUploadState(uploadKey, currentSize, totalSize);
            return;
        }
        int i3 = this.imageProgress;
        Intrinsics.e(valueOf);
        int intValue = i3 / valueOf.intValue();
        Iterator<Map.Entry<String, PublishValue>> it = this.publishQueue.entrySet().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            if (it.next().getValue().getState() == 1) {
                i4 += intValue;
            }
        }
        int i6 = i4 - this.postProgress;
        i = i6 > 0 ? i6 : 0;
        uploadIng(i4);
        a.a.f(a.a, TAG, "uploadProgress imageProgress:" + i + " " + uploadKey, false, 4, (Object) null);
        setLastRefreshTime();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, com.transsion.publish.api.bean.RequestPostMediaEntity] */
    private final void disposePost(Context context, RequestPostEntity postEntity, boolean retry) {
        RequestPostMediaEntity requestPostMediaEntity;
        List audio;
        List video;
        MediaVideoEntity mediaVideoEntity;
        RequestPostMediaEntity requestPostMediaEntity2;
        List image;
        a.a.f(a.a, TAG, "uploading=" + this.uploading, false, 4, (Object) null);
        wu.a.a.b(getClassTag() + " --> publish() --> publishType = " + this.publishType + " --> postEntity = " + postEntity);
        this.uploading = true;
        postUploadState$default(this, 0, 0, null, 4, null);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? media = postEntity.getMedia();
        ref$ObjectRef.element = media;
        r3 = null;
        String str = null;
        if ((media != 0 ? media.getImage() : null) != null && (requestPostMediaEntity2 = (RequestPostMediaEntity) ref$ObjectRef.element) != null && (image = requestPostMediaEntity2.getImage()) != null && (!image.isEmpty())) {
            this.uploadType = 1;
            disposeImage(((RequestPostMediaEntity) ref$ObjectRef.element).getImage(), retry);
            return;
        }
        RequestPostMediaEntity requestPostMediaEntity3 = (RequestPostMediaEntity) ref$ObjectRef.element;
        if ((requestPostMediaEntity3 != null ? requestPostMediaEntity3.getVideo() : null) != null && (video = ((RequestPostMediaEntity) ref$ObjectRef.element).getVideo()) != null && (!video.isEmpty())) {
            this.uploadType = 4;
            List video2 = ((RequestPostMediaEntity) ref$ObjectRef.element).getVideo();
            if (video2 != null && (mediaVideoEntity = (MediaVideoEntity) video2.get(0)) != null) {
                str = mediaVideoEntity.getUrl();
            }
            h.a.a(context, str, new e(this, ref$ObjectRef, retry, postEntity));
            return;
        }
        RequestPostMediaEntity requestPostMediaEntity4 = (RequestPostMediaEntity) ref$ObjectRef.element;
        if ((requestPostMediaEntity4 != null ? requestPostMediaEntity4.getAudio() : null) == null || (requestPostMediaEntity = (RequestPostMediaEntity) ref$ObjectRef.element) == null || (audio = requestPostMediaEntity.getAudio()) == null || !(!audio.isEmpty())) {
            RequestPostMediaEntity media2 = postEntity.getMedia();
            if (media2 != null) {
                media2.setMediaType(0);
            }
            create(postEntity, retry);
            return;
        }
        this.uploadType = 2;
        disposeAudio(((RequestPostMediaEntity) ref$ObjectRef.element).getAudio(), retry);
        if (((RequestPostMediaEntity) ref$ObjectRef.element).getCover() != null) {
            disposeCover(((RequestPostMediaEntity) ref$ObjectRef.element).getCover(), retry);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disposeVideo(List<MediaVideoEntity> videos, boolean retry) {
        if (videos != null) {
            for (MediaVideoEntity mediaVideoEntity : videos) {
                if (!isUploadSucceed(mediaVideoEntity.getUrl())) {
                    this.publishQueue.put(mediaVideoEntity.getUrl(), new PublishValue(4));
                    c.a.f(mediaVideoEntity.getUrl(), UploadFileType.OBJECT_NAME_VIDEO, true, uploadCallback());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void failureCallback(String code, String message, boolean retry) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_code", code == null ? "" : code);
        RequestPostEntity requestPostEntity = this.postEntity;
        hashMap.put("subject_id", String.valueOf(requestPostEntity != null ? requestPostEntity.getSubjectId() : null));
        qi.h.a.o(getPageName(), hashMap);
        this.createIng = false;
        a.a aVar = a.a;
        a.a.f(aVar, TAG, "Upload onFailure... code:" + code + "msg:" + message, false, 4, (Object) null);
        a.a.f(aVar, TAG, "Upload onFailure... retry:" + retry + ",uploadFail:" + this.uploadFail + ",uploadRetry:" + this.uploadRetry, false, 4, (Object) null);
        if (retry || this.uploadRetry) {
            reset();
        } else {
            uploadFail();
        }
    }

    private final void filterExceptionData(RequestPostEntity requestPost) {
        List video;
        List image;
        RequestPostMediaEntity media = requestPost.getMedia();
        Iterator it = null;
        Iterator it2 = (media == null || (image = media.getImage()) == null) ? null : image.iterator();
        while (it2 != null && it2.hasNext()) {
            if (isExceptionData(((MediaImageEntity) it2.next()).getUrl())) {
                it2.remove();
            }
        }
        RequestPostMediaEntity media2 = requestPost.getMedia();
        if (media2 != null && (video = media2.getVideo()) != null) {
            it = video.iterator();
        }
        while (it != null && it.hasNext()) {
            if (isExceptionData(((MediaVideoEntity) it.next()).getUrl())) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = PublishManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public static final PublishManager getINSTANCE() {
        return Companion.a();
    }

    private final b getPublishModel() {
        return (b) this.publishModel.getValue();
    }

    private final void imageSourceReplace() {
        RequestPostMediaEntity media;
        RequestPostEntity requestPostEntity = this.postEntity;
        List<MediaImageEntity> image = (requestPostEntity == null || (media = requestPostEntity.getMedia()) == null) ? null : media.getImage();
        if (image != null) {
            for (MediaImageEntity mediaImageEntity : image) {
                PublishValue publishValue = this.publishQueue.get(mediaImageEntity.getUrl());
                mediaImageEntity.setUrl(String.valueOf(publishValue != null ? publishValue.getUploadUrl() : null));
            }
        }
        RequestPostEntity requestPostEntity2 = this.postEntity;
        if (requestPostEntity2 != null) {
            create(requestPostEntity2);
        }
    }

    private final boolean isComplete(int value) {
        return value == 1;
    }

    private final boolean isCompleteAll() {
        boolean z = true;
        for (Map.Entry<String, PublishValue> entry : this.publishQueue.entrySet()) {
            wu.a aVar = wu.a.a;
            String classTag = getClassTag();
            String key = entry.getKey();
            aVar.a(classTag + " --> check state:" + ((Object) key) + ",state:" + entry.getValue().getState() + "size=" + this.publishQueue.size());
            z = isComplete(entry.getValue().getState());
            if (!z) {
                break;
            }
        }
        return z;
    }

    private final boolean isExceptionData(String url) {
        return url == null || url.length() == 0 || StringsKt.c0(url, "/data/user", false, 2, (Object) null) || StringsKt.c0(url, "/storage/emulated", false, 2, (Object) null);
    }

    private final boolean isInterceptProgress() {
        return this.lastRefreshTime != 0 && System.currentTimeMillis() - this.lastRefreshTime < ((long) this.INTERVALTIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isUploadSucceed(String key) {
        PublishValue publishValue;
        return (TextUtils.isEmpty(key) || this.publishQueue.get(key) == null || (publishValue = this.publishQueue.get(key)) == null || publishValue.getState() != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void netRunnable$lambda$14(PublishManager publishManager) {
        if (publishManager.uploading) {
            return;
        }
        publishManager.reset();
        postUploadState$default(publishManager, 4, 0, null, 6, null);
    }

    private final void netWorkMonitor() {
        this.handler.postDelayed(this.netRunnable, this.NETWORK_MONITOR);
    }

    private final void postSucceed(Object data) {
        RequestPostMediaEntity media;
        if (data == null) {
            a.a.f(a.a, TAG, "postSucceed data null", false, 4, (Object) null);
            postUploadState(1, 100, "");
            syncPost("");
        } else if (data instanceof PostResuleEntity) {
            PostResuleEntity postResuleEntity = (PostResuleEntity) data;
            String postId = postResuleEntity.getPostId();
            a.a.f(a.a, TAG, "postSucceed data postid:" + postId, false, 4, (Object) null);
            syncPost(postId);
            postUploadState(1, 100, postId);
            HashMap hashMap = new HashMap();
            hashMap.put("post_id", postId);
            RequestPostEntity requestPostEntity = this.postEntity;
            hashMap.put("post_media_type", String.valueOf((requestPostEntity == null || (media = requestPostEntity.getMedia()) == null) ? null : Integer.valueOf(media.getMediaType())));
            RequestPostEntity requestPostEntity2 = this.postEntity;
            hashMap.put("subject_id", String.valueOf(requestPostEntity2 != null ? requestPostEntity2.getSubjectId() : null));
            hashMap.put("post_score", postResuleEntity.getScore());
            qi.h.a.o(getPageName(), hashMap);
        } else {
            postUploadState(1, 100, "");
            syncPost("");
        }
        reset();
    }

    private final void postUploadState(int state, int progress, String postId) {
        PublishResult publishResult = new PublishResult();
        publishResult.setProgress(progress);
        publishResult.setState(state);
        publishResult.setPostId(postId);
        publishResult.setSource(this.publishType);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PublishResult.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, publishResult, 0L);
    }

    static /* synthetic */ void postUploadState$default(PublishManager publishManager, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            str = "";
        }
        publishManager.postUploadState(i, i2, str);
    }

    private final int progress(long currentSize, long totalSize) {
        return 100 - ((int) (((totalSize - currentSize) * 100) / totalSize));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b publishModel_delegate$lambda$0() {
        return new b();
    }

    private final void setLastRefreshTime() {
        this.lastRefreshTime = System.currentTimeMillis();
    }

    private final void setNetMonitor() {
        try {
            if (this.netWorkReceiver != null) {
                return;
            }
            this.netWorkReceiver = new NetworkReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (Build.VERSION.SDK_INT >= 33) {
                Application a = Utils.a();
                if (a != null) {
                    com.transsion.commercialization.pslink.c.a(a, this.netWorkReceiver, intentFilter, 2);
                }
            } else {
                Application a2 = Utils.a();
                if (a2 != null) {
                    a2.registerReceiver(this.netWorkReceiver, intentFilter);
                }
            }
        } catch (Exception e) {
            a.a.f(a.a, TAG, "setNetMonitor ext:" + e.getMessage(), false, 4, (Object) null);
        }
    }

    private final void startPost(Context context, boolean retry) {
        asyn(new i(this, context, retry));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startPost$lambda$3(PublishManager publishManager, Context context, boolean z) {
        try {
            RequestPostEntity requestPostEntity = publishManager.postEntity;
            if (requestPostEntity != null) {
                publishManager.disposePost(context, requestPostEntity, z);
            }
        } catch (Exception e) {
            a.a.f(a.a, TAG, "startPost ext:" + e.getMessage(), false, 4, (Object) null);
            publishManager.uploadFail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void successCallback(Object data) {
        this.createIng = false;
        a.a.f(a.a, TAG, "Upload onSuccess...", false, 4, (Object) null);
        try {
            uploadIng(100);
            postSucceed(data);
        } catch (Exception e) {
            a.a.f(a.a, TAG, "onSuccess ext:" + e.getMessage(), false, 4, (Object) null);
            postSucceed(data);
        }
        xj.a.a.a(Utils.a()).i();
    }

    private final void syncPost(String postId) {
        asyn(new h(postId, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void syncPost$lambda$26(String str, PublishManager publishManager) {
        gx.b a = gx.b.a.a();
        RequestPostEntity requestPostEntity = publishManager.postEntity;
        a.h(str, requestPostEntity != null ? requestPostEntity.getGroupId() : null, publishManager.publishType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final uu.a uploadCallback() {
        return new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadFail() {
        a.a.f(a.a, TAG, "uploadFail", false, 4, (Object) null);
        this.uploadFail = true;
        postUploadState$default(this, 2, 0, null, 6, null);
    }

    private final void uploadIng(int progress) {
        postUploadState$default(this, 3, progress, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadProgress(String uploadKey, long currentSize, long totalSize) {
        int i = this.uploadType;
        if (i == 1) {
            disposeImageProgress(uploadKey, currentSize, totalSize);
            return;
        }
        if (i == 2) {
            if (isInterceptProgress()) {
                checkUploadState(uploadKey, currentSize, totalSize);
                return;
            }
            checkUploadState(uploadKey, currentSize, totalSize);
            disposeAudioVideoProgress(uploadKey, currentSize, totalSize, 2);
            setLastRefreshTime();
            return;
        }
        if (i != 4) {
            return;
        }
        if (isInterceptProgress()) {
            checkUploadState(uploadKey, currentSize, totalSize);
            return;
        }
        checkUploadState(uploadKey, currentSize, totalSize);
        disposeAudioVideoProgress(uploadKey, currentSize, totalSize, 4);
        setLastRefreshTime();
    }

    private final void uploadSucceed() {
        postUploadState$default(this, 1, 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadSuccess() {
        boolean isCompleteAll = isCompleteAll();
        if (!isCompleteAll) {
            a.a.f(a.a, TAG, "Upload unfinished...", false, 4, (Object) null);
            return;
        }
        int i = this.uploadType;
        if (i == 1) {
            if (isCompleteAll) {
                imageSourceReplace();
            }
        } else if (i == 2) {
            if (isCompleteAll) {
                audioSourceReplace();
            }
        } else if (i == 4 && isCompleteAll) {
            videoSourceReplace();
        }
    }

    private final void videoSourceReplace() {
        RequestPostMediaEntity media;
        RequestPostMediaEntity media2;
        a.a.f(a.a, TAG, "videoSourceReplace", false, 4, (Object) null);
        RequestPostEntity requestPostEntity = this.postEntity;
        List<MediaVideoEntity> video = (requestPostEntity == null || (media2 = requestPostEntity.getMedia()) == null) ? null : media2.getVideo();
        if (video != null) {
            for (MediaVideoEntity mediaVideoEntity : video) {
                PublishValue publishValue = this.publishQueue.get(mediaVideoEntity.getUrl());
                mediaVideoEntity.setUrl(String.valueOf(publishValue != null ? publishValue.getUploadUrl() : null));
            }
        }
        Iterator<Map.Entry<String, PublishValue>> it = this.publishQueue.entrySet().iterator();
        while (it.hasNext()) {
            String uploadUrl = it.next().getValue().getUploadUrl();
            if (StringsKt.c0(uploadUrl, ".jpg", false, 2, (Object) null) || StringsKt.c0(uploadUrl, ".png", false, 2, (Object) null) || StringsKt.c0(uploadUrl, ".webp", false, 2, (Object) null) || StringsKt.c0(uploadUrl, ".gif", false, 2, (Object) null)) {
                RequestPostEntity requestPostEntity2 = this.postEntity;
                MediaCoverEntity cover = (requestPostEntity2 == null || (media = requestPostEntity2.getMedia()) == null) ? null : media.getCover();
                if (cover != null) {
                    cover.setUrl(uploadUrl);
                }
            }
        }
        RequestPostEntity requestPostEntity3 = this.postEntity;
        if (requestPostEntity3 != null) {
            create(requestPostEntity3);
        }
    }

    public final void cancel() {
        this.cancelIng = true;
        c.a.b();
        reset();
        postUploadState$default(this, 4, 0, null, 6, null);
    }

    public final String getPageName() {
        return this.publishType == 2 ? "create_post" : "create_review";
    }

    /* renamed from: isFail, reason: from getter */
    public final boolean getUploadFail() {
        return this.uploadFail;
    }

    public final void onConnected(NetworkType networkType) {
        a.a aVar = a.a;
        a.a.f(aVar, TAG, "onConnected:" + (networkType != null ? networkType.name() : null), false, 4, (Object) null);
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.netRunnable);
        }
        a.a.f(aVar, TAG, "uploadFail=" + this.uploadFail, false, 4, (Object) null);
        if (this.uploadFail) {
            this.uploading = false;
            a.a.f(aVar, TAG, "uploading=" + this.uploading, false, 4, (Object) null);
            retry();
        }
    }

    public final void onDisconnected() {
        a.a aVar = a.a;
        a.a.f(aVar, TAG, "onDisconnected", false, 4, (Object) null);
        if (this.uploading) {
            netWorkMonitor();
            uploadFail();
            this.uploadFail = true;
            a.a.f(aVar, TAG, "uploadFail=" + this.uploadFail, false, 4, (Object) null);
        }
    }

    public final void publish(RequestPostEntity requestPostEntity, int publishType) {
        Intrinsics.h(requestPostEntity, "requestPostEntity");
        this.postEntity = requestPostEntity;
        this.publishType = publishType;
        Application a = Utils.a();
        if (a != null) {
            startPost(a, false);
        }
    }

    public final void reset() {
        this.publishQueue.clear();
        this.postEntity = null;
        this.uploading = false;
        this.cancelIng = false;
        this.uploadFail = false;
        this.uploadRetry = false;
        this.tstToken = null;
        a.a.f(a.a, TAG, "reset", false, 4, (Object) null);
    }

    public final void retry() {
        a.a aVar = a.a;
        a.a.f(aVar, TAG, "retry", false, 4, (Object) null);
        if (this.uploading) {
            a.a.f(aVar, TAG, "Upload in progress", false, 4, (Object) null);
            return;
        }
        this.uploading = true;
        this.uploadFail = false;
        a.a.f(aVar, TAG, "retry uploading=" + this.uploading + " uploadFail=" + this.uploadFail, false, 4, (Object) null);
        boolean isCompleteAll = isCompleteAll();
        this.uploadRetry = true;
        if (isCompleteAll) {
            RequestPostEntity requestPostEntity = this.postEntity;
            if (requestPostEntity != null) {
                create(requestPostEntity, true);
                return;
            }
            return;
        }
        Application a = Utils.a();
        if (a != null) {
            startPost(a, false);
        }
    }

    /* renamed from: uploading, reason: from getter */
    public final boolean getUploading() {
        return this.uploading;
    }
}
