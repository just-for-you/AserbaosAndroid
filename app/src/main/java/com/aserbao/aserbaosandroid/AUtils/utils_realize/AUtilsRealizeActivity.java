package com.aserbao.aserbaosandroid.AUtils.utils_realize;

import android.bluetooth.BluetoothAdapter;
import android.view.View;

import com.aserbao.aserbaosandroid.AUtils.utils.date.AppScreenMgr;
import com.aserbao.aserbaosandroid.AUtils.utils.date.AppSysMgr;
import com.aserbao.aserbaosandroid.AUtils.utils.network.ANetworkUtils;
import com.aserbao.aserbaosandroid.AUtils.utils.phone.APhoneMediaUtils;
import com.aserbao.aserbaosandroid.AUtils.utils.phone.APhoneUtils;
import com.aserbao.aserbaosandroid.R;
import com.aserbao.aserbaosandroid.base.BaseRecyclerViewActivity;
import com.aserbao.aserbaosandroid.base.beans.BaseRecyclerBean;
import com.aserbao.aserbaosandroid.base.beans.ClassBean;

public class AUtilsRealizeActivity extends BaseRecyclerViewActivity {

    @Override
    public void initGetData() {
        mBaseRecyclerBeen.add(new BaseRecyclerBean("获取当前手机信息"));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("网络状态"));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("多媒体数据获取"));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("屏幕常用参数获取"));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("ContextWrapper的常用方法调用"));
    }


    @Override
    public void itemClickBack(View view, int position) {
        switch (position){
            case 0:
                StringBuffer stringBuffer = new StringBuffer();
                String phoneMeesager = APhoneUtils.getInstance().getPhoneMeesager(this);
                String appSysMgrInfo = AppSysMgr.getAppSysMgrInfo(this);
                stringBuffer.append(phoneMeesager).append(appSysMgrInfo);

                BluetoothAdapter myDevice = BluetoothAdapter.getDefaultAdapter();
                if (myDevice != null) {
                    String deviceName = myDevice.getName();
                    mBaseRecyclerTv.setText(deviceName + stringBuffer.toString());
                }else{
                    mBaseRecyclerTv.setText(stringBuffer.toString());
                }

                break;
            case 1:
                int networkState = ANetworkUtils.getNetworkState(this);
                String valueOf = String.valueOf(networkState);
                mBaseRecyclerTv.setText(valueOf);
                break;
            case 2:
                String phoneMediaInfo = APhoneMediaUtils.getPhoneMediaInfo(this);
                mBaseRecyclerTv.setText(phoneMediaInfo);
                break;
            case 3:
                mBaseRecyclerTv.setText(AppScreenMgr.getScreenInfo(this));
                break;
            case 4:
                mBaseRecyclerTv.setTextSize(16);
                StringBuffer sb = new StringBuffer();
                sb.append("getPackageName() = ").append(getPackageName()).append("\n")
                  .append("getPackageResourcePath() =").append(getPackageResourcePath()).append("\n")
                  .append("getPackageCodePath() =").append(getPackageCodePath()).append("\n")
                  .append("getFilesDir() =").append(getFilesDir().toString()).append("\n");
                mBaseRecyclerTv.setText(sb.toString());
                break;
        }
    }
}
