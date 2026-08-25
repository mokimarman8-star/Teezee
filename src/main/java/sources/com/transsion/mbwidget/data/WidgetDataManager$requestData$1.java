package com.transsion.mbwidget.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.mbwidget.data.WidgetDataManager", f = "WidgetDataManager.kt", l = {174}, m = "requestData")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class WidgetDataManager$requestData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetDataManager$requestData$1(WidgetDataManager widgetDataManager, Continuation<? super WidgetDataManager$requestData$1> continuation) {
        super(continuation);
        this.this$0 = widgetDataManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object A;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        A = this.this$0.A(this);
        return A;
    }
}
