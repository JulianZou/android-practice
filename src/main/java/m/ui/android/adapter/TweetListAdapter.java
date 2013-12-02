package m.ui.android.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View.OnTouchListener; 
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import m.domain.tweet.Tweet;
import m.domain.user.User;
import m.infrastructure.SampleData;
import m.ui.android.R;

/**
 * chunterg on 12/2/13.
 */
public class TweetListAdapter extends ArrayAdapter<Tweet> {

    private final Context context;   
    private List<Tweet> tweetList;
    private int resource;

    public TweetListAdapter(Context context, int resource, List<Tweet> tweetList) {

        super(context, resource, tweetList);
        this.context = context;
        this.tweetList = tweetList;
        this.resource = resource;
    }
    
    public final class ListItemView{  
        public TextView twitterUserName;     
        public TextView twitterContent; 
     }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	ListItemView  listItemView = null;
    	if (convertView == null) {
    		listItemView = new ListItemView();
//    		��ȡ����ֱ�ӵ��ã�����ʵ����
            convertView = LayoutInflater.from(context).inflate(R.layout.tweet_item, null);
            listItemView.twitterUserName = (TextView) convertView.findViewById(R.id.twitter_username);
            listItemView.twitterContent = (TextView) convertView.findViewById(R.id.twitter_content);
            convertView.setTag(listItemView); 
            
        }else {   
            listItemView = (ListItemView)convertView.getTag();   
        }
		// Ϊÿһ��view�����ô��ؼ���
    	convertView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
//				Listview touch�¼�
				Log.d("app-msg",event.toString());
				// TODO Auto-generated method stub
				return false;
			}
			
		});  
    	listItemView.twitterUserName.setText(tweetList.get(position).getUserName());
    	listItemView.twitterContent.setText(tweetList.get(position).getContent());
        return convertView;
    }


}
