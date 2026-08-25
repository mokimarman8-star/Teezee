package com.transsnet.downloader.manager;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class p {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ g b(a aVar, Context context, int i, Object obj) {
            if ((i & 1) != 0) {
                context = null;
            }
            return aVar.a(context);
        }

        public final g a(Context context) {
            return DownloadManagerImpl.y.a();
        }
    }
}
