package com.transsion.search.fragment.suggest;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.bean.SuggestEntity;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/transsion/search/fragment/suggest/d;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/search/bean/SuggestEntity;", "<init>", "()V", BuildConfig.FLAVOR, "keyWord", BuildConfig.FLAVOR, "R1", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "G", "Ljava/lang/String;", "Q1", "()Ljava/lang/String;", "S1", "mKeyWord", "H", "a", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseProviderMultiAdapter<SuggestEntity> {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int I = 3;
    public static final int J = 2;
    public static final int K = 1;
    public static final int L = 0;

    /* renamed from: G, reason: from kotlin metadata */
    private String mKeyWord;

    /* renamed from: com.transsion.search.fragment.suggest.d$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final CharSequence a(String str, String str2) {
            String str3;
            int length;
            int i;
            int o0;
            int length2;
            SpannableStringBuilder spannableStringBuilder;
            Intrinsics.h(str, "mKeyWord");
            try {
                Result.Companion companion = Result.Companion;
                Locale locale = Locale.ROOT;
                String upperCase = str.toUpperCase(locale);
                Intrinsics.g(upperCase, "toUpperCase(...)");
                if (str2 != null) {
                    String upperCase2 = str2.toUpperCase(locale);
                    Intrinsics.g(upperCase2, "toUpperCase(...)");
                    if (upperCase2 != null) {
                        str3 = upperCase2;
                        length = upperCase.length() - 1;
                        i = 0;
                        boolean z = false;
                        while (i <= length) {
                            boolean z2 = Intrinsics.j(upperCase.charAt(!z ? i : length), 32) <= 0;
                            if (z) {
                                if (!z2) {
                                    break;
                                }
                                length--;
                            } else if (z2) {
                                i++;
                            } else {
                                z = true;
                            }
                        }
                        if (upperCase.subSequence(i, length + 1).toString().length() != 0 || !StringsKt.c0(str3, upperCase, false, 2, (Object) null)) {
                            return str2;
                        }
                        o0 = StringsKt.o0(str3, upperCase, 0, false, 6, (Object) null);
                        length2 = upperCase.length() + o0;
                        spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) str2);
                        if (length2 != 0 && o0 != -1) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#10A84D")), o0, length2, 33);
                        }
                        return spannableStringBuilder;
                    }
                }
                str3 = BuildConfig.FLAVOR;
                length = upperCase.length() - 1;
                i = 0;
                boolean z3 = false;
                while (i <= length) {
                }
                if (upperCase.subSequence(i, length + 1).toString().length() != 0) {
                    return str2;
                }
                o0 = StringsKt.o0(str3, upperCase, 0, false, 6, (Object) null);
                length2 = upperCase.length() + o0;
                spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) str2);
                if (length2 != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#10A84D")), o0, length2, 33);
                }
                return spannableStringBuilder;
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
                return BuildConfig.FLAVOR;
            }
        }
    }

    public d() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        F1(new aq.d());
        F1(new aq.b());
        F1(new aq.c());
        F1(new aq.a());
        this.mKeyWord = BuildConfig.FLAVOR;
    }

    protected int N1(List<SuggestEntity> data, int position) {
        Intrinsics.h(data, "data");
        Integer type = data.get(position).getType();
        if (type != null && type.intValue() == 2) {
            return 2;
        }
        if (type != null && type.intValue() == 1) {
            return 1;
        }
        return ((type != null && type.intValue() == 0) || type == null || type.intValue() != 3) ? 0 : 3;
    }

    /* renamed from: Q1, reason: from getter */
    public final String getMKeyWord() {
        return this.mKeyWord;
    }

    public final void R1(String keyWord) {
        Intrinsics.h(keyWord, "keyWord");
        this.mKeyWord = keyWord;
    }

    public final void S1(String str) {
        Intrinsics.h(str, "<set-?>");
        this.mKeyWord = str;
    }
}
