package com.transsion.ad.ps.distribute;

import ci.h;
import com.blankj.utilcode.util.o;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import com.transsion.ad.ps.model.PsLinkAdInfo;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PsStorageManager {
    public static final PsStorageManager a = new PsStorageManager();

    private PsStorageManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Continuation continuation) {
        PsStorageManager$deleteInvalidFile$1 psStorageManager$deleteInvalidFile$1;
        int i;
        HashSet hashSet;
        List list;
        if (continuation instanceof PsStorageManager$deleteInvalidFile$1) {
            psStorageManager$deleteInvalidFile$1 = (PsStorageManager$deleteInvalidFile$1) continuation;
            int i2 = psStorageManager$deleteInvalidFile$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                psStorageManager$deleteInvalidFile$1.label = i2 - Integer.MIN_VALUE;
                Object obj = psStorageManager$deleteInvalidFile$1.result;
                Object f = IntrinsicsKt.f();
                i = psStorageManager$deleteInvalidFile$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    HashSet hashSet2 = new HashSet();
                    PsDbManager psDbManager = PsDbManager.a;
                    psStorageManager$deleteInvalidFile$1.L$0 = hashSet2;
                    psStorageManager$deleteInvalidFile$1.label = 1;
                    Object d = psDbManager.d(psStorageManager$deleteInvalidFile$1);
                    if (d == f) {
                        return f;
                    }
                    hashSet = hashSet2;
                    obj = d;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    hashSet = (HashSet) psStorageManager$deleteInvalidFile$1.L$0;
                    ResultKt.b(obj);
                }
                list = (List) obj;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        PsLinkAdInfo psLinkAdInfo = (PsLinkAdInfo) o.d(((PsLinkAdPlan) it.next()).getPsLinkAdInfoStr(), PsLinkAdInfo.class);
                        hashSet.add(psLinkAdInfo.getPath());
                        hashSet.add(psLinkAdInfo.getAdvertiserAvatarPath());
                    }
                }
                h.a.b(new File(com.transsion.ad.a.a.a() + File.separatorChar), hashSet);
                return Unit.a;
            }
        }
        psStorageManager$deleteInvalidFile$1 = new PsStorageManager$deleteInvalidFile$1(this, continuation);
        Object obj2 = psStorageManager$deleteInvalidFile$1.result;
        Object f2 = IntrinsicsKt.f();
        i = psStorageManager$deleteInvalidFile$1.label;
        if (i != 0) {
        }
        list = (List) obj2;
        if (list != null) {
        }
        h.a.b(new File(com.transsion.ad.a.a.a() + File.separatorChar), hashSet);
        return Unit.a;
    }
}
