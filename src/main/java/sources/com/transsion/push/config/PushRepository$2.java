package com.transsion.push.config;

import com.transsion.push.ITopicListener;
import com.transsion.push.PushConstants;
import java.util.HashSet;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class PushRepository$2 implements Runnable {
    final /* synthetic */ PushRepository this$0;
    final /* synthetic */ ITopicListener val$listener;
    final /* synthetic */ String val$topic;

    class a implements ITopicListener {
        a() {
        }

        @Override // com.transsion.push.ITopicListener
        public void onFail(String str) {
            ITopicListener iTopicListener = PushRepository$2.this.val$listener;
            if (iTopicListener != null) {
                iTopicListener.onFail(str);
            }
        }

        @Override // com.transsion.push.ITopicListener
        public void onSuccess() {
            HashSet hashSet = (HashSet) PushRepository$2.this.this$0.getSpValue(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, new HashSet());
            if (PushRepository$2.this.val$topic.equals(PushConstants.SP_KEY_APP_TOPIC_UNSUBSCRIBE_ALL)) {
                hashSet.clear();
            } else if (PushRepository$2.this.val$topic.contains(",")) {
                for (String str : PushRepository$2.this.val$topic.split(",")) {
                    hashSet.remove(str);
                }
            } else {
                hashSet.remove(PushRepository$2.this.val$topic);
            }
            PushRepository$2.this.this$0.putSpValue(PushConstants.SP_KEY_SUBSCRIBE_TOPICS, hashSet);
            ITopicListener iTopicListener = PushRepository$2.this.val$listener;
            if (iTopicListener != null) {
                iTopicListener.onSuccess();
            }
        }
    }

    PushRepository$2(PushRepository pushRepository, String str, ITopicListener iTopicListener) {
        this.this$0 = pushRepository;
        this.val$topic = str;
        this.val$listener = iTopicListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushRepository.a(this.this$0).g(this.val$topic, PushConstants.TOPIC_UNSUBSCRIBE, new a());
    }
}
