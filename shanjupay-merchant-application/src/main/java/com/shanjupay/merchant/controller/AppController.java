package com.shanjupay.merchant.controller;

import com.shanjupay.merchant.api.AppService;
import com.shanjupay.merchant.api.dto.AppDTO;
import com.shanjupay.merchant.common.util.SecurityUtil;
import com.shanjupay.transaction.api.PayChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/

@Api(value = "商户平台-应用管理", tags = "商户平台-应用相关", description = "商户平台-应用相关")
@RestController
public class AppController {
    // 商户平台应用创建应用接口

    @Reference
    AppService appService;

    @ApiOperation("商户创建应用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "app", value = "应用信息", required = true, dataType = "AppDTO", paramType = "body")})
    @PostMapping(value = "/my/apps")
    public AppDTO createApp(@RequestBody AppDTO app){
        //得到商户id
        Long merchantId = SecurityUtil.getMerchantId();

       return  appService.createApp(merchantId,app);
    }

    @ApiOperation("查询商户下的应用列表")
    @GetMapping(value = "/my/apps")
    public List<AppDTO> queryMyApps() {
        //商户id
        Long merchantId = SecurityUtil.getMerchantId();
        return appService.queryAppByMerchant(merchantId);
    }
    @ApiOperation("根据应用id查询应用信息")
    @ApiImplicitParam(value = "应用id",name = "appId",dataType = "String",paramType = "path")
    @GetMapping(value = "/my/apps/{appId}")
    public AppDTO getApp(@PathVariable("appId") String appId){
        return appService.getAppById(appId);
    }

    @Reference
    PayChannelService payChannelService;
    /*
    * //商户平台应用绑定服务类型
    * 请求交易服务为指定应用添加服务类型
    * */
    @ApiOperation("绑定服务类型")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "应用id", name = "appId", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(value = "服务类型code", name = "platformChannelCodes", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping(value = "/my/apps/{appId}/platform-channels")
    void bindPlatformForApp(@PathVariable("appId") String appId, @RequestParam("platformChannelCodes") String platformChannelCodes) {
        payChannelService.bindPlatformChannelForApp(appId, platformChannelCodes);
    }
    /*
    * 查询应用是否已经绑定了某个服务类型
    * */

    @ApiOperation("查询应用是否绑定了某个服务类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "应用appId", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "platformChannel", value = "服务类型", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("/my/merchants/apps/platformchannels")
    public int queryAppBindPlatformChannel(@RequestParam String appId, @RequestParam String platformChannel) {
        return payChannelService.queryAppBindPlatformChannel(appId, platformChannel);
    }



}
