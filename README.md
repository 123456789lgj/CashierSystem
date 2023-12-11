# CashierSystem
一个简单的收银系统



配置好SSH秘钥
https://www.cnblogs.com/aaronthon/p/15468405.html
ssh-keygen -t rsa -C "这里换上你的邮箱"  一路回车，配置秘钥成功之后，上传公钥到GitHub的Settings里面
此时还是push 不成功


ssh -T git@github.com  可以使用该命令检查可以是否push成功
Hi aaro***! You've successfully authenticated, but GitHub does not provide shell access.
具体配置可参考链接：https://blog.csdn.net/weixin_44639164/article/details/128921508
具体命令如下：
git remote set-url origin git@github.com:123456789lgj/CashierSystem.git