package acidrain.hackaton.showerbug.acidrainfinal.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import acidrain.hackaton.showerbug.acidrainfinal.R;
import acidrain.hackaton.showerbug.acidrainfinal.client.SingletonRequestQueue;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SignUpFragment extends Fragment {
    @BindView(R.id.login_id)
    EditText login_id;
    @BindView(R.id.login_pw)
    EditText login_pw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_signup, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick (R.id.sign_up_confirm)
    void signUp() {
        String url ="http://acidrain.azurewebsites.net/users/";
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", login_id.getText().toString());
        params.put("password", login_pw.getText().toString());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url,new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(SignUpFragment.class.getSimpleName(), response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(SignUpFragment.class.getSimpleName(), error.toString());
                    }
                });
        SingletonRequestQueue.getInstance(getActivity()).addToRequestQueue(request);
    }
}
