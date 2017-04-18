package cn.shopin.mydagger2test.ui.gank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import cn.shopin.mydagger2test.R;
import cn.shopin.mydagger2test.model.entity.GankItemBean;

/**
 * Created by zcs on 2017/4/16.
 *
 * @desc
 */
public class GirlAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<GankItemBean> dataList;

    public GirlAdapter(Context mContext, List<GankItemBean> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (null == view) {
            view = mInflater.inflate(R.layout.item_gank, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) view.getTag();
        Picasso.with(mContext).load(dataList.get(i).getUrl()).into(viewHolder.img);
        return view;
    }

    class ViewHolder {
        private ImageView img;

        public ViewHolder(View view) {
            img = (ImageView) view.findViewById(R.id.img);
        }
    }
}
