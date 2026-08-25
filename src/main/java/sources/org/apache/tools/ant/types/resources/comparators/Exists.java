package org.apache.tools.ant.types.resources.comparators;

import org.apache.tools.ant.types.t;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class Exists extends ResourceComparator {
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    protected int resourceCompare(t tVar, t tVar2) {
        boolean k = tVar.k();
        if (k == tVar2.k()) {
            return 0;
        }
        return k ? 1 : -1;
    }
}
