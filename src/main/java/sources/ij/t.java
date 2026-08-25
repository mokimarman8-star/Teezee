package ij;

import com.transsion.baselib.utils.PlayMode;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.push.bean.MsgStyle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class t {
    public static final t a = new t();

    private t() {
    }

    private final PlayMode a() {
        String string = com.transsion.baselib.report.launch.b.a.b().getString("change_play_mode_by_debug", BuildConfig.FLAVOR);
        for (PlayMode playMode : PlayMode.values()) {
            if (Intrinsics.c(playMode.getValue(), string)) {
                return playMode;
            }
        }
        PlayMode playMode2 = PlayMode.DOWNLOAD;
        ConfigBean c = cm.f.c.a().c("play_mode", true);
        if (c == null) {
            return playMode2;
        }
        String value = c.getValue();
        return (!Intrinsics.c(value, MsgStyle.CUSTOM_LEFT_PIC) && Intrinsics.c(value, "2")) ? PlayMode.STREAM : playMode2;
    }

    public final boolean b() {
        return a() == PlayMode.STREAM;
    }

    public final void c(PlayMode playMode) {
        Intrinsics.h(playMode, "playMode");
        com.transsion.baselib.report.launch.b.a.b().putString("change_play_mode_by_debug", playMode.getValue());
    }
}
