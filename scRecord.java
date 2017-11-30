package school.termProject.database;

//jb

/**
 * The type Sc record.
 */


public class scRecord {
    private String subject;
    private Integer section;
    private Integer subsection;
    private String topic;
    private DifficultyLevel difficulty;
    private String instructions;

    //private String questionPlainText;
    private String questionHtml;
    private String questionLatex;
    private String choicesHtml;
    private String answerPlainText;
    private String answerHtml;

    //private String questionJeopardy;
    //private String answerJeopardy;

    scRecord(){
        subject = null;
        section = null;
        subject = null;
        subsection = null;
        topic = null;
        difficulty = DifficultyLevel.UNSPECIFIED;
        instructions = null;
        questionHtml = null;
        questionLatex = null;
        choicesHtml = null;
        answerHtml = null;
        answerPlainText = null;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Subject: " + getSubject());
        sb.append(System.lineSeparator());
        sb.append("Section: " + getSection().toString());
        sb.append(System.lineSeparator());
        sb.append("Subsection: " + getSubsection().toString());
        sb.append(System.lineSeparator());
        sb.append("Topic: " + getTopic());
        sb.append(System.lineSeparator());
        sb.append("Difficulty: " + getDifficulty().toString());
        sb.append(System.lineSeparator());
        sb.append("Instructions: " + getInstructions());
        sb.append(System.lineSeparator());
        sb.append("Question: ");
        sb.append(System.lineSeparator());
        sb.append("\tHTML: " + getQuestionHtml());
        sb.append(System.lineSeparator());
        sb.append("\tLATEX: " + getQuestionLatex());
        sb.append(System.lineSeparator());
        //sb.append("\tJeopardy: " + getQuestionJeopardy());
        //sb.append(System.lineSeparator());
        sb.append("Answer: ");
        sb.append(System.lineSeparator());
        sb.append("\tHTML: " + getAnswerHtml());
        //sb.append(System.lineSeparator());
        //sb.append("\tJeopardy: " + getAnswerJeopardy());
        sb.append("Choices (HTML): " + getChoicesHtml());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    /**
     * The enum Difficulty level.
     */
    public static enum  DifficultyLevel{
        /**
         * Unspecified difficulty level.
         */
        UNSPECIFIED,
        /**
         * Easy difficulty level.
         */
        EASY, /**
         * Medium difficulty level.
         */
        MEDIUM, /**
         * Hard difficulty level.
         */
        HARD;
    }


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
    public Integer getSection() {
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
    public Integer getSubsection() {
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
     * Set topic.
     *
     * @param topic the topic
     */
    public void setTopic(String topic){
        this.topic = topic;
    }

    /**
     * Get topic string.
     *
     * @return the string
     */
    public String getTopic(){
        return topic;
    }

    /**
     * Get the instructions.
     *
     * @return the string
     */
    public String getInstructions(){
        return instructions;
    }

    /**
     * Set instructions.
     *
     * @param instructions the instructions plain text
     */
    public void setInstructions(String instructions){
        this.instructions = instructions;
    }

    /**
     * Gets question with html markup.
     * If no html version found then return plain text.
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
     * If no latex version found then return plain text.
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
     * If no html version found then return plain text.
     *
     * @return the answer html
     */
    public String getAnswerHtml() {
        if (answerHtml.isEmpty()){
            return answerPlainText;
        }
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
    public String getChoicesHtml() {
        return choicesHtml;
    }

    /**
     * Sets html choices.
     *
     * @param choicesHtml the html choices
     */
    public void setChoicesHtml(String choicesHtml) {
        this.choicesHtml = choicesHtml;
    }

    
    public String getQuestionJeopardy() {
        return questionJeopardy;
    }
     
    
    public void setQuestionJeopardy(String questionJeopardy) {
        this.questionJeopardy = questionJeopardy;
    }

    public String getAnswerJeopardy() {
        return answerJeopardy;
    }


    public void setAnswerJeopardy(String answerJeopardy) {
        this.answerJeopardy = answerJeopardy;
    }

    static class difficultyLevel{
        private final Integer UNSPECIFIED = 0;
        private final Integer EASY = 1;
        private final Integer MEDIUM = 2;
        private final Integer HARD =3;

        private Integer level;

        public  getLevel(){
            return level;
        }
    }


}
