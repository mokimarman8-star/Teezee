package com.transsion.ga;

import com.transsion.athena.data.TrackData;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ AthenaAnalytics a;
    public final /* synthetic */ String b;
    public final /* synthetic */ TrackData c;
    public final /* synthetic */ long d;

    public /* synthetic */ a(AthenaAnalytics athenaAnalytics, String str, TrackData trackData, long j) {
        this.a = athenaAnalytics;
        this.b = str;
        this.c = trackData;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AthenaAnalytics.b(this.a, this.b, this.c, this.d);
    }
}
