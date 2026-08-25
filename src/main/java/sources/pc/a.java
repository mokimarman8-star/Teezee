package pc;

import com.google.firebase.messaging.l0;
import com.google.firebase.messaging.reporting.MessagingClientEvent;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a {
    private static final a b = new C0195a().a();
    private final MessagingClientEvent a;

    /* renamed from: pc.a$a, reason: collision with other inner class name */
    public static final class C0195a {
        private MessagingClientEvent a = null;

        C0195a() {
        }

        public a a() {
            return new a(this.a);
        }

        public C0195a b(MessagingClientEvent messagingClientEvent) {
            this.a = messagingClientEvent;
            return this;
        }
    }

    a(MessagingClientEvent messagingClientEvent) {
        this.a = messagingClientEvent;
    }

    public static C0195a b() {
        return new C0195a();
    }

    public MessagingClientEvent a() {
        return this.a;
    }

    public byte[] c() {
        return l0.a(this);
    }
}
