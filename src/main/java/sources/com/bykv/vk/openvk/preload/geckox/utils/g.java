package com.bykv.vk.openvk.preload.geckox.utils;

import java.io.File;
import java.io.FileFilter;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class g {
    public static Long a(File file) {
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.bykv.vk.openvk.preload.geckox.utils.g.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.isDirectory();
            }
        });
        Long l = null;
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                try {
                    Long valueOf = Long.valueOf(file2.getName());
                    long longValue = valueOf.longValue();
                    if (l == null || longValue > l.longValue()) {
                        l = valueOf;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return l;
    }
}
