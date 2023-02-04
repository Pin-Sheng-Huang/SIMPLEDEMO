package generate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * student
 * @author 
 */
@ApiModel(value="generate.Student")
@Data
public class Student implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private Integer tel;

    private String sex;

    private static final long serialVersionUID = 1L;
}