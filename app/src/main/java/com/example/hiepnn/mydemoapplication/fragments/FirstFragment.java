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
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hiepnn.mydemoapplication.R;
import com.example.hiepnn.mydemoapplication.activities.MainActivity;

public class FirstFragment extends Fragment {
    private ImageView imgBackground;
    private Toolbar toolbar;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_first, container, false);
        imgBackground = (ImageView) root.findViewById(R.id.imgBackground);
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
        setHasOptionsMenu(true);
        return root;

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
