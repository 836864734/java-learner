### 原型模式

#### 概念
用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。

#### 优点
* 性能优良。原型模式是在内存二进制流的拷贝，要比直接new一个对象性能好很多，特别是要在一个循环体内产生大量的对象时，原型模式可以更好地体现其有点。
* 逃避构造函数的约束。这既是它的优点也是缺点，直接在内存中拷贝，构造函数时不会执行的。有点就是减少了约束，缺点也是减少了约束。

#### 使用场景
* 资源优化场景。类初始化需要消耗非常多的资源，这个资源包括数据、硬件资源等。
* 性能和安全要求的场景。通过new产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式。
* 一个对象或多个修改者的场景。 一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。

#### 深拷贝和浅拷贝 
Object类提供的方法clone只是拷贝本对象，其对象内部的数组、引用等对象都不拷贝，还是指向原生对象的内部元素地址，这种拷贝就叫做浅拷贝。确实是非常浅，两个对象共享了一个私有变量，你改我改大家都能改，时一种非常不安全的方式，在实际项目中使用还是比较少的（当然，这也是一种”危机“环境的救命方式）。你可能会比较奇怪，为什么在Mail哪个类中就可以使用String类型，而不会产生由浅拷贝带来的问题呢？内部的数组和引用对象才不拷贝，其他的原始类型比如int、long、char等都会被拷贝，但是对于String类型，Java就希望你把它认为时基本类型，它时没有clone方法的，处理机制也比较特殊，通过字符串池（stringpool）在需要的时候 

既然浅拷贝是有风险的，那怎么才能深入地拷贝呢？我们可以对私有的类变量进行独立的拷贝。详情见代码部分。 

#### 注意事项
* 使用原型模式时，引用的成员变量必须满足两个条件才不会被拷贝：一时类的成员变量，而不是方法内变量；二是必须是一个可变的引用对象，而不是一个原始类型或不可变对象(final)。
* 深拷贝和浅拷贝建议不要混合使用，特别是在涉及类的继承时，父类由多个引用的情况就非常复杂，建议的方案是深拷贝和浅拷贝分开实现。
* 要使用clone方法，类的成员变量上不要增加final关键字。

#### 最佳实践
在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过clone的方法创建一个对象，然后由工厂方法提供给调用者。原型模式已经与Java融为一体，大家可以随手拿来使用。
