package com.transsion.api.gateway.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.transsion.api.gateway.utils.GatewayUtils;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class GatewayTrackData implements Parcelable {
    public static final Parcelable.Creator<GatewayTrackData> CREATOR = new Parcelable.Creator<GatewayTrackData>() { // from class: com.transsion.api.gateway.bean.GatewayTrackData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GatewayTrackData createFromParcel(Parcel parcel) {
            return new GatewayTrackData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GatewayTrackData[] newArray(int i) {
            return new GatewayTrackData[i];
        }
    };
    private JSONObject jsonObject;

    public GatewayTrackData() {
        this.jsonObject = new JSONObject();
    }

    public GatewayTrackData(Bundle bundle) {
        this.jsonObject = new JSONObject();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                add(str, String.valueOf(bundle.get(str)));
            }
        }
    }

    public GatewayTrackData(Parcel parcel) {
        try {
            this.jsonObject = new JSONObject(parcel.readString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public GatewayTrackData add(String str, double d) {
        try {
            this.jsonObject.put("_" + str.toLowerCase(), d);
        } catch (Exception unused) {
        }
        return this;
    }

    public GatewayTrackData add(String str, int i) {
        try {
            this.jsonObject.put("_" + str.toLowerCase(), i);
        } catch (Exception unused) {
        }
        return this;
    }

    public GatewayTrackData add(String str, long j) {
        try {
            this.jsonObject.put("_" + str.toLowerCase(), j);
        } catch (Exception unused) {
        }
        return this;
    }

    public GatewayTrackData add(String str, Bundle bundle) {
        if (bundle == null) {
            return this;
        }
        String lowerCase = str.toLowerCase();
        Set<String> keySet = bundle.keySet();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : keySet) {
                jSONObject.put(str2, bundle.get(str2));
            }
            this.jsonObject.put(lowerCase, jSONObject);
        } catch (Exception e) {
            GatewayUtils.L.e(e);
        }
        return this;
    }

    public GatewayTrackData add(String str, String str2) {
        if (str2 == null) {
            str2 = "null";
        }
        try {
            this.jsonObject.put("_" + str.toLowerCase(), str2);
        } catch (Exception unused) {
        }
        return this;
    }

    public GatewayTrackData add(String str, List<Bundle> list) {
        String str2 = "_" + str.toLowerCase();
        try {
            JSONArray jSONArray = new JSONArray();
            for (Bundle bundle : list) {
                Set<String> keySet = bundle.keySet();
                JSONObject jSONObject = new JSONObject();
                for (String str3 : keySet) {
                    if (bundle.get(str3) instanceof String) {
                        jSONObject.put("_" + str3, bundle.get(str3));
                    } else {
                        jSONObject.put("_" + str3, bundle.get(str3));
                    }
                }
                jSONArray.put(jSONObject);
            }
            this.jsonObject.put(str2, jSONArray);
        } catch (Exception unused) {
        }
        return this;
    }

    public GatewayTrackData add(String str, boolean z) {
        try {
            this.jsonObject.put("_" + str.toLowerCase(), z);
        } catch (Exception unused) {
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public boolean has(String str) {
        JSONObject jSONObject = this.jsonObject;
        return jSONObject != null && jSONObject.has(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jsonObject.toString());
    }
}
