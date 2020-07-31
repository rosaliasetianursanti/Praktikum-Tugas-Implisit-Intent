package id.mobilecomputing.modul4;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplisitIntentActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText phoneNumber;
    private EditText websiteUri;
    private EditText locationUri;
    private EditText textShare;

    Button buttonWebsite;
    Button buttonLocation;
    Button buttonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implisit_intent);

        phoneNumber = findViewById(R.id.edit_dial_phone);
        websiteUri = findViewById(R.id.edit_browser);
        locationUri = findViewById(R.id.edit_location);
        textShare = findViewById(R.id.edit_share_text);

        buttonWebsite = findViewById(R.id.btn_browser);
        buttonWebsite.setOnClickListener(this);

        buttonLocation = findViewById(R.id.btn_location);
        buttonLocation.setOnClickListener(this);

        buttonText = findViewById(R.id.btn_share_text);
        buttonText.setOnClickListener(this);
    }

    public void dialPhone(View view) {
        if(phoneNumber.getText().toString().length()==0){
            phoneNumber.setError("Nomor Telepon Wajib Diisi!");
        }
        else {
            Intent dialPhone = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + phoneNumber.getText().toString()));
            startActivity(dialPhone);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_browser:
                if(websiteUri.getText().toString().length()==0){
                    websiteUri.setError("Kolom URL Wajib Diisi!");
                }
                else {
                    Intent openWebsite = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(websiteUri.getText().toString()));
                    startActivity(openWebsite);
                }
                break;

            case R.id.btn_location:
                if(locationUri.getText().toString().length()==0){
                    locationUri.setError("Nama Lokasi Wajib Diisi!");
                }
                else {
                    Intent openLocation = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("geo:0,0?q=" +
                                    locationUri.getText().toString()));
                    startActivity(openLocation);
                }
                break;

            case R.id.btn_share_text:
                if(textShare.getText().toString().length()==0){
                    textShare.setError("Kolom Teks Wajib Diisi!");
                }
                else {
                    ShareCompat.IntentBuilder
                            .from(this)
                            .setType("text/plan")
                            .setChooserTitle("Share this text with : ")
                            .setText(textShare.getText().toString())
                            .startChooser();
                }
                break;
        }
    }
}