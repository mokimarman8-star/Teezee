package com.blankj.utilcode.util;

import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class LanguageUtils$2 implements Runnable {
    final /* synthetic */ Utils$b val$consumer;
    final /* synthetic */ Locale val$destLocale;
    final /* synthetic */ int val$index;

    LanguageUtils$2(Locale locale, int i, Utils$b utils$b) {
        this.val$destLocale = locale;
        this.val$index = i;
        this.val$consumer = utils$b;
    }

    @Override // java.lang.Runnable
    public void run() {
        LanguageUtils.e(this.val$destLocale, this.val$index + 1, this.val$consumer);
    }
}
