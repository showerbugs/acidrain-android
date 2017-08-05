package acidrain.hackaton.showerbug.acidrainfinal;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.microsoft.cognitiveservices.speechrecognition.DataRecognitionClient;
import com.microsoft.cognitiveservices.speechrecognition.ISpeechRecognitionServerEvents;
import com.microsoft.cognitiveservices.speechrecognition.MicrophoneRecognitionClient;
import com.microsoft.cognitiveservices.speechrecognition.RecognitionResult;
import com.microsoft.cognitiveservices.speechrecognition.SpeechRecognitionMode;
import com.microsoft.cognitiveservices.speechrecognition.SpeechRecognitionServiceFactory;

import acidrain.hackaton.showerbug.acidrainfinal.fragment.MainFragment;

public class MainActivity extends Activity implements ISpeechRecognitionServerEvents {
    private Activity activity;
    DataRecognitionClient dataClient = null;
    MicrophoneRecognitionClient micClient = null;
    int m_waitSeconds;
    int getWaitSecond(){
        return 20;
//        return 200;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        TextView v = (TextView)findViewById(R.id.ddd);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subscriptionKey = "69971df45fcf4deab367f459badab817";
                micClient = SpeechRecognitionServiceFactory.createMicrophoneClient(
                        activity,
                        SpeechRecognitionMode.ShortPhrase,
                        "en-us",
                        mCallback,
                        subscriptionKey);
                micClient.setAuthenticationUri("");
                micClient.startMicAndRecognition();
            }
        });


        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            MainFragment firstFragment = new MainFragment();
            getFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }
    }
    ISpeechRecognitionServerEvents mCallback = new ISpeechRecognitionServerEvents() {
        @Override
        public void onPartialResponseReceived(String s) {

        }

        @Override
        public void onFinalResponseReceived(RecognitionResult recognitionResult) {

        }

        @Override
        public void onIntentReceived(String s) {

        }

        @Override
        public void onError(int i, String s) {

        }

        @Override
        public void onAudioEvent(boolean b) {

        }
    };
    @Override
    public void onPartialResponseReceived(String s) {

    }

    @Override
    public void onFinalResponseReceived(RecognitionResult recognitionResult) {

    }

    @Override
    public void onIntentReceived(String s) {

    }

    @Override
    public void onError(int i, String s) {

    }

    @Override
    public void onAudioEvent(boolean b) {

    }
}
