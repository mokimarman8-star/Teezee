package com.cloud.tmc.miniapp.action;

import android.view.View;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface ClickAction extends View.OnClickListener {

    public static final class DefaultImpls {
        public static void onClick(ClickAction clickAction, View view) {
            Intrinsics.h(view, "view");
        }

        public static void setOnClickListener(ClickAction clickAction, View.OnClickListener onClickListener, int... iArr) {
            Intrinsics.h(iArr, "ids");
            for (int i : iArr) {
                View findViewById = clickAction.findViewById(i);
                if (findViewById != null) {
                    findViewById.setOnClickListener(onClickListener);
                }
            }
        }

        public static void setOnClickListener(ClickAction clickAction, View.OnClickListener onClickListener, View... viewArr) {
            Intrinsics.h(viewArr, "views");
            for (View view : viewArr) {
                if (view != null) {
                    view.setOnClickListener(onClickListener);
                }
            }
        }

        public static void setOnClickListener(ClickAction clickAction, int... iArr) {
            Intrinsics.h(iArr, "ids");
            clickAction.setOnClickListener(clickAction, Arrays.copyOf(iArr, iArr.length));
        }

        public static void setOnClickListener(ClickAction clickAction, View... viewArr) {
            Intrinsics.h(viewArr, "views");
            clickAction.setOnClickListener(clickAction, (View[]) Arrays.copyOf(viewArr, viewArr.length));
        }
    }

    <V extends View> V findViewById(int i);

    @Override // android.view.View.OnClickListener
    void onClick(View view);

    void setOnClickListener(View.OnClickListener onClickListener, int... iArr);

    void setOnClickListener(View.OnClickListener onClickListener, View... viewArr);

    void setOnClickListener(int... iArr);

    void setOnClickListener(View... viewArr);
}
