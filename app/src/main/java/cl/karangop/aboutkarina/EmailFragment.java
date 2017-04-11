package cl.karangop.aboutkarina;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmailFragment extends Fragment {


    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_email, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Button contactBtn= (Button) view.findViewById(R.id.contactBtn);
        final TextInputLayout msgWrapper= (TextInputLayout) view.findViewById(R.id.msgWrapper);
        final EditText userInput= (EditText) view.findViewById(R.id.msgEt);
        final Button btnSend= (Button) view.findViewById(R.id.sendBtn);

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactBtn.setVisibility(View.GONE);
                msgWrapper.setVisibility(View.VISIBLE);
                btnSend.setVisibility(View.VISIBLE);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg= userInput.getText().toString();

                if (msg.trim().length() > 0){
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setType("*/*");
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]
                            {"karangop@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Contacto About ME");
                    intent.putExtra(Intent.EXTRA_TEXT, msg);
                    startActivity(intent);
                }

            }
        });
    }
}
