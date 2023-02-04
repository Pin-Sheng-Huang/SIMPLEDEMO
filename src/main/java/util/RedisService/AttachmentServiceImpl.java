package util.RedisService;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2023-01-23 20:32
 * @LastEditTime: 2023-01-23 20:32
 */

public class AttachmentServiceImpl implements AttachmentService{
//    @Resource
//    private AttachmentDao attachmentdao;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public <Attachment> ResultMap insertSelective(Attachment attachment) {
        return null;
    }
}
