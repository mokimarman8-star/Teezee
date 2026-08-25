package com.bytedance.sdk.openadsdk.core.Ym.TKC;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC {

    @NonNull
    private final List<String> Sj;

    @NonNull
    private final Map<sP, String> sP;

    public TKC(@NonNull List<String> list) {
        this.Sj = list;
        HashMap hashMap = new HashMap();
        this.sP = hashMap;
        hashMap.put(sP.CACHEBUSTING, sP());
    }

    @NonNull
    private String sP() {
        return String.format(Locale.US, "%08d", Long.valueOf(Math.round(Math.random() * 1.0E8d)));
    }

    @NonNull
    private String sP(long j) {
        Locale locale = Locale.getDefault();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return String.format(locale, "%02d:%02d:%02d.%03d", Long.valueOf(timeUnit.toHours(j)), Long.valueOf(timeUnit.toMinutes(j) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(timeUnit.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j % 1000));
    }

    @NonNull
    public TKC Sj(@Nullable long j) {
        if (j >= 0) {
            String sP = sP(j);
            if (!TextUtils.isEmpty(sP)) {
                this.sP.put(sP.CONTENTPLAYHEAD, sP);
            }
        }
        return this;
    }

    @NonNull
    public TKC Sj(@Nullable com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj sj) {
        if (sj != null) {
            this.sP.put(sP.ERRORCODE, sj.Sj());
        }
        return this;
    }

    @NonNull
    public TKC Sj(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, Key.STRING_CHARSET_NAME);
            } catch (Throwable unused) {
            }
            this.sP.put(sP.ASSETURI, str);
        }
        return this;
    }

    @NonNull
    public List<String> Sj() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.Sj) {
            if (!TextUtils.isEmpty(str)) {
                for (sP sPVar : sP.values()) {
                    String str2 = this.sP.get(sPVar);
                    if (str2 == null) {
                        str2 = "";
                    }
                    str = str.replaceAll("\\[" + sPVar.name() + "\\]", str2);
                }
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
