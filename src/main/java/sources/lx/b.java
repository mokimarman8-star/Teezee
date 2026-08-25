package lx;

import android.content.Context;
import com.transsnet.loginapi.bean.Country;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b {
    private static b a;
    private static JSONArray b;

    public static b b() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    private String c(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (IOException unused) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
            } catch (IOException unused3) {
            }
        } catch (IOException unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        return sb.toString();
    }

    public ArrayList a(Context context) {
        ArrayList arrayList = new ArrayList();
        if (b == null) {
            d(context);
        }
        JSONArray jSONArray = b;
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = b.getJSONObject(i);
                    Country country = new Country();
                    country.setCountry(jSONObject.getString("cn"));
                    country.setCode(jSONObject.getString("pcc"));
                    if (jSONObject.has("mcc")) {
                        country.setMcc(jSONObject.getString("mcc"));
                    }
                    if (jSONObject.has("alpha2")) {
                        country.setCountry_s(jSONObject.getString("alpha2"));
                    }
                    arrayList.add(country);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public JSONArray d(Context context) {
        String str;
        if (b == null) {
            try {
                str = c(context.getAssets().open("sdk_country_cc_mcc.json"));
            } catch (IOException e) {
                e.printStackTrace();
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            try {
                b = new JSONArray(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return b;
    }
}
