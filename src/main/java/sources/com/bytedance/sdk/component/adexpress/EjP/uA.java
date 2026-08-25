package com.bytedance.sdk.component.adexpress.EjP;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.tmc.integration.utils.share.config.ShareConstant;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class uA {

    public enum Sj {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE(ShareConstant.SHARE_TYPE_IMAGE);

        private String HiB;

        Sj(String str) {
            this.HiB = str;
        }

        public String Sj() {
            return this.HiB;
        }
    }

    public static Sj Sj(String str) {
        Sj sj = Sj.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        sj = Sj.CSS;
                    } else if (path.endsWith(".js")) {
                        sj = Sj.JS;
                    } else if (!path.endsWith(".jpg") && !path.endsWith(".gif") && !path.endsWith(".png") && !path.endsWith(".jpeg") && !path.endsWith(".webp") && !path.endsWith(".bmp") && !path.endsWith(".ico") && path.endsWith(".html")) {
                        sj = Sj.HTML;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return sj;
    }

    public static boolean sP(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return false;
        }
        String path = parse.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }
}
