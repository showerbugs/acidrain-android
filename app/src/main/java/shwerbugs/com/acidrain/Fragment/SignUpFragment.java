package shwerbugs.com.acidrain.Fragment;

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

public class SignUpFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_signup, container, false);
    }
}