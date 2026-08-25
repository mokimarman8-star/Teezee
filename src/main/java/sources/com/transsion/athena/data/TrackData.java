package com.transsion.athena.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.athena.taaneh.aethna;
import com.transsion.ga.AthenaAnalytics;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class TrackData implements Parcelable {
    public static final Parcelable.Creator<TrackData> CREATOR = new athena();
    public static final int TRACK_ADD = 1;
    public static final int TRACK_APPEND = 2;
    public static final int TRACK_NORMAL = 0;
    private JSONObject a;
    private int b;
    private float c;

    public TrackData() {
        this.b = 0;
        this.c = 1.0f;
        this.a = new JSONObject();
    }

    public TrackData(int i, String str) {
        this.c = 1.0f;
        this.b = i;
        try {
            if (TextUtils.isEmpty(str)) {
                this.a = new JSONObject();
            } else {
                this.a = new JSONObject(str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public TrackData(int i, JSONObject jSONObject) {
        this.c = 1.0f;
        this.b = i;
        this.a = jSONObject;
    }

    public TrackData(Bundle bundle) {
        this.b = 0;
        this.c = 1.0f;
        this.a = new JSONObject();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                add(str, String.valueOf(bundle.get(str)));
            }
        }
    }

    protected TrackData(Parcel parcel) {
        this.b = 0;
        this.c = 1.0f;
        try {
            this.b = parcel.readInt();
            this.a = new JSONObject(parcel.readString());
            this.c = parcel.readFloat();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject a() {
        return this.a;
    }

    public void a(float f) {
        this.c = f;
    }

    public TrackData add(String str, double d) {
        return add(str, d, 0);
    }

    public TrackData add(String str, double d, int i) {
        String str2 = "_" + str;
        if (i != 0) {
            this.b = i;
        }
        try {
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
        if (i == 0) {
            this.a.put(str2, d);
        } else {
            if (i != 1) {
                if (i == 2) {
                    this.a.put(str2 + "&append", d);
                }
                return this;
            }
            this.a.put(str2 + "&add", d);
        }
        return this;
    }

    public TrackData add(String str, int i) {
        return add(str, i, 0);
    }

    public TrackData add(String str, int i, int i2) {
        String str2 = "_" + str;
        if (i2 != 0) {
            this.b = i2;
        }
        try {
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
        if (i2 == 0) {
            this.a.put(str2, i);
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.a.put(str2 + "&append", i);
                }
                return this;
            }
            this.a.put(str2 + "&add", i);
        }
        return this;
    }

    public TrackData add(String str, long j) {
        return add(str, j, 0);
    }

    public TrackData add(String str, long j, int i) {
        String str2 = "_" + str;
        if (i != 0) {
            this.b = i;
        }
        try {
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
        if (i == 0) {
            this.a.put(str2, j);
        } else {
            if (i != 1) {
                if (i == 2) {
                    this.a.put(str2 + "&append", j);
                }
                return this;
            }
            this.a.put(str2 + "&add", j);
        }
        return this;
    }

    public TrackData add(String str, Bundle bundle) {
        return add(str, bundle, 0);
    }

    public TrackData add(String str, Bundle bundle, int i) {
        if (bundle == null) {
            return this;
        }
        String str2 = "_" + str;
        if (i != 0) {
            this.b = i;
        }
        Set<String> keySet = bundle.keySet();
        JSONObject jSONObject = new JSONObject();
        try {
            if (i == 0) {
                for (String str3 : keySet) {
                    if (bundle.get(str3) instanceof String) {
                        jSONObject.put("_" + str3, AthenaAnalytics.M().a((String) bundle.get(str3)));
                    } else {
                        jSONObject.put("_" + str3, bundle.get(str3));
                    }
                }
                this.a.put(str2, jSONObject);
            } else {
                if (i == 1) {
                    throw new IllegalArgumentException("json object can not set TRACK_ADD flag");
                }
                if (i == 2) {
                    for (String str4 : keySet) {
                        if (bundle.get(str4) instanceof String) {
                            jSONObject.put("_" + str4, AthenaAnalytics.M().a((String) bundle.get(str4)));
                        } else {
                            jSONObject.put("_" + str4, bundle.get(str4));
                        }
                    }
                    this.a.put(str2 + "&append", jSONObject);
                }
            }
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
        return this;
    }

    public TrackData add(String str, Number number) {
        return add(str, number, 0);
    }

    public TrackData add(String str, Number number, int i) {
        String str2 = "_" + str;
        if (i != 0) {
            this.b = i;
        }
        try {
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
        if (i == 0) {
            this.a.put(str2, number);
        } else {
            if (i != 1) {
                if (i == 2) {
                    this.a.put(str2 + "&append", number);
                }
                return this;
            }
            this.a.put(str2 + "&add", number);
        }
        return this;
    }

    public TrackData add(String str, String str2) {
        if (str2 == null) {
            str2 = "null";
        }
        return add(str, str2, 0);
    }

    public TrackData add(String str, String str2, int i) {
        String str3 = "_" + str;
        if (i != 0) {
            this.b = i;
        }
        try {
            if (i == 0) {
                this.a.put(str3, AthenaAnalytics.M().a(str2));
            } else {
                if (i == 1) {
                    throw new IllegalArgumentException("json object can not set TRACK_ADD flag");
                }
                if (i == 2) {
                    this.a.put(str3 + "&append", AthenaAnalytics.M().a(str2));
                }
            }
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
        return this;
    }

    public TrackData add(String str, List<Bundle> list) {
        String str2 = "_" + str;
        try {
            JSONArray jSONArray = new JSONArray();
            for (Bundle bundle : list) {
                Set<String> keySet = bundle.keySet();
                JSONObject jSONObject = new JSONObject();
                for (String str3 : keySet) {
                    if (bundle.get(str3) instanceof String) {
                        jSONObject.put("_" + str3, AthenaAnalytics.M().a((String) bundle.get(str3)));
                    } else {
                        jSONObject.put("_" + str3, bundle.get(str3));
                    }
                }
                jSONArray.put(jSONObject);
            }
            this.a.put(str2, jSONArray);
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
        return this;
    }

    public TrackData add(String str, boolean z) {
        return add(str, z, 0);
    }

    public TrackData add(String str, boolean z, int i) {
        String str2 = "_" + str;
        if (i != 0) {
            this.b = i;
        }
        try {
            if (i == 0) {
                this.a.put(str2, z);
            } else {
                if (i == 1) {
                    throw new IllegalArgumentException("json object can not set TRACK_ADD flag");
                }
                if (i == 2) {
                    this.a.put(str2 + "&append", z);
                }
            }
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
        return this;
    }

    public float b() {
        return this.c;
    }

    public int c() {
        try {
            return this.a.toString().getBytes().length + 4;
        } catch (Exception unused) {
            return 4;
        }
    }

    public int d() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeString(this.a.toString());
        parcel.writeFloat(this.c);
    }
}
