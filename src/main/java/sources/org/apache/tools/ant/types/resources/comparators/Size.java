package org.apache.tools.ant.types.resources.comparators;

import org.apache.tools.ant.types.t;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class Size extends ResourceComparator {
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    protected int resourceCompare(t tVar, t tVar2) {
        return (int) (tVar.i() - tVar2.i());
    }
}
