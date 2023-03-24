package com.coffee.coffeeclouddisk;

import com.coffee.coffeeclouddisk.entity.DirectoryMeta;
import com.coffee.coffeeclouddisk.util.KryoUtil;
import com.coffee.coffeeclouddisk.util.MinioUtil;
import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import com.esotericsoftware.kryo.kryo5.util.Pool;
import io.minio.MinioClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/21 20:32
 */
public class KryoTest {

    //MinioClient minioClient = MinioUtil.getMinioClient();

    @Test
    public void testKryo() throws FileNotFoundException {
        //获取池与对象
        Pool<Kryo> kryoPool = KryoUtil.getKryoPool();
        Pool<Output> outputPool = KryoUtil.getOutputPool();
        Pool<Input> inputPool = KryoUtil.getInputPool();
        Kryo kryo = kryoPool.obtain();
        Output output = outputPool.obtain();
        Input input = inputPool.obtain();

        Date date = new Date();
        HashMap<String, Number> childrenDir = new HashMap<>();
        childrenDir.put("dirName", 1L);
        HashMap<String, Number> childrenFile = new HashMap<>();
        childrenFile.put("fileName", 1L);
        DirectoryMeta directoryMeta = new DirectoryMeta(100L, 1L, "456", date, 1L, childrenDir, childrenFile);

        //注册
        kryo.register(DirectoryMeta.class);
        kryo.register(Date.class);
        kryo.register(HashMap.class);
        output.setOutputStream(new FileOutputStream("file.bin"));
        input.setInputStream(new FileInputStream("file.bin"));

        //序列化
        kryo.writeObject(output, directoryMeta);
        output.close();

        //反序列化
        DirectoryMeta directoryMeta1 = kryo.readObject(input, DirectoryMeta.class);
        input.close();

        //关闭
        kryoPool.free(kryo);
        outputPool.free(output);
        inputPool.free(input);

        System.out.println(directoryMeta.toString());
        System.out.println(directoryMeta1.toString());
    }


}
