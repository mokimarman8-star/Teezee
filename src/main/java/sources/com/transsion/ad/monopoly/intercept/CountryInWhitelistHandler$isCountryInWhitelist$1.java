package com.transsion.ad.monopoly.intercept;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler", f = "CountryInWhitelistHandler.kt", l = {52}, m = "isCountryInWhitelist")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class CountryInWhitelistHandler$isCountryInWhitelist$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CountryInWhitelistHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountryInWhitelistHandler$isCountryInWhitelist$1(CountryInWhitelistHandler countryInWhitelistHandler, Continuation<? super CountryInWhitelistHandler$isCountryInWhitelist$1> continuation) {
        super(continuation);
        this.this$0 = countryInWhitelistHandler;
    }

    public final Object invokeSuspend(Object obj) {
        Object h;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        h = this.this$0.h(null, null, this);
        return h;
    }
}
