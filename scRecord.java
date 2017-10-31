public class scRecord {
    public Question question;
    public Answer answer;
    private String subject;
    private int section;
    private int subsection;
    enum  DifficultyLevel{UNSPECIFIED, EASY, MEDIUM, HARD}
    private DifficultyLevel difficulty;


    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getSubsection() {
        return subsection;
    }

    public void setSubsection(int subsection) {
        this.subsection = subsection;
    }



    class Question{
        private String text;
        private String html;
        private String latex;
        private String jeopardy;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public String getLatex() {
            return latex;
        }

        public void setLatex(String latex) {
            this.latex = latex;
        }

        public String getJeopardy() {
            return jeopardy;
        }

        public void setJeopardy(String jeopardy) {
            this.jeopardy = jeopardy;
        }
    }

    class Answer{
        private String text;
        private String[] htmlChoices;
        private String latex;
        private String jeopardy;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String[] getHtmlChoices() {
            return htmlChoices;
        }

        public void setHtmlChoices(String[] htmlChoices) {
            this.htmlChoices = htmlChoices;
        }

        public String getLatex() {
            return latex;
        }

        public void setLatex(String latex) {
            this.latex = latex;
        }

        public String getJeopardy() {
            return jeopardy;
        }

        public void setJeopardy(String jeopardy) {
            this.jeopardy = jeopardy;
        }
    }
}
