package shwerbugs.com.acidrain.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import shwerbugs.com.acidrain.GameActivity;
import shwerbugs.com.acidrain.R;
import shwerbugs.com.acidrain.utils.AppConstants;

/**
 * Created by kdaey on 2017-08-05.
 */

public class GameChooserFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_game_chooser, container, false);


        Button gameWord = (Button) view.findViewById(R.id.game_chooser_word);
        gameWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GameActivity.class);
                intent.putExtra(AppConstants.GAME_TYPE, AppConstants.GAME_WORD);
                startActivity(intent);
            }
        });

        Button gameSentence = (Button) view.findViewById(R.id.game_chooser_sentence);
        gameSentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GameActivity.class);
                intent.putExtra(AppConstants.GAME_TYPE, AppConstants.GAME_SENTENCE);
                startActivity(intent);
            }
        });


        Button gameAcidRain = (Button) view.findViewById(R.id.game_chooser_acid_rain);
        gameAcidRain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GameActivity.class);
                intent.putExtra(AppConstants.GAME_TYPE, AppConstants.GAME_ACIDRAIN);
                startActivity(intent);
            }
        });
        return view;
    }
}
