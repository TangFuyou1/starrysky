package com.xiaotang.starrysky;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 文件名: Data
 * 创建者: 友
 * 创建日期: 2020/10/22 8:48
 * 邮箱: 1738743304.com !
 * 描述: TODO
 */
public class Data {

    @SerializedName("args")
    private ArgsBean _$Args176; // FIXME check this code
    private String data;
    private FilesBean files;
    private FormBean form;
    private HeadersBean headers;
    private Object json;
    private String method;
    private String origin;
    private String url;

    @Override
    public String toString() {
        return "Data{" +
                "_$Args176=" + _$Args176 +
                ", data='" + data + '\'' +
                ", files=" + files +
                ", form=" + form +
                ", headers=" + headers +
                ", json=" + json +
                ", method='" + method + '\'' +
                ", origin='" + origin + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ArgsBean get_$Args176() {
        return _$Args176;
    }

    public void set_$Args176(ArgsBean _$Args176) {
        this._$Args176 = _$Args176;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public FilesBean getFiles() {
        return files;
    }

    public void setFiles(FilesBean files) {
        this.files = files;
    }

    public FormBean getForm() {
        return form;
    }

    public void setForm(FormBean form) {
        this.form = form;
    }

    public HeadersBean getHeaders() {
        return headers;
    }

    public void setHeaders(HeadersBean headers) {
        this.headers = headers;
    }

    public Object getJson() {
        return json;
    }

    public void setJson(Object json) {
        this.json = json;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class ArgsBean implements Serializable {
    }

    public static class FilesBean implements Serializable {
    }

    public static class FormBean implements Serializable {
    }

    public static class HeadersBean implements Serializable {
        @SerializedName("Accept")
        private String _$Accept142; // FIXME check this code
        @SerializedName("Accept-Encoding")
        private String AcceptEncoding;
        @SerializedName("Accept-Language")
        private String AcceptLanguage;
        private String Connection;
        private String Host;
        @SerializedName("Upgrade-Insecure-Requests")
        private String UpgradeInsecureRequests;
        @SerializedName("User-Agent")
        private String UserAgent;

        @Override
        public String toString() {
            return "HeadersBean{" +
                    "_$Accept142='" + _$Accept142 + '\'' +
                    ", AcceptEncoding='" + AcceptEncoding + '\'' +
                    ", AcceptLanguage='" + AcceptLanguage + '\'' +
                    ", Connection='" + Connection + '\'' +
                    ", Host='" + Host + '\'' +
                    ", UpgradeInsecureRequests='" + UpgradeInsecureRequests + '\'' +
                    ", UserAgent='" + UserAgent + '\'' +
                    '}';
        }

        public String get_$Accept142() {
            return _$Accept142;
        }

        public void set_$Accept142(String _$Accept142) {
            this._$Accept142 = _$Accept142;
        }

        public String getAcceptEncoding() {
            return AcceptEncoding;
        }

        public void setAcceptEncoding(String AcceptEncoding) {
            this.AcceptEncoding = AcceptEncoding;
        }

        public String getAcceptLanguage() {
            return AcceptLanguage;
        }

        public void setAcceptLanguage(String AcceptLanguage) {
            this.AcceptLanguage = AcceptLanguage;
        }

        public String getConnection() {
            return Connection;
        }

        public void setConnection(String Connection) {
            this.Connection = Connection;
        }

        public String getHost() {
            return Host;
        }

        public void setHost(String Host) {
            this.Host = Host;
        }

        public String getUpgradeInsecureRequests() {
            return UpgradeInsecureRequests;
        }

        public void setUpgradeInsecureRequests(String UpgradeInsecureRequests) {
            this.UpgradeInsecureRequests = UpgradeInsecureRequests;
        }

        public String getUserAgent() {
            return UserAgent;
        }

        public void setUserAgent(String UserAgent) {
            this.UserAgent = UserAgent;
        }
    }
}
