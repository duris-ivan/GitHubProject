package test.co.instea;

import main.co.instea.CommandExecution;
import main.co.instea.Settings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandExecutionTest {

    @Test
    public void shouldParseValidSetInputCommand() {
        Settings settings = CommandExecution.setMethod(new String[] {"set", "-r", "file"});
        assertEquals(settings.getInputType(), "file");
    }

    @Test
    public void shouldParseValidSetOutputCommand() {
        Settings settings = CommandExecution.setMethod(new String[] {"set", "-w", "console"});
        assertEquals(settings.getOutputType(), "console");
    }

    @Test
    public void shouldParseValidSetInputAndOutputCommand() {
        Settings settings = CommandExecution.setMethod(new String[] {"set", "-r", "file", "-w", "console"});
        assertEquals(settings.getOutputType(), "console");
        assertEquals(settings.getInputType(), "file");
    }

    @Test
    public void shouldFailForMissingValue() {
        Settings settings = CommandExecution.setMethod(new String[] {"set", "-r"});
        assertNull(settings);
    }

    @Test
    public void shouldFailForNotAllowedSwitch() {
        Settings settings = CommandExecution.setMethod(new String[] {"set", "-a", "file"});
        assertNull(settings);
    }

    @Test
    public void shouldFailForNotAllowedSwitchAfterValidCommand() {
        Settings settings = CommandExecution.setMethod(new String[] {"set", "-r", "file", "-w", "console", "-a", "api"});
        assertNull(settings);
    }

    @Test
    public void shouldFailForNotAllowedValue() {
        Settings settings = CommandExecution.setMethod(new String[] {"set", "-r", "api"});
        assertNull(settings);
    }

    @Test
    public void shouldFailForNotAllowedValueAfterValidSwitch() {
        Settings settings = CommandExecution.setMethod(new String[] {"set", "-r", "console","-w","api"});
        assertNull(settings);
    }

    @Test
    public void shouldFailForMissingSwitch() {
        Settings settings = CommandExecution.setMethod(new String[] {"set"});
        assertNull(settings);
    }

}