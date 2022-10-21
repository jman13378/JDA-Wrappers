import SlashCommandEvent;

public abstract class SlashCommand {
	/**
     * the string name
     */
    private final String name;
    /**
     * the class name
     *
     * @param name name
     */
    public SlashCommand(String name) {
        this.name = name;
    }
    /**
     * get the name of the command
     */
    public String getName() {
        return this.name;
    }
    /**
     * what the command executes
     */
    public abstract void execute(SlashCommandEvent event);
}
