package org.apache.tools.ant.types.resources.comparators;

import org.apache.tools.ant.types.t;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class Type extends ResourceComparator {
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    protected int resourceCompare(t tVar, t tVar2) {
        boolean j = tVar.j();
        if (j == tVar2.j()) {
            return 0;
        }
        return j ? 1 : -1;
    }
}
