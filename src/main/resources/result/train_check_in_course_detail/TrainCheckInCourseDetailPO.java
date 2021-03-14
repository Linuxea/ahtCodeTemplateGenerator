import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * train_check_in_course_detail po
 *
 * @author linuxea
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "train_check_in_course_detail 表", description = "train_check_in_course_detail 表")
@Table(name = "train_check_in_course_detail")
@Data
public class TrainCheckInCourseDetailPO extends BasePO {

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private Long id;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private Long checkInCourseId;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private String coverUrl;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private String videoUrl;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private String title;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private Long categoryConfigId;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private Long categoryConfigValue;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private Integer sort;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private Long classConfigId;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private String classConfigValue;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private Integer duration;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private Date createDate;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private Date modifyDate;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private Date generateDate;

    
    /**
     * 无注释
     */
    @ApiModelProperty("无注释")
    private Integer isDeleted;




}