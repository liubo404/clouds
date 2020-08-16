package com.demo;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DingTalk {

    private DingConfig dingConfig;

    public DingTalk(DingConfig dingConfig) {
        this.dingConfig = dingConfig;
    }

    public void msg(String msg) {

        try {
            Long time = System.currentTimeMillis();
            String sign = getSign(time);
            //这个是通过钉钉获取的机器人的连接，需要PC版才可以
            String url = String.format("%s&timestamp=%s&sign=%s", dingConfig.getHookUrl(), time, sign);
//        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=1e1e402813e3db2ad0a3a1ee7bd48171b7fec4778228ed8e476a02dac188d498&timestamp="+time+"&sign="+sign );
            DefaultDingTalkClient client = new DefaultDingTalkClient(url);
            OapiRobotSendRequest request = new OapiRobotSendRequest();
            request.setMsgtype("text");
            OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
            text.setContent(String.format("[%s]%s", dingConfig.getKeyword(), msg));
            request.setText(text);

            OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
            at.setIsAtAll(true);//设置@所有的人
            request.setAt(at);
            OapiRobotSendResponse response = client.execute(request);
            System.out.println(response.getErrcode());
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private String getSign(Long timestamp) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {


        String stringToSign = timestamp + "\n" + dingConfig.getSecret();
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(dingConfig.getSecret().getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        System.out.println(sign);

        return sign;
    }
}
