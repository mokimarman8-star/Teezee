package com.mbridge.msdk.playercommon.exoplayer2.text;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface Subtitle {
    List<Cue> getCues(long j);

    long getEventTime(int i);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j);
}
