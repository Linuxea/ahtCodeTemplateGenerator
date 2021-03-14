import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * train_check_in_course_detail dto
 *
 * @author linuxea
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TrainCheckInCourseDetailDTO extends BaseDTO {

    
    /**
     * 姓名
     */
    private String name;

    
    /**
     * id
     */
    private Long id;




}