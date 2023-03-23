package com.coffee.coffeeclouddisk.util;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import com.esotericsoftware.kryo.kryo5.util.Pool;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/21 20:17
 */
public class KryoUtil {

    /**
     * Kryo连接池的最大容量，未实装
     */
    @Value("${kryoInstancePoolCapacity}")
    public static int kryoPoolCapacity;
    @Value("${kryoOutputPoolCapacity}")
    public static int kryoOutputPoolCapacity;
    @Value("${kryoInputPoolCapacity}")
    public static int kryoInputPoolCapacity;
    /**
     * Kryo连接池
     */
    public static Pool<Kryo> kryoPool = new Pool<Kryo>(true,false) {
        @Override
        protected Kryo create() {
            return new Kryo();
        }
    };

    public static Pool<Output> outputPool = new Pool<Output>(true,false) {
        @Override
        protected Output create() {
            return new Output(1024,-1);
        }
    };

    public static Pool<Input> inputPool = new Pool<Input>(true,false) {
        @Override
        protected Input create() {
            return new Input(1024);
        }
    };

    public static Pool<Kryo> getKryoPool(){
        return kryoPool;
    }
    public static Pool<Output> getOutputPool(){
        return outputPool;
    }
    public static Pool<Input> getInputPool(){
        return inputPool;
    }
}
