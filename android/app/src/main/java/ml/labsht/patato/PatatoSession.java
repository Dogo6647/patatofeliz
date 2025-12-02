package ml.labsht.patato;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.service.voice.VoiceInteractionSessionService;
import android.util.Log;

public class PatatoSession extends VoiceInteractionSessionService {
    @SuppressLint("NewApi")
    @Override
    public VoiceInteractionSession onNewSession(Bundle args) {
        return new VoiceInteractionSession(this) {
            @Override
            public void onShow(Bundle args, int showFlags) {
                super.onShow(args, showFlags);
                hide();

                // Now it's safe — the user triggered the assistant gesture!
                Log.d("PATATOFELIZ", "VoiceInteractionSession onShow called");
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);
            }
        };
    }
}
