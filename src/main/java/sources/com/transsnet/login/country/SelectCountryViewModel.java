package com.transsnet.login.country;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsnet.loginapi.bean.Country;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class SelectCountryViewModel extends androidx.lifecycle.b {
    private final b0 b;
    private final b0 c;
    private final b0 d;
    private final b0 e;
    private HashMap f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectCountryViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = new b0();
        this.c = new b0();
        this.d = new b0();
        this.e = new b0();
        l();
    }

    private final Integer g(String str) {
        HashMap hashMap = this.f;
        if (hashMap == null) {
            return null;
        }
        Intrinsics.e(hashMap);
        return (Integer) hashMap.get(str);
    }

    private final String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String substring = str.substring(0, 1);
        Intrinsics.g(substring, "substring(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.g(locale, "getDefault(...)");
        String upperCase = substring.toUpperCase(locale);
        Intrinsics.g(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private final void l() {
        k.d(u0.a(this), y0.b(), null, new SelectCountryViewModel$initData$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        ArrayList a = lx.b.b().a(b());
        Intrinsics.g(a, "getCountryList_toArrayList(...)");
        final Function2 function2 = new Function2() { // from class: com.transsnet.login.country.f
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                int n;
                n = SelectCountryViewModel.n((Country) obj, (Country) obj2);
                return Integer.valueOf(n);
            }
        };
        CollectionsKt.A(a, new Comparator() { // from class: com.transsnet.login.country.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int o;
                o = SelectCountryViewModel.o(Function2.this, obj, obj2);
                return o;
            }
        });
        p(a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(Country obj, Country country) {
        Intrinsics.h(obj, "obj");
        return obj.compareTo(country);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    private final void p(List list) {
        if (list == null || list.isEmpty()) {
            this.c.n((Object) null);
            return;
        }
        if (this.f == null) {
            this.f = new HashMap();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            Country country = (Country) it.next();
            String country2 = country.getCountry();
            Intrinsics.g(country2, "getCountry(...)");
            String h = h(country2);
            if (!TextUtils.isEmpty(h) && !CollectionsKt.b0(arrayList, h)) {
                country.setIndex(h);
                Intrinsics.e(h);
                arrayList.add(h);
                Integer valueOf = Integer.valueOf(i);
                HashMap hashMap = this.f;
                Intrinsics.e(hashMap);
                hashMap.put(h, valueOf);
            }
            i++;
        }
        arrayList.add("#");
        HashMap hashMap2 = this.f;
        Intrinsics.e(hashMap2);
        hashMap2.put("#", Integer.valueOf(i - 1));
        this.b.n(list);
        this.c.n(arrayList);
    }

    public final LiveData f() {
        return this.b;
    }

    public final LiveData i() {
        return this.d;
    }

    public final LiveData j() {
        return this.e;
    }

    public final LiveData k() {
        return this.c;
    }

    public final void q(String index) {
        Intrinsics.h(index, "index");
        this.d.q(g(index));
    }

    public final void r(Country country) {
        if (country != null) {
            this.e.q(new kx.a(country));
        }
    }
}
