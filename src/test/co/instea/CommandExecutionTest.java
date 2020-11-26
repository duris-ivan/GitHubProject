package test.co.instea;

import main.co.instea.CommandExecution;
import main.co.instea.Settings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandExecutionTest {

    @Test
    public void shouldParseValidSetInputCommand() {
        try {
            Settings settings = CommandExecution.setMethod(new String[] {"set", "-r", "file"});
            assertEquals(settings.getInputType(), "file");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldParseValidSetOutputCommand() {
        try {
            Settings settings = CommandExecution.setMethod(new String[] {"set", "-w", "console"});
            assertEquals(settings.getOutputType(), "console");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldParseValidSetInputAndOutputCommand() {
        try {
            Settings settings = CommandExecution.setMethod(new String[] {"set", "-r", "file", "-w", "console"});
            assertEquals(settings.getOutputType(), "console");
            assertEquals(settings.getInputType(), "file");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldFailForMissingValue() {
        try {
            Settings settings = CommandExecution.setMethod(new String[] {"set", "-r"});
            assertNull(settings);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldFailForNotAllowedSwitch() {
        try {
            Settings settings = CommandExecution.setMethod(new String[] {"set", "-a", "file"});
            assertNull(settings);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldFailForNotAllowedSwitchAfterValidCommand() {
        try {
            Settings settings = CommandExecution.setMethod(new String[] {"set", "-r", "file", "-w", "console", "-a", "api"});
            assertNull(settings);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldFailForNotAllowedValue() {
        try {
            Settings settings = CommandExecution.setMethod(new String[] {"set", "-r", "api"});
            assertNull(settings);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldFailForNotAllowedValueAfterValidSwitch() {
        try {
            Settings settings = CommandExecution.setMethod(new String[] {"set", "-r", "console","-w","api"});
            assertNull(settings);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldFailForMissingSwitch() {
        try {
            Settings settings = CommandExecution.setMethod(new String[] {"set"});
            assertNull(settings);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}