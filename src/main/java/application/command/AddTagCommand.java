package application.command;

import application.exception.InvalidArgumentException;
import application.exception.MissingArgumentException;
import application.parser.ArgumentParser;
import application.review.Review;
import application.review.ReviewList;
import application.review.Tag;
import application.storage.Storage;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class AddTagCommand extends Command {
    public static final Set<String> DELIMITERS = Set.of("/default", "/tag");
    private final Map<String, String> commandArgs;

    /**
     * Constructor for AddReviewCommand class.
     *
     * @param commandArgs the arguments of the command
     */
    public AddTagCommand(Map<String, String> commandArgs) {
        this.commandArgs = commandArgs;
    }


    /**
     * Executes the command to add a tag to a review.
     * @param reviewList the list of reviews
     * @param storage the storage object
     * @return a string representation of the command result
     * @throws MissingArgumentException if any argument is missing
     * @throws InvalidArgumentException if any argument is in the wrong format
     */
    @Override
    public String execute(
            ReviewList reviewList,
            Storage storage
    ) throws MissingArgumentException, InvalidArgumentException {
        String indexAsString = commandArgs.get("/default");
        String tagsAsString = commandArgs.get("/tag");

        int index = ArgumentParser.toInt(indexAsString);
        Set<Tag> tags = ArgumentParser.toTags(tagsAsString);

        if (tags.isEmpty()) {
            throw new InvalidArgumentException("No tags provided!");
        }

        Review review = reviewList.addTagToReview(index, tags);

        return String.format("Updated review with new tags:\n%s", review);
    }
}
