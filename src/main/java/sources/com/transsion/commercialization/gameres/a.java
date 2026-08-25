package com.transsion.commercialization.gameres;

import android.content.Context;
import com.transsion.bean.GameInfoType;
import com.transsion.commercialization.gameres.aha.AHAGameResLoader;
import com.transsion.commercialization.gameres.ps.PSGameResLoader;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {
    public static final C0020a a = C0020a.a;

    /* renamed from: com.transsion.commercialization.gameres.a$a, reason: collision with other inner class name */
    public static final class C0020a {
        static final /* synthetic */ C0020a a = new C0020a();

        /* renamed from: com.transsion.commercialization.gameres.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0021a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[GameInfoType.values().length];
                try {
                    iArr[GameInfoType.AHA.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[GameInfoType.PS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        private C0020a() {
        }

        public final a a(GameInfoType gameInfoType) {
            Intrinsics.h(gameInfoType, "type");
            int i = C0021a.a[gameInfoType.ordinal()];
            if (i == 1) {
                return new AHAGameResLoader();
            }
            if (i == 2) {
                return new PSGameResLoader();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    void a(Context context, String str, String str2, Function1 function1);
}
