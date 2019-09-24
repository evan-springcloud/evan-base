package org.evan.springcloud.base.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.evan.libraries.model.result.OperateResult;
import org.evan.libraries.model.result.OperateResultConstants;
import org.evan.libraries.model.result.PageResult;
import org.evan.libraries.model.result.RestResponse;
import org.evan.springcloud.base.demo.DemoApplicationService;
import org.evan.springcloud.base.demo.DemoReadService;
import org.evan.springcloud.base.demo.enums.PublishStatusEnum;
import org.evan.springcloud.base.demo.model.Demo;
import org.evan.springcloud.base.demo.model.DemoAddUpdateDTO;
import org.evan.springcloud.base.demo.model.DemoQueryDTO;
import org.evan.springcloud.base.demo.model.DemoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;

/**
 * @author Evan.Shen
 * @since 2019-08-01
 */
@RestController
@RequestMapping("demo")
@Slf4j
@Api(description = "Api示例")
public class DemoController {

    @Autowired
    private DemoApplicationService demoApplicationService;

    @Autowired
    private DemoReadService demoReadService;

//    @Autowired
//    private PubDataDictionaryManager pubDataDictionaryManager;

    @Autowired
    private Environment environment;

    @ApiOperation(value = "分页列表")
    @GetMapping("list")
    public RestResponse<ArrayList<Demo>> list(DemoQueryDTO demoQuery) {
        log.info("=====>>query: " + demoQuery);
        PageResult<DemoVO> page = demoReadService.query(demoQuery);
        return RestResponse.create(page);
    }

    @ApiOperation(value = "添加-参数为formdata格式", notes = "这是接口描述")
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    //@PostMapping(value = "add", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
//    @CsrfValidate
    //@OperationLog(bizType = BizTypeEnum.DEMO, operationType = OperationTypeEnum.ADD, objectIdParamKey = "id", objectIdFrom = OperationLogObjectIdFromEnum.RESULT, objectNameParamKey = "arg0.fieldText", template = "新数据：${arg0}")

    public RestResponse<Demo> add(DemoAddUpdateDTO demoAddUpdateParams) {
        log.info("=====>>" + demoAddUpdateParams);
        OperateResult<Demo> result = demoApplicationService.add(demoAddUpdateParams);
        return RestResponse.create(result);
    }

    @ApiOperation(value = "添加-参数为json格式", notes = "这是接口描述")
    @PostMapping(value = "add2", consumes = MediaType.APPLICATION_JSON_VALUE)
    //@PostMapping(value = "add", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
//    @CsrfValidate
    //@OperationLog(bizType = BizTypeEnum.DEMO, operationType = OperationTypeEnum.ADD, objectIdParamKey = "id", objectIdFrom = OperationLogObjectIdFromEnum.RESULT, objectNameParamKey = "arg0.fieldText", template = "新数据：${arg0}")
    public RestResponse<Demo> add2(@Valid @RequestBody @ApiParam(value = "添加的对象", required = true) DemoAddUpdateDTO demoAddUpdateParams) {
        log.info("=====>>" + demoAddUpdateParams);
        OperateResult<Demo> result = demoApplicationService.add(demoAddUpdateParams);
        return RestResponse.create(result);
    }

    @ApiOperation(value = "根据id获取单个")
    @GetMapping("load")
    public RestResponse<DemoVO> load(@RequestParam("id") @ApiParam(value = "Id", required = true) Long id) {
        DemoVO demo = demoReadService.getById(id);

        RestResponse restResponse = RestResponse.create();
        if (demo == null) {
            restResponse.setCode(OperateResultConstants.DATA_NOT_FIND);
        } else {
            restResponse.setData(demo);
        }
        return restResponse;
    }

//    @ApiOperation(value = "根据id获取单个-id在请求路径中")
//    @GetMapping("{id}")
//    public RestResponse<DemoVO> load2(@PathVariable("id") @ApiParam(value = "Id", required = true) Long id) {
//        DemoVO demo = demoReadService.getById(id);
//        return RestResponse.create(demo);
//    }

