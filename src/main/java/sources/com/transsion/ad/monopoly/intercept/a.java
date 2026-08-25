package com.transsion.ad.monopoly.intercept;

import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    private a a;

    /* renamed from: com.transsion.ad.monopoly.intercept.a$a, reason: collision with other inner class name */
    public static final class C0004a {
        private a a;
        private a b;

        public final C0004a a(a aVar) {
            if (this.a == null) {
                this.b = aVar;
                this.a = aVar;
                return this;
            }
            a aVar2 = this.b;
            if (aVar2 != null) {
                aVar2.f(aVar);
            }
            this.b = aVar;
            return this;
        }

        public final a b() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(a aVar) {
        this.a = aVar;
    }

    public abstract Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation);

    public final a c() {
        return this.a;
    }

    protected final String d() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    protected final AdPlansHitResponse e() {
        return new AdPlansHitResponse(true, "default");
    }
}
