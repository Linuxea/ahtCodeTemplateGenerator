import com.aht.api.order.base.BaseOrderVideoInterviewApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * train_check_in_course_detail api client
 *
 * @author linuxea
 */
@FeignClient(name = TrainCheckInCourseDetailApi.SERVICE_NAME, path = TrainCheckInCourseDetailApi.CLIENT_PATH)
public interface TrainCheckInCourseDetailApiClient extends TrainCheckInCourseDetailApi {
}