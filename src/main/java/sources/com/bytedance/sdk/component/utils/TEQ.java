package com.bytedance.sdk.component.utils;

import java.io.Closeable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TEQ {
    public static void Sj(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
