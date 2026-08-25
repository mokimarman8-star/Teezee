package com.transsion.ad.ps.distribute;

import android.os.SystemClock;
import android.text.TextUtils;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.transsion.ad.monopoly.plan.AdPlanMaterialManager;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.strategy.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import rh.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PSAdPlanRequestManager {
    public static final PSAdPlanRequestManager a = new PSAdPlanRequestManager();

    private PSAdPlanRequestManager() {
    }

    private final String a() {
        String simpleName = PSAdPlanRequestManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0251 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0216 -> B:23:0x0219). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x023c -> B:25:0x023d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(Continuation continuation) {
        PSAdPlanRequestManager$updatePsLink$1 pSAdPlanRequestManager$updatePsLink$1;
        Object f;
        int i;
        List list;
        Iterator it;
        PsStorageManager psStorageManager;
        long j;
        Iterator it2;
        MbAdDbPlans mbAdDbPlans;
        Iterator it3;
        char c;
        MbAdDbPlans mbAdDbPlans2;
        int i2;
        String extAdSlot;
        if (continuation instanceof PSAdPlanRequestManager$updatePsLink$1) {
            pSAdPlanRequestManager$updatePsLink$1 = (PSAdPlanRequestManager$updatePsLink$1) continuation;
            int i3 = pSAdPlanRequestManager$updatePsLink$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                pSAdPlanRequestManager$updatePsLink$1.label = i3 - Integer.MIN_VALUE;
                Object obj = pSAdPlanRequestManager$updatePsLink$1.result;
                f = IntrinsicsKt.f();
                i = pSAdPlanRequestManager$updatePsLink$1.label;
                char c2 = 4;
                int i4 = 2;
                if (i != 0) {
                    ResultKt.b(obj);
                    AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.a;
                    String value = AdPlanSourceManager.AdPlanEnum.AD_PLAN_AD_SOURCE_PS.getValue();
                    pSAdPlanRequestManager$updatePsLink$1.label = 1;
                    obj = adPlansStorageManager.i(value, pSAdPlanRequestManager$updatePsLink$1);
                    if (obj == f) {
                        return f;
                    }
                } else if (i == 1) {
                    ResultKt.b(obj);
                } else {
                    if (i != 2) {
                        if (i == 3) {
                            j = pSAdPlanRequestManager$updatePsLink$1.J$0;
                            mbAdDbPlans = (MbAdDbPlans) pSAdPlanRequestManager$updatePsLink$1.L$1;
                            it2 = (Iterator) pSAdPlanRequestManager$updatePsLink$1.L$0;
                            ResultKt.b(obj);
                            e.a.b().putLong("key_ps_link_request_gap" + mbAdDbPlans.getId(), j);
                            it3 = it2;
                            c = 4;
                            it = it3;
                            c2 = c;
                            i4 = 2;
                            if (it.hasNext()) {
                            }
                            psStorageManager = PsStorageManager.a;
                            pSAdPlanRequestManager$updatePsLink$1.L$0 = null;
                            pSAdPlanRequestManager$updatePsLink$1.L$1 = null;
                            pSAdPlanRequestManager$updatePsLink$1.label = 5;
                            if (psStorageManager.a(pSAdPlanRequestManager$updatePsLink$1) == f) {
                            }
                            if (f.a.a()) {
                            }
                            return Unit.a;
                        }
                        if (i != 4) {
                            if (i != 5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            if (f.a.a()) {
                                xh.a.i(xh.a.a, a() + " --> analyzeData() --> 删除无效素材文件", 0, false, 6, null);
                            }
                            return Unit.a;
                        }
                        MbAdDbPlans mbAdDbPlans3 = (MbAdDbPlans) pSAdPlanRequestManager$updatePsLink$1.L$1;
                        Iterator it4 = (Iterator) pSAdPlanRequestManager$updatePsLink$1.L$0;
                        ResultKt.b(obj);
                        Iterator it5 = it4;
                        mbAdDbPlans2 = mbAdDbPlans3;
                        c = 4;
                        e.a.b().putLong("key_ps_link_request_gap" + mbAdDbPlans2.getId(), SystemClock.elapsedRealtime());
                        it3 = it5;
                        it = it3;
                        c2 = c;
                        i4 = 2;
                        if (it.hasNext()) {
                            MbAdDbPlans mbAdDbPlans4 = (MbAdDbPlans) it.next();
                            int i5 = -1;
                            if (!TextUtils.isEmpty(mbAdDbPlans4.getExtAdSlot()) && (extAdSlot = mbAdDbPlans4.getExtAdSlot()) != null) {
                                i5 = Integer.parseInt(extAdSlot);
                            }
                            if (i5 > 0) {
                                AdPlanMaterialManager adPlanMaterialManager = AdPlanMaterialManager.a;
                                pSAdPlanRequestManager$updatePsLink$1.L$0 = it;
                                pSAdPlanRequestManager$updatePsLink$1.L$1 = mbAdDbPlans4;
                                pSAdPlanRequestManager$updatePsLink$1.I$0 = i5;
                                pSAdPlanRequestManager$updatePsLink$1.label = i4;
                                Object d = adPlanMaterialManager.d(mbAdDbPlans4, pSAdPlanRequestManager$updatePsLink$1);
                                if (d == f) {
                                    return f;
                                }
                                it3 = it;
                                obj = d;
                                mbAdDbPlans2 = mbAdDbPlans4;
                                i2 = i5;
                                if (((Boolean) obj).booleanValue()) {
                                    it5 = it3;
                                    PsDistributeRequestManager psDistributeRequestManager = PsDistributeRequestManager.a;
                                    Integer d2 = Boxing.d(i2);
                                    String id = mbAdDbPlans2.getId();
                                    pSAdPlanRequestManager$updatePsLink$1.L$0 = it5;
                                    pSAdPlanRequestManager$updatePsLink$1.L$1 = mbAdDbPlans2;
                                    c = 4;
                                    pSAdPlanRequestManager$updatePsLink$1.label = 4;
                                    if (psDistributeRequestManager.n(0, 10, d2, id, pSAdPlanRequestManager$updatePsLink$1) == f) {
                                        return f;
                                    }
                                    e.a.b().putLong("key_ps_link_request_gap" + mbAdDbPlans2.getId(), SystemClock.elapsedRealtime());
                                    it3 = it5;
                                    it = it3;
                                    c2 = c;
                                    i4 = 2;
                                    if (it.hasNext()) {
                                    }
                                } else {
                                    long j2 = e.a.b().getLong("key_ps_link_request_gap" + mbAdDbPlans2.getId(), 0L);
                                    long elapsedRealtime = SystemClock.elapsedRealtime();
                                    if (elapsedRealtime - j2 > com.transsion.ad.scene.b.a.e() * 1000) {
                                        PsDistributeRequestManager psDistributeRequestManager2 = PsDistributeRequestManager.a;
                                        Integer d3 = Boxing.d(i2);
                                        String id2 = mbAdDbPlans2.getId();
                                        pSAdPlanRequestManager$updatePsLink$1.L$0 = it3;
                                        pSAdPlanRequestManager$updatePsLink$1.L$1 = mbAdDbPlans2;
                                        pSAdPlanRequestManager$updatePsLink$1.J$0 = elapsedRealtime;
                                        pSAdPlanRequestManager$updatePsLink$1.label = 3;
                                        Iterator it6 = it3;
                                        if (psDistributeRequestManager2.n(0, 10, d3, id2, pSAdPlanRequestManager$updatePsLink$1) == f) {
                                            return f;
                                        }
                                        j = elapsedRealtime;
                                        mbAdDbPlans = mbAdDbPlans2;
                                        it2 = it6;
                                        e.a.b().putLong("key_ps_link_request_gap" + mbAdDbPlans.getId(), j);
                                        it3 = it2;
                                        c = 4;
                                        it = it3;
                                        c2 = c;
                                        i4 = 2;
                                        if (it.hasNext()) {
                                        }
                                    } else {
                                        xh.a.i(xh.a.a, a.a() + " --> updatePsLink() --> ID = " + mbAdDbPlans2.getId() + " --> name = " + mbAdDbPlans2.getName() + " --> psScene = " + i2 + " --> 当前有资源，且在请求间隔内 --> 不做处理", 5, false, 4, null);
                                        Unit unit = Unit.a;
                                        c = 4;
                                        it = it3;
                                        c2 = c;
                                        i4 = 2;
                                        if (it.hasNext()) {
                                        }
                                    }
                                }
                            } else {
                                c = c2;
                                c2 = c;
                                i4 = 2;
                                if (it.hasNext()) {
                                }
                            }
                        }
                        psStorageManager = PsStorageManager.a;
                        pSAdPlanRequestManager$updatePsLink$1.L$0 = null;
                        pSAdPlanRequestManager$updatePsLink$1.L$1 = null;
                        pSAdPlanRequestManager$updatePsLink$1.label = 5;
                        if (psStorageManager.a(pSAdPlanRequestManager$updatePsLink$1) == f) {
                            return f;
                        }
                        if (f.a.a()) {
                        }
                        return Unit.a;
                    }
                    i2 = pSAdPlanRequestManager$updatePsLink$1.I$0;
                    mbAdDbPlans2 = (MbAdDbPlans) pSAdPlanRequestManager$updatePsLink$1.L$1;
                    Iterator it7 = (Iterator) pSAdPlanRequestManager$updatePsLink$1.L$0;
                    ResultKt.b(obj);
                    it3 = it7;
                    if (((Boolean) obj).booleanValue()) {
                    }
                }
                list = (List) obj;
                if (f.a.a()) {
                    ArrayList arrayList = new ArrayList();
                    if (list != null) {
                        Iterator it8 = list.iterator();
                        while (it8.hasNext()) {
                            arrayList.add(((MbAdDbPlans) it8.next()).getExtAdSlot());
                        }
                    }
                    xh.a.i(xh.a.a, a() + " --> updatePsLink(包断广告计划更新完成) --> 开始更新PS商单数据 --> plansBySource = " + (list != null ? Boxing.d(list.size()) : null) + " --> sceneIdList = " + arrayList, 0, false, 6, null);
                }
                if (list != null) {
                    it = list.iterator();
                    if (it.hasNext()) {
                    }
                }
                psStorageManager = PsStorageManager.a;
                pSAdPlanRequestManager$updatePsLink$1.L$0 = null;
                pSAdPlanRequestManager$updatePsLink$1.L$1 = null;
                pSAdPlanRequestManager$updatePsLink$1.label = 5;
                if (psStorageManager.a(pSAdPlanRequestManager$updatePsLink$1) == f) {
                }
                if (f.a.a()) {
                }
                return Unit.a;
            }
        }
        pSAdPlanRequestManager$updatePsLink$1 = new PSAdPlanRequestManager$updatePsLink$1(this, continuation);
        Object obj2 = pSAdPlanRequestManager$updatePsLink$1.result;
        f = IntrinsicsKt.f();
        i = pSAdPlanRequestManager$updatePsLink$1.label;
        char c22 = 4;
        int i42 = 2;
        if (i != 0) {
        }
        list = (List) obj2;
        if (f.a.a()) {
        }
        if (list != null) {
        }
        psStorageManager = PsStorageManager.a;
        pSAdPlanRequestManager$updatePsLink$1.L$0 = null;
        pSAdPlanRequestManager$updatePsLink$1.L$1 = null;
        pSAdPlanRequestManager$updatePsLink$1.label = 5;
        if (psStorageManager.a(pSAdPlanRequestManager$updatePsLink$1) == f) {
        }
        if (f.a.a()) {
        }
        return Unit.a;
    }
}
