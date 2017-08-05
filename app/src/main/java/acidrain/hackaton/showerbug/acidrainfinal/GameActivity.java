package acidrain.hackaton.showerbug.acidrainfinal;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import acidrain.hackaton.showerbug.acidrainfinal.fragment.GameSentenceFragment;
import acidrain.hackaton.showerbug.acidrainfinal.fragment.GameWordFragment;
import acidrain.hackaton.showerbug.acidrainfinal.utils.AppConstants;

/**
 * Created by kdaey on 2017-08-05.
 */

public class GameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        Bundle bundle = getIntent().getExtras();
        int type = bundle.getInt(AppConstants.GAME_TYPE);
        Fragment fragment = null;
        switch (type) {
            case AppConstants.GAME_WORD:
                fragment = new GameWordFragment();
                break;
            case AppConstants.GAME_SENTENCE:
                fragment = new GameSentenceFragment();
                break;
            case AppConstants.GAME_ACIDRAIN:
                fragment = new GameWordFragment();
                break;
            default:
                break;
        }
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
