package com.transsion.lib_web.download_render;

import com.tencent.mmkv.MMKV;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.lib_web.download_render.data.PageData;
import com.transsion.lib_web.download_render.data.PageListData;
import com.transsion.lib_web.download_render.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;
import pl.h;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.transsion.lib_web.download_render.FileRemoteDataManager$syncData$1", f = "FileRemoteDataManager.kt", l = {43}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class FileRemoteDataManager$syncData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    FileRemoteDataManager$syncData$1(Continuation<? super FileRemoteDataManager$syncData$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileRemoteDataManager$syncData$1(continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        MMKV h;
        String str;
        g g;
        String str2;
        Long x;
        Long x2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                FileRemoteDataManager fileRemoteDataManager = FileRemoteDataManager.a;
                h = fileRemoteDataManager.h();
                str = FileRemoteDataManager.h;
                h.putLong(str, System.currentTimeMillis());
                String k = c.a.k();
                g = fileRemoteDataManager.g();
                String i2 = fileRemoteDataManager.i();
                this.L$0 = k;
                this.label = 1;
                obj = g.a.a(g, i2, k, null, this, 4, null);
                if (obj == f) {
                    return f;
                }
                str2 = k;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str2 = (String) this.L$0;
                ResultKt.b(obj);
            }
            PageListData pageListData = (PageListData) ((BaseDto) obj).getData();
            if (pageListData != null && pageListData.getVersion() != null && !Intrinsics.c(pageListData.getVersion(), str2)) {
                HashMap hashMap = new HashMap();
                List<PageData> h5Pages = pageListData.getH5Pages();
                if (h5Pages == null) {
                    h5Pages = CollectionsKt.l();
                }
                for (PageData pageData : h5Pages) {
                    String url = pageData.getUrl();
                    if (url != null) {
                        PageData pageData2 = (PageData) hashMap.get(url);
                        if (pageData2 == null) {
                            hashMap.put(url, pageData);
                        } else {
                            String versionCode = pageData2.getVersionCode();
                            long j = 0;
                            long longValue = (versionCode == null || (x2 = StringsKt.x(versionCode)) == null) ? 0L : x2.longValue();
                            String versionCode2 = pageData.getVersionCode();
                            if (versionCode2 != null && (x = StringsKt.x(versionCode2)) != null) {
                                j = x.longValue();
                            }
                            if (j > longValue) {
                                hashMap.put(url, pageData);
                            }
                        }
                    }
                }
                Collection values = hashMap.values();
                Intrinsics.g(values, "<get-values>(...)");
                pageListData.setH5Pages(CollectionsKt.U0(values));
                c.a.p(pageListData);
                FileDownloadTaskManager.a.g(pageListData.getH5Pages());
            }
        } catch (Throwable th2) {
            h.a.b("DR_FileRemoteDataManager", "<syncData> fail:" + th2);
        }
        return Unit.a;
    }
}
