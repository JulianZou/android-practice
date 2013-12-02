package m.ui.android;

import java.util.HashMap;
import java.util.Map;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * ���ý���
 * 
 * @author ticmy
 */
public class SettingsActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener {
    /**
     * �Ƿ�������Ϣ
     */
    public static final String KEY_RECEIVE_PUSH_MSG = "key_push_msg";
    /**
     * �Ƿ�����
     */
    public static final String KEY_RECEIVE_BELL = "key_receive_bell";
    /**
     * ����
     */
    public static final String KEY_RINGTONE = "key_ringtone";
    /**
     * �Ƿ���
     */
    public static final String KEY_RECEIVE_VIBRATE = "key_receive_vibrate";
    /**
     * @������
     */
    public static final String KEY_AT_REMIND = "key_at_remind";
    /**
     * ��������
     */
    public static final String KEY_COMMENT_REMIND = "key_comment_remind";
    /**
     * ˽������
     */
    public static final String KEY_PRIVATE_MSG_REMIND = "key_private_msg_remind";
    /**
     * �¹�ע����
     */
    public static final String KEY_NEW_FANS_REMIND = "key_new_fans_remind";
    /**
     * ��Ϣ��ȡƵ��
     */
    public static final String KEY_MSG_PULL_FREQUENCY = "key_msg_pull_frequency";
    /**
     * �Ķ�ģʽ����ͼ����ͼ
     */
    public static final String KEY_READING_MODE = "key_reading_mode";
    /**
     * �ֺ�
     */
    public static final String KEY_FONT_SIZE = "key_font_size";
    /**
     * �Ƿ��Զ����ظ���
     */
    public static final String KEY_LOAD_MORE = "key_load_more";
    
    /**
     * �������ú���Ҫ����summary��ʾ����Щpreference
     */
    private Map<String, Summary> needUpdatePreferenceMap = new HashMap<String, SettingsActivity.Summary>();
    
    {
        needUpdatePreferenceMap.put(KEY_MSG_PULL_FREQUENCY, new Summary("ÿ��", "����ˢ��һ��"));
        needUpdatePreferenceMap.put(KEY_RINGTONE, new Summary("", ""){
            public String getSummary(String value) {
                int lastSlashIndex = -1;
                if(value != null && (lastSlashIndex = value.lastIndexOf("/")) != -1) {
                    return value.substring(lastSlashIndex + 1);
                }
                return "";
            }
        });
        needUpdatePreferenceMap.put(KEY_READING_MODE, new Summary("", "") {
            public String getSummary(String value) {
                if("true".equalsIgnoreCase(value)) {
                    return "��ͼģʽ";
                }
                return "��ͼģʽ";
            }
        });
        needUpdatePreferenceMap.put(KEY_FONT_SIZE, new Summary("", "") {
            public String getSummary(String value) {
                if("small".equalsIgnoreCase(value)) {
                    return "С";
                } else if("large".equalsIgnoreCase(value)) {
                    return "��";
                } else {
                    return "��";
                }
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        for(String key : needUpdatePreferenceMap.keySet()) {
            setSummary(sharedPreferences, key);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Summary summary = needUpdatePreferenceMap.get(key);
        if (summary != null) {
            setSummary(sharedPreferences, key);
        }
    }

    private void setSummary(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);
        String value = sharedPreferences.getString(key, null);
        Summary summary = needUpdatePreferenceMap.get(key);
        if(preference == null || value == null || summary == null) {
            return;
        }
        preference.setSummary(summary.getSummary(value));
    }
    
    private static class Summary {
        private String prefix;
        private String suffix;
        
        public Summary(String prefix, String suffix){
            this.prefix = prefix;
            this.suffix = suffix;
        }
        
        /**
         * Ĭ���� prefix + value + suffix
         * @param value
         * @return
         */
        public String getSummary(String value) {
            return prefix + value + suffix;
        }
    }
}
