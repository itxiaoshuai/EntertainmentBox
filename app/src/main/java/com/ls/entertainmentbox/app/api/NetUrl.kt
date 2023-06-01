package com.ls.entertainmentbox.app.api

import rxhttp.wrapper.annotation.DefaultDomain

object NetUrl {

    // 服务器请求成功的 Code值
    const val SUCCESS_CODE = 200

    @DefaultDomain //设置为默认域名
    const val DEV_URL = "https://api.pingcc.cn/"

    //登录
    const val LOGIN = "user/login"

    //获取首页列表数据
    const val HOME_LIST = "https://api.pingcc.cn/video/search/title/复仇者联盟/1/10"

    //获取电影详情
    const val MOVIE_DETAIL = "videoChapter/search/"

    //提现记录
    const val URL_WITHDRAW_LIST = "/ums/api/member/withdraw/list"

    //获取团队列表
    const val TEAM_LIST = "/ums/api/member/memberTeamInfo"

    //用户信息
    const val USER_INFO = "/ums/api/member/getUserInfo"

    //问题反馈 提交反馈 类型
    const val BACK_TYPE = "/shop/api/question/category/list"

    //问题反馈提交
    const val QUESTION_SAVE = "/shop/api/question/save"

    //问题反馈历史
    const val QUESTION_HISTORY = "/shop/api/question/old/list"

    //订单列表
    const val URL_ORDER_LIST = "/shop/api/order/list"

    //冻结订单
    const val URL_ORDER_LIST_FROZEN = "/hz/api/frozen/order/list"

    //冻结订单出售
    const val URL_ORDER_FROZEN_SELL = "/hz/api/receive/static"

    //商品收藏
    const val URL_COLLECTION = "/ums/api/member/collection/list"

    //收货地址
    const val ADDRESS_LIST = "/ums/api/member/address/list"

    //积分明细
    const val POINT_BREAKDOWN_LIST = "/hz/api/userWalletDetailList"

    //抢拍中心
    const val SNAPSHOT = "/hz/api/getUserInfo"

    //抢拍订单
    const val SNAPSHOT_ORDER_BUY = "/hz/api/investment/list"

    //抢拍订单
    const val SNAPSHOT_ORDER_SELL = "/hz/api/receive/list"

    //抽奖
    const val SNAPSHOT_LUCK_DRAW = "/hz/api/investment/order/luckdraw"

    //商品列表
    const val URL_PRODUCTIVE_LIST = "/shop/api/hz/product/list"

    //登入
    const val URL_LOGIN = "/ums/api/login"

    //注册
    const val URL_REGISTER = "/ums/api/register"

    //获取验证码
    const val URL_MES_CODE = "/ums/api/sms/getCheckCode"

    //收藏
    const val URL_COLLECT = "/ums/api/member/collection/add"

    //取消收藏
    const val URL_CANCEL_COLLECT = "/ums/api/member/collection/deleteByIds"


    //通宝转账
    const val URL_TRANSFER_TB = "/hz/api/member/schedulecoin/transfer"

    //通证转账
    const val URL_TRANSFER_TZ = "/hz/api/member/integral/transfer"

    //众筹
    const val URL_DYNAMIC = "/hz/api/receive/dynamic"

    //买入记录详情接口
    const val URL_INVESTMENT_DETAILS = "/hz/api/investment/match/details"

    //卖记录详情接口
    const val URL_RECEIVE_DETAILS = "/hz/api/receive/match/details"

    //财富 卖家确认打款
    const val URL_INVESTMENT_CONFIRM = "/hz/api/investment/confirm"

    //流水记录通宝
    const val URL_TRANSFER_RECORD_TB = "/hz/api/member/schedulecoin/list"

    //流水记录通证
    const val URL_TRANSFER_RECORD_TZ = "/hz/api/member/integral/list"

    //奖金钱包
    const val URL_WALLET_BONUS = "/hz/api/memberDynamicAward"

    //修改登录密码
    const val URL_UPDATE_PASSWORD = "/ums/api/member/updatePassword"

    //修改交易密码
    const val URL_UPDATE_PAY_PASSWORD = "/ums/api/member/setPayPassword"

    //分享码
    const val URL_SHARE_CODE = "/ums/api/member/getShareCode"

    //激活账户
    const val URL_ACTIVATE_ACCOUNT = "/hz/api/member/activate"

    //首页数据
    const val URL_HOME = "/shop/api/home"

    //商品详情
    const val URL_PRODUCT_DETAIL = "/shop/api/product/detail"

    //商品详情
    const val URL_COMMENT_COUNT = "/pms/api/comment/commentCount"

    //商品详情购买（radio）
    const val URL_INVESTMENT_RADIO = "/hz/api/investment"


    //绑定银行卡信息
    const val URL_BANK_INFO = "/ums/api/member/getBank"

    //提现初始化信息
    const val URL_GET_WITH_DRAW_INFO = "/hz/api/xkkx/getWithdrawInfo"

    //提现
    const val URL_WITHDRAW = "/ums/api/member/withdraw"

    //提现
    const val URL_WITHDRAW_RECORD = "/ums/api/member/withdraw/list"

    //开通通证收款
    const val URL_BIND_BANK_STATUS = "/ums/api/member/bindBank/status"

    //绑定银行卡
    const val URL_BIND_BANK = "/ums/api/member/hzbindBank"

    //抢拍详情列表
    const val URL_INVESTMENT_LIST = "/hz/api/investment/match/list"

    //拍卖子订单
    const val URL_RECEIVE_LIST = "/hz/api/receive/match/list"

    //添加收货地址
    const val URL_ADDRESS_ADD = "/ums/api/member/address/add"

    //更新收货地址
    const val URL_ADDRESS_UPDATE = "/ums/api/member/address/update"

    //删除地址
    const val URL_ADDRESS_DELETE = "/ums/api/member/address/delete"
}