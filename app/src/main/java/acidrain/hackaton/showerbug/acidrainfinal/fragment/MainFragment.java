package acidrain.hackaton.showerbug.acidrainfinal.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import acidrain.hackaton.showerbug.acidrainfinal.R;
import acidrain.hackaton.showerbug.acidrainfinal.client.SingletonRequestQueue;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainFragment extends Fragment {
    @BindView(R.id.login_id)
    EditText login_id;

    @BindView(R.id.login_pw)
    EditText login_pw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.login_sign_in)
    void signIn(){
        String url = "http://acidrain.azurewebsites.net/sessions/";
        JSONObject params = new JSONObject();
        try {
            params.put("name", login_id.getText().toString());
            params.put("password", login_pw.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                GameChooserFragment newFragment = new GameChooserFragment();
                FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                Toast.makeText(getActivity(), login_id.getText().toString() + " 님 안녕하세요", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(MainFragment.class.getSimpleName(), "onErrorResponse");
                Toast.makeText(getActivity(), "로그인 실패", Toast.LENGTH_SHORT).show();
            }
        });
        SingletonRequestQueue.getInstance(getActivity()).addToRequestQueue(request);

    }

    @OnClick(R.id.login_sign_up)
    void signUp(){
        SignUpFragment newFragment = new SignUpFragment();
        FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
