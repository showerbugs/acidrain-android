package acidrain.hackaton.showerbug.acidrainfinal.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import acidrain.hackaton.showerbug.acidrainfinal.GameActivity;
import acidrain.hackaton.showerbug.acidrainfinal.R;
import acidrain.hackaton.showerbug.acidrainfinal.utils.AppConstants;

/**
 * Created by kdaey on 2017-08-05.
 */

public class GameChooserFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
