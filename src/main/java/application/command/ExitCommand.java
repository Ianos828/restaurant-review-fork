package application.command;

import application.auth.AuthManager;
import application.review.ReviewList;
import application.storage.Storage;

/**
 * Class representing a command to exit the program.
 */
public class ExitCommand extends Command {
    @Override
    public boolean isTerminatingCommand() {
        return true;
    }

    /**
     * Returns a {@code CommandResult} object indicating that the program has exited.
     *
     * @param reviews the list of reviews
     * @param storage the storage object
     * @param manager the authentication manager
     * @return a {@code CommandResult} object containing the result of the command execution
     */
    @Override
    public CommandResult execute(
            ReviewList reviews,
            Storage storage,
            AuthManager manager
    ) {
        return new CommandResult(
                "Goodbye!",
                isTerminatingCommand(),
                reviews
        );
    }
}
