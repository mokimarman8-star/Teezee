package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    CharSequence f6970a;

    /* renamed from: b, reason: collision with root package name */
    IconCompat f6971b;

    /* renamed from: c, reason: collision with root package name */
    String f6972c;

    /* renamed from: d, reason: collision with root package name */
    String f6973d;

    /* renamed from: e, reason: collision with root package name */
    boolean f6974e;

    /* renamed from: f, reason: collision with root package name */
    boolean f6975f;

    static class a {
        static w a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.b(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        static Person b(w wVar) {
            return new Person.Builder().setName(wVar.d()).setIcon(wVar.b() != null ? wVar.b().w() : null).setUri(wVar.e()).setKey(wVar.c()).setBot(wVar.f()).setImportant(wVar.g()).build();
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        CharSequence f6976a;

        /* renamed from: b, reason: collision with root package name */
        IconCompat f6977b;

        /* renamed from: c, reason: collision with root package name */
        String f6978c;

        /* renamed from: d, reason: collision with root package name */
        String f6979d;

        /* renamed from: e, reason: collision with root package name */
        boolean f6980e;

        /* renamed from: f, reason: collision with root package name */
        boolean f6981f;

        public w a() {
            return new w(this);
        }

        public b b(boolean z5) {
            this.f6980e = z5;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f6977b = iconCompat;
            return this;
        }

        public b d(boolean z5) {
            this.f6981f = z5;
            return this;
        }

        public b e(String str) {
            this.f6979d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f6976a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f6978c = str;
            return this;
        }
    }

    w(b bVar) {
        this.f6970a = bVar.f6976a;
        this.f6971b = bVar.f6977b;
        this.f6972c = bVar.f6978c;
        this.f6973d = bVar.f6979d;
        this.f6974e = bVar.f6980e;
        this.f6975f = bVar.f6981f;
    }

    public static w a(Person person) {
        return a.a(person);
    }

    public IconCompat b() {
        return this.f6971b;
    }

    public String c() {
        return this.f6973d;
    }

    public CharSequence d() {
        return this.f6970a;
    }

    public String e() {
        return this.f6972c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        String c5 = c();
        String c6 = wVar.c();
        return (c5 == null && c6 == null) ? Objects.equals(Objects.toString(d()), Objects.toString(wVar.d())) && Objects.equals(e(), wVar.e()) && Boolean.valueOf(f()).equals(Boolean.valueOf(wVar.f())) && Boolean.valueOf(g()).equals(Boolean.valueOf(wVar.g())) : Objects.equals(c5, c6);
    }

    public boolean f() {
        return this.f6974e;
    }

    public boolean g() {
        return this.f6975f;
    }

    public String h() {
        String str = this.f6972c;
        if (str != null) {
            return str;
        }
        if (this.f6970a == null) {
            return "";
        }
        return "name:" + ((Object) this.f6970a);
    }

    public int hashCode() {
        String c5 = c();
        return c5 != null ? c5.hashCode() : Objects.hash(d(), e(), Boolean.valueOf(f()), Boolean.valueOf(g()));
    }

    public Person i() {
        return a.b(this);
    }

    public Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f6970a);
        IconCompat iconCompat = this.f6971b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.v() : null);
        bundle.putString("uri", this.f6972c);
        bundle.putString("key", this.f6973d);
        bundle.putBoolean("isBot", this.f6974e);
        bundle.putBoolean("isImportant", this.f6975f);
        return bundle;
    }
}
