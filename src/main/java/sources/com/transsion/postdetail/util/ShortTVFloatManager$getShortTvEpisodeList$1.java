package com.transsion.postdetail.util;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.bean.Media;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.ShortTvInfoEpisodeList;
import com.transsion.shorttv.bean.Video;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import sr.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.util.ShortTVFloatManager$getShortTvEpisodeList$1", f = "ShortTVFloatManager.kt", l = {124, 129, 136, 145}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTVFloatManager$getShortTvEpisodeList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ShortTvInfoEpisodeList, Unit> $callback;
    final /* synthetic */ int $selectEp;
    final /* synthetic */ String $subjectId;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ShortTVFloatManager$getShortTvEpisodeList$1(int i, String str, Function1<? super ShortTvInfoEpisodeList, Unit> function1, Continuation<? super ShortTVFloatManager$getShortTvEpisodeList$1> continuation) {
        super(2, continuation);
        this.$selectEp = i;
        this.$subjectId = str;
        this.$callback = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVFloatManager$getShortTvEpisodeList$1(this.$selectEp, this.$subjectId, this.$callback, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d0 A[Catch: all -> 0x004b, TryCatch #1 {all -> 0x004b, blocks: (B:21:0x0043, B:23:0x0109, B:24:0x010d, B:26:0x00ca, B:28:0x00d0, B:31:0x00e0, B:34:0x00e6, B:36:0x00ec, B:45:0x0112, B:53:0x0054, B:55:0x00b0, B:57:0x00bb, B:59:0x00c1), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0133  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0106 -> B:23:0x0109). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x010c -> B:24:0x010d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        int i;
        sr.a aVar;
        String str;
        Object c;
        List<ShortTVItem> items;
        Iterator it;
        Object obj3;
        String str2;
        com.transsnet.downloader.manager.g j;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        if (i2 == 0) {
            ResultKt.b(obj);
            int i3 = ((this.$selectEp - 1) / 20) * 20;
            int i4 = i3 + 1;
            wf.a.a.c("VideoFloat", "getShortTvEpisodes start：" + i4 + "  ", true);
            String str3 = this.$subjectId;
            try {
                Result.Companion companion = Result.Companion;
                aVar = ShortTVFloatManager.c;
                int i5 = i3 + 20;
                this.L$0 = str3;
                this.I$0 = i4;
                this.label = 1;
                str = str3;
                i = i4;
                try {
                    c = a.C0094a.c(aVar, str3, i4, i5, 0, null, this, 24, null);
                    if (c == f) {
                        return f;
                    }
                    i2 = i;
                } catch (Throwable th3) {
                    th = th3;
                    i2 = i;
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.a(th));
                    Function1<ShortTvInfoEpisodeList, Unit> function1 = this.$callback;
                    if (Result.isSuccess-impl(obj2)) {
                    }
                    Function1<ShortTvInfoEpisodeList, Unit> function12 = this.$callback;
                    if (Result.exceptionOrNull-impl(obj2) != null) {
                    }
                    return Unit.a;
                }
            } catch (Throwable th4) {
                th = th4;
                i = i4;
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        return Unit.a;
                    }
                    obj2 = this.L$0;
                    ResultKt.b(obj);
                    Function1<ShortTvInfoEpisodeList, Unit> function122 = this.$callback;
                    if (Result.exceptionOrNull-impl(obj2) != null) {
                        a2 c2 = y0.c();
                        ShortTVFloatManager$getShortTvEpisodeList$1$3$1 shortTVFloatManager$getShortTvEpisodeList$1$3$1 = new ShortTVFloatManager$getShortTvEpisodeList$1$3$1(function122, null);
                        this.L$0 = obj2;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.label = 4;
                        if (kotlinx.coroutines.i.g(c2, shortTVFloatManager$getShortTvEpisodeList$1$3$1, this) == f) {
                            return f;
                        }
                    }
                    return Unit.a;
                }
                i2 = this.I$0;
                Video video = (Video) this.L$5;
                it = (Iterator) this.L$2;
                obj3 = this.L$1;
                str2 = (String) this.L$0;
                ResultKt.b(obj);
                Video videoAddress = video;
                Object a = obj;
                String str4 = (String) a;
                videoAddress.setUrl(str4);
                while (it.hasNext()) {
                    ShortTVItem shortTVItem = (ShortTVItem) it.next();
                    int ep2 = shortTVItem.getEp();
                    Media video2 = shortTVItem.getVideo();
                    if (video2 != null && (videoAddress = video2.getVideoAddress()) != null) {
                        String url = videoAddress.getUrl();
                        if (url != null) {
                            j = ShortTVFloatManager.b.j();
                            this.L$0 = str2;
                            this.L$1 = obj3;
                            this.L$2 = it;
                            this.L$3 = shortTVItem;
                            this.L$4 = videoAddress;
                            this.L$5 = videoAddress;
                            this.I$0 = i2;
                            this.label = 2;
                            a = j.a(str2, ep2, url, this);
                            if (a == f) {
                                return f;
                            }
                            String str42 = (String) a;
                            videoAddress.setUrl(str42);
                            while (it.hasNext()) {
                            }
                        } else {
                            str42 = null;
                            videoAddress.setUrl(str42);
                            while (it.hasNext()) {
                            }
                        }
                    }
                }
                c = obj3;
                obj2 = Result.constructor-impl((BaseDto) c);
                Function1<ShortTvInfoEpisodeList, Unit> function13 = this.$callback;
                if (Result.isSuccess-impl(obj2)) {
                    a2 c3 = y0.c();
                    ShortTVFloatManager$getShortTvEpisodeList$1$2$1 shortTVFloatManager$getShortTvEpisodeList$1$2$1 = new ShortTVFloatManager$getShortTvEpisodeList$1$2$1(i2, (BaseDto) obj2, function13, null);
                    this.L$0 = obj2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 3;
                    if (kotlinx.coroutines.i.g(c3, shortTVFloatManager$getShortTvEpisodeList$1$2$1, this) == f) {
                        return f;
                    }
                }
                Function1<ShortTvInfoEpisodeList, Unit> function1222 = this.$callback;
                if (Result.exceptionOrNull-impl(obj2) != null) {
                }
                return Unit.a;
            }
            i2 = this.I$0;
            String str5 = (String) this.L$0;
            ResultKt.b(obj);
            str = str5;
            c = obj;
        }
        ShortTvInfoEpisodeList shortTvInfoEpisodeList = (ShortTvInfoEpisodeList) ((BaseDto) c).getData();
        if (shortTvInfoEpisodeList != null && (items = shortTvInfoEpisodeList.getItems()) != null) {
            it = items.iterator();
            obj3 = c;
            str2 = str;
            while (it.hasNext()) {
            }
            c = obj3;
        }
        obj2 = Result.constructor-impl((BaseDto) c);
        Function1<ShortTvInfoEpisodeList, Unit> function132 = this.$callback;
        if (Result.isSuccess-impl(obj2)) {
        }
        Function1<ShortTvInfoEpisodeList, Unit> function12222 = this.$callback;
        if (Result.exceptionOrNull-impl(obj2) != null) {
        }
        return Unit.a;
    }
}
