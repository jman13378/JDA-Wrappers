

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import SlashCommand;
import SlashCommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static final HashMap<String, SlashCommand> commands = new HashMap();
    public MainListener() {
    	ArrayList<SlashCommand> botCommands = new ArrayList<>(Arrays.asList(
    			new Chop()));
    	for (SlashCommand command : botCommands) {
    		commands.put(command.getName().toLowerCase(), command);
    	}
    }
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    	SlashCommand command = commands.get(event.getName());
    	command.execute(new SlashCommandEvent(event));
    }
}
