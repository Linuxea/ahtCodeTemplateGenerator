package com.aht.api.order.base;

import com.aht.core.utils.Result;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * train_check_in_course_detail api
 *
 * @author linuxea
 */
public interface TrainCheckInCourseDetailApi {

    String SERVICE_NAME = "";

    String CONTEXT = "/";

    String BASE_PATH = "/TrainCheckInCourseDetail";

    String CLIENT_PATH = CONTEXT + BASE_PATH;


    /**
     * 根据查询条件分页搜索
     *
     * @param po       查询条件
     * @param pageNum  页码
     * @param pageSize 页长
     * @return 分页信息
     */
    @ApiOperation("根据查询条件分页搜索")
    @PostMapping("/pageListWithSubOrg")
    Result<PageInfo<TrainCheckInCourseDetailPO>> pageListWithSubOrg(@RequestBody TrainCheckInCourseDetailPO po,
                                        @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize);

    /**
     * 添加
     *
     * @param po 参数
     * @return 结果
     */
    @PostMapping("/insert")
    @ApiOperation("添加")
    Result<Void> insert(@RequestBody TrainCheckInCourseDetailPO po);

    /**
     * 编辑
     *
     * @param po 参数
     * @return 结果
     */
    @PostMapping("/update")
    @ApiOperation("编辑")
    Result<Void> update(@RequestBody TrainCheckInCourseDetailPO po);


    /**
     * 逻辑删除
     *
     * @param ids 根据ID批量逻辑删除
     * @return 无
     */
    @GetMapping("/logicDelete")
    @ApiOperation(value = "【逻辑删除】", notes = "根据ID批量逻辑删除 格式：1,2,3,4")
    Result<Integer> logicDelete(@RequestParam String ids);

}