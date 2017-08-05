package shwerbugs.com.acidrain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

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
        int fragmentId = R.layout.game_word_content;
        switch (type) {
            case AppConstants.GAME_WORD :
                fragmentId = R.layout.game_word_content;
                break;
            case AppConstants.GAME_SENTENCE :
                fragmentId = R.layout.game_word_content;
                break;
            case AppConstants.GAME_ACIDRAIN :
                fragmentId = R.layout.game_word_content;
                break;
            default:
                break;
        }
    }
}
