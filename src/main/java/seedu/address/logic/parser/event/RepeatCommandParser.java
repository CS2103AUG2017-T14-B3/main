//@@author shuangyang
package seedu.address.logic.parser.event;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.event.EditEventCommand;
import seedu.address.logic.commands.event.RepeatCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new RepeatCommand object
 */
public class RepeatCommandParser implements Parser<RepeatCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the RepeatCommand
     * and returns a RepeatCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public RepeatCommand parse(String args) throws ParseException {
        requireNonNull(args);
        String trimmedArgs = args.trim();
        String[] tokens = trimmedArgs.split("\\s+");

        Index index;
        int period;

        try {
            index = ParserUtil.parseIndex(tokens[0]);
            period = ParserUtil.parsePeriod(tokens[1]);
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditEventCommand.MESSAGE_USAGE));
        }

        return new RepeatCommand(index, period);
    }
}
