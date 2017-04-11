package cl.karangop.aboutkarina;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        TextView linkedin= (TextView) findViewById(R.id.linkedinTv);
        TextView phone= (TextView) findViewById(R.id.phoneTv);

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linkedinIntent= new Intent(Intent.ACTION_VIEW);
                linkedinIntent.setData(Uri.parse("https://cl.linkedin.com/in/karangop"));
                startActivity(linkedinIntent);
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: +56 9 59178128"));
                startActivity(callIntent);
                //Toast.makeText(ContactActivity.this, "Hola Phone", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
