package com.mbridge.msdk.playercommon.exoplayer2.scheduler;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface Scheduler {
    public static final boolean DEBUG = false;

    boolean cancel();

    boolean schedule(Requirements requirements, String str, String str2);
}
