package a00077546.comp3717.bcit.ca.mileageconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void convertDistance(final View view) {

        final TextView outputText = (TextView) findViewById(R.id.outputText);
        final EditText edit = (EditText)findViewById(R.id.num2convert);
        final String inputStr = edit.getText().toString();
        final double output;

        if (TextUtils.isEmpty(inputStr)) {
            outputText.setText("");
            Toast.makeText(this, "Nothing to convert.  Try again.", Toast.LENGTH_LONG).show();
        } else {

            final double input = Double.parseDouble(inputStr);
            switch (view.getId()) {
                case R.id.btn_toKM:
                    //Toast.makeText(this, "Convert to KM", Toast.LENGTH_LONG).show();
                    output = convertToKM(input);
                    outputText.setText(inputStr + " Miles = " + output + " KM");
                    break;
                case R.id.btn_toMiles:
                    //Toast.makeText(this, "Convert to Miles", Toast.LENGTH_LONG).show();
                    output = convertToMiles(input);
                    outputText.setText(inputStr + " KM = " + output + " Miles");
                    break;
            }
        }
    }

    private double convertToMiles(final double d) {
        final double MILES_TO_KM = 0.621371;
        return d * MILES_TO_KM;
    }

    private double convertToKM(final double d) {
        final double KM_TO_MILES = 1.60934;
        return d * KM_TO_MILES;
    }
}
