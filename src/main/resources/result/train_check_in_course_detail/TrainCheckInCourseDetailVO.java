import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * train_check_in_course_detail vo
 *
 * @author linuxea
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TrainCheckInCourseDetailVO extends BaseVO {

    
    /**
     * 姓名
     */
     @ApiModelProperty("姓名")
    private String name;

    
    /**
     * id
     */
     @ApiModelProperty("id")
    private Long id;




}