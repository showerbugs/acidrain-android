package acidrain.hackaton.showerbug.acidrainfinal.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import acidrain.hackaton.showerbug.acidrainfinal.R;


/**
 * Created by kdaey on 2017-08-05.
 */

public class GameSentenceFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_sentence_content, container, false);
        return view;
    }
}
