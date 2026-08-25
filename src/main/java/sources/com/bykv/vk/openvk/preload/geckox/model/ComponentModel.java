package com.bykv.vk.openvk.preload.geckox.model;

import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ComponentModel {

    @com.bykv.vk.openvk.preload.a.a.b(a = "packages")
    private Map<String, List<UpdatePackage>> packages;

    @com.bykv.vk.openvk.preload.a.a.b(a = "universal_strategies")
    private Map<String, b> universalStrategies;

    public static class a {

        @com.bykv.vk.openvk.preload.a.a.b(a = "c")
        public String a;
    }

    public static class b {

        @com.bykv.vk.openvk.preload.a.a.b(a = "specified_clean")
        public List<a> a;
    }

    public Map<String, List<UpdatePackage>> getPackages() {
        return this.packages;
    }

    public Map<String, b> getUniversalStrategies() {
        return this.universalStrategies;
    }
}
