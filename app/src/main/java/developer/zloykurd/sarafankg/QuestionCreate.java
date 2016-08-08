package developer.zloykurd.sarafankg;

/**
 * Created by ZloykurD on 07.08.2016.
 */
public class QuestionCreate {

    String id;
    String themeQuestion;
    String textQuestion;
    String dateQuestion;
    String imageQuestion;
    String imageAccountUser;
    String creatorQuestion;
    String countCommyQuestion;
    String categoryQuestion;



    public QuestionCreate() {

    }

    public QuestionCreate(String id, String themeQuestion, String textQuestion, String dateQuestion, String imageQuestion, String imageAccountUser, String creatorQuestion, String countCommyQuestion, String categoryQuestion) {
        this.id = id;
        this.themeQuestion = themeQuestion;
        this.textQuestion = textQuestion;
        this.dateQuestion = dateQuestion;
        this.imageQuestion = imageQuestion;
        this.imageAccountUser = imageAccountUser;
        this.creatorQuestion = creatorQuestion;
        this.countCommyQuestion = countCommyQuestion;
        this.categoryQuestion = categoryQuestion;
    }

    public QuestionCreate(String themeQuestion, String textQuestion, String dateQuestion, String imageQuestion, String imageAccountUser, String creatorQuestion, String countCommyQuestion, String categoryQuestion) {
        this.themeQuestion = themeQuestion;
        this.textQuestion = textQuestion;
        this.dateQuestion = dateQuestion;
        this.imageQuestion = imageQuestion;
        this.imageAccountUser = imageAccountUser;
        this.creatorQuestion = creatorQuestion;
        this.countCommyQuestion = countCommyQuestion;
        this.categoryQuestion = categoryQuestion;
    }

    public QuestionCreate(String themeQuestion, String dateQuestion, String imageAccountUser, String creatorQuestion, String countCommyQuestion, String categoryQuestion) {
        this.themeQuestion = themeQuestion;
        this.dateQuestion = dateQuestion;
        this.imageAccountUser = imageAccountUser;
        this.creatorQuestion = creatorQuestion;
        this.countCommyQuestion = countCommyQuestion;
        this.categoryQuestion = categoryQuestion;
    }

    public QuestionCreate(String textQuestion, String dateQuestion, String creatorQuestion, String countCommyQuestion, String categoryQuestion) {
        this.textQuestion = textQuestion;
        this.dateQuestion = dateQuestion;
        this.creatorQuestion = creatorQuestion;
        this.countCommyQuestion = countCommyQuestion;
        this.categoryQuestion = categoryQuestion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThemeQuestion() {
        return themeQuestion;
    }

    public void setThemeQuestion(String themeQuestion) {
        this.themeQuestion = themeQuestion;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public String getDateQuestion() {
        return dateQuestion;
    }

    public void setDateQuestion(String dateQuestion) {
        this.dateQuestion = dateQuestion;
    }

    public String getImageQuestion() {
        return imageQuestion;
    }

    public void setImageQuestion(String imageQuestion) {
        this.imageQuestion = imageQuestion;
    }

    public String getImageAccountUser() {
        return imageAccountUser;
    }

    public void setImageAccountUser(String imageAccountUser) {
        this.imageAccountUser = imageAccountUser;
    }

    public String getCreatorQuestion() {
        return creatorQuestion;
    }

    public void setCreatorQuestion(String creatorQuestion) {
        this.creatorQuestion = creatorQuestion;
    }

    public String getCountCommyQuestion() {
        return countCommyQuestion;
    }

    public void setCountCommyQuestion(String countCommyQuestion) {
        this.countCommyQuestion = countCommyQuestion;
    }

    public String getCategoryQuestion() {
        return categoryQuestion;
    }

    public void setCategoryQuestion(String categoryQuestion) {
        this.categoryQuestion = categoryQuestion;
    }

    @Override
    public String toString() {
        return "QuestionCreate{" +
                "id=" + id +
                ", themeQuestion='" + themeQuestion + '\'' +
                ", textQuestion='" + textQuestion + '\'' +
                ", dateQuestion='" + dateQuestion + '\'' +
                ", imageQuestion='" + imageQuestion + '\'' +
                ", imageAccountUser='" + imageAccountUser + '\'' +
                ", creatorQuestion='" + creatorQuestion + '\'' +
                ", countCommyQuestion='" + countCommyQuestion + '\'' +
                ", categoryQuestion='" + categoryQuestion + '\'' +
                '}';
    }
}