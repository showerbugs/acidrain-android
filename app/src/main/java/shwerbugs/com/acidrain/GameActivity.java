package shwerbugs.com.acidrain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import shwerbugs.com.acidrain.fragment.GameSentenceFragment;
import shwerbugs.com.acidrain.fragment.GameWordFragment;
import shwerbugs.com.acidrain.utils.AppConstants;

/**
 * Created by kdaey on 2017-08-05.
 */

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
