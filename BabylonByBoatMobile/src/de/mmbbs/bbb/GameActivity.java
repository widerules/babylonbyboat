package de.mmbbs.bbb;

import de.mmbbs.bbb.R;
import de.mmbbs.bbb.R.id;
import de.mmbbs.bbb.R.layout;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity {

    GameManager gm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.game);
        gm = new GameManager((GameCanvas) this.findViewById(R.id.gui));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // nichts tun
    }
}
