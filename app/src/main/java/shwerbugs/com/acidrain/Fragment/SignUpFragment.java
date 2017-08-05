package shwerbugs.com.acidrain.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import shwerbugs.com.acidrain.R;
import shwerbugs.com.acidrain.client.SingletonRequestQueue;


public class SignUpFragment extends Fragment {
    @BindView(R.id.login_id)
    EditText login_id;
    @BindView(R.id.login_pw)
    EditText login_pw;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
        SingletonRequestQueue.getInstance(getContext()).addToRequestQueue(request);
    }
}
