package com.aliyun.liveshift.bean;

import com.aliyun.utils.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TimeLineInfo {
    private static final String TAG = "TimeLineInfo";
    public long end;
    public long start;

    public static List<TimeLineInfo> getInfoArrayFromJson(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                TimeLineInfo infoFromJson = getInfoFromJson(jSONArray.getJSONObject(i));
                if (infoFromJson != null) {
                    arrayList.add(infoFromJson);
                }
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    private static TimeLineInfo getInfoFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        TimeLineInfo timeLineInfo = new TimeLineInfo();
        timeLineInfo.start = JsonUtil.getLong(jSONObject, "start");
        timeLineInfo.end = JsonUtil.getLong(jSONObject, "end");
        return timeLineInfo;
    }
}
