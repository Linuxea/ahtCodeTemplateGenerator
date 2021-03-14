import com.aht.core.utils.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * train_check_in_course_detail controller
 *
 * @author linuxea
 */
@RestController
@RequestMapping(TrainCheckInCourseDetailApi.BASE_PATH)
@Slf4j
@Api(value = "train_check_in_course_detail", tags = "train_check_in_course_detail")
public class TrainCheckInCourseDetailController extends InjectServiceBaseController<TrainCheckInCourseDetailPO, TrainCheckInCourseDetailService> implements TrainCheckInCourseDetailApi {

    @Override
    @ApiOperation(hidden = true, value = "物理删除")
    public Result delete(String ids) {
        return Result.fail("不支持物理删除");
    }
}