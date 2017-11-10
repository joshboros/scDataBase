//jb

/**
 * The type Sc record.
 */
public class scRecord {
    private String subject;
    private int section;
    private int subsection;
    private String instructionsPlainText;

    private String questionPlainText;
    private String questionHtml;
    private String questionLatex;

    private String answerPlainText;
    private String[] htmlChoices;
    private String answerLatex;
    private String answerHtml;

    /**
     * The enum Difficulty level.
     */
    enum  DifficultyLevel{
        /**
         * Unspecified difficulty level.
         */
        UNSPECIFIED, /**
         * Easy difficulty level.
         */
        EASY, /**
         * Medium difficulty level.
         */
        MEDIUM, /**
         * Hard difficulty level.
         */
        HARD}
    private DifficultyLevel difficulty;


    /**
     * Gets difficulty.
     *
     * @return the difficulty
     */
    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    /**
     * Sets difficulty.
     *
     * @param difficulty the difficulty
     */
    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets section.
     *
     * @return the section
     */
    public int getSection() {
        return section;
    }

    /**
     * Sets section.
     *
     * @param section the section
     */
    public void setSection(int section) {
        this.section = section;
    }

    /**
     * Gets subsection.
     *
     * @return the subsection
     */
    public int getSubsection() {
        return subsection;
    }

    /**
     * Sets subsection.
     *
     * @param subsection the subsection
     */
    public void setSubsection(int subsection) {
        this.subsection = subsection;
    }

    /**
     * Get the instructions in plain text.
     *
     * @return the string
     */
    public String getInstructionsPlainText(){
        return instructionsPlainText;
    }

    /**
     * Set instructions plain text.
     *
     * @param instructionsPlainText the instructions plain text
     */
    public void setInstructionsPlainText(String instructionsPlainText){
        this.instructionsPlainText = instructionsPlainText;
    }


    /**
     * Gets the question in plain text.
     *
     * @return the question plain text
     */
    public String getQuestionPlainText() {
        return questionPlainText;
    }

    /**
     * Sets question plain text.
     *
     * @param questionPlainText the question plain text
     */
    public void setQuestionPlainText(String questionPlainText) {
        this.questionPlainText = questionPlainText;
    }

    /**
     * Gets question with html markup.
     *
     * @return the question html
     */
    public String getQuestionHtml() {
        return questionHtml;
    }

    /**
     * Set the question with html markup.
     *
     * @param questionHtml the question html
     */
    public void setQuestionHtml(String questionHtml) {
        this.questionHtml = questionHtml;
    }

    /**
     * Get question with latex markup.
     *
     * @return the question latex
     */
    public String getQuestionLatex() {
        return questionLatex;
    }

    /**
     * Set the question with latex markup.
     *
     * @param questionLatex the question latex
     */
    public void setQuestionLatex(String questionLatex) {
        this.questionLatex = questionLatex;
    }

    /**
     * Get answer with html markup.
     *
     * @return the answer html
     */
    public String getAnswerHtml() {
        return answerHtml;
    }

    /**
     * Set the answer with html markup.
     *
     * @param answerHtml the answer html
     */
    public void setAnswerHtml(String answerHtml) {
        this.answerHtml = answerHtml;
    }


    /**
     * Get the answer in plain text.
     *
     * @return the answer plain text
     */
    public String getAnswerPlainText() {
        return answerPlainText;
    }

    /**
     * Set the answer in plain text.
     *
     * @param answerPlainText the answer plain text
     */
    public void setAnswerPlainText(String answerPlainText) {
        this.answerPlainText = answerPlainText;
    }

    /**
     * Get html choices string [ ].
     *
     * @return the string [ ]
     */
    public String[] getHtmlChoices() {
        return htmlChoices;
    }

    /**
     * Sets html choices.
     *
     * @param htmlChoices the html choices
     */
    public void setHtmlChoices(String[] htmlChoices) {
        this.htmlChoices = htmlChoices;
    }

    /**
     * Get the answer with latex markup.
     *
     * @return the answer latex
     */
    public String getAnswerLatex() {
        return answerLatex;
    }

    /**
     * Set answer with latex markup.
     *
     * @param answerLatex the answer latex
     */
    public void setAnswerLatex(String answerLatex) {
        this.answerLatex = answerLatex;
    }

}
