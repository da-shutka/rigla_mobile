package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class TestData {

    public static String getTestData(String product) {
        ClassLoader classLoader = TestData.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("data/test.data")).getFile());

        Properties testData = new Properties();
        try {
            testData.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return testData.getProperty(product);
    }
}
