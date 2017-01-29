package com.example.hiepnn.mydemoapplication.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiepnn.mydemoapplication.R;
import com.example.hiepnn.mydemoapplication.databinding.FragmentFirstBinding;
import com.example.hiepnn.mydemoapplication.utils.FragmentUtil;

public class FirstFragment extends Fragment {
    FragmentFirstBinding fragmentFirstBinding;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFirstBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false);
        View view = fragmentFirstBinding.getRoot();
        fragmentFirstBinding.toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_menu));
        fragmentFirstBinding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("onClick", "Menu");
            }
        });
        fragmentFirstBinding.toolbarTitle.setText("Fragment First");
        fragmentFirstBinding.imgbtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("onClick", "Search");
            }
        });
        fragmentFirstBinding.btnFrgSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUtil.pushFragment(getActivity(), new SecondFragment(), null);
            }
        });
        setHasOptionsMenu(true);
        return view;

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
