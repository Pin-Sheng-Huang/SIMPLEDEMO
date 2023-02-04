package util.RedisService;




import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2023-01-23 20:28
 * @LastEditTime: 2023-01-23 20:28
 */
@Service
public interface AttachmentService {
    public <Attachment> ResultMap insertSelective(Attachment attachment);
}
