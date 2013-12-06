package m.ui.android;

import android.app.ActionBar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

import android.widget.EditText;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/*
 * ����΢������
 * @author chunterg
 */
public class PostActivity extends Activity {

    private EditText postContentEditText = null;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		//Ԥ����������ı�Ĵ���״̬������ setContentView ֮ǰ���ã��������ñ���ʱ������ʱ����
		  
		  setContentView(R.layout.activity_post);
		  
		  ActionBar actionBar = getActionBar();
		  actionBar.setDisplayHomeAsUpEnabled(true);
		  
		  Bundle extras = getIntent().getExtras();
		  
		  if (extras != null) {
			  String title = extras.getString("username");
			  setTitle(title);
		  }
//		  ��������򽹵�
		  postContentEditText= (EditText)findViewById(R.id.postcontent);
		  postContentEditText.setFocusableInTouchMode(true);  
		  postContentEditText.requestFocus(); 
//		  �Զ�������̣���timer��ʱ���أ������ڽ�������ǰ����
		 Timer timer = new Timer();  
	     timer.schedule(new TimerTask(){  
	         public void run()  
	         {  
	             InputMethodManager inputManager =  
	                 (InputMethodManager)postContentEditText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);  
	             inputManager.showSoftInput(postContentEditText, 0);  
	         }  
	           
	     },300);   
		  
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
            	Intent i = new Intent(this, MyHomeActivity.class);  
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
                startActivity(i);   
                return true;  
            case R.id.post_btn:
            	 EditText postContent = (EditText) findViewById(R.id.postcontent);
	        	 Intent mIntent = new Intent();  
	             mIntent.putExtra("postContent", postContent.getText().toString());  
	             // ���ý���������д���  
	             this.setResult(MyHomeActivity.POSTTWEET, mIntent); 
	             this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
