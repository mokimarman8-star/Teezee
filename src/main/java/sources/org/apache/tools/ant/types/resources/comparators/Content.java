package org.apache.tools.ant.types.resources.comparators;

import java.io.IOException;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.types.t;
import org.apache.tools.ant.util.o;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class Content extends ResourceComparator {
    private boolean binary = true;

    public boolean isBinary() {
        return this.binary;
    }

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    protected int resourceCompare(t tVar, t tVar2) {
        try {
            return o.b(tVar, tVar2, !this.binary);
        } catch (IOException e) {
            throw new BuildException(e);
        }
    }

    public void setBinary(boolean z) {
        this.binary = z;
    }
}
