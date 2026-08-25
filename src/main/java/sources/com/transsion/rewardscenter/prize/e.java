package com.transsion.rewardscenter.prize;

import com.transsion.rewardscenterapi.DrawChance;
import com.transsion.rewardscenterapi.DrawResult;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class e {

    public static final class a extends e {
        private final DrawChance a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DrawChance drawChance) {
            super(null);
            Intrinsics.h(drawChance, "data");
            this.a = drawChance;
        }

        public final DrawChance a() {
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
            return "DrawChanceItem(data=" + this.a + ")";
        }
    }

    public static final class b extends e {
        private final boolean a;

        public b(boolean z) {
            super(null);
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return androidx.compose.foundation.e.a(this.a);
        }

        public String toString() {
            return "FooterItem(isExpanded=" + this.a + ")";
        }
    }

    public static final class c extends e {
        private final DrawResult a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DrawResult drawResult) {
            super(null);
            Intrinsics.h(drawResult, "data");
            this.a = drawResult;
        }

        public final DrawResult a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.c(this.a, ((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Row(data=" + this.a + ")";
        }
    }

    private e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
