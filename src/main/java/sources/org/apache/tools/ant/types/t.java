package org.apache.tools.ant.types;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class t extends e implements Cloneable, Comparable, u {
    protected static final int f = h("Resource".getBytes());
    private static final int g = h("null name".getBytes());
    private String a;
    private Boolean b;
    private Long c;
    private Boolean d;
    private Long e;

    public t() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public t(String str) {
        this(str, false, 0L, false);
    }

    public t(String str, boolean z, long j, boolean z2) {
        this(str, z, j, z2, -1L);
    }

    public t(String str, boolean z, long j, boolean z2, long j2) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = str;
        o(str);
        m(z);
        n(j);
        l(z2);
        p(j2);
    }

    protected static int h(byte[] bArr) {
        return new BigInteger(bArr).intValue();
    }

    public boolean a() {
        return isReference() && ((t) getCheckedRef()).a();
    }

    @Override // org.apache.tools.ant.types.e, org.apache.tools.ant.q
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new UnsupportedOperationException("CloneNotSupportedException for a Resource caught. Derived classes must support cloning.");
        }
    }

    public int compareTo(Object obj) {
        if (isReference()) {
            return ((Comparable) getCheckedRef()).compareTo(obj);
        }
        if (obj instanceof t) {
            return toString().compareTo(obj.toString());
        }
        throw new IllegalArgumentException("Can only be compared with Resources");
    }

    public InputStream e() {
        if (isReference()) {
            return ((t) getCheckedRef()).e();
        }
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        return isReference() ? getCheckedRef().equals(obj) : obj.getClass().equals(getClass()) && compareTo(obj) == 0;
    }

    public long g() {
        Long l;
        if (isReference()) {
            return ((t) getCheckedRef()).g();
        }
        if (!k() || (l = this.c) == null) {
            return 0L;
        }
        long longValue = l.longValue();
        if (longValue < 0) {
            return 0L;
        }
        return longValue;
    }

    public String getName() {
        return isReference() ? ((t) getCheckedRef()).getName() : this.a;
    }

    public int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        String name = getName();
        return f * (name == null ? g : name.hashCode());
    }

    public long i() {
        if (isReference()) {
            return ((t) getCheckedRef()).i();
        }
        if (!k()) {
            return 0L;
        }
        Long l = this.e;
        if (l != null) {
            return l.longValue();
        }
        return -1L;
    }

    @Override // org.apache.tools.ant.types.u
    public Iterator iterator() {
        return isReference() ? ((t) getCheckedRef()).iterator() : new s(this);
    }

    public boolean j() {
        if (isReference()) {
            return ((t) getCheckedRef()).j();
        }
        Boolean bool = this.d;
        return bool != null && bool.booleanValue();
    }

    public boolean k() {
        if (isReference()) {
            return ((t) getCheckedRef()).k();
        }
        Boolean bool = this.b;
        return bool == null || bool.booleanValue();
    }

    public void l(boolean z) {
        checkAttributesAllowed();
        this.d = z ? Boolean.TRUE : Boolean.FALSE;
    }

    public void m(boolean z) {
        checkAttributesAllowed();
        this.b = z ? Boolean.TRUE : Boolean.FALSE;
    }

    public void n(long j) {
        checkAttributesAllowed();
        this.c = new Long(j);
    }

    public void o(String str) {
        checkAttributesAllowed();
        this.a = str;
    }

    public void p(long j) {
        checkAttributesAllowed();
        if (j <= -1) {
            j = -1;
        }
        this.e = new Long(j);
    }

    @Override // org.apache.tools.ant.types.e
    public void setRefid(r rVar) {
        if (this.a != null || this.b != null || this.c != null || this.d != null || this.e != null) {
            throw tooManyAttributes();
        }
        super.setRefid(rVar);
    }

    @Override // org.apache.tools.ant.types.u
    public int size() {
        if (isReference()) {
            return ((t) getCheckedRef()).size();
        }
        return 1;
    }

    @Override // org.apache.tools.ant.types.e
    public String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        String name = getName();
        return name == null ? "(anonymous)" : name;
    }
}
