package c346.rp.edu.sg.checkboxexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox discountCB;
    Button check;
    TextView displayTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountCB = findViewById(R.id.discountCB);

        check = findViewById(R.id.checkBtn);

        displayTv = findViewById(R.id.displayTv);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyActivity", "Inside onClick()");
                Toast.makeText(MainActivity.this, "Button Click", Toast.LENGTH_LONG).show();
                if (discountCB.isChecked()) {
                    double pay = calcPay(100, 20);
                    displayTv.setText("The discount is given. You need to pay " + pay);
                }
                else {
                    double pay = calcPay(100, 0);
                    displayTv.setText("The discount is not given. You need to pay " + pay);
                }
            }
        });

    }
    private double calcPay(double price, double discount) {
        double pay  = price * (1 - discount/100);

        return pay;
    }
}
