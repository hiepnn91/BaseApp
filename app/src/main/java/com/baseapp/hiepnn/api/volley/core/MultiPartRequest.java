package com.baseapp.hiepnn.api.volley.core;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyLog;


import org.apache.http.Consts;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class MultiPartRequest<T> extends GsonRequest<T> {

    MultipartEntityBuilder entity = MultipartEntityBuilder.create();
    private final Map<String, String> mStringParts;
    private final Map<String, File> mFileParts;

    private String bodyContentType = "multipart/form-data";

    private static final String BOUNDARY = "5L9XCyg8_cKjeJHOQTXkUF1InoVIG4RdHn";

    public MultiPartRequest(int method, String url, Response.ErrorListener listener, Class<T> mClass, Map<String, String> mHeader, Response.Listener<T> mListener, Map<String, String> mStringParts, Map<String, File> mFileParts) {
        super(method, url, mClass, mHeader, null, mListener, listener);
        this.mStringParts = mStringParts;
        this.mFileParts = mFileParts;
        if (mFileParts != null) {
            buildMultipartEntity();
        }
    }

    private void buildMultipartEntity() {
        entity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        entity.setBoundary(BOUNDARY);
        //送信するリクエストを設定する
        //StringData
        for (Map.Entry<String, String> entry : mStringParts.entrySet()) {
            entity.addPart(entry.getKey(), new StringBody(entry.getValue(), ContentType.create("text/plain", Consts.UTF_8)));
        }
        //File DataUpdateMyCoin
        for (Map.Entry<String, File> entry : mFileParts.entrySet()) {
//            final String path = entry.getValue().getPath();
//            final String mimeType = FileUtils.getMimeType(path);
//            DebugLog.i(String.format("\nUploading file:%s\n mimeType%s %s", path, mimeType, String.valueOf(entry.getValue().length())));
//
//            if (mimeType == null) {
//                if (path.endsWith(".jpg")) {
//                    entity.addPart(entry.getKey(), new FileBody(entry.getValue(), ContentType.create("image/jpeg"), entry.getValue().getName()));
//                } else {
//                    entity.addPart(entry.getKey(), new FileBody(entry.getValue(), ContentType.create(mimeType), entry.getValue().getName()));
//                }
//            } else {
//                entity.addPart(entry.getKey(), new FileBody(entry.getValue(), ContentType.create(mimeType), entry.getValue().getName()));
//            }
        }
//        bodyContentType = entity.build().getContentType().getValue();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            bos.writeTo(bos);
            String entityContentAsString = new String(bos.toByteArray());
            Log.e("volley", entityContentAsString);
        } catch (IOException e) {
            VolleyLog.e("IOException writing to ByteArrayOutputStream");
        }
        return bos.toByteArray();
    }

    @Override
    public String getBodyContentType() {
        return bodyContentType;
    }

}
