package com.rapigo.truoraclient.ui.domains;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rapigo.truoraclient.R;
import com.rapigo.truoraclient.models.Domain;
import com.rapigo.truoraclient.ui.domains.adapter.CustomAdapter;

import java.util.List;

public class DomainsFragment extends Fragment {

    private DomainsViewModel dashboardViewModel;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this).get(DomainsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        dashboardViewModel.getDomains().observe(this, new Observer<List<Domain>>() {
            @Override
            public void onChanged(List<Domain> domains) {
                mAdapter = new CustomAdapter(domains);

                recyclerView.setAdapter(mAdapter);
                Toast.makeText(getContext(), "Tamaño: " + domains.size(), Toast.LENGTH_LONG).show();
            }
        });

        recyclerView = (RecyclerView) root.findViewById(R.id.reciclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)



        return root;
    }
}