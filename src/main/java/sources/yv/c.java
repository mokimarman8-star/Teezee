package yv;

import android.graphics.drawable.Drawable;
import com.blankj.utilcode.util.Utils;
import com.transsion.videodetail.R$drawable;
import com.transsion.videodetail.music.bean.MusicLoopEnum;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    public static final c a = new c();
    private static MusicLoopEnum b = MusicLoopEnum.NORMAL;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MusicLoopEnum.values().length];
            try {
                iArr[MusicLoopEnum.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MusicLoopEnum.LIST_LOOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MusicLoopEnum.SINGLE_LOOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    private c() {
    }

    public final Drawable a(MusicLoopEnum loop) {
        Intrinsics.h(loop, "loop");
        int i = a.a[loop.ordinal()];
        if (i == 1) {
            return androidx.core.content.b.getDrawable(Utils.a(), R$drawable.music_iv_loop_normal);
        }
        if (i == 2) {
            return androidx.core.content.b.getDrawable(Utils.a(), R$drawable.music_iv_loop_list);
        }
        if (i == 3) {
            return androidx.core.content.b.getDrawable(Utils.a(), R$drawable.music_iv_loop_single);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final MusicLoopEnum b() {
        return b;
    }

    public final MusicLoopEnum c() {
        MusicLoopEnum musicLoopEnum;
        int i = a.a[b.ordinal()];
        if (i == 1) {
            musicLoopEnum = MusicLoopEnum.LIST_LOOP;
        } else if (i == 2) {
            musicLoopEnum = MusicLoopEnum.SINGLE_LOOP;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            musicLoopEnum = MusicLoopEnum.NORMAL;
        }
        b = musicLoopEnum;
        return musicLoopEnum;
    }
}
