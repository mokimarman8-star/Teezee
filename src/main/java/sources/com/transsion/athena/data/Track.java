package com.transsion.athena.data;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class Track {
    public static final int SAVE_FLAG_NONE = -1;
    public static final int SAVE_FLAG_TO_DB = 1;
    public static final int SAVE_FLAG_TO_FILE = 0;
    private String a;
    private JSONObject b;
    private JSONObject c;
    private long d;
    private int e;
    private long f;
    private long g;
    private String h;
    private TrackData i;

    public String getBootId() {
        return this.h;
    }

    public String getEventName() {
        return this.a;
    }

    public JSONObject getJsonData() {
        return this.b;
    }

    public JSONObject getOriginJsonData() {
        return this.c;
    }

    public long getTid() {
        return this.d;
    }

    public TrackData getTrackData() {
        return this.i;
    }

    public long getTrackErTs() {
        return this.g;
    }

    public int getTrackFlag() {
        return this.e;
    }

    public long getTrackTs() {
        return this.f;
    }

    public void setBootId(String str) {
        this.h = str;
    }

    public void setEventName(String str) {
        this.a = str;
    }

    public void setJsonData(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public void setOriginJsonData(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public void setTid(long j) {
        this.d = j;
    }

    public void setTrackData(TrackData trackData) {
        this.i = trackData;
    }

    public void setTrackErTs(long j) {
        this.g = j;
    }

    public void setTrackFlag(int i) {
        this.e = i;
    }

    public void setTrackTs(long j) {
        this.f = j;
    }

    @NonNull
    public String toString() {
        return "tid = " + this.d + ",event = " + this.b.toString();
    }
}
