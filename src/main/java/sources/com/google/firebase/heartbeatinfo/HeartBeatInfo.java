package com.google.firebase.heartbeatinfo;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface HeartBeatInfo {

    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        HeartBeat(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    HeartBeat b(String str);
}
