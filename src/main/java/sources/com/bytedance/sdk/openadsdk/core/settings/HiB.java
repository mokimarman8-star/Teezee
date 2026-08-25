package com.bytedance.sdk.openadsdk.core.settings;

import com.bytedance.sdk.component.utils.sU;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface HiB {
    public static final sP<JSONObject> Sj = new sP<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.settings.HiB.1
        @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.sP
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public JSONObject sP(String str) {
            try {
                return new JSONObject(str);
            } catch (Exception e) {
                sU.Sj("ISettingsDataRepository", "", e);
                return null;
            }
        }
    };
    public static final sP<Set<String>> sP = new sP<Set<String>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.HiB.2
        @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.sP
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public Set<String> sP(String str) {
            HashSet hashSet = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    hashSet.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                sU.Sj("ISettingsDataRepository", "", e);
            }
            return hashSet;
        }
    };

    public interface Sj {
        Sj Sj(String str);

        Sj Sj(String str, float f);

        Sj Sj(String str, int i);

        Sj Sj(String str, long j);

        Sj Sj(String str, String str2);

        Sj Sj(String str, boolean z);

        void Sj();
    }

    public interface sP<T> {
        T sP(String str);
    }

    void Sj(JSONObject jSONObject);
}
