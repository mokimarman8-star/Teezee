package com.transsion.athena.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.taaneh.aethna;
import com.transsion.athena.taaneh.athena;
import com.transsion.core.log.ObjectLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class AppIdData implements Parcelable {
    public static final Parcelable.Creator<AppIdData> CREATOR = new athena();
    public int a;
    public String b;
    public String c;
    public int d;
    public List<anehat> e = new ArrayList();
    public String f;

    public AppIdData() {
    }

    public AppIdData(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
    }

    public static AppIdData a(Context context, int i) {
        AppIdData appIdData = new AppIdData();
        appIdData.a = i;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pkgName", athena.h(context));
            jSONObject.put("versionSDK", "3.1.1.4");
            jSONObject.put("channel", ehanat.g());
            jSONObject.put("installer", athena.e(context));
            jSONObject.put("versionName", athena.j(context));
            jSONObject.put("versionCode", String.valueOf(athena.i(context)));
            appIdData.b = jSONObject.toString();
        } catch (Exception e) {
            ObjectLogUtils objectLogUtils = aethna.a;
            aethna.b(Log.getStackTraceString(e));
        }
        return appIdData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<anehat> it = this.e.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return "AppIdData{appid=" + this.a + ", baseInfo='" + this.b + "', packetUid='" + this.c + "', retryTimes=" + this.d + ", serverUrl='" + this.f + "', tidEventSets='" + ((Object) sb) + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
    }
}
