package com.faculty.fusedbloxxer.coachingapp.home.urgentsessions;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.BaseFragment;
import com.faculty.fusedbloxxer.coachingapp.model.PersonalDevelopmentViewModel;
import com.faculty.fusedbloxxer.coachingapp.utilities.Pair;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

import java.util.Locale;

public class UrgentSessionsFragment extends BaseFragment {
    private EditText rewardPointsEditText, priorityEditText;
    private PersonalDevelopmentViewModel vm;
    private UrgentViewModel urgentViewModel;
    private UrgentSessionAdapter adapter;
    private NavController navController;
    private RecyclerView recyclerView;
    private AlertDialog alertDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.simple_recycler_view_layout, container, false);
        initViews(itemView);
        return itemView;
    }

    private void initViews(View itemView) {
        recyclerView = itemView.findViewById(R.id.recycler_view);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        recyclerView.setAdapter(adapter = new UrgentSessionAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        vm = ViewModelProviders.of(this).get(PersonalDevelopmentViewModel.class);
        urgentViewModel = ViewModelProviders.of(this).get(UrgentViewModel.class);

        LifecycleOwner lifecycleOwner = this;
        getAlertDialog();
        urgentViewModel.getRewardAndPriority().observe(this, new Observer<Pair<Long, Long>>() {
                    @Override
                    public void onChanged(Pair<Long, Long> rewardAndPriority) {
                        priorityEditText.setText(String.format(Locale.ENGLISH, "%d", rewardAndPriority.getT2()));
                        rewardPointsEditText.setText(String.format(Locale.ENGLISH, "%d", rewardAndPriority.getT1()));
                        vm.getUrgentSessionsWhere(rewardAndPriority.getT1(), rewardAndPriority.getT2()).observe(lifecycleOwner,
                                urgentSessions -> adapter.setUrgentSessions(urgentSessions));
                    }
                }
        );
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.simple_filter_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.filter_option) {
            getAlertDialog().show();
        }
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

    private AlertDialog getAlertDialog() {
        if (alertDialog == null) {
            synchronized (this) {
                if (alertDialog == null) {
                    View dialogView = getLayoutInflater().inflate(R.layout.urgent_sessions_filter_dialog_layout, null);

                    rewardPointsEditText = dialogView.findViewById(R.id.urgent_sessions_reward_edit_text);
                    priorityEditText = dialogView.findViewById(R.id.urgent_sessions_priority_edit_text);

                    alertDialog = new AlertDialog.Builder(getContext())
                            .setView(dialogView)
                            .setTitle("Filtrare sedinte")
                            .setNegativeButton("Anuleaza", null)
                            .setPositiveButton("Accepta", (dialog, which) -> {
                                if (Utils.checkEditTexts(rewardPointsEditText, priorityEditText)) {

                                    final long rewardPoints = Long.parseLong(rewardPointsEditText.getText().toString());

                                    if (rewardPoints < 0 || rewardPoints > 100) {
                                        Toast.makeText(getContext(), "Recompensa nu este in intervalul corect !", Toast.LENGTH_LONG)
                                                .show();
                                        return;
                                    }

                                    final long priority = Long.parseLong(priorityEditText.getText().toString());

                                    if (priority < 0 || priority > 10) {
                                        Toast.makeText(getContext(), "Prioritatea nu este in intervalul corect !", Toast.LENGTH_LONG)
                                                .show();
                                        return;
                                    }

                                    urgentViewModel.setRewardAndPriority(
                                            rewardPoints,
                                            priority
                                    );

                                } else {
                                    Toast.makeText(getContext(), "Nu ati introdus date corecte !", Toast.LENGTH_LONG)
                                            .show();
                                }
                            })
                            .create();
                }
            }
        }
        return alertDialog;
    }
}
