package shwerbugs.com.acidrain.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shwerbugs.com.acidrain.R;

/**
 * Created by kdaey on 2017-08-05.
 */

public class GameSentenceFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_sentence_content, container, false);
        return view;
    }
}
