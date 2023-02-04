package generate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * article
 * @author 
 */
@ApiModel(value="generate.Article")
@Data
public class Article implements Serializable {
    private Integer id;

    private String author;

    private String title;

    private String content;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}