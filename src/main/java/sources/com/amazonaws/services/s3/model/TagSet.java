package com.amazonaws.services.s3.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TagSet {
    private Map a;

    public TagSet() {
        this.a = new HashMap(1);
    }

    public TagSet(Map map) {
        HashMap hashMap = new HashMap(1);
        this.a = hashMap;
        hashMap.putAll(map);
    }

    public Map a() {
        return this.a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("Tags: " + a());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
