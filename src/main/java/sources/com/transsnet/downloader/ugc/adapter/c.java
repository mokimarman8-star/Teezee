package com.transsnet.downloader.ugc.adapter;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class c {

    public static final class a extends c {
        private final DownloadBean a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DownloadBean bean) {
            super(null);
            Intrinsics.h(bean, "bean");
            this.a = bean;
        }

        public final DownloadBean a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.c(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "AllEpBtnItem(bean=" + this.a + ")";
        }
    }

    public static final class b extends c {
        private final DownloadBean a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DownloadBean bean) {
            super(null);
            Intrinsics.h(bean, "bean");
            this.a = bean;
        }

        public final b a(DownloadBean bean) {
            Intrinsics.h(bean, "bean");
            return new b(bean);
        }

        public final DownloadBean b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.c(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "DownloadedItem(bean=" + this.a + ")";
        }
    }

    /* renamed from: com.transsnet.downloader.ugc.adapter.c$c, reason: collision with other inner class name */
    public static final class C0029c extends c {
        private final DownloadBean a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0029c(DownloadBean bean) {
            super(null);
            Intrinsics.h(bean, "bean");
            this.a = bean;
        }

        public final C0029c a(DownloadBean bean) {
            Intrinsics.h(bean, "bean");
            return new C0029c(bean);
        }

        public final DownloadBean b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0029c) && Intrinsics.c(this.a, ((C0029c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "DownloadingItem(bean=" + this.a + ")";
        }
    }

    public static final class d extends c {
        public static final d a = new d();

        private d() {
            super(null);
        }
    }

    public static final class e extends c {
        private final UGCVideo a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(UGCVideo video) {
            super(null);
            Intrinsics.h(video, "video");
            this.a = video;
        }

        public final UGCVideo a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && Intrinsics.c(this.a, ((e) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ForYouItem(video=" + this.a + ")";
        }
    }

    public static final class f extends c {
        public static final f a = new f();

        private f() {
            super(null);
        }
    }

    private c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
