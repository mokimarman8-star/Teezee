package com.bykv.vk.openvk.preload.a;

import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class l extends i {
    private final com.bykv.vk.openvk.preload.a.b.g<String, i> a = new com.bykv.vk.openvk.preload.a.b.g<>();

    public final void a(String str, i iVar) {
        com.bykv.vk.openvk.preload.a.b.g<String, i> gVar = this.a;
        if (iVar == null) {
            iVar = k.a;
        }
        gVar.put(str, iVar);
    }

    public final Set<Map.Entry<String, i>> d() {
        return this.a.entrySet();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof l) && ((l) obj).a.equals(this.a);
        }
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
