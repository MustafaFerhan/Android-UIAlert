package henrychuang.tw.chatheadmsg;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;


public class MyDialog extends Activity {
	public static boolean active = false;
	public static Activity myDialog;
	
	EditText edt;
	Button btn;
	View top;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.dialog);
		
		edt = (EditText) findViewById(R.id.dialog_edt);
		btn = (Button) findViewById(R.id.dialog_btn);
		top = (View)findViewById(R.id.dialog_top);
				
		myDialog = MyDialog.this;
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String str = edt.getText().toString();
				if(str.length() > 0){
//					ChatHeadService.showMsg(MyDialog.this, str);
					Intent it = new Intent(MyDialog.this, ChatHeadService.class);
					it.putExtra(Utility.EXTRA_MSG, str);
					startService(it);
				}
			}
		});
		
		
		top.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}
		
	
	@Override
	protected void onResume() {
		super.onResume();
		active = true;
	}

	@Override
	protected void onPause() {
		super.onPause();
		active = false;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		active = false;
	}

	
	
}
