import com.demo.DingConfig;
import com.demo.DingTalk;
import com.taobao.api.ApiException;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Demo {

    final String secret = "SEC11f4df2a0f1120a56d20ff8f1f3afc4529e5edb6a5f5e8d38f51755b9c8ed961";

    final String hookUrl = "https://oapi.dingtalk.com/robot/send?access_token=1e1e402813e3db2ad0a3a1ee7bd48171b7fec4778228ed8e476a02dac188d498";

    final String keyword = "报警";

    @Test
    public void textMessage() throws ApiException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {

        DingConfig dc = DingConfig.builder().hookUrl(hookUrl).secret(secret).keyword(keyword).build();
        DingTalk dt = new DingTalk(dc);
        dt.msg("葵呼呼....");
//
//
//        Long time = System.currentTimeMillis();
//        String sign = getSign(time);
//        //这个是通过钉钉获取的机器人的连接，需要PC版才可以
//        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=1e1e402813e3db2ad0a3a1ee7bd48171b7fec4778228ed8e476a02dac188d498&timestamp=" + time + "&sign=" + sign);
//        OapiRobotSendRequest request = new OapiRobotSendRequest();
//        request.setMsgtype("text");
//        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
//        text.setContent("报警顶价失败....2...");
//        request.setText(text);
//
//        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
//        at.setIsAtAll(true);//设置@所有的人
//        request.setAt(at);
//        OapiRobotSendResponse response = client.execute(request);
//        System.out.println(response.getErrcode());
    }

//    private String getSign(Long timestamp) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
//
//
//        String stringToSign = timestamp + "\n" + secret;
//        Mac mac = Mac.getInstance("HmacSHA256");
//        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
//        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
//        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
//        System.out.println(sign);
//
//        return sign;
//    }
}
