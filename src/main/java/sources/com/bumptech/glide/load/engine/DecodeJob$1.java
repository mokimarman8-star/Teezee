package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.DecodeJob;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
/* synthetic */ class DecodeJob$1 {
    static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$EncodeStrategy;
    static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason;
    static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage;

    static {
        int[] iArr = new int[EncodeStrategy.values().length];
        $SwitchMap$com$bumptech$glide$load$EncodeStrategy = iArr;
        try {
            iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$com$bumptech$glide$load$EncodeStrategy[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[DecodeJob.Stage.values().length];
        $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = iArr2;
        try {
            iArr2[DecodeJob.Stage.RESOURCE_CACHE.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[DecodeJob.Stage.DATA_CACHE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[DecodeJob.Stage.SOURCE.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[DecodeJob.Stage.FINISHED.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[DecodeJob.Stage.INITIALIZE.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        int[] iArr3 = new int[DecodeJob.RunReason.values().length];
        $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = iArr3;
        try {
            iArr3[DecodeJob.RunReason.INITIALIZE.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[DecodeJob.RunReason.DECODE_DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
