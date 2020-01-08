package com.faculty.fusedbloxxer.coachingapp.core;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.home.OptionsViewModel;
import com.faculty.fusedbloxxer.coachingapp.home.roles.RolesFragmentDirections;
import com.faculty.fusedbloxxer.coachingapp.model.PersonalDevelopmentViewModel;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class TableFragment<T> extends BaseFragment implements INavigable<T> {
    protected OptionsViewModel optionsViewModel;
    protected PersonalDevelopmentViewModel vm;
    protected NavController navController;
    protected RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vm = ViewModelProviders.of(this).get(PersonalDevelopmentViewModel.class);
        optionsViewModel = ViewModelProviders.of(this).get(OptionsViewModel.class);
        optionsViewModel.getSelectedOption(getSortKey()).observe(this, this::fetchDataFromDatabase);

        recyclerView = view.findViewById(R.id.table_recycler_view);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(fabView -> onFabClick());

        navController = Navigation.findNavController(view);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.sort_option) {
            new AlertDialog.Builder(getContext())
                    .setTitle(Utils.SORT_TITLE)
                    .setItems(getOptions(), (dialogInterface, i) -> optionsViewModel.setSelectedOption(i, getSortKey()))
                    .create()
                    .show();
        }

        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

    protected abstract void fetchDataFromDatabase(int i);

    protected abstract String[] getOptions();

    protected abstract void onFabClick();

    protected abstract String getSortKey();
}
