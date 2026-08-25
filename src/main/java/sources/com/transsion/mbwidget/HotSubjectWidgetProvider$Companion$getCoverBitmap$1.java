package com.transsion.mbwidget;

import com.transsion.mbwidget.HotSubjectWidgetProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.mbwidget.HotSubjectWidgetProvider$Companion", f = "HotSubjectWidgetProvider.kt", l = {192}, m = "getCoverBitmap")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HotSubjectWidgetProvider$Companion$getCoverBitmap$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HotSubjectWidgetProvider.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HotSubjectWidgetProvider$Companion$getCoverBitmap$1(HotSubjectWidgetProvider.Companion companion, Continuation<? super HotSubjectWidgetProvider$Companion$getCoverBitmap$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        Object d;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        d = this.this$0.d(null, 0, this);
        return d;
    }
}
