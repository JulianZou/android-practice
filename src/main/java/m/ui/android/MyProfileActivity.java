package m.ui.android;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MyProfileActivity extends Activity {
	private static SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss");
	private static SimpleDateFormat yearBeforeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_profile);
		
		listView = (ListView)findViewById(R.id.message_list);
		
		SimpleAdapter adapter = new SimpleAdapter(this, getData(), 
				R.layout.list_row, 
				new String[]{"title", "postTime", "content"}, 
				new int[]{R.id.title, R.id.post_time, R.id.content});
		
		listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_profile, menu);
		return true;
	}
	
	
	
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.add(createMessage("����1", new Date(), "���ǣ���������䷭��-current����ʼ��б�ʱ��żȻ������һЩ����BSD grep��GNU grep���ܵ����ۣ������Ҳע�⵽����Щ���ۡ�������ô˵�������ο��ɣ�������һЩ�򵥵��ܽᣬ����ΪʲôGNU grep���֮�졣�������ܽ�����е�һЩ˼�����õ�BSD grep��ȥ��"));
		list.add(createMessage("����1", new Date(), "���ǣ���������䷭��-current����ʼ��б�ʱ��żȻ������һЩ����BSD grep��GNU grep���ܵ����ۣ������Ҳע�⵽����Щ���ۡ�������ô˵�������ο��ɣ�������һЩ�򵥵��ܽᣬ����ΪʲôGNU grep���֮�졣�������ܽ�����е�һЩ˼�����õ�BSD grep��ȥ��"));
		list.add(createMessage("����1", new Date(), "���ǣ���������䷭��-current����ʼ��б�ʱ��żȻ������һЩ����BSD grep��GNU grep���ܵ����ۣ������Ҳע�⵽����Щ���ۡ�������ô˵�������ο��ɣ�������һЩ�򵥵��ܽᣬ����ΪʲôGNU grep���֮�졣�������ܽ�����е�һЩ˼�����õ�BSD grep��ȥ��"));
		list.add(createMessage("����1", new Date(), "���ǣ���������䷭��-current����ʼ��б�ʱ��żȻ������һЩ����BSD grep��GNU grep���ܵ����ۣ������Ҳע�⵽����Щ���ۡ�������ô˵�������ο��ɣ�������һЩ�򵥵��ܽᣬ����ΪʲôGNU grep���֮�졣�������ܽ�����е�һЩ˼�����õ�BSD grep��ȥ��"));
		list.add(createMessage("����1", new Date(), "���ǣ���������䷭��-current����ʼ��б�ʱ��żȻ������һЩ����BSD grep��GNU grep���ܵ����ۣ������Ҳע�⵽����Щ���ۡ�������ô˵�������ο��ɣ�������һЩ�򵥵��ܽᣬ����ΪʲôGNU grep���֮�졣�������ܽ�����е�һЩ˼�����õ�BSD grep��ȥ��"));
		list.add(createMessage("����1", new Date(), "���ǣ���������䷭��-current����ʼ��б�ʱ��żȻ������һЩ����BSD grep��GNU grep���ܵ����ۣ������Ҳע�⵽����Щ���ۡ�������ô˵�������ο��ɣ�������һЩ�򵥵��ܽᣬ����ΪʲôGNU grep���֮�졣�������ܽ�����е�һЩ˼�����õ�BSD grep��ȥ��"));
		list.add(createMessage("����1", new Date(), "���ǣ���������䷭��-current����ʼ��б�ʱ��żȻ������һЩ����BSD grep��GNU grep���ܵ����ۣ������Ҳע�⵽����Щ���ۡ�������ô˵�������ο��ɣ�������һЩ�򵥵��ܽᣬ����ΪʲôGNU grep���֮�졣�������ܽ�����е�һЩ˼�����õ�BSD grep��ȥ��"));
		list.add(createMessage("����1", new Date(), "���ǣ���������䷭��-current����ʼ��б�ʱ��żȻ������һЩ����BSD grep��GNU grep���ܵ����ۣ������Ҳע�⵽����Щ���ۡ�������ô˵�������ο��ɣ�������һЩ�򵥵��ܽᣬ����ΪʲôGNU grep���֮�졣�������ܽ�����е�һЩ˼�����õ�BSD grep��ȥ��"));
		list.add(createMessage("����1", new Date(), "���ǣ���������䷭��-current����ʼ��б�ʱ��żȻ������һЩ����BSD grep��GNU grep���ܵ����ۣ������Ҳע�⵽����Щ���ۡ�������ô˵�������ο��ɣ�������һЩ�򵥵��ܽᣬ����ΪʲôGNU grep���֮�졣�������ܽ�����е�һЩ˼�����õ�BSD grep��ȥ��"));
		list.add(createMessage("����1", new Date(), "���ǣ���������䷭��-current����ʼ��б�ʱ��żȻ������һЩ����BSD grep��GNU grep���ܵ����ۣ������Ҳע�⵽����Щ���ۡ�������ô˵�������ο��ɣ�������һЩ�򵥵��ܽᣬ����ΪʲôGNU grep���֮�졣�������ܽ�����е�һЩ˼�����õ�BSD grep��ȥ��"));
		list.add(createMessage("����1", new Date(), "���ǣ���������䷭��-current����ʼ��б�ʱ��żȻ������һЩ����BSD grep��GNU grep���ܵ����ۣ������Ҳע�⵽����Щ���ۡ�������ô˵�������ο��ɣ�������һЩ�򵥵��ܽᣬ����ΪʲôGNU grep���֮�졣�������ܽ�����е�һЩ˼�����õ�BSD grep��ȥ��"));
		list.add(createMessage("����1", new Date(), "���ǣ���������䷭��-current����ʼ��б�ʱ��żȻ������һЩ����BSD grep��GNU grep���ܵ����ۣ������Ҳע�⵽����Щ���ۡ�������ô˵�������ο��ɣ�������һЩ�򵥵��ܽᣬ����ΪʲôGNU grep���֮�졣�������ܽ�����е�һЩ˼�����õ�BSD grep��ȥ��"));
		return list;
	}
	
	private Map<String, Object> createMessage(String title, Date postTime, String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("postTime", currentYear(postTime) ? format.format(postTime) : yearBeforeFormat.format(postTime));
		map.put("content", content);
		return map;
	}
	
	private boolean currentYear(Date date){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		cal.setTime(date);
		return year == cal.get(Calendar.YEAR); 
	}

}
