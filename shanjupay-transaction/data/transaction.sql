USE shanjupay_transaction;

LOCK TABLES `platform_channel` WRITE;
/*!40000 ALTER TABLE `platform_channel` DISABLE KEYS */;

INSERT INTO `platform_channel` ( `ID`, `CHANNEL_NAME`, `CHANNEL_CODE` )
VALUES
    ( 1, '闪聚B扫C', 'shanju_b2c' ),
    ( 2, '闪聚C扫B', 'shanju_c2b' ),
    ( 3, '微信Native支付', 'wx_native' ),
    ( 4, '支付宝手机网站支付', 'alipay_wap' );

/*!40000 ALTER TABLE `platform_channel` ENABLE KEYS */;
UNLOCK TABLES;
LOCK TABLES `pay_channel` WRITE;
/*!40000 ALTER TABLE `pay_channel` DISABLE KEYS */;

INSERT INTO `pay_channel` ( `ID`, `CHANNEL_NAME`, `CHANNEL_CODE` )
VALUES
    ( 1, '微信JSAPI', 'WX_JSAPI' ),
    ( 2, '支付宝手机网站支付', 'ALIPAY_WAP' ),
    ( 3, '支付宝条码支付', 'ALIPAY_BAR_CODE' ),
    ( 4, '微信付款码支付', 'WX_MICROPAY' ),
    ( 5, '微信native支付', 'WX_NATIVE' );

/*!40000 ALTER TABLE `pay_channel` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `platform_pay_channel` WRITE;
/*!40000 ALTER TABLE `platform_pay_channel` DISABLE KEYS */;

INSERT INTO `platform_pay_channel` ( `ID`, `PLATFORM_CHANNEL`, `PAY_CHANNEL` )
VALUES
    ( 1, 'shanju_b2c', 'WX_MICROPAY' ),
    ( 2, 'shanju_b2c', 'ALIPAY_BAR_CODE' ),
    ( 3, 'wx_native', 'WX_NATIVE' ),
    ( 4, 'alipay_wap', 'ALIPAY_WAP' ),
    ( 5, 'shanju_c2b', 'WX_JSAPI' ),
    ( 6, 'shanju_c2b', 'ALIPAY_WAP' );

/*!40000 ALTER TABLE `platform_pay_channel` ENABLE KEYS */;
UNLOCK TABLES;

SELECT
    *
FROM
    platform_pay_channel ppc,
    pay_channel pc,
    platform_channel pla
WHERE ppc.PAY_CHANNEL = pc.CHANNEL_CODE
  AND ppc.platform_channel = pla.channel_code
  AND pla.channel_code = "shanju_c2b";

