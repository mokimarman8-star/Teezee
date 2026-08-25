package com.cloud.tmc.kernel.utils;

import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class CollectionUtils {
    public static final boolean isEmpty(List list) {
        if (list == null) {
            return true;
        }
        return list.isEmpty();
    }

    public static final boolean isEmpty(Map map) {
        if (map == null) {
            return true;
        }
        return map.isEmpty();
    }
}
