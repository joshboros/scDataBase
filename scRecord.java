//jb

/**
 * The type Sc record.
 */


public class scRecord {
    private String subject;
    private Integer section;
    private Integer subsection;
    private String topic;
    private Integer difficulty;
    private String instructions;
    private String questionHtml;
    private String questionLatex;
    private String choicesHtml;
    private String answerHtml;

    scRecord(){
        subject = new String();
        section = 0;
        subsection = 0;
        topic = new String();
        difficulty = 0;
        instructions = new String();
        questionHtml = new String();
        questionLatex = new String();
        choicesHtml = new String();
        answerHtml = new String();
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
        sb.append("Answer: ");
        sb.append(System.lineSeparator());
        sb.append("\tHTML: " + getAnswerHtml());
        sb.append(System.lineSeparator());
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
        UNSPECIFIED(0),
        /**
         * Easy difficulty level.
         */
        EASY(1), /**
         * Medium difficulty level.
         */
        MEDIUM(2), /**
         * Hard difficulty level.
         */
        HARD(3);

        private Integer intLevel;

        DifficultyLevel(Integer level){
            this.intLevel = level;
        }

        public Integer getIntLevel(){
            return intLevel;
        }
    }


    /**
     * Gets difficulty.
     *
     * @return the difficulty
     */
    public Integer getDifficulty() {

        return difficulty;
    }

    /**
     * Sets difficulty.
     *
     * @param difficulty the difficulty
     */
    public void setDifficulty(Integer difficulty) {
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
     * 
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

    
}
