package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c1 {
    public static final a c = new a(null);
    private final String a;
    private final String b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a(List list) {
            c1 c1Var;
            if (list == null) {
                return CollectionsKt.l();
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ConfigCodeSeatDTO configCodeSeatDTO = (ConfigCodeSeatDTO) it.next();
                String codeSeatId = configCodeSeatDTO.getCodeSeatId();
                if (codeSeatId != null) {
                    Intrinsics.e(codeSeatId);
                    c1Var = new c1(codeSeatId, GsonUtil.d(configCodeSeatDTO));
                } else {
                    c1Var = null;
                }
                if (c1Var != null) {
                    arrayList.add(c1Var);
                }
            }
            return arrayList;
        }
    }

    public c1(String str, String str2) {
        Intrinsics.h(str, "codeSeatId");
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return Intrinsics.c(this.a, c1Var.a) && Intrinsics.c(this.b, c1Var.b);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CloudConfigEntity(codeSeatId=" + this.a + ", code_seat_bean=" + this.b + ')';
    }
}
