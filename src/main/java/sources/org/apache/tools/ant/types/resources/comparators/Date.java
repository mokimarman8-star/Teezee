package org.apache.tools.ant.types.resources.comparators;

import org.apache.tools.ant.types.t;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class Date extends ResourceComparator {
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    protected int resourceCompare(t tVar, t tVar2) {
        long g = tVar.g() - tVar2.g();
        if (g > 0) {
            return 1;
        }
        return g < 0 ? -1 : 0;
    }
}
