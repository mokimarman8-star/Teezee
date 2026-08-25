package com.transsion.infra.gateway.core.utils;

import com.transsion.gslb.BuildConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class c {
    public static ObjectLogUtils a = new Object() { // from class: com.transsion.infra.gateway.core.utils.ObjectLogUtils$a
        private boolean a = false;
        private boolean b = true;
        private String c = null;
        private boolean d = true;
        private boolean e = true;
        private boolean f = false;
        private boolean g = true;
        private int h = 2;
        private int i = 2;
        private String j;
        private String k;

        public ObjectLogUtils m() {
            return new ObjectLogUtils(this, (ObjectLogUtils$1) null);
        }

        public ObjectLogUtils$a n(boolean z) {
            this.g = z;
            return this;
        }

        public ObjectLogUtils$a o(String str) {
            if (ObjectLogUtils.a(str)) {
                this.c = BuildConfig.FLAVOR;
                this.d = true;
            } else {
                this.c = str;
                this.d = false;
            }
            return this;
        }

        public ObjectLogUtils$a p(boolean z) {
            this.e = z;
            return this;
        }

        public ObjectLogUtils$a q(boolean z) {
            this.a = z;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("switch: ");
            sb.append(this.a);
            sb.append(ObjectLogUtils.b());
            sb.append("console: ");
            sb.append(this.b);
            sb.append(ObjectLogUtils.b());
            sb.append("tag: ");
            sb.append(this.d ? "null" : this.c);
            sb.append(ObjectLogUtils.b());
            sb.append("head: ");
            sb.append(this.e);
            sb.append(ObjectLogUtils.b());
            sb.append("file: ");
            sb.append(this.f);
            sb.append(ObjectLogUtils.b());
            sb.append("dir: ");
            String str = this.k;
            if (str == null) {
                str = this.j;
            }
            sb.append(str);
            sb.append(ObjectLogUtils.b());
            sb.append("border: ");
            sb.append(this.g);
            sb.append(ObjectLogUtils.b());
            sb.append("consoleFilter: ");
            sb.append(ObjectLogUtils.c()[this.h - 2]);
            sb.append(ObjectLogUtils.b());
            sb.append("fileFilter: ");
            sb.append(ObjectLogUtils.c()[this.i - 2]);
            return sb.toString();
        }
    }.o("gateway_core").q(false).p(false).n(false).m();
}
