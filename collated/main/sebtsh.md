# sebtsh
###### \java\seedu\address\logic\commands\AddCommand.java
``` java
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS "
            + "[" + PREFIX_COMPANY + "COMPANY] "
            + "[" + PREFIX_POSITION + "POSITION] "
            + "[" + PREFIX_STATUS + "STATUS] "
            + "[" + PREFIX_PRIORITY + "PRIORITY] "
            + "[" + PREFIX_PHOTO + "PHOTO] "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
            + PREFIX_COMPANY + "Microsoft "
            + PREFIX_POSITION + "Manager "
            + PREFIX_STATUS + "Requires immediate follow up "
            + PREFIX_PRIORITY + "H "
            + PREFIX_PHOTO + "file:///~/Images/image.jpg "
            + PREFIX_TAG + "friends "
            + PREFIX_TAG + "owesMoney";
```
###### \java\seedu\address\logic\commands\EditCommand.java
``` java
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the person identified "
            + "by the index number used in the last person listing. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_PHONE + "PHONE] "
            + "[" + PREFIX_EMAIL + "EMAIL] "
            + "[" + PREFIX_ADDRESS + "ADDRESS] "
            + "[" + PREFIX_COMPANY + "COMPANY] "
            + "[" + PREFIX_POSITION + "POSITION] "
            + "[" + PREFIX_STATUS + "STATUS] "
            + "[" + PREFIX_PRIORITY + "PRIORITY] "
            + "[" + PREFIX_NOTE + "NOTE] "
            + "[" + PREFIX_PHOTO + "PHOTO] "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_PHONE + "91234567 "
            + PREFIX_EMAIL + "johndoe@example.com";
```
###### \java\seedu\address\logic\commands\EditCommand.java
``` java
    /**
     * Creates and returns a {@code Person} with the details of {@code personToEdit}
     * edited with {@code editPersonDescriptor}.
     */
    private static Person createEditedPerson(ReadOnlyPerson personToEdit,
                                             EditPersonDescriptor editPersonDescriptor) {
        assert personToEdit != null;

        Name updatedName = editPersonDescriptor.getName().orElse(personToEdit.getName());
        Phone updatedPhone = editPersonDescriptor.getPhone().orElse(personToEdit.getPhone());
        Email updatedEmail = editPersonDescriptor.getEmail().orElse(personToEdit.getEmail());
        Address updatedAddress = editPersonDescriptor.getAddress().orElse(personToEdit.getAddress());
        Company updatedCompany = editPersonDescriptor.getCompany().orElse(personToEdit.getCompany());
        Position updatedPosition = editPersonDescriptor.getPosition().orElse(personToEdit.getPosition());
        Status updatedStatus = editPersonDescriptor.getStatus().orElse(personToEdit.getStatus());
        Priority updatedPriority = editPersonDescriptor.getPriority().orElse(personToEdit.getPriority());
        Note updatedNote = editPersonDescriptor.getNote().orElse(personToEdit.getNote());
        Photo updatedPhoto = editPersonDescriptor.getPhoto().orElse(personToEdit
                .getPhoto());
        Set<Tag> updatedTags = editPersonDescriptor.getTags().orElse(personToEdit.getTags());
        Set<Relationship> updatedRel = editPersonDescriptor.getRelation().orElse(personToEdit.getRelation());

        return new Person(updatedName, updatedPhone, updatedEmail, updatedAddress, updatedCompany,
                updatedPosition, updatedStatus, updatedPriority, updatedNote,
               updatedPhoto, updatedTags, updatedRel);
    }
```
###### \java\seedu\address\logic\commands\EditCommand.java
``` java
    /**
     * Stores the details to edit the person with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class EditPersonDescriptor {
        private Name name;
        private Phone phone;
        private Email email;
        private Address address;
        private Company company;
        private Position position;
        private Status status;
        private Priority priority;
        private Note note;
        private Photo photo;
        private Set<Tag> tags;
        private Set<Relationship> relation;

        public EditPersonDescriptor() {
        }

        public EditPersonDescriptor(EditPersonDescriptor toCopy) {
            this.name = toCopy.name;
            this.phone = toCopy.phone;
            this.email = toCopy.email;
            this.address = toCopy.address;
            this.company = toCopy.company;
            this.position = toCopy.position;
            this.status = toCopy.status;
            this.priority = toCopy.priority;
            this.note = toCopy.note;
            this.photo = toCopy.photo;
            this.tags = toCopy.tags;
            this.relation = toCopy.relation;
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(this.name, this.phone, this.email, this.address, this.company,
                    this.position, this.status, this.priority, this.note,
                    this.photo, this.tags, this.relation);
        }
```
###### \java\seedu\address\logic\commands\EditCommand.java
``` java
        public Optional<Company> getCompany() {
            return Optional.ofNullable(company);
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        public Optional<Position> getPosition() {
            return Optional.ofNullable(position);
        }

        public void setPosition(Position position) {
            this.position = position;
        }

        public Optional<Status> getStatus() {
            return Optional.ofNullable(status);
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public Optional<Priority> getPriority() {
            return Optional.ofNullable(priority);
        }

        public void setPriority(Priority priority) {
            this.priority = priority;
        }

        public Optional<Note> getNote() {
            return Optional.ofNullable(note);
        }

        public void setNote(Note note) {
            this.note = note;
        }
```
###### \java\seedu\address\logic\commands\EditCommand.java
``` java
        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditPersonDescriptor)) {
                return false;
            }

            // state check
            EditPersonDescriptor e = (EditPersonDescriptor) other;

            return getName().equals(e.getName())
                    && getPhone().equals(e.getPhone())
                    && getEmail().equals(e.getEmail())
                    && getAddress().equals(e.getAddress())
                    && getCompany().equals(e.getCompany())
                    && getPosition().equals(e.getPosition())
                    && getStatus().equals(e.getStatus())
                    && getPriority().equals(e.getPriority())
                    && getNote().equals(e.getNote())
                    && getPhoto().equals(e.getPhoto())
                    && getTags().equals(e.getTags());
        }
    }
}
```
###### \java\seedu\address\logic\parser\AddCommandParser.java
``` java
    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS,
                        PREFIX_COMPANY, PREFIX_POSITION, PREFIX_STATUS,
                        PREFIX_PRIORITY, PREFIX_NOTE, PREFIX_PHOTO,
                        PREFIX_TAG, PREFIX_ADD_RELATIONSHIP, PREFIX_CLEAR_RELATIONSHIP, PREFIX_DELETE_RELATIONSHIP);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE, PREFIX_EMAIL)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        try {
            Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME)).get();
            Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE)).get();
            Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL)).get();
            Address address = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS)).get();
            //Initialize company, position, status, and note to NIL, priority to L
            Company company = new Company("NIL");
            Position position = new Position("NIL");
            Status status = new Status("NIL");
            Priority priority = new Priority("L");
            Note note = new Note("NIL");
            Set<Relationship> relationList = new HashSet<>();
            //Initialize photo to the default icon
            String s = File.separator;
            Photo photo = new Photo("data" + s + "default.jpg");

            Set<Tag> tagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));

            //Since Company, Position, Status, Priority and Photo and Relationship are optional
            // parameters, set them if they are present
            if (arePrefixesPresent(argMultimap, PREFIX_COMPANY)) {
                company = ParserUtil.parseCompany(argMultimap.getValue(PREFIX_COMPANY)).get();
            }

            if (arePrefixesPresent(argMultimap, PREFIX_POSITION)) {
                position = ParserUtil.parsePosition(argMultimap.getValue(PREFIX_POSITION)).get();
            }

            if (arePrefixesPresent(argMultimap, PREFIX_STATUS)) {
                status = ParserUtil.parseStatus(argMultimap.getValue(PREFIX_STATUS)).get();
            }

            if (arePrefixesPresent(argMultimap, PREFIX_PRIORITY)) {
                priority = ParserUtil.parsePriority(argMultimap.getValue(PREFIX_PRIORITY)).get();
            }

            if (arePrefixesPresent(argMultimap, PREFIX_NOTE)) {
                note = ParserUtil.parseNote(argMultimap.getValue(PREFIX_NOTE)).get();
            }

            if (arePrefixesPresent(argMultimap, PREFIX_PHOTO)) {
                photo = ParserUtil.parsePhoto(argMultimap.getValue
                        (PREFIX_PHOTO)).get();
            }
            if (arePrefixesPresent(argMultimap, PREFIX_ADD_RELATIONSHIP) || arePrefixesPresent(argMultimap,
                PREFIX_DELETE_RELATIONSHIP) || arePrefixesPresent(argMultimap, PREFIX_CLEAR_RELATIONSHIP)) {
                throw new ParseException(Relationship.MESSAGE_REL_PREFIX_NOT_ALLOWED);
            }

            ReadOnlyPerson person = new Person(name, phone, email, address, company, position, status, priority,
                    note, photo, tagList, relationList);

            return new AddCommand(person);
        } catch (IllegalValueException ive) {
            throw new ParseException(ive.getMessage(), ive);
        }
    }
}
```
###### \java\seedu\address\logic\parser\CliSyntax.java
``` java
    public static final Prefix PREFIX_COMPANY = new Prefix("c/");
    public static final Prefix PREFIX_POSITION = new Prefix("po/");
    public static final Prefix PREFIX_STATUS = new Prefix("s/");
    public static final Prefix PREFIX_PRIORITY = new Prefix("pr/");
    public static final Prefix PREFIX_NOTE = new Prefix("no/");
```
###### \java\seedu\address\logic\parser\EditCommandParser.java
``` java
    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS,
                        PREFIX_COMPANY, PREFIX_POSITION, PREFIX_STATUS,
                        PREFIX_PRIORITY, PREFIX_NOTE, PREFIX_PHOTO,
                        PREFIX_TAG, PREFIX_ADD_RELATIONSHIP, PREFIX_CLEAR_RELATIONSHIP, PREFIX_DELETE_RELATIONSHIP);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE));
        }

        EditPersonDescriptor editPersonDescriptor = new EditPersonDescriptor();
        try {
            ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME)).ifPresent(editPersonDescriptor::setName);
            ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE)).ifPresent(editPersonDescriptor::setPhone);
            ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL)).ifPresent(editPersonDescriptor::setEmail);
            ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS)).ifPresent(editPersonDescriptor::setAddress);
            ParserUtil.parseCompany(argMultimap.getValue(PREFIX_COMPANY)).ifPresent(editPersonDescriptor::setCompany);
            ParserUtil.parsePosition(argMultimap.getValue(PREFIX_POSITION))
                    .ifPresent(editPersonDescriptor::setPosition);
            ParserUtil.parseStatus(argMultimap.getValue(PREFIX_STATUS)).ifPresent(editPersonDescriptor::setStatus);
            ParserUtil.parsePriority(argMultimap.getValue(PREFIX_PRIORITY))
                    .ifPresent(editPersonDescriptor::setPriority);
            ParserUtil.parseNote(argMultimap.getValue(PREFIX_NOTE)).ifPresent(editPersonDescriptor::setNote);
            ParserUtil.parsePhoto(argMultimap.getValue(PREFIX_PHOTO)).ifPresent(editPersonDescriptor::setPhoto);
            parseTagsForEdit(argMultimap.getAllValues(PREFIX_TAG)).ifPresent(editPersonDescriptor::setTags);
        } catch (IllegalValueException ive) {
            throw new ParseException(ive.getMessage(), ive);
        }

        if (!editPersonDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditCommand.MESSAGE_NOT_EDITED);
        }
        if (arePrefixesPresent(argMultimap, PREFIX_ADD_RELATIONSHIP) || arePrefixesPresent(argMultimap,
            PREFIX_DELETE_RELATIONSHIP) || arePrefixesPresent(argMultimap, PREFIX_CLEAR_RELATIONSHIP)) {
            throw new ParseException(Relationship.MESSAGE_REL_PREFIX_NOT_ALLOWED);
        }

        return new EditCommand(index, editPersonDescriptor);
    }
```
###### \java\seedu\address\logic\parser\ParserUtil.java
``` java
    /**
     * Parses a {@code Optional<String> company} into an {@code Optional<Company>} if {@code company} is present.
     * See header comment of this class regarding the use of {@code Optional} parameters.
     */
    public static Optional<Company> parseCompany(Optional<String> company) throws IllegalValueException {
        requireNonNull(company);
        return company.isPresent() ? Optional.of(new Company(company.get())) : Optional.empty();
    }

    /**
     * Parses a {@code Optional<String> position} into an {@code Optional<Position>} if {@code position} is present.
     * See header comment of this class regarding the use of {@code Optional} parameters.
     */
    public static Optional<Position> parsePosition(Optional<String> position) throws IllegalValueException {
        requireNonNull(position);
        return position.isPresent() ? Optional.of(new Position(position.get())) : Optional.empty();
    }

    /**
     * Parses a {@code Optional<String> status} into an {@code Optional<Status>} if {@code status} is present.
     * See header comment of this class regarding the use of {@code Optional} parameters.
     */
    public static Optional<Status> parseStatus(Optional<String> status) throws IllegalValueException {
        requireNonNull(status);
        return status.isPresent() ? Optional.of(new Status(status.get())) : Optional.empty();
    }

    /**
     * Parses a {@code Optional<String> priority} into an {@code Optional<Priority>} if {@code priority} is present.
     * See header comment of this class regarding the use of {@code Optional} parameters.
     */
    public static Optional<Priority> parsePriority(Optional<String> priority) throws IllegalValueException {
        requireNonNull(priority);
        return priority.isPresent() ? Optional.of(new Priority(priority.get())) : Optional.empty();
    }

    /**
     * Parses a {@code Optional<String> note} into an {@code Optional<Note>} if {@code note} is present.
     * See header comment of this class regarding the use of {@code Optional} parameters.
     */
    public static Optional<Note> parseNote(Optional<String> note) throws IllegalValueException {
        requireNonNull(note);
        return note.isPresent() ? Optional.of(new Note(note.get())) : Optional.empty();
    }

```
###### \java\seedu\address\model\AddressBook.java
``` java
    /**
     * Removes a tag from all persons in the list if they have it
     *
     * @param tag Tag to be removed
     */
    public void removeTagFromAll(Tag tag) {
        Iterator<Person> iter = persons.iterator();
        while (iter.hasNext()) {
            iter.next().removeTag(tag);
        }
        tags.remove(tag); //remove tag from Master Tag List
    }
```
###### \java\seedu\address\model\ModelManager.java
``` java
    /**
     * Removes specified tag from all the persons in the address book.
     *
     * @param tag Tag to be removed
     */
    public void removeTag(Tag tag) {
        addressBook.removeTagFromAll(tag);
        indicateAddressBookChanged();
    }
```
###### \java\seedu\address\model\person\Company.java
``` java
package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.util.Comparator;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's company in the address book.
 */

public class Company implements Comparator<Company> {
    public static final String MESSAGE_COMPANY_CONSTRAINTS =
            "Person company can take any values, and it should not be blank";

    /*
     * The first character of the company must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String COMPANY_VALIDATION_REGEX = "[^\\s].*";

    private static final String ORDERED_ENTRIES = "NIL";
    public final String value;

    /**
     * Validates given company.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Company(String company) throws IllegalValueException {
        requireNonNull(company);
        if (!isValidCompany(company)) {
            throw new IllegalValueException(MESSAGE_COMPANY_CONSTRAINTS);
        }
        this.value = company;
    }

    /**
     * Returns true if a given string is a valid company.
     */
    public static boolean isValidCompany(String test) {
        return test.matches(COMPANY_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Company // instanceof handles nulls
                && this.value.equals(((Company) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
```
###### \java\seedu\address\model\person\Note.java
``` java
package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's note in the address book. A note is any string that the user wishes to input about a person
 * but cannot be adequately represented in tags (e.g. sentences-long details). Note is the only Person field that cannot
 * be initialized in an add command, it needs to be added after the Person is added to the address field.
 */

public class Note {
    public static final String MESSAGE_NOTE_CONSTRAINTS =
            "Person note can take any values, and it should not be blank";

    /*
     * The first character of the note must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String NOTE_VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Validates given note.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Note(String note) throws IllegalValueException {
        requireNonNull(note);
        if (!isValidNote(note)) {
            throw new IllegalValueException(MESSAGE_NOTE_CONSTRAINTS);
        }
        this.value = note;
    }

    /**
     * Returns true if a given string is a valid note.
     */
    public static boolean isValidNote(String test) {
        return test.matches(NOTE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Note // instanceof handles nulls
                && this.value.equals(((Note) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
```
###### \java\seedu\address\model\person\Person.java
``` java
    private ObjectProperty<Company> company;
    private ObjectProperty<Position> position;
    private ObjectProperty<Status> status;
    private ObjectProperty<Priority> priority;
    private ObjectProperty<Note> note;
    private ObjectProperty<Photo> photo;
```
###### \java\seedu\address\model\person\Person.java
``` java
    /**
     * Constructor without optional fields. Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Set<Relationship> relation) {
        requireAllNonNull(name, phone, email, address, tags, relation);
        this.name = new SimpleObjectProperty<>(name);
        this.phone = new SimpleObjectProperty<>(phone);
        this.email = new SimpleObjectProperty<>(email);
        this.address = new SimpleObjectProperty<>(address);
        //if Person is called without Company, Position or Status
        // parameters, initialize them to "NIL".
        //if Person is called without Priority, initialize it to L. Note is initialized to "NIL" in all cases
        //as it is meant to be added after creating the person.
        //if Person is called without Photo, initialize it to the default photo.
        try {
            this.company = new SimpleObjectProperty<>(new Company("NIL"));
            this.position = new SimpleObjectProperty<>(new Position("NIL"));
            this.status = new SimpleObjectProperty<>(new Status("NIL"));
            this.priority = new SimpleObjectProperty<>(new Priority("L"));
            this.note = new SimpleObjectProperty<>(new Note("NIL"));
            this.relation = new SimpleObjectProperty<>(new UniqueRelList(new HashSet<>()));
            this.photo = new SimpleObjectProperty<>(new Photo("src/main/resources/images/default.jpg"));;
        } catch (IllegalValueException ive) {
            ive.printStackTrace();
        }

        // protect internal tags from changes in the arg list
        this.tags = new SimpleObjectProperty<>(new UniqueTagList(tags));
    }

    /**
     * Constructor including all optional fields except Note. Every field must be present and not null.
     *
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param company
     * @param position
     * @param status
     * @param priority
     * @param photo
     * @param tags
     * @param relation
     */
    public Person(Name name, Phone phone, Email email, Address address, Company company, Position position,
                  Status status, Priority priority, Photo photo, Set<Tag>
                          tags, Set<Relationship> relation) {
        requireAllNonNull(name, phone, email, address, company, position, status, priority, photo, tags, relation);
        this.name = new SimpleObjectProperty<>(name);
        this.phone = new SimpleObjectProperty<>(phone);
        this.email = new SimpleObjectProperty<>(email);
        this.address = new SimpleObjectProperty<>(address);
        this.company = new SimpleObjectProperty<>(company);
        this.position = new SimpleObjectProperty<>(position);
        this.status = new SimpleObjectProperty<>(status);
        this.priority = new SimpleObjectProperty<>(priority);
        this.photo = new SimpleObjectProperty<>(photo);
        //Note is initialized to "NIL" as it is meant to be added after creating the person.
        try {
            this.note = new SimpleObjectProperty<>(new Note("NIL"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // protect internal tags from changes in the arg list
        this.tags = new SimpleObjectProperty<>(new UniqueTagList(tags));

        // protect internal connections from changes in the arg list
        this.relation = new SimpleObjectProperty<>(new UniqueRelList(relation));
    }

    /**
     * Constructor including all fields. Every field must be present and not null.
     *
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param company
     * @param position
     * @param status
     * @param priority
     * @param note
     * @param tags
     * @param relation
     */
    public Person(Name name, Phone phone, Email email, Address address, Company company, Position position,
                  Status status, Priority priority, Note note, Photo
                          photo, Set<Tag> tags, Set<Relationship> relation) {
        requireAllNonNull(name, phone, email, address, company, position,
                status, priority, note, photo, tags, relation);
        this.name = new SimpleObjectProperty<>(name);
        this.phone = new SimpleObjectProperty<>(phone);
        this.email = new SimpleObjectProperty<>(email);
        this.address = new SimpleObjectProperty<>(address);
        this.company = new SimpleObjectProperty<>(company);
        this.position = new SimpleObjectProperty<>(position);
        this.status = new SimpleObjectProperty<>(status);
        this.priority = new SimpleObjectProperty<>(priority);
        this.note = new SimpleObjectProperty<>(note);
        this.photo = new SimpleObjectProperty<>(photo);

        // protect internal tags from changes in the arg list
        this.tags = new SimpleObjectProperty<>(new UniqueTagList(tags));
        // protect internal connections from changes in the arg list
        this.relation = new SimpleObjectProperty<>(new UniqueRelList(relation));
    }
```
###### \java\seedu\address\model\person\Person.java
``` java
    @Override
    public Company getCompany() {
        return company.get();
    }

    public void setCompany(Company company) {
        this.company.set(requireNonNull(company));
    }

    @Override
    public ObjectProperty<Company> companyProperty() {
        return company;
    }

    @Override
    public Position getPosition() {
        return position.get();
    }

    public void setPosition(Position position) {
        this.position.set(position);
    }

    public ObjectProperty<Position> positionProperty() {
        return position;
    }

    @Override
    public Status getStatus() {
        return status.get();
    }

    public void setStatus(Status status) {
        this.status.set(status);
    }

    @Override
    public ObjectProperty<Status> statusProperty() {
        return status;
    }

    @Override
    public Priority getPriority() {
        return priority.get();
    }

    public void setPriority(Priority priority) {
        this.priority.set(priority);
    }

    @Override
    public ObjectProperty<Priority> priorityProperty() {
        return priority;
    }

    @Override
    public Note getNote() {
        return note.get();
    }

    @Override
    public ObjectProperty<Note> noteProperty() {
        return note;
    }

    public void setNote(Note note) {
        this.note.set(note);
    }
```
###### \java\seedu\address\model\person\Person.java
``` java
    /**
     * Removes a tag from this person's list of tags if the list contains the tag.
     *
     * @param toRemove Tag to be removed
     */
    public void removeTag(Tag toRemove) {
        tags.get().remove(toRemove);
    }
```
###### \java\seedu\address\model\person\Position.java
``` java
package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.util.Comparator;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's position in the address book.
 */

public class Position implements Comparator<Position> {
    public static final String MESSAGE_POSITION_CONSTRAINTS =
            "Person position can take any values, and it should not be blank";

    /*
     * The first character of the position must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String POSITION_VALIDATION_REGEX = "[^\\s].*";

    private static final String ORDERED_ENTRIES = "NIL";
    public final String value;

    /**
     * Validates given position.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Position(String position) throws IllegalValueException {
        requireNonNull(position);
        if (!isValidPosition(position)) {
            throw new IllegalValueException(MESSAGE_POSITION_CONSTRAINTS);
        }
        this.value = position;
    }

    /**
     * Returns true if a given string is a valid position.
     */
    public static boolean isValidPosition(String test) {
        return test.matches(POSITION_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Position // instanceof handles nulls
                && this.value.equals(((Position) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
```
###### \java\seedu\address\model\person\Priority.java
``` java
package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.util.Comparator;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's priority in the address book.
 */

public class Priority implements Comparator<Priority> {
    public static final String MESSAGE_PRIORITY_CONSTRAINTS =
            "Person priority can take only H, M, or L as inputs.";

    /*
     * Only H, M and L are allowed as inputs.
     */
    public static final String PRIORITY_VALIDATION_REGEX = "[HML]";

    private static final String ORDERED_ENTRIES = "L, M, H";

    public final String value;

    /**
     * Validates given priority.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Priority(String priority) throws IllegalValueException {
        requireNonNull(priority);
        if (!isValidPriority(priority)) {
            throw new IllegalValueException(MESSAGE_PRIORITY_CONSTRAINTS);
        }
        this.value = priority;
    }

    /**
     * Returns true if a given string is a valid priority.
     */
    public static boolean isValidPriority(String test) {
        return test.matches(PRIORITY_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Priority // instanceof handles nulls
                && this.value.equals(((Priority) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

```
###### \java\seedu\address\model\person\ReadOnlyPerson.java
``` java
    Address getAddress();

    ObjectProperty<Company> companyProperty();

    Company getCompany();

    ObjectProperty<Position> positionProperty();

    Position getPosition();

    ObjectProperty<Status> statusProperty();

    Status getStatus();

    ObjectProperty<Priority> priorityProperty();

    Priority getPriority();

    ObjectProperty<Note> noteProperty();

    Note getNote();
```
###### \java\seedu\address\model\person\ReadOnlyPerson.java
``` java
    /**
     * Returns true if both have the same state. (interfaces cannot override .equals)
     */
    default boolean isSameStateAs(ReadOnlyPerson other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                && other.getName().equals(this.getName()) // state checks here onwards
                && other.getPhone().equals(this.getPhone())
                && other.getEmail().equals(this.getEmail())
                && other.getAddress().equals(this.getAddress())
                && other.getCompany().equals(this.getCompany())
                && other.getPosition().equals(this.getPosition())
                && other.getStatus().equals(this.getStatus())
                && other.getPriority().equals(this.getPriority())
                && other.getNote().equals(this.getNote())
                && other.getPhoto().equals(this.getPhoto()))
                && other.getRelation().equals(this.getRelation());
    }

    /**
     * Formats the person as text, showing all contact details.
     */
    default String getAsText() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Company: ")
                .append(getCompany())
                .append(" Position: ")
                .append(getPosition())
                .append(" Status: ")
                .append(getStatus())
                .append(" Priority: ")
                .append(getPriority())
                .append(" Note: ")
                .append(getNote())
                .append(" Photo: ")
                .append(getPhoto())
                .append(" Relationship: ")
                .append(getRelation())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }
```
###### \java\seedu\address\model\person\Status.java
``` java
package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.util.Comparator;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's status in the address book.
 */

public class Status implements Comparator<Status> {
    public static final String MESSAGE_STATUS_CONSTRAINTS =
            "Person status can take any values, and it should not be blank";

    /*
     * The first character of the status must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String STATUS_VALIDATION_REGEX = "[^\\s].*";

    private static final String ORDERED_ENTRIES = "NIL";

    public final String value;

    /**
     * Validates given status.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Status(String status) throws IllegalValueException {
        requireNonNull(status);
        if (!isValidStatus(status)) {
            throw new IllegalValueException(MESSAGE_STATUS_CONSTRAINTS);
        }
        this.value = status;
    }

    /**
     * Returns true if a given string is a valid status.
     */
    public static boolean isValidStatus(String test) {
        return test.matches(STATUS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Status // instanceof handles nulls
                && this.value.equals(((Status) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
```
###### \java\seedu\address\model\tag\UniqueTagList.java
``` java
    /**
     * Removes a Tag from the list if it is present.
     *
     * @param toRemove Tag to be removed
     */
    public void remove(Tag toRemove) {
        requireNonNull(toRemove);
        if (contains(toRemove)) {
            internalList.remove(toRemove);
        }
    }
```
###### \java\seedu\address\storage\XmlAdaptedPerson.java
``` java
    @XmlElement(required = true)
    private String company;
    @XmlElement(required = true)
    private String position;
    @XmlElement(required = true)
    private String status;
    @XmlElement(required = true)
    private String priority;
    @XmlElement(required = true)
    private String note;
```
###### \java\seedu\address\storage\XmlAdaptedPerson.java
``` java
    /**
     * Converts a given Person into this class for JAXB use.
     *
     * @param source future changes to this will not affect the created XmlAdaptedPerson
     */
    public XmlAdaptedPerson(ReadOnlyPerson source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        company = source.getCompany().value;
        position = source.getPosition().value;
        status = source.getStatus().value;
        priority = source.getPriority().value;
        note = source.getNote().value;
        photo = source.getPhoto().photoUrl;
        tagged = new ArrayList<>();
        relation = new ArrayList<>();
        for (Tag tag : source.getTags()) {
            tagged.add(new XmlAdaptedTag(tag));
        }
        for (Relationship rel : source.getRelation()) {
            relation.add(new XmlAdaptedRelationship(rel));
        }
    }

    /**
     * Converts this jaxb-friendly adapted person object into the model's Person object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person
     */
    public Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (XmlAdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
        }
        final List<Relationship> personRel = new ArrayList<>();
        for (XmlAdaptedRelationship rel : relation) {
            personRel.add(rel.toModelType());
        }
        final Name name = new Name(this.name);
        final Phone phone = new Phone(this.phone);
        final Email email = new Email(this.email);
        final Address address = new Address(this.address);
        Company company = new Company("NIL"); //to handle legacy versions where these optional fields were not stored
        if (this.company != null) {
            company = new Company(this.company);
        }
        Position position = new Position("NIL"); //to handle legacy versions where these optional fields were not stored
        if (this.position != null) {
            position = new Position(this.position);
        }
        Status status = new Status("NIL"); //to handle legacy versions where these optional fields were not stored
        if (this.status != null) {
            status = new Status(this.status);
        }
        Priority priority = new Priority("L"); //to handle legacy versions where these optional fields were not stored
        if (this.priority != null) {
            priority = new Priority(this.priority);
        }
        Note note = new Note("NIL"); //to handle legacy versions where these optional fields were not stored
        if (this.note != null) {
            note = new Note(this.note);
        }
        Photo photo = new Photo("NIL.jpg"); //to handle legacy versions
        // where these optional fields were not stored
        if (this.photo != null) {
            photo = new Photo(this.photo);
        }
        final Set<Tag> tags = new HashSet<>(personTags);
        final Set<Relationship> rel = new HashSet<>(personRel);
        return new Person(name, phone, email, address, company, position,
                status, priority, note, photo, tags, rel);
    }
}
```
###### \java\seedu\address\ui\EventListPanel.java
``` java
    @Subscribe
    /**
     *Clears the event card selection when a person is selected.
     */
    private void handlePersonPanelSelectionChangedEvent(PersonPanelSelectionChangedEvent event) {
        eventListView.getSelectionModel().clearSelection();
    }

    @Subscribe
    /**
     *Clears the event card selection when the calendar is opened.
     */
    private void handleShowCalendarEvent(ShowCalendarEvent event) {
        eventListView.getSelectionModel().clearSelection();
    }
```
###### \java\seedu\address\ui\EventPanel.java
``` java
package seedu.address.ui;

import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.events.ui.EventPanelSelectionChangedEvent;
import seedu.address.logic.Logic;
import seedu.address.model.event.ReadOnlyEvent;

/**
 * The main panel of the app that displays all the details of an event in the address book.
 */
public class EventPanel extends UiPart<Region> {
    private static final String FXML = "EventPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(this.getClass());
    private ReadOnlyEvent storedEvent;
    private Index storedEventIndex;
    private Logic logic;

    @FXML
    private Label nameLabel;

    @FXML
    private Label timeslotLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label periodLabel;

    public EventPanel(Logic logic) {
        super(FXML);
        this.logic = logic;
        registerAsAnEventHandler(this);
    }

    /**
     * Shows the details of the event selected. Called by the handleEventPanelSelectionChangedEvent event listener,
     * as well as the handleAddressBookChanged event listener.
     * @param event
     */
    private void showEventDetails(Index index, ReadOnlyEvent event) {
        nameLabel.setText(event.getTitle().toString());
        timeslotLabel.setText(event.getTimeslot().toString());
        descriptionLabel.setText(event.getDescription().toString());
        periodLabel.setText("Repeat: Every " + event.getPeriod().toString() + " days.");

    }

    /**
     * Calls showEventDetails when an event is selected in the event panel, causing their details to be displayed
     * in the main window.
     * @param event
     */
    @Subscribe
    private void handleEventPanelSelectionChangedEvent(EventPanelSelectionChangedEvent event) {
        Index index = event.getNewSelection().getIndex();
        ReadOnlyEvent onlyEvent = event.getNewSelection().event;
        storedEvent = onlyEvent;
        storedEventIndex = index;
        logger.info("Event Panel: stored index becomes " + index
                .getZeroBased());

        logger.info(LogsCenter.getEventHandlingLogMessage
                (event) + " for index " + index.getZeroBased());
        showEventDetails(index, onlyEvent);
    }

    /**
     * Calls showEventDetails when the address book is changed. This results in any edits to the currently displayed
     * event being refreshed immediately, instead of the user having to click away and click back to see the changes.
     * @param event

    @Subscribe
    private void handleAddressBookChangedEvent(AddressBookChangedEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
        for (ReadOnlyEvent dataEvent : event.data.getEventList()) {
            if (storedEvent != null && storedEvent.getTitle().equals(dataEvent.getTitle())) {
                showEventDetails(storedEventIndex, dataEvent);
                storedEvent = dataEvent;
                break;
            }
        }
    }
    */
}
```
###### \java\seedu\address\ui\MainWindow.java
``` java
    private PersonPanel personPanel;
    private EventPanel eventPanel;
```
###### \java\seedu\address\ui\MainWindow.java
``` java
        eventPanel = new EventPanel(logic);

        personPanel = new PersonPanel(logic);
```
###### \java\seedu\address\ui\MainWindow.java
``` java
        personPanel.setDimensions(personListPanel.getRoot().getHeight(),
                primaryStage.getWidth() - personListPanel.getRoot().getWidth());
```
###### \java\seedu\address\ui\MainWindow.java
``` java
    /**
     * Called when a person panel is selected. Hides other panels and displays the person panel.
     */
    @FXML
    public void handlePersonPanelSelected() {
        if (browserPlaceholder.getChildren().contains(eventPanel.getRoot())) {
            browserPlaceholder.getChildren().remove(eventPanel.getRoot());
        }
        if (browserPlaceholder.getChildren().contains(calendarView.getRoot())) {
            browserPlaceholder.getChildren().remove(calendarView.getRoot());
        }
        browserPlaceholder.getChildren().add((personPanel.getRoot()));
    }

    /**
     * Called when an event panel is selected. Hides other panels and displays the event panel.
     */
    @FXML
    public void handleEventPanelSelected() {
        if (browserPlaceholder.getChildren().contains(personPanel.getRoot())) {
            browserPlaceholder.getChildren().remove(personPanel.getRoot());
        }
        if (browserPlaceholder.getChildren().contains(eventPanel.getRoot())) {
            browserPlaceholder.getChildren().remove(eventPanel.getRoot());
        }
        if (browserPlaceholder.getChildren().contains(calendarView.getRoot())) {
            browserPlaceholder.getChildren().remove(calendarView.getRoot());
        }
        browserPlaceholder.getChildren().add((eventPanel.getRoot()));
    }
```
###### \java\seedu\address\ui\MainWindow.java
``` java
    @Subscribe
    private void handlePersonPanelSelectionChangedEvent(PersonPanelSelectionChangedEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
        handlePersonPanelSelected();
    }

    @Subscribe
    private void handleEventPanelSelectionChangedEvent(EventPanelSelectionChangedEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
        handleEventPanelSelected();
    }
```
###### \java\seedu\address\ui\PersonCard.java
``` java
        company.textProperty().bind(Bindings.convert(person.companyProperty()));
        position.textProperty().bind(Bindings.convert(person.positionProperty()));
        priority.textProperty().bind(Bindings.convert(person.priorityProperty()));
```
###### \java\seedu\address\ui\PersonCard.java
``` java

    /**
     *Changes the CSS rules to apply different colours to different priorities.
     */
    private void setPriorityTextFill() {
        if (priority.textProperty().getValue().equals("H")) {
            pane.setId("highpriority");
        } else if (priority.textProperty().getValue().equals("M")) {
            pane.setId("mediumpriority");
        } else if (priority.textProperty().getValue().equals("L")) {
            pane.setId("lowpriority");
        }
    }

    /**
     * Checks the priority when the address book is changed and sets the text fill accordingly.
     * @param event
    */
    @Subscribe
    private void handleAddressBookChangedEvent(AddressBookChangedEvent event) {
        logger.fine(LogsCenter.getEventHandlingLogMessage(event));
        setPriorityTextFill();
    }
}
```
###### \java\seedu\address\ui\PersonListPanel.java
``` java
    @Subscribe
    /**
     *Clears the person card selection when an event is selected.
     */
    private void handleEventPanelSelectionChangedEvent(EventPanelSelectionChangedEvent event) {
        personListView.getSelectionModel().clearSelection();
    }

    @Subscribe
    /**
     *Clears the person card selection when the calendar is opened.
     */
    private void handleShowCalendarEvent(ShowCalendarEvent event) {
        personListView.getSelectionModel().clearSelection();
    }
```
###### \java\seedu\address\ui\PersonPanel.java
``` java
package seedu.address.ui;

import java.io.File;
import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.events.model.AddressBookChangedEvent;
import seedu.address.commons.events.ui.NewResultAvailableEvent;
import seedu.address.commons.events.ui.PersonPanelSelectionChangedEvent;
import seedu.address.logic.Logic;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.ReadOnlyPerson;

/**
 * The main panel of the app that displays all the details of a person in the address book.
 */
public class PersonPanel extends UiPart<Region> {
    private static final double EMAIL_NAME_WIDTH = 42;
    private static final double STATUS_NAME_WIDTH = 47;
    private static final double HORIZONTAL_SCALE = 0.55;
    private static final double HORIZONTAL_SCALE_EXTENDED = HORIZONTAL_SCALE + 0.05;
    private static final String FXML = "PersonPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(this.getClass());
    private ReadOnlyPerson storedPerson;
    private Logic logic;

    @FXML
    private Label nameLabel;

    @FXML
    private ImageView photo;

    @FXML
    private Button photoSelectionButton;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label emailName;

    @FXML
    private Label emailLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label companyLabel;

    @FXML
    private Label positionLabel;

    @FXML
    private Label statusName;

    @FXML
    private Label statusLabel;

    @FXML
    private Label priorityLabel;

    @FXML
    private Label noteLabel;

    @FXML
    private FlowPane relationshipPane;
    @FXML
    private FlowPane tagsPane;

    @FXML
    private ImageView imageView;

    @FXML
    private Line line;

    public PersonPanel(Logic logic) {
        super(FXML);
        this.logic = logic;
        registerAsAnEventHandler(this);
    }

```
###### \java\seedu\address\ui\PersonPanel.java
``` java

    /**
     * Shows the details of the person selected. Called by the handlePersonPanelSelectionChangedEvent event listener,
     * as well as the handleAddressBookChanged event listener.
     * @param person
     */
    private void showPersonDetails(ReadOnlyPerson person) {
        nameLabel.setText(person.getName().toString());
        phoneLabel.setText(person.getPhone().toString());
        emailLabel.setText(person.getEmail().toString());
        addressLabel.setText(person.getAddress().toString());
        companyLabel.setText(person.getCompany().toString());
        positionLabel.setText(person.getPosition().toString());
        priorityLabel.setText(person.getPriority().toString());
        statusLabel.setText(person.getStatus().toString());
        noteLabel.setText(person.getNote().toString());
        tagsPane.getChildren().removeAll(tagsPane.getChildren());
        person.getTags().forEach(tag -> tagsPane.getChildren().add(new Label(tag.tagName)));
        relationshipPane.getChildren().removeAll(relationshipPane.getChildren());
        person.getRelation().forEach
            (relationship -> relationshipPane.getChildren().add(new Label(relationship.relType)));
```
###### \java\seedu\address\ui\PersonPanel.java
``` java

    /**
     * Called by MainWindow. Sets the dimensions of the various elements for relative scaling once primaryStage
     * dimensions are known.
     * @param height
     * @param width
     */
    public void setDimensions(double height, double width) {
        emailLabel.setLayoutX(width * HORIZONTAL_SCALE);
        emailName.setLayoutX(emailLabel.getLayoutX() - EMAIL_NAME_WIDTH);
        statusName.setLayoutX(emailName.getLayoutX());
        statusLabel.setLayoutX(statusName.getLayoutX() + STATUS_NAME_WIDTH);
        photo.setLayoutX(width * HORIZONTAL_SCALE);
        photoSelectionButton.setLayoutX(width * HORIZONTAL_SCALE);
        photoSelectionButton.setLayoutY(photo.getLayoutY() + photo.getFitHeight());
        line.setEndX(width * HORIZONTAL_SCALE_EXTENDED);
    }

    /**
     * Calls showPersonDetails when a person is selected in the person panel, causing their details to be displayed
     * in the main window.
     * @param event
     */
    @Subscribe
    private void handlePersonPanelSelectionChangedEvent(PersonPanelSelectionChangedEvent event) {
        Index index = event.getNewSelection().index;
        ReadOnlyPerson person = event.getNewSelection().person;
        logger.fine("Person Panel: stored index becomes " + index
                .getZeroBased());

        registerImageSelectionButton(index);
        logger.fine(LogsCenter.getEventHandlingLogMessage
                (event) + " for index " + index.getZeroBased());
        showPersonDetails(person);

    }

    /**
     * Calls showPersonDetails when the address book is changed. This results in any edits to the currently displayed
     * person being refreshed immediately, instead of the user having to click away and click back to see the changes.
     * @param event
     */
    @Subscribe
    private void handleAddressBookChangedEvent(AddressBookChangedEvent event) {
        logger.fine(LogsCenter.getEventHandlingLogMessage(event));
        for (ReadOnlyPerson dataPerson : event.data.getPersonList()) {
            if (storedPerson != null && storedPerson.getName().equals(dataPerson.getName())) {
                showPersonDetails(dataPerson);
                storedPerson = dataPerson;
                break;
            }
        }
    }
}
```
###### \resources\view\BrightTheme.css
``` css

#eventName .label {
    -fx-font-family: "Segoe UI Light";
    -fx-font-size: 40pt;
}

#eventTime .label {
    -fx-font-family: "Segoe UI Light";
    -fx-font-size: 30pt;
}

#eventDescription .label {
    -fx-font-family: "Segoe UI Light";
    -fx-font-size: 16pt;
}

#highpriority .label {
    -fx-text-fill: white;
    -fx-background-color: red;
    -fx-padding: 1 1 1 1;
    -fx-border-radius: 1;
    -fx-background-radius: 1;
    -fx-font-size: 11;
}

#mediumpriority .label {
    -fx-text-fill: white;
    -fx-background-color: orange;
    -fx-padding: 1 1 1 1;
    -fx-border-radius: 1;
    -fx-background-radius: 1;
    -fx-font-size: 11;
}

#lowpriority .label {
    -fx-text-fill: white;
    -fx-background-color: green;
    -fx-padding: 1 1 1 1;
    -fx-border-radius: 1;
    -fx-background-radius: 1;
    -fx-font-size: 11;
}
```
