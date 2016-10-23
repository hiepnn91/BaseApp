package com.example.hiepnn.mydemoapplication.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiepnn.mydemoapplication.R;
import com.example.hiepnn.mydemoapplication.activities.MainActivity;

public class SecondFragment extends Fragment {
    private ImageView imgBackground;
    private Toolbar toolbar;

    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_second, container, false);
        imgBackground = (ImageView) root.findViewById(R.id.imgBackground);
        final MainActivity act = (MainActivity) getActivity();
        if (act.getSupportActionBar() != null) {
            toolbar = (Toolbar) act.findViewById(R.id.toolbar);
            toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
            toolbar.setTitle("Fragment Second");
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    popBackStack();
                }
            });
        }
        setHasOptionsMenu(true);
        return root;
    }

    public void popBackStack() {
        final FragmentManager fm = getFragmentManager();
        final int backStackCount = fm.getBackStackEntryCount();
        if (backStackCount > 0) {
            getFragmentManager().popBackStack();
        } else {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_second, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add) {
            Toast.makeText(getActivity(), "Add", Toast.LENGTH_SHORT);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
