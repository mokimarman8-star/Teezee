package com.transsion.athena.config.data.model;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class anateh {
    private enatha a = new enatha();
    private List<athena> b = new CopyOnWriteArrayList();

    @Nullable
    public static anateh a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            anateh anatehVar = new anateh();
            enatha a = enatha.a(jSONObject.getJSONObject("global_config"));
            if (a != null) {
                anatehVar.a = a;
            }
            return anatehVar;
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            com.transsion.ga.anateh.a("fromJSON", e);
            return null;
        }
    }

    public athena a(int i) {
        if (!anehat.b(this.b)) {
            return null;
        }
        for (athena athenaVar : this.b) {
            if (athenaVar.b() == i) {
                return athenaVar;
            }
        }
        return null;
    }

    public String a(long j) {
        return this.a.a(j);
    }

    public List<athena> a() {
        return this.b;
    }

    public void a(List<athena> list) {
        this.b.clear();
        this.b.addAll(list);
    }

    public enatha b() {
        return this.a;
    }

    public List<TidConfigBean> c() {
        ArrayList arrayList = new ArrayList();
        Iterator<athena> it = this.b.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().j());
        }
        return arrayList;
    }

    public void d() {
        for (athena athenaVar : this.b) {
            athenaVar.c(0L);
            athenaVar.b(-1L);
        }
        this.a.f(0L);
        this.a.c(-1L);
    }

    public String e() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("global_config", this.a.j());
            return jSONObject.toString();
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            com.transsion.ga.anateh.a("toJSON", e);
            return BuildConfig.FLAVOR;
        }
    }
}
