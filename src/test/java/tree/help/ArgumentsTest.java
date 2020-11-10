package tree.help;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArgumentsTest {

    @Test
    void getArgs() {
        Assertions.assertEquals("-a", Arguments.ALL_FILES.getArgs());
        Assertions.assertEquals("-d", Arguments.DIRECTORIES.getArgs());
        Assertions.assertNotEquals("-p", Arguments.ALL_FILES.getArgs());
        Assertions.assertNotEquals("-l", Arguments.DIRECTORIES.getArgs());
    }
}