package com.transsion.mbwidget;

import com.transsion.mbwidget.SportSchedulePreviewWidgetProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.mbwidget.SportSchedulePreviewWidgetProvider$Companion", f = "SportSchedulePreviewWidgetProvider.kt", l = {344, 345}, m = "bindMatch")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SportSchedulePreviewWidgetProvider$Companion$bindMatch$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SportSchedulePreviewWidgetProvider.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SportSchedulePreviewWidgetProvider$Companion$bindMatch$1(SportSchedulePreviewWidgetProvider.Companion companion, Continuation<? super SportSchedulePreviewWidgetProvider$Companion$bindMatch$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        Object f;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        f = this.this$0.f(null, null, 0, null, this);
        return f;
    }
}
