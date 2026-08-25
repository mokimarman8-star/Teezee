package org.apache.tools.ant.types;

import java.net.SocketPermission;
import java.security.Permission;
import java.security.Permissions;
import java.security.UnresolvedPermission;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PropertyPermission;
import java.util.Set;
import java.util.StringTokenizer;
import okhttp3.HttpUrl;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ExitException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class o {
    private static final Class[] g;
    static /* synthetic */ Class h;
    private List a;
    private List b;
    private Permissions c;
    private SecurityManager d;
    private boolean e;
    private boolean f;

    private class a extends SecurityManager {
        private a() {
        }

        private void a(Permission permission) {
            ListIterator listIterator = o.this.b.listIterator();
            while (listIterator.hasNext()) {
                if (((b) listIterator.next()).d(permission)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Permission ");
                    stringBuffer.append(permission);
                    stringBuffer.append(" was revoked.");
                    throw new SecurityException(stringBuffer.toString());
                }
            }
        }

        @Override // java.lang.SecurityManager
        public void checkExit(int i) {
            try {
                checkPermission(new RuntimePermission("exitVM", null));
            } catch (SecurityException e) {
                throw new ExitException(e.getMessage(), i);
            }
        }

        @Override // java.lang.SecurityManager
        public void checkPermission(Permission permission) {
            if (o.this.e) {
                if (o.this.f && !permission.getName().equals("exitVM")) {
                    boolean implies = o.this.c.implies(permission);
                    a(permission);
                    if (implies || o.this.d == null) {
                        return;
                    }
                    o.this.d.checkPermission(permission);
                    return;
                }
                if (o.this.c.implies(permission)) {
                    a(permission);
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Permission ");
                stringBuffer.append(permission);
                stringBuffer.append(" was not granted.");
                throw new SecurityException(stringBuffer.toString());
            }
        }
    }

    public static class b {
        private String a;
        private String b;
        private String c;
        private Set d;

        private Set e(String str) {
            HashSet hashSet = new HashSet();
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String trim = stringTokenizer.nextToken().trim();
                if (!trim.equals(HttpUrl.FRAGMENT_ENCODE_SET)) {
                    hashSet.add(trim);
                }
            }
            return hashSet;
        }

        public String a() {
            return this.c;
        }

        public String b() {
            return this.a;
        }

        public String c() {
            return this.b;
        }

        boolean d(Permission permission) {
            if (!this.a.equals(permission.getClass().getName())) {
                return false;
            }
            String str = this.b;
            if (str != null) {
                if (str.endsWith("*")) {
                    String name = permission.getName();
                    String str2 = this.b;
                    if (!name.startsWith(str2.substring(0, str2.length() - 1))) {
                        return false;
                    }
                } else if (!this.b.equals(permission.getName())) {
                    return false;
                }
            }
            if (this.d != null) {
                Set e = e(permission.getActions());
                int size = e.size();
                e.removeAll(this.d);
                if (e.size() == size) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Permission: ");
            stringBuffer.append(this.a);
            stringBuffer.append(" (\"");
            stringBuffer.append(this.b);
            stringBuffer.append("\", \"");
            stringBuffer.append(this.d);
            stringBuffer.append("\")");
            return stringBuffer.toString();
        }
    }

    static {
        Class cls = h;
        if (cls == null) {
            cls = f("java.lang.String");
            h = cls;
        }
        Class cls2 = h;
        if (cls2 == null) {
            cls2 = f("java.lang.String");
            h = cls2;
        }
        g = new Class[]{cls, cls2};
    }

    public o() {
        this(false);
    }

    public o(boolean z) {
        this.a = new LinkedList();
        this.b = new LinkedList();
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = z;
    }

    static /* synthetic */ Class f(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private Permission g(b bVar) {
        try {
            return (Permission) Class.forName(bVar.b()).getConstructor(g).newInstance(bVar.c(), bVar.a());
        } catch (Exception unused) {
            return new UnresolvedPermission(bVar.b(), bVar.c(), bVar.a(), null);
        }
    }

    private void h() {
        this.c = new Permissions();
        ListIterator listIterator = this.b.listIterator();
        while (listIterator.hasNext()) {
            b bVar = (b) listIterator.next();
            if (bVar.b() == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Revoked permission ");
                stringBuffer.append(bVar);
                stringBuffer.append(" does not contain a class.");
                throw new BuildException(stringBuffer.toString());
            }
        }
        ListIterator listIterator2 = this.a.listIterator();
        while (listIterator2.hasNext()) {
            b bVar2 = (b) listIterator2.next();
            if (bVar2.b() == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Granted permission ");
                stringBuffer2.append(bVar2);
                stringBuffer2.append(" does not contain a class.");
                throw new BuildException(stringBuffer2.toString());
            }
            this.c.add(g(bVar2));
        }
        this.c.add(new SocketPermission("localhost:1024-", "listen"));
        this.c.add(new PropertyPermission("java.version", "read"));
        this.c.add(new PropertyPermission("java.vendor", "read"));
        this.c.add(new PropertyPermission("java.vendor.url", "read"));
        this.c.add(new PropertyPermission("java.class.version", "read"));
        this.c.add(new PropertyPermission("os.name", "read"));
        this.c.add(new PropertyPermission("os.version", "read"));
        this.c.add(new PropertyPermission("os.arch", "read"));
        this.c.add(new PropertyPermission("file.encoding", "read"));
        this.c.add(new PropertyPermission("file.separator", "read"));
        this.c.add(new PropertyPermission("path.separator", "read"));
        this.c.add(new PropertyPermission("line.separator", "read"));
        this.c.add(new PropertyPermission("java.specification.version", "read"));
        this.c.add(new PropertyPermission("java.specification.vendor", "read"));
        this.c.add(new PropertyPermission("java.specification.name", "read"));
        this.c.add(new PropertyPermission("java.vm.specification.version", "read"));
        this.c.add(new PropertyPermission("java.vm.specification.vendor", "read"));
        this.c.add(new PropertyPermission("java.vm.specification.name", "read"));
        this.c.add(new PropertyPermission("java.vm.version", "read"));
        this.c.add(new PropertyPermission("java.vm.vendor", "read"));
        this.c.add(new PropertyPermission("java.vm.name", "read"));
    }

    public synchronized void i() {
        this.e = false;
        System.setSecurityManager(this.d);
    }

    public synchronized void j() {
        this.d = System.getSecurityManager();
        h();
        System.setSecurityManager(new a());
        this.e = true;
    }
}
