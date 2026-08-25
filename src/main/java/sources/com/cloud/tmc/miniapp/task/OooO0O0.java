package com.cloud.tmc.miniapp.task;

import java.util.LinkedList;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0O0 {
    public final LinkedList<OooO00o> OooO00o = new LinkedList<>();

    public final void OooO00o() {
        while (!this.OooO00o.isEmpty()) {
            OooO00o poll = this.OooO00o.poll();
            if (poll != null) {
                poll.OooO0O0.run();
            }
        }
    }

    public final void OooO00o(OooO00o oooO00o) {
        Intrinsics.h(oooO00o, "task");
        ListIterator<OooO00o> listIterator = this.OooO00o.listIterator();
        Intrinsics.g(listIterator, "queue.listIterator()");
        while (listIterator.hasNext()) {
            if (listIterator.next().OooO00o == oooO00o.OooO00o) {
                listIterator.set(oooO00o);
                return;
            }
        }
        this.OooO00o.add(oooO00o);
    }
}
