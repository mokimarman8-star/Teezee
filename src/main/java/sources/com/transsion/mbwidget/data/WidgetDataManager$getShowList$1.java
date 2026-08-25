package com.transsion.mbwidget.data;

import com.transsion.athena.config.data.model.TidConfigBean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.mbwidget.data.WidgetDataManager", f = "WidgetDataManager.kt", l = {81, TidConfigBean.REASON_TID_DISABLE}, m = "getShowList")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class WidgetDataManager$getShowList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetDataManager$getShowList$1(WidgetDataManager widgetDataManager, Continuation<? super WidgetDataManager$getShowList$1> continuation) {
        super(continuation);
        this.this$0 = widgetDataManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.u(null, null, this);
    }
}
