import okhttp3.*;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class OkHttpTest {

    public static void main(String[] args) throws IOException {

        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2)
                .cipherSuites(
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384,
                        CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384,
                        CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA,
                        CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA256,
                        CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA

                        //TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 (0xC030) 256 bits FS
                        //TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA (0xC014) 256 bits FS
                        //TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 (0xC028) 256 bits FS
                        //TLS_RSA_WITH_AES_256_GCM_SHA384 (0x9D) 256 bits
                        //TLS_RSA_WITH_AES_256_CBC_SHA (0x35) 256 bits
                        //TLS_RSA_WITH_AES_256_CBC_SHA256 (0x3D) 256 bits
                        //TLS_RSA_WITH_CAMELLIA_256_CBC_SHA (0x84) 256 bits
                        //
                        )
                .build();

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectionSpecs(Collections.singletonList(spec))
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
//            .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
              //  .sslSocketFactory(SSLSocketClient.getSSLSocketFactory(), SSLSocketClient.getX509TrustManager())
           //     .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();
        Request request = new Request.Builder()
                //.url("https://fzfinder.yjbtest.com/v2/event/list")
                .url("https://sffinder.yjbtest.com/v2/event/list")
               // .url("https://www.baidu.com/")
                .build();
        Response execute = okHttpClient.newCall(request).execute();
        System.out.println(execute.toString());


//        sendHtpps("https://fzfinder.yjbtest.com/v2/event/list");
       // sendHtpps("https://www.baidu.com");
    }


    public static class SSLSocketClient {

        //????????????SSLSocketFactory
        public static SSLSocketFactory getSSLSocketFactory() {
            try {
                SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, getTrustManager(), new SecureRandom());
                return sslContext.getSocketFactory();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //??????TrustManager
        private static TrustManager[] getTrustManager() {
            return new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[]{};
                        }
                    }
            };
        }

        //??????HostnameVerifier
        public static HostnameVerifier getHostnameVerifier() {
            return (s, sslSession) -> true;
        }

        public static X509TrustManager getX509TrustManager() {
            X509TrustManager trustManager = null;
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                    throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                }
                trustManager = (X509TrustManager) trustManagers[0];
            } catch (Exception e) {
                e.printStackTrace();
            }

            return trustManager;
        }
    }



    public static String sendHtpps(String openIdSessionkeyUrl) {
        String result = "";
        PrintWriter out = null;
        BufferedReader in = null;
        HttpURLConnection conn;
        try {
            trustAllHosts();
            URL realUrl = new URL(openIdSessionkeyUrl);
            // ????????????????????????????????????(http?????????https)
            if (realUrl.getProtocol().toLowerCase().equals("https")) {
                HttpsURLConnection https = (HttpsURLConnection) realUrl.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                conn = https;
            } else {
                conn = (HttpURLConnection) realUrl.openConnection();
            }
            // ???????????????????????????
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "text/plain;charset=utf-8");
            // ??????POST??????????????????????????????
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // ??????URLConnection????????????????????????
            out = new PrintWriter(conn.getOutputStream());
            // ??????????????????
            // out.print(a);
            // flush??????????????????
            out.flush();
            // ??????BufferedReader??????????????????URL?????????
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {// ??????finally?????????????????????????????????
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    private static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }
        } };
        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };
}
