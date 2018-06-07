package ng.com.ioi.blogx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Converter extends AppCompatActivity {

    TextView nairaChange, dollarChange, Converted;

    EditText naira, dollar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        nairaChange = findViewById(R.id.nairaChange);
        dollarChange = findViewById(R.id.dollarChange);

        //naira = findViewById(R.id.nairaConvert);
        dollar = findViewById(R.id.dollarCovert);

        //Naira
        DocumentReference naira = FirebaseFirestore.getInstance().document("CurrencyDB/NairaValue");
        naira.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if (documentSnapshot.exists()) {
                    String nairaValue = documentSnapshot.getString("NairaValue");
                    nairaChange.setText(nairaValue);
                }
            }
        });

        //Naira
        DocumentReference dollar = FirebaseFirestore.getInstance().document("CurrencyDB/DollarValue");
        dollar.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if (documentSnapshot.exists()) {
                    String dollarValue = documentSnapshot.getString("DollarValue");
                    dollarChange.setText(dollarValue);
                }
            }
        });
    }

    public void UpdateDollar(View view) {

        final String dr = dollar.getText().toString();

        if (!TextUtils.isEmpty(dr)) {

            EditText dollar = findViewById(R.id.dollarCovert);

            double d = Double.parseDouble(nairaChange.getText().toString());
            long D = Math.round(d);

            int Naira = Integer.parseInt(dollar.getText().toString());

            int Dollar = (int) D;

            double result = ((double) Naira * Dollar);

            Converted = findViewById(R.id.Converted);

            Converted.setText(String.valueOf(result));
        } else {

            dollar.setText("0");
        }
    }
}
