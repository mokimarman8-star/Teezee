package kotlinx.coroutines.internal;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class t {
    public final LockFreeLinkedListNode a;

    public t(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.a = lockFreeLinkedListNode;
    }

    public String toString() {
        return "Removed[" + this.a + ']';
    }
}
