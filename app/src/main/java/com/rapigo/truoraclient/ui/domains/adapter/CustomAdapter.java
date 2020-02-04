package com.rapigo.truoraclient.ui.domains.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rapigo.truoraclient.R;
import com.rapigo.truoraclient.models.Domain;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.DomainViewHolder> {

    private List<Domain> listDomains;

    public CustomAdapter(List<Domain> list){
        this.listDomains = list;
    }

    @NonNull
    @Override
    public DomainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dominio_list, parent, false);
        return new DomainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DomainViewHolder holder, int position) {
        Domain domain = listDomains.get(position);
        holder.bindDomain(domain);
    }

    @Override
    public int getItemCount() {
        return listDomains.size();
    }

    public static class DomainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textViewDomain;
        private TextView textViewLogo;
        private TextView textViewTitle;
        private TextView textViewSslGrade;

        public DomainViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewDomain = itemView.findViewById(R.id.textViewDomain);
            this.textViewLogo = itemView.findViewById(R.id.textViewLogo);
            this.textViewTitle = itemView.findViewById(R.id.textViewTitle);
            this.textViewSslGrade = itemView.findViewById(R.id.textViewSslGrade);
        }

        @Override
        public void onClick(View v) {

        }

        public void bindDomain(Domain domain){
            textViewDomain.setText(domain.getDomain());
            textViewLogo.setText(domain.getLogo());
            textViewTitle.setText(domain.getTitle());
            textViewSslGrade.setText(domain.getSslGrade());
        }
    }
}
