package com.gs.netsupport.cover;

import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * 自定义数据转换器工厂
 * 返回结果为String类型
 * @author husky
 */
public class CustomStringConverterFactory extends Converter.Factory {
    private final Gson gson;

    private CustomStringConverterFactory(Gson gson) {
        if (gson == null){ throw new NullPointerException("gson == null");}
        this.gson = gson;
    }

    public static CustomStringConverterFactory create() {
        return create(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create());
    }

    public static CustomStringConverterFactory create(Gson gson) {
        return new CustomStringConverterFactory(gson);
    }

    @Nullable
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations,
                                                          Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new CustomStringRequestBodyConverter<>(gson, adapter);
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new CustomStringResponseBodyConverter<>(gson, adapter);
    }
}
