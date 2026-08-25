package com.amazonaws.services.s3.model;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Grant {
    private Grantee a;
    private Permission b;

    public Grant(Grantee grantee, Permission permission) {
        this.a = grantee;
        this.b = permission;
    }

    public Grantee a() {
        return this.a;
    }

    public Permission b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Grant grant = (Grant) obj;
        Grantee grantee = this.a;
        if (grantee == null) {
            if (grant.a != null) {
                return false;
            }
        } else if (!grantee.equals(grant.a)) {
            return false;
        }
        return this.b == grant.b;
    }

    public int hashCode() {
        Grantee grantee = this.a;
        int hashCode = ((grantee == null ? 0 : grantee.hashCode()) + 31) * 31;
        Permission permission = this.b;
        return hashCode + (permission != null ? permission.hashCode() : 0);
    }

    public String toString() {
        return "Grant [grantee=" + this.a + ", permission=" + this.b + "]";
    }
}
