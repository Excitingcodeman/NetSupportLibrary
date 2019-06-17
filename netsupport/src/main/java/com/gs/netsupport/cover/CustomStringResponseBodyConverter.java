package com.gs.netsupport.cover;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.gs.netsupport.BuildConfig;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;


/**
 * 自定义数据转换器
 * 返回结果同一为String
 *
 * @param <T>
 * @author husky
 */
public class CustomStringResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    static String TAG = CustomStringResponseBodyConverter.class.getSimpleName();
    private final TypeAdapter<T> adapter;

    CustomStringResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.adapter = adapter;

    }


    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        if (BuildConfig.DEBUG) {
            Log.d(TAG, response);
        }
        try {
            return adapter.fromJson(response);
        } finally {
            value.close();
        }
    }
}
