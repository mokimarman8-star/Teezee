package org.jsoup.select;

import org.jsoup.nodes.j;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface NodeFilter {

    public enum FilterResult {
        CONTINUE,
        SKIP_CHILDREN,
        SKIP_ENTIRELY,
        REMOVE,
        STOP
    }

    FilterResult a(j jVar, int i);

    FilterResult b(j jVar, int i);
}
