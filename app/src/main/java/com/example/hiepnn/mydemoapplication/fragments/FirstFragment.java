package com.example.hiepnn.mydemoapplication.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiepnn.mydemoapplication.R;
import com.example.hiepnn.mydemoapplication.activities.MainActivity;
import com.example.hiepnn.mydemoapplication.utils.DebugLog;
import com.example.hiepnn.mydemoapplication.utils.LayoutUtils;
import com.example.hiepnn.mydemoapplication.view.FlowLayout;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FirstFragment extends Fragment {
    private Toolbar toolbar;
    int myID[] = {1, 2, 3};
    String myName[] = {"Hiep", "Nam", "Long"};
    String myCurriculum[] = {"Toan", "Van", "Vat ly"};
    String myBirthday[] = {"12-08-1991", "20-10-1992", "15-6-1993"};
    int NumOfStudent = 3;
    String myYear[] = {"2014", "2015", "2016"};
    String str_json = "";
    TextView tvHello;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_first, container, false);
        final MainActivity act = (MainActivity) getActivity();
        if (act.getSupportActionBar() != null) {
            toolbar = (Toolbar) act.findViewById(R.id.toolbar);
            toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_menu));
            toolbar.setTitle("First Fragment");
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Menu", Toast.LENGTH_SHORT).show();
                }
            });
        }
        tvHello = (TextView) root.findViewById(R.id.tv_hello);
        Gson gson = new Gson();
        try {
            str_json = gson.toJson(makJsonObject(myID, myName, myYear, myCurriculum, myBirthday, NumOfStudent));
            DebugLog.ee("json", str_json);
            tvHello.setText(str_json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setHasOptionsMenu(true);
        return root;

    }


    public JSONObject makJsonObject(int id[], String name[], String year[],
                                    String curriculum[], String birthday[], int numberof_students)
            throws JSONException {
        JSONObject obj = null;
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < numberof_students; i++) {
            obj = new JSONObject();
            try {
                obj.put("id", id[i]);
                obj.put("name", name[i]);
                obj.put("year", year[i]);
                obj.put("curriculum", curriculum[i]);
                obj.put("birthday", birthday[i]);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArray.put(obj);
        }

        JSONObject finalobject = new JSONObject();
        finalobject.put("student", jsonArray);
        return finalobject;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {
            Toast.makeText(getActivity(), "Search", Toast.LENGTH_SHORT);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
