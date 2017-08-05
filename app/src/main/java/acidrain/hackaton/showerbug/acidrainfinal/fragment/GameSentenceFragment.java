package acidrain.hackaton.showerbug.acidrainfinal.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.microsoft.bing.speech.SpeechClientStatus;
import com.microsoft.cognitiveservices.speechrecognition.ISpeechRecognitionServerEvents;
import com.microsoft.cognitiveservices.speechrecognition.MicrophoneRecognitionClient;
import com.microsoft.cognitiveservices.speechrecognition.RecognitionResult;
import com.microsoft.cognitiveservices.speechrecognition.SpeechRecognitionMode;
import com.microsoft.cognitiveservices.speechrecognition.SpeechRecognitionServiceFactory;

import acidrain.hackaton.showerbug.acidrainfinal.R;


/**
 * Created by kdaey on 2017-08-05.
 */

public class GameSentenceFragment extends Fragment {
    MicrophoneRecognitionClient micClient = null;
    TextView mFeedbackText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_sentence_content, container, false);
        mFeedbackText = (TextView) view.findViewById(R.id.game_feedback);

        ImageView micOn = (ImageView) view.findViewById(R.id.game_mic_on);
        micOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subscriptionKey = "69971df45fcf4deab367f459badab817";
                micClient = SpeechRecognitionServiceFactory.createMicrophoneClient(
                        getActivity(),
                        SpeechRecognitionMode.ShortPhrase,
                        "en-us",
                        mCallback,
                        subscriptionKey);
                micClient.setAuthenticationUri("");
                micClient.startMicAndRecognition();
            }
        });

        return view;
    }

    ISpeechRecognitionServerEvents mCallback = new ISpeechRecognitionServerEvents() {
        public void onPartialResponseReceived(final String response) {
            mFeedbackText.setText(mFeedbackText.getText() + "\n" + response);
        }

        public void onError(final int errorCode, final String response) {
            mFeedbackText.setText(mFeedbackText.getText() + "\n" + "Error code: " + SpeechClientStatus.fromInt(errorCode) + " " + errorCode);
        }

        @Override
        public void onFinalResponseReceived(RecognitionResult recognitionResult) {

        }

        @Override
        public void onIntentReceived(String s) {
            //nothing
        }

        @Override
        public void onAudioEvent(boolean b) {
            //nothing
        }
    };
}
