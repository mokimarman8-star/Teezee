package com.aliyun.player.nativeclass;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Options {
    private static final int FLAG_APPEND = 1;
    private static final int FLAG_REPLACE = 2;
    private Map<String, String> mOptions = new HashMap();

    public String get(String str) {
        return this.mOptions.get(str);
    }

    public void reset() {
        this.mOptions.clear();
    }

    public boolean set(String str, String str2, int i) {
        if (!this.mOptions.containsKey(str)) {
            this.mOptions.put(str, str2);
        } else if (i == 1) {
            this.mOptions.put(str, this.mOptions.get(str) + str2);
        } else {
            if (i != 2) {
                return false;
            }
            this.mOptions.put(str, str2);
        }
        return true;
    }
}
