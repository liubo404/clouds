import com.demo.DingConfig;
import com.demo.DingTalk;
import org.junit.Test;

public class Demo {

    final String secret = "SEC11f4df2a0f1120a56d20ff8f1f3afc4529e5edb6a5f5e8d38f51755b9c8ed961";

    final String hookUrl = "https://oapi.dingtalk.com/robot/send?access_token=1e1e402813e3db2ad0a3a1ee7bd48171b7fec4778228ed8e476a02dac188d498";

    final String keyword = "报警";

    @Test
    public void textMessage() {

        DingConfig dc = DingConfig.builder().hookUrl(hookUrl).secret(secret).keyword(keyword).isAtAll(true).build();
        DingTalk dt = new DingTalk(dc);
        dt.msg("葵呼呼....");
    }

}
