package com.transsion.transfer.androidasync.http;

import android.net.Uri;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class i extends j {
    public i(Uri uri) {
        super(uri, "POST");
    }

    public i(String str) {
        this(Uri.parse(str));
    }
}
