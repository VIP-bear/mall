# 掏包网服务端

## 登录
- 使用邮箱或者用户名登陆
- 忘记密码，可通过用户绑定的邮箱获取验证码找回密码(设置新密码)，验证码有效时间为5分钟
## 注册
- 用户密码使用[Spring Security加密](https://blog.csdn.net/pyycsd/article/details/102803132?utm_medium=distribute.pc_relevant.none-task-blog-title-6&spm=1001.2101.3001.4242)
- 只能使用用户名注册，用户名唯一，注册后可以绑定邮箱（用于找回密码）
## 商家注册
- 填写商家信息表单，验证商家是否可以发布商品
## 用户进入首页
- 按商品名称模糊搜索
- 按类别搜索