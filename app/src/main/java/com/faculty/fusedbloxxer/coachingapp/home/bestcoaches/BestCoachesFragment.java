package com.faculty.fusedbloxxer.coachingapp.home.bestcoaches;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.BaseFragment;
import com.faculty.fusedbloxxer.coachingapp.model.PersonalDevelopmentViewModel;

public class BestCoachesFragment extends BaseFragment {
    private static AlertDialog alertDialog;

    private BestCoachesAdapter bestCoachesAdapter;
    private PersonalDevelopmentViewModel vm;
    private ScoreViewModel scoreViewModel;
    private NavController navController;
    private RecyclerView recyclerView;

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
        recyclerView.setAdapter(bestCoachesAdapter = new BestCoachesAdapter());
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
        vm = ViewModelProviders.of(this).get(PersonalDevelopmentViewModel.class);
        scoreViewModel.getScoresLiveData().observe(this, scores ->
                vm.groupCoachesHaving(scores.getT1(), scores.getT2())
                        .observe(this, coachWithScores ->
                                bestCoachesAdapter.setCoachWithScoresList(coachWithScores)));
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
                    View dialogView = getLayoutInflater().inflate(R.layout.coaches_filter_dialog_layout, null);

                    RatingBar avgScoreRatingBar = dialogView.findViewById(R.id.coach_avg_score_rating_bar);
                    RatingBar maxScoreRatingBar = dialogView.findViewById(R.id.coach_max_score_rating_bar);

                    alertDialog = new AlertDialog.Builder(getContext())
                            .setView(dialogView)
                            .setTitle("Filtrare coach")
                            .setNegativeButton("Anuleaza", null)
                            .setPositiveButton("Accepta", (dialog, which) ->
                                    scoreViewModel.setScores(
                                            avgScoreRatingBar.getRating(),
                                            maxScoreRatingBar.getRating()
                                    )
                            )
                            .create();
                }
            }
        }
        return alertDialog;
    }
}
