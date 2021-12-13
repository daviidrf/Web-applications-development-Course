package proven.friends.views;

/** 
 * Option.java
 * Class Option
 * Encapsulates one option for a generic menu
 * @author Jose Moreno
 */
public class Option {

    /**
     * text of option
     */
    private String text;
    /**
     * action command of option
     */
    private String actionCommand;


    /**
     * option constructor
     * @param text of option
     * @param actionCommand action command of option
     */
    public Option(String text, String actionCommand) {
        this.text = text;
        this.actionCommand = actionCommand;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the actionCommand
     */
    public String getActionCommand() {
        return actionCommand;
    }

    /**
     * @param actionCommand the actionCommand to set
     */
    public void setActionCommand(String actionCommand) {
        this.actionCommand = actionCommand;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((actionCommand == null) ? 0 : actionCommand.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Option))
            return false;
        Option other = (Option) obj;
        if (actionCommand == null) {
            if (other.actionCommand != null)
                return false;
        } else if (!actionCommand.equals(other.actionCommand))
            return false;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Option [text=");
        builder.append(text);
        builder.append(", actionCommand=");
        builder.append(actionCommand);
        builder.append("]");
        return builder.toString();
    }

}