package a00077546.comp3717.bcit.ca.mileageconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.String;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        final Button button = (Button) findViewById(R.id.btn_convert);
        final TextView textView = (TextView) findViewById(R.id.outputText);
        final EditText edit = (EditText)findViewById(R.id.num2convert);

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                String input = edit.getText().toString();
                Double inputValue = Double.parseDouble(input);

                Double outputValue = convertToMiles(inputValue);

                String output = outputValue.toString();
                textView.setText(input + " KM = " + output + " Miles");
                System.out.println("You entered: " + input);
            }
        });

        return true;
    }

    public double convertToMiles(double d) {
        final double miles2km = 0.621371;
        return d * miles2km;
    }

    public double convertToKM(double d) {
        final double kmToMiles = 1.60934;
        return d * kmToMiles;
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
}
