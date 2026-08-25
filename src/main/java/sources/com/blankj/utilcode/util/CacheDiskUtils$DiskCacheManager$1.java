package com.blankj.utilcode.util;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class CacheDiskUtils$DiskCacheManager$1 implements Runnable {
    final /* synthetic */ e this$0;
    final /* synthetic */ File val$cacheDir;

    class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith("cdu_");
        }
    }

    CacheDiskUtils$DiskCacheManager$1(e eVar, File file) {
        this.val$cacheDir = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        File[] listFiles = this.val$cacheDir.listFiles(new a());
        if (listFiles != null) {
            int i = 0;
            int i2 = 0;
            for (File file : listFiles) {
                i = (int) (i + file.length());
                i2++;
                e.a(null).put(file, Long.valueOf(file.lastModified()));
            }
            e.b(null).getAndAdd(i);
            e.c(null).getAndAdd(i2);
        }
    }
}
