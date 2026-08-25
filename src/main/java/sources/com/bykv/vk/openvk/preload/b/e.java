package com.bykv.vk.openvk.preload.b;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface e {

    public static class a implements e {
        @Override // com.bykv.vk.openvk.preload.b.e
        public final <T> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    <T> T a(Class<T> cls);
}
