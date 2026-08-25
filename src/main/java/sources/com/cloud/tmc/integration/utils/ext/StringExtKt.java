package com.cloud.tmc.integration.utils.ext;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.miniutils.util.EncryptUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0086\bø\u0001\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001\u001a\f\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0001\u001a&\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\nH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"orDefault", "", "fallbackValue", "Lkotlin/Function0;", "orDefaultAndCheckEmpty", "takeIfNotEmpty", "toMd5", "useNotEmpty", "", "block", "Lkotlin/Function1;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class StringExtKt {
    public static final String orDefault(String str, String str2) {
        Intrinsics.h(str2, "fallbackValue");
        return str == null ? str2 : str;
    }

    public static final String orDefault(String str, Function0<String> function0) {
        Intrinsics.h(function0, "fallbackValue");
        return str == null ? (String) function0.invoke() : str;
    }

    public static final String orDefaultAndCheckEmpty(String str, String str2) {
        Intrinsics.h(str2, "fallbackValue");
        return (str == null || str.length() == 0) ? str2 : str;
    }

    public static final String takeIfNotEmpty(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str;
    }

    public static final String toMd5(String str) {
        String encryptMD5ToString = EncryptUtils.encryptMD5ToString(str);
        Intrinsics.g(encryptMD5ToString, "encryptMD5ToString(this)");
        return encryptMD5ToString;
    }

    public static final void useNotEmpty(String str, Function1<? super String, Unit> function1) {
        Intrinsics.h(function1, "block");
        String takeIfNotEmpty = takeIfNotEmpty(str);
        if (takeIfNotEmpty != null) {
            function1.invoke(takeIfNotEmpty);
        }
    }
}
