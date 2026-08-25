package com.transsion.shorttv.subtitle;

import com.transsion.gslb.BuildConfig;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import nr.e;
import qr.k0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$downloadListener$1$onComplete$1", f = "ShortTVSubtitleControlImp.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTVSubtitleControlImp$downloadListener$1$onComplete$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubtitleDownloadTable $stDownloadTable;
    int label;
    final /* synthetic */ ShortTVSubtitleControlImp this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTVSubtitleControlImp$downloadListener$1$onComplete$1(ShortTVSubtitleControlImp shortTVSubtitleControlImp, SubtitleDownloadTable subtitleDownloadTable, Continuation<? super ShortTVSubtitleControlImp$downloadListener$1$onComplete$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTVSubtitleControlImp;
        this.$stDownloadTable = subtitleDownloadTable;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVSubtitleControlImp$downloadListener$1$onComplete$1(this.this$0, this.$stDownloadTable, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        e eVar;
        as.a aVar;
        Object obj2;
        as.a aVar2;
        k0 k0Var;
        Object obj3;
        as.a aVar3;
        Object obj4;
        String str;
        k0 k0Var2;
        String str2;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        eVar = this.this$0.e;
        if (!Intrinsics.c(eVar.f(), this.$stDownloadTable.getResourceId())) {
            a.a aVar4 = wf.a.a;
            str2 = this.this$0.g;
            a.a.g(aVar4, str2 + " --> onComplete() --> 字幕下载成功，不是当前视频，不做处理", false, 2, (Object) null);
            return Unit.a;
        }
        aVar = this.this$0.h;
        List list = (List) aVar.d().f();
        if (list == null) {
            list = new ArrayList();
        }
        List list2 = list;
        SubtitleDownloadTable subtitleDownloadTable = this.$stDownloadTable;
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            xr.b bVar = (xr.b) obj2;
            if (Intrinsics.c(bVar.a().getId(), subtitleDownloadTable.getId()) && bVar.a().getResourceStreamType() == subtitleDownloadTable.getResourceStreamType()) {
                break;
            }
        }
        SubtitleDownloadTable subtitleDownloadTable2 = this.$stDownloadTable;
        ShortTVSubtitleControlImp shortTVSubtitleControlImp = this.this$0;
        xr.b bVar2 = (xr.b) obj2;
        if (bVar2 != null) {
            bVar2.e(subtitleDownloadTable2);
        } else {
            xr.b bVar3 = new xr.b(subtitleDownloadTable2);
            list.add(bVar3);
            aVar2 = shortTVSubtitleControlImp.h;
            aVar2.d().q(list);
            k0Var = shortTVSubtitleControlImp.c;
            k0Var.K.setSubtitlePath(subtitleDownloadTable2.getPath(), yr.a.b(bVar3));
        }
        SubtitleDownloadTable subtitleDownloadTable3 = this.$stDownloadTable;
        Iterator it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it2.next();
            if (Intrinsics.c(((xr.b) obj3).a().getId(), subtitleDownloadTable3.getId())) {
                break;
            }
        }
        xr.b bVar4 = (xr.b) obj3;
        if (bVar4 == null) {
            bVar4 = new xr.b(this.$stDownloadTable);
        }
        aVar3 = this.this$0.h;
        if (Intrinsics.c(aVar3.f().f(), Boxing.a(true))) {
            bVar4.f(false);
        } else if (this.$stDownloadTable.isAutoDownload()) {
            String string = com.transsion.subtitle_download.utils.d.a.b().getString("k_subtitle_select_lan", (String) null);
            Iterator it3 = list2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    obj4 = null;
                    break;
                }
                obj4 = it3.next();
                if (Intrinsics.c(((xr.b) obj4).a().getLan(), string)) {
                    break;
                }
            }
            if (((xr.b) obj4) == null || string == null || string.length() == 0 || Intrinsics.c(string, this.$stDownloadTable.getLan())) {
                bVar4.f(true);
            }
        } else {
            bVar4.f(true);
        }
        a.a aVar5 = wf.a.a;
        str = this.this$0.g;
        a.a.q(aVar5, str + " --> onComplete() --> 字幕下载成功：" + this.$stDownloadTable.getName() + "," + this.$stDownloadTable.getLanName() + ", isSelect:" + bVar4.d(), false, 2, (Object) null);
        k0Var2 = this.this$0.c;
        k0Var2.K.setSubtitlePath(this.$stDownloadTable.getPath(), yr.a.b(bVar4));
        if (bVar4.d()) {
            this.this$0.h(bVar4);
        }
        return Unit.a;
    }
}
