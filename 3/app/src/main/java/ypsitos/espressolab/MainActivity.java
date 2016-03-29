package ypsitos.espressolab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView mBalanceTv;
    TextView mBalanceTitle;
    EditText mIncomingBalance;
    FloatingActionButton mNextFab;
    FloatingActionButton mAddFab;
    FloatingActionButton mMinusFab;
    String mInputString;
    int mNextBalance;
    int mToUseBalance;
    int mCurrentBalance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBalanceTv = (TextView)findViewById(R.id.balanceTv);
        mBalanceTitle = (TextView)findViewById(R.id.balanceTitle);
        mIncomingBalance = (EditText)findViewById(R.id.incomingBalanceEt);

        mAddFab = (FloatingActionButton)findViewById(R.id.addFab);
        mAddFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentBalance = Integer.parseInt(mBalanceTv.getText().toString());
                mInputString = mIncomingBalance.getText().toString();
                mToUseBalance = Integer.parseInt(mInputString);

                mNextBalance = mCurrentBalance + mToUseBalance;
                mBalanceTv.setText(Integer.toString(mNextBalance));
            }
        });


        mMinusFab = (FloatingActionButton)findViewById(R.id.minusFab);
        mMinusFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentBalance = Integer.parseInt(mBalanceTv.getText().toString());
                mInputString = mIncomingBalance.getText().toString();
                mToUseBalance = Integer.parseInt(mInputString);

                mNextBalance = mCurrentBalance - mToUseBalance;
                mBalanceTv.setText(Integer.toString(mNextBalance));
            }
        });




       mNextFab = (FloatingActionButton) findViewById(R.id.nextFab);
        mNextFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toNameAndEmailActivity = new Intent(MainActivity.this,NameAndEmailActivity.class);
                startActivity(toNameAndEmailActivity);
            }
        });
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
}
