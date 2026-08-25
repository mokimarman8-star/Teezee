package com.transsion.baseui.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class k {

    public static final class a extends k {
        private final int a;

        public a(int i) {
            super(null);
            this.a = i;
        }

        public final int a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return this.a;
        }

        public String toString() {
            return "Icon(iconRes=" + this.a + ")";
        }
    }

    public static final class b extends k {
        private final String a;
        private final Integer b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Integer num) {
            super(null);
            Intrinsics.h(str, "content");
            this.a = str;
            this.b = num;
        }

        public final String a() {
            return this.a;
        }

        public final Integer b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.c(this.a, bVar.a) && Intrinsics.c(this.b, bVar.b);
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            Integer num = this.b;
            return hashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "Text(content=" + this.a + ", textColorRes=" + this.b + ")";
        }
    }

    private k() {
    }

    public /* synthetic */ k(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
