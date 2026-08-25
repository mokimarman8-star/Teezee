package com.transsion.subtitle.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.subtitle.helper.SubtitleSearchHelper", f = "SubtitleSearchHelper.kt", l = {86, 99, 103, 141, 148, 152, 157}, m = "innerUpdateLanguageList")
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class SubtitleSearchHelper$innerUpdateLanguageList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubtitleSearchHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubtitleSearchHelper$innerUpdateLanguageList$1(SubtitleSearchHelper subtitleSearchHelper, Continuation<? super SubtitleSearchHelper$innerUpdateLanguageList$1> continuation) {
        super(continuation);
        this.this$0 = subtitleSearchHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object g;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g = this.this$0.g(this);
        return g;
    }
}
