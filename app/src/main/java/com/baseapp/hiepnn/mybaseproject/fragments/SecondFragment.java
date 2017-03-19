package com.baseapp.hiepnn.mybaseproject.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.baseapp.hiepnn.mybaseproject.R;
import com.baseapp.hiepnn.mybaseproject.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    FragmentSecondBinding fragmentSecondBinding;

    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSecondBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false);
        View view = fragmentSecondBinding.getRoot();
        fragmentSecondBinding.toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        if (fragmentSecondBinding.toolbarTitle instanceof TextView)
            fragmentSecondBinding.toolbarTitle.setText("Fragment Second");
        if (fragmentSecondBinding.imgbtnAdd instanceof ImageButton) {
            fragmentSecondBinding.imgbtnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("onClick", "Add");
                }
            });
        }
        fragmentSecondBinding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popBackStack();
            }
        });
        setHasOptionsMenu(true);
        return view;
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
            Toast.makeText(getActivity(), "Add", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