    @ApiOperation(value = "修改-参数为formdata")
    @PostMapping(value = "update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    //@OperationLog(bizType = BizTypeEnum.DEMO, operationType = OperationTypeEnum.MODIFY, objectIdParamKey = "arg0", objectNameParamKey = "arg1.fieldText", template = "新数据：${arg1}")
    public RestResponse update1(DemoAddUpdateDTO demoAddUpdateParams) {
        log.info("=====>>" + demoAddUpdateParams);
        OperateResult result = demoApplicationService.update(demoAddUpdateParams);
        return RestResponse.create(result);
    }

    @ApiOperation(value = "修改-参数为json")
    @PostMapping(value = "update2", consumes = MediaType.APPLICATION_JSON_VALUE)
    //@OperationLog(bizType = BizTypeEnum.DEMO, operationType = OperationTypeEnum.MODIFY, objectIdParamKey = "arg0.id", objectNameParamKey = "arg0.fieldText", template = "新数据：${arg0}")
    public RestResponse update2(@RequestBody DemoAddUpdateDTO demoAddUpdateParams) {
        log.info("=====>>" + demoAddUpdateParams);
        OperateResult result = demoApplicationService.update(demoAddUpdateParams);
        return RestResponse.create(result);
    }


    @ApiOperation(value = "删除-单个")
    @PostMapping(value = "delete")
    //@OperationLog(bizType = BizTypeEnum.DEMO, operationType = OperationTypeEnum.DELETE, objectIdParamKey = "arg0", template = "删除数据")
    public RestResponse delete(@RequestParam("id") @ApiParam(value = "Id", required = true) long id) {
        log.info("=======>>参数:" + id);
        demoApplicationService.remove(id);
        return RestResponse.create();
    }

    @ApiOperation(value = "删除-批量")
    @PostMapping("delete-batch")
//    @OperationLog(object = "示例", operation = "删除", objectIdParamKey = "arg0")
    public RestResponse deleteBatch(@RequestParam("ids") @ApiParam(name = "ids", value = "id数组", required = true, example = "1,4,5") Long[] demoIds) {
        log.info("=======>>参数:" + demoIds);
        demoApplicationService.removeBatch(demoIds);
        return RestResponse.create();
        // throw new ServiceException("删除出错了，测试一下业务异常");
    }

    /**
     * 状态变更
     */
    @ApiOperation(value = "状态变更-id在params中")
    @PostMapping("update-status")
    //@OperationLog(bizType = BizTypeEnum.DEMO, operationType = OperationTypeEnum.CHANGE_STATUS, objectIdParamKey = "arg0", objectStatusParamKey = "arg1", template = "状态变更")
    public RestResponse updateStatus(@RequestParam("id") @ApiParam(value = "Id", required = true) long demoId,
                                     @RequestParam("newStatus") @ApiParam(value = "变更后的状态", required = true, allowableValues = "1,2") int newStatusCode) {
        PublishStatusEnum newStatus = PublishStatusEnum.valueOf(newStatusCode);
        Assert.notNull(newStatus, "请求参数newStatus值[" + newStatusCode + "]不正确,正确的值为" + PublishStatusEnum.values());

        OperateResult result = demoApplicationService.updateStatus(demoId, newStatus);
        return RestResponse.create(result);
        // throw new RuntimeException();//测试一下系统异常
    }

    /**
     * 状态变更
     */
    @ApiOperation(value = "状态变更-id在请求query中(不建议)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Id", required = true, paramType = "query", type = "integer"),
            @ApiImplicitParam(name = "newStatus", value = "变更后的状态", required = true, paramType = "query", type = "integer", allowableValues = "1,2")
    })
    @PostMapping("update-status2")
//    @OperationLog(bizType = BizTypeEnum.DEMO, operationType = OperationTypeEnum.CHANGE_STATUS,
//            objectIdParamKey = "arg0", objectIdFrom = OperationLogObjectIdFromEnum.HTTP_REQUEST, objectStatusParamKey = "arg1", template = "状态变更")
    public RestResponse updateStatus2(HttpServletRequest request) {
        String demoIdStr = request.getParameter("id");
        String newStatusCodeStr = request.getParameter("newStatus");

        Assert.hasLength(demoIdStr, "demoId不能为空");
        Assert.hasLength(newStatusCodeStr, "newStatus不能为空");

        Long demoId = Long.valueOf(demoIdStr);
        Integer newStatusCode = Integer.valueOf(newStatusCodeStr);

        PublishStatusEnum newStatus = PublishStatusEnum.valueOf(newStatusCode);
        Assert.notNull(newStatus, "请求参数newStatus值[" + newStatusCode + "]不正确,正确的值为" + PublishStatusEnum.values());

        OperateResult result = demoApplicationService.updateStatus(demoId, newStatus);
        return RestResponse.create(result);
    }

    @ApiOperation(value = "状态变更-批量")
    @PostMapping("update-status-batch")
