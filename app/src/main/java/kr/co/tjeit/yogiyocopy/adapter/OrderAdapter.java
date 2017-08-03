package kr.co.tjeit.yogiyocopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import kr.co.tjeit.yogiyocopy.R;
import kr.co.tjeit.yogiyocopy.data.OrderData;

/**
 * Created by the on 2017-08-03.
 */



public class OrderAdapter extends ArrayAdapter<OrderData> {

    Context mContext;
    List<OrderData> mList;
    LayoutInflater inf;
    // OrderData와, order_list_item을 활용하는 어탭터를 작성.
    // 메인화면 2번째 탭에 리스트가 (내용은 반영하지 않고) 갯수만 나타나게.

    public  OrderAdapter(Context context, List<OrderData> list) {
        super(context, R.layout.order_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.order_list_item, null);
        }

        OrderData data = mList.get(position);

        TextView storeNameTxt = (TextView) row.findViewById(R.id.storeNameTxt);
        storeNameTxt.setText(data.getOrderStore().getStoreName());

        TextView dataTxt = (TextView) row.findViewById(R.id.dataTxt);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 dd일");
        dataTxt.setText(sdf.format(data.getOrderDate().getTime()));

        TextView locationTxt = (TextView) row.findViewById(R.id.locationTxt);
        locationTxt.setText(data.getLocation());

        TextView amountTxt = (TextView) row.findViewById(R.id.amountTxt);
        String amountStr = String.format(Locale.KOREA, "%,d원", data.getCost());
        amountTxt.setText(amountStr);

        return row;
    }
}
