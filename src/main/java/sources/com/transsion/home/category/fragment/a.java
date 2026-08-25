package com.transsion.home.category.fragment;

import androidx.lifecycle.c0;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {

    /* renamed from: com.transsion.home.category.fragment.a$a, reason: collision with other inner class name */
    static final class C0031a implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        C0031a(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    public static final String a(Subject subject, String str) {
        String ops;
        JSONObject jSONObject;
        String ops2;
        if (subject != null) {
            try {
                ops = subject.getOps();
            } catch (Exception e) {
                e.printStackTrace();
                return subject != null ? subject.getOps() : null;
            }
        } else {
            ops = null;
        }
        if (ops != null && ops.length() != 0) {
            jSONObject = (subject == null || (ops2 = subject.getOps()) == null) ? new JSONObject() : new JSONObject(ops2);
            jSONObject.put("rec_type", str);
            return jSONObject.toString();
        }
        jSONObject = new JSONObject();
        jSONObject.put("rec_type", str);
        return jSONObject.toString();
    }
}
