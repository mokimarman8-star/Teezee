package com.bytedance.sdk.openadsdk.zR;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP {
    private SharedPreferences Sj;
    private final String TKC;
    private final Context sP;

    public sP(Context context, String str) {
        this.sP = context;
        this.TKC = str;
    }

    private SharedPreferences sP() {
        Context context;
        SharedPreferences sharedPreferences = this.Sj;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        if (TextUtils.isEmpty(this.TKC) || (context = this.sP) == null) {
            return null;
        }
        try {
            this.Sj = context.getSharedPreferences(this.TKC, 0);
        } catch (Throwable th) {
            Log.e("SPUnit", th.getMessage());
        }
        return this.Sj;
    }

    public int Sj(String str, int i) {
        try {
            SharedPreferences sP = sP();
            if (sP != null && sP.contains(str)) {
                return sP.getInt(str, i);
            }
            return i;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.TKC);
            sb.append(th.getMessage());
            return i;
        }
    }

    public String Sj(String str, String str2) {
        try {
            SharedPreferences sP = sP();
            if (sP != null && sP.contains(str)) {
                return sP.getString(str, str2);
            }
            return str2;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.TKC);
            sb.append(th.getMessage());
            return str2;
        }
    }

    public void Sj() {
        SharedPreferences sP = sP();
        if (sP != null) {
            SharedPreferences.Editor edit = sP.edit();
            edit.clear();
            edit.commit();
        }
    }

    public void Sj(String str, long j) {
        try {
            SharedPreferences sP = sP();
            if (sP != null) {
                SharedPreferences.Editor edit = sP.edit();
                edit.putLong(str, j);
                edit.apply();
            }
        } catch (Throwable th) {
            Log.e("SPUnit", th.getMessage());
        }
    }

    public void Sj(JSONObject jSONObject) {
        try {
            SharedPreferences sP = sP();
            if (sP != null) {
                SharedPreferences.Editor edit = sP.edit();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        if (!TextUtils.isEmpty(next)) {
                            Object obj = jSONObject.get(next);
                            if (obj instanceof Integer) {
                                edit.putInt(next, ((Integer) obj).intValue());
                            } else if (obj instanceof Long) {
                                edit.putLong(next, ((Long) obj).longValue());
                            } else if (obj instanceof String) {
                                edit.putString(next, (String) obj);
                            } else if (obj instanceof Boolean) {
                                edit.putBoolean(next, ((Boolean) obj).booleanValue());
                            } else if (obj instanceof Float) {
                                edit.putFloat(next, ((Float) obj).floatValue());
                            } else if (obj instanceof Double) {
                                Double d = (Double) obj;
                                d.doubleValue();
                                edit.putFloat(next, d.floatValue());
                            }
                        }
                    } catch (Throwable th) {
                        Log.e("SPUnit", th.getMessage());
                    }
                }
                edit.apply();
            }
        } catch (Throwable th2) {
            Log.e("SPUnit", th2.getMessage());
        }
    }

    public boolean Sj(String str, boolean z) {
        try {
            SharedPreferences sP = sP();
            if (sP != null && sP.contains(str)) {
                return sP.getBoolean(str, z);
            }
            return z;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.TKC);
            sb.append(th.getMessage());
            return z;
        }
    }

    public long sP(String str, long j) {
        try {
            SharedPreferences sP = sP();
            if (sP != null && sP.contains(str)) {
                return sP.getLong(str, j);
            }
            return j;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.TKC);
            sb.append(th.getMessage());
            return j;
        }
    }
}
