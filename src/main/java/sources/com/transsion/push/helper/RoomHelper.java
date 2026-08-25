package com.transsion.push.helper;

import android.content.Context;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.push.bean.MsgType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class RoomHelper {
    public static final RoomHelper a = new RoomHelper();

    private RoomHelper() {
    }

    private final Object b(Context context, String str, Continuation continuation) {
        return AppDatabase.p.b(context).s1().f(str, continuation);
    }

    public final Object a(Context context, Continuation continuation) {
        return b(context, MsgType.LOCAL_PUSH.getType(), continuation);
    }

    public final Object c(Context context, String str, Continuation continuation) {
        return AppDatabase.p.b(context).s1().e(str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(android.content.Context r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsion.push.helper.RoomHelper$getNewestMsgByReceiveTime$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsion.push.helper.RoomHelper$getNewestMsgByReceiveTime$1 r0 = (com.transsion.push.helper.RoomHelper$getNewestMsgByReceiveTime$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.push.helper.RoomHelper$getNewestMsgByReceiveTime$1 r0 = new com.transsion.push.helper.RoomHelper$getNewestMsgByReceiveTime$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L47
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            com.transsion.baselib.db.AppDatabase$f1 r6 = com.transsion.baselib.db.AppDatabase.p
            com.transsion.baselib.db.AppDatabase r5 = r6.b(r5)
            zi.a r5 = r5.s1()
            r0.label = r3
            java.lang.Object r6 = r5.d(r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L5a
            r5 = r6
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L5a
            r5 = 0
            java.lang.Object r5 = r6.get(r5)
            return r5
        L5a:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.helper.RoomHelper.d(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object e(Context context, Continuation continuation) {
        return b(context, MsgType.SUBJECT_SEEKING.getType(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(android.content.Context r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsion.push.helper.RoomHelper$hasGetMsgToday$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsion.push.helper.RoomHelper$hasGetMsgToday$1 r0 = (com.transsion.push.helper.RoomHelper$hasGetMsgToday$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.push.helper.RoomHelper$hasGetMsgToday$1 r0 = new com.transsion.push.helper.RoomHelper$hasGetMsgToday$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            r0.label = r3
            java.lang.Object r6 = r4.d(r5, r0)
            if (r6 != r1) goto L3d
            return r1
        L3d:
            com.transsion.baselib.db.notification.MsgBean r6 = (com.transsion.baselib.db.notification.MsgBean) r6
            if (r6 == 0) goto L56
            java.lang.Long r5 = r6.getReceiveTime()
            if (r5 == 0) goto L56
            long r5 = r5.longValue()
            boolean r5 = com.blankj.utilcode.util.c0.f(r5)
            if (r5 == 0) goto L56
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        L56:
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.helper.RoomHelper.f(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0106 -> B:12:0x0109). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00bd -> B:26:0x00c0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(android.content.Context r9, com.transsion.baselib.db.notification.PullMsgResp r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.helper.RoomHelper.g(android.content.Context, com.transsion.baselib.db.notification.PullMsgResp, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object h(Context context, MsgBean msgBean, Continuation continuation) {
        Object b = AppDatabase.p.b(context).s1().b(msgBean, continuation);
        return b == IntrinsicsKt.f() ? b : Unit.a;
    }
}
