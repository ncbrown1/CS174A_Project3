/**
 * Created by ncbrown on 2/26/15.
 */
public class Author {
    private String AuthorID;
    private String AuthorTitle;
    private String AuthorFirstName;
    private String AuthorLastName;

    public Author(String authorID, String authorTitle, String authorFirstName, String authorLastName) {
        AuthorID = authorID;
        AuthorTitle = authorTitle;
        AuthorFirstName = authorFirstName;
        AuthorLastName = authorLastName;
    }

    public String getAuthorID() { return AuthorID; }
    public void setAuthorID(String authorID) { AuthorID = authorID; }
    public String getAuthorTitle() { return AuthorTitle; }
    public void setAuthorTitle(String authorTitle) { AuthorTitle = authorTitle; }
    public String getAuthorFirstName() { return AuthorFirstName; }
    public void setAuthorFirstName(String authorFirstName) { AuthorFirstName = authorFirstName; }
    public String getAuthorLastName() { return AuthorLastName; }
    public void setAuthorLastName(String authorLastName) { AuthorLastName = authorLastName; }
}
