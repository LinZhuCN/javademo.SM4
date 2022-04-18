# ObjectScript集成Java版国密算法SM4示例
这是一段示例程序，并不适合直接用于生产环境。  
另外，SM4中包含ECB与CBC两种模式，本例只使用了ECB模式，而生产环境推荐使用CBC模式。  
ECB模式与CBC模式的差别可参考本例依赖的SM4开源实现：https://github.com/xjfuuu/SM2_SM3_SM4Encrypt   
如使用CBC模式，本例中的代码也需要进行若干修改。

## ObjectScript代码
见/IRISCode/JavaDemo.xml，需导入IRIS中Build后使用

## Log4J配置
在类路径下配置log4j2.xml，在/src/main/java下有示例。    
目前的配置是Java程序的执行路径下/log中输出SM4.log。  
因此，在被IRIS调用执行时，日志文件将在 [IRIS安装路径]/mgr/[命名空间] 或 







