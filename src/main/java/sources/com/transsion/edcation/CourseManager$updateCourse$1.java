package com.transsion.edcation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.edcation.CourseManager", f = "CourseManager.kt", l = {240, 241}, m = "updateCourse")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class CourseManager$updateCourse$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CourseManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CourseManager$updateCourse$1(CourseManager courseManager, Continuation<? super CourseManager$updateCourse$1> continuation) {
        super(continuation);
        this.this$0 = courseManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object w;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        w = this.this$0.w(null, this);
        return w;
    }
}
