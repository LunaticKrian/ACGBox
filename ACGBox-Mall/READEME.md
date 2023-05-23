# 商城模块

## 技术:

- 前端：Vue + Element
- 后端：SpringBoot + MySQL

后端使用renren-fast模板工程，前端使用renren-vue-fast

```shell
npm install -g cnpm --registry=https://registry.npm.taobao.org
```

```shell
cnpm install
```

```shell
npm run dev
```

解决异常问题：

```shell
npm install --save qs    
```

## 模块划分：

- 商品模块（mall-product）
- 订单模块（mall-order)
- 会员模块（mall-member)
- 库存模块（mall-ware)
- 活动模块（mall-coupon）

```xml
<!-- 聚合工程 -->
<modules>
    <module>mall-product</module>
    <module>mall-order</module>
    <module>mall-ware</module>
    <module>mall-coupon</module>
    <module>mall-member</module>
</modules>
```

