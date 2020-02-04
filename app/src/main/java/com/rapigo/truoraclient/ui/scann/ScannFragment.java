package com.rapigo.truoraclient.ui.scann;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.rapigo.truoraclient.R;
import com.rapigo.truoraclient.client.CallbackHttp;
import com.rapigo.truoraclient.client.TruoraService;
import com.rapigo.truoraclient.models.Domain;
import com.rapigo.truoraclient.ui.domains.DomainsViewModel;
import com.rapigo.truoraclient.ui.utils.InitComponents;

public class ScannFragment extends Fragment implements InitComponents, View.OnClickListener {
    private EditText inputTextDomain;
    private View domainFragment;
    private Button escanearButton;

    private TextView textViewDomain;
    private TextView textViewLogo;
    private TextView textViewTitle;
    private TextView textViewSslGrade;

    private ScannViewModel scannViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        scannViewModel = ViewModelProviders.of(this).get(ScannViewModel.class);

        scannViewModel.getDomain().observe(this, new Observer<Domain>() {
            @Override
            public void onChanged(@Nullable Domain d) {
                showDomain(d);
            }
        });

        this.init(root);

        return root;
    }

    @Override
    public void init(View root) {
        this.inputTextDomain = root.findViewById(R.id.dominioInput);
        this.escanearButton = root.findViewById(R.id.buttonEscanear);
        this.textViewDomain = root.findViewById(R.id.textViewDomain);
        this.textViewLogo = root.findViewById(R.id.textViewLogo);
        this.textViewTitle = root.findViewById(R.id.textViewTitle);
        this.textViewSslGrade = root.findViewById(R.id.textViewSslGrade);

        this.escanearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String domain = inputTextDomain.getText().toString();

        TruoraService service = new TruoraService(getContext());
        service.scannDomain(domain, new CallbackHttp<Domain>() {
            @Override
            public void success(Domain domain) {
                scannViewModel.setDomain(domain);
            }

            @Override
            public void error(String error) {
                Toast.makeText(getContext(),error, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showDomain(Domain domain){
        textViewDomain.setText(domain.getDomain());
        textViewLogo.setText(domain.getLogo());
        textViewTitle.setText(domain.getTitle());
        textViewSslGrade.setText(domain.getSslGrade());
    }
}