//    @OperationLog(object = "示例", operation = "状态变更", objectIdParamKey = "arg0", template = "新状态：${arg1}")
    public RestResponse updateStatusBatch(@RequestParam("ids") @ApiParam(value = "id数组", required = true, example = "1,4,5") Long[] demoIds,
                                          @RequestParam("newStatus") @ApiParam(value = "变更后的状态", required = true, allowableValues = "1,2") int newStatusCode) {
        PublishStatusEnum newStatus = PublishStatusEnum.valueOf(newStatusCode);
        demoApplicationService.updateStatusBatch(demoIds, newStatus);
        return RestResponse.create();
    }

    @ApiOperation(value = "校验fieldText是否不重复", notes = "返回true:不重复，false:重复")
    @ApiResponse(code = 200, message = "true:不重复，false:重复")
    @GetMapping(value = "fieldText-check")
    public RestResponse<Boolean> checkFieldText(
            @RequestParam(value = "id", required = false) @ApiParam(value = "id为空表示新增时校验，否则表示修改时校验") Long id,
            @RequestParam("fieldText") @ApiParam(value = "验证的文本", required = true) String fieldText) {
        boolean notExists = demoReadService.notExists(id, fieldText);
        RestResponse restResponse = RestResponse.create(notExists);
        return restResponse;
    }

    @ApiIgnore
    @GetMapping("testConfig/{configName}")
    public String testConfig(@PathVariable("configName") String configName) {
        return environment.getProperty(configName, "undefinded");
    }

//    @ApiOperation(value = "左边三级树示例")
//    @GetMapping(value = "root")
//    public RestResponse getGroupTree(String parentValue) {
//        PubDataDictionaryQuery pubDataDictionary = new PubDataDictionaryQuery();
//        pubDataDictionary.setParentValue(parentValue);
//        List<PubDataDictionary> list = pubDataDictionaryManager.queryList(pubDataDictionary);
//        pubDataDictionary.setParentValue("cardType");
//        List<PubDataDictionary> cardTypeList = pubDataDictionaryManager.queryList(pubDataDictionary);
//
//        List<MenuTreeNodeDTO> nodes = new ArrayList<>();
//        for (PubDataDictionary pub : list) {
//            MenuTreeNodeDTO node = new MenuTreeNodeDTO();
//            node.setId(pub.getDictValue());
//            node.setName(pub.getDictText());
//            node.setpId(pub.getParentValue());
//            if ("root".equals(parentValue)) {
//                node.setIsParent(1);
//            } else {
//                node.setIsParent(0);
//            }
//            nodes.add(node);
//        }
//        return RestResponse.create(nodes);
//    }
//
//    @ApiOperation(value = "参数是key-value对")
//    @PostMapping(value = "kv-params")
//    public RestResponse testMap(@RequestBody Map<String, Object> map) {
//        RestResponse response = RestResponse.create();
//        response.setData(map);
//        return response;
//    }
//
//    /**
//     * http://localhost:8021/demo/export-excel
//     *
//     * @param request
//     * @param response
//     * @return
//     * @throws IOException
//     */
//    @ApiOperation(value = "导出excel")
//    @GetMapping(value = "export-excel")
//    public RestResponse testExportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("multipart/form-data");
//        response.setCharacterEncoding("utf-8");
//// UserInfo处有空格 导致后缀出错
//        String fileName = new String(("UserInfo" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
//                .getBytes(), "UTF-8");
//        response.setHeader("file-name", fileName + ".xlsx");
//        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xls");
//
//        ServletOutputStream out = response.getOutputStream();
//
//        String path = "templates" + File.separator + "库存月报表-汤总整理.xlsx";
//
//        Map<String, Object> data = new HashMap<String, Object>();
//        data.put("title", "供应商");
//        data.put("date", "2019年1月1日");
//
//        List<Map<String, Object>> maps = createMaps();
//        data.put("maplist", maps);
//        TemplateExportParams params = new TemplateExportParams(path, 0, 1);
//        Workbook workbook = ExcelExportUtil.exportExcel(params, data);
//        workbook.write(out);
//
//        out.flush();
//
//        return RestResponse.create();
//    }
//
//    private List<Map<String, Object>> createMaps() {
//        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
//        for (int i = 0; i < 4; i++) {
//            Map<String, Object> lm = new HashMap<String, Object>();
//            lm.put("name", "张三" + i);
//            lm.put("specificationName", (BigDecimal.valueOf(i * 10000.01)));
//            lm.put("bianma", "A001");
//            lm.put("mingcheng", "设计");
//            lm.put("xiangmumingcheng", "EasyPoi " + i + "期");
//            lm.put("quancheng", "开源项目");
//            lm.put("sqje", i * 10000 + "");
//            lm.put("remark", i * 10000 + "");
//
//            listMap.add(lm);
//        }
//        return listMap;
//    }


}
