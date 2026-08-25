package com.transsion.search_pugc.speech;

import android.speech.SpeechRecognizer;
import com.blankj.utilcode.util.Utils;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    public static final g a = new g();

    private g() {
    }

    public final boolean a() {
        return SpeechRecognizer.isRecognitionAvailable(Utils.a());
    }
}
