package ndk.banee.clickonce;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class ButtonAdaptor extends BaseAdapter {

    private Context mContext;
    private String[] services = {"s1", "s2", "s1", "s2", "s1", "s2", "s1", "s2", "s1", "s2", "s1", "s2"};

    ButtonAdaptor(Context c) {

        mContext = c;
    }

    @Override
    public int getCount() {

        return 12;
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Button button;

        if (convertView == null) {

            button = new Button(mContext);
            button.setLayoutParams(new GridView.LayoutParams(85, 85));
            button.setPadding(8, 8, 8, 8);

        } else {

            button = (Button) convertView;
        }
        button.setText(services[position]);
        return button;
    }
}
