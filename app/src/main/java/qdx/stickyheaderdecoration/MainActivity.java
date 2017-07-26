package qdx.stickyheaderdecoration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import qdx.stickyheaderdecoration.grid.GridCustomActivity;
import qdx.stickyheaderdecoration.grid.GridNormalActivity;
import qdx.stickyheaderdecoration.linear.LinearCustomActivity;
import qdx.stickyheaderdecoration.linear.LinearNormalActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btn_lly_normal(View view) {
        startActivity(new Intent(MainActivity.this, LinearNormalActivity.class));
    }

    public void btn_lly_custom(View view) {
        startActivity(new Intent(MainActivity.this, LinearCustomActivity.class));
    }

    public void btn_grid_normal(View view) {
        startActivity(new Intent(MainActivity.this, GridNormalActivity.class));
    }

    public void btn_grid_custom(View view) {
        startActivity(new Intent(MainActivity.this, GridCustomActivity.class));
    }
}
