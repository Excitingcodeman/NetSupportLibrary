package com.gs.netsupport.cover;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.orhanobut.logger.Logger;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
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
    private final TypeAdapter<T> adapter;

    CustomStringResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }


    @Override
    public T convert(@NotNull ResponseBody value) throws IOException {
        String response = value.string();
        Logger.d(response);
        try {
            return adapter.fromJson(response);
        } finally {
            value.close();
        }
    }
}
