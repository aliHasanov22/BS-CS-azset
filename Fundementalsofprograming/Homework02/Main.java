package Homework02;

public class Main {
    public static void main(String[] args) {
        TUMLibrary library = new TUMLibrary("TUM Library");
        library.addSection(new Section("Fiction"));
        library.addSection(new Section("Science"));
        library.addSection(new Section("History"));
        library.addSection(new Section("Technology"));
        library.addSection(new Section("Art"));

        library.validateNewBook(new Book(101, "The Hobbit", "J. R. R. Tolkien", "Fiction"));
        library.validateNewBook(new Book(102, "Dune", "Frank Herbert", "Fiction"));
        library.validateNewBook(new Book(103, "A Brief History of Time", "Stephen Hawking", "Science"));
        library.validateNewBook(new Book(104, "The Art Book", "Phaidon Editors", "Art"));
        library.sort();

        System.out.println(library.getName());
        for (Section section : library.getSections()) {
            if (section == null) {
                continue;
            }
            System.out.println(section.getSectionName() + ":");
            for (Shelf shelf : section.getShelves()) {
                if (shelf == null) {
                    continue;
                }
                for (Book book : shelf.getBooks()) {
                    if (book != null) {
                        System.out.println("  " + book.getId() + " - " + book.getTitle()
                                + " by " + book.getAuthor());
                    }
                }
            }
        }
    }
}

class Book {
    private int id;
    private String title;
    private String author;
    private String genre;

    public Book(int id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(String title, String author, String genre, int id) {
        this(id, title, author, genre);
    }

    public int getId() {
        return id;
    }

    public int getBookId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

class Shelf {
    private final Book[] books = new Book[15];
    private Section section;

    public Shelf(Section section) {
        this.section = section;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Book[] getBooks() {
        return books.clone();
    }

    public boolean isUtilized() {
        for (Book book : books) {
            if (book != null) {
                return true;
            }
        }
        return false;
    }

    public boolean addBook(Book book) {
        if (book == null || containsId(book.getId())) {
            return false;
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return true;
            }
        }
        return false;
    }

    public void sort() {
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (books[j] != null && books[j + 1] != null
                        && books[j].getTitle().compareTo(books[j + 1].getTitle()) > 0) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    private boolean containsId(int id) {
        for (Book book : books) {
            if (book != null && book.getId() == id) {
                return true;
            }
        }
        return false;
    }
}

class Section {
    private String sectionName;
    private final Shelf[] shelves = new Shelf[5];

    public Section(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Shelf[] getShelves() {
        return shelves.clone();
    }

    public boolean addToShelf(Book book) {
        if (book == null || containsId(book.getId())) {
            return false;
        }

        for (Shelf shelf : shelves) {
            if (shelf != null && shelf.addBook(book)) {
                return true;
            }
        }

        for (int i = 0; i < shelves.length; i++) {
            if (shelves[i] == null) {
                Shelf shelf = new Shelf(this);
                if (shelf.addBook(book)) {
                    shelves[i] = shelf;
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private boolean containsId(int id) {
        for (Shelf shelf : shelves) {
            if (shelf == null) {
                continue;
            }
            for (Book book : shelf.getBooks()) {
                if (book != null && book.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }
}


class TUMLibrary {
    private String name;
    private final Section[] sections = new Section[5];

    public TUMLibrary(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section[] getSections() {
        return sections.clone();
    }

    public boolean addSection(Section section) {
        if (section == null || findSection(section.getSectionName()) != null) {
            return false;
        }

        for (int i = 0; i < sections.length; i++) {
            if (sections[i] == null) {
                sections[i] = section;
                return true;
            }
        }
        return false;
    }

    public boolean validateNewBook(Book book) {
        if (book == null || book.getGenre() == null || containsId(book.getId())) {
            return false;
        }

        Section section = findSection(book.getGenre());
        return section != null && section.addToShelf(book);
    }

    public void sort() {
        for (Section section : sections) {
            if (section == null) {
                continue;
            }
            for (Shelf shelf : section.getShelves()) {
                if (shelf != null) {
                    shelf.sort();
                }
            }
        }
    }

    private Section findSection(String sectionName) {
        if (sectionName == null) {
            return null;
        }
        for (Section section : sections) {
            if (section != null && sectionName.equals(section.getSectionName())) {
                return section;
            }
        }
        return null;
    }

    private boolean containsId(int id) {
        for (Section section : sections) {
            if (section == null) {
                continue;
            }
            for (Shelf shelf : section.getShelves()) {
                if (shelf == null) {
                    continue;
                }
                for (Book existingBook : shelf.getBooks()) {
                    if (existingBook != null && existingBook.getId() == id) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}